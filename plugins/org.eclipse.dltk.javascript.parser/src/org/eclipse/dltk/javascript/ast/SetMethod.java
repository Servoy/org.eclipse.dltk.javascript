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

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.dltk.ast.ASTVisitor;

public class SetMethod extends Method {

	private Keyword setKeyword;
	private List<Argument> arguments;
	
	public SetMethod(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (setKeyword != null)
				setKeyword.traverse(visitor);
			if (getName() != null)
				getName().traverse(visitor);
			if (getArgument() != null)
				getArgument().traverse(visitor);
			if (getBody() != null)
				getBody().traverse(visitor);
			visitor.endvisit(this);
		}
	}

	public Identifier getArgument() {
		return this.arguments != null && !this.arguments.isEmpty() ? this.arguments.get(0).getIdentifier() : null;
	}

	public void setArgument(Identifier argument) {
		Argument a = new Argument(this);
		a.setIdentifier(argument);
		if (this.arguments == null) {
			this.arguments = List.of(a);
		} else if (this.arguments.isEmpty()) {
			this.arguments.add(a);
		} else {
			this.arguments.set(0, a);
		}
	}

	public void setArguments(List<Argument> arguments) {
		this.arguments = arguments;		
	}

	public List<Argument> getArguments() {
		return this.arguments;
	}
	
	public Keyword getSetKeyword() {
		return this.setKeyword;
	}

	public void setSetKeyword(Keyword keyword) {
		this.setKeyword = keyword;
	}

	@Override
	public String toSourceString(String indentationString) {
		final StringBuilder buffer = new StringBuilder();

		buffer.append(Keywords.SET);
		buffer.append(" ");
		buffer.append(toSourceString(getName(), indentationString));
		buffer.append(" (");
		String joined = arguments.stream()
		        .map(argument -> toSourceString(argument, indentationString))
		        .collect(Collectors.joining(", "));
		buffer.append(joined);
		buffer.append(")\n");
		buffer.append(toSourceString(getBody(), indentationString));

		return buffer.toString();
	}

}
