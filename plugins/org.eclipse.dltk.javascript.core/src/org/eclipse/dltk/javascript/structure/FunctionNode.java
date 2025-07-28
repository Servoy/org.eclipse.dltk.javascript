/*******************************************************************************
 * Copyright (c) 2012 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.structure;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.dltk.compiler.IElementRequestor.MethodInfo;
import org.eclipse.dltk.core.ISourceNode;
import org.eclipse.dltk.internal.javascript.parser.JSModifiers;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IMethod;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IParameter;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;

public abstract class FunctionNode extends Scope {

	final FunctionStatement function;
	final IMethod method;
	private String returnType;

	public FunctionNode(IParentNode parent, FunctionStatement function,
			IMethod method) {
		super(parent);
		this.function = function;
		this.method = method;
	}

	public void buildArgumentNodes() {
		for (Argument argument : function.getArguments()) {
			final String name = argument.getArgumentName();
			final IParameter parameter = method.getParameter(name);
			addChild(new ArgumentNode(this, name,
					parameter != null ? parameter.getType() : null,
					ReferenceLocation.create(method.getLocation().getSource(),
							argument.start(), argument.end())));
		}
	}

	public JSType getType() {
		return method.getType();
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public int start() {
		return getNameNode().start();
	}

	protected String argumentsToString() {
		final StringBuilder sb = new StringBuilder();
		for (ArgumentNode argument : getArguments()) {
			if (sb.length() != 0) {
				sb.append(',');
			}
			sb.append(argument.getName());
			if (argument.getType() != null) {
				sb.append(':');
				sb.append(argument.getType().getName());
			}
		}
		return sb.toString();
	}

	protected List<ArgumentNode> getArguments() {
		List<ArgumentNode> result = null;
		for (IStructureNode node : getChildren()) {
			if (node instanceof ArgumentNode) {
				if (result == null) {
					result = new ArrayList<ArgumentNode>(function
							.getArguments().size());
				}
				result.add((ArgumentNode) node);
			}
		}
		return result != null ? result : Collections.<ArgumentNode> emptyList();
	}

	@Override
	public void reportStructure(IStructureRequestor requestor,
			IStructureContext context) {
		final boolean allowed = context.allow(IStructureContext.METHOD);
		if (allowed) {
			final ISourceNode nameNode = getNameNode();
			if (nameNode == null) {
				// If there is no name node, we cannot report the method
				return;
			}
			final MethodInfo info = new MethodInfo();
			info.declarationStart = min(nameNode.start(), function.start());
			info.name = getName();
			if (method.getVisibility() != null) {
				info.modifiers |= method.getVisibility().getFlags();
			}
			if (method.isDeprecated()) {
				info.modifiers |= JSModifiers.DEPRECATED;
			}
			info.nameSourceStart = nameNode.start();
			info.nameSourceEnd = nameNode.end() - 1;
			final List<ArgumentNode> arguments = getArguments();
			if (!arguments.isEmpty()) {
				final int argumentCount = arguments.size();
				info.parameterNames = new String[argumentCount];
				info.parameterTypes = new String[argumentCount];
				for (int i = 0; i < argumentCount; ++i) {
					final ArgumentNode argument = arguments.get(i);
					info.parameterNames[i] = argument.getName();
					info.parameterTypes[i] = typeToModel(argument.getType());
				}
			}
			info.returnType = typeToModel(getType());
			if (info.returnType == null)
				info.returnType = returnType;
			info.isConstructor = method.isConstructor();
			requestor.enterMethod(info, getStructureNameNode(), function,
					method);
		}
		context.pushMask(IStructureContext.FIELD);
		super.reportStructure(requestor, context);
		context.popMask();
		if (allowed) {
			requestor.exitMethod(function.end() - 1);
		}
	}

	protected Expression getStructureNameNode() {
		return function.getName();
	}

	protected abstract String getName();

	public abstract ISourceNode getNameNode();

}
