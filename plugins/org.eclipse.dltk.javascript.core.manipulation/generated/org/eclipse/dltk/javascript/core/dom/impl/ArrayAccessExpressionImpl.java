/**
 * <copyright>
 * </copyright>
 *
 * $Id: ArrayAccessExpressionImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression;
import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Access Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ArrayAccessExpressionImpl#getArray <em>Array</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ArrayAccessExpressionImpl#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArrayAccessExpressionImpl extends ExpressionImpl implements ArrayAccessExpression {
	/**
	 * The cached value of the '{@link #getArray() <em>Array</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArray()
	 * @generated
	 * @ordered
	 */
	protected Expression array;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected Expression index;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.ARRAY_ACCESS_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getArray() {
		return array;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArray(Expression newArray, NotificationChain msgs) {
		Expression oldArray = array;
		array = newArray;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.ARRAY_ACCESS_EXPRESSION__ARRAY, oldArray, newArray);
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
	public void setArray(Expression newArray) {
		if (newArray != array) {
			NotificationChain msgs = null;
			if (array != null)
				msgs = ((InternalEObject)array).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.ARRAY_ACCESS_EXPRESSION__ARRAY, null, msgs);
			if (newArray != null)
				msgs = ((InternalEObject)newArray).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.ARRAY_ACCESS_EXPRESSION__ARRAY, null, msgs);
			msgs = basicSetArray(newArray, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.ARRAY_ACCESS_EXPRESSION__ARRAY, newArray, newArray));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIndex(Expression newIndex, NotificationChain msgs) {
		Expression oldIndex = index;
		index = newIndex;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.ARRAY_ACCESS_EXPRESSION__INDEX, oldIndex, newIndex);
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
	public void setIndex(Expression newIndex) {
		if (newIndex != index) {
			NotificationChain msgs = null;
			if (index != null)
				msgs = ((InternalEObject)index).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.ARRAY_ACCESS_EXPRESSION__INDEX, null, msgs);
			if (newIndex != null)
				msgs = ((InternalEObject)newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.ARRAY_ACCESS_EXPRESSION__INDEX, null, msgs);
			msgs = basicSetIndex(newIndex, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.ARRAY_ACCESS_EXPRESSION__INDEX, newIndex, newIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.ARRAY_ACCESS_EXPRESSION__ARRAY:
				return basicSetArray(null, msgs);
			case DomPackage.ARRAY_ACCESS_EXPRESSION__INDEX:
				return basicSetIndex(null, msgs);
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
			case DomPackage.ARRAY_ACCESS_EXPRESSION__ARRAY:
				return getArray();
			case DomPackage.ARRAY_ACCESS_EXPRESSION__INDEX:
				return getIndex();
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
			case DomPackage.ARRAY_ACCESS_EXPRESSION__ARRAY:
				setArray((Expression)newValue);
				return;
			case DomPackage.ARRAY_ACCESS_EXPRESSION__INDEX:
				setIndex((Expression)newValue);
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
			case DomPackage.ARRAY_ACCESS_EXPRESSION__ARRAY:
				setArray((Expression)null);
				return;
			case DomPackage.ARRAY_ACCESS_EXPRESSION__INDEX:
				setIndex((Expression)null);
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
			case DomPackage.ARRAY_ACCESS_EXPRESSION__ARRAY:
				return array != null;
			case DomPackage.ARRAY_ACCESS_EXPRESSION__INDEX:
				return index != null;
		}
		return super.eIsSet(featureID);
	}

} //ArrayAccessExpressionImpl
