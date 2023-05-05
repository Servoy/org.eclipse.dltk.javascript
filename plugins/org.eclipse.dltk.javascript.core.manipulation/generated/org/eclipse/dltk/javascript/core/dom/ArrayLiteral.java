/**
 * <copyright>
 * </copyright>
 *
 * $Id: ArrayLiteral.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ArrayLiteral#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrayLiteral()
 * @model
 * @generated
 */
public interface ArrayLiteral extends Expression {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.IArrayElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrayLiteral_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<IArrayElement> getElements();

} // ArrayLiteral
