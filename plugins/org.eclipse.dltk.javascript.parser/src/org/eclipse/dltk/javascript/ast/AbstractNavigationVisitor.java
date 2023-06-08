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
package org.eclipse.dltk.javascript.ast;

import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.ast.v4.ForOfStatement;
import org.eclipse.dltk.javascript.ast.v4.TagFunctionExpression;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringExpression;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringLiteral;

public class AbstractNavigationVisitor<E> extends ASTVisitor<E> {

	@Override
	public E visitArrayInitializer(ArrayInitializer node) {
		for (ASTNode item : node.getItems()) {
			visit(item);
		}
		return null;
	}

	@Override
	public E visitAsteriskExpression(AsteriskExpression node) {
		return null;
	}

	@Override
	public E visitBinaryOperation(BinaryOperation node) {
		visit(node.getLeftExpression());
		visit(node.getRightExpression());
		return null;
	}

	@Override
	public E visitBooleanLiteral(BooleanLiteral node) {
		return null;
	}

	@Override
	public E visitBreakStatement(BreakStatement node) {
		return null;
	}

	@Override
	public E visitCallExpression(CallExpression node) {
		visit(node.getExpression());
		for (ASTNode argument : node.getArguments()) {
			visit(argument);
		}
		return null;
	}

	@Override
	public E visitCommaExpression(CommaExpression node) {
		for (ASTNode item : node.getItems()) {
			visit(item);
		}
		return null;
	}

	@Override
	public E visitConditionalOperator(ConditionalOperator node) {
		visit(node.getCondition());
		visit(node.getTrueValue());
		visit(node.getFalseValue());
		return null;
	}

	@Override
	public E visitConstDeclaration(ConstStatement node) {
		processVariables(node.getVariables());
		return null;
	}

	private void processVariables(List<VariableDeclaration> variables) {
		for (VariableDeclaration declaration : variables) {
			processVariable(declaration);
		}
	}

	protected void processVariable(VariableDeclaration declaration) {
		if (declaration.getInitializer() != null) {
			visit(declaration.getInitializer());
		}
	}

	@Override
	public E visitContinueStatement(ContinueStatement node) {
		return null;
	}

	@Override
	public E visitDecimalLiteral(DecimalLiteral node) {
		return null;
	}

	@Override
	public E visitDefaultXmlNamespace(DefaultXmlNamespaceStatement node) {
		return null;
	}

	@Override
	public E visitDoWhileStatement(DoWhileStatement node) {
		final E result = visit(node.getBody());
		visitCondition(node.getCondition());
		return result;
	}

	protected void visitCondition(Expression condition) {
		visit(condition);
	}

	@Override
	public E visitEmptyExpression(EmptyExpression node) {
		return null;
	}

	@Override
	public E visitEmptyStatement(EmptyStatement node) {
		return null;
	}

	@Override
	public E visitForEachInStatement(ForEachInStatement node) {
		visit(node.getItem());
		visit(node.getIterator());
		return visit(node.getBody());
	}

	@Override
	public E visitForInStatement(ForInStatement node) {
		visit(node.getItem());
		visit(node.getIterator());
		return visit(node.getBody());
	}

	@Override
	public E visitForStatement(ForStatement node) {
		visit(node.getInitial());
		visit(node.getCondition());
		visit(node.getStep());
		return visit(node.getBody());
	}

	@Override
	public E visitFunctionStatement(FunctionStatement node) {
		return visit(node.getBody());
	}

	@Override
	public E visitGetAllChildrenExpression(GetAllChildrenExpression node) {
		visit(node.getObject());
		visit(node.getProperty());
		return null;
	}

	@Override
	public E visitGetArrayItemExpression(GetArrayItemExpression node) {
		visit(node.getArray());
		visit(node.getIndex());
		return null;
	}

	@Override
	public E visitGetLocalNameExpression(GetLocalNameExpression node) {
		visit(node.getNamespace());
		visit(node.getLocalName());
		return null;
	}

	@Override
	public E visitIdentifier(Identifier node) {
		return null;
	}

	@Override
	public E visitIfStatement(IfStatement node) {
		visitCondition(node.getCondition());
		if (node.getThenStatement() != null) {
			visit(node.getThenStatement());
		}
		if (node.getElseStatement() != null) {
			visit(node.getElseStatement());
		}
		return null;
	}

	@Override
	public E visitLabelledStatement(LabelledStatement node) {
		visit(node.getStatement());
		return null;
	}

	@Override
	public E visitNewExpression(NewExpression node) {
		return visit(node.getObjectClass());
	}

	@Override
	public E visitNullExpression(NullExpression node) {
		return null;
	}

	@Override
	public E visitObjectInitializer(ObjectInitializer node) {
		for (ObjectInitializerPart part : node.getInitializers()) {
			if (part instanceof GetMethod) {
				visitMethod((GetMethod) part);
			} else if (part instanceof SetMethod) {
				visitMethod((SetMethod) part);
			} else if (part instanceof PropertyInitializer) {
				final PropertyInitializer pi = (PropertyInitializer) part;
				visit(pi.getName());
				visit(pi.getValue());
			}
		}
		return null;
	}

	/**
	 * @param part
	 */
	protected E visitMethod(Method method) {
		return visit(method.getBody());
	}

	@Override
	public E visitParenthesizedExpression(ParenthesizedExpression node) {
		return visit(node.getExpression());
	}

	@Override
	public E visitPropertyExpression(PropertyExpression node) {
		visit(node.getObject());
		visit(node.getProperty());
		return null;
	}

	@Override
	public E visitRegExpLiteral(RegExpLiteral node) {
		return null;
	}

	@Override
	public E visitReturnStatement(ReturnStatement node) {
		if (node.getValue() != null) {
			visit(node.getValue());
		}
		return null;
	}

	@Override
	public E visitScript(Script node) {
		for (Statement statement : node.getStatements()) {
			visit(statement);
		}
		return null;
	}

	@Override
	public E visitStatementBlock(StatementBlock node) {
		for (Statement statement : node.getStatements()) {
			visit(statement);
		}
		return null;
	}

	@Override
	public E visitStringLiteral(StringLiteral node) {
		return null;
	}

	@Override
	public E visitSwitchStatement(SwitchStatement node) {
		if (node.getCondition() != null)
			visit(node.getCondition());
		for (SwitchComponent component : node.getCaseClauses()) {
			if (component instanceof CaseClause) {
				final CaseClause caseClause = (CaseClause) component;
				if (caseClause.getCondition() != null) {
					visit(caseClause.getCondition());
				}
			}
			for (Statement statement : component.getStatements()) {
				visit(statement);
			}
		}
		return null;
	}

	@Override
	public E visitThisExpression(ThisExpression node) {
		return null;
	}

	@Override
	public E visitThrowStatement(ThrowStatement node) {
		if (node.getException() != null) {
			visit(node.getException());
		}
		return null;
	}

	@Override
	public E visitTryStatement(TryStatement node) {
		visit(node.getBody());
		for (CatchClause catchClause : node.getCatches()) {
			if (catchClause.getFilterExpression() != null)
				visit(catchClause.getFilterExpression());
			final Statement catchStatement = catchClause.getStatement();
			if (catchStatement != null) {
				visit(catchStatement);
			}
		}
		if (node.getFinally() != null) {
			final Statement finallyStatement = node.getFinally().getStatement();
			if (finallyStatement != null) {
				visit(finallyStatement);
			}
		}
		return null;
	}

	@Override
	public E visitUnaryOperation(UnaryOperation node) {
		visit(node.getExpression());
		return null;
	}

	@Override
	public E visitVariableStatement(VariableStatement node) {
		processVariables(node.getVariables());
		return null;
	}

	@Override
	public E visitVoidExpression(VoidExpression node) {
		visit(node.getExpression());
		return null;
	}

	@Override
	public E visitWhileStatement(WhileStatement node) {
		visitCondition(node.getCondition());
		return visit(node.getBody());
	}

	@Override
	public E visitWithStatement(WithStatement node) {
		visit(node.getExpression());
		visit(node.getStatement());
		return null;
	}

	@Override
	public E visitXmlLiteral(XmlLiteral node) {
		return null;
	}

	@Override
	public E visitXmlPropertyIdentifier(XmlAttributeIdentifier node) {
		visit(node.getExpression());
		return null;
	}

	@Override
	public E visitYieldOperator(YieldOperator node) {
		visit(node.getParent());
		return null;
	}

	@Override
	public E visitArrowFunction(ArrowFunctionStatement node) {
		return visit(node.getBody());
	}

	@Override
	public E visitTemplateStringLiteral(TemplateStringLiteral node) {
		for (Expression expression : node.getTemplateExpressions()) {
			visit(expression);
		}
		return null;
	}

	@Override
	public E visitTagFunction(TagFunctionExpression node) {
		visit(node.getTagFunction());
		visit(node.getLiteral());
		return null;
	}

	@Override
	public E visitTemplateStringExpression(TemplateStringExpression node) {
		return visit(node.getExpression());
	}

	@Override
	public E visitForOfStatement(ForOfStatement node) {
		visit(node.getItem());
		visit(node.getIterator());
		return visit(node.getBody());
	}
}
