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

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTVisitor;

public abstract class UnaryOperation extends Expression {

	private Expression expression;
	protected int operation = -1;
	private int operationPos = -1;

	public UnaryOperation(JSNode parent) {
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
			visitor.endvisit(this);
		}
	}

	public Expression getExpression() {
		return this.expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public int getOperation() {
		return this.operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public int getOperationPosition() {
		return this.operationPos;
	}

	public void setOperationPosition(int operationPos) {
		this.operationPos = operationPos;
	}

	public abstract String getOperationText();

	public abstract boolean isPostfix();

	public abstract boolean isTextOperator();

	@Override
	public String toSourceString(String indentationString) {

		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);
		Assert.isTrue(operationPos > 0);
		Assert.isTrue(operation > 0);

		final StringBuilder buffer = new StringBuilder();

		if (!isPostfix()) {
			buffer.append(getOperationText());
			if (isTextOperator()) {
				buffer.append(" ");
			}
		}

		buffer.append(expression.toSourceString(indentationString));

		if (isPostfix()) {
			buffer.append(getOperationText());
		}

		return buffer.toString();
	}

	public abstract boolean isIncDec();

	public abstract boolean isNotOperator();

	public abstract boolean isDelete();

	public abstract boolean isTypeOf();

	public abstract boolean isVoid(); 

}
