package org.eclipse.dltk.javascript.ast.v3;

import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Keywords;
import org.eclipse.dltk.javascript.parser.JSParser;

public class BinaryOperation extends  org.eclipse.dltk.javascript.ast.BinaryOperation{

	public BinaryOperation(JSNode parent) {
		super(parent);
	}

	public boolean isAssignment() {
		return operation == JSParser.ASSIGN || operation == JSParser.ADDASS
				|| operation == JSParser.SUBASS || operation == JSParser.MULASS
				|| operation == JSParser.DIVASS || operation == JSParser.MODASS
				|| operation == JSParser.ANDASS || operation == JSParser.ORASS
				|| operation == JSParser.XORASS || operation == JSParser.SHLASS
				|| operation == JSParser.SHRASS || operation == JSParser.SHUASS;
	}

	public boolean isAssignOperator() {
		return operation == JSParser.ASSIGN;
	}
	
	public String getOperationText() {
		return Keywords.fromToken(this.operation);
	}

	@Override
	public boolean isLogicalAnd() {
		return operation == JSParser.LAND;
	}

	@Override
	public boolean returnsBoolean() {
		return operation == JSParser.GT || operation == JSParser.GTE || operation == JSParser.LT
				|| operation == JSParser.LTE || operation == JSParser.NSAME
				|| operation == JSParser.SAME || operation == JSParser.NEQ
				|| operation == JSParser.EQ || JSParser.INSTANCEOF == operation;
	}

	@Override
	public boolean isAddition() {
		return operation == JSParser.ADD;
	}

	@Override
	public boolean isLogicalOr() {
		return operation == JSParser.LOR;
	}

	@Override
	public boolean isInstanceof() {
		return operation == JSParser.INSTANCEOF;
	}
}
