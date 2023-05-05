/**
 * <copyright>
 * </copyright>
 *
 * $Id: BlockStatement.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.BlockStatement#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getBlockStatement()
 * @model
 * @generated
 */
public interface BlockStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getBlockStatement_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getStatements();

} // BlockStatement
