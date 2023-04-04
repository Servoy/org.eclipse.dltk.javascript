package org.eclipse.dltk.javascript.core.dom.rewrite;

import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.UnaryOperation;
import org.eclipse.dltk.javascript.core.dom.BinaryOperator;
import org.eclipse.dltk.javascript.core.dom.UnaryOperator;
import org.eclipse.dltk.javascript.parser.v4.JSParser;

public class OperatorFactoryV4 {

	public BinaryOperator createBinaryOperator(BinaryOperation node) {
		BinaryOperator r = null;
		switch (node.getOperation()) {
		case JSParser.Plus:
			r = BinaryOperator.ADD;
			break;
		case JSParser.PlusAssign:
			r = BinaryOperator.ADD_ASSIGN;
			break;
		case JSParser.BitAndAssign:
			r = BinaryOperator.AND_ASSIGN;
			break;
		case JSParser.Assign:
			r = BinaryOperator.ASSIGN;
			break;
		case JSParser.BitAnd:
			r = BinaryOperator.BW_AND;
			break;
		case JSParser.Comma:
			r = BinaryOperator.COMMA;
			break;
		case JSParser.BitOr:
			r = BinaryOperator.BW_OR;
			break;
		case JSParser.BitXOr:
			r = BinaryOperator.BW_XOR;
			break;
		case JSParser.Divide:
			r = BinaryOperator.DIV;
			break;
		case JSParser.DivideAssign:
			r = BinaryOperator.DIV_ASSIGN;
			break;
		case JSParser.Equals_:
			r = BinaryOperator.EQ;
			break;
		case JSParser.GreaterThanEquals:
			r = BinaryOperator.GEQ;
			break;
		case JSParser.MoreThan:
			r = BinaryOperator.GREATER;
			break;
		case JSParser.In:
			r = BinaryOperator.IN;
			break;
		case JSParser.Instanceof:
			r = BinaryOperator.INSTANCEOF;
			break;
		case JSParser.LessThanEquals:
			r = BinaryOperator.LEQ;
			break;
		case JSParser.LessThan:
			r = BinaryOperator.LESS;
			break;
		case JSParser.And:
			r = BinaryOperator.LOG_AND;
			break;
		case JSParser.Or:
			r = BinaryOperator.LOG_OR;
			break;
		case JSParser.LeftShiftArithmetic:
			r = BinaryOperator.LSH;
			break;
		case JSParser.LeftShiftArithmeticAssign:
			r = BinaryOperator.LSH_ASSIGN;
			break;
		case JSParser.Modulus:
			r = BinaryOperator.MOD;
			break;
		case JSParser.ModulusAssign:
			r = BinaryOperator.MOD_ASSIGN;
			break;
		case JSParser.Multiply:
			r = BinaryOperator.MUL;
			break;
		case JSParser.MultiplyAssign:
			r = BinaryOperator.MUL_ASSIGN;
			break;
		case JSParser.NotEquals:
			r = BinaryOperator.NEQ;
			break;
		case JSParser.IdentityNotEquals:
			r = BinaryOperator.NSAME;
			break;
		case JSParser.BitOrAssign:
			r = BinaryOperator.OR_ASSIGN;
			break;
		case JSParser.RightShiftArithmetic:
			r = BinaryOperator.RSH;
			break;
		case JSParser.RightShiftArithmeticAssign:
			r = BinaryOperator.RSH_ASSIGN;
			break;
		case JSParser.IdentityEquals:
			r = BinaryOperator.SAME;
			break;
		case JSParser.Minus:
			r = BinaryOperator.SUB;
			break;
		case JSParser.MinusAssign:
			r = BinaryOperator.SUB_ASSIGN;
			break;
		case JSParser.RightShiftLogical:
			r = BinaryOperator.URSH;
			break;
		case JSParser.RightShiftLogicalAssign:
			r = BinaryOperator.URSH_ASSIGN;
			break;
		case JSParser.BitXorAssign:
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
		case JSParser.BitNot:
			r  = UnaryOperator.BW_NOT;
			break;
		case JSParser.Delete:
			r = UnaryOperator.DELETE;
			break;
		case JSParser.Not:
			r = UnaryOperator.NOT;
			break;
		case JSParser.Minus:
			r = UnaryOperator.NUM_NEG;
			break;
		case JSParser.MinusMinus:
			r = node.isPostfix() ? UnaryOperator.POSTFIX_DEC : UnaryOperator.PREFIX_DEC;
			break;
		case JSParser.PlusPlus:
			r = node.isPostfix() ? UnaryOperator.POSTFIX_INC : UnaryOperator.PREFIX_INC;
			break;
		case JSParser.Typeof:
			r = UnaryOperator.TYPEOF;
			break;
		case JSParser.Plus:
			r = UnaryOperator.UNARY_PLUS;
			break;
		case JSParser.Void:
			r = UnaryOperator.VOID;
			break;
		default:
			throw new IllegalStateException("Unknown binary operator");
		}
		return r;
	}
}
