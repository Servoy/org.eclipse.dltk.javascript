/*******************************************************************************
 * Copyright (c) 2012 Servoy
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Servoy - initial API and Implementation (Johan Compagner)
 *******************************************************************************/
package org.eclipse.dltk.javascript.typeinfo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IValidationStatus;
import org.eclipse.dltk.internal.javascript.ti.IReferenceAttributes;
import org.eclipse.dltk.internal.javascript.ti.IValue;
import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.PhantomValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;

/**
 * @author jcompagner
 */
class RLocalType extends RType implements IRLocalType {

	private final IValueReference functionValue;
	private final String name;

	RLocalType(String name, IValueReference functionValue) {
		this.name = name;
		this.functionValue = functionValue;
	}

	public IValueReference getValue() {
		IValueCollection value = (IValueCollection) functionValue.getAttribute(
				IReferenceAttributes.FUNCTION_SCOPE, false);
		if (value != null) {
			return value.getThis();
		}
		// backup value, target is not known to be a function.
		return PhantomValueReference.REFERENCE;
	}

	private HashSet<String> recusionCheck = new HashSet<String>();
	
	public IValueReference getDirectChild(String name) {
		if (recusionCheck.contains(name))
			return null;
		recusionCheck.add(name);
		try {
			return getChild(this, name, new HashSet<IRType>());
		} finally {
			recusionCheck.remove(name);
		}
	}

	/**
	 * @param name
	 * @param declaredTypes
	 * @param set
	 */
	private static IValueReference getChildFromDeclaredTypes(String name,
			JSTypeSet declaredTypes, HashSet<IRType> set) {
		for (IRType irType : declaredTypes) {
			if (irType instanceof RLocalType) {
				IValueReference child = getChild((RLocalType) irType, name, set);
				if (child != null)
					return child;
			}
		}
		return null;
	}

	private static IValueReference getChild(RLocalType irType, String name,
			HashSet<IRType> set) {
		if (set.add(irType)) {
			IValueReference declaredValue = irType.getValue();
			if (declaredValue.getDirectChildren(IValue.NO_LOCAL_TYPES)
					.contains(name)) {
				return declaredValue.getChild(name);
			}
			IValueReference fromChild = getChildFromDeclaredTypes(name,
					declaredValue.getDeclaredTypes(), set);
			if (fromChild == null && !PROTOTYPE_PROPERTY.equals(name)) {
				IValueReference prototype = irType.functionValue
						.getChild(PROTOTYPE_PROPERTY);
				fromChild = prototype.getChild(name);
				if (!fromChild.exists())
					fromChild = null;
			}
			return fromChild;
		}
		return null;
	}

	public Set<String> getDirectChildren() {
		Set<String> children = new HashSet<String>();
		fillChildren(this, children, new HashSet<IRType>());
		return children;
	}

	private static void fillChildren(RLocalType rLocalType,
			Set<String> children,
			HashSet<IRType> set) {
		if (set.add(rLocalType)) {
			IValueReference value = rLocalType.getValue();
			children.addAll(value.getDirectChildren(
					IValue.NO_LOCAL_TYPES));
			IValueReference prototype = rLocalType.functionValue
					.getChild(PROTOTYPE_PROPERTY);
			children.addAll(prototype.getDirectChildren());
			fillDeclaredLocalTypesChildren(children, prototype.getTypes(), set);
			fillDeclaredLocalTypesChildren(children, value
					.getDeclaredTypes(), set);
		}
	}

	/**
	 * @param children
	 * @param declaredTypes
	 * @param set
	 */
	private static void fillDeclaredLocalTypesChildren(Set<String> children,
			JSTypeSet declaredTypes, HashSet<IRType> set) {
		for (IRType irType : declaredTypes) {
			if (irType instanceof RLocalType && set.add(irType)) {
				children.addAll(((RLocalType) irType).getValue()
						.getDirectChildren(IValue.NO_LOCAL_TYPES));
				fillDeclaredLocalTypesChildren(children, ((RLocalType) irType)
						.getValue().getDeclaredTypes(), set);
			} else if (irType instanceof RRecordType && set.add(irType)) {
				Collection<IRRecordMember> members = ((RRecordType) irType)
						.getMembers();
				for (IRRecordMember member : members) {
					children.add(member.getName());
				}
			}
		}
	}

	public ReferenceLocation getReferenceLocation() {
		if (functionValue
				.getAttribute(IReferenceAttributes.LOCAL_TYPE_LOCATION) instanceof ReferenceLocation) {
			return (ReferenceLocation) functionValue
					.getAttribute(IReferenceAttributes.LOCAL_TYPE_LOCATION);
		}
		return functionValue.getLocation();
	}

	@Override
	public TypeCompatibility isAssignableFrom(IRType type) {
		if (type instanceof IRLocalType) {
			if (getReferenceLocation().equals(
					((IRLocalType) type).getReferenceLocation())) {
				return TypeCompatibility.TRUE;
			}
		} else if (type instanceof IRSimpleType
				&& ((IRSimpleType) type).getTarget().getKind() == TypeKind.UNKNOWN
				&& type.getName().equals(getName())) {
			// if this RSimpleType was a result of an IRIValueType not being
			// able to be resolved. just make this assignable if this type is
			// unknown and has the same name..
			// this happens when you have something like @return {init.Node} as
			// function doc, and that Node is not there yet.
			// see also RSimpleType.isAssignableFrom
			return TypeCompatibility.TRUE;
		}
		return super.isAssignableFrom(type);
	}

	public IValidationStatus isAssignableFrom(IValueReference argument) {
		if (argument == null)
			return TypeCompatibility.TRUE;
		Set<IRType> types = JavaScriptValidations.getTypes(argument);
		return testLocation(types, new HashSet<IRType>());
	}

	/**
	 * @param types
	 */
	private IValidationStatus testLocation(Iterable<IRType> types,
			HashSet<IRType> set) {
		for (IRType irType : types) {
			if (irType instanceof IRLocalType && set.add(irType)) {
				if (getReferenceLocation().equals(
						((IRLocalType) irType).getReferenceLocation())) {
					return TypeCompatibility.TRUE;
				}
				
				IValidationStatus status = testLocation(((IRLocalType) irType)
						.getValue().getDeclaredTypes(), set);
				if (status == TypeCompatibility.TRUE)
					return status;
			}
		}
		return TypeCompatibility.FALSE;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RLocalType) {
			return getReferenceLocation().equals(
					((RLocalType) obj).getReferenceLocation());
		}
		return false;
	}
}
