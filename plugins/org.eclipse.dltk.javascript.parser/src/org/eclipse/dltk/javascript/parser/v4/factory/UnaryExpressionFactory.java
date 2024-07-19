package org.eclipse.dltk.javascript.parser.v4.factory;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.dltk.javascript.parser.v4.JSParser.UnaryExpressionContext;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.v4.UnaryOperation;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LHSExprContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PostDecreaseExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PostIncrementExpressionContext;

public class UnaryExpressionFactory extends JSNodeFactory<UnaryExpressionContext> {
	
	private static UnaryExpressionFactory instance = new UnaryExpressionFactory();
	
	private UnaryExpressionFactory() {}
	
	public static UnaryExpressionFactory getInstance() {
		return instance;
	}
	
	@Override
	JSNode createJSNode(UnaryExpressionContext ctx, JSNode parent) {
		boolean isPostfix = false;
		TerminalNode op;
		if (ctx instanceof PostIncrementExpressionContext || ctx instanceof PostDecreaseExpressionContext ) {
			isPostfix = true;
			op = (TerminalNode)ctx.getChild(1);			
		}
		else {
			op = (TerminalNode)ctx.getChild(0);	
		}
		UnaryOperation operation = new UnaryOperation(parent, isPostfix);
		operation.setOperation(op.getSymbol().getType());
		return operation;
	}

	@Override
	boolean skip(UnaryExpressionContext ctx) {
		return ctx instanceof LHSExprContext;
	}
}
