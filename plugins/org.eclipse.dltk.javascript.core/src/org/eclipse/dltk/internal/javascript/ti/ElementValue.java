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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.internal.javascript.validation.ValidationMessages;
import org.eclipse.dltk.javascript.core.JavaScriptProblems;
import org.eclipse.dltk.javascript.core.Types;
import org.eclipse.dltk.javascript.typeinference.IAssignProtection;
import org.eclipse.dltk.javascript.typeinference.ILocationProvider;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IMemberEvaluator;
import org.eclipse.dltk.javascript.typeinfo.IRArrayType;
import org.eclipse.dltk.javascript.typeinfo.IRClassType;
import org.eclipse.dltk.javascript.typeinfo.IRElement;
import org.eclipse.dltk.javascript.typeinfo.IRFunctionType;
import org.eclipse.dltk.javascript.typeinfo.IRLocalType;
import org.eclipse.dltk.javascript.typeinfo.IRMapType;
import org.eclipse.dltk.javascript.typeinfo.IRMember;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRProperty;
import org.eclipse.dltk.javascript.typeinfo.IRRecordMember;
import org.eclipse.dltk.javascript.typeinfo.IRRecordType;
import org.eclipse.dltk.javascript.typeinfo.IRSimpleType;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.IRUnionType;
import org.eclipse.dltk.javascript.typeinfo.ITypeInfoContext;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.JSTypeSet;
import org.eclipse.dltk.javascript.typeinfo.MemberPredicate;
import org.eclipse.dltk.javascript.typeinfo.MemberPredicates;
import org.eclipse.dltk.javascript.typeinfo.RSimpleType;
import org.eclipse.dltk.javascript.typeinfo.RTypeMemberQuery;
import org.eclipse.dltk.javascript.typeinfo.RTypes;
import org.eclipse.dltk.javascript.typeinfo.TypeInfoManager;
import org.eclipse.dltk.javascript.typeinfo.TypeUtil;
import org.eclipse.dltk.javascript.typeinfo.model.Element;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;

public abstract class ElementValue implements IValue {

	public static IValue findMember(ITypeSystem context, IRType type,
			String name) {
		return findMember(context, type, name, MemberPredicates.ALWAYS_TRUE);
	}

	private static class PrototypeType extends RSimpleType {
		public PrototypeType(ITypeSystem typeSystem,
				IRTypeDeclaration declaration) {
			super(typeSystem, declaration);
		}

		public PrototypeType(ITypeSystem typeSystem, Type type) {
			super(typeSystem, type);
		}

		@Override
		public String getName() {
			return "prototype<" + getTarget().getName() + ">";
		}

		@Override
		public boolean isExtensible() {
			return true;
		}
	}

	static IValue findMemberA(ITypeSystem context, IRType type,
 String name,
			boolean resolve) {
		final MemberPredicate predicate;
		if (type instanceof IRClassType) {
			final Type target = ((IRClassType) type).getTarget();
			predicate = target != null ? target.memberPredicateFor(type,
					MemberPredicates.STATIC) : MemberPredicates.STATIC;
		} else if (type instanceof IRSimpleType) {
			final Type target = ((IRSimpleType) type).getTarget();
			predicate = target != null ? target.memberPredicateFor(type,
					MemberPredicates.NON_STATIC) : MemberPredicates.NON_STATIC;
		} else if (type instanceof IRUnionType) {
			// TODO (alex) use different predicate for each option
			predicate = MemberPredicates.ALWAYS_TRUE;
		} else {
			predicate = MemberPredicates.NON_STATIC;
		}
		return findMember(context, type, name, predicate, resolve);
	}

	public static IValue findMember(ITypeSystem context, IRType type,
			String name, MemberPredicate predicate) {
		return findMember(context, type, name, predicate, true);
	}

	public static IValue findMember(ITypeSystem context, IRType type,
			String name, MemberPredicate predicate, boolean resolve) {
		if (type != null) {
			final ITypeSystem saved = type.activeTypeSystem();
			if (saved != null) {
				context = saved;
			}
		}
		if (IValueReference.ARRAY_OP.equals(name)) {
			IRType arrayType = TypeUtil.extractArrayItemType(type);
			// only give back this a a TypeValue if it is a known and not a
			// NoneType
			if (arrayType != null
					&& TypeUtil.kind(arrayType) != TypeKind.UNKNOWN
					&& arrayType != RTypes.none()
					&& arrayType != RTypes.arrayOf().getItemType()) {
				return new TypeValue(context, arrayType);
			}
		}
		if (type instanceof IRClassType) {
			final IRTypeDeclaration t = ((IRClassType) type).getDeclaration();
			if (t != null) {
				final List<IRMember> selection = findMembers(t, name, predicate);
				if (!selection.isEmpty()) {
					if (selection.size() == 1) {
						return createElement(context, t, selection.get(0));
					}
					return new MemberValue(context,
							selection.toArray(new IRMember[selection.size()]));
				}
			}
			if ((t == null || t.getSource().hasPrototype())
					&& predicate.isCompatibleWith(MemberPredicates.STATIC)) {
				final List<IRMember> selection = findMembers(
						context.convert(t != null ? t.getSource()
								.getPrototypeType() : Types.FUNCTION), name,
						MemberPredicates.NON_STATIC);
				if (!selection.isEmpty()) {
					if (selection.size() == 1) {
						final IRMember selected = selection.get(0);
						if ("prototype".equals(selected.getName())
								&& selected instanceof IRProperty) {
							if (t != null) {
								return new PrototypePropertyValue(context,
										(IRProperty) selected,
										new PrototypeType(context, t));
							} else {
								return new PrototypePropertyValue(context,
										(IRProperty) selected,
										new PrototypeType(context,
												RTypes.OBJECT.getDeclaration()));
							}
						}
						return createElement(context,
								RTypes.FUNCTION.getDeclaration(), selected);
					}
					return new MemberValue(context,
							selection.toArray(new IRMember[selection.size()]));
				}
			}
		} else if (type instanceof IRUnionType) {
			for (IRType unionTarget : ((IRUnionType) type).getTargets()) {
				IValue member = findMember(context, unionTarget, name,
						predicate);
				if (member != null)
					return member;
			}
		} else if (type instanceof IRRecordType) {
			final IRRecordMember member = ((IRRecordType) type).getMember(name);
			if (member != null) {
				return new RTypeValue(context, member.getType(), member);
			}
			return findMember(context, RTypes.OBJECT, name);
		} else if (type instanceof IRFunctionType) {
			if (FunctionMethod.apply.test(name)) {
				return getFunctionMethod(context, (IRFunctionType) type,
						FunctionMethod.apply);
			} else if (FunctionMethod.call.test(name)) {
				return getFunctionMethod(context, (IRFunctionType) type,
						FunctionMethod.call);
			} else {
				final IRTypeDeclaration function = RTypes.FUNCTION
						.getDeclaration();
				final List<IRMember> selection = findMembers(function, name,
						predicate);
				if (!selection.isEmpty()) {
					if (selection.size() == 1) {
						return createElement(context, function,
								selection.get(0));
					}
					return new MemberValue(context,
							selection.toArray(new IRMember[selection.size()]));
				}
			}
		} else if (type instanceof IRLocalType) {
			IValue value = ((IValueProvider) ((IRLocalType) type).getValue().getChild(
					name)).getValue();
			if (value != null)
				return value;
			return findMember(context, RTypes.OBJECT, name);
		} else {
			final IRTypeDeclaration t = TypeUtil.extractType(context, type);
			if (t != null) {
				final List<IRMember> selection = findMembers(t, name, predicate);
				if (!selection.isEmpty()) {
					if (selection.size() == 1) {
						return createElement(context, t, selection.get(0));
					}
					return new MemberValue(context,
							selection.toArray(new IRMember[selection.size()]));
				} else if (resolve && type instanceof IRSimpleType
						&& context instanceof ITypeInfoContext) {
					Type target = ((IRSimpleType) type).getTarget();
					for (IMemberEvaluator evaluator : TypeInfoManager
							.getMemberEvaluators()) {
						final IValueCollection collection = evaluator.valueOf(
								(ITypeInfoContext) context, target);
						if (collection != null) {
							if (collection instanceof IValueProvider) {
								IValueReference child = collection
										.getChild(name);
								if (child instanceof IValueProvider) {
									return ((IValueProvider) child).getValue();
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	private static ElementValue getFunctionMethod(ITypeSystem context,
			IRFunctionType type, FunctionMethod method) {
		if (context != null) {
			final FunctionMethodKey key = new FunctionMethodKey(type, method);
			ElementValue value = (ElementValue) context.getValue(key);
			if (value == null) {
				value = new FunctionTypeMethodValue(context, type, method);
				context.setValue(key, value);
			}
			return value;
		} else {
			return new FunctionTypeMethodValue(context, type, method);
		}
	}

	private static class FunctionMethodKey {
		private final IRFunctionType type;
		private final FunctionMethod method;

		public FunctionMethodKey(IRFunctionType type, FunctionMethod method) {
			this.type = type;
			this.method = method;
		}

		@Override
		public int hashCode() {
			return type.hashCode() ^ method.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof FunctionMethodKey) {
				final FunctionMethodKey other = (FunctionMethodKey) obj;
				return type.equals(other.type) && method == other.method;
			}
			return false;
		}
	}

	private static ElementValue createElement(ITypeSystem context,
			final IRTypeDeclaration type, final IRMember member) {
		if (member instanceof IRProperty) {
			if (TypeSystemImpl.isContextualizable(member.getType())) {
				return new PropertyValue(context, context.contextualize(
						(IRProperty) member, type));
			} else {
				return new PropertyValue(context, (IRProperty) member);
			}
		} else if (member instanceof IRMethod) {
			if (TypeSystemImpl.isContextualizable(member.getType())) {
				return new MethodValue(context, context.contextualize(
						(IRMethod) member, type));
			} else {
				return new MethodValue(context, (IRMethod) member);
			}
		} else {
			return null;
		}
	}

	public static List<IRMember> findMembers(IRTypeDeclaration type,
			String name, MemberPredicate predicate) {
		final List<IRMember> selection = new ArrayList<IRMember>(4);
		for (IRMember member : new RTypeMemberQuery(type, predicate)
				.ignoreDuplicates()) {
			if (name.equals(member.getName())) {
				selection.add(member);
			}
		}
		return selection;
	}

	public static ElementValue createFor(IRElement element, ITypeSystem context) {
		if (element instanceof IRMethod) {
			return new MethodValue(context, (IRMethod) element);
		} else if (element instanceof IRProperty) {
			return new PropertyValue(context, (IRProperty) element);
		} else {
			final IRTypeDeclaration type = (IRTypeDeclaration) element;
			return new TypeValue(context, RTypes.simple(type));
		}
	}

	public static ElementValue createClass(ITypeSystem context, Type type) {
		return new ClassValue(context, JSTypeSet.singleton(RTypes.classType(
				context, type)));
	}

	static class TypeValue extends ElementValue implements IValue {

		private final Map<String, IValue> children = new HashMap<String, IValue>(
				4, 0.9f);

		private final JSTypeSet types;

		public TypeValue(ITypeSystem context, IRType type) {
			super(context);
			this.types = JSTypeSet.singleton(type);
		}

		public TypeValue(ITypeSystem context, JSTypeSet types) {
			super(context);
			this.types = types;
		}

		@Override
		public final Set<String> getDirectChildren() {
			Set<String> set = new HashSet<String>();
			JSTypeSet typeSet = getTypes();
			for (IRType irType : typeSet) {
				if (irType instanceof IRLocalType) {
					set.addAll(((IRLocalType) irType).getValue()
							.getDirectChildren());
				}
			}
			return set;
		}

		@Override
		protected Type[] getElements() {
			return types.toArray();
		}

		public IValue getChild(String name, boolean resolve) {
			IValue value = children.get(name);
			if (value == null) {
				for (IRType type : types) {
					value = findMemberA(context, type, name, resolve);
					if (value != null) {
						if (value instanceof ElementValue) {
							value = ((ElementValue) value).resolveValue();
						}
						break;
					}
				}
				if (value == null && name.equals(IValueReference.ARRAY_OP)) {
					value = new Value();
				}
				if (value != null) {
					children.put(name, value);
				}
			}
			return value;
		}

		public IRType getDeclaredType() {
			return types.getFirst();
		}

		public JSTypeSet getDeclaredTypes() {
			return types;
		}

		@Override
		public final JSTypeSet getTypes() {
			return types;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + types;
		}
	}

	private static class ClassValue extends ElementValue implements IValue {

		private final JSTypeSet types;

		public ClassValue(ITypeSystem context, JSTypeSet types) {
			super(context);
			this.types = types;
		}

		@Override
		protected Type[] getElements() {
			return types.toArray();
		}

		public IValue getChild(String name, boolean resolve) {
			// just guess that if the child is the function operator it is a new
			// expression of this type. return then the none static type.
			if (name.equals(IValueReference.FUNCTION_OP)) {
				if (types.size() == 1) {
					final IRType type = types.getFirst();
					if (type instanceof IRClassType) {
						return new TypeValue(context,
								((IRClassType) type).newItemType());
					}
				}
				final JSTypeSet returnTypes = JSTypeSet.create();
				for (IRType type : types) {
					if (type instanceof IRClassType) {
						returnTypes.add(((IRClassType) type).newItemType());
					} else {
						returnTypes.add(type);
					}
				}
				return new TypeValue(context, returnTypes);
			}
			for (IRType type : types) {
				IValue child = findMember(context, type, name,
						MemberPredicates.STATIC);
				if (child != null)
					return child;
			}
			return null;
		}

		public IRType getDeclaredType() {
			return types.getFirst();
		}

		public JSTypeSet getDeclaredTypes() {
			return types;
		}

		@Override
		public ReferenceKind getKind() {
			return ReferenceKind.TYPE;
		}

		@Override
		public Object getAttribute(String key, boolean includeReferences) {
			if (IAssignProtection.ATTRIBUTE.equals(key)) {
				return UNASSIGNABLE_CLASS;
			}
			return super.getAttribute(key, includeReferences);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + types;
		}
	}

	private static class MethodValue extends ElementValue implements IValue {

		private TypeValue functionOperator;
		private final IRMethod method;

		public MethodValue(ITypeSystem context, IRMethod method) {
			super(context);
			this.method = method;
		}

		@Override
		protected IRMethod getElements() {
			return method;
		}

		@Override
		public IValue resolveValue() {
			final IValue value = context.valueOf(method);
			if (value != null) {
				return value;
			}
			return this;
		}

		@Override
		public ReferenceKind getKind() {
			return ReferenceKind.METHOD;
		}

		public IValue getChild(String name, boolean resolve) {
			if (IValueReference.FUNCTION_OP.equals(name)) {
				if (method.getType() != null) {
					if (functionOperator == null) {
						functionOperator = new TypeValue(context,
								JSTypeSet.singleton(method.getType()));
					}
					return functionOperator;
				}
			}
			final IValue child = ElementValue.findMemberA(context,
					getDeclaredType(), name, resolve);
			if (child != null) {
				return child;
			}
			return null;
		}

		public IRType getDeclaredType() {
			return RTypes.FUNCTION;
		}

		public JSTypeSet getDeclaredTypes() {
			return JSTypeSet.singleton(getDeclaredType());
		}

		@Override
		public Object getAttribute(String key, boolean includeReferences) {
			if (IAssignProtection.ATTRIBUTE.equals(key)
					&& method.getDeclaringType() == null) {
				return UNASSIGNABLE_METHOD;
			}
			return super.getAttribute(key, includeReferences);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + '<' + method + '>';
		}
	}

	public static final IAssignProtection READONLY_PROPERTY = new IAssignProtection() {
		public IProblemIdentifier problemId() {
			return JavaScriptProblems.PROPERTY_READONLY;
		}

		public String problemMessage() {
			return ValidationMessages.AssignmentToReadonlyProperty;
		}
	};

	static final IAssignProtection UNASSIGNABLE_METHOD = new IAssignProtection() {
		public IProblemIdentifier problemId() {
			return JavaScriptProblems.UNASSIGNABLE_ELEMENT;
		}

		public String problemMessage() {
			return ValidationMessages.UnassignableMethod;
		}
	};

	static final IAssignProtection UNASSIGNABLE_CLASS = new IAssignProtection() {
		public IProblemIdentifier problemId() {
			return JavaScriptProblems.UNASSIGNABLE_ELEMENT;
		}

		public String problemMessage() {
			return ValidationMessages.UnassignableClass;
		}
	};

	private static class PropertyValue extends ElementValue implements IValue {

		private final IRProperty property;
		private final Map<String, IValue> children = new HashMap<String, IValue>(
				4, 0.9f);

		public PropertyValue(ITypeSystem context, IRProperty property) {
			super(context);
			this.property = property;
		}

		@Override
		protected IRProperty getElements() {
			return property;
		}

		@Override
		public IValue resolveValue() {
			final IValue value = context.valueOf(property);
			if (value != null) {
				return value;
			}
			return this;
		}

		@Override
		public ReferenceKind getKind() {
			return ReferenceKind.PROPERTY;
		}

		public IValue getChild(String name, boolean resolve) {
			IValue child = children.get(name);
			if (child == null) {
				if (name.equals(IValueReference.ARRAY_OP)
						&& property.getType() != null) {
					IRTypeDeclaration arrayType = null;
					if (property.getType() instanceof IRArrayType) {
						arrayType = TypeUtil.extractType(context,
								((IRArrayType) property.getType())
										.getItemType());
					} else if (property.getType() instanceof IRMapType) {
						arrayType = TypeUtil
								.extractType(context, ((IRMapType) property
										.getType()).getValueType());
					}
					if (arrayType != null) {
						child = createFor(arrayType, context);
						children.put(name, child);
						return child;
					}
				}
				final IRType propType = getDeclaredType();
				final IValue eValue = ElementValue.findMemberA(context,
						propType, name, resolve);
				if (eValue instanceof ElementValue) {
					child = ((ElementValue) eValue).resolveValue();
					children.put(name, child);
				}
			}
			return child;
		}

		public IRType getDeclaredType() {
			return property.getType();
		}

		private JSTypeSet declaredTypes = null;

		public JSTypeSet getDeclaredTypes() {
			if (declaredTypes == null) {
				final IRType type = getDeclaredType();
				if (type != null) {
					declaredTypes = JSTypeSet.singleton(type);
				} else {
					declaredTypes = JSTypeSet.emptySet();
				}
			}
			return declaredTypes;
		}

		@Override
		public Object getAttribute(String key, boolean includeReferences) {
			if (IAssignProtection.ATTRIBUTE.equals(key)) {
				final IRTypeDeclaration declaringType = property
						.getDeclaringType();
				if (declaringType != null) {
					return declaringType.getReadOnlyStatus(property);
				} else {
					return property.isReadOnly() ? READONLY_PROPERTY : null;
				}
			}
			return super.getAttribute(key, includeReferences);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + '<' + property + '>';
		}
	}

	private static class PrototypePropertyValue extends PropertyValue {
		private final IRType valueType;

		public PrototypePropertyValue(ITypeSystem context, IRProperty property,
				IRType valueType) {
			super(context, property);
			this.valueType = valueType;
		}

		@Override
		public IRType getDeclaredType() {
			return valueType;
		}
	}

	private static class RTypeValue extends ElementValue implements IValue {

		private final IRType type;
		private final Map<String, IValue> children = new HashMap<String, IValue>();
		private final IRMember element;

		public RTypeValue(ITypeSystem context, IRType type, IRMember element) {
			super(context);
			this.type = type;
			this.element = element;
		}

		@Override
		protected IRMember getElements() {
			return element;
		}

		@Override
		public ReferenceKind getKind() {
			return ReferenceKind.PROPERTY;
		}

		public IValue getChild(String name, boolean resolve) {
			IValue child = children.get(name);
			if (child == null) {
				if (name.equals(IValueReference.ARRAY_OP)) {
					IRTypeDeclaration arrayType = null;
					if (type instanceof IRArrayType) {
						arrayType = TypeUtil.extractType(context,
								((IRArrayType) type).getItemType());
					} else if (type instanceof IRMapType) {
						arrayType = TypeUtil.extractType(context,
								((IRMapType) type).getValueType());
					}
					if (arrayType != null) {
						ElementValue arrayOpChild = createFor(arrayType,
								context);
						children.put(name, arrayOpChild);
						return arrayOpChild;
					}
				} else if (IValueReference.FUNCTION_OP.equals(name)) {
					if (type instanceof IRFunctionType) {
						child = new Value();
						child.addType(((IRFunctionType) type).getReturnType());
						children.put(name, child);
						return child;
					}
				}
				IValue eValue = ElementValue.findMemberA(context, type, name,
						resolve);
				if (eValue instanceof ElementValue) {
					child = ((ElementValue) eValue).resolveValue();
					children.put(name, child);
				}
			}
			return child;
		}

		public IRType getDeclaredType() {
			return type;
		}

		public JSTypeSet getDeclaredTypes() {
			if (type != null) {
				return JSTypeSet.singleton(type);
			} else {
				return JSTypeSet.emptySet();
			}
		}

		@Override
		public ReferenceLocation getLocation() {
			if (element.getSource() instanceof ILocationProvider) {
				return ((ILocationProvider) element.getSource()).getLocation();
			}
			return super.getLocation();
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + '<' + type + '>';
		}
	}

	private static class MemberValue extends ElementValue implements IValue {

		private TypeValue functionOperator;
		private final IRMember[] members;

		public MemberValue(ITypeSystem context, IRMember[] members) {
			super(context);
			this.members = members;
		}

		@Override
		protected IRMember[] getElements() {
			return members;
		}

		@Override
		public IValue resolveValue() {
			if (members.length == 1) {
				final IValue value = context.valueOf(members[0]);
				if (value != null) {
					// copy over the properties of this value.
					value.setDeclaredType(getDeclaredType());
					value.setAttribute(IReferenceAttributes.ELEMENT,
							getAttribute(IReferenceAttributes.ELEMENT));
					return value;
				}
			}
			return this;
		}

		@Override
		public ReferenceKind getKind() {
			for (IRMember member : members) {
				if (member instanceof IRMethod)
					return ReferenceKind.METHOD;
			}
			return ReferenceKind.PROPERTY;
		}

		public IValue getChild(String name, boolean resolve) {
			if (IValueReference.FUNCTION_OP.equals(name)) {
				JSTypeSet types = null;
				for (IRMember member : members) {
					if (member instanceof IRMethod) {
						final IRMethod method = (IRMethod) member;
						if (method.getType() != null) {
							if (types == null) {
								types = JSTypeSet.create();
							}
							types.add(method.getType());
						}
					}
				}
				if (types != null) {
					if (functionOperator == null) {
						functionOperator = new TypeValue(context, types);
					}
					return functionOperator;
				}
			}

			IRType type = getDeclaredType();
			if (type != null) {
				final IValue child = ElementValue.findMemberA(context, type,
						name, resolve);
				if (child != null) {
					return child;
				}
			}
			return null;
		}

		public IRType getDeclaredType() {
			for (IRMember member : members) {
				if (member instanceof IRProperty) {
					final IRProperty property = (IRProperty) member;
					if (property.getType() != null) {
						return property.getType();
					}
				} else if (member instanceof IRMethod) {
					return RTypes.FUNCTION;
				}
			}
			return null;
		}

		public JSTypeSet getDeclaredTypes() {
			JSTypeSet types = null;
			for (IRMember member : members) {
				if (member instanceof IRProperty) {
					final IRProperty property = (IRProperty) member;
					if (property.getType() != null) {
						if (types == null) {
							types = JSTypeSet.create();
						}
						types.add(property.getType());
					}
				} else if (member instanceof IRMethod) {
					if (types == null) {
						types = JSTypeSet.create();
					}
					types.add(RTypes.FUNCTION);
				}
			}
			if (types != null) {
				return types;
			} else {
				return JSTypeSet.emptySet();
			}
		}

		@Override
		public Object getAttribute(String key, boolean includeReferences) {
			if (IAssignProtection.ATTRIBUTE.equals(key)) {
				for (IRMember member : members) {
					if (member instanceof IRProperty) {
						if (((IRProperty) member).isReadOnly()) {
							return READONLY_PROPERTY;
						}
					} else if (member instanceof IRMethod
							&& member.getDeclaringType() == null) {
						return UNASSIGNABLE_METHOD;
					}
				}
				return null;
			}
			return super.getAttribute(key, includeReferences);
		}

	}

	protected final ITypeSystem context;

	public ElementValue(ITypeSystem context) {
		this.context = context;
	}

	protected abstract Object getElements();

	public IValue resolveValue() {
		return this;
	}

	public final void clear() {
	}

	public final void addValue(IValue src) {
	}

	public final void addReference(IValue src) {
	}

	public void removeReference(IValue value) {
	}

	public final Object getAttribute(String key) {
		return getAttribute(key, false);
	}

	public Object getAttribute(String key, boolean includeReferences) {
		if (IReferenceAttributes.ELEMENT.equals(key)) {
			return getElements();
		}
		if (IReferenceAttributes.TYPE_SYSTEM.equals(key)) {
			return context;
		}
		if (IReferenceAttributes.HIDE_ALLOWED.equals(key)) {
			final Object elements = getElements();
			if (elements instanceof IRElement) {
				final Object source = ((IRElement) elements).getSource();
				if (source instanceof Element) {
					if (((Element) source).isHideAllowed()) {
						return Boolean.TRUE;
					}
				}
			}
		}
		return null;
	}

	public final void setAttribute(String key, Object value) {
	}

	public Set<String> getDirectChildren() {
		return Collections.emptySet();
	}

	public Set<String> getDeletedChildren() {
		return Collections.emptySet();
	}

	public void deleteChild(String name, boolean force) {
	}

	public final boolean hasChild(String name) {
		return false;
	}

	public final IValue createChild(String name, int flags) {
		return getChild(name, true);
		// throw new UnsupportedOperationException();
	}

	public void putChild(String name, IValue value) {
		throw new UnsupportedOperationException();
	}

	public ReferenceKind getKind() {
		return ReferenceKind.UNKNOWN;
	}

	public ReferenceLocation getLocation() {
		return ReferenceLocation.UNKNOWN;
	}

	public JSTypeSet getTypes() {
		return JSTypeSet.emptySet();
	}

	public final void setDeclaredType(IRType declaredType) {
	}

	public void addType(IRType type) {
	}

	public final void setKind(ReferenceKind kind) {
	}

	public final void setLocation(ReferenceLocation location) {
	}
}
