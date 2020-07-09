/*******************************************************************************
 * Copyright (c) 2011 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.parser;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

import org.eclipse.dltk.compiler.problem.DefaultProblem;
import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.dltk.core.builder.ISourceLineTracker;

public class Reporter extends LineTracker implements IProblemReporter,
		JSProblemReporter {

	private final IProblemReporter problemReporter;

	private IProblemIdentifier id;
	private String message;
	private int line;
	private int start;
	private int end;
	private ProblemSeverity severity;

	public Reporter(ISourceLineTracker lineTracker,
			IProblemReporter problemReporter) {
		super(lineTracker);
		this.problemReporter = problemReporter;
		reset();
	}

	private void reset() {
		severity = ProblemSeverity.WARNING;
		id = null;
		message = null;
		line = -1;
		start = -1;
		end = -1;
	}

	public void report() {
		if (problemReporter != null && message != null) {
			reportProblem(createProblem());
		}
		reset();
	}

	private IProblem createProblem() {
		if (line == -1 && start != -1) {
			line = getLineNumberOfOffset(start);
		}
		if (line > getNumberOfLines() && start >= 0 && start <= getLength()) {
			line = getLineNumberOfOffset(start);
		}

		return new DefaultProblem(message, id, null, severity, start, end, line);
	}

	public void setFormattedMessage(JSProblemIdentifier id, Object... args) {
		this.id = id;
		this.message = id.formatMessage(args);
	}

	public void setMessage(JSProblemIdentifier id) {
		this.id = id;
		this.message = id.getMessage();
	}

	public void setMessage(IProblemIdentifier id, String message) {
		this.id = id;
		this.message = message;
	}

	public IProblemIdentifier getId() {
		return id;
	}

	public void setId(IProblemIdentifier id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public ProblemSeverity getSeverity() {
		return severity;
	}

	public void setSeverity(ProblemSeverity severity) {
		this.severity = severity;
	}

	public void setRange(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public void reportProblem(IProblem problem) {
		if (problemReporter != null && problem != null) {
			problemReporter.reportProblem(problem);
		}
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		return null;
	}

	public void reportProblem(IProblemIdentifier identifier, String message,
			int start, int end) {
		if (isSuppressed(identifier)) {
			return;
		}
		reportProblem(ProblemSeverity.WARNING, identifier, message, start, end);
	}

	public void reportProblem(ProblemSeverity severity, IProblemIdentifier id,
			String message, int start, int end) {
		if (isSuppressed(id)) {
			return;
		}
		reportProblem(new DefaultProblem(message, id, null, severity, start,
				end, getLineNumberOfOffset(start)));
	}
	@Override
	public void reportProblem(IProblemIdentifier id, String message,
			int start, int end, String... args) {
		if (isSuppressed(id)) {
			return;
		}
		reportProblem(new DefaultProblem(message, id, args, severity, start,
				end, getLineNumberOfOffset(start)));
	}

	private boolean isSuppressed(IProblemIdentifier identifier) {
		return suppressed != null && suppressed.contains(identifier);
	}

	@SuppressWarnings("serial")
	private static class SnapshotProblemCategory extends
			HashSet<IProblemIdentifier> implements IProblemCategory {

		public SnapshotProblemCategory(SuppressWarningsSet warningsSet) {
			super(warningsSet);
		}

		public String name() {
			return "<snapshot>";
		}

		public Collection<IProblemIdentifier> contents() {
			return this;
		}
	}

	@SuppressWarnings("serial")
	private static class SuppressWarningsSet extends
			HashSet<IProblemIdentifier> implements ISuppressWarningsState {

		public SuppressWarningsSet() {
		}

		public SuppressWarningsSet(Collection<IProblemIdentifier> set) {
			super(set);
		}

		private SnapshotProblemCategory snapshot;

		public IProblemCategory asCategory() {
			if (snapshot == null || !snapshot.equals(this)) {
				snapshot = new SnapshotProblemCategory(this);
			}
			return snapshot;
		}
	}

	private SuppressWarningsSet suppressed;

	public void suppressProblems(IProblemIdentifier... identifiers) {
		if (suppressed == null) {
			suppressed = new SuppressWarningsSet();
		}
		Collections.addAll(suppressed, identifiers);
	}

	private Stack<SuppressWarningsSet> suppressedStack = null;

	public void pushSuppressWarnings(Collection<IProblemIdentifier> suppressed) {
		if (suppressedStack == null) {
			suppressedStack = new Stack<SuppressWarningsSet>();
		}
		suppressedStack.push(this.suppressed);
		if (this.suppressed == null) {
			this.suppressed = new SuppressWarningsSet();
		} else {
			this.suppressed = new SuppressWarningsSet(this.suppressed);
		}
		this.suppressed.addAll(suppressed);
	}

	public void popSuppressWarnings() {
		if (suppressedStack != null && !suppressedStack.isEmpty()) {
			suppressed = suppressedStack.pop();
		}
	}

	public ISuppressWarningsState getSuppressWarnings() {
		return suppressed;
	}

	public void restoreSuppressWarnings(ISuppressWarningsState sup) {
		suppressed = (SuppressWarningsSet) sup;
	}
}
