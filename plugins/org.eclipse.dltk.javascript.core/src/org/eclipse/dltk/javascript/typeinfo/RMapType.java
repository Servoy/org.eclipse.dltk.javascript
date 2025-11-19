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
package org.eclipse.dltk.javascript.typeinfo;

import java.util.Map;

class RMapType extends RType implements IRMapType {

	private final IRType valueType;
	private final IRType keyType;
	private final IRTypeDeclaration declaration;

	public RMapType(IRType keyType, IRType valueType,
			IRTypeDeclaration declaration) {
		this.keyType = keyType;
		this.valueType = valueType;
		this.declaration = declaration;
	}

	public String getName() {
		// if the key type is set but it is a String then just default to
		// without it.
		if (valueType != null && keyType != null) {
			return ITypeNames.MAP + '<' + keyType.getName() + ','
					+ valueType.getName() + '>';
		}
		return valueType != null ? ITypeNames.SET + '<'
				+ valueType.getName() + '>' : ITypeNames.OBJECT;
	}

	@Override
	public int hashCode() {
		return valueType.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RMapType) {
			final RMapType other = (RMapType) obj;
			return valueType.equals(other.valueType);
		}
		return false;
	}

	@Override
	public boolean isExtensible() {
		return true;
	}

	@Override
	public TypeCompatibility isAssignableFrom(IRType type) {
		if (super.isAssignableFrom(type).ok()) {
			return TypeCompatibility.TRUE;
		}
		if (type instanceof RMapType) {
			return valueType.isAssignableFrom(((RMapType) type).valueType);
		} else if (type instanceof IRRecordType) {
			TypeCompatibility result = TypeCompatibility.TRUE;
			for (IRRecordMember member : ((IRRecordType) type).getMembers()) {
				final TypeCompatibility compatibility = valueType
						.isAssignableFrom(member.getType());
				if (compatibility == TypeCompatibility.FALSE) {
					return compatibility;
				} else if (compatibility != result
						&& compatibility.after(result)) {
					result = compatibility;
				}
			}
			return result;
		}
		return TypeCompatibility.FALSE;
	}

	public IRType getKeyType() {
		return keyType;
	}

	public IRType getValueType() {
		return valueType;
	}

	@Override
	public IRMapType makeImmutable(Map<Object, Object> visited) {
		if (keyType instanceof ImmutableType<?> || valueType instanceof ImmutableType<?>) {
			IRType copyKey = keyType;
			if (keyType instanceof ImmutableType<?> im) {
				copyKey = (IRType) im.makeImmutable(visited);
			}
			IRType copyValue = valueType;
			if (valueType instanceof ImmutableType<?> im) {
				copyValue = (IRType) im.makeImmutable(visited);
			}
			
			if (copyKey != keyType || copyValue != valueType)
				return new RMapType(copyKey, copyValue, declaration);
		}
		return this;
	}

	@Override
	public IRTypeDeclaration getDeclaration() {
		return declaration;
	}
}
