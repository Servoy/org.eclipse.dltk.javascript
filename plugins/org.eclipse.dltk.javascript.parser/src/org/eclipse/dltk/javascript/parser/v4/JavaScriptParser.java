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
package org.eclipse.dltk.javascript.parser.v4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.EmptyStackException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.builder.ISourceLineTracker;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.parser.Reporter;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ProgramContext;
import org.eclipse.dltk.javascript.parser.v4.internal.JSCommonTokenStream;
import org.eclipse.dltk.utils.TextUtils;

import org.eclipse.dltk.javascript.parser.JSProblem;
import org.eclipse.dltk.javascript.parser.JavaScriptParserUtil;

public class JavaScriptParser implements ISourceParser {

	private boolean xmlEnabled = true;

	public boolean isXmlEnabled() {
		return xmlEnabled;
	}

	public void setXmlEnabled(boolean xmlEnabled) {
		this.xmlEnabled = xmlEnabled;
	}

	public static final String PARSER_ID = "org.eclipse.dltk.javascript.NewParser";
	
	/**
	 * @since 2.0
	 */
	public Script parse(IModuleSource input, IProblemReporter reporter) {
		Assert.isNotNull(input);
		char[] source = input.getContentsAsCharArray();
		Reporter reporter_ = reporter == null ? null : new Reporter(TextUtils
				.createLineTracker(source), reporter);
		return parse(
				input.getModelElement(),
				createTokenStream(source, reporter_),
				reporter_);
	}

	/**
	 * @since 2.0
	 */
	public Script parse(String source, IProblemReporter reporter) {
		Assert.isNotNull(source);
		ISourceLineTracker lineTracker = TextUtils
				.createLineTracker(source);
		Reporter reporter_ = reporter == null ? null : new Reporter(lineTracker, reporter);
		return parse(null, createTokenStream(source, reporter_),
				lineTracker, reporter);
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
		try {
			final Reporter reporter = new Reporter(
					TextUtils.createLineTracker(source), _reporter);
			final JSTokenStream stream = createTokenStream(source, reporter);
			final JSParser parser = createTreeParser(stream, reporter);
			final ParseTree root = parser.program();
			JSTransformer jsTransformerListener = new JSTransformer(
					((JSTokenStream)parser.getTokenStream()).getTokens(), parser.getNumberOfSyntaxErrors() > 0);
			jsTransformerListener.setReporter(reporter);
			return (Expression) jsTransformerListener.transform(root);
		} catch (ClassCastException e) {
			//ignore 
			return null;
		} catch (Exception e) {
			if (DLTKCore.DEBUG)
				e.printStackTrace();
			if (_reporter != null) {
				_reporter.reportProblem(new JSProblem(e));
			}
			return null;
		}
	}
	
	

	public JSParser createTreeParser(final JSTokenStream stream,
			final Reporter reporter) {
		final JSParser parser = new JSParser(stream);
		parser.addErrorListener(new ParseErrorListener(reporter));
		// TODO add xmlEnabled to the parser
//		parser.xmlEnabled = xmlEnabled;
		return parser;
	}

	protected Script parse(IModelElement element, JSTokenStream stream,
			ISourceLineTracker lineTracker, IProblemReporter reporter) {
		return parse(element, stream, new Reporter(lineTracker, reporter));
	}

	protected Script parse(IModelElement element, JSTokenStream stream,
			Reporter reporter) {
		try {
			final JSParser parser = createTreeParser(stream, reporter);
			final ProgramContext root = parser.program();
			JSTransformer jsTransformerListener = new JSTransformer(((JSTokenStream)parser.getTokenStream()).getTokens());
			jsTransformerListener.setReporter(reporter);
			final Script script = jsTransformerListener.transformScript(root);
			if (element != null && element instanceof ISourceModule) {
				script.setAttribute(JavaScriptParserUtil.ATTR_MODULE, element);
			}
			return script;
		}
		catch (ClassCastException|EmptyStackException e) {
			return new Script();
		}
		catch (Exception e) {
			JavaScriptParserPlugin.error(e);
			if (reporter != null) {
				reporter.reportProblem(new JSProblem(e));
			}
			// create empty output
			return new Script();
		}
	}

	public JSTokenStream createTokenStream(char[] source, Reporter reporter) {
		CharStream charStream = CharStreams.fromString(new String(source));
		return createTokenStream(charStream, reporter);
	}

	public JSTokenStream createTokenStream(String source, Reporter reporter) {
		CharStream charStream = CharStreams.fromString(source);
		return createTokenStream(charStream, reporter);
	}

	/**
	 * @param input
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public JSTokenStream createTokenStream(InputStream input, String encoding, Reporter reporter)
			throws IOException {
		CharStream charStream = CharStreams.fromStream(input, Charset.forName(encoding));
		return createTokenStream(charStream, reporter);
	}

	private JSTokenStream createTokenStream(CharStream charStream, Reporter reporter) {
// TODO enable if xml is supported
//		if (xmlEnabled) {
//			return new DynamicTokenStream(new JavaScriptTokenSource(charStream));
//		} else {
			JavaScriptLexer lexer = new JavaScriptLexer(charStream);
			if (reporter != null) {
				lexer.addErrorListener(new ParseErrorListener(reporter));
			}
			lexer.setUseStrictDefault(false);
			return new JSCommonTokenStream(lexer);
//		}
	}
}