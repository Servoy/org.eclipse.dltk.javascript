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
package org.eclipse.dltk.javascript.parser.rhino;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.builder.ISourceLineTracker;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.internal.parser.NodeTransformerManager;
import org.eclipse.dltk.javascript.parser.JSProblem;
import org.eclipse.dltk.javascript.parser.JavaScriptParserPlugin;
import org.eclipse.dltk.javascript.parser.NodeTransformer;
import org.eclipse.dltk.javascript.parser.Reporter;
import org.eclipse.dltk.utils.TextUtils;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;

public class JavaScriptParser implements ISourceParser {

	private boolean xmlEnabled = false; //TODO impl xml literals

	public boolean isXmlEnabled() {
		return xmlEnabled;
	}

	public void setXmlEnabled(boolean xmlEnabled) {
		this.xmlEnabled = xmlEnabled;
	}

	public static final String PARSER_ID = "org.eclipse.dltk.javascript.rhino.Parser";

	/**
	 * @since 2.0
	 */
	public Script parse(IModuleSource input, IProblemReporter reporter) {
		Assert.isNotNull(input);
		String source = input.getSourceContents();
		Reporter reporter_ = new Reporter(TextUtils
				.createLineTracker(source), reporter);
		return parse(
				input.getModelElement(),
				source, null,
				reporter == null ? null : reporter_);
	}

	/**
	 * @since 2.0
	 */
	public Script parse(String source, IProblemReporter reporter) {
		Assert.isNotNull(source);
		return parse(null, source,
				TextUtils.createLineTracker(source), reporter);
	}
	
	private Script parse(IModelElement modelElement, String source,
			ISourceLineTracker iSourceLineTracker, IProblemReporter reporter_) {
		ISourceLineTracker lineTracker = iSourceLineTracker != null ? iSourceLineTracker : TextUtils.createLineTracker(source);
		Reporter reporter = new Reporter(lineTracker, reporter_);
		final NodeTransformer[] transformers = NodeTransformerManager
				.createTransformers(modelElement, reporter);
		CompilerEnvirons ideEnvirons = CompilerEnvirons.ideEnvirons();
		ideEnvirons.setStrictMode(false);
		ideEnvirons.setRecordingLocalJsDocComments(true);
		ideEnvirons.setLanguageVersion(Context.VERSION_ES6);
		ideEnvirons.setXmlAvailable(xmlEnabled);
		ideEnvirons.setWarnTrailingComma(false);
		try {
			Parser p = new Parser(ideEnvirons, new JSProblemReporter(reporter));
			return p.parse(source, modelElement != null ?
					modelElement.getPath().toString() : null, 1, transformers);
		}
		catch (RuntimeException e) {
			if (DLTKCore.DEBUG)
				e.printStackTrace();
			JavaScriptParserPlugin.error(e);
			reporter.reportProblem(new JSProblem(e));
			return new Script();
		}
	}

	/**
	 * Parse the specified string as JavaScript expression. Returns the
	 * expression node or <code>null</code> on unrecoverable errors.
	 * {@link org.eclipse.dltk.javascript.ast.ErrorExpression} could be also
	 * returned.
	 * 
	 * @param source
	 * @param _reporter
	 * @return
	 */
	public Expression expression(String source, IProblemReporter _reporter) {
		ISourceLineTracker lineTracker = TextUtils.createLineTracker(source);
		Reporter reporter = new Reporter(lineTracker, _reporter);
		CompilerEnvirons ideEnvirons = CompilerEnvirons.ideEnvirons();
		ideEnvirons.setStrictMode(false);
		ideEnvirons.setRecordingLocalJsDocComments(true);
		ideEnvirons.setLanguageVersion(Context.VERSION_ES6);
		ideEnvirons.setXmlAvailable(xmlEnabled);
		ideEnvirons.setWarnTrailingComma(false);
		try {
			Parser p = new Parser(ideEnvirons, new JSProblemReporter(reporter));
			return p.standaloneExpression(source);
		}
		catch (RuntimeException e) {
			if (DLTKCore.DEBUG)
				e.printStackTrace();
			reporter.reportProblem(new JSProblem(e));
		}
		return null;
	}
}
