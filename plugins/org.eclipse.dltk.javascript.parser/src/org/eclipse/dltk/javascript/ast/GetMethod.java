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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;

public class GetMethod extends Method {

	private Keyword getKeyword;

	public GetMethod(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (getKeyword != null)
				getKeyword.traverse(visitor);
			if (getName() != null)
				getName().traverse(visitor);
			if (getBody() != null)
				getBody().traverse(visitor);
			visitor.endvisit(this);
		}
	}

	public Keyword getGetKeyword() {
		return this.getKeyword;
	}

	public void setGetKeyword(Keyword keyword) {
		this.getKeyword = keyword;
	}

	@Override
	public String toSourceString(String indentationString) {
		final StringBuilder buffer = new StringBuilder();

		buffer.append(Keywords.GET);
		buffer.append(" ");
		buffer.append(toSourceString(getName(), indentationString));
		buffer.append(" ()");
		buffer.append(toSourceString(getBody(), indentationString));

		return buffer.toString();
	}
	
	@Override
	public List<Argument> getArguments() {
		return Collections.emptyList();
	}

}
