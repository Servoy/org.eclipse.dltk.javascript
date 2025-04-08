package org.eclipse.dltk.javascript.core.dom.rewrite;

import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.UnaryOperation;
import org.eclipse.dltk.javascript.core.dom.BinaryOperator;
import org.eclipse.dltk.javascript.core.dom.UnaryOperator;
import org.mozilla.javascript.Token;

public class OperatorFactoryRhino {

	public BinaryOperator createBinaryOperator(BinaryOperation node) {
		BinaryOperator r = null;
		switch (node.getOperation()) {
		case Token.ADD:
			r = BinaryOperator.ADD;
			break;
		case Token.ASSIGN_ADD:
			r = BinaryOperator.ADD_ASSIGN;
			break;
		case Token.ASSIGN_BITAND:
			r = BinaryOperator.AND_ASSIGN;
			break;
		case Token.ASSIGN:
			r = BinaryOperator.ASSIGN;
			break;
		case Token.BITAND:
			r = BinaryOperator.BW_AND;
			break;
		case Token.COMMA:
			r = BinaryOperator.COMMA;
			break;
		case Token.BITOR:
			r = BinaryOperator.BW_OR;
			break;
		case Token.BITXOR:
			r = BinaryOperator.BW_XOR;
			break;
		case Token.DIV:
			r = BinaryOperator.DIV;
			break;
		case Token.ASSIGN_DIV:
			r = BinaryOperator.DIV_ASSIGN;
			break;
		case Token.EQ:
			r = BinaryOperator.EQ;
			break;
		case Token.GE:
			r = BinaryOperator.GEQ;
			break;
		case Token.GT:
			r = BinaryOperator.GREATER;
			break;
		case Token.IN:
			r = BinaryOperator.IN;
			break;
		case Token.INSTANCEOF:
			r = BinaryOperator.INSTANCEOF;
			break;
		case Token.LE:
			r = BinaryOperator.LEQ;
			break;
		case Token.LT:
			r = BinaryOperator.LESS;
			break;
		case Token.AND:
			r = BinaryOperator.LOG_AND;
			break;
		case Token.OR:
			r = BinaryOperator.LOG_OR;
			break;
		case Token.LSH:
			r = BinaryOperator.LSH;
			break;
		case Token.ASSIGN_LSH:
			r = BinaryOperator.LSH_ASSIGN;
			break;
		case Token.MOD:
			r = BinaryOperator.MOD;
			break;
		case Token.ASSIGN_MOD:
			r = BinaryOperator.MOD_ASSIGN;
			break;
		case Token.MUL:
			r = BinaryOperator.MUL;
			break;
		case Token.ASSIGN_MUL:
			r = BinaryOperator.MUL_ASSIGN;
			break;
		case Token.NE:
			r = BinaryOperator.NEQ;
			break;
		case Token.SHNE:
			r = BinaryOperator.NSAME;
			break;
		case Token.ASSIGN_BITOR:
			r = BinaryOperator.OR_ASSIGN;
			break;
		case Token.RSH:
			r = BinaryOperator.RSH;
			break;
		case Token.ASSIGN_RSH:
			r = BinaryOperator.RSH_ASSIGN;
			break;
		case Token.SHEQ:
			r = BinaryOperator.SAME;
			break;
		case Token.SUB:
			r = BinaryOperator.SUB;
			break;
		case Token.ASSIGN_SUB:
			r = BinaryOperator.SUB_ASSIGN;
			break;
		case Token.URSH:
			r = BinaryOperator.URSH;
			break;
		case Token.ASSIGN_URSH:
			r = BinaryOperator.URSH_ASSIGN;
			break;
		case Token.ASSIGN_BITXOR:
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
		case Token.BITNOT:
			r  = UnaryOperator.BW_NOT;
			break;
		case Token.DELPROP:
			r = UnaryOperator.DELETE;
			break;
		case Token.NOT:
			r = UnaryOperator.NOT;
			break;
		case Token.NEG:
			r = UnaryOperator.NUM_NEG;
			break;
		case Token.DEC:
			r = node.isPostfix() ? UnaryOperator.POSTFIX_DEC : UnaryOperator.PREFIX_DEC;
			break;
		case Token.INC:
			r = node.isPostfix() ? UnaryOperator.POSTFIX_INC : UnaryOperator.PREFIX_INC;
			break;
		case Token.TYPEOF:
			r = UnaryOperator.TYPEOF;
			break;
		case Token.ADD:
			r = UnaryOperator.UNARY_PLUS;
			break;
		case Token.VOID:
			r = UnaryOperator.VOID;
			break;
		default:
			throw new IllegalStateException("Unknown binary operator");
		}
		return r;
	}
}
