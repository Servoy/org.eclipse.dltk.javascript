package org.eclipse.dltk.internal.javascript.ti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IMemberEvaluator;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.JSTypeSet;
import org.eclipse.dltk.javascript.typeinfo.TypeInfoManager;
import org.eclipse.dltk.javascript.typeinfo.model.Type;

public class LazyEvaluatorValue extends ImmutableValue implements ILazyValue {

	private final ITypeInferenceContext context;
	private final Type type;
	private boolean resolved = false;

	public LazyEvaluatorValue(ITypeInferenceContext context, Type type) {
		this.context = context;
		this.type = type;
	}

	@Override
	public boolean isResolved() {
		return resolved;
	}

	public void resolve() {
		if (resolved)
			return;
		resolved = true;
		for (IMemberEvaluator evaluator : TypeInfoManager
				.getMemberEvaluators()) {
			final IValueCollection collection = evaluator.valueOf(context,
					type);
			if (collection != null) {
				if (collection instanceof IValueProvider) {
					mergeValue(((IValueProvider) collection).getValue());
				}
			}
		}
	}

	@Override
	public void mergeValue(IValue src) {
		ImmutableValue val = (ImmutableValue) src;
		if (val.attributes != null && val.attributes.size() > 0) {
			if (this.attributes == null) {
				this.attributes = new HashMap<String, Object>(val.attributes);
			} else {
				this.attributes.putAll(val.attributes);
			}
		}
		if (val.deletedChildren != null && val.deletedChildren.size() > 0) {
			if (this.deletedChildren == null) {
				this.deletedChildren = new HashSet<String>(val.deletedChildren);
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

	}

	@Override
	public Object getAttribute(String key, boolean includeReferences) {
		resolve();
		return super.getAttribute(key, includeReferences);
	}

	@Override
	public IValue getChild(String name, boolean resolve) {
		resolve();
		return super.getChild(name, resolve);
	}

	@Override
	public IRType getDeclaredType() {
		resolve();
		return super.getDeclaredType();
	}

	@Override
	public JSTypeSet getDeclaredTypes() {
		resolve();
		return super.getDeclaredTypes();
	}

	@Override
	public Set<String> getDeletedChildren() {
		resolve();
		return super.getDeletedChildren();
	}

	@Override
	public Set<String> getDirectChildren(int flags) {
		resolve();
		return super.getDirectChildren(flags);
	}

	@Override
	public ReferenceKind getKind() {
		resolve();
		return super.getKind();
	}

	@Override
	public ReferenceLocation getLocation() {
		resolve();
		return super.getLocation();
	}

	@Override
	public Set<? extends IValue> getReferences() {
		resolve();
		return super.getReferences();
	}

	@Override
	public JSTypeSet getTypes() {
		resolve();
		return super.getTypes();
	}

	@Override
	public String getLazyName() {
		return null;
	}

	@Override
	public void setFinalResolve() {
	}
}
