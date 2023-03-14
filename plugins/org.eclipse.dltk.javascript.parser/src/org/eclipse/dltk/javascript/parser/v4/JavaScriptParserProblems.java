/*******************************************************************************
 * Copyright (c) 2010 xored software, Inc.  
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html  
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.parser.v4;

import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.IProblemIdentifierExtension2;
import org.eclipse.dltk.utils.EnumNLS;
import org.eclipse.osgi.util.NLS;

public enum JavaScriptParserProblems implements IProblemIdentifier,
		JSProblemIdentifier, IProblemIdentifierExtension2 {

	INTERNAL_ERROR,
	LEXER_ERROR,
	SYNTAX_ERROR,
	RESERVED_KEYWORD,

	DUPLICATE_FUNCTION(JSParserProblemGroup.DUPLICATE_DECLARATION),
	DUPLICATE_PARAMETER(JSParserProblemGroup.DUPLICATE_DECLARATION),
	DUPLICATE_VAR(JSParserProblemGroup.DUPLICATE_DECLARATION),
	DUPLICATE_CONST(JSParserProblemGroup.DUPLICATE_DECLARATION),

	FUNCTION_DUPLICATES_OTHER(JSParserProblemGroup.DUPLICATE_DECLARATION_OTHER_KIND),
	VAR_DUPLICATES_OTHER(JSParserProblemGroup.DUPLICATE_DECLARATION_OTHER_KIND),
	CONST_DUPLICATES_OTHER(JSParserProblemGroup.DUPLICATE_DECLARATION_OTHER_KIND),

	DOUBLE_SWITCH_DEFAULT, DUPLICATE_LABEL, UNDEFINED_LABEL, BAD_BREAK,
	INVALID_RETURN, BAD_CONTINUE, CATCH_UNREACHABLE,

	TRAILING_COMMA_OBJECT_INITIALIZER;

	JavaScriptParserProblems() {
		this(null);
	}

	private final JSParserProblemGroup group;

	JavaScriptParserProblems(JSParserProblemGroup group) {
		this.group = group;
	}

	public IProblemIdentifier getPrimeIdentifier() {
		return group;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public String formatMessage(Object... args) {
		return NLS.bind(message, args);
	}

	static {
		EnumNLS.initializeMessages(JavaScriptParserProblems.values(), "message");
	}

	public String contributor() {
		return JavaScriptParserPlugin.PLUGIN_ID;
	}

	/**
	 * Checks if the specified problem is a syntax error, so AST is not fully
	 * correct.
	 */
	public static boolean isSyntaxError(IProblem problem) {
		return problem.getID() == LEXER_ERROR
				|| problem.getID() == SYNTAX_ERROR
				|| problem.getID() == INTERNAL_ERROR;
	}

}
