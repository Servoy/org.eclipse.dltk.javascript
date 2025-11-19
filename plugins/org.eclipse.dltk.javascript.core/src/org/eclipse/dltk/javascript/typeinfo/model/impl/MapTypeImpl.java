/**
 * Copyright (c) 2011 NumberFour AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 */
package org.eclipse.dltk.javascript.typeinfo.model.impl;

import java.util.Arrays;
import java.util.Collections;

import org.eclipse.dltk.javascript.core.Types;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.ITypeNames;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.RTypes;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.MapType;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.impl.MapTypeImpl#getKeyType <em>Key Type</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.impl.MapTypeImpl#getValueType <em>Value Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MapTypeImpl extends MinimalEObjectImpl implements MapType {
    /**
     * The cached value of the '{@link #getKeyType() <em>Key Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKeyType()
     * @generated
     * @ordered
     */
    protected JSType keyType;

    /**
     * The cached value of the '{@link #getValueType() <em>Value Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueType()
     * @generated
     * @ordered
     */
    protected JSType valueType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MapTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TypeInfoModelPackage.Literals.MAP_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JSType getKeyType() {
        return keyType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetKeyType(JSType newKeyType, NotificationChain msgs) {
        JSType oldKeyType = keyType;
        keyType = newKeyType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypeInfoModelPackage.MAP_TYPE__KEY_TYPE, oldKeyType, newKeyType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKeyType(JSType newKeyType) {
        if (newKeyType != keyType) {
            NotificationChain msgs = null;
            if (keyType != null)
                msgs = ((InternalEObject)keyType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypeInfoModelPackage.MAP_TYPE__KEY_TYPE, null, msgs);
            if (newKeyType != null)
                msgs = ((InternalEObject)newKeyType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypeInfoModelPackage.MAP_TYPE__KEY_TYPE, null, msgs);
            msgs = basicSetKeyType(newKeyType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypeInfoModelPackage.MAP_TYPE__KEY_TYPE, newKeyType, newKeyType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JSType getValueType() {
        return valueType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetValueType(JSType newValueType, NotificationChain msgs) {
        JSType oldValueType = valueType;
        valueType = newValueType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypeInfoModelPackage.MAP_TYPE__VALUE_TYPE, oldValueType, newValueType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValueType(JSType newValueType) {
        if (newValueType != valueType) {
            NotificationChain msgs = null;
            if (valueType != null)
                msgs = ((InternalEObject)valueType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypeInfoModelPackage.MAP_TYPE__VALUE_TYPE, null, msgs);
            if (newValueType != null)
                msgs = ((InternalEObject)newValueType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypeInfoModelPackage.MAP_TYPE__VALUE_TYPE, null, msgs);
            msgs = basicSetValueType(newValueType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypeInfoModelPackage.MAP_TYPE__VALUE_TYPE, newValueType, newValueType));
    }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
    public String getName() {
		// if the key type is set but it is a String then just default to
		// without it.
		if (valueType != null && keyType != null
				&& !keyType.getName().equals(ITypeNames.STRING)) {
			return ITypeNames.OBJECT + '<' + keyType.getName() + ','
					+ valueType.getName() + '>';
		}
		return valueType != null ? ITypeNames.OBJECT + '<'
				+ valueType.getName() + '>' : ITypeNames.OBJECT;
	}
    
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IRType toRType(ITypeSystem typeSystem) {
		IRType valueType = RTypes.create(typeSystem, getValueType());
		IRType keyType2 = RTypes.create(typeSystem, getKeyType());
		return RTypes.mapOf(keyType2,
				valueType,
				keyType != null
						? typeSystem.parameterize(Types.MAP,
								Arrays.asList(keyType2, valueType))
						: typeSystem.parameterize(Types.SET,
								Collections.singletonList(valueType)));
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TypeInfoModelPackage.MAP_TYPE__KEY_TYPE:
                return basicSetKeyType(null, msgs);
            case TypeInfoModelPackage.MAP_TYPE__VALUE_TYPE:
                return basicSetValueType(null, msgs);
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
            case TypeInfoModelPackage.MAP_TYPE__KEY_TYPE:
                return getKeyType();
            case TypeInfoModelPackage.MAP_TYPE__VALUE_TYPE:
                return getValueType();
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
            case TypeInfoModelPackage.MAP_TYPE__KEY_TYPE:
                setKeyType((JSType)newValue);
                return;
            case TypeInfoModelPackage.MAP_TYPE__VALUE_TYPE:
                setValueType((JSType)newValue);
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
            case TypeInfoModelPackage.MAP_TYPE__KEY_TYPE:
                setKeyType((JSType)null);
                return;
            case TypeInfoModelPackage.MAP_TYPE__VALUE_TYPE:
                setValueType((JSType)null);
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
            case TypeInfoModelPackage.MAP_TYPE__KEY_TYPE:
                return keyType != null;
            case TypeInfoModelPackage.MAP_TYPE__VALUE_TYPE:
                return valueType != null;
        }
        return super.eIsSet(featureID);
    }

} //MapTypeImpl
