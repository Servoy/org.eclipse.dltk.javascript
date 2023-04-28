package org.eclipse.dltk.javascript.core.dom;

public interface TemplateStringLiteral extends Expression, IPropertyName {

	void setText(String text);
	String getText();
	void addExpression(Node templateStringExpression);
}
