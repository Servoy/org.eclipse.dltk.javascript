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

import java.util.Set;

import org.eclipse.dltk.annotations.ConfigurationElement;
import org.eclipse.dltk.javascript.typeinfo.model.Member;

@ConfigurationElement("resolver")
public interface IElementResolver {
	/**
	 * @since 5.1
	 */
	Set<Member> resolveElements(ITypeInfoContext context, String name);

	Member resolveElement(ITypeInfoContext context, String name);

	/**
	 * @param context
	 * @param prefix
	 *            the prefix, not <code>null</code>
	 * @return
	 */
	Set<String> listGlobals(ITypeInfoContext context, String prefix);
}
