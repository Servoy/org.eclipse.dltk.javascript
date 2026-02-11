package org.eclipse.dltk.javascript.typeinference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.internal.javascript.ti.IValue;
import org.eclipse.dltk.internal.javascript.ti.IValueProvider;
import org.eclipse.dltk.internal.javascript.ti.ImmutableValue;
import org.eclipse.dltk.internal.javascript.ti.ImmutableValueCollection;
import org.eclipse.dltk.internal.javascript.ti.NestedValueCollection;
import org.eclipse.dltk.internal.javascript.ti.ThisValue;
import org.eclipse.dltk.internal.javascript.ti.TopValueCollection;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencer2;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencerVisitor;
import org.eclipse.dltk.internal.javascript.ti.Value;
import org.eclipse.dltk.internal.javascript.ti.ValueCollection;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.parser.JavaScriptParserUtil;
import org.eclipse.dltk.javascript.typeinfo.IRType;

public class ValueCollectionFactory {

	/**
	 * @return a standard none scoped {@link IValueCollection}
	 */
	public static IValueCollection createValueCollection() {
		return new ValueCollection(null, new Value()) {

			public boolean isScope() {
				return false;
			}
		};
	}

	/**
	 * @return a standard none scoped {@link IValueCollection}
	 */
	public static IValueCollection createValueCollection(IRType thisType) {
		final ThisValue thisValue = new ThisValue();
		thisValue.setDeclaredType(thisType);
		return new ValueCollection(null, new Value()) {

			public boolean isScope() {
				return false;
			}

			@Override
			public IValueReference getThis() {
				return thisValue;
			}
		};
	}

	/**
	 * @param collection
	 *            the {@link IValueCollection} to clone.
	 * 
	 * @return the copy of the given collection {@link IValueCollection}
	 */
	public static IValueCollection shallowCloneValueCollection(
			IValueCollection collection) {
		ImmutableValue value = (ImmutableValue) ((IValueProvider) collection)
				.getValue();
		final boolean isScope = collection.isScope();
		return new ValueCollection(collection.getParent(), new Value(value)) {
			public boolean isScope() {
				return isScope;
			}
		};
	}

	/**
	 * @return a standard none scoped {@link IValueCollection} that gets a
	 *         parent.
	 */
	public static IValueCollection createValueCollection(IValueCollection parent) {
		return new ValueCollection(parent, new Value()) {

			public boolean isScope() {
				return false;
			}
		};
	}

	/**
	 * @return a standard scoped {@link IValueCollection}
	 */
	public static IValueCollection createScopeValueCollection() {
		return new ValueCollection(null, new Value()) {

			public boolean isScope() {
				return true;
			}
		};
	}

	/**
	 * @return a standard scoped {@link IValueCollection} that gets a parent.
	 */
	public static IValueCollection createScopeValueCollection(
			IValueCollection parent) {
		return new ValueCollection(parent, new Value()) {

			public boolean isScope() {
				return true;
			}
		};
	}

	private static final ThreadLocal<ValueCollectionReferenceStack> stack = new ThreadLocal<>() {
		protected ValueCollectionReferenceStack initialValue() {
			return new ValueCollectionReferenceStack();
        }
	};

	/**
	 * Parses the give file into a {@link Script}, if that can be resolved then
	 * the {@link Script} will be parsed by an inferencer Will return the result
	 * as an {@link IValueCollection}
	 * 
	 * @param file
	 *            the file to parse/inference
	 * @param resolve
	 *            Must the Inferencer resolve all elements, set to false if you
	 *            want to avoid circular references.
	 * @return The {@link IValueCollection} of the parsed/inference'd file
	 */
	public static IValueCollectionReference createValueCollection(
			final IFile file,
			boolean resolve, boolean visitFunctionBody,
			final IPreStart preStart) {
		if (file.exists()) {
			ValueCollectionReferenceStack refStack = stack.get();
			final IValueCollectionReference currentFileCollection = refStack.executingFiles
					.get(file);
			// file already in progres for this stack return that one.
			if (currentFileCollection != null)
				return currentFileCollection;
			ISourceModule sourceModule = DLTKCore.createSourceModuleFrom(file);
			Script script = JavaScriptParserUtil.parse(sourceModule);
			if (script != null) {
				final ValueCollectionReference valueCollectionReference = new ValueCollectionReference();
				refStack.executingFiles.put(file, valueCollectionReference);
				TypeInferencer2 inferencer = new TypeInferencer2();
				inferencer.setVisitor(new TypeInferencerVisitor(inferencer,
						visitFunctionBody) {
					protected void initializeCollection(
							TopValueCollection topCollection) {
						valueCollectionReference.collection = topCollection;
						if (preStart.aboutToStart(file,
								valueCollectionReference))
							super.initializeCollection(topCollection);
					}
				});
				inferencer.setModelElement(sourceModule);
				inferencer.setDoResolve(resolve);
				inferencer.setVisitFunctionBody(visitFunctionBody);
				inferencer.doInferencing(script);

				refStack.fileDone(file, inferencer);
				return valueCollectionReference;
			}
		}
		return null;
	}

	/**
	 * Make a immutable collection of the give collection.
	 * 
	 * @param collection
	 * 
	 * @return the immutable value collection
	 */
	public static IValueCollection makeImmutable(IValueCollection collection) {
		return ImmutableValueCollection.getImmutableValueCollection(collection,
				new HashMap<Object, Object>());
	}

	/**
	 * copies/merges the source {@link IValueCollection} into the target
	 * {@link IValueCollection}
	 * 
	 * @param target
	 * @param source
	 */
	public static void copyInto(IValueCollection target, IValueCollection source) {
		if (target instanceof IValueProvider
				&& source instanceof IValueProvider) {
			IValue targetValue = ((IValueProvider) target).getValue();
			IValue sourceValue = ((IValueProvider) source).getValue();
			targetValue.mergeValue(sourceValue);
		}
	}

	public static IValueCollection createNestedScopeValueCollection(
			IValueCollection parent) {
		return new NestedValueCollection(parent) {

			public boolean isScope() {
				return true;
			}
		};
	}

	private final static class ValueCollectionReferenceStack {
		private final Map<IFile, ValueCollectionReference> executingFiles = new HashMap<>();
		private final List<ValueCollectionReference> done = new ArrayList<>();

		private void fileDone(IFile file, TypeInferencer2 inferencer) {
			ValueCollectionReference reference = executingFiles.remove(file);
			reference.inferencer = inferencer;
			done.add(reference);
			if (executingFiles.isEmpty()) {
				List<ValueCollectionReference> copy = List.copyOf(done);
				done.clear();
				for (ValueCollectionReference ref : copy) {
					ref.collection = ValueCollectionFactory
							.makeImmutable(ref.inferencer.getCollection());
					ref.inferencer.setVisitor(null);
					ref.inferencer.reset();
				}
			}
		}
	}

	private final static class ValueCollectionReference
			implements IValueCollectionReference {
		private volatile IValueCollection collection;

		private TypeInferencer2 inferencer;

		@Override
		public IValueCollection getValueCollection() {
			return collection;
		}
	}
}
