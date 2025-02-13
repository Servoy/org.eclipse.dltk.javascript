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
package org.eclipse.dltk.javascript.typeinfo;

import java.util.List;

public interface IRFunctionType extends IRType, ImmutableType<IRFunctionType> {

	/**
	 * Returns the type system this instance was created by.
	 */
	ITypeSystem getTypeSystem();

	IRType getReturnType();

	List<IRParameter> getParameters();

}
