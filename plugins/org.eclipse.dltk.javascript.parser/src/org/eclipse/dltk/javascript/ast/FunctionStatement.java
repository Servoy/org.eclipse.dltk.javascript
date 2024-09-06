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
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.internal.parser.JSLiterals;

public class FunctionStatement extends Expression implements ISourceableBlock,
		Documentable, JSDeclaration, JSScope {

	private Keyword functionKeyword;
	private Identifier name;
	private List<Argument> arguments = null;
	private StatementBlock body;
	private int LP = -1;
	private int RP = -1;
	// TODO (alex) remove unused field in DLTK 6.0
	@Deprecated
	private int colonPosition = -1;
	private Comment documentation;
	private boolean declaration;
	private List<JSDeclaration> declarations;

	public FunctionStatement(JSNode parent, boolean declaration) {
		super(parent);
		this.declaration = declaration;
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (functionKeyword != null)
				functionKeyword.traverse(visitor);
			if (name != null)
				name.traverse(visitor);

			if (arguments != null) {
				for (ASTNode node : arguments) {
					node.traverse(visitor);
				}
			}
			if (body != null)
				body.traverse(visitor);
			visitor.endvisit(this);
		}
	}

	public Keyword getFunctionKeyword() {
		return this.functionKeyword;
	}

	public void setFunctionKeyword(Keyword keyword) {
		this.functionKeyword = keyword;
	}

	public Identifier getName() {
		return this.name;
	}

	public void setName(Identifier name) {
		this.name = name;
	}

	public Identifier getIdentifier() {
		return name;
	}

	public String getFunctionName() {
		return name != null ? name.getName() : "<anonymous>";
	}

	public List<Argument> getArguments() {
		return arguments != null ? arguments : Collections
				.<Argument> emptyList();
	}

	public void addArgument(Argument argument) {
		if (arguments == null) {
			arguments = new ArrayList<Argument>(4);
		}
		arguments.add(argument);
	}

	/**
	 * Returns the {@link Argument} with the specified name or <code>null</code>
	 * if not found
	 * 
	 * @param argumentName
	 * @return
	 */
	public Argument getArgument(String argumentName) {
		if (arguments != null && argumentName != null) {
			for (Argument argument : arguments) {
				if (argumentName.equals(argument.getArgumentName())) {
					return argument;
				}
			}
		}
		return null;
	}

	public StatementBlock getBody() {
		return this.body;
	}

	public void setBody(StatementBlock body) {
		this.body = body;
	}

	public boolean isEmptyBody() {
		return body == null || body.getStatements().isEmpty();
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

	@Deprecated
	public int getColonPosition() {
		return colonPosition;
	}

	@Deprecated
	public void setColonPosition(int colonPosition) {
		this.colonPosition = colonPosition;
	}

	@Override
	public Comment getDocumentation() {
		return documentation;
	}

	public void setDocumentation(Comment documentation) {
		this.documentation = documentation;
	}

	@Override
	public String toSourceString(String indentationString) {

		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);
		Assert.isTrue(LP > 0);
		Assert.isTrue(RP > 0);

		StringBuffer buffer = new StringBuffer();

		buffer.append(indentationString);
		buffer.append(Keywords.FUNCTION);

		if (name != null) {
			buffer.append(" ");
			buffer.append(name.toSourceString(indentationString));
		}

		buffer.append(" (");

		for (int i = 0; i < getArguments().size(); i++) {
			if (i > 0)
				buffer.append(", ");

			buffer.append(getArguments().get(i).toSourceString(
					indentationString));
		}

		buffer.append(")");
		buffer.append(JSLiterals.EOL);
		buffer.append(getBody().toSourceString(indentationString));

		return buffer.toString();
	}

	public boolean isBlock() {
		return true;
	}

	public boolean isDeclaration() {
		return declaration;
	}

	/**
	 * Tests if this function is just a block:
	 * 
	 * <pre>
	 * (function(){})();
	 * </pre>
	 */
	public boolean isInlineBlock() {
		if (!declaration) {
			if (getParent() instanceof CallExpression) {
				return true;
			} else if (getParent() instanceof ParenthesizedExpression) {
				if (((ParenthesizedExpression) getParent()).getParent() instanceof CallExpression) {
					return true;
				}
			}
		}
		return false;
	}

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

	public void setIsDeclaration(boolean declaration) {
		this.declaration = declaration;
	}
}
