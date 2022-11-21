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
package org.eclipse.dltk.javascript.parser.rhino;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

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
import org.eclipse.dltk.javascript.parser.JSProblemIdentifier;
import org.eclipse.dltk.javascript.parser.JavaScriptParserProblems;
import org.eclipse.dltk.javascript.parser.NodeTransformer;
import org.eclipse.dltk.javascript.parser.NodeTransformerExtension;
import org.eclipse.dltk.javascript.parser.Reporter;
import org.eclipse.dltk.javascript.parser.SymbolKind;
import org.eclipse.dltk.javascript.parser.SymbolTable;
import org.eclipse.dltk.utils.IntList;
import org.mozilla.javascript.Token;

@SuppressWarnings("restriction")
public class JSTransformer {

	private final NodeTransformer[] transformers;
//	private final List<Token> tokens;
//	private final int[] tokenOffsets;
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

	public JSTransformer() {
		this(NodeTransformerManager.NO_TRANSFORMERS, false);
	}

	public JSTransformer(boolean ignoreUnknown) {
		this(NodeTransformerManager.NO_TRANSFORMERS, ignoreUnknown);
	}

	public JSTransformer(NodeTransformer[] transformers,
			boolean ignoreUnknown) {
		this.transformers = transformers;
//		this.tokens = tokens;
		this.ignoreUnknown = ignoreUnknown;
//		tokenOffsets = prepareOffsetMap(tokens);
	}

	private static final WeakHashSet stringPool = new WeakHashSet();

	private static final String intern(String value) {
		synchronized (stringPool) {
			return (String) stringPool.add(value);
		}
	}

	protected final ASTNode visitNode(TokenStream node) throws IOException {
		ASTNode accept = visit(node);
//		if (accept == null) {
//			for (int i = 0; i < node.getChildCount(); i++) {
//				visitNode(node.getChild(i));
//			}
//		}
		return accept;
	}

	private ASTNode internalVisit(TokenStream node) throws IOException {
		assert node != null;
		switch (node.peekToken()) {

		case Token.NAME:
//		case Token.WXML:
		case Token.GET:
		case Token.SET:
//		case Token.EACH:
//		case Token.NAMESPACE:
			return visitIdentifier(node);

		case Token.BLOCK:
			return visitBlock(node);

		case Token.TRUE:
		case Token.FALSE:
			return visitBooleanLiteral(node);

		case Token.THIS:
			return visitThis(node);

		case Token.NUMBER:
			return visitDecimalLiteral(node);

		case Token.STRING:
			return visitStringLiteral(node);

//		case Token.BYFIELD:
//			return visitByField(node);
//
//		case Token.BYINDEX:
//			return visitByIndex(node);

		case Token.EXP:
			return visitExpression(node);

		case Token.CALL:
			return visitCall(node);

		case Token.NULL:
			return visitNull(node);

			// arithmetic
		case Token.ADD:
		case Token.SUB:
		case Token.MUL:
		case Token.DIV:
		case Token.MOD:
			// assign
		case Token.ASSIGN:
		case Token.ASSIGN_ADD:
		case Token.ASSIGN_SUB:
		case Token.ASSIGN_MUL:
		case Token.ASSIGN_DIV:
		case Token.ASSIGN_MOD:
			// conditional
		case Token.LT:
		case Token.GT:
		case Token.LE:
		case Token.GE:
			// bitwise
		case Token.AND:
		case Token.OR:
		case Token.BITXOR:
		case Token.ASSIGN_BITAND:
		case Token.ASSIGN_BITXOR:
		case Token.ASSIGN_BITOR:
		case Token.LSH:
		case Token.RSH:
		case Token.URSH:
		case Token.ASSIGN_LSH:
		case Token.ASSIGN_RSH:
		case Token.ASSIGN_URSH:
			// logical
		case Token.BITOR:
		case Token.BITAND:
		case Token.SHEQ:
		case Token.EQ:
		case Token.NE:
		case Token.SHNE:
			// special
		case Token.IN:
		case Token.INSTANCEOF:
			return visitBinaryOperation(node);

//		case Token.PINC:
//		case Token.PDEC:
		case Token.INC:
		case Token.DEC:
		case Token.NEG:
		case Token.POS:
		case Token.NOT:
		case Token.BITNOT:
		case Token.DEL_REF:
		case Token.TYPEOF:
		case Token.VOID:
			return visitUnaryOperation(node);

		case Token.RETURN:
			return visitReturn(node);

		case Token.SWITCH:
			return visitSwitch(node);

		case Token.DEFAULT:
			return visitDefault(node);

		case Token.CASE:
			return visitCase(node);

		case Token.BREAK:
			return visitBreak(node);

		case Token.CONTINUE:
			return visitContinue(node);

		case Token.DO:
			return visitDoWhile(node);

		case Token.WHILE:
			return visitWhile(node);

		case Token.FOR:
			return visitFor(node);

//		case Token.OBJECT:
//			return visitObjectInitializer(node);

//		case Token.NAMEDVALUE:
//			return visitPropertyInitializer(node);

//		case Token.FOREACH:
//			return visitForEachInStatement(node);

		case Token.IF:
			return visitIf(node);

//		case Token.QUE:
//			return visitConditional(node);

//		case Token.PAREXPR:
//			return visitParenthesizedExpression(node);

		case Token.TRY:
			return visitTry(node);

		case Token.THROW:
			return visitThrow(node);

		case Token.CATCH:
			return visitCatch(node);

		case Token.FINALLY:
			return visitFinally(node);

		case Token.NEW:
			return visitNew(node);

		case Token.ARRAYLIT:
			return visitArray(node);

		case Token.COMMA:
			return visitCommaExpression(node);

		case Token.REGEXP:
			return visitRegExp(node);

		case Token.WITH:
			return visitWith(node);

		case Token.LABEL:
			return visitLabelled(node);

		case Token.GET_REF:
			return visitGet(node);

		case Token.SET_REF:
			return visitSet(node);

		case Token.VAR:
			return visitVarDeclaration(node);

		case Token.CONST:
			return visitConst(node);

		case Token.FUNCTION:
//		case Token.FUNCTION_DECLARATION:
			return visitFunction(node);

		case Token.XML:
			return visitXmlLiteral(node);

		case Token.DEFAULTNAMESPACE:
			return visitNamespace(node);

		case Token.XMLATTR:
			return visitXmlAttribute(node);

//		case Token.ALLCHILDREN:
//			return visitGetAllChildren(node);

//		case Token.LOCALNAME:
//			return visitGetLocalName(node);

//		case Token.HexIntegerLiteral:
//			return visitHexIntegerLiteral(node);
//
//		case Token.OctalIntegerLiteral:
//			return visitOctalIntegerLiteral(node);

		case Token.YIELD:
			return visitYield(node);

		case Token.EMPTY:
			return visitEmptyStatement(node);

		default:
			return visitUnknown(node);
		}
	}

	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	public Script transformScript(TokenStream ts) throws IOException {
		final Script script = new Script();
		scope = new SymbolTable(script);
		addComments(script);
		while (ts.peekToken() != Token.EOF) {
			script.addStatement(transformStatementNode(ts, script));
			ts.consumeToken();
		}
		script.setStart(0);
		script.setEnd(ts.tokenEnd);
		for (NodeTransformer transformer : transformers) {
			if (transformer instanceof NodeTransformerExtension) {
				((NodeTransformerExtension) transformer).postConstruct(script);
			}
		}
		return script;
	}

//	public ASTNode transform(ParserRuleReturnScope root) {
//		Assert.isNotNull(root);
//		final Tree tree = (Tree) root.getTree();
//		if (tree == null)
//			return null;
//		scope = null;
//		return transformExpression(tree, null);
//	}

	private JSNode getParent() {
		if (parents.isEmpty()) {
			return null;
		} else {
			return parents.peek();
		}
	}

	private ASTNode transformNode(TokenStream node, JSNode parent) throws IOException {
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

//	private static int[] prepareOffsetMap(List<Token> tokens) {
//		final int[] offsets = new int[tokens.size() + 1];
//		for (int i = 0; i < tokens.size(); i++) {
//			offsets[i] = ((CommonToken) tokens.get(i)).getStartIndex();
//		}
//		if (tokens.isEmpty()) {
//			offsets[0] = 0;
//		} else {
//			offsets[tokens.size()] = ((CommonToken) tokens
//					.get(tokens.size() - 1)).getStopIndex() + 1;
//		}
//		return offsets;
//	}

//	private int getTokenOffset(int tokenIndex) {
//		try {
//			return tokenOffsets[tokenIndex];
//		} catch (ArrayIndexOutOfBoundsException e) {
//			return -1;
//		}
//	}

	private void setRange(ASTNode node, int start, int end) {
		node.setStart(start);
		node.setEnd(end);
	}

//	private void setRange(ASTNode node, Tree treeNode) {
//		node.setStart(getTokenOffset(treeNode.getTokenStartIndex()));
//		setEndByTokenIndex(node, treeNode.getTokenStopIndex());
//	}

//	private void setEndByTokenIndex(ASTNode node, int stopIndex) {
//		while (stopIndex >= 0 && isHidden(tokens.get(stopIndex))) {
//			--stopIndex;
//		}
//		node.setEnd(getTokenOffset(stopIndex + 1));
//	}
//
//	private static boolean isHidden(Token token) {
//		return token.getType() == Token.EOL
//				|| token.getType() == Token.SingleLineComment
//				|| token.getType() == Token.MultiLineComment;
//	}

//	private int getTokenOffset(int tokenType, int startTokenIndex,
//			int endTokenIndex) {
//
//		Assert.isTrue(startTokenIndex >= 0);
//		Assert.isTrue(endTokenIndex >= 0);
//		Assert.isTrue(startTokenIndex <= endTokenIndex);
//
//		Token token = null;
//
//		for (int i = startTokenIndex; i <= endTokenIndex; i++) {
//			Token item = tokens.get(i);
//			if (item.getType() == tokenType) {
//				token = item;
//				break;
//			}
//		}
//
//		if (token == null)
//			return -1;
//		else
//			return getTokenOffset(token.getTokenIndex());
//	}

	private final Expression transformExpression(TokenStream node, JSNode parent) throws IOException {
		final ASTNode transformed = transformNode(node, parent);
		if (transformed == null || transformed instanceof Expression) {
			return (Expression) transformed;
		} else {
			return createErrorExpression(node);
		}
	}

	private Statement transformStatementNode(TokenStream node, JSNode parent) throws IOException {

		ASTNode expression = transformNode(node, parent);

		if (expression instanceof Statement)
			return (Statement) expression;
		else {
			VoidExpression voidExpression = new VoidExpression(parent);
			voidExpression.setExpression((Expression) expression);

//			if (node.getTokenStopIndex() >= 0
//					&& node.getTokenStopIndex() < tokens.size()) {
//				final Token token = tokens.get(node.getTokenStopIndex());
//				if (token.getType() == Token.SEMIC) {
//					voidExpression.setSemicolonPosition(getTokenOffset(token
//							.getTokenIndex()));
//					voidExpression.getExpression().setEnd(
//							Math.min(voidExpression.getSemicolonPosition(),
//									expression.sourceEnd()));
//				}
//			}

			assert expression.sourceStart() >= 0;
			assert expression.sourceEnd() > 0;

			voidExpression.setStart(expression.sourceStart());
			voidExpression.setEnd(Math.max(expression.sourceEnd(),
					voidExpression.getSemicolonPosition() + 1));

			return voidExpression;
		}
	}

	protected ASTNode visit(TokenStream tree) throws IOException {
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

	private void locateDocumentation(final Documentable node, TokenStream tree) {
//		int tokenIndex = tree.getTokenStartIndex();
//		while (tokenIndex > 0) {
//			--tokenIndex;
//			final Token token = tokens.get(tokenIndex);
//			if (token.getType() == Token.WhiteSpace
//					|| token.getType() == Token.EOL) {
//				continue;
//			}
//			if (token.getType() == Token.MultiLineComment) {
//				final Comment comment = documentationMap.get(token
//						.getTokenIndex());
//				if (comment != null) {
//					node.setDocumentation(comment);
//				}
//			}
//			break;
//		}
	}

	protected ASTNode visitUnknown(TokenStream node) throws IOException {
		if (ignoreUnknown) {
			return createErrorExpression(node);
		}
		throw new UnsupportedOperationException("Unknown token "
				+ Token.name(node.peekToken()) + " (" + node.getString()
				+ ")");
	}

	private ErrorExpression createErrorExpression(TokenStream node) {
		if (node != null) {
			ErrorExpression error = new ErrorExpression(getParent(),
					node.getString());
			error.setStart(node.tokenBeg);
			error.setEnd(node.tokenEnd);
			return error;
		} else {
			return new ErrorExpression(getParent(), "");
		}
	}

	protected ASTNode visitBinaryOperation(TokenStream node) throws IOException {
//		if (node.peekToken() == Token.MUL) {
//			switch (node.getChildCount()) {
//			case 0:
//				return visitAsterisk(node);
//			case 1:
//				// HACK
//				return visit(node.getChild(0));
//			}
//
//		}
//
//		Assert.isNotNull(node.getChild(0));
//		Assert.isNotNull(node.getChild(1));

		BinaryOperation operation = new BinaryOperation(getParent());

		operation.setOperation(node.peekToken());
		node.consumeToken();
		operation.setLeftExpression(transformExpression(node, operation));
		node.consumeToken();
		operation.setRightExpression(transformExpression(node, operation));

//		operation.setOperationPosition(getTokenOffset(node.getType(),
//				getRealTokenStopIndex(node.getChild(0)) + 1, node.getChild(1)
//						.getTokenStartIndex()));
//
//		Assert.isTrue(operation.getOperationPosition() >= operation
//				.getLeftExpression().sourceEnd());
//		Assert.isTrue(operation.getOperationPosition()
//				+ operation.getOperationText().length() <= operation
//				.getRightExpression().sourceStart());
//
//		operation.setStart(operation.getLeftExpression().sourceStart());
//		operation.setEnd(operation.getRightExpression().sourceEnd());

		return operation;
	}

	protected ASTNode visitBlock(TokenStream node) {

		StatementBlock block = new StatementBlock(getParent());

//		List<Statement> statements = block.getStatements();
//		for (int i = 0; i < node.getChildCount(); i++) {
//			statements.add(transformStatementNode(node.getChild(i), block));
//		}
//
//		block.setLC(getTokenOffset(Token.LBRACE, node.getTokenStartIndex(),
//				node.getTokenStopIndex()));
//
//		block.setRC(getTokenOffset(Token.RBRACE, node.getTokenStopIndex(),
//				node.getTokenStopIndex()));
//
//		if (block.getLC() > -1) {
//			block.setStart(block.getLC());
//		} else if (!statements.isEmpty()) {
//			block.setStart(statements.get(0).sourceStart());
//		} else {
//			block.setStart(getTokenOffset(node.getTokenStartIndex()));
//		}
//		if (block.getRC() > -1) {
//			block.setEnd(block.getRC() + 1);
//		} else if (!statements.isEmpty()) {
//			block.setEnd(statements.get(statements.size() - 1).sourceStart());
//		} else {
//			block.setEnd(getTokenOffset(node.getTokenStopIndex()));
//		}

		return block;
	}

	private Keyword createKeyword(TokenStream node, String text) {
		assert text.equals(node.getString());
		// assert text.equals(Keywords.fromToken(node.getType()));
		final Keyword keyword = new Keyword(text);
		setRange(keyword, node.tokenBeg, node.tokenEnd);
		return keyword;
	}

	protected ASTNode visitBreak(TokenStream node) {
		BreakStatement statement = new BreakStatement(getParent());
		statement.setBreakKeyword(createKeyword(node, Keywords.BREAK));

//		if (node.getChildCount() > 0) {
//			Label label = new Label(statement);
//			final Tree labelNode = node.getChild(0);
//			label.setText(intern(labelNode.getText()));
//			setRangeByToken(label, labelNode.getTokenStartIndex());
//			statement.setLabel(label);
//			validateLabel(label);
//		}
//
//		statement.setSemicolonPosition(getTokenOffset(Token.SEMIC,
//				node.getTokenStopIndex(), node.getTokenStopIndex()));
//
//		statement.setStart(statement.getBreakKeyword().sourceStart());
//
//		if (statement.getLabel() != null)
//			statement.setEnd(Math.max(statement.getSemicolonPosition() + 1,
//					statement.getLabel().sourceEnd()));
//		else
//			statement.setEnd(Math.max(statement.getSemicolonPosition() + 1,
//					statement.getBreakKeyword().sourceEnd()));
//		if (statement.getLabel() == null) {
//			validateParent(JavaScriptParserProblems.BAD_BREAK, statement,
//					LoopStatement.class, SwitchStatement.class);
//		}
		return statement;
	}

	protected ASTNode visitCall(TokenStream node) {
		CallExpression call = new CallExpression(getParent());

//		Assert.isNotNull(node.getChild(0));
//		Assert.isNotNull(node.getChild(1));
//
//		call.setExpression(transformExpression(node.getChild(0), call));
//		Tree callArgs = node.getChild(1);
//		IntList commas = new IntList();
//		for (int i = 0; i < callArgs.getChildCount(); ++i) {
//			Tree callArg = callArgs.getChild(i);
//			final ASTNode argument = transformNode(callArg, call);
//			if (i > 0) {
//				commas.add(getTokenOffset(Token.COMMA,
//						callArgs.getChild(i - 1).getTokenStopIndex() + 1,
//						callArg.getTokenStartIndex()));
//			}
//			call.addArgument(argument);
//		}
//		call.setCommas(commas);
//
//		call.setLP(getTokenOffset(Token.LPAREN, node.getChild(1)
//				.getTokenStartIndex(), node.getChild(1).getTokenStartIndex()));
//		call.setRP(getTokenOffset(Token.RPAREN, node.getChild(1)
//				.getTokenStopIndex(), node.getChild(1).getTokenStopIndex()));
//
//		call.setStart(call.getExpression().sourceStart());
//		if (call.getRP() > -1) {
//			call.setEnd(call.getRP() + 1);
//		} else {
//			call.setEnd(call.getExpression().sourceEnd());
//		}

		return call;
	}

	protected ASTNode visitCase(TokenStream node) {
		CaseClause caseClause = new CaseClause(getParent());

		caseClause.setCaseKeyword(createKeyword(node, Keywords.CASE));

//		final Tree condition = node.getChild(0);
//		if (condition != null) {
//			caseClause.setCondition(transformExpression(condition, caseClause));
//			caseClause
//					.setColonPosition(getTokenOffset(Token.COLON,
//							condition.getTokenStopIndex() + 1,
//							node.getTokenStopIndex()));
//		} else {
//			caseClause.setCondition(new ErrorExpression(caseClause,
//					Util.EMPTY_STRING));
//			caseClause
//					.setColonPosition(caseClause.getCaseKeyword().sourceEnd());
//		}
//
//		// skip condition
//		for (int i = 1; i < node.getChildCount(); i++) {
//			caseClause.getStatements().add(
//					transformStatementNode(node.getChild(i), caseClause));
//		}
//
//		caseClause.setStart(caseClause.getCaseKeyword().sourceStart());
//		caseClause.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return caseClause;
	}

	protected ASTNode visitDecimalLiteral(TokenStream node) {
		DecimalLiteral number = new DecimalLiteral(getParent());
		number.setText(intern(node.getString()));
		number.setStart(node.tokenBeg);
		number.setEnd(node.tokenEnd);
		node.consumeToken();
		return number;
	}

	protected ASTNode visitDefault(TokenStream node) {
		DefaultClause defaultClause = new DefaultClause(getParent());

		defaultClause.setDefaultKeyword(createKeyword(node, Keywords.DEFAULT));

//		defaultClause.setColonPosition(getTokenOffset(Token.COLON,
//				node.getTokenStartIndex() + 1, node.getTokenStopIndex() + 1));
//
//		for (int i = 0; i < node.getChildCount(); i++) {
//			defaultClause.getStatements().add(
//					transformStatementNode(node.getChild(i), defaultClause));
//		}
//
//		defaultClause.setStart(defaultClause.getDefaultKeyword().sourceStart());
//		defaultClause.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return defaultClause;
	}

	protected ASTNode visitExpression(TokenStream node) {
//		if (node.getChildCount() > 0)
//			return transformNode(node.getChild(0), getParent());
//		else
			return new EmptyExpression(getParent());
	}

	protected ASTNode visitFor(TokenStream node) {
//		switch (node.getChild(0).getType()) {
//		case Token.FORSTEP:
//			return visitForStatement(node);
//
//		case Token.FORITER:
//			return visitForInStatement(node);
//
//		case Token.BLOCK:
//			if (node.getChildCount() == 1) {
//				// TODO error reporting???? "for() {" case
//				final ForStatement statement = new ForStatement(getParent());
//				statement.setForKeyword(createKeyword(node, Keywords.FOR));
//				statement.setInitial(new EmptyExpression(statement));
//				statement.setCondition(new EmptyExpression(statement));
//				statement.setStep(new EmptyExpression(statement));
//				statement.setBody(transformStatementNode(node.getChild(0),
//						statement));
//				return statement;
//			}
//
//		default:
//			// TODO error reporting & recovery
//			throw new IllegalArgumentException("FORSTEP or FORITER expected");
//		}
		return null;
	}

	private ASTNode visitForStatement(TokenStream node) {
		ForStatement statement = new ForStatement(getParent());

		statement.setForKeyword(createKeyword(node, Keywords.FOR));

//		statement.setLP(getTokenOffset(Token.LPAREN,
//				node.getTokenStartIndex() + 1, node.getTokenStopIndex()));
//		final Tree forControl = node.getChild(0);
//		statement.setInitial(transformExpression(forControl.getChild(0),
//				statement));
//		statement.setInitialSemicolonPosition(getTokenOffset(forControl
//				.getChild(1).getTokenStartIndex()));
//		statement.setCondition(transformExpression(forControl.getChild(2),
//				statement));
//		statement.setConditionalSemicolonPosition(getTokenOffset(forControl
//				.getChild(3).getTokenStartIndex()));
//		statement
//				.setStep(transformExpression(forControl.getChild(4), statement));
//		statement.setRP(getTokenOffset(Token.RPAREN,
//				forControl.getTokenStopIndex() + 1, node.getTokenStopIndex()));
//
//		if (statement.getInitial() instanceof EmptyExpression) {
//			final int pos = statement.getInitialSemicolonPosition();
//			statement.getInitial().setStart(pos);
//			statement.getInitial().setEnd(pos);
//		}
//		if (statement.getCondition() instanceof EmptyExpression) {
//			final int pos = statement.getConditionalSemicolonPosition();
//			statement.getCondition().setStart(pos);
//			statement.getCondition().setEnd(pos);
//		}
//		if (statement.getStep() instanceof EmptyExpression) {
//			final int pos = statement.getConditionalSemicolonPosition() + 1;
//			statement.setStart(pos);
//			statement.setEnd(pos);
//		}
//
//		if (node.getChildCount() > 1) {
//			statement.setBody(transformStatementNode(node.getChild(1),
//					statement));
//		}

		statement.setStart(statement.getForKeyword().sourceStart());
		statement.setEnd(node.tokenEnd);

		return statement;
	}

	private ASTNode visitForInStatement(TokenStream node) {
		ForInStatement statement = new ForInStatement(getParent());

		statement.setForKeyword(createKeyword(node, Keywords.FOR));

//		statement.setLP(getTokenOffset(Token.LPAREN, node
//				.getTokenStartIndex() + 1, node.getChild(0)
//				.getTokenStartIndex()));
//
//		statement.setItem(transformExpression(node.getChild(0).getChild(0),
//				statement));
//
//		Keyword inKeyword = new Keyword(Keywords.IN);
//
//		int iteratorStart = node.getChild(0).getChild(1).getTokenStartIndex();
//
//		if (iteratorStart == -1
//				&& node.getChild(0).getChild(1).getType() == Token.EXPR
//				&& node.getChild(0).getChild(1).getChildCount() > 0)
//			iteratorStart = node.getChild(0).getChild(1).getChild(0)
//					.getTokenStartIndex();
//
//		inKeyword.setStart(getTokenOffset(Token.IN,
//				getRealTokenStopIndex(node.getChild(0).getChild(0)) + 1,
//				iteratorStart));
//		inKeyword.setEnd(inKeyword.sourceStart() + Keywords.IN.length());
//		statement.setInKeyword(inKeyword);
//
//		statement.setIterator(transformExpression(node.getChild(0).getChild(1),
//				statement));
//
//		statement.setRP(getTokenOffset(Token.RPAREN, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getTokenStopIndex()));
//
//		if (node.getChildCount() > 1)
//			statement.setBody(transformStatementNode(node.getChild(1),
//					statement));
//
//		statement.setStart(statement.getForKeyword().sourceStart());
//		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	   final static boolean isIdentifierKeyword(int token)
	    {
	    	return 
//	    			token == Token.WXML
	    		token == Token.GET
	      		|| token == Token.SET;
//	      		|| token == Token.EACH
//	      		|| token == Token.NAMESPACE; 
	    }
	   
	private Argument transformArgument(TokenStream node, JSNode parent) throws IOException {
		Assert.isTrue(node.peekToken() == Token.NAME
				|| isIdentifierKeyword(node.peekToken()));

		Argument argument = new Argument(parent);
		argument.setIdentifier((Identifier) visitIdentifier(node));
		argument.setStart(node.tokenBeg);
		argument.setEnd(node.tokenEnd);
		return argument;
	}

	protected ASTNode visitFunction(TokenStream node) throws IOException {
		FunctionStatement fn = new FunctionStatement(getParent(),
				node.peekToken() == Token.FUNCTION);
		locateDocumentation(fn, node);

		fn.setFunctionKeyword(createKeyword(node, Keywords.FUNCTION));

		int index = 0;

//		if (node.getChild(index).getType() != Token.ARGUMENTS) {
//			fn.setName((Identifier) transformNode(node.getChild(index), fn));
//			index++;
//		}
//
//		Tree argsNode = node.getChild(index++);
//		assert argsNode.getType() == Token.ARGUMENTS;
//
//		fn.setLP(getTokenOffset(Token.LPAREN, node.getTokenStartIndex() + 1,
//				argsNode.getTokenStartIndex()));
//		final SymbolTable functionScope = new SymbolTable(fn);
//		for (int i = 0, childCount = argsNode.getChildCount(); i < childCount; ++i) {
//			final Tree argNode = argsNode.getChild(i);
//			Argument argument = transformArgument(argNode, fn);
//			if (i + 1 < childCount) {
//				argument.setCommaPosition(getTokenOffset(Token.COMMA,
//						argNode.getTokenStopIndex() + 1,
//						argsNode.getChild(i + 1).getTokenStartIndex()));
//			}
//			fn.addArgument(argument);
//			if (functionScope.add(argument.getArgumentName(), SymbolKind.PARAM) != null
//					&& reporter != null) {
//				reporter.setFormattedMessage(
//						JavaScriptParserProblems.DUPLICATE_PARAMETER,
//						argument.getArgumentName());
//				reporter.setRange(argument.sourceStart(), argument.sourceEnd());
//				reporter.report();
//			}
//		}
//		fn.setRP(getTokenOffset(Token.RPAREN, argsNode.getTokenStopIndex(),
//				node.getChild(index).getTokenStartIndex()));
//		final Identifier nameNode = fn.getName();
//		if (fn.isDeclaration() && nameNode != null) {
//			final SymbolKind replaced = scope.add(nameNode.getName(),
//					SymbolKind.FUNCTION, fn);
//			if (replaced != null && reporter != null) {
//				if (replaced == SymbolKind.FUNCTION) {
//					reporter.setFormattedMessage(
//							JavaScriptParserProblems.DUPLICATE_FUNCTION,
//							nameNode.getName());
//				} else {
//					reporter.setFormattedMessage(
//							JavaScriptParserProblems.FUNCTION_DUPLICATES_OTHER,
//							nameNode.getName(), replaced.verboseName());
//				}
//				reporter.setRange(nameNode.sourceStart(), nameNode.sourceEnd());
//				reporter.report();
//			}
//		}
//		final Tree bodyNode = node.getChild(index);
//		final SymbolTable savedScope = scope;
//		try {
//			scope = functionScope;
//			fn.setBody((StatementBlock) transformNode(bodyNode, fn));
//		} finally {
//			scope = savedScope;
//		}
//		fn.setStart(fn.getFunctionKeyword().sourceStart());
//		fn.setEnd(fn.getBody().sourceEnd());

		return fn;
	}

	protected ASTNode visitIdentifier(TokenStream node) {

		Identifier id = new Identifier(getParent());
		locateDocumentation(id, node);

		id.setName(intern(node.getString()));

		setRange(id, node.tokenBeg, node.tokenEnd);

		return id;
	}

	protected ASTNode visitReturn(TokenStream node) {

		ReturnStatement returnStatement = new ReturnStatement(getParent());

		returnStatement.setReturnKeyword(createKeyword(node, Keywords.RETURN));

//		if (node.getChildCount() > 0) {
//			returnStatement.setValue(transformExpression(node.getChild(0),
//					returnStatement));
//		}
//
//		Token token = tokens.get(node.getTokenStopIndex());
//		if (token.getType() == Token.SEMIC) {
//			returnStatement.setSemicolonPosition(getTokenOffset(node
//					.getTokenStopIndex()));
//
//			returnStatement.setEnd(returnStatement.getSemicolonPosition() + 1);
//		} else if (returnStatement.getValue() != null) {
//			returnStatement.setEnd(returnStatement.getValue().sourceEnd());
//		} else {
//			returnStatement.setEnd(returnStatement.getReturnKeyword()
//					.sourceEnd());
//		}

		returnStatement.setStart(returnStatement.getReturnKeyword()
				.sourceStart());
		validateParent(JavaScriptParserProblems.INVALID_RETURN,
				returnStatement, FunctionStatement.class, Method.class);
		return returnStatement;
	}

	protected ASTNode visitStringLiteral(TokenStream node) {

		StringLiteral literal = new StringLiteral(getParent());
		locateDocumentation(literal, node);
		literal.setText(intern(node.getString()));

		literal.setStart(node.tokenBeg);
		literal.setEnd(node.tokenEnd);

		return literal;
	}

	protected ASTNode visitSwitch(TokenStream node) {

		SwitchStatement statement = new SwitchStatement(getParent());

		statement.setSwitchKeyword(createKeyword(node, Keywords.SWITCH));

//		statement.setLP(getTokenOffset(Token.LPAREN, node
//				.getTokenStartIndex() + 1, node.getChild(0)
//				.getTokenStartIndex()));
//		statement.setRP(getTokenOffset(Token.RPAREN, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getTokenStopIndex()));
//
//		statement
//				.setCondition(transformExpression(node.getChild(0), statement));
//
//		statement.setLC(getTokenOffset(Token.LBRACE, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getTokenStopIndex()));
//
//		List<Tree> caseNodes = new ArrayList<Tree>(node.getChildCount() - 1);
//		for (int i = 1; i < node.getChildCount(); i++) {
//			caseNodes.add(node.getChild(i));
//		}
//		Collections.sort(caseNodes, new Comparator<Tree>() {
//			public int compare(Tree o1, Tree o2) {
//				return o1.getTokenStartIndex() - o2.getTokenStartIndex();
//			}
//		});
//		int defaultCount = 0;
//		for (Tree child : caseNodes) {
//			switch (child.getType()) {
//			case Token.CASE:
//				statement.addCase((SwitchComponent) transformNode(child,
//						statement));
//				break;
//			case Token.DEFAULT:
//				if (defaultCount != 0 && reporter != null) {
//					reporter.setMessage(JavaScriptParserProblems.DOUBLE_SWITCH_DEFAULT);
//					reporter.setSeverity(ProblemSeverity.ERROR);
//					reporter.setStart(reporter.getOffset(child.getLine(),
//							child.getCharPositionInLine()));
//					reporter.setEnd(reporter.getStart()
//							+ child.getText().length());
//					reporter.report();
//				}
//				++defaultCount;
//				statement.addCase((SwitchComponent) transformNode(child,
//						statement));
//				break;
//			default:
//				throw new UnsupportedOperationException();
//			}
//		}
//
//		statement.setRC(getTokenOffset(Token.RBRACE,
//				node.getTokenStopIndex(), node.getTokenStopIndex()));

		statement.setStart(statement.getSwitchKeyword().sourceStart());
		statement.setEnd(statement.getRC() + 1);

		return statement;
	}

	protected ASTNode visitUnaryOperation(TokenStream node) throws IOException {

		UnaryOperation operation = new UnaryOperation(getParent());

		operation.setOperation(node.peekToken());

		int operationType = node.peekToken();

//		if (operation.isPostfix())
//			operation.setOperationPosition(getTokenOffset(operationType, node
//					.getChild(0).getTokenStopIndex() + 1, node
//					.getTokenStopIndex()));
//		else
//			operation.setOperationPosition(getTokenOffset(operationType,
//					node.getTokenStartIndex(), node.getTokenStopIndex()));

		if (operation.getOperationPosition() == -1) {

			// use compatible operations
			switch (operationType) {
//			case Token.PINC:
//				operationType = Token.INC;
//				break;
//
//			case Token.PDEC:
//				operationType = Token.DEC;
//				break;

			case Token.POS:
				operationType = Token.ADD;
				break;

			case Token.NEG:
				operationType = Token.SUB;
				break;
			}

//			if (operation.isPostfix())
//				operation.setOperationPosition(getTokenOffset(operationType,
//						node.getChild(0).getTokenStopIndex() + 1,
//						node.getTokenStopIndex()));
//			else
//				operation.setOperationPosition(getTokenOffset(operationType,
//						node.getTokenStartIndex(), node.getTokenStopIndex()));

		}

		assert operation.getOperationPosition() > -1;

//		operation
//				.setExpression(transformExpression(node.getChild(0), operation));

		setRange(operation, node.tokenBeg, node.tokenEnd);

		return operation;
	}

	protected ASTNode visitContinue(TokenStream node) {
		ContinueStatement statement = new ContinueStatement(getParent());
		statement.setContinueKeyword(createKeyword(node, Keywords.CONTINUE));

//		if (node.getChildCount() > 0) {
//			Label label = new Label(statement);
//			final Tree labelNode = node.getChild(0);
//			label.setText(intern(labelNode.getText()));
//			setRangeByToken(label, labelNode.getTokenStartIndex());
//			statement.setLabel(label);
//			validateLabel(label);
//		}
//
//		statement.setSemicolonPosition(getTokenOffset(Token.SEMIC,
//				node.getTokenStopIndex(), node.getTokenStopIndex()));
		setRange(statement, node.tokenBeg, node.tokenEnd);
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

	private VariableDeclaration transformVariableDeclaration(TokenStream node,
			IVariableStatement statement) throws IOException {
		Assert.isTrue(node.peekToken() == Token.NAME
				|| isIdentifierKeyword(node.peekToken()));

		VariableDeclaration declaration = new VariableDeclaration(statement);
		declaration.setStart(node.tokenBeg);
		declaration
				.setIdentifier((Identifier) transformNode(node, declaration));
		node.consumeToken();
		System.err.println(Token.name(node.peekToken()));
		if (node.peekToken() == Token.ASSIGN) {
			declaration.setAssignPosition(node.tokenBeg);
			node.consumeToken();
			declaration.setInitializer(transformExpression(node, declaration));
		}
		int i = 0;
//		if (i + 2 <= node.getChildCount()
//				&& node.getChild(i).getType() == Token.ASSIGN) {
//			declaration.setAssignPosition(getTokenOffset(node.getChild(i)
//					.getTokenStartIndex()));
//			declaration.setInitializer(transformExpression(
//					node.getChild(i + 1), declaration));
//			i += 2;
//		}
		declaration.setEnd(node.tokenEnd);
		return declaration;
	}

	protected ASTNode visitVarDeclaration(TokenStream node) throws IOException {
		VariableStatement var = new VariableStatement(getParent());
		locateDocumentation(var, node);
		int begin = node.tokenBeg;
		var.setVarKeyword(createKeyword(node, Keywords.VAR));
		var.setLineno(node.lineno);

		node.consumeToken();
		
		System.err.println(Token.name(node.peekToken()));
		processVariableDeclarations(node, var, SymbolKind.VAR);

		setRange(var, begin, node.tokenEnd);

		return var;
	}

	private void processVariableDeclarations(TokenStream node, IVariableStatement var,
			SymbolKind kind) throws IOException {
		
//		int childCount = 0;
		while(true) {
			final VariableDeclaration declaration = transformVariableDeclaration(
					node, var);
			var.addVariable(declaration);
//			if (i + 1 < childCount) {
//				declaration.setCommaPosition(getTokenOffset(Token.COMMA,
//						varNode.getTokenStopIndex() + 1, node.getChild(i + 1)
//								.getTokenStartIndex()));
//			}
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
//			childCount++;
			if (!node.matchToken(Token.COMMA, true)) break;
		}
	}

	protected ASTNode visitObjectInitializer(TokenStream node) {

		ObjectInitializer initializer = new ObjectInitializer(getParent());

		IntList commas = new IntList();

//		for (int i = 0; i < node.getChildCount(); i++) {
//			final Tree child = node.getChild(i);
//			if (child.getType() == Token.COMMA) {
//				commas.add(getTokenOffset(child.getTokenStartIndex()));
//			} else {
//				final ASTNode pi = transformNode(child, initializer);
//				if (pi instanceof PropertyInitializerPair) {
//					final PropertyInitializerPair pair = (PropertyInitializerPair) pi;
//					initializer.addInitializer(pair.first);
//					commas.add(-1);
//					initializer.addInitializer(pair.second);
//				} else {
//					initializer.addInitializer((ObjectInitializerPart) pi);
//				}
//			}
//		}
		if (!commas.isEmpty()
				&& commas.size() >= initializer.getInitializers().size()
				&& reporter != null) {
			reporter.setMessage(JavaScriptParserProblems.TRAILING_COMMA_OBJECT_INITIALIZER);
			final int comma = commas.get(commas.size() - 1);
			reporter.setRange(comma, comma + 1);
			reporter.report();
		}

		initializer.setCommas(commas);

//		initializer.setLC(getTokenOffset(node.getTokenStartIndex()));
//		initializer.setRC(getTokenOffset(node.getTokenStopIndex()));
//
//		Token LC = tokens.get(node.getTokenStartIndex());
//		Token RC = tokens.get(node.getTokenStopIndex());
//
//		initializer.setMultiline(LC.getLine() != RC.getLine());
//
//		initializer.setStart(initializer.getLC());
//		initializer.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return initializer;
	}

	private PropertyInitializer buildPropertyInitializer(TokenStream node) {
		PropertyInitializer initializer = new PropertyInitializer(getParent());
//		initializer.setName(transformExpression(node.getChild(0), initializer));
//		final Expression value;
//		final int colonPos;
//		if (node.getChildCount() >= 2) {
//			colonPos = getTokenOffset(Token.COLON, node.getChild(0)
//					.getTokenStopIndex() + 1, node.getChild(1)
//					.getTokenStartIndex());
//			value = transformExpression(node.getChild(1), initializer);
//		} else {
//			colonPos = getTokenOffset(Token.COLON, node.getChild(0)
//					.getTokenStopIndex() + 1, node.getTokenStopIndex());
//			value = new ErrorExpression(initializer, Util.EMPTY_STRING);
//			value.setStart(colonPos + 1);
//			value.setEnd(colonPos + 1);
//		}
//		initializer.setValue(value);
//		initializer.setColon(colonPos);
//		initializer.setStart(initializer.getName().sourceStart());
//		initializer.setEnd(value.sourceEnd());
		return initializer;
	}

	protected ASTNode visitPropertyInitializer(TokenStream node) {
		final PropertyInitializer initializer = buildPropertyInitializer(node);
//		if (node.getChildCount() == 3) {
//			final Tree fixNode = node.getChild(2);
//			if (fixNode.getType() == Token.NAMEDVALUE) {
//				return new PropertyInitializerPair(initializer,
//						buildPropertyInitializer(fixNode));
//			} else if (fixNode.getType() == Token.COLON) {
//				final Expression value1 = initializer.getValue();
//				if (value1 instanceof Identifier
//						|| value1 instanceof StringLiteral
//						&& JavaScriptLanguageUtil
//								.isValidIdentifier(((StringLiteral) value1)
//										.getValue())) {
//					final PropertyInitializer initializer2 = new PropertyInitializer(
//							getParent());
//					initializer2.setColon(getTokenOffset(fixNode
//							.getTokenStartIndex()));
//					initializer2.setValue(transformExpression(
//							fixNode.getChild(0), initializer2));
//					initializer2.setEnd(initializer2.getValue().sourceEnd());
//					initializer2.setName(changeParent(value1, initializer2));
//					initializer2.setStart(value1.sourceStart());
//					final ErrorExpression error = new ErrorExpression(
//							initializer, "");
//					final int colonPos = initializer.getColon() + 1;
//					error.setStart(colonPos);
//					error.setEnd(colonPos);
//					initializer.setValue(error);
//					return new PropertyInitializerPair(initializer,
//							initializer2);
//				}
//			}
//		}
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

	protected ASTNode visitForEachInStatement(TokenStream node) {
		ForEachInStatement statement = new ForEachInStatement(getParent());

		statement.setForKeyword(createKeyword(node, Keywords.FOR));

		Keyword eachKeyword = new Keyword(Keywords.EACH);
//		eachKeyword.setStart(getTokenOffset(Token.EACH,
//				node.getTokenStartIndex(), node.getTokenStopIndex()));
//		eachKeyword.setEnd(eachKeyword.sourceStart() + Keywords.EACH.length());
//		statement.setEachKeyword(eachKeyword);
//
//		statement.setLP(getTokenOffset(Token.LPAREN, node
//				.getTokenStartIndex() + 1, node.getChild(0)
//				.getTokenStartIndex()));
//
//		statement.setItem(transformExpression(node.getChild(0).getChild(0),
//				statement));
//
//		Keyword inKeyword = new Keyword(Keywords.IN);
//		int iteratorStart = node.getChild(0).getChild(1).getTokenStartIndex();
//		if (iteratorStart == -1
//				&& node.getChild(0).getChild(1).getType() == Token.EXPR
//				&& node.getChild(0).getChild(1).getChildCount() > 0)
//			iteratorStart = node.getChild(0).getChild(1).getChild(0)
//					.getTokenStartIndex();
//
//		inKeyword.setStart(getTokenOffset(Token.IN,
//				getRealTokenStopIndex(node.getChild(0).getChild(0)) + 1,
//				iteratorStart));
//		inKeyword.setEnd(inKeyword.sourceStart() + Keywords.IN.length());
//		statement.setInKeyword(inKeyword);
//
//		statement.setIterator(transformExpression(node.getChild(0).getChild(1),
//				statement));
//
//		statement.setRP(getTokenOffset(Token.RPAREN, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getTokenStopIndex()));
//
//		if (node.getChildCount() > 1)
//			statement.setBody(transformStatementNode(node.getChild(1),
//					statement));
//
//		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
//		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	private static int getRealTokenStopIndex(TokenStream node) {

//		if (node.getTokenStopIndex() == -1)
//			return getRealTokenStopIndex(node
//					.getChild(node.getChildCount() - 1));
//
//		if (node.getChildCount() > 0) {
//			return Math
//					.max(node.getTokenStopIndex(), getRealTokenStopIndex(node
//							.getChild(node.getChildCount() - 1)));
//		}
//
//		return node.getTokenStopIndex();
		return -1;
	}

	protected ASTNode visitByField(TokenStream node) {

		PropertyExpression property = new PropertyExpression(getParent());
		locateDocumentation(property, node);

//		property.setObject(transformExpression(node.getChild(0), property));
//
//		final int dotPosition = getTokenOffset(node.getChild(1)
//				.getTokenStartIndex());
//		property.setDotPosition(dotPosition);
//
//		if (node.getChild(2) != null) {
//			property.setProperty(transformExpression(node.getChild(2), property));
//		} else {
//			final ErrorExpression error = new ErrorExpression(property,
//					Util.EMPTY_STRING);
//			error.setStart(dotPosition + 1);
//			error.setEnd(dotPosition + 1);
//			property.setProperty(error);
//		}
//
//		assert property.getObject().sourceStart() >= 0;
//		assert property.getProperty().sourceEnd() > 0;
//
//		property.setStart(property.getObject().sourceStart());
//		property.setEnd(property.getProperty().sourceEnd());

		return property;
	}

	protected ASTNode visitWhile(TokenStream node) {

		WhileStatement statement = new WhileStatement(getParent());

		statement.setWhileKeyword(createKeyword(node, Keywords.WHILE));

//		statement.setLP(getTokenOffset(Token.LPAREN, node
//				.getTokenStartIndex(), node.getChild(0).getTokenStartIndex()));
//
//		statement
//				.setCondition(transformExpression(node.getChild(0), statement));
//
//		statement.setRP(getTokenOffset(Token.RPAREN, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getTokenStopIndex()));
//
//		if (node.getChildCount() > 1)
//			statement.setBody(transformStatementNode(node.getChild(1),
//					statement));
//
//		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
//		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	protected ASTNode visitIf(TokenStream node) {

		IfStatement ifStatement = new IfStatement(getParent());

		ifStatement.setIfKeyword(createKeyword(node, Keywords.IF));

//		ifStatement.setLP(getTokenOffset(Token.LPAREN, node
//				.getTokenStartIndex() + 1, node.getChild(0)
//				.getTokenStartIndex()));
//		ifStatement.setCondition(transformExpression(node.getChild(0),
//				ifStatement));
//
//		if (node.getChildCount() > 1) {
//			ifStatement.setRP(getTokenOffset(Token.RPAREN, node.getChild(0)
//					.getTokenStopIndex() + 1, node.getChild(1)
//					.getTokenStartIndex()));
//			ifStatement.setThenStatement(transformStatementNode(
//					node.getChild(1), ifStatement));
//		} else {
//			ifStatement.setRP(getTokenOffset(Token.RPAREN, node.getChild(0)
//					.getTokenStopIndex() + 1, node.getChild(0)
//					.getTokenStopIndex() + 1));
//		}
//
//		if (node.getChildCount() > 2) {
//			Keyword elseKeyword = new Keyword(Keywords.ELSE);
//			elseKeyword.setStart(getTokenOffset(Token.ELSE, node.getChild(1)
//					.getTokenStopIndex() + 1, node.getChild(2)
//					.getTokenStartIndex()));
//			elseKeyword.setEnd(elseKeyword.sourceStart()
//					+ Keywords.ELSE.length());
//			ifStatement.setElseKeyword(elseKeyword);
//
//			ifStatement.setElseStatement(transformStatementNode(
//					node.getChild(2), ifStatement));
//		}

		ifStatement.setStart(ifStatement.getIfKeyword().sourceStart());
//		setEndByTokenIndex(ifStatement, node.getTokenStopIndex());

		return ifStatement;
	}

	protected ASTNode visitDoWhile(TokenStream node) {
		DoWhileStatement statement = new DoWhileStatement(getParent());

		statement.setDoKeyword(createKeyword(node, Keywords.DO));

//		statement.setBody(transformStatementNode(node.getChild(0), statement));
//
//		Keyword whileKeyword = new Keyword(Keywords.WHILE);
//		whileKeyword
//				.setStart(getTokenOffset(Token.WHILE, node.getChild(0)
//						.getTokenStopIndex() + 1, node.getChild(1)
//						.getTokenStartIndex()));
//		whileKeyword.setEnd(whileKeyword.sourceStart()
//				+ Keywords.WHILE.length());
//		statement.setWhileKeyword(whileKeyword);
//
//		statement
//				.setLP(getTokenOffset(Token.LPAREN, node.getChild(0)
//						.getTokenStopIndex() + 1, node.getChild(1)
//						.getTokenStartIndex()));
//
//		statement
//				.setCondition(transformExpression(node.getChild(1), statement));
//
//		statement.setRP(getTokenOffset(Token.RPAREN, node.getChild(1)
//				.getTokenStopIndex() + 1, node.getTokenStopIndex()));
//
//		statement
//				.setSemicolonPosition(getTokenOffset(Token.SEMIC, node
//						.getChild(1).getTokenStopIndex() + 1, node
//						.getTokenStopIndex()));
//
//		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
//		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	protected ASTNode visitConditional(TokenStream node) {

		ConditionalOperator operator = new ConditionalOperator(getParent());

//		operator.setCondition(transformExpression(node.getChild(0), operator));
//		operator.setTrueValue(transformExpression(node.getChild(1), operator));
//		operator.setFalseValue(transformExpression(node.getChild(2), operator));
//
//		operator.setQuestionPosition(getTokenOffset(Token.QUE, node
//				.getChild(0).getTokenStopIndex() + 1, node.getChild(1)
//				.getTokenStartIndex()));
//
//		operator.setColonPosition(getTokenOffset(Token.COLON,
//				node.getChild(1).getTokenStopIndex() + 1,
//				node.getChildCount() > 2 ? node.getChild(2)
//						.getTokenStartIndex() : node.getTokenStopIndex()));
//
//		operator.setStart(getTokenOffset(node.getTokenStartIndex()));
//		operator.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return operator;
	}

	protected ASTNode visitParenthesizedExpression(TokenStream node) {

		final ParenthesizedExpression expression = new ParenthesizedExpression(
				getParent());
//		expression.setLP(getTokenOffset(node.getTokenStartIndex()));
//		expression.setStart(expression.getLP());
//
//		if (node.getChildCount() == 2) {
//			expression.setExpression(transformExpression(node.getChild(0),
//					expression));
//			expression.setRP(getTokenOffset(node.getChild(1)
//					.getTokenStartIndex()));
//		} else {
//			expression.setExpression(new ErrorExpression(expression,
//					Util.EMPTY_STRING));
//			expression.setRP(getTokenOffset(node.getChild(0)
//					.getTokenStartIndex()));
//		}
//
//		expression.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return expression;
	}

	protected ASTNode visitTry(TokenStream node) {

		TryStatement statement = new TryStatement(getParent());

		statement.setTryKeyword(createKeyword(node, Keywords.TRY));

//		statement.setBody((StatementBlock) transformStatementNode(
//				node.getChild(0), statement));
//
//		boolean sawDefaultCatch = false;
//		for (int i = 1 /* miss body */; i < node.getChildCount(); i++) {
//
//			Tree child = node.getChild(i);
//
//			switch (child.getType()) {
//			case Token.CATCH:
//				final CatchClause catchClause = (CatchClause) transformNode(
//						child, statement);
//				if (reporter != null && sawDefaultCatch) {
//					reporter.setMessage(JavaScriptParserProblems.CATCH_UNREACHABLE);
//					reporter.setRange(catchClause.sourceStart(),
//							catchClause.getRP() + 1);
//					reporter.report();
//				}
//				if (!sawDefaultCatch
//						&& catchClause.getFilterExpression() == null) {
//					sawDefaultCatch = true;
//				}
//				statement.getCatches().add(catchClause);
//				break;
//
//			case Token.FINALLY:
//				statement.setFinally((FinallyClause) transformNode(child,
//						statement));
//				break;
//
//			default:
//				throw new UnsupportedOperationException(
//						"CATCH or FINALLY expected");
//			}
//
//		}
//
//		statement.setStart(getTokenOffset(node.getTokenStartIndex()));
//		statement.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return statement;
	}

	protected ASTNode visitThrow(TokenStream node) {

		ThrowStatement statement = new ThrowStatement(getParent());

		statement.setThrowKeyword(createKeyword(node, Keywords.THROW));

//		if (node.getChildCount() > 0) {
//			statement.setException(transformExpression(node.getChild(0),
//					statement));
//		}
//
//		statement.setSemicolonPosition(getTokenOffset(Token.SEMIC,
//				node.getTokenStopIndex(), node.getTokenStopIndex()));
//
		setRange(statement, node.tokenBeg, node.tokenEnd);

		return statement;
	}

	protected ASTNode visitNew(TokenStream node) {
		final NewExpression expression = new NewExpression(getParent());
		expression.setNewKeyword(createKeyword(node, Keywords.NEW));
//		final Tree expressionTree = node.getChild(0);
//		if (expressionTree != null) {
//			expression.setObjectClass(transformExpression(expressionTree,
//					expression));
//		} else {
//			final ErrorExpression error = new ErrorExpression(expression,
//					Util.EMPTY_STRING);
//			final int pos = expression.getNewKeyword().sourceEnd();
//			error.setStart(pos);
//			error.setEnd(pos);
//			expression.setObjectClass(error);
//		}
//		expression.setStart(getTokenOffset(node.getTokenStartIndex()));
//		expression.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));
		return expression;
	}

	protected ASTNode visitCatch(TokenStream node) {

		CatchClause catchClause = new CatchClause(getParent());

		catchClause.setCatchKeyword(createKeyword(node, Keywords.CATCH));

//		catchClause.setLP(getTokenOffset(Token.LPAREN, node
//				.getTokenStartIndex() + 1, node.getChild(0)
//				.getTokenStartIndex()));
//
//		catchClause.setException((Identifier) transformNode(node.getChild(0),
//				catchClause));
//
//		int statementIndex = 1;
//
//		if (statementIndex < node.getChildCount()
//				&& node.getChild(statementIndex).getType() == Token.IF) {
//			catchClause.setIfKeyword(createKeyword(
//					node.getChild(statementIndex++), Keywords.IF));
//
//			catchClause.setFilterExpression(transformExpression(
//					node.getChild(statementIndex++), catchClause));
//		}
//
//		if (statementIndex < node.getChildCount()) {
//			catchClause.setRP(getTokenOffset(Token.RPAREN,
//					node.getChild(statementIndex - 1).getTokenStopIndex() + 1,
//					node.getChild(statementIndex).getTokenStartIndex()));
//
//			catchClause.setStatement(transformStatementNode(
//					node.getChild(statementIndex), catchClause));
//		}
//
//		catchClause.setStart(getTokenOffset(node.getTokenStartIndex()));
//		catchClause.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return catchClause;
	}

	protected ASTNode visitFinally(TokenStream node) {

		FinallyClause finallyClause = new FinallyClause(getParent());

		finallyClause.setFinallyKeyword(createKeyword(node, Keywords.FINALLY));

//		if (node.getChildCount() >= 1) {
//			finallyClause.setStatement(transformStatementNode(node.getChild(0),
//					finallyClause));
//		}
//
//		finallyClause.setStart(getTokenOffset(node.getTokenStartIndex()));
//		finallyClause.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return finallyClause;
	}

	protected ASTNode visitArray(TokenStream node) {
		ArrayInitializer array = new ArrayInitializer(getParent(), 0);
//		final int itemCount = node.getChildCount() - 1;
//		ArrayInitializer array = new ArrayInitializer(getParent(), itemCount);
//		array.setLB(getTokenOffset(node.getTokenStartIndex()));
//		for (int i = 0; i < itemCount; i++) {
//			final Tree child = node.getChild(i);
//			assert child.getType() == Token.ITEM : "ITEM expected"; //$NON-NLS-1$
//			final Tree item = child.getChild(0);
//			if (item != null) {
//				array.getItems().add(transformExpression(item, array));
//				if (i != itemCount - 1) {
//					final int nextComma = getTokenOffset(Token.COMMA,
//							child.getTokenStopIndex() + 1, node.getChild(i + 1)
//									.getTokenStartIndex());
//					array.getCommas().add(nextComma);
//				}
//			} else {
//				assert i != itemCount - 1;
//				final int nextComma = getTokenOffset(Token.COMMA,
//						child.getTokenStopIndex() + 1, node.getChild(i + 1)
//								.getTokenStartIndex());
//				final EmptyExpression empty = new EmptyExpression(array);
//				empty.setStart(nextComma);
//				empty.setEnd(nextComma);
//				array.getItems().add(empty);
//				array.getCommas().add(nextComma);
//			}
//		}
//		array.setRB(getTokenOffset(node.getChild(itemCount)
//				.getTokenStartIndex()));
//		array.setStart(array.getLB());
//		array.setEnd(array.getRB() + 1);
		return array;
	}

	protected ASTNode visitByIndex(TokenStream node) {

		GetArrayItemExpression item = new GetArrayItemExpression(getParent());

//		item.setArray(transformExpression(node.getChild(0), item));
//		item.setLB(getTokenOffset(((CommonTree) node).getToken()
//				.getTokenIndex()));
//		if (node.getChildCount() == 2) {
//			item.setIndex(transformExpression(node.getChild(1), item));
//			item.setRB(getTokenOffset(Token.RBRACK, node.getChild(1)
//					.getTokenStopIndex() + 1, tokens.size() - 1));
//		} else {
//			item.setIndex(new ErrorExpression(item, Util.EMPTY_STRING));
//			item.setRB(getTokenOffset(Token.RBRACK, node.getChild(0)
//					.getTokenStopIndex() + 1, tokens.size() - 1));
//		}
//
//		item.setStart(item.getArray().sourceStart());
//		if (item.getRB() > -1) {
//			item.setEnd(item.getRB() + 1);
//		} else {
//			item.setEnd(item.getIndex().sourceEnd());
//		}

		return item;
	}

	protected ASTNode visitCommaExpression(TokenStream node) {

		CommaExpression expression = new CommaExpression(getParent());

//		List<ASTNode> items = new ArrayList<ASTNode>(node.getChildCount());
//		IntList commas = new IntList();
//
//		for (int i = 0; i < node.getChildCount(); i++) {
//			items.add(transformNode(node.getChild(i), expression));
//
//			if (i > 0)
//				commas.add(getTokenOffset(Token.COMMA, node.getChild(i - 1)
//						.getTokenStopIndex(), node.getChild(i)
//						.getTokenStartIndex()));
//		}
//
//		expression.setItems(items);
//		expression.setCommas(commas);
//
//		expression.setStart(getTokenOffset(node.getTokenStartIndex()));
//		expression.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return expression;
	}

	protected ASTNode visitRegExp(TokenStream node) {
		RegExpLiteral regexp = new RegExpLiteral(getParent());
		regexp.setText(intern(node.getString()));

		regexp.setStart(node.tokenBeg);
		regexp.setEnd(node.tokenEnd);

		return regexp;
	}

	protected ASTNode visitWith(TokenStream node) {

		WithStatement statement = new WithStatement(getParent());

		statement.setWithKeyword(createKeyword(node, Keywords.WITH));

//		statement.setLP(getTokenOffset(Token.LPAREN, node
//				.getTokenStartIndex(), node.getChild(0).getTokenStartIndex()));
//
//		statement
//				.setExpression(transformExpression(node.getChild(0), statement));
//
//		statement.setRP(getTokenOffset(Token.RPAREN, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getTokenStopIndex()));
//
//		if (node.getChildCount() > 1)
//			statement.setStatement(transformStatementNode(node.getChild(1),
//					statement));

		statement.setStart(node.tokenBeg);
		statement.setEnd(node.tokenEnd);

		return statement;
	}

	protected ASTNode visitThis(TokenStream node) {

		ThisExpression expression = new ThisExpression(getParent());

		expression.setStart(node.tokenBeg);
		expression.setEnd(node.tokenEnd);

		return expression;
	}

	protected ASTNode visitLabelled(TokenStream node) {
		LabelledStatement statement = new LabelledStatement(getParent());

		Label label = new Label(statement);
//		label.setText(intern(node.getChild(0).getText()));
//		setRangeByToken(label, node.tokenBeg, node.tokenEnd);
//		statement.setLabel(label);
//
//		statement.setColonPosition(getTokenOffset(Token.COLON, node
//				.getChild(0).getTokenStopIndex() + 1,
//				node.getTokenStopIndex() + 1));
//
//		if (!scope.addLabel(statement) && reporter != null) {
//			reporter.setMessage(JavaScriptParserProblems.DUPLICATE_LABEL);
//			reporter.setSeverity(ProblemSeverity.ERROR);
//			reporter.setRange(label.sourceStart(), label.sourceEnd());
//			reporter.report();
//		}
//
//		if (node.getChildCount() > 1) {
//			statement.setStatement(transformStatementNode(node.getChild(1),
//					statement));
//		}

		statement.setStart(node.tokenBeg);
		statement.setEnd(node.tokenEnd);

		return statement;
	}

	protected ASTNode visitGet(TokenStream node) {

		GetMethod method = new GetMethod(getParent());

		method.setGetKeyword(createKeyword(node, Keywords.GET));

//		method.setName((Identifier) transformNode(node.getChild(0), method));
//
//		method.setLP(getTokenOffset(Token.LPAREN, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getChild(1).getTokenStartIndex()));
//
//		method.setRP(getTokenOffset(Token.RPAREN, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getChild(1).getTokenStartIndex()));
//
//		method.setBody((StatementBlock) transformStatementNode(
//				node.getChild(1), method));
//
		method.setStart(node.tokenBeg);
		method.setEnd(node.tokenEnd);

		return method;
	}

	protected ASTNode visitSet(TokenStream node) {
		SetMethod method = new SetMethod(getParent());

		method.setSetKeyword(createKeyword(node, Keywords.SET));

//		method.setName((Identifier) transformNode(node.getChild(0), method));
//
//		method.setLP(getTokenOffset(Token.LPAREN, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getChild(1).getTokenStartIndex()));
//
//		method.setArgument((Identifier) transformNode(node.getChild(1), method));
//
//		method.setRP(getTokenOffset(Token.RPAREN, node.getChild(0)
//				.getTokenStopIndex() + 1, node.getChild(2).getTokenStartIndex()));
//
//		method.setBody((StatementBlock) transformStatementNode(
//				node.getChild(2), method));
//
//		method.setStart(getTokenOffset(node.getTokenStartIndex()));
//		method.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return method;
	}

	protected ASTNode visitNull(TokenStream node) {

		NullExpression expression = new NullExpression(getParent());

		expression.setStart(node.tokenBeg);
		expression.setEnd(node.tokenEnd);

		return expression;
	}

	protected ASTNode visitConst(TokenStream node) throws IOException {
		ConstStatement declaration = new ConstStatement(getParent());
		locateDocumentation(declaration, node);
		declaration.setConstKeyword(createKeyword(node, Keywords.CONST));

		processVariableDeclarations(node, declaration, SymbolKind.CONST);

//		declaration.setSemicolonPosition(getTokenOffset(Token.SEMIC,
//				node.getTokenStopIndex(), node.getTokenStopIndex()));
//
//		declaration.setStart(getTokenOffset(node.getTokenStartIndex()));
//		declaration.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return declaration;
	}

	private void addComments(Script script) {
//		for (int i = 0; i < tokens.size(); i++) {
//			final Token token = tokens.get(i);
//			final Comment comment;
//			if (token.getType() == Token.MultiLineComment) {
//				Comment c = new MultiLineComment();
//				c.setText(token.getText());
//				c.setStart(getTokenOffset(token.getTokenIndex()));
//				c.setEnd(c.sourceStart() + token.getText().length());
//				comment = c;
//			} else if (token.getType() == Token.SingleLineComment) {
//				Comment c = new SingleLineComment();
//				c.setText(token.getText());
//				c.setStart(getTokenOffset(token.getTokenIndex()));
//				c.setEnd(c.sourceStart() + token.getText().length());
//				comment = c;
//			} else {
//				continue;
//			}
//			script.addComment(comment);
//			if (comment.isDocumentation()) {
//				documentationMap.put(token.getTokenIndex(), comment);
//			}
//		}
	}

	protected ASTNode visitBooleanLiteral(TokenStream node) throws IOException {

		BooleanLiteral bool = new BooleanLiteral(getParent(),
				node.peekToken() == Token.TRUE);

		bool.setStart(node.tokenBeg);
		bool.setEnd(node.tokenEnd);

		return bool;
	}

	protected ASTNode visitXmlLiteral(TokenStream node) {
		final XmlLiteral xml = new XmlLiteral(getParent());
		final List<XmlFragment> fragments = new ArrayList<XmlFragment>();
//		for (int i = 0; i < node.getChildCount(); ++i) {
//			final Tree child = node.getChild(i);
//			if (child.getType() == Token.XMLFragment
//					|| child.getType() == Token.XMLFragmentEnd) {
//				final XmlTextFragment fragment = new XmlTextFragment(xml);
//				fragment.setStart(getTokenOffset(child.getTokenStartIndex()));
//				fragment.setEnd(getTokenOffset(child.getTokenStopIndex() + 1));
//				fragment.setXml(child.getText());
//				fragments.add(fragment);
//			} else {
//				XmlExpressionFragment fragment = new XmlExpressionFragment(xml);
//				Expression expression = transformExpression(child, fragment);
//				fragment.setExpression(expression);
//				fragment.setStart(expression.sourceStart());
//				fragment.setEnd(expression.sourceEnd());
//				fragments.add(fragment);
//				// TODO curly braces
//			}
//		}
//		if (fragments.size() > 1) {
//			Collections.sort(fragments, new Comparator<XmlFragment>() {
//				public int compare(XmlFragment o1, XmlFragment o2) {
//					return o1.sourceStart() - o2.sourceStart();
//				}
//			});
//		}
//		xml.setFragments(fragments);
//		xml.setStart(getTokenOffset(node.getTokenStartIndex()));
//		xml.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));

		return xml;
	}

	protected ASTNode visitNamespace(TokenStream node) {

		DefaultXmlNamespaceStatement statement = new DefaultXmlNamespaceStatement(
				getParent());

//		statement.setDefaultKeyword(createKeyword(node.getChild(0),
//				Keywords.DEFAULT));
//		statement.setXmlKeyword(createKeyword(node.getChild(1), Keywords.XML));
//
//		Keyword namespaceKeyword = new Keyword(Keywords.NAMESPACE);
//		namespaceKeyword.setStart(getTokenOffset(Token.NAMESPACE,
//				node.getTokenStartIndex(), node.getTokenStopIndex()));
//		namespaceKeyword.setEnd(namespaceKeyword.sourceStart()
//				+ Keywords.NAMESPACE.length());
//		statement.setNamespaceKeyword(namespaceKeyword);
//
//		statement.setAssignOperation(getTokenOffset(node.getChild(2)
//				.getTokenStartIndex()));
//
//		statement.setValue(transformExpression(node.getChild(3), statement));
//
//		Token token = tokens.get(node.getTokenStopIndex());
//		if (token.getType() == Token.SEMIC) {
//			statement.setSemicolonPosition(getTokenOffset(node
//					.getTokenStopIndex()));
//
//			statement.setEnd(statement.getSemicolonPosition() + 1);
//		} else {
//			statement.setEnd(statement.getValue().sourceEnd());
//		}
//		statement.setStart(statement.getDefaultKeyword().sourceStart());

		return statement;
	}

	protected ASTNode visitXmlAttribute(TokenStream node) {

		XmlAttributeIdentifier id = new XmlAttributeIdentifier(getParent());
//		final Expression expression = transformExpression(node.getChild(1), id);
//		id.setExpression(expression);
//
//		id.setStart(getTokenOffset(node.getTokenStartIndex()));
//		id.setEnd(expression.sourceEnd());

		return id;
	}

	protected ASTNode visitAsterisk(TokenStream node) {
		AsteriskExpression asterisk = new AsteriskExpression(getParent());

		asterisk.setStart(node.tokenBeg);
		asterisk.setEnd(node.tokenEnd);

		return asterisk;
	}

	protected ASTNode visitGetAllChildren(TokenStream node) {
		GetAllChildrenExpression expression = new GetAllChildrenExpression(
				getParent());

//		expression.setObject(transformExpression(node.getChild(0), expression));
//
//		expression
//				.setProperty(transformExpression(node.getChild(1), expression));
//
//		expression.setDotDotPosition(getTokenOffset(Token.DOTDOT,
//				getRealTokenStopIndex(node.getChild(0)) + 1, node.getChild(1)
//						.getTokenStartIndex()));
//
//		assert expression.getObject().sourceStart() >= 0;
//		assert expression.getProperty().sourceEnd() > 0;
//
//		expression.setStart(expression.getObject().sourceStart());
//		expression.setEnd(expression.getProperty().sourceEnd());

		return expression;
	}

	protected ASTNode visitGetLocalName(TokenStream node) {
		GetLocalNameExpression expression = new GetLocalNameExpression(
				getParent());

//		expression.setNamespace(transformExpression(node.getChild(0),
//				expression));
//
//		expression.setLocalName(transformExpression(node.getChild(1),
//				expression));
//
//		expression.setColonColonPosition(getTokenOffset(Token.COLONCOLON,
//				getRealTokenStopIndex(node.getChild(0)) + 1, node.getChild(1)
//						.getTokenStartIndex()));
//
//		assert expression.getNamespace().sourceStart() >= 0;
//		assert expression.getLocalName().sourceEnd() > 0;
//
//		expression.setStart(expression.getNamespace().sourceStart());
//		expression.setEnd(expression.getLocalName().sourceEnd());

		return expression;
	}

	protected ASTNode visitHexIntegerLiteral(TokenStream node) {
		DecimalLiteral number = new DecimalLiteral(getParent());
		number.setText(intern(node.getString()));
		number.setStart(node.tokenBeg);
		number.setEnd(node.tokenEnd);

		return number;
	}

	protected ASTNode visitOctalIntegerLiteral(TokenStream node) {
		DecimalLiteral number = new DecimalLiteral(getParent());
		number.setText(intern(node.getString()));
		number.setStart(node.tokenBeg);
		number.setEnd(node.tokenEnd);

		return number;
	}

	protected ASTNode visitYield(TokenStream node) {
		YieldOperator expression = new YieldOperator(getParent());

		expression.setYieldKeyword(createKeyword(node, Keywords.YIELD));

//		expression.setExpression(transformExpression(node.getChild(0),
//				expression));

		expression.setStart(expression.getYieldKeyword().sourceStart());
		expression.setEnd(expression.getExpression().sourceEnd());

		return expression;
	}

	protected ASTNode visitEmptyStatement(TokenStream node) {
		final EmptyStatement statement = new EmptyStatement(getParent());
		statement.setStart(node.tokenBeg);
		statement.setEnd(node.tokenEnd);
		return statement;
	}

}
