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
package org.eclipse.dltk.internal.javascript.ti;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.internal.javascript.validation.ValidationMessages;
import org.eclipse.dltk.javascript.ast.ArrayInitializer;
import org.eclipse.dltk.javascript.ast.AsteriskExpression;
import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.BooleanLiteral;
import org.eclipse.dltk.javascript.ast.BreakStatement;
import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.CaseClause;
import org.eclipse.dltk.javascript.ast.CatchClause;
import org.eclipse.dltk.javascript.ast.CommaExpression;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.ConditionalOperator;
import org.eclipse.dltk.javascript.ast.ConstStatement;
import org.eclipse.dltk.javascript.ast.ContinueStatement;
import org.eclipse.dltk.javascript.ast.DecimalLiteral;
import org.eclipse.dltk.javascript.ast.DefaultXmlNamespaceStatement;
import org.eclipse.dltk.javascript.ast.DoWhileStatement;
import org.eclipse.dltk.javascript.ast.EmptyExpression;
import org.eclipse.dltk.javascript.ast.EmptyStatement;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.ForEachInStatement;
import org.eclipse.dltk.javascript.ast.ForInStatement;
import org.eclipse.dltk.javascript.ast.ForStatement;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.GetAllChildrenExpression;
import org.eclipse.dltk.javascript.ast.GetArrayItemExpression;
import org.eclipse.dltk.javascript.ast.GetLocalNameExpression;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.IfStatement;
import org.eclipse.dltk.javascript.ast.JSDeclaration;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.JSScope;
import org.eclipse.dltk.javascript.ast.LabelledStatement;
import org.eclipse.dltk.javascript.ast.NewExpression;
import org.eclipse.dltk.javascript.ast.NullExpression;
import org.eclipse.dltk.javascript.ast.ObjectInitializer;
import org.eclipse.dltk.javascript.ast.ObjectInitializerPart;
import org.eclipse.dltk.javascript.ast.ParenthesizedExpression;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.PropertyInitializer;
import org.eclipse.dltk.javascript.ast.RegExpLiteral;
import org.eclipse.dltk.javascript.ast.ReturnStatement;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.Statement;
import org.eclipse.dltk.javascript.ast.StatementBlock;
import org.eclipse.dltk.javascript.ast.StringLiteral;
import org.eclipse.dltk.javascript.ast.SwitchComponent;
import org.eclipse.dltk.javascript.ast.SwitchStatement;
import org.eclipse.dltk.javascript.ast.ThisExpression;
import org.eclipse.dltk.javascript.ast.ThrowStatement;
import org.eclipse.dltk.javascript.ast.TryStatement;
import org.eclipse.dltk.javascript.ast.UnaryOperation;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.VoidExpression;
import org.eclipse.dltk.javascript.ast.WhileStatement;
import org.eclipse.dltk.javascript.ast.WithStatement;
import org.eclipse.dltk.javascript.ast.XmlAttributeIdentifier;
import org.eclipse.dltk.javascript.ast.XmlExpressionFragment;
import org.eclipse.dltk.javascript.ast.XmlFragment;
import org.eclipse.dltk.javascript.ast.XmlLiteral;
import org.eclipse.dltk.javascript.ast.XmlTextFragment;
import org.eclipse.dltk.javascript.ast.YieldOperator;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.core.JavaScriptPlugin;
import org.eclipse.dltk.javascript.core.JavaScriptProblems;
import org.eclipse.dltk.javascript.internal.core.RRecordMember;
import org.eclipse.dltk.javascript.parser.ISuppressWarningsState;
import org.eclipse.dltk.javascript.parser.PropertyExpressionUtils;
import org.eclipse.dltk.javascript.parser.jsdoc.JSDocTag;
import org.eclipse.dltk.javascript.parser.jsdoc.JSDocTags;
import org.eclipse.dltk.javascript.typeinference.IAssignProtection;
import org.eclipse.dltk.javascript.typeinference.IFunctionValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.PhantomValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceKind;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinference.ValueReferenceUtil;
import org.eclipse.dltk.javascript.typeinfo.CommonSuperTypeFinder;
import org.eclipse.dltk.javascript.typeinfo.E4XTypes;
import org.eclipse.dltk.javascript.typeinfo.GenericMethodTypeInferencer;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IMethod;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IParameter;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IVariable;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilderExtension;
import org.eclipse.dltk.javascript.typeinfo.IRArrayType;
import org.eclipse.dltk.javascript.typeinfo.IRClassType;
import org.eclipse.dltk.javascript.typeinfo.IRConstructor;
import org.eclipse.dltk.javascript.typeinfo.IRFunctionType;
import org.eclipse.dltk.javascript.typeinfo.IRLocalType;
import org.eclipse.dltk.javascript.typeinfo.IRMapType;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRProperty;
import org.eclipse.dltk.javascript.typeinfo.IRRecordMember;
import org.eclipse.dltk.javascript.typeinfo.IRRecordType;
import org.eclipse.dltk.javascript.typeinfo.IRSimpleType;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.IRTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.IRVariable;
import org.eclipse.dltk.javascript.typeinfo.ITypeInferenceListener;
import org.eclipse.dltk.javascript.typeinfo.ITypeNames;
import org.eclipse.dltk.javascript.typeinfo.JSTypeSet;
import org.eclipse.dltk.javascript.typeinfo.RModelBuilder;
import org.eclipse.dltk.javascript.typeinfo.RTypes;
import org.eclipse.dltk.javascript.typeinfo.ReferenceSource;
import org.eclipse.dltk.javascript.typeinfo.TypeMode;
import org.eclipse.dltk.javascript.typeinfo.TypeUtil;
import org.eclipse.dltk.javascript.typeinfo.model.ArrayType;
import org.eclipse.dltk.javascript.typeinfo.model.FunctionType;
import org.eclipse.dltk.javascript.typeinfo.model.GenericMethod;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.MapType;
import org.eclipse.dltk.javascript.typeinfo.model.Parameter;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterizedType;
import org.eclipse.dltk.javascript.typeinfo.model.RecordType;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariableClassType;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariableReference;
import org.eclipse.dltk.javascript.typeinfo.model.UnionType;
import org.eclipse.dltk.javascript.typeinfo.model.util.TypeInfoModelSwitch;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TypeInferencerVisitor extends TypeInferencerVisitorBase {

	private boolean visitFunctionBody;

	public TypeInferencerVisitor(ITypeInferenceContext context) {
		this(context, true);
	}

	public TypeInferencerVisitor(ITypeInferenceContext context,
			boolean visitFunctionBody) {
		super(context);
		this.visitFunctionBody = visitFunctionBody;
	}

	private static class ForwardDeclaration {
		final JSMethod method;
		final IValueReference reference;

		public ForwardDeclaration(JSMethod method, IValueReference reference) {
			this.method = method;
			this.reference = reference;
		}
	}

	private final Map<FunctionStatement, ForwardDeclaration> forwardDeclarations = new IdentityHashMap<FunctionStatement, ForwardDeclaration>();

	@Override
	public void initialize() {
		super.initialize();
		forwardDeclarations.clear();
	}

	private final Stack<Branching> branchings = new Stack<Branching>();

	private class Branching {
		public void end() {
			branchings.remove(this);
		}
	}

	protected Branching branching() {
		final Branching branching = new Branching();
		branchings.add(branching);
		return branching;
	}

	public ReferenceSource getSource() {
		final ReferenceSource source = context.getSource();
		return source != null ? source : ReferenceSource.UNKNOWN;
	}

	protected void assign(IValueReference dest, IValueReference src) {
		IRType destType = JavaScriptValidations.typeOf(dest);
		if (destType != null && isXML(destType)) {
			IRType srcType = JavaScriptValidations.typeOf(src);
			if (srcType != null && !isXML(srcType))
				return;
		}
		if (branchings.isEmpty()) {
			dest.setValue(src);
		} else {
			dest.addValue(src, false);
		}
	}

	private static boolean isXML(IRType srcType) {
		return (srcType instanceof IRSimpleType)
				&& (ITypeNames.XML.equals(srcType.getName()) || ITypeNames.XMLLIST
						.equals(srcType.getName()));
	}

	@Override
	public IValueReference visitArrayInitializer(ArrayInitializer node) {
		if (node.getItems().isEmpty()) {
			return new ConstantValue(RTypes.arrayOf());
		}
		final Set<IRType> types = new HashSet<IRType>();
		for (ASTNode astNode : node.getItems()) {
			if (astNode instanceof StringLiteral) {
				types.add(RTypes.STRING);
			} else if (astNode instanceof DecimalLiteral) {
				types.add(RTypes.NUMBER);
			} else if (astNode instanceof BooleanLiteral) {
				types.add(RTypes.BOOLEAN);
			} else if (astNode instanceof NullExpression
					|| astNode instanceof EmptyExpression) {
				// ignore
			} else {
				final IValueReference child = visit(astNode);
				if (child != null && child.exists()) {
					for (IRType type : JavaScriptValidations.getTypes(child)) {
						if (type == null) {
							JavaScriptPlugin.error(buildNodeErrorMessage(node)
									+ " - item type is null");
							continue;
						}
						types.add(type.normalize());
					}
				}
				// TODO (alex) else add(Object) ?
			}
		}
		if (types.isEmpty()) {
			return new ConstantValue(RTypes.arrayOf());
		} else {
			if (types.size() == 1) {
				return new ConstantValue(RTypes.arrayOf(context,
						CommonSuperTypeFinder.evaluate(context, types)));
			} else {
				return new ConstantValue(RTypes.arrayOf(context,
						RTypes.union(types)));
			}
		}
	}

	@Override
	public IValueReference visitAsteriskExpression(AsteriskExpression node) {
		return new XMLListValue(peekContext());
	}

	@Override
	public IValueReference visitBinaryOperation(BinaryOperation node) {
		final IValueReference left = visit(node.getLeftExpression());
		if (node.isAssignOperator()) {
			if (left != null) {
				for (IModelBuilder modelBuilder : context.getModelBuilders()) {
					if (modelBuilder instanceof IModelBuilderExtension) {
						((IModelBuilderExtension) modelBuilder)
								.processAssignment(node.getLeftExpression(),
										left);
					}
				}
			}
			if (left != null && left.exists()) {
				if (left.getParent() instanceof ThisValue) {
					// this is an override, make sure that left is really
					// created. copy over the variable (so that visibility is used)
					Object variable = left
							.getAttribute(IReferenceAttributes.R_VARIABLE);
					left.getParent().createChild(left.getName());
					if (variable != null) {
						left.setAttribute(IReferenceAttributes.R_VARIABLE,
								variable);
					}
					Expression property = node.getLeftExpression();
					if (property instanceof PropertyExpression) {
						left.setLocation(ReferenceLocation.create(getSource(),
								property.sourceStart(), property.sourceEnd(),
								((PropertyExpression) property).getProperty()
										.sourceStart(),
								((PropertyExpression) property).getProperty()
										.sourceEnd()));
					}
				}
				left.setAttribute(IReferenceAttributes.RESOLVING, Boolean.TRUE);
				final IValueReference r;
				try {
					r = visit(node.getRightExpression());
				} finally {
					left.setAttribute(IReferenceAttributes.RESOLVING, null);
				}
				return visitAssign(left, r, node);
			} else {
				return visitAssign(left, visit(node.getRightExpression()), node);
			}
		}
		final IValueReference right = visit(node.getRightExpression());
		if (left == null && right instanceof ConstantValue) {
			return right;
		} else if (node.isLogicalAnd()) {
			return coalesce(right, left);
		} else if (node.returnsBoolean()) {
			return ConstantValue.of(RTypes.BOOLEAN);
		} else if (isNumber(left) && isNumber(right)) {
			return ConstantValue.of(RTypes.NUMBER);
		} else if (node.isAddition()) {
			if (isString(left) || isString(right)) {
				return ConstantValue.of(RTypes.STRING);
			}
			return left;
		} else if (node.isLogicalOr()) {
			final JSTypeSet typeSet = JSTypeSet.create();
			if (left != null) {
				typeSet.addAll(left.getDeclaredTypes());
				typeSet.addAll(left.getTypes());
			}
			if (right != null) {
				typeSet.addAll(right.getDeclaredTypes());
				typeSet.addAll(right.getTypes());
			}
			return new ConstantValue(typeSet);
		} else {
			// TODO handle other operations
			return null;
		}
	}

	private static IValueReference coalesce(IValueReference v1,
			IValueReference v2) {
		return v1 != null ? v1 : v2;
	}

	private boolean isNumber(IValueReference ref) {
		if (ref != null) {
			if (ref.getTypes().contains(RTypes.NUMBER))
				return true;
			if (RTypes.NUMBER.equals(ref.getDeclaredType()))
				return true;
		}
		return false;
	}

	private boolean isString(IValueReference ref) {
		if (ref != null) {
			if (ref.getTypes().contains(RTypes.STRING))
				return true;
			if (RTypes.STRING.equals(ref.getDeclaredType()))
				return true;
		}
		return false;
	}

	protected IValueReference visitAssign(IValueReference left,
			IValueReference right, BinaryOperation node) {
		if (left != null) {
			if (node.getLeftExpression() instanceof PropertyExpression) {
				final PropertyExpression property = (PropertyExpression) node
						.getLeftExpression();
				if (property.getProperty() instanceof Identifier
						&& !left.exists()) {
					final IValueReference leftParent = left.getParent();
					if (property.getObject() instanceof ThisExpression
							|| (leftParent != null && Boolean.TRUE.equals(
									leftParent.getAttribute(IReferenceAttributes.THIS_VALUE,
											true)))) {
						if (isFunctionDeclaration(property)) {
							left.setKind(ReferenceKind.FUNCTION);
							// this functions is part of an object ('this'
							// assignment). Set the this of that function to the
							// parent local type function.
							IValueCollection scope = (IValueCollection) right
									.getAttribute(IReferenceAttributes.FUNCTION_SCOPE);
							IValueCollection context = peekContext();
							if (scope != null
									&& scope.getThis().getDeclaredType() == null
									&& context instanceof IFunctionValueCollection) {
								String name = ((IFunctionValueCollection) context)
										.getFunctionName();
								scope.getThis().setDeclaredType(
										RTypes.localType(name, context
												.getParent().getChild(name)));
							}
						} 
						else {
							left.setKind(ReferenceKind.FIELD);
							final Comment comment = JSDocSupport
									.getComment(node);
							final JSDocTags tags = parseTags(comment);
							final JSDocTag typeTag = tags.get(JSDocTag.TYPE);
							if (typeTag != null) {
								final JSType type = getDocSupport().parseType(
										typeTag, false, getProblemReporter());
								if (type != null) {
									setIRType(left, type.toRType(context), true);
								}
							}
							if (comment != null) {
								IValueReference namedChild = extractNamedChild(
										left, property.getProperty());
								String name = namedChild.getName();
								final JSVariable variable = new JSVariable(name);
								getDocSupport().parseAccessModifiers(variable,
										tags, reporter);
								if (variable.getVisibility() != null) {
									left.setAttribute(
											IReferenceAttributes.R_VARIABLE,
											RModelBuilder.create(context,
													variable));
								}
							}
						}
						left.setLocation(ReferenceLocation.create(getSource(),
								property.sourceStart(), property.sourceEnd(),
								property.getProperty().sourceStart(), property
										.getProperty().sourceEnd()));
					} else {
						if (leftParent != null) {
							final IRType declaredType = leftParent
									.getDeclaredType();
							if (declaredType != null
									&& !declaredType.isExtensible()
									&& !declaredType.isJavaScriptObject()) {
								// skip assignment
								return right;
							} else {
								// if the assignment is done on the prototype property
								// then make sure it is not IRProperty (the one from Object itself)
								// replace that with a AnonymousValue
								Object attribute = leftParent
										.getAttribute(IReferenceAttributes.ELEMENT);
								if (attribute instanceof IRProperty
										&& ((IRProperty) attribute).getName()
												.equals(IRLocalType.PROTOTYPE_PROPERTY)) {
									leftParent.getParent()
											.createChild(
													IRLocalType.PROTOTYPE_PROPERTY)
											.setValue(new AnonymousValue());
								}

							}
						}
					}
				} else {
					// create a new object if prototype is directly set to record type value.
					Object attribute = left
							.getAttribute(IReferenceAttributes.ELEMENT);
					if (attribute instanceof IRProperty
							&& ((IRProperty) attribute).getName().equals(
									IRLocalType.PROTOTYPE_PROPERTY)) {
						left.getParent()
								.createChild(IRLocalType.PROTOTYPE_PROPERTY)
								.setValue(new AnonymousValue());
					}
				}
			}
			if (IValueReference.ARRAY_OP.equals(left.getName())
					&& node.getLeftExpression() instanceof GetArrayItemExpression) {
				GetArrayItemExpression arrayItemExpression = (GetArrayItemExpression) node
						.getLeftExpression();
				IValueReference namedChild = extractNamedChild(
						left.getParent(), arrayItemExpression.getIndex());
				if (namedChild != null) {
					assign(namedChild, right);
				} else {
					assign(left, right);
				}
			} else {
				if (!hasUnknowParentFunctionCall(left))
					assign(left, right);
			}
		}
		return right;
	}

	private boolean hasUnknowParentFunctionCall(IValueReference reference) {
		IValueReference parent = reference.getParent();
		while (parent != null) {
			if (parent.getName().equals(IValueReference.FUNCTION_OP)
					&& !parent.exists())
				return true;
			parent = parent.getParent();
		}
		return false;
	}

	@Override
	public IValueReference visitBooleanLiteral(BooleanLiteral node) {
		return ConstantValue.of(RTypes.BOOLEAN);
	}

	@Override
	public IValueReference visitBreakStatement(BreakStatement node) {
		return null;
	}

	@Override
	public IValueReference visitCallExpression(CallExpression node) {
		final IValueReference reference = visit(node.getExpression());
		final List<ASTNode> args = node.getArguments();
		final IValueReference[] arguments = new IValueReference[args.size()];
		for (int i = 0; i < args.size(); ++i) {
			arguments[i] = visit(args.get(i));
		}
		if (reference != null) {
			final List<IRMethod> methods = ValueReferenceUtil.extractElements(
					reference, IRMethod.class);
			if (methods != null && methods.size() == 1) {
				final IRMethod method = methods.get(0);
				IValueReference ref = checkSpecialJavascriptFunctionCalls(
						reference, arguments, method);
				if (ref != null)
					return ref;
				if (method.isGeneric()) {
					final IRType type = evaluateGenericCall(method, arguments);
					return ConstantValue.of(type);
				} else {
					return ConstantValue.of(method.getType());
				}
			} else {
				final IRType expressionType = JavaScriptValidations
						.typeOf(reference);
				if (expressionType != null) {
					if (expressionType instanceof IRFunctionType) {
						return ConstantValue
								.of(((IRFunctionType) expressionType)
										.getReturnType());
					} else if (expressionType instanceof IRClassType) {
						final IRTypeDeclaration target = ((IRClassType) expressionType)
								.getDeclaration();
						if (target != null) {
							final IRConstructor constructor = target
									.getStaticConstructor();
							if (constructor != null
									&& constructor.getType() != null) {
								return new ConstantValue(constructor.getType());
							}
						}
					}
				}
			}
			return reference.getChild(IValueReference.FUNCTION_OP);
		} else {
			return null;
		}
	}

	protected IValueReference checkSpecialJavascriptFunctionCalls(
			final IValueReference reference, final IValueReference[] arguments,
			final IRMethod method) {
		if (method.getName() != null) {
			if (reference.getParent() != null
					&& RTypes.FUNCTION.getDeclaration().equals(
							method.getDeclaringType())) {

				if ("call".equals(method.getName())
						|| "apply".equals(method.getName())) {
					Object x = reference.getParent().getAttribute(
							IReferenceAttributes.ELEMENT);
					if (x == null)
						x = reference.getParent().getAttribute(
								IReferenceAttributes.R_METHOD);
					if (x instanceof IRMethod) {
						return ConstantValue.of(((IRMethod) x).getType());
					}
				} else if ("bind".equals(method.getName())) {
					return reference.getParent();
				}
			} else if ((method.getName().equals("create")
					|| method.getName().equals("freeze")
					|| method.getName().equals("seal"))
					&& RTypes.OBJECT.getDeclaration().equals(
							method.getDeclaringType()) && arguments.length > 0
					&& arguments[0] != null) {
				AnonymousValue value = new AnonymousValue();
				IValue argumentValue = ((IValueProvider) arguments[0])
						.getValue();

				if (argumentValue != null)
					value.getValue().addValue(argumentValue);
				if (arguments.length == 2) {
					JSTypeSet types = arguments[1].getTypes();
					for (IRType type : types) {
						if (type instanceof IRRecordType) {
							List<IRRecordMember> newMembers = new ArrayList<IRRecordMember>();
							Collection<IRRecordMember> members = ((IRRecordType) type)
									.getMembers();
							for (IRRecordMember member : members) {
								if (member.getType() instanceof IRRecordType) {
									IRRecordMember valueMember = ((IRRecordType) member
											.getType()).getMember("value");
									if (valueMember != null) {
										newMembers.add(new RRecordMember(member
														.getName(), valueMember
														.getType(), member
														.getSource()));
									}
									valueMember = ((IRRecordType) member
											.getType()).getMember("get");
									if (valueMember != null) {
										IRType valueType = valueMember
												.getType();
										if (valueType instanceof IRFunctionType) {
											valueType = ((IRFunctionType) valueType)
													.getReturnType();
										}
										newMembers.add(new RRecordMember(member
												.getName(), valueType,
												valueMember.getSource()));
									}
								} else {
									newMembers.add(member);
								}
							}
							if (newMembers.size() > 0) {
								value.addValue(ConstantValue.of(RTypes
										.recordType(newMembers)), true);
							}
						}
					}
				}
				return value;
			}
		}
		return null;
	}

	protected IRType evaluateGenericCall(IRMethod rMethod,
			IValueReference[] arguments) {
		assert rMethod.isGeneric();
		final GenericMethod method = (GenericMethod) rMethod.getSource();
		final GenericMethodTypeInferencer methodTypeInferencer = new GenericMethodTypeInferencer(
				context, method);
		for (int i = 0; i < arguments.length; ++i) {
			final Parameter parameter = method.getParameterFor(i);
			if (parameter != null) {
				// parameter count is checked in ValidationVisitor
				// TODO (alex) can be pre-evaluated in GenericParameter objects.
				if (TypeUtil.containsTypeVariables(parameter.getType())) {
					final IValueReference argument = arguments[i];
					JSTypeSet argTypes;
					if (argument != null) {
						argTypes = argument.getDeclaredTypes();
						if (argTypes.isEmpty()) {
							argTypes = argument.getTypes();
						}
					} else {
						argTypes = JSTypeSet.emptySet();
					}
					methodTypeInferencer.capture(parameter.getType(), argTypes);
				} else {
					// TODO (alex) check parameter compatibility
				}
			}
		}
		return RTypes.create(methodTypeInferencer, method.getType());
	}

	public static final TypeInfoModelSwitch<Boolean> GENERIC_TYPE_EXPRESSION = new TypeInfoModelSwitch<Boolean>() {
		@Override
		public Boolean doSwitch(EObject theEObject) {
			return theEObject != null ? super.doSwitch(theEObject) : null;
		}

		@Override
		public Boolean caseJSType(JSType object) {
			return Boolean.FALSE;
		}

		@Override
		public Boolean caseTypeVariableReference(TypeVariableReference object) {
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseTypeVariableClassType(TypeVariableClassType object) {
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseArrayType(ArrayType object) {
			return doSwitch(object.getItemType());
		}

		@Override
		public Boolean caseMapType(MapType object) {
			final Boolean result = doSwitch(object.getKeyType());
			if (result == Boolean.TRUE) {
				return result;
			}
			return doSwitch(object.getValueType());
		}

		@Override
		public Boolean caseParameterizedType(ParameterizedType object) {
			for (JSType type : object.getActualTypeArguments()) {
				final Boolean result = doSwitch(type);
				if (result == Boolean.TRUE) {
					return result;
				}
			}
			return Boolean.FALSE;
		}

		@Override
		public Boolean caseUnionType(UnionType object) {
			for (JSType type : object.getTargets()) {
				final Boolean result = doSwitch(type);
				if (result == Boolean.TRUE) {
					return result;
				}
			}
			return Boolean.FALSE;
		}

		@Override
		public Boolean caseFunctionType(FunctionType object) {
			for (Parameter parameter : object.getParameters()) {
				final Boolean result = doSwitch(parameter.getType());
				if (result == Boolean.TRUE) {
					return result;
				}
			}
			return doSwitch(object.getReturnType());
		}
	};

	@Override
	public IValueReference visitCommaExpression(CommaExpression node) {
		return visit(node.getItems());
	}

	@Override
	public IValueReference visitConditionalOperator(ConditionalOperator node) {
		visit(node.getCondition());
		return merge(visit(node.getTrueValue()), visit(node.getFalseValue()));
	}

	protected static final IAssignProtection PROTECT_CONST = new IAssignProtection() {
		public IProblemIdentifier problemId() {
			return JavaScriptProblems.REASSIGNMENT_OF_CONSTANT;
		}

		public String problemMessage() {
			return ValidationMessages.ReassignmentOfConstant;
		}
	};

	@Override
	public IValueReference visitConstDeclaration(ConstStatement node) {
		final IValueCollection context = peekContext();
		for (VariableDeclaration declaration : node.getVariables()) {
			final IValueReference reference = context.getChild(declaration
					.getVariableName());
			assert reference.exists();
			initializeVariable(reference, declaration);
		}
		return null;
	}

	protected IValueReference createVariable(IValueCollection context,
			VariableDeclaration declaration) {
		final Identifier identifier = declaration.getIdentifier();
		final String varName = identifier.getName();
		final IValueReference reference = context.createChild(varName);
		final JSVariable variable = new JSVariable(
				declaration.getVariableName());
		for (IModelBuilder extension : this.context.getModelBuilders()) {
			extension.processVariable(declaration, variable, reporter,
					getTypeChecker());
		}
		if (reporter != null) {
			final ISuppressWarningsState state = reporter.getSuppressWarnings();
			if (state != null) {
				variable.addSuppressedWarning(state.asCategory());
			}
		}
		if (listeners != null) {
			for (ITypeInferenceListener listener : listeners) {
				listener.variableParsed(variable);
			}
		}
		reference.setAttribute(IReferenceAttributes.VARIABLE, variable);

		reference.setKind(inFunction() ? ReferenceKind.LOCAL
				: ReferenceKind.GLOBAL);
		reference.setLocation(ReferenceLocation.create(getSource(),
				declaration.sourceStart(), declaration.sourceEnd(),
				identifier.sourceStart(), identifier.sourceEnd()));

		if (variable.getTypeDef() instanceof RecordType) {
			RecordType type = (RecordType) variable.getTypeDef();
			type.setTypeName(varName);
			this.context.registerRecordType(type);
		}
		return reference;
	}

	protected void initializeVariable(final IValueReference reference,
			VariableDeclaration declaration) {
		if (declaration.getInitializer() != null) {
			final IValueReference assignment;
			reference
					.setAttribute(IReferenceAttributes.RESOLVING, Boolean.TRUE);
			try {
				assignment = visit(declaration.getInitializer());
			} finally {
				reference.setAttribute(IReferenceAttributes.RESOLVING, null);
			}
			if (assignment != null) {
				final IRVariable variable = (IRVariable) reference
						.getAttribute(IReferenceAttributes.R_VARIABLE);
				if (variable != null && variable.getType() != null) {
					// if declared type specified then just add it as a value on
					// top of what we already have. So that we don't clear the
					// current one.
					reference.addValue(assignment, false);
				} else {
					// assign only if no declared type specified
					assign(reference, assignment);
				}
				if (assignment.getKind() == ReferenceKind.FUNCTION
						&& reference.getAttribute(IReferenceAttributes.METHOD) != null)
					reference.setKind(ReferenceKind.FUNCTION);
			}
		}
	}

	@Override
	public IValueReference visitContinueStatement(ContinueStatement node) {
		return null;
	}

	@Override
	public IValueReference visitDecimalLiteral(DecimalLiteral node) {
		return ConstantValue.of(RTypes.NUMBER);
	}

	@Override
	public IValueReference visitDefaultXmlNamespace(
			DefaultXmlNamespaceStatement node) {
		visit(node.getValue());
		return null;
	}

	@Override
	public IValueReference visitDoWhileStatement(DoWhileStatement node) {
		visit(node.getCondition());
		visit(node.getBody());
		return null;
	}

	@Override
	public IValueReference visitEmptyExpression(EmptyExpression node) {
		return null;
	}

	@Override
	public IValueReference visitEmptyStatement(EmptyStatement node) {
		return null;
	}

	@Override
	public IValueReference visitForEachInStatement(ForEachInStatement node) {
		IValueReference itemReference = visit(node.getItem());
		IValueReference iteratorReference = visit(node.getIterator());
		Set<IRType> typeSet = JavaScriptValidations.getTypes(iteratorReference);
		if (!typeSet.isEmpty()) {
			IRType type = null;
			// try to get the best type, just take the first one, and if the the
			// latter just have Any or None types skip those.
			for (IRType irType : typeSet) {
				if (type == null) {
					type = irType;
				} else if (irType instanceof IRArrayType) {
					IRType itemType = ((IRArrayType) irType).getItemType();
					if (itemType != RTypes.none() && itemType != RTypes.any()) {
						type = irType;
					}
				} else if (irType instanceof IRMapType) {
					IRType itemType = ((IRMapType) irType).getValueType();
					if (itemType != RTypes.none() && itemType != RTypes.any()) {
						type = irType;
					}
				}
			}

			if (type instanceof IRArrayType
					&& JavaScriptValidations.typeOf(itemReference) == null) {
				final IRType itemType = ((IRArrayType) type).getItemType();
				setIRType(itemReference, itemType, true);
			} else if (type instanceof IRMapType
					&& JavaScriptValidations.typeOf(itemReference) == null) {
				final IRType itemType = ((IRMapType) type).getValueType();
				setIRType(itemReference, itemType, true);
			} else if (ITypeNames.XMLLIST.equals(type.getName())) {
				itemReference.setDeclaredType(E4XTypes.XML);
			}
		}
		visit(node.getBody());
		return null;
	}

	@Override
	public IValueReference visitForInStatement(ForInStatement node) {
		final IValueReference item = visit(node.getItem());
		if (item != null) {
			assign(item, ConstantValue.of(RTypes.STRING));
		}
		visit(node.getIterator());
		visit(node.getBody());
		return null;
	}

	@Override
	public IValueReference visitForStatement(ForStatement node) {
		if (node.getInitial() != null)
			visit(node.getInitial());
		if (node.getCondition() != null)
			visit(node.getCondition());
		if (node.getStep() != null)
			visit(node.getStep());
		if (node.getBody() != null)
			visit(node.getBody());
		return null;
	}

	private void initializeFunction(JSMethod method, IValueReference function) {
		function.setLocation(method.getLocation());
		function.setKind(ReferenceKind.FUNCTION);
		function.setDeclaredType(RTypes.FUNCTION);
		function.setAttribute(IReferenceAttributes.METHOD, method);
		function.setAttribute(IReferenceAttributes.RESOLVING, Boolean.TRUE);
	}

	@Override
	public IValueReference visitFunctionStatement(FunctionStatement node) {
		final JSMethod method;
		final IValueReference result;
		final ForwardDeclaration forward = forwardDeclarations.remove(node);
		if (forward != null) {
			method = forward.method;
			result = forward.reference;
		} else {
			assert !node.isDeclaration();
			method = createMethod(node);
			result = new AnonymousValue();
			initializeFunction(method, result);
			result.setAttribute(IReferenceAttributes.R_METHOD,
					RModelBuilder.create(getContext(), method));
		}
		final ThisValue thisValue = new ThisValue();
		if (method.getThisType() != null) {
			thisValue.setDeclaredType(this.context.contextualize(method
					.getThisType()));
		} else if (method.getExtendsType() != null) {
			IRType thisType = this.context.contextualize(method
					.getExtendsType());
			thisValue.setDeclaredType(thisType);
			if (thisType instanceof IRLocalType) {
				IValueReference prototype = result
						.createChild(IRLocalType.PROTOTYPE_PROPERTY);
				prototype.setDeclaredType(context.getType(ITypeNames.OBJECT)
						.toRType(context));
				Set<String> directChildren = ((IRLocalType) thisType)
						.getDirectChildren();
				for (String child : directChildren) {
					IValueReference protoChild = prototype.createChild(child);
					IValueReference localChild = ((IRLocalType) thisType)
							.getDirectChild(child);
					protoChild.setKind(localChild.getKind());
					protoChild.setLocation(localChild.getLocation());
					if (localChild.getDeclaredType() != null) {
						protoChild
								.setDeclaredType(localChild.getDeclaredType());
					} else if (localChild.getKind() == ReferenceKind.FUNCTION) {
						protoChild.setDeclaredType(context
								.getType(ITypeNames.FUNCTION).toRType(context));
					}
					JSTypeSet types = localChild.getTypes();
					protoChild.getTypes().addAll(types);

				}
			}

		} else {
			// if this is a "this.property" assignment then take over the this
			// of the parent.
			if (node.getParent() instanceof BinaryOperation) {
				BinaryOperation bo = (BinaryOperation) node.getParent();
				if (bo.getLeftExpression() instanceof PropertyExpression
						&& ((PropertyExpression) bo.getLeftExpression())
								.getObject() instanceof ThisExpression) {
					IValueCollection context = peekContext();
					if (context instanceof IFunctionValueCollection) {
						String name = ((IFunctionValueCollection) context)
								.getFunctionName();
						thisValue.setDeclaredType(RTypes.localType(name,
								context.getParent().getChild(name)));
					}
				}
			}
		}
		final IValueCollection function = new FunctionValueCollection(
				peekContext(), method.getName(), thisValue,
				node.isInlineBlock());

		for (IParameter parameter : method.getParameters()) {
			final IValueReference refArg = function.createChild(parameter
					.getName());
			refArg.setKind(ReferenceKind.ARGUMENT);
			setTypeImpl(refArg, parameter.getType());
			refArg.setLocation(parameter.getLocation());
		}
		result.setAttribute(IReferenceAttributes.FUNCTION_SCOPE, function);
		enterContext(function);
		Set<IProblemIdentifier> suppressed = null;
		try {
			if (reporter != null && !method.getSuppressedWarnings().isEmpty()) {
				suppressed = new HashSet<IProblemIdentifier>();
				for (IProblemCategory category : method.getSuppressedWarnings()) {
					suppressed.addAll(category.contents());
				}
				reporter.pushSuppressWarnings(suppressed);
			}
			visitFunctionBody(node);
		} finally {
			if (reporter != null && suppressed != null) {
				reporter.popSuppressWarnings();
			}
			leaveContext();
			result.setAttribute(IReferenceAttributes.RESOLVING, null);
		}
		final IValueReference returnValue = result
				.getChild(IValueReference.FUNCTION_OP);
		returnValue.addValue(function.getReturnValue(), true);
		setTypeImpl(returnValue, method.getType());
		return result;
	}

	/**
	 * Creates "declaration" model for the specified function AST node. Is
	 * called once before processing this function.
	 * 
	 * @param node
	 * @return
	 */
	protected JSMethod createMethod(FunctionStatement node) {
		final JSMethod method = new JSMethod(node, getSource());
		for (IModelBuilder extension : context.getModelBuilders()) {
			extension.processMethod(node, method, reporter, getTypeChecker());
		}
		if (node.isInlineBlock() && method.getParameterCount() > 0) {
			final IParameter last = method.getParameters().get(
					method.getParameterCount() - 1);
			if (last.getType() == null
					&& last.getKind() == ParameterKind.NORMAL
					&& ITypeNames.UNDEFINED.equals(last.getName())) {
				last.setKind(ParameterKind.OPTIONAL);
			}
		}
		if (listeners != null) {
			for (ITypeInferenceListener listener : listeners) {
				listener.methodParsed(method);
			}
		}
		return method;
	}

	public void visitFunctionBody(FunctionStatement node) {
		boolean visitBody = visitFunctionBody;
		if (!visitBody && node.getDocumentation() != null
				&& node.getDocumentation().getText() != null) {
			visitBody = node.getDocumentation().getText()
					.contains("@constructor")
					|| node.getDocumentation().getText().contains("@parse");
		}
		if (visitBody) {
			handleDeclarations(node);
			visit(node.getBody());
		}
	}

	public void setType(IValueReference value, JSType type, boolean lazyEnabled) {
		setTypeImpl(value, type, lazyEnabled);
	}

	private void setTypeImpl(IValueReference value, JSType type) {
		setTypeImpl(value, type, true);
	}

	private void setTypeImpl(IValueReference value, JSType type,
			boolean lazyEnabled) {
		if (type == null) {
			return;
		}
		final IRType rt = context.contextualize(type);
		setIRType(value, rt, lazyEnabled);
	}

	/**
	 * @param value
	 * @param rt
	 * @param lazyEnabled
	 */
	private void setIRType(IValueReference value, final IRType rt,
			boolean lazyEnabled) {
		if (rt instanceof IRSimpleType) {
			final Type t = ((IRSimpleType) rt).getTarget();
			if (t.getKind() != TypeKind.UNKNOWN) {
				if (value instanceof IValueProvider) {
					((IValueProvider) value).getValue()
							.addReference(new LazyEvaluatorValue(context, t));
				}
				value.setDeclaredType(rt);
			} else if (lazyEnabled) {
				value.addValue(new LazyTypeReference(context, t.getName(),
						peekContext()), false);
			}
		} else {
			value.setDeclaredType(rt);
		}
	}

	@Override
	public IValueReference visitGetAllChildrenExpression(
			GetAllChildrenExpression node) {
		return new XMLListValue(peekContext());
	}

	@Override
	public IValueReference visitGetArrayItemExpression(
			GetArrayItemExpression node) {
		final IValueReference array = visit(node.getArray());
		visit(node.getIndex());
		if (array != null) {
			// always just create the ARRAY_OP child (for code completion)
			IValueReference child = array.getChild(IValueReference.ARRAY_OP);
			IRType arrayType = null;
			if (array.getDeclaredType() != null) {
				arrayType = TypeUtil.extractArrayItemType(array
						.getDeclaredType());
			} else {
				JSTypeSet types = array.getTypes();
				if (types.size() > 0)
					arrayType = TypeUtil.extractArrayItemType(types.toRType());
			}
			if (arrayType != null && child.getDeclaredType() == null) {
				setIRType(child, arrayType, true);
			}
			if (node.getIndex() instanceof StringLiteral) {
				IValueReference namedChild = extractNamedChild(array,
						node.getIndex());
				if (namedChild.exists()) {
					child = namedChild;
					if (arrayType != null && child.getDeclaredType() == null) {
						child.setDeclaredType(arrayType);
					}
				}
			}
			return child;
		}
		return null;
	}

	@Override
	public IValueReference visitGetLocalNameExpression(
			GetLocalNameExpression node) {
		return null;
	}

	@Override
	public IValueReference visitIdentifier(Identifier node) {
		return peekContext().getChild(node.getName());

	}

	private Boolean evaluateCondition(Expression condition) {
		if (condition instanceof BooleanLiteral) {
			return Boolean.valueOf(((BooleanLiteral) condition).getText());
		} else {
			return null;
		}
	}

	@Override
	public IValueReference visitIfStatement(IfStatement node) {
		visit(node.getCondition());
		visitIfStatements(node);
		return null;
	}

	protected void visitIfStatements(IfStatement node) {
		final List<Statement> statements = new ArrayList<Statement>(2);
		Statement onlyBranch = null;
		final Boolean condition = evaluateCondition(node.getCondition());
		if ((condition == null || condition.booleanValue())
				&& node.getThenStatement() != null) {
			statements.add(node.getThenStatement());
			if (condition != null && condition.booleanValue()) {
				onlyBranch = node.getThenStatement();
			}
		}
		if ((condition == null || !condition.booleanValue())
				&& node.getElseStatement() != null) {
			statements.add(node.getElseStatement());
			if (condition != null && !condition.booleanValue()) {
				onlyBranch = node.getElseStatement();
			}
		}
		if (!statements.isEmpty()) {
			if (statements.size() == 1) {
				if (statements.get(0) == onlyBranch) {
					visit(statements.get(0));
				} else {
					final Branching branching = branching();
					visit(statements.get(0));
					branching.end();
				}
			} else {
				final Branching branching = branching();
				final List<NestedValueCollection> collections = new ArrayList<NestedValueCollection>(
						statements.size());
				for (Statement statement : statements) {
					final NestedValueCollection nestedCollection = new NestedValueCollection(
							peekContext());
					enterContext(nestedCollection);
					visit(statement);
					leaveContext();
					collections.add(nestedCollection);
				}
				NestedValueCollection.mergeTo(peekContext(), collections);
				branching.end();
			}
		}
	}

	@Override
	public IValueReference visitLabelledStatement(LabelledStatement node) {
		if (node.getStatement() != null)
			visit(node.getStatement());
		return null;
	}

	protected static class AnonymousNewValue extends AnonymousValue {
		@Override
		public IValueReference getChild(String name) {
			if (name.equals(IValueReference.FUNCTION_OP))
				return this;
			return super.getChild(name);
		}

		@Override
		public void setValue(IValueReference value) {
			if (value instanceof ThisValue) {
				// make sure a copy is created so that the this values of
				// various instances are not shared over those instances.
				IValue val = createValue();
				if (val != null)
					val.addValue(((ThisValue) value).getValue());
			} else {
				super.setValue(value);
			}
		}
	}

	public static class VisitNewResult {
		IValueReference typeValue;
		IValueReference[] arguments;
		IValueReference value;

		public IValueReference getValue() {
			return value;
		}

		public IValueReference getTypeValue() {
			return typeValue;
		}

		public IValueReference[] getArguments() {
			return arguments;
		}
	}

	protected VisitNewResult visitNew(NewExpression node) {
		final VisitNewResult result = new VisitNewResult();
		Expression objectClass = node.getObjectClass();
		if (objectClass instanceof CallExpression) {
			final CallExpression call = (CallExpression) objectClass;
			result.arguments = new IValueReference[call.getArguments().size()];
			int index = 0;
			for (ASTNode argument : call.getArguments()) {
				result.arguments[index++] = visit(argument);
			}
			objectClass = call.getExpression();
		} else {
			result.arguments = new IValueReference[0];
		}
		result.typeValue = visit(objectClass);

		if (result.typeValue != null) {
			if (result.typeValue.getKind() == ReferenceKind.FUNCTION) {
				Object fs = result.typeValue
						.getAttribute(IReferenceAttributes.FUNCTION_SCOPE);
				if (fs instanceof IValueCollection
						&& ((IValueCollection) fs).getThis() != null) {
					result.value = new AnonymousNewValue();
					result.value.setValue(((IValueCollection) fs).getThis());
					result.value.setKind(ReferenceKind.TYPE);
					String className = PropertyExpressionUtils
							.getPath(objectClass);
					IRMethod method = (IRMethod) result.typeValue
							.getAttribute(IReferenceAttributes.R_METHOD);
					if (method != null) {
						// if a method is found, then check if that
						// method name 'MyObject' is in the
						// classname 'xxx.yyy.MyObject' then use the full
						// classname else use the methodname
						// (new myVar() when var myVar = MyObject)
						String methodName = method.getName();
						if (className == null
								|| !className.endsWith(methodName)) {
							className = methodName;
						}
					}
					if (className != null && !className.equals("<anonymous>")) {
						result.value.setDeclaredType(RTypes.localType(
								className, result.typeValue));
					} else {
						result.value.setDeclaredType(RTypes.OBJECT);
					}
				}
			} else if (result.typeValue.exists()) {
				for (IRType type : result.typeValue.getDeclaredTypes()) {
					if (type instanceof IRClassType) {
						result.value = new AnonymousNewValue();
						result.value.setKind(ReferenceKind.TYPE);
						result.value.setDeclaredType(((IRClassType) type)
								.newItemType());
						return result;
					}
				}
				for (IRType type : result.typeValue.getTypes()) {
					if (type instanceof IRClassType) {
						result.value = new AnonymousNewValue();
						result.value.setKind(ReferenceKind.TYPE);
						result.value.setDeclaredType(((IRClassType) type)
								.newItemType());
						return result;
					}
				}
			}
		}
		if (result.value == null) {
			final String className = PropertyExpressionUtils
					.getPath(objectClass);
			IValueCollection contextValueCollection = peekContext();
			if (className != null) {
				Type knownType = context.getKnownType(className, TypeMode.CODE);
				if (knownType != null) {
					result.value = new AnonymousNewValue();
					result.value.setValue(new ConstantValue(RTypes.simple(
							context, knownType)));
					result.value.setKind(ReferenceKind.TYPE);
				} else {
					result.value = new LazyTypeReference(context, className,
							contextValueCollection);
				}
			} else {
				result.value = new AnonymousNewValue();
				result.value.setValue(ConstantValue.of(RTypes.OBJECT));
			}
		}
		return result;
	}

	@Override
	public IValueReference visitNewExpression(NewExpression node) {
		return visitNew(node).getValue();
	}

	@Override
	public IValueReference visitNullExpression(NullExpression node) {
		return null;
	}

	@Override
	public IValueReference visitObjectInitializer(ObjectInitializer node) {
		final List<IRRecordMember> members = new ArrayList<IRRecordMember>(node
				.getInitializers().size());
		for (ObjectInitializerPart part : node.getInitializers()) {
			if (part instanceof PropertyInitializer) {
				final PropertyInitializer pi = (PropertyInitializer) part;
				final String childName = PropertyExpressionUtils.nameOf(pi
						.getName());
				if (childName == null) { // just in case
					visit(pi.getValue());
					continue;
				}
				final JSDocTags tags = parseTags(pi.getName()
						.getDocumentation());

				final IValueReference value = visit(pi.getValue());
				if (value != null) {
					final IRMethod method = (IRMethod) value
							.getAttribute(IReferenceAttributes.R_METHOD);
					if (method != null
							&& (pi.getValue() instanceof FunctionStatement || tags
									.get(JSDocTag.TYPE) == null)) {
						if (method.getSource() instanceof IMethod) {
							final IMethod m = (IMethod) method.getSource();
							final ReferenceLocation loc = m.getLocation();
							m.setLocation(ReferenceLocation.create(getSource(),
									loc.getDeclarationStart(), loc
											.getDeclarationEnd(), pi.getName()
											.sourceStart(), pi.getName()
											.sourceEnd()));
						}
						IRType returnType = method.getType();
						if (returnType == null) {
							returnType = JavaScriptValidations.typeOf(value
									.getChild(IValueReference.FUNCTION_OP));
						}
						members.add(new RRecordMember(childName, RTypes
								.functionType(context, method.getParameters(),
										returnType), method.getSource()));
						continue;
					}
				}
				final JSVariable source;
				if (!(pi.getValue() instanceof FunctionStatement)) {
					source = new JSVariable();
					source.setName(childName);
					source.setLocation(ReferenceLocation.create(getSource(), pi
							.getName().sourceStart(), pi.getName().sourceEnd()));
					if (!tags.isEmpty()) {
						final JSDocSupport jsdocSupport = getDocSupport();
						if (jsdocSupport != null) {
							jsdocSupport.parseType(source, tags,
									JSDocSupport.TYPE_TAGS, reporter,
									getTypeChecker());
							jsdocSupport.parseDeprecation(source, tags,
									reporter);
							jsdocSupport.parseAccessModifiers(source, tags,
									reporter);
						}
					}
				} else {
					source = null;
				}
				final IRType type;
				if (source != null && source.getType() != null) {
					type = RTypes.create(context, source.getType());
					// TODO (alex) validate evaluated type?
				} else {
					type = JavaScriptValidations.typeOf(value);
				}
				members.add(new RRecordMember(childName, type != null ? type
						: RTypes.any(), source));
			} else {
				// TODO handle get/set methods
			}
		}
		return ConstantValue.of(RTypes.recordType(members));
	}

	private JSDocTags parseTags(final Comment documentation) {
		return documentation != null ? JSDocSupport.parse(documentation)
				: JSDocTags.EMPTY;
	}

	private JSDocSupport getDocSupport() {
		for (IModelBuilder modelBuilder : this.context.getModelBuilders()) {
			if (modelBuilder instanceof JSDocSupport) {
				return (JSDocSupport) modelBuilder;
			}
		}
		return null;
	}

	@Override
	public IValueReference visitParenthesizedExpression(
			ParenthesizedExpression node) {
		return visit(node.getExpression());
	}

	@Override
	public IValueReference visitPropertyExpression(PropertyExpression node) {
		final IValueReference object = visit(node.getObject());
		return extractNamedChild(object, node.getProperty());
	}

	protected IValueReference extractNamedChild(IValueReference parent,
			Expression name) {
		if (parent != null) {
			final String nameStr;
			if (name instanceof Identifier) {
				nameStr = ((Identifier) name).getName();
				IRType parentType = JavaScriptValidations.typeOf(parent);
				if (parentType != null && isXML(parentType)) {
					IValueReference child = parent.getChild(nameStr);
					if (child != null && child.getDeclaredType() == null) {
						child.setDeclaredType(E4XTypes.XML);
						return child;
					}
				}
			} else if (name instanceof StringLiteral) {
				nameStr = ((StringLiteral) name).getValue();
			} else if (name instanceof XmlAttributeIdentifier) {
				if (((XmlAttributeIdentifier) name).getExpression() instanceof AsteriskExpression) {
					return visitAsteriskExpression((AsteriskExpression) ((XmlAttributeIdentifier) name)
							.getExpression());
				} else {
					nameStr = ((XmlAttributeIdentifier) name)
							.getAttributeName();
					if (nameStr == null) {
						// TODO (alex) .@[expression] syntax
						return null;
					}
					IValueReference child = parent.getChild(nameStr);
					if (child != null && child.getDeclaredType() == null) {
						child.setDeclaredType(E4XTypes.XML);
						return child;
					}
				}
			} else if (name instanceof AsteriskExpression) {
				return visitAsteriskExpression((AsteriskExpression) name);
			} else if (name instanceof ParenthesizedExpression) {
				visitParenthesizedExpression((ParenthesizedExpression) name);
				return parent;
			} else {
				return null;
			}
			return parent.getChild(nameStr);
		}
		return null;
	}

	@Override
	public IValueReference visitRegExpLiteral(RegExpLiteral node) {
		return new ConstantValue(RTypes.REGEXP);
	}

	@Override
	public IValueReference visitReturnStatement(ReturnStatement node) {
		if (node.getValue() != null) {
			final IValueReference value = visit(node.getValue());
			if (value != null) {
				final IValueReference returnValue = peekContext()
						.getReturnValue();
				if (returnValue != null) {
					returnValue.addValue(value,
							!(value instanceof LazyTypeReference));
				}
			}
			return value;
		}
		return null;
	}

	@Override
	public IValueReference visitScript(Script node) {
		handleDeclarations(node);
		return visit(node.getStatements());
	}

	private void handleDeclarations(JSScope scope) {
		ArrayList<IValueReference> variables = new ArrayList<IValueReference>();
		ArrayList<ForwardDeclaration> forwardDecls = new ArrayList<ForwardDeclaration>();
		final IValueCollection context = peekContext();
		for (JSDeclaration declaration : scope.getDeclarations()) {
			if (declaration instanceof FunctionStatement) {
				final FunctionStatement funcNode = (FunctionStatement) declaration;
				assert funcNode.isDeclaration();
				final JSMethod method = createMethod(funcNode);
				final IValueReference function = context.createChild(method
						.getName());
				initializeFunction(method, function);
				ForwardDeclaration fd = new ForwardDeclaration(method, function);
				forwardDecls.add(fd);
				forwardDeclarations.put(funcNode, fd);
			} else if (declaration instanceof VariableDeclaration) {
				final VariableDeclaration varDeclaration = (VariableDeclaration) declaration;
				final IValueReference var = createVariable(context,
						varDeclaration);
				if (varDeclaration.getParent() instanceof ConstStatement) {
					var.setAttribute(IAssignProtection.ATTRIBUTE, PROTECT_CONST);
				}
				variables.add(var);
			}
		}
		for (ForwardDeclaration decl : forwardDecls) {
			decl.reference.setAttribute(IReferenceAttributes.R_METHOD,
					RModelBuilder.create(getContext(), decl.method));
			if (decl.method.isConstructor()) {
				String name = decl.method.getName();

				if (scope instanceof FunctionStatement) {
					JSNode parent = (FunctionStatement) scope;
					while (parent != null) {
						if (parent instanceof FunctionStatement) {
							FunctionStatement fs = (FunctionStatement) parent;
							if (fs.getName() != null) {
								name = fs.getName().getName() + '.' + name;
							} else {
								parent = fs.getParent();
								if (parent instanceof BinaryOperation) {
									Expression leftExpression = ((BinaryOperation) parent)
											.getLeftExpression();
									if (leftExpression instanceof PropertyExpression
											&& ((PropertyExpression) leftExpression)
													.getObject() instanceof ThisExpression
											&& ((PropertyExpression) leftExpression)
													.getProperty() instanceof Identifier) {
										name = ((Identifier) ((PropertyExpression) leftExpression)
												.getProperty()).getName()
												+ '.'
												+ name;
									}
								}
							}
						}
						parent = parent.getParent();
					}
				}
				// this will create a local type
				this.context.getType(name);
			}
		}

		for (IValueReference reference : variables) {
			final IVariable var = (IVariable) reference
					.getAttribute(IReferenceAttributes.VARIABLE);
			if (var == null) {
				// attribute was lost or new value was not created as
				// something predefined was already there.
				continue;
			}
			final IRVariable rvar = RModelBuilder.create(getContext(), var);
			reference.setAttribute(IReferenceAttributes.R_VARIABLE, rvar);
			if (rvar.getType() != null) {
				setIRType(reference, rvar.getType(), true);
				// typed - make sure it wasn't initialized with the phantom
				// value.
				reference.removeReference(PhantomValueReference.REFERENCE);
			}

		}

	}

	@Override
	public IValueReference visitStatementBlock(StatementBlock node) {
		for (Statement statement : node.getStatements()) {
			visit(statement);
		}
		return null;
	}

	@Override
	public IValueReference visitStringLiteral(StringLiteral node) {
		return ConstantValue.of(RTypes.STRING);
	}

	@Override
	public IValueReference visitSwitchStatement(SwitchStatement node) {
		if (node.getCondition() != null)
			visit(node.getCondition());
		for (SwitchComponent component : node.getCaseClauses()) {
			if (component instanceof CaseClause) {
				visit(((CaseClause) component).getCondition());
			}
			visit(component.getStatements());
		}
		return null;
	}

	@Override
	public IValueReference visitThisExpression(ThisExpression node) {
		return peekContext().getThis();
	}

	@Override
	public IValueReference visitThrowStatement(ThrowStatement node) {
		if (node.getException() != null)
			visit(node.getException());
		return null;
	}

	@Override
	public IValueReference visitTryStatement(TryStatement node) {
		visit(node.getBody());
		for (CatchClause catchClause : node.getCatches()) {
			final NestedValueCollection collection = new NestedValueCollection(
					peekContext());
			final Identifier id = catchClause.getException();
			final IValueReference var = collection.createChild(id.getName());
			final JSDocTags tags = parseTags(id.getDocumentation());
			final JSElement variable = new JSElement(id.getName());
			getDocSupport().parseType(variable, tags, JSDocSupport.TYPE_TAGS,
					reporter, getTypeChecker());
			var.setDeclaredType(variable.getType() != null ? context
					.contextualize(variable.getType()) : RTypes.ERROR);

			enterContext(collection);
			if (catchClause.getFilterExpression() != null) {
				visit(catchClause.getFilterExpression());
			}
			if (catchClause.getStatement() != null) {
				visit(catchClause.getStatement());
			}
			leaveContext();
		}
		if (node.getFinally() != null) {
			visit(node.getFinally().getStatement());
		}
		return null;
	}

	@Override
	public IValueReference visitUnaryOperation(UnaryOperation node) {
		if (node.isNotOperator()) {
			visit(node.getExpression());
			return ConstantValue.of(RTypes.BOOLEAN);
		} else if (node.isDelete()) {
			final IValueReference value = visit(node.getExpression());
			if (value != null) {
				value.delete(false);
			}
			return ConstantValue.of(RTypes.BOOLEAN);
		} else if (node.isTypeOf()) {
			visit(node.getExpression());
			return ConstantValue.of(RTypes.STRING);
		} else if (node.isVoid()) {
			visit(node.getExpression());
			return null;
		} else {
			return visit(node.getExpression());
		}
	}

	@Override
	public IValueReference visitVariableStatement(VariableStatement node) {
		final IValueCollection collection = peekContext();
		IValueReference result = null;
		for (VariableDeclaration declaration : node.getVariables()) {
			result = collection.getChild(declaration.getVariableName());
			assert result.exists();
			initializeVariable(result, declaration);
		}
		return result;
	}

	@Override
	public IValueReference visitVoidExpression(VoidExpression node) {
		visit(node.getExpression());
		return null;
	}

	@Override
	public IValueReference visitWhileStatement(WhileStatement node) {
		if (node.getCondition() != null)
			visit(node.getCondition());
		if (node.getBody() != null)
			visit(node.getBody());
		return null;
	}

	@Override
	public IValueReference visitWithStatement(WithStatement node) {
		final IValueReference with = visit(node.getExpression());
		if (with != null) {
			final WithValueCollection withCollection = new WithValueCollection(
					peekContext(), with);
			enterContext(withCollection);
			visit(node.getStatement());
			leaveContext();
		} else {
			visit(node.getStatement());
		}
		return null;
	}

	private static final DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
			.newInstance();
	private DocumentBuilder docBuilder;

	/**
	 * @return
	 * @throws ParserConfigurationException
	 */
	private DocumentBuilder getDocumentBuilder()
			throws ParserConfigurationException {
		if (docBuilder == null)
			docBuilder = docBuilderFactory.newDocumentBuilder();
		return docBuilder;
	}

	@Override
	public IValueReference visitXmlLiteral(XmlLiteral node) {
		IValueReference xmlValueReference = new ConstantValue(E4XTypes.XML);

		if (xmlValueReference instanceof IValueProvider) {
			IValue xmlValue = ((IValueProvider) xmlValueReference).getValue();
			List<XmlFragment> fragments = node.getFragments();
			StringBuilder xml = new StringBuilder();
			for (XmlFragment xmlFragment : fragments) {
				if (xmlFragment instanceof XmlTextFragment) {
					String xmlText = ((XmlTextFragment) xmlFragment).getXml();
					if (xmlText.equals("<></>"))
						continue;
					if (xmlText.startsWith("<>") && xmlText.endsWith("</>")) {
						xmlText = "<xml>"
								+ xmlText.substring(2, xmlText.length() - 3)
								+ "</xml>";
					}
					xml.append(xmlText);
				} else if (xmlFragment instanceof XmlExpressionFragment) {
					Expression expression = ((XmlExpressionFragment) xmlFragment)
							.getExpression();
					visit(expression);
					if (xml.charAt(xml.length() - 1) == '<'
							|| xml.subSequence(xml.length() - 2, xml.length())
									.equals("</")) {
						if (expression instanceof Identifier) {
							xml.append(((Identifier) expression).getName());
						} else {
							xml.setLength(0);
							break;
						}
					} else
						xml.append("\"\" ");
				}
			}

			if (xml.length() > 0) {
				try {
					DocumentBuilder docBuilder = getDocumentBuilder();
					Document doc = docBuilder.parse(new InputSource(
							new StringReader(xml.toString())));
					NodeList nl = doc.getChildNodes();
					if (nl.getLength() == 1) {
						Node item = nl.item(0);
						NamedNodeMap attributes = item.getAttributes();
						for (int a = 0; a < attributes.getLength(); a++) {
							Node attribute = attributes.item(a);
							xmlValue.createChild("@" + attribute.getNodeName(),
									0);
						}
						createXmlChilds(xmlValue, item.getChildNodes());
					} else {
						System.err.println("root should be 1 child?? " + xml);
					}
				} catch (Exception e) {
				}
			}
		}
		return xmlValueReference;
	}

	/**
	 * @param xmlType
	 * @param xmlValue
	 * @param nl
	 */
	private void createXmlChilds(IValue xmlValue, NodeList nl) {
		for (int i = 0; i < nl.getLength(); i++) {
			Node item = nl.item(i);
			if (item.getNodeType() == Node.TEXT_NODE) {
				String value = item.getNodeValue();
				if (value == null || "".equals(value.trim())) {
					continue;
				}
			}
			IValue nodeValue = xmlValue.createChild(item.getNodeName(), 0);
			nodeValue.setDeclaredType(E4XTypes.XML);
			NamedNodeMap attributes = item.getAttributes();
			if (attributes != null) {
				for (int a = 0; a < attributes.getLength(); a++) {
					Node attribute = attributes.item(a);
					nodeValue.createChild("@" + attribute.getNodeName(), 0);
				}
			}
			createXmlChilds(nodeValue, item.getChildNodes());
		}
	}

	@Override
	public IValueReference visitXmlPropertyIdentifier(
			XmlAttributeIdentifier node) {
		return new ConstantValue(E4XTypes.XML);
	}

	@Override
	public IValueReference visitYieldOperator(YieldOperator node) {
		final IValueReference value = visit(node.getExpression());
		if (value != null) {
			final IValueReference reference = peekContext().getReturnValue();
			if (reference != null) {
				reference.addValue(value, true);
			}
		}
		return null;
	}

	public static boolean isFunctionDeclaration(Expression expression) {
		PropertyExpression pe = null;
		if (expression instanceof PropertyExpression)
			pe = (PropertyExpression) expression;
		else if (expression.getParent() instanceof PropertyExpression)
			pe = (PropertyExpression) expression.getParent();
		if (pe != null && pe.getObject() instanceof ThisExpression
				&& pe.getParent() instanceof BinaryOperation) {
			return ((BinaryOperation) pe.getParent()).getRightExpression() instanceof FunctionStatement;
		}
		return false;
	}

	@Override
	public IValueReference visitArrowFunction(ArrowFunctionStatement node) {
		// TODO Auto-generated method stub
		return null;
	}

}
