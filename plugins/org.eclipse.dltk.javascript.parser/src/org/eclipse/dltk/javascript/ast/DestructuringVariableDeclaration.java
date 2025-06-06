package org.eclipse.dltk.javascript.ast;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.javascript.internal.parser.JSLiterals;

public class DestructuringVariableDeclaration extends VariableBinding implements ISourceable {

    private IDestructuringPattern target;

    public DestructuringVariableDeclaration(IVariableStatement parent) {
		super((JSNode) parent);
	}
    
    @Override
	public String toSourceString(String indentationString) {
		final StringBuilder sb = new StringBuilder();
		if (target != null) {
			sb.append(target.toSourceString(indentationString));
		} else {
			sb.append(JSLiterals.ERROR_TOKEN);
		}
		if (initializer != null) {
			sb.append(JSLiterals.ASSIGN);
			sb.append(initializer.toSourceString(indentationString));
		}
		return sb.toString();
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (target != null) {
				target.traverse(visitor);
			}
			if (initializer != null) {
				initializer.traverse(visitor);
			}
			visitor.endvisit(this);
		}
	}

	public List<Identifier> getIdentifiers() {
		return target != null ? target.getIdentifiers() : null;
	}
	
	public List<String> getVariableNames() {
		return target != null ? target.getIdentifiers().stream().map(i -> i != null ? i.getName() : JSLiterals.ERROR_TOKEN).toList() : null;
	}
	
	public IDestructuringPattern getTarget() {
        return target;
    }

	public void setTarget(IDestructuringPattern destructuring) {
		target = destructuring;		
	}

	@Override
	public Identifier getIdentifier() {
		throw new UnsupportedOperationException("Destructuring declarations do not have a single identifier");		
	}

	@Override
	public Expression getInitializer(String name) {
		return target != null ? target.getInitializerFor(name, initializer) : null;
	}
}
