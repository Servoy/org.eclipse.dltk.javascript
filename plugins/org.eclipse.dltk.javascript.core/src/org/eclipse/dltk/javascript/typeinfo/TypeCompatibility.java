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
package org.eclipse.dltk.javascript.typeinfo;

import org.eclipse.dltk.compiler.problem.IValidationStatus;

public enum TypeCompatibility implements IValidationStatus {
	TRUE, UNPARAMETERIZED, FALSE, ANY;

	public boolean ok() {
		return this == TRUE;
	}

	public static TypeCompatibility valueOf(boolean value) {
		return value ? TRUE : FALSE;
	}

	public boolean after(TypeCompatibility value) {
		return ordinal() > value.ordinal();
	}
}
