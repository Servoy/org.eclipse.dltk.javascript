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
package org.eclipse.dltk.javascript.internal.ui.text.folding;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.dltk.annotations.Internal;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IMethod;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IModelElementVisitor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.core.SourceParserUtil;
import org.eclipse.dltk.javascript.ast.AbstractNavigationVisitor;
import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.IVariableStatement;
import org.eclipse.dltk.javascript.ast.Method;
import org.eclipse.dltk.javascript.ast.ObjectInitializer;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.StringLiteral;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.XmlLiteral;
import org.eclipse.dltk.javascript.parser.JavaScriptParser;
import org.eclipse.dltk.javascript.parser.JavascriptParserPreferences;
import org.eclipse.dltk.javascript.parser.PropertyExpressionUtils;
import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.dltk.ui.text.folding.IFoldingBlockProvider;
import org.eclipse.dltk.ui.text.folding.IFoldingBlockRequestor;
import org.eclipse.dltk.ui.text.folding.IFoldingContent;
import org.eclipse.jface.preference.IPreferenceStore;

public class JavaScriptCodeFoldingBlockProvider extends
		AbstractNavigationVisitor<Object> implements IFoldingBlockProvider {

	private static Script parse(IFoldingContent content) {
		if (content.getModelElement() instanceof ISourceModule) {
			IModuleDeclaration declaration = SourceParserUtil.parse(
					(ISourceModule) content.getModelElement(), null);
			if (declaration instanceof Script) {
				return (Script) declaration;
			}
		}
		boolean antlr4Parser = new JavascriptParserPreferences().useES6Parser();
		return antlr4Parser
				? new org.eclipse.dltk.javascript.parser.v4.JavaScriptParser()
						.parse(content, null)
				: new JavaScriptParser().parse(content, null);
	}

	private boolean collapseMethods;
	private boolean collapseObjectInitializers;
	private boolean collapseXml;
	private boolean collapseStrings;
	private int fBlockLinesMin;

	public void initializePreferences(IPreferenceStore preferenceStore) {
		collapseMethods = preferenceStore
				.getBoolean(PreferenceConstants.EDITOR_FOLDING_INIT_METHODS);
		fBlockLinesMin = preferenceStore
				.getInt(PreferenceConstants.EDITOR_FOLDING_LINES_LIMIT);
	}

	public int getMinimalLineCount() {
		return fBlockLinesMin;
	}

	private IFoldingBlockRequestor requestor;

	public void setRequestor(IFoldingBlockRequestor requestor) {
		this.requestor = requestor;
	}

	@SuppressWarnings("serial")
	@Internal
	static class MethodCollector extends HashMap<Integer, IModelElement>
			implements IModelElementVisitor {

		public boolean visit(IModelElement element) {
			if (element instanceof IMethod) {
				try {
					final ISourceRange range = ((IMethod) element)
							.getSourceRange();
					// end offset works for both function declarations and
					// expressions.
					put(range.getOffset() + range.getLength(), element);
				} catch (ModelException e) {
					// empty
				}
			}
			return true;
		}
	}

	private final MethodCollector methodCollector = new MethodCollector();

	public void computeFoldableBlocks(IFoldingContent content) {
		names.clear();
		final Script script = parse(content);
		if (script != null) {
			methodCollector.clear();
			try {
				content.getModelElement().accept(methodCollector);
			} catch (ModelException e) {
				if (DLTKCore.DEBUG) {
					e.printStackTrace();
				}
			}
			visitScript(script);
			names.clear();
		}
	}

	@Override
	public Object visitFunctionStatement(FunctionStatement node) {
		final IModelElement element = methodCollector.get(node.end());

		requestor.acceptBlock(node.sourceStart(), node.sourceEnd(),
				JavaScriptFoldingBlockKind.FUNCTION, element, collapseMethods);
		return super.visitFunctionStatement(node);
	}

	@Override
	protected Object visitMethod(Method method) {
		requestor.acceptBlock(method.sourceStart(), method.sourceEnd(),
				JavaScriptFoldingBlockKind.FUNCTION, null, collapseMethods);
		return super.visitMethod(method);
	}

	@Override
	public Object visitObjectInitializer(ObjectInitializer node) {
		if (node.isMultiline()) {
			final Key assignemtKey = getAssignementKey(node.getParent());
			if (assignemtKey != null) {
				requestor.acceptBlock(node.sourceStart(), node.sourceEnd(),
						JavaScriptFoldingBlockKind.OBJECT_INITIALIZER,
						assignemtKey, collapseObjectInitializers);
			}
		}
		return super.visitObjectInitializer(node);
	}

	private Key getAssignementKey(ASTNode node) {
		if (node instanceof VariableDeclaration) {
			final VariableDeclaration declaration = (VariableDeclaration) node;
			final IVariableStatement statement = (IVariableStatement) declaration
					.getParent();
			if (statement.getVariables().size() == 1) {
				return registerName(declaration.getVariableName(),
						declaration.getIdentifier());
			}
		} else if (node instanceof BinaryOperation) {
			final BinaryOperation operation = (BinaryOperation) node;
			if (operation.isAssignOperator()) {
				final String path = PropertyExpressionUtils.getPath(operation
						.getLeftExpression());
				if (path != null) {
					return registerName(path, operation.getLeftExpression());
				}
			}
		}
		return null;
	}

	@Override
	public Object visitBinaryOperation(BinaryOperation node) {
		if (node.isAssignOperator()) {
			final Expression expression = node.getLeftExpression();
			final String name = PropertyExpressionUtils.getPath(expression);
			if (name != null) {
				registerName(name, expression);
			}
		}
		return super.visitBinaryOperation(node);
	}

	@Override
	public Object visitVariableStatement(VariableStatement node) {
		for (VariableDeclaration declaration : node.getVariables()) {
			registerName(declaration.getVariableName(), declaration);
		}
		return super.visitVariableStatement(node);
	}

	private static class Key {
		final String name;
		final int occurence;

		public Key(String name, int occurence) {
			this.name = name;
			this.occurence = occurence;
		}

		@Override
		public int hashCode() {
			return name.hashCode() * 31 + occurence;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Key) {
				final Key other = (Key) obj;
				return occurence == other.occurence && name.equals(other.name);
			}
			return false;
		}

	}

	@SuppressWarnings("serial")
	private static class Scope extends IdentityHashMap<ASTNode, Key> {
		final String name;

		public Scope(String name) {
			this.name = name;
		}

		private int lastValue;

		Key getKey(ASTNode node) {
			Key key = get(node);
			if (key == null) {
				key = new Key(name, lastValue++);
				put(node, key);
			}
			return key;
		}
	}

	private final Map<String, Scope> names = new HashMap<String, Scope>();

	private Key registerName(String name, ASTNode node) {
		Scope scope = names.get(name);
		if (scope == null) {
			scope = new Scope(name);
			names.put(name, scope);
		}
		return scope.getKey(node);
	}

	@Override
	public Object visitXmlLiteral(XmlLiteral node) {
		requestor.acceptBlock(node.sourceStart(), node.sourceEnd(),
				JavaScriptFoldingBlockKind.XML, null, collapseXml);
		return super.visitXmlLiteral(node);
	}

	@Override
	public Object visitStringLiteral(StringLiteral node) {
		requestor.acceptBlock(node.sourceStart(), node.sourceEnd(),
				JavaScriptFoldingBlockKind.MULTILINESTRING, null,
				collapseStrings);
		return super.visitStringLiteral(node);
	}
}
