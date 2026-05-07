/**
 */
package org.eclipse.dltk.javascript.core.dom;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spread Property</b></em>'.
 * Represents a spread property in an object literal: {@code { ...expr }}.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.SpreadProperty#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSpreadProperty()
 * @model
 * @generated
 */
public interface SpreadProperty extends PropertyAssignment {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSpreadProperty_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.SpreadProperty#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // SpreadProperty
