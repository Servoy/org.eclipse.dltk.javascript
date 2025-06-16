package org.eclipse.dltk.javascript.ast;

import org.eclipse.dltk.ast.ASTVisitor;

public class BindingIdentifier extends Expression {
	private Identifier identifier;
	private int ellipsisPosition = -1;
	private int assignPosition = -1; //optional
	private Expression defaultValue; //optional

	public BindingIdentifier(JSNode parent) {
		super(parent);
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	public Expression getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Expression defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public int getAssignPosition() {
		return assignPosition;
	}

	public void setAssignPosition(int assignPosition) {
		this.assignPosition = assignPosition;
	}

	@Override
	public void traverse(ASTVisitor visitor)
			throws Exception {
		if (identifier != null)
			identifier.traverse(visitor);
		if (defaultValue != null)
			defaultValue.traverse(visitor);
	}

	@Override
	public String toSourceString(String indentationString) {
		String sourceString = identifier.toSourceString(indentationString);
		if (ellipsisPosition != -1) {
			return "..." + sourceString;
		}
		if (defaultValue != null) {
			return sourceString += " = "
					+ defaultValue.toSourceString(indentationString);
		}
		return sourceString;
	}
}