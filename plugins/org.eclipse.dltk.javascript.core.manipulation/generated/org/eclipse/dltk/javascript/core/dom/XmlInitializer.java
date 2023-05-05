/**
 * <copyright>
 * </copyright>
 *
 * $Id: XmlInitializer.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xml Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.XmlInitializer#getFragments <em>Fragments</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getXmlInitializer()
 * @model
 * @generated
 */
public interface XmlInitializer extends Expression {
	/**
	 * Returns the value of the '<em><b>Fragments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.XmlFragment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragments</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getXmlInitializer_Fragments()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<XmlFragment> getFragments();

} // XmlInitializer
