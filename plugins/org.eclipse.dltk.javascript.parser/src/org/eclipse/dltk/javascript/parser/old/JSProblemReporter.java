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
package org.eclipse.dltk.javascript.parser.old;

import java.util.Collection;

import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.IProblemReporter;

public interface JSProblemReporter extends ProblemReporter, IProblemReporter {

	void pushSuppressWarnings(Collection<IProblemIdentifier> suppressed);

	void popSuppressWarnings();

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
