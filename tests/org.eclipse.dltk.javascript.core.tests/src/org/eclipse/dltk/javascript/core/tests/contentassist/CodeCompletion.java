package org.eclipse.dltk.javascript.core.tests.contentassist;

import static org.eclipse.dltk.core.tests.TestSupport.notYetImplemented;
import static org.eclipse.dltk.javascript.typeinfo.ITypeNames.NUMBER;
import static org.eclipse.dltk.javascript.typeinfo.MemberPredicates.STATIC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.dltk.codeassist.ICompletionEngine;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.tests.util.StringList;
import org.eclipse.dltk.javascript.ast.Keywords;
import org.eclipse.dltk.javascript.core.JavaScriptKeywords;
import org.eclipse.dltk.javascript.internal.core.codeassist.JSCompletionEngine;
import org.eclipse.dltk.javascript.typeinfo.ITypeNames;

@SuppressWarnings("restriction")
public class CodeCompletion extends AbstractCompletionTest {

	private static final String ARGUMENTS = "arguments";

	/**
	 * dumb completion on keyword
	 */
	public void test0() {
		LinkedList<CompletionProposal> results = new LinkedList<CompletionProposal>();
		ICompletionEngine c = createEngine(results,
				JSCompletionEngine.OPTION_NONE);
		c.complete(new TestModule(""), 0, 0);
		assertEquals(0, results.size());
	}

	/**
	 * dumb completion on function
	 */
	public void test1() {
		LinkedList<CompletionProposal> results = new LinkedList<CompletionProposal>();
		ICompletionEngine c = createEngine(results,
				JSCompletionEngine.OPTION_NONE);
		c.complete(createModule("test1.js"), 0, 0);
		assertEquals(0, results.size());
	}

	/**
	 * dumb completion on function
	 */
	public void test2() {
		String[] names = new String[] { "firstVar", "secondVar" };
		IModuleSource module = createModule("test2.js");
		int position = lastPositionInFile("\n", module);
		basicTest(module, position, names);
		// basicTest("test2.js", 36, names);
	}

	/**
	 * dumb completion on function
	 */
	public void test3() {
		String[] names = concat(getMembersOfObject(), "world");
		IModuleSource module = createModule("test3.js");
		int position = lastPositionInFile("firstVar.", module);
		basicTest(module, position, names);
		// basicTest(module, 63, names);
	}

	// 104 ,temperature
	/**
	 * dumb completion on function
	 */
	public void test4() {
		String[] names = concat(getMembersOfString(), "temperature");
		IModuleSource module = createModule("test4.js");
		int position = lastPositionInFile("firstVar.world.", module);
		basicTest(module, position, names);
		// basicTest("test4.js", 100, names);
	}

	public void test5() {
		String[] names = concat(getMembersOfString(), "world");
		String[] names1 = concat(getMembersOfString(), "temperature");
		IModuleSource module = createModule("test5.js");
		int positionFirst = lastPositionInFile("secondVar.", module);
		basicTest(module, positionFirst, names);
		int positionSecond = lastPositionInFile("world.", module);
		basicTest(module, positionSecond, names1);
		// basicTest(module, 120, names);
		// basicTest(module, 126, names1);
	}

	public void test6() {
		String[] names = concat(getMembersOfString(), "world");
		// String[] names1=new String[]{"temperature"};
		IModuleSource module = createModule("test6.js");
		int position = lastPositionInFile("world.", module);
		basicTest(module, position, names);
		// basicTest(module, 158, names);
		// basicTest(module, 126, names1);
	}

	public void test7() {
		String[] names = concat(getMembersOfString(), "world");
		// String[] names1=new String[]{"temperature"};
		IModuleSource module = createModule("test7.js");
		int position = lastPositionInFile("world.", module);
		basicTest(module, position, names);
		// basicTest(module, 157, names);
		// basicTest(module, 126, names1);
	}

	public void test8() {
		String[] names = concat(getMembersOfString(), "mission", "target");
		// String[] names1=new String[]{"temperature"};
		IModuleSource module = createModule("test8.js");
		int position = lastPositionInFile("firstVar.", module);
		basicTest(module, position, names);
		// basicTest(module, 124, names);
		// basicTest(module, 126, names1);
	}

	public void test9() {
		String[] names = concat(getMembersOfString());
		// String[] names1=new String[]{"temperature"};
		IModuleSource module = createModule("test9.js");
		int position = lastPositionInFile("firstVar.", module);
		basicTest(module, position, names);
		// basicTest(module, 138, names);
		// basicTest(module, 126, names1);
	}

	public void test10() {
		String[] names = concat(getMembersOfString(), "mission", "target");
		// String[] names1=new String[]{"temperature"};
		IModuleSource module = createModule("test10.js");
		// basicTest(module, 139, names);
		int position = lastPositionInFile("secondVar.", module);
		basicTest(module, position, names);
	}

	public void test11() {
		String[] names = new String[] { ARGUMENTS, "firstVar", "secondVar",
				"main" };
		IModuleSource module = createModule("test11.js");
		int position = lastPositionInFile("{", module);
		basicTest(module, position, names);
		// basicTest(module, 56, names);
	}

	public void test12() {
		String[] names = new String[] { "p0", "p1" };
		IModuleSource module = createModule("test12.js");
		// basicTest(module, 62, names);
		int position = lastPositionInFile("p", module);
		basicTest(module, position, names);
	}

	public void test13() {
		String[] names = concat(getMembersOfString(), "element");
		IModuleSource module = createModule("test13.js");
		int position = lastPositionInFile("firstVar.", module);
		basicTest(module, position, names);
	}

	public void test14() {
		String[] names = concat(getMembersOfString(), "element");
		IModuleSource module = createModule("test14.js");
		int position = lastPositionInFile("firstVar.", module);
		basicTest(module, position, names);
		// basicTest(module, 88, names);
	}

	public void test15() {
		String[] names = concat(getMembersOfNumber());
		IModuleSource module = createModule("test15.js");
		int position = lastPositionInFile("firstVar.", module);
		basicTest(module, position, names);
		// basicTest(module, 104, names);
	}

	public void test16() {
		String[] names = new String[] { "xaml" };
		IModuleSource module = createModule("test16.js");
		int position = lastPositionInFile("x", module);
		basicTest(module, position, names);
		// basicTest(module, 86, names);
	}

	public void test17() {
		String[] names = new String[] {};
		IModuleSource module = createModule("test17.js");
		int position = lastPositionInFile("x", module);
		basicTest(module, position, names);
		// basicTest(module, 87, names);
	}

	public void test18() {
		String[] names = new String[] { "my" };
		IModuleSource module = createModule("test18.js");
		int position = lastPositionInFile("hello.", module);
		basicTest(module, position, names);
		// basicTest(module, 120, names);
	}

	public void test19() {
		String[] names = concat(getMembersOfNumber());
		IModuleSource module = createModule("test19.js");
		int position = lastPositionInFile("hello.", module);
		basicTest(module, position, names);
		// basicTest(module, 119, names);
	}

	public void test20() {
		String[] names = concat(getMembersOfNumber(), "my");
		IModuleSource module = createModule("test20.js");
		int position = lastPositionInFile("hello.", module);
		basicTest(module, position, names);
		// basicTest(module, 123, names);
	}

	public void test21() {
		String[] names = concat(getMembersOfNumber(), "favorite");
		IModuleSource module = createModule("test21.js");
		int position = lastPositionInFile("hello.my.", module);
		basicTest(module, position, names);
		// basicTest(module, 151, names);
	}

	public void test22() {
		if (notYetImplemented(this))
			return;
		String[] names = concat(getMembersOfNumber());
		IModuleSource module = createModule("test22.js");
		int position = lastPositionInFile("hello.", module);
		basicTest(module, position, names);
		// basicTest(module, 147, names);
	}

	public void test23() {
		String[] names = new String[] { "my", "olive" };
		IModuleSource module = createModule("test23.js");
		int position = lastPositionInFile("hello.", module);
		basicTest(module, position, names);
		// basicTest(module, 160, names);
	}

	public void test24() {
		String[] names = concat(getMembersOfNumber(), "age", "wine");
		IModuleSource module = createModule("test24.js");
		int position = lastPositionInFile("hello.olive.", module);
		basicTest(module, position, names);
		// basicTest(module, 215, names);
	}

	public void test25() {
		String[] names = concat(getMembersOfNumber(), "age", "my", "olive",
				"wine");

		IModuleSource module = createModule("test25.js");
		int position = lastPositionInFile("hello.olive.", module);
		basicTest(module, position, names);
		// basicTest(module, 219, names);
	}

	public void test26() {
		if (notYetImplemented(this))
			return;
		String[] names = concat(getMembersOfNumber(), "wine");

		IModuleSource module = createModule("test26.js");
		int position = lastPositionInFile("hello.olive.", module);
		basicTest(module, position, names);
		// basicTest(module, 256, names);
	}

	public void test27() {
		String[] names = new String[] { "olive" };
		IModuleSource module = createModule("test27.js");
		int position = lastPositionInFile("hello.o", module);
		basicTest(module, position, names);
		// basicTest(module, 131, names);
	}

	public void test28() {
		String[] names = concat(getMembersOfNumber());
		IModuleSource module = createModule("test28.js");
		int position = lastPositionInFile("hello.", module);
		basicTest(module, position, names);
		// basicTest(module, 118, names);
	}

	public void test29() {
		String[] names = new String[] { ARGUMENTS, "x", "main" };
		IModuleSource module = createModule("test29.js");
		int position = lastPositionInFile("{", module);
		basicTest(module, position, names);
		// basicTest(module, 46, names);
	}

	public void test30() {
		String[] names = concat(getMembersOfNumber(), "xsd");
		IModuleSource module = createModule("test30.js");
		int position = lastPositionInFile("sz.", module);
		basicTest(module, position, names);
		// basicTest(module, 79, names);
	}

	public void test31() {
		String[] names = concat(getMembersOfString(), "x");
		IModuleSource module = createModule("test31.js");
		int position = lastPositionInFile("node.", module);
		basicTest(module, position, names);
		// basicTest(module, 107, names);
	}

	public void test32() {
		String[] names = concat(getMembersOfString(), "x");
		IModuleSource module = createModule("test32.js");
		int position = lastPositionInFile("node.", module);
		basicTest(module, position, names);
		// basicTest(module, 110, names);
	}

	public void test33() {
		String[] names = new String[] { ARGUMENTS, "object", "objectVariable",
				"main" };
		IModuleSource module = createModule("test33.js");
		int position = lastPositionInFile("{", module);
		basicTest(module, position, names);
		// basicTest(module, 65, names);
	}

	public void test34() {
		String[] names = new String[] { "x2" };
		IModuleSource module = createModule("test34.js");
		int position = lastPositionInFile("object.", module);
		basicTest(module, position, names);
		// basicTest(module, 93, names);
	}

	public void test35() {
		String[] names = concat(getMembersOfNumber(), "x");
		IModuleSource module = createModule("test35.js");
		int position = lastPositionInFile("c.", module);
		basicTest(module, position, names);
		// basicTest(module, 82, names);
	}

	public void test36() {
		String[] names = new String[] { ARGUMENTS, "c", "object", "e", "main" };
		IModuleSource module = createModule("test36.js");
		int position = lastPositionInFile("{", module);
		basicTest(module, position, names);
		// basicTest(module, 76, names);
	}

	public void test37() {
		String[] names = new String[] { ARGUMENTS, "forward", "hello",
				"object", "main" };
		IModuleSource module = createModule("test37.js");
		int position = lastPositionInFile("{", module);
		basicTest(module, position, names);
		// basicTest(module, 85, names);
	}

	public void test38() {
		String[] names = new String[] { "object" };
		IModuleSource module = createModule("test38.js");
		int position = lastPositionInFile("o", module);
		basicTest(module, position, names);
		// basicTest(module, 102, names);
	}

	public void test39() {
		String[] names = concat(getMembersOfNumber(), "er");
		IModuleSource module = createModule("test39.js");
		int position = lastPositionInFile("eer.", module);
		basicTest(module, position, names);
		// basicTest(module, 125, names);
	}

	public void test40() {
		String[] names = new String[] { "s" };
		IModuleSource module = createModule("test40.js");
		int position = lastPositionInFile("v.", module);
		basicTest(module, position, names);
		// basicTest(module, 65, names);
	}

	public void test41() {
		String[] names = new String[] { "hello" };
		IModuleSource module = createModule("test41.js");
		int position = lastPositionInFile("er[0].", module);
		basicTest(module, position, names);
		// basicTest(module, 96, names);
	}

	public void test42() {
		String[] names = new String[] { "Hello", "Mama" };
		IModuleSource module = createModule("test42.js");
		int position = lastPositionInFile("object.", module);
		basicTest(module, position, names);
		// basicTest(module, 76, names);
	}

	public void test43() {
		String[] names = new String[] { ARGUMENTS, "main" };
		IModuleSource module = createModule("test43.js");
		int position = lastPositionInFile(";", module);
		basicTest(module, position, names);
		// basicTest(module, 45, names);
	}

	public void test44() {
		String[] names = new String[] { "main" };
		IModuleSource module = createModule("test44.js");
		int position = lastPositionInFile("object.", module);
		basicTest(module, position, names);
		// basicTest(module, 95, names);
	}

	public void test45() {
		String[] names = new String[] { "word", "other_word" };
		IModuleSource module = createModule("test45.js");
		int position = lastPositionInFile("x.hello.", module);
		basicTest(module, position, concat(getMembersOfObject(), names));
		// basicTest(module, 139, names);
	}

	public void test46() {
		if (notYetImplemented(this))
			return;
		String[] names = new String[] { "aaa", "baa", "my", "prototype" };
		IModuleSource module = createModule("test46.js");
		int position = lastPositionInFile("x.", module);
		basicTest(module, position, names);
		// basicTest(module, 102, names);
	}

	public void test47() {
		String[] names = new String[] { "x", "y" };
		IModuleSource module = createModule("test47.js");
		int position = lastPositionInFile("this.", module);
		basicTest(module, position, names);
		// basicTest(module, 54, names);
	}

	public void test48() {
		String[] names = new String[] { "erer" };
		IModuleSource module = createModule("test48.js");
		int position = lastPositionInFile("this.", module);
		basicTest(module, position, names);
		// basicTest(module, 105, names);
	}

	public void test49() {
		IModuleSource module = createModule("test49.js");
		int position = lastPositionInFile("name.", module);
		basicTest(module, position, concat(getMembersOfString()));
		// basicTest(module, 105, names);
	}

	public void test50() {
		IModuleSource module = createModule("test50.js");
		int position = lastPositionInFile("Function.", module);
		basicTest(
				module,
				position,
				concat(getMembers(ITypeNames.FUNCTION, STATIC),
						getMembersOfFunction()));
		// basicTest(module, 105, names);
	}

	public void test51() {
		IModuleSource module = createModule("test51.js");
		int position = lastPositionInFile("test.", module);
		basicTest(module, position, concat(getMembersOfFunction()));
		// basicTest(module, 105, names);
	}

	public void test52() {
		IModuleSource module = createModule("test52.js");
		int position = lastPositionInFile("x.", module);
		basicTest(module, position, concat(getMembersOfFunction()));
		// basicTest(module, 105, names);
	}

	public void testObjectFunctionReturnValue() {
		String[] names = new String[] { "a", "b" };
		IModuleSource module = createModule("test-return-value.js");
		int position = lastPositionInFile("execute().", module);
		basicTest(module, position, concat(getMembersOfObject(), names));
	}

	public void testFunctionRefs() {
		String[] names = new String[] { "test1", "test2", "test3" };
		IModuleSource module = createModule("test-function-refs.js");
		int position = lastPositionInFile("a = test", module);
		basicTest(module, position, names);
	}

	public void testFunctionRefsAndKinds() {
		String[] names = new String[] { "test1()", "test2()", "test3()" };
		IModuleSource module = createModule("test-function-refs.js");
		int position = lastPositionInFile("a = test", module);
		testWithKinds(module, position, names);
	}

	public void testArrayInitializer() {
		IModuleSource module = createModule("test-array-intializer.js");
		int position = lastPositionInFile("].", module);
		basicTest(module, position, concat(getMembersOfArray()));
	}

	public void testParamType() {
		IModuleSource module = createModule("test-function-paramtype.js");
		int position = lastPositionInFile(".", module);
		basicTest(module, position, new String[] { "service", "status" });
	}

	public void testElementReferenceType() {
		IModuleSource module = createModule("test-element-reference.js");
		int position = lastPositionInFile(".", module);
		basicTest(module, position,
				new String[] { "deprecatedName", "service" });
	}

	public void testNewViaClassRef() {
		IModuleSource module = createModule("test-new-via-class-ref.js");
		int position = lastPositionInFile(".", module);
		basicTest(module, position, concat(getMembersOfNumber()));
	}

	public void testXmlVar() {
		IModuleSource module = createModule("test-xml-name.js");
		int position = lastPositionInFile(".", module);
		basicTest(module, position, concat(getMembersOfNumber()));
	}

	public void testObjectLiteral() {
		IModuleSource module = createModule("test-object-literal.js");
		int position = lastPositionInFile(":p", module);
		basicTest(module, position, new String[] { "person" });
	}

	public void testCamelCase() {
		IModuleSource module = createModule("test-camel-case.js");
		int position = lastPositionInFile("DS", module);
		basicTest(module, position, new String[] { "DataSource" });
	}

	public void testStaticInference() {
		IModuleSource module = createModule("test-static.js");
		int position = lastPositionInFile("num1.", module);
		basicTest(module, position,
				concat(getMembers(NUMBER, STATIC), getMembersOfFunction()));
	}

	public void testStaticMath() {
		IModuleSource module = new TestModule("Math.");
		int position = lastPositionInFile(".", module);
		basicTest(module, position,
				concat(getMembers("Math", STATIC), getMembersOfObject()));
	}

	public void testArrayOfRecords() {
		final StringList code = new StringList();
		code.add("/** @type {Array<{x:Number,y:Number}>} */");
		code.add("var points");
		code.add("points[0].");
		final IModuleSource module = new TestModule(code.toString());
		String[] names = new String[] { "x", "y" };
		int position = lastPositionInFile(".", module);
		basicTest(module, position, concat(getMembersOfObject(), names));
	}

	public void testPropertyInitializerValue_FilteredKeywords1() {
		final StringList code = new StringList();
		code.add("var figure = {");
		code.add("	draw: ");
		code.add("}");
		final IModuleSource module = new TestModule(code.toString());
		final List<CompletionProposal> results = new ArrayList<CompletionProposal>();
		final ICompletionEngine completionEngine = createEngine(results,
				JSCompletionEngine.OPTION_KEYWORDS);
		completionEngine.complete(module, lastPositionInFile(": ", module), 0);
		final String[] expectedProposals = concat(
				Collections.singletonList("figure"),
				JavaScriptKeywords.getJavaScriptValueKeywords());
		if (!compareProposalNames(results, expectedProposals)) {
			assertEquals(new StringList(expectedProposals).sort().toString(),
					exractProposalNames(results, false).sort().toString());
		}
	}

	public void testPropertyInitializerValue_FilteredKeywords2() {
		final StringList code = new StringList();
		code.add("var figure = {");
		code.add("	draw: fu");
		code.add("}");
		final IModuleSource module = new TestModule(code.toString());
		final List<CompletionProposal> results = new ArrayList<CompletionProposal>();
		final ICompletionEngine completionEngine = createEngine(results,
				JSCompletionEngine.OPTION_KEYWORDS);
		completionEngine.complete(module, lastPositionInFile("fu", module), 0);
		final String[] expectedProposals = { Keywords.FUNCTION };
		if (!compareProposalNames(results, expectedProposals)) {
			assertEquals(new StringList(expectedProposals).sort().toString(),
					exractProposalNames(results, false).sort().toString());
		}
	}

	public void testArrayOfLazyTypeInitializedEmpty() {
		final StringList code = new StringList();
		code.add("function MyObject() {");
		code.add("	this.test = 10;");
		code.add("}");
		code.add("/**");
		code.add(" * @type {Array<MyObject>}");
		code.add(" */");
		code.add("var x = [];");
		code.add("x[0].");
		final IModuleSource module = new TestModule(code.toString());
		String[] names = new String[] { "test" };
		int position = lastPositionInFile(".", module);
		basicTest(module, position, concat(getMembersOfObject(), names));
	}

	public void testRecordTypeFunction() {
		final StringList code = new StringList();

		code.add("function test() {");
		code.add("	return {");
		code.add("   testProp: 10,");
		code.add("testFunc: function(x){}");
		code.add(" }");
		code.add("}");

		code.add("function testtest() {");
		code.add("	test().testFunc");
		code.add(" }");
		final IModuleSource module = new TestModule(code.toString());
		int position = lastPositionInFile(".testFunc", module);
		List<CompletionProposal> results = new ArrayList<CompletionProposal>();
		ICompletionEngine c = createEngine(results,
				JSCompletionEngine.OPTION_NONE);
		c.complete(module, position, 0);
		assertEquals(1, results.size());
		assertEquals(CompletionProposal.METHOD_REF, results.get(0).getKind());
	}

	public void testRecordTypeFunctionWithConstructor() {
		final StringList code = new StringList();

		code.add("function testConstructor() {");
		code.add("	this.testMethod = function() {");
		code.add("	return {");
		code.add("   testProp: 10,");
		code.add("   testFunc: function(x){}");
		code.add("  }");
		code.add(" }");
		code.add("}");

		code.add("function testtest() {");
		code.add("	var x = new testConstructor();");
		code.add("  x.testMethod().testFunc");
		code.add(" }");
		final IModuleSource module = new TestModule(code.toString());
		int position = lastPositionInFile(".testFunc", module);
		List<CompletionProposal> results = new ArrayList<CompletionProposal>();
		ICompletionEngine c = createEngine(results,
				JSCompletionEngine.OPTION_NONE);
		c.complete(module, position, 0);
		assertEquals(1, results.size());
		assertEquals(CompletionProposal.METHOD_REF, results.get(0).getKind());
	}

	public void testCodeCompletionWithValidWhiteSpace() {
		final StringList code = new StringList();

		code.add("function Test() {");
		code.add("	/**@return {Test}*/");
		code.add("	this.f1 = function(){return this;}");
		code.add("  /**@return {Test}*/");
		code.add("  this.f2 = function(){return this;}");
		code.add("}");

		code.add("function testCC() {");
		code.add("	var x = new Test();");
		code.add("  x.f1().f2().");
		code.add("  f1()");
		code.add("  .f1().  f1()");
		code.add("  .f1().");
		code.add("   ");
		code.add(" }");
		final IModuleSource module = new TestModule(code.toString());
		int position = lastPositionInFile("   ", module);
		List<CompletionProposal> results = new ArrayList<CompletionProposal>();
		ICompletionEngine c = createEngine(results,
				JSCompletionEngine.OPTION_NONE);
		c.complete(module, position, 0);
		assertEquals(2 + getMembersOfObject().size(), results.size());
	}
	
	public void testArrayInArrayLookup() {
		final StringList code = new StringList();
		code.add("function test() {");
		code.add("	arrayTest.execute()[1].execute()[1].");
		code.add("}");
		final IModuleSource module = new TestModule(code.toString());
		String[] names = new String[] { "execute" };
		int position = lastPositionInFile(".", module);
		basicTest(module, position, names);
	}
	
	public void testVariableTypedAsTypedArrayThroughDoc() {
		final StringList code = new StringList();
		code.add("function test() {");
		code.add("	/** @type {Array<String>} */");
		code.add("	this.scopeOneItems = new Array();");
		code.add("	this.scopeOneItems[1].");
		code.add("}");
		final IModuleSource module = new TestModule(code.toString());
		String[] names = getMembersOfString().toArray(new String[0]);
		int position = lastPositionInFile(".", module);
		basicTest(module, position, names);
	}
}
