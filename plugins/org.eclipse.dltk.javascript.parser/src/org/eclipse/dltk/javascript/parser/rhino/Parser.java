/* -*- Mode: java; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.eclipse.dltk.javascript.parser.rhino;

import java.io.IOException;

import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.Script;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.ast.IdeErrorReporter;

/**
 * This class implements the JavaScript parser.
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
public class Parser {



	private boolean parseFinished; // set when finished to prevent reuse
    String sourceURI;
    CompilerEnvirons compilerEnv;
    
    private TokenStream ts;
    int syntaxErrorCount;
    
    private ErrorReporter errorReporter;
    private IdeErrorReporter errorCollector;

    protected boolean inUseStrictDirective;
    
    private static class ParserException extends RuntimeException {
        private static final long serialVersionUID = 5882582646773765630L;
    }
    
    
    public Parser() {
        this(new CompilerEnvirons());
    }

    public Parser(CompilerEnvirons compilerEnv) {
        this(compilerEnv, compilerEnv.getErrorReporter());
    }

    public Parser(CompilerEnvirons compilerEnv, ErrorReporter errorReporter) {
        this.compilerEnv = compilerEnv;
        this.errorReporter = errorReporter;
        if (errorReporter instanceof IdeErrorReporter) {
            errorCollector = (IdeErrorReporter) errorReporter;
        }
    }
    public Script parse(String sourceString, String sourceURI, int lineno) {
        if (parseFinished) throw new IllegalStateException("parser reused");
        this.sourceURI = sourceURI;
//        if (compilerEnv.isIdeMode()) {
//            this.sourceChars = sourceString.toCharArray();
//        }
        this.ts = new TokenStream(this, null, sourceString, lineno);
        try {
        	JSTransformer transformer = new JSTransformer();
        	return transformer.transformScript(ts);
        } catch (IOException iox) {
            // Should never happen
            throw new IllegalStateException();
        } finally {
            parseFinished = true;
        }
    }
    
    
//    private int peekFlaggedToken() throws IOException {
//        peekToken();
//        return currentFlaggedToken;
//    }
    

    // Returns Token.EOL if the current token follows a newline, else returns
    // the current token.  Used in situations where we don't consider certain
    // token types valid if they are preceded by a newline.  One example is the
    // postfix ++ or -- operator, which has to be on the same line as its
    // operand.
//    private int peekTokenOrEOL() throws IOException {
//        int tt = peekToken();
//        // Check for last peeked token flags
//        if ((currentFlaggedToken & TI_AFTER_EOL) != 0) {
//            tt = Token.EOL;
//        }
//        return tt;
//    }

    
//    void consumeToken() {
//        currentFlaggedToken = Token.EOF;
//    }

//    private int nextToken() throws IOException {
//        int tt = peekToken();
//        consumeToken();
//        return tt;
//    }
    

    
    FunctionStatement function () {
    	return null;
    }

    public boolean inUseStrictDirective() {
        return inUseStrictDirective;
    }
    void reportError(String messageId) {
        reportError(messageId, null);
    }

    void reportError(String messageId, String messageArg) {
        if (ts == null) { // happens in some regression tests
            reportError(messageId, messageArg, 1, 1);
        } else {
            reportError(messageId, messageArg, ts.tokenBeg, ts.tokenEnd - ts.tokenBeg);
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
    
    void addWarning(String messageId, String messageArg) {
        int beg = -1, end = -1;
        if (ts != null) {
            beg = ts.tokenBeg;
            end = ts.tokenEnd - ts.tokenBeg;
        }
        addWarning(messageId, messageArg, beg, end);
    }

    void addWarning(String messageId, int position, int length) {
        addWarning(messageId, null, position, length);
    }

    void addWarning(String messageId, String messageArg, int position, int length) {
    	System.err.println("warning added " + messageId  + " " + messageArg);
//        String message = lookupMessage(messageId, messageArg);
//        if (compilerEnv.reportWarningAsError()) {
//            addError(messageId, messageArg, position, length);
//        } else if (errorCollector != null) {
//            errorCollector.warning(message, sourceURI, position, length);
//        } else if (ts != null) {
//            errorReporter.warning(message, sourceURI, ts.getLineno(), ts.getLine(), ts.getOffset());
//        } else {
//            errorReporter.warning(message, sourceURI, 1, "", 1);
//        }
    }
    void addError(String messageId) {
        if (ts == null) {
            addError(messageId, 0, 0);
        } else {
            addError(messageId, ts.tokenBeg, ts.tokenEnd - ts.tokenBeg);
        }
    }

    void addError(String messageId, int position, int length) {
        addError(messageId, null, position, length);
    }

    void addError(String messageId, String messageArg) {
        if (ts == null) {
            addError(messageId, messageArg, 0, 0);
        } else {
            addError(messageId, messageArg, ts.tokenBeg, ts.tokenEnd - ts.tokenBeg);
        }
    }

    void addError(String messageId, int c) {
        String messageArg = Character.toString((char) c);
        addError(messageId, messageArg);
    }
    void addError(String messageId, String messageArg, int position, int length) {
    	addError(messageId, messageArg, position, length, -1, null, -1);
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
    	System.err.println("error added " + messageId  + " " + messageArg);
    }
    
}
