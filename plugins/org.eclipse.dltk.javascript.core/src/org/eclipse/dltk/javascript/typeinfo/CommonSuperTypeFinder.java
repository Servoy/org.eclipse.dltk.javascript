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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.dltk.annotations.Nullable;
import org.eclipse.dltk.javascript.core.Types;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelLoader;

/**
 * Finds the least common supertype among the specified type expressions or
 * declarations. Only supertypes are considered at the moment, implemented
 * traits (interfaces) are not checked.
 * <p>
 * There are 2 entry points: {@link #evaluate(Collection)} which works with type
 * expressions and {@link #leastCommonSuperType(List)} which works with type
 * declarations.
 * </p>
 */
public class CommonSuperTypeFinder {

	static class State {
		int anyCount;
		final Set<IRSimpleType> simpleTypes = new HashSet<IRSimpleType>();
		final Set<IRClassType> classTypes = new HashSet<IRClassType>();
		final Set<IRArrayType> arrayTypes = new HashSet<IRArrayType>();
		final Set<IRMapType> mapTypes = new HashSet<IRMapType>();
		final Set<IRLocalType> localTypes = new HashSet<IRLocalType>();
		final Set<IRRecordType> recordTypes = new HashSet<IRRecordType>();
		final Set<IRType> others = new HashSet<IRType>();

		void addAll(Collection<? extends IRType> types) {
			for (IRType type : types) {
				add(type);
			}
		}

		void add(IRType type) {
			if (type == RTypes.none() || type == RTypes.undefined()) {
				return; // just ignore
			} else if (type == RTypes.any()) {
				++anyCount;
			} else if (type instanceof IRUnionType) {
				addAll(((IRUnionType) type).getTargets()); // expand
			} else if (type instanceof IRArrayType) {
				arrayTypes.add((IRArrayType) type);
			} else if (type instanceof IRSimpleType) {
				simpleTypes.add((IRSimpleType) type);
			} else if (type instanceof IRClassType) {
				classTypes.add((IRClassType) type);
			} else if (type instanceof IRMapType) {
				mapTypes.add((IRMapType) type);
			} else if (type instanceof IRLocalType) {
				localTypes.add((IRLocalType) type);
			} else if (type instanceof IRRecordType) {
				recordTypes.add((IRRecordType) type);
			} else {
				others.add(type);
			}
		}

		private int countCollections() {
			int result = 0;
			if (!simpleTypes.isEmpty())
				++result;
			if (!classTypes.isEmpty())
				++result;
			if (!arrayTypes.isEmpty())
				++result;
			if (!mapTypes.isEmpty())
				++result;
			if (!localTypes.isEmpty())
				++result;
			if (!recordTypes.isEmpty())
				++result;
			if (!others.isEmpty())
				++result;
			return result;
		}

		private boolean areJavaScriptObjects(Collection<? extends IRType> types) {
			for (IRType type : types) {
				if (!type.isJavaScriptObject()) {
					return false;
				}
			}
			return true;
		}

		private boolean areJavaScriptObjects() {
			// arrays & maps are always JS, check other sets
			return areJavaScriptObjects(simpleTypes)
					&& areJavaScriptObjects(classTypes)
					&& areJavaScriptObjects(others);
		}

		IRType find(ITypeSystem typeSystem) {
			if (anyCount != 0) {
				return RTypes.any();
			}
			if (countCollections() != 1) {
				return areJavaScriptObjects() ? RTypes.OBJECT : RTypes.any();
			}
			if (!simpleTypes.isEmpty()) {
				if (simpleTypes.size() == 1) {
					return getSingleItem(simpleTypes);
				}
				final List<IRTypeDeclaration> declarations = new ArrayList<IRTypeDeclaration>();
				for (IRSimpleType type : simpleTypes) {
					declarations.add(type.getDeclaration());
				}
				final IRTypeDeclaration common = leastCommonSuperType(declarations);
				return common != null ? RTypes.simple(common) : RTypes.any();
			} else if (!classTypes.isEmpty()) {
				if (classTypes.size() == 1) {
					return getSingleItem(classTypes);
				}
				final List<IRTypeDeclaration> declarations = new ArrayList<IRTypeDeclaration>();
				for (IRClassType type : classTypes) {
					if (type.getDeclaration() == null) {
						return type;
					}
					declarations.add(type.getDeclaration());
				}
				return RTypes.classType(leastCommonSuperType(declarations));
			} else if (!arrayTypes.isEmpty()) {
				if (arrayTypes.size() == 1) {
					return getSingleItem(arrayTypes);
				}
				final Set<IRType> itemTypes = new HashSet<IRType>();
				for (IRArrayType type : arrayTypes) {
					// TODO (alex) skip empty arrays
					itemTypes.add(type.getItemType());
				}
				return RTypes.arrayOf(typeSystem,
						evaluate(typeSystem, itemTypes));
			} else if (!mapTypes.isEmpty()) {
				if (mapTypes.size() == 1) {
					return getSingleItem(mapTypes);
				}
				final Set<IRType> itemTypes = new HashSet<IRType>();
				for (IRMapType type : mapTypes) {
					itemTypes.add(type.getValueType());
				}
				return RTypes.mapOf(RTypes.STRING,
						evaluate(typeSystem, itemTypes),
						typeSystem.convert(Types.MAP));
			} else if (!localTypes.isEmpty()) {
				if (localTypes.size() == 1) {
					return getSingleItem(localTypes);
				}
				final Set<ReferenceLocation> locations = new HashSet<ReferenceLocation>();
				for (IRLocalType type : localTypes) {
					locations.add(type.getReferenceLocation());
				}
				// TODO super type check?
				return locations.size() == 1 ? localTypes.iterator().next()
						: RTypes.OBJECT;
			} else if (!recordTypes.isEmpty()) {
				if (recordTypes.size() == 1) {
					return getSingleItem(recordTypes);
				}
				List<IRRecordMember> commonMembers = new ArrayList<IRRecordMember>();
				for (IRRecordType type : recordTypes) {
					if (commonMembers.size() == 0)
						commonMembers.addAll(type.getMembers());
					else {
						commonMembers.retainAll(type.getMembers());
					}
				}
				return commonMembers.size() == 0 ? RTypes.OBJECT : RTypes
						.recordType(commonMembers);
			} else {
				assert !others.isEmpty();
				if (others.size() == 1) {
					return getSingleItem(others);
				}
				// TODO (alex) better support for record types
				return RTypes.OBJECT;
			}
		}

	}

	/**
	 * Returns the least common super type among the specified type expressions
	 * or {@link RTypes#any()}.
	 */
	public static IRType evaluate(ITypeSystem typeSystem,
			Collection<? extends IRType> types) {
		if (types.isEmpty()) {
			return RTypes.any();
		} else {
			if (types.size() == 1) {
				final IRType type = getSingleItem(types);
				if (!(type instanceof IRUnionType)) {
					return type;
				}
			}
			final State state = new State();
			state.addAll(types);
			return state.find(typeSystem);
		}
	}

	/**
	 * Returns the least common super type among the specified
	 * {@link IRTypeDeclaration}s or null, if no such type could be found.
	 */
	@Nullable
	public static IRTypeDeclaration leastCommonSuperType(
			List<IRTypeDeclaration> declarations) {
		if (declarations.isEmpty()) {
			return null;
		} else if (declarations.size() == 1) {
			return declarations.get(0);
		}
		// initial hierarchy based on the 0th type
		final List<IRTypeDeclaration> hierarchy = new ArrayList<IRTypeDeclaration>();
		for (IRTypeDeclaration d = declarations.get(0);;) {
			hierarchy.add(d);
			d = d.getSuperType();
			if (d == null)
				break;
		}
		Collections.reverse(hierarchy);
		// handle others starting from the 1st type
		for (int i = 1; i < declarations.size(); ++i) {
			for (IRTypeDeclaration declaration = declarations.get(i);;) {
				final int index = hierarchy.lastIndexOf(declaration);
				if (index >= 0) { // common type found, remove the tail
					for (int j = hierarchy.size(); --j > index;) {
						hierarchy.remove(j);
					}
					break; // ... and handle the next type
				}
				declaration = declaration.getSuperType();
				if (declaration == null) { // no common type found
					// TODO (alex) check mixed java/javascript case
					return RTypes.OBJECT.getDeclaration();
				}
			}
		}
		return hierarchy.get(hierarchy.size() - 1);
	}

	@SuppressWarnings("unchecked")
	static <T> T getSingleItem(Collection<T> values) {
		assert values.size() == 1;
		if (values instanceof List) {
			return ((List<T>) values).get(0);
		} else {
			return (T) values.toArray()[0];
		}
	}

}
