package org.eclipse.dltk.javascript.ast;

import org.eclipse.dltk.ast.ASTVisitor;

/**
 * Represents a computed property key in an object literal:
 * {@code { [expr]: value }}.
 * <p>
 * The {@link #getKey()} expression is the computed key (inside {@code []}),
 * and {@link #getValue()} is the property value. The positions of {@code [},
 * {@code ]}, and {@code :} are stored for source-range fidelity.
 */
public class ComputedPropertyKey extends ObjectInitializerPart implements ISourceable {

	private Expression key;
	private Expression value;
	private int lb = -1;
	private int rb = -1;
	private int colon = -1;

	public ComputedPropertyKey(JSNode parent) {
		super(parent);
	}

	public Expression getKey() {
		return key;
	}

	public void setKey(Expression key) {
		this.key = key;
	}

	public Expression getValue() {
		return value;
	}

	public void setValue(Expression value) {
		this.value = value;
	}

	public int getLB() {
		return lb;
	}

	public void setLB(int lb) {
		this.lb = lb;
	}

	public int getRB() {
		return rb;
	}

	public void setRB(int rb) {
		this.rb = rb;
	}

	public int getColon() {
		return colon;
	}

	public void setColon(int colon) {
		this.colon = colon;
	}

	/**
	 * Returns {@code null} — computed keys are not simple name expressions.
	 */
	@Override
	public Expression getName() {
		return null;
	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (key != null)
				key.traverse(visitor);
			if (value != null)
				value.traverse(visitor);
			visitor.endvisit(this);
		}
	}

	@Override
	public String toSourceString(String indentationString) {
		return "[" + toSourceString(key, indentationString) + "]: "
				+ toSourceString(value, indentationString);
	}
}
