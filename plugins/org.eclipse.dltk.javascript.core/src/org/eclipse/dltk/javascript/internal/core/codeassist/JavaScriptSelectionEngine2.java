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
package org.eclipse.dltk.javascript.internal.core.codeassist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.annotations.Nullable;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.utils.ASTUtil;
import org.eclipse.dltk.codeassist.ScriptSelectionEngine;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IMember;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IModelElementVisitor;
import org.eclipse.dltk.core.IParent;
import org.eclipse.dltk.core.IProjectFragment;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.core.ScriptModelUtil;
import org.eclipse.dltk.core.SourceRange;
import org.eclipse.dltk.core.model.LocalVariable;
import org.eclipse.dltk.core.model.UnresolvedElement;
import org.eclipse.dltk.internal.javascript.ti.AnonymousValue;
import org.eclipse.dltk.internal.javascript.ti.ElementValue;
import org.eclipse.dltk.internal.javascript.ti.IReferenceAttributes;
import org.eclipse.dltk.internal.javascript.ti.IValue;
import org.eclipse.dltk.internal.javascript.ti.JSDocSupport;
import org.eclipse.dltk.internal.javascript.ti.JSDocSupport.ParameterNode;
import org.eclipse.dltk.internal.javascript.ti.JSDocSupport.TypeNode;
import org.eclipse.dltk.internal.javascript.ti.JSDocSupport.TypedElementNode;
import org.eclipse.dltk.internal.javascript.ti.PositionReachedException;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencer2;
import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.MultiLineComment;
import org.eclipse.dltk.javascript.ast.PropertyInitializer;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.StringLiteral;
import org.eclipse.dltk.javascript.ast.ThisExpression;
import org.eclipse.dltk.javascript.core.NodeFinder;
import org.eclipse.dltk.javascript.parser.JavaScriptParserUtil;
import org.eclipse.dltk.javascript.parser.jsdoc.JSDocTag;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinference.ValueReferenceUtil;
import org.eclipse.dltk.javascript.typeinfo.IRMember;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRProperty;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.JSDocTypeRegion;
import org.eclipse.dltk.javascript.typeinfo.JSDocTypeUtil;
import org.eclipse.dltk.javascript.typeinfo.JSTypeSet;
import org.eclipse.dltk.javascript.typeinfo.TypeInfoManager;
import org.eclipse.dltk.javascript.typeinfo.model.Element;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.Method;
import org.eclipse.dltk.javascript.typeinfo.model.Property;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;

public class JavaScriptSelectionEngine2 extends ScriptSelectionEngine {

	private static final boolean DEBUG = false;

	public static boolean isJSDocTypeSelectionEnabled() {
		return true;
	}

	@SuppressWarnings("serial")
	private static class ModelElementFound extends RuntimeException {
		final IModelElement element;

		public ModelElementFound(IModelElement element) {
			this.element = element;
		}

	}

	private static class Visitor implements IModelElementVisitor {

		private final int nameStart;
		private final int nameEnd;

		public Visitor(int nameStart, int nameEnd) {
			this.nameStart = nameStart;
			this.nameEnd = nameEnd;
		}

		public boolean visit(IModelElement element) {
			if (element instanceof IMember) {
				IMember member = (IMember) element;
				try {
					ISourceRange range = member.getNameRange();
					if (range.getOffset() == nameStart
							&& range.getLength() == nameEnd - nameStart) {
						throw new ModelElementFound(element);
					}
				} catch (ModelException e) {
					//
				}
			}
			return true;
		}

	}

	private static boolean isStringLiteralInObjectLiteral(ASTNode node) {
		if (node instanceof StringLiteral) {
			final StringLiteral literal = (StringLiteral) node;
			if (literal.getParent() instanceof PropertyInitializer) {
				final PropertyInitializer initializer = (PropertyInitializer) literal
						.getParent();
				return initializer.getName() == literal;
			}
		}
		return false;
	}

	public IModelElement[] select(final IModuleSource module, int position,
			int i) {
		if (!(module.getModelElement() instanceof ISourceModule) || i == -1) {
			return null;
		}
		String content = module.getSourceContents();
		if (position < 0 || position > content.length()) {
			return null;
		}
		if (DEBUG) {
			System.out
					.println("select in " + module.getFileName() + " at " + position); //$NON-NLS-1$ //$NON-NLS-2$
		}
		final Script script = JavaScriptParserUtil.parse(module, null);

		NodeFinder finder = new NodeFinder(position, i + 1);
		finder.locate(script);
		ASTNode node = finder.getNode();
		if (node != null) {
			if (DEBUG) {
				System.out.println(node.getClass().getName() + "=" + node); //$NON-NLS-1$
			}
			if (node instanceof Identifier || node instanceof ThisExpression
					|| isStringLiteralInObjectLiteral(node)) {
				final TypeInferencer2 inferencer2 = new TypeInferencer2();
				final SelectionVisitor visitor = new SelectionVisitor(
						inferencer2, node);
				inferencer2.setVisitor(visitor);
				inferencer2.setModelElement(module.getModelElement());
				try {
					inferencer2.doInferencing(script);
				} catch (PositionReachedException e) {
					//
				}
				final IValueReference value = visitor.getValue();
				if (value == null) {
					if (DEBUG) {
						System.out.println("value is null or not found"); //$NON-NLS-1$
					}
					return null;
				}
				ITypeSystem.CURRENT.runWith(inferencer2, new Runnable() {
					public void run() {
						toModelElements(inferencer2, visitor, module, value);
					}
				});
				return null;
			} else if (node instanceof MultiLineComment
					&& isJSDocTypeSelectionEnabled()) {
				final MultiLineComment comment = (MultiLineComment) node;
				if (comment.isDocumentation()) {
					final JSDocTag tag = JSDocSupport.parse(comment).getTagAt(
							position);
					if (tag == null || position < tag.valueStart()) {
						return null;
					}
					final int valueOffset = tag.toValueOffset(position);
					if (JSDocTag.PARAM.equals(tag.name())) {
						final ParameterNode paramNode = JSDocSupport
								.parseParameter(tag);
						if (paramNode != null) {
							if (paramNode.isInParameter(valueOffset)) {
								final FunctionStatement function = findFunctionByDocumentation(
										script, comment);
								if (function != null) {
									final Argument argument = function
											.getArgument(paramNode.name);
									if (argument != null) {
										return new IModelElement[] { new LocalVariable(
												module.getModelElement(),
												paramNode.name,
												argument.start(),
												argument.end(),
												argument.start(),
												argument.end() - 1, null,
												null) };
									}
								}
							} else if (paramNode.isInType(valueOffset)) {
								findTypeInTypeExpression(module, script, tag,
										paramNode, valueOffset);
							}
						}
					} else if (JSDocTag.RETURN.equals(tag.name())
							|| JSDocTag.RETURNS.equals(tag.name())) {
						final TypedElementNode typedNode = JSDocSupport
								.parseOptionalType(tag);
						if (typedNode != null
								&& typedNode.isInType(valueOffset)) {
							findTypeInTypeExpression(module, script, tag,
									typedNode,
									valueOffset);
						}
					} else if (JSDocTag.TYPE.equals(tag.name())
							|| JSDocTag.EXTENDS.equals(tag.name())
							|| JSDocTag.THIS.equals(tag.name())) {
						final TypeNode typeNode = JSDocSupport.parseType(tag);
						if (typeNode != null && typeNode.isInType(valueOffset)) {
							findTypeInTypeExpression(module, script, tag,
									typeNode,
									valueOffset);
						}
					}
				}
			}
		}

		// TODO Auto-generated method stub
		return null;
	}

	private void findTypeInTypeExpression(IModuleSource module, Script script,
			JSDocTag tag,
			TypedElementNode node, int valueOffset) {
		final ISourceModule m = (ISourceModule) module.getModelElement();
		final TypeInferencer2 inferencer2 = new TypeInferencer2();
		inferencer2.setModelElement(module.getModelElement());
		final JSDocTypeRegion typeRegion = JSDocTypeUtil.findTypeAt(
				inferencer2, node.getTypeExpression(),
				valueOffset - node.getTypeExpressionStart());
		if (typeRegion != null) {
			Type type = inferencer2.getKnownType(typeRegion.name());
			if (type == null) {
				inferencer2.setVisitFunctionBody(false);
				inferencer2.doInferencing(script);
				type = inferencer2.getKnownType(typeRegion.name());
				if (type == null) {
					IValueReference child = inferencer2.getCollection()
							.getChild(typeRegion.name());
					if (child.exists()) {
						toModelElements(inferencer2, null, module, child);
					} else {
						String[] split = typeRegion.name().split("\\.");
						if (split.length > 1) {
							IRMember member = inferencer2.resolve(split[0]);
							if (member != null) {
								ElementValue for1 = ElementValue
										.createFor(member);
								IValue child2 = for1.getChild(split[1], true);
								if (child2 != null) {
									for (int i = 2; i < split.length; i++) {
										child2 = child2.getChild(split[i],
												true);
										if (child2 == null) {
											break;
										}
									}
								}
								if (child2 != null) {
									toModelElements(inferencer2, null, module,
											new AnonymousValue(child2));
								}
							}
						}
					}
				}
			}
			if (type != null) {
				final int typeOffsetInFile = tag.fromValueOffset(typeRegion
						.start() + node.getTypeExpressionStart());
				convertAndReportElement(m, type, new SourceRange(
						typeOffsetInFile, typeRegion.length()));
			}
		}
	}

	/**
	 * Finds the function the specified documentation belongs to.
	 */
	@Nullable
	private static FunctionStatement findFunctionByDocumentation(Script script,
			MultiLineComment comment) {
		for (FunctionStatement function : ASTUtil.select(script,
				FunctionStatement.class, true)) {
			if (function.getDocumentation() == comment
					|| JSDocSupport.getComment(function) == comment) {
				return function;
			}
		}
		return null;
	}

	private void toModelElements(TypeInferencer2 inferencer2,
			SelectionVisitor visitor, IModuleSource module,
			IValueReference value) {
		final ReferenceKind kind = value.getKind();
		if (DEBUG) {
			System.out.println(value + "," + kind); //$NON-NLS-1$
		}
		final ReferenceLocation location = value.getLocation();
		if (DEBUG) {
			System.out.println(location);
		}
		ISourceModule m = (ISourceModule) module.getModelElement();
		if (kind == ReferenceKind.ARGUMENT || kind == ReferenceKind.LOCAL) {
			if (location == ReferenceLocation.UNKNOWN) {
				return;
			}
			final IModelElement result = locateModelElement(location);
			if (result != null
					&& (result.getElementType() == IModelElement.FIELD || result
							.getElementType() == IModelElement.METHOD)) {
				reportElement(result);
				return;
			}
			final IRType type = JavaScriptValidations.typeOf(value);
			final String description = (String) value
					.getAttribute(IReferenceAttributes.DESCRIPTION);
			reportElement(new LocalVariable(m, value.getName(),
					location.getDeclarationStart(),
					location.getDeclarationEnd(), location.getNameStart(),
					location.getNameEnd() - 1, type == null ? null
							: type.getName(),
					description));
			return;
		} else if (kind == ReferenceKind.FUNCTION
				|| kind == ReferenceKind.GLOBAL || kind == ReferenceKind.FIELD
				|| kind == ReferenceKind.THIS) {
			if (location == ReferenceLocation.UNKNOWN) {
				return;
			}
			final IModelElement result = locateModelElement(location);
			if (result != null) {
				reportElement(result);
				return;
			}
		} else if (kind == ReferenceKind.PROPERTY) {
			final Collection<IRProperty> properties = ValueReferenceUtil
					.extractElements(value, IRProperty.class);
			if (properties != null) {
				for (IRProperty prop : properties) {
					reportElement(prop);
				}
				return;
			}
			final IModelElement result = locateModelElement(location);
			if (result != null) {
				reportElement(result);
				return;
			}
		} else if (kind == ReferenceKind.METHOD) {
			final List<IRMethod> methods = ValueReferenceUtil.extractElements(
					value, IRMethod.class);
			if (methods != null) {
				IValueReference[] arguments = visitor != null
						? visitor.getArguments()
						: null;
				if (arguments == null) {
					arguments = new IValueReference[0];
				}
				final IRMethod method = JavaScriptValidations.selectMethod(
						methods, arguments, true);
				if (method.getSource() instanceof Method element) {
					try {
						IModelElement me = convert(m, element);
						if (me != null)
							reportElement(me);
						else {
							reportElement(method);
						}
					} catch (ModelException e) {
					}
					return;
				}
			}
		} else if (kind == ReferenceKind.TYPE) {
			final LinkedHashSet<Type> t = new LinkedHashSet<Type>();
			JSTypeSet types = value.getDeclaredTypes();
			if (types != null) {
				Collections.addAll(t, types.toArray());
			}
			types = value.getTypes();
			if (types != null) {
				Collections.addAll(t, types.toArray());
			}
			if (!t.isEmpty()) {
				convertAndReportElements(m, t);
				return;
			}
		}
		if (location != ReferenceLocation.UNKNOWN
				&& location.getSourceModule() != null) {
			reportElement(new UnresolvedElement(location.getSourceModule(),
					value.getName(), location.getNameStart(),
					location.getNameEnd() - 1));
			return;
		}
		return;
	}

	/**
	 * @param module
	 * @param elements
	 * @return
	 */
	private void convertAndReportElements(ISourceModule module,
			Collection<? extends Element> elements) {
		for (Element element : elements) {
			convertAndReportElement(module, element, null);
		}
	}

	private void convertAndReportElement(ISourceModule module, Element element,
			ISourceRange range) {
		try {
			final IModelElement me = convert(module, element);
			reportElement(me != null ? me : element, range);
		} catch (ModelException e) {
			//
		}
	}

	/**
	 * @param module
	 * @param element
	 * @return
	 * @throws ModelException
	 */
	private IModelElement convert(ISourceModule module, Element element)
			throws ModelException {
		Type type;
		if (element instanceof Type) {
			type = (Type) element;
		} else {
			type = ((Member) element).getDeclaringType();
		}
		if (type != null && type.getKind() == TypeKind.PREDEFINED) {
			final List<String> path = new ArrayList<String>();
			path.add(type.getName());
			if (element != type) {
				path.add(element.getName());
			}
			return resolveBuiltin(module.getScriptProject(), path);
		}
		if (type != null && type.getKind() == TypeKind.JAVASCRIPT) {
			ReferenceLocation location = (ReferenceLocation) element
					.getAttribute(IReferenceAttributes.LOCATION);
			if (location != null && location != ReferenceLocation.UNKNOWN) {
				if (element instanceof Property) {
					return new LocalVariable(module, element.getName(),
							location.getDeclarationStart(),
							location.getDeclarationEnd(),
							location.getNameStart(), location.getNameEnd() - 1,
							null, null);
				}
				final IModelElement result = locateModelElement(location);
				if (result != null) {
					return result;
				}
			} else {
				// TODO this only goes 1 deep, need support for nested types..
				IModelElement[] children = module.getChildren();
				for (IModelElement modelElement : children) {
					if (modelElement.getElementType() == IModelElement.METHOD
							&& modelElement.getElementName().equals(
									type.getName())) {
						IModelElement[] children2 = ((IParent) modelElement)
								.getChildren();
						for (IModelElement child : children2) {
							if (child.getElementName()
									.equals(element.getName()))
								return child;
						}
						return modelElement;
					}
				}
			}
		}
		return TypeInfoManager.convertElement(module, element);
	}

	private IModelElement locateModelElement(final ReferenceLocation location) {
		ISourceModule module = location.getSourceModule();
		if (module != null) {
			try {
				ScriptModelUtil.reconcile(module);
				module.accept(new Visitor(location.getNameStart(), location
						.getNameEnd()));
			} catch (ModelException e) {
				if (DLTKCore.DEBUG) {
					e.printStackTrace();
				}
			} catch (ModelElementFound e) {
				return e.element;
			}
		}
		return null;
	}

	/**
	 * @param project
	 * @param segments
	 * @return
	 * @throws ModelException
	 */
	private IModelElement resolveBuiltin(IScriptProject project,
			List<String> segments) throws ModelException {
		for (IProjectFragment fragment : project.getProjectFragments()) {
			if (fragment.isBuiltin()) {
				ISourceModule m = fragment.getScriptFolder(Path.EMPTY)
						.getSourceModule("builtins.js"); //$NON-NLS-1$
				if (!m.exists()) {
					return null;
				}
				IModelElement me = m;
				SEGMENT_LOOP: for (String segment : segments) {
					if (me instanceof IParent) {
						final IModelElement[] children = ((IParent) me)
								.getChildren();
						for (IModelElement child : children) {
							if (segment.equals(child.getElementName())) {
								me = child;
								continue SEGMENT_LOOP;
							}
						}
					}
					return null;
				}
				return me;
			}
		}
		return null;
	}
}
