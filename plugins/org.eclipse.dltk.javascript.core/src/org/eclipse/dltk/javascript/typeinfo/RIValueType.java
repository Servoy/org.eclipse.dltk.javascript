package org.eclipse.dltk.javascript.typeinfo;

import java.util.Set;

import org.eclipse.dltk.compiler.problem.IValidationStatus;
import org.eclipse.dltk.internal.javascript.ti.IValue;
import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;

class RIValueType extends RType implements IRIValueType {

	private final IValue value;
	private final String name;
	private final ReferenceLocation referenceLocation;

	RIValueType(ITypeSystem typeSystem, String name, IValue value,
			ReferenceLocation referenceLocation) {
		super(typeSystem);
		this.name = name;
		this.value = value;
		this.referenceLocation = referenceLocation;

	}

	public IValue getValue() {
		return value;
	}

	public ReferenceLocation getReferenceLocation() {
		return referenceLocation;
	}

	public IValidationStatus isAssignableFrom(IValueReference argument) {
		Set<IRType> types = JavaScriptValidations.getTypes(argument);
		for (IRType irType : types) {
			if (irType instanceof IRIValueType) {
				if (referenceLocation.equals(((IRIValueType) irType)
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
