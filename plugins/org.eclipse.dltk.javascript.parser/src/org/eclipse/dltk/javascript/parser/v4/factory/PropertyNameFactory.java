package org.eclipse.dltk.javascript.parser.v4.factory;

import org.eclipse.dltk.javascript.ast.DecimalLiteral;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.StringLiteral;
import org.eclipse.dltk.javascript.parser.v4.JSTransformer;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PropertyNameContext;

public class PropertyNameFactory extends JSNodeFactory<PropertyNameContext> {

	private static PropertyNameFactory instance = new PropertyNameFactory();
	
	private PropertyNameFactory() {}
	
	public static PropertyNameFactory getInstance() {
		return instance;
	}

	@Override
	JSNode createJSNode(PropertyNameContext ctx, JSNode parent) {
		if (ctx.StringLiteral() != null) {
			StringLiteral stringLiteral = new StringLiteral(parent);
			stringLiteral.setText(JSTransformer.intern(ctx.getText()));
			return stringLiteral;
		}
		if (ctx.numericLiteral() != null) {
			DecimalLiteral decimalLiteral = new DecimalLiteral(parent);
			decimalLiteral.setText(JSTransformer.intern(ctx.getText()));
			return decimalLiteral;
		}
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}

	@Override
	boolean skip(PropertyNameContext ctx) {
		return ctx.identifierName() != null || ctx.OpenBracket() != null;
	}
}
