/**
 * <copyright>
 * </copyright>
 *
 * $Id: ForStatement.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ForStatement#getInitialization <em>Initialization</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ForStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ForStatement#getIncrement <em>Increment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends IterationStatement {
	/**
	 * Returns the value of the '<em><b>Initialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialization</em>' containment reference.
	 * @see #setInitialization(IForInitializer)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForStatement_Initialization()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IForInitializer getInitialization();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ForStatement#getInitialization <em>Initialization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization</em>' containment reference.
	 * @see #getInitialization()
	 * @generated
	 */
	void setInitialization(IForInitializer value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForStatement_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ForStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Increment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Increment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Increment</em>' containment reference.
	 * @see #setIncrement(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForStatement_Increment()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getIncrement();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ForStatement#getIncrement <em>Increment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increment</em>' containment reference.
	 * @see #getIncrement()
	 * @generated
	 */
	void setIncrement(Expression value);

} // ForStatement
