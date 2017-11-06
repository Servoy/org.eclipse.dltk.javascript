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

import java.util.Collections;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.javascript.typeinfo.IRMember;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.RTypes;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.Visibility;

public class RMember<E extends Member> implements IRMember {
	protected final E member;
	private final RTypeDeclaration typeDeclaration;
	private IRType type;
	private boolean initialized;

	public RMember(E member, IRTypeDeclaration typeDeclaration) {
		assert typeDeclaration != null;
		this.member = member;
		this.typeDeclaration = (RTypeDeclaration) typeDeclaration;
	}

	public RMember(E member, IRType type, IRTypeDeclaration typeDeclaration) {
		this.member = member;
		this.typeDeclaration = (RTypeDeclaration) typeDeclaration;
		this.type = type;
		this.initialized = true;
	}

	protected synchronized final void checkInitialized() {
		if (!initialized) {
			initialize(typeDeclaration.getEffectiveTypeSystem());
			initialized = true;
		}
	}

	protected void initialize(ITypeSystem typeSystem) {
		type = RTypes.create(typeSystem, member.getType());
	}

	public String getName() {
		return member.getName();
	}

	public Visibility getVisibility() {
		return member.getVisibility();
	}

	public IRTypeDeclaration getDeclaringType() {
		return typeDeclaration;
	}

	public Set<IProblemCategory> getSuppressedWarnings() {
		return Collections.emptySet();
	}

	public boolean isSuppressed(IProblemIdentifier problemIdentifier) {
		return false;
	}

	public boolean isDeprecated() {
		return member.isDeprecated();
	}

	public Object getSource() {
		return member;
	}

	public IRType getType() {
		checkInitialized();
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + member.hashCode();
		result = prime * result;
		if (typeDeclaration != null)
			result += typeDeclaration.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final RMember<?> other = (RMember<?>) obj;
		return member.equals(other.member)
				&& typeDeclaration.equals(other.typeDeclaration);
	}

	@Override
	public String toString() {
		return getName();
	}

	public boolean isStatic() {
		return member.isStatic();
	}

	public boolean isVisible() {
		return member.isVisible();
	}

}
