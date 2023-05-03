/**
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrow Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getParametersPosition <em>Parameters Position</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrowFunction()
 * @model
 * @generated
 */
public interface ArrowFunction extends Expression {
	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' reference.
	 * @see #setDocumentation(Comment)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrowFunction_Documentation()
	 * @model
	 * @generated
	 */
	Comment getDocumentation();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getDocumentation <em>Documentation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' reference.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(Comment value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrowFunction_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Statement)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrowFunction_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Statement value);

	/**
	 * Returns the value of the '<em><b>Parameters Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters Position</em>' attribute.
	 * @see #setParametersPosition(int)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getArrowFunction_ParametersPosition()
	 * @model required="true"
	 * @generated
	 */
	int getParametersPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getParametersPosition <em>Parameters Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters Position</em>' attribute.
	 * @see #getParametersPosition()
	 * @generated
	 */
	void setParametersPosition(int value);

} // ArrowFunction
