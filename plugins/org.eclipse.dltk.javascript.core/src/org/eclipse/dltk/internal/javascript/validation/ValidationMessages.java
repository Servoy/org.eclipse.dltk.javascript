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
package org.eclipse.dltk.internal.javascript.validation;

import org.eclipse.osgi.util.NLS;

public class ValidationMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.dltk.internal.javascript.validation.ValidationMessages"; //$NON-NLS-1$
	public static String UnknownType;
	public static String UndefinedJavascriptType;
	public static String DeprecatedType;

	public static String UndefinedMethodInScript;
	public static String WrongFunction;
	public static String WrongFunctionExpression;
	public static String UndefinedMethod;
	public static String UndefinedMethodOnObject;
	public static String MethodNotSelected;
	public static String MethodNotApplicable;
	public static String TopLevelMethodNotApplicable;
	public static String MethodNotApplicableInScript;
	public static String DeprecatedMethod;
	public static String DeprecatedTopLevelMethod;
	public static String DeprecatedFunction;
	public static String PrivateFunction;

	public static String UndefinedProperty;
	public static String UndefinedPropertyInScriptType;
	public static String UndefinedPropertyInScript;
	public static String DeprecatedProperty;
	public static String DeprecatedPropertyOfInstance;
	public static String DeprecatedPropertyNoType;
	public static String DeprecatedVariable;
	public static String PrivateVariable;
	public static String HiddenProperty;
	public static String HiddenPropertyOfInstance;
	public static String HiddenPropertyNoType;
	public static String ReassignmentOfConstant;
	public static String AssignmentToReadonlyProperty;
	public static String DeclarationMismatchWithActualReturnType;
	public static String DeclarationMismatchNoReturnType;
	public static String ParameterHidesVariable;
	public static String ParameterHidesFunction;
	public static String ParameterHidesProperty;
	public static String ParameterHidesPropertyOfType;
	public static String VariableHidesVariable;
	public static String VariableHidesParameter;
	public static String VariableHidesPropertyOfType;
	public static String VariableHidesProperty;
	public static String VariableHidesMethodOfType;
	public static String VariableHidesMethod;
	public static String VariableHidesFunction;
	public static String VariableHidesPredefinedIdentifier;
	public static String UndeclaredVariable;
	public static String FunctionHidesPropertyOfType;
	public static String FunctionHidesProperty;
	public static String FunctionHidesVariable;
	public static String FunctionHidesFunction;
	public static String FunctionHidesPredefinedIdentifier;
	public static String ReturnTypeInconsistentWithPreviousReturn;
	public static String NonInstantiableType;

	public static String InaccessibleMember;
	public static String InaccessibleType;
	public static String UnassignableMethod;
	public static String UnassignableClass;
	public static String UnassignableFunction;

	public static String NotGenericType;
	public static String IncorrectNumberOfTypeArguments;
	public static String ParameterizedBoundMismatch;

	public static String MixBigInt;
	public static String BigIntNotConstructor;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, ValidationMessages.class);
	}

	private ValidationMessages() {
	}
}
