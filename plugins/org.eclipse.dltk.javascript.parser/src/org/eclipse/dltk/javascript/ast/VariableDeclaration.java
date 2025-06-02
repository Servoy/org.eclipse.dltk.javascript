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

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.internal.parser.JSLiterals;

public class VariableDeclaration extends JSNode implements ISourceable,
		JSDeclaration {

	private Identifier identifier;
	private Expression target;
	
	// TODO (alex) remove unused field in DLTK 6.0
	@Deprecated
	private int colonPosition = -1;
	private int assignPosition = -1;
	private Expression initializer;
	private int commaPosition = -1;

	/**
	 * @param parent
	 */
	public VariableDeclaration(IVariableStatement parent) {
		super((JSNode) parent);
	}

	@Override
	public String toSourceString(String indentationString) {
		final StringBuilder sb = new StringBuilder();
		if (target != null) {
			sb.append(target.toSourceString(indentationString));
		} else if (identifier != null) {
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
			if (target != null) {
				target.traverse(visitor);
			} else if (identifier != null) {
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

	public int getAssignPosition() {
		return assignPosition;
	}

	public void setAssignPosition(int assignPosition) {
		this.assignPosition = assignPosition;
	}

	/**
	 * Returns the comma position after this variable or -1 if this is the last
	 * variable in statement.
	 * 
	 * @return
	 */
	public int getCommaPosition() {
		return commaPosition;
	}

	/**
	 * Sets the comma position after this variable.
	 * 
	 * @param commaPosition
	 */
	public void setCommaPosition(int commaPosition) {
		this.commaPosition = commaPosition;
	}

	public String getVariableName() {
		return identifier != null ? identifier.getName() : null;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier name) {
		this.identifier = name;
		if (target == null) {
			this.target = name;
		}
	}
	
	public Expression getTarget() {
		return target;
	}

	public void setTarget(Expression target) {
		this.target = target;
		if (target instanceof Identifier && identifier == null) {
			this.identifier = (Identifier) target;
		}
	}

	public Expression getInitializer() {
		return initializer;
	}

	public void setInitializer(Expression initializer) {
		this.initializer = initializer;
	}

	@Override
	public Comment getDocumentation() {
		return identifier != null ? identifier.getDocumentation() : null;
	}

	public IVariableStatement getStatement() {
		return (IVariableStatement) getParent();
	}

}
