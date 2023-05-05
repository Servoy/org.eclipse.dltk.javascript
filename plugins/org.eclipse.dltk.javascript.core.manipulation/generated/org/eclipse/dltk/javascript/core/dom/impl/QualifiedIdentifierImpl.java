/**
 * <copyright>
 * </copyright>
 *
 * $Id: QualifiedIdentifierImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.IPropertySelector;
import org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector;
import org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.QualifiedIdentifierImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.QualifiedIdentifierImpl#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedIdentifierImpl extends PropertyIdentifierImpl implements QualifiedIdentifier {
	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected IPropertySelector namespace;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected IUnqualifiedSelector member;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualifiedIdentifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.QUALIFIED_IDENTIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IPropertySelector getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamespace(IPropertySelector newNamespace, NotificationChain msgs) {
		IPropertySelector oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.QUALIFIED_IDENTIFIER__NAMESPACE, oldNamespace, newNamespace);
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
	public void setNamespace(IPropertySelector newNamespace) {
		if (newNamespace != namespace) {
			NotificationChain msgs = null;
			if (namespace != null)
				msgs = ((InternalEObject)namespace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.QUALIFIED_IDENTIFIER__NAMESPACE, null, msgs);
			if (newNamespace != null)
				msgs = ((InternalEObject)newNamespace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.QUALIFIED_IDENTIFIER__NAMESPACE, null, msgs);
			msgs = basicSetNamespace(newNamespace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.QUALIFIED_IDENTIFIER__NAMESPACE, newNamespace, newNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IUnqualifiedSelector getMember() {
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMember(IUnqualifiedSelector newMember, NotificationChain msgs) {
		IUnqualifiedSelector oldMember = member;
		member = newMember;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.QUALIFIED_IDENTIFIER__MEMBER, oldMember, newMember);
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
	public void setMember(IUnqualifiedSelector newMember) {
		if (newMember != member) {
			NotificationChain msgs = null;
			if (member != null)
				msgs = ((InternalEObject)member).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.QUALIFIED_IDENTIFIER__MEMBER, null, msgs);
			if (newMember != null)
				msgs = ((InternalEObject)newMember).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.QUALIFIED_IDENTIFIER__MEMBER, null, msgs);
			msgs = basicSetMember(newMember, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.QUALIFIED_IDENTIFIER__MEMBER, newMember, newMember));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.QUALIFIED_IDENTIFIER__NAMESPACE:
				return basicSetNamespace(null, msgs);
			case DomPackage.QUALIFIED_IDENTIFIER__MEMBER:
				return basicSetMember(null, msgs);
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
			case DomPackage.QUALIFIED_IDENTIFIER__NAMESPACE:
				return getNamespace();
			case DomPackage.QUALIFIED_IDENTIFIER__MEMBER:
				return getMember();
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
			case DomPackage.QUALIFIED_IDENTIFIER__NAMESPACE:
				setNamespace((IPropertySelector)newValue);
				return;
			case DomPackage.QUALIFIED_IDENTIFIER__MEMBER:
				setMember((IUnqualifiedSelector)newValue);
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
			case DomPackage.QUALIFIED_IDENTIFIER__NAMESPACE:
				setNamespace((IPropertySelector)null);
				return;
			case DomPackage.QUALIFIED_IDENTIFIER__MEMBER:
				setMember((IUnqualifiedSelector)null);
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
			case DomPackage.QUALIFIED_IDENTIFIER__NAMESPACE:
				return namespace != null;
			case DomPackage.QUALIFIED_IDENTIFIER__MEMBER:
				return member != null;
		}
		return super.eIsSet(featureID);
	}

} //QualifiedIdentifierImpl
