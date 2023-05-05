/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionExpression.java,v 1.5 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getParametersPosition <em>Parameters Position</em>}</li>
 * </ul>
 *
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getFunctionExpression()
 * @model
 * @generated
 */
public interface FunctionExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documentation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' reference.
	 * @see #setDocumentation(Comment)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getFunctionExpression_Documentation()
	 * @model
	 * @generated
	 */
	Comment getDocumentation();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getDocumentation <em>Documentation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' reference.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(Comment value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' containment reference.
	 * @see #setIdentifier(Identifier)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getFunctionExpression_Identifier()
	 * @model containment="true"
	 * @generated
	 */
	Identifier getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getIdentifier <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' containment reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(Identifier value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.dltk.javascript.core.dom.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getFunctionExpression_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(BlockStatement)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getFunctionExpression_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BlockStatement getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(BlockStatement value);

	/**
	 * Returns the value of the '<em><b>Parameters Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters Position</em>' attribute.
	 * @see #setParametersPosition(int)
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getFunctionExpression_ParametersPosition()
	 * @model required="true"
	 * @generated
	 */
	int getParametersPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getParametersPosition <em>Parameters Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters Position</em>' attribute.
	 * @see #getParametersPosition()
	 * @generated
	 */
	void setParametersPosition(int value);

} // FunctionExpression
