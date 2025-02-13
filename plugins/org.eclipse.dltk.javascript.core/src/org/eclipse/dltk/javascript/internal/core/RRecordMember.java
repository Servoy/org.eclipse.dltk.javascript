/*******************************************************************************
 * Copyright (c) 2011,2012 NumberFour AG
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

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IMember;
import org.eclipse.dltk.javascript.typeinfo.IRRecordMember;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.ImmutableType;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.RecordMember;
import org.eclipse.dltk.javascript.typeinfo.model.Visibility;

public class RRecordMember implements IRRecordMember {

	private final String name;
	private final IRType type;
	private final Object source;

	public RRecordMember(String name, IRType type, Object member) {
		this.name = name;
		this.type = type;
		this.source = member;
	}

	public String getName() {
		return name;
	}

	public IRType getType() {
		return type;
	}

	public boolean isOptional() {
		return source instanceof RecordMember
				&& ((RecordMember) source).isOptional();
	}

	@Override
	public String toString() {
		return name + ":" + type + (isOptional() ? "=" : "");
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RRecordMember) {
			final RRecordMember other = (RRecordMember) obj;
			return name.equals(other.name) && type.equals(other.type);
		}
		return false;
	}

	public Visibility getVisibility() {
		if (source instanceof IMember)
			return ((IMember) source).getVisibility();
		return Visibility.PUBLIC;
	}

	public IRTypeDeclaration getDeclaringType() {
		return null;
	}

	public boolean isStatic() {
		return false;
	}

	public boolean isVisible() {
		return true;
	}

	public Set<IProblemCategory> getSuppressedWarnings() {
		return Collections.emptySet();
	}

	public boolean isSuppressed(IProblemIdentifier problemIdentifier) {
		return false;
	}

	public boolean isDeprecated() {
		return source instanceof IMember && ((IMember) source).isDeprecated()
				|| source instanceof Member && ((Member) source).isDeprecated();
	}

	public Object getSource() {
		return source;
	}

	@Override
	public IRRecordMember makeImmutable(Map<Object, Object> visited) {
		if (type instanceof ImmutableType<?> t) {
			return new RRecordMember(name, (IRType) t.makeImmutable(visited),
					source);
		}
		return this;
	}
}
