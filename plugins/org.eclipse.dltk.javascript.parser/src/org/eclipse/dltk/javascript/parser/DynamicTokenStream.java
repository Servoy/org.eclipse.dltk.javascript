/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.eclipse.dltk.javascript.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.dltk.utils.IntList;

public class DynamicTokenStream implements TokenStream, JSTokenStream {

	private static final boolean DEBUG = false;

	private final JavaScriptTokenSource tokenSource;

	/**
	 * Record every single token pulled from the source so we can reproduce
	 * chunks of it later.
	 */
	private List<Token> tokens;
	private IntList offsets;
	private IntList modes;

	private int currentMode = 0;

	/**
	 * Skip tokens on any channel but this one; this is how we skip
	 * whitespace...
	 */
	private int channel = Token.DEFAULT_CHANNEL;

	/** Track the last mark() call result value for use in rewind(). */
	private int lastMarker;

	/**
	 * The index into the tokens list of the current token (next token to
	 * consume).
	 */
	private int p = 0;
	private boolean pValid = false;

	public DynamicTokenStream(JavaScriptTokenSource tokenSource) {
		tokens = new ArrayList<Token>(500);
		offsets = new IntList(500);
		modes = new IntList(500);
		this.tokenSource = tokenSource;
	}

	public DynamicTokenStream(JavaScriptTokenSource tokenSource, int channel) {
		this(tokenSource);
		this.channel = channel;
	}

	/**
	 * Fetches the next token, returns the result if fetch was successful
	 */
	private final boolean fetchToken() {
		CommonToken t = (CommonToken) tokenSource.nextToken();
		if (t.getType() != JSParser.EOF) {
			int index = tokens.size();
			t.setTokenIndex(index);
			tokens.add(t);
			int offset = t.getStopIndex() - t.getStartIndex() + 1;
			if (offsets.size() != 0) {
				offset += offsets.get(offsets.size() - 1);
			}
			offsets.add(offset);
			modes.add(currentMode);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * if EOF was reached.
	 */
	private boolean endOfStream = false;

	/**
	 * Loads tokens up to <code>n</code>-th, do nothing if the specified element
	 * is already loaded.
	 */
	protected void fill(int n) {
		if (endOfStream) {
			return;
		}
		for (int i = tokens.size(); i <= n; ++i) {
			if (!fetchToken()) {
				endOfStream = true;
				if (DEBUG)
					System.out.println("EOF at fill(" + i + ")");
				break;
			}
		}
	}

	/**
	 * Makes sure current index is valid
	 */
	private void init() {
		if (!pValid) {
			p = skipOffTokenChannels(p); // init
			pValid = true;
		}
	}

	/**
	 * Loads all tokens from the stream
	 */
	private void loadAll() {
		if (!endOfStream) {
			if (DEBUG)
				System.out.println("LOAD ALL");
			while (fetchToken())
				;
			endOfStream = true;
		}
	}

	/**
	 * Move the input pointer to the next incoming token. The stream must become
	 * active with LT(1) available. consume() simply moves the input pointer so
	 * that LT(1) points at the next input symbol. Consume at least one token.
	 * 
	 * Walk past any token not on the channel the parser is listening to.
	 */
	public void consume() {
		assert pValid;
		if (!endOfStream) {
			fill(p + 1);
		}
		if (p < tokens.size()) {
			++p;
			p = skipOffTokenChannels(p); // leave p on valid token
			pValid = true;
		}
	}

	/**
	 * Given a starting index, return the index of the first on-channel token.
	 */
	protected int skipOffTokenChannels(int i) {
		for (;;) {
			if (!endOfStream) {
				fill(i);
			}
			if (i >= tokens.size()) {
				return i;
			}
			if (tokens.get(i).getChannel() == channel) {
				return i;
			}
			++i;
		}
	}

	protected int skipOffTokenChannelsReverse(int i) {
		while (i >= 0 && tokens.get(i).getChannel() != channel) {
			i--;
		}
		return i;
	}

	public List<Token> getTokens() {
		loadAll();
		return tokens;
	}

	/**
	 * Get the ith token from the current position 1..n where k=1 is the first
	 * symbol of lookahead.
	 */
	public Token LT(int k) {
		if (k == 0) {
			return null;
		}
		init();
		if (k < 0) {
			return LB(-k);
		}
		fill(p + k - 1);
		if (p + k - 1 >= tokens.size()) {
			return new CommonToken(CharStream.EOF);
		}
		int i = p;
		// skip k-1 tokens
		while (--k > 0) {
			// skip off-channel tokens
			i = skipOffTokenChannels(i + 1); // leave p on valid token
		}
		if (i >= tokens.size()) {
			return new CommonToken(CharStream.EOF);
		}
		return tokens.get(i);
	}

	/** Look backwards k tokens on-channel tokens 
	 * @since 6.0
	 s*/
	protected Token LB(int k) {
		assert k != 0;
		if (p < k) {
			return null;
		}
		int i = p;
		// skip k tokens backwards
		while (--k >= 0) {
			// skip off-channel tokens
			i = skipOffTokenChannelsReverse(i - 1); // leave p on valid token
		}
		if (i < 0) {
			return null;
		}
		return tokens.get(i);
	}

	/**
	 * Return absolute token i; ignore which channel the tokens are on; that is,
	 * count all tokens not just on-channel tokens.
	 */
	public Token get(int i) {
		fill(i);
		return i < tokens.size() ? tokens.get(i) : null;
	}

	public int LA(int i) {
		return LT(i).getType();
	}

	public int mark() {
		lastMarker = index();
		return lastMarker;
	}

	public void release(int marker) {
		// no resources to release
	}

	public int size() {
		loadAll();
		return tokens.size();
	}

	public int index() {
		assert pValid;
		return p;
	}

	public void rewind(int marker) {
		seek(marker);
	}

	public void rewind() {
		seek(lastMarker);
	}

	public void seek(int index) {
		fill(index);
		// TODO any validation?
		p = index;
	}

	public TokenSource getTokenSource() {
		return tokenSource;
	}

	@Override
	public String toString() {
		loadAll();
		return toString(0, tokens.size() - 1);
	}

	public String toString(int start, int stop) {
		if (start < 0 || stop < 0) {
			return null;
		}
		fill(stop);
		if (stop >= tokens.size()) {
			stop = tokens.size() - 1;
		}
		StringBuilder buf = new StringBuilder();
		for (int i = start; i <= stop; i++) {
			Token t = tokens.get(i);
			buf.append(t.getText());
		}
		return buf.toString();
	}

	/**
	 * @since 6.0
	 */
	public String toString(Token start, Token stop) {
		if (start != null && stop != null) {
			return toString(start.getTokenIndex(), stop.getTokenIndex());
		}
		return null;
	}

	public int getMode() {
		return currentMode;
	}

	public void setMode(int value) {
		if (value == currentMode) {
			return;
		}
		currentMode = value;
		tokenSource.setMode(value);
		if (p < tokens.size()) {
			pValid = false;
			// reset already loaded tokens after current position
			endOfStream = false;
			for (int i = tokens.size(); --i >= p;) {
				tokens.remove(i);
			}
			assert p == tokens.size();
			offsets.setSize(p);
			modes.setSize(p);
			assert offsets.size() == tokens.size();
			// rewind tokenSource
			tokenSource.seek(offsets.size() == 0 ? 0 : offsets.get(offsets
					.size() - 1));
		}
	}

	//TODO check err reporting in v4
	public void setReporter(Reporter reporter) {
		tokenSource.setReporter(reporter);
	}

	@Override
	public String getSourceName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(Interval interval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(RuleContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(Token start, Token stop) {
		// TODO Auto-generated method stub
		return null;
	}
}
