/**
 * <copyright>
 * </copyright>
 *
 * $Id: SetterAssignment.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Setter Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.SetterAssignment#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSetterAssignment()
 * @model
 * @generated
 */
public interface SetterAssignment extends AccessorAssignment {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference.
	 * @see #setParameter(Identifier)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSetterAssignment_Parameter()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.SetterAssignment#getParameter <em>Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' containment reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Identifier value);

} // SetterAssignment
