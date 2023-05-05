/**
 * <copyright>
 * </copyright>
 *
 * $Id: ThisExpressionImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.ThisExpression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>This Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ThisExpressionImpl extends ExpressionImpl implements ThisExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThisExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.THIS_EXPRESSION;
	}

} //ThisExpressionImpl
