/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeIdentifier.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.AttributeIdentifier#getSelector <em>Selector</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getAttributeIdentifier()
 * @model
 * @generated
 */
public interface AttributeIdentifier extends PropertyIdentifier {
	/**
	 * Returns the value of the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selector</em>' containment reference.
	 * @see #setSelector(ISelector)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getAttributeIdentifier_Selector()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ISelector getSelector();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.AttributeIdentifier#getSelector <em>Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selector</em>' containment reference.
	 * @see #getSelector()
	 * @generated
	 */
	void setSelector(ISelector value);

} // AttributeIdentifier
