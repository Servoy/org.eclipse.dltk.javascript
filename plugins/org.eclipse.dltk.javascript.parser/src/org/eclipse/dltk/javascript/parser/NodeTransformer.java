/*******************************************************************************
 * Copyright (c) 2011 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.parser;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.javascript.ast.JSNode;

/**
 * @since 6.0
 */
public interface NodeTransformer {

	public interface Factory {

		NodeTransformer create(IModelElement element, JSProblemReporter reporter);

	}

	ASTNode transform(ASTNode node, JSNode parent);

}
