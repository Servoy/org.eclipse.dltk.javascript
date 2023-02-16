package org.eclipse.dltk.javascript.parser.v4.factory;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.v4.BinaryOperation;
import org.eclipse.dltk.javascript.ast.v4.UnaryOperation;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AdditiveExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentOperatorExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.IdentifierExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LiteralExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MultiplicativeExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PostIncrementExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.RelationalExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.SingleExpressionContext;

public class ExpressionFactory extends JSNodeFactory<SingleExpressionContext> {
	private static final ExpressionFactory instance = new ExpressionFactory();

	public static ExpressionFactory getInstance() {
		return instance;
	}
	
	@Override
	JSNode createJSNode(SingleExpressionContext ctx, JSNode parent) {
		if (ctx instanceof AdditiveExpressionContext) {
			AdditiveExpressionContext _ctx = (AdditiveExpressionContext) ctx;
			return createBinaryOperation(ctx, parent, _ctx.Plus() != null ? _ctx.Plus().getSymbol().getType() : _ctx.Minus().getSymbol().getType());
		}
		if (ctx instanceof AssignmentExpressionContext) {
			return createBinaryOperation(ctx, parent,  ((AssignmentExpressionContext)ctx).Assign().getSymbol().getType());
		}
		if (ctx instanceof AssignmentOperatorExpressionContext) {
			return createBinaryOperation(ctx, parent, -1);
		}
		if (ctx instanceof MultiplicativeExpressionContext) {
			MultiplicativeExpressionContext _ctx = (MultiplicativeExpressionContext) ctx;
			TerminalNode terminalNode = _ctx.Multiply() != null ? _ctx.Multiply() : _ctx.Divide() != null ? _ctx.Divide() : _ctx.Modulus();
			return createBinaryOperation(ctx, parent, terminalNode.getSymbol().getType());
		}
		if (ctx instanceof RelationalExpressionContext) {
			return createBinaryOperation(ctx, parent, ((TerminalNode)ctx.getChild(1)).getSymbol().getType());
		}
		if (ctx instanceof PostIncrementExpressionContext) {
			return new UnaryOperation(parent);
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

	@Override
	boolean skip(ParserRuleContext ctx) {
		return ctx instanceof IdentifierExpressionContext || ctx instanceof LiteralExpressionContext;
	}
}
