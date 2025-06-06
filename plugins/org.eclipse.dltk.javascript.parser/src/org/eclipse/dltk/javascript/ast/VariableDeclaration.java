/*******************************************************************************
 * Copyright (c) 2010 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.ast;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.internal.parser.JSLiterals;

public class VariableDeclaration extends VariableBinding implements ISourceable {

	private Identifier identifier;
	
	// TODO (alex) remove unused field in DLTK 6.0
	@Deprecated
	private int colonPosition = -1;

	/**
	 * @param parent
	 */
	public VariableDeclaration(IVariableStatement parent) {
		super((JSNode) parent);
	}

	@Override
	public String toSourceString(String indentationString) {
		final StringBuilder sb = new StringBuilder();
		if (identifier != null) {
			sb.append(identifier.getName());
		} else {
			sb.append(JSLiterals.ERROR_TOKEN);
		}
		if (initializer != null) {
			sb.append(JSLiterals.ASSIGN);
			sb.append(initializer.toSourceString(indentationString));
		}
		return sb.toString();
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (identifier != null) {
				identifier.traverse(visitor);
			}
			if (initializer != null) {
				initializer.traverse(visitor);
			}
			visitor.endvisit(this);
		}
	}

	@Deprecated
	public int getColonPosition() {
		return colonPosition;
	}

	@Deprecated
	public void setColonPosition(int colonPosition) {
		this.colonPosition = colonPosition;
	}

	public String getVariableName() {
		return identifier != null ? identifier.getName() : null;
	}

	public Identifier getIdentifier() {

		return identifier;
	}

	public void setIdentifier(Identifier name) {
		this.identifier = name;
	}

	@Override
	public Comment getDocumentation() {
		return identifier != null ? identifier.getDocumentation() : null;
	}

	@Override
	public List<Identifier> getIdentifiers() {
		return identifier != null ? List.of(identifier) : List.of();
	}

	@Override
	public List<String> getVariableNames() {
		return List.of(getVariableName() != null ? getVariableName() : JSLiterals.ERROR_TOKEN);
	}

	@Override
	public Expression getInitializer(String name) {
		return initializer;
	}
}
