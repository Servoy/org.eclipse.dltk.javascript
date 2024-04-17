package org.eclipse.dltk.javascript.parser.v4;

// Generated from JavaScriptParser.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JSParser}.
 */
public interface JavaScriptParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JSParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(JSParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(JSParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#sourceElement}.
	 * @param ctx the parse tree
	 */
	void enterSourceElement(JSParser.SourceElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#sourceElement}.
	 * @param ctx the parse tree
	 */
	void exitSourceElement(JSParser.SourceElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JSParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JSParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JSParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JSParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(JSParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(JSParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(JSParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(JSParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#importFromBlock}.
	 * @param ctx the parse tree
	 */
	void enterImportFromBlock(JSParser.ImportFromBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#importFromBlock}.
	 * @param ctx the parse tree
	 */
	void exitImportFromBlock(JSParser.ImportFromBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#importModuleItems}.
	 * @param ctx the parse tree
	 */
	void enterImportModuleItems(JSParser.ImportModuleItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#importModuleItems}.
	 * @param ctx the parse tree
	 */
	void exitImportModuleItems(JSParser.ImportModuleItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#importAliasName}.
	 * @param ctx the parse tree
	 */
	void enterImportAliasName(JSParser.ImportAliasNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#importAliasName}.
	 * @param ctx the parse tree
	 */
	void exitImportAliasName(JSParser.ImportAliasNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#moduleExportName}.
	 * @param ctx the parse tree
	 */
	void enterModuleExportName(JSParser.ModuleExportNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#moduleExportName}.
	 * @param ctx the parse tree
	 */
	void exitModuleExportName(JSParser.ModuleExportNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#importedBinding}.
	 * @param ctx the parse tree
	 */
	void enterImportedBinding(JSParser.ImportedBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#importedBinding}.
	 * @param ctx the parse tree
	 */
	void exitImportedBinding(JSParser.ImportedBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#importDefault}.
	 * @param ctx the parse tree
	 */
	void enterImportDefault(JSParser.ImportDefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#importDefault}.
	 * @param ctx the parse tree
	 */
	void exitImportDefault(JSParser.ImportDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#importNamespace}.
	 * @param ctx the parse tree
	 */
	void enterImportNamespace(JSParser.ImportNamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#importNamespace}.
	 * @param ctx the parse tree
	 */
	void exitImportNamespace(JSParser.ImportNamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#importFrom}.
	 * @param ctx the parse tree
	 */
	void enterImportFrom(JSParser.ImportFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#importFrom}.
	 * @param ctx the parse tree
	 */
	void exitImportFrom(JSParser.ImportFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#aliasName}.
	 * @param ctx the parse tree
	 */
	void enterAliasName(JSParser.AliasNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#aliasName}.
	 * @param ctx the parse tree
	 */
	void exitAliasName(JSParser.AliasNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExportDeclaration}
	 * labeled alternative in {@link JSParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void enterExportDeclaration(JSParser.ExportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExportDeclaration}
	 * labeled alternative in {@link JSParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void exitExportDeclaration(JSParser.ExportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExportDefaultDeclaration}
	 * labeled alternative in {@link JSParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void enterExportDefaultDeclaration(JSParser.ExportDefaultDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExportDefaultDeclaration}
	 * labeled alternative in {@link JSParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void exitExportDefaultDeclaration(JSParser.ExportDefaultDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#exportFromBlock}.
	 * @param ctx the parse tree
	 */
	void enterExportFromBlock(JSParser.ExportFromBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#exportFromBlock}.
	 * @param ctx the parse tree
	 */
	void exitExportFromBlock(JSParser.ExportFromBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#exportModuleItems}.
	 * @param ctx the parse tree
	 */
	void enterExportModuleItems(JSParser.ExportModuleItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#exportModuleItems}.
	 * @param ctx the parse tree
	 */
	void exitExportModuleItems(JSParser.ExportModuleItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#exportAliasName}.
	 * @param ctx the parse tree
	 */
	void enterExportAliasName(JSParser.ExportAliasNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#exportAliasName}.
	 * @param ctx the parse tree
	 */
	void exitExportAliasName(JSParser.ExportAliasNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(JSParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(JSParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableStatement(JSParser.VariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableStatement(JSParser.VariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationList(JSParser.VariableDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationList(JSParser.VariableDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(JSParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(JSParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement_(JSParser.EmptyStatement_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement_(JSParser.EmptyStatement_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(JSParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(JSParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(JSParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(JSParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(JSParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(JSParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(JSParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(JSParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(JSParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(JSParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInStatement(JSParser.ForInStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInStatement(JSParser.ForInStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForOfStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForOfStatement(JSParser.ForOfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForOfStatement}
	 * labeled alternative in {@link JSParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForOfStatement(JSParser.ForOfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#varModifier}.
	 * @param ctx the parse tree
	 */
	void enterVarModifier(JSParser.VarModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#varModifier}.
	 * @param ctx the parse tree
	 */
	void exitVarModifier(JSParser.VarModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(JSParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(JSParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(JSParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(JSParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(JSParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(JSParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void enterYieldStatement(JSParser.YieldStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void exitYieldStatement(JSParser.YieldStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(JSParser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(JSParser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(JSParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(JSParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(JSParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(JSParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#caseClauses}.
	 * @param ctx the parse tree
	 */
	void enterCaseClauses(JSParser.CaseClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#caseClauses}.
	 * @param ctx the parse tree
	 */
	void exitCaseClauses(JSParser.CaseClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void enterCaseClause(JSParser.CaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void exitCaseClause(JSParser.CaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void enterDefaultClause(JSParser.DefaultClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void exitDefaultClause(JSParser.DefaultClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabelledStatement(JSParser.LabelledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabelledStatement(JSParser.LabelledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(JSParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(JSParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(JSParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(JSParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#catchProduction}.
	 * @param ctx the parse tree
	 */
	void enterCatchProduction(JSParser.CatchProductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#catchProduction}.
	 * @param ctx the parse tree
	 */
	void exitCatchProduction(JSParser.CatchProductionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#finallyProduction}.
	 * @param ctx the parse tree
	 */
	void enterFinallyProduction(JSParser.FinallyProductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#finallyProduction}.
	 * @param ctx the parse tree
	 */
	void exitFinallyProduction(JSParser.FinallyProductionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void enterDebuggerStatement(JSParser.DebuggerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void exitDebuggerStatement(JSParser.DebuggerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(JSParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(JSParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(JSParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(JSParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#classTail}.
	 * @param ctx the parse tree
	 */
	void enterClassTail(JSParser.ClassTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#classTail}.
	 * @param ctx the parse tree
	 */
	void exitClassTail(JSParser.ClassTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#classElement}.
	 * @param ctx the parse tree
	 */
	void enterClassElement(JSParser.ClassElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#classElement}.
	 * @param ctx the parse tree
	 */
	void exitClassElement(JSParser.ClassElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMethodDefinition(JSParser.MethodDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMethodDefinition(JSParser.MethodDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#fieldDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFieldDefinition(JSParser.FieldDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#fieldDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFieldDefinition(JSParser.FieldDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#classElementName}.
	 * @param ctx the parse tree
	 */
	void enterClassElementName(JSParser.ClassElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#classElementName}.
	 * @param ctx the parse tree
	 */
	void exitClassElementName(JSParser.ClassElementNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#privateIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterPrivateIdentifier(JSParser.PrivateIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#privateIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitPrivateIdentifier(JSParser.PrivateIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(JSParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(JSParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#formalParameterArg}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterArg(JSParser.FormalParameterArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#formalParameterArg}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterArg(JSParser.FormalParameterArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#lastFormalParameterArg}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameterArg(JSParser.LastFormalParameterArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#lastFormalParameterArg}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameterArg(JSParser.LastFormalParameterArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(JSParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(JSParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#sourceElements}.
	 * @param ctx the parse tree
	 */
	void enterSourceElements(JSParser.SourceElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#sourceElements}.
	 * @param ctx the parse tree
	 */
	void exitSourceElements(JSParser.SourceElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(JSParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(JSParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#elementList}.
	 * @param ctx the parse tree
	 */
	void enterElementList(JSParser.ElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#elementList}.
	 * @param ctx the parse tree
	 */
	void exitElementList(JSParser.ElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void enterArrayElement(JSParser.ArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void exitArrayElement(JSParser.ArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertyExpressionAssignment}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropertyExpressionAssignment(JSParser.PropertyExpressionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertyExpressionAssignment}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropertyExpressionAssignment(JSParser.PropertyExpressionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComputedPropertyExpressionAssignment}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterComputedPropertyExpressionAssignment(JSParser.ComputedPropertyExpressionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComputedPropertyExpressionAssignment}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitComputedPropertyExpressionAssignment(JSParser.ComputedPropertyExpressionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionProperty}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterFunctionProperty(JSParser.FunctionPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionProperty}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitFunctionProperty(JSParser.FunctionPropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertyGetter}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropertyGetter(JSParser.PropertyGetterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertyGetter}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropertyGetter(JSParser.PropertyGetterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertySetter}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropertySetter(JSParser.PropertySetterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertySetter}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropertySetter(JSParser.PropertySetterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertyShorthand}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropertyShorthand(JSParser.PropertyShorthandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertyShorthand}
	 * labeled alternative in {@link JSParser#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropertyShorthand(JSParser.PropertyShorthandContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#propertyName}.
	 * @param ctx the parse tree
	 */
	void enterPropertyName(JSParser.PropertyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#propertyName}.
	 * @param ctx the parse tree
	 */
	void exitPropertyName(JSParser.PropertyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(JSParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(JSParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(JSParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(JSParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(JSParser.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(JSParser.ExpressionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#memberExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpression(JSParser.MemberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#memberExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpression(JSParser.MemberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TemplateStringExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterTemplateStringExpression(JSParser.TemplateStringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TemplateStringExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitTemplateStringExpression(JSParser.TemplateStringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(JSParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(JSParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(JSParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(JSParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PowerExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(JSParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PowerExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(JSParser.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(JSParser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(JSParser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectLiteralExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteralExpression(JSParser.ObjectLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectLiteralExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteralExpression(JSParser.ObjectLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MetaExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMetaExpression(JSParser.MetaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MetaExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMetaExpression(JSParser.MetaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(JSParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(JSParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(JSParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(JSParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OptionalChainExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterOptionalChainExpression(JSParser.OptionalChainExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OptionalChainExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitOptionalChainExpression(JSParser.OptionalChainExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(JSParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(JSParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecreaseExpression(JSParser.PreDecreaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecreaseExpression(JSParser.PreDecreaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentsExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsExpression(JSParser.ArgumentsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentsExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsExpression(JSParser.ArgumentsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AwaitExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterAwaitExpression(JSParser.AwaitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AwaitExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitAwaitExpression(JSParser.AwaitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ThisExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpression(JSParser.ThisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ThisExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpression(JSParser.ThisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(JSParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(JSParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(JSParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(JSParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(JSParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(JSParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostDecreaseExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecreaseExpression(JSParser.PostDecreaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostDecreaseExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecreaseExpression(JSParser.PostDecreaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeofExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterTypeofExpression(JSParser.TypeofExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeofExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitTypeofExpression(JSParser.TypeofExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstanceofExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterInstanceofExpression(JSParser.InstanceofExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstanceofExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitInstanceofExpression(JSParser.InstanceofExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryPlusExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPlusExpression(JSParser.UnaryPlusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryPlusExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPlusExpression(JSParser.UnaryPlusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeleteExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterDeleteExpression(JSParser.DeleteExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeleteExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitDeleteExpression(JSParser.DeleteExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterImportExpression(JSParser.ImportExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitImportExpression(JSParser.ImportExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(JSParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(JSParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitXOrExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitXOrExpression(JSParser.BitXOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitXOrExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitXOrExpression(JSParser.BitXOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuperExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSuperExpression(JSParser.SuperExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuperExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSuperExpression(JSParser.SuperExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(JSParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(JSParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitShiftExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitShiftExpression(JSParser.BitShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitShiftExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitShiftExpression(JSParser.BitShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(JSParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(JSParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(JSParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(JSParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(JSParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(JSParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostIncrementExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(JSParser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostIncrementExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(JSParser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code YieldExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterYieldExpression(JSParser.YieldExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code YieldExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitYieldExpression(JSParser.YieldExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitNotExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitNotExpression(JSParser.BitNotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitNotExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitNotExpression(JSParser.BitNotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(JSParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(JSParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(JSParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(JSParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayLiteralExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralExpression(JSParser.ArrayLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayLiteralExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralExpression(JSParser.ArrayLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberDotExpression(JSParser.MemberDotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberDotExpression(JSParser.MemberDotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassExpression(JSParser.ClassExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassExpression(JSParser.ClassExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberIndexExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberIndexExpression(JSParser.MemberIndexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberIndexExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberIndexExpression(JSParser.MemberIndexExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(JSParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(JSParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitAndExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitAndExpression(JSParser.BitAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitAndExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitAndExpression(JSParser.BitAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitOrExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitOrExpression(JSParser.BitOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitOrExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitOrExpression(JSParser.BitOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentOperatorExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperatorExpression(JSParser.AssignmentOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentOperatorExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperatorExpression(JSParser.AssignmentOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterVoidExpression(JSParser.VoidExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitVoidExpression(JSParser.VoidExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CoalesceExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterCoalesceExpression(JSParser.CoalesceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CoalesceExpression}
	 * labeled alternative in {@link JSParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitCoalesceExpression(JSParser.CoalesceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(JSParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(JSParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(JSParser.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(JSParser.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(JSParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(JSParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NamedFunction}
	 * labeled alternative in {@link JSParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterNamedFunction(JSParser.NamedFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NamedFunction}
	 * labeled alternative in {@link JSParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitNamedFunction(JSParser.NamedFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnonymousFunctionDecl}
	 * labeled alternative in {@link JSParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousFunctionDecl(JSParser.AnonymousFunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnonymousFunctionDecl}
	 * labeled alternative in {@link JSParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousFunctionDecl(JSParser.AnonymousFunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrowFunction}
	 * labeled alternative in {@link JSParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunction(JSParser.ArrowFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrowFunction}
	 * labeled alternative in {@link JSParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunction(JSParser.ArrowFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#arrowFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunctionParameters(JSParser.ArrowFunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#arrowFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunctionParameters(JSParser.ArrowFunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#arrowFunctionBody}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunctionBody(JSParser.ArrowFunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#arrowFunctionBody}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunctionBody(JSParser.ArrowFunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(JSParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(JSParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JSParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JSParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#templateStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTemplateStringLiteral(JSParser.TemplateStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#templateStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTemplateStringLiteral(JSParser.TemplateStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#templateStringAtom}.
	 * @param ctx the parse tree
	 */
	void enterTemplateStringAtom(JSParser.TemplateStringAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#templateStringAtom}.
	 * @param ctx the parse tree
	 */
	void exitTemplateStringAtom(JSParser.TemplateStringAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(JSParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(JSParser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#bigintLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBigintLiteral(JSParser.BigintLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#bigintLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBigintLiteral(JSParser.BigintLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#getter}.
	 * @param ctx the parse tree
	 */
	void enterGetter(JSParser.GetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#getter}.
	 * @param ctx the parse tree
	 */
	void exitGetter(JSParser.GetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#setter}.
	 * @param ctx the parse tree
	 */
	void enterSetter(JSParser.SetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#setter}.
	 * @param ctx the parse tree
	 */
	void exitSetter(JSParser.SetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#identifierName}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierName(JSParser.IdentifierNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#identifierName}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierName(JSParser.IdentifierNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JSParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JSParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#reservedWord}.
	 * @param ctx the parse tree
	 */
	void enterReservedWord(JSParser.ReservedWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#reservedWord}.
	 * @param ctx the parse tree
	 */
	void exitReservedWord(JSParser.ReservedWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(JSParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(JSParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#let_}.
	 * @param ctx the parse tree
	 */
	void enterLet_(JSParser.Let_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#let_}.
	 * @param ctx the parse tree
	 */
	void exitLet_(JSParser.Let_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JSParser#eos}.
	 * @param ctx the parse tree
	 */
	void enterEos(JSParser.EosContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSParser#eos}.
	 * @param ctx the parse tree
	 */
	void exitEos(JSParser.EosContext ctx);
}