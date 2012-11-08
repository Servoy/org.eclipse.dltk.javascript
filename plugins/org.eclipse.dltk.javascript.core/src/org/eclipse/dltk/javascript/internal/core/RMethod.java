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

import java.util.List;

import org.eclipse.dltk.internal.javascript.ti.TypeSystemImpl;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRParameter;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.RTypes;
import org.eclipse.dltk.javascript.typeinfo.model.GenericMethod;
import org.eclipse.dltk.javascript.typeinfo.model.Method;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;

public class RMethod extends RMember<Method> implements IRMethod {

	private List<IRParameter> parameters;

	public RMethod(Method method, IRType type, List<IRParameter> parameters,
			IRTypeDeclaration typeDeclaration) {
		super(method, type, typeDeclaration);
		this.parameters = parameters;
	}

	public RMethod(Method method, IRTypeDeclaration typeDeclaration) {
		super(method, typeDeclaration);
	}

	@Override
	protected void initialize() {
		super.initialize();
		parameters = TypeSystemImpl.convertParameters(getDeclaringType()
				.getTypeSystem(), member.getParameters());
	}

	public int getParameterCount() {
		checkInitialized();
		return parameters.size();
	}

	public List<IRParameter> getParameters() {
		checkInitialized();
		return parameters;
	}

	public boolean isTyped() {
		if (getType() != null) { // checkInitialized() is called there
			return true;
		}
		for (int i = 0; i < parameters.size(); ++i) {
			final IRParameter parameter = parameters.get(i);
			if (parameter.getType() != RTypes.any()
					|| parameter.getKind() != ParameterKind.NORMAL) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		checkInitialized();
		final StringBuilder sb = new StringBuilder();
		sb.append(getName()).append('(');
		for (int i = 0; i < getParameterCount(); ++i) {
			if (i != 0) {
				sb.append(',');
			}
			sb.append(parameters.get(i).toString());
		}
		sb.append(')');
		return sb.toString();
	}

	public boolean isAbstract() {
		return member.isAbstract();
	}

	public boolean isGeneric() {
		return member instanceof GenericMethod;
	}
}
