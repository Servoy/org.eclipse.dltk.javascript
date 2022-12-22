/*******************************************************************************
 * Copyright (c) 2011 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.parser.jsdoc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.javascript.ast.MultiLineComment;
import org.eclipse.dltk.utils.IntList;

/**
 * @since 6.0
 */
public class SimpleJSDocParser {

	private static final char FORM_FEED = '\u000c';
	private static final char CR = '\r';
	private static final char LF = '\n';
	private static final char TAB = '\t';
	private static final char SPACE = ' ';

	private char buffer[];
	private int index;
	private int end;
	private final StringBuilder value = new StringBuilder();
	private final IntList ranges = new IntList();

	public JSDocTags parse(String content, int offset) {
		List<JSDocTag> tags = null;
		index = MultiLineComment.JSDOC_PREFIX.length();
		buffer = content.toCharArray();
		end = buffer.length;
		if (index + 2 <= end && buffer[end - 2] == '*'
				&& buffer[end - 1] == '/') {
			end -= 2;
		}
		while (index < end) {
			switch (readChar()) {
			case '*':
			case SPACE:
			case TAB:
			case FORM_FEED:
				continue;
			case LF:
				skipChar(CR);
				continue;
			case CR:
				skipChar(LF);
				continue;
			case '@':
				final JSDocTag tag = parseTag(offset);
				if (tag != null) {
					if (tags == null) {
						tags = new ArrayList<JSDocTag>();
					}
					tags.add(tag);
				} else {
					skipEndOfLine();
				}
				break;
			default:
				skipEndOfLine();
				continue;
			}
		}
		if (tags != null) {
			return new JSDocTags(tags.toArray(new JSDocTag[tags.size()]));
		} else {
			return JSDocTags.EMPTY;
		}
	}

	private JSDocTag parseTag(int offset) {
		final int tagStart = index - 1;
		if (index < end && Character.isLetter(buffer[index])) {
			++index;
			while (index < end
					&& (buffer[index] == '.' || buffer[index] == '-' || Character
							.isLetterOrDigit(buffer[index]))) {
				++index;
			}
		}
		if (index == tagStart + 1) {
			return null;
		}
		final String tag = new String(buffer, tagStart, index - tagStart);
		final int nameEnd = index;
		value.setLength(0);
		ranges.clear();
		skipSpaces();
		boolean lineStart = false;
		VALUE_LOOP: while (index < end) {
			char c = readChar();
			switch (c) {
			case '@':
				if (lineStart) {
					unread();
					break VALUE_LOOP;
				}
				value.append(c);
				addToRanges(index);
				break;
			case CR:
				skipChar(LF);
				lineStart = true;
				skipSpaces();
				if (skipAll('*') && skipChar('/')) {
					// end of comment
					break VALUE_LOOP;
				}
				break;
			case LF:
				skipChar(CR);
				lineStart = true;
				skipSpaces();
				if (skipAll('*') && skipChar('/')) {
					// end of comment
					break VALUE_LOOP;
				}
				break;
			case SPACE:
			case TAB:
			case FORM_FEED:
				value.append(c);
				addToRanges(index);
				break;
			default:
				lineStart = false;
				value.append(c);
				addToRanges(index);
				break;
			}
		}
		int len = value.length();
		while (len > 0 && Character.isWhitespace(value.charAt(len - 1))) {
			--len;
		}
		if (len != value.length()) {
			trimRangesBy(value.length() - len);
			value.setLength(len);
		}
		final int valueStart;
		final int end;
		final String value;
		final int[] ranges;
		if (this.ranges.isEmpty()) {
			valueStart = nameEnd;
			end = nameEnd;
			value = "";
			ranges = null;
		} else {
			valueStart = this.ranges.first();
			end = this.ranges.last();
			value = this.value.toString();
			if (end - valueStart == value.length()) {
				ranges = null;
			} else {
				ranges = this.ranges.toArray();
				for (int i = 0; i < ranges.length; ++i) {
					ranges[i] += offset;
				}
			}
		}
		return new JSDocTag(tag, value, offset + tagStart, offset + valueStart,
				offset + end, ranges);
	}

	private void trimRangesBy(int delta) {
		if (!ranges.isEmpty()) {
			int endIndex = ranges.size();
			while (endIndex > 0) {
				int rangeLen = ranges.get(endIndex - 1)
						- ranges.get(endIndex - 2);
				if (rangeLen <= delta) {
					delta -= rangeLen;
					endIndex -= 2;
				} else {
					ranges.set(endIndex - 1, ranges.get(endIndex - 1) - delta);
					break;
				}
			}
			if (endIndex != ranges.size()) {
				ranges.setSize(endIndex);
			}
		}
	}

	private void addToRanges(int offset) {
		if (ranges.isEmpty() || ranges.last() != offset - 1) {
			ranges.add(offset - 1);
			ranges.add(offset);
		} else {
			ranges.set(ranges.size() - 1, offset);
		}
	}

	private boolean skipAll(char expected) {
		boolean result = false;
		while (index < end && buffer[index] == expected) {
			++index;
			result = true;
		}
		return result;
	}

	private void skipSpaces() {
		while (index < end && (buffer[index] == ' ' || buffer[index] == '\t')) {
			++index;
		}
	}

	private void skipEndOfLine() {
		LOOP: while (index < end) {
			switch (readChar()) {
			case CR:
				skipChar(LF);
				break LOOP;
			case LF:
				skipChar(CR);
				break LOOP;
			}
		}
	}

	private boolean skipChar(char expected) {
		if (index < end && buffer[index] == expected) {
			++index;
			return true;
		}
		return false;
	}

	private void unread() {
		--index;
	}

	private char readChar() {
		return buffer[index++];
	}

}
