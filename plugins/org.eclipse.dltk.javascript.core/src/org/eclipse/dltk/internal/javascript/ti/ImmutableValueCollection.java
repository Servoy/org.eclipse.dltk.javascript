package org.eclipse.dltk.internal.javascript.ti;

import java.util.Map;
import java.util.Set;

import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;

public class ImmutableValueCollection implements IValueCollection,
		IValueProvider {

	public static ImmutableValueCollection getImmutableValueCollection(
			IValueCollection collection, Map<Object, Object> visited) {
		if (collection == null)
			return null;
		ImmutableValueCollection readOnlyCol = (ImmutableValueCollection) visited
				.get(collection);
		if (readOnlyCol != null)
			return readOnlyCol;

		readOnlyCol = new ImmutableValueCollection();
		visited.put(collection, readOnlyCol);

		boolean reference = false;
		IValue value = null;
		if (collection instanceof IValueProvider) {
			reference = ((IValueProvider) collection).isReference();
			value = ((IValueProvider) collection).getValue();
			if (value instanceof Value)
				value = ((Value) value).getImmutableValue(visited);
		}
		IValue thisValue = null;
		if (collection.getThis() instanceof IValueProvider) {
			thisValue = ((IValueProvider) collection.getThis()).getValue();
			if (thisValue instanceof Value)
				thisValue = ((Value) thisValue).getImmutableValue(visited);
		}
		IValue returnValue = null;
		if (collection.getReturnValue() instanceof IValueProvider) {
			returnValue = ((IValueProvider) collection.getReturnValue())
					.getValue();
			if (returnValue instanceof Value)
				returnValue = ((Value) returnValue).getImmutableValue(visited);
		}
		readOnlyCol.init(collection.isScope(), reference,
				getImmutableValueCollection(collection.getParent(), visited),
				value, thisValue, returnValue);
		return readOnlyCol;
	}

	private boolean scope;
	private boolean reference;
	private IValueCollection parent;
	private IValue value;
	private IValueReference thisValue;
	private IValueReference returnValue;

	public ImmutableValueCollection() {
	}

	public void init(boolean scope, boolean reference, IValueCollection parent,
			IValue value, IValue thisValue, IValue returnValue) {
		this.scope = scope;
		this.reference = reference;
		this.parent = parent;
		this.value = value;
		this.thisValue = new AnonymousValue(thisValue);
		this.returnValue = new AnonymousValue(returnValue);
	}

	public boolean isReference() {
		return reference;
	}

	public IValue getValue() {
		return value;
	}

	public IValue createValue() {
		return getValue();
	}

	public final Set<String> getDirectChildren() {
		return getDirectChildren(IValue.DEFAULT);
	}

	public Set<String> getDirectChildren(int flags) {
		return value.getDirectChildren(flags);
	}

	public Set<String> getDeletedChildren() {
		return value.getDeletedChildren();
	}

	public boolean hasChild(String name) {
		IValue value = getValue();
		return value != null && value.getChild(name, true) != null;
	}

	public IValueReference getChild(String name) {
		return new ChildReference(this, name);
	}

	public boolean isScope() {
		return scope;
	}

	public IValueCollection getParent() {
		return parent;
	}

	public IValueReference createChild(String name) {
		return getChild(name);
	}

	public IValueReference getReturnValue() {
		return returnValue;
	}

	public IValueReference getThis() {
		return thisValue;
	}
}
