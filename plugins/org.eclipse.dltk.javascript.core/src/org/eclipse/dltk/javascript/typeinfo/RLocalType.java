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

import org.eclipse.dltk.compiler.problem.IValidationStatus;
import org.eclipse.dltk.internal.javascript.ti.ChildReference;
import org.eclipse.dltk.internal.javascript.ti.IReferenceAttributes;
import org.eclipse.dltk.internal.javascript.ti.IValueProvider;
import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;

/**
 * @author jcompagner
 */
class RLocalType extends RType implements IRLocalType {

	private final IValueReference functionValue;
	private final String name;

	RLocalType(ITypeSystem typeSystem, String name,
			IValueReference functionValue) {
		super(typeSystem);
		this.name = name;
		this.functionValue = functionValue;
	}

	public IValueReference getValue() {
		IValueCollection value = (IValueCollection) functionValue.getAttribute(
				IReferenceAttributes.FUNCTION_SCOPE, false);
		if (value != null) {
			return value.getThis();
		}
		// back up shouldn't happen
		return new ChildReference((IValueProvider) functionValue, name);
	}

	public ReferenceLocation getReferenceLocation() {
		return functionValue.getLocation();
	}

	@Override
	public TypeCompatibility isAssignableFrom(IRType type) {
		if (type instanceof IRLocalType) {
			if (getReferenceLocation().equals(
					((IRLocalType) type).getReferenceLocation())) {
				return TypeCompatibility.TRUE;
			}
		}
		return super.isAssignableFrom(type);
	}

	public IValidationStatus isAssignableFrom(IValueReference argument) {
		Set<IRType> types = JavaScriptValidations.getTypes(argument);
		for (IRType irType : types) {
			if (irType instanceof IRLocalType) {
				if (getReferenceLocation().equals(
						((IRLocalType) irType)
						.getReferenceLocation())) {
					return TypeCompatibility.TRUE;
				}
			}
		}
		return TypeCompatibility.FALSE;
	}

	public String getName() {
		return name;
	}

}
