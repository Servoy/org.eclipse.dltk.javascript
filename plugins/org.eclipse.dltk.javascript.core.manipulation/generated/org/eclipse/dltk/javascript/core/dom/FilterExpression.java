/**
 * <copyright>
 * </copyright>
 *
 * $Id: FilterExpression.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.FilterExpression#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.FilterExpression#getFilter <em>Filter</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getFilterExpression()
 * @model
 * @generated
 */
public interface FilterExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' containment reference.
	 * @see #setObject(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getFilterExpression_Object()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.FilterExpression#getObject <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' containment reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(Expression value);

	/**
	 * Returns the value of the '<em><b>Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter</em>' containment reference.
	 * @see #setFilter(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getFilterExpression_Filter()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getFilter();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.FilterExpression#getFilter <em>Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' containment reference.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(Expression value);

} // FilterExpression
