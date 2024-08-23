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
import org.eclipse.dltk.javascript.internal.parser.JSLiterals;

/**
 * Same as the VariableStatement, this class extends expression only to allow usage as initial expression in
 * "for(;;)" loop statement.
 */
public class ConstStatement extends Expression implements IVariableStatement, Documentable {

	private Keyword constKeyword;
	private final List<VariableDeclaration> consts = new ArrayList<VariableDeclaration>();
	private Comment documentation;

	public ConstStatement(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (constKeyword != null)
				constKeyword.traverse(visitor);

			for (ASTNode constNode : consts) {
				constNode.traverse(visitor);
			}

			visitor.endvisit(this);
		}
	}

	public List<VariableDeclaration> getVariables() {
		return this.consts;
	}

	public void addVariable(VariableDeclaration declaration) {
		consts.add(declaration);
	}

	public Keyword getConstKeyword() {
		return this.constKeyword;
	}

	public void setConstKeyword(Keyword keyword) {
		this.constKeyword = keyword;
	}

	@Override
	public String toSourceString(String indentationString) {
		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);

		StringBuffer buffer = new StringBuffer();

		buffer.append(indentationString);
		buffer.append(Keywords.CONST);
		buffer.append(JSLiterals.SPACE);

		for (int i = 0; i < consts.size(); i++) {
			if (i > 0)
				buffer.append(", ");
			buffer.append(consts.get(i).toSourceString(indentationString));
		}

		return buffer.toString();
	}

	@Override
	public Comment getDocumentation() {
		return documentation;
	}

	public void setDocumentation(Comment documentation) {
		this.documentation = documentation;
	}

}
