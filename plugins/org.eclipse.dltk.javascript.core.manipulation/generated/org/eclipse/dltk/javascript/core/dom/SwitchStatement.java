/**
 * <copyright>
 * </copyright>
 *
 * $Id: SwitchStatement.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.SwitchStatement#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.SwitchStatement#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSwitchStatement()
 * @model
 * @generated
 */
public interface SwitchStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selector</em>' containment reference.
	 * @see #setSelector(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSwitchStatement_Selector()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getSelector();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.SwitchStatement#getSelector <em>Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selector</em>' containment reference.
	 * @see #getSelector()
	 * @generated
	 */
	void setSelector(Expression value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.SwitchElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getSwitchStatement_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<SwitchElement> getElements();

} // SwitchStatement
