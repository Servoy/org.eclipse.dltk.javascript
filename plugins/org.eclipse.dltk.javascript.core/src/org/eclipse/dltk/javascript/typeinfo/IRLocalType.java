/*******************************************************************************
 * Copyright (c) 2012 Servoy
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Servoy - initial API and Implementation (Johan Compagner)
 *******************************************************************************/
package org.eclipse.dltk.javascript.typeinfo;

import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;

/**
 * @author jcompagner
 */
public interface IRLocalType extends IRType, IRTypeExtension {
	public IValueReference getValue();

	public ReferenceLocation getReferenceLocation();
}
