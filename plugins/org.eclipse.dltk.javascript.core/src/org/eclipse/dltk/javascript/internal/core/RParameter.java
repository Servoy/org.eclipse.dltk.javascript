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

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.javascript.typeinfo.IRParameter;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.ImmutableType;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;

public class RParameter implements IRParameter {

	private final String name;
	private final IRType type;
	private final ParameterKind kind;

	public RParameter(String name, IRType type, ParameterKind kind) {
		Assert.isNotNull(type);
		this.name = name;
		this.type = type;
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public IRType getType() {
		return type;
	}

	public ParameterKind getKind() {
		return kind;
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RParameter) {
			final RParameter other = (RParameter) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (!type.equals(other.type))
				return false;
			if (kind != other.kind)
				return false;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return name + ":" + type;
	}

	public boolean isOptional() {
		return kind == ParameterKind.OPTIONAL;
	}

	public boolean isVarargs() {
		return kind == ParameterKind.VARARGS;
	}

	@Override
	public IRParameter makeImmutable(Map<Object, Object> visited) {
		if (type instanceof ImmutableType<?> local) {
			return new RParameter(name, (IRType) local.makeImmutable(visited),
					kind);
		}
		return this;
	}

}
