/**
 */
package org.eclipse.dltk.javascript.core.dom;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spread Element</b></em>'.
 * Represents a spread element in an array literal or call argument: {@code ...expr}.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.SpreadElement#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSpreadElement()
 * @model
 * @generated
 */
public interface SpreadElement extends Expression, IArrayElement {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSpreadElement_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.SpreadElement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // SpreadElement
