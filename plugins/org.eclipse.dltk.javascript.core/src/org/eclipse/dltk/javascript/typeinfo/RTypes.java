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
package org.eclipse.dltk.javascript.typeinfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.dltk.annotations.Nullable;
import org.eclipse.dltk.internal.javascript.ti.IValue;
import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.javascript.core.JavaScriptPlugin;
import org.eclipse.dltk.javascript.core.Types;
import org.eclipse.dltk.javascript.internal.core.RRecordMember;
import org.eclipse.dltk.javascript.internal.core.TypeSystems;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.Type;

/**
 * Static utility methods pertaining to {@code IRType} instances.
 */
public class RTypes {

	private RTypes() {
	}

	private static IRType initRType(IRType defaultValue) {
		final IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry != null) { // if running under OSGI
			final String name = defaultValue.getClass().getSimpleName();
			final IConfigurationElement[] elements = registry
					.getConfigurationElementsFor(TypeInfoManager.EXT_POINT);
			for (IConfigurationElement element : elements) {
				if ("runtimeType".equals(element.getName())
						&& name.equals(element.getAttribute("name"))) {
					try {
						return (IRType) element
								.createExecutableExtension("class");
					} catch (Exception e) {
						JavaScriptPlugin.error(e);
					}
				}
			}
		}
		return defaultValue;
	}

	private static final IRType UNDEFINED_TYPE = new Undefined();

	static class Undefined extends RType {
		public String getName() {
			return ITypeNames.UNDEFINED;
		}

		@Override
		public TypeCompatibility isAssignableFrom(IRType type) {
			return TypeCompatibility.valueOf(type == this);
		}
	}

	/**
	 * Returns the instance of the special <b>undefined</b> type.
	 */
	public static IRType undefined() {
		return UNDEFINED_TYPE;
	}

	private static final IRType ANY_TYPE = initRType(new Any());

	static class Any extends RType {
		public String getName() {
			return "Any";
		}

		@Override
		public TypeCompatibility isAssignableFrom(IRType type) {
			return TypeCompatibility.TRUE;
		}

		@Override
		public boolean isExtensible() {
			return true;
		}
	}

	/**
	 * Returns the instance of the logical <b>Any</b> type.
	 * 
	 * @return
	 */
	public static IRType any() {
		return ANY_TYPE;
	}

	private static final IRType NONE_TYPE = new None();

	static class None extends RType {
		public String getName() {
			return "None";
		}

		@Override
		public TypeCompatibility isAssignableFrom(IRType type) {
			return TypeCompatibility.TRUE;
		}

		@Override
		public boolean isExtensible() {
			return true;
		}

		@Override
		public boolean isSynthetic() {
			return true;
		}
	}

	/**
	 * Returns the instance of the logical <b>None</b> type (which is used as a
	 * placeholder if generic type parameters (e.g. array item type) are not
	 * known/specified).
	 */
	public static IRType none() {
		return NONE_TYPE;
	}

	/**
	 * Returns the instance of the <b>empty array literal</b>.
	 */
	public static IRArrayType arrayOf() {
		return ARRAY_OF;
	}

	static final IRType EMPTY_ARRAY_ITEM_TYPE = new EmptyArrayItem();

	private static final IRArrayType ARRAY_OF = arrayOf(TypeSystems.GLOBAL,
			EMPTY_ARRAY_ITEM_TYPE);

	static class EmptyArrayItem extends RType {
		public String getName() {
			return "empty";
		}

		@Override
		public TypeCompatibility isAssignableFrom(IRType type) {
			return TypeCompatibility.TRUE;
		}

		@Override
		public boolean isExtensible() {
			return true;
		}
	}

	public static IRType simple(ITypeSystem typeSystem, Type type) {
		if (Types.ARRAY == type) {
			return arrayOf(typeSystem, none());
		} else {
			return type.toRType(typeSystem);
		}
	}

	public static IRType simple(IRTypeDeclaration declaration) {
		return declaration.getSource().getMetaType().toRType(null, declaration);
	}

	public static IRType simple(ITypeSystem typeSystem,
			IRTypeDeclaration declaration) {
		return declaration.getSource().getMetaType()
				.toRType(typeSystem, declaration);
	}

	@Deprecated
	public static IRType simple(Type type) {
		if (Types.ARRAY == type) {
			return arrayOf(TypeSystems.GLOBAL, none());
		} else {
			return type.toRType(null);
		}
	}

	@Deprecated
	public static IRClassType classType(Type type) {
		return new RClassType(type);
	}

	public static IRClassType classType(ITypeSystem typeSystem, Type type) {
		return new RClassType(typeSystem, type);
	}

	public static IRClassType classType(IRTypeDeclaration declaration) {
		return new RClassType(declaration);
	}

	/**
	 * Returns the {@link IRClassType} corresponding to the specified (simple)
	 * type.
	 * <p>
	 * NOTICE: At the moment only {@link IRSimpleType} is supported at the
	 * moment, for all other values empty class type is returned.
	 * </p>
	 */
	public static IRClassType classOf(IRType type) {
		if (type instanceof IRSimpleType) {
			return classType(((IRSimpleType) type).getDeclaration());
		} else {
			// not supported case - create empty class type.
			return classType((IRTypeDeclaration) null);
		}
	}

	public static IRMapType mapOf(final IRType keyType, final IRType valueType) {
		return new RMapType(keyType, valueType);
	}

	public static IRMapType mapOf(ITypeSystem typeSystem, final IRType keyType,
			final IRType valueType) {
		return new RMapType(typeSystem, keyType, valueType);
	}

	/**
	 * Returns empty record type instance.
	 */
	public static IRRecordType recordType() {
		return EMPTY_RECORD_TYPE;
	}

	private static final IRRecordType EMPTY_RECORD_TYPE = new EmptyRecordType();

	static class EmptyRecordType extends RType implements IRRecordType {

		public String getName() {
			return "{}";
		}

		public IRRecordMember getMember(String name) {
			return null;
		}

		public Collection<IRRecordMember> getMembers() {
			return Collections.emptyList();
		}
	}

	public static IRRecordType recordType(ITypeSystem typeSystem,
			Collection<Member> members) {
		return new RRecordType(typeSystem, members);
	}

	public static IRRecordType recordType(Collection<IRRecordMember> members) {
		return new RRecordType(members);
	}

	/**
	 * Represents the specified {@link IValueReference} as {@link IRRecordType}.
	 * Only {@link IRRecordType} value types and direct children are considered,
	 * otherwise the {@link #recordType() empty record type} is returned.
	 */
	public static IRRecordType recordType(@Nullable IValueReference argument) {
		if (argument != null) {
			final Set<String> directChildren = argument.getDirectChildren();
			final IRType type = JavaScriptValidations.typeOf(argument);
			if (type instanceof IRRecordType) {
				if (directChildren.isEmpty()) {
					return (IRRecordType) type;
				} else {
					final List<IRRecordMember> members = new ArrayList<IRRecordMember>(
							directChildren.size()
									+ ((IRRecordType) type).getMembers().size());
					for (String childName : directChildren) {
						final IValueReference child = argument
								.getChild(childName);
						if (child.exists()) {
							final IRType memberType = JavaScriptValidations
									.typeOf(child);
							members.add(new RRecordMember(childName,
									memberType != null ? memberType : any(),
									child));
						}
					}
					for (IRRecordMember member : ((IRRecordType) type)
							.getMembers()) {
						if (!directChildren.contains(member.getName())) {
							members.add(member);
						}
					}
					return recordType(members);
				}
			} else if (!directChildren.isEmpty()) {
				final List<IRRecordMember> members = new ArrayList<IRRecordMember>(
						directChildren.size());
				for (String childName : directChildren) {
					final IValueReference child = argument.getChild(childName);
					if (child.exists()) {
						final IRType memberType = JavaScriptValidations
								.typeOf(child);
						members.add(new RRecordMember(childName,
								memberType != null ? memberType : any(), child));
					}
				}
				return recordType(members);
			} else {
				return recordType();
			}
		} else {
			return recordType();
		}
	}

	public static Set<String> memberNames(IRRecordType recordType) {
		final Collection<IRRecordMember> members = recordType.getMembers();
		if (members.isEmpty()) {
			return Collections.emptySet();
		}
		final Set<String> names = new LinkedHashSet<String>(members.size());
		for (IRRecordMember member : members) {
			names.add(member.getName());
		}
		return names;
	}

	public static IRFunctionType functionType(List<IRParameter> parameters,
			IRType returnType) {
		return new RFunctionType(parameters, returnType);
	}

	public static IRType union(Collection<IRType> targets) {
		return new RUnionType(targets);
	}

	/**
	 * Creates new instance of the array type with the specified itemType.
	 */
	@Deprecated
	public static IRArrayType arrayOf(final IRType itemType) {
		return new RArrayType(itemType != null ? itemType : none());
	}

	public static IRArrayType arrayOf(ITypeSystem typeSystem,
			final IRType itemType) {
		return new RArrayType(typeSystem, itemType);
	}

	public static IRIValueType create(ITypeSystem typeSystem, String name,
			IValue value) {
		return new RIValueType(typeSystem, name, value);
	}

	@Deprecated
	public static IRType create(JSType type) {
		ITypeSystem current = ITypeSystem.CURRENT.get();
		if (current == null) {
			current = TypeSystems.DELEGATING_TYPE_SYSTEM;
		}
		return create(current, type);
	}

	/**
	 * Converts the specified type expression to the "resolved" type expression.
	 */
	public static IRType create(ITypeSystem typeSystem, JSType type) {
		if (type == null) {
			return null;
		}
		final IRType result = type.toRType(typeSystem);
		if (result != null) {
			return result;
		}
		for (IRTypeFactory factory : TypeInfoManager.getRTypeFactories()) {
			final IRType runtimeType = factory.create(typeSystem, type);
			if (runtimeType != null) {
				return runtimeType;
			}
		}
		throw new IllegalArgumentException("Unsupported type "
				+ type.getClass().getName());
	}

	public static final IRSimpleType FUNCTION = (IRSimpleType) simple(
			TypeSystems.GLOBAL, Types.FUNCTION);

	public static final IRType STRING = simple(TypeSystems.GLOBAL, Types.STRING);

	public static final IRType NUMBER = simple(TypeSystems.GLOBAL, Types.NUMBER);

	public static final IRType BOOLEAN = simple(TypeSystems.GLOBAL,
			Types.BOOLEAN);

	public static final IRSimpleType OBJECT = (IRSimpleType) simple(
			TypeSystems.GLOBAL, Types.OBJECT);

	public static final IRSimpleType REGEXP = (IRSimpleType) simple(
			TypeSystems.GLOBAL, Types.REGEXP);

	public static final IRSimpleType ERROR = (IRSimpleType) simple(
			TypeSystems.GLOBAL, Types.ERROR);

	public static List<IRType> convert(ITypeSystem typeSystem, List<JSType> args) {
		final int size = args.size();
		final List<IRType> parameters = new ArrayList<IRType>(size);
		for (int i = 0; i < size; ++i) {
			parameters.add(create(typeSystem, args.get(i)));
		}
		return parameters;
	}

	/**
	 * Checks if the specified type is {@link #undefined()} or is an union
	 * containing {@link #undefined()}.
	 */
	public static boolean isUndefined(IRType type) {
		if (type == undefined()) {
			return true;
		} else if (type instanceof IRUnionType) {
			return ((IRUnionType) type).getTargets().contains(undefined());
		} else {
			return false;
		}
	}

}
