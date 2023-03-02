package org.eclipse.dltk.javascript.parser.v4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.dltk.compiler.util.Util;
import org.eclipse.dltk.internal.core.util.WeakHashSet;
import org.eclipse.dltk.javascript.ast.Argument;
import org.eclipse.dltk.javascript.ast.ArrayInitializer;
import org.eclipse.dltk.javascript.ast.BreakStatement;
import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.CaseClause;
import org.eclipse.dltk.javascript.ast.CatchClause;
import org.eclipse.dltk.javascript.ast.Comment;
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
import org.eclipse.dltk.javascript.ast.NewExpression;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.ReturnStatement;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.Statement;
import org.eclipse.dltk.javascript.ast.StatementBlock;
import org.eclipse.dltk.javascript.ast.SwitchStatement;
import org.eclipse.dltk.javascript.ast.ThrowStatement;
import org.eclipse.dltk.javascript.ast.TryStatement;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.VoidExpression;
import org.eclipse.dltk.javascript.ast.WhileStatement;
import org.eclipse.dltk.javascript.ast.WithStatement;
import org.eclipse.dltk.javascript.ast.YieldOperator;
import org.eclipse.dltk.javascript.ast.v4.BinaryOperation;
import org.eclipse.dltk.javascript.ast.v4.Keywords;
import org.eclipse.dltk.javascript.ast.v4.UnaryOperation;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AdditiveExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArgumentsContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArgumentsExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrayElementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ArrayLiteralExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentOperatorContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.AssignmentOperatorExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BitNotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BlockContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.BreakStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.CaseBlockContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.CaseClauseContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.CatchProductionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ContinueStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.DefaultClauseContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.DeleteExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.DoStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ElementListContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.EmptyStatement_Context;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ExpressionStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FinallyProductionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ForInStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ForStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FormalParameterArgContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FunctionBodyContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.FunctionDeclarationContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.IdentifierContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.IfStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LabelledStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.LiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MemberDotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MemberIndexExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.MultiplicativeExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.NewExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.NotExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PostDecreaseExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PostIncrementExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PreDecreaseExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.PreIncrementExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ProgramContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.RelationalExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ReturnStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.SingleExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.SourceElementsContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.StatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.StatementListContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.SwitchStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ThrowStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TryStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.TypeofExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.UnaryMinusExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.UnaryPlusExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VariableDeclarationContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VariableDeclarationListContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VariableStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VoidExpressionContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.WhileStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.WithStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.YieldStatementContext;
import org.eclipse.dltk.javascript.parser.v4.factory.JSNodeCreator;
import org.eclipse.dltk.utils.IntList;

public class JSTransformerListener extends JavaScriptParserBaseListener {

	private final JSParser parser;
	private SymbolTable scope;
	private Stack<JSNode> parents = new Stack<JSNode>();
	private Stack<JSNode> children = new Stack<JSNode>();
	private Stack<List<Statement>> lists = new Stack<>();
	private Reporter reporter;
	private Script script;
	private List<Token> tokens;
	private final int[] tokenOffsets;
	private final Map<Integer, Comment> documentationMap = new HashMap<Integer, Comment>();

	/**
	 * @param javaScriptParser
	 */
	JSTransformerListener(JSParser javaScriptParser) {
		parser = javaScriptParser;
		tokens = ((JSTokenStream)parser.getTokenStream()).getTokens();
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
			return null;
		} else {
			return parents.peek();
		}
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
	
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}
	
	public ASTNode transform(ParseTree root) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Script transformScript(ProgramContext root) {
		if (root == null)
			return new Script();
		script = new Script();
		scope = new SymbolTable(script);
		
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(this, root);
		
		//TODO addComments(script);
		
		script.setStart(0);
		script.setEnd(tokenOffsets[tokenOffsets.length - 1]);//getTokenOffset(root.stop.getTokenIndex()));
		
//		for (NodeTransformer transformer : transformers) {
//			if (transformer instanceof NodeTransformerExtension) {
//				((NodeTransformerExtension) transformer).postConstruct(script);
//			}
//		}
		
		assert parents.isEmpty();
		assert children.isEmpty();
		assert lists.isEmpty();
		return script;
	}

	private Keyword createKeyword(ASTNode node, Token token, String text) {
		assert text.equals(token.getText());
		assert text.equals(Keywords.fromToken(token.getType()));
		final Keyword keyword = new Keyword(text);
		setRangeByToken(keyword, token.getStartIndex());
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
		return token.getType() == JSParser.LineTerminator //TODO make sure this is EOL
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
		}
	}

	@Override
	public void exitStatement(StatementContext ctx) {
		if (JSNodeCreator.skipCreate(ctx)) return;
		addStatement(ctx, parents.pop());
	}

	private void addStatement(StatementContext ctx, JSNode expression) {
		Statement statement = transformStatementNode(ctx, expression);
		if (expression.getParent() == null) {
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
		if (ctx.getParent() != null && ctx.getParent().getParent() instanceof ExpressionStatementContext) return;
		if (ctx instanceof SingleExpressionContext) {
			if (!JSNodeCreator.skipCreate(ctx)) {
				children.push(parents.pop());
			}
		}
	}

//TODO removed for now
//	@Override
//	public void enterExpressionSequence(ExpressionSequenceContext ctx) {
//		List<SingleExpressionContext> ruleContexts = ctx.getRuleContexts(SingleExpressionContext.class);
//		Collections.reverse(ruleContexts);
//		for (SingleExpressionContext singleExpression : ruleContexts) {
//			if (!JSNodeCreator.skipCreate(singleExpression)) {
//				parents.push(JSNodeCreator.create(singleExpression, getParent()));
//			}
//		}
//	}
//
//	@Override
//	public void exitExpressionSequence(ExpressionSequenceContext ctx) {
//		if (ctx.getParent() instanceof ExpressionStatementContext) return;
//		List<SingleExpressionContext> ruleContexts = ctx.getRuleContexts(SingleExpressionContext.class);
//		for (SingleExpressionContext singleExpression : ruleContexts) {
//			if (!JSNodeCreator.skipCreate(singleExpression)) {
//				children.push(parents.pop());
//			}
//		}
//	}
	
	@Override
	public void exitExpressionStatement(ExpressionStatementContext ctx) {
		addStatement((StatementContext) ctx.getParent(), parents.pop());
	}

	@Override
	public void enterLiteral(LiteralContext ctx) {
		Literal literal = (Literal) JSNodeCreator.create(ctx, getParent());
		literal.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		literal.setEnd(literal.sourceStart() + literal.getText().length());
		children.push(literal);
	}

	@Override
	public void enterVariableStatement(VariableStatementContext ctx) {
		createVariableStatement(ctx);
	}

	public void createVariableStatement(ParserRuleContext ctx) {
		VariableStatement statement = (VariableStatement)getParent();
		locateDocumentation(statement, ctx.getStart());
		//TODO var/ or let or const!
		statement.setVarKeyword(createKeyword(statement, ctx.getStart(), Keywords.VAR));
		setRange(statement, ctx);
	}

	@Override
	public void enterVariableDeclarationList(
			VariableDeclarationListContext ctx) {
		if (!getParent().getClass().equals(VariableStatement.class)) {
			VariableStatement statement = new VariableStatement(getParent());
			parents.push(statement);
			createVariableStatement(ctx);
		}
	}

	@Override
	public void exitVariableDeclarationList(VariableDeclarationListContext ctx) {
		VariableStatement statement = (VariableStatement)getParent();
		List<VariableDeclaration> decl = new ArrayList<>();
		for (int i = 0; i < ctx.variableDeclaration().size(); i++ ) {
			decl.add((VariableDeclaration) children.pop());
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
		VariableDeclaration declaration = (VariableDeclaration)parents.pop();
//		VariableStatement statement = (VariableStatement)getParent();
//		statement.addVariable(declaration);
		
		if (!children.isEmpty() && children.peek() instanceof Expression && ctx.Assign() != null) {
			declaration.setAssignPosition(getTokenOffset(ctx.Assign().getSymbol().getTokenIndex()));
			declaration.setInitializer((Expression) children.pop());
		}
		if (children.peek() instanceof Identifier) {
			Identifier identifier = (Identifier) children.pop();
			declaration.setIdentifier(identifier);
//			declaration.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
//			declaration.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
		}

		SymbolKind kind = SymbolKind.VAR; //TODO add LET?
		final SymbolKind replaced = scope.add(
				declaration.getVariableName(), kind, declaration);
		if (replaced != null && reporter != null) {
			final Identifier identifier = declaration.getIdentifier();
			reporter.setRange(identifier.sourceStart(),
					identifier.sourceEnd());
			if (replaced == kind) {
				reporter.setMessage(kind.duplicateProblem,
						declaration.getVariableName());
			} else {
				//TODO
//				reporter.setMessage(kind.hideProblem,
//						declaration.getVariableName(),
//						replaced.verboseName());
			}
			reporter.report();
		}
		
		setRange(declaration, ctx);
		children.add(declaration);
	}

	@Override
	public void enterIdentifier(IdentifierContext ctx) {
		//TODO move to factory
		Assert.isTrue(ctx.getStart().getType() == JSParser.Identifier);
//		|| JSLexer.isIdentifierKeyword(ctx.getStart().getType()));
		
		Identifier identifier = new Identifier(getParent());	
		locateDocumentation(identifier, ctx.getStart());
		identifier.setName(intern(ctx.getText()));
		setRangeByToken(identifier, ctx.getStart().getTokenIndex());
		children.push(identifier);
	}
	
	@Override
	public void exitAdditiveExpression(AdditiveExpressionContext ctx) {
		setupBinaryOperation(ctx);
	}
	
	public void setupBinaryOperation(SingleExpressionContext ctx) {
		BinaryOperation operation = (BinaryOperation) getParent();		
		
		operation.setRightExpression((Expression) children.pop());
		if (!children.isEmpty()) {
			operation.setLeftExpression((Expression) children.pop());	
		}

		operation.setOperationPosition(getTokenOffset(operation.getOperation(), ctx.getStart().getTokenIndex(),
				ctx.getStop().getStopIndex()));

		Assert.isTrue(operation.getOperationPosition() >= operation
				.getLeftExpression().sourceEnd());
		Assert.isTrue(operation.getOperationPosition() + operation.getOperationText().length() <=
				operation.getRightExpression().sourceStart());

		operation.setStart(operation.getLeftExpression().sourceStart());
		operation.setEnd(operation.getRightExpression().sourceEnd());
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
	public void exitIfStatement(IfStatementContext ctx) {
		IfStatement ifStatement = (IfStatement) getParent();
		ifStatement.setIfKeyword(createKeyword(ifStatement, ctx.getStart(), Keywords.IF));		
		ifStatement.setStart(ifStatement.getIfKeyword().sourceStart());
		setEndByTokenIndex(ifStatement, ctx.getStop().getTokenIndex());

		Statement _else = ctx.Else() != null ? (Statement) children.pop() : null;
		Statement then = (Statement) children.pop();
		ifStatement.setCondition((Expression) children.pop());
		
		ifStatement.setLP(getTokenOffset(JSParser.OpenParen, ctx.getStart().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		if (ctx.statement() != null) {
			ifStatement.setRP(ctx.CloseParen().getSymbol().getTokenIndex());
			ifStatement.setThenStatement(then);
		} 
		else {
			ifStatement.setRP(ctx.CloseParen().getSymbol().getTokenIndex());
		}

		if (ctx.Else() != null) {
			Keyword elseKeyword = new Keyword(Keywords.ELSE);
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
		List<Statement> statementList = lists.pop();
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
	}	
		
	@Override
	public void exitWhileStatement(WhileStatementContext ctx) {
		WhileStatement statement = (WhileStatement) getParent();
		statement.setWhileKeyword(createKeyword(statement, ctx.getStart(),  Keywords.WHILE));
		statement.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.getStart().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		statement.setRP(ctx.CloseParen().getSymbol().getTokenIndex());

		if (ctx.statement() != null) statement.setBody((Statement) children.pop());
		statement.setCondition((Expression) children.pop());
		statement.setStart(statement.getWhileKeyword().sourceStart());
		setEndByTokenIndex(statement, ctx.getStop().getTokenIndex());
	}
	
	@Override
	public void exitDoStatement(DoStatementContext ctx) {
		DoWhileStatement statement = (DoWhileStatement) getParent();
		Expression condition = (Expression) children.pop();
		Statement body = (Statement) children.pop();
		
		statement.setDoKeyword(createKeyword(statement, ctx.getStart(),  Keywords.DO));
		if (ctx.statement() != null) statement.setBody(body);
		
		statement.setWhileKeyword(createKeyword(statement, ctx.While().getSymbol(), Keywords.WHILE));
		statement.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.While().getSymbol().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		statement.setRP(ctx.CloseParen().getSymbol().getTokenIndex());

		statement.setCondition(condition);
		statement.setSemicolonPosition(ctx.getStop().getTokenIndex());

		statement.setStart(statement.getDoKeyword().sourceStart());
		setEndByTokenIndex(statement, ctx.getStop().getTokenIndex());
	}

	@Override
	public void exitForStatement(ForStatementContext ctx) {
		ForStatement statement = (ForStatement) getParent();
		Statement body = (Statement) children.pop();
		Expression step = (Expression) children.pop();
		Expression condition = (Expression) children.pop();
		Expression initial = (Expression) children.pop();
		
		statement.setForKeyword(createKeyword(statement, ctx.getStart(),  Keywords.FOR));
		statement.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.For().getSymbol().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		
		statement.setInitial(initial);
		statement.setInitialSemicolonPosition(getTokenOffset(ctx.SemiColon(0).getSymbol().getTokenIndex()));
		statement.setCondition(condition);
		statement.setConditionalSemicolonPosition(getTokenOffset(ctx.SemiColon(1).getSymbol().getTokenIndex()));
		statement.setStep(step);
		statement.setRP(ctx.CloseParen().getSymbol().getTokenIndex());

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
		Statement body = (Statement) children.pop();
		Expression iterator = (Expression) children.pop();
		Expression item = (Expression) children.pop();
		
		statement.setForKeyword(createKeyword(statement, ctx.getStart(),  Keywords.FOR));
		statement.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.For().getSymbol().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		
		statement.setItem(item);

		Keyword inKeyword = new Keyword(Keywords.IN);

//		int iteratorStart = node.getChild(0).getChild(1).getTokenStartIndex();
//
//		if (iteratorStart == -1
//				&& node.getChild(0).getChild(1).getType() == JSParser.EXPR
//				&& node.getChild(0).getChild(1).getChildCount() > 0)
//			iteratorStart = node.getChild(0).getChild(1).getChild(0)
//					.getTokenStartIndex();

		inKeyword.setStart(ctx.In().getSymbol().getTokenIndex());
		inKeyword.setEnd(inKeyword.sourceStart() + Keywords.IN.length());
		statement.setInKeyword(inKeyword);
		statement.setIterator(iterator);
		statement.setRP(ctx.CloseParen().getSymbol().getTokenIndex());

		if (ctx.getChildCount() >= 1)
			statement.setBody(body);

		statement.setStart(statement.getForKeyword().sourceStart());
		setEndByTokenIndex(statement, ctx.getStop().getTokenIndex());
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
		List<Statement> statementList = lists.pop();
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
	public void exitFunctionDeclaration(FunctionDeclarationContext ctx) {
		FunctionStatement fn = (FunctionStatement) getParent();
		locateDocumentation(fn, ctx.getStart());
		fn.setFunctionKeyword(createKeyword(fn, ctx.getStart(), Keywords.FUNCTION));
		
		StatementBlock body = (StatementBlock) children.pop();
		List<FormalParameterArgContext> args = ctx.formalParameterList().formalParameterArg();
		List<Argument> arguments = new ArrayList<>();
		for (FormalParameterArgContext arg : args) {
			arguments.add((Argument) children.pop());
		}
		Collections.reverse(arguments);
		Identifier identifier = (Identifier) children.pop();
		fn.setName(identifier);
		
		
		final SymbolTable functionScope = new SymbolTable(fn);
		for (int i = 0, childCount = arguments.size(); i < childCount; ++i) {
			Argument argument = arguments.get(i);
			if (i + 1 < childCount) {
				argument.setCommaPosition(getTokenOffset(ctx.formalParameterList().Comma(i).getSymbol().getTokenIndex()));
			}
			fn.addArgument(argument);
			if (functionScope.add(argument.getArgumentName(), SymbolKind.PARAM) != null && reporter != null) {
				reporter.setFormattedMessage(
				JavaScriptParserProblems.DUPLICATE_PARAMETER,
				argument.getArgumentName());
				reporter.setRange(argument.sourceStart(), argument.sourceEnd());
				reporter.report();
			}
		}
		
		fn.setLP(getTokenOffset(JSParser.OpenParen, 
				ctx.identifier().getStop().getTokenIndex() + 1, ctx.OpenParen().getSymbol().getStartIndex()));
		fn.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));
		if (fn.isDeclaration() && identifier != null) {
			final SymbolKind replaced = scope.add(identifier.getName(),
					SymbolKind.FUNCTION, fn);
			if (replaced != null && reporter != null) {
				if (replaced == SymbolKind.FUNCTION) {
					reporter.setMessage(
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
		final SymbolTable savedScope = scope;
		try {
			scope = functionScope;
			fn.setBody(body);
		} finally {
			scope = savedScope;
		}
		fn.setStart(fn.getFunctionKeyword().sourceStart());
		fn.setEnd(fn.getBody().sourceEnd());
	}

	private Statement transformStatementNode(StatementContext ctx, JSNode expression) {
		if (expression instanceof Statement)
			return (Statement) expression;
		else {
			VoidExpression voidExpression = new VoidExpression(getParent() == null? script : getParent());
			voidExpression.setExpression((Expression) expression);

			if (ctx.getStop().getTokenIndex() >= 0
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
		arg.setIdentifier((Identifier) children.pop());
		//TODO impl set initializer (es6)
		arg.setCommaPosition(0);
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

		operation.setExpression((Expression) children.pop());
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

		if (!scope.addLabel(statement) && reporter != null) {
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
			statement.setStatement((Statement) children.pop());
		}
		children.pop();//remove the label from the stack, was processed in enterLabelledStatement
		statement.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		statement.setEnd(getTokenOffset(ctx.getStop().getTokenIndex()));
	}

	@Override
	public void exitContinueStatement(ContinueStatementContext ctx) {
		ContinueStatement statement = (ContinueStatement)getParent();
		statement.setContinueKeyword(createKeyword(statement, ctx.getStart(), Keywords.CONTINUE));

		if (ctx.identifier() != null) {
			Label label = new Label(statement);
			Identifier labelNode = (Identifier) children.pop();
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
			returnStatement.setValue((Expression) children.pop());
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
			Identifier labelNode = (Identifier) children.pop();
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
			statement.setException((Expression) children.pop());
		}

		if (ctx.eos().SemiColon() != null) {
			statement.setSemicolonPosition(getTokenOffset(ctx.eos().SemiColon().getSymbol().getTokenIndex()));
		}
		setRange(statement, ctx);
	}

	@Override
	public void exitNewExpression(NewExpressionContext ctx) {
		Expression callExpression = ctx.singleExpression()	!= null ? transformCallExpression(ctx.singleExpression(), ctx.arguments()) : null;
		parents.pop();//TODO check
		NewExpression expression = (NewExpression)getParent();
		expression.setNewKeyword(createKeyword(expression, ctx.getStart(), Keywords.NEW));
		if (ctx.singleExpression()	!= null) {
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

		List<Expression> _args = new ArrayList<>();
		for(int i = 0; i < args.argument().size(); i++) {
			_args.add((Expression) children.pop());
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
		if (getParent() instanceof StatementBlock) return;
		parents.push(new StatementBlock(getParent()));
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
		statement.setBody((StatementBlock)children.pop());
		statement.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		statement.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
	}

	@Override
	public void enterCatchProduction(CatchProductionContext ctx) {
		parents.push(new CatchClause(getParent()));
	}
	
	@Override
	public void exitCatchProduction(CatchProductionContext ctx) {
		CatchClause catchClause = (CatchClause) parents.pop();
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

		catchClause.setRP(getTokenOffset(ctx.CloseParen().getSymbol().getTokenIndex()));
		catchClause.setStatement((Statement) children.pop());

		catchClause.setException((Identifier) children.pop());
		catchClause.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		catchClause.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));	
		
		TryStatement parent = (TryStatement) catchClause.getParent();
		parent.getCatches().add(catchClause);
	}
	
	@Override
	public void enterFinallyProduction(FinallyProductionContext ctx) {
		parents.push(new FinallyClause(getParent()));
	}

	@Override
	public void exitFinallyProduction(FinallyProductionContext ctx) {
		FinallyClause finallyClause = (FinallyClause)parents.pop();
		finallyClause.setFinallyKeyword(createKeyword(finallyClause, ctx.getStart(), Keywords.FINALLY));

		if (ctx.block() != null) {
			finallyClause.setStatement((Statement) children.pop());
		}

		finallyClause.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		finallyClause.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
		TryStatement parent = (TryStatement) finallyClause.getParent();
		parent.setFinally(finallyClause);
	}

	@Override
	public void enterYieldStatement(YieldStatementContext ctx) {
		parents.push(new YieldOperator(getParent()));
	}

	@Override
	public void exitYieldStatement(YieldStatementContext ctx) {
		YieldOperator expression = (YieldOperator)getParent();
		expression.setYieldKeyword(createKeyword(expression, ctx.getStart(), Keywords.YIELD));
		expression.setExpression((Expression) children.pop());
		expression.setStart(expression.getYieldKeyword().sourceStart());
		expression.setEnd(expression.getExpression().sourceEnd());
	}

	@Override
	public void exitSwitchStatement(SwitchStatementContext ctx) {
		SwitchStatement switchStatement = (SwitchStatement) getParent();
		switchStatement.setSwitchKeyword(createKeyword(switchStatement, ctx.getStart(), Keywords.SWITCH));
		switchStatement.setCondition((Expression) children.pop());
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
	public void exitCaseBlock(CaseBlockContext ctx) {
		if (ctx.exception != null) {
			reporter.setMessage(ctx.exception.getMessage());
			reporter.setSeverity(ProblemSeverity.ERROR);
			reporter.setStart(reporter.getOffset(ctx.exception.getOffendingToken()));
			reporter.setEnd(reporter.getStart()
					+ ctx.exception.getOffendingToken().getText().length());
			reporter.report();	
		}
	}

	@Override
	public void enterCaseClause(CaseClauseContext ctx) {
		parents.push(new CaseClause(getParent()));
	}

	@Override
	public void exitCaseClause(CaseClauseContext ctx) {
		CaseClause caseClause = (CaseClause)parents.pop();
		caseClause.setCaseKeyword(createKeyword(caseClause, ctx.getStart(), Keywords.CASE));
		caseClause.setColonPosition(getTokenOffset(ctx.Colon().getSymbol().getTokenIndex()));
		caseClause.setCondition((Expression) children.pop());
		List<Statement> statements = lists.pop();
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
		DefaultClause caseClause = (DefaultClause)parents.pop();
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
			statement.setStatement((Statement)children.pop());
		}
		statement.setExpression((Expression) children.pop());
		statement.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		statement.setEnd(getTokenOffset(ctx.getStop().getTokenIndex() + 1));
	}

	@Override
	public void exitMemberIndexExpression(MemberIndexExpressionContext ctx) {
		GetArrayItemExpression item = (GetArrayItemExpression)getParent();
		item.setLB(getTokenOffset(ctx.OpenBracket().getSymbol().getTokenIndex()));
		if (ctx.expressionSequence() != null) {
			item.setIndex((Expression) children.pop());
			item.setRB(getTokenOffset(ctx.CloseBracket().getSymbol().getTokenIndex()));
		} else {
			item.setIndex(new ErrorExpression(item, Util.EMPTY_STRING));
			item.setRB(getTokenOffset(getTokenOffset(ctx.getStop().getTokenIndex() + 1)));
		}
		item.setArray((Expression) children.pop());

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
			property.setProperty((Expression) children.pop());
		} else {
			final ErrorExpression error = new ErrorExpression(property,
					Util.EMPTY_STRING);
			error.setStart(dotPosition + 1);
			error.setEnd(dotPosition + 1);
			property.setProperty(error);
		}
		property.setObject((Expression) children.pop());

		assert property.getObject().sourceStart() >= 0;
		assert property.getProperty().sourceEnd() > 0;

		property.setStart(property.getObject().sourceStart());
		property.setEnd(property.getProperty().sourceEnd());
	}

	@Override
	public void exitArrayLiteralExpression(ArrayLiteralExpressionContext ctx) {
		ArrayInitializer array = (ArrayInitializer)getParent();
		ElementListContext elementList = ctx.arrayLiteral().elementList();
		for (int i = 0; i < elementList.Comma().size(); i++) {
			array.getCommas().add(getTokenOffset(elementList.Comma(i).getSymbol().getTokenIndex()));
		}
		array.setLB(getTokenOffset(ctx.getStart().getTokenIndex()));
		array.setRB(getTokenOffset(ctx.arrayLiteral().CloseBracket().getSymbol().getTokenIndex()));
		array.setStart(array.getLB());
		array.setEnd(array.getRB() + 1);
	}

	@Override
	public void exitArrayElement(ArrayElementContext ctx) {
		ArrayInitializer array = (ArrayInitializer)getParent();
		array.getItems().add((Expression) children.pop());
	}	
}