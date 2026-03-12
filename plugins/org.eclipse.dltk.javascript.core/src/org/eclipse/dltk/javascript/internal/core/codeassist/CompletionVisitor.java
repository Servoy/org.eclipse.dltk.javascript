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
import org.eclipse.dltk.javascript.ast.ForInStatement;
import org.eclipse.dltk.javascript.ast.ForStatement;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.JSScope;
import org.eclipse.dltk.javascript.ast.StatementBlock;
import org.eclipse.dltk.javascript.ast.v4.ForOfStatement;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;

public class CompletionVisitor extends TypeInferencerVisitor {

	private final int position;
	private boolean skipPositionTest = false;

	/**
	 * True while we are visiting the JSScope node whose source range contains
	 * the completion position. This is scoped to that single node via
	 * try/finally in visit(ASTNode).
	 */
	private boolean inScopeThatContainsPosition = false;

	/**
	 * When true, the next context that is left belongs to the scope that
	 * contains the position and should be remembered as the completion
	 * collection.
	 */
	private boolean rememberNextContextOnLeave = false;

	/**
	 * The concrete collection instance that was active when we entered the
	 * scope that contains the completion position. We keep this reference so
	 * that even if the underlying visitor changes its notion of the "current"
	 * collection (for example, having TopValueCollection at index 0 and the
	 * function collection at index 1), we still remember the function
	 * collection we actually want to use for completion.
	 */
	private IValueCollection actualCurrentCollection = null;

	public CompletionVisitor(ITypeInferenceContext context, int position) {
		super(context);
		this.position = position;
	}

	static class Level {
		boolean enabled;
	}

	@Override
	public void enterContext(IValueCollection collection) {
		// If we are entering a value collection while visiting the scope that
		// contains the completion position, then this collection is exactly the
		// one we want to keep when that scope is left (for example, a
		// FunctionValueCollection for a function body).
		if (inScopeThatContainsPosition) {
			rememberNextContextOnLeave = true;
			// Cache the concrete collection instance we are entering. Using this
			// avoids relying on super.getCollection() later, which might already
			// have switched back to TopValueCollection when leaveContext() is
			// invoked.
			actualCurrentCollection = collection;
		}
		super.enterContext(collection);
	}

	@Override
	public IValueCollection leaveContext() {
		// Capture the collection we are about to leave if it is the one flagged
		// in enterContext() while we were visiting the scope that contains the
		// completion position.
		if (rememberNextContextOnLeave && savedCollection == null
				&& actualCurrentCollection != null) {
			// Remember this collection for completion so that even after the
			// context is popped, getCollection() keeps returning the innermost
			// scope that contained the completion position (for example, a
			// function's body when completing on the last empty line before }).
			savedCollection = actualCurrentCollection;
			rememberNextContextOnLeave = false;
			actualCurrentCollection = null;
		}
		return super.leaveContext();
	}

	private Stack<Level> levels = new Stack<Level>();

	private IValueCollection savedCollection = null;

	private PositionReachedException positionReached = null;

	@Override
	public IValueReference visit(ASTNode node) {
		if (node instanceof JSScope) {
			boolean isCorrectScopeType = node instanceof FunctionStatement
					|| node instanceof StatementBlock;
			// Determine if this scope's source range contains the completion
			// position.
			boolean containsPosition = node.sourceStart() <= position
					&& position <= node.sourceEnd()
					&& isCorrectScopeType;

			boolean oldInScope = inScopeThatContainsPosition;
			if (containsPosition) {
				// We are now visiting the scope that actually contains the
				// completion position.
				inScopeThatContainsPosition = true;
			}

			try {
				if (levels.isEmpty() && positionReached == null
						&& node.sourceStart() >= position) {
					// We haven't reached the position yet, and this scope starts
					// at or after the position, so nothing inside will help.
					return null;
				}
				return super.visit(node);
			} finally {
				// Restore previous flag when leaving this scope node so that
				// inScopeThatContainsPosition is only true while we are visiting
				// the JSScope that contains the position.
				inScopeThatContainsPosition = oldInScope;
			}
		}

		final IValueReference result = super.visit(node);
		if (!levels.isEmpty() && levels.peek().enabled) {
			return result;
		}

		if (!skipPositionTest && savedCollection == null && node != null
				&& node.sourceEnd() >= position) {
			// For non-scope nodes we still allow the old early-stop behavior,
			// but only if no collection has been remembered yet. In practice
			// savedCollection will already be set from leaveContext() when
			// completing inside a function body.
			savedCollection = peekContext();
			throw new PositionReachedException(node, result);
		}
		return result;
	}

	@Override
	protected void handleDeclarations(JSScope scope) {
		// don't test position in declarations, because that could be visiting
		// something after the postion your are in
		// that doesn't mean you are already in the scope that you really want
		// to be in.
		skipPositionTest = true;
		try {
			super.handleDeclarations(scope);
		} finally {
			skipPositionTest = false;
		}
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
	public IValueReference visitForInStatement(ForInStatement node) {
		addLevel(node);
		IValueReference result;
		try {
			result = super.visitForInStatement(node);
		} finally {
			levels.pop();
		}
		return result;
	}

	@Override
	public IValueReference visitForStatement(ForStatement node) {
		addLevel(node);
		try {
			return super.visitForStatement(node);
		} finally {
			levels.pop();
		}
	}

	@Override
	public IValueReference visitForOfStatement(ForOfStatement node) {
		addLevel(node);
		try {
			return super.visitForOfStatement(node);
		} finally {
			levels.pop();
		}
	}

	@Override
	public IValueReference visitStatementBlock(StatementBlock node) {
		if (node.getParent() instanceof FunctionStatement) {
			return super.visitStatementBlock(node);
		}
		addLevel(node);
		IValueReference result;
		try {
			result = super.visitStatementBlock(node);
		} finally {
			levels.pop();
		}
		return result;
	}

	private void addLevel(JSNode node) {
		final Level level = new Level();
		level.enabled = node.sourceEnd() < position
				|| node.sourceStart() > position;
		levels.push(level);
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
