/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimplePropertyAssignment.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.SimplePropertyAssignment#getInitializer <em>Initializer</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSimplePropertyAssignment()
 * @model
 * @generated
 */
public interface SimplePropertyAssignment extends PropertyAssignment {
	/**
	 * Returns the value of the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initializer</em>' containment reference.
	 * @see #setInitializer(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSimplePropertyAssignment_Initializer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getInitializer();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.SimplePropertyAssignment#getInitializer <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializer</em>' containment reference.
	 * @see #getInitializer()
	 * @generated
	 */
	void setInitializer(Expression value);

} // SimplePropertyAssignment
