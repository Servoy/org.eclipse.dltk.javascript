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
package org.eclipse.dltk.javascript.core;

import org.eclipse.dltk.core.keyword.IKeywordCategory;

/**
 * JavaScript keyword categories.
 * 
 * @since 3.0
 */
public enum JSKeywordCategory implements IKeywordCategory {
	/**
	 * code keyword category
	 */
	CODE,

	/**
	 * JSDoc tag category
	 */
	JS_DOC_TAG
}
