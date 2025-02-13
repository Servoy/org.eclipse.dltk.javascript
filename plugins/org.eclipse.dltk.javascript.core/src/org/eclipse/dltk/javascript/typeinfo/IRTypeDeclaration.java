/*******************************************************************************
 * Copyright (c) 2012 NumberFour AG
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

import java.util.List;

import org.eclipse.dltk.annotations.Nullable;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeKind;

/**
 * Resolved type used during type inference. It is created based on the
 * {@link Type} model declaration by the {@link ITypeSystem}, for generic types
 * it can be also parameterized.
 * 
 * @see Type
 * @see ITypeSystem
 */
public interface IRTypeDeclaration
		extends IRElement {

	/**
	 * Returns the type system this instance was created by.
	 */
	ITypeSystem getTypeSystem();

	/**
	 * Returns the super type of this type or <code>null</code>
	 */
	@Nullable
	IRTypeDeclaration getSuperType();

	/**
	 * Returns list of traits/interfaces implemented by this type
	 */
	List<IRTypeDeclaration> getTraits();

	/**
	 * Returns list of members
	 * 
	 * @see IRMethod
	 * @see IRProperty
	 */
	List<IRMember> getMembers();

	/**
	 * Returns list of constructors callable via <code>new</code> operator
	 */
	List<IRConstructor> getConstructors();

	/**
	 * Returns the constructor which is called when this type is used as
	 * function, e.g. <code>String(1)</code>
	 */
	@Nullable
	IRConstructor getStaticConstructor();

	/**
	 * Returns the kind of this type, just delegates to {@link Type#getKind()}
	 */
	TypeKind getKind();

	/**
	 * Answers if static members of this type are accessible in the sub-types or
	 * not. Typically in JavaScript they are not, i.e. static members of
	 * <code>Object</code> are not accessible via <code>String</code> type
	 * reference, but in some libraries it could be different. At the moment
	 * this method delegates to {@link Type#isInheritStaticMembers()}.
	 */
	boolean isInheritStaticMembers();

	/**
	 * Returns the original model declaration of this type. This method just
	 * overrides the return type of the method, declared in the super type.
	 */
	Type getSource();

	Object getReadOnlyStatus(IRProperty property);

	/**
	 * Answers if this type is generic (possibly not parameterized yet).
	 */
	boolean isGeneric();

	/**
	 * Answers if this type is parameterized.
	 */
	boolean isParameterized();

	/**
	 * Answers type arguments of this parameterized type or empty array if not
	 * this type is not parameterized.
	 */
	List<IRType> getActualTypeArguments();

	/**
	 * Checks if type is compatible with the speciifed one.
	 */
	TypeCompatibility isAssignableFrom(IRTypeDeclaration declaration);

	/**
	 * Finds the method with the specified name and {@link IRMember#isStatic()}
	 * attribute.
	 */
	@Nullable
	IRMethod findMethod(String name, boolean isStatic);

}
