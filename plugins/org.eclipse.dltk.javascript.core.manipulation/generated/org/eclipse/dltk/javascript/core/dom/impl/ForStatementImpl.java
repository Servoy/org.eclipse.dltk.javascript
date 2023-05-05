/**
 * <copyright>
 * </copyright>
 *
 * $Id: ForStatementImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Expression;
import org.eclipse.dltk.javascript.core.dom.ForStatement;
import org.eclipse.dltk.javascript.core.dom.IForInitializer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ForStatementImpl#getInitialization <em>Initialization</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ForStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ForStatementImpl#getIncrement <em>Increment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForStatementImpl extends IterationStatementImpl implements ForStatement {
	/**
	 * The cached value of the '{@link #getInitialization() <em>Initialization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialization()
	 * @generated
	 * @ordered
	 */
	protected IForInitializer initialization;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression condition;

	/**
	 * The cached value of the '{@link #getIncrement() <em>Increment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected Expression increment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.FOR_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IForInitializer getInitialization() {
		return initialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialization(IForInitializer newInitialization, NotificationChain msgs) {
		IForInitializer oldInitialization = initialization;
		initialization = newInitialization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.FOR_STATEMENT__INITIALIZATION, oldInitialization, newInitialization);
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
	public void setInitialization(IForInitializer newInitialization) {
		if (newInitialization != initialization) {
			NotificationChain msgs = null;
			if (initialization != null)
				msgs = ((InternalEObject)initialization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.FOR_STATEMENT__INITIALIZATION, null, msgs);
			if (newInitialization != null)
				msgs = ((InternalEObject)newInitialization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.FOR_STATEMENT__INITIALIZATION, null, msgs);
			msgs = basicSetInitialization(newInitialization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.FOR_STATEMENT__INITIALIZATION, newInitialization, newInitialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.FOR_STATEMENT__CONDITION, oldCondition, newCondition);
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
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.FOR_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.FOR_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.FOR_STATEMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getIncrement() {
		return increment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncrement(Expression newIncrement, NotificationChain msgs) {
		Expression oldIncrement = increment;
		increment = newIncrement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.FOR_STATEMENT__INCREMENT, oldIncrement, newIncrement);
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
	public void setIncrement(Expression newIncrement) {
		if (newIncrement != increment) {
			NotificationChain msgs = null;
			if (increment != null)
				msgs = ((InternalEObject)increment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.FOR_STATEMENT__INCREMENT, null, msgs);
			if (newIncrement != null)
				msgs = ((InternalEObject)newIncrement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.FOR_STATEMENT__INCREMENT, null, msgs);
			msgs = basicSetIncrement(newIncrement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.FOR_STATEMENT__INCREMENT, newIncrement, newIncrement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.FOR_STATEMENT__INITIALIZATION:
				return basicSetInitialization(null, msgs);
			case DomPackage.FOR_STATEMENT__CONDITION:
				return basicSetCondition(null, msgs);
			case DomPackage.FOR_STATEMENT__INCREMENT:
				return basicSetIncrement(null, msgs);
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
			case DomPackage.FOR_STATEMENT__INITIALIZATION:
				return getInitialization();
			case DomPackage.FOR_STATEMENT__CONDITION:
				return getCondition();
			case DomPackage.FOR_STATEMENT__INCREMENT:
				return getIncrement();
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
			case DomPackage.FOR_STATEMENT__INITIALIZATION:
				setInitialization((IForInitializer)newValue);
				return;
			case DomPackage.FOR_STATEMENT__CONDITION:
				setCondition((Expression)newValue);
				return;
			case DomPackage.FOR_STATEMENT__INCREMENT:
				setIncrement((Expression)newValue);
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
			case DomPackage.FOR_STATEMENT__INITIALIZATION:
				setInitialization((IForInitializer)null);
				return;
			case DomPackage.FOR_STATEMENT__CONDITION:
				setCondition((Expression)null);
				return;
			case DomPackage.FOR_STATEMENT__INCREMENT:
				setIncrement((Expression)null);
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
			case DomPackage.FOR_STATEMENT__INITIALIZATION:
				return initialization != null;
			case DomPackage.FOR_STATEMENT__CONDITION:
				return condition != null;
			case DomPackage.FOR_STATEMENT__INCREMENT:
				return increment != null;
		}
		return super.eIsSet(featureID);
	}

} //ForStatementImpl
