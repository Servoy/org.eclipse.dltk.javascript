/**
 * <copyright>
 * </copyright>
 *
 * $Id: CallExpressionImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import java.util.Collection;

import org.eclipse.dltk.javascript.core.dom.CallExpression;
import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.CallExpressionImpl#getApplicant <em>Applicant</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.CallExpressionImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallExpressionImpl extends ExpressionImpl implements CallExpression {
	/**
	 * The cached value of the '{@link #getApplicant() <em>Applicant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicant()
	 * @generated
	 * @ordered
	 */
	protected Expression applicant;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> arguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.CALL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getApplicant() {
		return applicant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplicant(Expression newApplicant, NotificationChain msgs) {
		Expression oldApplicant = applicant;
		applicant = newApplicant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.CALL_EXPRESSION__APPLICANT, oldApplicant, newApplicant);
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
	public void setApplicant(Expression newApplicant) {
		if (newApplicant != applicant) {
			NotificationChain msgs = null;
			if (applicant != null)
				msgs = ((InternalEObject)applicant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.CALL_EXPRESSION__APPLICANT, null, msgs);
			if (newApplicant != null)
				msgs = ((InternalEObject)newApplicant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.CALL_EXPRESSION__APPLICANT, null, msgs);
			msgs = basicSetApplicant(newApplicant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.CALL_EXPRESSION__APPLICANT, newApplicant, newApplicant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<Expression>(Expression.class, this, DomPackage.CALL_EXPRESSION__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.CALL_EXPRESSION__APPLICANT:
				return basicSetApplicant(null, msgs);
			case DomPackage.CALL_EXPRESSION__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case DomPackage.CALL_EXPRESSION__APPLICANT:
				return getApplicant();
			case DomPackage.CALL_EXPRESSION__ARGUMENTS:
				return getArguments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DomPackage.CALL_EXPRESSION__APPLICANT:
				setApplicant((Expression)newValue);
				return;
			case DomPackage.CALL_EXPRESSION__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends Expression>)newValue);
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
			case DomPackage.CALL_EXPRESSION__APPLICANT:
				setApplicant((Expression)null);
				return;
			case DomPackage.CALL_EXPRESSION__ARGUMENTS:
				getArguments().clear();
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
			case DomPackage.CALL_EXPRESSION__APPLICANT:
				return applicant != null;
			case DomPackage.CALL_EXPRESSION__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CallExpressionImpl
