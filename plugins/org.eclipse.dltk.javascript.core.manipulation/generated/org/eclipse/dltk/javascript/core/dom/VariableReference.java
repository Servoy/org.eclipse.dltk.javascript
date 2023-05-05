/**
 * <copyright>
 * </copyright>
 *
 * $Id: VariableReference.java,v 1.4 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.VariableReference#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getVariableReference()
 * @model
 * @generated
 */
public interface VariableReference extends Expression {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(Identifier)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getVariableReference_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.VariableReference#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Identifier value);

} // VariableReference
