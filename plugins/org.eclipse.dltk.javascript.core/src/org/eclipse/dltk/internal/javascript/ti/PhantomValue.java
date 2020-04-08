/*******************************************************************************
 * Copyright (c) 2011 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.internal.javascript.ti;

import java.util.Collections;
import java.util.Set;

import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.JSTypeSet;

public enum PhantomValue implements IValue {
	VALUE;

	public boolean hasChild(String name) {
		return false;
	}

	public Set<String> getDirectChildren(int flags) {
		return Collections.emptySet();
	}

	public IValue getChild(String name, boolean resolve) {
		return this;
	}

	public IValue createChild(String name, int flags) {
		return this;
	}

	public IRType getDeclaredType() {
		return null;
	}

	public void setDeclaredType(IRType declaredType) {
	}

	public void addType(IRType type) {
	}

	public JSTypeSet getDeclaredTypes() {
		return JSTypeSet.emptySet();
	}

	public JSTypeSet getTypes() {
		return JSTypeSet.emptySet();
	}

	public Object getAttribute(String key, boolean includeReferences) {
		if (key == IReferenceAttributes.PHANTOM) {
			return Boolean.TRUE;
		}
		return null;
	}

	public Object getAttribute(String key) {
		return null;
	}

	public void setAttribute(String key, Object value) {
	}

	public ReferenceKind getKind() {
		return ReferenceKind.PREDEFINED;
	}

	public void setKind(ReferenceKind kind) {
	}

	public ReferenceLocation getLocation() {
		return ReferenceLocation.UNKNOWN;
	}

	public void setLocation(ReferenceLocation location) {
	}

	public void addValue(IValue src) {
	}

	public void mergeValue(IValue src) {
	}

	public void addReference(IValue src) {
	}

	public void removeReference(IValue value) {
	}

	public void clear() {
	}

	public void putChild(String name, IValue value) {
	}

	public Set<String> getDeletedChildren() {
		return Collections.emptySet();
	}

	public void deleteChild(String name, boolean force) {
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

}
