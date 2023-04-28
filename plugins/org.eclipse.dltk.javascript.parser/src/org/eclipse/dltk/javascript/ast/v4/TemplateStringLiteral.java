package org.eclipse.dltk.javascript.ast.v4;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Literal;

public class TemplateStringLiteral extends Literal {
	
	private String text;
	private List<TemplateStringExpression> templateExpressions = new ArrayList<TemplateStringExpression>();
	private int startBackTick = -1;
	private int endBackTick = -1;

	public TemplateStringLiteral(JSNode parent) {
		super(parent);
	}

	@Override
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toSourceString(String indentationString) {
		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);

		return text;
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (templateExpressions != null) {
				for (ASTNode node : templateExpressions) {
					node.traverse(visitor);
				}
			}
			visitor.endvisit(this);
		}
	}	

	public int getStartBackTick() {
		return startBackTick;
	}

	public void setStartBackTick(int startBackTick) {
		this.startBackTick = startBackTick;
	}

	public int getEndBackTick() {
		return endBackTick;
	}

	public void setEndBackTick(int endBackTick) {
		this.endBackTick = endBackTick;
	}

	public void addTemplateStringExpression(TemplateStringExpression expression) {
		templateExpressions.add(expression);
	}

	public List<TemplateStringExpression> getTemplateExpressions() {
		return templateExpressions;
	}	
}
