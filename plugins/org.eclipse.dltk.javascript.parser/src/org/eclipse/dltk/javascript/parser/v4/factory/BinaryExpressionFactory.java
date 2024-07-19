package org.eclipse.dltk.javascript.parser.v4.factory;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.v4.BinaryOperation;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BinaryExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.UnaryExpContext;

public class BinaryExpressionFactory extends JSNodeFactory<BinaryExpressionContext> {
	
	private static BinaryExpressionFactory instance = new BinaryExpressionFactory();
	
	private BinaryExpressionFactory() {}
	
	public static BinaryExpressionFactory getInstance() {
		return instance;
	}

	@Override
	JSNode createJSNode(BinaryExpressionContext ctx, JSNode parent) {
		Assert.isNotNull(ctx.getChild(0));
		Assert.isNotNull(ctx.getChild(1));

		BinaryOperation operation = new BinaryOperation(parent);
		if (ctx.getChild(1) instanceof TerminalNode) {
			operation.setOperation(((TerminalNode) ctx.getChild(1)).getSymbol().getType());
		}
		return operation;
	}

	@Override
	boolean skip(BinaryExpressionContext ctx) {
		return ctx instanceof UnaryExpContext;
	}
}
