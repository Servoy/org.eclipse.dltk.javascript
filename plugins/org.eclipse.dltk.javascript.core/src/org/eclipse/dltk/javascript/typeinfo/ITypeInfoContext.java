/*******************************************************************************
 * Copyright (c) 2010 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.typeinfo;

import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.SimpleType;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;

public interface ITypeInfoContext extends ITypeSystem {

	/**
	 * Returns the {@link Type} with the specified name. If there is already an
	 * active call to the {@link ITypeProvider} then a proxy is returned. If
	 * type couldn't be found then {@link TypeKind#UNKNOWN} type is returned.
	 * 
	 * @param typeName
	 * @return
	 */
	Type getType(String typeName);

	/**
	 * Calls {@link #getType(String)} and wraps the result as {@link SimpleType}
	 * 
	 * @param typeName
	 * @return
	 */
	SimpleType getTypeRef(String typeName);

	/**
	 * Returns the {@link Type} with the specified name. The only difference if
	 * compared to {@link #getType(String)} is that this function returns
	 * <code>null</code> instead of {@link TypeKind#UNKNOWN} type.
	 * 
	 * @param typeName
	 *            the name of the type
	 * @param mode
	 *            the mode or <code>null</code> if unknown
	 * @since 3.0
	 */
	Type getKnownType(String typeName, TypeMode mode);

	/**
	 * Returns the model element being processed or <code>null</code>
	 * 
	 * @return
	 */
	IModelElement getModelElement();

	/**
	 * Returns the source being processed or <code>null</code>
	 * 
	 * @return
	 */
	ReferenceSource getSource();

	/**
	 * Returns current value for the specified attribute.
	 * 
	 * @param key
	 * @return
	 */
	<T> T getAttribute(AttributeKey<T> key);

	/**
	 * Adds value for the specified attribute.
	 * 
	 * Current value of the attribute can be retrieved with
	 * {@link ITypeSystem#getAttribute(AttributeKey)}.
	 * 
	 * @param key
	 * @param value
	 */
	<T> void pushAttribute(AttributeKey<T> key, T value);

	/**
	 * Removes last added value for the specified attribute.
	 * 
	 * @param key
	 * @return
	 */
	<T> T popAttribute(AttributeKey<T> key);

	/**
	 * Returns the collection representing the current local scope of the
	 * evaluated code.
	 */
	IValueCollection currentCollection();

	/**
	 * Returns the references to the registered local type with the specified
	 * name, if no such types registered then empty array is returned.
	 */
	ILocalTypeReference[] getLocalTypes(String name);

	/**
	 * Registers the specified local type as "local" (if multiple types with the
	 * same name are registered then the first one which is enabled will be
	 * used). Returns the type reference, which can be used to disable it
	 * temporary.
	 */
	ILocalTypeReference registerLocalType(Type type);

	/**
	 * Attribute used by {@link #contextualize(IRType)}.
	 */
	static final AttributeKey<IRTypeDeclaration> CONTEXTUALIZE_WITH = new AttributeKey<IRTypeDeclaration>();

	/**
	 * Converts the specified type expression to the resolved type expression
	 * and contextualizes it by replacing contextualizable type expressions with
	 * the value of {@link #CONTEXTUALIZE_WITH} attribute.
	 */
	IRType contextualize(JSType type);

	/**
	 * looks if it can generate an IValue type from the given JSType
	 * 
	 * @param type
	 * @return
	 */
	IRIValueType getIValueType(String name);
}
