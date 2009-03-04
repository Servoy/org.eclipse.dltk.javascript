/**
 * 
 */
package org.eclipse.dlkt.javascript.dom.support;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.dltk.internal.javascript.reference.resolvers.IResolvableReference;
import org.eclipse.dltk.internal.javascript.reference.resolvers.ReferenceResolverContext;
import org.eclipse.dltk.internal.javascript.typeinference.IReference;
import org.eclipse.dltk.internal.javascript.typeinference.UnknownReference;
import org.mozilla.javascript.Scriptable;

/**
 * @author jcompagner
 * 
 */
public class ScriptableScopeReference extends UnknownReference implements
		IResolvableReference {

	private final Scriptable scriptable;
	private final ReferenceResolverContext resolver;

	/**
	 * @param paramOrVarName
	 * @param cs
	 * @param childIsh
	 */
	public ScriptableScopeReference(String paramOrVarName,
			Scriptable scriptable, ReferenceResolverContext resolver) {
		super(paramOrVarName, true);
		this.scriptable = scriptable;
		this.resolver = resolver;
	}

	/**
	 * @see org.eclipse.dltk.internal.javascript.typeinference.UnknownReference#createChilds()
	 */
	protected void createChilds() {

		Set hashSet = resolver.resolveChilds(this);

		Iterator i = hashSet.iterator();
		while (i.hasNext()) {
			Object next = i.next();
			if (next instanceof IReference) {
				IReference r = (IReference) next;
				setChild(r.getName(), r);
			}
		}

		// HashMap results = new HashMap();
		// resolver.fillMap(results, scriptable, false, null);
		// HashSet rs = new HashSet();
		// resolver.createReferences("", results, rs);
		// Iterator iterator = rs.iterator();
		// while (iterator.hasNext()) {
		// IReference ref = (IReference) iterator.next();
		// setChild(ref.getName(), ref);
		// }
	}

	/**
	 * @see org.eclipse.dltk.internal.javascript.typeinference.UnknownReference#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj instanceof ScriptableScopeReference && super.equals(obj)) {
			ScriptableScopeReference ssr = (ScriptableScopeReference) obj;
			return scriptable.equals(ssr.scriptable);
		}
		return false;
	}

	/**
	 * @return
	 */
	public Scriptable getScriptable() {
		return scriptable;
	}
}
