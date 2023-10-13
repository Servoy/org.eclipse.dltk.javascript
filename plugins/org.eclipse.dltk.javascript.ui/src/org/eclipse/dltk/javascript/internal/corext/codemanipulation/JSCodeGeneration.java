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
package org.eclipse.dltk.javascript.internal.corext.codemanipulation;

import static org.eclipse.dltk.javascript.ast.MultiLineComment.JSDOC_PREFIX;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.dltk.core.IMethod;
import org.eclipse.dltk.core.IParameter;
import org.eclipse.dltk.core.IPreferencesLookupDelegate;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.core.PreferencesLookupDelegate;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.javascript.typeinfo.ITypeNames;
import org.eclipse.dltk.javascript.ui.scriptdoc.IndentManipulation;
import org.eclipse.dltk.javascript.ui.scriptdoc.ScriptdocContentAccess;
import org.eclipse.dltk.ui.CodeFormatterConstants;

public class JSCodeGeneration {

	public static String getMethodComment(IMethod meth, IMethod overridden,
			String lineDelimiter) {
		String existingComment = null;
		try {
			ISourceRange range = ScriptdocContentAccess.getJavadocRange(meth);
			if (range != null) {
				ISourceModule compilationUnit = meth.getSourceModule();
				existingComment = compilationUnit.getBuffer().getText(
						range.getOffset(), range.getLength());

			}
		} catch (Exception e) {
			// ignore
		}

		StringBuffer buf = new StringBuffer();
		if (existingComment != null && !isEmptyComment(existingComment)) {
			// update existing doc.
			List<String> lines = new ArrayList<String>();
			List<Param> paramLines = new ArrayList<Param>();
			int paramStart = -1;
			boolean hasReturn = false;
			StringTokenizer st = new StringTokenizer(existingComment,
					lineDelimiter);
			while (st.hasMoreTokens()) {
				String line = st.nextToken().trim();
				if (line.startsWith("*"))
					line = ' ' + line;
				hasReturn = hasReturn || line.indexOf("@return") != -1;
				int index = line.indexOf("@param");
				if (index != -1) {
					if (paramStart == -1)
						paramStart = lines.size() - 1;
					Param param = new Param();
					StringTokenizer tokenizer = new StringTokenizer(line, " \t");
					while (tokenizer.hasMoreTokens()) {
						String token = tokenizer.nextToken();
						if (token.equals("@param")) {
							if (tokenizer.hasMoreTokens()) {
								token = tokenizer.nextToken();
								if (token.startsWith("{")
										&& token.endsWith("}")) {
									param.type = token;
									if (tokenizer.hasMoreTokens()) {
										param.name = tokenizer.nextToken();
									}
								} else {
									param.name = token;
								}
								if (param.name.startsWith("[")
										&& param.name.endsWith("]")) {
									param.optional = true;
									param.name = param.name.substring(1,
											param.name.length() - 1);
								}
							}
							if (tokenizer.hasMoreTokens()) {
								param.doc = tokenizer.nextToken(lineDelimiter)
										.trim();
							}
							break;
						}

					}
					paramLines.add(param);
				} else
					lines.add(line);
			}
			int parameterLength = 0;
			try {
				IParameter[] parameters = meth.getParameters();
				parameterLength = parameters.length;
				outer: for (int paramCounter = 0; paramCounter < parameterLength; paramCounter++) {
					IParameter parameter = parameters[paramCounter];
					for (int i = 0; i < paramLines.size(); i++) {
						Param param = paramLines.get(i);

						if (param.name.equals(parameter.getName())) {
							if (i != paramCounter) {
								paramLines.remove(i);
								paramLines.add(paramCounter, param);
							}
							continue outer;
						}
					}

					paramLines.add(new Param(parameter.getName(), "{Object}"));
					paramCounter--;
				}
			} catch (ModelException e) {
				// ignore
			}
			if (paramStart == -1)
				paramStart = lines.size() - 2;
			for (int i = 0; i < lines.size(); i++) {
				buf.append(lines.get(i)).append(lineDelimiter);
				if (paramStart == i) {
					boolean optional = false;
					for (int j = 0; j < parameterLength; j++) {
						Param param = paramLines.get(j);
						if (!optional)
							optional = param.optional;
						param.optional = optional;
						buf.append(param).append(lineDelimiter);
					}
					if (!hasReturn) {
						try {
							if (meth.getType() != null) {
								buf.append(" * @return {");
								buf.append(meth.getType());
								buf.append("}").append(lineDelimiter); //$NON-NLS-1$
							}
						} catch (ModelException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} else {
			buf.append(JSDOC_PREFIX).append(lineDelimiter);
			try {
				for (IParameter parameter : meth.getParameters()) {
					buf.append(" * @param {Object} " + parameter.getName())
							.append(lineDelimiter);
				}
				if (meth.getType() != null) {
					buf.append(" * @return {");
					buf.append(meth.getType());
					buf.append("}").append(lineDelimiter); //$NON-NLS-1$
				}
			} catch (ModelException e) {
				// ignore
			}
			// try {
			// if (meth.getType() != null) {
			// buf.append(" * @return {");
			// buf.append(meth.getType());
			//					buf.append("}").append(lineDelimiter); //$NON-NLS-1$
			// }
			// } catch (ModelException e) {
			// // ignore
			// }
			buf.append(" */").append(lineDelimiter); //$NON-NLS-1$
		}
		return buf.toString();
	}

	public static String getFieldComment(ISourceModule sourceModule,
			String typeName, String fieldName, String lineDelimiter) {
		StringBuffer buf = new StringBuffer();
		buf.append(JSDOC_PREFIX).append(lineDelimiter);
		buf.append(" * " + fieldName).append(lineDelimiter); //$NON-NLS-1$
		// TODO (alex) do we need an option for braces here ?
		buf.append(" * @type ").append("{").append(typeName != null ? typeName : ITypeNames.OBJECT).append("}").append(lineDelimiter); //$NON-NLS-1$
		buf.append(" */").append(lineDelimiter); //$NON-NLS-1$
		return buf.toString();
	}

	public static String getTypeComment(ISourceModule sourceModule,
			String typeQualifiedName, String[] typeParameterNames,
			String lineDelimiter) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns that part of the indentation of <code>line</code> that makes up a
	 * multiple of indentation units.
	 * 
	 * @param line
	 *            the line to scan
	 * @param project
	 *            the java project from which to get the formatter preferences,
	 *            or <code>null</code> for global preferences
	 * @return the indent part of <code>line</code>, but no odd spaces
	 * @since 3.1
	 */
	public static String getIndentString(String line, IScriptProject project) {
		return IndentManipulation.extractIndentString(line,
				getTabWidth(project), getIndentWidth(project));
	}

	/**
	 * Gets the current tab width.
	 * 
	 * @param project
	 *            The project where the source is used, used for project
	 *            specific options or <code>null</code> if the project is
	 *            unknown and the workspace default should be used
	 * @return The tab width
	 */
	public static int getTabWidth(IScriptProject project) {
		/*
		 * If the tab-char is SPACE, FORMATTER_INDENTATION_SIZE is not used by
		 * the core formatter. We piggy back the visual tab length setting in
		 * that preference in that case.
		 */
		final String key;
		final IPreferencesLookupDelegate prefs = new PreferencesLookupDelegate(
				project);
		if (CodeFormatterConstants.SPACE.equals(prefs.getString(
				JavaScriptUI.PLUGIN_ID,
				CodeFormatterConstants.FORMATTER_TAB_CHAR))) {
			key = CodeFormatterConstants.FORMATTER_INDENTATION_SIZE;
		} else {
			key = CodeFormatterConstants.FORMATTER_TAB_SIZE;
		}
		return prefs.getInt(JavaScriptUI.PLUGIN_ID, key);
	}

	/**
	 * Returns the current indent width.
	 * 
	 * @param project
	 *            the project where the source is used or, <code>null</code> if
	 *            the project is unknown and the workspace default should be
	 *            used
	 * @return the indent width
	 */
	public static int getIndentWidth(IScriptProject project) {
		String key;
		final IPreferencesLookupDelegate prefs = new PreferencesLookupDelegate(
				project);
		if (CodeFormatterConstants.MIXED.equals(prefs.getString(
				JavaScriptUI.PLUGIN_ID,
				CodeFormatterConstants.FORMATTER_TAB_CHAR)))
			key = CodeFormatterConstants.FORMATTER_INDENTATION_SIZE;
		else
			key = CodeFormatterConstants.FORMATTER_TAB_SIZE;

		return prefs.getInt(JavaScriptUI.PLUGIN_ID, key);
	}

	/**
	 * Change the indent of, possible multi-line, code range. The current indent
	 * is removed, a new indent added. The first line of the code will not be
	 * changed. (It is considered to have no indent as it might start in the
	 * middle of a line)
	 * 
	 * @param code
	 *            the code
	 * @param codeIndentLevel
	 *            level of indentation
	 * 
	 * @param project
	 *            the java project from which to get the formatter preferences,
	 *            or <code>null</code> for global preferences
	 * @param newIndent
	 *            new indent
	 * @param lineDelim
	 *            line delimiter
	 * @return the changed code
	 */
	public static String changeIndent(String code, int codeIndentLevel,
			IScriptProject project, String newIndent, String lineDelim) {
		return IndentManipulation.changeIndent(code, codeIndentLevel,
				getTabWidth(project), getIndentWidth(project), newIndent,
				lineDelim);
	}

	private static boolean isEmptyComment(String comment) {
		int begin = 0;
		int end = comment.length();
		while (begin < end && Character.isWhitespace(comment.charAt(begin))) {
			++begin;
		}
		if (begin < end && comment.charAt(begin) == '/') {
			++begin;
		}
		while (begin < end && Character.isWhitespace(comment.charAt(end - 1))) {
			--end;
		}
		if (begin < end && comment.charAt(end - 1) == '/') {
			--end;
		}
		while (begin < end
				&& (Character.isWhitespace(comment.charAt(begin)) || comment
						.charAt(begin) == '*')) {
			++begin;
		}
		return begin >= end;
	}

	private static class Param {
		private String name;
		private boolean optional;
		private String type;
		private String doc;

		public Param() {
		}

		public Param(String name, String type) {
			this.name = name;
			this.type = type;
		}

		public String toString() {
			return " * @param " + (type != null ? type + " " : "")
					+ (optional ? "[" + name + "]" : name) 
					+ (doc != null ? " " + doc : "");
		}
	}
}