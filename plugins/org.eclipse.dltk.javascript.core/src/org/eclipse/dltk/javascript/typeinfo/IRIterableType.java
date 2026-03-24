package org.eclipse.dltk.javascript.typeinfo;

/**
 * this is an interface that can be implemnted by types that are iterable, so
 * that the type of the items can be retrieved This is different then the
 * IRArrayType because that gives the ItemType of the array elements But that
 * doesn't have to be the same as the iterable type.
 */
public interface IRIterableType extends ImmutableType<IRIterableType> {
	IRType getIterableType();
}
