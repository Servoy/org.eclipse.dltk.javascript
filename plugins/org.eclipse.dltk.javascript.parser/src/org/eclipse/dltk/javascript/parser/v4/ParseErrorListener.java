package org.eclipse.dltk.javascript.parser.v4;

import java.util.BitSet;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.dltk.javascript.parser.JavaScriptParserProblems;
import org.eclipse.dltk.javascript.parser.Reporter;

public class ParseErrorListener implements org.antlr.v4.runtime.ANTLRErrorListener {
	
	private Reporter reporter;

	public ParseErrorListener(Reporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
		if (reporter == null)
			return;
		reporter.setMessage(JavaScriptParserProblems.SYNTAX_ERROR, msg);
		reporter.setSeverity(ProblemSeverity.ERROR);
		Token token = null;
		if (offendingSymbol instanceof Token) {
			token = (Token) offendingSymbol;
		}
		else if (e != null && e.getOffendingToken() != null) {
			token = e.getOffendingToken();
		}
		if (token != null) {
			reporter.setRange(token.getStartIndex(),
				token.getStopIndex() + 1);
		}
		reporter.setLine(line - 1);
		reporter.report();
		
		JavaScriptParserPlugin.error(msg);
	}
	
	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
		// TODO Auto-generated method stub
//		System.out.println("ctx sensitivity "+startIndex);
	}
	
	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
		// TODO Auto-generated method stub		
//		System.out.println("full ctx " + startIndex);
	}
	
	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
//		System.out.println("ambiguity " + startIndex);
	}
}
