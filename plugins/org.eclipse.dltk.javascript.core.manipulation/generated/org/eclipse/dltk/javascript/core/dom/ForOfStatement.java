/**
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Of Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ForOfStatement#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ForOfStatement#getCollection <em>Collection</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForOfStatement()
 * @model
 * @generated
 */
public interface ForOfStatement extends IterationStatement {
	/**
	 * Returns the value of the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' containment reference.
	 * @see #setItem(IForInitializer)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForOfStatement_Item()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IForInitializer getItem();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ForOfStatement#getItem <em>Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' containment reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(IForInitializer value);

	/**
	 * Returns the value of the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection</em>' containment reference.
	 * @see #setCollection(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForOfStatement_Collection()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCollection();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ForOfStatement#getCollection <em>Collection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection</em>' containment reference.
	 * @see #getCollection()
	 * @generated
	 */
	void setCollection(Expression value);

} // ForOfStatement
