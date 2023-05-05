/**
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template String Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral#getTemplateExpressions <em>Template Expressions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTemplateStringLiteral()
 * @model
 * @generated
 */
public interface TemplateStringLiteral extends Expression, IPropertyName {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTemplateStringLiteral_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Template Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.TemplateStringExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Expressions</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTemplateStringLiteral_TemplateExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemplateStringExpression> getTemplateExpressions();

} // TemplateStringLiteral
