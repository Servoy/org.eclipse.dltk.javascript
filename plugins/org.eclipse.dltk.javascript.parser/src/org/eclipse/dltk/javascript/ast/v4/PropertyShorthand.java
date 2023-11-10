package org.eclipse.dltk.javascript.ast.v4;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.ISourceable;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.ObjectInitializerPart;

/**
 * @author emera
 */
public class PropertyShorthand extends ObjectInitializerPart implements ISourceable {
	
	private Expression expression;

	public PropertyShorthand(JSNode parent) {
		super(parent);
	}
	
	public Expression getExpression() {
		return this.expression;
	}

	public void setExpression(Expression e) {
		this.expression = e;
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
		return toSourceString(expression, indentationString);
	}
}
