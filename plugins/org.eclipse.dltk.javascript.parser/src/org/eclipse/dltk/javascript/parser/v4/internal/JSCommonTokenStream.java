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
package org.eclipse.dltk.javascript.parser.v4.internal;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.eclipse.dltk.javascript.parser.v4.JSTokenSource;
import org.eclipse.dltk.javascript.parser.v4.JSTokenStream;
import org.eclipse.dltk.javascript.parser.v4.JavaScriptLexer;
import org.eclipse.dltk.javascript.parser.v4.Reporter;

public class JSCommonTokenStream extends CommonTokenStream implements
		JSTokenStream {

	public JSCommonTokenStream(JavaScriptLexer tokenSource) {
		super(tokenSource);
	}

	public int getMode() {
		return JSTokenSource.MODE_JS;
	}

	public void setMode(int value) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Token> getTokens() {
		return super.getTokens();
	}

	public void setReporter(Reporter reporter) {
		((JavaScriptLexer) tokenSource).setReporter(reporter);
	}

}