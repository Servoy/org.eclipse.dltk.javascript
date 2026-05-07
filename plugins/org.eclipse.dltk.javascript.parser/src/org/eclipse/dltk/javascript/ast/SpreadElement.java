package org.eclipse.dltk.javascript.ast;

import org.eclipse.dltk.ast.ASTVisitor;

/**
 * Represents a spread element in an array literal or call argument list:
 * {@code [...expr]} or {@code f(...expr)}.
 */
public class SpreadElement extends Expression {

	private int dotdotdot = -1;
	private Expression expression;

	public SpreadElement(JSNode parent) {
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
