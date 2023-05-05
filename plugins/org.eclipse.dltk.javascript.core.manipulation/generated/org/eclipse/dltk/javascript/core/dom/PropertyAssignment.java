/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertyAssignment.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.PropertyAssignment#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getPropertyAssignment()
 * @model abstract="true"
 * @generated
 */
public interface PropertyAssignment extends Node {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(IPropertyName)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getPropertyAssignment_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IPropertyName getName();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.PropertyAssignment#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(IPropertyName value);

} // PropertyAssignment
