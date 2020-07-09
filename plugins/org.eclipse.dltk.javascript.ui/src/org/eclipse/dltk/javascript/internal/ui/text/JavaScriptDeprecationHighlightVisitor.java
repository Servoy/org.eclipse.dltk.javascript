/*******************************************************************************
 * Copyright (c) 2011 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.internal.ui.text;

import static org.eclipse.dltk.javascript.internal.ui.text.JavascriptColorConstants.JS_DEPRECATED;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.internal.javascript.ti.ITypeInferenceContext;
import org.eclipse.dltk.internal.javascript.ti.JSMethod;
import org.eclipse.dltk.internal.javascript.validation.TypeInfoValidator.ValidationVisitor;
import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.PropertyInitializer;
import org.eclipse.dltk.javascript.core.JavaScriptProblems;
import org.eclipse.dltk.javascript.parser.ISuppressWarningsState;
import org.eclipse.dltk.javascript.parser.JSProblemReporter;
import org.eclipse.dltk.ui.editor.highlighting.ISemanticHighlightingRequestor;

@SuppressWarnings("restriction")
public class JavaScriptDeprecationHighlightVisitor extends ValidationVisitor
		implements JSProblemReporter {

	private final ISemanticHighlightingRequestor requestor;

	public JavaScriptDeprecationHighlightVisitor(ITypeInferenceContext context,
			ISemanticHighlightingRequestor requestor) {
		super(context, null, null);
		reporter = this;
		this.requestor = requestor;
	}

	private static final Set<JavaScriptProblems> DEPRECATION = EnumSet.of(
			JavaScriptProblems.DEPRECATED_FUNCTION,
			JavaScriptProblems.DEPRECATED_METHOD,
			JavaScriptProblems.DEPRECATED_PROPERTY,
			JavaScriptProblems.DEPRECATED_TYPE,
			JavaScriptProblems.DEPRECATED_VARIABLE);

	public void reportProblem(IProblem problem) {
	}

	@Override
	protected JSMethod createMethod(FunctionStatement node) {
		JSMethod method = super.createMethod(node);
		if (method != null && method.isDeprecated()) {
			if (node.getName() != null) {
				requestor.addPosition(node.getName().sourceStart(), node
						.getName()
					.sourceEnd(), JS_DEPRECATED);
			} else if (node.getParent() instanceof BinaryOperation
					&& ((BinaryOperation) node.getParent()).getLeftExpression() instanceof PropertyExpression) {
				PropertyExpression exp = (PropertyExpression) ((BinaryOperation) node
						.getParent()).getLeftExpression();
				requestor.addPosition(exp.getProperty().sourceStart(), exp
						.getProperty().sourceEnd(), JS_DEPRECATED);
			} else if (node.getParent() instanceof PropertyInitializer) {
				Expression name = ((PropertyInitializer) node.getParent())
						.getName();
				requestor.addPosition(name.sourceStart(), name.sourceEnd(),
						JS_DEPRECATED);
			}
		}
		return method;
	}

	public void reportProblem(IProblemIdentifier identifier, String message,
			int start, int end) {
		if (DEPRECATION.contains(identifier)) {
			requestor.addPosition(start, end, JS_DEPRECATED);
		}
	}

	@Override
	public void reportProblem(IProblemIdentifier identifier, String message,
			int start, int end, String... args) {
		reportProblem(identifier, message, start, end);
	}

	public void pushSuppressWarnings(Collection<IProblemIdentifier> suppressed) {
	}

	public void popSuppressWarnings() {
	}

	public ISuppressWarningsState getSuppressWarnings() {
		return null;
	}

	public void restoreSuppressWarnings(ISuppressWarningsState state) {
	}

}
