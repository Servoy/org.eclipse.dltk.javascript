package org.eclipse.dltk.javascript.ast;

import org.eclipse.dltk.ast.ASTVisitor;

/**
 * Represents a spread property inside an object literal: {@code { ...obj }}.
 */
public class SpreadProperty extends ObjectInitializerPart implements ISourceable {

	private int dotdotdot = -1;
	private Expression expression;

	public SpreadProperty(JSNode parent) {
		super(parent);
	}

	public int getDotDotDot() {
		return dotdotdot;
	}

	public void setDotDotDot(int pos) {
		this.dotdotdot = pos;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	/** SpreadProperty has no distinct key; returns {@code null}. */
	@Override
	public Expression getName() {
		return null;
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (expression != null)
				expression.traverse(visitor);
			visitor.endvisit(this);
		}
	}

	@Override
	public String toSourceString(String indentationString) {
		return "..." + toSourceString(expression, indentationString);
	}
}
