/**
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Expression;
import org.eclipse.dltk.javascript.core.dom.TagFunction;
import org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.TagFunctionImpl#getTagFunction <em>Tag Function</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.TagFunctionImpl#getTemplateStringLiteral <em>Template String Literal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagFunctionImpl extends ExpressionImpl implements TagFunction {
	/**
	 * The cached value of the '{@link #getTagFunction() <em>Tag Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagFunction()
	 * @generated
	 * @ordered
	 */
	protected Expression tagFunction;

	/**
	 * The cached value of the '{@link #getTemplateStringLiteral() <em>Template String Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateStringLiteral()
	 * @generated
	 * @ordered
	 */
	protected TemplateStringLiteral templateStringLiteral;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TagFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.TAG_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getTagFunction() {
		return tagFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTagFunction(Expression newTagFunction, NotificationChain msgs) {
		Expression oldTagFunction = tagFunction;
		tagFunction = newTagFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.TAG_FUNCTION__TAG_FUNCTION, oldTagFunction, newTagFunction);
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
	public void setTagFunction(Expression newTagFunction) {
		if (newTagFunction != tagFunction) {
			NotificationChain msgs = null;
			if (tagFunction != null)
				msgs = ((InternalEObject)tagFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.TAG_FUNCTION__TAG_FUNCTION, null, msgs);
			if (newTagFunction != null)
				msgs = ((InternalEObject)newTagFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.TAG_FUNCTION__TAG_FUNCTION, null, msgs);
			msgs = basicSetTagFunction(newTagFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.TAG_FUNCTION__TAG_FUNCTION, newTagFunction, newTagFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateStringLiteral getTemplateStringLiteral() {
		if (templateStringLiteral != null && templateStringLiteral.eIsProxy()) {
			InternalEObject oldTemplateStringLiteral = (InternalEObject)templateStringLiteral;
			templateStringLiteral = (TemplateStringLiteral)eResolveProxy(oldTemplateStringLiteral);
			if (templateStringLiteral != oldTemplateStringLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomPackage.TAG_FUNCTION__TEMPLATE_STRING_LITERAL, oldTemplateStringLiteral, templateStringLiteral));
			}
		}
		return templateStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateStringLiteral basicGetTemplateStringLiteral() {
		return templateStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTemplateStringLiteral(TemplateStringLiteral newTemplateStringLiteral) {
		TemplateStringLiteral oldTemplateStringLiteral = templateStringLiteral;
		templateStringLiteral = newTemplateStringLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.TAG_FUNCTION__TEMPLATE_STRING_LITERAL, oldTemplateStringLiteral, templateStringLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.TAG_FUNCTION__TAG_FUNCTION:
				return basicSetTagFunction(null, msgs);
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
			case DomPackage.TAG_FUNCTION__TAG_FUNCTION:
				return getTagFunction();
			case DomPackage.TAG_FUNCTION__TEMPLATE_STRING_LITERAL:
				if (resolve) return getTemplateStringLiteral();
				return basicGetTemplateStringLiteral();
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
			case DomPackage.TAG_FUNCTION__TAG_FUNCTION:
				setTagFunction((Expression)newValue);
				return;
			case DomPackage.TAG_FUNCTION__TEMPLATE_STRING_LITERAL:
				setTemplateStringLiteral((TemplateStringLiteral)newValue);
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
			case DomPackage.TAG_FUNCTION__TAG_FUNCTION:
				setTagFunction((Expression)null);
				return;
			case DomPackage.TAG_FUNCTION__TEMPLATE_STRING_LITERAL:
				setTemplateStringLiteral((TemplateStringLiteral)null);
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
			case DomPackage.TAG_FUNCTION__TAG_FUNCTION:
				return tagFunction != null;
			case DomPackage.TAG_FUNCTION__TEMPLATE_STRING_LITERAL:
				return templateStringLiteral != null;
		}
		return super.eIsSet(featureID);
	}

} //TagFunctionImpl
