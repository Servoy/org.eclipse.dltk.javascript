/**
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.ComputedPropertyKey;
import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computed Property Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ComputedPropertyKeyImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.ComputedPropertyKeyImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputedPropertyKeyImpl extends PropertyAssignmentImpl implements ComputedPropertyKey {
	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' containment reference.
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected Expression key;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Expression value;

	/**
	 * @generated
	 */
	protected ComputedPropertyKeyImpl() {
		super();
	}

	/**
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.COMPUTED_PROPERTY_KEY;
	}

	/**
	 * @generated
	 */
	@Override
	public Expression getKey() {
		return key;
	}

	/**
	 * @generated
	 */
	public NotificationChain basicSetKey(Expression newKey, NotificationChain msgs) {
		Expression oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.COMPUTED_PROPERTY_KEY__KEY, oldKey, newKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * @generated
	 */
	@Override
	public void setKey(Expression newKey) {
		if (newKey != key) {
			NotificationChain msgs = null;
			if (key != null)
				msgs = ((InternalEObject)key).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.COMPUTED_PROPERTY_KEY__KEY, null, msgs);
			if (newKey != null)
				msgs = ((InternalEObject)newKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.COMPUTED_PROPERTY_KEY__KEY, null, msgs);
			msgs = basicSetKey(newKey, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.COMPUTED_PROPERTY_KEY__KEY, newKey, newKey));
	}

	/**
	 * @generated
	 */
	@Override
	public Expression getValue() {
		return value;
	}

	/**
	 * @generated
	 */
	public NotificationChain basicSetValue(Expression newValue, NotificationChain msgs) {
		Expression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.COMPUTED_PROPERTY_KEY__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * @generated
	 */
	@Override
	public void setValue(Expression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.COMPUTED_PROPERTY_KEY__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.COMPUTED_PROPERTY_KEY__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.COMPUTED_PROPERTY_KEY__VALUE, newValue, newValue));
	}

	/**
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.COMPUTED_PROPERTY_KEY__KEY:
				return basicSetKey(null, msgs);
			case DomPackage.COMPUTED_PROPERTY_KEY__VALUE:
				return basicSetValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomPackage.COMPUTED_PROPERTY_KEY__KEY:
				return getKey();
			case DomPackage.COMPUTED_PROPERTY_KEY__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DomPackage.COMPUTED_PROPERTY_KEY__KEY:
				setKey((Expression)newValue);
				return;
			case DomPackage.COMPUTED_PROPERTY_KEY__VALUE:
				setValue((Expression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DomPackage.COMPUTED_PROPERTY_KEY__KEY:
				setKey((Expression)null);
				return;
			case DomPackage.COMPUTED_PROPERTY_KEY__VALUE:
				setValue((Expression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DomPackage.COMPUTED_PROPERTY_KEY__KEY:
				return key != null;
			case DomPackage.COMPUTED_PROPERTY_KEY__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputedPropertyKeyImpl
