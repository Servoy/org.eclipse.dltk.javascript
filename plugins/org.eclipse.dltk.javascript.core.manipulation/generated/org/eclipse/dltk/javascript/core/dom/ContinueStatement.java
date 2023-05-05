/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContinueStatement.java,v 1.3 2010/12/29 15:18:57 jcompagne Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Continue Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ContinueStatement#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getContinueStatement()
 * @model
 * @generated
 */
public interface ContinueStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' containment reference.
	 * @see #setLabel(Label)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getContinueStatement_Label()
	 * @model containment="true"
	 * @generated
	 */
	Label getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ContinueStatement#getLabel <em>Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' containment reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(Label value);

} // ContinueStatement
