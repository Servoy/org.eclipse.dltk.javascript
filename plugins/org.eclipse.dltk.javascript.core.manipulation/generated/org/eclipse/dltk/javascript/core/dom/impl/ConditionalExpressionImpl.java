/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConditionalExpressionImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.ConditionalExpression;
import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ConditionalExpressionImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ConditionalExpressionImpl#getConsequent <em>Consequent</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ConditionalExpressionImpl#getAlternative <em>Alternative</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalExpressionImpl extends ExpressionImpl implements ConditionalExpression {
	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected Expression predicate;

	/**
	 * The cached value of the '{@link #getConsequent() <em>Consequent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsequent()
	 * @generated
	 * @ordered
	 */
	protected Expression consequent;

	/**
	 * The cached value of the '{@link #getAlternative() <em>Alternative</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternative()
	 * @generated
	 * @ordered
	 */
	protected Expression alternative;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.CONDITIONAL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getPredicate() {
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredicate(Expression newPredicate, NotificationChain msgs) {
		Expression oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.CONDITIONAL_EXPRESSION__PREDICATE, oldPredicate, newPredicate);
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
	public void setPredicate(Expression newPredicate) {
		if (newPredicate != predicate) {
			NotificationChain msgs = null;
			if (predicate != null)
				msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.CONDITIONAL_EXPRESSION__PREDICATE, null, msgs);
			if (newPredicate != null)
				msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.CONDITIONAL_EXPRESSION__PREDICATE, null, msgs);
			msgs = basicSetPredicate(newPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.CONDITIONAL_EXPRESSION__PREDICATE, newPredicate, newPredicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getConsequent() {
		return consequent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsequent(Expression newConsequent, NotificationChain msgs) {
		Expression oldConsequent = consequent;
		consequent = newConsequent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.CONDITIONAL_EXPRESSION__CONSEQUENT, oldConsequent, newConsequent);
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
	public void setConsequent(Expression newConsequent) {
		if (newConsequent != consequent) {
			NotificationChain msgs = null;
			if (consequent != null)
				msgs = ((InternalEObject)consequent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.CONDITIONAL_EXPRESSION__CONSEQUENT, null, msgs);
			if (newConsequent != null)
				msgs = ((InternalEObject)newConsequent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.CONDITIONAL_EXPRESSION__CONSEQUENT, null, msgs);
			msgs = basicSetConsequent(newConsequent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.CONDITIONAL_EXPRESSION__CONSEQUENT, newConsequent, newConsequent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getAlternative() {
		return alternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlternative(Expression newAlternative, NotificationChain msgs) {
		Expression oldAlternative = alternative;
		alternative = newAlternative;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.CONDITIONAL_EXPRESSION__ALTERNATIVE, oldAlternative, newAlternative);
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
	public void setAlternative(Expression newAlternative) {
		if (newAlternative != alternative) {
			NotificationChain msgs = null;
			if (alternative != null)
				msgs = ((InternalEObject)alternative).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.CONDITIONAL_EXPRESSION__ALTERNATIVE, null, msgs);
			if (newAlternative != null)
				msgs = ((InternalEObject)newAlternative).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.CONDITIONAL_EXPRESSION__ALTERNATIVE, null, msgs);
			msgs = basicSetAlternative(newAlternative, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.CONDITIONAL_EXPRESSION__ALTERNATIVE, newAlternative, newAlternative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.CONDITIONAL_EXPRESSION__PREDICATE:
				return basicSetPredicate(null, msgs);
			case DomPackage.CONDITIONAL_EXPRESSION__CONSEQUENT:
				return basicSetConsequent(null, msgs);
			case DomPackage.CONDITIONAL_EXPRESSION__ALTERNATIVE:
				return basicSetAlternative(null, msgs);
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
			case DomPackage.CONDITIONAL_EXPRESSION__PREDICATE:
				return getPredicate();
			case DomPackage.CONDITIONAL_EXPRESSION__CONSEQUENT:
				return getConsequent();
			case DomPackage.CONDITIONAL_EXPRESSION__ALTERNATIVE:
				return getAlternative();
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
			case DomPackage.CONDITIONAL_EXPRESSION__PREDICATE:
				setPredicate((Expression)newValue);
				return;
			case DomPackage.CONDITIONAL_EXPRESSION__CONSEQUENT:
				setConsequent((Expression)newValue);
				return;
			case DomPackage.CONDITIONAL_EXPRESSION__ALTERNATIVE:
				setAlternative((Expression)newValue);
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
			case DomPackage.CONDITIONAL_EXPRESSION__PREDICATE:
				setPredicate((Expression)null);
				return;
			case DomPackage.CONDITIONAL_EXPRESSION__CONSEQUENT:
				setConsequent((Expression)null);
				return;
			case DomPackage.CONDITIONAL_EXPRESSION__ALTERNATIVE:
				setAlternative((Expression)null);
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
			case DomPackage.CONDITIONAL_EXPRESSION__PREDICATE:
				return predicate != null;
			case DomPackage.CONDITIONAL_EXPRESSION__CONSEQUENT:
				return consequent != null;
			case DomPackage.CONDITIONAL_EXPRESSION__ALTERNATIVE:
				return alternative != null;
		}
		return super.eIsSet(featureID);
	}

} //ConditionalExpressionImpl
