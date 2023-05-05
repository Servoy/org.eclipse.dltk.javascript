/**
 * <copyright>
 * </copyright>
 *
 * $Id: AccessorAssignment.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accessor Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.AccessorAssignment#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getAccessorAssignment()
 * @model abstract="true"
 * @generated
 */
public interface AccessorAssignment extends PropertyAssignment {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(BlockStatement)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getAccessorAssignment_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BlockStatement getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.AccessorAssignment#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(BlockStatement value);

} // AccessorAssignment
