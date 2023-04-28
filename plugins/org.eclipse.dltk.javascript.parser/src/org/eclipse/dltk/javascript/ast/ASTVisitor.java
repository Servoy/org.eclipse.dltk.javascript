/*******************************************************************************
 * Copyright (c) 2009-2013 xored software, Inc and NumberFour AG.  
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html  
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Vladimir Belov)
 *     NumberFour AG - multiple API improvements (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.ast;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.ast.v4.TagFunctionExpression;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringExpression;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringLiteral;

public abstract class ASTVisitor<E> implements INodeVisitor<E> {

	public E visit(Collection<? extends ASTNode> nodes) {
		E result = null;
		for (ASTNode node : nodes) {
			result = visit(node);
		}
		return result;
	}

	protected void visitList(Collection<? extends ASTNode> nodes) {
		for (ASTNode node : nodes) {
			visit(node);
		}
	}

	private static final Map<Class<? extends ASTNode>, Integer> HANDLERS = new HashMap<Class<? extends ASTNode>, Integer>();

	// generated block
	static {
		HANDLERS.put(ArrayInitializer.class, 0);
		HANDLERS.put(BinaryOperation.class, 1);
		HANDLERS.put(BooleanLiteral.class, 2);
		HANDLERS.put(BreakStatement.class, 3);
		HANDLERS.put(CallExpression.class, 4);
		HANDLERS.put(CommaExpression.class, 5);
		HANDLERS.put(ConditionalOperator.class, 6);
		HANDLERS.put(ConstStatement.class, 7);
		HANDLERS.put(ContinueStatement.class, 8);
		HANDLERS.put(DecimalLiteral.class, 9);
		HANDLERS.put(DoWhileStatement.class, 10);
		HANDLERS.put(EmptyExpression.class, 11);
		HANDLERS.put(ForStatement.class, 12);
		HANDLERS.put(ForInStatement.class, 13);
		HANDLERS.put(ForEachInStatement.class, 14);
		HANDLERS.put(FunctionStatement.class, 15);
		HANDLERS.put(GetArrayItemExpression.class, 16);
		HANDLERS.put(Identifier.class, 17);
		HANDLERS.put(IfStatement.class, 18);
		HANDLERS.put(LabelledStatement.class, 19);
		HANDLERS.put(NewExpression.class, 20);
		HANDLERS.put(NullExpression.class, 21);
		HANDLERS.put(ObjectInitializer.class, 22);
		HANDLERS.put(ParenthesizedExpression.class, 23);
		HANDLERS.put(PropertyExpression.class, 24);
		HANDLERS.put(RegExpLiteral.class, 25);
		HANDLERS.put(ReturnStatement.class, 26);
		HANDLERS.put(Script.class, 27);
		HANDLERS.put(StatementBlock.class, 28);
		HANDLERS.put(StringLiteral.class, 29);
		HANDLERS.put(SwitchStatement.class, 30);
		HANDLERS.put(ThisExpression.class, 31);
		HANDLERS.put(ThrowStatement.class, 32);
		HANDLERS.put(TryStatement.class, 33);
		HANDLERS.put(UnaryOperation.class, 34);
		HANDLERS.put(VariableStatement.class, 35);
		HANDLERS.put(VoidExpression.class, 36);
		HANDLERS.put(YieldOperator.class, 37);
		HANDLERS.put(WhileStatement.class, 38);
		HANDLERS.put(WithStatement.class, 39);
		HANDLERS.put(XmlLiteral.class, 40);
		HANDLERS.put(DefaultXmlNamespaceStatement.class, 41);
		HANDLERS.put(XmlAttributeIdentifier.class, 42);
		HANDLERS.put(AsteriskExpression.class, 43);
		HANDLERS.put(GetAllChildrenExpression.class, 44);
		HANDLERS.put(GetLocalNameExpression.class, 45);
		HANDLERS.put(ErrorExpression.class, 46);
		HANDLERS.put(EmptyStatement.class, 47);
		HANDLERS.put(ArrowFunctionStatement.class, 48);
		HANDLERS.put(TemplateStringLiteral.class, 49);
		HANDLERS.put(TagFunctionExpression.class, 50);
		HANDLERS.put(TemplateStringExpression.class, 51);
		
		HANDLERS.put(org.eclipse.dltk.javascript.ast.v3.BinaryOperation.class, 1);
		HANDLERS.put(org.eclipse.dltk.javascript.ast.v4.BinaryOperation.class, 1);
		HANDLERS.put(org.eclipse.dltk.javascript.ast.v3.UnaryOperation.class, 34);
		HANDLERS.put(org.eclipse.dltk.javascript.ast.v4.UnaryOperation.class, 34);
	}

	// generated function
	private final E handle(ASTNode node, int handlerIndex) {
		switch (handlerIndex) {
		case 0:
			return visitArrayInitializer((ArrayInitializer) node);
		case 1:
			return visitBinaryOperation((BinaryOperation) node);
		case 2:
			return visitBooleanLiteral((BooleanLiteral) node);
		case 3:
			return visitBreakStatement((BreakStatement) node);
		case 4:
			return visitCallExpression((CallExpression) node);
		case 5:
			return visitCommaExpression((CommaExpression) node);
		case 6:
			return visitConditionalOperator((ConditionalOperator) node);
		case 7:
			return visitConstDeclaration((ConstStatement) node);
		case 8:
			return visitContinueStatement((ContinueStatement) node);
		case 9:
			return visitDecimalLiteral((DecimalLiteral) node);
		case 10:
			return visitDoWhileStatement((DoWhileStatement) node);
		case 11:
			return visitEmptyExpression((EmptyExpression) node);
		case 12:
			return visitForStatement((ForStatement) node);
		case 13:
			return visitForInStatement((ForInStatement) node);
		case 14:
			return visitForEachInStatement((ForEachInStatement) node);
		case 15:
			return visitFunctionStatement((FunctionStatement) node);
		case 16:
			return visitGetArrayItemExpression((GetArrayItemExpression) node);
		case 17:
			return visitIdentifier((Identifier) node);
		case 18:
			return visitIfStatement((IfStatement) node);
		case 19:
			return visitLabelledStatement((LabelledStatement) node);
		case 20:
			return visitNewExpression((NewExpression) node);
		case 21:
			return visitNullExpression((NullExpression) node);
		case 22:
			return visitObjectInitializer((ObjectInitializer) node);
		case 23:
			return visitParenthesizedExpression((ParenthesizedExpression) node);
		case 24:
			return visitPropertyExpression((PropertyExpression) node);
		case 25:
			return visitRegExpLiteral((RegExpLiteral) node);
		case 26:
			return visitReturnStatement((ReturnStatement) node);
		case 27:
			return visitScript((Script) node);
		case 28:
			return visitStatementBlock((StatementBlock) node);
		case 29:
			return visitStringLiteral((StringLiteral) node);
		case 30:
			return visitSwitchStatement((SwitchStatement) node);
		case 31:
			return visitThisExpression((ThisExpression) node);
		case 32:
			return visitThrowStatement((ThrowStatement) node);
		case 33:
			return visitTryStatement((TryStatement) node);
		case 34:
			return visitUnaryOperation((UnaryOperation) node);
		case 35:
			return visitVariableStatement((VariableStatement) node);
		case 36:
			return visitVoidExpression((VoidExpression) node);
		case 37:
			return visitYieldOperator((YieldOperator) node);
		case 38:
			return visitWhileStatement((WhileStatement) node);
		case 39:
			return visitWithStatement((WithStatement) node);
		case 40:
			return visitXmlLiteral((XmlLiteral) node);
		case 41:
			return visitDefaultXmlNamespace((DefaultXmlNamespaceStatement) node);
		case 42:
			return visitXmlPropertyIdentifier((XmlAttributeIdentifier) node);
		case 43:
			return visitAsteriskExpression((AsteriskExpression) node);
		case 44:
			return visitGetAllChildrenExpression((GetAllChildrenExpression) node);
		case 45:
			return visitGetLocalNameExpression((GetLocalNameExpression) node);
		case 46:
			return visitErrorExpression((ErrorExpression) node);
		case 47:
			return visitEmptyStatement((EmptyStatement) node);
		case 48:
			return visitArrowFunction((ArrowFunctionStatement) node);
		case 49:
			return visitTemplateStringLiteral((TemplateStringLiteral) node);
		case 50:
			return visitTagFunction((TagFunctionExpression)node);
		case 51:
			return visitTemplateStringExpression((TemplateStringExpression)node);
		}
		return visitUnknownNode(node);
	}

	public E visit(ASTNode node) {
		if (node == null) {
			return null;
		}
		Integer handler = HANDLERS.get(node.getClass());
		if (handler != null) {
			return handle(node, handler.intValue());
		} else {
			if (node instanceof JSUserNode) {
				final ASTNode original = ((JSUserNode) node).getOriginal();
				if (original != null) {
					handler = HANDLERS.get(original.getClass());
					if (handler != null) {
						return handle(original, handler.intValue());
					}
				}
			}
			return visitUnknownNode(node);
		}
	}

	public abstract E visitArrayInitializer(ArrayInitializer node);

	public abstract E visitBinaryOperation(BinaryOperation node);

	public abstract E visitBooleanLiteral(BooleanLiteral node);

	public abstract E visitBreakStatement(BreakStatement node);

	public abstract E visitCallExpression(CallExpression node);

	@Deprecated
	public final E visitCaseClause(CaseClause node) {
		return null;
	}

	@Deprecated
	public final E visitCatchClause(CatchClause node) {
		return null;
	}

	public abstract E visitCommaExpression(CommaExpression node);

	public abstract E visitConditionalOperator(ConditionalOperator node);

	public abstract E visitConstDeclaration(ConstStatement node);

	public abstract E visitContinueStatement(ContinueStatement node);

	public abstract E visitDecimalLiteral(DecimalLiteral node);

	@Deprecated
	public final E visitDefaultClause(DefaultClause node) {
		return null;
	}

	public abstract E visitDoWhileStatement(DoWhileStatement node);

	public abstract E visitEmptyExpression(EmptyExpression node);

	@Deprecated
	public final E visitFinallyClause(FinallyClause node) {
		return null;
	}

	public abstract E visitForStatement(ForStatement node);

	public abstract E visitForInStatement(ForInStatement node);

	public abstract E visitForEachInStatement(ForEachInStatement node);

	public abstract E visitFunctionStatement(FunctionStatement node);

	@Deprecated
	public final E visitArgument(Argument argument) {
		return null;
	}

	public abstract E visitGetArrayItemExpression(GetArrayItemExpression node);

	@Deprecated
	public final E visitGetMethod(GetMethod node) {
		return null;
	}

	public abstract E visitIdentifier(Identifier node);

	public abstract E visitIfStatement(IfStatement node);

	@Deprecated
	public final E visitKeyword(Keyword node) {
		return null;
	}

	public abstract E visitLabelledStatement(LabelledStatement node);

	public abstract E visitNewExpression(NewExpression node);

	public abstract E visitNullExpression(NullExpression node);

	public abstract E visitObjectInitializer(ObjectInitializer node);

	public abstract E visitParenthesizedExpression(ParenthesizedExpression node);

	public abstract E visitPropertyExpression(PropertyExpression node);

	@Deprecated
	public final E visitPropertyInitializer(PropertyInitializer node) {
		return null;
	}

	public abstract E visitRegExpLiteral(RegExpLiteral node);

	public abstract E visitReturnStatement(ReturnStatement node);

	public abstract E visitScript(Script node);

	@Deprecated
	public final E visitSetMethod(SetMethod node) {
		return null;
	}

	public abstract E visitStatementBlock(StatementBlock node);

	public abstract E visitStringLiteral(StringLiteral node);

	public abstract E visitSwitchStatement(SwitchStatement node);

	public abstract E visitThisExpression(ThisExpression node);

	public abstract E visitThrowStatement(ThrowStatement node);

	public abstract E visitTryStatement(TryStatement node);

	public abstract E visitUnaryOperation(UnaryOperation node);

	public abstract E visitVariableStatement(VariableStatement node);

	@Deprecated
	public final E visitVariableDeclaration(VariableDeclaration node) {
		return null;
	}

	public abstract E visitVoidExpression(VoidExpression node);

	public abstract E visitYieldOperator(YieldOperator node);

	public abstract E visitWhileStatement(WhileStatement node);

	public abstract E visitWithStatement(WithStatement node);

	public abstract E visitXmlLiteral(XmlLiteral node);

	public abstract E visitDefaultXmlNamespace(DefaultXmlNamespaceStatement node);

	public abstract E visitXmlPropertyIdentifier(XmlAttributeIdentifier node);

	public abstract E visitAsteriskExpression(AsteriskExpression node);

	public abstract E visitGetAllChildrenExpression(
			GetAllChildrenExpression node);

	public abstract E visitGetLocalNameExpression(GetLocalNameExpression node);

	public E visitErrorExpression(ErrorExpression node) {
		return null;
	}

	public abstract E visitEmptyStatement(EmptyStatement node);
	
	public abstract E visitArrowFunction(ArrowFunctionStatement node);
	
	public abstract E visitTemplateStringLiteral(TemplateStringLiteral node);
	
	public abstract E visitTemplateStringExpression(TemplateStringExpression node);
	
	public abstract E visitTagFunction(TagFunctionExpression node);

	/**
	 * @since 2.0
	 */
	public E visitUnknownNode(ASTNode node) {
		throw new UnsupportedOperationException("Unknown node type: "
				+ node.getClass().getName());
	}

}
