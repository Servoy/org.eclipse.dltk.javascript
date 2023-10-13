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
package org.eclipse.dltk.javascript.internal.ui.text.completion;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.core.IMember;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IModelElementVisitor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.javascript.ti.JSDocSupport;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.core.JavaScriptNature;
import org.eclipse.dltk.javascript.core.NodeFinder;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.javascript.parser.JavaScriptParserUtil;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IMethod;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IVariable;
import org.eclipse.dltk.javascript.typeinfo.model.Element;
import org.eclipse.dltk.javascript.ui.scriptdoc.JavaDoc2HTMLTextReader;
import org.eclipse.dltk.javascript.ui.scriptdoc.ScriptDocumentationProvider;
import org.eclipse.dltk.javascript.ui.scriptdoc.StringJavaDocCommentReader;
import org.eclipse.dltk.ui.documentation.DocumentationUtils;
import org.eclipse.dltk.ui.documentation.IDocumentationResponse;
import org.eclipse.dltk.ui.documentation.ScriptDocumentationAccess;
import org.eclipse.dltk.ui.text.completion.ProposalInfo;

public class JavaScriptProposalInfo extends ProposalInfo {

	private final Object ref;

	public JavaScriptProposalInfo(Object ref) {
		super(null);
		this.ref = ref;
	}

	@Override
	public String getInfo(IProgressMonitor monitor) {
		if (ref instanceof IMember) {
			Reader contentReader = new ScriptDocumentationProvider().getInfo(
					(IMember) ref, true, true);
			if (contentReader != null) {
				String string = getString(contentReader);
				return string;
			}
		} else if (ref instanceof String) {
			return (String) ref;
		} else if (ref instanceof Element) {
			final IDocumentationResponse response = ScriptDocumentationAccess
					.getDocumentation(JavaScriptNature.NATURE_ID, ref, null);
			if (response != null) {
				try {
					return getString(response.getReader());
				} catch (IOException e) {
					JavaScriptUI.log(e);
				}
			}
		} else if (ref instanceof IValueReference) {
			return getInfo( ((IValueReference) ref).getLocation());
		} else if (ref instanceof IMethod) {
			ISourceRange docRange = ((IMethod) ref).getDocRange();
			if (docRange != null && docRange.getOffset() > 0
					&& docRange.getLength() > 0) {
				ISourceModule sourceModule = ((IMethod) ref).getLocation()
						.getSourceModule();
				try {
					String comment = sourceModule.getSource().substring(
							docRange.getOffset(),
							docRange.getOffset() + docRange.getLength());
					return getString(new JavaDoc2HTMLTextReader(
							new StringJavaDocCommentReader(comment)));
				} catch (ModelException e) {
					e.printStackTrace();
				}
			}
		} else if (ref instanceof IVariable) {
			return getInfo(((IVariable) ref).getLocation());
		}

		return null;
	}

	private String getInfo(final ReferenceLocation location) {
		if (location == ReferenceLocation.UNKNOWN)
			return null;
		final ISourceModule m = location.getSourceModule();
		if (m == null)
			return null;
		try {
			m.accept(new IModelElementVisitor() {
				public boolean visit(IModelElement element) {
					if (element instanceof IMember) {
						try {
							ISourceRange nameRange = ((IMember) element)
									.getNameRange();
							if (location.getNameStart() >= nameRange
									.getOffset()
									&& location.getNameEnd() <= (nameRange
											.getOffset() + nameRange
											.getLength())) {
								throw new ModelElementFound(element);
							}
						} catch (ModelException e) {
							e.printStackTrace();
						}
					}
					return true;
				}
			});
		} catch (ModelException e) {
			e.printStackTrace();
		} catch (ModelElementFound found) {
			Reader contentReader = new ScriptDocumentationProvider().getInfo(
					(IMember) found.element, true, true);
			if (contentReader != null) {
				return getString(contentReader);
			}
		}
		final Script script = JavaScriptParserUtil.parse(m, null);
		final NodeFinder nodeFinder = new NodeFinder(location.getNameStart(),
				location.getNameEnd());
		nodeFinder.locate(script);
		ASTNode node = nodeFinder.getNode();
		if (node instanceof JSNode) {
			Comment comment = JSDocSupport.getComment((JSNode) node);

			if (comment != null && comment.getText().length() > 0) {
				return getString(new JavaDoc2HTMLTextReader(
						new StringJavaDocCommentReader(
						comment.getText())));
			}
		}
		return null;
	}

	/**
	 * Gets the reader content as a String
	 */
	private String getString(Reader reader) {
		return DocumentationUtils.readAll(reader);
	}

	@SuppressWarnings("serial")
	private static class ModelElementFound extends RuntimeException {
		final IModelElement element;

		public ModelElementFound(IModelElement element) {
			this.element = element;
		}

	}

}
