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

import org.eclipse.dltk.internal.javascript.ti.ReferenceLocation;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.typeinfo.model.Type;

public interface IModelBuilder {

	public interface IParameter {
		String getName();

		void setName(String name);

		Type getType();

		void setType(Type type);

		ReferenceLocation getLocation();

		void setLocation(ReferenceLocation location);
	}

	public interface IMethod {
		String getName();

		void setName(String name);

		Type getType();

		void setType(Type type);

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
	}

	void processMethod(ITypeInfoContext context, FunctionStatement statement,
			IMethod method);

}
