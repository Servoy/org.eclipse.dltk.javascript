package org.eclipse.dltk.javascript.parser.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.Statement;
import org.eclipse.dltk.javascript.ast.StatementBlock;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.VoidExpression;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.ast.v4.TagFunctionExpression;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringLiteral;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.junit.Test;

/**
 * @since 6.0
 */
public class TestANTLR4Parser {
	
	private Script getScript(String source) {
		final org.eclipse.dltk.javascript.parser.JavaScriptParser jsParser =  new org.eclipse.dltk.javascript.parser.JavaScriptParser();
		Script script = jsParser.parse(source, new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				System.err.println(problem);
			}
		});
		System.err.println(script);
		return script;
	}
	
	private Script getScriptv4(String source) {
		final org.eclipse.dltk.javascript.parser.v4.JavaScriptParser jsParserv4 =  new org.eclipse.dltk.javascript.parser.v4.JavaScriptParser();
		Script scriptv4 = jsParserv4.parse(source, new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				System.err.println(problem);
			}
		});
		System.err.println(scriptv4);
		return scriptv4;
	}
	
	private boolean equalsJSNode(JSNode node1, JSNode node2) {
		if (node1.toString().equals(node2.toString())) {
			return node1.sourceStart() == node2.sourceStart() &&
					node1.sourceEnd() == node2.sourceEnd() &&
					node1.toString().equals(node2.toString());
		}
		return false;
	}
	
	@Test
	public void testSimpleVariableDeclaration() {
		String source = "var a;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertEquals(script.toString(), scriptv4.toString());
		VoidExpression expression = (VoidExpression) script.getStatements().get(0);
		VoidExpression expressionv4 = (VoidExpression) scriptv4.getStatements().get(0);
		assertEquals(expression.sourceStart(), expressionv4.sourceStart());
		assertEquals(expression.sourceEnd(), expressionv4.sourceEnd());
		VariableStatement statement = (VariableStatement) expression.getExpression();
		VariableStatement statementv4 = (VariableStatement) expressionv4.getExpression();
		VariableDeclaration variableDeclaration = statement.getVariables().get(0);
		VariableDeclaration variableDeclarationv4 = statementv4.getVariables().get(0);
		assertEquals(variableDeclaration.sourceStart(), variableDeclarationv4.sourceStart());
		assertEquals(variableDeclaration.sourceEnd(), variableDeclarationv4.sourceEnd());
		assertTrue(equalsJSNode(variableDeclaration, variableDeclarationv4));
		assertTrue(equalsJSNode(statement, statementv4));
		assertTrue(equalsJSNode(expression, expressionv4));
		
		assertEquals(script.sourceEnd(), scriptv4.sourceEnd());
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testVariableDeclaration() {
		String source = "var from, a = 10;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertEquals(script.toString(), scriptv4.toString());
		VoidExpression expression = (VoidExpression) script.getStatements().get(0);
		VoidExpression expressionv4 = (VoidExpression) scriptv4.getStatements().get(0);
		assertEquals(expression.sourceStart(), expressionv4.sourceStart());
		assertEquals(expression.sourceEnd(), expressionv4.sourceEnd());
		VariableStatement statement = (VariableStatement) expression.getExpression();
		VariableStatement statementv4 = (VariableStatement) expressionv4.getExpression();
		assertEquals(statement.getVariables().get(0).sourceStart(), statementv4.getVariables().get(0).sourceStart());
		assertEquals(statement.getVariables().get(0).sourceEnd(), statementv4.getVariables().get(0).sourceEnd());
		assertTrue(equalsJSNode(statement.getVariables().get(0), statementv4.getVariables().get(0)));
		assertTrue(equalsJSNode(statement.getVariables().get(1), statementv4.getVariables().get(1)));
		assertTrue(equalsJSNode(statement, statementv4));
		assertTrue(equalsJSNode(expression, expressionv4));
		
		assertEquals(script.sourceEnd(), scriptv4.sourceEnd());
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testStatementBlock() {
		String source = "{a += 1; b=2;}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testPlusAssignment() {
		String source = "a += 1;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testIf() {
		String source = "if (a < b) { b = a; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testIfElse() {
		String source = "if (a < b) { b = a; } else {a = b;}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testIfElse2() {
		String source = "if (a < b)  b = a;  else a = b;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testWhile() {
		String source = "while (a < b) {a+=1;}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testDo() {
		String source = "do {a+=1} while (a<b);";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testFor() {
		String source = "for(var i=0; true; 1){ a += 1;}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testForIn() {
		String source = "for (var e in obj) { a += 1; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testFunctionDeclaration() {
		String source = "function abc(a,b){ a+=1;} "
				+ "function getHash (value, algorithm) {"
				+ "    var bytes=value instanceof String ? string2Bytes(value) : value;\r\n"
				+ "    var digest=Packages.java.security.MessageDigest.getInstance(algorithm);\r\n"
				+ "    return utils.bytesToBase64(digest.digest(bytes));\r\n"
				+ "}"
				+ "function onOpen(event) {\r\n"
				+ "\r\n"
				+ "	/** @type {scopes.svyNavigation.NavigationItem} */\r\n"
				+ "	var item = event.getNavigationItem();\r\n"
				+ "	var formName = item.getFormName();\r\n"
				+ "\r\n"
				+ "	// get the form instance\r\n"
				+ "	var form = forms[formName];\r\n"
				+ "	if (!form) {\r\n"
				+ "		throw new scopes.svyExceptions.IllegalStateException('Cannot navigate to form because cannot find form instance ' + formName);\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "	// show form\r\n"
				+ "	elements.formcontainer.containedForm = formName;\r\n"
				+ "\r\n"
				+ "	//  update the selected menu item for the main menu\r\n"
				+ "	/** @type {String} */\r\n"
				+ "	var menuId = getMenuItemID(item.getFormName());\r\n"
				+ "	if (menuId) {\r\n"
				+ "		elements.navbar.setMenuSelected(menuId);\r\n"
				+ "	} else {\r\n"
				+ "		elements.navbar.setMenuSelected(null);\r\n"
				+ "	}\r\n"
				+ "}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertEquals(script.toString(), scriptv4.toString());
		assertEquals(script.getStatements().get(0).sourceStart(), scriptv4.getStatements().get(0).sourceStart());
		assertEquals(script.getStatements().get(0).sourceEnd(), scriptv4.getStatements().get(0).sourceEnd());
		
		FunctionStatement func = (FunctionStatement)script.getStatements().get(0).getChilds().get(0);
		FunctionStatement func_v4 = (FunctionStatement)scriptv4.getStatements().get(0).getChilds().get(0);
		assertEquals(func.getFunctionName(), func_v4.getFunctionName());
		assertEquals(2, func_v4.getArguments().size());
		assertEquals("a", func_v4.getArguments().get(0).getArgumentName());
		assertEquals("b", func_v4.getArguments().get(1).getArgumentName());
		assertTrue(equalsJSNode(func, func_v4));
		assertTrue(equalsJSNode(script, scriptv4));
	}	
	
	@Test
	public void testScript() {
		String source = "var a,b = 10;\n"
			+"var y=11+ b-a/2 * 7 % 3;\n" +
			"a=5; b+=1; a-=y;\n" +
			"if (a < b) b = a;\n" +
			"if (a < b) { b = a; } else {a = b;}\n" + 
			"while (a < b) {a+=1;}\n" +
			"do {a+=1} while (a<b);\n" +
			"for (var e in obj) { a += 1; }\n" +
			"for(var i=0; true; 1){ a += 1;}\n";		
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testContinue() {
		String source = "for (var e in obj) { continue; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testContinueLabel() {
		String source = "outer : for (var i in o) for (var e in obj) { continue outer; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testReturn() {
		String source = "function sum(a,b){ return a + b;}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testBreak() {
		String source = "for (var e in obj) { break; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testBreakLabel() {
		String source = "outer : for (var i in o) for (var e in obj) { break outer; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testCall() {
		String source = "myfunc(10);";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testNew() {
		String source = "new A('test', 10);";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testThrow() {
		String source = "if (a < b) throw new Error('some exception'); else throw 'error!';";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testTry() {
		String source = "{ try { init(a); } catch (e) { throw 'error!'; } finally { a = 0;} }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testYield() {
		String source = "{ yield abc; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testSwitch() {
		String source = "switch (color) { case 'blue' : print(msg1); break; case 'red' : print(msg2); break; default: print(msg);}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testSwitchErrorReporting() {
		String source = "switch (color) { case 'blue' : print(msg1); break; case 'red' : print(msg2); break; default: print(msg); default: abc();}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		//TODO test which errors are reported
		//they can't be the same because the switch statement rule doesn't support more default cases
		//assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testEmptyStatement() {
		String source = ";";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testWithStatement() {
		String source = "with (obj) test(x);";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testPostIncrementExpression() {
		String source = "x = a++;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testIncrementExpression() {
		String source = "for(var i=0; i < 10; ++i){ a += 1;}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testUnaryMinusExpression() {
		String source = "c = -a;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testOtherUnaryOperations() {
		String source = "i--; x = ~a;" 
						+ "y = !a;"
						+ "b = --i;"
						+ "void a;"
						+ "typeof a;"
						+ "delete b;"
						+ "c = -1;"
						+ "d = +1;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testPropertyExpression() {
		String source = "myobj.myprop;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testArrayItemExpression() {
		String source = "arr[2];";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testArrayInitializer() {
		String source = "var arr = [1, 2, 3];";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testCommaExpression() {
		String source = "y = ( a+b, 1/2, x );";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testTernaryOperator() {
		String source = "y = x > 0 ? x : 0;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testConst() {
		String source = "const a = 5;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testObjectInitializer() {
		String source = "o = { a: 'foo',\n"
				+ " b: 42,\n"
				+ "get property() {},\n"
				+ "set property(value) {}};";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testEmptyExpression() {
		String source = "var arr = [1, , 3];";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}

	@Test
	public void testExpression() {
		String source = "var payload={\"sub\": \"1234567890\", name_: \"Edit M\", \"admin\": true, arrayValue: ['Monday', 'Tuesday'], arr: [1, 2, 3]};\r\n"
				+ ";";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	 
	@Test
	public void testFunctionExpression() {
			String source ="this.setNavigationPolicy = function(policy) { this.navigationPolicy = policy; return this; }";
			Script script = getScript(source);
			Script scriptv4 = getScriptv4(source);
			
			assertNotNull(script);
			assertNotNull(scriptv4);
			assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testInEpression() {
		String source ="if (!('svyNavigationHistory' in scopes)) {\r\n"
				+ "			scopes.svyNavigationHistory;\r\n"
				+ "		}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testErrorReporting() {
		String source = " try {"
		+ "		scopes.svyEventManager.fireEvent(this, APPLICATION_EVENT_TYPES.ERROR, arguments, true)"
		+ "	} catch (e if e instanceof scopes.svyEventManager.VetoEventException) {"
		+ "		return false"
		+ "	}";
		
		final org.eclipse.dltk.javascript.parser.v4.JavaScriptParser jsParserv4 =  new org.eclipse.dltk.javascript.parser.v4.JavaScriptParser();
		final List<IProblem> problems = new ArrayList<IProblem>();
		IProblemReporter reporter = new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				problems.add(problem);
			}
		};
		Script scriptv4 = jsParserv4.parse(source, reporter);
		assertNotNull(scriptv4);		
		assertTrue(problems.size() == 3);
	}
	
	@Test
	public void testArrowFunction1() {
		String source ="e => {e.toUpperCase();}";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		assertTrue(statement.getChilds().get(0) instanceof ArrowFunctionStatement);
		ArrowFunctionStatement fn = (ArrowFunctionStatement) statement.getChilds().get(0);
		assertEquals(1, fn.getArguments().size());
		assertEquals("e", fn.getArguments().get(0).toString());
		assertEquals(2, fn.getArrow());
		assertTrue(fn.getBody() instanceof StatementBlock);
		assertEquals(1, ((StatementBlock) fn.getBody()).getStatements().size());
		assertEquals("e.toUpperCase();",((StatementBlock) fn.getBody()).getStatements().get(0).toString().trim());
	}
	
	@Test
	public void testArrowFunction2() {
		String source ="(a, b) => a + b + 100;";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		assertTrue(statement.getChilds().get(0) instanceof ArrowFunctionStatement);
		ArrowFunctionStatement fn = (ArrowFunctionStatement) statement.getChilds().get(0);
		assertEquals(2, fn.getArguments().size());
		assertEquals("a", fn.getArguments().get(0).toString());
		assertEquals("b", fn.getArguments().get(1).toString());
		assertEquals(0, fn.getLP());
		assertEquals(5, fn.getRP());
		assertEquals(7, fn.getArrow());
		assertTrue(fn.getBody() instanceof VoidExpression);
		assertEquals("a + b + 100", fn.getBody().toString().trim());
	}
	
	@Test
	public void testTemplateString() {
		String source ="`test ${abc+c}`";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		assertTrue(statement instanceof VoidExpression);
		TemplateStringLiteral expr = (TemplateStringLiteral) ((VoidExpression) statement).getExpression();
		assertEquals(source, expr.toString().trim());
		assertEquals(1, expr.getTemplateExpressions().size());
		assertEquals("${abc + c}", expr.getTemplateExpressions().get(0).toString());
	}
	
	@Test
	public void testTagFunction() {
		String source ="myfunc`test ${abc} some other text ${c}`";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		assertTrue(statement instanceof VoidExpression);
		TagFunctionExpression expr = (TagFunctionExpression) ((VoidExpression) statement).getExpression();
		assertEquals(source, expr.toString().trim());
		assertEquals("myfunc",expr.getTagFunction().toString());
		TemplateStringLiteral literal = expr.getLiteral();
		assertEquals(2, literal.getTemplateExpressions().size());
		assertEquals("${abc}", literal.getTemplateExpressions().get(0).toString());
		assertEquals("${c}", literal.getTemplateExpressions().get(1).toString());
	}
}
