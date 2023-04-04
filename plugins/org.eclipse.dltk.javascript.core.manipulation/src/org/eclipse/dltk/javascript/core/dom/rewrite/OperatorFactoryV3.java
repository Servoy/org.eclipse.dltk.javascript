package org.eclipse.dltk.javascript.core.dom.rewrite;

import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.UnaryOperation;
import org.eclipse.dltk.javascript.core.dom.BinaryOperator;
import org.eclipse.dltk.javascript.core.dom.UnaryOperator;
import org.eclipse.dltk.javascript.parser.JSParser;

public class OperatorFactoryV3 {

	public BinaryOperator createBinaryOperator(BinaryOperation node) {
		BinaryOperator r = null;
		switch (node.getOperation()) {
		case JSParser.ADD:
			r = BinaryOperator.ADD;
			break;
		case JSParser.ADDASS:
			r = BinaryOperator.ADD_ASSIGN;
			break;
		case JSParser.ANDASS:
			r = BinaryOperator.AND_ASSIGN;
			break;
		case JSParser.ASSIGN:
			r = BinaryOperator.ASSIGN;
			break;
		case JSParser.AND:
			r = BinaryOperator.BW_AND;
			break;
		case JSParser.COMMA:
			r = BinaryOperator.COMMA;
			break;
		case JSParser.OR:
			r = BinaryOperator.BW_OR;
			break;
		case JSParser.XOR:
			r = BinaryOperator.BW_XOR;
			break;
		case JSParser.DIV:
			r = BinaryOperator.DIV;
			break;
		case JSParser.DIVASS:
			r = BinaryOperator.DIV_ASSIGN;
			break;
		case JSParser.EQ:
			r = BinaryOperator.EQ;
			break;
		case JSParser.GTE:
			r = BinaryOperator.GEQ;
			break;
		case JSParser.GT:
			r = BinaryOperator.GREATER;
			break;
		case JSParser.IN:
			r = BinaryOperator.IN;
			break;
		case JSParser.INSTANCEOF:
			r = BinaryOperator.INSTANCEOF;
			break;
		case JSParser.LTE:
			r = BinaryOperator.LEQ;
			break;
		case JSParser.LT:
			r = BinaryOperator.LESS;
			break;
		case JSParser.LAND:
			r = BinaryOperator.LOG_AND;
			break;
		case JSParser.LOR:
			r = BinaryOperator.LOG_OR;
			break;
		case JSParser.SHL:
			r = BinaryOperator.LSH;
			break;
		case JSParser.SHLASS:
			r = BinaryOperator.LSH_ASSIGN;
			break;
		case JSParser.MOD:
			r = BinaryOperator.MOD;
			break;
		case JSParser.MODASS:
			r = BinaryOperator.MOD_ASSIGN;
			break;
		case JSParser.MUL:
			r = BinaryOperator.MUL;
			break;
		case JSParser.MULASS:
			r = BinaryOperator.MUL_ASSIGN;
			break;
		case JSParser.NEQ:
			r = BinaryOperator.NEQ;
			break;
		case JSParser.NSAME:
			r = BinaryOperator.NSAME;
			break;
		case JSParser.ORASS:
			r = BinaryOperator.OR_ASSIGN;
			break;
		case JSParser.SHR:
			r = BinaryOperator.RSH;
			break;
		case JSParser.SHRASS:
			r = BinaryOperator.RSH_ASSIGN;
			break;
		case JSParser.SAME:
			r = BinaryOperator.SAME;
			break;
		case JSParser.SUB:
			r = BinaryOperator.SUB;
			break;
		case JSParser.SUBASS:
			r = BinaryOperator.SUB_ASSIGN;
			break;
		case JSParser.SHU:
			r = BinaryOperator.URSH;
			break;
		case JSParser.SHUASS:
			r = BinaryOperator.URSH_ASSIGN;
			break;
		case JSParser.XORASS:
			r = BinaryOperator.XOR_ASSIGN;
			break;
		default:
			throw new IllegalStateException("Unknown binary operator");
		}
		return r;
	}

	public UnaryOperator createUnaryOperator(UnaryOperation node) {
		UnaryOperator r = null;
		switch (node.getOperation()) {
		case JSParser.INV:
			r  = UnaryOperator.BW_NOT;
			break;
		case JSParser.DELETE:
			r = UnaryOperator.DELETE;
			break;
		case JSParser.NOT:
			r = UnaryOperator.NOT;
			break;
		case JSParser.NEG:
		case JSParser.SUB:
			r = UnaryOperator.NUM_NEG;
			break;
		case JSParser.PDEC:
			r = UnaryOperator.POSTFIX_DEC;
			break;
		case JSParser.PINC:
			r = UnaryOperator.POSTFIX_INC;
			break;
		case JSParser.DEC:
			r = UnaryOperator.PREFIX_DEC;
			break;
		case JSParser.INC:
			r = UnaryOperator.PREFIX_INC;
			break;
		case JSParser.TYPEOF:
			r = UnaryOperator.TYPEOF;
			break;
		case JSParser.POS:
		case JSParser.ADD:
			r = UnaryOperator.UNARY_PLUS;
			break;
		case JSParser.VOID:
			r = UnaryOperator.VOID;
			break;
		default:
			throw new IllegalStateException("Unknown binary operator");
		}
		return r;
	}
}
