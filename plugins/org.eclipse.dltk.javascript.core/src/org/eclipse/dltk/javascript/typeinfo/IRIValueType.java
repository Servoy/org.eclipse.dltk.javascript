package org.eclipse.dltk.javascript.typeinfo;

import org.eclipse.dltk.internal.javascript.ti.IValue;

public interface IRIValueType extends IRType, IRTypeExtension {
	public IValue getValue();
}
