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

import java.util.Collections;

import org.eclipse.dltk.javascript.core.Types;
import org.eclipse.dltk.javascript.typeinfo.model.Type;

class RArrayType extends RType implements IRArrayType {

	private final IRType itemType;
	private final IRTypeDeclaration declaration;

	public RArrayType(ITypeSystem typeSystem, IRType itemType) {
		this.itemType = itemType;
		this.declaration = typeSystem.parameterize(Types.ARRAY,
				Collections.singletonList(itemType));
	}

	public Type getTarget() {
		return Types.ARRAY;
	}

	public IRTypeDeclaration getDeclaration() {
		return declaration;
	}

	public String getName() {
		return itemType != null
				? ITypeNames.ARRAY + '<' + itemType.getName() + '>'
				: ITypeNames.ARRAY;
	}

	public IRType getItemType() {
		return itemType;
	}

	@Override
	public int hashCode() {
		return itemType.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RArrayType) {
			final RArrayType other = (RArrayType) obj;
			return itemType.equals(other.itemType);
		}
		return false;
	}

	@Override
	public TypeCompatibility isAssignableFrom(IRType type) {
		if (super.isAssignableFrom(type).ok()) {
			return TypeCompatibility.TRUE;
		}
		if (type instanceof RArrayType) {
			final IRType ortherItem = ((RArrayType) type).itemType;
			if (ortherItem == RTypes.EMPTY_ARRAY_ITEM_TYPE) {
				return TypeCompatibility.TRUE;
			}
			final TypeCompatibility compatibility = itemType
					.isAssignableFrom(ortherItem);
			return compatibility == TypeCompatibility.TRUE ? compatibility
					: TypeCompatibility.UNPARAMETERIZED;
		} else {
			return TypeCompatibility.FALSE;
		}
	}

	@Override
	public IRType transform(IRTypeTransformer function) {
		final IRType value = function.transform(itemType);
		if (value != itemType) {
			return new RArrayType(declaration.getTypeSystem(), value);
		} else {
			return this;
		}
	}

}
