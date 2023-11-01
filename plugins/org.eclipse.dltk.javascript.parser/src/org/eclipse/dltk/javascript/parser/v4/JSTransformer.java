package org.eclipse.dltk.javascript.parser.v4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.dltk.compiler.util.Util;
import org.eclipse.dltk.internal.core.util.WeakHashSet;
import org.eclipse.dltk.javascript.ast.AbstractForStatement;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.ArrayInitializer;
import org.eclipse.dltk.javascript.ast.BreakStatement;
import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.CaseClause;
import org.eclipse.dltk.javascript.ast.CatchClause;
import org.eclipse.dltk.javascript.ast.CommaExpression;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.ConditionalOperator;
import org.eclipse.dltk.javascript.ast.ConstStatement;
import org.eclipse.dltk.javascript.ast.ContinueStatement;
import org.eclipse.dltk.javascript.ast.DefaultClause;
import org.eclipse.dltk.javascript.ast.DoWhileStatement;
import org.eclipse.dltk.javascript.ast.Documentable;
import org.eclipse.dltk.javascript.ast.EmptyExpression;
import org.eclipse.dltk.javascript.ast.EmptyStatement;
import org.eclipse.dltk.javascript.ast.ErrorExpression;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.FinallyClause;
import org.eclipse.dltk.javascript.ast.ForInStatement;
import org.eclipse.dltk.javascript.ast.ForStatement;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.GetArrayItemExpression;
import org.eclipse.dltk.javascript.ast.GetMethod;
import org.eclipse.dltk.javascript.ast.IVariableStatement;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.IfStatement;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Keyword;
import org.eclipse.dltk.javascript.ast.Label;
import org.eclipse.dltk.javascript.ast.LabelledStatement;
import org.eclipse.dltk.javascript.ast.Literal;
import org.eclipse.dltk.javascript.ast.LoopStatement;
import org.eclipse.dltk.javascript.ast.Method;
import org.eclipse.dltk.javascript.ast.MultiLineComment;
import org.eclipse.dltk.javascript.ast.NewExpression;
import org.eclipse.dltk.javascript.ast.ObjectInitializer;
import org.eclipse.dltk.javascript.ast.ParenthesizedExpression;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.PropertyInitializer;
import org.eclipse.dltk.javascript.ast.ReturnStatement;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.SetMethod;
import org.eclipse.dltk.javascript.ast.SingleLineComment;
import org.eclipse.dltk.javascript.ast.Statement;
import org.eclipse.dltk.javascript.ast.StatementBlock;
import org.eclipse.dltk.javascript.ast.SwitchStatement;
import org.eclipse.dltk.javascript.ast.ThisExpression;
import org.eclipse.dltk.javascript.ast.ThrowStatement;
import org.eclipse.dltk.javascript.ast.TryStatement;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.VoidExpression;
import org.eclipse.dltk.javascript.ast.WhileStatement;
import org.eclipse.dltk.javascript.ast.WithStatement;
import org.eclipse.dltk.javascript.ast.YieldOperator;
import org.eclipse.dltk.javascript.ast.v4.ArrowFunctionStatement;
import org.eclipse.dltk.javascript.ast.v4.BinaryOperation;
import org.eclipse.dltk.javascript.ast.v4.ForOfStatement;
import org.eclipse.dltk.javascript.ast.v4.Keywords;
import org.eclipse.dltk.javascript.ast.v4.TagFunctionExpression;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringExpression;
import org.eclipse.dltk.javascript.ast.v4.TemplateStringLiteral;
import org.eclipse.dltk.javascript.ast.v4.UnaryOperation;
import org.eclipse.dltk.javascript.ast.v4.LetStatement;
import org.eclipse.dltk.javascript.internal.parser.NodeTransformerManager;
import org.eclipse.dltk.javascript.parser.JSProblemIdentifier;
import org.eclipse.dltk.javascript.parser.JavaScriptParserProblems;
import org.eclipse.dltk.javascript.parser.NodeTransformer;
import org.eclipse.dltk.javascript.parser.NodeTransformerExtension;
import org.eclipse.dltk.javascript.parser.Reporter;
import org.eclipse.dltk.javascript.parser.SymbolKind;
import org.eclipse.dltk.javascript.parser.SymbolTable;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AdditiveExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AnonymousFunctionDeclContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArgumentsContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArgumentsExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrayElementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrayLiteralExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrowFunctionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrowFunctionParametersContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignableContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentOperatorContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentOperatorExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitAndExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitNotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitOrExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitShiftExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitXOrExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BlockContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BreakStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.CaseClauseContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.CatchProductionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ContinueStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.DefaultClauseContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.DeleteExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.DoStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ElementListContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.EmptyStatement_Context;
import org.eclipse.dltk.javascript.parser.v4.JSParser.EqualityExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ExpressionSequenceContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ExpressionStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FinallyProductionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ForInStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ForOfStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ForStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FormalParameterArgContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FormalParameterListContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FunctionBodyContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FunctionDeclarationContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.IdentifierContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.IdentifierNameContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.IfStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.InExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.InstanceofExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LabelledStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LogicalAndExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LogicalOrExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MemberDotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MemberIndexExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MultiplicativeExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.NewExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.NotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ObjectLiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ParenthesizedExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PostDecreaseExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PostIncrementExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PreDecreaseExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PreIncrementExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ProgramContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PropertyExpressionAssignmentContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PropertyGetterContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PropertyNameContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PropertySetterContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.RelationalExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ReturnStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.SingleExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.SourceElementsContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.StatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.StatementListContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.SwitchStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TemplateStringAtomContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TemplateStringExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TemplateStringLiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TernaryExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ThisExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ThrowStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TryStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TypeofExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.UnaryMinusExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.UnaryPlusExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VarModifierContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VariableDeclarationContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VariableDeclarationListContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VariableStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VoidExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.WhileStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.WithStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.YieldStatementContext;
import org.eclipse.dltk.javascript.parser.v4.factory.JSNodeCreator;
import org.eclipse.dltk.utils.IntList;

public class JSTransformer extends JavaScriptParserBaseListener {

	private SymbolTable scope;
	private Stack<JSNode> parents = new Stack<JSNode>();
	private Stack<JSNode> children = new Stack<JSNode>();
	private Stack<List<Statement>> lists = new Stack<>();
	private Stack<SymbolTable> scopes = new Stack<SymbolTable>();
	private Stack<SymbolTable> blockScopes = new Stack<SymbolTable>();
	private Reporter reporter;
	private Script script;
	private List<Token> tokens;
	private int[] tokenOffsets;
	private final Map<Integer, Comment> documentationMap = new HashMap<Integer, Comment>();
	private NodeTransformer[] transformers;
	private boolean ignoreUnknown; //TODO check
	
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

	public static final String intern(String value) {
		synchronized (stringPool) {
			return (String) stringPool.add(value);
		}
	}
	
	private static int[] prepareOffsetMap(List<Token> tokens) {
		final int[] offsets = new int[tokens.size() + 1];
		for (int i = 0; i < tokens.size(); i++) {
			offsets[i] = tokens.get(i).getStartIndex();
		}
		if (tokens.isEmpty()) {
			offsets[0] = 0;
		} else {
			offsets[tokens.size()] =  tokens.get(tokens.size() - 1).getStopIndex() + 1;
		}
		return offsets;
	}
	
	private JSNode getParent() {
		if (parents.isEmpty()) {
			return script;
		} else {
			return parents.peek();
		}
	}
	
	private SymbolTable getScope() {
		if (scopes.isEmpty()) {
			return scope;
		} else {
			return scopes.peek();
		}
	}
	
	private <T extends JSNode> T popParents(Class<? extends T> nodeType, ParserRuleContext context) {
		return checkedPop(nodeType, context, parents);
	}
	
	private <T extends JSNode> T popChildren(Class<? extends T> nodeType, ParserRuleContext context) {
		return checkedPop(nodeType, context, children);
	}

	private <T extends JSNode> T checkedPop(Class<? extends T> nodeType,
			ParserRuleContext context, Stack<JSNode> stack) {
		if (!stack.isEmpty()) {
			if (nodeType.isInstance(stack.peek())) {
				return nodeType.cast(stack.pop());
			}

			reporter.setFormattedMessage(
					JavaScriptParserProblems.INTERNAL_ERROR, "Cannot transform node: " + context.getStart().getText());
			reporter.setSeverity(ProblemSeverity.ERROR);
			reporter.setRange(getTokenOffset(context.getStart().getTokenIndex()),
					getTokenOffset(context.getStop().getTokenIndex()));
			reporter.report();
		}
		else {
			reporter.setFormattedMessage(
					JavaScriptParserProblems.INTERNAL_ERROR, "Cannot transform node (empty stack): " + context.getStart().getText());
			reporter.setSeverity(ProblemSeverity.ERROR);
			reporter.setRange(getTokenOffset(context.getStart().getTokenIndex()),
					getTokenOffset(context.getStop().getTokenIndex()));
			reporter.report();
		}
		return null;
	}
	
	private void locateDocumentation(final Documentable node, Token t) {
		int tokenIndex = t.getTokenIndex();
		while (tokenIndex > 0) {
			--tokenIndex;
			final Token token = tokens.get(tokenIndex);
			if (token.getType() == JSParser.WhiteSpaces
					|| token.getType() == JSParser.LineTerminator) {
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
	
	private void validateLabel(Label label) {
		if (reporter == null)
			return;
		if (!getScope().hasLabel(label.getText())) {
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
	
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}
	
	public ASTNode transform(ParseTree root) {
		if (root == null)
			return null;
		scope = null;
		return JSNodeCreator.create((ParserRuleContext) root, null);
	}
	
	public Script transformScript(ProgramContext root) {
		if (root == null)
			return new Script();
		script = new Script();
		scope = new SymbolTable(script);
		addComments();
		
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(this, root);
		
		script.setStart(0);
		script.setEnd(tokenOffsets[tokenOffsets.length - 1]);
		
		for (NodeTransformer transformer : transformers) {
			if (transformer instanceof NodeTransformerExtension) {
				((NodeTransformerExtension) transformer).postConstruct(script);
			}
		}
		return script;
	}

	private void addComments() {
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
	
	private Keyword createKeyword(ASTNode node, Token token, String text) {
		assert text.equals(token.getText());
		assert text.equals(Keywords.fromToken(token.getType()));
		final Keyword keyword = new Keyword(text);
		setRangeByToken(keyword, token.getTokenIndex());
		return keyword;
	}
	
	private void setRangeByToken(ASTNode node, int tokenIndex) {
		node.setStart(getTokenOffset(tokenIndex));
		node.setEnd(getTokenOffset(tokenIndex + 1));
	}
	
	private void setRange(ASTNode node, ParserRuleContext treeNode) {
		node.setStart(getTokenOffset(treeNode.getStart().getTokenIndex()));
		setEndByTokenIndex(node, treeNode.getStop().getTokenIndex());
	}

	private void setEndByTokenIndex(ASTNode node, int stopIndex) {
		while (stopIndex >= 0 && isHidden(tokens.get(stopIndex))) {
			--stopIndex;
		}
		node.setEnd(getTokenOffset(stopIndex + 1));
	}

	private int getTokenOffset(int tokenIndex) {
		try {
			return tokenOffsets[tokenIndex];
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}

	private static boolean isHidden(Token token) {
		return token.getType() == JSParser.LineTerminator
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
	
	@Override
	public void enterStatement(StatementContext ctx) {
		if (!JSNodeCreator.skipCreate(ctx)) {
			parents.push(JSNodeCreator.create(ctx, getParent()));
			if (getParent() instanceof AbstractForStatement) {
				blockScopes.push(new SymbolTable((AbstractForStatement)getParent()));
			}
		}
	}

	@Override
	public void exitStatement(StatementContext ctx) throws AssertionFailedException {
		if (JSNodeCreator.skipCreate(ctx)) return;
		if (getParent() instanceof AbstractForStatement) {
			blockScopes.pop();
		}
		addStatement(ctx, parents.pop());
	}

	private void addStatement(StatementContext ctx, JSNode expression) {
		Statement statement = transformStatementNode(ctx, expression);
		if (statement == null) return;
		if (expression.getParent() == script) {
			script.addStatement(statement);
		}
		else
		{
			children.push(statement);
		}
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if (ctx instanceof SingleExpressionContext) {
			if (JSNodeCreator.skipCreate(ctx)) return;
			parents.push(JSNodeCreator.create(ctx, getParent()));
		}
	}
	
	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		if (ctx.exception != null && !parents.isEmpty() && parents.peek() instanceof ErrorExpression) {
			ErrorExpression error = popParents(ErrorExpression.class, ctx);
			error.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
			if (ctx.getStop() != null) error.setEnd(getTokenOffset(ctx.getStop().getTokenIndex()));
			if (ctx instanceof StatementContext) {
				addStatement((StatementContext)ctx, error);
			}
			else {
				children.push(error);
			}
		}
		else {
		if (ctx instanceof SingleExpressionContext) {
			if (!JSNodeCreator.skipCreate(ctx)) {
				children.push(parents.pop());
			}
		}
		}
	}

	@Override
	public void enterExpressionSequence(ExpressionSequenceContext ctx) {
		if (ctx.Comma().isEmpty()) return;
		parents.push(new CommaExpression(getParent()));
	}

	@Override
	public void exitExpressionSequence(ExpressionSequenceContext ctx) {
		if (ctx.Comma().isEmpty()) return;
		CommaExpression expression = popParents(CommaExpression.class, ctx);
		List<SingleExpressionContext> ruleContexts = ctx.getRuleContexts(SingleExpressionContext.class);
		List<ASTNode> items = new ArrayList<>();
		IntList commas = new IntList();
		int i = 0;
		while ( i < ruleContexts.size() ) {
			items.add(children.pop());
			if (i+1 < ruleContexts.size()) {
				commas.add(getTokenOffset(ctx.Comma(i).getSymbol().getTokenIndex()));
			}
			i++;
		}
		Collections.reverse(items);
		expression.setItems(items);
		expression.setCommas(commas);
		expression.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		expression.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
		children.push(expression);
	}
	
	@Override
	public void exitExpressionStatement(ExpressionStatementContext ctx) {
		addStatement((StatementContext) ctx.getParent(), children.pop());
	}

	@Override
	public void enterLiteral(LiteralContext ctx) {
		Literal literal = (Literal) JSNodeCreator.create(ctx, getParent());
		literal.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		if (literal.getText() != null) {
			literal.setEnd(literal.sourceStart() + literal.getText().length());
		}
		children.push(literal);
	}

	@Override
	public void enterVariableStatement(VariableStatementContext ctx) {
		if (ctx.variableDeclarationList().varModifier().Var() != null) {
			setupVariableStatement(ctx);
		}
		if (ctx.variableDeclarationList().varModifier().Const() != null) {
			setupConstStatement(ctx);
		}
		if (ctx.variableDeclarationList().varModifier().let_() != null) {
			setupLetStatement(ctx);
		}
	}
	
	private void setupLetStatement(ParserRuleContext ctx) {
		LetStatement statement = (LetStatement)getParent();
		locateDocumentation(statement, ctx.getStart());
		statement.setLetKeyword(createKeyword(statement, ctx.getStart(), Keywords.LET));
		setRange(statement, ctx);
	}

	public void setupVariableStatement(ParserRuleContext ctx) {
		VariableStatement statement = (VariableStatement)getParent();
		locateDocumentation(statement, ctx.getStart());
		statement.setVarKeyword(createKeyword(statement, ctx.getStart(), Keywords.VAR));
		setRange(statement, ctx);
	}
	
	public void setupConstStatement(ParserRuleContext ctx) {
		ConstStatement statement = (ConstStatement)getParent();
		locateDocumentation(statement, ctx.getStart());
		statement.setConstKeyword(createKeyword(statement, ctx.getStart(), Keywords.CONST));
		if (ctx.getStop().getType() == JSParser.SemiColon) {
			statement.setSemicolonPosition(getTokenOffset(ctx.getStop().getTokenIndex()));
		}
		setRange(statement, ctx);
	}

	@Override
	public void enterVariableDeclarationList(
			VariableDeclarationListContext ctx) {
		if (ctx.varModifier().Var() != null && !getParent().getClass().equals(VariableStatement.class)) {
			VariableStatement statement = new VariableStatement(getParent());
			parents.push(statement);
			setupVariableStatement(ctx);
		}
		if (ctx.varModifier().Const() != null && !getParent().getClass().equals(ConstStatement.class)) {
			ConstStatement statement = new ConstStatement(getParent());
			parents.push(statement);
			setupConstStatement(ctx);
		}
		if (ctx.varModifier().let_() != null && !getParent().getClass().equals(LetStatement.class)) {
			LetStatement statement = new LetStatement(getParent());
			parents.push(statement);
			setupLetStatement(ctx);
		}
	}

	@Override
	public void exitVariableDeclarationList(VariableDeclarationListContext ctx) {
		IVariableStatement statement = (IVariableStatement)getParent();
		List<VariableDeclaration> decl = new ArrayList<>();
		for (int i = 0; i < ctx.variableDeclaration().size(); i++ ) {
			decl.add(popChildren(VariableDeclaration.class, ctx));
		}
		Collections.reverse(decl);
		for (int i = 0; i < ctx.variableDeclaration().size(); i++ ) {
			statement.addVariable(decl.get(i));
			if (i + 1 < ctx.variableDeclaration().size()) {
				decl.get(i).setCommaPosition(getTokenOffset(ctx.Comma(i).getSymbol().getTokenIndex()));
			}
		}
		if (ctx.getParent() instanceof VariableStatementContext) return;
		children.push(parents.pop());
	}

	@Override
	public void enterVariableDeclaration(VariableDeclarationContext ctx) {
		VariableDeclaration declaration = new VariableDeclaration((IVariableStatement) getParent());
		parents.push(declaration);
	}	
	
	@Override
	public void exitVariableDeclaration(VariableDeclarationContext ctx) {
		VariableDeclaration declaration = popParents(VariableDeclaration.class, ctx);
		if (!children.isEmpty() && children.peek() instanceof Expression && ctx.Assign() != null) {
			declaration.setAssignPosition(getTokenOffset(ctx.Assign().getSymbol().getTokenIndex()));
			declaration.setInitializer(popChildren(Expression.class, ctx));
		}
		if (children.peek() instanceof Identifier) {
			Identifier identifier = popChildren(Identifier.class, ctx);
			declaration.setIdentifier(identifier);
		}

		SymbolKind kind = getSymbolKind(ctx);
		final SymbolKind replaced = addVariableToScope(
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
		
		setRange(declaration, ctx);
		children.add(declaration);
	}

	private SymbolKind addVariableToScope(String variableName, SymbolKind kind,
			VariableDeclaration declaration) {
		SymbolKind added = null;
		SymbolTable blockScope = !blockScopes.isEmpty() ? blockScopes.peek() : null;
		if ((kind == SymbolKind.LET ||  kind == SymbolKind.CONST) && blockScope != null) {
			return blockScope.add(variableName, kind, declaration);
		}
		added = getScope().add(variableName, kind, declaration);
		//if (blockScope != null) blockScope.add(variableName, kind, declaration);
		return added;
	}

	private SymbolKind getSymbolKind(VariableDeclarationContext ctx) {
		if (ctx.getParent() instanceof VariableDeclarationListContext) {
			VarModifierContext varModifier = ((VariableDeclarationListContext) ctx.getParent()).varModifier();
			if (varModifier.Var() != null) return SymbolKind.VAR;
			if (varModifier.Const() != null) return SymbolKind.CONST;
			if (varModifier.let_() != null) return SymbolKind.LET;
		}
		return null;
	}

	@Override
	public void enterIdentifier(IdentifierContext ctx) {
		if (ctx.getParent() instanceof IdentifierNameContext) return;
		int type = ctx.getStart().getType();
		Assert.isTrue(type == JSParser.Identifier || type == JSParser.Async ||
				type == JSParser.NonStrictLet || type == JSParser.From || type == JSParser.As
				|| type == JSParser.Static || type == JSParser.Implements || type == JSParser.Interface
				|| type == JSParser.Package || type == JSParser.Private || type == JSParser.Public
				|| type == JSParser.Protected || type == JSParser.Yield || type == JSParser.Of);
		createIdentifier(ctx.getStart(), ctx.getText());
	}
	
	@Override
	public void exitAdditiveExpression(AdditiveExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}
	
	@Override
	public void exitInExpression(InExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	public void setupBinaryOperation(SingleExpressionContext ctx) {
		BinaryOperation operation = (BinaryOperation) getParent();		
		
		operation.setRightExpression(popChildren(Expression.class, ctx));
		if (!children.isEmpty()) {
			operation.setLeftExpression(popChildren(Expression.class, ctx));	
		}
		
//		operation.setOperationPosition(getTokenOffset(operation.getOperation(), ctx.getStart().getTokenIndex(),
//				ctx.getStop().getTokenIndex()));
		operation.setOperationPosition(getTokenOffset(operation.getOperation(), getRealTokenStopIndex(ctx.getRuleContext().getChild(0)) + 1,
				ctx.getStop().getTokenIndex()));

		Assert.isTrue(operation.getOperationPosition() >= operation
				.getLeftExpression().sourceEnd());
		Assert.isTrue(operation.getOperationPosition() + operation.getOperationText().length() <=
				operation.getRightExpression().sourceStart());

		operation.setStart(operation.getLeftExpression().sourceStart());
		operation.setEnd(operation.getRightExpression().sourceEnd());
	}

	private int getRealTokenStopIndex(ParseTree child) {
		if (child instanceof TerminalNode) {
			return ((TerminalNode) child).getSymbol().getTokenIndex();
		}
		if (child instanceof RuleContext) {
			RuleContext context = (RuleContext) child;
			return getRealTokenStopIndex(context.getChild(context.getChildCount()-1));
		}
		return 0;
	}

	@Override
	public void exitBitXOrExpression(BitXOrExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void exitBitShiftExpression(BitShiftExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void exitBitAndExpression(BitAndExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void exitBitOrExpression(BitOrExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void exitMultiplicativeExpression(MultiplicativeExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}


	@Override
	public void exitAssignmentExpression(AssignmentExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void enterAssignmentOperator(AssignmentOperatorContext ctx) {
		if (getParent() instanceof BinaryOperation) {
			((BinaryOperation)getParent()).setOperation(ctx.getStart().getType());
		}
		else
		{
			//TODO report error?
		}
	}

	@Override
	public void exitAssignmentOperatorExpression(AssignmentOperatorExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void exitRelationalExpression(RelationalExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void exitLogicalAndExpression(LogicalAndExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void exitLogicalOrExpression(LogicalOrExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void exitEqualityExpression(EqualityExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}
	
	@Override
	public void exitInstanceofExpression(InstanceofExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}

	@Override
	public void exitIfStatement(IfStatementContext ctx) {
		IfStatement ifStatement = (IfStatement) getParent();
		ifStatement.setIfKeyword(createKeyword(ifStatement, ctx.getStart(), Keywords.IF));		
		ifStatement.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		setEndByTokenIndex(ifStatement, ctx.getStop().getTokenIndex());

		Statement _else = ctx.Else() != null ? popChildren(Statement.class, ctx) : null;
		Statement then = popChildren(Statement.class, ctx);
		if (children.peek() instanceof Expression) {
			ifStatement.setCondition(popChildren(Expression.class, ctx));
		}
		
		if (ctx.OpenParen().getSymbol().getStartIndex() > 0) {
			ifStatement.setLP(getTokenOffset(JSParser.OpenParen, 
					ctx.getStart().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		}
		if (ctx.CloseParen() != null) {
			ifStatement.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));
		}
		if (ctx.statement() != null) {
			ifStatement.setThenStatement(then);
		}

		if (ctx.Else() != null) {
			Keyword elseKeyword = createKeyword(ifStatement, ctx.Else().getSymbol(), Keywords.ELSE);
			ifStatement.setElseKeyword(elseKeyword);
			ifStatement.setElseStatement(_else);
		}
	}

	@Override
	public void exitStatementList(StatementListContext ctx) {
		List<Statement> result = new ArrayList<>();
		for (int i = 0; i < ctx.statement().size(); i++) {
			result.add(transformStatementNode(ctx.statement(i), children.pop()));
		}
		Collections.reverse(result);
		lists.push(result);
	}

	@Override
	public void exitBlock(BlockContext ctx) {
		StatementBlock block = (StatementBlock) getParent();
		List<Statement> statementList = lists.isEmpty() ? new ArrayList<>() : lists.pop();
		for (int i = 0; i < statementList.size(); i++) {
			block.getStatements().add(statementList.get(i));
		}
		block.setLC(getTokenOffset(JSParser.OpenBrace, ctx.getStart().getTokenIndex(),
				ctx.getStop().getTokenIndex()));

		block.setRC(getTokenOffset(JSParser.CloseBrace, ctx.getStop().getTokenIndex(),
				ctx.getStop().getTokenIndex()));

		if (block.getLC() > -1) {
			block.setStart(block.getLC());
		} else if (!block.getStatements().isEmpty()) {
			block.setStart(block.getStatements().get(0).sourceStart());
		} else {
			block.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		}
		if (block.getRC() > -1) {
			block.setEnd(block.getRC() + 1);
		} else if (!block.getStatements().isEmpty()) {
			block.setEnd(block.getStatements().get(block.getStatements().size() - 1).sourceStart());
		} else {
			block.setEnd(getTokenOffset(ctx.getStop().getTokenIndex()));
		}
		
		if (ctx.getParent() instanceof TryStatementContext || ctx.getParent() instanceof CatchProductionContext || ctx.getParent() instanceof FinallyProductionContext) {
			children.add(parents.pop());
		}
		blockScopes.pop();
	}	
		
	@Override
	public void exitWhileStatement(WhileStatementContext ctx) {
		WhileStatement statement = (WhileStatement) getParent();
		statement.setWhileKeyword(createKeyword(statement, ctx.getStart(),  Keywords.WHILE));
		statement.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.getStart().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		statement.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));

		if (ctx.statement() != null) statement.setBody(popChildren(Statement.class, ctx));
		statement.setCondition(popChildren(Expression.class, ctx));
		statement.setStart(statement.getWhileKeyword().sourceStart());
		setEndByTokenIndex(statement, ctx.getStop().getTokenIndex());
	}
	
	@Override
	public void exitDoStatement(DoStatementContext ctx) {
		DoWhileStatement statement = (DoWhileStatement) getParent();
		Expression condition = popChildren(Expression.class, ctx);
		Statement body = popChildren(Statement.class, ctx);
		
		statement.setDoKeyword(createKeyword(statement, ctx.getStart(),  Keywords.DO));
		if (ctx.statement() != null) statement.setBody(body);
		
		statement.setWhileKeyword(createKeyword(statement, ctx.While().getSymbol(), Keywords.WHILE));
		statement.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.While().getSymbol().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		statement.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));

		statement.setCondition(condition);
		statement.setSemicolonPosition(getTokenOffset(ctx.getStop().getTokenIndex()));

		statement.setStart(statement.getDoKeyword().sourceStart());
		setEndByTokenIndex(statement, ctx.getStop().getTokenIndex());
	}

	@Override
	public void exitForStatement(ForStatementContext ctx) {
		ForStatement statement = (ForStatement) getParent();
		Statement body = popChildren(Statement.class, ctx);
		Expression step = null, condition = null, initial = null;
		if (ctx.expressionSequence().size() == 3 || ctx.expressionSequence().size() == 2 
			&& ctx.variableDeclarationList() != null) {
			step =  popChildren(Expression.class, ctx);
			condition =  popChildren(Expression.class, ctx);
			initial = popChildren(Expression.class, ctx);
		}
		else if (ctx.expressionSequence().size() == 0 && ctx.variableDeclarationList() == null) {
			step = new EmptyExpression(statement);
			condition = new EmptyExpression(statement);
			initial = new EmptyExpression(statement);
		}
		else {
			List<ParseTree> _children = ctx.children;
			int index = _children.indexOf(ctx.OpenParen()) + 1;
			if (_children.size() > index && _children.get(index) == ctx.SemiColon(0)) {
				initial = new EmptyExpression(statement);
			}
			index = _children.indexOf(ctx.SemiColon(0)) + 1;
			if (_children.size() > index && _children.get(index) == ctx.SemiColon(1)) {
				condition = new EmptyExpression(statement);
			}
			index = _children.indexOf(ctx.SemiColon(1)) + 1;
			if (_children.size() > index && _children.get(index) == ctx.CloseParen()) {
				step = new EmptyExpression(statement);
			}
			
			if (step == null) step =  popChildren(Expression.class, ctx);
			if (condition == null) condition =  popChildren(Expression.class, ctx);
			if (initial == null) initial = popChildren(Expression.class, ctx);
			
		}
		
		statement.setForKeyword(createKeyword(statement, ctx.getStart(),  Keywords.FOR));
		statement.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.For().getSymbol().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		
		statement.setInitial(initial);
		statement.setInitialSemicolonPosition(getTokenOffset(ctx.SemiColon(0).getSymbol().getTokenIndex()));
		statement.setCondition(condition);
		statement.setConditionalSemicolonPosition(getTokenOffset(ctx.SemiColon(1).getSymbol().getTokenIndex()));
		statement.setStep(step);
		statement.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));

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

		if (ctx.statement().getChildCount() >= 1) {
			statement.setBody(body);
		}

		statement.setStart(statement.getForKeyword().sourceStart());
		setEndByTokenIndex(statement, ctx.getStop().getTokenIndex());
	}	

	@Override
	public void exitForInStatement(ForInStatementContext ctx) {
		ForInStatement statement = (ForInStatement)getParent();
		Statement body = popChildren(Statement.class, ctx);
		Expression iterator = popChildren(Expression.class, ctx);
		Expression item = popChildren(Expression.class, ctx);
		
		statement.setForKeyword(createKeyword(statement, ctx.getStart(),  Keywords.FOR));
		statement.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.For().getSymbol().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		
		statement.setItem(item);

		Keyword inKeyword = createKeyword(statement, ctx.In().getSymbol(), Keywords.IN);

//		int iteratorStart = node.getChild(0).getChild(1).getTokenStartIndex();
//
//		if (iteratorStart == -1
//				&& node.getChild(0).getChild(1).getType() == JSParser.EXPR
//				&& node.getChild(0).getChild(1).getChildCount() > 0)
//			iteratorStart = node.getChild(0).getChild(1).getChild(0)
//					.getTokenStartIndex();

		statement.setInKeyword(inKeyword);
		statement.setIterator(iterator);
		statement.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));

		if (ctx.getChildCount() >= 1)
			statement.setBody(body);

		statement.setStart(statement.getForKeyword().sourceStart());
		setEndByTokenIndex(statement, ctx.getStop().getTokenIndex());
	}

	@Override
	public void enterFunctionDeclaration(FunctionDeclarationContext ctx) {
		SymbolTable symbolTable = new SymbolTable((FunctionStatement)getParent());
		scopes.push(symbolTable);
		blockScopes.push(symbolTable);
	}

	@Override
	public void enterFunctionBody(FunctionBodyContext ctx) {
		parents.push(new StatementBlock(getParent()));
	}
	
	@Override
	public void exitSourceElements(SourceElementsContext ctx) {
		if (ctx.getParent() instanceof ProgramContext) return;
		List<Statement> result = new ArrayList<>();
		for (int i = 0; i < ctx.sourceElement().size(); i++) {
			result.add(transformStatementNode(ctx.sourceElement(i).statement(), children.pop()));
		}
		Collections.reverse(result);
		lists.push(result);
	}

	@Override
	public void exitFunctionBody(FunctionBodyContext ctx) {
		StatementBlock block = (StatementBlock) getParent();
		List<Statement> statementList = !lists.isEmpty() ? lists.pop() : new ArrayList<>();
		for (int i = 0; i < statementList.size(); i++) {
			block.getStatements().add(statementList.get(i));
		}
		
		block.setLC(getTokenOffset(JSParser.OpenBrace, ctx.getStart().getTokenIndex(),
				ctx.getStop().getTokenIndex()));

		block.setRC(getTokenOffset(JSParser.CloseBrace, ctx.getStop().getTokenIndex(),
				ctx.getStop().getTokenIndex()));

		if (block.getLC() > -1) {
			block.setStart(block.getLC());
		} else if (!block.getStatements().isEmpty()) {
			block.setStart(block.getStatements().get(0).sourceStart());
		} else {
			block.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		}
		if (block.getRC() > -1) {
			block.setEnd(block.getRC() + 1);
		} else if (!block.getStatements().isEmpty()) {
			block.setEnd(block.getStatements().get(block.getStatements().size() - 1).sourceStart());
		} else {
			block.setEnd(getTokenOffset(ctx.getStop().getTokenIndex()));
		}
		children.push(parents.pop());
	}

	@Override
	public void exitAnonymousFunctionDecl(AnonymousFunctionDeclContext ctx) {
		FunctionStatement fn = (FunctionStatement) getParent();
		fn.setLP(getTokenOffset(ctx.OpenParen().getSymbol().getTokenIndex()));
		fn.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));
		setupFunction(ctx.Function_(), ctx.formalParameterList(), ctx.identifier(), ctx);
	}
	
	@Override
	public void enterAnonymousFunctionDecl(AnonymousFunctionDeclContext ctx) {
		SymbolTable symbolTable = new SymbolTable((FunctionStatement)getParent());
		scopes.push(symbolTable);
		blockScopes.push(symbolTable);
	}

	@Override
	public void exitFunctionDeclaration(FunctionDeclarationContext ctx) {
		FunctionStatement fn = (FunctionStatement) getParent();
		fn.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.identifier().getStop().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		fn.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));
		setupFunction(ctx.Function_(), ctx.formalParameterList(), ctx.identifier(), ctx);
	}
	
	private void setupFunction(TerminalNode function_, FormalParameterListContext parameterList, IdentifierContext id, ParserRuleContext ctx) {		
		FunctionStatement fn = (FunctionStatement) getParent();
		if (function_ != null) {
			fn.setFunctionKeyword(createKeyword(fn, function_.getSymbol(), Keywords.FUNCTION));
			locateDocumentation(fn, function_.getSymbol());
		}
		
		StatementBlock body = popChildren(StatementBlock.class, ctx);
		List<Argument> arguments = new ArrayList<>();
		if (parameterList != null) {
			List<FormalParameterArgContext> args = parameterList.formalParameterArg();
			for (FormalParameterArgContext arg : args) {
				if (children.peek() instanceof Argument) {
					arguments.add(popChildren(Argument.class, ctx));
				}
			}
		}
		Collections.reverse(arguments);
		final SymbolTable functionScope = blockScopes.pop(); //blockScope/scope should be the same in this case
		scopes.pop();
		for (int i = 0, childCount = arguments.size(); i < childCount; ++i) {
			Argument argument = arguments.get(i);
			if (i + 1 < childCount) {
				argument.setCommaPosition(getTokenOffset(parameterList.Comma(i).getSymbol().getTokenIndex()));
			}
			fn.addArgument(argument);
			validateParameter(functionScope, argument);
		}
		
		if (id != null) {
			Identifier identifier = popChildren(Identifier.class, ctx);
			fn.setName(identifier);
			final SymbolKind replaced = getScope().add(identifier.getName(),
					SymbolKind.FUNCTION, fn);
			if (replaced != null && reporter != null) {
				if (replaced == SymbolKind.FUNCTION) {
					reporter.setFormattedMessage(
							JavaScriptParserProblems.DUPLICATE_FUNCTION,
							identifier.getName());
				} else {
					reporter.setFormattedMessage(
							JavaScriptParserProblems.FUNCTION_DUPLICATES_OTHER,
							identifier.getName(), replaced.verboseName());
				}
				reporter.setRange(identifier.sourceStart(), identifier.sourceEnd());
				reporter.report();
			}
		}
		fn.setBody(body);
		fn.setStart(fn.getFunctionKeyword().sourceStart());
		fn.setEnd(fn.getBody().sourceEnd());
	}
	
	private Statement transformStatementNode(ParserRuleContext ctx, JSNode expression) {
		if (expression == null) return null;
		if (expression instanceof Statement)
			return (Statement) expression;
		else {
			VoidExpression voidExpression = new VoidExpression(getParent() == null? script : getParent());
			voidExpression.setExpression((Expression) expression);

			if (ctx.getStop() != null && ctx.getStop().getTokenIndex() >= 0
					&& ctx.getStop().getTokenIndex() < tokens.size()) {
				final Token token = ctx.getStop();
				if (token.getType() == JSParser.SemiColon) {
					voidExpression.setSemicolonPosition(getTokenOffset(token.getTokenIndex()));
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
	
	@Override
	public void exitFormalParameterArg(FormalParameterArgContext ctx) {
		Argument arg = new Argument(getParent());
		arg.setIdentifier(popChildren(Identifier.class, ctx));
		//TODO impl set initializer (es6)
		arg.setStart(ctx.getStart().getTokenIndex());
		arg.setEnd(ctx.getStop().getTokenIndex());
		children.add(arg);
	}

	@Override
	public void exitPostIncrementExpression(PostIncrementExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.PlusPlus().getSymbol());
	}

	@Override
	public void exitPostDecreaseExpression(PostDecreaseExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.MinusMinus().getSymbol());
	}

	@Override
	public void exitPreIncrementExpression(PreIncrementExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.PlusPlus().getSymbol());
	}
	
	@Override
	public void exitPreDecreaseExpression(PreDecreaseExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.MinusMinus().getSymbol());
	}
	
	@Override
	public void exitBitNotExpression(BitNotExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.BitNot().getSymbol());
	}

	@Override
	public void exitNotExpression(NotExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.Not().getSymbol());
	}
	
	@Override
	public void exitUnaryMinusExpression(UnaryMinusExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.Minus().getSymbol());
	}
	
	@Override
	public void exitUnaryPlusExpression(UnaryPlusExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.Plus().getSymbol());
	}

	@Override
	public void exitDeleteExpression(DeleteExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.Delete().getSymbol());
	}

	@Override
	public void exitTypeofExpression(TypeofExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.Typeof().getSymbol());
	}

	@Override
	public void exitVoidExpression(VoidExpressionContext ctx) {
		setupUnaryOperation(ctx, (UnaryOperation) getParent(), ctx.Void().getSymbol());
	}

	public void setupUnaryOperation(SingleExpressionContext ctx,
			UnaryOperation operation, Token symbol) {
		operation.setOperationPosition(getTokenOffset(symbol.getTokenIndex()));
		assert operation.getOperationPosition() > -1;

		operation.setExpression(popChildren(Expression.class, ctx));
		setRange(operation, ctx);
	}

	@Override
	public void enterLabelledStatement(LabelledStatementContext ctx) {
		LabelledStatement statement = (LabelledStatement)getParent();

		Label label = new Label(statement);
		label.setText(intern(ctx.identifier().getText()));
		setRangeByToken(label, ctx.getStart().getTokenIndex());
		statement.setLabel(label);

		statement.setColonPosition(getTokenOffset(ctx.Colon().getSymbol().getTokenIndex()));

		if (!getScope().addLabel(statement) && reporter != null) {
			reporter.setMessage(JavaScriptParserProblems.DUPLICATE_LABEL);
			reporter.setSeverity(ProblemSeverity.ERROR);
			reporter.setRange(label.sourceStart(), label.sourceEnd());
			reporter.report();
		}
	}

	@Override
	public void exitLabelledStatement(LabelledStatementContext ctx) {
		LabelledStatement statement = (LabelledStatement)getParent();
		if (ctx.statement() != null) {
			statement.setStatement(popChildren(Statement.class, ctx));
		}
		children.pop();//remove the label from the stack, was processed in enterLabelledStatement
		statement.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		statement.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
	}

	@Override
	public void exitContinueStatement(ContinueStatementContext ctx) {
		ContinueStatement statement = (ContinueStatement)getParent();
		statement.setContinueKeyword(createKeyword(statement, ctx.getStart(), Keywords.CONTINUE));

		if (ctx.identifier() != null) {
			Label label = new Label(statement);
			Identifier labelNode = popChildren(Identifier.class, ctx);
			label.setText(intern(labelNode.getName()));
			setRangeByToken(label, ctx.identifier().getStart().getTokenIndex());
			statement.setLabel(label);
			validateLabel(label);
		}

		statement.setSemicolonPosition(getTokenOffset(ctx.getStop().getTokenIndex()));
		setRange(statement, ctx);
		if (statement.getLabel() == null) {
			validateParent(JavaScriptParserProblems.BAD_CONTINUE, statement,
					LoopStatement.class);
		}
	}

	@Override
	public void exitReturnStatement(ReturnStatementContext ctx) {
		ReturnStatement returnStatement = (ReturnStatement)getParent();

		returnStatement.setReturnKeyword(createKeyword(returnStatement, ctx.getStart(), Keywords.RETURN));

		if (ctx.expressionSequence() != null) {
			returnStatement.setValue(popChildren(Expression.class, ctx));
		}

		Token token = ctx.getStop();
		if (token.getType() == JSParser.SemiColon) {
			returnStatement.setSemicolonPosition(getTokenOffset(token.getTokenIndex()));

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
	}

	@Override
	public void exitBreakStatement(BreakStatementContext ctx) {
		BreakStatement statement = (BreakStatement)getParent();
		statement.setBreakKeyword(createKeyword(statement, ctx.getStart(), Keywords.BREAK));

		if (ctx.identifier() != null) {
			Label label = new Label(statement);
			Identifier labelNode = popChildren(Identifier.class, ctx);
			label.setText(intern(labelNode.getName()));
			setRangeByToken(label, ctx.identifier().getStart().getTokenIndex());
			statement.setLabel(label);
			validateLabel(label);
		}

		statement.setSemicolonPosition(getTokenOffset(ctx.getStop().getTokenIndex()));
		setRange(statement, ctx);
		if (statement.getLabel() == null) {
			validateParent(JavaScriptParserProblems.BAD_BREAK, statement,
					LoopStatement.class, SwitchStatement.class);
		}	
	}

	@Override
	public void exitThrowStatement(ThrowStatementContext ctx) {
		ThrowStatement statement = (ThrowStatement)getParent();
		statement.setThrowKeyword(createKeyword(statement, ctx.getStart(), Keywords.THROW));

		if (ctx.expressionSequence() != null) {
			statement.setException(popChildren(Expression.class, ctx));
		}

		if (ctx.eos().SemiColon() != null) {
			statement.setSemicolonPosition(getTokenOffset(ctx.eos().SemiColon().getSymbol().getTokenIndex()));
		}
		setRange(statement, ctx);
	}

	@Override
	public void exitNewExpression(NewExpressionContext ctx) {
		Expression callExpression = ctx.singleExpression()	!= null ? transformCallExpression(ctx.singleExpression(), ctx.arguments()) : null;
		
		if (callExpression == null && ctx.identifier() != null) { 
			callExpression = setupCallExpression(ctx.arguments(), popParents(CallExpression.class, ctx), ctx);
		}
		else {
			parents.pop();
		}
		NewExpression expression = (NewExpression)getParent();
		expression.setNewKeyword(createKeyword(expression, ctx.getStart(), Keywords.NEW));
		if (callExpression	!= null) {
			expression.setObjectClass(callExpression);
		} else {
			final ErrorExpression error = new ErrorExpression(expression,
					Util.EMPTY_STRING);
			final int pos = expression.getNewKeyword().sourceEnd();
			error.setStart(pos);
			error.setEnd(pos);
			expression.setObjectClass(error);
		}
		setRange(expression, ctx);
	}

	@Override
	public void exitArgumentsExpression(ArgumentsExpressionContext ctx) {
		transformCallExpression(ctx.singleExpression(), ctx.arguments());
	}
	
	@Override
	public void enterArguments(ArgumentsContext ctx) {
		if (!getParent().getClass().equals(CallExpression.class)) {
			parents.push(new CallExpression(getParent()));
		}
	}

	private Expression transformCallExpression(SingleExpressionContext ctx, ArgumentsContext args) {
		CallExpression call = (CallExpression)getParent();

		Assert.isNotNull(ctx);
		Assert.isNotNull(args);

		return setupCallExpression(args, call, ctx);
	}

	private Expression setupCallExpression(ArgumentsContext args,
			CallExpression call, ParserRuleContext ctx) {
		List<Expression> _args = new ArrayList<>();
		for(int i = 0; i < args.argument().size(); i++) {
			_args.add(popChildren(Expression.class, ctx));
		}
		Collections.reverse(_args);
		call.setExpression((Expression) children.pop());
		IntList commas = new IntList();
		for (int i = 0; i < _args.size(); i++) {
			if (args.Comma(i) != null) {
				commas.add(getTokenOffset(args.Comma(i).getSymbol().getTokenIndex()));
			}
			call.addArgument(_args.get(i));
		}
		call.setCommas(commas);
		call.setLP(getTokenOffset(args.OpenParen().getSymbol().getTokenIndex()));
		call.setRP(getTokenOffset(args.CloseParen().getSymbol().getTokenIndex()));

		call.setStart(call.getExpression().sourceStart());
		if (call.getRP() > -1) {
			call.setEnd(call.getRP() + 1);
		} else {
			call.setEnd(call.getExpression().sourceEnd());
		}
		return call;
	}

	@Override
	public void enterBlock(BlockContext ctx) {
		if (getParent() instanceof StatementBlock) {
			//created via factory
			blockScopes.push(new SymbolTable((StatementBlock)getParent()));
			return;
		}
		parents.push(new StatementBlock(getParent()));
		blockScopes.push(new SymbolTable((StatementBlock)getParent()));
	}

	@Override
	public void exitTryStatement(TryStatementContext ctx) {
		TryStatement statement = (TryStatement)getParent();
		statement.setTryKeyword(createKeyword(statement, ctx.getStart(), Keywords.TRY));

//		boolean sawDefaultCatch = false;
//		for (int i = 1 /* miss body */; i < node.getChildCount(); i++) {
//
//			Tree child = node.getChild(i);
//
//			switch (child.getType()) {
//			case JSParser.CATCH:
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
//			case JSParser.FINALLY:
//				statement.setFinally((FinallyClause) children.pop());
//				break;
//
//			default:
//				throw new UnsupportedOperationException(
//						"CATCH or FINALLY expected");
//			}
//
//		}
		if (children.peek() instanceof StatementBlock) {
			statement.setBody(popChildren(StatementBlock.class, ctx));
		}
		statement.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		statement.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
	}

	@Override
	public void enterCatchProduction(CatchProductionContext ctx) {
		parents.push(new CatchClause(getParent()));
	}
	
	@Override
	public void exitCatchProduction(CatchProductionContext ctx) {
		CatchClause catchClause = popParents(CatchClause.class, ctx);
		catchClause.setCatchKeyword(createKeyword(catchClause, ctx.getStart(), Keywords.CATCH));
		catchClause.setLP(getTokenOffset(ctx.OpenParen().getSymbol().getTokenIndex()));

// TODO this is not supported in the current g4 file, we need to change the rule and regenerate the parser
//		int statementIndex = 1;
//		if (statementIndex < node.getChildCount()
//				&& node.getChild(statementIndex).getType() == JSParser.If) {
//			catchClause.setIfKeyword(createKeyword(
//					node.getChild(statementIndex++), Keywords.IF));
//
//			catchClause.setFilterExpression(transformExpression(
//					node.getChild(statementIndex++), catchClause));
//		}

		catchClause.setRP(getTokenOffset(ctx.getStop().getTokenIndex()));
		if (children.peek() instanceof Statement) {
			catchClause.setStatement(popChildren(Statement.class, ctx));
		}

		catchClause.setException(popChildren(Identifier.class, ctx));
		catchClause.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		catchClause.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));	
		
		if (getParent() instanceof TryStatement) {
			TryStatement parent = (TryStatement) catchClause.getParent();
			parent.getCatches().add(catchClause);
		}
	}
	
	@Override
	public void enterFinallyProduction(FinallyProductionContext ctx) {
		parents.push(new FinallyClause(getParent()));
	}

	@Override
	public void exitFinallyProduction(FinallyProductionContext ctx) {
		FinallyClause finallyClause = popParents(FinallyClause.class, ctx);
		finallyClause.setFinallyKeyword(createKeyword(finallyClause, ctx.getStart(), Keywords.FINALLY));

		if (ctx.block() != null) {
			finallyClause.setStatement(popChildren(Statement.class, ctx));
		}

		finallyClause.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		finallyClause.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
		
		if (getParent() instanceof TryStatement) {
			TryStatement parent = (TryStatement) finallyClause.getParent();
			parent.setFinally(finallyClause);
		}
	}

	@Override
	public void enterYieldStatement(YieldStatementContext ctx) {
		parents.push(new YieldOperator(getParent()));
	}

	@Override
	public void exitYieldStatement(YieldStatementContext ctx) {
		YieldOperator expression = popParents(YieldOperator.class, ctx);
		expression.setYieldKeyword(createKeyword(expression, ctx.getStart(), Keywords.YIELD));
		expression.setExpression(popChildren(Expression.class, ctx));
		expression.setStart(expression.getYieldKeyword().sourceStart());
		expression.setEnd(expression.getExpression().sourceEnd());
		children.push(expression);
	}

	@Override
	public void exitSwitchStatement(SwitchStatementContext ctx) {
		SwitchStatement switchStatement = (SwitchStatement) getParent();
		switchStatement.setSwitchKeyword(createKeyword(switchStatement, ctx.getStart(), Keywords.SWITCH));
		switchStatement.setCondition(popChildren(Expression.class, ctx));
		switchStatement.setLP(getTokenOffset(ctx.OpenParen().getSymbol().getTokenIndex()));
		switchStatement.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));
		switchStatement.setLC(getTokenOffset(ctx.caseBlock().OpenBrace().getSymbol().getTokenIndex()));
		switchStatement.setRC(getTokenOffset(ctx.getStop().getTokenIndex()));
		switchStatement.setStart(switchStatement.sourceStart());
		switchStatement.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
		while(!children.isEmpty() && getParent().equals(children.peek().getParent())) {
			children.pop(); // remove from the children stack the default clauses which are not processed
		}
	}

	@Override
	public void enterCaseClause(CaseClauseContext ctx) {
		parents.push(new CaseClause(getParent()));
	}

	@Override
	public void exitCaseClause(CaseClauseContext ctx) {
		CaseClause caseClause = popParents(CaseClause.class, ctx);
		caseClause.setCaseKeyword(createKeyword(caseClause, ctx.getStart(), Keywords.CASE));
		caseClause.setColonPosition(getTokenOffset(ctx.Colon().getSymbol().getTokenIndex()));
		caseClause.setCondition(popChildren(Expression.class, ctx));
		List<Statement> statements = !lists.isEmpty() ? lists.pop() : new ArrayList<>();
		for (Statement statement : statements) {
			caseClause.getStatements().add(statement);
		}
		((SwitchStatement) getParent()).addCase(caseClause);
		caseClause.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		caseClause.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
	}

	@Override
	public void enterDefaultClause(DefaultClauseContext ctx) {
		parents.push(new DefaultClause(getParent()));
	}

	@Override
	public void exitDefaultClause(DefaultClauseContext ctx) {
		DefaultClause caseClause = popParents(DefaultClause.class, ctx);
		caseClause.setDefaultKeyword(createKeyword(caseClause, ctx.getStart(), Keywords.DEFAULT));
		caseClause.setColonPosition(getTokenOffset(ctx.Colon().getSymbol().getTokenIndex()));
		List<Statement> statements = lists.pop();
		for (Statement statement : statements) {
			caseClause.getStatements().add(statement);
		}
		((SwitchStatement) getParent()).addCase(caseClause);
		caseClause.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		caseClause.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
	}

	@Override
	public void exitEmptyStatement_(EmptyStatement_Context ctx) {
		EmptyStatement statement = (EmptyStatement)getParent();
		statement.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		statement.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
	}

	@Override
	public void exitWithStatement(WithStatementContext ctx) {
		WithStatement statement = (WithStatement)getParent();
		statement.setWithKeyword(createKeyword(statement, ctx.getStart(), Keywords.WITH));
		statement.setLP(getTokenOffset(ctx.OpenParen().getSymbol().getTokenIndex()));
		statement.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));
		if (ctx.statement() != null) {
			statement.setStatement(popChildren(Statement.class, ctx));
		}
		statement.setExpression(popChildren(Expression.class, ctx));
		statement.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		statement.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
	}

	@Override
	public void exitMemberIndexExpression(MemberIndexExpressionContext ctx) {
		GetArrayItemExpression item = (GetArrayItemExpression)getParent();
		item.setLB(getTokenOffset(ctx.OpenBracket().getSymbol().getTokenIndex()));
		if (ctx.expressionSequence() != null) {
			item.setIndex(popChildren(Expression.class, ctx));
			item.setRB(getTokenOffset(ctx.CloseBracket().getSymbol().getTokenIndex()));
		} else {
			item.setIndex(new ErrorExpression(item, Util.EMPTY_STRING));
			item.setRB(getTokenOffset(getTokenOffset(ctx.getStop().getTokenIndex() + 1)));
		}
		item.setArray(popChildren(Expression.class, ctx));

		item.setStart(item.getArray().sourceStart());
		if (item.getRB() > -1) {
			item.setEnd(item.getRB() + 1);
		} else {
			item.setEnd(item.getIndex().sourceEnd());
		}
	}

	@Override
	public void exitMemberDotExpression(MemberDotExpressionContext ctx) {
		PropertyExpression property = (PropertyExpression)getParent();
		locateDocumentation(property, ctx.getStart());
		int dotPosition = getTokenOffset(ctx.Dot().getSymbol().getTokenIndex());
		property.setDotPosition(dotPosition);
		if (ctx.identifierName() != null) {
			property.setProperty(popChildren(Expression.class, ctx));
		} else {
			final ErrorExpression error = new ErrorExpression(property,
					Util.EMPTY_STRING);
			error.setStart(dotPosition + 1);
			error.setEnd(dotPosition + 1);
			property.setProperty(error);
		}
		property.setObject(popChildren(Expression.class, ctx));

		assert property.getObject().sourceStart() >= 0;
		assert property.getProperty().sourceEnd() > 0;

		property.setStart(property.getObject().sourceStart());
		property.setEnd(property.getProperty().sourceEnd());
	}

	@Override
	public void exitArrayLiteralExpression(ArrayLiteralExpressionContext ctx) {
		final int itemCount = ctx.arrayLiteral().getChildCount();
		ArrayInitializer array = (ArrayInitializer)getParent();
		ElementListContext elementList = ctx.arrayLiteral().elementList();
		for (int i = 0; i < elementList.Comma().size(); i++) {
			if (i >= itemCount - 1) break;
			array.getCommas().add(getTokenOffset(elementList.Comma(i).getSymbol().getTokenIndex()));
		}
		if (array.getItems().size() != array.getCommas().size() - 1) {
			//empty element(s)
			for (int i = 0; i < elementList.getChildCount()-1 ; i++) {
				if (elementList.Comma().contains(elementList.getChild(i)) && elementList.Comma().contains(elementList.getChild(i+1))) {
					if (i >= itemCount - 1) break; //we don't append empty elements
					EmptyExpression empty = new EmptyExpression(array);
					Token comma = elementList.Comma(i).getSymbol();
					empty.setStart(comma.getStartIndex());
					empty.setEnd(comma.getStopIndex());
					array.getItems().add(i, empty);
				}
			}
		}
		array.setLB(getTokenOffset(ctx.getStart().getTokenIndex()));
		array.setRB(getTokenOffset(ctx.arrayLiteral().CloseBracket().getSymbol().getTokenIndex()));
		array.setStart(array.getLB());
		array.setEnd(array.getRB() + 1);
	}

	@Override
	public void exitArrayElement(ArrayElementContext ctx) {
		ArrayInitializer array = (ArrayInitializer)getParent();
		array.getItems().add(popChildren(Expression.class, ctx));
	}

	@Override
	public void exitParenthesizedExpression(ParenthesizedExpressionContext ctx) {
		ParenthesizedExpression expression = (ParenthesizedExpression) getParent();
		expression.setLP(getTokenOffset(ctx.OpenParen().getSymbol().getTokenIndex()));
		expression.setStart(expression.getLP());

		if (ctx.expressionSequence() != null) {
			expression.setExpression(popChildren(Expression.class, ctx));
			expression.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));
		} else {
			expression.setExpression(new ErrorExpression(expression,
					Util.EMPTY_STRING));
			expression.setRP(getTokenOffset(ctx.getStop().getTokenIndex()));
		}
		expression.setEnd(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex() + 1));
	}

	@Override
	public void exitTernaryExpression(TernaryExpressionContext ctx) {
		ConditionalOperator operator = (ConditionalOperator)getParent();
		operator.setFalseValue(popChildren(Expression.class, ctx));
		operator.setTrueValue(popChildren(Expression.class, ctx));
		operator.setCondition(popChildren(Expression.class, ctx));
		operator.setQuestionPosition(getTokenOffset(ctx.QuestionMark().getSymbol().getTokenIndex()));
		operator.setColonPosition(getTokenOffset(ctx.Colon().getSymbol().getTokenIndex()));
		operator.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		operator.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
	}

	@Override
	public void exitThisExpression(ThisExpressionContext ctx) {
		ThisExpression expression = (ThisExpression)getParent();
		expression.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		expression.setEnd(getTokenOffset(ctx.getStop().getTokenIndex()+1));
	}

	@Override
	public void exitObjectLiteral(ObjectLiteralContext ctx) {
		ObjectInitializer initializer = (ObjectInitializer) getParent();
		
		IntList commas = new IntList();
		for (int i = 0; i < ctx.Comma().size(); i++) {
			commas.add(getTokenOffset(ctx.Comma(i).getSymbol().getTokenIndex()));
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

		Token LC = ctx.OpenBrace().getSymbol();
		Token RC = ctx.CloseBrace().getSymbol();
		initializer.setLC(getTokenOffset(LC.getTokenIndex()));
		initializer.setRC(getTokenOffset(RC.getTokenIndex()));

		initializer.setMultiline(LC.getLine() != RC.getLine());

		initializer.setStart(initializer.getLC());
		initializer.setEnd(getTokenOffset(ctx.getStop().getTokenIndex())+1);
	}

	@Override
	public void enterPropertyExpressionAssignment(PropertyExpressionAssignmentContext ctx) {
		parents.push(new PropertyInitializer(getParent()));
	}
	
	@Override
	public void exitPropertyExpressionAssignment(PropertyExpressionAssignmentContext ctx) {
		PropertyInitializer initializer = popParents(PropertyInitializer.class, ctx);
		final Expression value;
		if (ctx.Colon() != null) {
			initializer.setColon(getTokenOffset(ctx.Colon().getSymbol().getTokenIndex()));
		}
		if (ctx.singleExpression() != null) {
			value = popChildren(Expression.class, ctx);
		}
		//TODO FunctionProperty, PropertyShorthand
		else {
			value = new ErrorExpression(initializer, Util.EMPTY_STRING);
			value.setStart(ctx.Colon() != null ? initializer.getColon() : ctx.getStart().getTokenIndex());
			value.setEnd(ctx.Colon() != null ? initializer.getColon() + 1 : ctx.getStop().getTokenIndex());
		}
		initializer.setValue(value);
		initializer.setName(popChildren(Expression.class, ctx));
		initializer.setStart(initializer.getName().sourceStart());
		initializer.setEnd(value.sourceEnd());
		
		((ObjectInitializer)getParent()).addInitializer(initializer);
	}
	
	@Override
	public void enterPropertyGetter(PropertyGetterContext ctx) {
		parents.push(new GetMethod(getParent()));
	}

	@Override
	public void exitPropertyGetter(PropertyGetterContext ctx) {
		GetMethod method = popParents(GetMethod.class, ctx);
		
		//get and set are not JSParser constants
		final Keyword keyword = new Keyword(Keywords.GET);
		assert Keywords.GET.equals(ctx.getStart().getText());
		setRangeByToken(keyword, ctx.getStart().getTokenIndex());
		method.setGetKeyword(keyword);
		method.setLP(getTokenOffset(ctx.OpenParen().getSymbol().getTokenIndex()));
		method.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));

		method.setBody(popChildren(StatementBlock.class, ctx));
		method.setName(popChildren(Identifier.class, ctx));
		children.pop();//get

		method.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		method.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));		
		((ObjectInitializer)getParent()).addInitializer(method);
	}

	@Override
	public void enterPropertySetter(PropertySetterContext ctx) {
		parents.push(new SetMethod(getParent()));
	}	
	
	@Override
	public void exitPropertySetter(PropertySetterContext ctx) {
		SetMethod method = popParents(SetMethod.class, ctx);
		
		//get and set are not JSParser constants
		final Keyword keyword = new Keyword(Keywords.SET);
		assert Keywords.SET.equals(ctx.getStart().getText());
		setRangeByToken(keyword, ctx.getStart().getTokenIndex());
		method.setSetKeyword(keyword);
		method.setLP(getTokenOffset(ctx.OpenParen().getSymbol().getTokenIndex()));
		method.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));

		method.setBody(popChildren(StatementBlock.class, ctx));
		method.setArgument((popChildren(Argument.class, ctx)).getIdentifier());
		method.setName(popChildren(Identifier.class, ctx));
		children.pop();//set

		method.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		method.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));		
		((ObjectInitializer)getParent()).addInitializer(method);
	}

	@Override
	public void enterPropertyName(PropertyNameContext ctx) {
		if (JSNodeCreator.skipCreate(ctx)) return;
		Expression expression = (Expression) JSNodeCreator.create(ctx, getParent());
		expression.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		expression.setEnd(expression.sourceStart() + ctx.getText().length());
		children.push(expression);
	}

	private void createIdentifier(Token start, String text) {
		Identifier identifier = new Identifier(getParent());	
		locateDocumentation(identifier, start);
		identifier.setName(intern(text));
		setRangeByToken(identifier, start.getTokenIndex());
		children.push(identifier);
	}
	
	@Override
	public void enterIdentifierName(IdentifierNameContext ctx) {
		createIdentifier(ctx.getStart(), ctx.getText());
	}

	@Override
	public void enterArrowFunction(ArrowFunctionContext ctx) {
		scopes.push(new SymbolTable((ArrowFunctionStatement)getParent()));
	}

	@Override
	public void exitArrowFunction(ArrowFunctionContext ctx) {
		ArrowFunctionStatement fn = (ArrowFunctionStatement) getParent();
		
		Statement body = null;
		if (children.peek() instanceof StatementBlock) {
				body = popChildren(StatementBlock.class, ctx);
		}
		else {
			body = transformStatementNode(ctx, children.pop());
		}
		
		final SymbolTable functionScope = scopes.pop();
		ArrowFunctionParametersContext params = ctx.arrowFunctionParameters();
		if (params.OpenParen() != null) {
			fn.setLP(getTokenOffset(params.OpenParen().getSymbol().getTokenIndex()));
			if (params.CloseParen() != null) {
				fn.setRP(getTokenOffset(params.CloseParen().getSymbol().getTokenIndex()));
			}
			if (params.formalParameterList() != null) {
				List<Argument> arguments = new ArrayList<>();
				FormalParameterListContext parameterList = ctx
						.arrowFunctionParameters().formalParameterList();
				List<FormalParameterArgContext> args = parameterList
						.formalParameterArg();
				for (FormalParameterArgContext arg : args) {
					if (children.peek() instanceof Argument) {
						arguments.add(popChildren(Argument.class, ctx));
					}
				}
				Collections.reverse(arguments);
				for (int i = 0,
						childCount = arguments.size(); i < childCount; ++i) {
					Argument argument = arguments.get(i);
					if (i + 1 < childCount) {
						argument.setCommaPosition(getTokenOffset(parameterList
								.Comma(i).getSymbol().getTokenIndex()));
					}
					fn.addArgument(argument);
					validateParameter(functionScope, argument);
				}
			}
		} else if (children.peek() instanceof Identifier) {
			Argument argument = new Argument(fn);
			argument.setIdentifier(popChildren(Identifier.class, ctx));
			fn.addArgument(argument);
			validateParameter(functionScope, argument);
		}
		
		fn.setBody(body);
		fn.setArrow(getTokenOffset(ctx.ARROW().getSymbol().getTokenIndex()));
		fn.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		fn.setEnd(fn.getBody().sourceEnd());
	}

	public void validateParameter(final SymbolTable functionScope,
			Argument argument) {
		if (functionScope.add(argument.getArgumentName(), SymbolKind.PARAM) != null && reporter != null) {
			reporter.setFormattedMessage(
					JavaScriptParserProblems.DUPLICATE_PARAMETER,
					argument.getArgumentName());
			reporter.setRange(argument.sourceStart(), argument.sourceEnd());
			reporter.report();
		}
	}

	@Override
	public void enterTemplateStringLiteral(TemplateStringLiteralContext ctx) {
		TemplateStringLiteral literal;
		if (children.peek() instanceof TemplateStringLiteral) {
			literal = popChildren(TemplateStringLiteral.class, ctx);
		}
		else {
			literal = new TemplateStringLiteral(getParent());
			literal.setText(intern(ctx.getText()));
			literal.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
			if (literal.getText() != null) {
				literal.setEnd(literal.sourceStart() + literal.getText().length());
			}
		}
		literal.setStartBackTick(getTokenOffset(ctx.BackTick(0).getSymbol().getTokenIndex()));
		literal.setEndBackTick(getTokenOffset(ctx.BackTick(1) != null ? 
				ctx.BackTick(1).getSymbol().getTokenIndex(): ctx.getStop().getTokenIndex()));
		parents.push(literal);
	}	

	@Override
	public void exitTemplateStringLiteral(TemplateStringLiteralContext ctx) {
		children.push(parents.pop());
	}

	@Override
	public void exitTemplateStringAtom(TemplateStringAtomContext ctx) {
		if (ctx.TemplateStringStartExpression() != null)
		{
			TemplateStringExpression expression = new TemplateStringExpression(getParent());
			expression.setExpression(popChildren(Expression.class, ctx));
			int start = getTokenOffset(ctx.TemplateStringStartExpression().getSymbol().getTokenIndex());
			expression.setStart(start);
			int end = expression.getExpression().sourceEnd() + 1;
			expression.setEnd(end);
			expression.setTemplateStringStart(start);
			expression.setTemplateCloseBrace(end);
			((TemplateStringLiteral)getParent()).addTemplateStringExpression(expression);
		}
	}

	@Override
	public void exitTemplateStringExpression(TemplateStringExpressionContext ctx) {
		TagFunctionExpression tagFunction = (TagFunctionExpression) getParent();
		tagFunction.setLiteral(popChildren(TemplateStringLiteral.class, ctx));
		tagFunction.setTagFunction(popChildren(Expression.class, ctx));
		tagFunction.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		tagFunction.setEnd(getTokenOffset(ctx.getStop().getTokenIndex()));
	}
	
	@Override
	public void exitForOfStatement(ForOfStatementContext ctx) {
		ForOfStatement statement = (ForOfStatement)getParent();
		Statement body = popChildren(Statement.class, ctx);
		Expression iterator = popChildren(Expression.class, ctx);
		Expression item = popChildren(Expression.class, ctx);
		
		statement.setForKeyword(createKeyword(statement, ctx.getStart(),  Keywords.FOR));
		statement.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.For().getSymbol().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		statement.setItem(item);

		Keyword ofKeyword = createKeyword(statement, ctx.Of().getSymbol(), Keywords.OF);
		statement.setOfKeyword(ofKeyword);
		statement.setIterator(iterator);
		if (ctx.CloseParen() != null) {
			statement.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));
		}

		if (ctx.getChildCount() >= 1)
			statement.setBody(body);

		statement.setStart(statement.getForKeyword().sourceStart());
		setEndByTokenIndex(statement, ctx.getStop().getTokenIndex());
	}
}