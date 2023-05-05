/**
 * <copyright>
 * </copyright>
 *
 * $Id: QualifiedIdentifier.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getQualifiedIdentifier()
 * @model
 * @generated
 */
public interface QualifiedIdentifier extends PropertyIdentifier, ISelector {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' containment reference.
	 * @see #setNamespace(IPropertySelector)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getQualifiedIdentifier_Namespace()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IPropertySelector getNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier#getNamespace <em>Namespace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' containment reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(IPropertySelector value);

	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' containment reference.
	 * @see #setMember(IUnqualifiedSelector)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getQualifiedIdentifier_Member()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IUnqualifiedSelector getMember();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier#getMember <em>Member</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member</em>' containment reference.
	 * @see #getMember()
	 * @generated
	 */
	void setMember(IUnqualifiedSelector value);

} // QualifiedIdentifier
