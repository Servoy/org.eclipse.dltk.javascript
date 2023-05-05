/**
 * <copyright>
 * </copyright>
 *
 * $Id: VariableStatement.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.VariableStatement#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getVariableStatement()
 * @model
 * @generated
 */
public interface VariableStatement extends Statement, IForInitializer {
	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarations</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getVariableStatement_Declarations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<VariableDeclaration> getDeclarations();

} // VariableStatement
