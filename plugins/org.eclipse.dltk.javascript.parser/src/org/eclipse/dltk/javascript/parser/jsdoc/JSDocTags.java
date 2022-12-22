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
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.dltk.utils.ArrayIterator;

/**
 * @since 6.0
 */
public class JSDocTags implements Iterable<JSDocTag> {

	public static final JSDocTags EMPTY = new JSDocTags(new JSDocTag[0]);

	private final JSDocTag[] tags;

	public JSDocTags(JSDocTag[] tags) {
		this.tags = tags;
	}

	/**
	 * Returns all the jsdoc tags.
	 * 
	 * @param tagName
	 * @return
	 */
	public List<JSDocTag> list() {
		return Arrays.asList(tags);
	}

	/**
	 * Return 1st tag with the specified name or <code>null</code>
	 * 
	 * @param tagName
	 * @return
	 */
	public JSDocTag get(String tagName) {
		for (JSDocTag tag : tags) {
			if (tagName.equals(tag.name())) {
				return tag;
			}
		}
		return null;
	}

	/**
	 * Return 1st tag with one of the specified names or <code>null</code>
	 * 
	 * @param tagName
	 * @return
	 */
	public JSDocTag get(String[] tagNames) {
		for (JSDocTag tag : tags) {
			for (String tagName : tagNames) {
				if (tagName.equals(tag.name())) {
					return tag;
				}
			}
		}
		return null;
	}

	/**
	 * Returns all tags with the specified name. If there are no matching tags
	 * the empty list is returned.
	 * 
	 * @param tagName
	 * @return
	 */
	public List<JSDocTag> list(String tagName) {
		List<JSDocTag> result = null;
		for (JSDocTag tag : tags) {
			if (tagName.equals(tag.name())) {
				if (result == null) {
					result = new ArrayList<JSDocTag>();
				}
				result.add(tag);
			}
		}
		return result != null ? result : Collections.<JSDocTag> emptyList();
	}

	/**
	 * Returns all tags with the specified names. If there are no matching tags
	 * the empty list is returned.
	 * 
	 * @param tagNames
	 * @return
	 */
	public List<JSDocTag> list(String[] tagNames) {
		List<JSDocTag> result = null;
		for (JSDocTag tag : tags) {
			for (String tagName : tagNames) {
				if (tagName.equals(tag.name())) {
					if (result == null) {
						result = new ArrayList<JSDocTag>();
					}
					result.add(tag);
					break;
				}
			}
		}
		return result != null ? result : Collections.<JSDocTag> emptyList();
	}

	public int size() {
		return tags.length;
	}

	public boolean isEmpty() {
		return tags.length == 0;
	}

	public JSDocTag get(int index) {
		return tags[index];
	}

	/**
	 * Returns the number of tags with the specified name.
	 * 
	 * @param tagName
	 * @return
	 */
	public int count(String tagName) {
		int result = 0;
		for (JSDocTag tag : tags) {
			if (tagName.equals(tag.name())) {
				++result;
			}
		}
		return result;
	}

	/**
	 * Returns the number of the tags with the specified names.
	 * 
	 * @param tagName
	 * @return
	 */
	public int count(String[] tagNames) {
		int result = 0;
		for (JSDocTag tag : tags) {
			for (String tagName : tagNames) {
				if (tagName.equals(tag.name())) {
					++result;
					break;
				}
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		boolean first = true;
		for (JSDocTag tag : tags) {
			if (!first) {
				sb.append(",\n ");
			} else {
				first = false;
			}
			sb.append(tag);
		}
		sb.append(']');
		return sb.toString();
	}

	public Iterator<JSDocTag> iterator() {
		return new ArrayIterator<JSDocTag>(tags);
	}

	public JSDocTag getTagAt(int offset) {
		for (JSDocTag tag : tags) {
			if (tag.start() <= offset && tag.end() >= offset) {
				return tag;
			}
		}
		return null;
	}

}
