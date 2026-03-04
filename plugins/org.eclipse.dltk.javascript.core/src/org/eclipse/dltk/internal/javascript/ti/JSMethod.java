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
import java.util.Objects;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Keyword;
import org.eclipse.dltk.javascript.ast.Method;
import org.eclipse.dltk.javascript.ast.NewExpression;
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
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof JSMethod m) {
			if (m.location != null || this.location != null) {
				return Objects.equals(m.location, this.location);
			}
			if (m.getName().equals(this.getName())) {
				if (m.getParameterCount() == this.getParameterCount()) {
					for (int i = 0; i < this.getParameterCount(); i++) {
						if (!m.getParameters().get(i).getName().equals(
								this.getParameters().get(i).getName())) {
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
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

	public JSMethod(FunctionStatement node, ReferenceSource source) {
		super(node.getArguments().size());
		Identifier nameNode = node.getName();
		if (nameNode == null) {
			// handle assignments or "new function() {}" constructs
			nameNode = extractPropertyIdentifier(node);
		}

		initialize(node, source, nameNode);
	}

	private Identifier extractPropertyIdentifier(JSNode node) {
		JSNode parent = node.getParent();
		// direct assignment (obj.method = function() {})
		if (parent instanceof BinaryOperation bo) {
			Expression left = bo.getLeftExpression();
			if (left instanceof PropertyExpression pe) {
				Expression property = pe.getProperty();
				if (property instanceof Identifier id)
					return id;
			}
		}

		// new function() {} assigned (var X = new function() {...}();)
		if (parent instanceof NewExpression ne
				&& ne.getParent() instanceof VariableDeclaration vd) {
			return vd.getIdentifier();
		}

		return null;
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

	public JSMethod(Method node, ReferenceSource source) {
		super(node.getArguments().size());
		initialize(node, source);
	}

	private void initialize(Method node, ReferenceSource source) {
		setLocation(ReferenceLocation.create(source, node.sourceStart(),
				node.sourceEnd()));
		setName(node.getName());
		addArguments(node.getArguments(), source);
		setDoc(node);
	}

	private void setDoc(JSNode node) {
		Comment documentation = JSDocSupport.getComment(node);
		if (documentation == null) {
			Identifier id = extractPropertyIdentifier(node);
			if (id != null) {
			documentation = id.getDocumentation();
			//doc might be on the parent, like var statement
			if (documentation == null && id.getParent() != null) {
				documentation = id.getParent().getParent().getDocumentation();
			}
			}
		}

		if (documentation != null) {
			setDocRange(documentation.getRange());
		}
	}

	private void addArguments(List<Argument> arguments,
			ReferenceSource source) {
		for (Argument argument : arguments) {
			final IParameter parameter = createParameter();
			parameter.setName(argument.getIdentifier().getName());
			parameter.setLocation(ReferenceLocation.create(source,
					argument.sourceStart(), argument.sourceEnd()));
			if (argument.getEllipsisPosition() > 0) {
				parameter.setKind(ParameterKind.VARARGS);
			}
			if (argument.getDefaultParamValue() != null) {
				parameter.setKind(ParameterKind.OPTIONAL);
			}
			getParameters().add(parameter);
		}
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
			setName(expression);
			addArguments(node.getArguments(), source);
			setDoc(node);
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
			setName(expression);
		}
		addArguments(node.getArguments(), source);
		setDoc(node);
	}

	private void setName(Expression expression) {
		if (expression instanceof Identifier) {
			setName(((Identifier) expression).getName());
		} else {
			setName("<anonymous>");
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
		private String description;

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

		@Override
		public String getDescription() {
			return description;
		}

		@Override
		public void setDescription(String description) {
			this.description = description;

		}

	}
}
