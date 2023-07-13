/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomAdapterFactory.java,v 1.4 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.util;

import org.eclipse.dltk.javascript.core.dom.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage
 * @generated
 */
public class DomAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DomPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DomPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomSwitch<Adapter> modelSwitch =
		new DomSwitch<Adapter>() {
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseComment(Comment object) {
				return createCommentAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseVariableReference(VariableReference object) {
				return createVariableReferenceAdapter();
			}
			@Override
			public Adapter caseLabel(Label object) {
				return createLabelAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseNullLiteral(NullLiteral object) {
				return createNullLiteralAdapter();
			}
			@Override
			public Adapter caseBooleanLiteral(BooleanLiteral object) {
				return createBooleanLiteralAdapter();
			}
			@Override
			public Adapter caseNumericLiteral(NumericLiteral object) {
				return createNumericLiteralAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseRegularExpressionLiteral(RegularExpressionLiteral object) {
				return createRegularExpressionLiteralAdapter();
			}
			@Override
			public Adapter caseThisExpression(ThisExpression object) {
				return createThisExpressionAdapter();
			}
			@Override
			public Adapter caseArrayLiteral(ArrayLiteral object) {
				return createArrayLiteralAdapter();
			}
			@Override
			public Adapter caseIArrayElement(IArrayElement object) {
				return createIArrayElementAdapter();
			}
			@Override
			public Adapter caseElision(Elision object) {
				return createElisionAdapter();
			}
			@Override
			public Adapter caseObjectLiteral(ObjectLiteral object) {
				return createObjectLiteralAdapter();
			}
			@Override
			public Adapter casePropertyAssignment(PropertyAssignment object) {
				return createPropertyAssignmentAdapter();
			}
			@Override
			public Adapter caseIPropertyName(IPropertyName object) {
				return createIPropertyNameAdapter();
			}
			@Override
			public Adapter caseSimplePropertyAssignment(SimplePropertyAssignment object) {
				return createSimplePropertyAssignmentAdapter();
			}
			@Override
			public Adapter caseAccessorAssignment(AccessorAssignment object) {
				return createAccessorAssignmentAdapter();
			}
			@Override
			public Adapter caseGetterAssignment(GetterAssignment object) {
				return createGetterAssignmentAdapter();
			}
			@Override
			public Adapter caseSetterAssignment(SetterAssignment object) {
				return createSetterAssignmentAdapter();
			}
			@Override
			public Adapter caseParenthesizedExpression(ParenthesizedExpression object) {
				return createParenthesizedExpressionAdapter();
			}
			@Override
			public Adapter caseArrayAccessExpression(ArrayAccessExpression object) {
				return createArrayAccessExpressionAdapter();
			}
			@Override
			public Adapter casePropertyAccessExpression(PropertyAccessExpression object) {
				return createPropertyAccessExpressionAdapter();
			}
			@Override
			public Adapter caseNewExpression(NewExpression object) {
				return createNewExpressionAdapter();
			}
			@Override
			public Adapter caseCallExpression(CallExpression object) {
				return createCallExpressionAdapter();
			}
			@Override
			public Adapter caseUnaryExpression(UnaryExpression object) {
				return createUnaryExpressionAdapter();
			}
			@Override
			public Adapter caseBinaryExpression(BinaryExpression object) {
				return createBinaryExpressionAdapter();
			}
			@Override
			public Adapter caseConditionalExpression(ConditionalExpression object) {
				return createConditionalExpressionAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter caseBlockStatement(BlockStatement object) {
				return createBlockStatementAdapter();
			}
			@Override
			public Adapter caseVariableStatement(VariableStatement object) {
				return createVariableStatementAdapter();
			}
			@Override
			public Adapter caseVariableDeclaration(VariableDeclaration object) {
				return createVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseEmptyStatement(EmptyStatement object) {
				return createEmptyStatementAdapter();
			}
			@Override
			public Adapter caseExpressionStatement(ExpressionStatement object) {
				return createExpressionStatementAdapter();
			}
			@Override
			public Adapter caseIfStatement(IfStatement object) {
				return createIfStatementAdapter();
			}
			@Override
			public Adapter caseIterationStatement(IterationStatement object) {
				return createIterationStatementAdapter();
			}
			@Override
			public Adapter caseDoStatement(DoStatement object) {
				return createDoStatementAdapter();
			}
			@Override
			public Adapter caseWhileStatement(WhileStatement object) {
				return createWhileStatementAdapter();
			}
			@Override
			public Adapter caseForStatement(ForStatement object) {
				return createForStatementAdapter();
			}
			@Override
			public Adapter caseIForInitializer(IForInitializer object) {
				return createIForInitializerAdapter();
			}
			@Override
			public Adapter caseForInStatement(ForInStatement object) {
				return createForInStatementAdapter();
			}
			@Override
			public Adapter caseContinueStatement(ContinueStatement object) {
				return createContinueStatementAdapter();
			}
			@Override
			public Adapter caseBreakStatement(BreakStatement object) {
				return createBreakStatementAdapter();
			}
			@Override
			public Adapter caseReturnStatement(ReturnStatement object) {
				return createReturnStatementAdapter();
			}
			@Override
			public Adapter caseWithStatement(WithStatement object) {
				return createWithStatementAdapter();
			}
			@Override
			public Adapter caseSwitchStatement(SwitchStatement object) {
				return createSwitchStatementAdapter();
			}
			@Override
			public Adapter caseSwitchElement(SwitchElement object) {
				return createSwitchElementAdapter();
			}
			@Override
			public Adapter caseCaseClause(CaseClause object) {
				return createCaseClauseAdapter();
			}
			@Override
			public Adapter caseDefaultClause(DefaultClause object) {
				return createDefaultClauseAdapter();
			}
			@Override
			public Adapter caseLabeledStatement(LabeledStatement object) {
				return createLabeledStatementAdapter();
			}
			@Override
			public Adapter caseThrowStatement(ThrowStatement object) {
				return createThrowStatementAdapter();
			}
			@Override
			public Adapter caseTryStatement(TryStatement object) {
				return createTryStatementAdapter();
			}
			@Override
			public Adapter caseCatchClause(CatchClause object) {
				return createCatchClauseAdapter();
			}
			@Override
			public Adapter caseFinallyClause(FinallyClause object) {
				return createFinallyClauseAdapter();
			}
			@Override
			public Adapter caseFunctionExpression(FunctionExpression object) {
				return createFunctionExpressionAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseSource(Source object) {
				return createSourceAdapter();
			}
			@Override
			public Adapter caseConstStatement(ConstStatement object) {
				return createConstStatementAdapter();
			}
			@Override
			public Adapter casePropertyIdentifier(PropertyIdentifier object) {
				return createPropertyIdentifierAdapter();
			}
			@Override
			public Adapter caseIProperty(IProperty object) {
				return createIPropertyAdapter();
			}
			@Override
			public Adapter caseXmlInitializer(XmlInitializer object) {
				return createXmlInitializerAdapter();
			}
			@Override
			public Adapter caseAttributeIdentifier(AttributeIdentifier object) {
				return createAttributeIdentifierAdapter();
			}
			@Override
			public Adapter caseISelector(ISelector object) {
				return createISelectorAdapter();
			}
			@Override
			public Adapter caseQualifiedIdentifier(QualifiedIdentifier object) {
				return createQualifiedIdentifierAdapter();
			}
			@Override
			public Adapter caseIUnqualifiedSelector(IUnqualifiedSelector object) {
				return createIUnqualifiedSelectorAdapter();
			}
			@Override
			public Adapter caseWildcardIdentifier(WildcardIdentifier object) {
				return createWildcardIdentifierAdapter();
			}
			@Override
			public Adapter caseIPropertySelector(IPropertySelector object) {
				return createIPropertySelectorAdapter();
			}
			@Override
			public Adapter caseExpressionSelector(ExpressionSelector object) {
				return createExpressionSelectorAdapter();
			}
			@Override
			public Adapter caseXmlFragment(XmlFragment object) {
				return createXmlFragmentAdapter();
			}
			@Override
			public Adapter caseXmlTextFragment(XmlTextFragment object) {
				return createXmlTextFragmentAdapter();
			}
			@Override
			public Adapter caseXmlExpressionFragment(XmlExpressionFragment object) {
				return createXmlExpressionFragmentAdapter();
			}
			@Override
			public Adapter caseDescendantAccessExpression(DescendantAccessExpression object) {
				return createDescendantAccessExpressionAdapter();
			}
			@Override
			public Adapter caseFilterExpression(FilterExpression object) {
				return createFilterExpressionAdapter();
			}
			@Override
			public Adapter caseDefaultXmlNamespaceStatement(DefaultXmlNamespaceStatement object) {
				return createDefaultXmlNamespaceStatementAdapter();
			}
			@Override
			public Adapter caseForEachInStatement(ForEachInStatement object) {
				return createForEachInStatementAdapter();
			}
			@Override
			public Adapter caseArrowFunction(ArrowFunction object) {
				return createArrowFunctionAdapter();
			}
			@Override
			public Adapter caseTemplateStringLiteral(TemplateStringLiteral object) {
				return createTemplateStringLiteralAdapter();
			}
			@Override
			public Adapter caseTemplateStringExpression(TemplateStringExpression object) {
				return createTemplateStringExpressionAdapter();
			}
			@Override
			public Adapter caseTagFunction(TagFunction object) {
				return createTagFunctionAdapter();
			}
			@Override
			public Adapter caseForOfStatement(ForOfStatement object) {
				return createForOfStatementAdapter();
			}
			@Override
			public Adapter caseLetStatement(LetStatement object) {
				return createLetStatementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.Comment
	 * @generated
	 */
	public Adapter createCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableReference
	 * @generated
	 */
	public Adapter createVariableReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.Label
	 * @generated
	 */
	public Adapter createLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.NullLiteral <em>Null Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.NullLiteral
	 * @generated
	 */
	public Adapter createNullLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.BooleanLiteral
	 * @generated
	 */
	public Adapter createBooleanLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.NumericLiteral <em>Numeric Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.NumericLiteral
	 * @generated
	 */
	public Adapter createNumericLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.RegularExpressionLiteral <em>Regular Expression Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.RegularExpressionLiteral
	 * @generated
	 */
	public Adapter createRegularExpressionLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ThisExpression <em>This Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ThisExpression
	 * @generated
	 */
	public Adapter createThisExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ArrayLiteral <em>Array Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrayLiteral
	 * @generated
	 */
	public Adapter createArrayLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.IArrayElement <em>IArray Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.IArrayElement
	 * @generated
	 */
	public Adapter createIArrayElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.Elision <em>Elision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.Elision
	 * @generated
	 */
	public Adapter createElisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ObjectLiteral <em>Object Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ObjectLiteral
	 * @generated
	 */
	public Adapter createObjectLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.PropertyAssignment <em>Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.PropertyAssignment
	 * @generated
	 */
	public Adapter createPropertyAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.IPropertyName <em>IProperty Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.IPropertyName
	 * @generated
	 */
	public Adapter createIPropertyNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.SimplePropertyAssignment <em>Simple Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.SimplePropertyAssignment
	 * @generated
	 */
	public Adapter createSimplePropertyAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.AccessorAssignment <em>Accessor Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.AccessorAssignment
	 * @generated
	 */
	public Adapter createAccessorAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.GetterAssignment <em>Getter Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.GetterAssignment
	 * @generated
	 */
	public Adapter createGetterAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.SetterAssignment <em>Setter Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.SetterAssignment
	 * @generated
	 */
	public Adapter createSetterAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ParenthesizedExpression
	 * @generated
	 */
	public Adapter createParenthesizedExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression <em>Array Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression
	 * @generated
	 */
	public Adapter createArrayAccessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.PropertyAccessExpression <em>Property Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.PropertyAccessExpression
	 * @generated
	 */
	public Adapter createPropertyAccessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.NewExpression <em>New Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.NewExpression
	 * @generated
	 */
	public Adapter createNewExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.CallExpression <em>Call Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.CallExpression
	 * @generated
	 */
	public Adapter createCallExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.UnaryExpression
	 * @generated
	 */
	public Adapter createUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryExpression
	 * @generated
	 */
	public Adapter createBinaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression <em>Conditional Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ConditionalExpression
	 * @generated
	 */
	public Adapter createConditionalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.BlockStatement <em>Block Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.BlockStatement
	 * @generated
	 */
	public Adapter createBlockStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.VariableStatement <em>Variable Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableStatement
	 * @generated
	 */
	public Adapter createVariableStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.EmptyStatement <em>Empty Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.EmptyStatement
	 * @generated
	 */
	public Adapter createEmptyStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ExpressionStatement <em>Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ExpressionStatement
	 * @generated
	 */
	public Adapter createExpressionStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.IfStatement
	 * @generated
	 */
	public Adapter createIfStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.IterationStatement <em>Iteration Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.IterationStatement
	 * @generated
	 */
	public Adapter createIterationStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.DoStatement <em>Do Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.DoStatement
	 * @generated
	 */
	public Adapter createDoStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.WhileStatement
	 * @generated
	 */
	public Adapter createWhileStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ForStatement
	 * @generated
	 */
	public Adapter createForStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.IForInitializer <em>IFor Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.IForInitializer
	 * @generated
	 */
	public Adapter createIForInitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ForInStatement <em>For In Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ForInStatement
	 * @generated
	 */
	public Adapter createForInStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ContinueStatement <em>Continue Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ContinueStatement
	 * @generated
	 */
	public Adapter createContinueStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.BreakStatement <em>Break Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.BreakStatement
	 * @generated
	 */
	public Adapter createBreakStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ReturnStatement <em>Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ReturnStatement
	 * @generated
	 */
	public Adapter createReturnStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.WithStatement <em>With Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.WithStatement
	 * @generated
	 */
	public Adapter createWithStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.SwitchStatement
	 * @generated
	 */
	public Adapter createSwitchStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.SwitchElement <em>Switch Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.SwitchElement
	 * @generated
	 */
	public Adapter createSwitchElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.CaseClause <em>Case Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.CaseClause
	 * @generated
	 */
	public Adapter createCaseClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.DefaultClause <em>Default Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.DefaultClause
	 * @generated
	 */
	public Adapter createDefaultClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.LabeledStatement <em>Labeled Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.LabeledStatement
	 * @generated
	 */
	public Adapter createLabeledStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ThrowStatement <em>Throw Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ThrowStatement
	 * @generated
	 */
	public Adapter createThrowStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.TryStatement <em>Try Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.TryStatement
	 * @generated
	 */
	public Adapter createTryStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.CatchClause <em>Catch Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.CatchClause
	 * @generated
	 */
	public Adapter createCatchClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.FinallyClause <em>Finally Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.FinallyClause
	 * @generated
	 */
	public Adapter createFinallyClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression <em>Function Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.FunctionExpression
	 * @generated
	 */
	public Adapter createFunctionExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.Source <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.Source
	 * @generated
	 */
	public Adapter createSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ConstStatement <em>Const Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ConstStatement
	 * @generated
	 */
	public Adapter createConstStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.PropertyIdentifier <em>Property Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.PropertyIdentifier
	 * @generated
	 */
	public Adapter createPropertyIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.IProperty <em>IProperty</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.IProperty
	 * @generated
	 */
	public Adapter createIPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.XmlInitializer <em>Xml Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlInitializer
	 * @generated
	 */
	public Adapter createXmlInitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.AttributeIdentifier <em>Attribute Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.AttributeIdentifier
	 * @generated
	 */
	public Adapter createAttributeIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ISelector <em>ISelector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ISelector
	 * @generated
	 */
	public Adapter createISelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier <em>Qualified Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier
	 * @generated
	 */
	public Adapter createQualifiedIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector <em>IUnqualified Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector
	 * @generated
	 */
	public Adapter createIUnqualifiedSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.WildcardIdentifier <em>Wildcard Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.WildcardIdentifier
	 * @generated
	 */
	public Adapter createWildcardIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.IPropertySelector <em>IProperty Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.IPropertySelector
	 * @generated
	 */
	public Adapter createIPropertySelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ExpressionSelector <em>Expression Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ExpressionSelector
	 * @generated
	 */
	public Adapter createExpressionSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.XmlFragment <em>Xml Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlFragment
	 * @generated
	 */
	public Adapter createXmlFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.XmlTextFragment <em>Xml Text Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlTextFragment
	 * @generated
	 */
	public Adapter createXmlTextFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.XmlExpressionFragment <em>Xml Expression Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlExpressionFragment
	 * @generated
	 */
	public Adapter createXmlExpressionFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.DescendantAccessExpression <em>Descendant Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.DescendantAccessExpression
	 * @generated
	 */
	public Adapter createDescendantAccessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.FilterExpression <em>Filter Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.FilterExpression
	 * @generated
	 */
	public Adapter createFilterExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.DefaultXmlNamespaceStatement <em>Default Xml Namespace Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.DefaultXmlNamespaceStatement
	 * @generated
	 */
	public Adapter createDefaultXmlNamespaceStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ForEachInStatement <em>For Each In Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ForEachInStatement
	 * @generated
	 */
	public Adapter createForEachInStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction <em>Arrow Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrowFunction
	 * @generated
	 */
	public Adapter createArrowFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral <em>Template String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral
	 * @generated
	 */
	public Adapter createTemplateStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.TemplateStringExpression <em>Template String Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.TemplateStringExpression
	 * @generated
	 */
	public Adapter createTemplateStringExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.TagFunction <em>Tag Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.TagFunction
	 * @generated
	 */
	public Adapter createTagFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.ForOfStatement <em>For Of Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.ForOfStatement
	 * @generated
	 */
	public Adapter createForOfStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.dltk.javascript.core.dom.LetStatement <em>Let Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.dltk.javascript.core.dom.LetStatement
	 * @generated
	 */
	public Adapter createLetStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DomAdapterFactory
