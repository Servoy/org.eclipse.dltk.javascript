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

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.utils.IntList;

public class CallExpression extends Expression implements IsOptionalChain{

	private Expression expression;
	private final List<ASTNode> arguments = new ArrayList<ASTNode>();
	private IntList commas;
	private int LP = -1;
	private int RP = -1;
	private int optionalChain = -1;

	public CallExpression(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (expression != null)
				expression.traverse(visitor);

			if (arguments != null) {
				for (ASTNode node : arguments) {
					node.traverse(visitor);
				}
			}
			visitor.endvisit(this);
		}
	}

	public Expression getExpression() {
		return this.expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public List<ASTNode> getArguments() {
		return this.arguments;
	}

	public void addArgument(ASTNode argument) {
		this.arguments.add(argument);
	}

	public int getLP() {
		return this.LP;
	}

	public void setLP(int LP) {
		this.LP = LP;
	}

	public int getRP() {
		return this.RP;
	}

	public void setRP(int RP) {
		this.RP = RP;
	}

	public IntList getCommas() {
		return this.commas;
	}

	public void setCommas(IntList commas) {
		this.commas = commas;
	}

	@Override
	public String toSourceString(String indentationString) {

		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);
		Assert.isTrue(LP > 0);
		Assert.isTrue(RP > 0);
		Assert.isTrue(arguments.size() == 0
				|| commas.size() == arguments.size() - 1);

		StringBuffer buffer = new StringBuffer();

		buffer.append(((ISourceable) expression)
				.toSourceString(indentationString));

		if (optionalChain > 0) {
			buffer.append("?.");
		}
		buffer.append('(');

		for (int i = 0; i < arguments.size(); i++) {
			if (i > 0)
				buffer.append(", ");

			ISourceable item = (ISourceable) arguments.get(i);
			buffer.append(item.toSourceString(indentationString));
		}

		buffer.append(')');

		return buffer.toString();
	}

	@Override
	public void setOptionalChain(int optionalChainPos) {
		this.optionalChain = optionalChainPos;		
	}

	@Override
	public int getOptionalChain() {
		return optionalChain;
	}
}
