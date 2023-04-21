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
package org.eclipse.dltk.internal.javascript.ti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.Keyword;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.PropertyInitializer;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.parser.PropertyExpressionUtils;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IMethod;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IParameter;
import org.eclipse.dltk.javascript.typeinfo.ReferenceSource;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.dltk.javascript.typeinfo.model.Visibility;

@SuppressWarnings("serial")
public class JSMethod extends ArrayList<IParameter> implements IMethod {

	private String name;
	private JSType type;
	private boolean deprecated;
	private Visibility visibility;
	private boolean constructor;
	private ReferenceLocation location = ReferenceLocation.UNKNOWN;
	private ISourceRange docRange;
	private JSType thisType;
	private JSType extendsType;

	public IParameter createParameter() {
		return new Parameter();
	}

	public String getName() {
		return name;
	}

	public List<IParameter> getParameters() {
		return this;
	}

	public int getParameterCount() {
		return size();
	}

	public IParameter getParameter(String name) {
		if (name != null) {
			for (IParameter parameter : this) {
				if (name.equals(parameter.getName())) {
					return parameter;
				}
			}
		}
		return null;
	}

	public JSType getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(JSType type) {
		this.type = type;
	}

	public ReferenceLocation getLocation() {
		return location;
	}

	public void setLocation(ReferenceLocation location) {
		this.location = location;
	}

	public boolean isDeprecated() {
		return deprecated;
	}

	public void setDeprecated(boolean deprecated) {
		this.deprecated = deprecated;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public boolean isConstructor() {
		return constructor;
	}

	public void setConstructor(boolean constructor) {
		this.constructor = constructor;
	}

	public ISourceRange getDocRange() {
		return docRange;
	}

	public void setDocRange(ISourceRange docRange) {
		this.docRange = docRange;
	}

	public JSType getThisType() {
		return this.thisType;
	}

	public void setThisType(JSType thisType) {
		this.thisType = thisType;
	}

	public JSType getExtendsType() {
		return this.extendsType;
	}

	public void setExtendsType(JSType extendsType) {
		this.extendsType = extendsType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append('(');
		boolean first = true;
		if (thisType != null) {
			sb.append("this:").append(thisType);
			first = false;
		}
		for (IParameter parameter : this) {
			if (!first) {
				sb.append(',');
			}
			first = false;
			sb.append(parameter);
		}
		sb.append(')');
		if (type != null) {
			sb.append(':').append(type);
		}
		return sb.toString();
	}

	public JSMethod() {
		super(4);
	}

	/**
	 * @param node
	 * @param source
	 * @return
	 */
	public JSMethod(FunctionStatement node, ReferenceSource source) {
		super(node.getArguments().size());
		Identifier nameNode = node.getName();
		if (nameNode == null && node.getParent() instanceof BinaryOperation) {
			Expression left = ((BinaryOperation) node.getParent())
					.getLeftExpression();
			if (left instanceof PropertyExpression) {
				Expression property = ((PropertyExpression) left).getProperty();
				if (property instanceof Identifier)
					nameNode = (Identifier) property;
			}
		}
		initialize(node, source, nameNode);
	}

	public JSMethod(FunctionStatement node, ReferenceSource source,
			Expression name) {
		super(node.getArguments().size());
		initialize(node, source, name);
	}

	public JSMethod(ArrowFunctionStatement node, ReferenceSource source) {
		super(node.getArguments().size());
		initialize(node, source);
	}

	private void initialize(ArrowFunctionStatement node,
			ReferenceSource source) {
			setLocation(ReferenceLocation.create(source, node.sourceStart(),
					node.sourceEnd()));
			Expression expression = null;
			if (node.getParent() instanceof BinaryOperation) {
				expression = ((BinaryOperation) node.getParent())
						.getLeftExpression();
				while (expression != null
						&& !(expression instanceof Identifier)) {
					if (expression instanceof PropertyExpression) {
						expression = ((PropertyExpression) expression)
								.getProperty();
					} else
						expression = null;
				}
			} else if (node.getParent() instanceof PropertyInitializer) {
				expression = ((PropertyInitializer) node.getParent()).getName();
			} else if (node.getParent() instanceof VariableDeclaration) {
				expression = ((VariableDeclaration) node.getParent())
						.getIdentifier();
			}
			if (expression instanceof Identifier) {
				setName(((Identifier) expression).getName());
			} else {
				setName("<anonymous>");
			}
		for (Argument argument : node.getArguments()) {
			final IParameter parameter = createParameter();
			parameter.setName(argument.getIdentifier().getName());
			parameter.setLocation(ReferenceLocation.create(source,
					argument.sourceStart(), argument.sourceEnd()));
			getParameters().add(parameter);
		}
		final Comment documentation = JSDocSupport.getComment(node);
		if (documentation != null) {
			setDocRange(documentation.getRange());
		}
	}

	protected void initialize(FunctionStatement node, ReferenceSource source,
			Expression methodName) {
		if (methodName != null) {
			setName(PropertyExpressionUtils.nameOf(methodName));
			setLocation(ReferenceLocation.create(source, node.sourceStart(),
					node.sourceEnd(), methodName.sourceStart(),
					methodName.sourceEnd()));
		} else {
			final Keyword kw = node.getFunctionKeyword();
			setLocation(ReferenceLocation.create(source, node.sourceStart(),
					node.sourceEnd(), kw.sourceStart(), kw.sourceEnd()));
			Expression expression = null;
			if (node.getParent() instanceof BinaryOperation) {
				expression = ((BinaryOperation) node.getParent())
						.getLeftExpression();
				while (expression != null
						&& !(expression instanceof Identifier)) {
					if (expression instanceof PropertyExpression) {
						expression = ((PropertyExpression) expression)
								.getProperty();
					} else
						expression = null;
				}
			} else if (node.getParent() instanceof PropertyInitializer) {
				expression = ((PropertyInitializer) node.getParent()).getName();
			} else if (node.getParent() instanceof VariableDeclaration) {
				expression = ((VariableDeclaration) node.getParent())
						.getIdentifier();
			}
			if (expression instanceof Identifier) {
				setName(((Identifier) expression).getName());
			} else {
				setName("<anonymous>");
			}
		}
		for (Argument argument : node.getArguments()) {
			final IParameter parameter = createParameter();
			parameter.setName(argument.getIdentifier().getName());
			parameter.setLocation(ReferenceLocation.create(source,
					argument.sourceStart(), argument.sourceEnd()));
			getParameters().add(parameter);
		}
		final Comment documentation = JSDocSupport.getComment(node);
		if (documentation != null) {
			setDocRange(documentation.getRange());
		}
	}

	private Set<IProblemCategory> suppressedWarnings = null;

	public Set<IProblemCategory> getSuppressedWarnings() {
		return suppressedWarnings != null ? suppressedWarnings : Collections
				.<IProblemCategory> emptySet();
	}

	public void addSuppressedWarning(IProblemCategory warningCategoryId) {
		if (suppressedWarnings == null) {
			suppressedWarnings = new HashSet<IProblemCategory>();
		}
		suppressedWarnings.add(warningCategoryId);
	}

	public static class Parameter extends JSElement implements IParameter {

		private ParameterKind kind = ParameterKind.NORMAL;

		public boolean isOptional() {
			return kind == ParameterKind.OPTIONAL;
		}

		public boolean isVarargs() {
			return kind == ParameterKind.VARARGS;
		}

		public ParameterKind getKind() {
			return kind;
		}

		public void setKind(ParameterKind kind) {
			this.kind = kind;
		}

		@Override
		public String toString() {
			return getType() != null ? getName() + ':' + getType().getName()
					: getName();
		}

	}
}
