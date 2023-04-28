package org.eclipse.dltk.javascript.parser.v4.factory;

import org.eclipse.dltk.javascript.ast.BooleanLiteral;
import org.eclipse.dltk.javascript.ast.DecimalLiteral;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.NullExpression;
import org.eclipse.dltk.javascript.ast.RegExpLiteral;
import org.eclipse.dltk.javascript.ast.StringLiteral;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringLiteral;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSTransformer;

public class LiteralFactory extends JSNodeFactory<LiteralContext> {

	private static LiteralFactory instance = new LiteralFactory();
	
	private LiteralFactory() {}
	
	public static LiteralFactory getInstance() {
		return instance;
	}
	
	@Override
	JSNode createJSNode(LiteralContext ctx, JSNode parent) {
		if (ctx.numericLiteral() != null) {	
			DecimalLiteral decimalLiteral = new DecimalLiteral(parent);
			decimalLiteral.setText(JSTransformer.intern(ctx.getText()));
			return decimalLiteral;
		}
		if (ctx.StringLiteral() != null) {
			StringLiteral stringLiteral = new StringLiteral(parent);
			stringLiteral.setText(JSTransformer.intern(ctx.getText()));
			return stringLiteral;
		}
		if (ctx.RegularExpressionLiteral() != null) {
			RegExpLiteral literal = new RegExpLiteral(parent);
			literal.setText(JSTransformer.intern(ctx.getText()));
			return literal;
		}
		if (ctx.BooleanLiteral() != null) {
			return new BooleanLiteral(parent, Boolean.parseBoolean(ctx.BooleanLiteral().getSymbol().getText()));
		}
		if (ctx.NullLiteral() != null) {
			return new NullExpression(parent);
		}
		if (ctx.templateStringLiteral() != null) {
			TemplateStringLiteral templateStringLiteral = new TemplateStringLiteral(parent);
			templateStringLiteral.setText(JSTransformer.intern(ctx.getText()));
			return templateStringLiteral;
		}
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}

	@Override
	boolean skip(LiteralContext ctx) {
		return false;
	}
}
