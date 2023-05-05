/**
 * <copyright>
 * </copyright>
 *
 * $Id: TryStatement.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Try Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.TryStatement#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.TryStatement#getCatches <em>Catches</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.TryStatement#getFinallyClause <em>Finally Clause</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTryStatement()
 * @model
 * @generated
 */
public interface TryStatement extends Statement {
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
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTryStatement_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BlockStatement getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.TryStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(BlockStatement value);

	/**
	 * Returns the value of the '<em><b>Catches</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.CatchClause}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catches</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTryStatement_Catches()
	 * @model containment="true"
	 * @generated
	 */
	EList<CatchClause> getCatches();

	/**
	 * Returns the value of the '<em><b>Finally Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finally Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally Clause</em>' containment reference.
	 * @see #setFinallyClause(FinallyClause)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getTryStatement_FinallyClause()
	 * @model containment="true"
	 * @generated
	 */
	FinallyClause getFinallyClause();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.TryStatement#getFinallyClause <em>Finally Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally Clause</em>' containment reference.
	 * @see #getFinallyClause()
	 * @generated
	 */
	void setFinallyClause(FinallyClause value);

} // TryStatement
