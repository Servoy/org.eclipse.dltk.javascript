/**
 * <copyright>
 * </copyright>
 *
 * $Id: BinaryExpressionImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.BinaryExpression;
import org.eclipse.dltk.javascript.core.dom.BinaryOperator;
import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.BinaryExpressionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.BinaryExpressionImpl#getRight <em>Right</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.BinaryExpressionImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.BinaryExpressionImpl#getOperatorPosition <em>Operator Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryExpressionImpl extends ExpressionImpl implements BinaryExpression {
	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected Expression left;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected Expression right;

	/**
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final BinaryOperator OPERATION_EDEFAULT = BinaryOperator.MUL;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected BinaryOperator operation = OPERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatorPosition() <em>Operator Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int OPERATOR_POSITION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOperatorPosition() <em>Operator Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorPosition()
	 * @generated
	 * @ordered
	 */
	protected int operatorPosition = OPERATOR_POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.BINARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeft(Expression newLeft, NotificationChain msgs) {
		Expression oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.BINARY_EXPRESSION__LEFT, oldLeft, newLeft);
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
	public void setLeft(Expression newLeft) {
		if (newLeft != left) {
			NotificationChain msgs = null;
			if (left != null)
				msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.BINARY_EXPRESSION__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.BINARY_EXPRESSION__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.BINARY_EXPRESSION__LEFT, newLeft, newLeft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRight(Expression newRight, NotificationChain msgs) {
		Expression oldRight = right;
		right = newRight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.BINARY_EXPRESSION__RIGHT, oldRight, newRight);
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
	public void setRight(Expression newRight) {
		if (newRight != right) {
			NotificationChain msgs = null;
			if (right != null)
				msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.BINARY_EXPRESSION__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.BINARY_EXPRESSION__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.BINARY_EXPRESSION__RIGHT, newRight, newRight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BinaryOperator getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(BinaryOperator newOperation) {
		BinaryOperator oldOperation = operation;
		operation = newOperation == null ? OPERATION_EDEFAULT : newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.BINARY_EXPRESSION__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOperatorPosition() {
		return operatorPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperatorPosition(int newOperatorPosition) {
		int oldOperatorPosition = operatorPosition;
		operatorPosition = newOperatorPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.BINARY_EXPRESSION__OPERATOR_POSITION, oldOperatorPosition, operatorPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.BINARY_EXPRESSION__LEFT:
				return basicSetLeft(null, msgs);
			case DomPackage.BINARY_EXPRESSION__RIGHT:
				return basicSetRight(null, msgs);
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
			case DomPackage.BINARY_EXPRESSION__LEFT:
				return getLeft();
			case DomPackage.BINARY_EXPRESSION__RIGHT:
				return getRight();
			case DomPackage.BINARY_EXPRESSION__OPERATION:
				return getOperation();
			case DomPackage.BINARY_EXPRESSION__OPERATOR_POSITION:
				return getOperatorPosition();
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
			case DomPackage.BINARY_EXPRESSION__LEFT:
				setLeft((Expression)newValue);
				return;
			case DomPackage.BINARY_EXPRESSION__RIGHT:
				setRight((Expression)newValue);
				return;
			case DomPackage.BINARY_EXPRESSION__OPERATION:
				setOperation((BinaryOperator)newValue);
				return;
			case DomPackage.BINARY_EXPRESSION__OPERATOR_POSITION:
				setOperatorPosition((Integer)newValue);
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
			case DomPackage.BINARY_EXPRESSION__LEFT:
				setLeft((Expression)null);
				return;
			case DomPackage.BINARY_EXPRESSION__RIGHT:
				setRight((Expression)null);
				return;
			case DomPackage.BINARY_EXPRESSION__OPERATION:
				setOperation(OPERATION_EDEFAULT);
				return;
			case DomPackage.BINARY_EXPRESSION__OPERATOR_POSITION:
				setOperatorPosition(OPERATOR_POSITION_EDEFAULT);
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
			case DomPackage.BINARY_EXPRESSION__LEFT:
				return left != null;
			case DomPackage.BINARY_EXPRESSION__RIGHT:
				return right != null;
			case DomPackage.BINARY_EXPRESSION__OPERATION:
				return operation != OPERATION_EDEFAULT;
			case DomPackage.BINARY_EXPRESSION__OPERATOR_POSITION:
				return operatorPosition != OPERATOR_POSITION_EDEFAULT;
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
		result.append(" (operation: ");
		result.append(operation);
		result.append(", operatorPosition: ");
		result.append(operatorPosition);
		result.append(')');
		return result.toString();
	}

} //BinaryExpressionImpl
