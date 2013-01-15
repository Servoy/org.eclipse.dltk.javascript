package org.eclipse.dltk.internal.javascript.ti;

import java.util.StringTokenizer;

import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinfo.IRClassType;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.RTypes;
import org.eclipse.dltk.javascript.typeinfo.model.Type;

public class LazyTypeReference extends AbstractReference {

	final class LazyTypeValue extends Value implements ILazyValue {
		boolean resolved = false;
		private boolean finalResolve;
		private boolean doResolve = true;
		private boolean resolving;

		public void resolve() {
			if (!resolved && doResolve && !resolving) {
				resolving = true;
				doResolve();
				resolving = false;
			}
		}

		private void doResolve() {
			IValueReference createChild = collection.getChild(className);
			if (createChild.exists()
					&& createChild.getAttribute(IReferenceAttributes.RESOLVING) == null) {
				final IRType childType = JavaScriptValidations
						.typeOf(createChild);
				if (childType != null && childType instanceof IRClassType) {
					final Type target = ((IRClassType) childType).getTarget();
					if (target != null) {
						setDeclaredType(RTypes.simple(context, target));
						resolved = true;
						return;
					}
				}
				IValueCollection collection = (IValueCollection) createChild
						.getAttribute(IReferenceAttributes.FUNCTION_SCOPE);
				if (collection != null && collection.getThis() != null) {
					addValue(((IValueProvider) collection.getThis()).getValue());
				} else {
					IValue src = ((IValueProvider) createChild).getValue();
					if (src != null) {
						addValue(src);
					}
				}
				setKind(ReferenceKind.TYPE);
				setDeclaredType(RTypes.create(context, className, createChild));
				resolved = true;
			} else if (className.indexOf('.') != -1) {
				StringTokenizer st = new StringTokenizer(className, ".");
				IValueReference child = null;
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if (child == null) {
						child = collection.getChild(token);
					} else {
						child = child.getChild(token);
					}
					if (!child.exists()) {
						child = null;
						break;
					}
				}
				if (child != null) {
					IValue src = ((IValueProvider) child).getValue();
					if (src != null) {
						// this is a type so try to get the this of the
						// function if this resolves to a function object.
						IValueCollection collection = (IValueCollection) src
								.getAttribute(
										IReferenceAttributes.FUNCTION_SCOPE,
										true);
						if (collection != null)
							addValue(((IValueProvider) collection.getThis())
									.getValue());
						else
							addValue(src);
						setDeclaredType(RTypes.create(context, className,
 child));
					}
					setKind(ReferenceKind.TYPE);
					resolved = true;
				}
			} else {
				doResolve = !finalResolve;
			}
		}

		public String getLazyName() {
			return className;
		}

		public boolean isResolved() {
			return resolved;
		}

		public void setFinalResolve() {
			finalResolve = true;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof LazyTypeValue)
				return ((LazyTypeValue) obj).getLazyName().equals(className);
			return super.equals(obj);
		}

		@Override
		public int hashCode() {
			return className.hashCode();
		}
	}

	private final LazyTypeValue value = new LazyTypeValue();
	final ITypeInferenceContext context;
	final String className;
	final IValueCollection collection;

	public LazyTypeReference(ITypeInferenceContext context, String className,
			IValueCollection collection) {
		this.context = context;
		this.className = className;
		this.collection = collection;

	}

	@Override
	public IValueReference getChild(String name) {
		if (name.equals(IValueReference.FUNCTION_OP))
			return this;
		return super.getChild(name);
	}

	public IValueReference getParent() {
		return null;
	}

	public String getName() {
		return className;
	}

	public void delete(boolean force) {
	}

	public boolean isReference() {
		return true;
	}

	@Override
	public IValue getValue() {
		value.resolve();
		return value;
	}

	@Override
	public boolean exists() {
		value.resolve();
		return value.isResolved();
	}

	@Override
	public IValue createValue() {
		return getValue();
	}

}
