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
package org.eclipse.dltk.javascript.internal.core.codeassist;

import java.util.Stack;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.internal.javascript.ti.ITypeInferenceContext;
import org.eclipse.dltk.internal.javascript.ti.PositionReachedException;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencerVisitor;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.StatementBlock;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;

public class CompletionVisitor extends TypeInferencerVisitor {

	private final int position;

	public CompletionVisitor(ITypeInferenceContext context, int position) {
		super(context);
		this.position = position;
	}

	static class Level {
		boolean enabled;
	}

	private Stack<Level> levels = new Stack<Level>();

	private IValueCollection savedCollection = null;

	private PositionReachedException positionReached = null;

	@Override
	public IValueReference visit(ASTNode node) {
		if (node instanceof FunctionStatement
				|| node instanceof StatementBlock) {
			if (levels.isEmpty() && positionReached == null
					&& node.sourceStart() >= position) {
				return null;
			}
			return super.visit(node);
		}
		final IValueReference result = super.visit(node);
		if (!levels.isEmpty() && levels.peek().enabled) {
			return result;
		}

		if (savedCollection == null && node != null
				&& node.sourceEnd() >= position) {
			savedCollection = peekContext();
			throw new PositionReachedException(node, result);
		}
		return result;
	}

	@Override
	public IValueReference visitFunctionStatement(FunctionStatement node) {
		final Level level = new Level();
		level.enabled = node.sourceEnd() < position
				|| node.sourceStart() > position;
		levels.push(level);
		IValueReference result;
		try {
			result = super.visitFunctionStatement(node);
		} finally {
			levels.pop();
		}
		return result;
	}

	@Override
	public IValueReference visitStatementBlock(StatementBlock node) {
		if (node.getParent() instanceof FunctionStatement) {
			return super.visitStatementBlock(node);
		}
		final Level level = new Level();
		level.enabled = node.sourceEnd() < position
				|| node.sourceStart() > position;
		levels.push(level);
		IValueReference result;
		try {
			result = super.visitStatementBlock(node);
		} finally {
			levels.pop();
		}
		return result;
	}

	@Override
	public void visitFunctionBody(FunctionStatement node) {
		try {
			super.visitFunctionBody(node);
		} catch (PositionReachedException e) {
			positionReached = e;
		}
	}

	@Override
	public IValueCollection getCollection() {
		if (savedCollection != null) {
			return savedCollection;
		}
		return super.getCollection();
	}

}
