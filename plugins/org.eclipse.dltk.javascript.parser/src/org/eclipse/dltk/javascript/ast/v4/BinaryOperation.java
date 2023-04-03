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

import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.parser.v4.JSParser;

public class BinaryOperation extends org.eclipse.dltk.javascript.ast.BinaryOperation {

	public BinaryOperation(JSNode parent) {
		super(parent);
	}

	@Override
	public String getOperationText() {
		return Keywords.fromToken(this.operation);
	}

	@Override
	public boolean isAssignment() {
		return operation == JSParser.Assign || operation == JSParser.PlusAssign
				|| operation == JSParser.MinusAssign || operation == JSParser.MultiplyAssign
				|| operation == JSParser.DivideAssign || operation == JSParser.ModulusAssign
				|| operation == JSParser.BitAndAssign || operation == JSParser.BitOrAssign
				|| operation == JSParser.BitXorAssign || operation == JSParser.LeftShiftArithmeticAssign
				|| operation == JSParser.RightShiftArithmeticAssign || operation == JSParser.RightShiftLogicalAssign;
	}

	@Override
	public boolean isAssignOperator() {
		return operation == JSParser.Assign;
	}

	@Override
	public boolean isLogicalAnd() {
		return operation == JSParser.And;
	}

	@Override
	public boolean returnsBoolean() {
		return operation == JSParser.MoreThan || operation == JSParser.GreaterThanEquals || operation == JSParser.LessThan
				|| operation == JSParser.LessThanEquals || operation == JSParser.IdentityNotEquals
				|| operation == JSParser.IdentityEquals || operation == JSParser.NotEquals
				|| operation == JSParser.Equals_ || JSParser.Instanceof == operation;
	}

	@Override
	public boolean isAddition() {
		return operation == JSParser.Plus;
	}

	@Override
	public boolean isLogicalOr() {
		return JSParser.Or == operation;
	}

	@Override
	public boolean isInstanceof() {
		return operation == JSParser.Instanceof;
	}
}
