package org.eclipse.dltk.javascript.ast;

import java.util.List;

public abstract class VariableBinding extends JSNode implements JSDeclaration {

	protected int assignPosition = -1;
	protected Expression initializer;
	protected int commaPosition = -1;
	
	public VariableBinding(JSNode parent) {
		super(parent);
	}
	
	public IVariableStatement getStatement() {
		return (IVariableStatement) getParent();
	}

	public Expression getInitializer() {
		return initializer;
	}
	
	public void setInitializer(Expression initializer) {
		this.initializer = initializer;
	}
	
	public int getAssignPosition() {
		return assignPosition;
	}

	public void setAssignPosition(int assignPosition) {
		this.assignPosition = assignPosition;
	}
	
	/**
	 * Returns the comma position after this variable or -1 if this is the last
	 * variable in statement.
	 * 
	 * @return
	 */
	public int getCommaPosition() {
		return commaPosition;
	}

	/**
	 * Sets the comma position after this variable.
	 * 
	 * @param commaPosition
	 */
	public void setCommaPosition(int commaPosition) {
		this.commaPosition = commaPosition;
	}


	public abstract List<Identifier> getIdentifiers();
	public abstract List<String> getVariableNames();
	public abstract Expression getInitializer(String name);
}
