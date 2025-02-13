package org.eclipse.dltk.javascript.typeinfo;

import java.util.Map;

public interface ImmutableType<T> {

	public T makeImmutable(Map<Object, Object> visited);
}
