package org.eclipse.dltk.javascript.parser.v4;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.internal.parser.v4.JSCommonTokenStream;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ProgramContext;

/**
 * @since 6.0
 */
public class TestParser {

	public static void main(String[] args) throws RecognitionException {
		String source = "var a = 10;";		
//		char[] arr = source.toCharArray();
//		org.antlr.runtime.CharStream charStream2 = new ANTLRStringStream(arr, arr.length);
//		final org.eclipse.dltk.javascript.parser.JSTokenStream stream2 = new org.eclipse.dltk.javascript.internal.parser.JSCommonTokenStream(new org.eclipse.dltk.javascript.parser.JavaScriptLexer(charStream2));
//		final org.eclipse.dltk.javascript.parser.JSParser parser2 =  new org.eclipse.dltk.javascript.parser.JSParser(stream2);
//		final ParserRuleReturnScope root2 = parser2.program();
//		org.eclipse.dltk.javascript.parser.JSTransformer transformer = new org.eclipse.dltk.javascript.parser.JSTransformer(stream2.getTokens());
//		ASTNode ast = transformer.transform(root2);
//		System.out.println(ast);
		final org.eclipse.dltk.javascript.parser.JavaScriptParser jsParser =  new org.eclipse.dltk.javascript.parser.JavaScriptParser();
		Script script = jsParser.parse(source, new IProblemReporter() {		
			@Override
			public void reportProblem(IProblem problem) {
				System.err.println(problem);
				
			}
		});
		System.err.println(script);
		
		CharStream charStream =  CharStreams.fromString(source);
		final JSTokenStream stream = new JSCommonTokenStream(new JavaScriptLexer(charStream));
		final JSParser parser =  new JSParser(stream);
		final ProgramContext root = parser.program();
		JSTransformerListener listener = new JSTransformerListener(parser);
		Script scriptv4 = listener.transformScript(root);
		System.err.println(scriptv4);
	}
}
