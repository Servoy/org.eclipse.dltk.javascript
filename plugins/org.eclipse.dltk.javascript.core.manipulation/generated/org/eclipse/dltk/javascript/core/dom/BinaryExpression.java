/**
 * <copyright>
 * </copyright>
 *
 * $Id: BinaryExpression.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getRight <em>Right</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getOperatorPosition <em>Operator Position</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getBinaryExpression()
 * @model
 * @generated
 */
public interface BinaryExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getBinaryExpression_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Expression value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getBinaryExpression_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getRight();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Expression value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.dltk.javascript.core.dom.BinaryOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryOperator
	 * @see #setOperation(BinaryOperator)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getBinaryExpression_Operation()
	 * @model required="true"
	 * @generated
	 */
	BinaryOperator getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryOperator
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(BinaryOperator value);

	/**
	 * Returns the value of the '<em><b>Operator Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Position</em>' attribute.
	 * @see #setOperatorPosition(int)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getBinaryExpression_OperatorPosition()
	 * @model required="true"
	 * @generated
	 */
	int getOperatorPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getOperatorPosition <em>Operator Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Position</em>' attribute.
	 * @see #getOperatorPosition()
	 * @generated
	 */
	void setOperatorPosition(int value);

} // BinaryExpression
