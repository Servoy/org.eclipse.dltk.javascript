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
 * $Id: TypeInfoModelPackage.java,v 1.41 2012/06/12 10:40:32 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.typeinfo.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelFactory
 * @model kind="package"
 * @generated
 */
public interface TypeInfoModelPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "model"; //$NON-NLS-1$

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://www.eclipse.org/dltk/javascript/typeinfo.ecore"; //$NON-NLS-1$

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "ti"; //$NON-NLS-1$

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TypeInfoModelPackage eINSTANCE = org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl.init();

	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.NamedElement <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.NamedElement
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getNamedElement()
     * @generated
     */
    int NAMED_ELEMENT = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT__NAME = 0;

    /**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.TypedElement <em>Typed Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypedElement
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypedElement()
     * @generated
     */
    int TYPED_ELEMENT = 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPED_ELEMENT__TYPE = 0;

    /**
     * The feature id for the '<em><b>Direct Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPED_ELEMENT__DIRECT_TYPE = 1;

    /**
     * The number of structural features of the '<em>Typed Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPED_ELEMENT_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.JSType <em>JS Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.JSType
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getJSType()
     * @generated
     */
    int JS_TYPE = 11;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ElementImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getElement()
     * @generated
     */
	int ELEMENT = 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT__DEPRECATED = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT__VISIBLE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT__HIDE_ALLOWED = NAMED_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getType()
     * @generated
     */
	int TYPE = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE__NAME = ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE__DEPRECATED = ELEMENT__DEPRECATED;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE__DESCRIPTION = ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE__VISIBLE = ELEMENT__VISIBLE;

	/**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE__ATTRIBUTES = ELEMENT__ATTRIBUTES;

	/**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__HIDE_ALLOWED = ELEMENT__HIDE_ALLOWED;

    /**
     * The feature id for the '<em><b>Members</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE__MEMBERS = ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE__KIND = ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Super Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__SUPER_TYPE = ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Super Type Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__SUPER_TYPE_EXPR = ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Static Constructor</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__STATIC_CONSTRUCTOR = ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Traits</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__TRAITS = ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Constructors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__CONSTRUCTORS = ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Instantiable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__INSTANTIABLE = ELEMENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Inherit Constructors</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__INHERIT_CONSTRUCTORS = ELEMENT_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Inherit Static Members</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__INHERIT_STATIC_MEMBERS = ELEMENT_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Meta Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__META_TYPE = ELEMENT_FEATURE_COUNT + 10;

    /**
     * The number of structural features of the '<em>Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 11;

	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeAliasImpl <em>Type Alias</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeAliasImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeAlias()
     * @generated
     */
    int TYPE_ALIAS = 4;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.MemberImpl <em>Member</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.MemberImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getMember()
     * @generated
     */
	int MEMBER = 5;

	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.MethodImpl <em>Method</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.MethodImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getMethod()
     * @generated
     */
	int METHOD = 6;

	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ConstructorImpl <em>Constructor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ConstructorImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getConstructor()
     * @generated
     */
    int CONSTRUCTOR = 8;

    /**
     * The feature id for the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ALIAS__SOURCE = 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ALIAS__TARGET = 1;

    /**
     * The number of structural features of the '<em>Type Alias</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_ALIAS_FEATURE_COUNT = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEMBER__NAME = ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEMBER__DEPRECATED = ELEMENT__DEPRECATED;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEMBER__DESCRIPTION = ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEMBER__VISIBLE = ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEMBER__ATTRIBUTES = ELEMENT__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MEMBER__HIDE_ALLOWED = ELEMENT__HIDE_ALLOWED;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEMBER__TYPE = ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Direct Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MEMBER__DIRECT_TYPE = ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Static</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEMBER__STATIC = ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEMBER__DECLARING_TYPE = ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MEMBER__VISIBILITY = ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Member</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEMBER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD__NAME = MEMBER__NAME;

    /**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD__DEPRECATED = MEMBER__DEPRECATED;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD__DESCRIPTION = MEMBER__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD__VISIBLE = MEMBER__VISIBLE;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD__ATTRIBUTES = MEMBER__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METHOD__HIDE_ALLOWED = MEMBER__HIDE_ALLOWED;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD__TYPE = MEMBER__TYPE;

    /**
     * The feature id for the '<em><b>Direct Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METHOD__DIRECT_TYPE = MEMBER__DIRECT_TYPE;

    /**
     * The feature id for the '<em><b>Static</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD__STATIC = MEMBER__STATIC;

    /**
     * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD__DECLARING_TYPE = MEMBER__DECLARING_TYPE;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METHOD__VISIBILITY = MEMBER__VISIBILITY;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD__PARAMETERS = MEMBER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int METHOD__ABSTRACT = MEMBER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Method</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getParameter()
     * @generated
     */
	int PARAMETER = 7;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER__NAME = NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Direct Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER__DIRECT_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER__KIND = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Parameter</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__NAME = METHOD__NAME;

    /**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__DEPRECATED = METHOD__DEPRECATED;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__DESCRIPTION = METHOD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__VISIBLE = METHOD__VISIBLE;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__ATTRIBUTES = METHOD__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__HIDE_ALLOWED = METHOD__HIDE_ALLOWED;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__TYPE = METHOD__TYPE;

    /**
     * The feature id for the '<em><b>Direct Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__DIRECT_TYPE = METHOD__DIRECT_TYPE;

    /**
     * The feature id for the '<em><b>Static</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__STATIC = METHOD__STATIC;

    /**
     * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__DECLARING_TYPE = METHOD__DECLARING_TYPE;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__VISIBILITY = METHOD__VISIBILITY;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__PARAMETERS = METHOD__PARAMETERS;

    /**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR__ABSTRACT = METHOD__ABSTRACT;

    /**
     * The number of structural features of the '<em>Constructor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTRUCTOR_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.PropertyImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getProperty()
     * @generated
     */
	int PROPERTY = 9;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY__NAME = MEMBER__NAME;

	/**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY__DEPRECATED = MEMBER__DEPRECATED;

	/**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY__DESCRIPTION = MEMBER__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY__VISIBLE = MEMBER__VISIBLE;

	/**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY__ATTRIBUTES = MEMBER__ATTRIBUTES;

	/**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__HIDE_ALLOWED = MEMBER__HIDE_ALLOWED;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY__TYPE = MEMBER__TYPE;

	/**
     * The feature id for the '<em><b>Direct Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__DIRECT_TYPE = MEMBER__DIRECT_TYPE;

    /**
     * The feature id for the '<em><b>Static</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY__STATIC = MEMBER__STATIC;

	/**
     * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY__DECLARING_TYPE = MEMBER__DECLARING_TYPE;

	/**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__VISIBILITY = MEMBER__VISIBILITY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY__READ_ONLY = MEMBER_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Property</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 1;


	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.AttributeEntryImpl <em>Attribute Entry</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.AttributeEntryImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getAttributeEntry()
     * @generated
     */
	int ATTRIBUTE_ENTRY = 10;

	/**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_ENTRY__KEY = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_ENTRY__VALUE = 1;

	/**
     * The number of structural features of the '<em>Attribute Entry</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_ENTRY_FEATURE_COUNT = 2;

    /**
     * The number of structural features of the '<em>JS Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JS_TYPE_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.FunctionTypeImpl <em>Function Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.FunctionTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getFunctionType()
     * @generated
     */
    int FUNCTION_TYPE = 12;

    /**
     * The feature id for the '<em><b>Return Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FUNCTION_TYPE__RETURN_TYPE = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FUNCTION_TYPE__PARAMETERS = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Function Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FUNCTION_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.SimpleTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getSimpleType()
     * @generated
     */
    int SIMPLE_TYPE = 13;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TYPE__TARGET = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Simple Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ArrayTypeImpl <em>Array Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ArrayTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getArrayType()
     * @generated
     */
    int ARRAY_TYPE = 14;

    /**
     * The feature id for the '<em><b>Item Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARRAY_TYPE__ITEM_TYPE = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Array Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARRAY_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.AnyTypeImpl <em>Any Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.AnyTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getAnyType()
     * @generated
     */
    int ANY_TYPE = 15;

    /**
     * The number of structural features of the '<em>Any Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.UnionTypeImpl <em>Union Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.UnionTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getUnionType()
     * @generated
     */
    int UNION_TYPE = 16;

    /**
     * The feature id for the '<em><b>Targets</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNION_TYPE__TARGETS = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Union Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNION_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterizedTypeImpl <em>Parameterized Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterizedTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getParameterizedType()
     * @generated
     */
    int PARAMETERIZED_TYPE = 17;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETERIZED_TYPE__TARGET = SIMPLE_TYPE__TARGET;

    /**
     * The feature id for the '<em><b>Actual Type Arguments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETERIZED_TYPE__ACTUAL_TYPE_ARGUMENTS = SIMPLE_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Parameterized Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETERIZED_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.GenericTypeImpl <em>Generic Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.GenericTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getGenericType()
     * @generated
     */
    int GENERIC_TYPE = 25;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.MapTypeImpl <em>Map Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.MapTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getMapType()
     * @generated
     */
    int MAP_TYPE = 18;

    /**
     * The feature id for the '<em><b>Key Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAP_TYPE__KEY_TYPE = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Value Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAP_TYPE__VALUE_TYPE = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Map Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAP_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.RecordTypeImpl <em>Record Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.RecordTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getRecordType()
     * @generated
     */
    int RECORD_TYPE = 19;

    /**
     * The feature id for the '<em><b>Members</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_TYPE__MEMBERS = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_TYPE__TYPE_NAME = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Record Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.RecordMember <em>Record Member</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.RecordMember
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getRecordMember()
     * @generated
     */
    int RECORD_MEMBER = 20;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__NAME = MEMBER__NAME;

    /**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__DEPRECATED = MEMBER__DEPRECATED;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__DESCRIPTION = MEMBER__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__VISIBLE = MEMBER__VISIBLE;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__ATTRIBUTES = MEMBER__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__HIDE_ALLOWED = MEMBER__HIDE_ALLOWED;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__TYPE = MEMBER__TYPE;

    /**
     * The feature id for the '<em><b>Direct Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__DIRECT_TYPE = MEMBER__DIRECT_TYPE;

    /**
     * The feature id for the '<em><b>Static</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__STATIC = MEMBER__STATIC;

    /**
     * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__DECLARING_TYPE = MEMBER__DECLARING_TYPE;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__VISIBILITY = MEMBER__VISIBILITY;

    /**
     * The feature id for the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER__OPTIONAL = MEMBER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Record Member</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_MEMBER_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.RecordPropertyImpl <em>Record Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.RecordPropertyImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getRecordProperty()
     * @generated
     */
    int RECORD_PROPERTY = 21;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__NAME = PROPERTY__NAME;

    /**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__DEPRECATED = PROPERTY__DEPRECATED;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__DESCRIPTION = PROPERTY__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__VISIBLE = PROPERTY__VISIBLE;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__ATTRIBUTES = PROPERTY__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__HIDE_ALLOWED = PROPERTY__HIDE_ALLOWED;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__TYPE = PROPERTY__TYPE;

    /**
     * The feature id for the '<em><b>Direct Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__DIRECT_TYPE = PROPERTY__DIRECT_TYPE;

    /**
     * The feature id for the '<em><b>Static</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__STATIC = PROPERTY__STATIC;

    /**
     * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__DECLARING_TYPE = PROPERTY__DECLARING_TYPE;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__VISIBILITY = PROPERTY__VISIBILITY;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__READ_ONLY = PROPERTY__READ_ONLY;

    /**
     * The feature id for the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY__OPTIONAL = PROPERTY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Record Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECORD_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ClassTypeImpl <em>Class Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ClassTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getClassType()
     * @generated
     */
    int CLASS_TYPE = 22;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLASS_TYPE__TARGET = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Class Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLASS_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.UndefinedTypeImpl <em>Undefined Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.UndefinedTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getUndefinedType()
     * @generated
     */
    int UNDEFINED_TYPE = 23;

    /**
     * The number of structural features of the '<em>Undefined Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNDEFINED_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableImpl <em>Type Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeVariable()
     * @generated
     */
    int TYPE_VARIABLE = 24;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_VARIABLE__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Bound</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_VARIABLE__BOUND = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Variable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__NAME = TYPE__NAME;

    /**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__DEPRECATED = TYPE__DEPRECATED;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__VISIBLE = TYPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__ATTRIBUTES = TYPE__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__HIDE_ALLOWED = TYPE__HIDE_ALLOWED;

    /**
     * The feature id for the '<em><b>Members</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__MEMBERS = TYPE__MEMBERS;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__KIND = TYPE__KIND;

    /**
     * The feature id for the '<em><b>Super Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__SUPER_TYPE = TYPE__SUPER_TYPE;

    /**
     * The feature id for the '<em><b>Super Type Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__SUPER_TYPE_EXPR = TYPE__SUPER_TYPE_EXPR;

    /**
     * The feature id for the '<em><b>Static Constructor</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__STATIC_CONSTRUCTOR = TYPE__STATIC_CONSTRUCTOR;

    /**
     * The feature id for the '<em><b>Traits</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__TRAITS = TYPE__TRAITS;

    /**
     * The feature id for the '<em><b>Constructors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__CONSTRUCTORS = TYPE__CONSTRUCTORS;

    /**
     * The feature id for the '<em><b>Instantiable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__INSTANTIABLE = TYPE__INSTANTIABLE;

    /**
     * The feature id for the '<em><b>Inherit Constructors</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__INHERIT_CONSTRUCTORS = TYPE__INHERIT_CONSTRUCTORS;

    /**
     * The feature id for the '<em><b>Inherit Static Members</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__INHERIT_STATIC_MEMBERS = TYPE__INHERIT_STATIC_MEMBERS;

    /**
     * The feature id for the '<em><b>Meta Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__META_TYPE = TYPE__META_TYPE;

    /**
     * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE__TYPE_PARAMETERS = TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Generic Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableReferenceImpl <em>Type Variable Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableReferenceImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeVariableReference()
     * @generated
     */
    int TYPE_VARIABLE_REFERENCE = 26;

    /**
     * The feature id for the '<em><b>Variable</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_VARIABLE_REFERENCE__VARIABLE = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Variable Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_VARIABLE_REFERENCE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.RTypeImpl <em>RType</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.RTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getRType()
     * @generated
     */
    int RTYPE = 27;

    /**
     * The feature id for the '<em><b>Runtime Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RTYPE__RUNTIME_TYPE = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>RType</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RTYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.GenericMethodImpl <em>Generic Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.GenericMethodImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getGenericMethod()
     * @generated
     */
    int GENERIC_METHOD = 28;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__NAME = METHOD__NAME;

    /**
     * The feature id for the '<em><b>Deprecated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__DEPRECATED = METHOD__DEPRECATED;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__DESCRIPTION = METHOD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__VISIBLE = METHOD__VISIBLE;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__ATTRIBUTES = METHOD__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Hide Allowed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__HIDE_ALLOWED = METHOD__HIDE_ALLOWED;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__TYPE = METHOD__TYPE;

    /**
     * The feature id for the '<em><b>Direct Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__DIRECT_TYPE = METHOD__DIRECT_TYPE;

    /**
     * The feature id for the '<em><b>Static</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__STATIC = METHOD__STATIC;

    /**
     * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__DECLARING_TYPE = METHOD__DECLARING_TYPE;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__VISIBILITY = METHOD__VISIBILITY;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__PARAMETERS = METHOD__PARAMETERS;

    /**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__ABSTRACT = METHOD__ABSTRACT;

    /**
     * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD__TYPE_PARAMETERS = METHOD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Generic Method</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_METHOD_FEATURE_COUNT = METHOD_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeLiteralImpl <em>Type Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeLiteralImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeLiteral()
     * @generated
     */
    int TYPE_LITERAL = 29;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LITERAL__NAME = 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LITERAL__TARGET = 1;

    /**
     * The number of structural features of the '<em>Type Literal</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_LITERAL_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableClassTypeImpl <em>Type Variable Class Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableClassTypeImpl
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeVariableClassType()
     * @generated
     */
    int TYPE_VARIABLE_CLASS_TYPE = 30;

    /**
     * The feature id for the '<em><b>Variable</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_VARIABLE_CLASS_TYPE__VARIABLE = JS_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Variable Class Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_VARIABLE_CLASS_TYPE_FEATURE_COUNT = JS_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeKind <em>Type Kind</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeKind
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeKind()
     * @generated
     */
	int TYPE_KIND = 31;


	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.ParameterKind <em>Parameter Kind</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.ParameterKind
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getParameterKind()
     * @generated
     */
	int PARAMETER_KIND = 32;


	/**
     * The meta object id for the '{@link org.eclipse.dltk.javascript.typeinfo.model.Visibility <em>Visibility</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.model.Visibility
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getVisibility()
     * @generated
     */
    int VISIBILITY = 33;


    /**
     * The meta object id for the '<em>IR Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.IRType
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getIRType()
     * @generated
     */
    int IR_TYPE = 34;


    /**
     * The meta object id for the '<em>Meta Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.MetaType
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getMetaType()
     * @generated
     */
    int META_TYPE = 35;


    /**
     * The meta object id for the '<em>IType System</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.dltk.javascript.typeinfo.ITypeSystem
     * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getITypeSystem()
     * @generated
     */
    int ITYPE_SYSTEM = 36;


    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.NamedElement
     * @generated
     */
    EClass getNamedElement();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
    EAttribute getNamedElement_Name();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.TypedElement <em>Typed Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Typed Element</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypedElement
     * @generated
     */
    EClass getTypedElement();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.typeinfo.model.TypedElement#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypedElement#getType()
     * @see #getTypedElement()
     * @generated
     */
    EReference getTypedElement_Type();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.typeinfo.model.TypedElement#getDirectType <em>Direct Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Direct Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypedElement#getDirectType()
     * @see #getTypedElement()
     * @generated
     */
    EReference getTypedElement_DirectType();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.JSType <em>JS Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>JS Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.JSType
     * @generated
     */
    EClass getJSType();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.FunctionType <em>Function Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Function Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.FunctionType
     * @generated
     */
    EClass getFunctionType();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.typeinfo.model.FunctionType#getReturnType <em>Return Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Return Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.FunctionType#getReturnType()
     * @see #getFunctionType()
     * @generated
     */
    EReference getFunctionType_ReturnType();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.FunctionType#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.FunctionType#getParameters()
     * @see #getFunctionType()
     * @generated
     */
    EReference getFunctionType_Parameters();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.SimpleType <em>Simple Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.SimpleType
     * @generated
     */
    EClass getSimpleType();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.typeinfo.model.SimpleType#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.SimpleType#getTarget()
     * @see #getSimpleType()
     * @generated
     */
    EReference getSimpleType_Target();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.ArrayType <em>Array Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Array Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.ArrayType
     * @generated
     */
    EClass getArrayType();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.typeinfo.model.ArrayType#getItemType <em>Item Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Item Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.ArrayType#getItemType()
     * @see #getArrayType()
     * @generated
     */
    EReference getArrayType_ItemType();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.AnyType <em>Any Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Any Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.AnyType
     * @generated
     */
    EClass getAnyType();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.UnionType <em>Union Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Union Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.UnionType
     * @generated
     */
    EClass getUnionType();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.UnionType#getTargets <em>Targets</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Targets</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.UnionType#getTargets()
     * @see #getUnionType()
     * @generated
     */
    EReference getUnionType_Targets();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.ParameterizedType <em>Parameterized Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameterized Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.ParameterizedType
     * @generated
     */
    EClass getParameterizedType();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.ParameterizedType#getActualTypeArguments <em>Actual Type Arguments</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Actual Type Arguments</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.ParameterizedType#getActualTypeArguments()
     * @see #getParameterizedType()
     * @generated
     */
    EReference getParameterizedType_ActualTypeArguments();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.GenericType <em>Generic Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generic Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.GenericType
     * @generated
     */
    EClass getGenericType();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.GenericType#getTypeParameters <em>Type Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.GenericType#getTypeParameters()
     * @see #getGenericType()
     * @generated
     */
    EReference getGenericType_TypeParameters();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeVariableReference <em>Type Variable Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Variable Reference</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeVariableReference
     * @generated
     */
    EClass getTypeVariableReference();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeVariableReference#getVariable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Variable</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeVariableReference#getVariable()
     * @see #getTypeVariableReference()
     * @generated
     */
    EReference getTypeVariableReference_Variable();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.RType <em>RType</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>RType</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.RType
     * @generated
     */
    EClass getRType();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.RType#getRuntimeType <em>Runtime Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Runtime Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.RType#getRuntimeType()
     * @see #getRType()
     * @generated
     */
    EAttribute getRType_RuntimeType();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.GenericMethod <em>Generic Method</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generic Method</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.GenericMethod
     * @generated
     */
    EClass getGenericMethod();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.GenericMethod#getTypeParameters <em>Type Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.GenericMethod#getTypeParameters()
     * @see #getGenericMethod()
     * @generated
     */
    EReference getGenericMethod_TypeParameters();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeLiteral <em>Type Literal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Literal</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeLiteral
     * @generated
     */
    EClass getTypeLiteral();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeLiteral#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeLiteral#getName()
     * @see #getTypeLiteral()
     * @generated
     */
    EAttribute getTypeLiteral_Name();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeLiteral#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeLiteral#getTarget()
     * @see #getTypeLiteral()
     * @generated
     */
    EReference getTypeLiteral_Target();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeVariableClassType <em>Type Variable Class Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Variable Class Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeVariableClassType
     * @generated
     */
    EClass getTypeVariableClassType();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeVariableClassType#getVariable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Variable</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeVariableClassType#getVariable()
     * @see #getTypeVariableClassType()
     * @generated
     */
    EReference getTypeVariableClassType_Variable();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.MapType <em>Map Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Map Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.MapType
     * @generated
     */
    EClass getMapType();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.typeinfo.model.MapType#getKeyType <em>Key Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Key Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.MapType#getKeyType()
     * @see #getMapType()
     * @generated
     */
    EReference getMapType_KeyType();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.typeinfo.model.MapType#getValueType <em>Value Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.MapType#getValueType()
     * @see #getMapType()
     * @generated
     */
    EReference getMapType_ValueType();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.RecordType <em>Record Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Record Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.RecordType
     * @generated
     */
    EClass getRecordType();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.RecordType#getMembers <em>Members</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Members</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.RecordType#getMembers()
     * @see #getRecordType()
     * @generated
     */
    EReference getRecordType_Members();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.RecordType#getTypeName <em>Type Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Name</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.RecordType#getTypeName()
     * @see #getRecordType()
     * @generated
     */
    EAttribute getRecordType_TypeName();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.RecordMember <em>Record Member</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Record Member</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.RecordMember
     * @generated
     */
    EClass getRecordMember();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.RecordMember#isOptional <em>Optional</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Optional</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.RecordMember#isOptional()
     * @see #getRecordMember()
     * @generated
     */
    EAttribute getRecordMember_Optional();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.RecordProperty <em>Record Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Record Property</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.RecordProperty
     * @generated
     */
    EClass getRecordProperty();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.ClassType <em>Class Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Class Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.ClassType
     * @generated
     */
    EClass getClassType();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.typeinfo.model.ClassType#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.ClassType#getTarget()
     * @see #getClassType()
     * @generated
     */
    EReference getClassType_Target();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.UndefinedType <em>Undefined Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Undefined Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.UndefinedType
     * @generated
     */
    EClass getUndefinedType();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeVariable <em>Type Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Variable</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeVariable
     * @generated
     */
    EClass getTypeVariable();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeVariable#getBound <em>Bound</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Bound</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeVariable#getBound()
     * @see #getTypeVariable()
     * @generated
     */
    EReference getTypeVariable_Bound();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.Element <em>Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Element
     * @generated
     */
	EClass getElement();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Element#isDeprecated <em>Deprecated</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Deprecated</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Element#isDeprecated()
     * @see #getElement()
     * @generated
     */
	EAttribute getElement_Deprecated();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Element#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Element#getDescription()
     * @see #getElement()
     * @generated
     */
	EAttribute getElement_Description();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Element#isVisible <em>Visible</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visible</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Element#isVisible()
     * @see #getElement()
     * @generated
     */
	EAttribute getElement_Visible();

	/**
     * Returns the meta object for the map '{@link org.eclipse.dltk.javascript.typeinfo.model.Element#getAttributes <em>Attributes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Attributes</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Element#getAttributes()
     * @see #getElement()
     * @generated
     */
	EReference getElement_Attributes();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Element#isHideAllowed <em>Hide Allowed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Hide Allowed</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Element#isHideAllowed()
     * @see #getElement()
     * @generated
     */
    EAttribute getElement_HideAllowed();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type
     * @generated
     */
	EClass getType();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getMembers <em>Members</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Members</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#getMembers()
     * @see #getType()
     * @generated
     */
	EReference getType_Members();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#getKind()
     * @see #getType()
     * @generated
     */
	EAttribute getType_Kind();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getSuperType <em>Super Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Super Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#getSuperType()
     * @see #getType()
     * @generated
     */
    EReference getType_SuperType();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getSuperTypeExpr <em>Super Type Expr</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Super Type Expr</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#getSuperTypeExpr()
     * @see #getType()
     * @generated
     */
    EReference getType_SuperTypeExpr();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getStaticConstructor <em>Static Constructor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Static Constructor</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#getStaticConstructor()
     * @see #getType()
     * @generated
     */
    EReference getType_StaticConstructor();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getTraits <em>Traits</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Traits</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#getTraits()
     * @see #getType()
     * @generated
     */
    EReference getType_Traits();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getConstructors <em>Constructors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Constructors</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#getConstructors()
     * @see #getType()
     * @generated
     */
    EReference getType_Constructors();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#isInstantiable <em>Instantiable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instantiable</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#isInstantiable()
     * @see #getType()
     * @generated
     */
    EAttribute getType_Instantiable();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#isInheritConstructors <em>Inherit Constructors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Inherit Constructors</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#isInheritConstructors()
     * @see #getType()
     * @generated
     */
    EAttribute getType_InheritConstructors();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#isInheritStaticMembers <em>Inherit Static Members</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Inherit Static Members</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#isInheritStaticMembers()
     * @see #getType()
     * @generated
     */
    EAttribute getType_InheritStaticMembers();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Type#getMetaType <em>Meta Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Meta Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Type#getMetaType()
     * @see #getType()
     * @generated
     */
    EAttribute getType_MetaType();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.Constructor <em>Constructor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Constructor</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Constructor
     * @generated
     */
    EClass getConstructor();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeAlias <em>Type Alias</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Alias</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeAlias
     * @generated
     */
    EClass getTypeAlias();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeAlias#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeAlias#getSource()
     * @see #getTypeAlias()
     * @generated
     */
    EAttribute getTypeAlias_Source();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeAlias#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeAlias#getTarget()
     * @see #getTypeAlias()
     * @generated
     */
    EReference getTypeAlias_Target();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.Member <em>Member</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Member</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Member
     * @generated
     */
	EClass getMember();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Member#isStatic <em>Static</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Static</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Member#isStatic()
     * @see #getMember()
     * @generated
     */
	EAttribute getMember_Static();

	/**
     * Returns the meta object for the container reference '{@link org.eclipse.dltk.javascript.typeinfo.model.Member#getDeclaringType <em>Declaring Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Declaring Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Member#getDeclaringType()
     * @see #getMember()
     * @generated
     */
	EReference getMember_DeclaringType();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Member#getVisibility <em>Visibility</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visibility</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Member#getVisibility()
     * @see #getMember()
     * @generated
     */
    EAttribute getMember_Visibility();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.Method <em>Method</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Method</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Method
     * @generated
     */
	EClass getMethod();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.typeinfo.model.Method#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Method#getParameters()
     * @see #getMethod()
     * @generated
     */
	EReference getMethod_Parameters();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Method#isAbstract <em>Abstract</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Abstract</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Method#isAbstract()
     * @see #getMethod()
     * @generated
     */
    EAttribute getMethod_Abstract();

    /**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.Parameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameter</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Parameter
     * @generated
     */
	EClass getParameter();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Parameter#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Parameter#getKind()
     * @see #getParameter()
     * @generated
     */
	EAttribute getParameter_Kind();

	/**
     * Returns the meta object for class '{@link org.eclipse.dltk.javascript.typeinfo.model.Property <em>Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Property
     * @generated
     */
	EClass getProperty();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.typeinfo.model.Property#isReadOnly <em>Read Only</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Only</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Property#isReadOnly()
     * @see #getProperty()
     * @generated
     */
	EAttribute getProperty_ReadOnly();

	/**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>Attribute Entry</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Entry</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="org.eclipse.emf.ecore.EString"
     *        valueDataType="org.eclipse.emf.ecore.EJavaObject"
     * @generated
     */
	EClass getAttributeEntry();

	/**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getAttributeEntry()
     * @generated
     */
	EAttribute getAttributeEntry_Key();

	/**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getAttributeEntry()
     * @generated
     */
	EAttribute getAttributeEntry_Value();

	/**
     * Returns the meta object for enum '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeKind <em>Type Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Type Kind</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeKind
     * @generated
     */
	EEnum getTypeKind();

	/**
     * Returns the meta object for enum '{@link org.eclipse.dltk.javascript.typeinfo.model.ParameterKind <em>Parameter Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Parameter Kind</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.ParameterKind
     * @generated
     */
	EEnum getParameterKind();

	/**
     * Returns the meta object for enum '{@link org.eclipse.dltk.javascript.typeinfo.model.Visibility <em>Visibility</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Visibility</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.model.Visibility
     * @generated
     */
    EEnum getVisibility();

    /**
     * Returns the meta object for data type '{@link org.eclipse.dltk.javascript.typeinfo.IRType <em>IR Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>IR Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.IRType
     * @model instanceClass="org.eclipse.dltk.javascript.typeinfo.IRType" serializeable="false"
     * @generated
     */
    EDataType getIRType();

    /**
     * Returns the meta object for data type '{@link org.eclipse.dltk.javascript.typeinfo.MetaType <em>Meta Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Meta Type</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.MetaType
     * @model instanceClass="org.eclipse.dltk.javascript.typeinfo.MetaType"
     * @generated
     */
    EDataType getMetaType();

    /**
     * Returns the meta object for data type '{@link org.eclipse.dltk.javascript.typeinfo.ITypeSystem <em>IType System</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>IType System</em>'.
     * @see org.eclipse.dltk.javascript.typeinfo.ITypeSystem
     * @model instanceClass="org.eclipse.dltk.javascript.typeinfo.ITypeSystem" serializeable="false"
     * @generated
     */
    EDataType getITypeSystem();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	TypeInfoModelFactory getTypeInfoModelFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.NamedElement <em>Named Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.NamedElement
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getNamedElement()
         * @generated
         */
        EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.TypedElement <em>Typed Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.TypedElement
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypedElement()
         * @generated
         */
        EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

        /**
         * The meta object literal for the '<em><b>Direct Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPED_ELEMENT__DIRECT_TYPE = eINSTANCE.getTypedElement_DirectType();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.JSType <em>JS Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.JSType
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getJSType()
         * @generated
         */
        EClass JS_TYPE = eINSTANCE.getJSType();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.FunctionTypeImpl <em>Function Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.FunctionTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getFunctionType()
         * @generated
         */
        EClass FUNCTION_TYPE = eINSTANCE.getFunctionType();

        /**
         * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FUNCTION_TYPE__RETURN_TYPE = eINSTANCE.getFunctionType_ReturnType();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FUNCTION_TYPE__PARAMETERS = eINSTANCE.getFunctionType_Parameters();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.SimpleTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getSimpleType()
         * @generated
         */
        EClass SIMPLE_TYPE = eINSTANCE.getSimpleType();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIMPLE_TYPE__TARGET = eINSTANCE.getSimpleType_Target();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ArrayTypeImpl <em>Array Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ArrayTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getArrayType()
         * @generated
         */
        EClass ARRAY_TYPE = eINSTANCE.getArrayType();

        /**
         * The meta object literal for the '<em><b>Item Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ARRAY_TYPE__ITEM_TYPE = eINSTANCE.getArrayType_ItemType();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.AnyTypeImpl <em>Any Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.AnyTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getAnyType()
         * @generated
         */
        EClass ANY_TYPE = eINSTANCE.getAnyType();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.UnionTypeImpl <em>Union Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.UnionTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getUnionType()
         * @generated
         */
        EClass UNION_TYPE = eINSTANCE.getUnionType();

        /**
         * The meta object literal for the '<em><b>Targets</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UNION_TYPE__TARGETS = eINSTANCE.getUnionType_Targets();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterizedTypeImpl <em>Parameterized Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterizedTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getParameterizedType()
         * @generated
         */
        EClass PARAMETERIZED_TYPE = eINSTANCE.getParameterizedType();

        /**
         * The meta object literal for the '<em><b>Actual Type Arguments</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PARAMETERIZED_TYPE__ACTUAL_TYPE_ARGUMENTS = eINSTANCE.getParameterizedType_ActualTypeArguments();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.GenericTypeImpl <em>Generic Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.GenericTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getGenericType()
         * @generated
         */
        EClass GENERIC_TYPE = eINSTANCE.getGenericType();

        /**
         * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GENERIC_TYPE__TYPE_PARAMETERS = eINSTANCE.getGenericType_TypeParameters();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableReferenceImpl <em>Type Variable Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableReferenceImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeVariableReference()
         * @generated
         */
        EClass TYPE_VARIABLE_REFERENCE = eINSTANCE.getTypeVariableReference();

        /**
         * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE_VARIABLE_REFERENCE__VARIABLE = eINSTANCE.getTypeVariableReference_Variable();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.RTypeImpl <em>RType</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.RTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getRType()
         * @generated
         */
        EClass RTYPE = eINSTANCE.getRType();

        /**
         * The meta object literal for the '<em><b>Runtime Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RTYPE__RUNTIME_TYPE = eINSTANCE.getRType_RuntimeType();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.GenericMethodImpl <em>Generic Method</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.GenericMethodImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getGenericMethod()
         * @generated
         */
        EClass GENERIC_METHOD = eINSTANCE.getGenericMethod();

        /**
         * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GENERIC_METHOD__TYPE_PARAMETERS = eINSTANCE.getGenericMethod_TypeParameters();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeLiteralImpl <em>Type Literal</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeLiteralImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeLiteral()
         * @generated
         */
        EClass TYPE_LITERAL = eINSTANCE.getTypeLiteral();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TYPE_LITERAL__NAME = eINSTANCE.getTypeLiteral_Name();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE_LITERAL__TARGET = eINSTANCE.getTypeLiteral_Target();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableClassTypeImpl <em>Type Variable Class Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableClassTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeVariableClassType()
         * @generated
         */
        EClass TYPE_VARIABLE_CLASS_TYPE = eINSTANCE.getTypeVariableClassType();

        /**
         * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE_VARIABLE_CLASS_TYPE__VARIABLE = eINSTANCE.getTypeVariableClassType_Variable();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.MapTypeImpl <em>Map Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.MapTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getMapType()
         * @generated
         */
        EClass MAP_TYPE = eINSTANCE.getMapType();

        /**
         * The meta object literal for the '<em><b>Key Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAP_TYPE__KEY_TYPE = eINSTANCE.getMapType_KeyType();

        /**
         * The meta object literal for the '<em><b>Value Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAP_TYPE__VALUE_TYPE = eINSTANCE.getMapType_ValueType();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.RecordTypeImpl <em>Record Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.RecordTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getRecordType()
         * @generated
         */
        EClass RECORD_TYPE = eINSTANCE.getRecordType();

        /**
         * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RECORD_TYPE__MEMBERS = eINSTANCE.getRecordType_Members();

        /**
         * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RECORD_TYPE__TYPE_NAME = eINSTANCE.getRecordType_TypeName();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.RecordMember <em>Record Member</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.RecordMember
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getRecordMember()
         * @generated
         */
        EClass RECORD_MEMBER = eINSTANCE.getRecordMember();

        /**
         * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RECORD_MEMBER__OPTIONAL = eINSTANCE.getRecordMember_Optional();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.RecordPropertyImpl <em>Record Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.RecordPropertyImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getRecordProperty()
         * @generated
         */
        EClass RECORD_PROPERTY = eINSTANCE.getRecordProperty();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ClassTypeImpl <em>Class Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ClassTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getClassType()
         * @generated
         */
        EClass CLASS_TYPE = eINSTANCE.getClassType();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CLASS_TYPE__TARGET = eINSTANCE.getClassType_Target();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.UndefinedTypeImpl <em>Undefined Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.UndefinedTypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getUndefinedType()
         * @generated
         */
        EClass UNDEFINED_TYPE = eINSTANCE.getUndefinedType();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableImpl <em>Type Variable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeVariableImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeVariable()
         * @generated
         */
        EClass TYPE_VARIABLE = eINSTANCE.getTypeVariable();

        /**
         * The meta object literal for the '<em><b>Bound</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE_VARIABLE__BOUND = eINSTANCE.getTypeVariable_Bound();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ElementImpl <em>Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ElementImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getElement()
         * @generated
         */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
         * The meta object literal for the '<em><b>Deprecated</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT__DEPRECATED = eINSTANCE.getElement_Deprecated();

		/**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT__DESCRIPTION = eINSTANCE.getElement_Description();

		/**
         * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT__VISIBLE = eINSTANCE.getElement_Visible();

		/**
         * The meta object literal for the '<em><b>Attributes</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ELEMENT__ATTRIBUTES = eINSTANCE.getElement_Attributes();

		/**
         * The meta object literal for the '<em><b>Hide Allowed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELEMENT__HIDE_ALLOWED = eINSTANCE.getElement_HideAllowed();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeImpl <em>Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getType()
         * @generated
         */
		EClass TYPE = eINSTANCE.getType();

		/**
         * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE__MEMBERS = eINSTANCE.getType_Members();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute TYPE__KIND = eINSTANCE.getType_Kind();

		/**
         * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE__SUPER_TYPE = eINSTANCE.getType_SuperType();

        /**
         * The meta object literal for the '<em><b>Super Type Expr</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE__SUPER_TYPE_EXPR = eINSTANCE.getType_SuperTypeExpr();

        /**
         * The meta object literal for the '<em><b>Static Constructor</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE__STATIC_CONSTRUCTOR = eINSTANCE.getType_StaticConstructor();

        /**
         * The meta object literal for the '<em><b>Traits</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE__TRAITS = eINSTANCE.getType_Traits();

        /**
         * The meta object literal for the '<em><b>Constructors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE__CONSTRUCTORS = eINSTANCE.getType_Constructors();

        /**
         * The meta object literal for the '<em><b>Instantiable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TYPE__INSTANTIABLE = eINSTANCE.getType_Instantiable();

        /**
         * The meta object literal for the '<em><b>Inherit Constructors</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TYPE__INHERIT_CONSTRUCTORS = eINSTANCE.getType_InheritConstructors();

        /**
         * The meta object literal for the '<em><b>Inherit Static Members</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TYPE__INHERIT_STATIC_MEMBERS = eINSTANCE.getType_InheritStaticMembers();

        /**
         * The meta object literal for the '<em><b>Meta Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TYPE__META_TYPE = eINSTANCE.getType_MetaType();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ConstructorImpl <em>Constructor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ConstructorImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getConstructor()
         * @generated
         */
        EClass CONSTRUCTOR = eINSTANCE.getConstructor();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.TypeAliasImpl <em>Type Alias</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeAliasImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeAlias()
         * @generated
         */
        EClass TYPE_ALIAS = eINSTANCE.getTypeAlias();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TYPE_ALIAS__SOURCE = eINSTANCE.getTypeAlias_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE_ALIAS__TARGET = eINSTANCE.getTypeAlias_Target();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.MemberImpl <em>Member</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.MemberImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getMember()
         * @generated
         */
		EClass MEMBER = eINSTANCE.getMember();

		/**
         * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MEMBER__STATIC = eINSTANCE.getMember_Static();

		/**
         * The meta object literal for the '<em><b>Declaring Type</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MEMBER__DECLARING_TYPE = eINSTANCE.getMember_DeclaringType();

		/**
         * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MEMBER__VISIBILITY = eINSTANCE.getMember_Visibility();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.MethodImpl <em>Method</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.MethodImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getMethod()
         * @generated
         */
		EClass METHOD = eINSTANCE.getMethod();

		/**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference METHOD__PARAMETERS = eINSTANCE.getMethod_Parameters();

		/**
         * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute METHOD__ABSTRACT = eINSTANCE.getMethod_Abstract();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterImpl <em>Parameter</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.ParameterImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getParameter()
         * @generated
         */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PARAMETER__KIND = eINSTANCE.getParameter_Kind();

		/**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.PropertyImpl <em>Property</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.PropertyImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getProperty()
         * @generated
         */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
         * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PROPERTY__READ_ONLY = eINSTANCE.getProperty_ReadOnly();

		/**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.impl.AttributeEntryImpl <em>Attribute Entry</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.AttributeEntryImpl
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getAttributeEntry()
         * @generated
         */
		EClass ATTRIBUTE_ENTRY = eINSTANCE.getAttributeEntry();

		/**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ATTRIBUTE_ENTRY__KEY = eINSTANCE.getAttributeEntry_Key();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ATTRIBUTE_ENTRY__VALUE = eINSTANCE.getAttributeEntry_Value();

		/**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.TypeKind <em>Type Kind</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.TypeKind
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getTypeKind()
         * @generated
         */
		EEnum TYPE_KIND = eINSTANCE.getTypeKind();

		/**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.ParameterKind <em>Parameter Kind</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.ParameterKind
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getParameterKind()
         * @generated
         */
		EEnum PARAMETER_KIND = eINSTANCE.getParameterKind();

        /**
         * The meta object literal for the '{@link org.eclipse.dltk.javascript.typeinfo.model.Visibility <em>Visibility</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.model.Visibility
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getVisibility()
         * @generated
         */
        EEnum VISIBILITY = eINSTANCE.getVisibility();

        /**
         * The meta object literal for the '<em>IR Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.IRType
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getIRType()
         * @generated
         */
        EDataType IR_TYPE = eINSTANCE.getIRType();

        /**
         * The meta object literal for the '<em>Meta Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.MetaType
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getMetaType()
         * @generated
         */
        EDataType META_TYPE = eINSTANCE.getMetaType();

        /**
         * The meta object literal for the '<em>IType System</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.dltk.javascript.typeinfo.ITypeSystem
         * @see org.eclipse.dltk.javascript.typeinfo.model.impl.TypeInfoModelPackageImpl#getITypeSystem()
         * @generated
         */
        EDataType ITYPE_SYSTEM = eINSTANCE.getITypeSystem();

	}

} //TypeInfoModelPackage
