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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.dltk.javascript.core.Types;
import org.eclipse.dltk.javascript.internal.core.RMethod;
import org.eclipse.dltk.javascript.internal.core.RParameter;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinfo.IRMember;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRParameter;
import org.eclipse.dltk.javascript.typeinfo.IRProperty;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRUnionType;
import org.eclipse.dltk.javascript.typeinfo.RUnionType;
import org.eclipse.dltk.javascript.typeinfo.TypeMode;
import org.eclipse.dltk.javascript.typeinfo.model.Method;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;

public class TopValueCollection extends ValueCollection {

	private static final class TopValue extends Value {

		private final ITypeInferenceContext context;

		public TopValue(ITypeInferenceContext context) {
			this.context = context;
		}

		private final Map<String, IValue> memberCache = new HashMap<String, IValue>();

		@Override
		protected IValue findMember(String name, boolean resolve) {
			IValue member = super.findMember(name, resolve);
			if (resolve && member == null) {
				IValue value = memberCache.get(name);
				if (value != null)
					return value;
				final IRMember element = getMember(name);
				if (element != null) {
					value = context.valueOf(element);
					if (value == null) {
						value = ElementValue.createFor(element);
					}
					memberCache.put(name, value);
					return value;
				}
				if (name.equals(IValueReference.ARRAY_OP)) {
					// special case ARRAY_OP is an instance of an Array not
					// the Array type/class itself.
					value = ElementValue
							.createFor(context.convert(Types.ARRAY));
					memberCache.put(name, value);
					return value;
				}
				final Type type = context.getKnownType(name, TypeMode.CODE);
				if (type != null && type.getKind() != TypeKind.UNKNOWN) {
					value = ElementValue.createClass(context, type);
					memberCache.put(name, value);
					return value;
				}
				if ("Packages".equals(name)) {
					value = new PackagesValue(context);
					memberCache.put(name, value);
					return value;
				}
				if (name.startsWith("Packages.")) {
					value = new PackageOrClassValue(name.substring("Packages."
							.length()), context);
					memberCache.put(name, value);
					return value;
				}
				if ("java".equals(name) || name.startsWith("java.")) {
					value = new PackageOrClassValue(name, context);
					memberCache.put(name, value);
					return value;
				}
			}
			return member;
		}

		private IRMember getMember(String name) {
			Set<IRMember> elements = context.resolveAll(name);
			if (elements != null && !elements.isEmpty()) {
				if (elements.size() == 1
						|| !elements.isEmpty() && elements.iterator()
								.next() instanceof IRProperty) {
					return elements.iterator().next();
				} else {
					List<IRParameter> parameters = new ArrayList<IRParameter>();
					IRMethod method = null;
					int minParams = 0;
					for (IRMember element : elements) {
						if (element != null && element instanceof IRMethod) {
							IRMethod currentMethod = (IRMethod) element;
							if (method == null) {
								// the set of elements is ordered asc by the
								// params count
								// if the number of params exceeds minParams,
								// the kind of the param is optional
								minParams = currentMethod.getParameterCount();
								method = currentMethod;
							} else if (!currentMethod.isDeprecated()) {
								method = currentMethod;
							}
							mergeParameters(parameters, minParams,
									currentMethod);
						}
					}
					return new RMethod((Method) method.getSource(),
							method.getType(), parameters,
							method.getDeclaringType());
				}
			}
			return null;
		}

		private void mergeParameters(List<IRParameter> parameters,
				int minParams, IRMethod currentMethod) {
			for (int i = 0; i < currentMethod
					.getParameterCount(); i++) {
				IRParameter param = currentMethod.getParameters()
						.get(i);
				ParameterKind kind = i >= minParams
						? ParameterKind.OPTIONAL
						: param.getKind();
				if (parameters.size() == i) {
					IRParameter newParam = new RParameter(
							param.getName(), param.getType(),
							kind);
					parameters.add(newParam);
				}
				else {
					IRParameter p = parameters.get(i);
					if (!p.getType()
							.equals(param.getType())) {
						List<IRType> types = new ArrayList<IRType>();
						if (p.getType() instanceof IRUnionType) {
							types.addAll(((IRUnionType) p.getType())
											.getTargets());
						} 
						else
						{
							types.add(p.getType());
						}
						types.add(param.getType());
						IRParameter mergedParam = new RParameter(
								param.getName(), new RUnionType(types),
								kind);
						parameters.set(i, mergedParam);
					}
				}
			}
		}

		@Override
		protected void childCreated(String name) {
			super.childCreated(name);
			memberCache.remove(name);
		}
	}

	public boolean isScope() {
		return true;
	}

	/**
	 * @param parent
	 */
	public TopValueCollection(final ITypeInferenceContext context) {
		super(null, new TopValue(context));
		this.thisValue = new TopValueThis(this);

		IValueCollection topValueCollection = context.getTopValueCollection();
		if (topValueCollection instanceof IValueProvider) {
			getValue().addValue(
					((IValueProvider) topValueCollection).getValue());
		}
	}

	private final TopValueThis thisValue;

	@Override
	public IValueReference getThis() {
		return thisValue;
	}

}
