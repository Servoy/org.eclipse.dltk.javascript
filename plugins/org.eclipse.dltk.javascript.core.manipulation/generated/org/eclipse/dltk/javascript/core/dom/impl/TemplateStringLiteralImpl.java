/**
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import java.util.Collection;

import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.TemplateStringExpression;
import org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral;

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
 * An implementation of the model object '<em><b>Template String Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.TemplateStringLiteralImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.TemplateStringLiteralImpl#getTemplateExpressions <em>Template Expressions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateStringLiteralImpl extends ExpressionImpl implements TemplateStringLiteral {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTemplateExpressions() <em>Template Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateStringExpression> templateExpressions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateStringLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.TEMPLATE_STRING_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.TEMPLATE_STRING_LITERAL__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TemplateStringExpression> getTemplateExpressions() {
		if (templateExpressions == null) {
			templateExpressions = new EObjectContainmentEList<TemplateStringExpression>(TemplateStringExpression.class, this, DomPackage.TEMPLATE_STRING_LITERAL__TEMPLATE_EXPRESSIONS);
		}
		return templateExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.TEMPLATE_STRING_LITERAL__TEMPLATE_EXPRESSIONS:
				return ((InternalEList<?>)getTemplateExpressions()).basicRemove(otherEnd, msgs);
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
			case DomPackage.TEMPLATE_STRING_LITERAL__TEXT:
				return getText();
			case DomPackage.TEMPLATE_STRING_LITERAL__TEMPLATE_EXPRESSIONS:
				return getTemplateExpressions();
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
			case DomPackage.TEMPLATE_STRING_LITERAL__TEXT:
				setText((String)newValue);
				return;
			case DomPackage.TEMPLATE_STRING_LITERAL__TEMPLATE_EXPRESSIONS:
				getTemplateExpressions().clear();
				getTemplateExpressions().addAll((Collection<? extends TemplateStringExpression>)newValue);
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
			case DomPackage.TEMPLATE_STRING_LITERAL__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case DomPackage.TEMPLATE_STRING_LITERAL__TEMPLATE_EXPRESSIONS:
				getTemplateExpressions().clear();
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
			case DomPackage.TEMPLATE_STRING_LITERAL__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case DomPackage.TEMPLATE_STRING_LITERAL__TEMPLATE_EXPRESSIONS:
				return templateExpressions != null && !templateExpressions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

} //TemplateStringLiteralImpl
