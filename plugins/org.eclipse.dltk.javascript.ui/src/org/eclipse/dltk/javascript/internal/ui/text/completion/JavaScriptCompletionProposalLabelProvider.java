/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.javascript.internal.ui.text.completion;

import java.util.List;

import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.internal.javascript.ti.IReferenceAttributes;
import org.eclipse.dltk.internal.javascript.ti.JSMethod;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IMethod;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IVariable;
import org.eclipse.dltk.javascript.typeinfo.IRFunctionType;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRParameter;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.TypeUtil;
import org.eclipse.dltk.javascript.typeinfo.model.Element;
import org.eclipse.dltk.javascript.typeinfo.model.GenericType;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.Method;
import org.eclipse.dltk.javascript.typeinfo.model.Property;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariable;
import org.eclipse.dltk.javascript.typeinfo.model.Visibility;
import org.eclipse.dltk.javascript.ui.typeinfo.ElementLabelProviderRegistry;
import org.eclipse.dltk.javascript.ui.typeinfo.IElementLabelProvider.Mode;
import org.eclipse.dltk.ui.ScriptElementImageDescriptor;
import org.eclipse.dltk.ui.ScriptElementImageProvider;
import org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector;
import org.eclipse.jface.resource.ImageDescriptor;

@SuppressWarnings("restriction")
public class JavaScriptCompletionProposalLabelProvider extends
		CompletionProposalLabelProvider {

	@Override
	public String createTypeProposalLabel(CompletionProposal typeProposal) {
		if (typeProposal.getExtraInfo() instanceof Type) {
			final Type type = (Type) typeProposal.getExtraInfo();
			final String label = getElementLabel(type, typeProposal);
			if (label != null) {
				return label;
			}
			if (type instanceof GenericType) {
				final StringBuilder sb = new StringBuilder();
				sb.append(type.getName()).append('<');
				boolean first = true;
				for (TypeVariable variable : ((GenericType) type)
						.getTypeParameters()) {
					if (!first) {
						sb.append(',');
					}
					sb.append(variable.getName());
					first = false;
				}
				sb.append('>');
				return sb.toString();
			}
		}
		return super.createTypeProposalLabel(typeProposal);
	}

	private static String getElementLabel(Element element,
			CompletionProposal proposal) {
		return ElementLabelProviderRegistry.getLabel(element, Mode.PROPOSAL,
				proposal);
	}

	@Override
	protected String createMethodProposalLabel(CompletionProposal methodProposal) {
		String returnType = null;
		String source = null;
		Object info = methodProposal.getExtraInfo();
		if (info instanceof IRMethod methodInfo) {
			StringBuilder label = new StringBuilder();
			label.append(methodProposal.getName());
			label.append('(');
			List<IRParameter> params = methodInfo.getParameters();
			int count = 0;
			Integer paramLimit = (Integer) methodProposal.getAttribute(
					ScriptCompletionProposalCollector.ATTR_PARAM_LIMIT);
			for (IRParameter p : params) {
				if (paramLimit != null && count >= paramLimit)
					break;
				if (count > 0)
					label.append(", ");
				appendIRParameterLabel(label, p);
				count++;
			}
			label.append(')');
			return label.toString();
		}
		if (info instanceof Method) {
			final Method method = (Method) info;
			final String label = getElementLabel(method, methodProposal);
			if (label != null) {
				return label;
			}
			if (method.getType() != null) {
				returnType = method.getType().getName();
			}
			if (method.getDeclaringType() != null) {
				source = method.getDeclaringType().getName();
			}
		} else if (info instanceof IValueReference) {
			final IValueReference reference = (IValueReference) info;
			final IRType declaredType = reference.getChild(
					IValueReference.FUNCTION_OP).getDeclaredType();
			if (declaredType != null) {
				returnType = declaredType.getName();
			}
			final ReferenceLocation loc = reference.getLocation();
			if (loc != ReferenceLocation.UNKNOWN
					&& loc.getSourceModule() != null) {
				source = loc.getSourceModule().getPath().toString();
			}
		}
		StringBuffer nameBuffer = new StringBuffer();

		// method name
		nameBuffer.append(methodProposal.getName());

		// parameters
		nameBuffer.append('(');
		appendParameterList(nameBuffer, methodProposal);
		nameBuffer.append(')');

		if (returnType != null) {
			nameBuffer.append(": ");
			nameBuffer.append(returnType);
		}
		// TODO use different color
		if (source != null) {
			nameBuffer.append(" - ");
			nameBuffer.append(source);
		}
		return nameBuffer.toString();
	}

	private void appendIRParameterLabel(StringBuilder buf, IRParameter p) {
		buf.append(p.getName());
		if (p.isOptional())
			buf.append('?');
		buf.append(':');

		IRType type = p.getType();
		if (type instanceof IRFunctionType ft) {
			buf.append("function(");

			List<IRParameter> fps = ft.getParameters();
			for (int i = 0; i < fps.size(); i++) {
				IRParameter fp = fps.get(i);
				if (i > 0)
					buf.append(", ");
				buf.append(fp.getName());
				if (fp.isOptional())
					buf.append('?');
			}
			buf.append(')');
		} else {
			buf.append(type != null ? type.getName() : "any");
		}
	}

	@Override
	protected String createFieldProposalLabel(CompletionProposal proposal) {
		final Object info = proposal.getExtraInfo();
		if (info instanceof Property) {
			final Property property = (Property) proposal.getExtraInfo();
			final String label = getElementLabel(property, proposal);
			if (label != null) {
				return label;
			}
			final StringBuilder sb = new StringBuilder();
			sb.append(proposal.getName());
			if (TypeUtil.isValueTypeVisible(property.getType())) {
				sb.append(": ");
				sb.append(property.getType().getName());
			}
			// TODO use different color
			if (TypeUtil.isDeclaringTypeVisible(property)) {
				sb.append(" - ");
				sb.append(property.getDeclaringType().getName());
			}
			return sb.toString();
		} else if (proposal.getExtraInfo() instanceof IValueReference) {
			final IValueReference reference = (IValueReference) proposal
					.getExtraInfo();
			final StringBuilder sb = new StringBuilder();
			sb.append(proposal.getName());
			if (reference.getKind() != ReferenceKind.PREDEFINED) {
				final IRType declaredType = reference.getDeclaredType();
				if (declaredType != null) {
					sb.append(": ").append(declaredType.getName());
				}
			}
			return sb.toString();
		}
		return proposal.getName();
	}

	/**
	 * @see org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider#createImageDescriptor(org.eclipse.dltk.core.CompletionProposal)
	 */
	@Override
	public ImageDescriptor createImageDescriptor(CompletionProposal proposal) {
		ImageDescriptor imageDescriptor = extraImageFromProposal(proposal);
		if (imageDescriptor != null)
			return imageDescriptor;
		return super.createImageDescriptor(proposal);
	}

	/**
	 * @param proposal
	 * @return
	 */
	private ImageDescriptor extraImageFromProposal(CompletionProposal proposal) {
		final Object extraInfo = proposal.getExtraInfo();
		if (extraInfo instanceof Element) {
			final Element element = (Element) extraInfo;
			final ImageDescriptor descriptor = ElementLabelProviderRegistry
					.getImageDescriptor(element);
			if (descriptor != null) {
				return decorateImageDescriptor(descriptor, proposal);
			}
			if (element instanceof Member) {
				final int flags = ((Member) element).getVisibility().getFlags();
				if (element instanceof Property) {
					return decorateImageDescriptor(
							ScriptElementImageProvider
									.getFieldImageDescriptor(flags),
							proposal);
				} else if (element instanceof Method) {
					return decorateImageDescriptor(
							ScriptElementImageProvider
									.getMethodImageDescriptor(flags),
							proposal);
				}
			}
		} else if (extraInfo instanceof IValueReference) {
			final IValueReference reference = (IValueReference) extraInfo;
			final IMethod method = (IMethod) reference
					.getAttribute(IReferenceAttributes.METHOD);
			if (method != null) {
				return decorateImageDescriptor(
						ScriptElementImageProvider.getMethodImageDescriptor(Visibility
								.getFlags(method.getVisibility())), proposal);
			}
			final IVariable variable = (IVariable) reference
					.getAttribute(IReferenceAttributes.VARIABLE);
			if (variable != null) {
				return decorateImageDescriptor(
						ScriptElementImageProvider.getFieldImageDescriptor(Visibility
								.getFlags(variable.getVisibility())), proposal);
			}
		}
		return null;
	}

	/**
	 * @see org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider#createFieldImageDescriptor(org.eclipse.dltk.core.CompletionProposal)
	 */
	@Override
	protected ImageDescriptor createFieldImageDescriptor(
			CompletionProposal proposal) {
		ImageDescriptor imageDescriptor = extraImageFromProposal(proposal);
		if (imageDescriptor != null)
			return imageDescriptor;
		return super.createFieldImageDescriptor(proposal);
	}

	/**
	 * @see org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider#createLocalImageDescriptor(org.eclipse.dltk.core.CompletionProposal)
	 */
	@Override
	protected ImageDescriptor createLocalImageDescriptor(
			CompletionProposal proposal) {
		ImageDescriptor imageDescriptor = extraImageFromProposal(proposal);
		if (imageDescriptor != null)
			return imageDescriptor;
		return super.createLocalImageDescriptor(proposal);
	}

	/**
	 * @see org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider#createMethodImageDescriptor(org.eclipse.dltk.core.CompletionProposal)
	 */
	@Override
	public ImageDescriptor createMethodImageDescriptor(
			CompletionProposal proposal) {
		ImageDescriptor imageDescriptor = extraImageFromProposal(proposal);
		if (imageDescriptor != null)
			return imageDescriptor;
		return super.createMethodImageDescriptor(proposal);
	}

	/**
	 * @see org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider#createPackageImageDescriptor(org.eclipse.dltk.core.CompletionProposal)
	 */
	@Override
	protected ImageDescriptor createPackageImageDescriptor(
			CompletionProposal proposal) {
		ImageDescriptor imageDescriptor = extraImageFromProposal(proposal);
		if (imageDescriptor != null)
			return imageDescriptor;
		return super.createPackageImageDescriptor(proposal);
	}

	/**
	 * @see org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider#createTypeImageDescriptor(org.eclipse.dltk.core.CompletionProposal)
	 */
	@Override
	public ImageDescriptor createTypeImageDescriptor(CompletionProposal proposal) {
		ImageDescriptor imageDescriptor = extraImageFromProposal(proposal);
		if (imageDescriptor != null)
			return imageDescriptor;
		return super.createTypeImageDescriptor(proposal);
	}

	@Override
	protected ImageDescriptor decorateImageDescriptor(
			ImageDescriptor descriptor, CompletionProposal proposal) {
		if (isDeprecated(proposal)) {
			return new ScriptElementImageDescriptor(descriptor,
					ScriptElementImageDescriptor.DEPRECATED,
					ScriptElementImageProvider.SMALL_SIZE);
		} else if (isStatic(proposal)) {
			return new ScriptElementImageDescriptor(descriptor,
					ScriptElementImageDescriptor.STATIC,
					ScriptElementImageProvider.SMALL_SIZE);
		}
		return super.decorateImageDescriptor(descriptor, proposal);
	}

	/**
	 * @param proposal
	 * @return
	 */
	private boolean isStatic(CompletionProposal proposal) {
		if (proposal.getExtraInfo() instanceof Member) {
			return ((Member) proposal.getExtraInfo()).isStatic();
		} else {
			return false;
		}
	}

	private boolean isDeprecated(CompletionProposal proposal) {
		if (proposal.getExtraInfo() instanceof Element) {
			return ((Element) proposal.getExtraInfo()).isDeprecated();
		} else if (proposal.getExtraInfo() instanceof IValueReference) {
			final IValueReference reference = (IValueReference) proposal
					.getExtraInfo();
			final IMethod method = (IMethod) reference
					.getAttribute(IReferenceAttributes.METHOD);
			if (method != null)
				return method.isDeprecated();
			final IVariable variable = (IVariable) reference
					.getAttribute(IReferenceAttributes.VARIABLE);
			return variable != null && variable.isDeprecated();
		} else if (proposal.getExtraInfo() instanceof JSMethod) {
			return ((JSMethod) proposal.getExtraInfo()).isDeprecated();
		}
		return false;
	}
}
