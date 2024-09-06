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

import java.util.Collection;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.SourceRange;
import org.eclipse.dltk.javascript.internal.parser.JSLiterals;

public abstract class JSNode extends ASTNode {

	/**
	 * @since 2.0
	 */
	protected static void toSourceString(Collection<Statement> statements,
			StringBuffer buffer, String indentationString) {
		for (Statement statement : statements) {
			buffer.append(statement.toSourceString(indentationString));
		}
	}

	/**
	 * @since 5.0
	 */
	protected static String toSourceString(ISourceable node,
			String indentationString) {
		return node != null ? node.toSourceString(indentationString) : "?";
	}

	private JSNode parent;

	public JSNode(JSNode parent) {
		this.parent = parent;
		setStart(0);
		setEnd(0);
	}

	public JSNode getParent() {
		return this.parent;
	}

	/**
	 * Returns the root Script node this node is contained in or
	 * <code>null</code> if this node is not contained in any Script.
	 */
	public Script getScript() {
		JSNode current = parent;
		for (;;) {
			if (current instanceof Script) {
				return (Script) current;
			} else {
				current = current.parent;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends JSNode> T getAncestor(Class<T> clazz) {
		JSNode current = this;
		while (current != null) {
			if (clazz.isInstance(current)) {
				return (T) current;
			} else {
				current = current.parent;
			}
		}
		return null;
	}

	public Comment getDocumentation() {
		return null;
	}

	@Override
	public String toString() {
		return toSourceString(JSLiterals.EMPTY);
	}

	public abstract String toSourceString(String indentationString);

	public ISourceRange getRange() {
		return new SourceRange(sourceStart(), sourceEnd() - sourceStart());
	}

	public void setParent(JSNode parent) {
		this.parent = parent;		
	}
}
