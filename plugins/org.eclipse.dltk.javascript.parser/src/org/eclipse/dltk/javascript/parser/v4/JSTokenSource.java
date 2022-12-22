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
package org.eclipse.dltk.javascript.parser.v4;

import org.antlr.v4.runtime.TokenSource;

public interface JSTokenSource extends TokenSource {

	int MODE_JS = 0;
	int MODE_XML = 1;
	int MODE_EXPRESSION = 2;

	int getMode();

	void setMode(int mode);

	/**
	 * Set the input cursor to the character position indicated by index.
	 **/
	void seek(int index);
}
