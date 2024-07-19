package org.eclipse.dltk.javascript.parser.v4.factory;

import org.eclipse.dltk.javascript.ast.ArrayInitializer;
import org.eclipse.dltk.javascript.ast.ErrorExpression;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.ObjectInitializer;
import org.eclipse.dltk.javascript.ast.ParenthesizedExpression;
import org.eclipse.dltk.javascript.ast.ThisExpression;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrayLiteralExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AsyncFunctionExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.IdentifierExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LiteralExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ObjectLiteralExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ParenthesizedExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PrimaryExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ThisExpressionContext;

public class PrimaryExpressionFactory extends JSNodeFactory<PrimaryExpressionContext> {
	
private static PrimaryExpressionFactory instance = new PrimaryExpressionFactory();
	
	private PrimaryExpressionFactory() {}
	
	public static PrimaryExpressionFactory getInstance() {
		return instance;
	}

	@Override
	JSNode createJSNode(PrimaryExpressionContext ctx, JSNode parent) {
		if (ctx instanceof ArrayLiteralExpressionContext) {
			return new ArrayInitializer(parent, ((ArrayLiteralExpressionContext)ctx).arrayLiteral().getChildCount() - 1);
		}
		if (ctx instanceof ParenthesizedExpressionContext) {
			return new ParenthesizedExpression(parent);
		}
		if (ctx instanceof ObjectLiteralExpressionContext) {
			return new ObjectInitializer(parent);
		}
		if (ctx instanceof ThisExpressionContext) {
			return new ThisExpression(parent);
		}
		if (ctx instanceof AsyncFunctionExpressionContext) {
			return new FunctionStatement(parent, ((AsyncFunctionExpressionContext)ctx).identifier() != null);
		}
		if (ctx.exception != null) {
			return new ErrorExpression(parent, ctx.exception.getMessage());
		}
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}

	@Override
	boolean skip(PrimaryExpressionContext ctx) {
		return ctx instanceof IdentifierExpressionContext || ctx instanceof LiteralExpressionContext;
	}
}
