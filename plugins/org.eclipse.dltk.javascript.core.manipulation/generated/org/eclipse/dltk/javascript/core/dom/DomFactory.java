/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomFactory.java,v 1.4 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage
 * @generated
 */
public interface DomFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomFactory eINSTANCE = org.eclipse.dltk.javascript.core.dom.impl.DomFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
	Comment createComment();

	/**
	 * Returns a new object of class '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier</em>'.
	 * @generated
	 */
	Identifier createIdentifier();

	/**
	 * Returns a new object of class '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Reference</em>'.
	 * @generated
	 */
	VariableReference createVariableReference();

	/**
	 * Returns a new object of class '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Label</em>'.
	 * @generated
	 */
	Label createLabel();

	/**
	 * Returns a new object of class '<em>Null Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Literal</em>'.
	 * @generated
	 */
	NullLiteral createNullLiteral();

	/**
	 * Returns a new object of class '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal</em>'.
	 * @generated
	 */
	BooleanLiteral createBooleanLiteral();

	/**
	 * Returns a new object of class '<em>Numeric Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Literal</em>'.
	 * @generated
	 */
	NumericLiteral createNumericLiteral();

	/**
	 * Returns a new object of class '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal</em>'.
	 * @generated
	 */
	StringLiteral createStringLiteral();

	/**
	 * Returns a new object of class '<em>Regular Expression Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Regular Expression Literal</em>'.
	 * @generated
	 */
	RegularExpressionLiteral createRegularExpressionLiteral();

	/**
	 * Returns a new object of class '<em>This Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>This Expression</em>'.
	 * @generated
	 */
	ThisExpression createThisExpression();

	/**
	 * Returns a new object of class '<em>Array Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Literal</em>'.
	 * @generated
	 */
	ArrayLiteral createArrayLiteral();

	/**
	 * Returns a new object of class '<em>Elision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Elision</em>'.
	 * @generated
	 */
	Elision createElision();

	/**
	 * Returns a new object of class '<em>Object Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Literal</em>'.
	 * @generated
	 */
	ObjectLiteral createObjectLiteral();

	/**
	 * Returns a new object of class '<em>Simple Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Property Assignment</em>'.
	 * @generated
	 */
	SimplePropertyAssignment createSimplePropertyAssignment();

	/**
	 * Returns a new object of class '<em>Getter Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Getter Assignment</em>'.
	 * @generated
	 */
	GetterAssignment createGetterAssignment();

	/**
	 * Returns a new object of class '<em>Setter Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Setter Assignment</em>'.
	 * @generated
	 */
	SetterAssignment createSetterAssignment();

	/**
	 * Returns a new object of class '<em>Parenthesized Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parenthesized Expression</em>'.
	 * @generated
	 */
	ParenthesizedExpression createParenthesizedExpression();

	/**
	 * Returns a new object of class '<em>Array Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Access Expression</em>'.
	 * @generated
	 */
	ArrayAccessExpression createArrayAccessExpression();

	/**
	 * Returns a new object of class '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Access Expression</em>'.
	 * @generated
	 */
	PropertyAccessExpression createPropertyAccessExpression();

	/**
	 * Returns a new object of class '<em>New Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Expression</em>'.
	 * @generated
	 */
	NewExpression createNewExpression();

	/**
	 * Returns a new object of class '<em>Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Expression</em>'.
	 * @generated
	 */
	CallExpression createCallExpression();

	/**
	 * Returns a new object of class '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression</em>'.
	 * @generated
	 */
	UnaryExpression createUnaryExpression();

	/**
	 * Returns a new object of class '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Expression</em>'.
	 * @generated
	 */
	BinaryExpression createBinaryExpression();

	/**
	 * Returns a new object of class '<em>Conditional Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Expression</em>'.
	 * @generated
	 */
	ConditionalExpression createConditionalExpression();

	/**
	 * Returns a new object of class '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Statement</em>'.
	 * @generated
	 */
	BlockStatement createBlockStatement();

	/**
	 * Returns a new object of class '<em>Variable Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Statement</em>'.
	 * @generated
	 */
	VariableStatement createVariableStatement();

	/**
	 * Returns a new object of class '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration</em>'.
	 * @generated
	 */
	VariableDeclaration createVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Empty Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Empty Statement</em>'.
	 * @generated
	 */
	EmptyStatement createEmptyStatement();

	/**
	 * Returns a new object of class '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Statement</em>'.
	 * @generated
	 */
	ExpressionStatement createExpressionStatement();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

	/**
	 * Returns a new object of class '<em>Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Do Statement</em>'.
	 * @generated
	 */
	DoStatement createDoStatement();

	/**
	 * Returns a new object of class '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Statement</em>'.
	 * @generated
	 */
	WhileStatement createWhileStatement();

	/**
	 * Returns a new object of class '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Statement</em>'.
	 * @generated
	 */
	ForStatement createForStatement();

	/**
	 * Returns a new object of class '<em>For In Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For In Statement</em>'.
	 * @generated
	 */
	ForInStatement createForInStatement();

	/**
	 * Returns a new object of class '<em>Continue Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continue Statement</em>'.
	 * @generated
	 */
	ContinueStatement createContinueStatement();

	/**
	 * Returns a new object of class '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Break Statement</em>'.
	 * @generated
	 */
	BreakStatement createBreakStatement();

	/**
	 * Returns a new object of class '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return Statement</em>'.
	 * @generated
	 */
	ReturnStatement createReturnStatement();

	/**
	 * Returns a new object of class '<em>With Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>With Statement</em>'.
	 * @generated
	 */
	WithStatement createWithStatement();

	/**
	 * Returns a new object of class '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Statement</em>'.
	 * @generated
	 */
	SwitchStatement createSwitchStatement();

	/**
	 * Returns a new object of class '<em>Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Case Clause</em>'.
	 * @generated
	 */
	CaseClause createCaseClause();

	/**
	 * Returns a new object of class '<em>Default Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Clause</em>'.
	 * @generated
	 */
	DefaultClause createDefaultClause();

	/**
	 * Returns a new object of class '<em>Labeled Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Labeled Statement</em>'.
	 * @generated
	 */
	LabeledStatement createLabeledStatement();

	/**
	 * Returns a new object of class '<em>Throw Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throw Statement</em>'.
	 * @generated
	 */
	ThrowStatement createThrowStatement();

	/**
	 * Returns a new object of class '<em>Try Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Try Statement</em>'.
	 * @generated
	 */
	TryStatement createTryStatement();

	/**
	 * Returns a new object of class '<em>Catch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catch Clause</em>'.
	 * @generated
	 */
	CatchClause createCatchClause();

	/**
	 * Returns a new object of class '<em>Finally Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Finally Clause</em>'.
	 * @generated
	 */
	FinallyClause createFinallyClause();

	/**
	 * Returns a new object of class '<em>Function Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Expression</em>'.
	 * @generated
	 */
	FunctionExpression createFunctionExpression();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source</em>'.
	 * @generated
	 */
	Source createSource();

	/**
	 * Returns a new object of class '<em>Const Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Const Statement</em>'.
	 * @generated
	 */
	ConstStatement createConstStatement();

	/**
	 * Returns a new object of class '<em>Xml Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xml Initializer</em>'.
	 * @generated
	 */
	XmlInitializer createXmlInitializer();

	/**
	 * Returns a new object of class '<em>Attribute Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Identifier</em>'.
	 * @generated
	 */
	AttributeIdentifier createAttributeIdentifier();

	/**
	 * Returns a new object of class '<em>Qualified Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Identifier</em>'.
	 * @generated
	 */
	QualifiedIdentifier createQualifiedIdentifier();

	/**
	 * Returns a new object of class '<em>Wildcard Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wildcard Identifier</em>'.
	 * @generated
	 */
	WildcardIdentifier createWildcardIdentifier();

	/**
	 * Returns a new object of class '<em>Expression Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Selector</em>'.
	 * @generated
	 */
	ExpressionSelector createExpressionSelector();

	/**
	 * Returns a new object of class '<em>Xml Text Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xml Text Fragment</em>'.
	 * @generated
	 */
	XmlTextFragment createXmlTextFragment();

	/**
	 * Returns a new object of class '<em>Xml Expression Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xml Expression Fragment</em>'.
	 * @generated
	 */
	XmlExpressionFragment createXmlExpressionFragment();

	/**
	 * Returns a new object of class '<em>Descendant Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descendant Access Expression</em>'.
	 * @generated
	 */
	DescendantAccessExpression createDescendantAccessExpression();

	/**
	 * Returns a new object of class '<em>Filter Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Expression</em>'.
	 * @generated
	 */
	FilterExpression createFilterExpression();

	/**
	 * Returns a new object of class '<em>Default Xml Namespace Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Xml Namespace Statement</em>'.
	 * @generated
	 */
	DefaultXmlNamespaceStatement createDefaultXmlNamespaceStatement();

	/**
	 * Returns a new object of class '<em>For Each In Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each In Statement</em>'.
	 * @generated
	 */
	ForEachInStatement createForEachInStatement();

	/**
	 * Returns a new object of class '<em>Arrow Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arrow Function</em>'.
	 * @generated
	 */
	ArrowFunction createArrowFunction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DomPackage getDomPackage();

	TemplateStringLiteral createTemplateStringLiteral();

	/**
	 * Returns a new object of class '<em>Template String Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template String Expression</em>'.
	 * @generated
	 */
	TemplateStringExpression createTemplateStringExpression();

	/**
	 * Returns a new object of class '<em>Tag Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag Function</em>'.
	 * @generated
	 */
	TagFunction createTagFunction();

} //DomFactory
