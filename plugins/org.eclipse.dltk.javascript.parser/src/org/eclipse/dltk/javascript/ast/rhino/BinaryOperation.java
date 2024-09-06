package org.eclipse.dltk.javascript.ast.rhino;

import org.eclipse.dltk.javascript.ast.JSNode;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;

public class BinaryOperation extends org.eclipse.dltk.javascript.ast.BinaryOperation{

	public BinaryOperation(JSNode parent) {
		super(parent);
	}

	public boolean isAssignment() {
		return operation == Token.ASSIGN || operation == Token.ASSIGN_ADD
				|| operation == Token.ASSIGN_SUB || operation == Token.ASSIGN_MUL
				|| operation == Token.ASSIGN_DIV || operation == Token.ASSIGN_MOD
				|| operation == Token.ASSIGN_BITAND || operation == Token.ASSIGN_BITOR
				|| operation ==Token.ASSIGN_BITXOR || operation == Token.ASSIGN_RSH
				|| operation == Token.ASSIGN_LSH || operation == Token.ASSIGN_URSH;
	}

	public boolean isAssignOperator() {
		return operation == Token.ASSIGN;
	}
	
	public String getOperationText() {
		return AstNode.operatorToString(this.operation);
	}

	@Override
	public boolean isLogicalAnd() {
		return operation == Token.AND;
	}

	@Override
	public boolean returnsBoolean() {
		return operation == Token.GE || operation == Token.GT || operation == Token.LT
				|| operation == Token.LE || operation == Token.SHNE
				|| operation == Token.SHEQ || operation == Token.NE
				|| operation == Token.EQ || Token.INSTANCEOF == operation;
	}

	@Override
	public boolean isAddition() {
		return operation == Token.ADD;
	}

	@Override
	public boolean isLogicalOr() {
		return operation == Token.OR;
	}

	@Override
	public boolean isInstanceof() {
		return operation == Token.INSTANCEOF;
	}
}
