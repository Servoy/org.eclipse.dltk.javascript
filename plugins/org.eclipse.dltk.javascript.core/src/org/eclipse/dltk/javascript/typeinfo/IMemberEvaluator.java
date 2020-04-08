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

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.dltk.annotations.ConfigurationElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.javascript.typeinference.IValueCollection;
import org.eclipse.dltk.javascript.typeinfo.model.Element;

@ConfigurationElement("evaluator")
public interface IMemberEvaluator {

	/**
	 * @param member
	 * @return
	 */
	IValueCollection valueOf(ITypeInfoContext context, Element member);

	IValueCollection getTopValueCollection(ITypeInfoContext context);

	Collection<IFile> getDependencies(ISourceModule sourceModule);

}
