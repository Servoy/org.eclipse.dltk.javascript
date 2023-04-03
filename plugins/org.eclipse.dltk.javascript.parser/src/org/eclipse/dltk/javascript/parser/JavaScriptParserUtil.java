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

import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.SourceParserUtil;
import org.eclipse.dltk.javascript.ast.Script;

public class JavaScriptParserUtil {

	/**
	 * The name of the attribute referencing {@link ISourceModule} from
	 * {@link Script} attributes.
	 */
	public static final String ATTR_MODULE = ISourceModule.class.getName();

	public static Script parse(ISourceModule module) {
		return parse(module, null);
	}

	public static Script parse(ISourceModule module, IProblemReporter reporter) {
		// TODO pass additional predicate to this call...
		IModuleDeclaration declaration = SourceParserUtil.parse(module,
					reporter);
		if (declaration instanceof Script) {
			return (Script) declaration;
		}
		boolean antlr4Parser = new JavascriptParserPreferences().useES6Parser();
		return antlr4Parser ? new org.eclipse.dltk.javascript.parser.v4.JavaScriptParser().parse((IModuleSource) module, reporter)
				: new JavaScriptParser().parse((IModuleSource) module, reporter);
	}

	public static Script parse(IModuleSource module, IProblemReporter reporter) {
		if (module instanceof ISourceModule) {
			return parse((ISourceModule) module, reporter);
		}
		boolean antlr4Parser = new JavascriptParserPreferences().useES6Parser();
		return antlr4Parser ? new org.eclipse.dltk.javascript.parser.v4.JavaScriptParser().parse(module, reporter)
				: new JavaScriptParser().parse(module, reporter);
	}

	public static Script parse(String source, IProblemReporter reporter) {
		boolean antlr4Parser = new JavascriptParserPreferences().useES6Parser();
		return antlr4Parser ? new org.eclipse.dltk.javascript.parser.v4.JavaScriptParser().parse(source, reporter)
				: new JavaScriptParser().parse(source, reporter);
	}
}
