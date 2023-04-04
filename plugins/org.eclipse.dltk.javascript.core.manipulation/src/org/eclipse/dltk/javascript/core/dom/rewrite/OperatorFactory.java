package org.eclipse.dltk.javascript.core.dom.rewrite;

import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.UnaryOperation;
import org.eclipse.dltk.javascript.core.dom.BinaryOperator;
import org.eclipse.dltk.javascript.core.dom.UnaryOperator;
import org.eclipse.dltk.javascript.parser.JavascriptParserPreferences;

public class OperatorFactory {

	public static BinaryOperator getBinaryOperator(BinaryOperation node) {
		boolean antlr4Parser = new JavascriptParserPreferences().useES6Parser();
		return antlr4Parser ? new OperatorFactoryV4().createBinaryOperator(node) : new OperatorFactoryV3().createBinaryOperator(node);
	}

	public static UnaryOperator getUnaryOperator(UnaryOperation node) {
		boolean antlr4Parser = new JavascriptParserPreferences().useES6Parser();
		return antlr4Parser ? new OperatorFactoryV4().createUnaryOperator(node) : new OperatorFactoryV3().createUnaryOperator(node);
	}
}
