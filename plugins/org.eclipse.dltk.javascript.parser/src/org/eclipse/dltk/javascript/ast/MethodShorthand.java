package org.eclipse.dltk.javascript.ast;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;

public class MethodShorthand extends Method {

	private List<Argument> arguments;

	public MethodShorthand(JSNode parent) {
		super(parent);
	}

	@Override
	public String toSourceString(String indentationString) {
		final StringBuilder buffer = new StringBuilder();
		
		buffer.append(toSourceString(getName(), indentationString));
		if (arguments != null && !arguments.isEmpty()) {
			buffer.append("(");
			for (int i = 0; i < arguments.size(); i++) {
				if (i > 0) {
					buffer.append(", ");
				}
				buffer.append(
						arguments.get(i).toSourceString(indentationString));
			}
			buffer.append(")");
		} else {
			buffer.append("()");
		}
		buffer.append(toSourceString(getBody(), indentationString));

		return buffer.toString();
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (getName() != null)
				getName().traverse(visitor);
			if (getBody() != null)
				getBody().traverse(visitor);
			visitor.endvisit(this);
		}
	}

	public void setArguments(List<Argument> arguments) {
		this.arguments = arguments;		
	}

	public List<Argument> getArguments() {
		return this.arguments;
	}

	@Override
	public Comment getDocumentation() {
		return getName() != null ? getName().getDocumentation() : null;
	}
}
