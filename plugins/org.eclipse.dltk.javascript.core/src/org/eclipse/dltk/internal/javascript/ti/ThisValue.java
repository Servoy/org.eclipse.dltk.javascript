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
package org.eclipse.dltk.internal.javascript.ti;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.javascript.ast.Keywords;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinfo.IRType;

/**
 * Value representing "this" in function bodies.
 */
public class ThisValue extends AnonymousReferenceValue {

	public ThisValue() {
		getValue().setAttribute(IReferenceAttributes.THIS_VALUE, Boolean.TRUE);
	}

	@Override
	protected String getToStringPrefix() {
		final IRType declaredType = getDeclaredType();
		return Keywords.THIS
				+ (declaredType != null ? "(" + declaredType + ")" : "");
	}

	@Override
	public ReferenceKind getKind() {
		return ReferenceKind.THIS;
	}

	@Override
	public void setKind(ReferenceKind kind) {
		Assert.isLegal(kind == ReferenceKind.THIS);
	}
}
