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

package org.eclipse.dltk.javascript.ast.rhino;

import org.eclipse.dltk.javascript.ast.JSNode;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;

public class UnaryOperation extends org.eclipse.dltk.javascript.ast.UnaryOperation {

	private boolean isPostfix;
	
	public UnaryOperation(JSNode parent, boolean isPostfix) {
		super(parent);
		this.isPostfix = isPostfix;
	}

	public String getOperationText() {
		return AstNode.operatorToString(operation);
	}

	public boolean isPostfix() {
		return isPostfix;
	}

	public boolean isTextOperator() {
		return operation == Token.DELPROP || operation == Token.TYPEOF
				|| operation == Token.VOID;
	}

	@Override
	public boolean isIncDec() {
		return operation == Token.INC || operation == Token.DEC;
	}

	@Override
	public boolean isNotOperator() {
		return operation == Token.NOT || operation == Token.BITNOT;
	}

	@Override
	public boolean isDelete() {
		return operation == Token.DELPROP;
	}

	@Override
	public boolean isTypeOf() {
		return operation == Token.TYPEOF;
	}

	@Override
	public boolean isVoid() {
		return operation == Token.VOID;
	}
}
