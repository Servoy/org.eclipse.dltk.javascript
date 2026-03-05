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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.utils.CompoundIterator;

/**
 * Returns all the members defined by the specified type(s) and all it's super
 * types and implemented traits.
 * 
 * Types are visited in the breadth-first order (current type, super type,
 * traits), so the overriding methods are visited first. By default overridden
 * methods are returned multiple times, if you want to skip duplicates and have
 * only the actual implementations then use the {@link Iterable} returned by
 * {@link #ignoreDuplicates()}.
 */
public class RTypeMemberQuery implements Iterable<IRMember> {

	private static class QueueItem {
		final IRTypeDeclaration type;
		final MemberPredicate predicate;

		public QueueItem(IRTypeDeclaration type, MemberPredicate predicate) {
			this.type = type;
			this.predicate = predicate;
		}

		@Override
		public int hashCode() {
			return type.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof QueueItem) {
				final QueueItem other = (QueueItem) obj;
				return type.equals(other.type)
						&& predicate.equals(other.predicate);
			}
			return false;
		}

		@Override
		public String toString() {
			return predicate + ":" + type.getName();
		}

	}

	final List<QueueItem> types = new ArrayList<QueueItem>();

	/**
	 * Creates empty query
	 */
	public RTypeMemberQuery() {
	}

	/**
	 * Creates query for all the members of the specified type.
	 */
	public RTypeMemberQuery(IRTypeDeclaration type) {
		add(type);
	}

	/**
	 * Creates query for the members of the specified type matching the
	 * specified predicate.
	 * 
	 * @see MemberPredicates
	 */
	public RTypeMemberQuery(IRTypeDeclaration type, MemberPredicate predicate) {
		add(type, predicate);
	}

	/**
	 * Adds the specified type to this query
	 */
	public void add(IRTypeDeclaration type) {
		add(type, MemberPredicates.ALWAYS_TRUE);
	}

	/**
	 * Adds the specified type with the specified predicate to this query.
	 */
	public void add(IRTypeDeclaration type, MemberPredicate predicate) {
		Assert.isNotNull(type);
		types.add(new QueueItem(type, predicate));
	}

	protected boolean isValid(IRTypeDeclaration type) {
		return true;
	}

	private class TypeIterator extends CompoundIterator<QueueItem> {
		private final Set<QueueItem> visited = new HashSet<QueueItem>();
		private final List<QueueItem> queue = new ArrayList<QueueItem>();

		public TypeIterator(int mode) {
			if (mode == ALL) {
				queue.addAll(types);
			} else {
				assert mode == SUPERTYPES;
				for (QueueItem qi : types) {
					final IRTypeDeclaration type = qi.type;
					final IRTypeDeclaration superType = type.getSuperType();
					if (superType != null) {
						queue.add(new QueueItem(superType, qi.predicate));
					}
					for (IRTypeDeclaration trait : type.getTraits()) {
						queue.add(new QueueItem(trait, qi.predicate));
					}
				}
			}
			current = queue.iterator();
		}

		private boolean canVisit(QueueItem item) {
			return visited.add(item);
		}

		@Override
		protected boolean fetchNext() {
			if (!queue.isEmpty()) {
				final QueueItem[] copy = queue.toArray(new QueueItem[queue
						.size()]);
				queue.clear();
				for (QueueItem item : copy) {
					final IRTypeDeclaration type = item.type;
					final IRTypeDeclaration superType = type.getSuperType();
					if (superType != null) {
						final QueueItem superItem = new QueueItem(superType,
								item.predicate);
						if (canVisit(superItem) && isValid(superType)) {
							queue.add(superItem);
						}
					}
					for (IRTypeDeclaration trait : type.getTraits()) {
						final QueueItem traitItem = new QueueItem(trait,
								item.predicate);
						if (canVisit(traitItem) && isValid(trait)) {
							queue.add(traitItem);
						}
					}
				}
				current = queue.iterator();
				return current.hasNext();
			}
			return false;
		}
	}

	static final int ALL = 0;
	static final int SUPERTYPES = 1;

	private class MemberIterator extends CompoundIterator<IRMember> {

		private final TypeIterator typeIterator;
		private final Set<IRTypeDeclaration> entrypoints = new HashSet<IRTypeDeclaration>();

		public MemberIterator(int mode) {
			for (QueueItem item : types) {
				entrypoints.add(item.type);
			}
			typeIterator = new TypeIterator(mode);
			current = Collections.<IRMember> emptyList().iterator();
		}

		private Collection<IRMember> filter(Collection<IRMember> members) {
			final List<IRMember> result = new ArrayList<IRMember>();
			for (IRMember member : members) {
				if (isValid(member)) {
					result.add(member);
				}
			}
			return result;
		}

		protected boolean isValid(IRMember member) {
			if (member.isStatic()) {
				final IRTypeDeclaration owner = member.getDeclaringType();
				return owner != null
						&& (owner.isInheritStaticMembers() || entrypoints
								.contains(owner));
			} else {
				return true;
			}
		}

		@Override
		protected boolean fetchNext() {
			while (typeIterator.hasNext()) {
				final QueueItem item = typeIterator.next();
				final List<IRMember> members = item.type.getMembers();
				if (item.predicate == MemberPredicates.ALWAYS_TRUE) {
					current = filter(members).iterator();
				} else {
					final List<IRMember> filtered = new ArrayList<IRMember>(
							members.size());
					for (IRMember member : members) {
						if (item.predicate.evaluate(member) && isValid(member)) {
							filtered.add(member);
						}
					}
					current = filtered.iterator();
				}
				if (current.hasNext()) {
					return true;
				}
			}
			return false;
		}

	}

	public Iterator<IRMember> iterator() {
		return new MemberIterator(ALL);
	}

	/**
	 * Iterates over the members ignoring the duplicates, e.g. members with the
	 * same name.
	 * 
	 * <p>
	 * If there is an abstract and a normal method, both with the same name,
	 * normal method is returned. If there are two normal methods (or two
	 * abstract ones), the one that is closer to the given type in the
	 * inheritance chain is returned. Otherwise it's unspecified which one of
	 * the duplicated members is returned.
	 * </p>
	 */
	private class IgnoreDuplicateMemberIterator extends MemberIterator {

		private final Set<Object> processed = new HashSet<Object>();
		private final Collection<String> ignored;
		private final List<Object> abstractMethods = new ArrayList<Object>();
		private final Predicate<IRMember> filter;

		public IgnoreDuplicateMemberIterator(Collection<String> ignoreMembers,
				Predicate<IRMember> filter) {
			super(ALL);
			this.filter = filter != null ? filter : member -> true;
			this.ignored = ignoreMembers != null ? ignoreMembers : Collections
					.<String> emptySet();
		}

		@Override
		protected boolean isValid(IRMember member) {
			if (filter.test(member) && super.isValid(member)
					&& !ignored.contains(member.getName())) {
				final Object key = MethodKey.createKey(member);
				if (member instanceof IRMethod
						&& ((IRMethod) member).isAbstract()) {
					if (!processed.contains(key)) {
						abstractMethods.add(key);
						abstractMethods.add(member);
					}
					return false;
				} else {
					return processed.add(key);
				}
			} else {
				return false;
			}
		}

		@Override
		protected boolean fetchNext() {
			final boolean result = super.fetchNext();
			if (!result) {
				if (!abstractMethods.isEmpty()) {
					final List<IRMember> queue = new ArrayList<IRMember>();
					for (int i = 0; i < abstractMethods.size(); i += 2) {
						if (processed.add(abstractMethods.get(i))) {
							queue.add((IRMember) abstractMethods.get(i + 1));
						}
					}
					abstractMethods.clear();
					if (!queue.isEmpty()) {
						current = queue.iterator();
						return true;
					}
				}
			}
			return result;
		}
	}

	private static class MemberKey {
		final String name;
		final boolean isStatic;

		public MemberKey(IRMember member) {
			this.name = member.getName();
			this.isStatic = member.isStatic();
		}

		@Override
		public int hashCode() {
			return name.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof MemberKey) {
				final MemberKey other = (MemberKey) obj;
				return name.equals(other.name) && isStatic == other.isStatic;
			}
			return false;
		}
	}

	private static class MethodKey {
		final String name;
		final boolean isStatic;
		final String signature;

		/**
		 * @param name
		 */
		public MethodKey(IRMethod method) {
			this.name = method.getName();
			this.isStatic = method.isStatic();
			StringBuilder sb = new StringBuilder();
			for (IRParameter parameter : method.getParameters()) {
				final IRType paramType = parameter.getType();
				if (paramType != null) {
					sb.append(paramType.getName());
				}
				sb.append(',');
			}
			this.signature = sb.toString();
		}

		@Override
		public int hashCode() {
			return name.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof MethodKey) {
				final MethodKey other = (MethodKey) obj;
				return name.equals(other.name) && isStatic == other.isStatic
						&& signature.equals(other.signature);
			}
			return false;
		}

		protected static Object createKey(IRMember member) {
			if (member instanceof IRMethod && member.getDeclaringType() != null
					&& member.getDeclaringType().getSource().isJavaKind()) {
				return new MethodKey((IRMethod) member);
			} else {
				return new MemberKey(member);
			}
		}

	}

	/**
	 * Iterates over type members skipping overloaded methods
	 */
	public Iterable<IRMember> ignoreDuplicates(Predicate<IRMember> filter) {
		return ignoreDuplicates(null, filter);
	}

	/**
	 * Iterates over type members skipping overloaded methods and also skipping
	 * the specified members
	 * 
	 * @param ignoreMembers
	 *            member names to skip or <code>null</code> if nothing to skip
	 */
	public Iterable<IRMember> ignoreDuplicates(
			final Collection<String> ignoreMembers,
			Predicate<IRMember> filter) {
		return new Iterable<IRMember>() {
			public Iterator<IRMember> iterator() {
				return new IgnoreDuplicateMemberIterator(ignoreMembers, filter);
			}
		};
	}

	/**
	 * Finds the member with the specified name. Returns the member found or
	 * <code>null</code> otherwise.
	 */
	public IRMember findMember(String memberName) {
		for (IRMember member : this) {
			if (memberName.equals(member.getName())) {
				return member;
			}
		}
		return null;
	}

	/**
	 * Finds the member of the specified type with the specified name. Returns
	 * the member found or <code>null</code> otherwise.
	 */
	@SuppressWarnings("unchecked")
	protected <T extends IRMember> T findMember(String memberName,
			Class<T> memberType) {
		for (IRMember member : this) {
			if (memberType.isInstance(member)
					&& memberName.equals(member.getName())) {
				return (T) member;
			}
		}
		return null;
	}

	/**
	 * Finds the method with the specified name.
	 */
	public IRMethod findMethod(String methodName) {
		return findMember(methodName, IRMethod.class);
	}

	/**
	 * Finds the property with the specified name.
	 */
	public IRProperty findProperty(String propertyName) {
		return findMember(propertyName, IRProperty.class);
	}

	/**
	 * Checks if this query contains the specified type.
	 */
	public boolean contains(IRTypeDeclaration type) {
		for (QueueItem item : types) {
			if (type == item.type) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + types;
	}

	/**
	 * Finds the super method with the specified name.
	 */
	public IRMethod findSuperMethod(String methodName) {
		for (Iterator<IRMember> i = new MemberIterator(SUPERTYPES); i.hasNext();) {
			final IRMember member = i.next();
			if (member instanceof IRMethod
					&& methodName.equals(member.getName())) {
				return (IRMethod) member;
			}
		}
		return null;
	}

}
