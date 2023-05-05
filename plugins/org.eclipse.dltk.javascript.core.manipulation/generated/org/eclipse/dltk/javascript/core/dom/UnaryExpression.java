/**
 * <copyright>
 * </copyright>
 *
 * $Id: UnaryExpression.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.UnaryExpression#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.UnaryExpression#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference.
	 * @see #setArgument(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getUnaryExpression_Argument()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.UnaryExpression#getArgument <em>Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument</em>' containment reference.
	 * @see #getArgument()
	 * @generated
	 */
	void setArgument(Expression value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.dltk.javascript.core.dom.UnaryOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see org.eclipse.dltk.javascript.core.dom.UnaryOperator
	 * @see #setOperation(UnaryOperator)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getUnaryExpression_Operation()
	 * @model required="true"
	 * @generated
	 */
	UnaryOperator getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.UnaryExpression#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see org.eclipse.dltk.javascript.core.dom.UnaryOperator
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(UnaryOperator value);

} // UnaryExpression
