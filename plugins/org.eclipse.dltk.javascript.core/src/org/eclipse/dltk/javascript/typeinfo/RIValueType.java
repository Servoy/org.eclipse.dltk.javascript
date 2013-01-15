package org.eclipse.dltk.javascript.typeinfo;

import java.util.Set;

import org.eclipse.dltk.compiler.problem.IValidationStatus;
import org.eclipse.dltk.internal.javascript.ti.ChildReference;
import org.eclipse.dltk.internal.javascript.ti.IReferenceAttributes;
import org.eclipse.dltk.internal.javascript.ti.IValueProvider;
import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;

class RIValueType extends RType implements IRIValueType {

	private final IValueReference functionValue;
	private final String name;

	RIValueType(ITypeSystem typeSystem, String name,
			IValueReference functionValue) {
		super(typeSystem);
		this.name = name;
		this.functionValue = functionValue;

	}

	public IValueReference getValue() {
		IValueCollection value = (IValueCollection) functionValue.getAttribute(
				IReferenceAttributes.FUNCTION_SCOPE, false);
		if (value != null) {
			return value.getThis();
		}
		// back up shouldn't happen
		return new ChildReference((IValueProvider) functionValue, name);
	}

	public ReferenceLocation getReferenceLocation() {
		return functionValue.getLocation();
	}

	@Override
	public TypeCompatibility isAssignableFrom(IRType type) {
		if (type instanceof IRIValueType) {
			if (getReferenceLocation().equals(
					((IRIValueType) type).getReferenceLocation())) {
				return TypeCompatibility.TRUE;
			}
		}
		return super.isAssignableFrom(type);
	}

	public IValidationStatus isAssignableFrom(IValueReference argument) {
		Set<IRType> types = JavaScriptValidations.getTypes(argument);
		for (IRType irType : types) {
			if (irType instanceof IRIValueType) {
				if (getReferenceLocation().equals(
						((IRIValueType) irType)
						.getReferenceLocation())) {
					return TypeCompatibility.TRUE;
				}
			}
		}
		return TypeCompatibility.FALSE;
	}

	public String getName() {
		return name;
	}

}
