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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;

public class StatementBlock extends Statement implements ISourceableBlock, JSScope {

	private final List<Statement> statements = new ArrayList<Statement>();
	private int LC = -1;
	private int RC = -1;
	private List<JSDeclaration> declarations;

	public StatementBlock(JSNode parent) {
		super(parent);
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			Iterator<Statement> it = statements.iterator();
			while (it.hasNext()) {
				Statement node = it.next();
				node.traverse(visitor);
			}
			visitor.endvisit(this);
		}
	}

	public List<Statement> getStatements() {
		return this.statements;
	}

	public int getLC() {
		return this.LC;
	}

	public void setLC(int LC) {
		this.LC = LC;
	}

	public int getRC() {
		return this.RC;
	}

	public void setRC(int RC) {
		this.RC = RC;
	}

	@Override
	public String toSourceString(String indentationString) {
		final StringBuilder buffer = new StringBuilder();

		buffer.append(indentationString);
		buffer.append("{\n");

		for (int i = 0; i < statements.size(); i++) {
			buffer.append(toSourceString(statements.get(i),
					indentationString + INDENT));
		}

		buffer.append(indentationString);
		buffer.append("}\n");

		return buffer.toString();
	}

	public boolean isBlock() {
		return true;
	}

	@Override
	public void addDeclaration(JSDeclaration declaration) {
		if (declarations == null) {
			declarations = new ArrayList<JSDeclaration>();
		}
		declarations.add(declaration);
	}

	public List<JSDeclaration> getDeclarations() {
		return declarations != null ? declarations : Collections
				.<JSDeclaration> emptyList();
	}
}
