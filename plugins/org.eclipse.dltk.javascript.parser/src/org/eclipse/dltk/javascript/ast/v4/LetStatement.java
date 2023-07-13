package org.eclipse.dltk.javascript.ast.v4;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.Documentable;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.IVariableStatement;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Keyword;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.internal.parser.JSLiterals;

public class LetStatement extends Expression
		implements IVariableStatement, Documentable {

	private Keyword letKeyword;
	private final List<VariableDeclaration> variables = new ArrayList<VariableDeclaration>();
	private Comment documentation;

	public LetStatement(JSNode parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (letKeyword != null) {
				letKeyword.traverse(visitor);
			}
			for (ASTNode node : variables) {
				node.traverse(visitor);
			}
			visitor.endvisit(this);
		}
	}

	public List<VariableDeclaration> getVariables() {
		return this.variables;
	}

	public void addVariable(VariableDeclaration declaration) {
		this.variables.add(declaration);
	}

	public Keyword getLetKeyword() {
		return this.letKeyword;
	}

	public void setLetKeyword(Keyword keyword) {
		this.letKeyword = keyword;
	}

	@Override
	public String toSourceString(String indentationString) {

		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);

		StringBuffer buffer = new StringBuffer();

		buffer.append(Keywords.LET);
		buffer.append(JSLiterals.SPACE);

		for (int i = 0; i < variables.size(); i++) {
			if (i > 0)
				buffer.append(", ");

			buffer.append(variables.get(i).toSourceString(indentationString));
		}

		return buffer.toString();
	}

	@Override
	public Comment getDocumentation() {
		return documentation;
	}

	public void setDocumentation(Comment documentation) {
		this.documentation = documentation;
	}

}