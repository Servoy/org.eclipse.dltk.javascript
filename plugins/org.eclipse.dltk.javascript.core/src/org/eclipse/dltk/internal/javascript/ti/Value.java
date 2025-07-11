/*******************************************************************************
 * Copyright (c) 2010 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.internal.javascript.ti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.dltk.javascript.core.JavaScriptPlugin;
import org.eclipse.dltk.javascript.core.Types;
import org.eclipse.dltk.javascript.typeinference.IAssignProtection;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IRProperty;
import org.eclipse.dltk.javascript.typeinfo.IRSimpleType;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.ImmutableType;
import org.eclipse.dltk.javascript.typeinfo.JSTypeSet;
import org.eclipse.dltk.javascript.typeinfo.ReferenceSource;
import org.eclipse.dltk.javascript.typeinfo.model.Type;

public class Value extends ImmutableValue {

	public Value() {
	}

	public Value(ImmutableValue value) {
		super(value);
	}

	@Override
	public void setDeclaredType(IRType declaredType) {
		this.declaredType = declaredType;
	}

	@Override
	public void addType(IRType type) {
		if (type != null) {
			this.types.add(type);
		}
	}

	@Override
	public void setKind(ReferenceKind kind) {
		this.kind = kind;
	}

	@Override
	public void setLocation(ReferenceLocation location) {
		this.location = location;
	}

	@Override
	public void setAttribute(String key, Object value) {
		if (value != null) {
			if (attributes == null) {
				attributes = new HashMap<String, Object>();
			}
			attributes.put(key, value);
		} else {
			if (attributes != null) {
				attributes.remove(key);
			}
		}
	}

	@Override
	public void deleteChild(String name, boolean force) {
		if (force) {
			children.remove(name);
			inherited.remove(name);
		} else {
			if (deletedChildren == null) {
				deletedChildren = new HashSet<String>();
			}
			deletedChildren.add(name);
		}
	}

	@Override
	public void putChild(String name, IValue value) {
		inherited.put(name, value);
	}

	private static class CreateChildOperation implements Handler<Set<IValue>> {

		private final String childName;

		public CreateChildOperation(String childName) {
			this.childName = childName;
		}

		public void process(ImmutableValue value, Set<IValue> result) {
			if (result.isEmpty() && !value.hasReferences()) {
				IValue child = value.createChild(childName, 0);
				if (child != null)
					result.add(child);
			}
		}

	}

	@Override
	public IValue createChild(String name, int flags) {
		IValue child = children.get(name);
		if (child == null) {
			child = inherited.get(name);
			if (child == null) {
				if ((flags & CREATE) == 0) {
					// creating new child, so ignore external elements
					child = findMember(name, false);
					if (child != null) {
						return child;
					}
				}
				if (hasReferences()) {
					Set<IValue> result = new HashSet<IValue>();
					execute(this, new CreateChildOperation(name), result,
							new HashSet<IValue>());
					if (!result.isEmpty()) {
						return result.iterator().next();
					}
				}
				child = new Value();
				children.put(name, (Value) child);
				childCreated(name);
			}
		}
		return child;
	}

	protected void childCreated(String name) {
		if (elementValues != null) {
			elementValues.remove(name);
		}
		if (deletedChildren != null) {
			deletedChildren.remove(name);
		}
	}

	@Override
	public void clear() {
		references.clear();
		children.clear();
		inherited.clear();
		types.clear();
	}

	@SuppressWarnings("serial")
	static class DeepValueRecursionException extends RuntimeException {
	}

	private static final ThreadLocal<AtomicBoolean> recursionErrorReported = new ThreadLocal<AtomicBoolean>() {
		@Override
		protected AtomicBoolean initialValue() {
			return new AtomicBoolean();
		}
	};

	@Override
	public void addValue(IValue src) {
		if (src instanceof ImmutableValue) {
			final IdentityHashMap<ImmutableValue, ImmutableValue> processing = new IdentityHashMap<ImmutableValue, ImmutableValue>();
			try {
				addValueRecursive((ImmutableValue) src, processing, 0);
			} catch (DeepValueRecursionException e) {
				e.printStackTrace();
				if (recursionErrorReported.get().compareAndSet(false, true)) {
					String msg = "Deep recursion while copying the value";
					final ReferenceSource source = ITypeSystem.CURRENT
							.getCurrentSource();
					if (source != null) {
						msg += " when processing " + source;
					}
					JavaScriptPlugin.error(msg, e);
				}
			}
			// translate references, so they point to the new value
			for (Map.Entry<ImmutableValue, ImmutableValue> entry : processing
					.entrySet()) {
				final ImmutableValue input = entry.getKey();
				final ImmutableValue output = entry.getValue();
				for (IValue ref : input.references) {
					IValue refOut = processing.get(ref);
					if (refOut == null) {
						refOut = ref;
					}
					output.references.add(refOut);
				}
			}
		} else {
			// ElementValue is handled in this branch.
			final IRType srcType = src.getDeclaredType();
			if (srcType != null) {
				types.add(srcType);
			}
			types.addAll(src.getTypes());
			if (src.getKind() == ReferenceKind.METHOD) {
				final Object element = src.getAttribute(
						IReferenceAttributes.ELEMENT, false);
				if (element != null) {
					setAttribute(IReferenceAttributes.ELEMENT, element);
				}
				final IValue returnType = src.getChild(
						IValueReference.FUNCTION_OP, false);
				if (returnType != null) {
					final JSTypeSet myReturnTypes = createChild(
							IValueReference.FUNCTION_OP, 0).getTypes();
					myReturnTypes.addAll(returnType.getTypes());
					myReturnTypes.addAll(returnType.getDeclaredTypes());
				}
			} else if (src.getKind() == ReferenceKind.PROPERTY
					&& !isPrimitiveValue(srcType)) {
				/*
				 * to optimize memory usage remember *static non-primitive
				 * properties* only
				 */
				final Object element = src.getAttribute(
						IReferenceAttributes.ELEMENT, false);
				if (element != null && element instanceof IRProperty
						&& ((IRProperty) element).isStatic()) {
					setAttribute(IReferenceAttributes.ELEMENT, element);
				}
			}
		}
	}

	@Override
	public void mergeValue(IValue src) {
		if (src instanceof ImmutableValue) {
			ImmutableValue val = (ImmutableValue) src;
			if (val.attributes != null && val.attributes.size() > 0) {
				if (this.attributes == null) {
					this.attributes = new HashMap<String, Object>(
							val.attributes);
				} else {
					this.attributes.putAll(val.attributes);
				}
				// do not copy over the assign protection attribute
				if (val.attributes != null && val.attributes
						.containsKey(IAssignProtection.ATTRIBUTE)) {
					this.attributes.remove(IAssignProtection.ATTRIBUTE);
				}
			}
			if (val.deletedChildren != null && val.deletedChildren.size() > 0) {
				if (this.deletedChildren == null) {
					this.deletedChildren = new HashSet<String>(
							val.deletedChildren);
				} else {
					this.deletedChildren.addAll(val.deletedChildren);
				}
			}

			this.children.putAll(val.children);
			this.inherited.putAll(val.inherited);
			this.references.addAll(val.references);
			this.types.addAll(val.types);
			if (this.declaredType == null)
				this.declaredType = val.declaredType;
			if (this.kind == ReferenceKind.UNKNOWN)
				this.kind = val.kind;
			if (this.location == ReferenceLocation.UNKNOWN)
				this.location = val.location;

		} else {
			addValue(src);
		}
	}

	private static boolean isPrimitiveValue(IRType type) {
		if (type instanceof IRSimpleType) {
			final Type target = ((IRSimpleType) type).getTarget();
			return target == Types.BOOLEAN || target == Types.STRING
					|| target == Types.NUMBER;
		} else {
			return false;
		}
	}

	@Override
	public void addReference(IValue src) {
		assert src != null;
		if (src == this)
			return;
		references.add(src);
	}

	@Override
	public void removeReference(IValue value) {
		references.remove(value);
	}

	private void addValueRecursive(ImmutableValue src,
			Map<ImmutableValue, ImmutableValue> processing, int depth) {
		if (!processing.containsKey(src)) {
			processing.put(src, this);
			if (depth > 8) {
				throw new DeepValueRecursionException();
			}

			// (references will be copied later)
			if (src.attributes != null) {
				if (attributes == null) {
					attributes = new HashMap<String, Object>();
				}
				attributes.putAll(src.attributes);
			}
			for (Map.Entry<String, ImmutableValue> entry : src.children
					.entrySet()) {
				IValue child = createChild(entry.getKey(), 0);
				if (child instanceof Value) {
					((Value) child).addValueRecursive(entry.getValue(),
							processing, depth + 1);
				}
			}

			// this has to be done after the children are copied, because else
			// createChild will get it from de declared type
			if (declaredType == null) {
				declaredType = src.declaredType;
			} else if (src.declaredType != null) {
				types.add(src.declaredType);
			}
			types.addAll(src.types);

			if (src.kind != ReferenceKind.UNKNOWN
					&& kind == ReferenceKind.UNKNOWN) {
				kind = src.kind;
			}
			if (src.location != ReferenceLocation.UNKNOWN
					&& location == ReferenceLocation.UNKNOWN) {
				location = src.location;
			} else if (src.location != ReferenceLocation.UNKNOWN
					&& src.declaredType != null
					&& src.kind == ReferenceKind.FUNCTION) {
				// if src location is known and the src is a function, then we
				// need to remember the location if this function is used as a
				// local type (through the assignment)
				if (attributes == null) {
					attributes = new HashMap<String, Object>();
				}
				attributes.put(IReferenceAttributes.LOCAL_TYPE_LOCATION,
						src.location);
			}
		}
		else {
			mergeValue(src);
		}
	}

	public void putDirectChild(String name, ImmutableValue value) {
		children.put(name, value);
	}

	public void copyChilds(ImmutableValue value) {
		if (value.hasReferences()) {
			execute(value, new Handler<Map<String, ImmutableValue>>() {
				public void process(ImmutableValue value,
						Map<String, ImmutableValue> result) {
					result.putAll(value.children);
				};
			}, this.children, new HashSet<IValue>());
		} else {
			this.children.putAll(value.children);
		}
	}

	public void resolveLazyValues(Set<Value> visited) {
		if (visited.add(this)) {
			for (IValue value : references) {
				if (value instanceof ILazyValue
						&& !((ILazyValue) value).isResolved()) {
					((ILazyValue) value).setFinalResolve();
				} else if (value instanceof Value) {
					((Value) value).resolveLazyValues(visited);
				}
			}
			for (ImmutableValue value : children.values()) {
				if (value instanceof Value)
					((Value) value).resolveLazyValues(visited);
			}

			if (attributes != null) {
				for (Object attibute : attributes.values()) {
					if (attibute instanceof IValueProvider) {
						IValue value = ((IValueProvider) attibute).getValue();
						if (value instanceof Value) {
							((Value) value).resolveLazyValues(visited);
						}
					}
				}
			}
		}
	}

	public ImmutableValue getImmutableValue(Map<Object, Object> visited) {
		ImmutableValue immutableValue = (ImmutableValue) visited.get(this);
		if (immutableValue != null)
			return immutableValue;

		if (this instanceof ILazyValue) {
			((ILazyValue) this).resolve();
		}

		Set<String> deletedChilds = null;
		if (deletedChildren != null) {
			deletedChilds = Set.copyOf(deletedChildren);
		}

		Map<String, ImmutableValue> childs = new HashMap<String, ImmutableValue>(
				children.size(), 0.9f);
		Map<String, IValue> inherits = new HashMap<String, IValue>(
				inherited.size(), 0.9f);
		Set<IValue> refers = new HashSet<IValue>(references.size(), 0.9f);
		Map<String, Object> atts = null;
		if (attributes != null) {
			atts = new HashMap<String, Object>(attributes.size(), 0.9f);
		}

		JSTypeSet typeSet = JSTypeSet.create();
		immutableValue = new ImmutableValue(declaredType, typeSet,
				deletedChilds, kind, location, childs, inherits, refers, atts);
		// store this in the visited map to make sure this value is used when it
		// is referenced again
		visited.put(this, immutableValue);

		// now go over all the values to make them lazy.
		Map<String, IValue> elementValuesCopy = null;
		if (elementValues != null && !elementValues.isEmpty()) {
				elementValuesCopy = new HashMap<String, IValue>(
						elementValues.size(), 0.9f);
				for (Entry<String, IValue> entry : elementValues.entrySet()) {
					IValue value = entry.getValue();
					if (value instanceof Value v) {
						elementValuesCopy.put(entry.getKey(),
								v.getImmutableValue(visited));
					} else if (value instanceof ImmutableType<?> v) {
						elementValuesCopy.put(entry.getKey(),
								(IValue) v.makeImmutable(visited));
					} else {
						elementValuesCopy.put(entry.getKey(), value);
					}
				}
		}
		immutableValue.elementValues = elementValuesCopy;

		// fill the types, making sure local types are made immutable
		for (IRType irType : this.types) {
			if (irType instanceof ImmutableType<?> local) {
				irType = (IRType) local.makeImmutable(visited);
			}
			typeSet.add(irType);
		}
		// if the declared type is of IRLocalTyp make sure that is made
		// immutable to and overwrite the declared type
		if (declaredType instanceof ImmutableType<?> local) {
			IRType decl = (IRType) local.makeImmutable(visited);
			immutableValue.declaredType = decl;
		}

		if (attributes != null) {
			for (Map.Entry<String, Object> entry : attributes.entrySet()) {
				if (entry.getValue() instanceof Value v) {
					atts.put(entry.getKey(), v.getImmutableValue(visited));
				} else if (entry.getValue() instanceof IValueCollection vc) {
					atts.put(entry.getKey(), ImmutableValueCollection
							.getImmutableValueCollection(vc, visited));

				} else if (entry.getValue() instanceof AbstractReference) {
					atts.put(entry.getKey(), entry.getValue());
				} else if (entry
						.getValue() instanceof ImmutableType<?> method) {
					atts.put(entry.getKey(), method.makeImmutable(visited));
				} else {
					atts.put(entry.getKey(), entry.getValue());
				}
			}
		}

		for (IValue value : references) {
			if (value instanceof Value v) {
				refers.add(v.getImmutableValue(visited));
			} else if (value instanceof ImmutableType<?> v) {
				refers.add((IValue) v.makeImmutable(visited));
			} else {
				refers.add(value);
			}
		}

		for (Map.Entry<String, ImmutableValue> entry : children.entrySet()) {
			ImmutableValue value = entry.getValue();
			if (value instanceof Value v) {
				childs.put(entry.getKey(),
						v.getImmutableValue(visited));
			} else if (value instanceof ImmutableType<?> v) {
				childs.put(entry.getKey(),
						(ImmutableValue) v.makeImmutable(visited));
			} else {
				childs.put(entry.getKey(), value);
			}
		}

		for (Map.Entry<String, IValue> entry : inherited.entrySet()) {
			IValue value = entry.getValue();
			if (value instanceof Value v)
				inherits.put(entry.getKey(),
						v.getImmutableValue(visited));
			else if (value instanceof ImmutableType<?> v)
				inherits.put(entry.getKey(),
						(ImmutableValue) v.makeImmutable(visited));
			else
				inherits.put(entry.getKey(), value);
		}

		// now make all those maps small (and immutable by itself)
		immutableValue.children = Map.copyOf(immutableValue.children);
		immutableValue.inherited = Map.copyOf(immutableValue.inherited);
		immutableValue.references = Set.copyOf(immutableValue.references);
		if (immutableValue.attributes != null)
			immutableValue.attributes = Map.copyOf(immutableValue.attributes);
		return immutableValue;
	}

}
