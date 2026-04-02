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

import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.IProblemReporter;

public interface JSProblemReporter extends ProblemReporter, IProblemReporter {

	void pushSuppressWarnings(Collection<IProblemIdentifier> suppressed);

	void popSuppressWarnings();

	/**
	 * Pushes suppress warnings for the given source position (nodeStart).
	 * The pair (nodeStart, suppressed) is stored so it can be conditionally
	 * popped when another node on the same line triggers a problem.
	 */
	void pushSuppressWarningsForLine(int nodeStart,
			Collection<IProblemIdentifier> suppressed);

	/**
	 * Pops the suppress warnings that were pushed for the same source line as
	 * the given nodeStart, if any. Does nothing if no such entry is on the
	 * stack or if the top entry is not on the same line.
	 */
	void popSuppressWarningsIfOnSameLine(int nodeStart);

	/**
	 * Returns the current state of suppress warnings or <code>null</code>.
	 */
	ISuppressWarningsState getSuppressWarnings();

	/**
	 * Replaces the current state of suppress warnings with the value returned
	 * from {@link #getSuppressWarnings()}
	 */
	void restoreSuppressWarnings(ISuppressWarningsState state);

	void reportProblem(IProblemIdentifier deprecatedMethod, String bind,
			int sourceStart, int sourceEnd, String... args);

}
