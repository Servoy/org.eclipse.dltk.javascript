/*******************************************************************************
 * Copyright (c) 2010 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.javascript.ast.DecimalLiteral;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.StringLiteral;

/**
 * @since 6.0
 */
public class PropertyExpressionUtils {

	public static String getPath(Expression expression) {
		final StringBuilder buffer = new StringBuilder();
		if (buildPath(buffer, expression)) {
			return buffer.toString();
		} else {
			return null;
		}
	}

	public static Identifier getIdentifier(Expression expression) {
		if (expression instanceof Identifier) {
			return (Identifier) expression;
		} else if (expression instanceof PropertyExpression) {
			final PropertyExpression propertyExpression = (PropertyExpression) expression;

			Identifier identifier = getIdentifier(propertyExpression
					.getObject());
			if (identifier != null)
				return identifier;
			return getIdentifier(propertyExpression.getProperty());
		} else if (expression instanceof FunctionStatement) {
			final FunctionStatement functionStatement = (FunctionStatement) expression;
			return getIdentifier(functionStatement.getName());
		}
		return null;
	}

	private static boolean buildPath(StringBuilder buffer, Expression expression) {
		if (expression instanceof Identifier) {
			buffer.append(((Identifier) expression).getName());
			return true;
		} else if (expression instanceof PropertyExpression) {
			final PropertyExpression propertyExpression = (PropertyExpression) expression;
			if (!buildPath(buffer, propertyExpression.getObject()))
				return false;
			buffer.append('.');
			if (!buildPath(buffer, propertyExpression.getProperty()))
				return false;
			return true;
		} else if (expression instanceof FunctionStatement) {
			final FunctionStatement functionStatement = (FunctionStatement) expression;
			if (!buildPath(buffer, functionStatement.getName()))
				return false;
			return true;
		} else {
			return false;
		}
	}

	public static boolean equals(Expression expression,
			String... expressionPath) {
		int endIndex = expressionPath.length;
		if (endIndex <= 0) {
			return false;
		}
		for (;;) {
			--endIndex;
			if (endIndex == 0) {
				return expression instanceof Identifier
						&& expressionPath[endIndex]
								.equals(((Identifier) expression).getName());
			} else if (expression instanceof PropertyExpression) {
				final PropertyExpression pe = (PropertyExpression) expression;
				if (pe.getProperty() instanceof Identifier
						&& expressionPath[endIndex].equals(((Identifier) pe
								.getProperty()).getName())) {
					expression = pe.getObject();
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static List<Identifier> getIdentifiers(PropertyExpression expression) {
		final List<Identifier> identifiers = new ArrayList<Identifier>();
		collectIdentifiers(expression, identifiers);
		return identifiers;
	}

	private static void collectIdentifiers(PropertyExpression expression,
			List<Identifier> identifiers) {
		if (expression.getObject() instanceof PropertyExpression) {
			collectIdentifiers((PropertyExpression) expression.getObject(),
					identifiers);
		} else if (expression.getObject() instanceof Identifier) {
			identifiers.add((Identifier) expression.getObject());
		}
		if (expression.getProperty() instanceof Identifier) {
			identifiers.add((Identifier) expression.getProperty());
		}
	}

	public static String nameOf(Expression name) {
		if (name instanceof Identifier) {
			return ((Identifier) name).getName();
		} else if (name instanceof StringLiteral) {
			return ((StringLiteral) name).getValue();
		} else if (name instanceof DecimalLiteral) {
			return ((DecimalLiteral) name).getText();
		} else {
			return null;
		}
	}

}
