package org.eclipse.dltk.javascript.parser.v4;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.parser.JavaScriptParser;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.AstRoot;

public class Main {

	public static void main(String[] args) {
		
		String js = "var x = 10;\nvar y=11;";
		Parser parser = new Parser();
		
		AstRoot root = parser.parse(js,"", 0);
		System.err.println(root);
		
		JavaScriptParser jsParser = new JavaScriptParser();
		Script script = jsParser.parse(js, new IProblemReporter() {
			
			@Override
			public void reportProblem(IProblem problem) {
				System.err.println(problem);
				
			}
		});
		System.err.println(script);
		
		org.eclipse.dltk.javascript.parser.rhino.Parser rhino = new org.eclipse.dltk.javascript.parser.rhino.Parser();
		Script parsed = rhino.parse(js, "", 0);
		System.err.println(parsed);
		
		System.err.println(scriptToString(script));
		System.out.println("Divider");
		System.err.println(scriptToString(parsed));
	}

	private static String scriptToString(Script script) {
		StringBuilder sb = new StringBuilder();
		sb.append("Declarations:\n ");
		script.getDeclarations().forEach(declaration -> {
			sb.append(createJSNode(declaration.getIdentifier(), ""));
		});
		sb.append("\n");
		sb.append("Statements:\n " );
		script.getStatements().forEach(statement -> {
			sb.append(createJSNode(statement, ""));
		});
		return sb.toString();
	}

	private static StringBuilder createJSNode(ASTNode node, String indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(indent);
		sb.append('[');
		sb.append(node.getClass().getSimpleName());
		sb.append(": start:" );
		sb.append(node.start());
		sb.append(" : end:" );
		sb.append(node.end());
		if (node instanceof JSNode) {
		sb.append(" : source: " );
		sb.append(((JSNode)node).toSourceString("").trim());
		}
		sb.append("]\n");
		
		node.getChilds().forEach(child -> {
			sb.append(createJSNode( child, indent + " "));
		});
		return sb;
		
	}
}
