/**
 * <copyright>
 * </copyright>
 *
 * $Id: NewExpression.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.NewExpression#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.NewExpression#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getNewExpression()
 * @model
 * @generated
 */
public interface NewExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Constructor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constructor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructor</em>' containment reference.
	 * @see #setConstructor(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getNewExpression_Constructor()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getConstructor();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.NewExpression#getConstructor <em>Constructor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constructor</em>' containment reference.
	 * @see #getConstructor()
	 * @generated
	 */
	void setConstructor(Expression value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getNewExpression_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArguments();

} // NewExpression
