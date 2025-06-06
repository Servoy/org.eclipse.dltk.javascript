package org.eclipse.dltk.javascript.ast;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;

public interface IDestructuringPattern {

	void setIsDestructuring(boolean markDestructuring);

	boolean isDestructuring();

	String toSourceString(String indentationString);

	void traverse(ASTVisitor visitor) throws Exception;

	List<Identifier> getIdentifiers();

	Expression getInitializerFor(String name, Expression initializer);
}
