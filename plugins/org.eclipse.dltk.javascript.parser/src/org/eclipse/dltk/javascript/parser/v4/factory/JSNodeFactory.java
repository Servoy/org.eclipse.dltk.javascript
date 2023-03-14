package org.eclipse.dltk.javascript.parser.v4.factory;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.dltk.javascript.ast.JSNode;

public abstract class JSNodeFactory<T extends ParserRuleContext> {
	abstract JSNode createJSNode(T ctx, JSNode parent);
	abstract boolean skip(T ctx);
}
