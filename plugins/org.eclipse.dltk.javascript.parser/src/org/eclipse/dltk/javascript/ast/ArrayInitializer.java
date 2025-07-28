/*******************************************************************************
 * Copyright (c) 2009 xored software, Inc.  
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html  
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Vladimir Belov)
 *******************************************************************************/
package org.eclipse.dltk.javascript.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.utils.IntList;

public class ArrayInitializer extends Expression implements IDestructuringPattern {

	private final List<Expression> items;
	private final IntList commas;
	private int LB = -1;
	private int RB = -1;
	private boolean isDestructuring = false;

	public ArrayInitializer(JSNode parent, int itemCount) {
		super(parent);
		items = new ArrayList<Expression>(itemCount);
		commas = new IntList(itemCount > 0 ? itemCount - 1 : 0);
	}

	public ArrayInitializer(JSNode parent) {
		super(parent);
		this.commas = new IntList();
		items = new ArrayList<Expression>();
	}

	/**
	 * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			if (items != null) {
				for (ASTNode node : items) {
					node.traverse(visitor);
				}
			}
			visitor.endvisit(this);
		}
	}

	public List<Expression> getItems() {
		return this.items;
	}

	public IntList getCommas() {
		return this.commas;
	}

	public int getLB() {
		return this.LB;
	}

	public void setLB(int pos) {
		this.LB = pos;
	}

	public int getRB() {
		return this.RB;
	}

	public void setRB(int pos) {
		this.RB = pos;
	}

	@Override
	public String toSourceString(String indentionString) {

		Assert.isTrue(sourceStart() >= 0);
		Assert.isTrue(sourceEnd() > 0);
		Assert.isTrue(LB >= 0);
		Assert.isTrue(RB > 0);
		Assert.isTrue(items.size() == 0 || commas.size() == items.size() - 1);

		StringBuilder buffer = new StringBuilder();

		buffer.append(Keywords.LB);

		for (int i = 0; i < items.size(); i++) {
			if (i > 0)
				buffer.append(", ");

			buffer.append(toSourceString(items.get(i), indentionString));
		}

		buffer.append(Keywords.RB);

		return buffer.toString();
	}

	@Override
	public void setIsDestructuring(boolean markDestructuring) {
		this.isDestructuring  = markDestructuring;		
	}
	
	@Override
	public boolean isDestructuring() {
        return this.isDestructuring;
    }

	@Override
	public List<Identifier> getIdentifiers() {
		return items.stream().map(item -> {
			if (item instanceof Identifier id) {
				return id;
			} else if (item instanceof BindingIdentifier binding) {
				return binding.getIdentifier();
			} else {
				return null;
			}
		}).filter(Objects::nonNull).toList();
	}

	@Override
	public Expression getInitializerFor(String name, Expression value) {
		if (!(value instanceof ArrayInitializer)) return null;
		ArrayInitializer rhs = (ArrayInitializer) value;
		for (int i = 0; i < items.size(); i++) {
			Expression lhsItem = items.get(i);
			if (lhsItem instanceof Identifier) {
				Identifier id = (Identifier) lhsItem;
				if (name.equals(id.getName()) && i < rhs.getItems().size()) {
					return rhs.getItems().get(i);
				}
			} else if (lhsItem instanceof BindingIdentifier binding) {
				Identifier id = binding.getIdentifier();
				if (id != null && name.equals(id.getName())) {
					if (i < rhs.getItems().size()) {
						Expression init = rhs.getItems().get(i);
						if (init == null || init instanceof EmptyExpression || "undefined".equals(init.toString()) ) {
							return binding.getDefaultValue(); // fallback to default
						}
						return init;
					}
					return binding.getDefaultValue();
				}
			}
		}
		return null;
	}
}
