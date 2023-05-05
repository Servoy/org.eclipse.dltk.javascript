/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConditionalExpression.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getConsequent <em>Consequent</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getAlternative <em>Alternative</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getConditionalExpression()
 * @model
 * @generated
 */
public interface ConditionalExpression extends Expression {
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
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getConditionalExpression_Predicate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getPredicate();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getPredicate <em>Predicate</em>}' containment reference.
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
	 * @see #setConsequent(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getConditionalExpression_Consequent()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getConsequent();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getConsequent <em>Consequent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consequent</em>' containment reference.
	 * @see #getConsequent()
	 * @generated
	 */
	void setConsequent(Expression value);

	/**
	 * Returns the value of the '<em><b>Alternative</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative</em>' containment reference.
	 * @see #setAlternative(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getConditionalExpression_Alternative()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getAlternative();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getAlternative <em>Alternative</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alternative</em>' containment reference.
	 * @see #getAlternative()
	 * @generated
	 */
	void setAlternative(Expression value);

} // ConditionalExpression
