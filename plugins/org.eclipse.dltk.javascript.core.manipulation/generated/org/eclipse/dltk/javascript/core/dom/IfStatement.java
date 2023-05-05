/**
 * <copyright>
 * </copyright>
 *
 * $Id: IfStatement.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.IfStatement#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.IfStatement#getConsequent <em>Consequent</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.IfStatement#getAlternative <em>Alternative</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference.
	 * @see #setPredicate(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getIfStatement_Predicate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getPredicate();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.IfStatement#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Expression value);

	/**
	 * Returns the value of the '<em><b>Consequent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consequent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consequent</em>' containment reference.
	 * @see #setConsequent(Statement)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getIfStatement_Consequent()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getConsequent();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.IfStatement#getConsequent <em>Consequent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consequent</em>' containment reference.
	 * @see #getConsequent()
	 * @generated
	 */
	void setConsequent(Statement value);

	/**
	 * Returns the value of the '<em><b>Alternative</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative</em>' containment reference.
	 * @see #setAlternative(Statement)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getIfStatement_Alternative()
	 * @model containment="true"
	 * @generated
	 */
	Statement getAlternative();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.IfStatement#getAlternative <em>Alternative</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alternative</em>' containment reference.
	 * @see #getAlternative()
	 * @generated
	 */
	void setAlternative(Statement value);

} // IfStatement
