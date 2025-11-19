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
 * $Id: TypeInfoModelPackageImpl.java,v 1.47 2012/06/12 10:40:31 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.typeinfo.model.impl;

import java.util.Map;

import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.MetaType;
import org.eclipse.dltk.javascript.typeinfo.model.AnyType;
import org.eclipse.dltk.javascript.typeinfo.model.ArrayType;
import org.eclipse.dltk.javascript.typeinfo.model.ClassType;
import org.eclipse.dltk.javascript.typeinfo.model.Constructor;
import org.eclipse.dltk.javascript.typeinfo.model.Element;
import org.eclipse.dltk.javascript.typeinfo.model.FunctionType;
import org.eclipse.dltk.javascript.typeinfo.model.GenericMethod;
import org.eclipse.dltk.javascript.typeinfo.model.GenericType;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.MapType;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.Method;
import org.eclipse.dltk.javascript.typeinfo.model.NamedElement;
import org.eclipse.dltk.javascript.typeinfo.model.Parameter;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterizedType;
import org.eclipse.dltk.javascript.typeinfo.model.Property;
import org.eclipse.dltk.javascript.typeinfo.model.RType;
import org.eclipse.dltk.javascript.typeinfo.model.RecordMember;
import org.eclipse.dltk.javascript.typeinfo.model.RecordProperty;
import org.eclipse.dltk.javascript.typeinfo.model.RecordType;
import org.eclipse.dltk.javascript.typeinfo.model.SimpleType;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeAlias;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelFactory;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;
import org.eclipse.dltk.javascript.typeinfo.model.TypeLiteral;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariable;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariableClassType;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariableReference;
import org.eclipse.dltk.javascript.typeinfo.model.TypedElement;
import org.eclipse.dltk.javascript.typeinfo.model.UndefinedType;
import org.eclipse.dltk.javascript.typeinfo.model.UnionType;
import org.eclipse.dltk.javascript.typeinfo.model.Visibility;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypeInfoModelPackageImpl extends EPackageImpl implements TypeInfoModelPackage {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass namedElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typedElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jsTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass functionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass arrayTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass anyTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass unionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass parameterizedTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genericTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeVariableReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genericMethodEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeLiteralEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeVariableClassTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mapTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass recordTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass recordMemberEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass recordPropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass classTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass undefinedTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeVariableEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass elementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typeEClass = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass constructorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeAliasEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass memberEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass methodEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass parameterEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass propertyEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass attributeEntryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum typeKindEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum parameterKindEEnum = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum visibilityEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType irTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType metaTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType iTypeSystemEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private TypeInfoModelPackageImpl() {
        super(eNS_URI, TypeInfoModelFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link TypeInfoModelPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static TypeInfoModelPackage init() {
        if (isInited) return (TypeInfoModelPackage)EPackage.Registry.INSTANCE.getEPackage(TypeInfoModelPackage.eNS_URI);

        // Obtain or create and register package
        TypeInfoModelPackageImpl theTypeInfoModelPackage = (TypeInfoModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypeInfoModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypeInfoModelPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theTypeInfoModelPackage.createPackageContents();

        // Initialize created meta-data
        theTypeInfoModelPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theTypeInfoModelPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(TypeInfoModelPackage.eNS_URI, theTypeInfoModelPackage);
        return theTypeInfoModelPackage;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNamedElement() {
        return namedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNamedElement_Name() {
        return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypedElement() {
        return typedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypedElement_Type() {
        return (EReference)typedElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypedElement_DirectType() {
        return (EReference)typedElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJSType() {
        return jsTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFunctionType() {
        return functionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionType_ReturnType() {
        return (EReference)functionTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFunctionType_Parameters() {
        return (EReference)functionTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimpleType() {
        return simpleTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimpleType_Target() {
        return (EReference)simpleTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getArrayType() {
        return arrayTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getArrayType_ItemType() {
        return (EReference)arrayTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAnyType() {
        return anyTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUnionType() {
        return unionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUnionType_Targets() {
        return (EReference)unionTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParameterizedType() {
        return parameterizedTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getParameterizedType_ActualTypeArguments() {
        return (EReference)parameterizedTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenericType() {
        return genericTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGenericType_TypeParameters() {
        return (EReference)genericTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeVariableReference() {
        return typeVariableReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypeVariableReference_Variable() {
        return (EReference)typeVariableReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRType() {
        return rTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRType_RuntimeType() {
        return (EAttribute)rTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenericMethod() {
        return genericMethodEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGenericMethod_TypeParameters() {
        return (EReference)genericMethodEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeLiteral() {
        return typeLiteralEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeLiteral_Name() {
        return (EAttribute)typeLiteralEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypeLiteral_Target() {
        return (EReference)typeLiteralEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeVariableClassType() {
        return typeVariableClassTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypeVariableClassType_Variable() {
        return (EReference)typeVariableClassTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMapType() {
        return mapTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMapType_KeyType() {
        return (EReference)mapTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMapType_ValueType() {
        return (EReference)mapTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRecordType() {
        return recordTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRecordType_Members() {
        return (EReference)recordTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRecordType_TypeName() {
        return (EAttribute)recordTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRecordMember() {
        return recordMemberEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRecordMember_Optional() {
        return (EAttribute)recordMemberEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRecordProperty() {
        return recordPropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getClassType() {
        return classTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getClassType_Target() {
        return (EReference)classTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUndefinedType() {
        return undefinedTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeVariable() {
        return typeVariableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypeVariable_Bound() {
        return (EReference)typeVariableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getElement() {
        return elementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElement_Deprecated() {
        return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElement_Description() {
        return (EAttribute)elementEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElement_Visible() {
        return (EAttribute)elementEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getElement_Attributes() {
        return (EReference)elementEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getElement_HideAllowed() {
        return (EAttribute)elementEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getType() {
        return typeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getType_Members() {
        return (EReference)typeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getType_Kind() {
        return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getType_SuperType() {
        return (EReference)typeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getType_SuperTypeExpr() {
        return (EReference)typeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getType_StaticConstructor() {
        return (EReference)typeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getType_Traits() {
        return (EReference)typeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getType_Constructors() {
        return (EReference)typeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getType_Instantiable() {
        return (EAttribute)typeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getType_InheritConstructors() {
        return (EAttribute)typeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getType_InheritStaticMembers() {
        return (EAttribute)typeEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getType_MetaType() {
        return (EAttribute)typeEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConstructor() {
        return constructorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTypeAlias() {
        return typeAliasEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTypeAlias_Source() {
        return (EAttribute)typeAliasEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypeAlias_Target() {
        return (EReference)typeAliasEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMember() {
        return memberEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMember_Static() {
        return (EAttribute)memberEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMember_DeclaringType() {
        return (EReference)memberEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMember_Visibility() {
        return (EAttribute)memberEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMethod() {
        return methodEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMethod_Parameters() {
        return (EReference)methodEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMethod_Abstract() {
        return (EAttribute)methodEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getParameter() {
        return parameterEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getParameter_Kind() {
        return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
    }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getParameter_Description() {
		return (EAttribute) parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getProperty() {
        return propertyEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getProperty_ReadOnly() {
        return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAttributeEntry() {
        return attributeEntryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeEntry_Key() {
        return (EAttribute)attributeEntryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeEntry_Value() {
        return (EAttribute)attributeEntryEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getTypeKind() {
        return typeKindEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getParameterKind() {
        return parameterKindEEnum;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getVisibility() {
        return visibilityEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getIRType() {
        return irTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getMetaType() {
        return metaTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getITypeSystem() {
        return iTypeSystemEDataType;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeInfoModelFactory getTypeInfoModelFactory() {
        return (TypeInfoModelFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        namedElementEClass = createEClass(NAMED_ELEMENT);
        createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

        typedElementEClass = createEClass(TYPED_ELEMENT);
        createEReference(typedElementEClass, TYPED_ELEMENT__TYPE);
        createEReference(typedElementEClass, TYPED_ELEMENT__DIRECT_TYPE);

        elementEClass = createEClass(ELEMENT);
        createEAttribute(elementEClass, ELEMENT__DEPRECATED);
        createEAttribute(elementEClass, ELEMENT__DESCRIPTION);
        createEAttribute(elementEClass, ELEMENT__VISIBLE);
        createEReference(elementEClass, ELEMENT__ATTRIBUTES);
        createEAttribute(elementEClass, ELEMENT__HIDE_ALLOWED);

        typeEClass = createEClass(TYPE);
        createEReference(typeEClass, TYPE__MEMBERS);
        createEAttribute(typeEClass, TYPE__KIND);
        createEReference(typeEClass, TYPE__SUPER_TYPE);
        createEReference(typeEClass, TYPE__SUPER_TYPE_EXPR);
        createEReference(typeEClass, TYPE__STATIC_CONSTRUCTOR);
        createEReference(typeEClass, TYPE__TRAITS);
        createEReference(typeEClass, TYPE__CONSTRUCTORS);
        createEAttribute(typeEClass, TYPE__INSTANTIABLE);
        createEAttribute(typeEClass, TYPE__INHERIT_CONSTRUCTORS);
        createEAttribute(typeEClass, TYPE__INHERIT_STATIC_MEMBERS);
        createEAttribute(typeEClass, TYPE__META_TYPE);

        typeAliasEClass = createEClass(TYPE_ALIAS);
        createEAttribute(typeAliasEClass, TYPE_ALIAS__SOURCE);
        createEReference(typeAliasEClass, TYPE_ALIAS__TARGET);

        memberEClass = createEClass(MEMBER);
        createEAttribute(memberEClass, MEMBER__STATIC);
        createEReference(memberEClass, MEMBER__DECLARING_TYPE);
        createEAttribute(memberEClass, MEMBER__VISIBILITY);

        methodEClass = createEClass(METHOD);
        createEReference(methodEClass, METHOD__PARAMETERS);
        createEAttribute(methodEClass, METHOD__ABSTRACT);

        parameterEClass = createEClass(PARAMETER);
        createEAttribute(parameterEClass, PARAMETER__KIND);
		createEAttribute(parameterEClass, PARAMETER__DESCRIPTION);

        constructorEClass = createEClass(CONSTRUCTOR);

        propertyEClass = createEClass(PROPERTY);
        createEAttribute(propertyEClass, PROPERTY__READ_ONLY);

        attributeEntryEClass = createEClass(ATTRIBUTE_ENTRY);
        createEAttribute(attributeEntryEClass, ATTRIBUTE_ENTRY__KEY);
        createEAttribute(attributeEntryEClass, ATTRIBUTE_ENTRY__VALUE);

        jsTypeEClass = createEClass(JS_TYPE);

        functionTypeEClass = createEClass(FUNCTION_TYPE);
        createEReference(functionTypeEClass, FUNCTION_TYPE__RETURN_TYPE);
        createEReference(functionTypeEClass, FUNCTION_TYPE__PARAMETERS);

        simpleTypeEClass = createEClass(SIMPLE_TYPE);
        createEReference(simpleTypeEClass, SIMPLE_TYPE__TARGET);

        arrayTypeEClass = createEClass(ARRAY_TYPE);
        createEReference(arrayTypeEClass, ARRAY_TYPE__ITEM_TYPE);

        anyTypeEClass = createEClass(ANY_TYPE);

        unionTypeEClass = createEClass(UNION_TYPE);
        createEReference(unionTypeEClass, UNION_TYPE__TARGETS);

        parameterizedTypeEClass = createEClass(PARAMETERIZED_TYPE);
        createEReference(parameterizedTypeEClass, PARAMETERIZED_TYPE__ACTUAL_TYPE_ARGUMENTS);

        mapTypeEClass = createEClass(MAP_TYPE);
        createEReference(mapTypeEClass, MAP_TYPE__KEY_TYPE);
        createEReference(mapTypeEClass, MAP_TYPE__VALUE_TYPE);

        recordTypeEClass = createEClass(RECORD_TYPE);
        createEReference(recordTypeEClass, RECORD_TYPE__MEMBERS);
        createEAttribute(recordTypeEClass, RECORD_TYPE__TYPE_NAME);

        recordMemberEClass = createEClass(RECORD_MEMBER);
        createEAttribute(recordMemberEClass, RECORD_MEMBER__OPTIONAL);

        recordPropertyEClass = createEClass(RECORD_PROPERTY);

        classTypeEClass = createEClass(CLASS_TYPE);
        createEReference(classTypeEClass, CLASS_TYPE__TARGET);

        undefinedTypeEClass = createEClass(UNDEFINED_TYPE);

        typeVariableEClass = createEClass(TYPE_VARIABLE);
        createEReference(typeVariableEClass, TYPE_VARIABLE__BOUND);

        genericTypeEClass = createEClass(GENERIC_TYPE);
        createEReference(genericTypeEClass, GENERIC_TYPE__TYPE_PARAMETERS);

        typeVariableReferenceEClass = createEClass(TYPE_VARIABLE_REFERENCE);
        createEReference(typeVariableReferenceEClass, TYPE_VARIABLE_REFERENCE__VARIABLE);

        rTypeEClass = createEClass(RTYPE);
        createEAttribute(rTypeEClass, RTYPE__RUNTIME_TYPE);

        genericMethodEClass = createEClass(GENERIC_METHOD);
        createEReference(genericMethodEClass, GENERIC_METHOD__TYPE_PARAMETERS);

        typeLiteralEClass = createEClass(TYPE_LITERAL);
        createEAttribute(typeLiteralEClass, TYPE_LITERAL__NAME);
        createEReference(typeLiteralEClass, TYPE_LITERAL__TARGET);

        typeVariableClassTypeEClass = createEClass(TYPE_VARIABLE_CLASS_TYPE);
        createEReference(typeVariableClassTypeEClass, TYPE_VARIABLE_CLASS_TYPE__VARIABLE);

        // Create enums
        typeKindEEnum = createEEnum(TYPE_KIND);
        parameterKindEEnum = createEEnum(PARAMETER_KIND);
        visibilityEEnum = createEEnum(VISIBILITY);

        // Create data types
        irTypeEDataType = createEDataType(IR_TYPE);
        metaTypeEDataType = createEDataType(META_TYPE);
        iTypeSystemEDataType = createEDataType(ITYPE_SYSTEM);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

	/**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        elementEClass.getESuperTypes().add(this.getNamedElement());
        typeEClass.getESuperTypes().add(this.getElement());
        memberEClass.getESuperTypes().add(this.getElement());
        memberEClass.getESuperTypes().add(this.getTypedElement());
        methodEClass.getESuperTypes().add(this.getMember());
        parameterEClass.getESuperTypes().add(this.getNamedElement());
        parameterEClass.getESuperTypes().add(this.getTypedElement());
        constructorEClass.getESuperTypes().add(this.getMethod());
        propertyEClass.getESuperTypes().add(this.getMember());
        functionTypeEClass.getESuperTypes().add(this.getJSType());
        simpleTypeEClass.getESuperTypes().add(this.getJSType());
        arrayTypeEClass.getESuperTypes().add(this.getJSType());
        anyTypeEClass.getESuperTypes().add(this.getJSType());
        unionTypeEClass.getESuperTypes().add(this.getJSType());
        parameterizedTypeEClass.getESuperTypes().add(this.getSimpleType());
        mapTypeEClass.getESuperTypes().add(this.getJSType());
        recordTypeEClass.getESuperTypes().add(this.getJSType());
        recordMemberEClass.getESuperTypes().add(this.getMember());
        recordPropertyEClass.getESuperTypes().add(this.getProperty());
        recordPropertyEClass.getESuperTypes().add(this.getRecordMember());
        classTypeEClass.getESuperTypes().add(this.getJSType());
        undefinedTypeEClass.getESuperTypes().add(this.getJSType());
        typeVariableEClass.getESuperTypes().add(this.getNamedElement());
        genericTypeEClass.getESuperTypes().add(this.getType());
        typeVariableReferenceEClass.getESuperTypes().add(this.getJSType());
        rTypeEClass.getESuperTypes().add(this.getJSType());
        genericMethodEClass.getESuperTypes().add(this.getMethod());
        typeVariableClassTypeEClass.getESuperTypes().add(this.getJSType());

        // Initialize classes and features; add operations and parameters
        initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTypedElement_Type(), this.getJSType(), null, "type", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTypedElement_DirectType(), this.getType(), null, "directType", null, 0, 1, TypedElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getElement_Deprecated(), ecorePackage.getEBoolean(), "deprecated", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getElement_Visible(), ecorePackage.getEBoolean(), "visible", "true", 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getElement_Attributes(), this.getAttributeEntry(), null, "attributes", null, 0, -1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getElement_HideAllowed(), ecorePackage.getEBoolean(), "hideAllowed", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        EOperation op = addEOperation(elementEClass, ecorePackage.getEJavaObject(), "getAttribute", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(elementEClass, null, "setAttribute", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getType_Members(), this.getMember(), this.getMember_DeclaringType(), "members", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getType_Kind(), this.getTypeKind(), "kind", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getType_SuperType(), this.getType(), null, "superType", null, 0, 1, Type.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getType_SuperTypeExpr(), this.getSimpleType(), null, "superTypeExpr", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getType_StaticConstructor(), this.getConstructor(), null, "staticConstructor", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getType_Traits(), this.getType(), null, "traits", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getType_Constructors(), this.getConstructor(), null, "constructors", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getType_Instantiable(), ecorePackage.getEBoolean(), "instantiable", "true", 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getType_InheritConstructors(), ecorePackage.getEBoolean(), "inheritConstructors", null, 0, 1, Type.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getType_InheritStaticMembers(), ecorePackage.getEBoolean(), "inheritStaticMembers", null, 0, 1, Type.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getType_MetaType(), this.getMetaType(), "metaType", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(typeEClass, ecorePackage.getEBoolean(), "isProxy", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeAliasEClass, TypeAlias.class, "TypeAlias", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeAlias_Source(), ecorePackage.getEString(), "source", null, 0, 1, TypeAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTypeAlias_Target(), this.getType(), null, "target", null, 0, 1, TypeAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(memberEClass, Member.class, "Member", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getMember_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMember_DeclaringType(), this.getType(), this.getType_Members(), "declaringType", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getMember_Visibility(), this.getVisibility(), "visibility", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMethod_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getMethod_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(methodEClass, this.getParameter(), "getParameter", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(methodEClass, this.getParameter(), "getParameterFor", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEInt(), "position", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getParameter_Kind(), this.getParameterKind(), "kind", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getParameter_Description(), ecorePackage.getEString(),
				"description", null, 0, 1, Parameter.class, !IS_TRANSIENT, //$NON-NLS-1$
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

        initEClass(constructorEClass, Constructor.class, "Constructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getProperty_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(attributeEntryEClass, Map.Entry.class, "AttributeEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getAttributeEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAttributeEntry_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(jsTypeEClass, JSType.class, "JSType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        addEOperation(jsTypeEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(jsTypeEClass, this.getIRType(), "toRType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, this.getITypeSystem(), "typeSystem", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(functionTypeEClass, FunctionType.class, "FunctionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getFunctionType_ReturnType(), this.getJSType(), null, "returnType", null, 0, 1, FunctionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getFunctionType_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, FunctionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(simpleTypeEClass, SimpleType.class, "SimpleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getSimpleType_Target(), this.getType(), null, "target", null, 0, 1, SimpleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(arrayTypeEClass, ArrayType.class, "ArrayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getArrayType_ItemType(), this.getJSType(), null, "itemType", null, 0, 1, ArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(anyTypeEClass, AnyType.class, "AnyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(unionTypeEClass, UnionType.class, "UnionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getUnionType_Targets(), this.getJSType(), null, "targets", null, 0, -1, UnionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(parameterizedTypeEClass, ParameterizedType.class, "ParameterizedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getParameterizedType_ActualTypeArguments(), this.getJSType(), null, "actualTypeArguments", null, 0, -1, ParameterizedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(parameterizedTypeEClass, ecorePackage.getEString(), "getRawName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(mapTypeEClass, MapType.class, "MapType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMapType_KeyType(), this.getJSType(), null, "keyType", null, 0, 1, MapType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMapType_ValueType(), this.getJSType(), null, "valueType", null, 0, 1, MapType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(recordTypeEClass, RecordType.class, "RecordType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getRecordType_Members(), this.getMember(), null, "members", null, 0, -1, RecordType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getRecordType_TypeName(), ecorePackage.getEString(), "typeName", null, 0, 1, RecordType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(recordMemberEClass, RecordMember.class, "RecordMember", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getRecordMember_Optional(), ecorePackage.getEBoolean(), "optional", null, 0, 1, RecordMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(recordPropertyEClass, RecordProperty.class, "RecordProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(classTypeEClass, ClassType.class, "ClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getClassType_Target(), this.getType(), null, "target", null, 0, 1, ClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(classTypeEClass, ecorePackage.getEString(), "getRawName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(undefinedTypeEClass, UndefinedType.class, "UndefinedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(typeVariableEClass, TypeVariable.class, "TypeVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTypeVariable_Bound(), this.getJSType(), null, "bound", null, 0, 1, TypeVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(genericTypeEClass, GenericType.class, "GenericType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getGenericType_TypeParameters(), this.getTypeVariable(), null, "typeParameters", null, 0, -1, GenericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeVariableReferenceEClass, TypeVariableReference.class, "TypeVariableReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTypeVariableReference_Variable(), this.getTypeVariable(), null, "variable", null, 0, 1, TypeVariableReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(rTypeEClass, RType.class, "RType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getRType_RuntimeType(), this.getIRType(), "runtimeType", null, 0, 1, RType.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(genericMethodEClass, GenericMethod.class, "GenericMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getGenericMethod_TypeParameters(), this.getTypeVariable(), null, "typeParameters", null, 0, -1, GenericMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeLiteralEClass, TypeLiteral.class, "TypeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypeLiteral_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTypeLiteral_Target(), this.getType(), null, "target", null, 0, 1, TypeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeVariableClassTypeEClass, TypeVariableClassType.class, "TypeVariableClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTypeVariableClassType_Variable(), this.getTypeVariable(), null, "variable", null, 0, 1, TypeVariableClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum(typeKindEEnum, TypeKind.class, "TypeKind"); //$NON-NLS-1$
        addEEnumLiteral(typeKindEEnum, TypeKind.DEFAULT);
        addEEnumLiteral(typeKindEEnum, TypeKind.UNRESOLVED);
        addEEnumLiteral(typeKindEEnum, TypeKind.UNKNOWN);
        addEEnumLiteral(typeKindEEnum, TypeKind.PREDEFINED);
        addEEnumLiteral(typeKindEEnum, TypeKind.JAVASCRIPT);
        addEEnumLiteral(typeKindEEnum, TypeKind.JAVA);

        initEEnum(parameterKindEEnum, ParameterKind.class, "ParameterKind"); //$NON-NLS-1$
        addEEnumLiteral(parameterKindEEnum, ParameterKind.NORMAL);
        addEEnumLiteral(parameterKindEEnum, ParameterKind.OPTIONAL);
        addEEnumLiteral(parameterKindEEnum, ParameterKind.VARARGS);

        initEEnum(visibilityEEnum, Visibility.class, "Visibility"); //$NON-NLS-1$
        addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC);
        addEEnumLiteral(visibilityEEnum, Visibility.PROTECTED);
        addEEnumLiteral(visibilityEEnum, Visibility.INTERNAL);
        addEEnumLiteral(visibilityEEnum, Visibility.PRIVATE);

        // Initialize data types
        initEDataType(irTypeEDataType, IRType.class, "IRType", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(metaTypeEDataType, MetaType.class, "MetaType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(iTypeSystemEDataType, ITypeSystem.class, "ITypeSystem", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        // Create resource
        createResource(eNS_URI);
    }

} //TypeInfoModelPackageImpl
