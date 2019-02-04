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
package org.eclipse.dltk.internal.javascript.typeinference;

import java.util.Stack;

public class CompletionString {

	private static class Bracket {
		final char ch;
		final int position;

		public Bracket(char ch, int position) {
			this.ch = ch;
			this.position = position;
		}

	}

	public static String parse(String id, boolean dotBeforeBrackets) {
		return parse(id, dotBeforeBrackets, false);
	}

	public static String parse(String id, boolean dotBeforeBrackets,
			boolean functionCallParenthesis) {
		StringBuffer sb = new StringBuffer();
		int start = 0;
		int current = id.length();
		final Stack<Bracket> inBrackStack = new Stack<Bracket>();
		boolean inStringSingle = false;
		boolean inStringDouble = false;
		outer: for (int i = id.length(); --i >= 0;) {
			char c = id.charAt(i);
			if (c == '\'') {
				if (inStringSingle) {
					inStringSingle = false;
					continue;
				}
				// end of a string try to skip this.
				if (!inStringDouble)
					inStringSingle = true;
			}
			if (c == '\"') {
				if (inStringDouble) {
					inStringDouble = false;
					continue;
				}
				// end of a string try to skip this.
				if (!inStringSingle)
					inStringDouble = true;
			}
			if (inStringSingle || inStringDouble)
				continue;

			if (c == ']') {
				if (inBrackStack.isEmpty()) {
					String brackets = "[]";
					if (dotBeforeBrackets && i > 0
							&& ((i - 2) < 0 || id.charAt(i - 2) != '.')) {
						brackets = ".[]";
					}
					sb.insert(0, brackets + id.substring(i + 1, current));
				}
				inBrackStack.push(new Bracket('[', i));
				continue;
			}
			if (c == ')') {
				if (inBrackStack.isEmpty()) {
					if (functionCallParenthesis) {
						String parens = "()";
						if (dotBeforeBrackets && i > 0
								&& ((i - 2) < 0 || id.charAt(i - 2) != '.')) {
							parens = ".()";
						}
						sb.insert(0, parens + id.substring(i + 1, current));
					} else {
						sb.insert(0, id.substring(i + 1, current));
					}
				}
				inBrackStack.push(new Bracket('(', i));
				continue;
			}
			if (c == '[' || c == '(') {
				if (inBrackStack.isEmpty()) {
					if (i + 1 < id.length() && id.charAt(i + 1) == c) {
						// illegal code like [[xx]. try best guess
						id = id.substring(0, i) + id.substring(i + 1);
						return parse(id, dotBeforeBrackets,
								functionCallParenthesis);
					}
					return id.substring(i + 1, current) + sb.toString();
				}
				if (c == inBrackStack.peek().ch) {
					current = i;
					inBrackStack.pop();
				}
				continue;
			}
			if (c == ':') {
				if (i >= 1 && id.charAt(i - 1) == ':') {
					// "::" is part of XML expressions
					--i;
					continue;
				} else if (inBrackStack.isEmpty()) {
					// label, object literal, etc.
					start = i + 1;
					break;
				}
			}
			// for now only support {}
			if (c == '}' && inBrackStack.isEmpty() && i >= 1
					&& id.charAt(i - 1) == '{') {
				return "{}.";
			}
			if (c != '.'
					&& c != '@'
					&& inBrackStack.isEmpty()
					&& (Character.isWhitespace(c) || !Character
							.isJavaIdentifierPart(c))) {
				int k = i;
				while (k-- > 0) {
					if (!Character.isWhitespace(id.charAt(k))) {
						if (id.charAt(k) == '.') {
							int lastLineBreak = id.lastIndexOf('\n', k);
							int nextCommentTag = id
									.indexOf("//", lastLineBreak);
							if (nextCommentTag == -1 || nextCommentTag > k) {
								i = k + 1;
								continue outer;
							}
						}
						break;
					}
				}
				start = i + 1;
				break;
			}
			if (c == '.') {
				// skip white space
				while (--i >= 0) {
					if (!Character.isWhitespace(id.charAt(i))) {
						i++;
						break;
					}
				}
			}

		}
		if (start == 0 && current == id.length() && inBrackStack.isEmpty())
			return id;
		if (!inBrackStack.isEmpty()) { // illegal code like []]
			Bracket last = inBrackStack.pop();
			id = id.substring(start, last.position)
					+ id.substring(last.position + 1, id.length());
			return parse(id, dotBeforeBrackets, functionCallParenthesis);
		}
		sb.insert(0, id.substring(start, current));
		if (dotBeforeBrackets && sb.length() > 1 && sb.charAt(0) == '.'
				&& sb.charAt(1) == '[') {
			// don't return a . before the brackets when it starts with this (so
			// the start of the completion is the array itself)
			return sb.substring(1);
		}
		return sb.toString().replaceAll("\\s", "");
	}

}
