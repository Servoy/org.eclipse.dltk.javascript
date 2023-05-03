/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomSwitch.java,v 1.4 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.util;

import java.util.List;

import org.eclipse.dltk.javascript.core.dom.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage
 * @generated
 */
public class DomSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DomPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomSwitch() {
		if (modelPackage == null) {
			modelPackage = DomPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DomPackage.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.COMMENT: {
				Comment comment = (Comment)theEObject;
				T result = caseComment(comment);
				if (result == null) result = caseNode(comment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.IDENTIFIER: {
				Identifier identifier = (Identifier)theEObject;
				T result = caseIdentifier(identifier);
				if (result == null) result = caseIPropertyName(identifier);
				if (result == null) result = caseIPropertySelector(identifier);
				if (result == null) result = caseIProperty(identifier);
				if (result == null) result = caseIUnqualifiedSelector(identifier);
				if (result == null) result = caseISelector(identifier);
				if (result == null) result = caseNode(identifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.VARIABLE_REFERENCE: {
				VariableReference variableReference = (VariableReference)theEObject;
				T result = caseVariableReference(variableReference);
				if (result == null) result = caseExpression(variableReference);
				if (result == null) result = caseIArrayElement(variableReference);
				if (result == null) result = caseIForInitializer(variableReference);
				if (result == null) result = caseNode(variableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.LABEL: {
				Label label = (Label)theEObject;
				T result = caseLabel(label);
				if (result == null) result = caseNode(label);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseIArrayElement(expression);
				if (result == null) result = caseIForInitializer(expression);
				if (result == null) result = caseNode(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.NULL_LITERAL: {
				NullLiteral nullLiteral = (NullLiteral)theEObject;
				T result = caseNullLiteral(nullLiteral);
				if (result == null) result = caseExpression(nullLiteral);
				if (result == null) result = caseIArrayElement(nullLiteral);
				if (result == null) result = caseIForInitializer(nullLiteral);
				if (result == null) result = caseNode(nullLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.BOOLEAN_LITERAL: {
				BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
				T result = caseBooleanLiteral(booleanLiteral);
				if (result == null) result = caseExpression(booleanLiteral);
				if (result == null) result = caseIArrayElement(booleanLiteral);
				if (result == null) result = caseIForInitializer(booleanLiteral);
				if (result == null) result = caseNode(booleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.NUMERIC_LITERAL: {
				NumericLiteral numericLiteral = (NumericLiteral)theEObject;
				T result = caseNumericLiteral(numericLiteral);
				if (result == null) result = caseExpression(numericLiteral);
				if (result == null) result = caseIPropertyName(numericLiteral);
				if (result == null) result = caseIArrayElement(numericLiteral);
				if (result == null) result = caseIForInitializer(numericLiteral);
				if (result == null) result = caseNode(numericLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseExpression(stringLiteral);
				if (result == null) result = caseIPropertyName(stringLiteral);
				if (result == null) result = caseIArrayElement(stringLiteral);
				if (result == null) result = caseIForInitializer(stringLiteral);
				if (result == null) result = caseNode(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.REGULAR_EXPRESSION_LITERAL: {
				RegularExpressionLiteral regularExpressionLiteral = (RegularExpressionLiteral)theEObject;
				T result = caseRegularExpressionLiteral(regularExpressionLiteral);
				if (result == null) result = caseExpression(regularExpressionLiteral);
				if (result == null) result = caseIArrayElement(regularExpressionLiteral);
				if (result == null) result = caseIForInitializer(regularExpressionLiteral);
				if (result == null) result = caseNode(regularExpressionLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.THIS_EXPRESSION: {
				ThisExpression thisExpression = (ThisExpression)theEObject;
				T result = caseThisExpression(thisExpression);
				if (result == null) result = caseExpression(thisExpression);
				if (result == null) result = caseIArrayElement(thisExpression);
				if (result == null) result = caseIForInitializer(thisExpression);
				if (result == null) result = caseNode(thisExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.ARRAY_LITERAL: {
				ArrayLiteral arrayLiteral = (ArrayLiteral)theEObject;
				T result = caseArrayLiteral(arrayLiteral);
				if (result == null) result = caseExpression(arrayLiteral);
				if (result == null) result = caseIArrayElement(arrayLiteral);
				if (result == null) result = caseIForInitializer(arrayLiteral);
				if (result == null) result = caseNode(arrayLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.IARRAY_ELEMENT: {
				IArrayElement iArrayElement = (IArrayElement)theEObject;
				T result = caseIArrayElement(iArrayElement);
				if (result == null) result = caseNode(iArrayElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.ELISION: {
				Elision elision = (Elision)theEObject;
				T result = caseElision(elision);
				if (result == null) result = caseIArrayElement(elision);
				if (result == null) result = caseNode(elision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.OBJECT_LITERAL: {
				ObjectLiteral objectLiteral = (ObjectLiteral)theEObject;
				T result = caseObjectLiteral(objectLiteral);
				if (result == null) result = caseExpression(objectLiteral);
				if (result == null) result = caseIArrayElement(objectLiteral);
				if (result == null) result = caseIForInitializer(objectLiteral);
				if (result == null) result = caseNode(objectLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.PROPERTY_ASSIGNMENT: {
				PropertyAssignment propertyAssignment = (PropertyAssignment)theEObject;
				T result = casePropertyAssignment(propertyAssignment);
				if (result == null) result = caseNode(propertyAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.IPROPERTY_NAME: {
				IPropertyName iPropertyName = (IPropertyName)theEObject;
				T result = caseIPropertyName(iPropertyName);
				if (result == null) result = caseNode(iPropertyName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.SIMPLE_PROPERTY_ASSIGNMENT: {
				SimplePropertyAssignment simplePropertyAssignment = (SimplePropertyAssignment)theEObject;
				T result = caseSimplePropertyAssignment(simplePropertyAssignment);
				if (result == null) result = casePropertyAssignment(simplePropertyAssignment);
				if (result == null) result = caseNode(simplePropertyAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.ACCESSOR_ASSIGNMENT: {
				AccessorAssignment accessorAssignment = (AccessorAssignment)theEObject;
				T result = caseAccessorAssignment(accessorAssignment);
				if (result == null) result = casePropertyAssignment(accessorAssignment);
				if (result == null) result = caseNode(accessorAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.GETTER_ASSIGNMENT: {
				GetterAssignment getterAssignment = (GetterAssignment)theEObject;
				T result = caseGetterAssignment(getterAssignment);
				if (result == null) result = caseAccessorAssignment(getterAssignment);
				if (result == null) result = casePropertyAssignment(getterAssignment);
				if (result == null) result = caseNode(getterAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.SETTER_ASSIGNMENT: {
				SetterAssignment setterAssignment = (SetterAssignment)theEObject;
				T result = caseSetterAssignment(setterAssignment);
				if (result == null) result = caseAccessorAssignment(setterAssignment);
				if (result == null) result = casePropertyAssignment(setterAssignment);
				if (result == null) result = caseNode(setterAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.PARENTHESIZED_EXPRESSION: {
				ParenthesizedExpression parenthesizedExpression = (ParenthesizedExpression)theEObject;
				T result = caseParenthesizedExpression(parenthesizedExpression);
				if (result == null) result = caseExpression(parenthesizedExpression);
				if (result == null) result = caseIArrayElement(parenthesizedExpression);
				if (result == null) result = caseIForInitializer(parenthesizedExpression);
				if (result == null) result = caseNode(parenthesizedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.ARRAY_ACCESS_EXPRESSION: {
				ArrayAccessExpression arrayAccessExpression = (ArrayAccessExpression)theEObject;
				T result = caseArrayAccessExpression(arrayAccessExpression);
				if (result == null) result = caseExpression(arrayAccessExpression);
				if (result == null) result = caseIArrayElement(arrayAccessExpression);
				if (result == null) result = caseIForInitializer(arrayAccessExpression);
				if (result == null) result = caseNode(arrayAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.PROPERTY_ACCESS_EXPRESSION: {
				PropertyAccessExpression propertyAccessExpression = (PropertyAccessExpression)theEObject;
				T result = casePropertyAccessExpression(propertyAccessExpression);
				if (result == null) result = caseExpression(propertyAccessExpression);
				if (result == null) result = caseIArrayElement(propertyAccessExpression);
				if (result == null) result = caseIForInitializer(propertyAccessExpression);
				if (result == null) result = caseNode(propertyAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.NEW_EXPRESSION: {
				NewExpression newExpression = (NewExpression)theEObject;
				T result = caseNewExpression(newExpression);
				if (result == null) result = caseExpression(newExpression);
				if (result == null) result = caseIArrayElement(newExpression);
				if (result == null) result = caseIForInitializer(newExpression);
				if (result == null) result = caseNode(newExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.CALL_EXPRESSION: {
				CallExpression callExpression = (CallExpression)theEObject;
				T result = caseCallExpression(callExpression);
				if (result == null) result = caseExpression(callExpression);
				if (result == null) result = caseIArrayElement(callExpression);
				if (result == null) result = caseIForInitializer(callExpression);
				if (result == null) result = caseNode(callExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseExpression(unaryExpression);
				if (result == null) result = caseIArrayElement(unaryExpression);
				if (result == null) result = caseIForInitializer(unaryExpression);
				if (result == null) result = caseNode(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.BINARY_EXPRESSION: {
				BinaryExpression binaryExpression = (BinaryExpression)theEObject;
				T result = caseBinaryExpression(binaryExpression);
				if (result == null) result = caseExpression(binaryExpression);
				if (result == null) result = caseIArrayElement(binaryExpression);
				if (result == null) result = caseIForInitializer(binaryExpression);
				if (result == null) result = caseNode(binaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.CONDITIONAL_EXPRESSION: {
				ConditionalExpression conditionalExpression = (ConditionalExpression)theEObject;
				T result = caseConditionalExpression(conditionalExpression);
				if (result == null) result = caseExpression(conditionalExpression);
				if (result == null) result = caseIArrayElement(conditionalExpression);
				if (result == null) result = caseIForInitializer(conditionalExpression);
				if (result == null) result = caseNode(conditionalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = caseNode(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.BLOCK_STATEMENT: {
				BlockStatement blockStatement = (BlockStatement)theEObject;
				T result = caseBlockStatement(blockStatement);
				if (result == null) result = caseStatement(blockStatement);
				if (result == null) result = caseNode(blockStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.VARIABLE_STATEMENT: {
				VariableStatement variableStatement = (VariableStatement)theEObject;
				T result = caseVariableStatement(variableStatement);
				if (result == null) result = caseStatement(variableStatement);
				if (result == null) result = caseIForInitializer(variableStatement);
				if (result == null) result = caseNode(variableStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = caseNode(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.EMPTY_STATEMENT: {
				EmptyStatement emptyStatement = (EmptyStatement)theEObject;
				T result = caseEmptyStatement(emptyStatement);
				if (result == null) result = caseStatement(emptyStatement);
				if (result == null) result = caseNode(emptyStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.EXPRESSION_STATEMENT: {
				ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
				T result = caseExpressionStatement(expressionStatement);
				if (result == null) result = caseStatement(expressionStatement);
				if (result == null) result = caseNode(expressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = caseNode(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.ITERATION_STATEMENT: {
				IterationStatement iterationStatement = (IterationStatement)theEObject;
				T result = caseIterationStatement(iterationStatement);
				if (result == null) result = caseStatement(iterationStatement);
				if (result == null) result = caseNode(iterationStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.DO_STATEMENT: {
				DoStatement doStatement = (DoStatement)theEObject;
				T result = caseDoStatement(doStatement);
				if (result == null) result = caseIterationStatement(doStatement);
				if (result == null) result = caseStatement(doStatement);
				if (result == null) result = caseNode(doStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.WHILE_STATEMENT: {
				WhileStatement whileStatement = (WhileStatement)theEObject;
				T result = caseWhileStatement(whileStatement);
				if (result == null) result = caseIterationStatement(whileStatement);
				if (result == null) result = caseStatement(whileStatement);
				if (result == null) result = caseNode(whileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseIterationStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = caseNode(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.IFOR_INITIALIZER: {
				IForInitializer iForInitializer = (IForInitializer)theEObject;
				T result = caseIForInitializer(iForInitializer);
				if (result == null) result = caseNode(iForInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.FOR_IN_STATEMENT: {
				ForInStatement forInStatement = (ForInStatement)theEObject;
				T result = caseForInStatement(forInStatement);
				if (result == null) result = caseIterationStatement(forInStatement);
				if (result == null) result = caseStatement(forInStatement);
				if (result == null) result = caseNode(forInStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.CONTINUE_STATEMENT: {
				ContinueStatement continueStatement = (ContinueStatement)theEObject;
				T result = caseContinueStatement(continueStatement);
				if (result == null) result = caseStatement(continueStatement);
				if (result == null) result = caseNode(continueStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.BREAK_STATEMENT: {
				BreakStatement breakStatement = (BreakStatement)theEObject;
				T result = caseBreakStatement(breakStatement);
				if (result == null) result = caseStatement(breakStatement);
				if (result == null) result = caseNode(breakStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.RETURN_STATEMENT: {
				ReturnStatement returnStatement = (ReturnStatement)theEObject;
				T result = caseReturnStatement(returnStatement);
				if (result == null) result = caseStatement(returnStatement);
				if (result == null) result = caseNode(returnStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.WITH_STATEMENT: {
				WithStatement withStatement = (WithStatement)theEObject;
				T result = caseWithStatement(withStatement);
				if (result == null) result = caseStatement(withStatement);
				if (result == null) result = caseNode(withStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.SWITCH_STATEMENT: {
				SwitchStatement switchStatement = (SwitchStatement)theEObject;
				T result = caseSwitchStatement(switchStatement);
				if (result == null) result = caseStatement(switchStatement);
				if (result == null) result = caseNode(switchStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.SWITCH_ELEMENT: {
				SwitchElement switchElement = (SwitchElement)theEObject;
				T result = caseSwitchElement(switchElement);
				if (result == null) result = caseNode(switchElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.CASE_CLAUSE: {
				CaseClause caseClause = (CaseClause)theEObject;
				T result = caseCaseClause(caseClause);
				if (result == null) result = caseSwitchElement(caseClause);
				if (result == null) result = caseNode(caseClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.DEFAULT_CLAUSE: {
				DefaultClause defaultClause = (DefaultClause)theEObject;
				T result = caseDefaultClause(defaultClause);
				if (result == null) result = caseSwitchElement(defaultClause);
				if (result == null) result = caseNode(defaultClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.LABELED_STATEMENT: {
				LabeledStatement labeledStatement = (LabeledStatement)theEObject;
				T result = caseLabeledStatement(labeledStatement);
				if (result == null) result = caseStatement(labeledStatement);
				if (result == null) result = caseNode(labeledStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.THROW_STATEMENT: {
				ThrowStatement throwStatement = (ThrowStatement)theEObject;
				T result = caseThrowStatement(throwStatement);
				if (result == null) result = caseStatement(throwStatement);
				if (result == null) result = caseNode(throwStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.TRY_STATEMENT: {
				TryStatement tryStatement = (TryStatement)theEObject;
				T result = caseTryStatement(tryStatement);
				if (result == null) result = caseStatement(tryStatement);
				if (result == null) result = caseNode(tryStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.CATCH_CLAUSE: {
				CatchClause catchClause = (CatchClause)theEObject;
				T result = caseCatchClause(catchClause);
				if (result == null) result = caseNode(catchClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.FINALLY_CLAUSE: {
				FinallyClause finallyClause = (FinallyClause)theEObject;
				T result = caseFinallyClause(finallyClause);
				if (result == null) result = caseNode(finallyClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.FUNCTION_EXPRESSION: {
				FunctionExpression functionExpression = (FunctionExpression)theEObject;
				T result = caseFunctionExpression(functionExpression);
				if (result == null) result = caseExpression(functionExpression);
				if (result == null) result = caseIArrayElement(functionExpression);
				if (result == null) result = caseIForInitializer(functionExpression);
				if (result == null) result = caseNode(functionExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseNode(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.SOURCE: {
				Source source = (Source)theEObject;
				T result = caseSource(source);
				if (result == null) result = caseNode(source);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.CONST_STATEMENT: {
				ConstStatement constStatement = (ConstStatement)theEObject;
				T result = caseConstStatement(constStatement);
				if (result == null) result = caseStatement(constStatement);
				if (result == null) result = caseNode(constStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.PROPERTY_IDENTIFIER: {
				PropertyIdentifier propertyIdentifier = (PropertyIdentifier)theEObject;
				T result = casePropertyIdentifier(propertyIdentifier);
				if (result == null) result = caseExpression(propertyIdentifier);
				if (result == null) result = caseIProperty(propertyIdentifier);
				if (result == null) result = caseIArrayElement(propertyIdentifier);
				if (result == null) result = caseIForInitializer(propertyIdentifier);
				if (result == null) result = caseNode(propertyIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.IPROPERTY: {
				IProperty iProperty = (IProperty)theEObject;
				T result = caseIProperty(iProperty);
				if (result == null) result = caseNode(iProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.XML_INITIALIZER: {
				XmlInitializer xmlInitializer = (XmlInitializer)theEObject;
				T result = caseXmlInitializer(xmlInitializer);
				if (result == null) result = caseExpression(xmlInitializer);
				if (result == null) result = caseIArrayElement(xmlInitializer);
				if (result == null) result = caseIForInitializer(xmlInitializer);
				if (result == null) result = caseNode(xmlInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.ATTRIBUTE_IDENTIFIER: {
				AttributeIdentifier attributeIdentifier = (AttributeIdentifier)theEObject;
				T result = caseAttributeIdentifier(attributeIdentifier);
				if (result == null) result = casePropertyIdentifier(attributeIdentifier);
				if (result == null) result = caseExpression(attributeIdentifier);
				if (result == null) result = caseIProperty(attributeIdentifier);
				if (result == null) result = caseIArrayElement(attributeIdentifier);
				if (result == null) result = caseIForInitializer(attributeIdentifier);
				if (result == null) result = caseNode(attributeIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.ISELECTOR: {
				ISelector iSelector = (ISelector)theEObject;
				T result = caseISelector(iSelector);
				if (result == null) result = caseNode(iSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.QUALIFIED_IDENTIFIER: {
				QualifiedIdentifier qualifiedIdentifier = (QualifiedIdentifier)theEObject;
				T result = caseQualifiedIdentifier(qualifiedIdentifier);
				if (result == null) result = casePropertyIdentifier(qualifiedIdentifier);
				if (result == null) result = caseISelector(qualifiedIdentifier);
				if (result == null) result = caseExpression(qualifiedIdentifier);
				if (result == null) result = caseIProperty(qualifiedIdentifier);
				if (result == null) result = caseIArrayElement(qualifiedIdentifier);
				if (result == null) result = caseIForInitializer(qualifiedIdentifier);
				if (result == null) result = caseNode(qualifiedIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.IUNQUALIFIED_SELECTOR: {
				IUnqualifiedSelector iUnqualifiedSelector = (IUnqualifiedSelector)theEObject;
				T result = caseIUnqualifiedSelector(iUnqualifiedSelector);
				if (result == null) result = caseISelector(iUnqualifiedSelector);
				if (result == null) result = caseNode(iUnqualifiedSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.WILDCARD_IDENTIFIER: {
				WildcardIdentifier wildcardIdentifier = (WildcardIdentifier)theEObject;
				T result = caseWildcardIdentifier(wildcardIdentifier);
				if (result == null) result = casePropertyIdentifier(wildcardIdentifier);
				if (result == null) result = caseIPropertySelector(wildcardIdentifier);
				if (result == null) result = caseExpression(wildcardIdentifier);
				if (result == null) result = caseIProperty(wildcardIdentifier);
				if (result == null) result = caseIUnqualifiedSelector(wildcardIdentifier);
				if (result == null) result = caseIArrayElement(wildcardIdentifier);
				if (result == null) result = caseIForInitializer(wildcardIdentifier);
				if (result == null) result = caseISelector(wildcardIdentifier);
				if (result == null) result = caseNode(wildcardIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.IPROPERTY_SELECTOR: {
				IPropertySelector iPropertySelector = (IPropertySelector)theEObject;
				T result = caseIPropertySelector(iPropertySelector);
				if (result == null) result = caseIUnqualifiedSelector(iPropertySelector);
				if (result == null) result = caseISelector(iPropertySelector);
				if (result == null) result = caseNode(iPropertySelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.EXPRESSION_SELECTOR: {
				ExpressionSelector expressionSelector = (ExpressionSelector)theEObject;
				T result = caseExpressionSelector(expressionSelector);
				if (result == null) result = caseIUnqualifiedSelector(expressionSelector);
				if (result == null) result = caseISelector(expressionSelector);
				if (result == null) result = caseNode(expressionSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.XML_FRAGMENT: {
				XmlFragment xmlFragment = (XmlFragment)theEObject;
				T result = caseXmlFragment(xmlFragment);
				if (result == null) result = caseNode(xmlFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.XML_TEXT_FRAGMENT: {
				XmlTextFragment xmlTextFragment = (XmlTextFragment)theEObject;
				T result = caseXmlTextFragment(xmlTextFragment);
				if (result == null) result = caseXmlFragment(xmlTextFragment);
				if (result == null) result = caseNode(xmlTextFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.XML_EXPRESSION_FRAGMENT: {
				XmlExpressionFragment xmlExpressionFragment = (XmlExpressionFragment)theEObject;
				T result = caseXmlExpressionFragment(xmlExpressionFragment);
				if (result == null) result = caseXmlFragment(xmlExpressionFragment);
				if (result == null) result = caseNode(xmlExpressionFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.DESCENDANT_ACCESS_EXPRESSION: {
				DescendantAccessExpression descendantAccessExpression = (DescendantAccessExpression)theEObject;
				T result = caseDescendantAccessExpression(descendantAccessExpression);
				if (result == null) result = caseExpression(descendantAccessExpression);
				if (result == null) result = caseIArrayElement(descendantAccessExpression);
				if (result == null) result = caseIForInitializer(descendantAccessExpression);
				if (result == null) result = caseNode(descendantAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.FILTER_EXPRESSION: {
				FilterExpression filterExpression = (FilterExpression)theEObject;
				T result = caseFilterExpression(filterExpression);
				if (result == null) result = caseExpression(filterExpression);
				if (result == null) result = caseIArrayElement(filterExpression);
				if (result == null) result = caseIForInitializer(filterExpression);
				if (result == null) result = caseNode(filterExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.DEFAULT_XML_NAMESPACE_STATEMENT: {
				DefaultXmlNamespaceStatement defaultXmlNamespaceStatement = (DefaultXmlNamespaceStatement)theEObject;
				T result = caseDefaultXmlNamespaceStatement(defaultXmlNamespaceStatement);
				if (result == null) result = caseStatement(defaultXmlNamespaceStatement);
				if (result == null) result = caseNode(defaultXmlNamespaceStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.FOR_EACH_IN_STATEMENT: {
				ForEachInStatement forEachInStatement = (ForEachInStatement)theEObject;
				T result = caseForEachInStatement(forEachInStatement);
				if (result == null) result = caseIterationStatement(forEachInStatement);
				if (result == null) result = caseStatement(forEachInStatement);
				if (result == null) result = caseNode(forEachInStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.ARROW_FUNCTION: {
				ArrowFunction arrowFunction = (ArrowFunction)theEObject;
				T result = caseArrowFunction(arrowFunction);
				if (result == null) result = caseExpression(arrowFunction);
				if (result == null) result = caseIArrayElement(arrowFunction);
				if (result == null) result = caseIForInitializer(arrowFunction);
				if (result == null) result = caseNode(arrowFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.TEMPLATE_STRING_LITERAL: {
				TemplateStringLiteral templateStringLiteral = (TemplateStringLiteral)theEObject;
				T result = caseTemplateStringLiteral(templateStringLiteral);
				if (result == null) result = caseExpression(templateStringLiteral);
				if (result == null) result = caseIPropertyName(templateStringLiteral);
				if (result == null) result = caseIArrayElement(templateStringLiteral);
				if (result == null) result = caseIForInitializer(templateStringLiteral);
				if (result == null) result = caseNode(templateStringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.TEMPLATE_STRING_EXPRESSION: {
				TemplateStringExpression templateStringExpression = (TemplateStringExpression)theEObject;
				T result = caseTemplateStringExpression(templateStringExpression);
				if (result == null) result = caseExpression(templateStringExpression);
				if (result == null) result = caseIArrayElement(templateStringExpression);
				if (result == null) result = caseIForInitializer(templateStringExpression);
				if (result == null) result = caseNode(templateStringExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomPackage.TAG_FUNCTION: {
				TagFunction tagFunction = (TagFunction)theEObject;
				T result = caseTagFunction(tagFunction);
				if (result == null) result = caseExpression(tagFunction);
				if (result == null) result = caseIArrayElement(tagFunction);
				if (result == null) result = caseIForInitializer(tagFunction);
				if (result == null) result = caseNode(tagFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComment(Comment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableReference(VariableReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullLiteral(NullLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericLiteral(NumericLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regular Expression Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regular Expression Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegularExpressionLiteral(RegularExpressionLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>This Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>This Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThisExpression(ThisExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayLiteral(ArrayLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IArray Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IArray Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIArrayElement(IArrayElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Elision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Elision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElision(Elision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectLiteral(ObjectLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyAssignment(PropertyAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProperty Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProperty Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPropertyName(IPropertyName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Property Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimplePropertyAssignment(SimplePropertyAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Accessor Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Accessor Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccessorAssignment(AccessorAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Getter Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Getter Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetterAssignment(GetterAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Setter Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Setter Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetterAssignment(SetterAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParenthesizedExpression(ParenthesizedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayAccessExpression(ArrayAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyAccessExpression(PropertyAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewExpression(NewExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExpression(CallExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryExpression(BinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalExpression(ConditionalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockStatement(BlockStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableStatement(VariableStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptyStatement(EmptyStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionStatement(ExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfStatement(IfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iteration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterationStatement(IterationStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Do Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoStatement(DoStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileStatement(WhileStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForStatement(ForStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFor Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFor Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIForInitializer(IForInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For In Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For In Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForInStatement(ForInStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinueStatement(ContinueStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakStatement(BreakStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnStatement(ReturnStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>With Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>With Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWithStatement(WithStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchStatement(SwitchStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchElement(SwitchElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseClause(CaseClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultClause(DefaultClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Labeled Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Labeled Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabeledStatement(LabeledStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throw Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throw Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrowStatement(ThrowStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Try Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Try Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTryStatement(TryStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catch Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCatchClause(CatchClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Finally Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Finally Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinallyClause(FinallyClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionExpression(FunctionExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSource(Source object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstStatement(ConstStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyIdentifier(PropertyIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProperty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProperty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIProperty(IProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xml Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xml Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXmlInitializer(XmlInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeIdentifier(AttributeIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISelector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISelector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISelector(ISelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualifiedIdentifier(QualifiedIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IUnqualified Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUnqualified Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIUnqualifiedSelector(IUnqualifiedSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wildcard Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wildcard Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWildcardIdentifier(WildcardIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProperty Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProperty Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPropertySelector(IPropertySelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionSelector(ExpressionSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xml Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xml Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXmlFragment(XmlFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xml Text Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xml Text Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXmlTextFragment(XmlTextFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xml Expression Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xml Expression Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXmlExpressionFragment(XmlExpressionFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descendant Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descendant Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescendantAccessExpression(DescendantAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterExpression(FilterExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Xml Namespace Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Xml Namespace Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultXmlNamespaceStatement(DefaultXmlNamespaceStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each In Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each In Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachInStatement(ForEachInStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arrow Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arrow Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrowFunction(ArrowFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateStringLiteral(TemplateStringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template String Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template String Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateStringExpression(TemplateStringExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagFunction(TagFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //DomSwitch
