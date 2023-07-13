package org.eclipse.dltk.javascript.parser.v4.factory;

import org.eclipse.dltk.javascript.ast.BreakStatement;
import org.eclipse.dltk.javascript.ast.ConstStatement;
import org.eclipse.dltk.javascript.ast.ContinueStatement;
import org.eclipse.dltk.javascript.ast.DoWhileStatement;
import org.eclipse.dltk.javascript.ast.EmptyStatement;
import org.eclipse.dltk.javascript.ast.ForInStatement;
import org.eclipse.dltk.javascript.ast.ForStatement;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.IfStatement;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.LabelledStatement;
import org.eclipse.dltk.javascript.ast.ReturnStatement;
import org.eclipse.dltk.javascript.ast.StatementBlock;
import org.eclipse.dltk.javascript.ast.SwitchStatement;
import org.eclipse.dltk.javascript.ast.ThrowStatement;
import org.eclipse.dltk.javascript.ast.TryStatement;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.ast.WhileStatement;
import org.eclipse.dltk.javascript.ast.WithStatement;
import org.eclipse.dltk.javascript.ast.v4.ForOfStatement;
import org.eclipse.dltk.javascript.ast.v4.LetStatement;
import org.eclipse.dltk.javascript.parser.v4.JSParser.DoStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ForInStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ForOfStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.ForStatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.StatementContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.VarModifierContext;
import org.eclipse.dltk.javascript.parser.v4.JSParser.WhileStatementContext;

public class StatementFactory extends JSNodeFactory<StatementContext> {

	private static final StatementFactory instance = new StatementFactory();
	
	private StatementFactory(){
	}
	
	public static StatementFactory getInstance() {
		return instance;
	}
	
	JSNode createJSNode(StatementContext ctx, JSNode parent) {
		if (ctx.block() != null) {
			return new StatementBlock(parent);
		}
		if (ctx.variableStatement() != null) {
			VarModifierContext modifier =  ctx.variableStatement().variableDeclarationList().varModifier();
			if (modifier.Var() != null) {
				return new VariableStatement(parent);
			}
			if (modifier.Const() != null) {
				return new ConstStatement(parent);
			}
			if (modifier.let_() != null) {
				return new LetStatement(parent);
			}
		}
		if (ctx.importStatement() != null) {
			//TODO es6
		}
		if (ctx.exportStatement() != null) {
			//TODO es6
		}
		if (ctx.ifStatement() != null) {
			return new IfStatement(parent);
		}
		if (ctx.iterationStatement() != null) {
			if (ctx.iterationStatement() instanceof WhileStatementContext) {
				return new WhileStatement(parent);
			}
			if (ctx.iterationStatement() instanceof DoStatementContext) {
				return new DoWhileStatement(parent);
			}
			if (ctx.iterationStatement() instanceof ForStatementContext) {
				return new ForStatement(parent);
			}
			if (ctx.iterationStatement() instanceof ForInStatementContext) {
				return new ForInStatement(parent);
			}
			if (ctx.iterationStatement() instanceof ForOfStatementContext) {
				return new ForOfStatement(parent);
			}
		}
		if (ctx.functionDeclaration() != null) {
			return new FunctionStatement(parent, true);
		}
		if (ctx.labelledStatement() != null) {
			return new LabelledStatement(parent);
		}
		if (ctx.continueStatement() != null) {
			return new ContinueStatement(parent);
		}
		if (ctx.returnStatement() != null) {
			return new ReturnStatement(parent);
		}
		if (ctx.breakStatement() != null) {
			return new BreakStatement(parent);
		}
		if (ctx.throwStatement() != null) {
			return new ThrowStatement(parent);
		}
		if (ctx.tryStatement() != null) {
			return new TryStatement(parent);
		}
		if (ctx.switchStatement() != null) {
			return new SwitchStatement(parent);
		}
		if (ctx.emptyStatement_() != null) {
			return new EmptyStatement(parent);
		}
		if (ctx.withStatement() != null) {
			return new WithStatement(parent);
		}
		throw new UnsupportedOperationException("Cannot create JS node from "+ctx.getClass().getCanonicalName());
	}

	@Override
	boolean skip(StatementContext ctx) {
		return ctx.expressionStatement() != null;
	}
}
