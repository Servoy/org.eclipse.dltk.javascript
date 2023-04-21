package org.eclipse.dltk.javascript.ast.v4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.ISourceableBlock;
import org.eclipse.dltk.javascript.ast.JSDeclaration;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.JSScope;
import org.eclipse.dltk.javascript.ast.ParenthesizedExpression;
import org.eclipse.dltk.javascript.ast.Statement;
import org.eclipse.dltk.javascript.ast.StatementBlock;

/**
 * @author emera
 */
public class ArrowFunctionStatement extends Expression implements ISourceableBlock, JSScope {
	
	private List<Argument> arguments = null;
	private int LP = -1;
	private int RP = -1;
	private int ARROW = -1;
	private Statement body;
	private List<JSDeclaration> declarations;

	public ArrowFunctionStatement(JSNode parent) {
		super(parent);
	}
	
	public List<Argument> getArguments() {
		return arguments != null ? arguments : Collections
				.<Argument> emptyList();
	}

	public void addArgument(Argument argument) {
		if (arguments == null) {
			arguments = new ArrayList<Argument>(4);
		}
		arguments.add(argument);
	}
	
	public int getLP() {
		return this.LP;
	}

	public void setLP(int LP) {
		this.LP = LP;
	}

	public int getRP() {
		return this.RP;
	}

	public void setRP(int RP) {
		this.RP = RP;
	}
	
	public void setArrow(int arr) {
		ARROW = arr;
	}
	
	public int getArrow() {
		return ARROW;
	}
	
	public Statement getBody() {
		return this.body;
	}

	public void setBody(Statement body) {
		this.body = body;
	}

	public boolean isEmptyBody() {
		return body == null || body instanceof StatementBlock && ((StatementBlock) body).getStatements().isEmpty();
	}

	@Override
	public String toSourceString(String indentationString) {
		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);
		Assert.isTrue(ARROW > 0);

		StringBuffer buffer = new StringBuffer();

		buffer.append(indentationString);

		if (LP >= 0) buffer.append(" (");

		for (int i = 0; i < getArguments().size(); i++) {
			if (i > 0)
				buffer.append(", ");

			buffer.append(getArguments().get(i).toSourceString(
					indentationString));
		}

		if (RP > 0) buffer.append(")");
		buffer.append(" => ");
		buffer.append(getBody().toSourceString(indentationString));

		return buffer.toString();
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (arguments != null) {
				for (ASTNode node : arguments) {
					node.traverse(visitor);
				}
			}
			if (body != null)
				body.traverse(visitor);
			visitor.endvisit(this);
		}
	}

	public void addDeclaration(JSDeclaration declaration) {
		if (declarations == null) {
			declarations = new ArrayList<JSDeclaration>();
		}
		declarations.add(declaration);
	}

	public List<JSDeclaration> getDeclarations() {
		return declarations != null ? declarations : Collections
				.<JSDeclaration> emptyList();
	}
	
	@Override
	public boolean isBlock() {
		return (body instanceof ISourceableBlock)
				&& ((ISourceableBlock) body).isBlock();
	}

	public boolean isInlineBlock() {
		if (getParent() instanceof ParenthesizedExpression) {
			if (((ParenthesizedExpression) getParent()).getParent() instanceof CallExpression) {
				return true;
			}
		}
		return false;
	}
}
