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

import java.util.ArrayList;
import java.util.List;

public class CompletionPath {

	public static enum SegmentType {
		SIMPLE, ARRAY, FUNCTION, OBJECT
	}

	private static class Segment {
		final String name;
		final SegmentType type;

		public Segment(String name, SegmentType type) {
			this.name = name;
			this.type = type;
		}

		public String toString() {
			return "Segment[type:" + type.toString() + ",name:" + name + "]";
		}
	}

	private final Segment[] segments;

	public CompletionPath(String path) {
		final String parsed = CompletionString.parse(path, true, true);
		final List<Segment> s = new ArrayList<Segment>();
		final String[] tokens = parsed.split("\\.|\\?\\.", -1);
		for (String token : tokens) {
			SegmentType type = SegmentType.SIMPLE;
			if (token.equals("[]")) {
				token = null;
				type = SegmentType.ARRAY;
			} else if (token.equals("()")) {
				token = null;
				type = SegmentType.FUNCTION;
			} else if (token.equals("{}")) {
				token = null;
				type = SegmentType.OBJECT;
			}
			s.add(new Segment(token, type));
		}
		this.segments = s.toArray(new Segment[s.size()]);
	}

	public boolean isEmpty() {
		return segments.length == 0;
	}

	public int segmentCount() {
		return segments.length;
	}

	public SegmentType segmentType(int index) {
		return segments[index].type;
	}

	public String segment(int index) {
		return segments[index].name;
	}

	public boolean isName(int index) {
		return segments[index].type == SegmentType.SIMPLE;
	}

	public boolean isArray(int index) {
		return segments[index].type == SegmentType.ARRAY;
	}

	public boolean isFunction(int index) {
		return segments[index].type == SegmentType.FUNCTION;
	}

	public boolean isObject(int index) {
		return segments[index].type == SegmentType.OBJECT;
	}

	public String lastSegment() {
		return !isEmpty() ? segments[segments.length - 1].name : null;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for (Segment segment : segments) {
			if (sb.length() != 0) {
				sb.append('.');
			}
			if (segment.type == SegmentType.FUNCTION) {
				sb.append("()");
			} else if (segment.type == SegmentType.ARRAY) {
				sb.append("[]");
			} else {
				sb.append(segment.name);
			}
		}
		return sb.toString();
	}
}
