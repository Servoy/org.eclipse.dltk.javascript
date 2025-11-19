/**
 * Copyright (c) 2010 xored software, Inc.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *
 * $Id: ParameterImpl.java,v 1.7 2011/08/03 08:48:03 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.typeinfo.model.impl;

import org.eclipse.dltk.javascript.typeinfo.TypeUtil;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.Parameter;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.dltk.javascript.typeinfo.model.SimpleType;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage;
import org.eclipse.dltk.javascript.typeinfo.model.TypedElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterImpl#getDirectType <em>Direct Type</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends MinimalEObjectImpl implements Parameter {
	/**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected static final String NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected String name = NAME_EDEFAULT;

	/**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected JSType type;

    /**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected static final ParameterKind KIND_EDEFAULT = ParameterKind.NORMAL;

	/**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected ParameterKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TypeInfoModelPackage.Literals.PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypeInfoModelPackage.PARAMETER__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public JSType getType() {
        return type;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetType(JSType newType, NotificationChain msgs) {
        JSType oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypeInfoModelPackage.PARAMETER__TYPE, oldType, newType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(JSType newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null)
                msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypeInfoModelPackage.PARAMETER__TYPE, null, msgs);
            if (newType != null)
                msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypeInfoModelPackage.PARAMETER__TYPE, null, msgs);
            msgs = basicSetType(newType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypeInfoModelPackage.PARAMETER__TYPE, newType, newType));
    }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
    public Type getDirectType() {
		return type instanceof SimpleType ? ((SimpleType) type).getTarget() : null;
    }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
    public void setDirectType(Type newDirectType) {
		setType(TypeUtil.ref(newDirectType));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ParameterKind getKind() {
        return kind;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setKind(ParameterKind newKind) {
        ParameterKind oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypeInfoModelPackage.PARAMETER__KIND, oldKind, kind));
    }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TypeInfoModelPackage.PARAMETER__DESCRIPTION, oldDescription,
					description));
	}

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TypeInfoModelPackage.PARAMETER__TYPE:
                return basicSetType(null, msgs);
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
            case TypeInfoModelPackage.PARAMETER__NAME:
                return getName();
            case TypeInfoModelPackage.PARAMETER__TYPE:
                return getType();
            case TypeInfoModelPackage.PARAMETER__DIRECT_TYPE:
                return getDirectType();
            case TypeInfoModelPackage.PARAMETER__KIND:
                return getKind();
			case TypeInfoModelPackage.PARAMETER__DESCRIPTION:
				return getDescription();
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
            case TypeInfoModelPackage.PARAMETER__NAME:
                setName((String)newValue);
                return;
            case TypeInfoModelPackage.PARAMETER__TYPE:
                setType((JSType)newValue);
                return;
            case TypeInfoModelPackage.PARAMETER__DIRECT_TYPE:
                setDirectType((Type)newValue);
                return;
            case TypeInfoModelPackage.PARAMETER__KIND:
                setKind((ParameterKind)newValue);
                return;
			case TypeInfoModelPackage.PARAMETER__DESCRIPTION:
				setDescription((String) newValue);
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
            case TypeInfoModelPackage.PARAMETER__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TypeInfoModelPackage.PARAMETER__TYPE:
                setType((JSType)null);
                return;
            case TypeInfoModelPackage.PARAMETER__DIRECT_TYPE:
                setDirectType((Type)null);
                return;
            case TypeInfoModelPackage.PARAMETER__KIND:
                setKind(KIND_EDEFAULT);
                return;
			case TypeInfoModelPackage.PARAMETER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
            case TypeInfoModelPackage.PARAMETER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TypeInfoModelPackage.PARAMETER__TYPE:
                return type != null;
            case TypeInfoModelPackage.PARAMETER__DIRECT_TYPE:
                return getDirectType() != null;
            case TypeInfoModelPackage.PARAMETER__KIND:
                return kind != KIND_EDEFAULT;
			case TypeInfoModelPackage.PARAMETER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == TypedElement.class) {
            switch (derivedFeatureID) {
                case TypeInfoModelPackage.PARAMETER__TYPE: return TypeInfoModelPackage.TYPED_ELEMENT__TYPE;
                case TypeInfoModelPackage.PARAMETER__DIRECT_TYPE: return TypeInfoModelPackage.TYPED_ELEMENT__DIRECT_TYPE;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == TypedElement.class) {
            switch (baseFeatureID) {
                case TypeInfoModelPackage.TYPED_ELEMENT__TYPE: return TypeInfoModelPackage.PARAMETER__TYPE;
                case TypeInfoModelPackage.TYPED_ELEMENT__DIRECT_TYPE: return TypeInfoModelPackage.PARAMETER__DIRECT_TYPE;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: "); //$NON-NLS-1$
        result.append(name);
        result.append(", kind: "); //$NON-NLS-1$
        result.append(kind);
        result.append(')');
        return result.toString();
    }

} //ParameterImpl
