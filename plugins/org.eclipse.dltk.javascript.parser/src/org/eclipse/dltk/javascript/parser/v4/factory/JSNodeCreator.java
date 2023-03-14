package org.eclipse.dltk.javascript.parser.v4.factory;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PropertyNameContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.SingleExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.StatementContext;

public class JSNodeCreator {

	public static JSNode create(ParserRuleContext ctx, JSNode parent) {
		if (ctx.getClass().isAssignableFrom(StatementContext.class)) {
			return StatementFactory.getInstance().createJSNode((StatementContext) ctx, parent);
		}
		if (SingleExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return ExpressionFactory.getInstance().createJSNode((SingleExpressionContext) ctx, parent);
		}
		if (ctx.getClass().isAssignableFrom(LiteralContext.class)) {
			return LiteralFactory.getInstance().createJSNode((LiteralContext) ctx, parent);
		}
		if (ctx.getClass().isAssignableFrom(PropertyNameContext.class)) {
			return PropertyNameFactory.getInstance().createJSNode((PropertyNameContext) ctx, parent);
		}
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}
	
	public static boolean skipCreate(ParserRuleContext ctx) {
		if (ctx.getClass().isAssignableFrom(StatementContext.class)) {
			return StatementFactory.getInstance().skip((StatementContext) ctx);
		}
		if (SingleExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return ExpressionFactory.getInstance().skip((SingleExpressionContext) ctx);
		}
		if (ctx.getClass().isAssignableFrom(LiteralContext.class)) {
			return LiteralFactory.getInstance().skip((LiteralContext) ctx);
		}
		if (ctx.getClass().isAssignableFrom(PropertyNameContext.class)) {
			return PropertyNameFactory.getInstance().skip((PropertyNameContext) ctx);
		}
		return false;
	}
}