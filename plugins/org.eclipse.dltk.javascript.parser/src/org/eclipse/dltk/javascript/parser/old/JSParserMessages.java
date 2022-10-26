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
package org.eclipse.dltk.javascript.parser.old;

import java.util.HashMap;
import java.util.Map;

public class JSParserMessages {

	private static class Key {
		final JSParserRule rule;
		final int prevToken;

		public Key(JSParserRule rule, int prevToken) {
			this.rule = rule;
			this.prevToken = prevToken;
		}

		@Override
		public int hashCode() {
			return prevToken * 31 + rule.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Key) {
				final Key other = (Key) obj;
				return prevToken == other.prevToken && rule == other.rule;
			}
			return false;
		}

	}

	private final Map<Key, String> messages = new HashMap<Key, String>();
	private final Map<Integer, String> tokenNames = new HashMap<Integer, String>();

	public JSParserMessages() {
		messages.put(new Key(JSParserRule.LEFT_HAND_SIDE_EXPRESSION,
				JSParser.DOT), "missing name after . operator");
		tokenNames.put(JSParser.RBRACE, "}");
		tokenNames.put(JSParser.LBRACE, "{");
		tokenNames.put(JSParser.RPAREN, ")");
		tokenNames.put(JSParser.LPAREN, "(");
		tokenNames.put(JSParser.LBRACK, "[");
		tokenNames.put(JSParser.RBRACK, "]");

	}

	public String get(JSParserRule rule, int prevToken) {
		return messages.get(new Key(rule, prevToken));
	}

	public String get(int tokenType) {
		return tokenNames.get(tokenType);
	}

}
