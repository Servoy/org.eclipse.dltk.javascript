/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.javascript.ui.scriptdoc;

import java.io.Reader;

import org.eclipse.dltk.core.ILocalVariable;
import org.eclipse.dltk.core.IMember;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.javascript.scriptdoc.JSDocContentAccess;
import org.eclipse.dltk.ui.documentation.DocumentationUtils;
import org.eclipse.dltk.ui.documentation.IDocumentationResponse;
import org.eclipse.dltk.ui.documentation.IScriptDocumentationProvider;
import org.eclipse.dltk.ui.documentation.IScriptDocumentationProviderExtension2;
import org.eclipse.dltk.ui.documentation.IScriptDocumentationTitleAdapter;
import org.eclipse.dltk.ui.documentation.TextDocumentationResponse;
import org.eclipse.dltk.utils.AdaptUtils;

public class ScriptDocumentationProvider implements
		IScriptDocumentationProvider, IScriptDocumentationProviderExtension2 {

	public Reader getInfo(IMember element, boolean lookIntoParents,
			boolean lookIntoExternal) {
		try {
			return ScriptdocContentAccess.getHTMLContentReader(element,
					lookIntoParents, lookIntoExternal);
		} catch (ModelException e) {
			JavaScriptUI.log(e);
		}
		return null;
	}

	public Reader getInfo(String content) {
		return null;
	}

	public IDocumentationResponse getDocumentationFor(Object element) {
		if (element instanceof IMember member) {
			Reader reader = getInfo(member, true, true);
			return DocumentationUtils.wrap(element, member, reader);
		} else if (element instanceof ILocalVariable variable) {
			try {
				ISourceRange sourceRange = variable.getSourceRange();
				int possibleDocStart = 0;
				int possibleDocEnd = sourceRange.getOffset();
				ISourceRange docRange = JSDocContentAccess.getDocRange(
						(ISourceModule) variable.getOpenable(),
						possibleDocStart, possibleDocEnd);
				if (docRange != null) {
					String text = variable.getOpenable().getBuffer()
							.getText(0, possibleDocEnd);
					int indexOfLastLine = text.lastIndexOf('\n');
					indexOfLastLine = text.lastIndexOf('\n',
							indexOfLastLine - 1);
					if ((docRange.getOffset() + docRange.getLength()) > indexOfLastLine) {
						JavaDocCommentReader reader = ScriptdocContentAccess
								.getReader(
										((IModelElement) element).getOpenable(),
										docRange);

						return DocumentationUtils.wrap(element,
								((ILocalVariable) element),
								new JavaDoc2HTMLTextReader(reader));
					}
					else if (variable.getDescription() != null) {
						final IScriptDocumentationTitleAdapter titleAdapter = AdaptUtils
								.getAdapter(variable,
										IScriptDocumentationTitleAdapter.class);
						return new TextDocumentationResponse(variable,
								titleAdapter != null
										? titleAdapter.getTitle(variable)
										: null,
								titleAdapter != null
										? titleAdapter.getImage(variable)
										: null,
								variable.getDescription());
					}
				}
			} catch (ModelException e) {
				return null;
			}
		}
		return null;
	}
}
