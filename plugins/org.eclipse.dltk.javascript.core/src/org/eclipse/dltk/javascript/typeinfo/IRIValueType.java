package org.eclipse.dltk.javascript.typeinfo;

import org.eclipse.dltk.internal.javascript.ti.IValue;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;

public interface IRIValueType extends IRType, IRTypeExtension {
	public IValue getValue();

	public ReferenceLocation getReferenceLocation();
}
