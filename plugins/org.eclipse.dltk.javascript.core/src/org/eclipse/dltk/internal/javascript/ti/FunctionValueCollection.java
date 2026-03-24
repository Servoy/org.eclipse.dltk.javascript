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

import org.eclipse.dltk.javascript.typeinference.IFunctionValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinfo.RTypes;

public class FunctionValueCollection extends ValueCollection implements
		IFunctionValueCollection {

	private final String functionName;

	public FunctionValueCollection(IValueCollection parent, String functionName) {
		this(parent, functionName, false);
	}

	public FunctionValueCollection(IValueCollection parent,
			String functionName, boolean block) {
		this(parent, functionName, new ThisValue(), block);
	}

	public FunctionValueCollection(IValueCollection parent,
			String functionName, IValueReference thisValue, boolean block) {
		super(parent);
		this.functionName = functionName;
		this.thisValue = thisValue;
		this.block = block;
		IValueReference arguments = createChild("arguments");
		arguments.setKind(ReferenceKind.LOCAL);
		arguments.setDeclaredType(RTypes.arrayOf());
		IValueReference argumentsLength = arguments.getChild("length");
		argumentsLength.setDeclaredType(RTypes.NUMBER);
		IValueReference argumentsArray = arguments
				.getChild(IValueReference.ARRAY_OP);
		argumentsArray.setDeclaredType(RTypes.OBJECT);
	}

	private final boolean block;

	public boolean isInlineBlock() {
		return block;
	}

	public String getFunctionName() {
		return functionName;
	}

	public boolean isScope() {
		return true;
	}

	private final IValueReference returnValue = new AnonymousValue();

	@Override
	public IValueReference getReturnValue() {
		return returnValue;
	}

	private final IValueReference thisValue;

	@Override
	public IValueReference getThis() {
		return thisValue;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "<" + functionName + ">";
	}

}
