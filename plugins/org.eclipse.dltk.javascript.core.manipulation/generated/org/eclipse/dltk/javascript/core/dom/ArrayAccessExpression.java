/**
 * <copyright>
 * </copyright>
 *
 * $Id: ArrayAccessExpression.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Access Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression#getArray <em>Array</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrayAccessExpression()
 * @model
 * @generated
 */
public interface ArrayAccessExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array</em>' containment reference.
	 * @see #setArray(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrayAccessExpression_Array()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getArray();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression#getArray <em>Array</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array</em>' containment reference.
	 * @see #getArray()
	 * @generated
	 */
	void setArray(Expression value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' containment reference.
	 * @see #setIndex(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrayAccessExpression_Index()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression#getIndex <em>Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' containment reference.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Expression value);

} // ArrayAccessExpression
