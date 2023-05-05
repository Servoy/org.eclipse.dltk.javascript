/**
 * <copyright>
 * </copyright>
 *
 * $Id: ForEachInStatement.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Each In Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ForEachInStatement#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ForEachInStatement#getCollection <em>Collection</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForEachInStatement()
 * @model
 * @generated
 */
public interface ForEachInStatement extends IterationStatement {
	/**
	 * Returns the value of the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' containment reference.
	 * @see #setItem(IForInitializer)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForEachInStatement_Item()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IForInitializer getItem();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ForEachInStatement#getItem <em>Item</em>}' containment reference.
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
	 * <p>
	 * If the meaning of the '<em>Collection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection</em>' containment reference.
	 * @see #setCollection(Expression)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getForEachInStatement_Collection()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCollection();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ForEachInStatement#getCollection <em>Collection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection</em>' containment reference.
	 * @see #getCollection()
	 * @generated
	 */
	void setCollection(Expression value);

} // ForEachInStatement
