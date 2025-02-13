/*******************************************************************************
 * Copyright (c) 2010 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.internal.javascript.ti;

import org.eclipse.dltk.javascript.typeinference.IValueReference;

public class AnonymousValue extends AbstractReference {

	private final IValue value;

	public AnonymousValue(IValue value) {
		this.value = value;
	}

	public AnonymousValue() {
		this(new Value());
	}

	public boolean isReference() {
		return false;
	}

	@Override
	public IValue getValue() {
		return value;
	}

	@Override
	public IValue createValue() {
		return getValue();
	}

	public void delete(boolean force) {
	}

	public String getName() {
		return "";
	}

	public IValueReference getParent() {
		return null;
	}

	protected String getToStringPrefix() {
		return "AnonymousValue";
	}

	@Override
	public String toString() {
		return getToStringPrefix() + "@" + System.identityHashCode(value);
	}

}
