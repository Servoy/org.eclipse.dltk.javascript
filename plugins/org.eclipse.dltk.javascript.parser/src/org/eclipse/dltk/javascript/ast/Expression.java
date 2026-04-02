/*******************************************************************************
 * Copyright (c) 2009 xored software, Inc.  
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html  
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Vladimir Belov)
 *******************************************************************************/

package org.eclipse.dltk.javascript.ast;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IProblemCategory;

public abstract class Expression extends JSNode implements ISourceable {

	public Expression(JSNode parent) {
		super(parent);
	}
	private Set<IProblemCategory> suppressedWarnings = null;

	public Set<IProblemCategory> getSuppressedWarnings() {
		return suppressedWarnings != null ? suppressedWarnings : Collections
				.<IProblemCategory> emptySet();
	}

	public void addSuppressedWarning(IProblemCategory warningCategoryId) {
		if (suppressedWarnings == null) {
			suppressedWarnings = new HashSet<IProblemCategory>();
		}
		suppressedWarnings.add(warningCategoryId);
	}
}
