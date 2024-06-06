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

public class Argument extends JSNode implements ISourceable {

	private Identifier identifier;
	private int commaPosition = -1;
	private int ellipsisPosition = -1;

	public Argument(JSNode parent) {
		super(parent);
	}

	public String getArgumentName() {
		return identifier != null ? identifier.getName() : null;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
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
	
	public void setEllipsisPosition(int ellipsisPosition) {
		this.ellipsisPosition = ellipsisPosition;
	}
	
	public int getEllipsisPosition() {
		return ellipsisPosition;
	}

	@Override
	public String toSourceString(String indentationString) {
		if (ellipsisPosition != -1) {
			return "..." + identifier.toSourceString(indentationString);
		}
		return identifier.toSourceString(indentationString);
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (identifier != null) {
			identifier.traverse(visitor);
		}
	}
}
