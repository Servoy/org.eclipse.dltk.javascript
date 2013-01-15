package org.eclipse.dltk.javascript.typeinfo;

import org.eclipse.dltk.compiler.problem.IValidationStatus;
import org.eclipse.dltk.internal.javascript.ti.IValue;
import org.eclipse.dltk.javascript.typeinference.IValueReference;

class RIValueType extends RType implements IRIValueType {

	private final IValue value;
	private final String name;

	RIValueType(ITypeSystem typeSystem, String name, IValue value) {
		super(typeSystem);
		this.name = name;
		this.value = value;

	}

	public IValue getValue() {
		return value;
	}

	public IValidationStatus isAssignableFrom(IValueReference argument) {
		return null;
	}

	public String getName() {
		return name;
	}

}
