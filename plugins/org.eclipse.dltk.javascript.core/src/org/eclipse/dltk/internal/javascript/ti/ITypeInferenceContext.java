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
package org.eclipse.dltk.internal.javascript.ti;

import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder;
import org.eclipse.dltk.javascript.typeinfo.IRMember;
import org.eclipse.dltk.javascript.typeinfo.ITypeInfoContext;
import org.eclipse.dltk.javascript.typeinfo.ITypeProvider;
import org.eclipse.dltk.javascript.typeinfo.TypeMode;

public interface ITypeInferenceContext extends ITypeInfoContext, IAdaptable {

	IRMember resolve(String name);

	Set<IRMember> resolveAll(String name);

	Set<String> listGlobals(String prefix);

	Set<String> listTypes(TypeMode mode, String prefix);

	IValueCollection getTopValueCollection();

	IModelBuilder[] getModelBuilders();

	ITypeProvider[] getTypeProviders();

}
