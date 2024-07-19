package org.eclipse.dltk.javascript.parser.v4.factory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.javascript.ast.ConditionalOperator;
import org.eclipse.dltk.javascript.ast.EmptyExpression;
import org.eclipse.dltk.javascript.ast.ErrorExpression;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.ast.v4.BinaryOperation;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrowFunctionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentExprContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentOperatorContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentOperatorExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BinaryExprContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TernaryExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.YieldExpressionContext;

public class ExpressionFactory extends JSNodeFactory<AssignmentExpressionContext> {
	private static final ExpressionFactory instance = new ExpressionFactory();

	public static ExpressionFactory getInstance() {
		return instance;
	}
	
	@Override
	JSNode createJSNode(AssignmentExpressionContext ctx, JSNode parent) {
		if (ctx.getChildCount() == 0) return new EmptyExpression(parent);
		if (ctx instanceof AssignmentExprContext) {
			return createBinaryOperation(ctx, parent,
					((AssignmentExprContext) ctx).Assign().getSymbol().getType());
		}
		if (ctx instanceof AssignmentOperatorExpressionContext) {
			AssignmentOperatorContext _ctx = ((AssignmentOperatorExpressionContext) ctx)
					.assignmentOperator();
			return createBinaryOperation(ctx, parent, _ctx.getStart().getType());
		}
		if (ctx instanceof TernaryExpressionContext) {
			return new ConditionalOperator(parent);
		}
		if (ctx instanceof ArrowFunctionContext) {
			return new ArrowFunctionStatement(parent);
		}
		if (ctx.exception != null) {
			return new ErrorExpression(parent, ctx.exception.getMessage());
		}
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}

	private BinaryOperation createBinaryOperation(AssignmentExpressionContext ctx, JSNode parent,
			int operationType) {
		Assert.isNotNull(ctx.getChild(0));
		Assert.isNotNull(ctx.getChild(1));

		BinaryOperation operation = new BinaryOperation(parent);
		operation.setOperation(operationType);
		return operation;
	}

	@Override
	boolean skip(AssignmentExpressionContext ctx) {
		return ctx instanceof YieldExpressionContext || ctx instanceof BinaryExprContext;
	}
}
