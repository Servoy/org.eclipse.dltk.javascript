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

import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.internal.javascript.ti.ITypeInferenceContext;
import org.eclipse.dltk.internal.javascript.ti.PositionReachedException;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencerVisitor;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.VariableBinding;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;

public class SelectionVisitor extends TypeInferencerVisitor {

	private final ASTNode target;
	private IValueReference value;
	private IValueReference[] arguments;

	public SelectionVisitor(ITypeInferenceContext context, ASTNode target) {
		super(context);
		this.target = target;
	}

	public IValueReference getValue() {
		return value;
	}

	public IValueReference[] getArguments() {
		return arguments;
	}

	@Override
	public IValueReference visit(ASTNode node) {
		final IValueReference result = super.visit(node);
		if (node == target) {
			value = result;
			earlyExit();
		}
		return result;
	}

	@Override
	public IValueReference visitCallExpression(CallExpression node) {
		try {
			return super.visitCallExpression(node);
		} catch(PositionReachedException e) {
			List<ASTNode> args = node.getArguments();
			final IValueReference[] arguments = new IValueReference[args.size()];
			for (int i = 0; i < args.size(); ++i) {
				arguments[i] = visit(args.get(i));
			}
			this.arguments = arguments;
			throw e;
		}
	}


	@Override
	protected IValueReference extractNamedChild(IValueReference parent,
			Expression name) {
		final IValueReference result = super.extractNamedChild(parent, name);
		if (name == target) {
			value = result;
			earlyExit();
		}
		return result;
	}

	private IValueReference check(Identifier node, IValueReference reference) {
		if (node == target) {
			value = reference;
			earlyExit();
		}
		return reference;
	}

	@Override
	public void visitFunctionBody(FunctionStatement node) {
		for (Argument argument : node.getArguments()) {
			check(argument.getIdentifier(),
					peekContext().getChild(argument.getArgumentName()));
		}
		super.visitFunctionBody(node);
	}

	@Override
	public void visitArrowFunctionBody(ArrowFunctionStatement node) {
		for (Argument argument : node.getArguments()) {
			check(argument.getIdentifier(),
					peekContext().getChild(argument.getArgumentName()));
		}
		super.visitArrowFunctionBody(node);
	}

	@Override
	protected IValueReference createVariable(
			IValueCollection context, VariableBinding declaration,
			Identifier identifier) {
		IValueReference variable = super.createVariable(context, declaration,
				identifier);
		return variable;
		// if (declaration.getInitializer(identifier.getName()) != null) {
		// try {
		// IValueReference visit = visit(
		// declaration.getInitializer(identifier.getName()));
		// assign(variable, visit);
		// } catch (PositionReachedException e) {
		// // ignore this one else it exits to early
		// }
		// }
		// return check(identifier, variable);
	}

	@Override
	protected void initializeVariable(IValueReference reference,
			VariableBinding declaration) {
		super.initializeVariable(reference, declaration);

		check(declaration.getIdentifier(), reference);
	}

	@Override
	public IValueReference visitFunctionStatement(FunctionStatement node) {
		IValueReference fs = super.visitFunctionStatement(node);
		if (node.getName() != null)
			visit(node.getName());
		return fs;

	}

	private void earlyExit() {
		if (value == null || value.getKind() != ReferenceKind.UNKNOWN) {
			throw new PositionReachedException(target, value);
		}
	}

}
