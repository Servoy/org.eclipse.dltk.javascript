/*******************************************************************************
 * Copyright (c) 2012 Servoy
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Servoy - initial API and Implementation (Johan Compagner)
 *******************************************************************************/
package org.eclipse.dltk.javascript.typeinfo;

import java.util.Set;

import org.eclipse.dltk.annotations.Nullable;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;

/**
 * @author jcompagner
 */
public interface IRLocalType
		extends IRType, IRTypeExtension, ImmutableType<IRLocalType> {
	public static final String PROTOTYPE_PROPERTY = "prototype";

	public IValueReference getValue();

	@Nullable
	public IValueReference getDirectChild(String name);

	public ReferenceLocation getReferenceLocation();

	public Set<String> getDirectChildren();

	/**
	 * If this type is an enum, then return the type of the enum values,
	 * otherwise null.
	 * 
	 * @return the type of the enum values, or null if this is not an enum
	 */
	public IRType getEnumValueType();

	/**
	 * If this type extends another type, then return the type it extends,
	 * otherwise null.
	 * 
	 * @return the type this type extends, or null if it does not extend any
	 *         type
	 */
	public IRType getExtendsType();

}
