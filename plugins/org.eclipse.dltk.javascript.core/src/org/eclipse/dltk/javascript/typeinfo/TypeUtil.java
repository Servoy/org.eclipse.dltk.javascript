/*******************************************************************************
 * Copyright (c) 2011 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.typeinfo;

import static org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelFactory.eINSTANCE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.dltk.annotations.NonNull;
import org.eclipse.dltk.annotations.Nullable;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencerVisitor;
import org.eclipse.dltk.javascript.core.Types;
import org.eclipse.dltk.javascript.internal.core.RParameterizedTypeDeclaration;
import org.eclipse.dltk.javascript.typeinfo.model.ArrayType;
import org.eclipse.dltk.javascript.typeinfo.model.ClassType;
import org.eclipse.dltk.javascript.typeinfo.model.Constructor;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.MapType;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterizedType;
import org.eclipse.dltk.javascript.typeinfo.model.RType;
import org.eclipse.dltk.javascript.typeinfo.model.RecordType;
import org.eclipse.dltk.javascript.typeinfo.model.SimpleType;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelLoader;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariable;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariableReference;
import org.eclipse.dltk.javascript.typeinfo.model.UndefinedType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class TypeUtil {
	@Nullable
	public static SimpleType ref(@Nullable Type type) {
		if (type == null) {
			return null;
		}
		final SimpleType ref = eINSTANCE.createSimpleType();
		ref.setTarget(type);
		return ref;
	}

	@Nullable
	public static ClassType classType(@Nullable Type type) {
		if (type == null) {
			return null;
		}
		final ClassType ref = eINSTANCE.createClassType();
		ref.setTarget(type);
		return ref;
	}

	public static JSType ref(String typeName) {
		return ref(type(typeName));
	}

	public static Type type(String typeName) {
		final Type type = TypeInfoModelLoader.getInstance().getType(typeName);
		if (type != null) {
			return type;
		}
		return createProxy(typeName);
	}

	public static ArrayType arrayOf(String itemType) {
		return arrayOf(ref(itemType));
	}

	public static ArrayType arrayOf(JSType itemType) {
		final ArrayType arrayType = eINSTANCE.createArrayType();
		arrayType.setItemType(itemType != null ? itemType : ref(Types.OBJECT));
		return arrayType;
	}

	public static MapType mapOf(String keyType, String valueType) {
		return mapOf(keyType != null ? ref(keyType) : null, ref(valueType));
	}

	public static MapType mapOf(JSType keyType, JSType valueType) {
		final MapType mapType = eINSTANCE.createMapType();
		if (keyType != null)
			mapType.setKeyType(keyType);
		mapType.setValueType(valueType != null ? valueType : ref(Types.OBJECT));
		return mapType;
	}

	/**
	 * @deprecated Use {@link #parameterizedType(String,JSType...)} instead
	 */
	public static ParameterizedType genericType(String baseType,
			JSType... typeParameters) {
		return parameterizedType(type(baseType), typeParameters);
	}

	public static ParameterizedType parameterizedType(Type targetType,
			JSType... typeParameters) {
		final ParameterizedType genericType = eINSTANCE
				.createParameterizedType();
		genericType.setTarget(targetType);
		for (JSType typeParameter : typeParameters) {
			genericType.getActualTypeArguments().add(typeParameter);
		}
		return genericType;
	}

	public static ParameterizedType parameterizedType(Type targetType,
			List<JSType> typeParameters) {
		final ParameterizedType genericType = eINSTANCE
				.createParameterizedType();
		genericType.setTarget(targetType);
		for (JSType typeParameter : typeParameters) {
			genericType.getActualTypeArguments().add(typeParameter);
		}
		return genericType;
	}

	public static IRType extractArrayItemType(IRType type) {
		if (type instanceof IRArrayType) {
			return ((IRArrayType) type).getItemType();
		} else if (type instanceof IRMapType) {
			return ((IRMapType) type).getValueType();
		} else if (type != null && type.getName().equals(ITypeNames.XML)) {
			return type;
		} else if (type != null && type.getName().equals(ITypeNames.XMLLIST)) {
			return E4XTypes.XML;
		} else if (type instanceof IRSimpleType simple && simple
				.getDeclaration() instanceof RParameterizedTypeDeclaration decl
				&& decl.getActualTypeArguments().size() == 1) {
			IRType irType = decl.getActualTypeArguments().get(0);
			return irType;
		} else if (type instanceof IRRecordType record) {
			Set<IRType> types = record.getMembers().stream()
					.map(IRRecordMember::getType)
					.collect(Collectors.toSet());
			if (types.size() == 1) {
				return types.iterator().next();
			} else if (types.size() == 0) {
				return null;
			} else {
				return RTypes.union(types);
			}
		} else if (type instanceof REnumType) {
			// and array lookup of an Enum is just the enum type itself
			return type;
		} else {
			return null;
		}
	}

	public static String getName(JSType type) {
		return type != null ? type.getName() : null;
	}

	public static String getName(IRType type) {
		return type != null ? type.getName() : null;
	}

	public static String getName(Type type) {
		if (type.isProxy()) {
			return URI.decode(((InternalEObject) type).eProxyURI().fragment());
		} else {
			return type.getName();
		}
	}

	private static final String PROXY_SCHEME = "proxy";
	private static final String PROXY_OPAQUE_PART = "dltk/javascript/typeinfo/type";

	/**
	 * @param typeName
	 * @return
	 */
	public static Type createProxy(String typeName) {
		return createProxy(createProxyURI(typeName));
	}

	public static Type createProxy(URI uri) {
		final Type type = eINSTANCE.createType();
		type.setName(uri.fragment());
		((InternalEObject) type).eSetProxyURI(uri);
		return type;
	}

	public static URI createProxyURI(String typeName) {
		if (typeName == null)
			throw new NullPointerException("Type name is null");
		return URI.createGenericURI(PROXY_SCHEME, PROXY_OPAQUE_PART,
				URI.encodeFragment(typeName, false));
	}

	/**
	 * @param type
	 * @return
	 */
	public static Type createProxy(Type type) {
		final Type result = eINSTANCE.createType();
		if (type.isProxy()) {
			((InternalEObject) result).eSetProxyURI(((InternalEObject) type)
					.eProxyURI());
		} else {
			final String typeName = type.getName();
			result.setName(typeName);
			((InternalEObject) result).eSetProxyURI(createProxyURI(typeName));
		}
		return result;
	}

	public static boolean isTypeProxy(URI uri) {
		return PROXY_SCHEME.equals(uri.scheme())
				&& PROXY_OPAQUE_PART.equals(uri.opaquePart());
	}

	public static URI createProxyResourceURI() {
		return URI.createGenericURI(PROXY_SCHEME, PROXY_OPAQUE_PART, null);
	}

	public static EObject resolve(InternalEObject proxy, EObject objectContext) {
		if (proxy.eIsProxy()) {
			final Resource resource = objectContext.eResource();
			if (resource != null) {
				final ResourceSet resourceSet = resource.getResourceSet();
				if (resourceSet instanceof TypeInfoResourceSet) {
					return ((TypeInfoResourceSet) resourceSet).resolve(proxy,
							objectContext, resource);
				}
			}
			return EcoreUtil.resolve(proxy, objectContext);
		} else {
			return proxy;
		}
	}

	/**
	 * Tests if the declaring type of the specified member should be displayed
	 * in completion, etc.
	 * 
	 * @param member
	 * @return
	 */
	public static boolean isDeclaringTypeVisible(Member member) {
		return member.getDeclaringType() != null
				&& !(((EObject) member.getDeclaringType()).eContainer() instanceof RecordType);
	}

	/**
	 * Tests if the specified type expression should be displayed in completion,
	 * etc.
	 * 
	 * @param type
	 * @return
	 */
	public static boolean isValueTypeVisible(JSType type) {
		if (type == null) {
			return false;
		} else if (type instanceof UndefinedType) {
			return false;
		} else if (type instanceof RecordType) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Return {@link TypeKind} of the simple type in the specified runtime type
	 * or <code>null</code>.
	 * 
	 * @param type
	 * @return
	 */
	public static TypeKind kind(IRType type) {
		if (type != null) {
			if (type instanceof IRSimpleType) {
				final Type t = ((IRSimpleType) type).getTarget();
				if (t != null) {
					return t.getKind();
				}
			} else if (type instanceof IRClassType) {
				final Type t = ((IRClassType) type).getTarget();
				if (t != null) {
					return t.getKind();
				}
			}
		}
		return null;
	}

	public static List<Constructor> findConstructors(Type type) {
		final Set<Type> types = new HashSet<Type>();
		while (types.add(type)) {
			final List<Constructor> constructors = type.getConstructors();
			if (!constructors.isEmpty()) {
				return constructors;
			}
			if (!type.isInheritConstructors()) {
				break;
			}
			type = type.getSuperType();
			if (type == null) {
				break;
			}
		}
		return Collections.emptyList();
	}

	public static List<IRConstructor> findConstructors(IRTypeDeclaration type) {
		final Set<IRTypeDeclaration> types = new HashSet<IRTypeDeclaration>();
		while (types.add(type)) {
			final List<IRConstructor> constructors = type.getConstructors();
			if (!constructors.isEmpty()) {
				return constructors;
			}
			if (!type.getSource().isInheritConstructors()) {
				break;
			}
			type = type.getSuperType();
			if (type == null) {
				break;
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Creates EMF-based type expression, equivalent to the specified
	 * {@link IRType}.
	 * 
	 * @param type
	 *            nullable
	 * @return
	 */
	@Deprecated
	public static JSType createRType(IRType type) {
		if (type == null) {
			return null;
		}
		final RType result = eINSTANCE.createRType();
		result.setRuntimeType(type);
		return result;
	}

	/**
	 * Creates {@link TypeVariableReference} referencing the specified
	 * {@link TypeVariable}.
	 */
	@NonNull
	public static TypeVariableReference reference(@NonNull TypeVariable variable) {
		final TypeVariableReference reference = eINSTANCE
				.createTypeVariableReference();
		reference.setVariable(variable);
		return reference;
	}

	/**
	 * Checks if the specified type expression contains type variables.
	 */
	public static boolean containsTypeVariables(JSType type) {
		if (type != null) {
			final Boolean result = TypeInferencerVisitor.GENERIC_TYPE_EXPRESSION
					.doSwitch(type);
			return result != null && result.booleanValue();
		}
		return false;
	}

}
