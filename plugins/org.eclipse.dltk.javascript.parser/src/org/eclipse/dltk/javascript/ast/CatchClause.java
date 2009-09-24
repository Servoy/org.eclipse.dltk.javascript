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
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;

public class CatchClause extends Statement {

	private Keyword catchKeyword;
	private Identifier exception;
	private ExceptionFilter exceptionFilter = null;
	private Statement statement;
	private int LP = -1;
	private int RP = -1;

	public CatchClause(ASTNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (catchKeyword != null)
				catchKeyword.traverse(visitor);
			if (exception != null)
				exception.traverse(visitor);
			if (exceptionFilter != null)
				exceptionFilter.traverse(visitor);
			if (statement != null)
				statement.traverse(visitor);

			visitor.endvisit(this);
		}
	}

	public Identifier getException() {
		return this.exception;
	}

	public void setException(Identifier exception) {
		this.exception = exception;
	}

	public ExceptionFilter getExceptionFilter() {
		return this.exceptionFilter;
	}

	public void setExceptionFilter(ExceptionFilter filter) {
		this.exceptionFilter = filter;
	}

	public Statement getStatement() {
		return this.statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public Keyword getCatchKeyword() {
		return this.catchKeyword;
	}

	public void setCatchKeyword(Keyword keyword) {
		this.catchKeyword = keyword;
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

	public String toSourceString(String indentationString) {

		Assert.isTrue(sourceStart() > 0);
		Assert.isTrue(sourceEnd() > 0);
		Assert.isTrue(LP > 0);
		Assert.isTrue(RP > 0);

		StringBuffer buffer = new StringBuffer();

		buffer.append(indentationString);
		buffer.append(Keywords.CATCH);
		buffer.append(" (");
		buffer.append(this.exception.toSourceString(indentationString));
		if (this.exceptionFilter != null) {
			buffer.append(' ');
			buffer.append(exceptionFilter.toSourceString(indentationString));
		}
		buffer.append(")\n");

		buffer.append(statement.toSourceString(indentationString));

		return buffer.toString();
	}

}
