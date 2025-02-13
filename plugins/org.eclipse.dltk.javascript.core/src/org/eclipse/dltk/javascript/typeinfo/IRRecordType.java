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

import java.util.Collection;

import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.emf.common.util.EList;

public interface IRRecordType extends IRType, ImmutableType<IRRecordType> {

	IRRecordMember getMember(String name);

	Collection<IRRecordMember> getMembers();

	void init(ITypeSystem context, EList<Member> members);

}
