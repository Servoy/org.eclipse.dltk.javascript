/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomFactoryImpl.java,v 1.4 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomFactoryImpl extends EFactoryImpl implements DomFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DomFactory init() {
		try {
			DomFactory theDomFactory = (DomFactory)EPackage.Registry.INSTANCE.getEFactory(DomPackage.eNS_URI);
			if (theDomFactory != null) {
				return theDomFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DomFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DomPackage.COMMENT: return createComment();
			case DomPackage.IDENTIFIER: return createIdentifier();
			case DomPackage.VARIABLE_REFERENCE: return createVariableReference();
			case DomPackage.LABEL: return createLabel();
			case DomPackage.NULL_LITERAL: return createNullLiteral();
			case DomPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			case DomPackage.NUMERIC_LITERAL: return createNumericLiteral();
			case DomPackage.STRING_LITERAL: return createStringLiteral();
			case DomPackage.REGULAR_EXPRESSION_LITERAL: return createRegularExpressionLiteral();
			case DomPackage.THIS_EXPRESSION: return createThisExpression();
			case DomPackage.ARRAY_LITERAL: return createArrayLiteral();
			case DomPackage.ELISION: return createElision();
			case DomPackage.OBJECT_LITERAL: return createObjectLiteral();
			case DomPackage.SIMPLE_PROPERTY_ASSIGNMENT: return createSimplePropertyAssignment();
			case DomPackage.GETTER_ASSIGNMENT: return createGetterAssignment();
			case DomPackage.SETTER_ASSIGNMENT: return createSetterAssignment();
			case DomPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
			case DomPackage.ARRAY_ACCESS_EXPRESSION: return createArrayAccessExpression();
			case DomPackage.PROPERTY_ACCESS_EXPRESSION: return createPropertyAccessExpression();
			case DomPackage.NEW_EXPRESSION: return createNewExpression();
			case DomPackage.CALL_EXPRESSION: return createCallExpression();
			case DomPackage.UNARY_EXPRESSION: return createUnaryExpression();
			case DomPackage.BINARY_EXPRESSION: return createBinaryExpression();
			case DomPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
			case DomPackage.BLOCK_STATEMENT: return createBlockStatement();
			case DomPackage.VARIABLE_STATEMENT: return createVariableStatement();
			case DomPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case DomPackage.EMPTY_STATEMENT: return createEmptyStatement();
			case DomPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
			case DomPackage.IF_STATEMENT: return createIfStatement();
			case DomPackage.DO_STATEMENT: return createDoStatement();
			case DomPackage.WHILE_STATEMENT: return createWhileStatement();
			case DomPackage.FOR_STATEMENT: return createForStatement();
			case DomPackage.FOR_IN_STATEMENT: return createForInStatement();
			case DomPackage.CONTINUE_STATEMENT: return createContinueStatement();
			case DomPackage.BREAK_STATEMENT: return createBreakStatement();
			case DomPackage.RETURN_STATEMENT: return createReturnStatement();
			case DomPackage.WITH_STATEMENT: return createWithStatement();
			case DomPackage.SWITCH_STATEMENT: return createSwitchStatement();
			case DomPackage.CASE_CLAUSE: return createCaseClause();
			case DomPackage.DEFAULT_CLAUSE: return createDefaultClause();
			case DomPackage.LABELED_STATEMENT: return createLabeledStatement();
			case DomPackage.THROW_STATEMENT: return createThrowStatement();
			case DomPackage.TRY_STATEMENT: return createTryStatement();
			case DomPackage.CATCH_CLAUSE: return createCatchClause();
			case DomPackage.FINALLY_CLAUSE: return createFinallyClause();
			case DomPackage.FUNCTION_EXPRESSION: return createFunctionExpression();
			case DomPackage.PARAMETER: return createParameter();
			case DomPackage.SOURCE: return createSource();
			case DomPackage.CONST_STATEMENT: return createConstStatement();
			case DomPackage.XML_INITIALIZER: return createXmlInitializer();
			case DomPackage.ATTRIBUTE_IDENTIFIER: return createAttributeIdentifier();
			case DomPackage.QUALIFIED_IDENTIFIER: return createQualifiedIdentifier();
			case DomPackage.WILDCARD_IDENTIFIER: return createWildcardIdentifier();
			case DomPackage.EXPRESSION_SELECTOR: return createExpressionSelector();
			case DomPackage.XML_TEXT_FRAGMENT: return createXmlTextFragment();
			case DomPackage.XML_EXPRESSION_FRAGMENT: return createXmlExpressionFragment();
			case DomPackage.DESCENDANT_ACCESS_EXPRESSION: return createDescendantAccessExpression();
			case DomPackage.FILTER_EXPRESSION: return createFilterExpression();
			case DomPackage.DEFAULT_XML_NAMESPACE_STATEMENT: return createDefaultXmlNamespaceStatement();
			case DomPackage.FOR_EACH_IN_STATEMENT: return createForEachInStatement();
			case DomPackage.ARROW_FUNCTION: return createArrowFunction();
			case DomPackage.TEMPLATE_STRING_LITERAL: return createTemplateStringLiteral();
			case DomPackage.TEMPLATE_STRING_EXPRESSION: return createTemplateStringExpression();
			case DomPackage.TAG_FUNCTION: return createTagFunction();
			case DomPackage.FOR_OF_STATEMENT: return createForOfStatement();
			case DomPackage.LET_STATEMENT: return createLetStatement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DomPackage.UNARY_OPERATOR:
				return createUnaryOperatorFromString(eDataType, initialValue);
			case DomPackage.BINARY_OPERATOR:
				return createBinaryOperatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DomPackage.UNARY_OPERATOR:
				return convertUnaryOperatorToString(eDataType, instanceValue);
			case DomPackage.BINARY_OPERATOR:
				return convertBinaryOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Identifier createIdentifier() {
		IdentifierImpl identifier = new IdentifierImpl();
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableReference createVariableReference() {
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Label createLabel() {
		LabelImpl label = new LabelImpl();
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NullLiteral createNullLiteral() {
		NullLiteralImpl nullLiteral = new NullLiteralImpl();
		return nullLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericLiteral createNumericLiteral() {
		NumericLiteralImpl numericLiteral = new NumericLiteralImpl();
		return numericLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RegularExpressionLiteral createRegularExpressionLiteral() {
		RegularExpressionLiteralImpl regularExpressionLiteral = new RegularExpressionLiteralImpl();
		return regularExpressionLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThisExpression createThisExpression() {
		ThisExpressionImpl thisExpression = new ThisExpressionImpl();
		return thisExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArrayLiteral createArrayLiteral() {
		ArrayLiteralImpl arrayLiteral = new ArrayLiteralImpl();
		return arrayLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Elision createElision() {
		ElisionImpl elision = new ElisionImpl();
		return elision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectLiteral createObjectLiteral() {
		ObjectLiteralImpl objectLiteral = new ObjectLiteralImpl();
		return objectLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimplePropertyAssignment createSimplePropertyAssignment() {
		SimplePropertyAssignmentImpl simplePropertyAssignment = new SimplePropertyAssignmentImpl();
		return simplePropertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GetterAssignment createGetterAssignment() {
		GetterAssignmentImpl getterAssignment = new GetterAssignmentImpl();
		return getterAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SetterAssignment createSetterAssignment() {
		SetterAssignmentImpl setterAssignment = new SetterAssignmentImpl();
		return setterAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParenthesizedExpression createParenthesizedExpression() {
		ParenthesizedExpressionImpl parenthesizedExpression = new ParenthesizedExpressionImpl();
		return parenthesizedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArrayAccessExpression createArrayAccessExpression() {
		ArrayAccessExpressionImpl arrayAccessExpression = new ArrayAccessExpressionImpl();
		return arrayAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyAccessExpression createPropertyAccessExpression() {
		PropertyAccessExpressionImpl propertyAccessExpression = new PropertyAccessExpressionImpl();
		return propertyAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NewExpression createNewExpression() {
		NewExpressionImpl newExpression = new NewExpressionImpl();
		return newExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CallExpression createCallExpression() {
		CallExpressionImpl callExpression = new CallExpressionImpl();
		return callExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnaryExpression createUnaryExpression() {
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BinaryExpression createBinaryExpression() {
		BinaryExpressionImpl binaryExpression = new BinaryExpressionImpl();
		return binaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConditionalExpression createConditionalExpression() {
		ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
		return conditionalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockStatement createBlockStatement() {
		BlockStatementImpl blockStatement = new BlockStatementImpl();
		return blockStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableStatement createVariableStatement() {
		VariableStatementImpl variableStatement = new VariableStatementImpl();
		return variableStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EmptyStatement createEmptyStatement() {
		EmptyStatementImpl emptyStatement = new EmptyStatementImpl();
		return emptyStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpressionStatement createExpressionStatement() {
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoStatement createDoStatement() {
		DoStatementImpl doStatement = new DoStatementImpl();
		return doStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WhileStatement createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForInStatement createForInStatement() {
		ForInStatementImpl forInStatement = new ForInStatementImpl();
		return forInStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContinueStatement createContinueStatement() {
		ContinueStatementImpl continueStatement = new ContinueStatementImpl();
		return continueStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BreakStatement createBreakStatement() {
		BreakStatementImpl breakStatement = new BreakStatementImpl();
		return breakStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReturnStatement createReturnStatement() {
		ReturnStatementImpl returnStatement = new ReturnStatementImpl();
		return returnStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WithStatement createWithStatement() {
		WithStatementImpl withStatement = new WithStatementImpl();
		return withStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwitchStatement createSwitchStatement() {
		SwitchStatementImpl switchStatement = new SwitchStatementImpl();
		return switchStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CaseClause createCaseClause() {
		CaseClauseImpl caseClause = new CaseClauseImpl();
		return caseClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefaultClause createDefaultClause() {
		DefaultClauseImpl defaultClause = new DefaultClauseImpl();
		return defaultClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LabeledStatement createLabeledStatement() {
		LabeledStatementImpl labeledStatement = new LabeledStatementImpl();
		return labeledStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThrowStatement createThrowStatement() {
		ThrowStatementImpl throwStatement = new ThrowStatementImpl();
		return throwStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TryStatement createTryStatement() {
		TryStatementImpl tryStatement = new TryStatementImpl();
		return tryStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CatchClause createCatchClause() {
		CatchClauseImpl catchClause = new CatchClauseImpl();
		return catchClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FinallyClause createFinallyClause() {
		FinallyClauseImpl finallyClause = new FinallyClauseImpl();
		return finallyClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionExpression createFunctionExpression() {
		FunctionExpressionImpl functionExpression = new FunctionExpressionImpl();
		return functionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Source createSource() {
		SourceImpl source = new SourceImpl();
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstStatement createConstStatement() {
		ConstStatementImpl constStatement = new ConstStatementImpl();
		return constStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XmlInitializer createXmlInitializer() {
		XmlInitializerImpl xmlInitializer = new XmlInitializerImpl();
		return xmlInitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeIdentifier createAttributeIdentifier() {
		AttributeIdentifierImpl attributeIdentifier = new AttributeIdentifierImpl();
		return attributeIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QualifiedIdentifier createQualifiedIdentifier() {
		QualifiedIdentifierImpl qualifiedIdentifier = new QualifiedIdentifierImpl();
		return qualifiedIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WildcardIdentifier createWildcardIdentifier() {
		WildcardIdentifierImpl wildcardIdentifier = new WildcardIdentifierImpl();
		return wildcardIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpressionSelector createExpressionSelector() {
		ExpressionSelectorImpl expressionSelector = new ExpressionSelectorImpl();
		return expressionSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XmlTextFragment createXmlTextFragment() {
		XmlTextFragmentImpl xmlTextFragment = new XmlTextFragmentImpl();
		return xmlTextFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XmlExpressionFragment createXmlExpressionFragment() {
		XmlExpressionFragmentImpl xmlExpressionFragment = new XmlExpressionFragmentImpl();
		return xmlExpressionFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescendantAccessExpression createDescendantAccessExpression() {
		DescendantAccessExpressionImpl descendantAccessExpression = new DescendantAccessExpressionImpl();
		return descendantAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FilterExpression createFilterExpression() {
		FilterExpressionImpl filterExpression = new FilterExpressionImpl();
		return filterExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefaultXmlNamespaceStatement createDefaultXmlNamespaceStatement() {
		DefaultXmlNamespaceStatementImpl defaultXmlNamespaceStatement = new DefaultXmlNamespaceStatementImpl();
		return defaultXmlNamespaceStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForEachInStatement createForEachInStatement() {
		ForEachInStatementImpl forEachInStatement = new ForEachInStatementImpl();
		return forEachInStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArrowFunction createArrowFunction() {
		ArrowFunctionImpl arrowFunction = new ArrowFunctionImpl();
		return arrowFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryOperator result = UnaryOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryOperator createBinaryOperatorFromString(EDataType eDataType, String initialValue) {
		BinaryOperator result = BinaryOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomPackage getDomPackage() {
		return (DomPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DomPackage getPackage() {
		return DomPackage.eINSTANCE;
	}

	@Override
	public TemplateStringLiteral createTemplateStringLiteral() {
		TemplateStringLiteralImpl literal = new TemplateStringLiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateStringExpression createTemplateStringExpression() {
		TemplateStringExpressionImpl templateStringExpression = new TemplateStringExpressionImpl();
		return templateStringExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TagFunction createTagFunction() {
		TagFunctionImpl tagFunction = new TagFunctionImpl();
		return tagFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForOfStatement createForOfStatement() {
		ForOfStatementImpl forOfStatement = new ForOfStatementImpl();
		return forOfStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LetStatement createLetStatement() {
		LetStatementImpl letStatement = new LetStatementImpl();
		return letStatement;
	}

} //DomFactoryImpl
