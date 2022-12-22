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
package org.eclipse.dltk.javascript.ast.v4;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.parser.v4.JSParser;

public class BinaryOperation extends Expression {

	private int operation = -1;
	private Expression left;
	private Expression right;
	private int operationPos = -1;

	public BinaryOperation(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (left != null)
				left.traverse(visitor);
			if (right != null)
				right.traverse(visitor);
			visitor.endvisit(this);
		}
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

	public String getOperationText() {
		return Keywords.fromToken(this.operation);
	}

	public Expression getLeftExpression() {
		return this.left;
	}

	public void setLeftExpression(Expression left) {
		this.left = left;
	}

	public Expression getRightExpression() {
		return this.right;
	}

	public void setRightExpression(Expression right) {
		this.right = right;
	}

	@Override
	public Comment getDocumentation() {
		Comment comment = null;
		if (left != null) {
			comment = left.getDocumentation();
			if (comment != null) {
				return comment;
			}
		}
		if (right != null) {
			comment = right.getDocumentation();
			if (comment != null) {
				return comment;
			}
		}
		return super.getDocumentation();
	}

	@Override
	public String toSourceString(String indentionString) {

		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);
		Assert.isTrue(operationPos > 0);

		StringBuffer buffer = new StringBuffer();

		buffer.append(left.toSourceString(indentionString));
		buffer.append(' ');
		buffer.append(getOperationText());
		buffer.append(' ');
		buffer.append(right.toSourceString(indentionString));

		return buffer.toString();
	}

	public boolean isAssignment() {
		return operation == JSParser.Assign || operation == JSParser.PlusAssign
				|| operation == JSParser.MinusAssign || operation == JSParser.MultiplyAssign
				|| operation == JSParser.DivideAssign || operation == JSParser.ModulusAssign
				|| operation == JSParser.BitAndAssign || operation == JSParser.BitOrAssign
				|| operation == JSParser.BitXorAssign || operation == JSParser.LeftShiftArithmeticAssign
				|| operation == JSParser.RightShiftArithmeticAssign || operation == JSParser.RightShiftLogicalAssign;
	}

	public boolean isAssignmentTo(Expression expression) {
		return expression == left && isAssignment();
	}
}
