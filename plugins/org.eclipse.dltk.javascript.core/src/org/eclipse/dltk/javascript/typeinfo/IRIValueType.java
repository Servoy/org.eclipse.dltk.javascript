package org.eclipse.dltk.javascript.typeinfo;

import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;

public interface IRIValueType extends IRType, IRTypeExtension {
	public IValueReference getValue();

	public ReferenceLocation getReferenceLocation();
}
