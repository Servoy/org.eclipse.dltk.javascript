/**
 */
package org.eclipse.dltk.javascript.core.dom;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computed Property Key</b></em>'.
 * Represents a computed property key in an object literal: {@code { [expr]: value }}.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ComputedPropertyKey#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ComputedPropertyKey#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getComputedPropertyKey()
 * @model
 * @generated
 */
public interface ComputedPropertyKey extends PropertyAssignment {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' containment reference.
	 * @see #setKey(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getComputedPropertyKey_Key()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getKey();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ComputedPropertyKey#getKey <em>Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' containment reference.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(Expression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getComputedPropertyKey_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ComputedPropertyKey#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // ComputedPropertyKey
