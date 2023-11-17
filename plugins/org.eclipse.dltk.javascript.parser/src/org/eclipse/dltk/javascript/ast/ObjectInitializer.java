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

package org.eclipse.dltk.javascript.ast;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.ast.v4.PropertyShorthand;
import org.eclipse.dltk.utils.IntList;

public class ObjectInitializer extends Expression {

	private final List<ObjectInitializerPart> initializers = new ArrayList<ObjectInitializerPart>();
	private int LC = -1;
	private int RC = -1;
	private IntList commas;
	private boolean multiline;

	public ObjectInitializer(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (initializers != null) {
				for (ASTNode node : initializers) {
					node.traverse(visitor);
				}
			}
			visitor.endvisit(this);
		}
	}

	public List<ObjectInitializerPart> getInitializers() {
		return this.initializers;
	}

	public void addInitializer(ObjectInitializerPart initializer) {
		this.initializers.add(initializer);
	}

	public PropertyInitializer[] getPropertyInitializers() {
		List<PropertyInitializer> result = new ArrayList<PropertyInitializer>();
		for (ObjectInitializerPart part : initializers) {
			if (part instanceof PropertyInitializer) {
				result.add((PropertyInitializer) part);
			}
		}
		return result.toArray(new PropertyInitializer[result.size()]);
	}

	public Expression getValue(String propertyName) {
		final ObjectInitializerPart property = getEntry(propertyName);
		if (property instanceof PropertyInitializer) {
			return ((PropertyInitializer) property).getValue();
		}
		if (property instanceof PropertyShorthand) {
			return ((PropertyShorthand) property).getExpression();
		}
		return null;
	}

	public ObjectInitializerPart getEntry(String propertyName) {
		for (ObjectInitializerPart part : initializers) {
			if (part instanceof PropertyInitializer) {
				final PropertyInitializer property = (PropertyInitializer) part;
				if (propertyName.equals(property.getNameAsString())) {
					return property;
				}
			}
			if (part instanceof PropertyShorthand) {
				final PropertyShorthand property = (PropertyShorthand) part;
				if (propertyName.equals(property.getNameAsString())) {
					return property;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the offset of the opening left curly brace. It should be the same
	 * as {@link #sourceStart()}.
	 */
	public int getLC() {
		return this.LC;
	}

	public void setLC(int LC) {
		this.LC = LC;
	}

	/**
	 * Returns the offset of the closing right curly brace. It should be 1 less
	 * than {@link #sourceEnd()}.
	 */
	public int getRC() {
		return this.RC;
	}

	public void setRC(int RC) {
		this.RC = RC;
	}

	public IntList getCommas() {
		return this.commas;
	}

	public void setCommas(IntList commas) {
		this.commas = commas;
	}

	public boolean isMultiline() {
		return this.multiline;
	}

	public void setMultiline(boolean multiline) {
		this.multiline = multiline;
	}

	@Override
	public String toSourceString(String indentationString) {
		final StringBuilder buffer = new StringBuilder();

		buffer.append("{");
		for (int i = 0; i < initializers.size(); i++) {
			if (i > 0)
				buffer.append(", ");

			buffer.append(toSourceString((ISourceable) initializers.get(i),
					indentationString));
		}
		buffer.append("}");

		return buffer.toString();
	}

}
