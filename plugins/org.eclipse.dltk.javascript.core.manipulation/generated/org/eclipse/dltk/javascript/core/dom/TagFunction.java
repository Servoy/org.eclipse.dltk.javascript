/**
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.TagFunction#getTagFunction <em>Tag Function</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.TagFunction#getTemplateStringLiteral <em>Template String Literal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTagFunction()
 * @model
 * @generated
 */
public interface TagFunction extends Expression {
	/**
	 * Returns the value of the '<em><b>Tag Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Function</em>' containment reference.
	 * @see #setTagFunction(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTagFunction_TagFunction()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getTagFunction();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.TagFunction#getTagFunction <em>Tag Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag Function</em>' containment reference.
	 * @see #getTagFunction()
	 * @generated
	 */
	void setTagFunction(Expression value);

	/**
	 * Returns the value of the '<em><b>Template String Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template String Literal</em>' reference.
	 * @see #setTemplateStringLiteral(TemplateStringLiteral)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTagFunction_TemplateStringLiteral()
	 * @model
	 * @generated
	 */
	TemplateStringLiteral getTemplateStringLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.TagFunction#getTemplateStringLiteral <em>Template String Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template String Literal</em>' reference.
	 * @see #getTemplateStringLiteral()
	 * @generated
	 */
	void setTemplateStringLiteral(TemplateStringLiteral value);

} // TagFunction
