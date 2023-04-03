package org.eclipse.dltk.javascript.ast.v3;

import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Keywords;
import org.eclipse.dltk.javascript.parser.JSParser;

public class UnaryOperation extends org.eclipse.dltk.javascript.ast.UnaryOperation{

	public UnaryOperation(JSNode parent) {
		super(parent);
	}

	public String getOperationText() {
		return Keywords.fromToken(operation);
	}

	public boolean isPostfix() {
		return operation == JSParser.PINC || operation == JSParser.PDEC;
	}

	public boolean isTextOperator() {
		return operation == JSParser.DELETE || operation == JSParser.TYPEOF
				|| operation == JSParser.VOID;
	}
	
	public boolean isIncDec() {
		return operation == JSParser.INC || operation == JSParser.DEC
				|| operation == JSParser.PINC || operation == JSParser.PDEC;
	}
	
	@Override
	public boolean isNotOperator() {
		return operation == JSParser.NOT;
	}

	@Override
	public boolean isDelete() {
		return operation == JSParser.DELETE;
	}
	
	@Override
	public boolean isTypeOf() {
		return operation == JSParser.TYPEOF;
	}
	
	@Override
	public boolean isVoid() {
		return operation == JSParser.VOID;
	}
}
