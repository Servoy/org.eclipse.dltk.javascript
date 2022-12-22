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

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

public interface JSTokenStream extends TokenStream {

	List<Token> getTokens();

	int getMode();

	void setMode(int value);

	//TODO error reporting is done differently in v4
	//void setReporter(Reporter reporter);
}
