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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RUnionType extends RType implements IRUnionType {

	final Set<IRType> targets = new LinkedHashSet<IRType>();

	public RUnionType(Collection<IRType> targets) {
		assert !targets.contains(null);
		this.targets.addAll(targets);
	}

	public String getName() {
		final StringBuilder sb = new StringBuilder();
		for (IRType type : targets) {
			if (sb.length() != 0) {
				sb.append('|');
			}
			sb.append(type.getName());
		}
		return sb.toString();
	}

	@Override
	public TypeCompatibility isAssignableFrom(IRType type) {
		if (type instanceof IRUnionType) {
			Set<IRType> targets = ((IRUnionType) type).getTargets();
			if (this.targets.containsAll(targets)) {
				return TypeCompatibility.TRUE;
			}
			Set<IRType> compartible = new HashSet<IRType>();
			for (IRType myTarget : this.targets) {
				for (IRType theirTarget : targets) {
					if (myTarget.isAssignableFrom(theirTarget) == TypeCompatibility.TRUE) {
						compartible.add(theirTarget);
					}
				}
			}
			if (compartible.size() == targets.size())
				return TypeCompatibility.TRUE;
			return TypeCompatibility.FALSE;
		}
		for (IRType target : targets) {
			if (target.isAssignableFrom(type).ok()) {
				return TypeCompatibility.TRUE;
			}
		}
		return TypeCompatibility.FALSE;
	}

	public Set<IRType> getTargets() {
		return Collections.unmodifiableSet(targets);
	}

	@Override
	public int hashCode() {
		return targets.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RUnionType) {
			final RUnionType other = (RUnionType) obj;
			return targets.equals(other.targets);
		}
		return false;
	}

}
