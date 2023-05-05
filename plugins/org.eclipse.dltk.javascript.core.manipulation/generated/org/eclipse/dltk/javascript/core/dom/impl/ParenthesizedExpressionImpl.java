/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParenthesizedExpressionImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Expression;
import org.eclipse.dltk.javascript.core.dom.ParenthesizedExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parenthesized Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ParenthesizedExpressionImpl#getEnclosed <em>Enclosed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParenthesizedExpressionImpl extends ExpressionImpl implements ParenthesizedExpression {
	/**
	 * The cached value of the '{@link #getEnclosed() <em>Enclosed</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnclosed()
	 * @generated
	 * @ordered
	 */
	protected Expression enclosed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParenthesizedExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.PARENTHESIZED_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getEnclosed() {
		return enclosed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnclosed(Expression newEnclosed, NotificationChain msgs) {
		Expression oldEnclosed = enclosed;
		enclosed = newEnclosed;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.PARENTHESIZED_EXPRESSION__ENCLOSED, oldEnclosed, newEnclosed);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnclosed(Expression newEnclosed) {
		if (newEnclosed != enclosed) {
			NotificationChain msgs = null;
			if (enclosed != null)
				msgs = ((InternalEObject)enclosed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.PARENTHESIZED_EXPRESSION__ENCLOSED, null, msgs);
			if (newEnclosed != null)
				msgs = ((InternalEObject)newEnclosed).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.PARENTHESIZED_EXPRESSION__ENCLOSED, null, msgs);
			msgs = basicSetEnclosed(newEnclosed, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.PARENTHESIZED_EXPRESSION__ENCLOSED, newEnclosed, newEnclosed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.PARENTHESIZED_EXPRESSION__ENCLOSED:
				return basicSetEnclosed(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomPackage.PARENTHESIZED_EXPRESSION__ENCLOSED:
				return getEnclosed();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DomPackage.PARENTHESIZED_EXPRESSION__ENCLOSED:
				setEnclosed((Expression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DomPackage.PARENTHESIZED_EXPRESSION__ENCLOSED:
				setEnclosed((Expression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DomPackage.PARENTHESIZED_EXPRESSION__ENCLOSED:
				return enclosed != null;
		}
		return super.eIsSet(featureID);
	}

} //ParenthesizedExpressionImpl
