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
 * This class extends expression only to allow usage as initial expression in
 * "for(;;)" loop statement. It should be solved differently.
 */
public class VariableStatement extends Expression implements
		IVariableStatement, Documentable {

	private Keyword varKeyword;
	private final List<VariableBinding> variables = new ArrayList<VariableBinding>();
	private Comment documentation;

	public VariableStatement(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (varKeyword != null) {
				varKeyword.traverse(visitor);
			}
			for (ASTNode node : variables) {
				node.traverse(visitor);
			}
			visitor.endvisit(this);
		}
	}

	public List<VariableBinding> getBindings() {
		return this.variables;
	}

	public void addBinding(VariableBinding declaration) {
		this.variables.add(declaration);
	}

	public Keyword getVarKeyword() {
		return this.varKeyword;
	}

	public void setVarKeyword(Keyword keyword) {
		this.varKeyword = keyword;
	}

	@Override
	public String toSourceString(String indentationString) {

		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);

		StringBuffer buffer = new StringBuffer();

		buffer.append(Keywords.VAR);
		buffer.append(JSLiterals.SPACE);

		for (int i = 0; i < variables.size(); i++) {
			if (i > 0)
				buffer.append(", ");

			buffer.append(variables.get(i).toSourceString(indentationString));
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
