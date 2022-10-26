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
package org.eclipse.dltk.javascript.parser.old;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.dltk.javascript.ast.JSDeclaration;
import org.eclipse.dltk.javascript.ast.JSScope;
import org.eclipse.dltk.javascript.ast.LabelledStatement;

public class SymbolTable {
	private final Map<String, SymbolKind> symbols = new HashMap<String, SymbolKind>();

	private final Set<String> labels = new HashSet<String>();

	private final JSScope scope;

	public SymbolTable(JSScope scope) {
		this.scope = scope;
	}

	public SymbolKind canAdd(String name) {
		return symbols.get(name);
	}

	public SymbolKind add(String name, SymbolKind kind) {
		return add(name, kind, null);
	}

	public SymbolKind add(String name, SymbolKind kind, JSDeclaration node) {
		if (node != null) {
			scope.addDeclaration(node);
		}
		SymbolKind prev = symbols.get(name);
		if (prev != null) {
			return prev;
		}
		symbols.put(name, kind);
		return null;
	}

	public boolean addLabel(LabelledStatement statement) {
		final String label = statement.getLabel().getText();
		if (labels.contains(label)) {
			return false;
		}
		labels.add(label);
		return true;
	}

	public boolean hasLabel(String label) {
		return labels.contains(label);
	}
}
