package org.eclipse.dltk.javascript.parser.v4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.internal.core.util.WeakHashSet;
import org.eclipse.dltk.javascript.ast.DecimalLiteral;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.IVariableStatement;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Keyword;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.Statement;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.VoidExpression;
import org.eclipse.dltk.javascript.ast.v4.Keywords;
import org.eclipse.dltk.javascript.parser.v4.JSParser.IdentifierContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.NumericLiteralContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ProgramContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.StatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VariableDeclarationContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VariableStatementContext;

public class JSTransformerListener extends JavaScriptParserBaseListener {

	private final JSParser parser;
	private SymbolTable scope;
	private Stack<JSNode> parents = new Stack<JSNode>();
	private List<JSNode> children = new ArrayList<JSNode>();
	private Reporter reporter;
	private Script script;
	private List<Token> tokens;
	private final int[] tokenOffsets;

	/**
	 * @param javaScriptParser
	 */
	JSTransformerListener(JSParser javaScriptParser) {
		parser = javaScriptParser;
		tokens = ((JSTokenStream)parser.getTokenStream()).getTokens();
		tokenOffsets = prepareOffsetMap(tokens);
	}
	
	private static final WeakHashSet stringPool = new WeakHashSet();

	private static final String intern(String value) {
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
		script.setEnd(root.stop.getTokenIndex());
		
//		for (NodeTransformer transformer : transformers) {
//			if (transformer instanceof NodeTransformerExtension) {
//				((NodeTransformerExtension) transformer).postConstruct(script);
//			}
//		}
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
		node.setStart(treeNode.getStart().getTokenIndex());
		setEndByTokenIndex(node, getTokenOffset(treeNode.getStart().getTokenIndex() + 1));
	}

	private void setEndByTokenIndex(ASTNode node, int stopIndex) {
		while (stopIndex >= 0 && isHidden(tokens.get(stopIndex))) { //TODO check
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
	
	@Override
	public void exitStatement(StatementContext ctx) {
		JSNode expression = parents.pop();
		if (expression instanceof Statement)
			script.addStatement((Statement) expression);
		else {
			VoidExpression voidExpression = new VoidExpression(script); //TODO parent or expression
			voidExpression.setExpression((Expression) expression);

			if (ctx.getStop().getTokenIndex() >= 0
					&& ctx.getStop().getTokenIndex() < tokens.size()) {
				final Token token = ctx.getStop();
				if (token.getType() == JSParser.SemiColon) {
					voidExpression.setSemicolonPosition(ctx.stop.getTokenIndex());
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

			script.addStatement(voidExpression);
		}
	}

	@Override
	public void enterVariableStatement(VariableStatementContext ctx) {
		VariableStatement statement = new VariableStatement(getParent());
		//TODO locateDocumentation(var, node);
		
		//TODO var/ or let or const!
		statement.setVarKeyword(createKeyword(statement, ctx.getParent().getStart(), Keywords.VAR));
		
		setRange(statement, ctx);
		parents.add(statement);
	}

	@Override
	public void enterVariableDeclaration(VariableDeclarationContext ctx) {
		VariableDeclaration declaration = new VariableDeclaration((IVariableStatement) getParent());
		parents.add(declaration);
	}	
	
	@Override
	public void exitVariableDeclaration(VariableDeclarationContext ctx) {
		VariableDeclaration declaration = (VariableDeclaration)parents.pop();
		VariableStatement statement = (VariableStatement)getParent();
		statement.addVariable(declaration);
		if (children.get(0) instanceof Identifier) {
			Identifier identifier = (Identifier) children.remove(0);
			declaration.setIdentifier(identifier);
			//TODO
			//declaration.setStart(getTokenOffset(node.getTokenStartIndex()));
			//declaration.setEnd(getTokenOffset(node.getTokenStopIndex() + 1));
			if (!children.isEmpty() && children.get(0) instanceof Expression) {
				declaration.setAssignPosition(getTokenOffset(ctx.Assign().getSymbol().getTokenIndex()));
				declaration.setInitializer((Expression) children.remove(0));
			}
		}	

		SymbolKind kind = SymbolKind.VAR; //TODO add LET?
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

	@Override
	public void enterIdentifier(IdentifierContext ctx) {
		Assert.isTrue(ctx.getStart().getType() == JSParser.Identifier);
//		|| JSLexer.isIdentifierKeyword(ctx.getStart().getType()));
		
		Identifier identifier = new Identifier(getParent());	
		// TODO locateDocumentation(identifier, currentJSNode);
		identifier.setName(intern(ctx.getText()));
		setRangeByToken(identifier, ctx.getStart().getStartIndex());
		children.add(identifier);
	}

	@Override
	public void enterNumericLiteral(NumericLiteralContext ctx) {
		DecimalLiteral number = new DecimalLiteral(getParent());
		number.setText(intern(ctx.getText()));
		number.setStart(getTokenOffset(ctx.getStart().getTokenIndex()));
		number.setEnd(number.sourceStart() + number.getText().length());
		children.add(number);
	}
}
