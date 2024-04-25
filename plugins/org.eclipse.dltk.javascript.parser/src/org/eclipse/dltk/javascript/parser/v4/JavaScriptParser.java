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

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.atn.DecisionInfo;
import org.antlr.v4.runtime.atn.DecisionState;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;
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
import org.eclipse.dltk.javascript.internal.parser.NodeTransformerManager;
import org.eclipse.dltk.javascript.parser.JSProblem;
import org.eclipse.dltk.javascript.parser.JavaScriptParserUtil;
import org.eclipse.dltk.javascript.parser.NodeTransformer;
import org.eclipse.dltk.javascript.parser.Reporter;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ProgramContext;
import org.eclipse.dltk.javascript.parser.v4.internal.JSCommonTokenStream;
import org.eclipse.dltk.utils.TextUtils;

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
		parser.removeErrorListeners();
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
		
			boolean enableProfiling = false;
			parser.setProfile(enableProfiling);
			//parser.getInterpreter().debug = true;
			parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
			parser.removeErrorListeners();
			parser.setErrorHandler(new BailErrorStrategy());
			//parser.setBuildParseTree(false);
			
			long s = System.currentTimeMillis();
			Script script = null;
			try {
				final ProgramContext root = parser.program();
				//System.out.println(root.toStringTree(parser));
				System.out.println("new parser "+ (System.currentTimeMillis() - s) + "ms");
				
				final NodeTransformer[] transformers = NodeTransformerManager
						.createTransformers(element, reporter);
				JSTransformer jsTransformerListener = new JSTransformer(transformers,
						stream.getTokens(), parser.getNumberOfSyntaxErrors() > 0);
				jsTransformerListener.setReporter(reporter);
				
				s = System.currentTimeMillis();
				script = jsTransformerListener.transformScript(root);
				long t = System.currentTimeMillis() - s;
				System.out.println("new transformer "+ t + "ms");
				
			
				if (element != null && element instanceof ISourceModule) {
					script.setAttribute(JavaScriptParserUtil.ATTR_MODULE, element);
				}
			}
			catch (ParseCancellationException ex) {
				  // thrown by BailErrorStrategy
				  ((CommonTokenStream) parser.getTokenStream()).reset();
				  // rewind input stream
				  parser.reset();
				  // back to standard listeners/handlers
				  parser.addErrorListener(new ParseErrorListener(reporter));
				  parser.setErrorHandler(new DefaultErrorStrategy());
				  // full now with full LL(*)
				  parser.getInterpreter().setPredictionMode(PredictionMode.LL);
				  final ProgramContext root = parser.program();
					//System.out.println("new parser LL "+ (System.currentTimeMillis() - s) + "ms");
					JSTransformer jsTransformerListener = new JSTransformer(((JSTokenStream)parser.getTokenStream()).getTokens());
					jsTransformerListener.setReporter(reporter);
					s = System.currentTimeMillis();
					script = jsTransformerListener.transformScript(root);
					//System.out.println("new transformer "+ (System.currentTimeMillis() - s) + "ms");//TODO rem
					if (element != null && element instanceof ISourceModule) {
						script.setAttribute(JavaScriptParserUtil.ATTR_MODULE, element);
					}
			}
			if (enableProfiling) {
		         System.out.print(String.format("%-" + 35 + "s", "rule"));
		         System.out.print(String.format("%-" + 15 + "s", "time"));
		         System.out.print(String.format("%-" + 15 + "s", "invocations"));
		         System.out.print(String.format("%-" + 15 + "s", "lookahead"));
		         System.out.print(String.format("%-" + 15 + "s", "lookahead(max)"));
		         System.out.print(String.format("%-" + 15 + "s", "ambiguities"));
		         System.out.println(String.format("%-" + 15 + "s", "errors"));
			    for (DecisionInfo decisionInfo : parser.getParseInfo().getDecisionInfo()) {
			    	DecisionState ds = parser.getATN().getDecisionState(decisionInfo.decision);
			        String rule = parser.getRuleNames()[ds.ruleIndex]; 
			        if (decisionInfo.timeInPrediction > 0) {
			            System.out.print(String.format("%-" + 35 + "s", rule));
			            System.out.print(String.format("%-" + 15 + "s", decisionInfo.timeInPrediction));
			            System.out.print(String.format("%-" + 15 + "s", decisionInfo.invocations));
			            System.out.print(String.format("%-" + 15 + "s", decisionInfo.SLL_TotalLook));
			            System.out.print(String.format("%-" + 15 + "s", decisionInfo.SLL_MaxLook));
			            System.out.print(String.format("%-" + 15 + "s", decisionInfo.ambiguities.size()));
			            System.out.println(String.format("%-" + 15 + "s", decisionInfo.errors));
			        }
			    }
			}
			return script;
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
				lexer.removeErrorListeners();
				lexer.addErrorListener(new ParseErrorListener(reporter));
			}
			lexer.setUseStrictDefault(false);
			return new JSCommonTokenStream(lexer);
//		}
	}
}