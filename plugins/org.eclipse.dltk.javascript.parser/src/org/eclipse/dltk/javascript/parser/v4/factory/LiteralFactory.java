package org.eclipse.dltk.javascript.parser.v4.factory;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.dltk.javascript.ast.BooleanLiteral;
import org.eclipse.dltk.javascript.ast.DecimalLiteral;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.NullExpression;
import org.eclipse.dltk.javascript.ast.RegExpLiteral;
import org.eclipse.dltk.javascript.ast.StringLiteral;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.NumericLiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSTransformerListener;

public class LiteralFactory extends JSNodeFactory<LiteralContext> {

	private static LiteralFactory instance = new LiteralFactory();
	
	private LiteralFactory() {}
	
	public static LiteralFactory getInstance() {
		return instance;
	}
	
	@Override
	JSNode createJSNode(LiteralContext ctx, JSNode parent) {
		if (ctx.numericLiteral() != null) {
			NumericLiteralContext numericLiteral = ctx.numericLiteral();
			if (numericLiteral.DecimalLiteral() != null) {				
				DecimalLiteral decimalLiteral = new DecimalLiteral(parent);
				decimalLiteral.setText(JSTransformerListener.intern(ctx.getText()));
				return decimalLiteral;
			}
			//TODO others?
		}
		if (ctx.StringLiteral() != null) {
			StringLiteral stringLiteral = new StringLiteral(parent);
			stringLiteral.setText(JSTransformerListener.intern(ctx.getText()));
			return stringLiteral;
		}
		if (ctx.RegularExpressionLiteral() != null) {
			RegExpLiteral literal = new RegExpLiteral(parent);
			literal.setText(JSTransformerListener.intern(ctx.getText()));
			return literal;
		}
		if (ctx.BooleanLiteral() != null) {
			return new BooleanLiteral(parent, Boolean.parseBoolean(ctx.BooleanLiteral().getSymbol().getText()));
		}
		if (ctx.NullLiteral() != null) {
			return new NullExpression(parent);
		}
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}

	@Override
	boolean skip(ParserRuleContext ctx) {
		return false;
	}

}
