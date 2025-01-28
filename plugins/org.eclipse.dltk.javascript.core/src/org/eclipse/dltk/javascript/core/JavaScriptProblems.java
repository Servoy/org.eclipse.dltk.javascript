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
package org.eclipse.dltk.javascript.core;

import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.IProblemIdentifierExtension2;
import org.eclipse.dltk.compiler.problem.IProblemIdentifierExtension3;
import org.eclipse.dltk.compiler.problem.ProblemCategory;
import org.eclipse.dltk.javascript.parser.JSParserProblemGroup;

public enum JavaScriptProblems implements IProblemIdentifier,
		IProblemIdentifierExtension2, IProblemIdentifierExtension3 {

	/**
	 * Unknown type specified in JSDoc
	 */
	UNKNOWN_TYPE,

	/**
	 * Wrong type expression specified in javascript code, e.g.
	 * <code>new a.b.c.d()</code>
	 */
	WRONG_TYPE_EXPRESSION, DEPRECATED_TYPE,

	/**
	 * Non-instantiable type
	 */
	NON_INSTANTIABLE_TYPE,

	/**
	 * @since 3.0
	 */
	UNDECLARED_VARIABLE,

	/**
	 * Undefined standalone function
	 */
	UNDEFINED_FUNCTION(UNDECLARED_VARIABLE),

	/**
	 * Undefined object/class method
	 */
	UNDEFINED_METHOD,

	/**
	 * Call to something which is not known be a function.
	 */
	WRONG_FUNCTION,

	WRONG_PARAMETERS, WRONG_PARAMETERS_PARAMETERIZATION, WRONG_PARAMETERS_UNTYPED, DEPRECATED_METHOD,

	/**
	 * @since 3.0
	 */
	DEPRECATED_FUNCTION,

	/**
	 * @since 4.0
	 */
	INACCESSIBLE_MEMBER,

	/**
	 * @since 5.0
	 */
	INACCESSIBLE_TYPE,

	/**
	 * @since 5.0
	 */
	NOT_GENERIC_TYPE,

	/**
	 * @since 5.0
	 */
	PARAMETERIZED_TYPE_INCORRECT_ARGUMENTS,

	/**
	 * @since 3.0
	 */
	PRIVATE_FUNCTION,
	/**
	 * @since 3.0
	 */
	WRONG_JAVA_PARAMETERS,
	/**
	 * @since 3.0
	 */
	UNDEFINED_JAVA_METHOD,
	/**
	 * @since 3.0
	 */
	DECLARATION_MISMATCH_ACTUAL_RETURN_TYPE, DECLARATION_MISMATCH_ACTUAL_RETURN_TYPE_PARAMETERIZATION,

	UNDEFINED_PROPERTY, DEPRECATED_PROPERTY,
	/**
	 * @since 3.0
	 */
	DEPRECATED_VARIABLE,
	/**
	 * @since 3.0
	 */
	PRIVATE_VARIABLE,
	/**
	 * @since 3.0
	 */
	HIDDEN_PROPERTY,
	/**
	 * @since 3.0
	 */
	UNDEFINED_JAVA_PROPERTY,
	/**
	 * @since 3.0
	 */
	REASSIGNMENT_OF_CONSTANT,
	/**
	 * @since 4.0
	 */
	PROPERTY_READONLY,
	/**
	 * @since 4.1
	 */
	UNASSIGNABLE_ELEMENT,
	/**
	 * @since 3.0
	 */
	PARAMETER_HIDES_VARIABLE(JSParserProblemGroup.DECLARATION_HIDES_OTHER),

	PARAMETER_HIDES_FUNCTION(JSParserProblemGroup.DECLARATION_HIDES_OTHER),
	/**
	 * @since 3.0
	 */
	DUPLICATE_VAR_DECLARATION(JSParserProblemGroup.DECLARATION_HIDES_OTHER),
	/**
	 * @since 3.0
	 */
	VAR_HIDES_PARAMETER(JSParserProblemGroup.DECLARATION_HIDES_OTHER),
	/**
	 * @since 3.0
	 */
	VAR_HIDES_PROPERTY(JSParserProblemGroup.DECLARATION_HIDES_OTHER),

	VAR_HIDES_METHOD(JSParserProblemGroup.DECLARATION_HIDES_OTHER),
	/**
	 * @since 3.0
	 */
	VAR_HIDES_FUNCTION(JSParserProblemGroup.DECLARATION_HIDES_OTHER),

	/**
	 * @since 5.0
	 */
	VAR_HIDES_PREDEFINED,

	EQUAL_AS_ASSIGN, INVALID_ASSIGN_LEFT,

	UNREACHABLE_CODE, RETURN_INCONSISTENT, FUNCTION_NOT_ALWAYS_RETURN_VALUE,

	CONTINUE_NON_LOOP_LABEL, BREAK_NON_LOOP_LABEL,
	/**
	 * @since 3.0
	 */
	BREAK_OUTSIDE_LABEL,
	/**
	 * @since 3.0
	 */
	CONTINUE_OUTSIDE_LABEL,

	DUPLICATE_PROPERTY_IN_LITERAL,

	UNUSED_VARIABLE,

	/**
	 * @since 3.0
	 */
	FUNCTION_HIDES_VARIABLE(JSParserProblemGroup.DECLARATION_HIDES_OTHER),

	FUNCTION_HIDES_FUNCTION(JSParserProblemGroup.DECLARATION_HIDES_OTHER),

	/**
	 * @since 5.0
	 */
	FUNCTION_HIDES_PREDEFINED,

	BIGINT_TYPE_ERROR;

	private JavaScriptProblems() {
		this(null);
	}

	private JavaScriptProblems(IProblemIdentifier primary) {
		this.primary = primary;
	}

	private final IProblemIdentifier primary;

	public IProblemIdentifier getPrimeIdentifier() {
		return primary;
	}

	public boolean belongsTo(IProblemCategory category) {
		return category == ProblemCategory.IMPORT && this == UNKNOWN_TYPE;
	}

	public String contributor() {
		return JavaScriptPlugin.PLUGIN_ID;
	}

}
