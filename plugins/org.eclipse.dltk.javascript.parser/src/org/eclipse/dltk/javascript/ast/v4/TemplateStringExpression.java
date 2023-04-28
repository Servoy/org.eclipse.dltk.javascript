package org.eclipse.dltk.javascript.ast.v4;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.JSNode;

public class TemplateStringExpression extends Expression {
	
	private int templateStringStart = -1;
	private int templateCloseBrace = -1;
	private Expression expression;

	public TemplateStringExpression(JSNode parent) {
		super(parent);
	}

	public int getTemplateStringStart() {
		return templateStringStart;
	}

	public void setTemplateStringStart(int templateStringStart) {
		this.templateStringStart = templateStringStart;
	}

	public int getTemplateCloseBrace() {
		return templateCloseBrace;
	}

	public void setTemplateCloseBrace(int templateCloseBrace) {
		this.templateCloseBrace = templateCloseBrace;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public String toSourceString(String indentationString) {
		Assert.isTrue(sourceStart() > 0);
		Assert.isTrue(sourceEnd() > 0);
		Assert.isTrue(templateStringStart > 0);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("${");
		buffer.append(expression.toSourceString(indentationString));
		if (templateCloseBrace > 0) buffer.append("}");
		return buffer.toString();
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (expression != null)
				expression.traverse(visitor);
			visitor.endvisit(this);
		}
	}
}
