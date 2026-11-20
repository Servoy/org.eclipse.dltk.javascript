package org.eclipse.dltk.javascript.core.tests.typeinference;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.dltk.compiler.env.ModuleSource;
import org.eclipse.dltk.compiler.problem.ProblemCollector;
import org.eclipse.dltk.internal.javascript.ti.IReferenceAttributes;
import org.eclipse.dltk.internal.javascript.ti.ITypeInferenceContext;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencer2;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencerVisitor;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.VariableBinding;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.ITypeNames;

/**
 * Tests the type inference of for-loop head <code>let</code> declarations with
 * the rhino (ES6) parser. Needs assertions enabled (<code>-ea</code>), because
 * the failure mode is an {@link AssertionError} in
 * <code>TypeInferencerVisitor.initializeVariables</code> (SVY-21727).
 */
@SuppressWarnings({ "nls", "restriction" })
public class LetLoopTypeInferenceTests extends TestCase {

	/** Records the references created for declared variables, by name. */
	private static class CapturingVisitor extends TypeInferencerVisitor {
		final Map<String, IValueReference> variables = new HashMap<String, IValueReference>();

		CapturingVisitor(ITypeInferenceContext context) {
			super(context);
		}

		@Override
		protected IValueReference createVariable(IValueCollection context,
				VariableBinding declaration, Identifier identifier) {
			final IValueReference ref = super.createVariable(context,
					declaration, identifier);
			variables.put(identifier.getName(), ref);
			return ref;
		}
	}

	private CapturingVisitor visitor;

	private static Script parse(String code) {
		final org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser parser = new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
		final ProblemCollector reporter = new ProblemCollector();
		final Script script = parser.parse(new ModuleSource(code), reporter);
		if (reporter.hasErrors()) {
			fail(reporter.getErrors().toString());
		}
		assertNotNull(script);
		return script;
	}

	/** Infers the code; any AssertionError/RuntimeException is rethrown. */
	private IValueCollection inference(String code) {
		final TypeInferencer2 inferencer = new TestTypeInferencer2();
		visitor = new CapturingVisitor(inferencer);
		inferencer.setVisitor(visitor);
		inferencer.doInferencing(parse(code));
		return inferencer.getCollection();
	}

	private static boolean hasType(IValueReference ref, String typeName) {
		for (IRType type : ref.getTypes()) {
			if (typeName.equals(type.getName())) {
				return true;
			}
		}
		return false;
	}

	public void testAssertionsEnabled() {
		assertTrue(
				"run with -ea, otherwise the AssertionError tests are meaningless",
				TypeInferencerVisitor.class.desiredAssertionStatus());
	}

	public void testForLet_scriptLevel() {
		final String code = "for (let i = 0; i < 3; i++) { var s = i; }";
		final IValueCollection collection = inference(code);
		final IValueReference s = collection.getChild("s");
		assertTrue("s should be a Number: " + s.getTypes(),
				hasType(s, ITypeNames.NUMBER));
		assertFalse("let must not leak to the script scope",
				collection.getChild("i").exists());

		final IValueReference i = visitor.variables.get("i");
		assertNotNull("loop variable i must be created", i);
		assertNotNull("i must have the VARIABLE attribute",
				i.getAttribute(IReferenceAttributes.VARIABLE));
		final ReferenceLocation location = i.getLocation();
		assertNotNull(location);
		assertEquals(code.indexOf("i = 0"), location.getNameStart());
		assertEquals(code.indexOf("i = 0") + 1, location.getNameEnd());
	}

	public void testForLet_multipleBindings() {
		inference("for (let i = 0, j = 10; i < j; i++) { }");
		assertNotNull(visitor.variables.get("i"));
		assertNotNull(visitor.variables.get("j"));
		assertNotNull(visitor.variables.get("j")
				.getAttribute(IReferenceAttributes.VARIABLE));
	}

	public void testForLet_inFunction() {
		inference("function f(){ for (let i = 0; i < 3; i++) {} }");
		final IValueReference i = visitor.variables.get("i");
		assertNotNull("loop variable i must be created", i);
		assertNotNull(i.getAttribute(IReferenceAttributes.VARIABLE));
	}

	public void testForInLet() {
		inference("for (let k in obj) { }");
		final IValueReference k = visitor.variables.get("k");
		assertNotNull("loop variable k must be created", k);
		assertNotNull(k.getAttribute(IReferenceAttributes.VARIABLE));
		assertTrue("k should be a String: " + k.getTypes(),
				hasType(k, ITypeNames.STRING));
	}

	public void testForEachInLet() {
		inference("for each (let x in [1,2]) { }");
		final IValueReference x = visitor.variables.get("x");
		assertNotNull("loop variable x must be created", x);
		assertNotNull(x.getAttribute(IReferenceAttributes.VARIABLE));
	}

	public void testForOfLet_regression() {
		inference("for (let x of [1,2]) { }");
		assertNotNull(visitor.variables.get("x"));
	}

	public void testPlainLetConstBlock_regression() {
		inference("let a = 1; const c = 2; { let b = 1; }");
		assertNotNull(visitor.variables.get("a"));
		assertNotNull(visitor.variables.get("c"));
		assertNotNull(visitor.variables.get("b"));
	}
}
