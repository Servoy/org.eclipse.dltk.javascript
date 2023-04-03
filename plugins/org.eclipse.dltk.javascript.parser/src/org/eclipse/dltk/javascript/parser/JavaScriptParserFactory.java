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

import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.ast.parser.ISourceParserFactory;

public class JavaScriptParserFactory implements ISourceParserFactory {

	public ISourceParser createSourceParser() {
		boolean antlr4Parser = new JavascriptParserPreferences().useES6Parser();
		return antlr4Parser ? new org.eclipse.dltk.javascript.parser.v4.JavaScriptParser() : new JavaScriptParser();
	}

}
