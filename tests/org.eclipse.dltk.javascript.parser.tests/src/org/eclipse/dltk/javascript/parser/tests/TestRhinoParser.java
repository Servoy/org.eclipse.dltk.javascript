package org.eclipse.dltk.javascript.parser.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayDeque;
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
public class TestRhinoParser {
	
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
		org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser rhinoParser =  new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
		Script scriptv4 = rhinoParser.parse(source, new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				System.err.println(problem);
			}
		});
		System.err.println(scriptv4);
		return scriptv4;
	}
	
	private boolean equalsJSNode(ASTNode node1, ASTNode node2, ArrayDeque<String> stack) {
		stack.push(node1.getClass().getSimpleName());
		try {
			if (node1.toString().equals(node2.toString())
					&& node1.sourceStart() == node2.sourceStart()
					&& node1.sourceEnd() == node2.sourceEnd()
					&& node1.getChilds().size() == node2.getChilds().size()) {
				List<ASTNode> node1_children = node1.getChilds();
				List<ASTNode> node2_children = node2.getChilds();
				for (int i = 0; i < node1_children.size(); i++) {
					ASTNode child1 = node1_children.get(i);
					ASTNode child2 = node2_children.get(i);
					if (child1 instanceof JSNode) {
						if (!((JSNode) child1).getParent().getClass().getSimpleName().equals(((JSNode) child2).getParent().getClass().getSimpleName())) {
							fail("the node fails parent comparison for  " + ((JSNode) node2).getParent().getClass().getSimpleName() + " that should be "  + node1 + "\nstack: " + stack );
							return false;
						}
					}
					if (child1 instanceof VoidExpression
							&& ((VoidExpression) node1_children.get(i))
									.getExpression() instanceof VariableStatement
							|| node1_children
									.get(i) instanceof IVariableStatement
									&& child2 instanceof IVariableStatement) {
						//need to compare var statements separately because of bug in old antlr parser sourceEnd
						if (!compareVarStatements(child1, child2, stack)) {
							return false;
						}
						continue;
					}
					if (!equalsJSNode(child1, child2, stack)) {
						return false;
					}
				}
				if (node1 instanceof JSScope) {
					JSScope scope1 = (JSScope) node1;
					JSScope scope2 = (JSScope) node2;
					if (scope1.getDeclarations().size() == scope2
							.getDeclarations().size()) {
						for (int i = 0; i < scope1.getDeclarations()
								.size(); i++) {
							JSDeclaration decl1 = scope1.getDeclarations()
									.get(i);
							JSDeclaration decl2 = scope2.getDeclarations()
									.get(i);
							if (!equalsJSNode(decl1.getIdentifier(),
									decl2.getIdentifier(), stack)) {
								return false;
							}
						}
					} else {
						fail("the node fails for declaration size: " + scope1.getDeclarations().size() +" != "  + scope2.getDeclarations().size()+ " stack: " + stack + ", node:\n" + scope1);
						return false;
					}
								
				}
				if (node1 instanceof Documentable) {
					Comment documentation1 = ((JSNode) node1)
							.getDocumentation();
					Comment documentation2 = ((JSNode) node2)
							.getDocumentation();
					if (documentation1 != null) {
						if (documentation2 == null) {
							fail("the node fails mising documentation for  " + node2 + " that should be "  + node1 + "\nstack: " + stack );
							return false;
						}
						if (!equalsJSNode(documentation1, documentation2,
								stack)) {
							fail("the nodes documentation not equals for  " + documentation1 + " that should be "  + documentation2 + "\nstack: " + stack );
							return false;
						}
					}
				}
				if (node1 instanceof StatementBlock sb1) {
					if (node2 instanceof StatementBlock sb2) {
						if (!(sb1.getLC() == sb2.getLC()
								&& sb1.getRC() == sb2.getRC())) {
							fail("StatementBlocks don't have the same LC and/or RC, stack: " + stack + "\nnode1:\n" + node1 + "\nnode2:\n" + node2);
							return false;
						}
					} else {
						fail("both nodes are not instance of StatementBlocks, stack: " + stack + "\nnode1:\n" + node1 + "\nnode2:\n" + node2);
						return false;
					}
				}
				return true;
			}
			fail("nodes are not equal in source end/start or don't have the same childre, stack: " + stack + "\nnode1:\n" + node1 + "\nnode2:\n" + node2);
			return false;
		} finally {
			stack.pop();
		}
	}

	private boolean compareVarStatements(ASTNode child1, ASTNode child2, ArrayDeque<String> stack) {
		stack.push(child1.getClass().getSimpleName());
		try {
			IVariableStatement var1 = (IVariableStatement)(child1 instanceof VoidExpression ? 
					((VoidExpression)child1).getExpression(): child1);
			IVariableStatement var2 = (IVariableStatement) (child2 instanceof VoidExpression ? 
					((VoidExpression)child2).getExpression(): child2);
			if (child1.sourceStart() == child2.sourceStart() && 
					var1.getVariables().size() == var2.getVariables().size()) {
				for(int j = 0; j < var1.getVariables().size(); j++) {
					if (!equalsJSNode(var1.getVariables().get(j), var2.getVariables().get(j), stack)) {
						return false;
					}
				}
				return true;
			}
			fail("Var statements are not equal, var1: " + var1 + " , var2: " + var2 + ", stack: " + stack);
			return false;
		} finally {
			stack.pop();
		}
	}
	
	@Test
	public void testSimpleVariableDeclaration() {
		String source = "/** @type {String} */ var a;";
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
		assertTrue(equalsJSNode(statement.getDocumentation(), statementv4.getDocumentation(), new ArrayDeque<>()));
		VariableDeclaration variableDeclaration = statement.getVariables().get(0);
		VariableDeclaration variableDeclarationv4 = statementv4.getVariables().get(0);
		assertEquals(variableDeclaration.sourceStart(), variableDeclarationv4.sourceStart());
		assertEquals(variableDeclaration.sourceEnd(), variableDeclarationv4.sourceEnd());
		assertTrue(equalsJSNode(variableDeclaration, variableDeclarationv4, new ArrayDeque<>()));
		assertTrue(equalsJSNode(statement, statementv4, new ArrayDeque<>()));
		assertTrue(equalsJSNode(expression, expressionv4, new ArrayDeque<>()));
		
		assertEquals(script.sourceEnd(), scriptv4.sourceEnd());
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(statement.getVariables().get(0), statementv4.getVariables().get(0), new ArrayDeque<>()));
		assertTrue(equalsJSNode(statement.getVariables().get(1), statementv4.getVariables().get(1), new ArrayDeque<>()));
		assertTrue(equalsJSNode(statement, statementv4, new ArrayDeque<>()));
		assertTrue(equalsJSNode(expression, expressionv4, new ArrayDeque<>()));
		
		assertEquals(script.sourceEnd(), scriptv4.sourceEnd());
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testStatementBlock() {
		String source = "{ a += 1; b=2; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
		StatementBlock statement = (StatementBlock) script.getStatements().get(0);
		StatementBlock statementv4 = (StatementBlock) scriptv4.getStatements().get(0);
		assertEquals(statement.getLC(), statementv4.getLC());
		assertEquals(statement.getRC(), statementv4.getRC());
		for (int i = 0; i < statement.getStatements().size(); i++) {
			assertTrue(equalsJSNode(statement.getStatements().get(i), statementv4.getStatements().get(i), new ArrayDeque<>()));
		}
	}
	
	@Test
	public void testPlusAssignment() {
		String source = "a += 1;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testIfElse2() {
		String source = "if (a < b)  b = a;  else a = b;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testWhile() {
		String source = "while (a < b) {a+=1;}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
		ForInStatement statement = (ForInStatement) script.getStatements().get(0);
		ForInStatement statementv4 = (ForInStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
	}
	
	@Test
	public void testForInLet() {
		String source = "for (let e in obj) { a += 1; }";
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(scriptv4);
		
		ForInStatement statementv4 = (ForInStatement) scriptv4.getStatements().get(0);
		assertEquals(4, statementv4.getLP());
		assertEquals(17, statementv4.getRP());
		assertEquals(1, statementv4.getDeclarations().size());
		assertEquals(0, scriptv4.getDeclarations().size());
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
		assertTrue(equalsJSNode(func, func_v4, new ArrayDeque<>()));
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testContinue() {
		String source = "for (var e in obj) { continue; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4,new ArrayDeque<>() ));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testReturn1() {
		String source = "function sum(a,b){ return a + b }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		FunctionStatement statement = (FunctionStatement) ((VoidExpression) script.getStatements().get(0)).getExpression();
		FunctionStatement statementv4 = (FunctionStatement) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		StatementBlock block = (StatementBlock) statement.getBody();
		StatementBlock blockv4 = (StatementBlock) statementv4.getBody();
		ReturnStatement return_ = (ReturnStatement) block.getStatements().get(0);
		ReturnStatement returnv4 = (ReturnStatement) blockv4.getStatements().get(0);
		assertEquals(return_.getSemicolonPosition(), returnv4.getSemicolonPosition());
	}
	
	@Test
	public void testReturn2() {
		String source = "function test(b){ "
				+ "		if (!check) {\r\n"
				+ "			return // single line comment\r\n"
				+ "		}\r\n"
				+ " }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testReturn3() {
		String source = "function test(a){ return /** @type {String}*/ a }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testParamsFrom() {
		//conditional keyword as object property
		String source = "plugins.mail.sendMail(params.to, params.from, params.subject, emailContent)";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testBreak() {
		String source = "var cond; for (var e in obj) { cond = false; break; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testBreakLabel() {
		String source = "outer : for (var i in o) for (var e in obj) { break outer; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));

		NewExpression expression = (NewExpression) ((VoidExpression) script.getStatements().get(0)).getExpression();
		NewExpression expressionv4 = (NewExpression) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		CallExpression call = (CallExpression) expression.getObjectClass();
		CallExpression callv4 = (CallExpression) expressionv4.getObjectClass();
		assertEquals(call.getLP(), callv4.getLP());
		assertEquals(call.getRP(), callv4.getRP());
		assertEquals(call.getCommas().size(), callv4.getCommas().size());
		assertEquals(callv4.getCommas().size(),1);
		assertEquals(call.getCommas().first(), callv4.getCommas().first());
	}
	
	@Test
	public void testNewAndCall() {
		String source = "new Date().getTime()";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));

		CallExpression callexpression = (CallExpression) ((VoidExpression) script.getStatements().get(0)).getExpression();
		CallExpression callexpressionv4 = (CallExpression) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		assertEquals(callexpression.getLP(), callexpressionv4.getLP());
		assertEquals(callexpression.getRP(), callexpressionv4.getRP());
		assertEquals(callexpression.getCommas().size(), callexpressionv4.getCommas().size());
		assertEquals(callexpressionv4.getCommas().size(),0);
		PropertyExpression expression = (PropertyExpression) callexpression.getExpression();
		PropertyExpression expressionv4 = (PropertyExpression) callexpressionv4.getExpression();
		NewExpression object = (NewExpression) expression.getObject();
		NewExpression objectv4 = (NewExpression) expressionv4.getObject();
		assertTrue(equalsJSNode(object, objectv4, new ArrayDeque<>()));
		Identifier id = (Identifier) expression.getProperty();
		Identifier idv4 = (Identifier) expressionv4.getProperty();
		assertTrue(equalsJSNode(id, idv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testThrow() {
		String source = "if (a < b) throw new Error('some exception'); else throw 'error!';";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		TryStatement statement = (TryStatement)((StatementBlock)( script.getStatements().get(0))).getStatements().get(0);
		TryStatement statementv4 = (TryStatement)((StatementBlock)( scriptv4.getStatements().get(0))).getStatements().get(0);
		assertEquals(1, statementv4.getCatches().size()); //only 1 catch allowed in v4
		assertEquals(statement.getCatches().size(), statementv4.getCatches().size());
		CatchClause catchClause = statement.getCatches().get(0);
		CatchClause catchClausev4 = statementv4.getCatches().get(0);
		assertTrue(equalsJSNode(catchClause, catchClausev4, new ArrayDeque<>()));
		assertEquals(catchClause.getLP(), catchClausev4.getLP());
		assertEquals(catchClause.getRP(), catchClausev4.getRP());
		assertTrue(equalsJSNode(statement.getFinally(), statementv4.getFinally(), new ArrayDeque<>()));
	}
	
	@Test
	public void testYield() {
		String source = "function f() { yield abc; }";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testSwitch() {
		String source = "switch (color) { case 'blue' : print(msg1); break; case 'red' : print(msg2); break; default: print(msg);}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		SwitchStatement statement = (SwitchStatement) script.getStatements().get(0);
		SwitchStatement statementv4 = (SwitchStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
		assertEquals(statement.getLC(), statementv4.getLC());
		assertEquals(statement.getRC(), statementv4.getRC());
		assertEquals(statement.getCaseClauses().size(), statementv4.getCaseClauses().size());
		for (int i = 0; i < statement.getCaseClauses().size(); i++) {
			assertTrue(equalsJSNode(statement.getCaseClauses().get(i), statementv4.getCaseClauses().get(i), new ArrayDeque<>()));
			assertEquals(statement.getCaseClauses().get(i).getColonPosition(), statementv4.getCaseClauses().get(i).getColonPosition());
		}
	}
	
	@Test
	public void testSwitchErrorReporting() {
		String source = "switch (color) { case 'blue' : print(msg1); break; case 'red' : print(msg2); break; default: print(msg); default: abc();}";
		Script script = getScript(source);
		final org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser rhinoParser =  new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
		final List<IProblem> problems = new ArrayList<IProblem>();
		IProblemReporter reporter = new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				problems.add(problem);
			}
		};
		Script scriptv4 = rhinoParser.parse(source, reporter);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertEquals(1, problems.size());
		assertEquals("double default label in the switch statement", problems.get(0).getMessage());
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testEmptyStatement() {
		String source = ";";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testWithStatement() {
		String source = "with (obj) test(x);";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
						+" delete b;"
						+ "c = -1;"
						+ "d = +1;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testPropertyExpression() {
		String source = "myobj.myprop;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		GetArrayItemExpression expression = (GetArrayItemExpression) ((VoidExpression) script.getStatements().get(0)).getExpression();
		GetArrayItemExpression expressionv4 = (GetArrayItemExpression) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		assertEquals(expression.getLB(), expressionv4.getLB());
		assertEquals(expression.getRB(), expressionv4.getRB());
	}
	
	@Test
	public void testArrayInitializer() {
		String source = "var arr = [1, 2, 3]; ";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		BinaryOperation assignment = (BinaryOperation) ((VoidExpression) script.getStatements().get(0)).getExpression();
		BinaryOperation assignmentv4 = (BinaryOperation) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		ConditionalOperator conditional = (ConditionalOperator) assignment.getRightExpression();
		ConditionalOperator conditionalv4 = (ConditionalOperator) assignmentv4.getRightExpression();
		assertEquals(conditional.getQuestionPosition(), conditionalv4.getQuestionPosition());
		assertEquals(conditional.getColonPosition(), conditionalv4.getColonPosition());
	}
	
	@Test
	public void testTernaryOperator2() {
		String source = "check ? test = 1 : test = 2;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);

		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		ConditionalOperator conditional = (ConditionalOperator) ((VoidExpression) script.getStatements().get(0)).getExpression();
		ConditionalOperator conditionalv4 = (ConditionalOperator) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		assertEquals(conditional.getQuestionPosition(), conditionalv4.getQuestionPosition());
		assertEquals(conditional.getColonPosition(), conditionalv4.getColonPosition());
		BinaryOperation assignment1 = (BinaryOperation) conditional.getTrueValue();
		BinaryOperation assignmentv4_1 = (BinaryOperation) conditionalv4.getTrueValue();
		assertEquals("=", assignmentv4_1.getOperationText());
		assertEquals(assignment1.getOperationPosition(), assignmentv4_1.getOperationPosition());
		BinaryOperation assignment2 = (BinaryOperation) conditional.getFalseValue();
		BinaryOperation assignmentv4_2 = (BinaryOperation) conditionalv4.getFalseValue();
		assertEquals("=", assignmentv4_2.getOperationText());
		assertEquals(assignment2.getOperationPosition(), assignmentv4_2.getOperationPosition());

	}
	
	@Test
	public void testConst() {
		String source =
//				" const notInquireOnly = !getModule().isInInquireMode;\r\n"
//				+ "\r\n"
//				+ "	var allowChange = false;\r\n";
		
				"	const pivotDelta = {\r\n"
				+ "		quantityChange: 0,\r\n"
				+ "		amountChange: 0\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "	var allowChange = false;\r\n";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testObjectInitializer() {
		String source = "o = { a: 'foo',\n"
				+ " b: 42,\n"
				+ "get property() {},\n"
				+ "set property(value) {}"
				+ "};";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
	public void testObjectInitializerTrailingComma() {
		String source = "o = { a: 'foo',\n"
				+ " b: 42, };";
		
		org.eclipse.dltk.javascript.parser.JavaScriptParser jsParser =  new org.eclipse.dltk.javascript.parser.JavaScriptParser();
		final List<IProblem> problems = new ArrayList<IProblem>();
		Script script = jsParser.parse(source, new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				problems.add(problem);
			}
		});
		
		org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser jsParserv4 =  new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
		final List<IProblem> problemsv4 = new ArrayList<IProblem>();
		IProblemReporter reporter = new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				problemsv4.add(problem);
			}
		};
		Script scriptv4 = jsParserv4.parse(source, reporter);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		BinaryOperation assignment = (BinaryOperation) ((VoidExpression) script.getStatements().get(0)).getExpression();
		BinaryOperation assignmentv4 = (BinaryOperation) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		ObjectInitializer init = (ObjectInitializer) assignment.getRightExpression();
		ObjectInitializer initv4 = (ObjectInitializer) assignmentv4.getRightExpression();
		assertEquals(init.getLC(), initv4.getLC());
		assertEquals(init.getRC(), initv4.getRC());
		assertEquals(2, init.getCommas().size());
		assertEquals(init.getCommas().size(), initv4.getCommas().size());
		assertEquals(init.getCommas().get(0), initv4.getCommas().get(0));
		assertEquals(init.getCommas().get(1), initv4.getCommas().get(1));
		assertEquals(init.isMultiline(), initv4.isMultiline());
		
		assertEquals(0, problemsv4.size());
		assertEquals(1, problems.size());
		//the warning is only with the old parser
		assertEquals("trailing comma is not legal in ECMA-262 object initializers", problems.get(0).getMessage() );
	}	
	
	
	@Test
	public void testEmptyExpression() {
		//empty element should be ignored if comma is on the last position
		String source = "var arr = [1, , 3 ,];";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
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
		assertEquals(3, initv4.getItems().size());
		assertEquals("3", ((DecimalLiteral)initv4.getItems().get(2)).getText());
	}

	@Test
	public void testExpression() {
		String source = "var payload={\"sub\": \"1234567890\", name_: \"Edit M\", \"admin\": true, arrayValue: ['Monday', 'Tuesday'], arr: [1, 2, 3]};\r\n"
				+ ";";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	 
	@Test
	public void testFunctionExpression() {
			String source ="this.setNavigationPolicy = function(policy) { this.navigationPolicy = policy; return this; }";
			Script script = getScript(source);
			Script scriptv4 = getScriptv4(source);
			
			assertNotNull(script);
			assertNotNull(scriptv4);
			assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testInExpression() {
		String source ="if (!('svyNavigationHistory' in scopes)) {\r\n"
				+ "			scopes.svyNavigationHistory;\r\n"
				+ "		}";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testCatchIf() {
		String source = " try {"
		+ "		scopes.svyEventManager.fireEvent(this, APPLICATION_EVENT_TYPES.ERROR, arguments, true)"
		+ "	} catch (e if e instanceof scopes.svyEventManager.VetoEventException) {"
		+ "		application.output(e)"
		+ "	}";
		
		final org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser jsParserv4 =  new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
		final List<IProblem> problems = new ArrayList<IProblem>();
		IProblemReporter reporter = new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				problems.add(problem);
			}
		};
		Script scriptv4 = jsParserv4.parse(source, reporter);
		assertNotNull(scriptv4);		
		assertEquals(0, problems.size());
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
		String source ="(a, b) => a + b + 100";
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
		String source = "application.output(mat.map(mat => mat.length;));";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		Statement statementv4 = scriptv4.getStatements().get(0);
		assertNotNull(statementv4);
		assertTrue(statementv4 instanceof VoidExpression);
		VoidExpression expr = (VoidExpression)statementv4;
		assertNotNull(expr.getParent());
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

// not supported in Rhino	
//	@Test
//	public void testForOfConst() {
//		String source = "for (const e of obj) { a+= 1; }";
//		Script scriptv4 = getScriptv4(source);
//		assertNotNull(scriptv4);
//		
//		Statement statement = scriptv4.getStatements().get(0);
//		assertNotNull(statement);
//		assertTrue(statement instanceof ForOfStatement);
//		ForOfStatement forOf = (ForOfStatement) statement;
//		assertEquals("const e", forOf.getItem().toString());
//		assertEquals("obj", forOf.getIterator().toString());
//		assertNotNull(forOf.getOfKeyword());
//		assertEquals(13, forOf.getOfKeyword().sourceStart());
//		assertEquals(15, forOf.getOfKeyword().sourceEnd());
//		assertNotNull(forOf.getBody());
//		assertEquals("a += 1;\n", ((StatementBlock)forOf.getBody()).getStatements().get(0).toString());
//	}
	
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
		assertEquals(2, func.getDeclarations().size());
		assertEquals("b", func.getDeclarations().get(0).getIdentifier().getName());
		assertEquals("c", func.getDeclarations().get(1).getIdentifier().getName());
		
		IfStatement if_ = (IfStatement) func.getBody().getStatements().get(0);
		StatementBlock block = (StatementBlock) if_.getThenStatement();
		assertEquals(1, block.getDeclarations().size());
		assertEquals("a", block.getDeclarations().get(0).getIdentifier().getName());
		
		assertEquals(4, block.getStatements().size());
		ForInStatement forin = (ForInStatement) block.getStatements().get(3);
		assertEquals(1, forin.getDeclarations().size());
		assertEquals("color", forin.getDeclarations().get(0).getIdentifier().getName());
	}
	
	@Test
	public void testError() {
		String source = "function onAction(event) {"
				+ " event."
				+ "}";
		
		Script script = getScript(source);
		final org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser rhinoParser =  new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
		final List<IProblem> problems = new ArrayList<IProblem>();
		IProblemReporter reporter = new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				problems.add(problem);
			}
		};
		Script scriptv4 = rhinoParser.parse(source, reporter);	
		assertEquals(2, problems.size()); //TODO check the old parser has 1..
		assertTrue(problems.get(1).getMessage().startsWith("missing }"));
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testError2() {
		//array comprehension feature (obsolete)
		String source = "var numbers = [1, 2, 3, 4];\r\n"
				+ "var doubled = [i * 2 for (i of numbers)];";
		
		Script script = getScript(source);
		final org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser rhinoParser =  new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
		final List<IProblem> problems = new ArrayList<IProblem>();
		IProblemReporter reporter = new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				problems.add(problem);
			}
		};
		Script scriptv4 = rhinoParser.parse(source, reporter);	
		assertEquals(2, problems.size());
		assertTrue(problems.get(1).getMessage().startsWith("syntax error"));
		
		assertNotNull(script);
		assertNotNull(scriptv4);
//		assertTrue(equalsJSNode(script, scriptv4)); //do not compare because the new parser parses a bit more
	}
	
	@Test
	public void testContinueLineTerminator() {
		String source = "for (var i = 0; i < [].length; i++) {\r\n"
				+ "			var o = {}\r\n"
				+ "			\r\n"
				+ "         if (false) continue\r\n"
				+ "			\r\n"
				+ "			o[test] "
				+ "		}";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		ForStatement statement = (ForStatement) script.getStatements().get(0);
		ForStatement statementv4 = (ForStatement) scriptv4.getStatements().get(0);
		assertEquals(statement.getLP(), statementv4.getLP());
		assertEquals(statement.getRP(), statementv4.getRP());
		StatementBlock body = (StatementBlock) statement.getBody();
		StatementBlock bodyV4 = (StatementBlock) statementv4.getBody();
		IfStatement if_ = (IfStatement) body.getStatements().get(1);
		IfStatement if_v4 = (IfStatement) bodyV4.getStatements().get(1);
		
		ContinueStatement cont = (ContinueStatement) if_.getThenStatement();
		ContinueStatement contv4 = (ContinueStatement) if_v4.getThenStatement();
		assertEquals(cont.sourceEnd(), contv4.sourceEnd());
		
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testReturnLineTerminator() {
		String source = "function a() {\r\n"
				+ "			var o = {}\r\n"
				+ "			\r\n"
				+ "         if (false) return\r\n"
				+ "			o[test] "
				+ "		}";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testFunctionExpression2() {
		String source = "var x = (function test(){})()";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testFunctionExpression3() {
		String source = 
				 "this.addSearchProvider = function(dataProviderID, alias, impliedSearch, caseSensitive) {\r\n"
				+ "		var sp;\r\n"
				+ "		//	 search provider is new\r\n"
				+ "		if (!spExists) {\r\n"
				+ "			sp = new SearchProvider(this, dataProviderID);\r\n"
				+ "			searchProviders.push(sp);\r\n"
				+ "		}\r\n"
				+ "		return sp;\r\n"
				+ "	}";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testFunction() {
		String source = 
				 "function formatObjectExpansion(object, maxdepth, indent) {\r\n"
				 + "	function doFormat(obj, depth, indentation) {\r\n"
				 + "}\r\n"
				 + "	return doFormat(object, maxdepth, indent);\r\n"
				 + "}";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testMISC() {
		String source = " /**\r\n"
				+ "     * Sets the property value for this property.\r\n"
				+ "     * \r\n"
				+ "     * @public\r\n"
				+ "     * @param {String} propertyValue \r\n"
				+ "     * @return {Property} This property for call-chaining support.\r\n"
				+ "     * @this {Property}\r\n"
				+ "     */\r\n"
				+ "    Property.prototype.setPropertyValue = function(propertyValue) {\r\n"
				+ "    	if (!textLengthIsValid(propertyValue, MAX_VALUE_LENGTH)) {\r\n"
				+ "    		throw new Error(utils.stringFormat('PropertyValue must be between 0 and %1$s characters long.', [MAX_VALUE_LENGTH]));\r\n"
				+ "    	}\r\n"
				+ "    	\r\n"
				+ "    	this.record.property_value = propertyValue;\r\n"
				+ "        saveRecord(this.record);\r\n"
				+ "        return this;\r\n"
				+ "    }";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		for (int i = 0; i < script.getComments().size(); i++) {
			assertTrue(equalsJSNode(script.getComments().get(i), scriptv4.getComments().get(i), new ArrayDeque<>()));
		}
	}
	
	@Test
	public void testMultilineStringLiteral() {
		String source =  "var sql = \"line 1 \\\r\n"
				+ "		some other line \\\r\n"
				+ "		last line\"";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testSingleLineJSDoc() {
		String source = " /** @type {String} */ \r\n"
				+ "var a = 'test';";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertEquals(script.getComments().get(0).toString(), scriptv4.getComments().get(0).toString());
		assertTrue(equalsJSNode(script.getComments().get(0), scriptv4.getComments().get(0), new ArrayDeque<>()));
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));

	}
	
	@Test
	public void testSingleLineComments() {
		String source = "//test🌈 / June, 9 1:27 PM---\r\n" 
				+ "objectFields[subName].is_calculate_on_top = isCalculateOnTop // it's for tax only\r\n"
				+"		//	TODO add the missing bits, see:\r\n ";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertEquals(3, scriptv4.getComments().size());
		assertEquals(script.getComments().get(0).toString(), scriptv4.getComments().get(0).toString());
		assertEquals(script.getComments().get(1).toString(), scriptv4.getComments().get(1).toString());
		assertEquals(script.getComments().get(2).toString(), scriptv4.getComments().get(2).toString());
		assertTrue(equalsJSNode(script.getComments().get(0), scriptv4.getComments().get(0), new ArrayDeque<>()));
		assertTrue(equalsJSNode(script.getComments().get(1), scriptv4.getComments().get(1), new ArrayDeque<>()));
		assertTrue(equalsJSNode(script.getComments().get(2), scriptv4.getComments().get(2), new ArrayDeque<>()));
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));

	}
	
	@Test
	public void testSingleLineComments2() {
		String source = "//🌈\r\n"
				+ "a // ";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertEquals(2, scriptv4.getComments().size());
		assertEquals(script.getComments().get(0).toString(), scriptv4.getComments().get(0).toString());
		assertTrue(equalsJSNode(script.getComments().get(0), scriptv4.getComments().get(0), new ArrayDeque<>()));
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));

	}
	
	@Test
	public void testNewFunction() {
		String source =  "var x = new function() {  }";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testPropertyShorthand() {
		String source ="obj = { test, property: value, property_shorthand }";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statement = scriptv4.getStatements().get(0);
		assertNotNull(statement);
		BinaryOperation assignmentv4 = (BinaryOperation) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		ObjectInitializer initv4 = (ObjectInitializer) assignmentv4.getRightExpression();
		assertEquals(3, initv4.getInitializers().size());
		assertTrue(initv4.getInitializers().get(0) instanceof PropertyShorthand);
		PropertyShorthand property1 = (PropertyShorthand) initv4.getInitializers().get(0);
		assertEquals("test", property1.getExpression().toString());
		assertTrue(initv4.getInitializers().get(1) instanceof PropertyInitializer);
		PropertyInitializer property2 = (PropertyInitializer) initv4.getInitializers().get(1);
		assertEquals("property", property2.getName().toString());
		assertEquals("value", property2.getValue().toString());
		PropertyShorthand property3 = (PropertyShorthand) initv4.getInitializers().get(2);
		assertEquals("property_shorthand", property3.getExpression().toString());
	}
	
	@Test
	public void testNewPropertyExpression_and_Call() {
		String source =  "new java.lang.String(string).getBytes()";
		Script script = getScript(source);	
		assertNotNull(script);
		
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
		
		CallExpression callexpression = (CallExpression) ((VoidExpression) script.getStatements().get(0)).getExpression();
		CallExpression callexpressionv4 = (CallExpression) ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
		assertEquals(callexpression.getLP(), callexpressionv4.getLP());
		assertEquals(callexpression.getRP(), callexpressionv4.getRP());
		assertEquals(callexpression.getCommas().size(), callexpressionv4.getCommas().size());
		assertEquals(callexpressionv4.getCommas().size(),0);
		PropertyExpression expression = (PropertyExpression) callexpression.getExpression();
		PropertyExpression expressionv4 = (PropertyExpression) callexpressionv4.getExpression();
		NewExpression object = (NewExpression) expression.getObject();
		NewExpression objectv4 = (NewExpression) expressionv4.getObject();
		assertTrue(equalsJSNode(object, objectv4, new ArrayDeque<>()));
		CallExpression call = (CallExpression)object.getObjectClass();
		CallExpression callv4 = (CallExpression)objectv4.getObjectClass();
		PropertyExpression id = (PropertyExpression) call.getExpression();
		PropertyExpression idv4 = (PropertyExpression) callv4.getExpression();
		assertTrue(equalsJSNode(id, idv4, new ArrayDeque<>()));
	}
	
	@Test
	public void testRestArguments1() {
		String source ="function myFn(...myArgs) { }";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statementv4 = scriptv4.getStatements().get(0);
		assertNotNull(statementv4);
		assertTrue(statementv4.getChilds().get(0) instanceof FunctionStatement);
		FunctionStatement fn = (FunctionStatement) statementv4.getChilds().get(0);
		assertEquals("myFn", fn.getName().toString());
		List<Argument> arguments = fn.getArguments();
		assertEquals(1, arguments.size());
		Argument lastArg = arguments.get(0);
		assertEquals("myArgs", lastArg.getArgumentName());
		assertEquals(14, lastArg.getEllipsisPosition());
		assertEquals("...myArgs", lastArg.toString());
	}
	
	@Test
	public void testRestArguments2() {
		String source ="function myFn(firstArg, secondArg, ...myArgs) { }";
		Script scriptv4 = getScriptv4(source);
		assertNotNull(scriptv4);
		
		Statement statementv4 = scriptv4.getStatements().get(0);
		assertNotNull(statementv4);
		assertTrue(statementv4.getChilds().get(0) instanceof FunctionStatement);
		FunctionStatement fn = (FunctionStatement) statementv4.getChilds().get(0);
		assertEquals("myFn", fn.getName().toString());
		List<Argument> arguments = fn.getArguments();
		assertEquals(3, arguments.size());
		Argument firstArg = arguments.get(0);
		assertEquals("firstArg", firstArg.getArgumentName());
		assertEquals(-1, firstArg.getEllipsisPosition());
		assertEquals(22, firstArg.getCommaPosition());
		assertEquals("firstArg", firstArg.toString());
		Argument secondArg = arguments.get(1);
		assertEquals("secondArg", secondArg.getArgumentName());
		assertEquals(-1, secondArg.getEllipsisPosition());
		assertEquals(33, secondArg.getCommaPosition());
		assertEquals("secondArg", secondArg.toString());
		Argument lastArg = arguments.get(2);
		assertEquals("myArgs", lastArg.getArgumentName());
		assertEquals(35, lastArg.getEllipsisPosition());
		assertEquals(-1, lastArg.getCommaPosition());
		assertEquals("...myArgs", lastArg.toString());
	}
	
	@Test
	public void testRestArguments3() {
		String source ="function myFn(...myArgs, firstArg) { }";
		org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser jsParserv4 =  new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
		final List<IProblem> problemsv4 = new ArrayList<IProblem>();
		IProblemReporter reporter = new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				problemsv4.add(problem);
			}
		};
		Script scriptv4 = jsParserv4.parse(source, reporter);
		assertNotNull(scriptv4);
		assertEquals(1, problemsv4.size());
		assertEquals("parameter after rest parameter", problemsv4.get(0).getMessage());
	}
	
	@Test
	public void testXMLLiteral() {
		String source = "<SQL>select * from tbl</SQL>";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		XmlLiteral literal = (XmlLiteral) ((VoidExpression)script.getStatements().get(0)).getExpression();
		XmlLiteral literalv4 = (XmlLiteral) ((VoidExpression)scriptv4.getStatements().get(0)).getExpression();
		assertEquals(literal.getFragments().size(), literalv4.getFragments().size());
		assertEquals(1, literalv4.getFragments().size());
		ArrayDeque<String> stack = new ArrayDeque<>();
		assertTrue(equalsJSNode(literal.getFragments().get(0), literalv4.getFragments().get(0), stack));
		assertTrue(equalsJSNode(script, scriptv4, stack));
	}
	
	@Test
	public void testXMLExpressionFragment() {
		String source = "<person>\r\n"
				+ "  <name>{firstName} {lastName}</name>\r\n"
				+ "  <age>{30 + 5}</age>\r\n"
				+ "</person>;"
				+ "<item type=\"oranges\" price=\"4\"/>;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		XmlLiteral literal = (XmlLiteral) ((VoidExpression)script.getStatements().get(0)).getExpression();
		XmlLiteral literalv4 = (XmlLiteral) ((VoidExpression)scriptv4.getStatements().get(0)).getExpression();
		assertEquals(literal.getFragments().size(), literalv4.getFragments().size());
		ArrayDeque<String> stack = new ArrayDeque<>();
		for (int i = 0 ; i < literal.getFragments().size(); i++ ) {
			assertTrue(equalsJSNode(literal.getFragments().get(i), literalv4.getFragments().get(i), stack));
		}
		assertTrue(equalsJSNode(script, scriptv4, stack));
	}	
	
	@Test
	public void testXMLAttributeIdentifier() {
		String source = "person.@firstName;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		ArrayDeque<String> stack = new ArrayDeque<>();
		PropertyExpression literal = (PropertyExpression) ((VoidExpression)script.getStatements().get(0)).getExpression();
		PropertyExpression literalv4 = (PropertyExpression) ((VoidExpression)scriptv4.getStatements().get(0)).getExpression();
		XmlAttributeIdentifier id = (XmlAttributeIdentifier) literal.getProperty();
		XmlAttributeIdentifier idv4 = (XmlAttributeIdentifier) literalv4.getProperty();
		assertEquals(id.getAttributeName(), idv4.getAttributeName());
		assertTrue(equalsJSNode(script, scriptv4, stack));
	}
	
	@Test
	public void testXMLGetLocalName() {
		String source = "ns::firstName;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		ArrayDeque<String> stack = new ArrayDeque<>();
		GetLocalNameExpression id = (GetLocalNameExpression) ((VoidExpression)script.getStatements().get(0)).getExpression();
		GetLocalNameExpression idv4 = (GetLocalNameExpression) ((VoidExpression)scriptv4.getStatements().get(0)).getExpression();
		assertEquals(id.getNamespace().toString(), idv4.getNamespace().toString());
		assertEquals(id.getLocalName().toString(), idv4.getLocalName().toString());
		assertEquals(id.getColonColonPosition(), idv4.getColonColonPosition());
		assertTrue(equalsJSNode(script, scriptv4, stack));
	}
	
	@Test
	public void testXMLAsteriskExpression() {
		String source = "ns::*;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		ArrayDeque<String> stack = new ArrayDeque<>();
		GetLocalNameExpression id = (GetLocalNameExpression) ((VoidExpression)script.getStatements().get(0)).getExpression();
		GetLocalNameExpression idv4 = (GetLocalNameExpression) ((VoidExpression)scriptv4.getStatements().get(0)).getExpression();
		assertEquals(id.getNamespace().toString(), idv4.getNamespace().toString());
		assertEquals(id.getLocalName().toString(), idv4.getLocalName().toString());
		assertEquals(id.getColonColonPosition(), idv4.getColonColonPosition());
		assertTrue(equalsJSNode(script, scriptv4, stack));
	}
	
	@Test
	public void testXMLGetAllChildren() {
		String source = "foo..bar;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		ArrayDeque<String> stack = new ArrayDeque<>();
		GetAllChildrenExpression id = (GetAllChildrenExpression) ((VoidExpression)script.getStatements().get(0)).getExpression();
		GetAllChildrenExpression idv4 = (GetAllChildrenExpression) ((VoidExpression)scriptv4.getStatements().get(0)).getExpression();
		assertEquals(id.getObject().toString(), idv4.getObject().toString());
		assertEquals(id.getProperty().toString(), idv4.getProperty().toString());
		assertEquals(id.getDotDotPosition(), idv4.getDotDotPosition());
		assertTrue(equalsJSNode(script, scriptv4, stack));
	}
	
	@Test
	public void testDefaultXMLNamespace() {
		String source = "default xml namespace = \"http://example.com/namespace\";";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		ArrayDeque<String> stack = new ArrayDeque<>();
		assertTrue(equalsJSNode(script, scriptv4, stack));
	}
	
	@Test
	public void testVariousXMLExpressions() {
		String source = "ns..@*;"
				+ "name::[expr];" //the old parser ignores the [], therefore so does the new one
				+ "sales.item.(@type == \"oranges\").@quantity;"
				+ "sales..@price;";
		Script script = getScript(source);
		Script scriptv4 = getScriptv4(source);
		
		assertNotNull(script);
		assertNotNull(scriptv4);
		assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
	}
}