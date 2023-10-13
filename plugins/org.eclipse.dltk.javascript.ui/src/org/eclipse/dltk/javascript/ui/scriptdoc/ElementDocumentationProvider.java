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

import org.eclipse.dltk.core.IMember;
import org.eclipse.dltk.javascript.typeinfo.TypeUtil;
import org.eclipse.dltk.javascript.typeinfo.model.Element;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.Method;
import org.eclipse.dltk.javascript.typeinfo.model.Parameter;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.dltk.javascript.typeinfo.model.Property;
import org.eclipse.dltk.javascript.typeinfo.model.RecordType;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.ui.typeinfo.ElementLabelProviderRegistry;
import org.eclipse.dltk.javascript.ui.typeinfo.IElementLabelProvider.Mode;
import org.eclipse.dltk.ui.ScriptElementImageDescriptor;
import org.eclipse.dltk.ui.ScriptElementImageProvider;
import org.eclipse.dltk.ui.documentation.IDocumentationResponse;
import org.eclipse.dltk.ui.documentation.IScriptDocumentationProvider;
import org.eclipse.dltk.ui.documentation.IScriptDocumentationProviderExtension2;
import org.eclipse.dltk.ui.documentation.TextDocumentationResponse;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @since 3.0
 */
public class ElementDocumentationProvider implements
		IScriptDocumentationProvider, IScriptDocumentationProviderExtension2 {

	public Reader getInfo(IMember element, boolean lookIntoParents,
			boolean lookIntoExternal) {
		return null;
	}

	public Reader getInfo(String content) {
		return null;
	}

	public IDocumentationResponse getDocumentationFor(Object element) {
		if (element instanceof Element) {
			final Element jsElement = (Element) element;
			// if (jsElement.getDescription() != null
			// && jsElement.getDescription().length() != 0) {
			return new TextDocumentationResponse(element,
					getElementTitle(jsElement),
					getElementImageDescriptor(jsElement),
					jsElement.getDescription() != null ? jsElement
							.getDescription() : "");
			// }
		}
		return null;
	}

	private boolean appendDeclaringTypePath(StringBuilder sb, EObject object) {
		if (object instanceof RecordType) {
			return appendDeclaringTypePath(sb, object.eContainer());
		} else if (object instanceof Type) {
			if (object.eContainer() instanceof RecordType) {
				return appendDeclaringTypePath(sb, object.eContainer());
			} else {
				final Type type = (Type) object;
				sb.append(type.getName());
				sb.append(".");
				return true;
			}
		} else if (object instanceof Member) {
			if (appendDeclaringTypePath(sb, object.eContainer())) {
				final Member member = (Member) object;
				sb.append(member.getName());
				sb.append(".");
				return true;
			}
		}
		return false;
	}

	/**
	 * @param element
	 * @return
	 */
	protected String getElementTitle(Element element) {
		final String label = ElementLabelProviderRegistry.getLabel(element,
				Mode.TITLE);
		if (label != null) {
			return label;
		}
		final StringBuilder sb = new StringBuilder();
		if (element instanceof Member) {
			final Member member = (Member) element;
			if (member.getDeclaringType() != null) {
				if (TypeUtil.isDeclaringTypeVisible(member)) {
					sb.append(member.getDeclaringType().getName());
					sb.append('.');
				} else {
					appendDeclaringTypePath(sb, member.getDeclaringType());
				}
			}
		}
		sb.append(element.getName());
		if (element instanceof Property) {
			final Property property = (Property) element;
			if (TypeUtil.isValueTypeVisible(property.getType())) {
				sb.append(": "); //$NON-NLS-1$
				sb.append(property.getType().getName());
			}
		} else if (element instanceof Method) {
			final Method method = (Method) element;
			sb.append('(');
			int paramCount = 0;
			for (Parameter parameter : method.getParameters()) {
				if (paramCount != 0) {
					sb.append(", "); //$NON-NLS-1$
				}
				sb.append(parameter.getName());
				if (parameter.getType() != null) {
					sb.append(':');
					sb.append(parameter.getType().getName());
					if (parameter.getKind() == ParameterKind.VARARGS) {
						sb.append("...");
					}
				} else if (parameter.getKind() == ParameterKind.VARARGS) {
					sb.append("...");
				}
				++paramCount;
			}
			sb.append(')');
			if (method.getType() != null) {
				sb.append(": "); //$NON-NLS-1$
				sb.append(method.getType().getName());
			}
		}
		return sb.toString();
	}

	protected ImageDescriptor getElementImageDescriptor(Element element) {
		ImageDescriptor descriptor = ElementLabelProviderRegistry
				.getImageDescriptor(element);
		if (descriptor != null) {
			return descriptor;
		}
		if (element instanceof Type) {
			return decorateImageDescriptor(
					ScriptElementImageProvider.getTypeImageDescriptor(0, false),
					element);
		} else if (element instanceof Member) {
			final int flags = ((Member) element).getVisibility().getFlags();
			if (element instanceof Property) {
				return decorateImageDescriptor(
						ScriptElementImageProvider
								.getFieldImageDescriptor(flags),
						element);
			} else if (element instanceof Method) {
				return decorateImageDescriptor(
						ScriptElementImageProvider
								.getMethodImageDescriptor(flags),
						element);
			}
		}
		return null;
	}

	protected ImageDescriptor decorateImageDescriptor(
			ImageDescriptor descriptor, Element element) {
		if (element.isDeprecated()) {
			return new ScriptElementImageDescriptor(descriptor,
					ScriptElementImageDescriptor.DEPRECATED,
					ScriptElementImageProvider.SMALL_SIZE);
		} else if (element instanceof Member && ((Member) element).isStatic()) {
			return new ScriptElementImageDescriptor(descriptor,
					ScriptElementImageDescriptor.STATIC,
					ScriptElementImageProvider.SMALL_SIZE);
		}
		return descriptor;
	}

}
