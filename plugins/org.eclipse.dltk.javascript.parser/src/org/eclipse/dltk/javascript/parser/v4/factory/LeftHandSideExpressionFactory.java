package org.eclipse.dltk.javascript.parser.v4.factory;

import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.GetArrayItemExpression;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.NewExpression;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArgumentsExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LeftHandSideExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MemberDotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MemberExprContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MemberIndexExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.NewExpressionContext;

public class LeftHandSideExpressionFactory extends JSNodeFactory<LeftHandSideExpressionContext> {
	
	private static LeftHandSideExpressionFactory instance = new LeftHandSideExpressionFactory();
	
	private LeftHandSideExpressionFactory() {}
	
	public static LeftHandSideExpressionFactory getInstance() {
		return instance;
	}

	@Override
	JSNode createJSNode(LeftHandSideExpressionContext ctx, JSNode parent) {
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
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}

	@Override
	boolean skip(LeftHandSideExpressionContext ctx) {
		return ctx instanceof MemberExprContext;
	}
}
