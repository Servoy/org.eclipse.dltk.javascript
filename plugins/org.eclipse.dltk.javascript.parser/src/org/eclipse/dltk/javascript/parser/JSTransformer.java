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
package org.eclipse.dltk.javascript.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.dltk.compiler.util.Util;
import org.eclipse.dltk.internal.core.util.WeakHashSet;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.ArrayInitializer;
import org.eclipse.dltk.javascript.ast.AsteriskExpression;
import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.BooleanLiteral;
import org.eclipse.dltk.javascript.ast.BreakStatement;
import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.CaseClause;
import org.eclipse.dltk.javascript.ast.CatchClause;
import org.eclipse.dltk.javascript.ast.CommaExpression;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.ConditionalOperator;
import org.eclipse.dltk.javascript.ast.ConstStatement;
import org.eclipse.dltk.javascript.ast.ContinueStatement;
import org.eclipse.dltk.javascript.ast.DecimalLiteral;
import org.eclipse.dltk.javascript.ast.DefaultClause;
import org.eclipse.dltk.javascript.ast.DefaultXmlNamespaceStatement;
import org.eclipse.dltk.javascript.ast.DoWhileStatement;
import org.eclipse.dltk.javascript.ast.Documentable;
import org.eclipse.dltk.javascript.ast.EmptyExpression;
import org.eclipse.dltk.javascript.ast.EmptyStatement;
import org.eclipse.dltk.javascript.ast.ErrorExpression;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FinallyClause;
import org.eclipse.dltk.javascript.ast.ForEachInStatement;
import org.eclipse.dltk.javascript.ast.ForInStatement;
import org.eclipse.dltk.javascript.ast.ForStatement;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.GetAllChildrenExpression;
import org.eclipse.dltk.javascript.ast.GetArrayItemExpression;
import org.eclipse.dltk.javascript.ast.GetLocalNameExpression;
import org.eclipse.dltk.javascript.ast.GetMethod;
import org.eclipse.dltk.javascript.ast.IVariableStatement;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.IfStatement;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Keyword;
import org.eclipse.dltk.javascript.ast.Keywords;
import org.eclipse.dltk.javascript.ast.Label;
import org.eclipse.dltk.javascript.ast.LabelledStatement;
import org.eclipse.dltk.javascript.ast.LoopStatement;
import org.eclipse.dltk.javascript.ast.Method;
import org.eclipse.dltk.javascript.ast.MultiLineComment;
import org.eclipse.dltk.javascript.ast.NewExpression;
import org.eclipse.dltk.javascript.ast.NullExpression;
import org.eclipse.dltk.javascript.ast.ObjectInitializer;
import org.eclipse.dltk.javascript.ast.ObjectInitializerPart;
import org.eclipse.dltk.javascript.ast.ParenthesizedExpression;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.PropertyInitializer;
import org.eclipse.dltk.javascript.ast.RegExpLiteral;
import org.eclipse.dltk.javascript.ast.ReturnStatement;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.SetMethod;
import org.eclipse.dltk.javascript.ast.SingleLineComment;
import org.eclipse.dltk.javascript.ast.Statement;
import org.eclipse.dltk.javascript.ast.StatementBlock;
import org.eclipse.dltk.javascript.ast.StringLiteral;
import org.eclipse.dltk.javascript.ast.SwitchComponent;
import org.eclipse.dltk.javascript.ast.SwitchStatement;
import org.eclipse.dltk.javascript.ast.ThisExpression;
import org.eclipse.dltk.javascript.ast.ThrowStatement;
import org.eclipse.dltk.javascript.ast.TryStatement;
import org.eclipse.dltk.javascript.ast.UnaryOperation;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.VoidExpression;
import org.eclipse.dltk.javascript.ast.WhileStatement;
import org.eclipse.dltk.javascript.ast.WithStatement;
import org.eclipse.dltk.javascript.ast.XmlAttributeIdentifier;
import org.eclipse.dltk.javascript.ast.XmlExpressionFragment;
import org.eclipse.dltk.javascript.ast.XmlFragment;
import org.eclipse.dltk.javascript.ast.XmlLiteral;
import org.eclipse.dltk.javascript.ast.XmlTextFragment;
import org.eclipse.dltk.javascript.ast.YieldOperator;
import org.eclipse.dltk.javascript.core.JavaScriptLanguageUtil;
import org.eclipse.dltk.javascript.internal.parser.NodeTransformerManager;
import org.eclipse.dltk.javascript.parser.JSParser.program_return;
import org.eclipse.dltk.utils.IntList;

@SuppressWarnings("restriction")
public class JSTransformer {

	private final NodeTransformer[] transformers;
	private final List<Token> tokens;
	private final int[] tokenOffsets;
	private Stack<JSNode> parents = new Stack<JSNode>();
	private final boolean ignoreUnknown;
	private final Map<Integer, Comment> documentationMap = new HashMap<Integer, Comment>();
	private Reporter reporter;
	private SymbolTable scope;

	private static final int MAX_RECURSION_DEPTH = 512;

	private static class PropertyInitializerPair extends ASTNode {
		final PropertyInitializer first;
		final PropertyInitializer second;

		public PropertyInitializerPair(PropertyInitializer first,
				PropertyInitializer second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public void traverse(ASTVisitor visitor) throws Exception {
		}
	}

	private final void checkRecursionDepth() {
		if (parents.size() > MAX_RECURSION_DEPTH) {
			throw new IllegalArgumentException("Too nested AST");
		}
	}

	public JSTransformer(List<Token> tokens) {
		this(NodeTransformerManager.NO_TRANSFORMERS, tokens, false);
	}

	public JSTransformer(List<Token> tokens, boolean ignoreUnknown) {
		this(NodeTransformerManager.NO_TRANSFORMERS, tokens, ignoreUnknown);
	}

	public JSTransformer(NodeTransformer[] transformers, List<Token> tokens,
			boolean ignoreUnknown) {
		Assert.isNotNull(tokens);
		this.transformers = transformers;
		this.tokens = tokens;
		this.ignoreUnknown = ignoreUnknown;
		tokenOffsets = prepareOffsetMap(tokens);
	}

	private static final WeakHashSet stringPool = new WeakHashSet();

	private static final String intern(String value) {
		synchronized (stringPool) {
			return (String) stringPool.add(value);
		}
	}

	protected final ASTNode visitNode(Tree node) {
		ASTNode accept = visit(node);
		if (accept == null) {
			for (int i = 0; i < node.getChildCount(); i++) {
				visitNode(node.getChild(i));
			}
		}
		return accept;
	}

	private ASTNode internalVisit(Tree node) {
		assert node != null;
		switch (node.getType()) {

		case JSParser.Identifier:
		case JSParser.WXML:
		case JSParser.GET:
		case JSParser.SET:
		case JSParser.EACH:
		case JSParser.NAMESPACE:
			return visitIdentifier(node);

		case JSParser.BLOCK:
			return visitBlock(node);

		case JSParser.TRUE:
		case JSParser.FALSE:
			return visitBooleanLiteral(node);

		case JSParser.THIS:
			return visitThis(node);

		case JSParser.DecimalLiteral:
			return visitDecimalLiteral(node);

		case JSParser.StringLiteral:
			return visitStringLiteral(node);

		case JSParser.BYFIELD:
			return visitByField(node);

		case JSParser.BYINDEX:
			return visitByIndex(node);

		case JSParser.EXPR:
			return visitExpression(node);

		case JSParser.CALL:
			return visitCall(node);

		case JSParser.NULL:
			return visitNull(node);

			// arithmetic
		case JSParser.ADD:
		case JSParser.SUB:
		case JSParser.MUL:
		case JSParser.DIV:
		case JSParser.MOD:
			// assign
		case JSParser.ASSIGN:
		case JSParser.ADDASS:
		case JSParser.SUBASS:
		case JSParser.MULASS:
		case JSParser.DIVASS:
		case JSParser.MODASS:
			// conditional
		case JSParser.LT:
		case JSParser.GT:
		case JSParser.LTE:
		case JSParser.GTE:
			// bitwise
		case JSParser.AND:
		case JSParser.OR:
		case JSParser.XOR:
		case JSParser.ANDASS:
		case JSParser.XORASS:
		case JSParser.ORASS:
		case JSParser.SHL:
		case JSParser.SHR:
		case JSParser.SHU:
		case JSParser.SHLASS:
		case JSParser.SHRASS:
		case JSParser.SHUASS:
			// logical
		case JSParser.LOR:
		case JSParser.LAND:
		case JSParser.SAME:
		case JSParser.EQ:
		case JSParser.NEQ:
		case JSParser.NSAME:
			// special
		case JSParser.IN:
		case JSParser.INSTANCEOF:
			return visitBinaryOperation(node);

		case JSParser.PINC:
		case JSParser.PDEC:
		case JSParser.INC:
		case JSParser.DEC:
		case JSParser.NEG:
		case JSParser.POS:
		case JSParser.NOT:
		case JSParser.INV:
		case JSParser.DELETE:
		case JSParser.TYPEOF:
		case JSParser.VOID:
			return visitUnaryOperation(node);

		case JSParser.RETURN:
			return visitReturn(node);

		case JSParser.SWITCH:
			return visitSwitch(node);

		case JSParser.DEFAULT:
			return visitDefault(node);

		case JSParser.CASE:
			return visitCase(node);

		case JSParser.BREAK:
			return visitBreak(node);

		case JSParser.CONTINUE:
			return visitContinue(node);

		case JSParser.DO:
			return visitDoWhile(node);

		case JSParser.WHILE:
			return visitWhile(node);

		case JSParser.FOR:
			return visitFor(node);

		case JSParser.OBJECT:
			return visitObjectInitializer(node);

		case JSParser.NAMEDVALUE:
			return visitPropertyInitializer(node);

		case JSParser.FOREACH:
			return visitForEachInStatement(node);

		case JSParser.IF:
			return visitIf(node);

		case JSParser.QUE:
			return visitConditional(node);

		case JSParser.PAREXPR:
			return visitParenthesizedExpression(node);

		case JSParser.TRY:
			return visitTry(node);

		case JSParser.THROW:
			return visitThrow(node);

		case JSParser.CATCH:
			return visitCatch(node);

		case JSParser.FINALLY:
			return visitFinally(node);

		case JSParser.NEW:
			return visitNew(node);

		case JSParser.ARRAY:
			return visitArray(node);

		case JSParser.CEXPR:
			return visitCommaExpression(node);

		case JSParser.RegularExpressionLiteral:
			return visitRegExp(node);

		case JSParser.WITH:
			return visitWith(node);

		case JSParser.LABELLED:
			return visitLabelled(node);

		case JSParser.GETTER:
			return visitGet(node);

		case JSParser.SETTER:
			return visitSet(node);

		case JSParser.VAR:
			return visitVarDeclaration(node);

		case JSParser.CONST:
			return visitConst(node);

		case JSParser.FUNCTION:
		case JSParser.FUNCTION_DECLARATION:
			return visitFunction(node);

		case JSParser.XML_LITERAL:
			return visitXmlLiteral(node);

		case JSParser.DEFAULT_XML_NAMESPACE:
			return visitNamespace(node);

		case JSParser.XmlAttribute:
			return visitXmlAttribute(node);

		case JSParser.ALLCHILDREN:
			return visitGetAllChildren(node);

		case JSParser.LOCALNAME:
			return visitGetLocalName(node);

		case JSParser.HexIntegerLiteral:
			return visitHexIntegerLiteral(node);

		case JSParser.OctalIntegerLiteral:
			return visitOctalIntegerLiteral(node);

		case JSParser.YIELD:
			return visitYield(node);

		case JSParser.EMPTY_STATEMENT:
			return visitEmptyStatement(node);

		default:
			return visitUnknown(node);
		}
	}

	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	public Script transformScript(program_return root) {
		Assert.isNotNull(root);
		final Tree tree = (Tree) root.getTree();
		if (tree == null)
			return new Script();
		final Script script = new Script();
		scope = new SymbolTable(script);
		addComments(script);
		if (tree.getType() != 0) {
			script.addStatement(transformStatementNode(tree, script));
		} else {
			for (int i = 0; i < tree.getChildCount(); i++) {
				script.addStatement(transformStatementNode(tree.getChild(i),
						script));
			}
		}
		script.setStart(0);
		script.setEnd(tokenOffsets[tokenOffsets.length - 1]);
		for (NodeTransformer transformer : transformers) {
			if (transformer instanceof NodeTransformerExtension) {
				((NodeTransformerExtension) transformer).postConstruct(script);
			}
		}
		return script;
	}

	public ASTNode transform(ParserRuleReturnScope root) {
		Assert.isNotNull(root);
		final Tree tree = (Tree) root.getTree();
		if (tree == null)
			return null;
		scope = null;
		return transformExpression(tree, null);
	}

	private JSNode getParent() {
		if (parents.isEmpty()) {
			return null;
		} else {
			return parents.peek();
		}
	}

	private ASTNode transformNode(Tree node, JSNode parent) {
		if (node == null) {
			if (ignoreUnknown) {
				return createErrorExpression(node);
			} else {
				Assert.isNotNull(node);
			}
		}
		parents.push(parent);
		try {
			checkRecursionDepth();
			ASTNode result = visitNode(node);
			if (result == null)
				throw new AssertionFailedException("null argument:" + node); //$NON-NLS-1$
			return result;
		} catch (AssertionFailedException e) {
			if (ignoreUnknown) {
				return createErrorExpression(node);
			} else {
				throw e;
			}
		} finally {
			parents.pop();
		}
	}

	private static int[] prepareOffsetMap(List<Token> tokens) {
		final int[] offsets = new int[tokens.size() + 1];
		for (int i = 0; i < tokens.size(); i++) {
			offsets[i] = ((CommonToken) tokens.get(i)).getStartIndex();
		}
		if (tokens.isEmpty()) {
			offsets[0] = 0;
		} else {
			offsets[tokens.size()] = ((CommonToken) tokens
					.get(tokens.size() - 1)).getStopIndex() + 1;
		}
		return offsets;
	}

	private int getTokenOffset(int tokenIndex) {
		try {
			return tokenOffsets[tokenIndex];
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}

	private void setRangeByToken(ASTNode node, int tokenIndex) {
		node.setStart(getTokenOffset(tokenIndex));
		node.setEnd(getTokenOffset(tokenIndex + 1));
	}

	private void setRange(ASTNode node, Tree treeNode) {
		node.setStart(getTokenOffset(treeNode.getTokenStartIndex()));
		setEndByTokenIndex(node, treeNode.getTokenStopIndex());
	}

	private void setEndByTokenIndex(ASTNode node, int stopIndex) {
		while (stopIndex >= 0 && isHidden(tokens.get(stopIndex))) {
			--stopIndex;
		}
		node.setEnd(getTokenOffset(stopIndex + 1));
	}

	private static boolean isHidden(Token token) {
		return token.getType() == JSParser.EOL
				|| token.getType() == JSParser.SingleLineComment
				|| token.getType() == JSParser.MultiLineComment;
	}

	private int getTokenOffset(int tokenType, int startTokenIndex,
			int endTokenIndex) {

		Assert.isTrue(startTokenIndex >= 0);
		Assert.isTrue(endTokenIndex >= 0);
		Assert.isTrue(startTokenIndex <= endTokenIndex);

		Token token = null;

		for (int i = startTokenIndex; i <= endTokenIndex; i++) {
			Token item = tokens.get(i);
			if (item.getType() == tokenType) {
				token = item;
				break;
			}
		}

		if (token == null)
			return -1;
		else
			return getTokenOffset(token.getTokenIndex());
	}

	private final Expression transformExpression(Tree node, JSNode parent) {
		final ASTNode transformed = transformNode(node, parent);
		if (transformed == null || transformed instanceof Expression) {
			return (Expression) transformed;
		} else {
			return createErrorExpression(node);
		}
	}

	private Statement transformStatementNode(Tree node, JSNode parent) {

		ASTNode expression = transformNode(node, parent);

		if (expression instanceof Statement)
			return (Statement) expression;
		else {
			VoidExpression voidExpression = new VoidExpression(parent);
			voidExpression.setExpression((Expression) expression);

			if (node.getTokenStopIndex() >= 0
					&& node.getTokenStopIndex() < tokens.size()) {
				final Token token = tokens.get(node.getTokenStopIndex());
				if (token.getType() == JSParser.SEMIC) {
					voidExpression.setSemicolonPosition(getTokenOffset(token
							.getTokenIndex()));
					voidExpression.getExpression().setEnd(
							Math.min(voidExpression.getSemicolonPosition(),
									expression.sourceEnd()));
				}
			}

			assert expression.sourceStart() >= 0;
			assert expression.sourceEnd() > 0;

			voidExpression.setStart(expression.sourceStart());
			voidExpression.setEnd(Math.max(expression.sourceEnd(),
					voidExpression.getSemicolonPosition() + 1));

			return voidExpression;
		}
	}

	protected ASTNode visit(Tree tree) {
		final ASTNode node = internalVisit(tree);
		if (node != null && transformers.length != 0) {
			final JSNode parent = getParent();
			for (NodeTransformer transformer : transformers) {
				final ASTNode transformed = transformer.transform(node, parent);
				if (transformed != null && transformed != node) {
					return transformed;
				}
			}
		}
		return node;
	}

	private void locateDocumentation(final Documentable node, Tree tree) {
		int tokenIndex = tree.getTokenStartIndex();
		while (tokenIndex > 0) {
			--tokenIndex;
			final Token token = tokens.get(tokenIndex);
			if (token.getType() == JSParser.WhiteSpace
					|| token.getType() == JSParser.EOL) {
				continue;
			}
			if (token.getType() == JSParser.MultiLineComment) {
				final Comment comment = documentationMap.get(token
						.getTokenIndex());
				if (comment != null) {
					node.setDocumentation(comment);
				}
			}
			break;
		}
	}

	protected ASTNode visitUnknown(Tree node) {
		if (ignoreUnknown) {
			return createErrorExpression(node);
		}
		throw new UnsupportedOperationException("Unknown token "
				+ JSParser.tokenNames[node.getType()] + " (" + node.getText()
				+ ")");
	}

	private ErrorExpression createErrorExpression(Tree node) {
		if (node != null) {
			ErrorExpression error = new ErrorExpression(getParent(),
					node.getText());
			error.setStart(getTokenOffset(node.getTokenStartIndex()));
			error.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));
			return error;
		} else {
			return new ErrorExpression(getParent(), "");
		}
	}

	protected ASTNode visitBinaryOperation(Tree node) {
		if (node.getType() == JSParser.MUL) {
			switch (node.getChildCount()) {
			case 0:
				return visitAsterisk(node);
			case 1:
				// HACK
				return visit(node.getChild(0));
			}

		}

		Assert.isNotNull(node.getChild(0));
		Assert.isNotNull(node.getChild(1));

		BinaryOperation operation = new org.eclipse.dltk.javascript.ast.v3.BinaryOperation(getParent());

		operation.setOperation(node.getType());

		operation.setLeftExpression(transformExpression(node.getChild(0),
				operation));

		operation.setRightExpression(transformExpression(node.getChild(1),
				operation));

		operation.setOperationPosition(getTokenOffset(node.getType(),
				getRealTokenStopIndex(node.getChild(0)) + 1, node.getChild(1)
						.getTokenStartIndex()));

		Assert.isTrue(operation.getOperationPosition() >= operation
				.getLeftExpression().sourceEnd());
		Assert.isTrue(operation.getOperationPosition()
				+ operation.getOperationText().length() <= operation
				.getRightExpression().sourceStart());

		operation.setStart(operation.getLeftExpression().sourceStart());
		operation.setEnd(operation.getRightExpression().sourceEnd());

		return operation;
	}

	protected ASTNode visitBlock(Tree node) {

		StatementBlock block = new StatementBlock(getParent());

		List<Statement> statements = block.getStatements();
		for (int i = 0; i < node.getChildCount(); i++) {
			statements.add(transformStatementNode(node.getChild(i), block));
		}

		block.setLC(getTokenOffset(JSParser.LBRACE, node.getTokenStartIndex(),
				node.getTokenStopIndex()));

		block.setRC(getTokenOffset(JSParser.RBRACE, node.getTokenStopIndex(),
				node.getTokenStopIndex()));

		if (block.getLC() > -1) {
			block.setStart(block.getLC());
		} else if (!statements.isEmpty()) {
			block.setStart(statements.get(0).sourceStart());
		} else {
			block.setStart(getTokenOffset(node.getTokenStartIndex()));
		}
		if (block.getRC() > -1) {
			block.setEnd(block.getRC() + 1);
		} else if (!statements.isEmpty()) {
			block.setEnd(statements.get(statements.size() - 1).sourceStart());
		} else {
			block.setEnd(getTokenOffset(node.getTokenStopIndex()));
		}

		return block;
	}

	private Keyword createKeyword(Tree node, String text) {
		assert text.equals(node.getText());
		// assert text.equals(Keywords.fromToken(node.getType()));
		final Keyword keyword = new Keyword(text);
		setRangeByToken(keyword, node.getTokenStartIndex());
		return keyword;
	}

	protected ASTNode visitBreak(Tree node) {
		BreakStatement statement = new BreakStatement(getParent());
		statement.setBreakKeyword(createKeyword(node, Keywords.BREAK));

		if (node.getChildCount() > 0) {
			Label label = new Label(statement);
			final Tree labelNode = node.getChild(0);
			label.setText(intern(labelNode.getText()));
			setRangeByToken(label, labelNode.getTokenStartIndex());
			statement.setLabel(label);
			validateLabel(label);
		}

		statement.setSemicolonPosition(getTokenOffset(JSParser.SEMIC,
				node.getTokenStopIndex(), node.getTokenStopIndex()));

		statement.setStart(statement.getBreakKeyword().sourceStart());

		if (statement.getLabel() != null)
			statement.setEnd(Math.max(statement.getSemicolonPosition() + 1,
					statement.getLabel().sourceEnd()));
		else
			statement.setEnd(Math.max(statement.getSemicolonPosition() + 1,
					statement.getBreakKeyword().sourceEnd()));
		if (statement.getLabel() == null) {
			validateParent(JavaScriptParserProblems.BAD_BREAK, statement,
					LoopStatement.class, SwitchStatement.class);
		}
		return statement;
	}

	protected ASTNode visitCall(Tree node) {
		CallExpression call = new CallExpression(getParent());

		Assert.isNotNull(node.getChild(0));
		Assert.isNotNull(node.getChild(1));

		call.setExpression(transformExpression(node.getChild(0), call));
		Tree callArgs = node.getChild(1);
		IntList commas = new IntList();
		for (int i = 0; i < callArgs.getChildCount(); ++i) {
			Tree callArg = callArgs.getChild(i);
			final ASTNode argument = transformNode(callArg, call);
			if (i > 0) {
				commas.add(getTokenOffset(JSParser.COMMA,
						callArgs.getChild(i - 1).getTokenStopIndex() + 1,
						callArg.getTokenStartIndex()));
			}
			call.addArgument(argument);
		}
		call.setCommas(commas);

		call.setLP(getTokenOffset(JSParser.LPAREN, node.getChild(1)
				.getTokenStartIndex(), node.getChild(1).getTokenStartIndex()));
		call.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(1)
				.getTokenStopIndex(), node.getChild(1).getTokenStopIndex()));

		call.setStart(call.getExpression().sourceStart());
		if (call.getRP() > -1) {
			call.setEnd(call.getRP() + 1);
		} else {
			call.setEnd(call.getExpression().sourceEnd());
		}

		return call;
	}

	protected ASTNode visitCase(Tree node) {
		CaseClause caseClause = new CaseClause(getParent());

		caseClause.setCaseKeyword(createKeyword(node, Keywords.CASE));

		final Tree condition = node.getChild(0);
		if (condition != null) {
			caseClause.setCondition(transformExpression(condition, caseClause));
			caseClause
					.setColonPosition(getTokenOffset(JSParser.COLON,
							condition.getTokenStopIndex() + 1,
							node.getTokenStopIndex()));
		} else {
			caseClause.setCondition(new ErrorExpression(caseClause,
					Util.EMPTY_STRING));
			caseClause
					.setColonPosition(caseClause.getCaseKeyword().sourceEnd());
		}

		// skip condition
		for (int i = 1; i < node.getChildCount(); i++) {
			caseClause.getStatements().add(
					transformStatementNode(node.getChild(i), caseClause));
		}

		caseClause.setStart(caseClause.getCaseKeyword().sourceStart());
		caseClause.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return caseClause;
	}

	protected ASTNode visitDecimalLiteral(Tree node) {
		DecimalLiteral number = new DecimalLiteral(getParent());
		number.setText(intern(node.getText()));
		number.setStart(getTokenOffset(node.getTokenStartIndex()));
		number.setEnd(number.sourceStart() + number.getText().length());

		return number;
	}

	protected ASTNode visitDefault(Tree node) {
		DefaultClause defaultClause = new DefaultClause(getParent());

		defaultClause.setDefaultKeyword(createKeyword(node, Keywords.DEFAULT));

		defaultClause.setColonPosition(getTokenOffset(JSParser.COLON,
				node.getTokenStartIndex() + 1, node.getTokenStopIndex() + 1));

		for (int i = 0; i < node.getChildCount(); i++) {
			defaultClause.getStatements().add(
					transformStatementNode(node.getChild(i), defaultClause));
		}

		defaultClause.setStart(defaultClause.getDefaultKeyword().sourceStart());
		defaultClause.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return defaultClause;
	}

	protected ASTNode visitExpression(Tree node) {
		if (node.getChildCount() > 0)
			return transformNode(node.getChild(0), getParent());
		else
			return new EmptyExpression(getParent());
	}

	protected ASTNode visitFor(Tree node) {
		switch (node.getChild(0).getType()) {
		case JSParser.FORSTEP:
			return visitForStatement(node);

		case JSParser.FORITER:
			return visitForInStatement(node);

		case JSParser.BLOCK:
			if (node.getChildCount() == 1) {
				// TODO error reporting???? "for() {" case
				final ForStatement statement = new ForStatement(getParent());
				statement.setForKeyword(createKeyword(node, Keywords.FOR));
				statement.setInitial(new EmptyExpression(statement));
				statement.setCondition(new EmptyExpression(statement));
				statement.setStep(new EmptyExpression(statement));
				statement.setBody(transformStatementNode(node.getChild(0),
						statement));
				return statement;
			}

		default:
			// TODO error reporting & recovery
			throw new IllegalArgumentException("FORSTEP or FORITER expected");
		}
	}

	private ASTNode visitForStatement(Tree node) {
		ForStatement statement = new ForStatement(getParent());

		statement.setForKeyword(createKeyword(node, Keywords.FOR));

		statement.setLP(getTokenOffset(JSParser.LPAREN,
				node.getTokenStartIndex() + 1, node.getTokenStopIndex()));
		final Tree forControl = node.getChild(0);
		statement.setInitial(transformExpression(forControl.getChild(0),
				statement));
		statement.setInitialSemicolonPosition(getTokenOffset(forControl
				.getChild(1).getTokenStartIndex()));
		statement.setCondition(transformExpression(forControl.getChild(2),
				statement));
		statement.setConditionalSemicolonPosition(getTokenOffset(forControl
				.getChild(3).getTokenStartIndex()));
		statement
				.setStep(transformExpression(forControl.getChild(4), statement));
		statement.setRP(getTokenOffset(JSParser.RPAREN,
				forControl.getTokenStopIndex() + 1, node.getTokenStopIndex()));

		if (statement.getInitial() instanceof EmptyExpression) {
			final int pos = statement.getInitialSemicolonPosition();
			statement.getInitial().setStart(pos);
			statement.getInitial().setEnd(pos);
		}
		if (statement.getCondition() instanceof EmptyExpression) {
			final int pos = statement.getConditionalSemicolonPosition();
			statement.getCondition().setStart(pos);
			statement.getCondition().setEnd(pos);
		}
		if (statement.getStep() instanceof EmptyExpression) {
			final int pos = statement.getConditionalSemicolonPosition() + 1;
			statement.setStart(pos);
			statement.setEnd(pos);
		}

		if (node.getChildCount() > 1) {
			statement.setBody(transformStatementNode(node.getChild(1),
					statement));
		}

		statement.setStart(statement.getForKeyword().sourceStart());
		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	private ASTNode visitForInStatement(Tree node) {
		ForInStatement statement = new ForInStatement(getParent());

		statement.setForKeyword(createKeyword(node, Keywords.FOR));

		statement.setLP(getTokenOffset(JSParser.LPAREN, node
				.getTokenStartIndex() + 1, node.getChild(0)
				.getTokenStartIndex()));

		statement.setItem(transformExpression(node.getChild(0).getChild(0),
				statement));

		Keyword inKeyword = new Keyword(Keywords.IN);

		int iteratorStart = node.getChild(0).getChild(1).getTokenStartIndex();

		if (iteratorStart == -1
				&& node.getChild(0).getChild(1).getType() == JSParser.EXPR
				&& node.getChild(0).getChild(1).getChildCount() > 0)
			iteratorStart = node.getChild(0).getChild(1).getChild(0)
					.getTokenStartIndex();

		inKeyword.setStart(getTokenOffset(JSParser.IN,
				getRealTokenStopIndex(node.getChild(0).getChild(0)) + 1,
				iteratorStart));
		inKeyword.setEnd(inKeyword.sourceStart() + Keywords.IN.length());
		statement.setInKeyword(inKeyword);

		statement.setIterator(transformExpression(node.getChild(0).getChild(1),
				statement));

		statement.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(0)
				.getTokenStopIndex() + 1, node.getTokenStopIndex()));

		if (node.getChildCount() > 1)
			statement.setBody(transformStatementNode(node.getChild(1),
					statement));

		statement.setStart(statement.getForKeyword().sourceStart());
		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	private Argument transformArgument(Tree node, JSNode parent) {
		Assert.isTrue(node.getType() == JSParser.Identifier
				|| JSLexer.isIdentifierKeyword(node.getType()));

		Argument argument = new Argument(parent);
		argument.setIdentifier((Identifier) visitIdentifier(node));
		argument.setStart(getTokenOffset(node.getTokenStartIndex()));
		argument.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));
		return argument;
	}

	protected ASTNode visitFunction(Tree node) {
		FunctionStatement fn = new FunctionStatement(getParent(),
				node.getType() == JSParser.FUNCTION_DECLARATION);
		locateDocumentation(fn, node);

		fn.setFunctionKeyword(createKeyword(node, Keywords.FUNCTION));

		int index = 0;

		if (node.getChild(index).getType() != JSParser.ARGUMENTS) {
			fn.setName((Identifier) transformNode(node.getChild(index), fn));
			index++;
		}

		Tree argsNode = node.getChild(index++);
		assert argsNode.getType() == JSParser.ARGUMENTS;

		fn.setLP(getTokenOffset(JSParser.LPAREN, node.getTokenStartIndex() + 1,
				argsNode.getTokenStartIndex()));
		final SymbolTable functionScope = new SymbolTable(fn);
		for (int i = 0, childCount = argsNode.getChildCount(); i < childCount; ++i) {
			final Tree argNode = argsNode.getChild(i);
			Argument argument = transformArgument(argNode, fn);
			if (i + 1 < childCount) {
				argument.setCommaPosition(getTokenOffset(JSParser.COMMA,
						argNode.getTokenStopIndex() + 1,
						argsNode.getChild(i + 1).getTokenStartIndex()));
			}
			fn.addArgument(argument);
			if (functionScope.add(argument.getArgumentName(), SymbolKind.PARAM) != null
					&& reporter != null) {
				reporter.setFormattedMessage(
						JavaScriptParserProblems.DUPLICATE_PARAMETER,
						argument.getArgumentName());
				reporter.setRange(argument.sourceStart(), argument.sourceEnd());
				reporter.report();
			}
		}
		fn.setRP(getTokenOffset(JSParser.RPAREN, argsNode.getTokenStopIndex(),
				node.getChild(index).getTokenStartIndex()));
		final Identifier nameNode = fn.getName();
		if (fn.isDeclaration() && nameNode != null) {
			final SymbolKind replaced = scope.add(nameNode.getName(),
					SymbolKind.FUNCTION, fn);
			if (replaced != null && reporter != null) {
				if (replaced == SymbolKind.FUNCTION) {
					reporter.setFormattedMessage(
							JavaScriptParserProblems.DUPLICATE_FUNCTION,
							nameNode.getName());
				} else {
					reporter.setFormattedMessage(
							JavaScriptParserProblems.FUNCTION_DUPLICATES_OTHER,
							nameNode.getName(), replaced.verboseName());
				}
				reporter.setRange(nameNode.sourceStart(), nameNode.sourceEnd());
				reporter.report();
			}
		}
		final Tree bodyNode = node.getChild(index);
		final SymbolTable savedScope = scope;
		try {
			scope = functionScope;
			fn.setBody((StatementBlock) transformNode(bodyNode, fn));
		} finally {
			scope = savedScope;
		}
		fn.setStart(fn.getFunctionKeyword().sourceStart());
		fn.setEnd(fn.getBody().sourceEnd());

		return fn;
	}

	protected ASTNode visitIdentifier(Tree node) {

		Identifier id = new Identifier(getParent());
		locateDocumentation(id, node);

		id.setName(intern(node.getText()));

		setRangeByToken(id, node.getTokenStartIndex());

		return id;
	}

	protected ASTNode visitReturn(Tree node) {

		ReturnStatement returnStatement = new ReturnStatement(getParent());

		returnStatement.setReturnKeyword(createKeyword(node, Keywords.RETURN));

		if (node.getChildCount() > 0) {
			returnStatement.setValue(transformExpression(node.getChild(0),
					returnStatement));
		}

		Token token = tokens.get(node.getTokenStopIndex());
		if (token.getType() == JSParser.SEMIC) {
			returnStatement.setSemicolonPosition(getTokenOffset(node
					.getTokenStopIndex()));

			returnStatement.setEnd(returnStatement.getSemicolonPosition() + 1);
		} else if (returnStatement.getValue() != null) {
			returnStatement.setEnd(returnStatement.getValue().sourceEnd());
		} else {
			returnStatement.setEnd(returnStatement.getReturnKeyword()
					.sourceEnd());
		}

		returnStatement.setStart(returnStatement.getReturnKeyword()
				.sourceStart());
		validateParent(JavaScriptParserProblems.INVALID_RETURN,
				returnStatement, FunctionStatement.class, Method.class);
		return returnStatement;
	}

	protected ASTNode visitStringLiteral(Tree node) {

		StringLiteral literal = new StringLiteral(getParent());
		locateDocumentation(literal, node);
		literal.setText(intern(node.getText()));

		literal.setStart(getTokenOffset(node.getTokenStartIndex()));
		literal.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return literal;
	}

	protected ASTNode visitSwitch(Tree node) {

		SwitchStatement statement = new SwitchStatement(getParent());

		statement.setSwitchKeyword(createKeyword(node, Keywords.SWITCH));

		statement.setLP(getTokenOffset(JSParser.LPAREN, node
				.getTokenStartIndex() + 1, node.getChild(0)
				.getTokenStartIndex()));
		statement.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(0)
				.getTokenStopIndex() + 1, node.getTokenStopIndex()));

		statement
				.setCondition(transformExpression(node.getChild(0), statement));

		statement.setLC(getTokenOffset(JSParser.LBRACE, node.getChild(0)
				.getTokenStopIndex() + 1, node.getTokenStopIndex()));

		List<Tree> caseNodes = new ArrayList<Tree>(node.getChildCount() - 1);
		for (int i = 1; i < node.getChildCount(); i++) {
			caseNodes.add(node.getChild(i));
		}
		Collections.sort(caseNodes, new Comparator<Tree>() {
			public int compare(Tree o1, Tree o2) {
				return o1.getTokenStartIndex() - o2.getTokenStartIndex();
			}
		});
		int defaultCount = 0;
		for (Tree child : caseNodes) {
			switch (child.getType()) {
			case JSParser.CASE:
				statement.addCase((SwitchComponent) transformNode(child,
						statement));
				break;
			case JSParser.DEFAULT:
				if (defaultCount != 0 && reporter != null) {
					reporter.setMessage(JavaScriptParserProblems.DOUBLE_SWITCH_DEFAULT);
					reporter.setSeverity(ProblemSeverity.ERROR);
					reporter.setStart(reporter.getOffset(child.getLine(),
							child.getCharPositionInLine()));
					reporter.setEnd(reporter.getStart()
							+ child.getText().length());
					reporter.report();
				}
				++defaultCount;
				statement.addCase((SwitchComponent) transformNode(child,
						statement));
				break;
			default:
				throw new UnsupportedOperationException();
			}
		}

		statement.setRC(getTokenOffset(JSParser.RBRACE,
				node.getTokenStopIndex(), node.getTokenStopIndex()));

		statement.setStart(statement.getSwitchKeyword().sourceStart());
		statement.setEnd(statement.getRC() + 1);

		return statement;
	}

	protected ASTNode visitUnaryOperation(Tree node) {

		UnaryOperation operation = new org.eclipse.dltk.javascript.ast.v3.UnaryOperation(getParent());

		operation.setOperation(node.getType());

		int operationType = node.getType();

		if (operation.isPostfix())
			operation.setOperationPosition(getTokenOffset(operationType, node
					.getChild(0).getTokenStopIndex() + 1, node
					.getTokenStopIndex()));
		else
			operation.setOperationPosition(getTokenOffset(operationType,
					node.getTokenStartIndex(), node.getTokenStopIndex()));

		if (operation.getOperationPosition() == -1) {

			// use compatible operations
			switch (operationType) {
			case JSParser.PINC:
				operationType = JSParser.INC;
				break;

			case JSParser.PDEC:
				operationType = JSParser.DEC;
				break;

			case JSParser.POS:
				operationType = JSParser.ADD;
				break;

			case JSParser.NEG:
				operationType = JSParser.SUB;
				break;
			}

			if (operation.isPostfix())
				operation.setOperationPosition(getTokenOffset(operationType,
						node.getChild(0).getTokenStopIndex() + 1,
						node.getTokenStopIndex()));
			else
				operation.setOperationPosition(getTokenOffset(operationType,
						node.getTokenStartIndex(), node.getTokenStopIndex()));

		}

		assert operation.getOperationPosition() > -1;

		operation
				.setExpression(transformExpression(node.getChild(0), operation));

		setRange(operation, node);

		return operation;
	}

	protected ASTNode visitContinue(Tree node) {
		ContinueStatement statement = new ContinueStatement(getParent());
		statement.setContinueKeyword(createKeyword(node, Keywords.CONTINUE));

		if (node.getChildCount() > 0) {
			Label label = new Label(statement);
			final Tree labelNode = node.getChild(0);
			label.setText(intern(labelNode.getText()));
			setRangeByToken(label, labelNode.getTokenStartIndex());
			statement.setLabel(label);
			validateLabel(label);
		}

		statement.setSemicolonPosition(getTokenOffset(JSParser.SEMIC,
				node.getTokenStopIndex(), node.getTokenStopIndex()));
		setRange(statement, node);
		if (statement.getLabel() == null) {
			validateParent(JavaScriptParserProblems.BAD_CONTINUE, statement,
					LoopStatement.class);
		}
		return statement;
	}

	private void validateLabel(Label label) {
		if (reporter == null)
			return;
		if (!scope.hasLabel(label.getText())) {
			reporter.setFormattedMessage(
					JavaScriptParserProblems.UNDEFINED_LABEL, label.getText());
			reporter.setSeverity(ProblemSeverity.ERROR);
			reporter.setRange(label.sourceStart(), label.sourceEnd());
			reporter.report();
		}
	}

	private void validateParent(JSProblemIdentifier messageId,
			Statement statement, Class<?>... classes) {
		if (reporter == null)
			return;
		for (ListIterator<JSNode> i = parents.listIterator(parents.size()); i
				.hasPrevious();) {
			ASTNode parent = i.previous();
			for (Class<?> clazz : classes) {
				if (clazz.isInstance(parent)) {
					return;
				}
			}
		}
		reporter.setMessage(messageId);
		reporter.setRange(statement.sourceStart(), statement.sourceEnd());
		reporter.setSeverity(ProblemSeverity.ERROR);
		reporter.report();
	}

	private VariableDeclaration transformVariableDeclaration(Tree node,
			IVariableStatement statement) {
		Assert.isTrue(node.getType() == JSParser.Identifier
				|| JSLexer.isIdentifierKeyword(node.getType()));

		VariableDeclaration declaration = new VariableDeclaration(statement);
		declaration
				.setIdentifier((Identifier) transformNode(node, declaration));
		declaration.setStart(getTokenOffset(node.getTokenStartIndex()));
		declaration.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));
		int i = 0;
		if (i + 2 <= node.getChildCount()
				&& node.getChild(i).getType() == JSParser.ASSIGN) {
			declaration.setAssignPosition(getTokenOffset(node.getChild(i)
					.getTokenStartIndex()));
			declaration.setInitializer(transformExpression(
					node.getChild(i + 1), declaration));
			i += 2;
		}
		return declaration;
	}

	protected ASTNode visitVarDeclaration(Tree node) {
		VariableStatement var = new VariableStatement(getParent());
		locateDocumentation(var, node);

		var.setVarKeyword(createKeyword(node, Keywords.VAR));

		processVariableDeclarations(node, var, SymbolKind.VAR);

		setRange(var, node);

		return var;
	}

	private void processVariableDeclarations(Tree node, IVariableStatement var,
			SymbolKind kind) {
		for (int i = 0, childCount = node.getChildCount(); i < childCount; i++) {
			final Tree varNode = node.getChild(i);
			final VariableDeclaration declaration = transformVariableDeclaration(
					varNode, var);
			var.addVariable(declaration);
			if (i + 1 < childCount) {
				declaration.setCommaPosition(getTokenOffset(JSParser.COMMA,
						varNode.getTokenStopIndex() + 1, node.getChild(i + 1)
								.getTokenStartIndex()));
			}
			final SymbolKind replaced = scope.add(
					declaration.getVariableName(), kind, declaration);
			if (replaced != null && reporter != null) {
				final Identifier identifier = declaration.getIdentifier();
				reporter.setRange(identifier.sourceStart(),
						identifier.sourceEnd());
				if (replaced == kind) {
					reporter.setFormattedMessage(kind.duplicateProblem,
							declaration.getVariableName());
				} else {
					reporter.setFormattedMessage(kind.hideProblem,
							declaration.getVariableName(),
							replaced.verboseName());
				}
				reporter.report();
			}
		}
	}

	protected ASTNode visitObjectInitializer(Tree node) {

		ObjectInitializer initializer = new ObjectInitializer(getParent());

		IntList commas = new IntList();

		for (int i = 0; i < node.getChildCount(); i++) {
			final Tree child = node.getChild(i);
			if (child.getType() == JSParser.COMMA) {
				commas.add(getTokenOffset(child.getTokenStartIndex()));
			} else {
				final ASTNode pi = transformNode(child, initializer);
				if (pi instanceof PropertyInitializerPair) {
					final PropertyInitializerPair pair = (PropertyInitializerPair) pi;
					initializer.addInitializer(pair.first);
					commas.add(-1);
					initializer.addInitializer(pair.second);
				} else {
					initializer.addInitializer((ObjectInitializerPart) pi);
				}
			}
		}
		if (!commas.isEmpty()
				&& commas.size() >= initializer.getInitializers().size()
				&& reporter != null) {
			reporter.setMessage(JavaScriptParserProblems.TRAILING_COMMA_OBJECT_INITIALIZER);
			final int comma = commas.get(commas.size() - 1);
			reporter.setRange(comma, comma + 1);
			reporter.report();
		}

		initializer.setCommas(commas);

		initializer.setLC(getTokenOffset(node.getTokenStartIndex()));
		initializer.setRC(getTokenOffset(node.getTokenStopIndex()));

		Token LC = tokens.get(node.getTokenStartIndex());
		Token RC = tokens.get(node.getTokenStopIndex());

		initializer.setMultiline(LC.getLine() != RC.getLine());

		initializer.setStart(initializer.getLC());
		initializer.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return initializer;
	}

	private PropertyInitializer buildPropertyInitializer(Tree node) {
		PropertyInitializer initializer = new PropertyInitializer(getParent());
		initializer.setName(transformExpression(node.getChild(0), initializer));
		final Expression value;
		final int colonPos;
		if (node.getChildCount() >= 2) {
			colonPos = getTokenOffset(JSParser.COLON, node.getChild(0)
					.getTokenStopIndex() + 1, node.getChild(1)
					.getTokenStartIndex());
			value = transformExpression(node.getChild(1), initializer);
		} else {
			colonPos = getTokenOffset(JSParser.COLON, node.getChild(0)
					.getTokenStopIndex() + 1, node.getTokenStopIndex());
			value = new ErrorExpression(initializer, Util.EMPTY_STRING);
			value.setStart(colonPos + 1);
			value.setEnd(colonPos + 1);
		}
		initializer.setValue(value);
		initializer.setColon(colonPos);
		initializer.setStart(initializer.getName().sourceStart());
		initializer.setEnd(value.sourceEnd());
		return initializer;
	}

	protected ASTNode visitPropertyInitializer(Tree node) {
		final PropertyInitializer initializer = buildPropertyInitializer(node);
		if (node.getChildCount() == 3) {
			final Tree fixNode = node.getChild(2);
			if (fixNode.getType() == JSParser.NAMEDVALUE) {
				return new PropertyInitializerPair(initializer,
						buildPropertyInitializer(fixNode));
			} else if (fixNode.getType() == JSParser.COLON) {
				final Expression value1 = initializer.getValue();
				if (value1 instanceof Identifier
						|| value1 instanceof StringLiteral
						&& JavaScriptLanguageUtil
								.isValidIdentifier(((StringLiteral) value1)
										.getValue())) {
					final PropertyInitializer initializer2 = new PropertyInitializer(
							getParent());
					initializer2.setColon(getTokenOffset(fixNode
							.getTokenStartIndex()));
					initializer2.setValue(transformExpression(
							fixNode.getChild(0), initializer2));
					initializer2.setEnd(initializer2.getValue().sourceEnd());
					initializer2.setName(changeParent(value1, initializer2));
					initializer2.setStart(value1.sourceStart());
					final ErrorExpression error = new ErrorExpression(
							initializer, "");
					final int colonPos = initializer.getColon() + 1;
					error.setStart(colonPos);
					error.setEnd(colonPos);
					initializer.setValue(error);
					return new PropertyInitializerPair(initializer,
							initializer2);
				}
			}
		}
		return initializer;
	}

	private Expression changeParent(Expression expression, JSNode newParent) {
		if (expression instanceof Identifier) {
			final Identifier identifier = (Identifier) expression;
			final Identifier copy = new Identifier(newParent);
			copy.setName(identifier.getName());
			copyCommonFields(identifier, copy);
			return copy;
		} else if (expression instanceof StringLiteral) {
			final StringLiteral literal = (StringLiteral) expression;
			final StringLiteral copy = new StringLiteral(newParent);
			copy.setText(literal.getText());
			copyCommonFields(literal, copy);
			return copy;
		} else {
			throw new IllegalArgumentException("Unsupported expression "
					+ expression.getClass().getName());
		}
	}

	private static <E extends Expression & Documentable> void copyCommonFields(
			E source, E dest) {
		dest.setDocumentation(source.getDocumentation());
		dest.setStart(source.sourceStart());
		dest.setEnd(source.sourceEnd());
	}

	protected ASTNode visitForEachInStatement(Tree node) {
		ForEachInStatement statement = new ForEachInStatement(getParent());

		statement.setForKeyword(createKeyword(node, Keywords.FOR));

		Keyword eachKeyword = new Keyword(Keywords.EACH);
		eachKeyword.setStart(getTokenOffset(JSParser.EACH,
				node.getTokenStartIndex(), node.getTokenStopIndex()));
		eachKeyword.setEnd(eachKeyword.sourceStart() + Keywords.EACH.length());
		statement.setEachKeyword(eachKeyword);

		statement.setLP(getTokenOffset(JSParser.LPAREN, node
				.getTokenStartIndex() + 1, node.getChild(0)
				.getTokenStartIndex()));

		statement.setItem(transformExpression(node.getChild(0).getChild(0),
				statement));

		Keyword inKeyword = new Keyword(Keywords.IN);
		int iteratorStart = node.getChild(0).getChild(1).getTokenStartIndex();
		if (iteratorStart == -1
				&& node.getChild(0).getChild(1).getType() == JSParser.EXPR
				&& node.getChild(0).getChild(1).getChildCount() > 0)
			iteratorStart = node.getChild(0).getChild(1).getChild(0)
					.getTokenStartIndex();

		inKeyword.setStart(getTokenOffset(JSParser.IN,
				getRealTokenStopIndex(node.getChild(0).getChild(0)) + 1,
				iteratorStart));
		inKeyword.setEnd(inKeyword.sourceStart() + Keywords.IN.length());
		statement.setInKeyword(inKeyword);

		statement.setIterator(transformExpression(node.getChild(0).getChild(1),
				statement));

		statement.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(0)
				.getTokenStopIndex() + 1, node.getTokenStopIndex()));

		if (node.getChildCount() > 1)
			statement.setBody(transformStatementNode(node.getChild(1),
					statement));

		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	private static int getRealTokenStopIndex(Tree node) {

		if (node.getTokenStopIndex() == -1)
			return getRealTokenStopIndex(node
					.getChild(node.getChildCount() - 1));

		if (node.getChildCount() > 0) {
			return Math
					.max(node.getTokenStopIndex(), getRealTokenStopIndex(node
							.getChild(node.getChildCount() - 1)));
		}

		return node.getTokenStopIndex();
	}

	protected ASTNode visitByField(Tree node) {

		PropertyExpression property = new PropertyExpression(getParent());
		locateDocumentation(property, node);

		property.setObject(transformExpression(node.getChild(0), property));

		final int dotPosition = getTokenOffset(node.getChild(1)
				.getTokenStartIndex());
		property.setDotPosition(dotPosition);

		if (node.getChild(2) != null) {
			property.setProperty(transformExpression(node.getChild(2), property));
		} else {
			final ErrorExpression error = new ErrorExpression(property,
					Util.EMPTY_STRING);
			error.setStart(dotPosition + 1);
			error.setEnd(dotPosition + 1);
			property.setProperty(error);
		}

		assert property.getObject().sourceStart() >= 0;
		assert property.getProperty().sourceEnd() > 0;

		property.setStart(property.getObject().sourceStart());
		property.setEnd(property.getProperty().sourceEnd());

		return property;
	}

	protected ASTNode visitWhile(Tree node) {

		WhileStatement statement = new WhileStatement(getParent());

		statement.setWhileKeyword(createKeyword(node, Keywords.WHILE));

		statement.setLP(getTokenOffset(JSParser.LPAREN, node
				.getTokenStartIndex(), node.getChild(0).getTokenStartIndex()));

		statement
				.setCondition(transformExpression(node.getChild(0), statement));

		statement.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(0)
				.getTokenStopIndex() + 1, node.getTokenStopIndex()));

		if (node.getChildCount() > 1)
			statement.setBody(transformStatementNode(node.getChild(1),
					statement));

		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	protected ASTNode visitIf(Tree node) {

		IfStatement ifStatement = new IfStatement(getParent());

		ifStatement.setIfKeyword(createKeyword(node, Keywords.IF));

		ifStatement.setLP(getTokenOffset(JSParser.LPAREN, node
				.getTokenStartIndex() + 1, node.getChild(0)
				.getTokenStartIndex()));
		ifStatement.setCondition(transformExpression(node.getChild(0),
				ifStatement));

		if (node.getChildCount() > 1) {
			ifStatement.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(0)
					.getTokenStopIndex() + 1, node.getChild(1)
					.getTokenStartIndex()));
			ifStatement.setThenStatement(transformStatementNode(
					node.getChild(1), ifStatement));
		} else {
			ifStatement.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(0)
					.getTokenStopIndex() + 1, node.getChild(0)
					.getTokenStopIndex() + 1));
		}

		if (node.getChildCount() > 2) {
			Keyword elseKeyword = new Keyword(Keywords.ELSE);
			elseKeyword.setStart(getTokenOffset(JSParser.ELSE, node.getChild(1)
					.getTokenStopIndex() + 1, node.getChild(2)
					.getTokenStartIndex()));
			elseKeyword.setEnd(elseKeyword.sourceStart()
					+ Keywords.ELSE.length());
			ifStatement.setElseKeyword(elseKeyword);

			ifStatement.setElseStatement(transformStatementNode(
					node.getChild(2), ifStatement));
		}

		ifStatement.setStart(ifStatement.getIfKeyword().sourceStart());
		setEndByTokenIndex(ifStatement, node.getTokenStopIndex());

		return ifStatement;
	}

	protected ASTNode visitDoWhile(Tree node) {
		DoWhileStatement statement = new DoWhileStatement(getParent());

		statement.setDoKeyword(createKeyword(node, Keywords.DO));

		statement.setBody(transformStatementNode(node.getChild(0), statement));

		Keyword whileKeyword = new Keyword(Keywords.WHILE);
		whileKeyword
				.setStart(getTokenOffset(JSParser.WHILE, node.getChild(0)
						.getTokenStopIndex() + 1, node.getChild(1)
						.getTokenStartIndex()));
		whileKeyword.setEnd(whileKeyword.sourceStart()
				+ Keywords.WHILE.length());
		statement.setWhileKeyword(whileKeyword);

		statement
				.setLP(getTokenOffset(JSParser.LPAREN, node.getChild(0)
						.getTokenStopIndex() + 1, node.getChild(1)
						.getTokenStartIndex()));

		statement
				.setCondition(transformExpression(node.getChild(1), statement));

		statement.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(1)
				.getTokenStopIndex() + 1, node.getTokenStopIndex()));

		statement
				.setSemicolonPosition(getTokenOffset(JSParser.SEMIC, node
						.getChild(1).getTokenStopIndex() + 1, node
						.getTokenStopIndex()));

		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	protected ASTNode visitConditional(Tree node) {

		ConditionalOperator operator = new ConditionalOperator(getParent());

		operator.setCondition(transformExpression(node.getChild(0), operator));
		operator.setTrueValue(transformExpression(node.getChild(1), operator));
		operator.setFalseValue(transformExpression(node.getChild(2), operator));

		operator.setQuestionPosition(getTokenOffset(JSParser.QUE, node
				.getChild(0).getTokenStopIndex() + 1, node.getChild(1)
				.getTokenStartIndex()));

		operator.setColonPosition(getTokenOffset(JSParser.COLON,
				node.getChild(1).getTokenStopIndex() + 1,
				node.getChildCount() > 2 ? node.getChild(2)
						.getTokenStartIndex() : node.getTokenStopIndex()));

		operator.setStart(getTokenOffset(node.getTokenStartIndex()));
		operator.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return operator;
	}

	protected ASTNode visitParenthesizedExpression(Tree node) {

		final ParenthesizedExpression expression = new ParenthesizedExpression(
				getParent());
		expression.setLP(getTokenOffset(node.getTokenStartIndex()));
		expression.setStart(expression.getLP());

		if (node.getChildCount() == 2) {
			expression.setExpression(transformExpression(node.getChild(0),
					expression));
			expression.setRP(getTokenOffset(node.getChild(1)
					.getTokenStartIndex()));
		} else {
			expression.setExpression(new ErrorExpression(expression,
					Util.EMPTY_STRING));
			expression.setRP(getTokenOffset(node.getChild(0)
					.getTokenStartIndex()));
		}

		expression.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return expression;
	}

	protected ASTNode visitTry(Tree node) {

		TryStatement statement = new TryStatement(getParent());

		statement.setTryKeyword(createKeyword(node, Keywords.TRY));

		statement.setBody((StatementBlock) transformStatementNode(
				node.getChild(0), statement));

		boolean sawDefaultCatch = false;
		for (int i = 1 /* miss body */; i < node.getChildCount(); i++) {

			Tree child = node.getChild(i);

			switch (child.getType()) {
			case JSParser.CATCH:
				final CatchClause catchClause = (CatchClause) transformNode(
						child, statement);
				if (reporter != null && sawDefaultCatch) {
					reporter.setMessage(JavaScriptParserProblems.CATCH_UNREACHABLE);
					reporter.setRange(catchClause.sourceStart(),
							catchClause.getRP() + 1);
					reporter.report();
				}
				if (!sawDefaultCatch
						&& catchClause.getFilterExpression() == null) {
					sawDefaultCatch = true;
				}
				statement.getCatches().add(catchClause);
				break;

			case JSParser.FINALLY:
				statement.setFinally((FinallyClause) transformNode(child,
						statement));
				break;

			default:
				throw new UnsupportedOperationException(
						"CATCH or FINALLY expected");
			}

		}

		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	protected ASTNode visitThrow(Tree node) {

		ThrowStatement statement = new ThrowStatement(getParent());

		statement.setThrowKeyword(createKeyword(node, Keywords.THROW));

		if (node.getChildCount() > 0) {
			statement.setException(transformExpression(node.getChild(0),
					statement));
		}

		statement.setSemicolonPosition(getTokenOffset(JSParser.SEMIC,
				node.getTokenStopIndex(), node.getTokenStopIndex()));

		setRange(statement, node);

		return statement;
	}

	protected ASTNode visitNew(Tree node) {
		final NewExpression expression = new NewExpression(getParent());
		expression.setNewKeyword(createKeyword(node, Keywords.NEW));
		final Tree expressionTree = node.getChild(0);
		if (expressionTree != null) {
			expression.setObjectClass(transformExpression(expressionTree,
					expression));
		} else {
			final ErrorExpression error = new ErrorExpression(expression,
					Util.EMPTY_STRING);
			final int pos = expression.getNewKeyword().sourceEnd();
			error.setStart(pos);
			error.setEnd(pos);
			expression.setObjectClass(error);
		}
		expression.setStart(getTokenOffset(node.getTokenStartIndex()));
		expression.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));
		return expression;
	}

	protected ASTNode visitCatch(Tree node) {

		CatchClause catchClause = new CatchClause(getParent());

		catchClause.setCatchKeyword(createKeyword(node, Keywords.CATCH));

		catchClause.setLP(getTokenOffset(JSParser.LPAREN, node
				.getTokenStartIndex() + 1, node.getChild(0)
				.getTokenStartIndex()));

		catchClause.setException((Identifier) transformNode(node.getChild(0),
				catchClause));

		int statementIndex = 1;

		if (statementIndex < node.getChildCount()
				&& node.getChild(statementIndex).getType() == JSParser.IF) {
			catchClause.setIfKeyword(createKeyword(
					node.getChild(statementIndex++), Keywords.IF));

			catchClause.setFilterExpression(transformExpression(
					node.getChild(statementIndex++), catchClause));
		}

		if (statementIndex < node.getChildCount()) {
			catchClause.setRP(getTokenOffset(JSParser.RPAREN,
					node.getChild(statementIndex - 1).getTokenStopIndex() + 1,
					node.getChild(statementIndex).getTokenStartIndex()));

			catchClause.setStatement(transformStatementNode(
					node.getChild(statementIndex), catchClause));
		}

		catchClause.setStart(getTokenOffset(node.getTokenStartIndex()));
		catchClause.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return catchClause;
	}

	protected ASTNode visitFinally(Tree node) {

		FinallyClause finallyClause = new FinallyClause(getParent());

		finallyClause.setFinallyKeyword(createKeyword(node, Keywords.FINALLY));

		if (node.getChildCount() >= 1) {
			finallyClause.setStatement(transformStatementNode(node.getChild(0),
					finallyClause));
		}

		finallyClause.setStart(getTokenOffset(node.getTokenStartIndex()));
		finallyClause.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return finallyClause;
	}

	protected ASTNode visitArray(Tree node) {
		final int itemCount = node.getChildCount() - 1;
		ArrayInitializer array = new ArrayInitializer(getParent(), itemCount);
		array.setLB(getTokenOffset(node.getTokenStartIndex()));
		for (int i = 0; i < itemCount; i++) {
			final Tree child = node.getChild(i);
			assert child.getType() == JSParser.ITEM : "ITEM expected"; //$NON-NLS-1$
			final Tree item = child.getChild(0);
			if (item != null) {
				array.getItems().add(transformExpression(item, array));
				if (i != itemCount - 1) {
					final int nextComma = getTokenOffset(JSParser.COMMA,
							child.getTokenStopIndex() + 1, node.getChild(i + 1)
									.getTokenStartIndex());
					array.getCommas().add(nextComma);
				}
			} else {
				assert i != itemCount - 1;
				final int nextComma = getTokenOffset(JSParser.COMMA,
						child.getTokenStopIndex() + 1, node.getChild(i + 1)
								.getTokenStartIndex());
				final EmptyExpression empty = new EmptyExpression(array);
				empty.setStart(nextComma);
				empty.setEnd(nextComma);
				array.getItems().add(empty);
				array.getCommas().add(nextComma);
			}
		}
		array.setRB(getTokenOffset(node.getChild(itemCount)
				.getTokenStartIndex()));
		array.setStart(array.getLB());
		array.setEnd(array.getRB() + 1);
		return array;
	}

	protected ASTNode visitByIndex(Tree node) {

		GetArrayItemExpression item = new GetArrayItemExpression(getParent());

		item.setArray(transformExpression(node.getChild(0), item));
		item.setLB(getTokenOffset(((CommonTree) node).getToken()
				.getTokenIndex()));
		if (node.getChildCount() == 2) {
			item.setIndex(transformExpression(node.getChild(1), item));
			item.setRB(getTokenOffset(JSParser.RBRACK, node.getChild(1)
					.getTokenStopIndex() + 1, tokens.size() - 1));
		} else {
			item.setIndex(new ErrorExpression(item, Util.EMPTY_STRING));
			item.setRB(getTokenOffset(JSParser.RBRACK, node.getChild(0)
					.getTokenStopIndex() + 1, tokens.size() - 1));
		}

		item.setStart(item.getArray().sourceStart());
		if (item.getRB() > -1) {
			item.setEnd(item.getRB() + 1);
		} else {
			item.setEnd(item.getIndex().sourceEnd());
		}

		return item;
	}

	protected ASTNode visitCommaExpression(Tree node) {

		CommaExpression expression = new CommaExpression(getParent());

		List<ASTNode> items = new ArrayList<ASTNode>(node.getChildCount());
		IntList commas = new IntList();

		for (int i = 0; i < node.getChildCount(); i++) {
			items.add(transformNode(node.getChild(i), expression));

			if (i > 0)
				commas.add(getTokenOffset(JSParser.COMMA, node.getChild(i - 1)
						.getTokenStopIndex(), node.getChild(i)
						.getTokenStartIndex()));
		}

		expression.setItems(items);
		expression.setCommas(commas);

		expression.setStart(getTokenOffset(node.getTokenStartIndex()));
		expression.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return expression;
	}

	protected ASTNode visitRegExp(Tree node) {
		RegExpLiteral regexp = new RegExpLiteral(getParent());
		regexp.setText(intern(node.getText()));

		regexp.setStart(getTokenOffset(node.getTokenStartIndex()));
		regexp.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return regexp;
	}

	protected ASTNode visitWith(Tree node) {

		WithStatement statement = new WithStatement(getParent());

		statement.setWithKeyword(createKeyword(node, Keywords.WITH));

		statement.setLP(getTokenOffset(JSParser.LPAREN, node
				.getTokenStartIndex(), node.getChild(0).getTokenStartIndex()));

		statement
				.setExpression(transformExpression(node.getChild(0), statement));

		statement.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(0)
				.getTokenStopIndex() + 1, node.getTokenStopIndex()));

		if (node.getChildCount() > 1)
			statement.setStatement(transformStatementNode(node.getChild(1),
					statement));

		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	protected ASTNode visitThis(Tree node) {

		ThisExpression expression = new ThisExpression(getParent());

		expression.setStart(getTokenOffset(node.getTokenStartIndex()));
		expression.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return expression;
	}

	protected ASTNode visitLabelled(Tree node) {
		LabelledStatement statement = new LabelledStatement(getParent());

		Label label = new Label(statement);
		label.setText(intern(node.getChild(0).getText()));
		setRangeByToken(label, node.getChild(0).getTokenStartIndex());
		statement.setLabel(label);

		statement.setColonPosition(getTokenOffset(JSParser.COLON, node
				.getChild(0).getTokenStopIndex() + 1,
				node.getTokenStopIndex() + 1));

		if (!scope.addLabel(statement) && reporter != null) {
			reporter.setMessage(JavaScriptParserProblems.DUPLICATE_LABEL);
			reporter.setSeverity(ProblemSeverity.ERROR);
			reporter.setRange(label.sourceStart(), label.sourceEnd());
			reporter.report();
		}

		if (node.getChildCount() > 1) {
			statement.setStatement(transformStatementNode(node.getChild(1),
					statement));
		}

		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	protected ASTNode visitGet(Tree node) {

		GetMethod method = new GetMethod(getParent());

		method.setGetKeyword(createKeyword(node, Keywords.GET));

		method.setName((Identifier) transformNode(node.getChild(0), method));

		method.setLP(getTokenOffset(JSParser.LPAREN, node.getChild(0)
				.getTokenStopIndex() + 1, node.getChild(1).getTokenStartIndex()));

		method.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(0)
				.getTokenStopIndex() + 1, node.getChild(1).getTokenStartIndex()));

		method.setBody((StatementBlock) transformStatementNode(
				node.getChild(1), method));

		method.setStart(getTokenOffset(node.getTokenStartIndex()));
		method.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return method;
	}

	protected ASTNode visitSet(Tree node) {
		SetMethod method = new SetMethod(getParent());

		method.setSetKeyword(createKeyword(node, Keywords.SET));

		method.setName((Identifier) transformNode(node.getChild(0), method));

		method.setLP(getTokenOffset(JSParser.LPAREN, node.getChild(0)
				.getTokenStopIndex() + 1, node.getChild(1).getTokenStartIndex()));

		method.setArgument((Identifier) transformNode(node.getChild(1), method));

		method.setRP(getTokenOffset(JSParser.RPAREN, node.getChild(0)
				.getTokenStopIndex() + 1, node.getChild(2).getTokenStartIndex()));

		method.setBody((StatementBlock) transformStatementNode(
				node.getChild(2), method));

		method.setStart(getTokenOffset(node.getTokenStartIndex()));
		method.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return method;
	}

	protected ASTNode visitNull(Tree node) {

		NullExpression expression = new NullExpression(getParent());

		expression.setStart(getTokenOffset(node.getTokenStartIndex()));
		expression.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return expression;
	}

	protected ASTNode visitConst(Tree node) {
		ConstStatement declaration = new ConstStatement(getParent());
		locateDocumentation(declaration, node);
		declaration.setConstKeyword(createKeyword(node, Keywords.CONST));

		processVariableDeclarations(node, declaration, SymbolKind.CONST);

		declaration.setStart(getTokenOffset(node.getTokenStartIndex()));
		declaration.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return declaration;
	}

	private void addComments(Script script) {
		for (int i = 0; i < tokens.size(); i++) {
			final Token token = tokens.get(i);
			final Comment comment;
			if (token.getType() == JSParser.MultiLineComment) {
				Comment c = new MultiLineComment();
				c.setText(token.getText());
				c.setStart(getTokenOffset(token.getTokenIndex()));
				c.setEnd(c.sourceStart() + token.getText().length());
				comment = c;
			} else if (token.getType() == JSParser.SingleLineComment) {
				Comment c = new SingleLineComment();
				c.setText(token.getText());
				c.setStart(getTokenOffset(token.getTokenIndex()));
				c.setEnd(c.sourceStart() + token.getText().length());
				comment = c;
			} else {
				continue;
			}
			script.addComment(comment);
			if (comment.isDocumentation()) {
				documentationMap.put(token.getTokenIndex(), comment);
			}
		}
	}

	protected ASTNode visitBooleanLiteral(Tree node) {

		BooleanLiteral bool = new BooleanLiteral(getParent(),
				node.getType() == JSParser.TRUE);

		bool.setStart(getTokenOffset(node.getTokenStartIndex()));
		bool.setEnd(getTokenOffset(node.getTokenStartIndex() + 1));

		return bool;
	}

	protected ASTNode visitXmlLiteral(Tree node) {
		final XmlLiteral xml = new XmlLiteral(getParent());
		final List<XmlFragment> fragments = new ArrayList<XmlFragment>();
		for (int i = 0; i < node.getChildCount(); ++i) {
			final Tree child = node.getChild(i);
			if (child.getType() == JSParser.XMLFragment
					|| child.getType() == JSParser.XMLFragmentEnd) {
				final XmlTextFragment fragment = new XmlTextFragment(xml);
				fragment.setStart(getTokenOffset(child.getTokenStartIndex()));
				fragment.setEnd(getTokenOffset(child.getTokenStopIndex() + 1));
				fragment.setXml(child.getText());
				fragments.add(fragment);
			} else {
				XmlExpressionFragment fragment = new XmlExpressionFragment(xml);
				Expression expression = transformExpression(child, fragment);
				fragment.setExpression(expression);
				fragment.setStart(expression.sourceStart());
				fragment.setEnd(expression.sourceEnd());
				fragments.add(fragment);
				// TODO curly braces
			}
		}
		if (fragments.size() > 1) {
			Collections.sort(fragments, new Comparator<XmlFragment>() {
				public int compare(XmlFragment o1, XmlFragment o2) {
					return o1.sourceStart() - o2.sourceStart();
				}
			});
		}
		xml.setFragments(fragments);
		xml.setStart(getTokenOffset(node.getTokenStartIndex()));
		xml.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return xml;
	}

	protected ASTNode visitNamespace(Tree node) {

		DefaultXmlNamespaceStatement statement = new DefaultXmlNamespaceStatement(
				getParent());

		statement.setDefaultKeyword(createKeyword(node.getChild(0),
				Keywords.DEFAULT));
		statement.setXmlKeyword(createKeyword(node.getChild(1), Keywords.XML));

		Keyword namespaceKeyword = new Keyword(Keywords.NAMESPACE);
		namespaceKeyword.setStart(getTokenOffset(JSParser.NAMESPACE,
				node.getTokenStartIndex(), node.getTokenStopIndex()));
		namespaceKeyword.setEnd(namespaceKeyword.sourceStart()
				+ Keywords.NAMESPACE.length());
		statement.setNamespaceKeyword(namespaceKeyword);

		statement.setAssignOperation(getTokenOffset(node.getChild(2)
				.getTokenStartIndex()));

		statement.setValue(transformExpression(node.getChild(3), statement));

		Token token = tokens.get(node.getTokenStopIndex());
		if (token.getType() == JSParser.SEMIC) {
			statement.setSemicolonPosition(getTokenOffset(node
					.getTokenStopIndex()));

			statement.setEnd(statement.getSemicolonPosition() + 1);
		} else {
			statement.setEnd(statement.getValue().sourceEnd());
		}
		statement.setStart(statement.getDefaultKeyword().sourceStart());

		return statement;
	}

	protected ASTNode visitXmlAttribute(Tree node) {

		XmlAttributeIdentifier id = new XmlAttributeIdentifier(getParent());
		final Expression expression = transformExpression(node.getChild(1), id);
		id.setExpression(expression);

		id.setStart(getTokenOffset(node.getTokenStartIndex()));
		id.setEnd(expression.sourceEnd());

		return id;
	}

	protected ASTNode visitAsterisk(Tree node) {
		AsteriskExpression asterisk = new AsteriskExpression(getParent());

		asterisk.setStart(getTokenOffset(node.getTokenStartIndex()));
		asterisk.setEnd(asterisk.sourceStart() + node.getText().length());

		return asterisk;
	}

	protected ASTNode visitGetAllChildren(Tree node) {
		GetAllChildrenExpression expression = new GetAllChildrenExpression(
				getParent());

		expression.setObject(transformExpression(node.getChild(0), expression));

		expression
				.setProperty(transformExpression(node.getChild(1), expression));

		expression.setDotDotPosition(getTokenOffset(JSParser.DOTDOT,
				getRealTokenStopIndex(node.getChild(0)) + 1, node.getChild(1)
						.getTokenStartIndex()));

		assert expression.getObject().sourceStart() >= 0;
		assert expression.getProperty().sourceEnd() > 0;

		expression.setStart(expression.getObject().sourceStart());
		expression.setEnd(expression.getProperty().sourceEnd());

		return expression;
	}

	protected ASTNode visitGetLocalName(Tree node) {
		GetLocalNameExpression expression = new GetLocalNameExpression(
				getParent());

		expression.setNamespace(transformExpression(node.getChild(0),
				expression));

		expression.setLocalName(transformExpression(node.getChild(1),
				expression));

		expression.setColonColonPosition(getTokenOffset(JSParser.COLONCOLON,
				getRealTokenStopIndex(node.getChild(0)) + 1, node.getChild(1)
						.getTokenStartIndex()));

		assert expression.getNamespace().sourceStart() >= 0;
		assert expression.getLocalName().sourceEnd() > 0;

		expression.setStart(expression.getNamespace().sourceStart());
		expression.setEnd(expression.getLocalName().sourceEnd());

		return expression;
	}

	protected ASTNode visitHexIntegerLiteral(Tree node) {
		DecimalLiteral number = new DecimalLiteral(getParent());
		number.setText(intern(node.getText()));
		number.setStart(getTokenOffset(node.getTokenStartIndex()));
		number.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return number;
	}

	protected ASTNode visitOctalIntegerLiteral(Tree node) {
		DecimalLiteral number = new DecimalLiteral(getParent());
		number.setText(intern(node.getText()));
		number.setStart(getTokenOffset(node.getTokenStartIndex()));
		number.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return number;
	}

	protected ASTNode visitYield(Tree node) {
		YieldOperator expression = new YieldOperator(getParent());

		expression.setYieldKeyword(createKeyword(node, Keywords.YIELD));

		expression.setExpression(transformExpression(node.getChild(0),
				expression));

		expression.setStart(expression.getYieldKeyword().sourceStart());
		expression.setEnd(expression.getExpression().sourceEnd());

		return expression;
	}

	protected ASTNode visitEmptyStatement(Tree node) {
		final EmptyStatement statement = new EmptyStatement(getParent());
		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
		statement.setEnd(getTokenOffset(node.getTokenStartIndex() + 1));
		return statement;
	}

}
