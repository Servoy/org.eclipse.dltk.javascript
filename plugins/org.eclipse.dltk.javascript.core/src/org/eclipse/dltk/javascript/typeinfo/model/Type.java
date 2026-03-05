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
 * $Id: Type.java,v 1.18 2012/06/25 13:28:45 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.typeinfo.model;

import java.util.List;

import org.eclipse.dltk.annotations.Nullable;
import org.eclipse.dltk.javascript.typeinference.IAssignProtection;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.MemberPredicate;
import org.eclipse.dltk.javascript.typeinfo.MetaType;
import org.eclipse.dltk.javascript.typeinfo.RSimpleType;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getMembers <em>Members</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getSuperTypeExpr <em>Super Type Expr</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getStaticConstructor <em>Static Constructor</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getTraits <em>Traits</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getConstructors <em>Constructors</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#isInstantiable <em>Instantiable</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#isInheritConstructors <em>Inherit Constructors</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#isInheritStaticMembers <em>Inherit Static Members</em>}</li>
 *   <li>{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getMetaType <em>Meta Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType()
 * @model
 * @generated
 */
public interface Type extends Element {
	/**
     * Returns the value of the '<em><b>Members</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.dltk.javascript.typeinfo.model.Member}.
     * It is bidirectional and its opposite is '{@link org.eclipse.dltk.javascript.typeinfo.model.Member#getDeclaringType <em>Declaring Type</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Members</em>' containment reference list.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_Members()
     * @see org.eclipse.dltk.javascript.typeinfo.model.Member#getDeclaringType
     * @model opposite="declaringType" containment="true"
     * @generated
     */
	EList<Member> getMembers();

	/**
     * Returns the value of the '<em><b>Kind</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.dltk.javascript.typeinfo.model.TypeKind}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Kind</em>' attribute.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeKind
     * @see #setKind(TypeKind)
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_Kind()
     * @model
     * @generated
     */
	TypeKind getKind();

	/**
     * Sets the value of the '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getKind <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Kind</em>' attribute.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeKind
     * @see #getKind()
     * @generated
     */
	void setKind(TypeKind value);

    /**
     * Returns the value of the '<em><b>Super Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Super Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Super Type</em>' reference.
     * @see #setSuperType(Type)
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_SuperType()
     * @model resolveProxies="false" transient="true" volatile="true" derived="true"
     * @generated
     */
    Type getSuperType();

    /**
     * Sets the value of the '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getSuperType <em>Super Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Super Type</em>' reference.
     * @see #getSuperType()
     * @generated
     */
    void setSuperType(Type value);

    /**
     * Returns the value of the '<em><b>Super Type Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Super Type Expr</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Super Type Expr</em>' containment reference.
     * @see #setSuperTypeExpr(SimpleType)
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_SuperTypeExpr()
     * @model containment="true"
     * @generated
     */
    SimpleType getSuperTypeExpr();

    /**
     * Sets the value of the '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getSuperTypeExpr <em>Super Type Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Super Type Expr</em>' containment reference.
     * @see #getSuperTypeExpr()
     * @generated
     */
    void setSuperTypeExpr(SimpleType value);

    /**
     * Returns the value of the '<em><b>Static Constructor</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Static Constructor</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Static Constructor</em>' containment reference.
     * @see #setStaticConstructor(Constructor)
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_StaticConstructor()
     * @model containment="true"
     * @generated
     */
    Constructor getStaticConstructor();

    /**
     * Sets the value of the '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getStaticConstructor <em>Static Constructor</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Static Constructor</em>' containment reference.
     * @see #getStaticConstructor()
     * @generated
     */
    void setStaticConstructor(Constructor value);

    /**
     * Returns the value of the '<em><b>Traits</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.dltk.javascript.typeinfo.model.Type}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Traits</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Traits</em>' reference list.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_Traits()
     * @model
     * @generated
     */
    EList<Type> getTraits();

    /**
     * Returns the value of the '<em><b>Constructors</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.dltk.javascript.typeinfo.model.Constructor}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Constructors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Constructors</em>' containment reference list.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_Constructors()
     * @model containment="true"
     * @generated
     */
    EList<Constructor> getConstructors();

    /**
     * Returns the value of the '<em><b>Instantiable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instantiable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instantiable</em>' attribute.
     * @see #setInstantiable(boolean)
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_Instantiable()
     * @model default="true"
     * @generated
     */
    boolean isInstantiable();

    /**
     * Sets the value of the '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#isInstantiable <em>Instantiable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instantiable</em>' attribute.
     * @see #isInstantiable()
     * @generated
     */
    void setInstantiable(boolean value);

    /**
     * Returns the value of the '<em><b>Inherit Constructors</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inherit Constructors</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inherit Constructors</em>' attribute.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_InheritConstructors()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isInheritConstructors();

    /**
     * Returns the value of the '<em><b>Inherit Static Members</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inherit Static Members</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inherit Static Members</em>' attribute.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_InheritStaticMembers()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isInheritStaticMembers();

    /**
     * Returns the value of the '<em><b>Meta Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Meta Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Meta Type</em>' attribute.
     * @see #setMetaType(MetaType)
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#getType_MetaType()
     * @model dataType="org.eclipse.dltk.javascript.typeinfo.model.MetaType"
     * @generated
     */
    MetaType getMetaType();

    /**
     * Sets the value of the '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getMetaType <em>Meta Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Meta Type</em>' attribute.
     * @see #getMetaType()
     * @generated
     */
    void setMetaType(MetaType value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    boolean isProxy();

	MemberPredicate memberPredicateFor(IRType type, MemberPredicate predicate);

	/**
	 * Creates instance of this type as result of the <code>new</code> operator.
	 * 
	 * @param typeSystem
	 *            the context for the operation, possible <code>null</code>
	 */
	IRType createInstance(ITypeSystem typeSystem);

	/**
	 * Creates {@link IRType} instance for this type. Default implementation
	 * just instantiates {@link RSimpleType}.
	 */
	IRType toRType(ITypeSystem typeSystem);

	/**
	 * Returns array of additional type members, e.g. defined in partial types.
	 * Can return <code>null</code> if there are no additional members.
	 * 
	 * @param parameters
	 *            <code>null</code> for simple type usage, not <code>null</code>
	 *            for the parameterized usage.
	 * 
	 * @return
	 */
	Member[] getAdditionalMembers(@Nullable List<IRType> parameters);

	IAssignProtection getReadOnlyStatus(Property property);

	Member findDirectMember(String name);

	boolean hasPrototype();

	/**
	 * Returns the {@link Type} which members should be available via class
	 * reference of this type. Typically for JavaScript objects it is
	 * "Function".
	 */
	Type getPrototypeType();

	boolean isJavaKind();

} // Type
