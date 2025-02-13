package org.eclipse.dltk.internal.javascript.ti;

import java.util.HashMap;
import java.util.HashSet;

public class ValueWithElementValue extends ImmutableValue {

	private final ElementValue elementValue;

	public ValueWithElementValue(ImmutableValue value, ElementValue elementValue) {
		this.elementValue = elementValue;
		if (value.attributes != null)
			attributes = new HashMap<String, Object>(value.attributes);
		this.children.putAll(value.children);
		this.declaredType = value.declaredType;
		if (value.deletedChildren != null)
			deletedChildren = new HashSet<String>(value.deletedChildren);
		this.inherited.putAll(value.inherited);
		this.kind = value.kind;
		this.location = value.location;
		this.references.addAll(value.references);
		this.types.addAll(value.types);
	}

	@Override
	public Object getAttribute(String key, boolean includeReferences) {
		Object attribute = elementValue.getAttribute(key, includeReferences);
		if (attribute == null)
			attribute = super.getAttribute(key, includeReferences);
		return attribute;
	}

	@Override
	public IValue getChild(String name, boolean resolve) {
		IValue child = elementValue.getChild(name, resolve);
		if (child == null)
			child = super.getChild(name, resolve);
		return child;
	}

}
