/**
 * <copyright>
 * </copyright>
 *
 * $Id: Node.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.Node#getBegin <em>Begin</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.Node#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Begin</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin</em>' attribute.
	 * @see #setBegin(int)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getNode_Begin()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getBegin();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.Node#getBegin <em>Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin</em>' attribute.
	 * @see #getBegin()
	 * @generated
	 */
	void setBegin(int value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(int)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getNode_End()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.Node#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(int value);

} // Node
