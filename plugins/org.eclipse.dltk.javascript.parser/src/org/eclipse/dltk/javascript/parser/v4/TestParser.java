package org.eclipse.dltk.javascript.parser.v4;

import org.antlr.runtime.RecognitionException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
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
		String source = "var a = 10;\nvar y=11;";		
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
