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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.dltk.annotations.NonNull;
import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.javascript.typeinfo.IRConstructor;
import org.eclipse.dltk.javascript.typeinfo.IRMember;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRProperty;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.TypeCompatibility;
import org.eclipse.dltk.javascript.typeinfo.model.GenericType;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;

public class RTypeDeclaration implements IRTypeDeclaration {

	@NonNull
	protected final ITypeSystem typeSystem;
	@NonNull
	protected final Type type;
	protected RTypeDeclaration superType;
	protected List<RTypeDeclaration> traits;
	protected List<IRMember> members;
	protected List<IRConstructor> constructors;
	protected IRConstructor staticConstructor;

	public RTypeDeclaration(ITypeSystem typeSystem, Type type) {
		this.typeSystem = typeSystem;
		this.type = type;
	}

	protected ITypeSystem getEffectiveTypeSystem() {
		return typeSystem;
	}

	public String getName() {
		return type.getName();
	}

	public Set<IProblemCategory> getSuppressedWarnings() {
		return Collections.emptySet();
	}

	public boolean isSuppressed(IProblemIdentifier problemIdentifier) {
		return false;
	}

	public boolean isDeprecated() {
		return type.isDeprecated();
	}

	public ITypeSystem getTypeSystem() {
		return typeSystem;
	}

	public Type getSource() {
		return type;
	}

	public IRTypeDeclaration getSuperType() {
		return superType;
	}

	@SuppressWarnings("unchecked")
	public List<IRTypeDeclaration> getTraits() {
		return (List<IRTypeDeclaration>) (List<?>) traits;
	}

	public List<IRMember> getMembers() {
		return members;
	}

	@Override
	public int hashCode() {
		return type.hashCode();
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
		final RTypeDeclaration other = (RTypeDeclaration) obj;
		return type.equals(other.type);
	}

	@Override
	public String toString() {
		return getName();
	}

	public void setMembers(List<IRMember> members) {
		this.members = members;
	}

	public void setSuperType(RTypeDeclaration superType) {
		this.superType = superType;
	}

	public void setTraits(List<RTypeDeclaration> traits) {
		this.traits = traits;
	}

	public TypeKind getKind() {
		return type.getKind();
	}

	public boolean isInheritStaticMembers() {
		return type.isInheritStaticMembers();
	}

	public Object getReadOnlyStatus(IRProperty property) {
		return type.getReadOnlyStatus(property.getSource());
	}

	public boolean isGeneric() {
		return type instanceof GenericType;
	}

	public boolean isParameterized() {
		return false;
	}

	public List<IRType> getActualTypeArguments() {
		return Collections.emptyList();
	}

	public List<IRConstructor> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<IRConstructor> constructors) {
		this.constructors = constructors;
	}

	public IRConstructor getStaticConstructor() {
		return staticConstructor;
	}

	public void setStaticConstructor(IRConstructor staticConstructor) {
		this.staticConstructor = staticConstructor;
	}

	public TypeCompatibility isAssignableFrom(IRTypeDeclaration declaration) {
		final TypeCompatibility result = isAssignableFrom(this,
				(RTypeDeclaration) declaration, new HashSet<RTypeDeclaration>());
		return result != null ? result : TypeCompatibility.FALSE;
	}

	/*
	 * overridden in RParameterizedTypeDeclaration
	 */
	protected boolean _equals(RTypeDeclaration other) {
		return this.equals(other)
				|| type.equals(other.type)
				|| ((type.getKind() == TypeKind.UNKNOWN || other.type.getKind() == TypeKind.UNKNOWN) && type
						.getName().equals(other.type.getName()));
	}

	private static TypeCompatibility isAssignableFrom(RTypeDeclaration self,
			RTypeDeclaration current, Set<RTypeDeclaration> visited) {
		if (visited.add(current)) {
			if (self._equals(current)) {
				return TypeCompatibility.TRUE;
			}
			final RTypeDeclaration superType = current.superType;
			if (superType != null) {
				final TypeCompatibility result = isAssignableFrom(self,
						superType, visited);
				if (result != null) {
					return result;
				}
			}
			for (RTypeDeclaration trait : current.traits) {
				final TypeCompatibility result = isAssignableFrom(self, trait,
						visited);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}

	public IRMethod findMethod(String name, boolean isStatic) {
		for (IRMember member : members) {
			if (member instanceof IRMethod && name.equals(member.getName())
					&& isStatic == member.isStatic()) {
				return (IRMethod) member;
			}
		}
		return null;
	}
}
