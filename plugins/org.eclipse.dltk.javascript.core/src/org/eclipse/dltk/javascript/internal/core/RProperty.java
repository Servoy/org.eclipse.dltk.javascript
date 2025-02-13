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

import org.eclipse.dltk.javascript.typeinfo.IRProperty;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.IRVariable;
import org.eclipse.dltk.javascript.typeinfo.ImmutableType;
import org.eclipse.dltk.javascript.typeinfo.model.Property;

public class RProperty extends RMember<Property> implements IRProperty {

	public RProperty(Property member, IRTypeDeclaration typeDeclaration) {
		super(member, typeDeclaration);
	}

	public RProperty(Property member, IRType type,
			IRTypeDeclaration typeDeclaration) {
		super(member, type, typeDeclaration);
	}

	public boolean isReadOnly() {
		return member.isReadOnly();
	}

	@Override
	public Property getSource() {
		return member;
	}

	@Override
	public IRVariable makeImmutable(Map<Object, Object> visited) {
		IRType type = getType();
		IRTypeDeclaration declaringType = getDeclaringType();
		if (declaringType instanceof ImmutableType<?>
				|| type instanceof ImmutableType<?>) {
			if (type instanceof ImmutableType<?> local) {
				type = (IRType) local.makeImmutable(visited);
			}
			if (declaringType instanceof ImmutableType<?> local) {
				declaringType = (IRTypeDeclaration) local
						.makeImmutable(visited);
			}
			return new RProperty(member, type, declaringType);
		}
		return this;
	}

}
