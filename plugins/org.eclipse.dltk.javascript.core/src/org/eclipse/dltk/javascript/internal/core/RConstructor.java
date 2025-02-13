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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.dltk.javascript.typeinfo.IRConstructor;
import org.eclipse.dltk.javascript.typeinfo.IRParameter;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.ImmutableType;
import org.eclipse.dltk.javascript.typeinfo.model.Method;

public class RConstructor extends RMethod implements IRConstructor {

	public RConstructor(Method method, IRTypeDeclaration typeDeclaration) {
		super(method, typeDeclaration);
	}

	public RConstructor(Method method, IRType type,
			List<IRParameter> parameters, IRTypeDeclaration typeDeclaration) {
		super(method, type, parameters, typeDeclaration);
	}

	public RConstructor makeImmutable(Map<Object, Object> visited) {
		IRType type = getType();
		if (type instanceof ImmutableType<?> local) {
			type = (IRType) local.makeImmutable(visited);
		}
		List<IRParameter> params = parameters;
		if (parameters != null) {
			params = new ArrayList<>();
			for (IRParameter param : parameters) {
				params.add(param.makeImmutable(visited));
			}
		}
		IRTypeDeclaration declaringType = getDeclaringType();

		if (declaringType instanceof ImmutableType<?> im) {
			declaringType = (IRTypeDeclaration) im.makeImmutable(visited);
		}
		return new RConstructor(member, type, params, declaringType);
	}

}
