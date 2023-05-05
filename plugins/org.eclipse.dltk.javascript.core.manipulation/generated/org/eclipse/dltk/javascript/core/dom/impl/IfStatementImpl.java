/**
 * <copyright>
 * </copyright>
 *
 * $Id: IfStatementImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Expression;
import org.eclipse.dltk.javascript.core.dom.IfStatement;
import org.eclipse.dltk.javascript.core.dom.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.IfStatementImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.IfStatementImpl#getConsequent <em>Consequent</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.IfStatementImpl#getAlternative <em>Alternative</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends StatementImpl implements IfStatement {
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
	protected Statement consequent;

	/**
	 * The cached value of the '{@link #getAlternative() <em>Alternative</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternative()
	 * @generated
	 * @ordered
	 */
	protected Statement alternative;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.IF_STATEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.IF_STATEMENT__PREDICATE, oldPredicate, newPredicate);
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
				msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.IF_STATEMENT__PREDICATE, null, msgs);
			if (newPredicate != null)
				msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.IF_STATEMENT__PREDICATE, null, msgs);
			msgs = basicSetPredicate(newPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.IF_STATEMENT__PREDICATE, newPredicate, newPredicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Statement getConsequent() {
		return consequent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsequent(Statement newConsequent, NotificationChain msgs) {
		Statement oldConsequent = consequent;
		consequent = newConsequent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.IF_STATEMENT__CONSEQUENT, oldConsequent, newConsequent);
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
	public void setConsequent(Statement newConsequent) {
		if (newConsequent != consequent) {
			NotificationChain msgs = null;
			if (consequent != null)
				msgs = ((InternalEObject)consequent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.IF_STATEMENT__CONSEQUENT, null, msgs);
			if (newConsequent != null)
				msgs = ((InternalEObject)newConsequent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.IF_STATEMENT__CONSEQUENT, null, msgs);
			msgs = basicSetConsequent(newConsequent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.IF_STATEMENT__CONSEQUENT, newConsequent, newConsequent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Statement getAlternative() {
		return alternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlternative(Statement newAlternative, NotificationChain msgs) {
		Statement oldAlternative = alternative;
		alternative = newAlternative;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.IF_STATEMENT__ALTERNATIVE, oldAlternative, newAlternative);
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
	public void setAlternative(Statement newAlternative) {
		if (newAlternative != alternative) {
			NotificationChain msgs = null;
			if (alternative != null)
				msgs = ((InternalEObject)alternative).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.IF_STATEMENT__ALTERNATIVE, null, msgs);
			if (newAlternative != null)
				msgs = ((InternalEObject)newAlternative).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.IF_STATEMENT__ALTERNATIVE, null, msgs);
			msgs = basicSetAlternative(newAlternative, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.IF_STATEMENT__ALTERNATIVE, newAlternative, newAlternative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.IF_STATEMENT__PREDICATE:
				return basicSetPredicate(null, msgs);
			case DomPackage.IF_STATEMENT__CONSEQUENT:
				return basicSetConsequent(null, msgs);
			case DomPackage.IF_STATEMENT__ALTERNATIVE:
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
			case DomPackage.IF_STATEMENT__PREDICATE:
				return getPredicate();
			case DomPackage.IF_STATEMENT__CONSEQUENT:
				return getConsequent();
			case DomPackage.IF_STATEMENT__ALTERNATIVE:
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
			case DomPackage.IF_STATEMENT__PREDICATE:
				setPredicate((Expression)newValue);
				return;
			case DomPackage.IF_STATEMENT__CONSEQUENT:
				setConsequent((Statement)newValue);
				return;
			case DomPackage.IF_STATEMENT__ALTERNATIVE:
				setAlternative((Statement)newValue);
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
			case DomPackage.IF_STATEMENT__PREDICATE:
				setPredicate((Expression)null);
				return;
			case DomPackage.IF_STATEMENT__CONSEQUENT:
				setConsequent((Statement)null);
				return;
			case DomPackage.IF_STATEMENT__ALTERNATIVE:
				setAlternative((Statement)null);
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
			case DomPackage.IF_STATEMENT__PREDICATE:
				return predicate != null;
			case DomPackage.IF_STATEMENT__CONSEQUENT:
				return consequent != null;
			case DomPackage.IF_STATEMENT__ALTERNATIVE:
				return alternative != null;
		}
		return super.eIsSet(featureID);
	}

} //IfStatementImpl
