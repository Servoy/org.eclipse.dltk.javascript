/**
 * <copyright>
 * </copyright>
 *
 * $Id: TryStatementImpl.java,v 1.3 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import java.util.Collection;

import org.eclipse.dltk.javascript.core.dom.BlockStatement;
import org.eclipse.dltk.javascript.core.dom.CatchClause;
import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.FinallyClause;
import org.eclipse.dltk.javascript.core.dom.TryStatement;

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
 * An implementation of the model object '<em><b>Try Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.TryStatementImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.TryStatementImpl#getCatches <em>Catches</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.core.dom.impl.TryStatementImpl#getFinallyClause <em>Finally Clause</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TryStatementImpl extends StatementImpl implements TryStatement {
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected BlockStatement body;

	/**
	 * The cached value of the '{@link #getCatches() <em>Catches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatches()
	 * @generated
	 * @ordered
	 */
	protected EList<CatchClause> catches;

	/**
	 * The cached value of the '{@link #getFinallyClause() <em>Finally Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinallyClause()
	 * @generated
	 * @ordered
	 */
	protected FinallyClause finallyClause;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TryStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.TRY_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockStatement getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(BlockStatement newBody, NotificationChain msgs) {
		BlockStatement oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.TRY_STATEMENT__BODY, oldBody, newBody);
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
	public void setBody(BlockStatement newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.TRY_STATEMENT__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.TRY_STATEMENT__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.TRY_STATEMENT__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CatchClause> getCatches() {
		if (catches == null) {
			catches = new EObjectContainmentEList<CatchClause>(CatchClause.class, this, DomPackage.TRY_STATEMENT__CATCHES);
		}
		return catches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FinallyClause getFinallyClause() {
		return finallyClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinallyClause(FinallyClause newFinallyClause, NotificationChain msgs) {
		FinallyClause oldFinallyClause = finallyClause;
		finallyClause = newFinallyClause;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomPackage.TRY_STATEMENT__FINALLY_CLAUSE, oldFinallyClause, newFinallyClause);
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
	public void setFinallyClause(FinallyClause newFinallyClause) {
		if (newFinallyClause != finallyClause) {
			NotificationChain msgs = null;
			if (finallyClause != null)
				msgs = ((InternalEObject)finallyClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomPackage.TRY_STATEMENT__FINALLY_CLAUSE, null, msgs);
			if (newFinallyClause != null)
				msgs = ((InternalEObject)newFinallyClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomPackage.TRY_STATEMENT__FINALLY_CLAUSE, null, msgs);
			msgs = basicSetFinallyClause(newFinallyClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomPackage.TRY_STATEMENT__FINALLY_CLAUSE, newFinallyClause, newFinallyClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomPackage.TRY_STATEMENT__BODY:
				return basicSetBody(null, msgs);
			case DomPackage.TRY_STATEMENT__CATCHES:
				return ((InternalEList<?>)getCatches()).basicRemove(otherEnd, msgs);
			case DomPackage.TRY_STATEMENT__FINALLY_CLAUSE:
				return basicSetFinallyClause(null, msgs);
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
			case DomPackage.TRY_STATEMENT__BODY:
				return getBody();
			case DomPackage.TRY_STATEMENT__CATCHES:
				return getCatches();
			case DomPackage.TRY_STATEMENT__FINALLY_CLAUSE:
				return getFinallyClause();
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
			case DomPackage.TRY_STATEMENT__BODY:
				setBody((BlockStatement)newValue);
				return;
			case DomPackage.TRY_STATEMENT__CATCHES:
				getCatches().clear();
				getCatches().addAll((Collection<? extends CatchClause>)newValue);
				return;
			case DomPackage.TRY_STATEMENT__FINALLY_CLAUSE:
				setFinallyClause((FinallyClause)newValue);
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
			case DomPackage.TRY_STATEMENT__BODY:
				setBody((BlockStatement)null);
				return;
			case DomPackage.TRY_STATEMENT__CATCHES:
				getCatches().clear();
				return;
			case DomPackage.TRY_STATEMENT__FINALLY_CLAUSE:
				setFinallyClause((FinallyClause)null);
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
			case DomPackage.TRY_STATEMENT__BODY:
				return body != null;
			case DomPackage.TRY_STATEMENT__CATCHES:
				return catches != null && !catches.isEmpty();
			case DomPackage.TRY_STATEMENT__FINALLY_CLAUSE:
				return finallyClause != null;
		}
		return super.eIsSet(featureID);
	}

} //TryStatementImpl
