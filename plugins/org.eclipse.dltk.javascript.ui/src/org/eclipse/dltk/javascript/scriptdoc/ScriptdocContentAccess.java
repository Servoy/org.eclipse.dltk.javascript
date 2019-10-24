/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.javascript.scriptdoc;

import java.io.Reader;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.dltk.core.IBuffer;
import org.eclipse.dltk.core.IMember;
import org.eclipse.dltk.core.IMethod;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IOpenable;
import org.eclipse.dltk.core.IScriptFolder;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.javascript.ui.IJsExtendsScope;

class BufferJavaDocCommentReader extends JavaDocCommentReader {

	private IBuffer fBuffer;

	public BufferJavaDocCommentReader(IBuffer buf, int start, int end) {
		super(start, end);
		fBuffer = buf;
	}

	@Override
	protected char getChar(int index) {
		return fBuffer.getChar(index);
	}

	/**
	 * @see java.io.Reader#close()
	 */
	public void close() {
		fBuffer = null;
	}

}

/**
 * Helper needed to get the content of a Javadoc comment.
 * 
 * <p>
 * This class is not intended to be subclassed or instantiated by clients.
 * </p>
 * 
 * @since 3.1
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noextend This class is not intended to be subclassed by clients.
 */
public class ScriptdocContentAccess {

	private static IJsExtendsScope jsExtendsScope = null;
	// private static final String JAVADOC_END = "*/";

	private ScriptdocContentAccess() {
		// do not instantiate
	}

	public static ISourceRange getJavadocRange(IMember member)
			throws ModelException {
		return JSDocContentAccess.getDocRange(member);
	}

	public static JavaDocCommentReader getReader(IOpenable openable,
			ISourceRange docRange) throws ModelException {
		final IBuffer buf = openable.getBuffer();
		if (buf != null) {
			return new BufferJavaDocCommentReader(buf, docRange.getOffset(),
					docRange.getOffset() + docRange.getLength());
		}
		if (openable instanceof ISourceModule) {
			final ISourceModule module = (ISourceModule) openable;
			return new StringJavaDocCommentReader(module.getSource().substring(
					docRange.getOffset(),
					docRange.getOffset() + docRange.getLength()));
		}
		return null;
	}

	/**
	 * Gets a reader for an IMember's Javadoc comment content from the source
	 * attachment. The content does contain only the text from the comment
	 * without the Javadoc leading star characters. Returns <code>null</code> if
	 * the member does not contain a Javadoc comment or if no source is
	 * available.
	 * 
	 * @param member
	 *            The member to get the Javadoc of.
	 * @param allowInherited
	 *            For methods with no (Javadoc) comment, the comment of the
	 *            overridden class is returned if <code>allowInherited</code> is
	 *            <code>true</code>.
	 * @return Returns a reader for the Javadoc comment content or
	 *         <code>null</code> if the member does not contain a Javadoc
	 *         comment or if no source is available
	 * @throws JavaModelException
	 *             is thrown when the elements javadoc can not be accessed
	 */
	public static Reader getContentReader(IMember member, boolean allowInherited)
			throws ModelException {
		IOpenable openable = member.getOpenable();
		if (openable != null) {
			try {
				ISourceRange javadocRange = getJavadocRange(member);
				if (javadocRange != null) {
					JavaDocCommentReader reader = getReader(openable,
							javadocRange);
					if (reader == null) {
						return null;
					}
					if (!reader.containsInheritDoc()) {
						reader.reset();
						return reader;
					}
				}

				if (allowInherited
						&& (member.getElementType() == IModelElement.METHOD)) {
					IMember parentMember = findDocInHierarchy((IMethod) member);
					if (parentMember != null) {
						return getContentReader(parentMember, true);
					}
				}
			} catch (ModelException e) {
				return null;
			}
		}

		return null;
	}

	/**
	 * Gets a reader for an IMember's Javadoc comment content from the source
	 * attachment. and renders the tags in HTML. Returns <code>null</code> if
	 * the member does not contain a Javadoc comment or if no source is
	 * available.
	 * 
	 * @param member
	 *            the member to get the Javadoc of.
	 * @param allowInherited
	 *            for methods with no (Javadoc) comment, the comment of the
	 *            overridden class is returned if <code>allowInherited</code> is
	 *            <code>true</code>
	 * @param useAttachedJavadoc
	 *            if <code>true</code> Javadoc will be extracted from attached
	 *            Javadoc if there's no source
	 * @return a reader for the Javadoc comment content in HTML or
	 *         <code>null</code> if the member does not contain a Javadoc
	 *         comment or if no source is available
	 * @throws JavaModelException
	 *             is thrown when the elements Javadoc can not be accessed
	 * @since 3.2
	 */
	public static Reader getHTMLContentReader(IMember member,
			boolean allowInherited, boolean useAttachedJavadoc)
			throws ModelException {
		Reader contentReader = getContentReader(member, allowInherited);
		if (contentReader != null)
			return new JavaDoc2HTMLTextReader(contentReader);

		IOpenable openable = member.getOpenable();
		if (useAttachedJavadoc && openable != null
				&& openable.getBuffer() == null) { // only
			// if
			// no
			// source
			// available
			// String s= member.getAttachedJavadoc(null);
			// if (s != null)
			// return new StringReader(s);
		}
		return null;
	}

	/**
	 * Gets a reader for an IMember's Javadoc comment content from the source
	 * attachment. and renders the tags in HTML. Returns <code>null</code> if
	 * the member does not contain a Javadoc comment or if no source is
	 * available.
	 * 
	 * @param member
	 *            The member to get the Javadoc of.
	 * @param allowInherited
	 *            For methods with no (Javadoc) comment, the comment of the
	 *            overridden class is returned if <code>allowInherited</code> is
	 *            <code>true</code>.
	 * @return Returns a reader for the Javadoc comment content in HTML or
	 *         <code>null</code> if the member does not contain a Javadoc
	 *         comment or if no source is available
	 * @throws JavaModelException
	 *             is thrown when the elements javadoc can not be accessed
	 * @deprecated As of 3.2, replaced by
	 *             {@link #getHTMLContentReader(IMember, boolean, boolean)}
	 */
	public static Reader getHTMLContentReader(IMember member,
			boolean allowInherited) throws ModelException {
		return getHTMLContentReader(member, allowInherited, false);
	}

	private static IMember findDocInHierarchy(IMember method)
			throws ModelException {

		initialiseJsExtendsForm();
		if (jsExtendsScope != null && method instanceof IMethod) {
			// methodPath: full path for the method location in solution
			IPath methodPath = method.getPath();
			String formName = methodPath.lastSegment();
			String extendsFormName = jsExtendsScope.getExtendsScope(
					formName.substring(0, formName.length() - 3));
			if (extendsFormName != null) {
				extendsFormName += ".js";
				// scriptFolderPath: method's parent source module
				IPath scriptFolderPath = methodPath.removeLastSegments(1);
				IScriptFolder methodScriptFolder = null;
				// iterate for getting parent source module's container
				for (IScriptFolder scriptFolder : method.getScriptProject()
						.getScriptFolders()) {
					if (scriptFolderPath.equals(scriptFolder.getPath())) {
						methodScriptFolder = scriptFolder;
						break;
					}
				}
				// get source module for the parent form
				ISourceModule sourceModule = (ISourceModule) getElement(
						methodScriptFolder.getChildren(), extendsFormName,
						IModelElement.SOURCE_MODULE);
				// retrieving the method of the parent's source module
				if (sourceModule != null) {
					return (IMember) getElement(
							sourceModule.getChildren(), method.getElementName(),
							IModelElement.METHOD);
				}
			}
		}
		return null;
	}

	private static IModelElement getElement(IModelElement[] elements,
			String name, int type) {
		for (IModelElement element : elements) {
			if (element.getElementName().equals(name)
					&& element.getElementType() == type) {
				return element;
			}
		}
		return null;
	}

	private static void initialiseJsExtendsForm() {
		// if the instance name is given, make sure that that one is created.
		if (jsExtendsScope == null) {
			IExtensionRegistry reg = Platform.getExtensionRegistry();
			IExtensionPoint ep = reg
					.getExtensionPoint(IJsExtendsScope.EXTENSION_ID);
			IExtension[] extensions = ep.getExtensions();

			if (extensions != null && extensions.length > 0) {
				IExtension extension = extensions[0];
				IConfigurationElement[] ce = extension
						.getConfigurationElements();
				if (ce == null || ce.length == 0) {
					JavaScriptUI.log(new Exception(
							"Could not read model provider extension element (extension point "
									+ IJsExtendsScope.EXTENSION_ID + ")"));
				} else {
					if (ce.length > 1) {
						JavaScriptUI.log(new Exception(
								"Multiple model provider extension elements found (extension point "
										+ IJsExtendsScope.EXTENSION_ID
										+ ")"));
					}
					try {
						jsExtendsScope = (IJsExtendsScope) ce[0]
								.createExecutableExtension("class");
						if (jsExtendsScope == null) {
							JavaScriptUI.log(new Exception(
									"Could not load model provider (extension point "
											+ IJsExtendsScope.EXTENSION_ID
											+ ")"));
						}
					} catch (CoreException e) {
						JavaScriptUI.log(e);
					}
				}
			}
		}
	}

}