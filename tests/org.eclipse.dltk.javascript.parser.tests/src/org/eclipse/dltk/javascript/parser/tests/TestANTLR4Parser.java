package org.eclipse.dltk.javascript.parser.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.javascript.ast.*;
import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.UnaryOperation;
import org.eclipse.dltk.javascript.ast.v4.*;
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
	
	private boolean equalsJSNode(ASTNode node1, ASTNode node2) {
		if (node1.toString().equals(node2.toString()) &&
			node1.sourceStart() == node2.sourceStart() &&
			node1.sourceEnd() == node2.sourceEnd() &&
			node1.getChilds().size() == node2.getChilds().size()) {
			List<ASTNode> node1_children = node1.getChilds();
			List<ASTNode> node2_children = node2.getChilds();
			for (int i = 0; i < node1_children.size(); i++) {
				ASTNode child1 = node1_children.get(i);
				ASTNode child2 = node2_children.get(i);
				if (child1 instanceof VoidExpression && ((VoidExpression)node1_children.get(i)).getExpression() instanceof VariableStatement ||
						node1_children.get(i) instanceof VariableStatement && child2 instanceof VariableStatement) {
					//need to compare var statements separately because of bug in old antlr parser sourceEnd
					return compareVarStatements(child1, child2);
				}
				if (!equalsJSNode(child1, child2)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean compareVarStatements(ASTNode child1, ASTNode child2) {
		VariableStatement var1 = (VariableStatement)(child1 instanceof VoidExpression ? 
				((VoidExpression)child1).getExpression(): child1);
		VariableStatement var2 = (VariableStatement) (child2 instanceof VoidExpression ? 
				((VoidExpression)child2).getExpression(): child2);
		if (var1.sourceStart() == var2.sourceStart() && 
				var1.getVariables().size() == var2.getVariables().size()) {
			for(int j = 0; j < var1.getVariables().size(); j++) {
				if (!equalsJSNode(var1.getVariables().get(j), var2.getVariables().get(j))) {
					return false;
				}
			}
			return true;
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
		
		StatementBlock statement = (StatementBlock) script.getStatements().get(0);
		StatementBlock statementv4 = (StatementBlock) scriptv4.getStatements().get(0);
		assertEquals(statement.getLC(), statementv4.getLC());
		assertEquals(statement.getRC(), statementv4.getRC());
	}
	
	@Test
	public void testPlusAssignment() {
		String source = "a += 1;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		
		BinaryOperation assignment = (BinaryOperation) ((VoidExpression) script.getStatements().get(0)).getExpression();
		BinaryOperation assignmentv4 = (BinaryOperation) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		assertTrue(assignment.isAssignment());
		assertTrue(assignmentv4.isAssignment());
		assertEquals(assignment.getOperationPosition(), assignmentv4.getOperationPosition());
	}
	
	@Test
	public void testIf() {
		String source = "if (a < b) { b = a; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		
		IfStatement statement = (IfStatement) script.getStatements().get(0);
		IfStatement statementv4 = (IfStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
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
		WhileStatement statement = (WhileStatement) script.getStatements().get(0);
		WhileStatement statementv4 = (WhileStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
	}
	
	@Test
	public void testDo() {
		String source = "do {a+=1} while (a<b);";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		DoWhileStatement statement = (DoWhileStatement) script.getStatements().get(0);
		DoWhileStatement statementv4 = (DoWhileStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
		assertEquals(statement.getSemicolonPosition(), statementv4.getSemicolonPosition());
	}
	
	@Test
	public void testFor() {
		String source = "for(var i=0; i < list.size(); i++){ a += 1;}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		
		ForStatement statement = (ForStatement) script.getStatements().get(0);
		ForStatement statementv4 = (ForStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
		assertEquals(statement.getInitialSemicolonPosition(), statementv4.getInitialSemicolonPosition());
		assertEquals(statement.getConditionalSemicolonPosition(), statementv4.getConditionalSemicolonPosition());
	}
	
	@Test
	public void testForIn() {
		String source = "for (var e in obj) { a += 1; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		
		ForInStatement statement = (ForInStatement) script.getStatements().get(0);
		ForInStatement statementv4 = (ForInStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
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
		ForInStatement statement = (ForInStatement) script.getStatements().get(0);
		ForInStatement statementv4 = (ForInStatement) scriptv4.getStatements().get(0);
		StatementBlock block = (StatementBlock) statement.getBody();
		StatementBlock blockv4 = (StatementBlock) statementv4.getBody();
		ContinueStatement continue_ = (ContinueStatement) block.getStatements().get(0);
		ContinueStatement continue_v4 = (ContinueStatement) blockv4.getStatements().get(0);
		assertEquals(continue_.getSemicolonPosition(), continue_v4.getSemicolonPosition());
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
		FunctionStatement statement = (FunctionStatement) ((VoidExpression) script.getStatements().get(0)).getExpression();
		FunctionStatement statementv4 = (FunctionStatement) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		StatementBlock block = (StatementBlock) statement.getBody();
		StatementBlock blockv4 = (StatementBlock) statementv4.getBody();
		ReturnStatement return_ = (ReturnStatement) block.getStatements().get(0);
		ReturnStatement returnv4 = (ReturnStatement) blockv4.getStatements().get(0);
		assertEquals(return_.getSemicolonPosition(), returnv4.getSemicolonPosition());
	}
	
	@Test
	public void testParamsFrom() {
		//conditional keyword as object property
		String source = "plugins.mail.sendMail(params.to, params.from, params.subject, emailContent)";
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
		ForInStatement statement = (ForInStatement)((LabelledStatement) script.getStatements().get(0)).getStatement();
		ForInStatement statementv4 = (ForInStatement) ((LabelledStatement)scriptv4.getStatements().get(0)).getStatement();
		StatementBlock block = (StatementBlock) ((ForInStatement)statement.getBody()).getBody();
		StatementBlock blockv4 = (StatementBlock)((ForInStatement) statementv4.getBody()).getBody();
		BreakStatement break_ = (BreakStatement) block.getStatements().get(0);
		BreakStatement break_v4 = (BreakStatement) blockv4.getStatements().get(0);
		assertEquals(break_.getSemicolonPosition(), break_v4.getSemicolonPosition());
	}
	
	@Test
	public void testCall() {
		String source = "myfunc(10);";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		
		CallExpression expression = (CallExpression) ((VoidExpression) script.getStatements().get(0)).getExpression();
		CallExpression expressionv4 = (CallExpression) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		assertEquals(expression.getLP(), expressionv4.getLP());
		assertEquals(expression.getRP(), expressionv4.getRP());
		assertTrue(expressionv4.getCommas().isEmpty());
		assertEquals(expression.getCommas().size(), expressionv4.getCommas().size());
	}
	
	@Test
	public void testNew() {
		String source = "new A('test', 10);";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));

		NewExpression expression = (NewExpression) ((VoidExpression) script.getStatements().get(0)).getExpression();
		NewExpression expressionv4 = (NewExpression) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		CallExpression call = (CallExpression) expression.getObjectClass();
		CallExpression callv4 = (CallExpression) expressionv4.getObjectClass();
		assertEquals(call.getLP(), callv4.getLP());
		assertEquals(call.getRP(), callv4.getRP());
		assertEquals(callv4.getCommas().size(), callv4.getCommas().size());
		assertEquals(callv4.getCommas().size(),1);
		assertEquals(call.getCommas().first(), callv4.getCommas().first());
	}
	
	@Test
	public void testThrow() {
		String source = "if (a < b) throw new Error('some exception'); else throw 'error!';";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		
		IfStatement statement = (IfStatement) script.getStatements().get(0);
		IfStatement statementv4 = (IfStatement) scriptv4.getStatements().get(0);
		ThrowStatement throw_ = (ThrowStatement) statement.getThenStatement();
		ThrowStatement throw_v4 = (ThrowStatement) statementv4.getThenStatement();
		assertEquals(throw_.getSemicolonPosition(), throw_v4.getSemicolonPosition());
		ThrowStatement throw2 = (ThrowStatement) statement.getElseStatement();
		ThrowStatement throw2_v4 = (ThrowStatement) statementv4.getElseStatement();
		assertEquals(throw2.getSemicolonPosition(), throw2_v4.getSemicolonPosition());
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
		SwitchStatement statement = (SwitchStatement) script.getStatements().get(0);
		SwitchStatement statementv4 = (SwitchStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
		assertEquals(statement.getLC(), statementv4.getLC());
		assertEquals(statement.getRC(), statementv4.getRC());
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
	public void testEmptyExpressionFor() {
		String source = "for (;;){"
				+ "test(x);"
				+ "var a = 1;"
				+ "test(a)}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
			
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
	}
	
	@Test
	public void testFors() {
		String source = "for (var a;;){ test(a);}"
				+ "for (;a<10;){ test(a);}"
				+ "for (var b;a<10;){ test(a);}"
				+ "for (a<10;a++){ test(a);}";
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
		WithStatement statement = (WithStatement) script.getStatements().get(0);
		WithStatement statementv4 = (WithStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
	}
	
	@Test
	public void testPostIncrementExpression() {
		String source = "x = a++;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		
		BinaryOperation assignment = (BinaryOperation) ((VoidExpression) script.getStatements().get(0)).getExpression();
		BinaryOperation assignmentv4 = (BinaryOperation) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		UnaryOperation postincrement = (UnaryOperation) assignment.getRightExpression();
		UnaryOperation postincrementv4 = (UnaryOperation) assignmentv4.getRightExpression();
		assertEquals(postincrement.getOperationPosition(), postincrementv4.getOperationPosition());
	}
	
	@Test
	public void testIncrementExpression() {
		String source = "for(var i=0; i < 10; ++i){ a += 1;}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		UnaryOperation increment = (UnaryOperation) ((ForStatement) script.getStatements().get(0)).getStep();
		UnaryOperation incrementv4 = (UnaryOperation) ((ForStatement) scriptv4.getStatements().get(0)).getStep();
		assertEquals(increment.getOperationPosition(), incrementv4.getOperationPosition());
	}
	
	@Test
	public void testUnaryMinusExpression() {
		String source = "c = -a;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		BinaryOperation assignment = (BinaryOperation) ((VoidExpression) script.getStatements().get(0)).getExpression();
		BinaryOperation assignmentv4 = (BinaryOperation) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		UnaryOperation minus = (UnaryOperation) assignment.getRightExpression();
		UnaryOperation minusv4 = (UnaryOperation) assignmentv4.getRightExpression();
		assertEquals(minus.getOperationPosition(), minusv4.getOperationPosition());
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
		PropertyExpression expression = (PropertyExpression) ((VoidExpression) script.getStatements().get(0)).getExpression();
		PropertyExpression expressionv4 = (PropertyExpression) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		assertEquals(expression.getDotPosition(), expressionv4.getDotPosition());
	}
	
	@Test
	public void testArrayItemExpression() {
		String source = "arr[2];";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		GetArrayItemExpression expression = (GetArrayItemExpression) ((VoidExpression) script.getStatements().get(0)).getExpression();
		GetArrayItemExpression expressionv4 = (GetArrayItemExpression) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		assertEquals(expression.getLB(), expressionv4.getLB());
		assertEquals(expression.getRB(), expressionv4.getRB());
	}
	
	@Test
	public void testArrayInitializer() {
		String source = "var arr = [1, 2, 3];";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		
		VariableStatement statement = (VariableStatement) ((VoidExpression) script.getStatements().get(0)).getExpression();
		VariableStatement statementv4 = (VariableStatement) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		ArrayInitializer init = (ArrayInitializer) ((VariableDeclaration)statement.getVariables().get(0)).getInitializer();
		ArrayInitializer initv4 = (ArrayInitializer) ((VariableDeclaration)statementv4.getVariables().get(0)).getInitializer();
		assertEquals(init.getLB(), initv4.getLB());
		assertEquals(init.getRB(), initv4.getRB());
		assertEquals(init.getCommas().size(), initv4.getCommas().size());
		assertEquals(init.getCommas().get(0), initv4.getCommas().get(0));
		assertEquals(init.getCommas().get(1), initv4.getCommas().get(1));
	}
	
	@Test
	public void testCommaExpression() {
		String source = " x = a, b;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		CommaExpression expr = (CommaExpression) ((VoidExpression) script.getStatements().get(0)).getExpression();
		CommaExpression exprv4 = (CommaExpression) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		assertEquals(expr.getCommas().size(), exprv4.getCommas().size());
		assertEquals(expr.getCommas().get(0), exprv4.getCommas().get(0));
	}
	
	@Test
	public void testParenthesizedExpression() {
		String source = "y = ( a+b, 1/2, x );";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		BinaryOperation assignment = (BinaryOperation) ((VoidExpression) script.getStatements().get(0)).getExpression();
		BinaryOperation assignmentv4 = (BinaryOperation) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		ParenthesizedExpression pexpr = (ParenthesizedExpression) assignment.getRightExpression();
		ParenthesizedExpression pexprv4 = (ParenthesizedExpression) assignmentv4.getRightExpression();
		CommaExpression expr = (CommaExpression) pexpr.getExpression();
		CommaExpression exprv4 = (CommaExpression) pexprv4.getExpression();
		assertEquals(expr.getCommas().size(), exprv4.getCommas().size());
		assertEquals(expr.getCommas().get(0), exprv4.getCommas().get(0));
		assertEquals(expr.getCommas().get(1), exprv4.getCommas().get(1));
	}
	
	@Test
	public void testTernaryOperator() {
		String source = "y = x > 0 ? x : 0;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		BinaryOperation assignment = (BinaryOperation) ((VoidExpression) script.getStatements().get(0)).getExpression();
		BinaryOperation assignmentv4 = (BinaryOperation) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		ConditionalOperator conditional = (ConditionalOperator) assignment.getRightExpression();
		ConditionalOperator conditionalv4 = (ConditionalOperator) assignmentv4.getRightExpression();
		assertEquals(conditional.getQuestionPosition(), conditionalv4.getQuestionPosition());
		assertEquals(conditional.getColonPosition(), conditionalv4.getColonPosition());
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
		BinaryOperation assignment = (BinaryOperation) ((VoidExpression) script.getStatements().get(0)).getExpression();
		BinaryOperation assignmentv4 = (BinaryOperation) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		ObjectInitializer init = (ObjectInitializer) assignment.getRightExpression();
		ObjectInitializer initv4 = (ObjectInitializer) assignmentv4.getRightExpression();
		assertEquals(init.getLC(), initv4.getLC());
		assertEquals(init.getRC(), initv4.getRC());
		assertEquals(init.getCommas().size(), initv4.getCommas().size());
		assertEquals(init.getCommas().get(0), initv4.getCommas().get(0));
		assertEquals(init.getCommas().get(1), initv4.getCommas().get(1));
		assertEquals(init.getCommas().get(2), initv4.getCommas().get(2));
		assertEquals(init.isMultiline(), initv4.isMultiline());
	}
	
	@Test
	public void testEmptyExpression() {
		String source = "var arr = [1, , 3];";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4));
		VariableStatement statement = (VariableStatement) ((VoidExpression) script.getStatements().get(0)).getExpression();
		VariableStatement statementv4 = (VariableStatement) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		ArrayInitializer init = (ArrayInitializer) ((VariableDeclaration)statement.getVariables().get(0)).getInitializer();
		ArrayInitializer initv4 = (ArrayInitializer) ((VariableDeclaration)statementv4.getVariables().get(0)).getInitializer();
		assertEquals(init.getCommas().size(), initv4.getCommas().size());
		assertEquals(init.getCommas().get(0), initv4.getCommas().get(0));
		assertEquals(init.getCommas().get(1), initv4.getCommas().get(1));
		assertEquals(init.getItems().size(), initv4.getItems().size());
		assertTrue(init.getItems().get(1) instanceof EmptyExpression);
		assertTrue(initv4.getItems().get(1) instanceof EmptyExpression);
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
	public void testArrowFunction3() {
		String source ="() => {application.output(\"test\");}";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		assertTrue(statement.getChilds().get(0) instanceof ArrowFunctionStatement);
		ArrowFunctionStatement fn = (ArrowFunctionStatement) statement.getChilds().get(0);
		assertEquals(0, fn.getArguments().size());
	}
	
	@Test
	public void testFunc() {
		String source ="/**\r\n"
				+ "	 * @properties={typeid:24,uuid:\"46504F39-D010-4933-B11E-639EA779E496\"}\r\n"
				+ "	 */\r\n"
				+ "	function abc() {\r\n"
				+ "		const mat = ['abc', 'ab', 'ccc'];\r\n"
				+ "		application.output(mat.foreach(function(mat_){return mat_.length;}));\r\n"
				+ "	}";
		
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertNotNull(script);
		
		Statement statementv4 = scriptv4.getStatements().get(0);
		assertNotNull(statementv4);
		assertTrue(statementv4.getChilds().get(0) instanceof FunctionStatement);
		FunctionStatement fn4 = (FunctionStatement)statementv4.getChilds().get(0);
		assertNotNull(fn4.getDocumentation());
		
		Statement statement = script.getStatements().get(0);
		assertNotNull(statement);
		assertEquals(statement.sourceStart(), statementv4.sourceStart());
		assertEquals(statement.sourceEnd(), statementv4.sourceEnd());
		
		assertTrue(statement.getChilds().get(0) instanceof FunctionStatement);
		FunctionStatement fn = (FunctionStatement)statement.getChilds().get(0);

		assertEquals(fn.sourceStart(), fn4.sourceStart());
		assertEquals(fn.sourceEnd(), fn4.sourceEnd());
	}
	
	@Test
	public void testCallArrow() {
		String source = "application.output(mat.map(mat => mat.length));";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		Statement statementv4 = scriptv4.getStatements().get(0);
		assertNotNull(statementv4);
		assertTrue(statementv4 instanceof VoidExpression);
		VoidExpression expr = (VoidExpression)statementv4;
		assertTrue(expr.getParent() instanceof Script);
		assertTrue(expr.getExpression().getParent() instanceof Script);
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
	public void testTemplateString2() {
		String source ="var ts=`test ${abc+c}!`";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		assertTrue(statement instanceof VoidExpression);
		VariableStatement expression = (VariableStatement) ((VoidExpression) statement).getExpression();
		VariableDeclaration expr = expression.getVariables().get(0);
		assertEquals(source, expression.toString().trim());
		TemplateStringLiteral templateStringLiteral = (TemplateStringLiteral) expr.getInitializer();
		assertEquals(1, templateStringLiteral.getTemplateExpressions().size());
		assertEquals("${abc + c}", templateStringLiteral.getTemplateExpressions().get(0).toString());
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
	
	@Test
	public void testForOf() {
		String source = "for (var e of obj) { a+= 1; }";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		assertTrue(statement instanceof ForOfStatement);
		ForOfStatement forOf = (ForOfStatement) statement;
		assertEquals("var e", forOf.getItem().toString());
		assertEquals("obj", forOf.getIterator().toString());
		assertNotNull(forOf.getOfKeyword());
		assertEquals(11, forOf.getOfKeyword().sourceStart());
		assertEquals(13, forOf.getOfKeyword().sourceEnd());
		assertNotNull(forOf.getBody());
		assertEquals("a += 1;\n", ((StatementBlock)forOf.getBody()).getStatements().get(0).toString());
	}
	
	@Test
	public void testForOfLet() {
		String source = "for (let color of ['green', 'red', 'blue']) {\r\n"
				+ "		application.output(color);\r\n"
				+ "	}";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		assertTrue(statement instanceof ForOfStatement);
		ForOfStatement forOf = (ForOfStatement) statement;
		assertEquals("let color", forOf.getItem().toString());
		assertEquals("['green', 'red', 'blue']", forOf.getIterator().toString());
		assertNotNull(forOf.getOfKeyword());
		assertEquals(15, forOf.getOfKeyword().sourceStart());
		assertEquals(17, forOf.getOfKeyword().sourceEnd());
		assertNotNull(forOf.getBody());
		assertEquals("application.output(color);\n", ((StatementBlock)forOf.getBody()).getStatements().get(0).toString());
	}
	
	@Test
	public void testForOfConst() {
		String source = "for (const e of obj) { a+= 1; }";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		assertTrue(statement instanceof ForOfStatement);
		ForOfStatement forOf = (ForOfStatement) statement;
		assertEquals("const e", forOf.getItem().toString());
		assertEquals("obj", forOf.getIterator().toString());
		assertNotNull(forOf.getOfKeyword());
		assertEquals(13, forOf.getOfKeyword().sourceStart());
		assertEquals(15, forOf.getOfKeyword().sourceEnd());
		assertNotNull(forOf.getBody());
		assertEquals("a += 1;\n", ((StatementBlock)forOf.getBody()).getStatements().get(0).toString());
	}
	
	@Test
	public void testLet() {
		String source = "{ let a = 5; }";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		StatementBlock block = (StatementBlock) scriptv4.getStatements().get(0);
		LetStatement let = (LetStatement)((VoidExpression)block.getStatements().get(0)).getExpression();
		VariableDeclaration variableDeclaration = let.getVariables().get(0);
		assertEquals("a", variableDeclaration.getVariableName());
		assertEquals("5", variableDeclaration.getInitializer().toString());
	}
	
	@Test
	public void testLet_fnScope() {
		String source = "function f(param){ let a; }";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		FunctionStatement func = (FunctionStatement)scriptv4.getStatements().get(0).getChilds().get(0);
		assertEquals(1, func.getDeclarations().size());	
	}
	
	@Test
	public void testScopes() {
		String source = "function test(p){ if (p < 0) { "
				+ " let a = 5; "
				+ " var b = '';"
				+ " const c = 'test';"
				+ " for (let color in ['green', 'red', 'blue']) {}}"
				+ "}";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		FunctionStatement func = (FunctionStatement)scriptv4.getStatements().get(0).getChilds().get(0);
		assertEquals(1, func.getDeclarations().size());
		assertEquals("b", func.getDeclarations().get(0).getIdentifier().getName());
		
		IfStatement if_ = (IfStatement) func.getBody().getStatements().get(0);
		StatementBlock block = (StatementBlock) if_.getThenStatement();
		assertEquals(2, block.getDeclarations().size());
		assertEquals("a", block.getDeclarations().get(0).getIdentifier().getName());
		assertEquals("c", block.getDeclarations().get(1).getIdentifier().getName());
		
		assertEquals(4, block.getStatements().size());
		ForInStatement forin = (ForInStatement) block.getStatements().get(3);
		assertEquals(1, forin.getDeclarations().size());
		assertEquals("color", forin.getDeclarations().get(0).getIdentifier().getName());
	}
}