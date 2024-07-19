package org.eclipse.dltk.javascript.parser.v4.factory;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BinaryExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LeftHandSideExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PrimaryExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PropertyNameContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.StatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.UnaryExpressionContext;

public class JSNodeCreator {

	public static JSNode create(ParserRuleContext ctx, JSNode parent) {
		if (ctx.getClass().isAssignableFrom(StatementContext.class)) {
			return StatementFactory.getInstance().createJSNode((StatementContext) ctx, parent);
		}
		if (AssignmentExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return ExpressionFactory.getInstance().createJSNode((AssignmentExpressionContext) ctx, parent);
		}
		if (ctx.getClass().isAssignableFrom(LiteralContext.class)) {
			return LiteralFactory.getInstance().createJSNode((LiteralContext) ctx, parent);
		}
		if (ctx.getClass().isAssignableFrom(PropertyNameContext.class)) {
			return PropertyNameFactory.getInstance().createJSNode((PropertyNameContext) ctx, parent);
		}
		if (BinaryExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return BinaryExpressionFactory.getInstance().createJSNode((BinaryExpressionContext) ctx, parent);
		}
		if (UnaryExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return UnaryExpressionFactory.getInstance().createJSNode((UnaryExpressionContext) ctx, parent);
		}
		if (PrimaryExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return PrimaryExpressionFactory.getInstance().createJSNode((PrimaryExpressionContext) ctx, parent);
		}
		if (LeftHandSideExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return LeftHandSideExpressionFactory.getInstance().createJSNode((LeftHandSideExpressionContext) ctx, parent);
		}
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}
	
	public static boolean skipCreate(ParserRuleContext ctx) {
		if (ctx.getClass().isAssignableFrom(StatementContext.class)) {
			return StatementFactory.getInstance().skip((StatementContext) ctx);
		}
		if (AssignmentExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return ExpressionFactory.getInstance().skip((AssignmentExpressionContext) ctx);
		}
		if (ctx.getClass().isAssignableFrom(LiteralContext.class)) {
			return LiteralFactory.getInstance().skip((LiteralContext) ctx);
		}
		if (ctx.getClass().isAssignableFrom(PropertyNameContext.class)) {
			return PropertyNameFactory.getInstance().skip((PropertyNameContext) ctx);
		}
		if (BinaryExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return BinaryExpressionFactory.getInstance().skip((BinaryExpressionContext) ctx);
		}
		if (UnaryExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return UnaryExpressionFactory.getInstance().skip((UnaryExpressionContext) ctx);
		}
		if (PrimaryExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return PrimaryExpressionFactory.getInstance().skip((PrimaryExpressionContext) ctx);
		}
		if (LeftHandSideExpressionContext.class.isAssignableFrom(ctx.getClass())) {
			return LeftHandSideExpressionFactory.getInstance().skip((LeftHandSideExpressionContext) ctx);
		}
		return false;
	}
}