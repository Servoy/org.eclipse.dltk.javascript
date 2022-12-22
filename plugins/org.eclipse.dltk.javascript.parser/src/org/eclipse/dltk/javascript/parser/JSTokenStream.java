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
package org.eclipse.dltk.javascript.parser;

import java.util.List;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

/**
 * @since 6.0
 */
public interface JSTokenStream extends TokenStream {

	List<Token> getTokens();

	int getMode();

	void setMode(int value);

	void setReporter(Reporter reporter);

}
