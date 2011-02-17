package org.eclipse.dltk.internal.javascript.validation;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.dltk.compiler.problem.DefaultProblemIdentifier;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.dltk.javascript.core.JavaScriptPlugin;
import org.eclipse.dltk.javascript.parser.ISeverityReporter;

public class JavaScriptValidationSeverityReporter implements ISeverityReporter {

	public ProblemSeverity getSeverity(IProblemIdentifier problemId,
			ProblemSeverity defaultSeverity) {
		if (defaultSeverity == null)
			defaultSeverity = ProblemSeverity.WARNING;

		String severity = new InstanceScope().getNode(
				JavaScriptPlugin.PLUGIN_ID).get(
				DefaultProblemIdentifier.encode(problemId), null);
		if (severity != null) {
			if (ProblemSeverity.ERROR.name().equals(severity)) {
				return ProblemSeverity.ERROR;
			} else if (ProblemSeverity.WARNING.name().equals(severity)) {
				return ProblemSeverity.WARNING;
			} else if (ProblemSeverity.INFO.name().equals(severity)) {
				return ProblemSeverity.INFO;
			} else if (ProblemSeverity.IGNORE.name().equals(severity)) {
				return null;
			}
		}
		return defaultSeverity;
	}

}
