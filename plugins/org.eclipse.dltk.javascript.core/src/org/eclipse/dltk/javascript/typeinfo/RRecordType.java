/*******************************************************************************
 * Copyright (c) 2011,2012 NumberFour AG
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

import static org.eclipse.dltk.javascript.typeinfo.RTypes.any;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IValidationStatus;
import org.eclipse.dltk.javascript.internal.core.RRecordMember;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.emf.common.util.EList;

class RRecordType extends RType implements IRRecordType, IRTypeExtension {

	private final Map<String, IRRecordMember> members = new LinkedHashMap<String, IRRecordMember>();

	public RRecordType() {
	}

	public RRecordType(ITypeSystem context, Collection<Member> members) {
		for (Member member : members) {
			final JSType type = member.getType();
			this.members.put(
					member.getName(),
					new RRecordMember(member.getName(), type != null ? RTypes
							.create(context, type) : any(), member));
		}
	}

	public RRecordType(Collection<IRRecordMember> members) {
		for (IRRecordMember member : members) {
			this.members.put(member.getName(), member);
		}
	}

	public void init(ITypeSystem context, EList<Member> members) {
		for (Member member : members) {
			final JSType type = member.getType();
			this.members.put(
					member.getName(),
					new RRecordMember(member.getName(), type != null ? RTypes
							.create(context, type) : any(), member));
		}
	}

	@Override
	public String toString(Set<RType> processed) {
		if (!processed.add(this))
			return "{_self}";
		final StringBuilder sb = new StringBuilder();
		sb.append('{');
		for (IRRecordMember member : members.values()) {
			if (sb.length() > 1) {
				sb.append(',');
			}
			sb.append(member.getName());
			if (member.getType() != RTypes.any()) {
				sb.append(':');
				if (member.getType() instanceof RType) {
					sb.append(((RType) member.getType()).toString(processed));
				} else {
					sb.append(member.getType().getName());
				}
			}
			if (member.isOptional()) {
				sb.append('=');
			}
		}
		sb.append('}');
		return sb.toString();
	}

	public String getName() {
		return toString(new HashSet<RType>());
	}

	public IRRecordMember getMember(String name) {
		return members.get(name);
	}

	public Collection<IRRecordMember> getMembers() {
		return members.values();
	}

	@Override
	public TypeCompatibility isAssignableFrom(IRType type) {
		if (super.isAssignableFrom(type).ok()) {
			return TypeCompatibility.TRUE;
		} else if (type instanceof RRecordType) {
			return assignableFromRecordType((RRecordType) type);
		} else {
			return TypeCompatibility.FALSE;
		}
	}

	private TypeCompatibility assignableFromRecordType(RRecordType other) {
		final Map<String, IRRecordMember> others = other.members;
		if (members.isEmpty() && others.isEmpty()) {
			return TypeCompatibility.TRUE;
		}
		int hits = 0;
		for (Map.Entry<String, IRRecordMember> entry : others.entrySet()) {
			final IRRecordMember member = members.get(entry.getKey());
			if (member == null) {
				continue;
			}
			if (!member.getType().isAssignableFrom(entry.getValue().getType())
					.ok()) {
				return TypeCompatibility.FALSE;
			}
			++hits;
		}
		for (Map.Entry<String, IRRecordMember> entry : members.entrySet()) {
			if (!entry.getValue().isOptional()
					&& !others.containsKey(entry.getKey())) {
				return TypeCompatibility.FALSE;
			}
		}
		return hits != 0 ? TypeCompatibility.TRUE : TypeCompatibility.FALSE;
	}

	public IValidationStatus isAssignableFrom(IValueReference argument) {
		if (argument == null)
			return TypeCompatibility.TRUE;
		final IRRecordType other = RTypes.recordType(argument);
		return other != RTypes.emptyRecordType() ? assignableFromRecordType((RRecordType) other)
				: TypeCompatibility.FALSE;
	}

	@Override
	public int hashCode() {
		return members.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RRecordType) {
			final RRecordType other = (RRecordType) obj;
			return members.equals(other.members);
		}
		return false;
	}

}
