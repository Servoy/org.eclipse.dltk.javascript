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

import org.eclipse.dltk.ast.ASTVisitor;

public class PropertyExpression extends Expression implements Documentable, IsOptionalChain {

	private Expression object;
	private Expression property;
	private int dot = -1;
	private Comment documentation;
	private int optionalChain;

	public PropertyExpression(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (object != null)
				object.traverse(visitor);
			if (property != null)
				property.traverse(visitor);
			visitor.endvisit(this);
		}
	}

	public Expression getObject() {
		return this.object;
	}

	public void setObject(Expression object) {
		this.object = object;
	}

	public Expression getProperty() {
		return this.property;
	}

	public void setProperty(Expression property) {
		this.property = property;
	}

	public int getDotPosition() {
		return this.dot;
	}

	public void setDotPosition(int dot) {
		this.dot = dot;
	}

	public void setDocumentation(Comment documentation) {
		this.documentation = documentation;
	}

	@Override
	public Comment getDocumentation() {
		return documentation;
	}

	@Override
	public String toSourceString(String indentationString) {
		return toSourceString(object, indentationString) + (optionalChain > 0 ? "?." : '.')
				+ toSourceString(property, indentationString);
	}

	public List<Expression> getPath() {
		final List<Expression> path = new ArrayList<Expression>();
		addToPath(object, path);
		path.add(property);
		return path;
	}

	private static void addToPath(Expression object, List<Expression> path) {
		if (object instanceof PropertyExpression) {
			final PropertyExpression pe = (PropertyExpression) object;
			addToPath(pe.object, path);
			path.add(pe.property);
		} else {
			path.add(object);
		}
	}

	@Override
	public void setOptionalChain(int optionalChain) {
		this.optionalChain = optionalChain;
	}
	
	@Override
	public int getOptionalChain() {
		return optionalChain;
	}
}
