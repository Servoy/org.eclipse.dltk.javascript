/**
 * <copyright>
 * </copyright>
 *
 * $Id: CatchClause.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catch Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.CatchClause#getException <em>Exception</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.CatchClause#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.CatchClause#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getCatchClause()
 * @model
 * @generated
 */
public interface CatchClause extends Node {
	/**
	 * Returns the value of the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' containment reference.
	 * @see #setException(Identifier)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getCatchClause_Exception()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getException();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.CatchClause#getException <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' containment reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(Identifier value);

	/**
	 * Returns the value of the '<em><b>Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter</em>' containment reference.
	 * @see #setFilter(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getCatchClause_Filter()
	 * @model containment="true"
	 * @generated
	 */
	Expression getFilter();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.CatchClause#getFilter <em>Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' containment reference.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(Expression value);

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
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getCatchClause_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BlockStatement getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.CatchClause#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(BlockStatement value);

} // CatchClause
