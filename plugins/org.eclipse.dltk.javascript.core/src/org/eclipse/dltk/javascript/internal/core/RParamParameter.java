/*******************************************************************************
 * Copyright (c) 2012 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.internal.core;

import java.util.Map;

import org.eclipse.dltk.javascript.typeinfo.IRParameter;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.ImmutableType;
import org.eclipse.dltk.javascript.typeinfo.model.Parameter;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;

public class RParamParameter implements IRParameter {

	private final IRType type;
	private final Parameter parameter;

	public RParamParameter(Parameter parameter, IRType type) {
		this.parameter = parameter;
		this.type = type;
	}

	public String getName() {
		return parameter.getName();
	}

	@Override
	public String getDescription() {
		return parameter.getDescription();
	}

	public IRType getType() {
		return type;
	}

	public ParameterKind getKind() {
		return parameter.getKind();
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RParamParameter param) {
			if (!parameter.equals(param.parameter))
				return false;
			if (!type.equals(param.type))
				return false;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return getName() + ":" + type;
	}

	public boolean isOptional() {
		return getKind() == ParameterKind.OPTIONAL;
	}

	public boolean isVarargs() {
		return getKind() == ParameterKind.VARARGS;
	}

	@Override
	public IRParameter makeImmutable(Map<Object, Object> visited) {
		if (type instanceof ImmutableType<?> local) {
			return new RParamParameter(parameter,
					(IRType) local.makeImmutable(visited));
		}
		return this;
	}

}
