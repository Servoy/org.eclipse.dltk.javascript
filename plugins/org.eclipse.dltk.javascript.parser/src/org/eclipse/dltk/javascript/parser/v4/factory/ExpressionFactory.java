package org.eclipse.dltk.javascript.parser.v4.factory;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.javascript.ast.ArrayInitializer;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.ast.v4.BinaryOperation;
import org.eclipse.dltk.javascript.ast.v4.TagFunctionExpression;
import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.ConditionalOperator;
import org.eclipse.dltk.javascript.ast.EmptyExpression;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.GetArrayItemExpression;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.NewExpression;
import org.eclipse.dltk.javascript.ast.ObjectInitializer;
import org.eclipse.dltk.javascript.ast.ParenthesizedExpression;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.ThisExpression;
import org.eclipse.dltk.javascript.ast.v4.UnaryOperation;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AdditiveExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArgumentsExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrayLiteralExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrowFunctionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentOperatorContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentOperatorExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitAndExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitNotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitOrExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitShiftExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitXOrExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ConditionalKeywordExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.DeleteExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.EqualityExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FunctionExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.IdentifierExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.InExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.InstanceofExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LiteralExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LogicalAndExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LogicalOrExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MemberDotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MemberIndexExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MultiplicativeExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.NewExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.NotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ObjectLiteralExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ParenthesizedExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PostDecreaseExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PostIncrementExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PreDecreaseExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PreIncrementExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.RelationalExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.SingleExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TemplateStringExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TernaryExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ThisExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TypeofExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.UnaryMinusExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.UnaryPlusExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VoidExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.YieldExpressionContext;

public class ExpressionFactory extends JSNodeFactory<SingleExpressionContext> {
	private static final ExpressionFactory instance = new ExpressionFactory();

	public static ExpressionFactory getInstance() {
		return instance;
	}
	
	@Override
	JSNode createJSNode(SingleExpressionContext ctx, JSNode parent) {
		if (ctx.getChildCount() == 0) return new EmptyExpression(parent);
		if (ctx instanceof AdditiveExpressionContext) {
			AdditiveExpressionContext _ctx = (AdditiveExpressionContext) ctx;
			return createBinaryOperation(ctx, parent, _ctx.Plus() != null ? _ctx.Plus().getSymbol().getType() : _ctx.Minus().getSymbol().getType());
		}
		if (ctx instanceof AssignmentExpressionContext) {
			return createBinaryOperation(ctx, parent,  ((AssignmentExpressionContext)ctx).Assign().getSymbol().getType());
		}
		if (ctx instanceof AssignmentOperatorExpressionContext) {
			AssignmentOperatorContext _ctx = ((AssignmentOperatorExpressionContext) ctx).assignmentOperator();
			return createBinaryOperation(ctx, parent, _ctx.getStart().getType());
		}
		if (ctx instanceof BitShiftExpressionContext) {
			BitShiftExpressionContext _ctx = (BitShiftExpressionContext) ctx;
			TerminalNode terminalNode = _ctx.LeftShiftArithmetic() != null ?  _ctx.LeftShiftArithmetic() :  _ctx.RightShiftArithmetic() != null ?
					 _ctx.RightShiftArithmetic() : _ctx.RightShiftLogical();
			return createBinaryOperation(ctx, parent, terminalNode.getSymbol().getType());
		}
		if (ctx instanceof MultiplicativeExpressionContext) {
			MultiplicativeExpressionContext _ctx = (MultiplicativeExpressionContext) ctx;
			TerminalNode terminalNode = _ctx.Multiply() != null ? _ctx.Multiply() : _ctx.Divide() != null ? _ctx.Divide() : _ctx.Modulus();
			return createBinaryOperation(ctx, parent, terminalNode.getSymbol().getType());
		}
		if (ctx instanceof RelationalExpressionContext || ctx instanceof EqualityExpressionContext || ctx instanceof LogicalAndExpressionContext ||
				ctx instanceof LogicalOrExpressionContext || ctx instanceof InstanceofExpressionContext ||
				ctx instanceof BitOrExpressionContext || ctx instanceof BitAndExpressionContext || ctx instanceof BitXOrExpressionContext
				|| ctx instanceof InExpressionContext) {
			return createBinaryOperation(ctx, parent, ((TerminalNode)ctx.getChild(1)).getSymbol().getType());
		}
		if (ctx instanceof PostIncrementExpressionContext || ctx instanceof PostDecreaseExpressionContext ) {
			return createUnaryOperation(ctx, parent, ((TerminalNode)ctx.getChild(1)).getSymbol().getType(), true);
		}
		if (ctx instanceof UnaryPlusExpressionContext || ctx instanceof UnaryMinusExpressionContext ||
				ctx instanceof BitNotExpressionContext || ctx instanceof NotExpressionContext ||
				ctx instanceof PreIncrementExpressionContext || ctx instanceof PreDecreaseExpressionContext ||
				ctx instanceof VoidExpressionContext || ctx instanceof TypeofExpressionContext ||
				ctx instanceof DeleteExpressionContext) {
			return createUnaryOperation(ctx, parent, ((TerminalNode)ctx.getChild(0)).getSymbol().getType(), false);
		}
		if (ctx instanceof NewExpressionContext) {
			return new NewExpression(parent);
		}
		if (ctx instanceof ArgumentsExpressionContext) {
			return new CallExpression(parent);
		}
		if (ctx instanceof MemberIndexExpressionContext) {
			return new GetArrayItemExpression(parent);
		}
		if (ctx instanceof MemberDotExpressionContext) {
			return new PropertyExpression(parent);
		}
		if (ctx instanceof ArrayLiteralExpressionContext) {
			return new ArrayInitializer(parent, ((ArrayLiteralExpressionContext)ctx).arrayLiteral().elementList().arrayElement().size());
		}
		if (ctx instanceof ParenthesizedExpressionContext) {
			return new ParenthesizedExpression(parent);
		}
		if (ctx instanceof TernaryExpressionContext) {
			return new ConditionalOperator(parent);
		}
		if (ctx instanceof ObjectLiteralExpressionContext) {
			return new ObjectInitializer(parent);
		}
		if (ctx instanceof ThisExpressionContext) {
			return new ThisExpression(parent);
		}
		if (ctx instanceof FunctionExpressionContext) {
			if (ctx.getChild(0) instanceof ArrowFunctionContext) {
				return new ArrowFunctionStatement(parent);
			}
			return new FunctionStatement(parent, false);
		}
		if (ctx instanceof TemplateStringExpressionContext) {
			return new TagFunctionExpression(parent);
		}
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}
	
	public BinaryOperation createBinaryOperation(SingleExpressionContext ctx, JSNode parent,
			int operationType) {
		Assert.isNotNull(ctx.getChild(0));
		Assert.isNotNull(ctx.getChild(1));

		BinaryOperation operation = new BinaryOperation(parent);
		operation.setOperation(operationType);
		return operation;
	}
	
	UnaryOperation createUnaryOperation(SingleExpressionContext ctx, JSNode parent,
			int operationType, boolean isPostfix) {
		UnaryOperation operation = new UnaryOperation(parent, isPostfix);
		operation.setOperation(operationType);
		operation.setOperationPosition(operationType);
		return operation;
	}

	@Override
	boolean skip(SingleExpressionContext ctx) {
		return ctx instanceof IdentifierExpressionContext || ctx instanceof ConditionalKeywordExpressionContext || ctx instanceof LiteralExpressionContext
				|| ctx instanceof YieldExpressionContext;
	}
}
