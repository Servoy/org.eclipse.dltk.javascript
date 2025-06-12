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
package org.eclipse.dltk.javascript.typeinfo;

import java.util.List;
import java.util.Set;

import org.eclipse.dltk.annotations.ConfigurationElement;
import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.Method;
import org.eclipse.dltk.javascript.ast.VariableBinding;
import org.eclipse.dltk.javascript.parser.JSProblemReporter;
import org.eclipse.dltk.javascript.typeinference.ILocationProvider;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.dltk.javascript.typeinfo.model.Visibility;

@ConfigurationElement("builder")
public interface IModelBuilder {

	public interface IElement extends ILocationProvider {
		String getName();

		void setName(String name);

		JSType getType();

		void setType(JSType type);

		ReferenceLocation getLocation();

		void setLocation(ReferenceLocation location);

		Set<IProblemCategory> getSuppressedWarnings();

		void addSuppressedWarning(IProblemCategory warningCategoryId);
	}

	public interface IMember extends IElement {

		/**
		 * @since 3.0
		 */
		void setDeprecated(boolean deprecated);

		/**
		 * @since 3.0
		 */
		boolean isDeprecated();

		/**
		 * @since 4.0
		 */
		Visibility getVisibility();

		/**
		 * @since 4.0
		 */
		void setVisibility(Visibility visibility);

	}

	public interface IParameter extends IElement {

		/**
		 * @since 3.0
		 */
		boolean isOptional();

		/**
		 * @since 3.0
		 */
		boolean isVarargs();

		/**
		 * @since 5.0
		 */
		ParameterKind getKind();

		/**
		 * 
		 * @since 5.0
		 */
		void setKind(ParameterKind kind);

	}

	public interface IMethod extends IMember {

		int getParameterCount();

		/**
		 * Returns the list of this method parameters.
		 * 
		 * @return
		 */
		List<IParameter> getParameters();

		/**
		 * Factory method to create new parameter. The parameter is not added to
		 * the list of this method parameters.
		 * 
		 * @return
		 */
		IParameter createParameter();

		/**
		 * Finds the parameter with the specified name.
		 * 
		 * @param token
		 * @return the parameter found or <code>null</code>
		 */
		IParameter getParameter(String name);

		/**
		 * Is this a constructor method/function
		 */
		boolean isConstructor();

		/**
		 * Set to true if this method is meant to be a constructor (type)
		 */
		void setConstructor(boolean constructor);

		ISourceRange getDocRange();

		void setDocRange(ISourceRange docRange);

		/**
		 * Returns the type this function is supposed to have 'this' bound to
		 * during the invocation, <code>null</code> if not specified.
		 */
		JSType getThisType();

		/**
		 * Sets the type this function is supposed to have 'this' bound to
		 * during the invocation.
		 */
		void setThisType(JSType thisType);

		/**
		 * Returns the type this function that it extends
		 */
		JSType getExtendsType();

		/**
		 * Sets the type of this function that it extends
		 */
		void setExtendsType(JSType extendsType);
	}

	public interface IVariable extends IMember {

		JSType getTypeDef();

		void setTypeDef(JSType type);

	}

	/**
	 * Returns the unique identifier of the functionality, provided by this
	 * object. If some feature is provided by several objects, then the one
	 * having the maximal priority will be used.
	 * 
	 * @return
	 */
	String getFeatureId();

	/**
	 * Constant to be returned from {@link #priorityFor(ITypeInfoContext)} if
	 * this extension shouldn't be used
	 */
	int PRIORITY_UNSUPPORTED = -1;

	/**
	 * Constant to be returned from {@link #priorityFor(ITypeInfoContext)} as
	 * the default priorirt.
	 */
	int PRIORITY_DEFAULT = 0;

	int priorityFor(ITypeInfoContext context);

	void processMethod(FunctionStatement statement, IMethod method,
			JSProblemReporter reporter, ITypeChecker typeChecker);

	void processMethod(Method statement, IMethod method,
			JSProblemReporter reporter, ITypeChecker typeChecker);

	void processVariable(VariableBinding declaration, IVariable variabe,
			JSProblemReporter reporter, ITypeChecker typeChecker);

}
