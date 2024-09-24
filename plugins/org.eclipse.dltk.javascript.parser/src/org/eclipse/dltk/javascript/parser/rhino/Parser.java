/* -*- Mode: java; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.eclipse.dltk.javascript.parser.rhino;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.dltk.compiler.util.Util;
import org.eclipse.dltk.javascript.ast.AbstractForStatement;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.ArrayInitializer;
import org.eclipse.dltk.javascript.ast.BooleanLiteral;
import org.eclipse.dltk.javascript.ast.BreakStatement;
import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.CaseClause;
import org.eclipse.dltk.javascript.ast.CatchClause;
import org.eclipse.dltk.javascript.ast.CommaExpression;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.ConditionalOperator;
import org.eclipse.dltk.javascript.ast.ConstStatement;
import org.eclipse.dltk.javascript.ast.ContinueStatement;
import org.eclipse.dltk.javascript.ast.DecimalLiteral;
import org.eclipse.dltk.javascript.ast.DefaultClause;
import org.eclipse.dltk.javascript.ast.DoWhileStatement;
import org.eclipse.dltk.javascript.ast.Documentable;
import org.eclipse.dltk.javascript.ast.EmptyExpression;
import org.eclipse.dltk.javascript.ast.EmptyStatement;
import org.eclipse.dltk.javascript.ast.ErrorExpression;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FinallyClause;
import org.eclipse.dltk.javascript.ast.ForEachInStatement;
import org.eclipse.dltk.javascript.ast.ForInStatement;
import org.eclipse.dltk.javascript.ast.ForStatement;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.GetArrayItemExpression;
import org.eclipse.dltk.javascript.ast.GetMethod;
import org.eclipse.dltk.javascript.ast.ISemicolonStatement;
import org.eclipse.dltk.javascript.ast.IVariableStatement;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.IfStatement;
import org.eclipse.dltk.javascript.ast.JSDeclaration;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Keyword;
import org.eclipse.dltk.javascript.ast.Label;
import org.eclipse.dltk.javascript.ast.LabelledStatement;
import org.eclipse.dltk.javascript.ast.LoopStatement;
import org.eclipse.dltk.javascript.ast.Method;
import org.eclipse.dltk.javascript.ast.MultiLineComment;
import org.eclipse.dltk.javascript.ast.NewExpression;
import org.eclipse.dltk.javascript.ast.NullExpression;
import org.eclipse.dltk.javascript.ast.ObjectInitializer;
import org.eclipse.dltk.javascript.ast.ObjectInitializerPart;
import org.eclipse.dltk.javascript.ast.ParenthesizedExpression;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.PropertyInitializer;
import org.eclipse.dltk.javascript.ast.RegExpLiteral;
import org.eclipse.dltk.javascript.ast.ReturnStatement;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.SetMethod;
import org.eclipse.dltk.javascript.ast.SingleLineComment;
import org.eclipse.dltk.javascript.ast.Statement;
import org.eclipse.dltk.javascript.ast.StatementBlock;
import org.eclipse.dltk.javascript.ast.StringLiteral;
import org.eclipse.dltk.javascript.ast.SwitchComponent;
import org.eclipse.dltk.javascript.ast.SwitchStatement;
import org.eclipse.dltk.javascript.ast.ThisExpression;
import org.eclipse.dltk.javascript.ast.ThrowStatement;
import org.eclipse.dltk.javascript.ast.TryStatement;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.VoidExpression;
import org.eclipse.dltk.javascript.ast.WhileStatement;
import org.eclipse.dltk.javascript.ast.WithStatement;
import org.eclipse.dltk.javascript.ast.XmlAttributeIdentifier;
import org.eclipse.dltk.javascript.ast.YieldOperator;
import org.eclipse.dltk.javascript.ast.rhino.BinaryOperation;
import org.eclipse.dltk.javascript.ast.rhino.UnaryOperation;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.ast.v4.ForOfStatement;
import org.eclipse.dltk.javascript.ast.v4.LetStatement;
import org.eclipse.dltk.javascript.ast.v4.PropertyShorthand;
import org.eclipse.dltk.javascript.ast.v4.TagFunctionExpression;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringExpression;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringLiteral;
import org.eclipse.dltk.javascript.parser.JavaScriptParserProblems;
import org.eclipse.dltk.javascript.parser.NodeTransformer;
import org.eclipse.dltk.javascript.parser.NodeTransformerExtension;
import org.eclipse.dltk.javascript.parser.SymbolKind;
import org.eclipse.dltk.javascript.parser.SymbolTable;
import org.eclipse.dltk.utils.IntList;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.IParser;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.Token.CommentType;
import org.mozilla.javascript.TokenStream;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.IdeErrorReporter;


/**
 * This class makes use of the Rhino JavaScript parser's implementation to generate a DLTK parse tree.
 *
 * <p>It is based on the SpiderMonkey C source files jsparse.c and jsparse.h in the jsref package.
 *
 * <p>The parser generates an {@link AstRoot} parse tree representing the source code. No tree
 * rewriting is permitted at this stage, so that the parse tree is a faithful representation of the
 * source for frontend processing tools and IDEs.
 *
 * <p>This parser implementation is not intended to be reused after a parse finishes, and will throw
 * an IllegalStateException() if invoked again.
 *
 * <p>
 *
 * @see TokenStream
 * @author Mike McCabe
 * @author Brendan Eich
 */
public class Parser implements IParser{
	/** Maximum number of allowed function or constructor arguments, to follow SpiderMonkey. */
	public static final int ARGC_LIMIT = 1 << 16;

	// TokenInformation flags : currentFlaggedToken stores them together
	// with token type
	static final int CLEAR_TI_MASK = 0xFFFF, // mask to clear token information bits
			TI_AFTER_EOL = 1 << 16, // first token of the source line
			TI_CHECK_LABEL = 1 << 17; // indicates to check for label

	CompilerEnvirons compilerEnv;
	private JSProblemReporter reporter;
	private IdeErrorReporter errorCollector;
	private String sourceURI;
	private char[] sourceChars;

	boolean calledByCompileFunction; // ugly - set directly by Context
	private boolean parseFinished; // set when finished to prevent reuse

	private TokenStream ts;
	private int currentFlaggedToken = Token.EOF;
	private int currentToken;
	private int syntaxErrorCount;

	private List<Comment> scannedComments;
	private Comment currentJsDocComment;

	protected int nestingOfFunction;
	private LabelledStatement currentLabel;
	private boolean inDestructuringAssignment;
	protected boolean inUseStrictDirective;

	// The following are per function variables and should be saved/restored
	// during function parsing.  See PerFunctionVariables class below.
	JSNode currentScriptOrFn;
	SymbolTable currentScope;
	private int endFlags;
	private boolean inForInit; // bound temporarily during forStatement()
	private Map<String, LabelledStatement> labelSet;
	private List<LoopStatement> loopSet;
	private List<Statement> loopAndSwitchSet;
	// end of per function variables

	// Lacking 2-token lookahead, labels become a problem.
	// These vars store the token info of the last matched name,
	// iff it wasn't the last matched token.
	private int prevNameTokenStart;
	private String prevNameTokenString = "";
	//svy
	private Stack<JSNode> parents = new Stack<JSNode>();

	private SymbolTable scope;
	private Stack<SymbolTable> scopes = new Stack<SymbolTable>();
	private Stack<SymbolTable> blockScopes = new Stack<SymbolTable>();

	private int prevTokenEnd;

	private int lastCommentLineno;

	// Exception to unwind
	private static class ParserException extends RuntimeException {
		private static final long serialVersionUID = 5882582646773765630L;
	}

	public Parser(CompilerEnvirons compilerEnv, JSProblemReporter errorReporter) {
		this.compilerEnv = compilerEnv;
		this.reporter = errorReporter;
		if (errorReporter instanceof IdeErrorReporter) {
			errorCollector = (IdeErrorReporter) errorReporter;
		}
	}

	private JSNode getParent() {
		if (parents.isEmpty()) {
			return null;
		} else {
			return parents.peek();
		}
	}

	private SymbolTable getScope() {
		if (scopes.isEmpty()) {
			return scope;
		} else {
			return scopes.peek();
		}
	}

	private SymbolKind getSymbolKind(int declType) {
		if (declType == Token.VAR) return SymbolKind.VAR;
		if (declType == Token.CONST) return SymbolKind.CONST;
		if (declType == Token.LET) return SymbolKind.LET;
		return null;
	}

	private Keyword createKeyword(int type, int start) {
		String text = Token.keywordToName(type);
		if (text == null) return null;
		final Keyword keyword = new Keyword(text);
		keyword.setStart(start);
		keyword.setEnd(start + text.length());
		return keyword;
	}

	// Add a strict warning on the last matched token.
	void addStrictWarning(String messageId, String messageArg) {
		int beg = -1, end = -1;
		if (ts != null) {
			beg = ts.getTokenBeg();
			end = ts.getTokenEnd() - ts.getTokenBeg();
		}
		addStrictWarning(messageId, messageArg, beg, end);
	}

	void addStrictWarning(String messageId, String messageArg, int position, int length) {
		if (compilerEnv.isStrictMode()) addWarning(messageId, messageArg, position, length);
	}

	public void addWarning(String messageId, String messageArg) {
		int beg = -1, end = -1;
		if (ts != null) {
			beg = ts.getTokenBeg();
			end = ts.getTokenEnd() - ts.getTokenBeg();
		}
		addWarning(messageId, messageArg, beg, end);
	}

	void addWarning(String messageId, int position, int length) {
		addWarning(messageId, null, position, length);
	}

	void addWarning(String messageId, String messageArg, int position, int length) {
		String message = lookupMessage(messageId, messageArg);
		if (compilerEnv.reportWarningAsError()) {
			addError(messageId, messageArg, position, length);
		} else if (errorCollector != null) {
			errorCollector.warning(message, sourceURI, position, length);
		} else if (ts != null) {
			reporter.warning(message, sourceURI, ts.getLineno(), ts.getLine(), ts.getOffset());
		} else {
			reporter.warning(message, sourceURI, 1, "", 1);
		}
	}

	public void addError(String messageId) {
		if (ts == null) {
			addError(messageId, 0, 0);
		} else {
			addError(messageId, ts.getTokenBeg(), ts.getTokenEnd() - ts.getTokenBeg());
		}
	}

	void addError(String messageId, int position, int length) {
		addError(messageId, null, position, length);
	}

	void addError(String messageId, String messageArg) {
		if (ts == null) {
			addError(messageId, messageArg, 0, 0);
		} else {
			addError(messageId, messageArg, ts.getTokenBeg(), ts.getTokenEnd() - ts.getTokenBeg());
		}
	}

	public void addError(String messageId, int c) {
		String messageArg = Character.toString((char) c);
		addError(messageId, messageArg);
	}

	void addError(String messageId, String messageArg, int position, int length) {
		++syntaxErrorCount;
		String message = lookupMessage(messageId, messageArg);
		if (errorCollector != null) {
			errorCollector.error(message, sourceURI, position, length);
		} else {
			int beg = 1, end = 1;
			if (ts != null) { // happens in some regression tests
				beg = ts.getTokenBeg();
				end = ts.getTokenEnd();
			}
			reporter.setMessage(
					JavaScriptParserProblems.SYNTAX_ERROR,
					message);
			reporter.setSeverity(ProblemSeverity.ERROR);
			reporter.setRange(beg, end);
			reporter.report();
		}
	}

	private void addStrictWarning(
			String messageId,
			String messageArg,
			int position,
			int length,
			int line,
			String lineSource,
			int lineOffset) {
		if (compilerEnv.isStrictMode()) {
			addWarning(messageId, messageArg, position, length, line, lineSource, lineOffset);
		}
	}

	private void addWarning(
			String messageId,
			String messageArg,
			int position,
			int length,
			int line,
			String lineSource,
			int lineOffset) {
		String message = lookupMessage(messageId, messageArg);
		if (compilerEnv.reportWarningAsError()) {
			addError(messageId, messageArg, position, length, line, lineSource, lineOffset);
		} else if (errorCollector != null) {
			errorCollector.warning(message, sourceURI, position, length);
		} else {
			reporter.warning(message, sourceURI, line, lineSource, lineOffset);
		}
	}

	private void addError(
			String messageId,
			String messageArg,
			int position,
			int length,
			int line,
			String lineSource,
			int lineOffset) {
		++syntaxErrorCount;
		String message = lookupMessage(messageId, messageArg);
		if (errorCollector != null) {
			errorCollector.error(message, sourceURI, position, length);
		} else {
			reporter.error(message, sourceURI, line, lineSource, lineOffset);
		}
	}

	String lookupMessage(String messageId) {
		return lookupMessage(messageId, null);
	}

	String lookupMessage(String messageId, String messageArg) {
		return messageArg == null
				? ScriptRuntime.getMessageById(messageId)
						: ScriptRuntime.getMessageById(messageId, messageArg);
	}

	public void reportError(String messageId) {
		reportError(messageId, null);
	}

	public void reportError(String messageId, String messageArg) {
		if (ts == null) { // happens in some regression tests
			reportError(messageId, messageArg, 1, 1);
		} else {
			reportError(messageId, messageArg, ts.getTokenBeg(), ts.getTokenEnd() - ts.getTokenBeg());
		}
	}

	void reportError(String messageId, int position, int length) {
		reportError(messageId, null, position, length);
	}

	void reportError(String messageId, String messageArg, int position, int length) {
		addError(messageId, messageArg, position, length);

		if (!compilerEnv.recoverFromErrors()) {
			throw new ParserException();
		}
	}

	private void recordComment(int lineno, String comment) {
		if (scannedComments == null) {
			scannedComments = new ArrayList<>();
		}

		lastCommentLineno = lineno;
		Comment commentNode = null;
		if (ts.getCommentType() == Token.CommentType.JSDOC || comment.trim().startsWith("/*")) {
			//we need to also check for "/*" which is on a single line
			commentNode = new MultiLineComment();
		}
		else {
			commentNode = new SingleLineComment();
		}
		commentNode.setText(comment);
		commentNode.setStart(ts.getTokenBeg());
		commentNode.setEnd(ts.getTokenBeg() + comment.length());

		if (ts.getCommentType() == Token.CommentType.JSDOC
				&& compilerEnv.isRecordingLocalJsDocComments()) {
			currentJsDocComment = commentNode;
		}
		scannedComments.add(commentNode);
	}

	private Comment getAndResetJsDoc() {
		Comment saved = currentJsDocComment;
		currentJsDocComment = null;
		return saved;
	}

	// Returns the next token without consuming it.
	// If previous token was consumed, calls scanner to get new token.
	// If previous token was -not- consumed, returns it (idempotent).
	//
	// This function will not return a newline (Token.EOL - instead, it
	// gobbles newlines until it finds a non-newline token, and flags
	// that token as appearing just after a newline.
	//
	// This function will also not return a Token.COMMENT.  Instead, it
	// records comments in the scannedComments list.  If the token
	// returned by this function immediately follows a jsdoc comment,
	// the token is flagged as such.
	//
	// Note that this function always returned the un-flagged token!
	// The flags, if any, are saved in currentFlaggedToken.
	private int peekToken() throws IOException {
		// By far the most common case:  last token hasn't been consumed,
		// so return already-peeked token.
		if (currentFlaggedToken != Token.EOF) {
			return currentToken;
		}

		int lineno = ts.getLineno();
		prevTokenEnd = ts.getTokenEnd();
		int tt = ts.getToken();
		boolean sawEOL = false;

		// process comments and whitespace
		while (tt == Token.EOL || tt == Token.COMMENT) {
			prevTokenEnd = ts.getTokenEnd();
			if (tt == Token.EOL) {
				lineno++;
				sawEOL = true;
				tt = ts.getToken();
			} else {
				if (compilerEnv.isRecordingComments()) {
					String comment = ts.getAndResetCurrentComment();
					recordComment(lineno, comment);
					break;
				}
				tt = ts.getToken();
			}
		}

		currentToken = tt;
		currentFlaggedToken = tt | (sawEOL ? TI_AFTER_EOL : 0);
		return currentToken; // return unflagged token
	}

	private int peekFlaggedToken() throws IOException {
		peekToken();
		return currentFlaggedToken;
	}

	private void consumeToken() {
		currentFlaggedToken = Token.EOF;
	}

	private int nextToken() throws IOException {
		int tt = peekToken();
		consumeToken();
		return tt;
	}

	private boolean matchToken(int toMatch, boolean ignoreComment) throws IOException {
		int tt = peekToken();
		while (tt == Token.COMMENT && ignoreComment) {
			consumeToken();
			tt = peekToken();
		}
		if (tt != toMatch) {
			return false;
		}
		consumeToken();
		return true;
	}

	// Returns Token.EOL if the current token follows a newline, else returns
	// the current token.  Used in situations where we don't consider certain
	// token types valid if they are preceded by a newline.  One example is the
	// postfix ++ or -- operator, which has to be on the same line as its
	// operand.
	private int peekTokenOrEOL() throws IOException {
		int tt = peekToken();
		// Check for last peeked token flags
		if ((currentFlaggedToken & TI_AFTER_EOL) != 0) {
			tt = Token.EOL;
		}
		return tt;
	}

	private boolean mustMatchToken(int toMatch, String messageId, boolean ignoreComment)
			throws IOException {
		return mustMatchToken(
				toMatch, messageId, ts.getTokenBeg(), ts.getTokenEnd() - ts.getTokenBeg(), ignoreComment);
	}

	private boolean mustMatchToken(
			int toMatch, String msgId, int pos, int len, boolean ignoreComment) throws IOException {
		if (matchToken(toMatch, ignoreComment)) {
			return true;
		}
		reportError(msgId, pos, len);
		return false;
	}

	private void mustHaveXML() {
		if (!compilerEnv.isXmlAvailable()) {
			reportError("msg.XML.not.available");
		}
	}

	public boolean eof() {
		return ts.eof();
	}

	boolean insideFunction() {
		return nestingOfFunction != 0;
	}

	private void enterLoop(LoopStatement loop) {
		if (loopSet == null) loopSet = new ArrayList<>();
		loopSet.add(loop);
		if (loopAndSwitchSet == null) loopAndSwitchSet = new ArrayList<>();
		loopAndSwitchSet.add(loop);
		//        pushScope(loop);
		if (currentLabel != null) {
			currentLabel.setStatement(loop);
			//            currentLabel.getFirstLabel().setLoop(loop);
			// This is the only time during parsing that we set a node's parent
			// before parsing the children.  In order for the child node offsets
			// to be correct, we adjust the loop's reported position back to an
			// absolute source offset, and restore it when we call
			// restoreRelativeLoopPosition() (invoked just before setBody() is
			// called on the loop).
			//            loop.setRelative(-currentLabel.sourceStart());
		}
	}

	private void exitLoop() {
		loopSet.remove(loopSet.size() - 1);
		loopAndSwitchSet.remove(loopAndSwitchSet.size() - 1);
		//        popScope();
	}

	private void enterSwitch(SwitchStatement node) {
		if (loopAndSwitchSet == null) loopAndSwitchSet = new ArrayList<>();
		loopAndSwitchSet.add(node);
	}

	private void exitSwitch() {
		loopAndSwitchSet.remove(loopAndSwitchSet.size() - 1);
	}

	/**
	 * Builds a parse tree from the given source string.
	 * @param transformers 
	 *
	 * @return an {@link AstRoot} object representing the parsed program. If the parse fails, {@code
	 *     null} will be returned. (The parse failure will result in a call to the {@link
	 *     ErrorReporter} from {@link CompilerEnvirons}.) 
	 */
	public Script parse(String sourceString, String sourceURI, int lineno, NodeTransformer[] transformers) {
		if (parseFinished) throw new IllegalStateException("parser reused");
		this.sourceURI = sourceURI;
		if (compilerEnv.isIdeMode()) {
			this.sourceChars = sourceString.toCharArray();
		}
		this.ts = new TokenStream(this, null, sourceString, lineno);
		try {
			Script script = parse();
			for (NodeTransformer transformer : transformers) {
				if (transformer instanceof NodeTransformerExtension) {
					((NodeTransformerExtension) transformer).postConstruct(script);
				}
			}
			return script;
		}
		catch (RuntimeException e) {
			return new Script();
		}
		catch (IOException iox) {
			// Should never happen
			throw new IllegalStateException();
		}
		finally {
			parseFinished = true;
		}
	}
	
	public Expression standaloneExpression(String sourceString) {
		if (parseFinished) throw new IllegalStateException("parser reused");
		if (compilerEnv.isIdeMode()) {
			this.sourceChars = sourceString.toCharArray();
		}
		this.ts = new TokenStream(this, null, sourceString, 1);
		try {
			return expr(false);
		}
		catch (IOException iox) {
			// Should never happen
			throw new IllegalStateException();
		}
		finally {
			parseFinished = true;
		}
	}

	/**
	 * Builds a parse tree from the given sourcereader.
	 *
	 * @see #parse(String,String,int)
	 * @throws IOException if the {@link Reader} encounters an error
	 * @deprecated use parse(String, String, int) instead
	 */
	//    @Deprecated
	//    public Script parse(Reader sourceReader, String sourceURI, int lineno) throws IOException {
	//        if (parseFinished) throw new IllegalStateException("parser reused");
	//        if (compilerEnv.isIdeMode()) {
	//            return parse(Kit.readReader(sourceReader), sourceURI, lineno, null);
	//        }
	//        try {
	//            this.sourceURI = sourceURI;
	//            ts = new TokenStream(this, sourceReader, null, lineno);
	//            return parse();
	//        } finally {
	//            parseFinished = true;
	//        }
	//    }

	private Script parse() throws IOException {
		int pos = 0;
		Script script = new Script();
		scope = new SymbolTable(script);
		parents.push(script);

		int baseLineno = ts.getLineno(); // line number where source starts
		int end = pos; // in case source is empty

		try {
			for (; ; ) {
				int tt = peekToken();
				if (tt <= Token.EOF) {
					break;
				}

				ASTNode n = null;
				if (tt == Token.FUNCTION) {
					consumeToken();
					try {
						n =
								function(
										calledByCompileFunction
										? FunctionNode.FUNCTION_EXPRESSION
												: FunctionNode.FUNCTION_STATEMENT);
						script.addStatement(toVoidExpression((JSNode) n));
						end = n.end();
					} catch (ParserException e) {
						break;
					}
				} else if (tt == Token.COMMENT) {
					n = scannedComments.get(scannedComments.size() - 1);
					consumeToken();
					//                    script.addComment((Comment) n);
				} 
				else {
					n = statement();
					script.addStatement((Statement) n);
					end = n.end();
				}
			}
		} catch (StackOverflowError ex) {
			String msg = lookupMessage("msg.too.deep.parser.recursion");
			if (!compilerEnv.isIdeMode())
				throw Context.reportRuntimeError(msg, sourceURI, ts.getLineno(), null, 0);
		}

		if (this.syntaxErrorCount != 0) {
			String msg = String.valueOf(this.syntaxErrorCount);
			msg = lookupMessage("msg.got.syntax.errors", msg);
			if (!compilerEnv.isIdeMode())
				throw reporter.runtimeError(msg, sourceURI, baseLineno, null, 0);
		}

		// add comments to root in lexical order
		if (scannedComments != null) {
			// If we find a comment beyond end of our last statement or
			// function, extend the root bounds to the end of that comment.
			int last = scannedComments.size() - 1;
			end = Math.max(end, scannedComments.get(last).end());
			for (Comment c : scannedComments) {
				script.addComment(c);
			}
		}
		script.setStart(pos);
		script.setEnd(ts.getSourceString().length());
		return script;
	}

	private Statement parseFunctionBody(int type, JSNode fnNode) throws IOException {
		boolean isExpressionClosure = false;
		int lc = -1;
		if (!matchToken(Token.LC, true)) {
			if (compilerEnv.getLanguageVersion() < Context.VERSION_1_8
					&& type != FunctionNode.ARROW_FUNCTION) {
				reportError("msg.no.brace.body");
			} else {
				isExpressionClosure = true;
			}
		}
		else {
			lc = ts.getTokenBeg();
		}
		++nestingOfFunction;
		int pos = ts.getTokenBeg();

		boolean savedStrictMode = inUseStrictDirective;
		inUseStrictDirective = false;
		Statement pn = null;

		try {
			if (isExpressionClosure) {
				Expression returnValue = assignExpr();
				return toVoidExpression(returnValue);
			} else {
				StatementBlock block = new StatementBlock(fnNode); // starts at LC position
				parents.push(block);
				block.setStart(pos);
				block.setLC(lc);
				int end = 0;
				bodyLoop:
					for (; ; ) {
						ASTNode n;
						int tt = peekToken();
						switch (tt) {
						case Token.ERROR:
						case Token.EOF:
						case Token.RC:
							block.setRC(ts.getTokenBeg());
							break bodyLoop;
						case Token.COMMENT:
							consumeToken();
							n = scannedComments.get(scannedComments.size() - 1);
							break;
						case Token.FUNCTION:
							consumeToken();
							n = function(FunctionNode.FUNCTION_STATEMENT);
							break;
						default:
							n = statement();
							break;
						}
						if (n instanceof Statement) {
							block.getStatements().add((Statement) n);
							end = n.end();
						}
						else if (n instanceof Comment == false) {
							Statement voidExpression = toVoidExpression((JSNode) n);
							block.getStatements().add(voidExpression);
							end = voidExpression.end();
						}
						else {
							//COMMENT?
							end = ts.getTokenEnd();
						}
					}
				block.setEnd(block.getRC() > 0 ? block.getRC() + 1 : end);
				pn = block;
			}
		} catch (ParserException e) {
			// Ignore it
		} finally {
			--nestingOfFunction;
			inUseStrictDirective = savedStrictMode;
			parents.pop();
		}
		getAndResetJsDoc();
		if (pn != null && !isExpressionClosure && mustMatchToken(Token.RC, "msg.no.brace.after.body", true)) {
			((StatementBlock) pn).setRC(ts.getTokenEnd());
		}
		return pn;
	}

	private void parseFunctionParams(FunctionStatement fnNode) throws IOException {
		if (matchToken(Token.RP, true)) {
			fnNode.setRP(ts.getTokenBeg());
			return;
		}
		// Would prefer not to call createDestructuringAssignment until codegen,
		// but the symbol definitions have to happen now, before body is parsed.
		//TODO destructuring
//		Map<String, Node> destructuring = null;
		Set<String> paramNames = new HashSet<>();
		boolean hasRestParameter = false;
		boolean hasComma = false;
		Argument prevArg = null;
		int commaPos = -1;
		do {
			if (prevArg != null) prevArg.setCommaPosition(commaPos);
			int tt = peekToken();
			if (tt == Token.RP) {
				if (hasRestParameter) {
					// Error: parameter after rest parameter
					reportError("msg.parm.after.rest", ts.getTokenBeg(), ts.getTokenEnd() - ts.getTokenBeg());
				}

				//TODO fnNode.putIntProp(Node.TRAILING_COMMA, 1);
				break;
			}
			//            if (tt == Token.LB || tt == Token.LC) {
			//                if (hasRestParameter) {
			//                    // Error: parameter after rest parameter
			//                    reportError("msg.parm.after.rest", ts.getTokenBeg(), ts.getTokenEnd() - ts.getTokenBeg());
			//                }
			//
			//                Expression expr = destructuringPrimaryExpr();
			//                markDestructuring(expr);
			//                fnNode.addParam(expr);
			//                // Destructuring assignment for parameters: add a dummy
			//                // parameter name, and add a statement to the body to initialize
			//                // variables from the destructuring assignment
			//                if (destructuring == null) {
			//                    destructuring = new HashMap<>();
			//                }
			//                String pname = currentScriptOrFn.getNextTempName();
			//                defineSymbol(Token.LP, pname, false);
			//                destructuring.put(pname, expr);
			//            } else {
			boolean wasRest = false;
			int ellipsisPos = -1;
			if (tt == Token.DOTDOTDOT) {
				if (hasRestParameter) {
					// Error: parameter after rest parameter
					reportError("msg.parm.after.rest", ts.getTokenBeg(), ts.getTokenEnd() - ts.getTokenBeg());
				}

				hasRestParameter = true;
				wasRest = true;
				ellipsisPos = ts.getTokenBeg();
				consumeToken();
			}

			if (mustMatchToken(Token.NAME, "msg.no.parm", true)) {
				if (!wasRest && hasRestParameter) {
					// Error: parameter after rest parameter
					reportError("msg.parm.after.rest", ts.getTokenBeg(), ts.getTokenEnd() - ts.getTokenBeg());
				}

				Identifier paramNameNode = createNameNode();
				Comment jsdocNodeForName = getAndResetJsDoc();
				if (jsdocNodeForName != null) {
					paramNameNode.setDocumentation(jsdocNodeForName);
				}
				Argument argument = new Argument(fnNode);
				argument.setIdentifier(paramNameNode);
				argument.setStart(ts.getTokenBeg());
				argument.setEnd(ts.getTokenEnd());
				if (wasRest) argument.setEllipsisPosition(ellipsisPos);
				fnNode.addArgument(argument);
				prevArg = argument;
				String paramName = ts.getString();
				defineSymbol(Token.LP, paramNameNode);
				if (this.inUseStrictDirective) {
					if ("eval".equals(paramName) || "arguments".equals(paramName)) {
						reportError("msg.bad.id.strict", paramName);
					}
					if (paramNames.contains(paramName)) {
						reporter.setFormattedMessage(
								JavaScriptParserProblems.DUPLICATE_PARAMETER,
								argument.getArgumentName());
						reporter.setRange(argument.sourceStart(), argument.sourceEnd());
						reporter.report();
					}
					paramNames.add(paramName);
				}
			} else {
				//                    fnNode.addParam(makeErrorNode());
			}
			//            }
			hasComma = matchToken(Token.COMMA, true);
			commaPos = ts.getTokenBeg();
		} while (hasComma);

		//        if (destructuring != null) {
		//            Node destructuringNode = new Node(Token.COMMA);
		//            // Add assignment helper for each destructuring parameter
		//            for (Map.Entry<String, Node> param : destructuring.entrySet()) {
		//                Node assign =
		//                        createDestructuringAssignment(
		//                                Token.VAR, param.getValue(), createName(param.getKey()));
		//                destructuringNode.addChildToBack(assign);
		//            }
		//            //TODO fnNode.putProp(Node.DESTRUCTURING_PARAMS, destructuringNode);
		//        }

		if (mustMatchToken(Token.RP, "msg.no.paren.after.parms", true)) {
			fnNode.setRP(ts.getTokenBeg());
		}
	}

	private FunctionStatement function(int type) throws IOException {
		return function(type, false);
	}

	private FunctionStatement function(int type, boolean isGenerator) throws IOException {
		int syntheticType = type;
		int functionSourceStart = ts.getTokenBeg(); // start of "function" kwd
		Identifier name = null;
		Expression memberExprNode = null;
		FunctionStatement fnNode = new FunctionStatement(getParent(), type == FunctionNode.FUNCTION_STATEMENT);
		SymbolTable fnScope = new SymbolTable(fnNode);
		scopes.push(fnScope);
		blockScopes.push(fnScope);
		parents.push(fnNode);
		Comment doc = getAndResetJsDoc();
		if (matchToken(Token.NAME, true)) {
			fnNode.setIsDeclaration(true);
			name = createNameNode(true, Token.NAME);
			if (inUseStrictDirective) {
				String id = name.getName();
				if ("eval".equals(id) || "arguments".equals(id)) {
					reportError("msg.bad.id.strict", id);
				}
			}
			if (!matchToken(Token.LP, true)) {
				if (compilerEnv.isAllowMemberExprAsFunctionName()) {
					Expression memberExprHead = name;
					name = null;
					memberExprNode = memberExprTail(false, memberExprHead);
				}
				mustMatchToken(Token.LP, "msg.no.paren.parms", true);
			}
		} else if (matchToken(Token.LP, true)) {
			// Anonymous function:  leave name as null
			//no need to create the function again, it is created above
			//        	fnNode = new FunctionStatement(getParent(), false);

		} else if (matchToken(Token.MUL, true)
				&& (compilerEnv.getLanguageVersion() >= Context.VERSION_ES6)) {
			// ES6 generator function
			return function(type, true);
		} else {
			if (compilerEnv.isAllowMemberExprAsFunctionName()) {
				// Note that memberExpr can not start with '(' like
				// in function (1+2).toString(), because 'function (' already
				// processed as anonymous function
				memberExprNode = memberExpr(false);
			}
			mustMatchToken(Token.LP, "msg.no.paren.parms", true);
		}
		int lpPos = currentToken == Token.LP ? ts.getTokenBeg() : -1;

		if (memberExprNode != null) {
			syntheticType = FunctionNode.FUNCTION_EXPRESSION;
		}

		fnNode.setName(name);
		fnNode.setFunctionKeyword(createKeyword(Token.FUNCTION, functionSourceStart));
		//        fnNode.setFunctionType(type);
		//NO SUPPORT FOR GENERATOR FN IN DLTK
		//        if (isGenerator) {
		//            fnNode.setIsES6Generator();
		//        }
		if (lpPos != -1) fnNode.setLP(lpPos);

		fnNode.setDocumentation(doc);

		//        PerFunctionVariables savedVars = new PerFunctionVariables(fnNode);
		try {
			parseFunctionParams(fnNode);
			fnNode.setBody((StatementBlock) parseFunctionBody(type, fnNode));
			fnNode.setStart(functionSourceStart);
			fnNode.setEnd(ts.getTokenEnd());

			//            ignore strict mode for now
			//            if (compilerEnv.isStrictMode() && !fnNode.getBody().hasConsistentReturnUsage()) {
			//                String msg =
			//                        (name != null && name.length() > 0)
			//                                ? "msg.no.return.value"
			//                                : "msg.anon.no.return.value";
			//                addStrictWarning(msg, name == null ? "" : name.getIdentifier());
			//            }
		} finally {
			//            savedVars.restore();
		}

		if (memberExprNode != null) {
			// TODO(stevey): fix missing functionality
			Kit.codeBug();
			//            fnNode.setMemberExprNode(memberExprNode); // rewrite later
			/* old code:
            if (memberExprNode != null) {
                pn = nf.createAssignment(Token.ASSIGN, memberExprNode, pn);
                if (functionType != FunctionNode.FUNCTION_EXPRESSION) {
                    // XXX check JScript behavior: should it be createExprStatement?
                    pn = nf.createExprStatementNoReturn(pn, baseLineno);
                }
            }
			 */
		}
		// Set the parent scope.  Needed for finding undeclared vars.
		// Have to wait until after parsing the function to set its parent
		// scope, since defineSymbol needs the defining-scope check to stop
		// at the function boundary when checking for redeclarations.
		//        if (compilerEnv.isIdeMode()) {
		//            fnNode.setParentScope(currentScope);
		//        }
		parents.pop();
		scopes.pop();
		blockScopes.pop();
		if (syntheticType != FunctionNode.FUNCTION_EXPRESSION
				&& name != null
				&& name.getName().length() > 0) {
			// Function statements define a symbol in the enclosing scope
			defineSymbol(Token.FUNCTION, name, false, fnNode);
			//TODO check func name?
		}
		return fnNode;
	}

	private ArrowFunctionStatement arrowFunction(Expression params) throws IOException {
		int functionSourceStart =
				params != null ? params.start() : -1; // start of "function" kwd

		ArrowFunctionStatement fnNode = new ArrowFunctionStatement(getParent());
		parents.push(fnNode);
		fnNode.setStart(functionSourceStart);
		fnNode.setArrow(ts.getTokenBeg());
		Comment doc = getAndResetJsDoc();
		fnNode.setDocumentation(doc);

		// Would prefer not to call createDestructuringAssignment until codegen,
		// but the symbol definitions have to happen now, before body is parsed.
		Map<String, Node> destructuring = new HashMap<>();
		Set<String> paramNames = new HashSet<>();

		PerFunctionVariables savedVars = new PerFunctionVariables(fnNode);
		try {
			if (params instanceof ParenthesizedExpression) {
				fnNode.setLP(functionSourceStart);
				fnNode.setRP(((ParenthesizedExpression)params).getRP());
				Expression p = ((ParenthesizedExpression) params).getExpression();
				if (!(p instanceof EmptyExpression)) {
					arrowFunctionParams(fnNode, p, destructuring, paramNames);
				}
			} else {
				arrowFunctionParams(fnNode, params, destructuring, paramNames);
			}

			if (!destructuring.isEmpty()) {
				//                Node destructuringNode = new Node(Token.COMMA);
				//                // Add assignment helper for each destructuring parameter
				//                for (Map.Entry<String, Node> param : destructuring.entrySet()) {
				//                    Node assign =
				//                            createDestructuringAssignment(
				//                                    Token.VAR, param.getValue(), createName(param.getKey()));
				//                    destructuringNode.addChildToBack(assign);
				//                }
				//                fnNode.putProp(Node.DESTRUCTURING_PARAMS, destructuringNode);
			}

			fnNode.setBody(parseFunctionBody(FunctionNode.ARROW_FUNCTION, fnNode));
			fnNode.setStart(functionSourceStart);
			fnNode.setEnd( ts.getTokenEnd());
		} finally {
			savedVars.restore();
		}

		//TODO not supported in DLTK
		//        if (fnNode.isGenerator()) {
		//            reportError("msg.arrowfunction.generator");
		//            return makeErrorNode();
		//        }

		return fnNode;
	}

	private void arrowFunctionParams(
			ArrowFunctionStatement fnNode,
			ASTNode params,
			Map<String, Node> destructuring,
			Set<String> paramNames) {
		if (params instanceof ArrayInitializer || params instanceof ObjectInitializer) {
			//            markDestructuring(params);
			//            fnNode.addParam(params);
			//            String pname = currentScriptOrFn.getNextTempName();
			//            defineSymbol(Token.LP, pname, false);
			//            destructuring.put(pname, params);
		} 
		else if (params instanceof CommaExpression) {
			for (ASTNode param : ((CommaExpression) params).getItems()) {
				arrowFunctionParams(fnNode, param, destructuring, paramNames);
			}
		} 
		else if (params instanceof Identifier) {	
			Argument arg = new Argument(fnNode);
			fnNode.addArgument(arg);
			arg.setIdentifier((Identifier) params);
			arg.setStart(params.start());
			arg.setEnd(params.end());
			String paramName = arg.getArgumentName();
			defineSymbol(Token.LP, arg.getIdentifier());

			if (this.inUseStrictDirective) {
				if ("eval".equals(paramName) || "arguments".equals(paramName)) {
					reportError("msg.bad.id.strict", paramName);
				}
				if (paramNames.contains(paramName)) {
					//addError("msg.dup.param.strict", paramName);
					reporter.setFormattedMessage(
							JavaScriptParserProblems.DUPLICATE_PARAMETER,
							arg.getArgumentName());
					reporter.setRange(arg.sourceStart(), arg.sourceEnd());
					reporter.report();
				}
				paramNames.add(paramName);
			}
		} 
		else {
			reportError("msg.no.parm", params.start(), params.end() - params.start());
			//TODO how to add an error arg?
			//            fnNode.addParam(makeErrorNode());
		}
	}

	// This function does not match the closing RC: the caller matches
	// the RC so it can provide a suitable error message if not matched.
	// This means it's up to the caller to set the length of the node to
	// include the closing RC.  The node start pos is set to the
	// absolute buffer start position, and the caller should fix it up
	// to be relative to the parent node.  All children of this block
	// node are given relative start positions and correct lengths.

	private StatementBlock statements(JSNode parent) throws IOException {
		if (currentToken != Token.LC // assertion can be invalid in bad code
				&& !compilerEnv.isIdeMode()) codeBug();
		int pos = ts.getTokenBeg();
		StatementBlock block = parent instanceof StatementBlock ? (StatementBlock) parent : new StatementBlock(getParent());
		block.setLC(pos);
		block.setStart(pos);

		int tt;
		while ((tt = peekToken()) > Token.EOF && tt != Token.RC) {
			ASTNode statement = statement();
			if (statement instanceof Statement) {
				block.getStatements().add((Statement) statement);
				((Statement) statement).setParent(block);
			}
			//TODO comment
		}
		block.setEnd(ts.getTokenEnd());
		if (tt == Token.RC) block.setRC(ts.getTokenEnd());
		return block;
	}

	private static class ConditionData {
		Expression condition;
		int lp = -1;
		int rp = -1;
	}

	// parse and return a parenthesized expression
	private ConditionData condition() throws IOException {
		ConditionData data = new ConditionData();

		if (mustMatchToken(Token.LP, "msg.no.paren.cond", true)) data.lp = ts.getTokenBeg();

		data.condition = expr(false);

		if (mustMatchToken(Token.RP, "msg.no.paren.after.cond", true)) data.rp = ts.getTokenBeg();

		// Report strict warning on code like "if (a = 7) ...". Suppress the
		// warning if the condition is parenthesized, like "if ((a = 7)) ...".
		if (data.condition instanceof BinaryOperation && ((BinaryOperation)data.condition).isAssignment()) {
			addStrictWarning(
					"msg.equal.as.assign",
					"",
					data.condition.start(),
					data.condition.end() -  data.condition.start());
		}
		return data;
	}

	private ASTNode statement() throws IOException {
		int pos = ts.getTokenBeg(), lineno = ts.getLineno();
		try {
			ASTNode pn = statementHelper();
			if (pn != null) {
				if (compilerEnv.isStrictMode()) { //TODO && !pn.hasSideEffects()) {
					int beg = pn.start();
					beg = Math.max(beg, lineBeginningFor(beg));
					addStrictWarning(
							pn instanceof EmptyStatement
							? "msg.extra.trailing.semi"
									: "msg.no.side.effects",
									"",
									beg,
									pn.end() - beg);
				}
				int ntt = peekToken();
				if (ts.getLineno() - lineno > 2 && prevTokenEnd > pn.end()) {
					//this is to match the end with the old dltk tree when the next token is following multiple newlines
					//only void expr for now

					if (ntt != Token.RC && ntt != Token.EOF && pn instanceof VoidExpression) {
						pn.setEnd(prevTokenEnd + 1);
						((VoidExpression) pn).getExpression().setEnd(prevTokenEnd + 1);
					}
				}

				if (ntt == Token.COMMENT){
					if (ts.getCommentType() == Token.CommentType.JSDOC &&  pn instanceof Documentable) {
						((Documentable)pn).setDocumentation(scannedComments.get(scannedComments.size() - 1));
					}
					consumeToken();
				}
				return pn;
			}
		} catch (ParserException e) {
			// an ErrorNode was added to the ErrorReporter
		}

		// error:  skip ahead to a probable statement boundary
		guessingStatementEnd:
			for (; ; ) {
				int tt = peekTokenOrEOL();
				consumeToken();
				switch (tt) {
				case Token.ERROR:
				case Token.EOF:
				case Token.EOL:
				case Token.SEMI:
					break guessingStatementEnd;
				}
			}
		// We don't make error nodes explicitly part of the tree;
		// they get added to the ErrorReporter.  May need to do
		// something different here.
		EmptyStatement emptyStatement = new EmptyStatement(getParent());
		emptyStatement.setStart(pos);
		emptyStatement.setEnd(ts.getTokenEnd());
		return emptyStatement;
	}

	private ASTNode statementHelper() throws IOException {
		// If the statement is set, then it's been told its label by now.
		if (currentLabel != null && currentLabel.getStatement() != null) currentLabel = null;

		JSNode pn = null;
		int tt = peekToken();

		switch (tt) {
		case Token.IF:
			return ifStatement();

		case Token.SWITCH:
			return switchStatement();

		case Token.WHILE:
			return whileLoop();

		case Token.DO:
			return doLoop();

		case Token.FOR:
			return forLoop();

		case Token.TRY:
			return tryStatement();

		case Token.THROW:
			pn = throwStatement();
			break;

		case Token.BREAK:
			pn = breakStatement();
			break;

		case Token.CONTINUE:
			pn = continueStatement();
			break;

		case Token.WITH:
			if (this.inUseStrictDirective) {
				reportError("msg.no.with.strict");
			}
			return withStatement();

		case Token.CONST:
		case Token.VAR:
			consumeToken();
			pn = variables(currentToken, ts.getTokenBeg(), true);
			break;

		case Token.LET:
			pn = letStatement();
			if (pn instanceof LetStatement && peekToken() == Token.SEMI) break;
			return pn;

		case Token.RETURN:
		case Token.YIELD:
			pn = returnOrYield(tt, false);
			break;

		case Token.DEBUGGER:
			consumeToken();
			//DLTK does not have support for this
			//                pn = new KeywordLiteral(ts.getTokenBeg(), ts.getTokenEnd() - ts.getTokenBeg(), tt);
			//                pn.setLineno(ts.getLineno());
			break;

		case Token.LC:
			return block();

		case Token.ERROR:
			consumeToken();
			return makeErrorNode();

		case Token.SEMI:
			consumeToken();
			EmptyStatement emptyStatement = new EmptyStatement(getParent());
			emptyStatement.setStart(ts.getTokenBeg());
			emptyStatement.setEnd(ts.getTokenEnd());
			return emptyStatement;

		case Token.FUNCTION:
			consumeToken();
			return function(FunctionNode.FUNCTION_EXPRESSION_STATEMENT);

		case Token.DEFAULT:
			pn = defaultXmlNamespace();
			break;

		case Token.NAME:
			pn = nameOrLabel();
			if (pn instanceof Expression) break;
			return pn; // LabeledStatement
		case Token.COMMENT:
			// Do not consume token here
			return scannedComments.get(scannedComments.size() - 1);
		default:
			pn = expr(false);
			break;
		}

		if (pn instanceof ISemicolonStatement) {
			ISemicolonStatement stmt = (ISemicolonStatement) pn;
			autoInsertSemicolon(stmt);
			pn.setEnd(Math.max(pn.sourceEnd(), stmt.getSemicolonPosition() + 1));
			return pn;
		}
		else {
			return toVoidExpression(pn);
		}
	}

	private Statement toVoidExpression(JSNode pn) throws IOException {
		if (pn == null) return null;
		VoidExpression voidExpression = new VoidExpression(getParent());
		Expression expressionNode = (Expression) pn;
		voidExpression.setExpression(expressionNode);
		assert pn.sourceStart() >= 0;
		assert pn.sourceEnd() > 0;
		voidExpression.setStart(pn.sourceStart());

		autoInsertSemicolon(voidExpression);
		voidExpression.setEnd(Math.max(pn.sourceEnd(), voidExpression.getSemicolonPosition() + 1));

		return voidExpression;
	}

	private void autoInsertSemicolon(ISemicolonStatement statement) throws IOException {
		int ttFlagged = peekFlaggedToken();
		int pos = statement.sourceStart();
		switch (ttFlagged & CLEAR_TI_MASK) {
		case Token.SEMI:
			// Consume ';' as a part of expression
			consumeToken();
			// extend the node bounds to include the semicolon.
			statement.setSemicolonPosition(ts.getTokenBeg());
			break;
		case Token.ERROR:
		case Token.EOF:
		case Token.RC:
			// Autoinsert ;
			// Token.EOF can have negative length and negative nodeEnd(pn).
			// So, make the end position at least pos+1.
			warnMissingSemi(pos, Math.max(pos + 1, statement.sourceEnd()));
			break;
		default:
			if ((ttFlagged & TI_AFTER_EOL) == 0) {
				// Report error if no EOL or autoinsert ; otherwise
				//the old parser doesn't report this
				//reportError("msg.no.semi.stmt");
			} else {
				warnMissingSemi(pos, statement.sourceEnd());
			}
			break;
		}
	}

	private IfStatement ifStatement() throws IOException {
		if (currentToken != Token.IF) codeBug();
		consumeToken();
		int pos = ts.getTokenBeg(), elsePos = -1;
		IfStatement pn = new IfStatement(getParent());
		pn.setIfKeyword(createKeyword(Token.IF, pos));
		parents.push(pn);

		ConditionData data = condition();
		Statement ifTrue = getNextStatementAfterInlineComments(pn), ifFalse = null;
		if (matchToken(Token.ELSE, true)) {
			elsePos = ts.getTokenBeg();
			int tt = peekToken();
			if (tt == Token.COMMENT) {
				// the else keyword does not support comments in dltk
				//pn.setElseKeyWordInlineComment(scannedComments.get(scannedComments.size() - 1));
				consumeToken();
			}
			ifFalse = (Statement) statement();
		}
		Statement endNode = ifFalse != null ? ifFalse : ifTrue;
		pn.setStart(pos);
		pn.setEnd(endNode.end());
		pn.setCondition(data.condition);
		pn.setLP(data.lp);
		pn.setRP(data.rp);
		pn.setThenStatement(ifTrue);
		if (ifFalse != null) {
			pn.setElseKeyword(createKeyword(Token.ELSE, elsePos));
			pn.setElseStatement(ifFalse);
		}
		parents.pop();
		return pn;
	}

	private SwitchStatement switchStatement() throws IOException {
		if (currentToken != Token.SWITCH) codeBug();
		consumeToken();
		int pos = ts.getTokenBeg();

		SwitchStatement pn = new SwitchStatement(getParent());
		pn.setSwitchKeyword(createKeyword(Token.SWITCH, pos));
		parents.push(pn);
		enterSwitch(pn);
		pn.setStart(pos);
		if (mustMatchToken(Token.LP, "msg.no.paren.switch", true)) pn.setLP(ts.getTokenBeg());

		Expression discriminant = expr(false);
		pn.setCondition(discriminant);

		try {
			if (mustMatchToken(Token.RP, "msg.no.paren.after.switch", true))
				pn.setRP(ts.getTokenBeg());

			mustMatchToken(Token.LC, "msg.no.brace.switch", true);
			pn.setLC(ts.getTokenBeg());

			boolean hasDefault = false;
			int tt;
			switchLoop:
				for (; ; ) {
					tt = nextToken();
					SwitchComponent comp = null;
					switch (tt) {
					case Token.RC:
						pn.setRC(ts.getTokenBeg());
						pn.setEnd(ts.getTokenEnd());
						break switchLoop;

					case Token.CASE:
						comp = new CaseClause(pn);
						parents.push(comp);
						((CaseClause) comp).setCaseKeyword(createKeyword(Token.CASE, ts.getTokenBeg()));
						comp.setStart(ts.getTokenBeg());
						Expression caseExpression = expr(false);
						((CaseClause) comp).setCondition(caseExpression);
						mustMatchToken(Token.COLON, "msg.no.colon.case", true);
						comp.setColonPosition(ts.getTokenBeg());
						pn.addCase(comp);
						comp.setEnd(ts.getTokenEnd()); //in case of multiple case clauses
						break;

						case Token.DEFAULT:
							if (hasDefault) {
								//reportError("msg.double.switch.default");
								reporter.setMessage(JavaScriptParserProblems.DOUBLE_SWITCH_DEFAULT);
								reporter.setSeverity(ProblemSeverity.ERROR);
								reporter.setRange(ts.getTokenBeg(), ts.getTokenEnd());
								reporter.report();
							}
							hasDefault = true;
							comp = new DefaultClause(pn);
							parents.push(comp);
							((DefaultClause) comp).setDefaultKeyword(createKeyword(Token.DEFAULT, ts.getTokenBeg()));
							comp.setStart(ts.getTokenBeg());
							mustMatchToken(Token.COLON, "msg.no.colon.case", true);
							comp.setColonPosition(ts.getTokenBeg());
							pn.addCase(comp);
							break;
						case Token.COMMENT:
							Comment n = scannedComments.get(scannedComments.size() - 1);
							if (n.isDocumentation() && pn instanceof Documentable) {
								((Documentable) pn).setDocumentation(n);
							}
							continue switchLoop;
						default:
							reportError("msg.bad.switch");
							break switchLoop;
					}

					while ((tt = peekToken()) != Token.RC
							&& tt != Token.CASE
							&& tt != Token.DEFAULT
							&& tt != Token.EOF) {
						if (tt == Token.COMMENT) {
							//just consume the token, case nodes do not need comments in DLTK
							consumeToken();
							continue;
						}
						ASTNode nextStmt = statement();
						comp.getStatements().add((Statement) nextStmt);
						comp.setEnd(nextStmt.end() > 0 ? nextStmt.end() : ts.getTokenEnd());
					}
					parents.pop();
				}
		} finally {
			exitSwitch();
			parents.pop();
		}
		return pn;
	}

	private WhileStatement whileLoop() throws IOException {
		if (currentToken != Token.WHILE) codeBug();
		consumeToken();
		int pos = ts.getTokenBeg();
		WhileStatement pn = new WhileStatement(getParent());
		parents.push(pn);
		pn.setWhileKeyword(createKeyword(Token.WHILE, pos));
		pn.setStart(pos);
		enterLoop(pn);
		try {
			ConditionData data = condition();
			pn.setCondition(data.condition);
			pn.setLP(data.lp);
			pn.setRP(data.rp);
			Statement body = getNextStatementAfterInlineComments(pn);
			pn.setEnd(body.end());
			pn.setBody(body);
		} finally {
			exitLoop();
			parents.pop();
		}
		return pn;
	}

	private DoWhileStatement doLoop() throws IOException {
		if (currentToken != Token.DO) codeBug();
		consumeToken();
		int pos = ts.getTokenBeg(), end = -1;
		DoWhileStatement pn = new DoWhileStatement(getParent());
		parents.push(pn);
		pn.setDoKeyword(createKeyword(Token.DO, pos));
		enterLoop(pn);
		try {
			Statement body = getNextStatementAfterInlineComments(pn);
			mustMatchToken(Token.WHILE, "msg.no.while.do", true);
			pn.setWhileKeyword(createKeyword(Token.WHILE, ts.getTokenBeg()));
			ConditionData data = condition();
			pn.setCondition(data.condition);
			pn.setLP(data.lp);
			pn.setRP(data.rp);
			pn.setBody(body);
			end = ts.getTokenEnd();
		} finally {
			exitLoop();
			parents.pop();
		}
		// Always auto-insert semicolon to follow SpiderMonkey:
		// It is required by ECMAScript but is ignored by the rest of
		// world, see bug 238945
		if (matchToken(Token.SEMI, true)) {
			end = ts.getTokenEnd();
			pn.setSemicolonPosition(ts.getTokenBeg());
		}
		pn.setEnd(end);
		return pn;
	}

	private int peekUntilNonComment(int tt) throws IOException {
		while (tt == Token.COMMENT) {
			consumeToken();
			tt = peekToken();
		}
		return tt;
	}

	private Statement getNextStatementAfterInlineComments(JSNode pn) throws IOException {
		ASTNode body = statement();
		if (body instanceof Comment) {
			Comment commentNode = (Comment)body;
			body = statement();
			if (body instanceof Documentable) {
				((Documentable) body).setDocumentation(commentNode);
			}
		}
		return (Statement) body;
	}

	private AbstractForStatement forLoop() throws IOException {
		if (currentToken != Token.FOR) codeBug();
		consumeToken();
		int forPos = ts.getTokenBeg();
		boolean isForEach = false, isForIn = false, isForOf = false;
		int eachPos = -1, lp = -1, rp = -1;
		Keyword forKeyword = createKeyword(Token.FOR, forPos);
		Expression init = null; // init is also foo in 'foo in object'
		Expression cond = null; // cond is also object in 'foo in object'
		Expression incr = null;
		AbstractForStatement pn = null;
		//add temp scope
		blockScopes.push(new SymbolTable(new ForStatement(null)));

		//        Scope tempScope = new Scope();
		//        pushScope(tempScope); // decide below what AST class to use
		try {
			// See if this is a for each () instead of just a for ()
			if (matchToken(Token.NAME, true)) {
				//TODO check for each in
				if ("each".equals(ts.getString())) {
					isForEach = true;
					eachPos = ts.getTokenBeg();
				} else {
					reportError("msg.no.paren.for");
				}
			}

			if (mustMatchToken(Token.LP, "msg.no.paren.for", true)) lp = ts.getTokenBeg();
			int tt = peekToken();

			init = forLoopInit(tt);
			if (matchToken(Token.IN, true)) {
				isForIn = true;
				ForInStatement forin = null;
				if (isForEach) {
					forin = new ForEachInStatement(getParent());
					final Keyword keyword = new Keyword("each");
					keyword.setStart(eachPos);
					keyword.setEnd(eachPos + keyword.getKeyword().length());
					((ForEachInStatement)forin).setEachKeyword(keyword);
				}
				else {
					forin = new ForInStatement(getParent());
				}
				blockScopes.pop(); // remove the temp scope
				blockScopes.push(new SymbolTable(forin));
				forin.setForKeyword(forKeyword);
				forin.setInKeyword(createKeyword(Token.IN, ts.getTokenBeg()));
				parents.push(forin);
				markDestructuring(init);
				cond = expr(false); // object over which we're iterating
				forin.setItem(init);
				forin.setIterator(cond);
				pn = forin;
			} else if (compilerEnv.getLanguageVersion() >= Context.VERSION_ES6
					&& matchToken(Token.NAME, true)
					&& "of".equals(ts.getString())) {
				isForOf = true;
				ForOfStatement forof = new ForOfStatement(getParent());
				blockScopes.pop();// remove the temp scope
				blockScopes.push(new SymbolTable(forof));
				forof.setForKeyword(forKeyword);
				final Keyword keyword = new Keyword("of");
				keyword.setStart(ts.getTokenBeg());
				keyword.setEnd(ts.getTokenEnd());
				forof.setOfKeyword(keyword);
				parents.push(forof);
				markDestructuring(init);
				cond = expr(false); // object over which we're iterating
				forof.setItem(init);
				forof.setIterator(cond);
				pn = forof;
			} else { // ordinary for-loop
				ForStatement forStatement = new ForStatement(getParent());
				blockScopes.pop();// remove the temp scope
				blockScopes.push(new SymbolTable(forStatement));
				forStatement.setForKeyword(forKeyword);
				forStatement.setInitial(init);
				parents.push(forStatement);
				if (mustMatchToken(Token.SEMI, "msg.no.semi.for", true)) {
					forStatement.setInitialSemicolonPosition(ts.getTokenBeg());
				}
				if (peekToken() == Token.SEMI) {
					// no loop condition
					cond = new EmptyExpression(getParent());
					cond.setStart(ts.getTokenBeg());
					cond.setEnd(ts.getTokenBeg());
				} else {
					cond = expr(false);
				}
				forStatement.setCondition(cond);

				if (mustMatchToken(Token.SEMI, "msg.no.semi.for.cond", true)) {
					forStatement.setConditionalSemicolonPosition(ts.getTokenBeg());
				}
				int tmpPos = ts.getTokenEnd();
				if (peekToken() == Token.RP) {
					incr = new EmptyExpression(getParent());
					//TODO old transformers do not set start&end when incr is empty expr!                    
					//                    incr.setStart(tmpPos);
					//                    incr.setEnd(tmpPos);
				} else {
					incr = expr(false);
				}
				forStatement.setStep(incr);
				pn = forStatement;
			}
			init.setParent(getParent());

			if (mustMatchToken(Token.RP, "msg.no.paren.for.ctrl", true)) rp = ts.getTokenBeg();

			if (isForIn || isForOf) {
				if (init instanceof IVariableStatement) {
					// check that there was only one variable given
					if (((IVariableStatement) init).getVariables().size() > 1) {
						reportError("msg.mult.index");
					}
					else if (((IVariableStatement) init).getVariables().size() == 1){
						VariableDeclaration d = ((IVariableStatement) init).getVariables().get(0);
						//TODO use temp scope to check for dupl?
						SymbolKind kind = SymbolKind.VAR;
						if (init instanceof LetStatement) kind = SymbolKind.LET;
						if (init instanceof ConstStatement) kind = SymbolKind.CONST;
						blockScopes.peek().add(d.getVariableName(), kind, d);
					}
				}
				if (isForOf && isForEach) {
					reportError("msg.invalid.for.each");
				}
			}


			// replace temp scope with the new loop object
			//            currentScope.replaceWith(pn);
			//            popScope();

			// We have to parse the body -after- creating the loop node,
			// so that the loop node appears in the loopSet, allowing
			// break/continue statements to find the enclosing loop.
			enterLoop(pn);
			try {
				Statement body = getNextStatementAfterInlineComments(pn);
				pn.setEnd(body.end());
				pn.setBody(body);
			} finally {
				exitLoop();
			}

		} finally {
			//            if (currentScope == tempScope) {
			//                popScope();
			//            }
			blockScopes.pop();
			parents.pop();
		}
		pn.setStart(forPos);
		pn.setLP(lp);
		pn.setRP(rp);
		return pn;
	}

	private Expression forLoopInit(int tt) throws IOException {
		try {
			inForInit = true; // checked by variables() and relExpr()
			Expression init = null;
			if (tt == Token.SEMI) {
				init = new EmptyExpression(getParent());
				init.setStart(ts.getTokenBeg());
				init.setEnd(ts.getTokenBeg());
			} else if (tt == Token.VAR || tt == Token.LET) {
				consumeToken();
				init = variables(tt, ts.getTokenBeg(), false);
			} else {
				init = expr(false);
			}
			return init;
		} finally {
			inForInit = false;
		}
	}

	private TryStatement tryStatement() throws IOException {
		if (currentToken != Token.TRY) codeBug();
		consumeToken();

		// Pull out JSDoc info and reset it before recursing.
		getAndResetJsDoc();

		int tryPos = ts.getTokenBeg();

		TryStatement pn = new TryStatement(getParent());
		parents.push(pn);
		pn.setStart(tryPos);
		pn.setTryKeyword(createKeyword(Token.TRY, tryPos));
		// Hnadled comment here because there should not be try without LC
		int lctt = peekToken();
		while (lctt == Token.COMMENT) {
			//the Trystatment is not documentable, skip comment
			consumeToken();
			lctt = peekToken();
		}
		if (lctt != Token.LC) {
			reportError("msg.no.brace.try");
		}
		StatementBlock tryBlock = (StatementBlock) getNextStatementAfterInlineComments(pn);
		int tryEnd = tryBlock.end();

		List<CatchClause> clauses = new ArrayList<>();

		boolean sawDefaultCatch = false;
		int peek = peekToken();
		while (peek == Token.COMMENT) {
			//            Comment commentNode = scannedComments.get(scannedComments.size() - 1);
			//            pn.setInlineComment(commentNode);
			consumeToken();
			peek = peekToken();
		}
		if (peek == Token.CATCH) {
			while (matchToken(Token.CATCH, true)) {                
				if (sawDefaultCatch) {
					reportError("msg.catch.unreachable");
				}
				int catchPos = ts.getTokenBeg(), lp = -1, rp = -1, guardPos = -1;
				CatchClause catchNode = new CatchClause(getParent());
				catchNode.setStart(catchPos);
				catchNode.setCatchKeyword(createKeyword(Token.CATCH, catchPos));
				parents.push(catchNode);

				Identifier varName = null;
				Expression catchCond = null;
				Statement catchBlock = null;

				switch (peekToken()) {
				case Token.LP:
				{
					matchToken(Token.LP, true);
					lp = ts.getTokenBeg();
					mustMatchToken(Token.NAME, "msg.bad.catchcond", true);

					varName = createNameNode();
					Comment jsdocNodeForName = getAndResetJsDoc();
					if (jsdocNodeForName != null) {
						varName.setDocumentation(jsdocNodeForName);
					}
					String varNameString = varName.getName();
					if (inUseStrictDirective) {
						if ("eval".equals(varNameString)
								|| "arguments".equals(varNameString)) {
							reportError("msg.bad.id.strict", varNameString);
						}
					}

					if (matchToken(Token.IF, true)) {
						guardPos = ts.getTokenBeg();
						catchCond = expr(false);
					} else {
						sawDefaultCatch = true;
					}

					if (mustMatchToken(Token.RP, "msg.bad.catchcond", true)) {
						rp = ts.getTokenBeg();
					}
					mustMatchToken(Token.LC, "msg.no.brace.catchblock", true);
					catchBlock = statements(catchNode);
				}
				break;
				case Token.LC:
					if (compilerEnv.getLanguageVersion() >= Context.VERSION_ES6) {
						matchToken(Token.LC, true);
					} else {
						reportError("msg.no.paren.catch");
					}
					break;
				default:
					reportError("msg.no.paren.catch");
					break;
				}

				try {
					if (catchBlock == null) {
						catchBlock = (Statement) statement();
					}
				} finally {
					parents.pop();
				}

				tryEnd = catchNode.end();
				catchNode.setException(varName);
				catchNode.setStatement(catchBlock);
				if (guardPos != -1) {
					catchNode.setFilterExpression(catchCond);
					catchNode.setIfKeyword(createKeyword(Token.IF, guardPos));
				}
				catchNode.setLP(lp);
				catchNode.setRP(rp);

				if (mustMatchToken(Token.RC, "msg.no.brace.after.body", true)) tryEnd = ts.getTokenEnd();
				catchNode.setEnd(tryEnd);
				clauses.add(catchNode);
			}
		} else if (peek != Token.FINALLY) {
			mustMatchToken(Token.FINALLY, "msg.try.no.catchfinally", true);
		}

		FinallyClause finallyclause = null;
		if (matchToken(Token.FINALLY, true)) {
			finallyclause = new FinallyClause(getParent());
			finallyclause.setFinallyKeyword(createKeyword(Token.FINALLY, ts.getTokenBeg()));
			finallyclause.setStart(ts.getTokenBeg());
			parents.push(finallyclause);
			Statement finallyBlock = (Statement)statement();
			finallyclause.setStatement(finallyBlock);
			finallyclause.setEnd(finallyBlock.end());
			tryEnd = finallyBlock.end();
			parents.pop();
		}

		pn.setEnd(tryEnd);
		pn.setBody(tryBlock);
		pn.getCatches().addAll(clauses);
		pn.setFinally(finallyclause);
		pn.setEnd(tryEnd);
		parents.pop();
		return pn;
	}

	private ThrowStatement throwStatement() throws IOException {
		if (currentToken != Token.THROW) codeBug();
		consumeToken();
		int pos = ts.getTokenBeg();
		if (peekTokenOrEOL() == Token.EOL) {
			// ECMAScript does not allow new lines before throw expression,
			// see bug 256617
			reportError("msg.bad.throw.eol");
		}
		Expression expr = expr(false);
		ThrowStatement pn = new ThrowStatement(getParent());
		pn.setThrowKeyword(createKeyword(Token.THROW, pos));
		pn.setStart(pos);
		pn.setEnd(ts.getTokenEnd());
		pn.setException(expr);
		expr.setParent(pn);
		return pn;
	}

	// If we match a NAME, consume the token and return the statement
	// with that label.  If the name does not match an existing label,
	// reports an error.  Returns the labeled statement node, or null if
	// the peeked token was not a name.  Side effect:  sets scanner token
	// information for the label identifier (tokenBeg, tokenEnd, etc.)

	private LabelledStatement matchJumpLabelName() throws IOException {
		LabelledStatement label = null;

		if (peekTokenOrEOL() == Token.NAME) {
			consumeToken();
			if (labelSet != null) {
				label = labelSet.get(ts.getString());
			}
			if (label == null) {
				reportError("msg.undef.label");
			}
		}

		return label;
	}

	private BreakStatement breakStatement() throws IOException {
		if (currentToken != Token.BREAK) codeBug();
		consumeToken();
		int pos = ts.getTokenBeg(), end = ts.getTokenEnd();

		BreakStatement pn = new BreakStatement(getParent());
		pn.setBreakKeyword(createKeyword(Token.BREAK, pos));
		parents.push(pn);

		Label breakLabel = null;
		if (peekTokenOrEOL() == Token.NAME) {
			breakLabel = createLabelNode();
			end = breakLabel.end();
		}

		// matchJumpLabelName only matches if there is one
		LabelledStatement labels = matchJumpLabelName();
		// always use first label as target
		Statement breakTarget = labels == null ? null : labels.getStatement();

		if (breakTarget == null && breakLabel == null) {
			if (loopAndSwitchSet == null || loopAndSwitchSet.size() == 0) {
				reportError("msg.bad.break", pos, end - pos);
			} else {
				breakTarget = loopAndSwitchSet.get(loopAndSwitchSet.size() - 1);
			}
		}

		pn.setStart(pos);
		pn.setEnd(end);
		// can be null if it's a bad break in error-recovery mode
		if (breakLabel != null)
			pn.setLabel(breakLabel);
		parents.pop();
		return pn;
	}

	private ContinueStatement continueStatement() throws IOException {
		if (currentToken != Token.CONTINUE) codeBug();
		consumeToken();
		int pos = ts.getTokenBeg(), end = ts.getTokenEnd();
		Label label = null;
		ContinueStatement pn = new ContinueStatement(getParent());
		pn.setContinueKeyword(createKeyword(Token.CONTINUE, pos));
		parents.push(pn);
		if (peekTokenOrEOL() == Token.NAME) {
			label = createLabelNode();
			end = label.end();
			pn.setLabel(label);
		}

		// matchJumpLabelName only matches if there is one
		LabelledStatement labels = matchJumpLabelName();
		LoopStatement target = null;
		if (labels == null && label == null) {
			if (loopSet == null || loopSet.size() == 0) {
				reportError("msg.continue.outside");
			} else {
				target = loopSet.get(loopSet.size() - 1);
			}
		} else {
			if (labels == null || !(labels.getStatement() instanceof LoopStatement)) {
				reportError("msg.continue.nonloop", pos, end - pos);
			}
			target = labels == null ? null : (LoopStatement) labels.getStatement();
		}

		pn.setStart(pos);
		pn.setEnd(end);
		if (target != null) // can be null in error-recovery mode
			pn.setLabel(label);
		parents.pop();
		return pn;
	}

	private WithStatement withStatement() throws IOException {
		if (currentToken != Token.WITH) codeBug();
		consumeToken();
		WithStatement pn = new WithStatement(getParent());
		parents.push(pn);

		//the with statement is not documentable
		getAndResetJsDoc();

		int pos = ts.getTokenBeg(), lp = -1, rp = -1;
		if (mustMatchToken(Token.LP, "msg.no.paren.with", true)) lp = ts.getTokenBeg();

		Expression obj = expr(false);

		if (mustMatchToken(Token.RP, "msg.no.paren.after.with", true)) rp = ts.getTokenBeg();

		pn.setWithKeyword(createKeyword(Token.WITH, pos));
		pn.setStart(pos);
		Statement body = getNextStatementAfterInlineComments(pn);
		pn.setEnd(body.end());
		//        pn.setJsDocNode(withComment);
		pn.setExpression(obj);
		pn.setStatement(body);
		pn.setLP(lp);
		pn.setRP(rp);
		parents.pop();
		return pn;
	}

	private Expression letStatement() throws IOException {
		if (currentToken != Token.LET) codeBug();
		consumeToken();
		int pos = ts.getTokenBeg();
		Expression pn;
		if (peekToken() == Token.LP) {
			pn = let(true, pos);
		} else {
			pn = variables(Token.LET, pos, true); // else, e.g.: let x=6, y=7;
		}
		return pn;
	}

	/**
	 * Returns whether or not the bits in the mask have changed to all set.
	 *
	 * @param before bits before change
	 * @param after bits after change
	 * @param mask mask for bits
	 * @return {@code true} if all the bits in the mask are set in "after" but not in "before"
	 */
	private static final boolean nowAllSet(int before, int after, int mask) {
		return ((before & mask) != mask) && ((after & mask) == mask);
	}

	private JSNode returnOrYield(int tt, boolean exprContext) throws IOException {
		if (!insideFunction()) {
			reportError(tt == Token.RETURN ? "msg.bad.return" : "msg.bad.yield");
		}
		consumeToken();
		int pos = ts.getTokenBeg(), end = ts.getTokenEnd();

		//TODO DLTK does not support yieldStar
		boolean yieldStar = false;
		if ((tt == Token.YIELD)
				&& (compilerEnv.getLanguageVersion() >= Context.VERSION_ES6)
				&& (peekToken() == Token.MUL)) {
			yieldStar = true;
			consumeToken();
		}

		JSNode ret = null;
		if (tt == Token.RETURN) {
			ReturnStatement ret_ = new ReturnStatement(getParent());
			ret_.setReturnKeyword(createKeyword(tt, pos));
			ret = ret_;
		} 
		else {
			if (!insideFunction()) reportError("msg.bad.yield");
			endFlags |= Node.END_YIELDS;            
			YieldOperator op = new YieldOperator(getParent());
			op.setYieldKeyword(createKeyword(Token.YIELD, pos));
			ret = op;
		}

		Expression e = null;
		// This is ugly, but we don't want to require a semicolon.
		int peekTokenOrEOL = peekTokenOrEOL();
		switch (peekTokenOrEOL) {
		case Token.SEMI:
		case Token.RC:
		case Token.RB:
		case Token.RP:
		case Token.EOF:
		case Token.EOL:
		case Token.ERROR:
			break;
		case Token.YIELD:
			if (compilerEnv.getLanguageVersion() < Context.VERSION_ES6) {
				// Take extra care to preserve language compatibility
				break;
			}
			// fallthrough
		default:
			//the original parser does not do this and fails for return //comment !
			Comment jsdoc = null;
			boolean endOfStatement = false;
			if (peekTokenOrEOL == Token.COMMENT) {
				CommentType commentType = ts.getCommentType();
				if (commentType == Token.CommentType.JSDOC)
				{
					jsdoc = getAndResetJsDoc();
					consumeToken();
				}
				else {
					//end of statement
					consumeToken();
					endOfStatement = true;
				}
			}

			if (!endOfStatement) {
				parents.push(ret);
				e = expr(false);
				parents.pop();
				end = e.end();

				//the original parser does not do this
				if (e instanceof Documentable) {
					((Documentable)e).setDocumentation(jsdoc);
				}
			}
		}

		int before = endFlags;

		if (tt == Token.RETURN) {
			endFlags |= e == null ? Node.END_RETURNS : Node.END_RETURNS_VALUE;
			((ReturnStatement) ret).setValue(e);

			// see if we need a strict mode warning
			if (nowAllSet(before, endFlags, Node.END_RETURNS | Node.END_RETURNS_VALUE))
				addStrictWarning("msg.return.inconsistent", "", pos, end - pos);
		} 
		else {
			if (!insideFunction()) reportError("msg.bad.yield");
			endFlags |= Node.END_YIELDS;            
			if (e != null) {
				((YieldOperator) ret).setExpression(e);
			}
			ret.setStart(pos);
			ret.setEnd(end);
			if (!exprContext) {
				YieldOperator op = (YieldOperator) ret;
				ret = new VoidExpression(getParent());
				((VoidExpression)ret).setExpression(op);
			}
			//            setIsGenerator();

		}
		ret.setStart(pos);
		ret.setEnd(end);

		// see if we are mixing yields and value returns.
		if (insideFunction()
				&& nowAllSet(before, endFlags, Node.END_YIELDS | Node.END_RETURNS_VALUE)) {

			//if (!fn.isES6Generator()) {
			if (currentScriptOrFn instanceof FunctionStatement) {
				Identifier name = ((FunctionStatement) currentScriptOrFn).getIdentifier();
				if (name == null || name.getName().length() == 0) {
					addError("msg.anon.generator.returns", "");
				} else {
					addError("msg.generator.returns", name.getName());
				}
			}
		}
		return ret;
	}

	private StatementBlock block() throws IOException {
		if (currentToken != Token.LC) codeBug();
		consumeToken();
		int pos = ts.getTokenBeg();

		StatementBlock block = new StatementBlock(getParent());
		parents.push(block);
		SymbolTable blockScope = new SymbolTable((StatementBlock)getParent());
		blockScopes.push(blockScope);

		try {
			statements(block);
			block.setStart(pos);
			block.setLC(pos);
			if (mustMatchToken(Token.RC, "msg.no.brace.block", true)) {
				block.setRC(ts.getTokenEnd() - 1);
			}
			block.setEnd(ts.getTokenEnd());

			return block;
		} finally {
			blockScopes.pop();
			parents.pop();
		}
	}

	private Expression defaultXmlNamespace() throws IOException {
		if (currentToken != Token.DEFAULT) codeBug();
		consumeToken();
		mustHaveXML();
		//      setRequiresActivation();
		//      int lineno = ts.getLineno(), pos = ts.getTokenBeg();
		//
		//      if (!(matchToken(Token.NAME, true) && "xml".equals(ts.getString()))) {
		//          reportError("msg.bad.namespace");
		//      }
		//      if (!(matchToken(Token.NAME, true) && "namespace".equals(ts.getString()))) {
		//          reportError("msg.bad.namespace");
		//      }
		//      if (!matchToken(Token.ASSIGN, true)) {
		//          reportError("msg.bad.namespace");
		//      }
		//
		//      AstNode e = null; //TODO expr(false);
		//      UnaryExpression dxmln = new UnaryExpression(pos, getNodeEnd(e) - pos);
		//      dxmln.setOperator(Token.DEFAULTNAMESPACE);
		//      dxmln.setOperand(e);
		//      dxmln.setLineno(lineno);
		//
		//      ExpressionStatement es = new ExpressionStatement(dxmln, true);
		//      return es;
		reportError("msg.XML.not.available");
		return makeErrorNode();
	}

	private void recordLabel(Label label, LabelledStatement bundle) throws IOException {
		// current token should be colon that primaryExpr left untouched
		if (peekToken() != Token.COLON) codeBug();
		consumeToken();
		bundle.setColonPosition(ts.getTokenBeg());
		String name = label.getText();
		if (labelSet == null) {
			labelSet = new HashMap<>();
		} else {
			LabelledStatement ls = labelSet.get(name);
			if (ls != null) {
				Label l = label;
				if (compilerEnv.isIdeMode()) {
					l = ls.getLabel();					
				}
//				reportError("msg.dup.label", label.sourceStart(), label.sourceEnd() - label.sourceStart());
				reporter.setMessage(JavaScriptParserProblems.DUPLICATE_LABEL);
				reporter.setSeverity(ProblemSeverity.ERROR);
				reporter.setRange(l.sourceStart(), l.sourceEnd());
				reporter.report();
			}
		}
		bundle.setLabel(label);
		label.setParent(bundle);
		labelSet.put(name, bundle);
	}

	/**
	 * Found a name in a statement context. If it's a label, we gather up any following labels and
	 * the next non-label statement into a {@link LabeledStatement} "bundle" and return that.
	 * Otherwise we parse an expression and return it wrapped in an {@link ExpressionStatement}.
	 */
	private JSNode nameOrLabel() throws IOException {
		if (currentToken != Token.NAME) throw codeBug();
		int pos = ts.getTokenBeg();
		int end = -1;

		// set check for label and call down to primaryExpr
		currentFlaggedToken |= TI_CHECK_LABEL;
		ASTNode expr = expr(false);

		if (expr instanceof Label == false) {
			return expr instanceof JSNode ? (JSNode) expr : makeErrorNode();
		}

		LabelledStatement bundle = new LabelledStatement(getParent());
		recordLabel((Label) expr, bundle);
		// look for more labels
		ASTNode stmt = null;
		while (peekToken() == Token.NAME) {
			currentFlaggedToken |= TI_CHECK_LABEL;
			expr = expr(false);
			if (expr instanceof LabelledStatement) {
				stmt = toVoidExpression((JSNode) expr);
				autoInsertSemicolon((ISemicolonStatement) stmt);
				break;
			}
		}

		// no more labels; now parse the labeled statement
		try {
			currentLabel = bundle;
			if (stmt == null) {
				int lineno = ts.getLineno();
				stmt = statementHelper();
				int ntt = peekToken();
				if (ntt == Token.COMMENT && lineno == lastCommentLineno) {
					consumeToken();
				}
			}
		} finally {
			currentLabel = null;
			// remove the labels for this statement from the global set
			//            for (Label lb : bundle.getLabels()) {
			//                labelSet.remove(lb.getName());
			//            }
			//DLTK has support for only one label
			labelSet.remove(bundle.getLabel().getText());
		}

		// If stmt has parent assigned its position already is relative
		// (See bug #710225)
		if (stmt instanceof Statement) {
			bundle.setStatement((Statement) stmt);
			((JSNode) stmt).setParent(bundle);
			end = stmt.end();
		}
		bundle.setStart(pos);
		bundle.setEnd(end);
		return bundle;
	}

	/**
	 * Parse a 'var' or 'const' statement, or a 'var' init list in a for statement.
	 *
	 * @param declType A token value: either VAR, CONST, or LET depending on context.
	 * @param pos the position where the node should start. It's sometimes the var/const/let
	 *     keyword, and other times the beginning of the first token in the first variable
	 *     declaration.
	 * @return the parsed variable list
	 */
	private Expression variables(int declType, int pos, boolean isStatement)
			throws IOException {
		IVariableStatement variableStatement = createIVariableStatement(
				declType, pos);

		Comment varjsdocNode = getAndResetJsDoc();
		if (varjsdocNode != null) {
			((Documentable) variableStatement).setDocumentation(varjsdocNode);
		}
		// Example:
		// var foo = {a: 1, b: 2}, bar = [3, 4];
		// var {b: s2, a: s1} = foo, x = 6, y, [s3, s4] = bar;
		int end;
		for (; ; ) {
			Expression destructuring = null;
			Identifier name = null;
			int tt = peekToken(), kidPos = ts.getTokenBeg();
			end = ts.getTokenEnd();

			if (tt == Token.LB || tt == Token.LC) {
				// Destructuring assignment, e.g., var [a,b] = ...
				// TODO not supported in DLTK
//				destructuring = destructuringPrimaryExpr();
//				end = destructuring.end();
//				if (!(destructuring instanceof DestructuringForm))
//					reportError("msg.bad.assign.left", kidPos, end - kidPos);
				//markDestructuring(destructuring);
			} else {
				// Simple variable name
				mustMatchToken(Token.NAME, "msg.bad.var", true);
				name = createNameNode();
				if (inUseStrictDirective) {
					String id = ts.getString();
					if ("eval".equals(id) || "arguments".equals(ts.getString())) {
						reportError("msg.bad.id.strict", id);
					}
				}
				// moved lower    defineSymbol(declType, ts.getString(), inForInit, variableDeclaration);
			}

			Comment jsdocNode = getAndResetJsDoc();
			if (jsdocNode != null) 
			{
				((Documentable)variableStatement).setDocumentation(jsdocNode);
			}
			VariableDeclaration variableDeclaration = new VariableDeclaration(variableStatement); 
			parents.push(variableDeclaration);
			Expression init = null;
			tt = peekToken();
			int assignPos = -1;
			if (matchToken(Token.ASSIGN, true)) {
				assignPos = ts.getTokenBeg();
				init = assignExpr();
				end = init.sourceEnd();
			}
			if (destructuring != null) {
				//                if (init == null && !inForInit) {
				//                    reportError("msg.destruct.assign.no.init");
				//                }
				//                vi.setTarget(destructuring);
			} else {
				variableDeclaration.setIdentifier(name);   
				name.setParent(variableDeclaration);
			}
			variableDeclaration.setStart(kidPos);
			variableDeclaration.setEnd(end);
			variableDeclaration.setInitializer(init);
			variableDeclaration.setAssignPosition(assignPos);
			variableStatement.addVariable(variableDeclaration);
			defineSymbol(declType, variableDeclaration.getIdentifier(), inForInit, variableDeclaration);

			parents.pop();
			if (!matchToken(Token.COMMA, true)) break;
		}
		Expression ex = (Expression) variableStatement;
		ex.setStart(pos);
		ex.setEnd(end);
		return ex;
	}

	private IVariableStatement createIVariableStatement(int declType, int pos) {
		Keyword keyword = createKeyword(declType, pos);
		if (declType == Token.VAR) {
			VariableStatement variableStatement = new VariableStatement(getParent());
			variableStatement.setVarKeyword(keyword);
			return variableStatement;
		}
		if (declType == Token.LET) {
			LetStatement variableStatement = new LetStatement(getParent());
			variableStatement.setLetKeyword(keyword);
			return variableStatement;
		}
		if (declType == Token.CONST) {
			ConstStatement variableStatement = new ConstStatement(getParent());
			variableStatement.setConstKeyword(keyword);
			return variableStatement;
		}
		return null;
	}

	// have to pass in 'let' kwd position to compute kid offsets properly
	private Expression let(boolean isStatement, int pos) throws IOException {
		//TODO not supported yet in DLTK
		//        LetStatement pn = new LetStatement(getParent());
		//        pn.setStart(pos);
		//        if (mustMatchToken(Token.LP, "msg.no.paren.after.let", true)) pn.setLP(ts.getTokenBeg());
		//        pushScope(pn);
		//        try {
		//            VariableDeclaration vars = variables(Token.LET, ts.getTokenBeg(), isStatement);
		//            pn.setVariables(vars);
		//            if (mustMatchToken(Token.RP, "msg.no.paren.let", true)) {
		//                pn.setRp(ts.getTokenBeg() - pos);
		//            }
		//            if (isStatement && peekToken() == Token.LC) {
		//                // let statement
		//                consumeToken();
		//                int beg = ts.getTokenBeg(); // position stmt at LC
		//                AstNode stmt = statements();
		//                mustMatchToken(Token.RC, "msg.no.curly.let", true);
		//                stmt.setLength(ts.getTokenEnd() - beg);
		//                pn.setLength(ts.getTokenEnd() - pos);
		//                pn.setBody(stmt);
		//                pn.setType(Token.LET);
		//            } else {
		//                // let expression
		//                Expression expr = expr(false);
		//                
		//                pn.setLength(getNodeEnd(expr) - pos);
		//                pn.setBody(expr);
		//                if (isStatement) {
		//                    // let expression in statement context
		//                    ExpressionStatement es = new ExpressionStatement(pn, !insideFunction());
		//                    es.setLineno(pn.getLineno());
		//                    return es;
		//                }
		//            }
		//        } finally {
		//            popScope();
		//        }
		//        return pn;
		return makeErrorNode();
	}

	void defineSymbol(int declType, Identifier name) {
		defineSymbol(declType, name, false, null);
	}

	void defineSymbol(int declType, Identifier name, boolean ignoreNotInBlock, JSDeclaration declaration) {
		if (name == null) {
			if (compilerEnv.isIdeMode()) { // be robust in IDE-mode
				return;
			}
			codeBug();
		}
		SymbolTable definingScope = !blockScopes.isEmpty() ? blockScopes.peek() : getScope();
		SymbolKind kind = getScope().canAdd(name.getName());
		if (kind != null
				&& (kind == SymbolKind.CONST
				|| declType == Token.CONST
				|| (definingScope == getScope() && kind == SymbolKind.LET))) {
			addError(
					kind == SymbolKind.CONST
					? "msg.const.redecl"
							: kind == SymbolKind.LET
							? "msg.let.redecl"
									: kind == SymbolKind.VAR
									? "msg.var.redecl"
											: kind == SymbolKind.FUNCTION
											? "msg.fn.redecl"
													: "msg.parm.redecl",
													name.getName());
			return;
		}
		switch (declType) {
		case Token.LET:
			if (!ignoreNotInBlock
					//was ifStatement instead of block
					&& ((getParent() instanceof StatementBlock) || getParent() instanceof LoopStatement)) {
				addError("msg.let.decl.not.in.block");
				return;
			}
			definingScope.add(name.getName(), getSymbolKind(declType), declaration);
			return;

		case Token.VAR:
		case Token.CONST:
		case Token.FUNCTION:
			if (kind != null) {
				if (kind == SymbolKind.VAR) addStrictWarning("msg.var.redecl", name.getName());
				else if (kind == SymbolKind.PARAM) {
					addStrictWarning("msg.var.hides.arg", name.getName());
				}
			} else {
				getScope().add(name.getName(), getSymbolKind(declType), declaration);
			}
			return;

		case Token.LP:
			if (kind != null) {
				// must be duplicate parameter. Second parameter hides the
				// first, so go ahead and add the second parameter
				addWarning("msg.dup.parms", name.getName());
			}
			getScope().add(name.getName(), getSymbolKind(declType), declaration);
			return;

		default:
			return;
		}
	}

	private Expression expr(boolean allowTrailingComma) throws IOException {
		Expression pn = assignExpr();
		int pos = pn.start();
		List<ASTNode> items = new ArrayList<>();
		items.add(pn);
		IntList commas = new IntList();
		int end = -1;
		while (matchToken(Token.COMMA, true)) {
			int opPos = ts.getTokenBeg();
			end = opPos;
			if (compilerEnv.isStrictMode()) //TODO  && !pn.hasSideEffects())
				addStrictWarning("msg.no.side.effects", "", pos, pn.end() - pos);
			if (peekToken() == Token.YIELD) reportError("msg.yield.parenthesized");
			if (allowTrailingComma && peekToken() == Token.RP) {
				commas.add(opPos);               
				return pn;
			}
			Expression assignExpr = assignExpr();
			items.add(assignExpr);
			commas.add(opPos);
			end = assignExpr.end();
		}
		if (!commas.isEmpty()) {
			CommaExpression c = new CommaExpression(getParent());
			c.setCommas(commas);
			items.forEach(item -> ((JSNode) item).setParent(c));
			c.setItems(items);
			c.setStart(pos);
			c.setEnd(end);
			return c;
		}
		return pn;
	}

	private Expression assignExpr() throws IOException {
		int tt = peekToken();
		if (tt == Token.YIELD) {
			//YieldOperator extends Expression, but 
			//returnOrYield returns VoidExpression when is not in expression context as below
			return (Expression)returnOrYield(tt, true);
		}
		Expression pn = condExpr();
		boolean hasEOL = false;
		tt = peekTokenOrEOL();
		if (tt == Token.EOL) {
			hasEOL = true;
			tt = peekToken();
		}
		if (Token.FIRST_ASSIGN <= tt && tt <= Token.LAST_ASSIGN) {
			//            if (inDestructuringAssignment) {
			//                // default values inside destructuring assignments,
			//                // like 'var [a = 10] = b' or 'var {a: b = 10} = c',
			//                // are not supported
			//                reportError("msg.destruct.default.vals");
			//            }

			consumeToken();

			// Pull out JSDoc info and reset it before recursing.
			Comment jsdocNode = getAndResetJsDoc();

			//TODO add support in dltk
			//            markDestructuring(pn);
			int opPos = ts.getTokenBeg();    
			pn = createBinaryOperation(tt, opPos,
					pn, assignExpr(), getParent());

			if (jsdocNode != null  && pn instanceof Documentable) {
				((Documentable)pn).setDocumentation(jsdocNode);
			}
		} else if (tt == Token.SEMI) {
			// This may be dead code added intentionally, for JSDoc purposes.
			// For example: /** @type Number */ C.prototype.x;
			if (currentJsDocComment != null) {
				Comment doc = getAndResetJsDoc();
				if (pn instanceof Documentable) {
					((Documentable)pn).setDocumentation(doc);
				}
			}
		} else if (!hasEOL && tt == Token.ARROW) {
			consumeToken();
			pn = arrowFunction(pn);
		}
		return pn;
	}

	private BinaryOperation createBinaryOperation(int tt, int opPos, Expression leftExpression, Expression rightExpression,
			JSNode parent) {
		BinaryOperation op = new BinaryOperation(parent);
		op.setLeftExpression(leftExpression);
		op.setRightExpression(rightExpression);
		op.setOperationPosition(opPos);
		op.setOperation(tt);
		op.setStart(leftExpression.start());
		op.setEnd(rightExpression.end());
		leftExpression.setParent(op);
		rightExpression.setParent(op);
		return op;
	}

	private UnaryOperation createUnaryOperation(int tt, int opPos, Expression expr, JSNode parent, boolean isPostFix) {
		UnaryOperation op = new UnaryOperation(parent, isPostFix);
		op.setExpression(expr);
		op.setOperationPosition(opPos);
		op.setOperation(tt);
		op.setStart(isPostFix ? expr.start() : opPos);
		op.setEnd(isPostFix ? opPos + op.getOperationText().length() : expr.end());
		expr.setParent(op);
		return op;
	}

	private Expression condExpr() throws IOException {
		Expression pn = orExpr();
		if (matchToken(Token.HOOK, true)) {
			int qmarkPos = ts.getTokenBeg(), colonPos = -1;
			/*
			 * Always accept the 'in' operator in the middle clause of a ternary,
			 * where it's unambiguous, even if we might be parsing the init of a
			 * for statement.
			 */
			boolean wasInForInit = inForInit;
			inForInit = false;
			Expression ifTrue;
			try {
				ifTrue = assignExpr();
			} finally {
				inForInit = wasInForInit;
			}
			if (mustMatchToken(Token.COLON, "msg.no.colon.cond", true)) colonPos = ts.getTokenBeg();
			Expression ifFalse = assignExpr();
			int beg = pn.start();
			ConditionalOperator ce = new ConditionalOperator(getParent());
			ce.setStart(beg);
			ce.setCondition(pn);
			pn.setParent(ce);
			ce.setTrueValue(ifTrue);
			if (ifTrue != null) {
				ifTrue.setParent(ce);
			}
			ce.setFalseValue(ifFalse);
			if (ifFalse != null) {
				ifFalse.setParent(ce);
			}
			ce.setQuestionPosition(qmarkPos);
			ce.setColonPosition(colonPos);
			ce.setEnd(ifFalse != null ? ifFalse.end() : ts.getTokenEnd());
			pn = ce;
		}
		return pn;
	}

	private Expression orExpr() throws IOException {
		Expression pn = andExpr();
		if (matchToken(Token.OR, true)) {
			int opPos = ts.getTokenBeg();
			pn = createBinaryOperation(Token.OR, opPos, pn, orExpr(), getParent());
		}
		return pn;
	}

	private Expression andExpr() throws IOException {
		Expression pn = bitOrExpr();
		if (matchToken(Token.AND, true)) {
			int opPos = ts.getTokenBeg();
			pn = createBinaryOperation(Token.AND, opPos, pn, andExpr(), getParent());
		}
		return pn;
	}

	private Expression bitOrExpr() throws IOException {
		Expression pn = bitXorExpr();
		while (matchToken(Token.BITOR, true)) {
			int opPos = ts.getTokenBeg();
			pn = createBinaryOperation(Token.BITOR, opPos, pn, bitXorExpr(), getParent());
		}
		return pn;
	}

	private Expression bitXorExpr() throws IOException {
		Expression pn = bitAndExpr();
		while (matchToken(Token.BITXOR, true)) {
			int opPos = ts.getTokenBeg();
			pn = createBinaryOperation(Token.BITXOR, opPos, pn, bitAndExpr(), getParent());
		}
		return pn;
	}

	private Expression bitAndExpr() throws IOException {
		Expression pn = eqExpr();
		while (matchToken(Token.BITAND, true)) {
			int opPos = ts.getTokenBeg();
			pn = createBinaryOperation(Token.BITAND, opPos, pn, eqExpr(), getParent());
		}
		return pn;
	}

	private Expression eqExpr() throws IOException {
		Expression pn = relExpr();
		for (; ; ) {
			int tt = peekToken(), opPos = ts.getTokenBeg();
			switch (tt) {
			case Token.EQ:
			case Token.NE:
			case Token.SHEQ:
			case Token.SHNE:
				consumeToken();
				int parseToken = tt;
				if (compilerEnv.getLanguageVersion() == Context.VERSION_1_2) {
					// JavaScript 1.2 uses shallow equality for == and != .
					if (tt == Token.EQ) parseToken = Token.SHEQ;
					else if (tt == Token.NE) parseToken = Token.SHNE;
				}
				pn = createBinaryOperation(parseToken, opPos, pn, relExpr(), getParent());
				continue;
			}
			break;
		}
		return pn;
	}

	private Expression relExpr() throws IOException {
		Expression pn = shiftExpr();
		for (; ; ) {
			int tt = peekToken(), opPos = ts.getTokenBeg();
			switch (tt) {
			case Token.IN:
				if (inForInit) break;
				// fall through
			case Token.INSTANCEOF:
			case Token.LE:
			case Token.LT:
			case Token.GE:
			case Token.GT:
				consumeToken();
				pn = createBinaryOperation(tt, opPos, pn, shiftExpr(), getParent());
				continue;
			}
			break;
		}
		return pn;
	}

	private Expression shiftExpr() throws IOException {
		Expression pn = addExpr();
		for (; ; ) {
			int tt = peekToken(), opPos = ts.getTokenBeg();
			switch (tt) {
			case Token.LSH:
			case Token.URSH:
			case Token.RSH:
				consumeToken();
				pn = createBinaryOperation(tt, opPos, pn, addExpr(), getParent());
				continue;
			}
			break;
		}
		return pn;
	}

	private Expression addExpr() throws IOException {
		Expression pn = mulExpr();
		for (; ; ) {
			int tt = peekToken(), opPos = ts.getTokenBeg();
			if (tt == Token.ADD || tt == Token.SUB) {
				consumeToken();
				pn = createBinaryOperation(tt, opPos, pn, mulExpr(), getParent());
				continue;
			}
			break;
		}
		return pn;
	}

	private Expression mulExpr() throws IOException {
		Expression pn = expExpr();
		for (; ; ) {
			int tt = peekToken(), opPos = ts.getTokenBeg();
			switch (tt) {
			case Token.MUL:
			case Token.DIV:
			case Token.MOD:
				consumeToken();
				pn = createBinaryOperation(tt, opPos, pn, expExpr(), getParent());
				continue;
			}
			break;
		}
		return pn;
	}

	private Expression expExpr() throws IOException {
		Expression pn = unaryExpr();
		for (; ; ) {
			int tt = peekToken(), opPos = ts.getTokenBeg();
			switch (tt) {
			case Token.EXP:
				//                    if (pn instanceof UnaryExpression) {
				//                        reportError(
				//                                "msg.no.unary.expr.on.left.exp",
				//                                AstNode.operatorToString(pn.getType()));
				//                        return makeErrorNode();
				//                    }
				//                    consumeToken();
				//                    pn = new InfixExpression(tt, pn, expExpr(), opPos);
				continue;
			}
			break;
		}
		return pn;
	}

	private Expression unaryExpr() throws IOException {
		int tt = peekToken();
		if (tt == Token.COMMENT) {
			consumeToken();
			tt = peekUntilNonComment(tt);
		}

		switch (tt) {
		case Token.VOID:
		case Token.NOT:
		case Token.BITNOT:
		case Token.TYPEOF:
			consumeToken();
			return createUnaryOperation(tt, ts.getTokenBeg(), unaryExpr(), getParent(), false);

		case Token.ADD:
			consumeToken();
			// Convert to special POS token in parse tree
			return createUnaryOperation(Token.POS, ts.getTokenBeg(), unaryExpr(), getParent(), false);

		case Token.SUB:
			consumeToken();
			// Convert to special NEG token in parse tree
			return createUnaryOperation(Token.NEG, ts.getTokenBeg(), unaryExpr(), getParent(), false);

		case Token.INC:
		case Token.DEC:
			consumeToken();
			UnaryOperation expr = createUnaryOperation(tt, ts.getTokenBeg(), memberExpr(true), getParent(), false);
			checkBadIncDec(expr);
			return expr;

		case Token.DELPROP:
			consumeToken();
			return createUnaryOperation(Token.DELPROP, ts.getTokenBeg(), unaryExpr(), getParent(), false);

		case Token.ERROR:
			consumeToken();
			return makeErrorNode();
		case Token.LT:
			// XML stream encountered in expression.
			if (compilerEnv.isXmlAvailable()) {
				consumeToken();
				return memberExprTail(true, xmlInitializer());
			}
			// Fall thru to the default handling of RELOP
			// fall through

		default:
			Expression pn = memberExpr(true);
			// Don't look across a newline boundary for a postfix incop.
			tt = peekTokenOrEOL();
			if (!(tt == Token.INC || tt == Token.DEC)) {
				return pn;
			}
			consumeToken();
			return createUnaryOperation(tt, ts.getTokenBeg(), pn, getParent(), true);
		}
	}

	private Expression xmlInitializer() throws IOException {
		if (currentToken != Token.LT) codeBug();
		int pos = ts.getTokenBeg(), tt = ts.getFirstXMLToken();
		if (tt != Token.XML && tt != Token.XMLEND) {
			reportError("msg.syntax", pos, ts.getTokenEnd() - pos);
			makeErrorNode();
		}

		//        XmlLiteral pn = new XmlLiteral(pos);
		//        pn.setLineno(ts.getLineno());
		//
		for (; ; tt = ts.getNextXMLToken()) {
			switch (tt) {
			//                case Token.XML:
			//                    pn.addFragment(new XmlString(ts.getTokenBeg(), ts.getString()));
			//                    mustMatchToken(Token.LC, "msg.syntax", true);
			//                    int beg = ts.getTokenBeg();
			//                    AstNode expr =
			//                            (peekToken() == Token.RC)
			//                                    ? new EmptyExpression(beg, ts.getTokenEnd() - beg)
			//                                    : expr(false);
			//                    mustMatchToken(Token.RC, "msg.syntax", true);
			//                    XmlExpression xexpr = new XmlExpression(beg, expr);
			//                    xexpr.setIsXmlAttribute(ts.isXMLAttribute());
			//                    xexpr.setLength(ts.getTokenEnd() - beg);
			//                    pn.addFragment(xexpr);
			//                    break;
			//
			//                case Token.XMLEND:
			//                    pn.addFragment(new XmlString(ts.getTokenBeg(), ts.getString()));
			//                    return pn;

			default:
				reportError("msg.syntax", pos, ts.getTokenEnd() - pos);
				makeErrorNode();
			}
		}
	}

	private void argumentList(CallExpression call) throws IOException {
		if (matchToken(Token.RP, true)) {
			call.setCommas(new IntList());
			call.setRP(ts.getTokenBeg());
			return;
		}

		boolean wasInForInit = inForInit;
		inForInit = false;
		boolean hasComma = false;
		parents.push(call);
		IntList commas = new IntList();
		try {
			do {
				if (hasComma) {
					commas.add(ts.getTokenBeg());
				}
				if (peekToken() == Token.RP) {
					// Quick fix to handle scenario like f1(a,); but not f1(a,b
					break;
				}
				if (peekToken() == Token.YIELD) {
					reportError("msg.yield.parenthesized");
				}
				ASTNode en = assignExpr();
				//                if (peekToken() == Token.FOR) {
				//                    try {
				//                        result.add(generatorExpression(en, 0, true));
				//                    } catch (IOException ex) {
				//                        // #TODO
				//                    }
				//                } else {
				//                    result.add(en);
				//                }
				call.addArgument(en);
				hasComma = matchToken(Token.COMMA, true);
			} while (hasComma);
		} finally {
			inForInit = wasInForInit;
			parents.pop();
			call.setCommas(commas);
		}

		if (mustMatchToken(Token.RP, "msg.no.paren.arg", true)) {
			call.setRP(ts.getTokenBeg());
		}
	}

	/**
	 * Parse a new-expression, or if next token isn't {@link Token#NEW}, a primary expression.
	 *
	 * @param allowCallSyntax passed down to {@link #memberExprTail}
	 */
	private Expression memberExpr(boolean allowCallSyntax) throws IOException {
		int tt = peekToken();
		Expression pn = null;

		if (tt != Token.NEW) {
			pn = primaryExpr();
		} else {
			consumeToken();
			int pos = ts.getTokenBeg();
			NewExpression nx = new NewExpression(getParent());
			nx.setNewKeyword(createKeyword(Token.NEW, pos));
			nx.setStart(pos);

			Expression target = memberExpr(false);

			int lp = -1;
			if (matchToken(Token.LP, true)) {
				lp = ts.getTokenBeg();
				CallExpression call = new CallExpression(nx);
				call.setExpression(target);
				target.setParent(call);
				call.setStart(target.start());
				call.setLP(lp);
				argumentList(call);
				if (call.getArguments() != null && call.getArguments().size() > ARGC_LIMIT)
					reportError("msg.too.many.constructor.args");
				call.setEnd(ts.getTokenEnd());
				nx.setObjectClass(call);
				nx.setEnd(call.end());
			}
			else {
				nx.setEnd(target.end());
				nx.setObjectClass(target);
			}

			// Experimental syntax: allow an object literal to follow a new
			// expression, which will mean a kind of anonymous class built with
			// the JavaAdapter.  the object literal will be passed as an
			// additional argument to the constructor.
			//            if (matchToken(Token.LC, true)) {
			//                ObjectLiteral initializer = objectLiteral();
			//                end = getNodeEnd(initializer);
			//                nx.setInitializer(initializer);
			//            }
			//            nx.setLength(end - pos);
			pn = nx;
		}
		Expression tail = memberExprTail(allowCallSyntax, pn);
		return tail;
	}

	/**
	 * Parse any number of "(expr)", "[expr]" ".expr", "..expr", or ".(expr)" constructs trailing
	 * the passed expression.
	 *
	 * @param pn the non-null parent node
	 * @return the outermost (lexically last occurring) expression, which will have the passed
	 *     parent node as a descendant
	 */
	private Expression memberExprTail(boolean allowCallSyntax, Expression pn) throws IOException {
		// we no longer return null for errors, so this won't be null
		if (pn == null) codeBug();
		int pos = pn.sourceStart();
		tailLoop:
			for (; ; ) {
				int tt = peekToken();
				switch (tt) {
				case Token.EOL:
					pn.setEnd(ts.getTokenEnd());
					consumeToken();
					break;
				case Token.DOT:
				case Token.DOTDOT:
					pn = propertyAccess(tt, pn);
					break;

				case Token.DOTQUERY:
					//TODO not supported in DLTK
					consumeToken();
					//                    int opPos = ts.getTokenBeg(), rp = -1;
					//                    lineno = ts.getLineno();
					//                    mustHaveXML();
					//                    setRequiresActivation();
					//                    AstNode filter = expr(false);
					//                    int end = getNodeEnd(filter);
					//                    if (mustMatchToken(Token.RP, "msg.no.paren", true)) {
					//                        rp = ts.getTokenBeg();
					//                        end = ts.getTokenEnd();
					//                    }
					//                    XmlDotQuery q = new XmlDotQuery(pos, end - pos);
					//                    q.setLeft(pn);
					//                    q.setRight(filter);
					//                    q.setOperatorPosition(opPos);
					//                    q.setRp(rp - pos);
					//                    q.setLineno(lineno);
					//                    pn = q;
					break;

				case Token.LB:
					consumeToken();
					int lb = ts.getTokenBeg(), rb = -1;
					Expression expr = expr(false);
					int end = expr.end();
					if (mustMatchToken(Token.RB, "msg.no.bracket.index", true)) {
						rb = ts.getTokenBeg();
						end = ts.getTokenEnd();
					}
					GetArrayItemExpression g = new GetArrayItemExpression(getParent());
					g.setArray(pn);
					pn.setParent(g);
					g.setIndex(expr);
					expr.setParent(g);
					g.setStart(pn.start());
					g.setEnd(end);
					g.setLB(lb);
					g.setRB(rb);
					pn = g;
					break;

				case Token.LP:
					if (!allowCallSyntax) {
						break tailLoop;
					}
					consumeToken();
					CallExpression f = new CallExpression(getParent());
					f.setStart(pos);
					f.setExpression(pn);
					pn.setParent(f);
					// Assign the line number for the function call to where
					// the paren appeared, not where the name expression started.
					f.setLP(ts.getTokenBeg());
					argumentList(f);
					if (f.getArguments() != null && f.getArguments().size() > ARGC_LIMIT)
						reportError("msg.too.many.function.args");
					f.setRP(ts.getTokenBeg());
					f.setEnd(ts.getTokenEnd());
					pn = f;
					break;
				case Token.COMMENT:
					// Ignoring all the comments, because previous statement may not be terminated
					// properly.
					int currentFlagTOken = currentFlaggedToken;
					peekUntilNonComment(tt);
					currentFlaggedToken =
							(currentFlaggedToken & TI_AFTER_EOL) != 0
							? currentFlaggedToken
									: currentFlagTOken;
					break;
				case Token.TEMPLATE_LITERAL:
					consumeToken();
					pn = taggedTemplateLiteral(pn);
					break;
				default:
					break tailLoop;
				}
			}
		return pn;
	}

	private TagFunctionExpression taggedTemplateLiteral(Expression pn) throws IOException {
		Expression templateLiteral = templateLiteral(true);
		TagFunctionExpression tagged = new TagFunctionExpression(getParent());
		parents.push(tagged);
		tagged.setStart(pn.start());
		tagged.setTagFunction(pn);
		if (templateLiteral instanceof TemplateStringLiteral) {
			tagged.setLiteral((TemplateStringLiteral) templateLiteral);
		}
		tagged.setEnd(ts.getTokenEnd());
		parents.pop();
		return tagged;
	}

	/**
	 * Handles any construct following a "." or ".." operator.
	 *
	 * @param pn the left-hand side (target) of the operator. Never null.
	 * @return a PropertyGet, XmlMemberGet, or ErrorNode
	 */
	private Expression propertyAccess(int tt, Expression pn) throws IOException {
		if (pn == null) codeBug();
		int memberTypeFlags = 0, dotPos = ts.getTokenBeg();
		consumeToken();

		if (tt == Token.DOTDOT) {
			mustHaveXML();
			memberTypeFlags = Node.DESCENDANTS_FLAG;
		}

		//        if (!compilerEnv.isXmlAvailable()) {
		//            int maybeName = nextToken();
		//            if (maybeName != Token.NAME
		//                    && !(compilerEnv.isReservedKeywordAsIdentifier()
		//                            && TokenStream.isKeyword(
		//                                    ts.getString(),
		//                                    compilerEnv.getLanguageVersion(),
		//                                    inUseStrictDirective))) {
		//                reportError("msg.no.name.after.dot");
		//            }

		//            Name name = createNameNode(true, Token.GETPROP);
		//            PropertyGet pg = new PropertyGet(pn, name, dotPos);
		//            pg.setLineno(lineno);
		//            return pg;
		//        }

		Expression ref = null; // right side of . or .. operator

		int token = nextToken();
		switch (token) {
		case Token.THROW:
			// needed for generator.throw();
			saveNameTokenData(ts.getTokenBeg(), "throw", ts.getLineno());
			ref = propertyName(-1, memberTypeFlags);
			break;

		case Token.NAME:
			// handles: name, ns::name, ns::*, ns::[expr]
			ref = propertyName(-1, memberTypeFlags);
			break;

		case Token.MUL:
			// handles: *, *::name, *::*, *::[expr]
			saveNameTokenData(ts.getTokenBeg(), "*", ts.getLineno());
			ref = propertyName(-1, memberTypeFlags);
			break;

		case Token.XMLATTR:
			// handles: '@attr', '@ns::attr', '@ns::*', '@ns::*',
			//          '@::attr', '@::*', '@*', '@*::attr', '@*::*'
			ref = attributeAccess();
			break;

		case Token.RESERVED:
		{
			String name = ts.getString();
			saveNameTokenData(ts.getTokenBeg(), name, ts.getLineno());
			ref = propertyName(-1, memberTypeFlags);
			break;
		}

		default:
			if (compilerEnv.isReservedKeywordAsIdentifier()) {
				// allow keywords as property names, e.g. ({if: 1})
				String name = Token.keywordToName(token);
				if (name != null) {
					saveNameTokenData(ts.getTokenBeg(), name, ts.getLineno());
					ref = propertyName(-1, memberTypeFlags);
					break;
				}
			}
			addError("msg.no.name.after.dot", dotPos, 1);
			ref = makeErrorNode();
		}

		if (ref instanceof XmlAttributeIdentifier) { //TODO impl
			//        	 Expression result = new org.eclipse.dltk.javascript.ast.XmlLiteral(getParent());    	
			//             //if (xml && tt == Token.DOT) result.setType(Token.DOT);
			//             int pos = pn.start();
			//             result.setLength(getNodeEnd(ref) - pos);
			//             result.setOperatorPosition(dotPos - pos);
			//             result.setLineno(pn.getLineno());
			//             result.setLeft(pn); // do this after setting position
			//             result.setRight(ref);
			//             return result;
			reportError("msg.XML.not.available");
			return makeErrorNode();
		}
		else
		{
			PropertyExpression result = new PropertyExpression(getParent());   
			if (pn instanceof Documentable) {
				//the original rhino parser doesn't do this
				if (pn.getDocumentation() == null) {
					Comment doc = getAndResetJsDoc();
					((Documentable) pn).setDocumentation(doc);
				}
				result.setDocumentation(pn.getDocumentation());
			}
			else {
				result.setDocumentation(getAndResetJsDoc());
			}
			result.setStart(pn.start());
			result.setEnd(ref.end());
			result.setObject(pn);
			pn.setParent(result);
			result.setProperty(ref);
			ref.setParent(result);
			result.setDotPosition(dotPos);
			return result;
		}
	}

	/**
	 * Xml attribute expression:
	 *
	 * <p>{@code @attr}, {@code @ns::attr}, {@code @ns::*}, {@code @ns::*}, {@code @*},
	 * {@code @*::attr}, {@code @*::*}, {@code @ns::[expr]}, {@code @*::[expr]}, {@code @[expr]}
	 *
	 * <p>Called if we peeked an '@' token.
	 */
	private Expression attributeAccess() throws IOException {
		int tt = nextToken(), atPos = ts.getTokenBeg();

		switch (tt) {
		// handles: @name, @ns::name, @ns::*, @ns::[expr]
		case Token.NAME:
			return propertyName(atPos, 0);

			// handles: @*, @*::name, @*::*, @*::[expr]
		case Token.MUL:
			saveNameTokenData(ts.getTokenBeg(), "*", ts.getLineno());
			return propertyName(atPos, 0);

			// handles @[expr]
		case Token.LB:
			return xmlElemRef(atPos, null, -1);

		default:
			addError("msg.no.name.after.xmlAttr", atPos, ts.getTokenEnd() - atPos);
			return makeErrorNode();
		}
	}

	/**
	 * Check if :: follows name in which case it becomes a qualified name.
	 *
	 * @param atPos a natural number if we just read an '@' token, else -1
	 * @param s the name or string that was matched (an identifier, "throw" or "*").
	 * @param memberTypeFlags flags tracking whether we're a '.' or '..' child
	 * @return an XmlRef node if it's an attribute access, a child of a '..' operator, or the name
	 *     is followed by ::. For a plain name, returns a Name node. Returns an ErrorNode for
	 *     malformed XML expressions. (For now - might change to return a partial XmlRef.)
	 */
	private Expression propertyName(int atPos, int memberTypeFlags) throws IOException {
		int pos = atPos != -1 ? atPos : ts.getTokenBeg();
		int colonPos = -1;
		Identifier name = createNameNode(true, currentToken);
		Identifier ns = null;

		if (matchToken(Token.COLONCOLON, true)) {
			ns = name;
			colonPos = ts.getTokenBeg();

			switch (nextToken()) {
			// handles name::name
			case Token.NAME:
				name = createNameNode();
				break;

				// handles name::*
			case Token.MUL:
				saveNameTokenData(ts.getTokenBeg(), "*", ts.getLineno());
				name = createNameNode(false, -1);
				break;

				// handles name::[expr] or *::[expr]
				//                case Token.LB:
				//                    return xmlElemRef(atPos, ns, colonPos);
				//
			default:
				reportError("msg.no.name.after.coloncolon", pos, colonPos);
				makeErrorNode();
			}
		}

		if (ns == null && memberTypeFlags == 0 && atPos == -1) {
			return name;
		}

		//        XmlPropRef ref = new XmlPropRef(pos, getNodeEnd(name) - pos);
		//        ref.setAtPos(atPos);
		//        ref.setNamespace(ns);
		//        ref.setColonPos(colonPos);
		//        ref.setPropName(name);
		//        ref.setLineno(lineno);
		//        return ref;
		return makeErrorNode();
	}

	/**
	 * Parse the [expr] portion of an xml element reference, e.g. @[expr], @*::[expr], or
	 * ns::[expr].
	 */
	private Expression xmlElemRef(int atPos, Identifier namespace, int colonPos) throws IOException {
		//        int lb = ts.getTokenBeg(), rb = -1, pos = atPos != -1 ? atPos : lb;
		//        AstNode expr = expr(false);
		//        int end = getNodeEnd(expr);
		//        if (mustMatchToken(Token.RB, "msg.no.bracket.index", true)) {
		//            rb = ts.getTokenBeg();
		//            end = ts.getTokenEnd();
		//        }
		//        XmlElemRef ref = new XmlElemRef(pos, end - pos);
		//        ref.setNamespace(namespace);
		//        ref.setColonPos(colonPos);
		//        ref.setAtPos(atPos);
		//        ref.setExpression(expr);
		//        ref.setBrackets(lb, rb);
		//        return ref;
		reportError("msg.XML.not.available");
		return makeErrorNode();
	}

	private Expression destructuringPrimaryExpr() throws IOException, ParserException {
		try {
			inDestructuringAssignment = true;
			return primaryExpr();
		} finally {
			inDestructuringAssignment = false;
		}
	}

	private Expression primaryExpr() throws IOException {
		int ttFlagged = peekFlaggedToken();
		int tt = ttFlagged & CLEAR_TI_MASK;

		switch (tt) {
		case Token.FUNCTION:
			consumeToken();
			return function(FunctionNode.FUNCTION_EXPRESSION);

		case Token.LB:
			consumeToken();
			return arrayLiteral();

		case Token.LC:
			consumeToken();
			return objectLiteral();

		case Token.LET:
			consumeToken();
			return let(false, ts.getTokenBeg());

		case Token.LP:
			consumeToken();
			return parenExpr();

		case Token.XMLATTR:
			consumeToken();
			mustHaveXML();
			return attributeAccess();

		case Token.NAME:
			consumeToken();
			return name(ttFlagged, tt);

		case Token.NUMBER:
		case Token.BIGINT:
		{
			consumeToken();
			return createNumericLiteral(tt, false);
		}

		case Token.STRING:
			consumeToken();
			return createStringLiteral();

		case Token.DIV:
		case Token.ASSIGN_DIV:
			consumeToken();
			// Got / or /= which in this context means a regexp
					ts.readRegExp(tt);
			int pos = ts.getTokenBeg(), end = ts.getTokenEnd();
			RegExpLiteral re = new RegExpLiteral(getParent());
			re.setStart(pos);
			re.setEnd(end);
			String flags = ts.readAndClearRegExpFlags();
			re.setText("/"+ts.getString()+"/"+ (flags == null ? "" : flags));
			return re;

		case Token.NULL:
			consumeToken();
			NullExpression ex = new NullExpression(getParent());
			ex.setStart(ts.getTokenBeg());
			ex.setEnd(ts.getTokenEnd());
			return ex;
		case Token.THIS:
			consumeToken();
			ThisExpression this_ = new ThisExpression(getParent());
			this_.setStart(ts.getTokenBeg());
			this_.setEnd(ts.getTokenEnd());
			return this_;
		case Token.FALSE:
		case Token.TRUE:
			consumeToken();
			BooleanLiteral l= new BooleanLiteral(getParent(), tt == Token.TRUE ? true : false);
			l.setStart(ts.getTokenBeg());
			l.setEnd(ts.getTokenEnd());
			return l;

		case Token.TEMPLATE_LITERAL:
			consumeToken();
			return templateLiteral(false);

		case Token.RESERVED:
			consumeToken();
			reportError("msg.reserved.id", ts.getString());
			break;

		case Token.ERROR:
			consumeToken();
			// the scanner or one of its subroutines reported the error.
			break;

		case Token.EOF:
			consumeToken();
			reportError("msg.unexpected.eof");
			break;

		default:
			consumeToken();
			reportError("msg.syntax");
			break;
		}
		// should only be reachable in IDE/error-recovery mode
		consumeToken();
		return makeErrorNode();
	}

	private Expression parenExpr() throws IOException {
		boolean wasInForInit = inForInit;
		inForInit = false;
		try {
			//parenthesized expr does not support docs
			Comment jsdocNode = getAndResetJsDoc();
			int begin = ts.getTokenBeg();
			Expression e = (peekToken() == Token.RP ? new EmptyExpression(getParent()) : expr(true));
			//TODO generator not supported in dltk
			//            if (peekToken() == Token.FOR) {
			//                return generatorExpression(e, begin);
			//            }
			mustMatchToken(Token.RP, "msg.no.paren", true);

			boolean hasTrailingComma = false;
			if (e instanceof CommaExpression) {
				CommaExpression expr = (CommaExpression) e;
				hasTrailingComma = expr.getCommas() != null && expr.getCommas().size() > expr.getItems().size();
			}
			if ((hasTrailingComma || e instanceof EmptyExpression) && peekToken() != Token.ARROW) {
				reportError("msg.syntax");
				return makeErrorNode();
			}

			ParenthesizedExpression pn = new ParenthesizedExpression(getParent());
			pn.setStart(begin);
			pn.setLP(begin);
			pn.setEnd(ts.getTokenEnd());
			pn.setRP(ts.getTokenBeg());
			pn.setExpression(e);
			e.setParent(pn);
			if (jsdocNode == null) {
				jsdocNode = getAndResetJsDoc();
			}
			return pn;
		} finally {
			inForInit = wasInForInit;
		}
	}

	private Expression name(int ttFlagged, int tt) throws IOException {
		String nameString = ts.getString();
		int namePos = ts.getTokenBeg(), nameLineno = ts.getLineno();
		if (0 != (ttFlagged & TI_CHECK_LABEL) && peekToken() == Token.COLON) {
			// Do not consume colon.  It is used as an unwind indicator
			// to return to statementHelper.
			Label label = new Label(getParent());
			label.setText(nameString);
			label.setStart(namePos);
			label.setEnd(namePos + nameString.length());
			return label;
		}
		// Not a label.  Unfortunately peeking the next token to check for
		// a colon has biffed ts.getTokenBeg(), ts.getTokenEnd().  We store the name's
		// bounds in instance vars and createNameNode uses them.
		saveNameTokenData(namePos, nameString, nameLineno);

		if (compilerEnv.isXmlAvailable()) {
			return propertyName(-1, 0);
		}
		return createNameNode(true, Token.NAME);
	}

	/** May return an {@link ArrayLiteral} or {@link ArrayComprehension}. */
	private Expression arrayLiteral() throws IOException {
		if (currentToken != Token.LB) codeBug();
		int pos = ts.getTokenBeg(), end = ts.getTokenEnd();
		boolean after_lb_or_comma = true;
		int afterComma = -1;
		int rb = -1;
		ArrayInitializer pn = new ArrayInitializer(getParent());
		parents.push(pn);
		for (; ; ) {
			int tt = peekToken();
			if (tt == Token.COMMA) {
				consumeToken();
				pn.getCommas().add(ts.getTokenBeg());
				afterComma = ts.getTokenEnd();
				if (!after_lb_or_comma) {
					after_lb_or_comma = true;
				} else {
					EmptyExpression emptyExpression = new EmptyExpression(getParent());
					emptyExpression.setStart(ts.getTokenBeg());
					emptyExpression.setEnd(ts.getTokenBeg());
					pn.getItems().add(emptyExpression);
				}
			} else if (tt == Token.COMMENT) {
				consumeToken();
			} else if (tt == Token.RB) {
				consumeToken();
				// for ([a,] in obj) is legal, but for ([a] in obj) is
				// not since we have both key and value supplied. The
				// trick is that [a,] and [a] are equivalent in other
				// array literal contexts. So we calculate a special
				// length value just for destructuring assignment.
				end = ts.getTokenEnd();
				rb = ts.getTokenBeg();
				//                pn.setDestructuringLength(elements.size() + (after_lb_or_comma ? 1 : 0));
				//                pn.setSkipCount(skipCount);
				if (afterComma != -1) {
					pn.getCommas().removeAt(pn.getCommas().size() - 1);
					warnTrailingComma(pos, pn.getItems(), afterComma);
				}
				break;
				//TODO destructuring
				//            } else if (tt == Token.FOR && !after_lb_or_comma && elements.size() == 1) {
				//                return arrayComprehension(elements.get(0), pos);
			} else if (tt == Token.EOF) {
				reportError("msg.no.bracket.arg");
				break;
			} else {
				if (!after_lb_or_comma) {
					reportError("msg.no.bracket.arg");
				}
				pn.getItems().add(assignExpr());
				after_lb_or_comma = false;
				afterComma = -1;
			}
		}

		pn.setStart(pos);
		pn.setEnd(end);
		pn.setLB(pos);
		pn.setRB(rb);
		parents.pop();
		return pn;
	}

	/**
	 * Parse a JavaScript 1.7 Array comprehension.
	 *
	 * @param result the first expression after the opening left-bracket
	 * @param pos start of LB token that begins the array comprehension
	 * @return the array comprehension or an error node
	 */
	//TODO impl or remove?
	private Expression arrayComprehension(JSNode result, int pos) throws IOException {
		//        List<ArrayComprehensionLoop> loops = new ArrayList<>();
		//        while (peekToken() == Token.FOR) {
		//            loops.add(arrayComprehensionLoop());
		//        }
		//        int ifPos = -1;
		//        ConditionData data = null;
		//        if (peekToken() == Token.IF) {
		//            consumeToken();
		//            ifPos = ts.getTokenBeg() - pos;
		//            data = condition();
		//        }
		//        mustMatchToken(Token.RB, "msg.no.bracket.arg", true);
		//        ArrayComprehension pn = new ArrayComprehension(pos, ts.getTokenEnd() - pos);
		//        pn.setResult(result);
		//        pn.setLoops(loops);
		//        if (data != null) {
		//            pn.setIfPosition(ifPos);
		//            pn.setFilter(data.condition);
		//            pn.setFilterLp(data.lp - pos);
		//            pn.setFilterRp(data.rp - pos);
		//        }
		//        return pn;
		return null;
	}

//	private ArrayComprehensionLoop arrayComprehensionLoop() throws IOException {
//		if (nextToken() != Token.FOR) codeBug();
//		int pos = ts.getTokenBeg();
//		int eachPos = -1, lp = -1, rp = -1, inPos = -1;
//		boolean isForOf = false;
//		ArrayComprehensionLoop pn = new ArrayComprehensionLoop(pos);
//
//		//        pushScope(pn);
//		try {
//			if (matchToken(Token.NAME, true)) {
//				if (ts.getString().equals("each")) {
//					eachPos = ts.getTokenBeg() - pos;
//				} else {
//					reportError("msg.no.paren.for");
//				}
//			}
//			if (mustMatchToken(Token.LP, "msg.no.paren.for", true)) {
//				lp = ts.getTokenBeg() - pos;
//			}
//
//			AstNode iter = null;
//			switch (peekToken()) {
//			case Token.LB:
//			case Token.LC:
//				// handle destructuring assignment
//				iter = null;// TODO destructuringPrimaryExpr();
//				//                    markDestructuring(iter);
//				break;
//			case Token.NAME:
//				consumeToken();
//				//                    iter = createNameNode();
//				break;
//			default:
//				reportError("msg.bad.var");
//			}
//
//			// Define as a let since we want the scope of the variable to
//			// be restricted to the array comprehension
//			if (iter.getType() == Token.NAME) {
//				defineSymbol(Token.LET, ts.getString(), true, null); //TODO JSDeclaration
//			}
//
//			switch (nextToken()) {
//			case Token.IN:
//				inPos = ts.getTokenBeg() - pos;
//				break;
//			case Token.NAME:
//				if ("of".equals(ts.getString())) {
//					if (eachPos != -1) {
//						reportError("msg.invalid.for.each");
//					}
//					inPos = ts.getTokenBeg() - pos;
//					isForOf = true;
//					break;
//				}
//				// fall through
//			default:
//				reportError("msg.in.after.for.name");
//			}
//			Expression obj = expr(false);
//			if (mustMatchToken(Token.RP, "msg.no.paren.for.ctrl", true)) rp = ts.getTokenBeg() - pos;
//
//			pn.setLength(ts.getTokenEnd() - pos);
//			pn.setIterator(iter);
//			pn.setIteratedObject(obj);
//			pn.setInPosition(inPos);
//			pn.setEachPosition(eachPos);
//			pn.setIsForEach(eachPos != -1);
//			pn.setParens(lp, rp);
//			pn.setIsForOf(isForOf);
//			return pn;
//		} finally {
//			//            popScope();
//		}
//	}

//	private AstNode generatorExpression(AstNode result, int pos) throws IOException {
//		return generatorExpression(result, pos, false);
//	}
//
//	private AstNode generatorExpression(AstNode result, int pos, boolean inFunctionParams)
//			throws IOException {
//
//		List<GeneratorExpressionLoop> loops = new ArrayList<>();
//		while (peekToken() == Token.FOR) {
//			loops.add(generatorExpressionLoop());
//		}
//		int ifPos = -1;
//		ConditionData data = null;
//		if (peekToken() == Token.IF) {
//			consumeToken();
//			ifPos = ts.getTokenBeg() - pos;
//			data = condition();
//		}
//		if (!inFunctionParams) {
//			mustMatchToken(Token.RP, "msg.no.paren.let", true);
//		}
//		GeneratorExpression pn = new GeneratorExpression(pos, ts.getTokenEnd() - pos);
//		pn.setResult(result);
//		pn.setLoops(loops);
//		if (data != null) {
//			pn.setIfPosition(ifPos);
//			pn.setFilter(data.condition);
//			pn.setFilterLp(data.lp - pos);
//			pn.setFilterRp(data.rp - pos);
//		}
//		return pn;
//	}

//	private GeneratorExpressionLoop generatorExpressionLoop() throws IOException {
//		if (nextToken() != Token.FOR) codeBug();
//		int pos = ts.getTokenBeg();
//		int lp = -1, rp = -1, inPos = -1;
//		GeneratorExpressionLoop pn = new GeneratorExpressionLoop(pos);
//
//		//        pushScope(pn);
//		try {
//			if (mustMatchToken(Token.LP, "msg.no.paren.for", true)) {
//				lp = ts.getTokenBeg() - pos;
//			}
//
//			AstNode iter = null;
//			switch (peekToken()) {
//			case Token.LB:
//			case Token.LC:
//				// handle destructuring assignment
//				iter = null;// TODO destructuringPrimaryExpr();
//				//                    markDestructuring(iter);
//				break;
//			case Token.NAME:
//				consumeToken();
//				//                    iter = createNameNode();
//				break;
//			default:
//				reportError("msg.bad.var");
//			}
//
//			// Define as a let since we want the scope of the variable to
//			// be restricted to the array comprehension
//			if (iter.getType() == Token.NAME) {
//				defineSymbol(Token.LET, ts.getString(), true, null); //TODO JSDeclaration
//			}
//
//			if (mustMatchToken(Token.IN, "msg.in.after.for.name", true)) inPos = ts.getTokenBeg() - pos;
//			AstNode obj = expr(false);
//			if (mustMatchToken(Token.RP, "msg.no.paren.for.ctrl", true)) rp = ts.getTokenBeg() - pos;
//
//			pn.setLength(ts.getTokenEnd() - pos);
//			pn.setIterator(iter);
//			pn.setIteratedObject(obj);
//			pn.setInPosition(inPos);
//			pn.setParens(lp, rp);
//			return pn;
//		} finally {
//            popScope();
//		}
//	}

	private static final int PROP_ENTRY = 1;
	private static final int GET_ENTRY = 2;
	private static final int SET_ENTRY = 4;
	private static final int METHOD_ENTRY = 8;

	private ObjectInitializer objectLiteral() throws IOException {
		int pos = ts.getTokenBeg(), lineno = ts.getLineno();
		int afterComma = -1;
		List<ObjectInitializerPart> elems = new ArrayList<>();
		IntList commas = new IntList();
		Set<String> getterNames = null;
		Set<String> setterNames = null;
		if (this.inUseStrictDirective) {
			getterNames = new HashSet<>();
			setterNames = new HashSet<>();
		}
		// not supported Comment 
		Comment objJsdocNode = getAndResetJsDoc();
		ObjectInitializer init = new ObjectInitializer(getParent());
		parents.push(init);
		init.setStart(pos);
		init.setLC(pos);

		commaLoop:
			for (; ; ) {
				String propertyName = null;
				int entryKind = PROP_ENTRY;
				int tt = peekToken();
				// not supported doc
				Comment jsdocNode = getAndResetJsDoc();
				if (tt == Token.COMMENT) {
					consumeToken();
					tt = peekUntilNonComment(tt);
				}
				if (tt == Token.RC) {
					if (afterComma != -1) warnTrailingComma(pos, elems, afterComma);
					init.setRC(ts.getTokenBeg());
					break commaLoop;
				}
				Expression pname = objliteralProperty();
				if (pname == null) {
					reportError("msg.bad.prop");
				} else {
					propertyName = ts.getString();
					int ppos = ts.getTokenBeg();
					consumeToken();

					// This code path needs to handle both destructuring object
					// literals like:
					// var {get, b} = {get: 1, b: 2};
					// and getters like:
					// var x = {get 1() { return 2; };
					// So we check a whitelist of tokens to check if we're at the
					// first case. (Because of keywords, the second case may be
					// many tokens.)
					int peeked = peekToken();
					if (peeked == Token.COMMA) commas.add(ts.getTokenBeg());
					if (peeked != Token.COMMA && peeked != Token.COLON && peeked != Token.RC) {
						if (peeked == Token.LP) {
							entryKind = METHOD_ENTRY; //TODO not supported in dltk
						} else if (pname instanceof Identifier) {
							if ("get".equals(propertyName)) {
								entryKind = GET_ENTRY;
							} else if ("set".equals(propertyName)) {
								entryKind = SET_ENTRY;
							}
						}
						if (entryKind == GET_ENTRY || entryKind == SET_ENTRY) {
							pname = objliteralProperty();
							if (pname == null) {
								reportError("msg.bad.prop");
							}
							consumeToken();
						}
						if (pname == null) {
							propertyName = null;
						} else if (pname instanceof Identifier) {
							propertyName = ts.getString();
							Method objectProp = methodDefinition(ppos, (Identifier) pname, entryKind);
							((Identifier) pname).setDocumentation(jsdocNode);
							pname.setParent(objectProp);
							elems.add(objectProp);
						}
					} else {
						if (pname instanceof Documentable) {
							((Documentable) pname).setDocumentation(jsdocNode);
						}
						elems.add(plainProperty(pname, tt, commas));
					}
				}

				if (this.inUseStrictDirective && propertyName != null) {
					switch (entryKind) {
					case PROP_ENTRY:
					case METHOD_ENTRY:
						if (getterNames.contains(propertyName)
								|| setterNames.contains(propertyName)) {
							addError("msg.dup.obj.lit.prop.strict", propertyName);
						}
						getterNames.add(propertyName);
						setterNames.add(propertyName);
						break;
					case GET_ENTRY:
						if (getterNames.contains(propertyName)) {
							addError("msg.dup.obj.lit.prop.strict", propertyName);
						}
						getterNames.add(propertyName);
						break;
					case SET_ENTRY:
						if (setterNames.contains(propertyName)) {
							addError("msg.dup.obj.lit.prop.strict", propertyName);
						}
						setterNames.add(propertyName);
						break;
					}
				}

				// Eat any dangling jsdoc in the property.
				getAndResetJsDoc();

				if (matchToken(Token.COMMA, true)) {
					afterComma = ts.getTokenEnd();
					commas.add(ts.getTokenBeg());
				} else {
					break commaLoop;
				}
			}

		if (mustMatchToken(Token.RC, "msg.no.brace.prop", true)) {
			init.setRC(ts.getTokenBeg());
		}
		init.setEnd(ts.getTokenEnd());
		init.setCommas(commas);
		init.getInitializers().addAll(elems);
		init.setMultiline(ts.getLineno() - lineno > 0);
		parents.pop();
		return init;
	}

	private Expression objliteralProperty() throws IOException {
		Expression pname;
		int tt = peekToken();
		switch (tt) {
		case Token.NAME:
			pname =  createNameNode();
			break;

		case Token.STRING:
			pname = createStringLiteral();
			break;

		case Token.NUMBER:
		case Token.BIGINT:
			pname = createNumericLiteral(tt, true);
			break;

		default:
			if (compilerEnv.isReservedKeywordAsIdentifier()
					&& TokenStream.isKeyword(
							ts.getString(),
							compilerEnv.getLanguageVersion(),
							inUseStrictDirective)) {
				// convert keyword to property name, e.g. ({if: 1})
				pname = createNameNode();
				break;
			}
			return null;
		}

		return pname;
	}

	private ObjectInitializerPart plainProperty(Expression property, int ptt, IntList commas) throws IOException {
		// Support, e.g., |var {x, y} = o| as destructuring shorthand
		// for |var {x: x, y: y} = o|, as implemented in spidermonkey JS 1.8.
		int tt = peekToken();
		if (tt == Token.COMMA) commas.add(ts.getTokenBeg());
		if ((tt == Token.COMMA || tt == Token.RC)
				&& ptt == Token.NAME
				&& compilerEnv.getLanguageVersion() >= Context.VERSION_1_8) {
			if (!inDestructuringAssignment
					&& compilerEnv.getLanguageVersion() < Context.VERSION_ES6) {
				reportError("msg.bad.object.init");
			}
			PropertyShorthand nn = new PropertyShorthand(getParent());
			nn.setStart(property.start());
			nn.setEnd(property.end());
			nn.setExpression(property);
			return nn;
		}
		mustMatchToken(Token.COLON, "msg.no.colon.prop", true);
		PropertyInitializer init = new PropertyInitializer(getParent());
		init.setStart(property.start());
		init.setColon(ts.getTokenBeg());
		parents.push(init);
		init.setName(property);
		property.setParent(init);
		Expression value = assignExpr();
		init.setValue(value);
		init.setEnd(value.end());
		parents.pop();
		return init;
	}

	private Method methodDefinition(int pos, Identifier propName, int entryKind)
			throws IOException { 
		FunctionStatement fn = function(FunctionNode.FUNCTION_EXPRESSION);
		// We've already parsed the function name, so fn should be anonymous.
		Identifier name = fn.getName();
		if (name != null && name.getName().length() != 0) {
			reportError("msg.bad.prop");
		}
		Method pn = null;
		switch (entryKind) {
		case GET_ENTRY:
			pn = new GetMethod(getParent());
			final Keyword getKeyword = new Keyword("get");
			getKeyword.setStart(pos);
			getKeyword.setEnd(pos + 3);
			((GetMethod)pn).setGetKeyword(getKeyword);
			break;
		case SET_ENTRY:
			pn = new SetMethod(getParent());
			if (fn.getArguments() != null && fn.getArguments().size() == 1)
			{
				Identifier identifier = fn.getArguments().get(0).getIdentifier();
				identifier.setParent(pn);
				((SetMethod)pn).setArgument(identifier);
			}
			final Keyword setKeyword = new Keyword("set");
			setKeyword.setStart(pos);
			setKeyword.setEnd(pos + 3);
			((SetMethod)pn).setSetKeyword(setKeyword);
			break;
		case METHOD_ENTRY:
			//TODO check not supported in dltk
			//                pn.setIsNormalMethod();
			//                fn.setFunctionIsNormalMethod();
			break;
		}
		if (pn != null) {
			pn.setStart(pos);
			pn.setEnd(fn.end());
			pn.setName(propName);
			pn.setBody(fn.getBody());
			fn.getBody().setParent(pn);
			pn.setLP(fn.getLP());
			pn.setRP(fn.getRP());
		}
		return pn;
	}

	private Identifier createNameNode() {
		return createNameNode(false, Token.NAME);
	}

	/**
	 * Create a {@code Name} node using the token info from the last scanned name. In some cases we
	 * need to either synthesize a name node, or we lost the name token information by peeking. If
	 * the {@code token} parameter is not {@link Token#NAME}, then we use token info saved in
	 * instance vars.
	 */
	private Identifier createNameNode(boolean checkActivation, int token) {
		int beg = ts.getTokenBeg();
		String s = ts.getString();
		if (!"".equals(prevNameTokenString)) {
			beg = prevNameTokenStart;
			s = prevNameTokenString;
			prevNameTokenStart = 0;
			prevNameTokenString = "";
		}
		if (s == null) {
			if (compilerEnv.isIdeMode()) {
				s = "";
			} else {
				codeBug();
			}
		}
		Identifier name = new Identifier(getParent());
		name.setName(s);
		name.setStart(beg);
		name.setEnd(beg + s.length());
		if (checkActivation) {
			checkActivationName(s, token);
		}
		return name;
	}

	private Label createLabelNode() {
		int beg = ts.getTokenBeg();
		String s = ts.getString();
		if (!"".equals(prevNameTokenString)) {
			beg = prevNameTokenStart;
			s = prevNameTokenString;
			prevNameTokenStart = 0;
			prevNameTokenString = "";
		}
		if (s == null) {
			if (compilerEnv.isIdeMode()) {
				s = "";
			} else {
				codeBug();
			}
		}
		Label name = new Label(getParent());
		name.setText(s);
		name.setStart(beg);
		name.setEnd(beg + s.length());
		return name;
	}

	private StringLiteral createStringLiteral() {
		int pos = ts.getTokenBeg(), end = ts.getTokenEnd();
		StringLiteral s = new StringLiteral(getParent());
		s.setStart(pos);
		s.setEnd(end);
//		String text = ts.getString();
//		if (text.contains("\\"))
//		{
			//copy from the source string to preserve the exact line terminators, escaped characters
			s.setText(ts.getSourceString().substring(pos, end));
//		}
//		else
//		{
//			StringBuilder builder = new StringBuilder();
//			builder.append(ts.getQuoteChar());
//			builder.append(text);
//			builder.append(ts.getQuoteChar());
//			s.setText(builder.toString());
//		}
		return s;
	}

	private Expression templateLiteral(boolean isTaggedLiteral) throws IOException {
		if (currentToken != Token.TEMPLATE_LITERAL) codeBug();
		int pos = ts.getTokenBeg();
		TemplateStringLiteral pn = new TemplateStringLiteral(getParent());
		parents.push(pn);
		pn.setStartBackTick(pos);
		pn.setStart(pos);
		StringBuilder text = new StringBuilder();
		text.append('`');

		int posChars = ts.getTokenBeg() + 1;
		int tt = ts.readTemplateLiteral(isTaggedLiteral);
		while (tt == Token.TEMPLATE_LITERAL_SUBST) {
			text.append(ts.getRawString());
			TemplateStringExpression expr = new TemplateStringExpression(getParent());
			expr.setStart(posChars);
			expr.setTemplateStringStart(posChars);
			expr.setExpression(expr(false));
			mustMatchToken(Token.RC, "msg.syntax", true);
			expr.setTemplateCloseBrace(ts.getTokenEnd());
			expr.setEnd(ts.getTokenEnd());
			text.append(ts.getSourceString().substring(posChars, ts.getTokenEnd()));

			pn.addTemplateStringExpression(expr);
			tt = ts.readTemplateLiteral(isTaggedLiteral);
		}
		if (tt == Token.ERROR) {
			return makeErrorNode();
		}
		assert tt == Token.TEMPLATE_LITERAL;
		//mustMatchToken(Token.TEMPLATE_LITERAL, "msg.syntax", true);
		text.append(ts.getString());
		pn.setEnd(ts.getTokenEnd());
		text.append('`');
		pn.setText('`'+ts.getSourceString().substring(posChars, ts.getTokenEnd()));
		pn.setEndBackTick(ts.getTokenBeg());

		parents.pop();
		return pn;
	}

	private Expression createNumericLiteral(int tt, boolean isProperty) {
		String s = ts.getString();
		if (this.inUseStrictDirective && ts.isNumericOldOctal()) {
			if (compilerEnv.getLanguageVersion() >= Context.VERSION_ES6 || !isProperty) {
				if (tt == Token.BIGINT) {
					reportError("msg.no.old.octal.bigint");
				} else {
					reportError("msg.no.old.octal.strict");
				}
			}
		}
		if (compilerEnv.getLanguageVersion() >= Context.VERSION_ES6 || !isProperty) {
			if (ts.isNumericBinary()) {
				s = "0b" + s;
			} else if (ts.isNumericOldOctal()) {
				s = "0" + s;
			} else if (ts.isNumericOctal()) {
				s = "0o" + s;
			} else if (ts.isNumericHex()) {
				s = "0x" + s;
			}
		}
		//BigInt is also decimal literal..
		//        if (tt == Token.BIGINT) {
		//            return new BigIntLiteral(ts.getTokenBeg(), s + "n", ts.getBigInt());
		//        } 
		//    else {
		// return new NumberLiteral(ts.getTokenBeg(), s, ts.getNumber());
		DecimalLiteral number = new DecimalLiteral(getParent());
		number.setText(s);
		number.setStart(ts.getTokenBeg());
		number.setEnd(ts.getTokenEnd());

		return number;
		//        }
	}

	protected void checkActivationName(String name, int token) {
		if (!insideFunction()) {
			return;
		}
		boolean activation = false;
		if ("arguments".equals(name)
				&&
				// An arrow function not generate arguments. So it not need activation.
				currentScriptOrFn instanceof ArrowFunctionStatement) {
			activation = true;
		} else if (compilerEnv.getActivationNames() != null
				&& compilerEnv.getActivationNames().contains(name)) {
			activation = true;
		} else if ("length".equals(name)) {
			if (token == Token.GETPROP && compilerEnv.getLanguageVersion() == Context.VERSION_1_2) {
				// Use of "length" in 1.2 requires an activation object.
				activation = true;
			}
		}
		if (activation) {
			setRequiresActivation();
		}
	}

	protected void setRequiresActivation() {
		if (insideFunction()) {
			//            ((FunctionNode) currentScriptOrFn).setRequiresActivation();
		}
	}

	protected void setIsGenerator() {
		if (insideFunction()) {
			//            ((FunctionNode) currentScriptOrFn).setIsGenerator();
		}
	}

	private void checkBadIncDec(UnaryOperation expr) {
		JSNode op = removeParens(expr.getExpression());
		if (!(op instanceof Identifier
				|| op instanceof GetMethod
				|| op instanceof GetArrayItemExpression
				// TODO what is get ref?  || tt == Token.GET_REF
				|| op instanceof CallExpression))
			reportError(expr.getOperation() == Token.INC ? "msg.bad.incr" : "msg.bad.decr");
	}

	private ErrorExpression makeErrorNode() {
		ErrorExpression pn = new ErrorExpression(getParent(), Util.EMPTY_STRING);
		pn.setStart(ts.getTokenBeg());
		pn.setEnd(ts.getTokenBeg());
		return pn;
	}

	private void saveNameTokenData(int pos, String name, int lineno) {
		prevNameTokenStart = pos;
		prevNameTokenString = name;
	}

	/**
	 * Return the file offset of the beginning of the input source line containing the passed
	 * position.
	 *
	 * @param pos an offset into the input source stream. If the offset is negative, it's converted
	 *     to 0, and if it's beyond the end of the source buffer, the last source position is used.
	 * @return the offset of the beginning of the line containing pos (i.e. 1+ the offset of the
	 *     first preceding newline). Returns -1 if the {@link CompilerEnvirons} is not set to
	 *     ide-mode, and {@link #parse(java.io.Reader,String,int)} was used.
	 */
	private int lineBeginningFor(int pos) {
		if (sourceChars == null) {
			return -1;
		}
		if (pos <= 0) {
			return 0;
		}
		char[] buf = sourceChars;
		if (pos >= buf.length) {
			pos = buf.length - 1;
		}
		while (--pos >= 0) {
			char c = buf[pos];
			if (ScriptRuntime.isJSLineTerminator(c)) {
				return pos + 1; // want position after the newline
			}
		}
		return 0;
	}

	private void warnMissingSemi(int pos, int end) {
		// Should probably change this to be a CompilerEnvirons setting,
		// with an enum Never, Always, Permissive, where Permissive means
		// don't warn for 1-line functions like function (s) {return x+2}
		if (compilerEnv.isStrictMode()) {
			int[] linep = new int[2];
			String line = ts.getLine(end, linep);
			// this code originally called lineBeginningFor() and in order to
			// preserve its different line-offset handling, we need to special
			// case ide-mode here
			int beg = compilerEnv.isIdeMode() ? Math.max(pos, end - linep[1]) : pos;
			if (line != null) {
				addStrictWarning("msg.missing.semi", "", beg, end - beg, linep[0], line, linep[1]);
			} else {
				// no line information available, report warning at current line
				addStrictWarning("msg.missing.semi", "", beg, end - beg);
			}
		}
	}

	private void warnTrailingComma(int pos, List<?> elems, int commaPos) {
		if (compilerEnv.getWarnTrailingComma()) {
			// back up from comma to beginning of line or array/objlit
			if (!elems.isEmpty()) {
				pos = ((JSNode) elems.get(0)).sourceStart();
			}
			pos = Math.max(pos, lineBeginningFor(commaPos));
			//addWarning("msg.extra.trailing.comma", pos, commaPos - pos);
			
			reporter.setMessage(JavaScriptParserProblems.TRAILING_COMMA_OBJECT_INITIALIZER, 
					lookupMessage("msg.extra.trailing.comma", null));
			reporter.setSeverity(ProblemSeverity.WARNING);
			reporter.setRange(ts.getTokenBeg(), ts.getTokenEnd());
			reporter.report();
		}
	}

	// helps reduce clutter in the already-large function() method
	protected class PerFunctionVariables {
		private JSNode savedCurrentScriptOrFn;
		private SymbolTable savedCurrentScope;
		private int savedEndFlags;
		private boolean savedInForInit;
		//        private Map<String, LabeledStatement> savedLabelSet;
		private List<LoopStatement> savedLoopSet;
		private List<Statement> savedLoopAndSwitchSet;

		PerFunctionVariables(ArrowFunctionStatement fnNode) {
			savedCurrentScriptOrFn = Parser.this.currentScriptOrFn;
			Parser.this.currentScriptOrFn = fnNode;

			savedCurrentScope = Parser.this.currentScope;
			Parser.this.currentScope = new SymbolTable(fnNode);

			//            savedLabelSet = Parser.this.labelSet;
			Parser.this.labelSet = null;

			savedLoopSet = Parser.this.loopSet;
			Parser.this.loopSet = null;

			savedLoopAndSwitchSet = Parser.this.loopAndSwitchSet;
			Parser.this.loopAndSwitchSet = null;

			savedEndFlags = Parser.this.endFlags;
			Parser.this.endFlags = 0;

			savedInForInit = Parser.this.inForInit;
			Parser.this.inForInit = false;
		}

		void restore() {
			Parser.this.currentScriptOrFn = savedCurrentScriptOrFn;
			Parser.this.currentScope = savedCurrentScope;
			//            Parser.this.labelSet = savedLabelSet;
			Parser.this.loopSet = savedLoopSet;
			Parser.this.loopAndSwitchSet = savedLoopAndSwitchSet;
			Parser.this.endFlags = savedEndFlags;
			Parser.this.inForInit = savedInForInit;
		}
	}

	//    PerFunctionVariables createPerFunctionVariables(FunctionNode fnNode) {
	//        return new PerFunctionVariables(fnNode);
	//    }

	/**
	 * Given a destructuring assignment with a left hand side parsed as an array or object literal
	 * and a right hand side expression, rewrite as a series of assignments to the variables defined
	 * in left from property accesses to the expression on the right.
	 *
	 * @param type declaration type: Token.VAR or Token.LET or -1
	 * @param left array or object literal containing NAME nodes for variables to assign
	 * @param right expression to assign from
	 * @return expression that performs a series of assignments to the variables defined in left
	 */
	Node createDestructuringAssignment(int type, Node left, Node right) {
		//        String tempName = currentScriptOrFn.getNextTempName();
		//        Node result = destructuringAssignmentHelper(type, left, right, tempName);
		//        Node comma = result.getLastChild();
		//        comma.addChildToBack(createName(tempName));
		//        return result;
		return null;
	}

	Expression destructuringAssignmentHelper(int variableType, Node left, Node right, String tempName) {
		//        Scope result = createScopeNode(Token.LETEXPR, left.getLineno());
		//        result.addChildToFront(new Node(Token.LET, createName(Token.NAME, tempName, right)));
		//        try {
		////            pushScope(result);
		//            defineSymbol(Token.LET, tempName, true, null); //TODO param JSDeclaration
		//        } finally {
		////            popScope();
		//        }
		//        Node comma = new Node(Token.COMMA);
		//        result.addChildToBack(comma);
		//        List<String> destructuringNames = new ArrayList<>();
		//        boolean empty = true;
		//        switch (left.getType()) {
		//            case Token.ARRAYLIT:
		//                empty =
		//                        destructuringArray(
		//                                (ArrayLiteral) left,
		//                                variableType,
		//                                tempName,
		//                                comma,
		//                                destructuringNames);
		//                break;
		//            case Token.OBJECTLIT:
		//                empty =
		//                        destructuringObject(
		//                                (ObjectLiteral) left,
		//                                variableType,
		//                                tempName,
		//                                comma,
		//                                destructuringNames);
		//                break;
		//            case Token.GETPROP:
		//            case Token.GETELEM:
		//                switch (variableType) {
		//                    case Token.CONST:
		//                    case Token.LET:
		//                    case Token.VAR:
		//                        reportError("msg.bad.assign.left");
		//                }
		//                comma.addChildToBack(simpleAssignment(left, createName(tempName)));
		//                break;
		//            default:
		//                reportError("msg.bad.assign.left");
		//        }
		//        if (empty) {
		//            // Don't want a COMMA node with no children. Just add a zero.
		//            comma.addChildToBack(createNumber(0));
		//        }
		//        result.putProp(Node.DESTRUCTURING_NAMES, destructuringNames);
		//        return result;
		return null;
	}

//	boolean destructuringArray(
//			ArrayLiteral array,
//			int variableType,
//			String tempName,
//			Node parent,
//			List<String> destructuringNames) {
//		boolean empty = true;
//		int setOp = variableType == Token.CONST ? Token.SETCONST : Token.SETNAME;
//		int index = 0;
//		for (AstNode n : array.getElements()) {
//			if (n.getType() == Token.EMPTY) {
//				index++;
//				continue;
//			}
//			Node rightElem = new Node(Token.GETELEM, createName(tempName), createNumber(index));
//			if (n.getType() == Token.NAME) {
//				String name = n.getString();
//				parent.addChildToBack(
//						new Node(setOp, createName(Token.BINDNAME, name, null), rightElem));
//				if (variableType != -1) {
//					defineSymbol(variableType, name, true, null); //TODO param JSDeclaration
//					destructuringNames.add(name);
//				}
//			} else {
//				//                parent.addChildToBack(
//				//                        destructuringAssignmentHelper(
//				//                                variableType, n, rightElem, currentScriptOrFn.getNextTempName()));
//			}
//			index++;
//			empty = false;
//		}
//		return empty;
//	}
//
//	boolean destructuringObject(
//			ObjectLiteral node,
//			int variableType,
//			String tempName,
//			Node parent,
//			List<String> destructuringNames) {
//		boolean empty = true;
//		int setOp = variableType == Token.CONST ? Token.SETCONST : Token.SETNAME;
//
//		for (ObjectProperty prop : node.getElements()) {
//			int lineno = 0;
//			// This function is sometimes called from the IRFactory when
//			// when executing regression tests, and in those cases the
//			// tokenStream isn't set.  Deal with it.
//			if (ts != null) {
//				lineno = ts.getLineno();
//			}
//			AstNode id = prop.getLeft();
//			Node rightElem = null;
//			if (id instanceof Name) {
//				Node s = Node.newString(((Name) id).getIdentifier());
//				rightElem = new Node(Token.GETPROP, createName(tempName), s);
//				//TODO
//				//            } else if (id instanceof StringLiteral) {
//				//                Node s = Node.newString(((StringLiteral) id).getValue());
//				//                rightElem = new Node(Token.GETPROP, createName(tempName), s);
//			} else if (id instanceof NumberLiteral) {
//				Node s = createNumber((int) ((NumberLiteral) id).getNumber());
//				rightElem = new Node(Token.GETELEM, createName(tempName), s);
//			} else {
//				//rightElem = codeBug();
//				return false;
//				//throw codeBug();
//			}
//			rightElem.setLineno(lineno);
//			AstNode value = prop.getRight();
//			if (value.getType() == Token.NAME) {
//				String name = ((Name) value).getIdentifier();
//				parent.addChildToBack(
//						new Node(setOp, createName(Token.BINDNAME, name, null), rightElem));
//				if (variableType != -1) {
//					defineSymbol(variableType, name, true, null); //TODO param JSDeclaration
//					destructuringNames.add(name);
//				}
//			} else {
//				//                parent.addChildToBack(
//				//                        destructuringAssignmentHelper(
//				//                                variableType,
//				//                                value,
//				//                                rightElem,
//				//                                currentScriptOrFn.getNextTempName()));
//			}
//			empty = false;
//		}
//		return empty;
//	}

	protected Node createName(String name) {
		checkActivationName(name, Token.NAME);
		return Node.newString(Token.NAME, name);
	}

	protected Node createName(int type, String name, Node child) {
		Node result = createName(name);
		result.setType(type);
		if (child != null) result.addChildToBack(child);
		return result;
	}

	protected Node createNumber(double number) {
		return Node.newNumber(number);
	}

	// Quickie tutorial for some of the interpreter bytecodes.
	//
	// GETPROP - for normal foo.bar prop access; right side is a name
	// GETELEM - for normal foo[bar] element access; rhs is an expr
	// SETPROP - for assignment when left side is a GETPROP
	// SETELEM - for assignment when left side is a GETELEM
	// DELPROP - used for delete foo.bar or foo[bar]
	//
	// GET_REF, SET_REF, DEL_REF - in general, these mean you're using
	// get/set/delete on a right-hand side expression (possibly with no
	// explicit left-hand side) that doesn't use the normal JavaScript
	// Object (i.e. ScriptableObject) get/set/delete functions, but wants
	// to provide its own versions instead.  It will ultimately implement
	// Ref, and currently SpecialRef (for __proto__ etc.) and XmlName
	// (for E4X XML objects) are the only implementations.  The runtime
	// notices these bytecodes and delegates get/set/delete to the object.
	//
	// BINDNAME:  used in assignments.  LHS is evaluated first to get a
	// specific object containing the property ("binding" the property
	// to the object) so that it's always the same object, regardless of
	// side effects in the RHS.

	protected Expression simpleAssignment(Node left, Node right) {
		//        int nodeType = left.getType();
		//        switch (nodeType) {
		//            case Token.NAME:
		//                String name = ((Name) left).getIdentifier();
		//                if (inUseStrictDirective && ("eval".equals(name) || "arguments".equals(name))) {
		//                    reportError("msg.bad.id.strict", name);
		//                }
		//                left.setType(Token.BINDNAME);
		//                return new Node(Token.SETNAME, left, right);
		//
		//            case Token.GETPROP:
		//            case Token.GETELEM:
		//                {
		//                    Node obj, id;
		//                    // If it's a PropertyGet or ElementGet, we're in the parse pass.
		//                    // We could alternately have PropertyGet and ElementGet
		//                    // override getFirstChild/getLastChild and return the appropriate
		//                    // field, but that seems just as ugly as this casting.
		//                    if (left instanceof PropertyGet) {
		//                        obj = ((PropertyGet) left).getTarget();
		//                        id = ((PropertyGet) left).getProperty();
		//                    } else if (left instanceof ElementGet) {
		//                        obj = ((ElementGet) left).getTarget();
		//                        id = ((ElementGet) left).getElement();
		//                    } else {
		//                        // This branch is called during IRFactory transform pass.
		//                        obj = left.getFirstChild();
		//                        id = left.getLastChild();
		//                    }
		//                    int type;
		//                    if (nodeType == Token.GETPROP) {
		//                        type = Token.SETPROP;
		//                        // TODO(stevey) - see https://bugzilla.mozilla.org/show_bug.cgi?id=492036
		//                        // The new AST code generates NAME tokens for GETPROP ids where the old
		//                        // parser
		//                        // generated STRING nodes. If we don't set the type to STRING below, this
		//                        // will
		//                        // cause java.lang.VerifyError in codegen for code like
		//                        // "var obj={p:3};[obj.p]=[9];"
		//                        id.setType(Token.STRING);
		//                    } else {
		//                        type = Token.SETELEM;
		//                    }
		//                    return new Node(type, obj, id, right);
		//                }
		//            case Token.GET_REF:
		//                {
		//                    Node ref = left.getFirstChild();
		//                    checkMutableReference(ref);
		//                    return new Node(Token.SET_REF, ref, right);
		//                }
		//        }

		throw codeBug();
	}

	protected void checkMutableReference(Node n) {
		int memberTypeFlags = n.getIntProp(Node.MEMBER_TYPE_PROP, 0);
		if ((memberTypeFlags & Node.DESCENDANTS_FLAG) != 0) {
			reportError("msg.bad.assign.left");
		}
	}

	// remove any ParenthesizedExpression wrappers
	protected Expression removeParens(Expression node) {
		while (node instanceof ParenthesizedExpression) {
			node = ((ParenthesizedExpression) node).getExpression();
		}
		return node;
	}

	void markDestructuring(Expression expr) {
//		if (expr instanceof DestructuringForm) {
//			((DestructuringForm) expr).setIsDestructuring(true);
//		} else if (expr instanceof ParenthesizedExpression) {
//			markDestructuring(((ParenthesizedExpression) expr).getExpression());
//		}
	}

	// throw a failed-assertion with some helpful debugging info
	private RuntimeException codeBug() throws RuntimeException {
		reporter.setFormattedMessage(
				JavaScriptParserProblems.INTERNAL_ERROR,
				"Parse error at '" + ts.getSourceString().substring(ts.getTokenBeg(), ts.getTokenEnd())+"'");
		reporter.setSeverity(ProblemSeverity.ERROR);
		reporter.setRange(ts.getTokenBeg(), ts.getTokenEnd());
		reporter.report();

		return Kit.codeBug(
				"ts.cursor="
						+ ts.getCursor()
						+ ", ts.getTokenBeg()="
						+ ts.getTokenBeg()
						+ ", currentToken="
						+ currentToken);
	}

	public boolean inUseStrictDirective() {
		return inUseStrictDirective;
	}

	@Override
	public boolean getCalledByCompileFunction() {
		return calledByCompileFunction;
	}

	@Override
	public CompilerEnvirons getCompilerEnv() {
		return compilerEnv;
	}
}
