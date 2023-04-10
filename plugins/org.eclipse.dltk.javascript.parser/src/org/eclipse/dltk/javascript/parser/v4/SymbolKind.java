/*******************************************************************************
 * Copyright (c) 2011 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.parser.v4;

public enum SymbolKind {
	PARAM(JavaScriptParserProblems.DUPLICATE_PARAMETER, null),

	VAR(JavaScriptParserProblems.DUPLICATE_VAR,
			JavaScriptParserProblems.VAR_DUPLICATES_OTHER),

	CONST(JavaScriptParserProblems.DUPLICATE_CONST,
			JavaScriptParserProblems.CONST_DUPLICATES_OTHER),

	FUNCTION(JavaScriptParserProblems.DUPLICATE_FUNCTION,
			JavaScriptParserProblems.FUNCTION_DUPLICATES_OTHER);

	final JSProblemIdentifier duplicateProblem;
	final JSProblemIdentifier hideProblem;

	SymbolKind(JSProblemIdentifier duplicateProblem,
			JSProblemIdentifier hideProblem) {
		this.duplicateProblem = duplicateProblem;
		this.hideProblem = hideProblem;
	}

	public String verboseName() {
		return name().toLowerCase();
	}
}