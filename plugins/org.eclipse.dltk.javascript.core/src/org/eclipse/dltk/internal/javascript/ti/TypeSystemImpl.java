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
package org.eclipse.dltk.internal.javascript.ti;

import static org.eclipse.core.runtime.Platform.getDebugOption;
import static org.eclipse.dltk.javascript.typeinfo.RTypes.none;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.dltk.annotations.NonNull;
import org.eclipse.dltk.annotations.Nullable;
import org.eclipse.dltk.javascript.internal.core.RConstructor;
import org.eclipse.dltk.javascript.internal.core.RMethod;
import org.eclipse.dltk.javascript.internal.core.RParamParameter;
import org.eclipse.dltk.javascript.internal.core.RParameter;
import org.eclipse.dltk.javascript.internal.core.RParameterizedTypeDeclaration;
import org.eclipse.dltk.javascript.internal.core.RProperty;
import org.eclipse.dltk.javascript.internal.core.RTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.IRArrayType;
import org.eclipse.dltk.javascript.typeinfo.IRConstructor;
import org.eclipse.dltk.javascript.typeinfo.IRContextualizableType;
import org.eclipse.dltk.javascript.typeinfo.IRMember;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRParameter;
import org.eclipse.dltk.javascript.typeinfo.IRProperty;
import org.eclipse.dltk.javascript.typeinfo.IRSimpleType;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.IRTypeTransformer;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.RTypes;
import org.eclipse.dltk.javascript.typeinfo.model.Constructor;
import org.eclipse.dltk.javascript.typeinfo.model.GenericType;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.Method;
import org.eclipse.dltk.javascript.typeinfo.model.Parameter;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterizedType;
import org.eclipse.dltk.javascript.typeinfo.model.Property;
import org.eclipse.dltk.javascript.typeinfo.model.SimpleType;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelLoader;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;

public class TypeSystemImpl implements ITypeSystem {

	/*
	 * @see ITypeSystem#getKnownType(java.lang.String)
	 */
	public Type getKnownType(String typeName) {
		return TypeInfoModelLoader.getInstance().getType(typeName);
	}

	/*
	 * @see ITypeSystem#resolveType(Type)
	 */
	public Type resolveType(Type type) {
		if (type != null && type.isProxy()) {
			return doResolveType(type);
		} else {
			return type;
		}
	}

	protected Type doResolveType(Type type) {
		final String typeName = URI.decode(((InternalEObject) type).eProxyURI()
				.fragment());
		final Type resolved = TypeInfoModelLoader.getInstance().getType(
				typeName);
		if (resolved != null) {
			return resolved;
		}
		return type;
	}

	/*
	 * @see ITypeSystem#valueOf(Member)
	 */
	public IValue valueOf(IRMember member) {
		return null;
	}

	private final Object lock = new Object();

	private final Map<Type, RTypeDeclaration> declarations = new HashMap<Type, RTypeDeclaration>();

	public IRTypeDeclaration convert(Type type) {
		return convert0(resolveType(type));
	}

	final IRTypeDeclaration convert0(Type type) {
		final ITypeSystem preferred = type.getMetaType()
				.getPreferredTypeSystem(type);
		if (preferred != null && preferred != this) {
			return convertInPreferred(preferred, type);
		}
		return convert1(type);
	}

	private IRTypeDeclaration convertInPreferred(ITypeSystem typeSystem,
			Type type) {
		if (typeSystem instanceof TypeSystemImpl) {
			return ((TypeSystemImpl) typeSystem).convert1(type);
		} else {
			return typeSystem.convert(type);
		}
	}

	final IRTypeDeclaration convert1(Type type) {
		synchronized (lock) {
			return convertType(type, null);
		}
	}

	/**
	 * Clears the cached data of this type system.
	 */
	public void reset() {
		synchronized (lock) {
			declarations.clear();
			parameterized.clear();
			contextualized.clear();
			if (values != null) {
				values.clear();
			}
		}
	}

	private RTypeDeclaration convertType(Type type, Set<Type> processedTypes) {
		{
			final RTypeDeclaration declaration = declarations.get(type);
			if (declaration != null) {
				return declaration;
			}
		}
		if (processedTypes == null) {
			processedTypes = new HashSet<Type>();
		} else { // when called for super type/traits
			final ITypeSystem preferred = type.getMetaType()
					.getPreferredTypeSystem(type);
			if (preferred != null && preferred != this) {
				return (RTypeDeclaration) convertInPreferred(preferred, type);
			}
		}
		if (!processedTypes.add(type)) {
			return null;
		}
		final RTypeDeclaration declaration = new RTypeDeclaration(this, type);
		declarations.put(type, declaration);
		if (TRACE) {
			log("Creating", declaration, "declarations.size=",
					declarations.size());
		}
		buildType(declaration, type, type.getAdditionalMembers(null),
				processedTypes);
		return declaration;
	}

	private void buildType(final RTypeDeclaration declaration, Type type,
			@Nullable final Member[] additionalMembers, Set<Type> processedTypes) {
		final SimpleType superType = type.getSuperTypeExpr();
		if (superType != null && superType.getTarget() != null) {
			if (superType.getTarget() instanceof GenericType) {
				final GenericType generic = (GenericType) superType.getTarget();
				if (superType instanceof ParameterizedType) {
					declaration.setSuperType(parameterizeType(generic, RTypes
							.convert(this, ((ParameterizedType) superType)
									.getActualTypeArguments())));
				} else if (declaration.isParameterized()) {
					declaration.setSuperType(parameterizeType(generic,
							declaration.getActualTypeArguments()));
				} else {
					declaration.setSuperType(convertType(generic,
							processedTypes));
				}
			} else {
				declaration.setSuperType(convertType(superType.getTarget(),
						processedTypes));
			}
		}
		final List<RTypeDeclaration> traits = new ArrayList<RTypeDeclaration>(
				type.getTraits().size());
		for (Type trait : type.getTraits()) {
			final RTypeDeclaration t = convertType(trait, processedTypes);
			if (t != null) {
				traits.add(t);
			}
		}
		declaration.setTraits(toImmutableList(traits));
		final List<IRMember> members = new ArrayList<IRMember>(type
				.getMembers().size()
				+ (additionalMembers != null ? additionalMembers.length : 0));
		for (Member member : type.getMembers()) {
			members.add(convertMember(member, declaration));
		}
		if (additionalMembers != null && additionalMembers.length != 0) {
			for (Member member : additionalMembers) {
				members.add(convertMember(member, declaration));
			}
		}
		declaration.setMembers(toImmutableList(members));
		final List<IRConstructor> constructors = new ArrayList<IRConstructor>(
				type.getConstructors().size());
		for (Constructor constructor : type.getConstructors()) {
			constructors.add(convertConstructor(constructor, declaration));
		}
		declaration.setConstructors(toImmutableList(constructors));
		final Constructor staticConstructor = type.getStaticConstructor();
		if (staticConstructor != null) {
			declaration.setStaticConstructor(convertConstructor(
					staticConstructor, declaration));
		}
	}

	private static <E> List<E> toImmutableList(List<E> list) {
		// TODO (alex) introduce real immutable lists
		return list.isEmpty() ? Collections.<E> emptyList() : list;
	}

	private void log(Object... args) {
		if (!TRACE)
			return;
		final StringBuilder sb = new StringBuilder(128);
		sb.append('[').append(Thread.currentThread().getName()).append("] ");
		sb.append(this.toString());
		sb.append(":");
		boolean space = true;
		for (int i = 0; i < args.length; ++i) {
			if (space) {
				sb.append(' ');
			}
			final Object arg = args[i];
			sb.append(arg);
			space = !(arg instanceof String && ((String) arg).endsWith("="));
		}
		System.out.println(sb);
	}

	private IRType convert(final JSType type) {
		return RTypes.create(this, type);
	}

	public IRType getTypeVariable(TypeVariable variable) {
		for (int i = typeVariables.size(); --i >= 0;) {
			final IRType type = typeVariables.get(i).getTypeVariable(variable);
			if (type != null) {
				return type;
			}
		}
		return null;
	}

	protected IRMember convertMember(Member member,
			IRTypeDeclaration declaration) {
		if (member instanceof Method) {
			return convertMethod((Method) member, declaration);
		} else {
			assert member instanceof Property;
			return convertProperty((Property) member, declaration);
		}
	}

	private IRMember convertProperty(Property property,
			IRTypeDeclaration declaration) {
		if (declaration != null && isLazy()) {
			return new RProperty(property, declaration);
		} else {
			return new RProperty(property, convert(property.getType()),
					declaration);
		}
	}

	private IRMember convertMethod(Method method, IRTypeDeclaration declaration) {
		if (declaration != null && isLazy()) {
			return new RMethod(method, declaration);
		} else {
			return new RMethod(method, convert(method.getType()),
					convertParameters(this, method.getParameters()),
					declaration);
		}
	}

	private IRConstructor convertConstructor(Constructor constructor,
			RTypeDeclaration declaration) {
		return new RConstructor(constructor, declaration); // always lazy
	}

	public static List<IRParameter> convertParameters(ITypeSystem typeSystem,
			List<Parameter> parameters) {
		if (parameters.isEmpty()) {
			return Collections.emptyList();
		}
		final List<IRParameter> result = new ArrayList<IRParameter>(
				parameters.size());
		for (Parameter param : parameters) {
			final IRType type = param.getType() != null ? RTypes.create(
					typeSystem, param.getType()) : RTypes.any();
			result.add(new RParamParameter(param, type));
		}
		return toImmutableList(result);
	}

	private static class ParameterizedTypeKey {
		final GenericType type;
		final IRType[] parameters;

		public ParameterizedTypeKey(GenericType type,
				List<? extends IRType> params) {
			this.type = type;
			final int expectedParamCount = type.getTypeParameters().size();
			this.parameters = new IRType[expectedParamCount];
			for (int i = 0; i < expectedParamCount; ++i) {
				IRType t;
				if (i < params.size()) {
					t = params.get(i);
					if (t == null) {
						t = none();
					}
				} else {
					t = none();
				}
				this.parameters[i] = t;
			}
		}

		@Override
		public int hashCode() {
			return type.hashCode() ^ Arrays.hashCode(parameters);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof ParameterizedTypeKey) {
				final ParameterizedTypeKey other = (ParameterizedTypeKey) obj;
				return type == other.type
						&& Arrays.equals(parameters, other.parameters);
			}
			return false;
		}

		@Override
		public String toString() {
			final StringBuilder parameterizedName = new StringBuilder(type
					.getName().length() + parameters.length * 16);
			parameterizedName.append(type.getName());
			parameterizedName.append("<");
			for (int i = 0; i < parameters.length; ++i) {
				if (i > 0) {
					parameterizedName.append(",");
				}
				parameterizedName.append(parameters[i].getName());
			}
			parameterizedName.append(">");
			return parameterizedName.toString();
		}

	}

	private final Map<ParameterizedTypeKey, RTypeDeclaration> parameterized = new HashMap<ParameterizedTypeKey, RTypeDeclaration>();

	/*
	 * @see ITypeSystem#parameterize(Type, java.util.List)
	 */
	public IRTypeDeclaration parameterize(Type target,
			List<? extends IRType> parameters) {
		target = resolveType(target);
		if (!(target instanceof GenericType)) {
			return convert0(target);
		}
		synchronized (lock) {
			return parameterizeType((GenericType) target, parameters);
		}
	}

	private final List<RParameterizedTypeDeclaration> typeVariables = new ArrayList<RParameterizedTypeDeclaration>();

	private RTypeDeclaration parameterizeType(GenericType genericType,
			List<? extends IRType> parameters) {
		final ParameterizedTypeKey key = new ParameterizedTypeKey(genericType,
				parameters);
		{
			final RTypeDeclaration declaration = parameterized.get(key);
			if (declaration != null) {
				return declaration;
			}
		}
		if (TRACE) {
			log("Creating", key, "parameterized.size=", parameterized.size());
		}
		final RParameterizedTypeDeclaration declaration = new RParameterizedTypeDeclaration(
				this, genericType, Arrays.asList(key.parameters));
		parameterized.put(key, declaration);
		typeVariables.add(declaration);
		try {
			buildType(declaration, genericType,
					genericType.getAdditionalMembers(declaration
							.getActualTypeArguments()), new HashSet<Type>());
		} finally {
			typeVariables.remove(typeVariables.size() - 1);
		}
		return declaration;
	}

	private static class ContextualizeKey {
		@NonNull
		final IRMember member;

		@NonNull
		final IRTypeDeclaration declaration;

		public ContextualizeKey(@NonNull IRMember member,
				@NonNull IRTypeDeclaration declaration) {
			this.member = member;
			this.declaration = declaration;
		}

		@Override
		public int hashCode() {
			return member.hashCode() ^ declaration.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof ContextualizeKey) {
				final ContextualizeKey other = (ContextualizeKey) obj;
				return member.equals(other.member)
						&& declaration.equals(other.declaration);
			}
			return false;
		}
	}

	private final Map<ContextualizeKey, IRMember> contextualized = new HashMap<ContextualizeKey, IRMember>();

	@SuppressWarnings("unchecked")
	public <E extends IRMember> E contextualize(E member,
			IRTypeDeclaration declaration) {
		if (!isContextualizable(member)) {
			return member;
		}
		final ContextualizeKey key = new ContextualizeKey(member, declaration);
		synchronized (contextualized) {
			final E cached = (E) contextualized.get(key);
			if (cached != null) {
				return cached;
			}
			final E result = contextualizeMember(member, declaration);
			contextualized.put(key, result);
			if (TRACE) {
				log("Contextualized", result, "with", declaration,
						"contextualized.size=", contextualized.size());
			}
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	private <E extends IRMember> E contextualizeMember(E member,
			IRTypeDeclaration declaration) {
		final IRTypeTransformer transformer = newTypeContextualizer(declaration);
		if (member instanceof IRMethod) {
			final IRMethod method = (IRMethod) member;
			final List<IRParameter> parameters = transformParameters(method,
					transformer);
			if (member instanceof IRConstructor) {
				return (E) new RConstructor((Method) member.getSource(),
						transformer.transform(member.getType()), parameters,
						member.getDeclaringType());
			} else {
				return (E) new RMethod((Method) member.getSource(),
						transformer.transform(member.getType()), parameters,
						member.getDeclaringType());
			}
		} else {
			assert member instanceof IRProperty;
			return (E) new RProperty((Property) member.getSource(),
					transformer.transform(member.getType()),
					member.getDeclaringType());
		}
	}

	protected IRTypeTransformer newTypeContextualizer(
			IRTypeDeclaration declaration) {
		return new TypeContextualizer(declaration);
	}

	private static List<IRParameter> transformParameters(final IRMethod method,
			final IRTypeTransformer transformer) {
		if (method.getParameterCount() == 0) {
			return Collections.emptyList();
		} else {
			final List<IRParameter> parameters = new ArrayList<IRParameter>(
					method.getParameterCount());
			for (IRParameter parameter : method.getParameters()) {
				final IRType newType = transformer.transform(parameter
						.getType());
				if (newType != parameter.getType()) {
					parameters.add(new RParameter(parameter.getName(), newType,
							parameter.getKind()));
				} else {
					parameters.add(parameter);
				}
			}
			return toImmutableList(parameters);
		}
	}

	private class TypeContextualizer implements IRTypeTransformer {
		private final IRTypeDeclaration contextType;

		public TypeContextualizer(IRTypeDeclaration declaration) {
			this.contextType = declaration;
		}

		public IRType transform(IRType type) {
			if (type instanceof IRContextualizableType) {
				final IRContextualizableType c = (IRContextualizableType) type;
				if (c.isContextualizable()) {
					return c.contextualize(contextType);
				}
			}
			return type != null ? type.transform(this) : null;
		}

		public IRTypeDeclaration transform(IRTypeDeclaration declaration) {
			if (declaration.isParameterized()) {
				boolean createNew = false;
				final List<IRType> typeParams = new ArrayList<IRType>(
						declaration.getActualTypeArguments());
				for (ListIterator<IRType> i = typeParams.listIterator(); i
						.hasNext();) {
					final IRType type = i.next();
					if (type instanceof IRContextualizableType) {
						final IRContextualizableType c = (IRContextualizableType) type;
						if (c.isContextualizable()) {
							final IRType newType = c
									.contextualize(this.contextType);
							if (newType != type) {
								i.set(newType);
								createNew = true;
							}
						}
					}
				}
				if (createNew) {
					return parameterize(declaration.getSource(), typeParams);
				}
			}
			return declaration;
		}
	}

	private Map<Object, Object> values;

	/*
	 * @see ITypeSystem#getValue(java.lang.Object )
	 */
	public Object getValue(Object key) {
		assert key != null;
		return values != null ? values.get(key) : null;
	}

	/*
	 * @see ITypeSystem#setValue(java.lang.Object , java.lang.Object)
	 */
	public void setValue(Object key, Object value) {
		assert key != null;
		if (values == null) {
			values = new HashMap<Object, Object>();
		}
		values.put(key, value);
	}

	protected boolean isContextualizable(IRMember member) {
		if (isContextualizable(member.getType())) {
			return true;
		}
		if (member instanceof IRMethod) {
			for (IRParameter parameter : ((IRMethod) member).getParameters()) {
				if (isContextualizable(parameter.getType())) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isContextualizable(IRType type) {
		if (type == null) {
			return false;
		} else if (type instanceof IRContextualizableType) {
			return ((IRContextualizableType) type).isContextualizable();
		} else if (type instanceof IRArrayType) {
			return isContextualizable(((IRArrayType) type).getItemType());
		} else if (type instanceof IRSimpleType) {
			final IRTypeDeclaration declaration = ((IRSimpleType) type)
					.getDeclaration();
			if (declaration.isParameterized()) {
				for (IRType typeArgument : declaration.getActualTypeArguments()) {
					if (isContextualizable(typeArgument)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public ITypeSystem getPrimary() {
		return this;
	}

	protected final boolean isLazy() {
		return true;
	}

	public static class TypeSystemStats {
		private final int declarationCount;
		private final int parameterizedCount;
		private final int contextualizedCount;

		public TypeSystemStats(int declarationCount, int parameterizedCount,
				int contextualizedCount) {
			this.declarationCount = declarationCount;
			this.parameterizedCount = parameterizedCount;
			this.contextualizedCount = contextualizedCount;
		}

		public int declarationCount() {
			return declarationCount;
		}

		public int parameterizedCount() {
			return parameterizedCount;
		}

		public int contextualizedCount() {
			return contextualizedCount;
		}

		public boolean isEmpty() {
			return declarationCount == 0 && parameterizedCount == 0
					&& contextualizedCount == 0;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + "[declarationCount="
					+ declarationCount + ",parameterizedCount="
					+ parameterizedCount + ",contextualizedCount="
					+ contextualizedCount + "]";
		}
	}

	public TypeSystemStats stats() {
		synchronized (lock) {
			return new TypeSystemStats(declarations.size(),
					parameterized.size(), contextualized.size());
		}
	}

	private static final boolean TRACE = Boolean.valueOf(
			getDebugOption("org.eclipse.dltk.javascript.core/traceTypeSystem"))
			.booleanValue();

}
