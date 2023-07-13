/**
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.LetStatement#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getLetStatement()
 * @model
 * @generated
 */
public interface LetStatement extends Statement, IForInitializer {
	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarations</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getLetStatement_Declarations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<VariableDeclaration> getDeclarations();

} // LetStatement
