/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.javascript.internal.ui.text;

import static org.eclipse.dltk.javascript.ast.MultiLineComment.JSDOC_PREFIX;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.javascript.ui.text.IJavaScriptPartitions;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

public class JavascriptPartitionScanner extends RuleBasedPartitionScanner {

	private static class JavaScriptStringRule extends SingleLineRule {
		public JavaScriptStringRule(String quote, IToken token) {
			super(quote, quote, token, '\\', true, true);
		}
	}

	/**
	 * Detector for empty comments.
	 */
	static class EmptyCommentDetector implements IWordDetector {

		/*
		 * @see IWordDetector#isWordStart
		 */
		public boolean isWordStart(char c) {
			return (c == '/');
		}

		/*
		 * @see IWordDetector#isWordPart
		 */
		public boolean isWordPart(char c) {
			return (c == '*' || c == '/');
		}
	}

	/**
	 * Word rule for empty comments.
	 */
	static class EmptyCommentRule extends WordRule implements IPredicateRule {

		private IToken fSuccessToken;

		/**
		 * Constructor for EmptyCommentRule.
		 * 
		 * @param successToken
		 */
		public EmptyCommentRule(IToken successToken) {
			super(new EmptyCommentDetector());
			fSuccessToken = successToken;
			addWord("/**/", fSuccessToken); //$NON-NLS-1$
		}

		/*
		 * @see IPredicateRule#evaluate(ICharacterScanner, boolean)
		 */
		public IToken evaluate(ICharacterScanner scanner, boolean resume) {
			return evaluate(scanner);
		}

		/*
		 * @see IPredicateRule#getSuccessToken()
		 */
		public IToken getSuccessToken() {
			return fSuccessToken;
		}
	}

	/**
	 * Creates the partitioner and sets up the appropriate rules.
	 */
	public JavascriptPartitionScanner() {
		super();

		IToken string = new Token(IJavaScriptPartitions.JS_STRING);
		IToken stringSingle = new Token(IJavaScriptPartitions.JS_STRING_SINGLE);
		IToken multiLineComment = new Token(
				IJavaScriptPartitions.JS_MULTI_LINE_COMMENT);
		IToken singleLineComment = new Token(
				IJavaScriptPartitions.JS_SINGLE_LINE_COMMENT);
		IToken doc = new Token(IJavaScriptPartitions.JS_DOC);

		List<IPredicateRule> rules = new ArrayList<IPredicateRule>();
		rules.add(new EndOfLineRule("//", singleLineComment) {
			@Override
			protected boolean sequenceDetected(ICharacterScanner scanner,
					char[] sequence, boolean eofAllowed) {

				boolean retValue = super.sequenceDetected(scanner, sequence,
						eofAllowed);
				if (retValue) {
					// check if we are inside a regular expression
					scanner.unread();
					scanner.unread();
					scanner.unread();
					int prevChar = scanner.read();
					scanner.read();
					scanner.read();
					int nextChar = scanner.read();
					scanner.unread();
					if (prevChar == '\\' && (nextChar == 'g' || nextChar == 'i'
							|| nextChar == 'm')) {
						return false;
					}
				}
				return retValue;
			}
		}); // $NON-NLS-1$
		// Add special case word rule.
		rules.add(new EmptyCommentRule(multiLineComment));
		rules.add(new MultiLineRule(JSDOC_PREFIX, "*/", doc)); //$NON-NLS-1$ 
		rules.add(new MultiLineRule("/*", "*/", multiLineComment)); //$NON-NLS-1$ //$NON-NLS-2$

		// Add rule for character constants.
		rules.add(new JavaScriptStringRule("'", stringSingle));
		rules.add(new JavaScriptStringRule("\"", string));

		IPredicateRule[] result = new IPredicateRule[rules.size()];
		rules.toArray(result);
		setPredicateRules(result);
	}
}