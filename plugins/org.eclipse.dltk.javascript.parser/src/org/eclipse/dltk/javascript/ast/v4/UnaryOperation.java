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

public class UnaryOperation extends org.eclipse.dltk.javascript.ast.UnaryOperation {

	private boolean isPostfix;
	
	public UnaryOperation(JSNode parent, boolean isPostfix) {
		super(parent);
		this.isPostfix = isPostfix;
	}

	public String getOperationText() {
		return Keywords.fromToken(operation);
	}

	public boolean isPostfix() {
		return isPostfix;
	}

	public boolean isTextOperator() {
		return operation == JSParser.Delete || operation == JSParser.Typeof
				|| operation == JSParser.Void;
	}

	@Override
	public boolean isIncDec() {
		return operation == JSParser.PlusPlus || operation == JSParser.MinusMinus;
	}

	@Override
	public boolean isNotOperator() {
		return operation == JSParser.Not;
	}

	@Override
	public boolean isDelete() {
		return operation == JSParser.Delete;
	}

	@Override
	public boolean isTypeOf() {
		return operation == JSParser.Typeof;
	}

	@Override
	public boolean isVoid() {
		return operation == JSParser.Void;
	}
}
