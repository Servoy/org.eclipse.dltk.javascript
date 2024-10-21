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
import org.eclipse.dltk.javascript.internal.parser.JSLiterals;

public class DefaultXmlNamespaceStatement extends Statement implements ISemicolonStatement {

	private Keyword defaultKeyword;
	private Keyword xmlKeyword;
	private Keyword namespaceKeyword;
	private int assignOperation = -1;
	private Expression value;
	private int semic = -1;

	public DefaultXmlNamespaceStatement(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (defaultKeyword != null)
				defaultKeyword.traverse(visitor);
			if (xmlKeyword != null)
				xmlKeyword.traverse(visitor);
			if (namespaceKeyword != null)
				namespaceKeyword.traverse(visitor);
			if (value != null)
				value.traverse(visitor);

			visitor.endvisit(this);
		}
	}

	public Keyword getDefaultKeyword() {
		return this.defaultKeyword;
	}

	public void setDefaultKeyword(Keyword keyword) {
		this.defaultKeyword = keyword;
	}

	public Keyword getXmlKeyword() {
		return this.xmlKeyword;
	}

	public void setXmlKeyword(Keyword keyword) {
		this.xmlKeyword = keyword;
	}

	public Keyword getNamespaceKeyword() {
		return this.namespaceKeyword;
	}

	public void setNamespaceKeyword(Keyword keyword) {
		this.namespaceKeyword = keyword;
	}

	public int getAssignOperation() {
		return this.assignOperation;
	}

	public void setAssignOperation(int operation) {
		this.assignOperation = operation;
	}

	public Expression getValue() {
		return this.value;
	}

	public void setValue(Expression value) {
		this.value = value;
	}

	public int getSemicolonPosition() {
		return this.semic;
	}

	public void setSemicolonPosition(int semic) {
		this.semic = semic;
	}

	@Override
	public String toSourceString(String indentationString) {

		Assert.isNotNull(defaultKeyword);
		Assert.isNotNull(xmlKeyword);
		Assert.isNotNull(namespaceKeyword);
		Assert.isNotNull(value);
		Assert.isTrue(assignOperation > 0);

		StringBuffer buffer = new StringBuffer();

		buffer.append(indentationString);
		buffer.append(Keywords.DEFAULT);
		buffer.append(" ");
		buffer.append(Keywords.XML);
		buffer.append(" ");
		buffer.append(Keywords.NAMESPACE);
		buffer.append(" = ");
		buffer.append(this.value.toSourceString(JSLiterals.EMPTY));
		if (semic > 0)
			buffer.append(";");

		return buffer.toString();
	}

}
