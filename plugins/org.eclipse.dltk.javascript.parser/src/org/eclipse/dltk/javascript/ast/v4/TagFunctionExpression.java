package org.eclipse.dltk.javascript.ast.v4;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.JSNode;

public class TagFunctionExpression extends Expression {
	
	private Expression tagFunction;
	private TemplateStringLiteral literal;

	public TagFunctionExpression(JSNode parent) {
		super(parent);
	}

	public Expression getTagFunction() {
		return tagFunction;
	}

	public void setTagFunction(Expression tagFunction) {
		this.tagFunction = tagFunction;
	}

	public TemplateStringLiteral getLiteral() {
		return literal;
	}

	public void setLiteral(TemplateStringLiteral literal) {
		this.literal = literal;
	}

	@Override
	public String toSourceString(String indentationString) {
		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);

		StringBuffer buffer = new StringBuffer();
		buffer.append(tagFunction);
		buffer.append(literal.toSourceString(indentationString));
		return buffer.toString();
	}
	
	@Override
	public String toString() {
		return toSourceString("");
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (tagFunction != null) 
				tagFunction.traverse(visitor);
			if (literal != null)
				literal.traverse(visitor);
			visitor.endvisit(this);
		}
	}
}
