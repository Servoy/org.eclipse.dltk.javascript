package org.eclipse.dltk.javascript.parser.rhino;

import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.dltk.javascript.parser.JSProblemIdentifier;
import org.eclipse.dltk.javascript.parser.JavaScriptParserPlugin;
import org.eclipse.dltk.javascript.parser.JavaScriptParserProblems;
import org.eclipse.dltk.javascript.parser.Reporter;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;

public class JSProblemReporter implements ErrorReporter {
	private final Reporter reporter;

	public JSProblemReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void warning(String message, String sourceName, int line,
			String lineSource, int lineOffset) {
		if (reporter == null)
			return;
		reporter.setId(JavaScriptParserProblems.SYNTAX_ERROR);
		reporter.setMessage(message);
		reporter.setSeverity(ProblemSeverity.WARNING);
		reporter.setLine(line - 1);
		reporter.setStart(reporter.getOffset(line - 1, lineOffset));
		reporter.report();
	}

	@Override
	public EvaluatorException runtimeError(String message, String sourceName,
			int line, String lineSource, int lineOffset) {
		return null;
	}

	@Override
	public void error(String message, String sourceName, int line,
			String lineSource, int lineOffset) {
		if (reporter == null)
			return;
		reporter.setMessage(JavaScriptParserProblems.SYNTAX_ERROR, message);
		reporter.setSeverity(ProblemSeverity.ERROR);
		reporter.setLine(line - 1);
		reporter.setStart(reporter.getOffset(line-1, lineOffset));
		reporter.report();
		
		JavaScriptParserPlugin.error(message);
	}

	public void setFormattedMessage(JSProblemIdentifier id, Object... args) {
		reporter.setFormattedMessage(id, args);
	}

	public void setRange(int sourceStart, int sourceEnd) {
		reporter.setRange(sourceStart, sourceEnd);
	}

	public void report() {
		reporter.report();
	}

	public void setMessage(JSProblemIdentifier id) {
		reporter.setMessage(id);
		
	}
	
	public void setMessage(JSProblemIdentifier id, String message) {
		reporter.setId(id);
		reporter.setMessage(message);
	}

	public void setSeverity(ProblemSeverity severity) {
		reporter.setSeverity(severity);
	}
}