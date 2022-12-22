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
package org.eclipse.dltk.javascript.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.SourceRange;
import org.eclipse.dltk.core.builder.ISourceLineTracker;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.internal.parser.JSCommonTokenStream;
import org.eclipse.dltk.javascript.internal.parser.NodeTransformerManager;
import org.eclipse.dltk.javascript.parser.JSParser.program_return;
import org.eclipse.dltk.javascript.parser.JSParser.standaloneExpression_return;
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

	static class JSBaseParser extends Parser {

		Reporter reporter;
		boolean xmlEnabled;

		public JSBaseParser(TokenStream input) {
			super(input);
		}

		protected boolean isXmlEnabled() {
			return xmlEnabled;
		}

		protected void reportFailure(Throwable t) {
			if (reporter != null && !peekState().hasErrors()) {
				reporter.reportProblem(new JSProblem(t));
			}
		}

		private JSParserMessages messages = null;

		private JSParserMessages getMessages() {
			if (messages == null) {
				messages = new JSParserMessages();
			}
			return messages;
		}

		private String getTokenName(int token) {
			String message = getMessages().get(token);
			if (message == null) {
				message = getTokenNames()[token];
			}
			return message;
		}

		@Override
		public String getTokenErrorDisplay(Token t) {
			final String message = getMessages().get(t.getType());
			if (message != null) {
				return message;
			}
			return super.getTokenErrorDisplay(t);
		}

		@Override
		public void displayRecognitionError(String[] tokenNames,
				RecognitionException re) {
			peekState().incrementErrorCount();
			if (reporter == null)
				return;
			String message;
			ISourceRange range;
			if (re instanceof NoViableAltException) {
				range = convert(re.token);
				final Token token = getLastToken(re.token);
				message = getMessages().get(peekState().rule, token.getType());
				if (message == null) {
					message = "Unexpected " + getTokenErrorDisplay(re.token);
				}
			} else if (re instanceof MismatchedTokenException) {
				MismatchedTokenException mte = (MismatchedTokenException) re;
				if (re.token == Token.EOF_TOKEN) {
					message = getTokenName(mte.expecting) + " expected";
				} else {
					message = "Mismatched input "
							+ getTokenErrorDisplay(re.token);
					if (mte.expecting >= 0 && mte.expecting < tokenNames.length) {
						message += ", " + getTokenName(mte.expecting)
								+ " expected";
					}
				}
				range = convert(re.token);
				if (range.getLength() + range.getOffset() >= inputLength()) {
					int stop = inputLength() - 1;
					int start = Math.min(stop - 1, range.getOffset() - 2);
					range = new SourceRange(start, stop - start);
				}
			} else if (re instanceof MismatchedSetException) {
				MismatchedSetException mse = (MismatchedSetException) re;
				message = "Mismatched input " + getTokenErrorDisplay(re.token);
				if (mse.expecting != null) {
					message += " expecting set " + mse.expecting;
				}
				range = convert(re.token);
			} else {
				message = "Syntax Error:" + re.getMessage();
				range = convert(re.token);
				// stop = start + 1;}
			}
			reporter.setMessage(JavaScriptParserProblems.SYNTAX_ERROR, message);
			reporter.setSeverity(ProblemSeverity.ERROR);
			if (range != null) {
				reporter.setRange(range.getOffset(),
						range.getOffset() + range.getLength());
			}
			reporter.setLine(re.line - 1);
			reporter.report();
		}

		private Token getLastToken(Token token) {
			if (token == Token.EOF_TOKEN) {
				final TokenStream stream = getTokenStream();
				int index = stream.index();
				while (index > 0) {
					--index;
					final Token prevToken = stream.get(index);
					if (prevToken.getType() != JSParser.WhiteSpace
							&& prevToken.getType() != JSParser.EOL) {
						token = prevToken;
						break;
					}
				}
			}
			return token;
		}

		private ISourceRange convert(Token token) {
			token = getLastToken(token);
			if (token == Token.EOF_TOKEN) {
				return null;
			}
			return reporter.toSourceRange(token);
		}

		private int inputLength() {
			return reporter.getLength();
		}

		/*
		 * Standard implementation contains forgotten debug System.err.println()
		 * and we don't need it at all.
		 */
		@Override
		public void recoverFromMismatchedToken(IntStream input,
				RecognitionException e, int ttype, BitSet follow)
				throws RecognitionException {
			// if next token is what we are looking for then "delete" this token
			if (input.LA(2) == ttype) {
				reportError(e);
				beginResync();
				input.consume(); // simply delete extra token
				endResync();
				input.consume(); // move past ttype token as if all were ok
				return;
			}
			// insert "}" if expected
			if (ttype == JSParser.RBRACE) {
				displayRecognitionError(getTokenNames(), e);
				return;
			}
			if (!recoverFromMismatchedElement(input, e, follow)) {
				throw e;
			}
		}

		protected void syncToSet() {
			final BitSet follow = following[_fsp];
			int mark = input.mark();
			try {
				Token first = null;
				Token last = null;
				while (!follow.member(input.LA(1))) {
					if (input.LA(1) == Token.EOF) {
						input.rewind();
						mark = -1;
						return;
					}
					last = input.LT(1);
					if (first == null) {
						first = last;
					}
					input.consume();
				}
				if (first != null && reporter != null) {
					final ISourceRange end = convert(last);
					reporter.setMessage(JavaScriptParserProblems.SYNTAX_ERROR,
							"Unexpected input was discarded");
					reporter.setSeverity(ProblemSeverity.ERROR);
					reporter.setRange(convert(first).getOffset(),
							end.getOffset() + end.getLength());
					reporter.setLine(first.getLine() - 1);
					reporter.report();
				}
			} finally {
				if (mark != -1) {
					input.release(mark);
				}
			}
		}

		protected void reportReservedKeyword(Token token) {
			if (reporter == null)
				return;
			final ISourceRange range = convert(token);
			reporter.setFormattedMessage(
					JavaScriptParserProblems.RESERVED_KEYWORD, token.getText());
			reporter.setSeverity(ProblemSeverity.ERROR);
			reporter.setRange(range.getOffset(),
					range.getOffset() + range.getLength());
			reporter.setLine(token.getLine() - 1);
			reporter.report();
		}

		protected void reportError(String message, Token token) {
			if (reporter == null)
				return;
			final ISourceRange range = convert(token);
			reporter.setMessage(JavaScriptParserProblems.SYNTAX_ERROR, message);
			reporter.setSeverity(ProblemSeverity.ERROR);
			reporter.setRange(range.getOffset(),
					range.getOffset() + range.getLength());
			reporter.setLine(token.getLine() - 1);
			reporter.report();
		}

		/**
		 * Overrides the function to prevent NPE.
		 * 
		 * The only change is <code>localFollowSet != null</code> check
		 * 
		 * @see org.eclipse.dltk.javascript.parser.tests.Bug20110503#testCombinedFollowsNPE()
		 */
		@Override
		protected BitSet combineFollows(boolean exact) {
			int top = _fsp;
			BitSet followSet = new BitSet();
			for (int i = top; i >= 0; i--) {
				BitSet localFollowSet = following[i];
				followSet.orInPlace(localFollowSet);
				if (exact && localFollowSet != null
						&& !localFollowSet.member(Token.EOR_TOKEN_TYPE)) {
					break;
				}
			}
			followSet.remove(Token.EOR_TOKEN_TYPE);
			return followSet;
		}

		protected void reportRuleError(RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		private final Stack<JSParserState> states = new Stack<JSParserState>();

		protected void pushState(JSParserRule rule) {
			states.push(new JSParserState(peekState(), rule));
		}

		protected void popState() {
			states.pop();
		}

		public JSParserState peekState() {
			return states.isEmpty() ? null : states.peek();
		}
	}

	/**
	 * @since 2.0
	 */
	public Script parse(IModuleSource input, IProblemReporter reporter) {
		Assert.isNotNull(input);
		char[] source = input.getContentsAsCharArray();
		return parse(
				input.getModelElement(),
				createTokenStream(source),
				reporter == null ? null : new Reporter(TextUtils
						.createLineTracker(source), reporter));
	}

	/**
	 * @since 2.0
	 */
	public Script parse(String source, IProblemReporter reporter) {
		Assert.isNotNull(source);
		return parse(null, createTokenStream(source),
				TextUtils.createLineTracker(source), reporter);
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
			final JSTokenStream stream = createTokenStream(source);
			stream.setReporter(reporter);
			final JSParser parser = createTreeParser(stream, reporter);
			final standaloneExpression_return root = parser
					.standaloneExpression();
			final JSTransformer transformer = new JSTransformer(
					stream.getTokens(), parser.peekState().hasErrors());
			transformer.setReporter(reporter);
			return (Expression) transformer.transform(root);
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
		parser.reporter = reporter;
		parser.xmlEnabled = xmlEnabled;
		return parser;
	}

	protected Script parse(IModelElement element, JSTokenStream stream,
			ISourceLineTracker lineTracker, IProblemReporter reporter) {
		return parse(element, stream, new Reporter(lineTracker, reporter));
	}

	protected Script parse(IModelElement element, JSTokenStream stream,
			Reporter reporter) {
		try {
			stream.setReporter(reporter);
			JSParser parser = createTreeParser(stream, reporter);
			final program_return root = parser.program();
			final NodeTransformer[] transformers = NodeTransformerManager
					.createTransformers(element, reporter);
			JSTransformer transformer = new JSTransformer(transformers,
					stream.getTokens(), parser.peekState().hasErrors());
			transformer.setReporter(reporter);
			final Script script = transformer.transformScript(root);
			if (element != null && element instanceof ISourceModule) {
				script.setAttribute(JavaScriptParserUtil.ATTR_MODULE, element);
			}
			return script;
		} catch (Exception e) {
			JavaScriptParserPlugin.error(e);
			if (reporter != null) {
				reporter.reportProblem(new JSProblem(e));
			}
			// create empty output
			return new Script();
		}
	}

	public JSTokenStream createTokenStream(char[] source) {
		CharStream charStream = new ANTLRStringStream(source, source.length);
		return createTokenStream(charStream);
	}

	public JSTokenStream createTokenStream(String source) {
		CharStream charStream = new ANTLRStringStream(source);
		return createTokenStream(charStream);
	}

	/**
	 * @param input
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public JSTokenStream createTokenStream(InputStream input, String encoding)
			throws IOException {
		CharStream charStream = new ANTLRInputStream(input, encoding);
		return createTokenStream(charStream);
	}

	private JSTokenStream createTokenStream(CharStream charStream) {
		if (xmlEnabled) {
			return new DynamicTokenStream(new JavaScriptTokenSource(charStream));
		} else {
			return new JSCommonTokenStream(new JavaScriptLexer(charStream));
		}
	}
}
