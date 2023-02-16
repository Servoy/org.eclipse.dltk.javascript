package org.eclipse.dltk.javascript.parser.v4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.VoidExpression;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.junit.Test;

/**
 * @since 6.0
 */
public class TestParser {
	
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
		String source = "var a,b = 10;";
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
		String source = "{a += 1;}";
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
		String source = "function abc(a,b){ a+=1;}";
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
			+//"var y=11+ b-a/2 * 7 % 3;\n" + //TODO
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
}
