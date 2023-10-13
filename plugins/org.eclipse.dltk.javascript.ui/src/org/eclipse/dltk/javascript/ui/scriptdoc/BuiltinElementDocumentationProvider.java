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
package org.eclipse.dltk.javascript.ui.scriptdoc;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.core.IMember;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IProjectFragment;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencer2;
import org.eclipse.dltk.javascript.typeinfo.model.Element;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.ui.documentation.IScriptDocumentationProvider;

/**
 * @since 3.0
 */
public class BuiltinElementDocumentationProvider implements
		IScriptDocumentationProvider {

	public Reader getInfo(String content) {
		return null;
	}

	public Reader getInfo(IMember element, boolean lookIntoParents,
			boolean lookIntoExternal) {
		final IProjectFragment fragment = (IProjectFragment) element
				.getAncestor(IModelElement.PROJECT_FRAGMENT);
		if (fragment != null && fragment.isBuiltin()) {
			final ISourceModule module = (ISourceModule) element
					.getAncestor(IModelElement.SOURCE_MODULE);
			if (module != null && "builtins.js".equals(module.getElementName())) {
				final List<String> segments = new ArrayList<String>();
				IModelElement e = element;
				while (e != module) {
					segments.add(0, e.getElementName());
					e = e.getParent();
				}
				final TypeInferencer2 context = new TypeInferencer2();
				Type type = context.getType(segments.get(0));
				if (type != null) {
					if (segments.size() == 1) {
						return documentationFor(element, type);
					} else if (segments.size() >= 2) {
						for (Member member : type.getMembers()) {
							if (segments.get(1).equals(member.getName())) {
								return documentationFor(element, member);
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * @param element
	 * @param type
	 * @return
	 */
	private static Reader documentationFor(IMember element, Element type) {
		if (type.getDescription() != null
				&& type.getDescription().length() != 0) {
			return new StringReader(type.getDescription());
		}
		return null;
	}
}
