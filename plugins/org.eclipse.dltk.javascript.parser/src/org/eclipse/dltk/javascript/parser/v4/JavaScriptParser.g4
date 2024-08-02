/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 by Bart Kiers (original author) and Alexandre Vitorelli (contributor -> ported to CSharp)
 * Copyright (c) 2017-2020 by Ivan Kochurkin (Positive Technologies):
    added ECMAScript 6 support, cleared and transformed to the universal grammar.
 * Copyright (c) 2018 by Juan Alvarez (contributor -> ported to Go)
 * Copyright (c) 2019 by Student Main (contributor -> ES2020)
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging

parser grammar JavaScriptParser;

// Insert here @header for C++ parser.

options {
    tokenVocab = JavaScriptLexer;
    superClass = JavaScriptParserBase;
}

program
    : HashBangLine? sourceElements? EOF
    ;

sourceElement
    : statement
    ;

statement
    : block
    | variableStatement
    | importStatement
    | exportStatement
    | emptyStatement_
    | classDeclaration
    | functionDeclaration
    | expressionStatement
    | ifStatement
    | iterationStatement
    | continueStatement
    | breakStatement
    | returnStatement
    | yieldStatement
    | withStatement
    | labelledStatement
    | switchStatement
    | throwStatement
    | tryStatement
    | debuggerStatement
    ;

block
    : '{' statementList? '}'
    ;

statementList
    : statement+
    ;

importStatement
    : Import importFromBlock
    ;

importFromBlock
    : importDefault? (importNamespace | importModuleItems) importFrom eos
    | StringLiteral eos
    ;

importModuleItems
    : '{' (importAliasName ',')* (importAliasName ','?)? '}'
    ;

importAliasName
    : moduleExportName (As importedBinding)?
    ;

moduleExportName
    : identifierName
    | StringLiteral
    ;

// yield and await are permitted as BindingIdentifier in the grammar
importedBinding
    : Identifier
    | Yield
    | Await
    ;

importDefault
    : aliasName ','
    ;

importNamespace
    : ('*' | identifierName) (As identifierName)?
    ;

importFrom
    : From StringLiteral
    ;

aliasName
    : identifierName (As identifierName)?
    ;

exportStatement
    : Export Default? (exportFromBlock | declaration) eos # ExportDeclaration
    | Export Default assignmentExpression eos             # ExportDefaultDeclaration
    ;

exportFromBlock
    : importNamespace importFrom eos
    | exportModuleItems importFrom? eos
    ;

exportModuleItems
    : '{' (exportAliasName ',')* (exportAliasName ','?)? '}'
    ;

exportAliasName
    : moduleExportName (As moduleExportName)?
    ;

declaration
    : variableStatement
    | classDeclaration
    | functionDeclaration
    ;

variableStatement
    : variableDeclarationList eos
    ;

variableDeclarationList
    : varModifier variableDeclaration (',' variableDeclaration)*
    ;

variableDeclaration
    : assignable ('=' assignmentExpression)? // ECMAScript 6: Array & Object Matching
    ;

emptyStatement_
    : SemiColon
    ;

expressionStatement
    : {this.notOpenBraceAndNotFunction()}? expressionSequence eos
    ;

ifStatement
    : If '(' expressionSequence ')' statement (Else statement)?
    ;

iterationStatement
    : Do statement While '(' expressionSequence ')' eos                                                                     # DoStatement
    | While '(' expressionSequence ')' statement                                                                            # WhileStatement
    | For '(' (expressionSequence | variableDeclarationList)? ';' expressionSequence? ';' expressionSequence? ')' statement # ForStatement
    | For '(' (leftHandSideExpression | variableDeclarationList) In expressionSequence ')' statement                        # ForInStatement
    | For Await? '(' (leftHandSideExpression | variableDeclarationList) Of expressionSequence ')' statement                 # ForOfStatement
    ;

varModifier // let, const - ECMAScript 6
    : Var
    | let_
    | Const
    ;

continueStatement
    : Continue ({this.notLineTerminator()}? identifier)? eos
    ;

breakStatement
    : Break ({this.notLineTerminator()}? identifier)? eos
    ;

returnStatement
    : Return ({this.notLineTerminator()}? expressionSequence)? eos
    ;

yieldStatement
    : (Yield | YieldStar) ({this.notLineTerminator()}? expressionSequence)? eos
    ;

withStatement
    : With '(' expressionSequence ')' statement
    ;

switchStatement
    : Switch '(' expressionSequence ')' caseBlock
    ;

caseBlock
    : '{' caseClauses? (defaultClause caseClauses?)? '}'
    ;

caseClauses
    : caseClause+
    ;

caseClause
    : Case expressionSequence ':' statementList?
    ;

defaultClause
    : Default ':' statementList?
    ;

labelledStatement
    : identifier ':' statement
    ;

throwStatement
    : Throw {this.notLineTerminator()}? expressionSequence eos
    ;

tryStatement
    : Try block (catchProduction finallyProduction? | finallyProduction)
    ;

catchProduction
    : Catch ('(' assignable? ')')? block
    ;

finallyProduction
    : Finally block
    ;

debuggerStatement
    : Debugger eos
    ;

functionDeclaration
    : Async? Function_ '*'? identifier '(' formalParameterList? ')' functionBody
    ;

classDeclaration
    : Class identifier classTail
    ;

classTail
    : (Extends assignmentExpression)? '{' classElement* '}'
    ;

classElement
    : (Static | {this.n("static")}? identifier)? methodDefinition
    | (Static | {this.n("static")}? identifier)? fieldDefinition
    | (Static | {this.n("static")}? identifier) block
    | emptyStatement_
    ;

methodDefinition
    : (Async {this.notLineTerminator()}?)? '*'? classElementName '(' formalParameterList? ')' functionBody
    | '*'? getter '(' ')' functionBody
    | '*'? setter '(' formalParameterList? ')' functionBody
    ;

fieldDefinition
    : classElementName initializer?
    ;

classElementName
    : propertyName
    | privateIdentifier
    ;

privateIdentifier
    : '#' identifierName
    ;

formalParameterList
    : formalParameterArg (',' formalParameterArg)* (',' lastFormalParameterArg)?
    | lastFormalParameterArg
    ;

formalParameterArg
    : assignable ('=' assignmentExpression)? // ECMAScript 6: Initialization
    ;

lastFormalParameterArg // ECMAScript 6: Rest Parameter
    : Ellipsis assignmentExpression
    ;

functionBody
    : '{' sourceElements? '}'
    ;

sourceElements
    : sourceElement+
    ;

arrayLiteral
    : ('[' elementList ']')
    ;

// JavaScript supports arrasys like [,,1,2,,].
elementList
    : ','* arrayElement? (','+ arrayElement) * ','* // Yes, everything is optional
    ;

arrayElement
    : Ellipsis? assignmentExpression
    ;

propertyAssignment
    : propertyName ':' assignmentExpression                                  # PropertyExpressionAssignment
    | '[' assignmentExpression ']' ':' assignmentExpression                  # ComputedPropertyExpressionAssignment
    | Async? '*'? propertyName '(' formalParameterList? ')' functionBody     # FunctionProperty
    | getter '(' ')' functionBody                                            # PropertyGetter
    | setter '(' formalParameterArg ')' functionBody                         # PropertySetter
    | Ellipsis? assignmentExpression                                         # PropertyShorthand
    ;

propertyName
    : identifierName
    | StringLiteral
    | numericLiteral
    | '[' assignmentExpression ']'
    ;

arguments
    : '(' (argument (',' argument)* ','?)? ')'
    ;

argument
    : Ellipsis? (assignmentExpression | identifier)
    ;

expressionSequence
    : assignmentExpression (',' assignmentExpression)*
    ;
    
memberExpression
    : primaryExpression memberExpressionSuffix*
    ;

memberExpressionSuffix
    : '?.' assignmentExpression                                # OptionalChainExpr
    | '[' expressionSequence ']'                               # MemberIndexExpr
    | '.' identifierName                                       # MemberDotExpr
    | templateStringLiteral                                    # TemplateStringExpression // ECMAScript 6  spec is primaryExpression - CHECK
    ;
    
primaryExpression
    : This                                                                             # ThisExpression
    | identifier                                                                       # IdentifierExpression
    | Super                                                                            # SuperExpression
    | literal                                                                          # LiteralExpression
    | arrayLiteral                                                                     # ArrayLiteralExpression
    | objectLiteral                                                                    # ObjectLiteralExpression
    | Async? Function_ '*'? identifier? '(' formalParameterList? ')' functionBody      # AsyncFunctionExpression
    | Class identifier? classTail                                                      # ClassExpression
//    | primaryExpression templateStringLiteral                                        # TemplateStringExpression // ECMAScript 6      TODO CHECK!
    | '(' expressionSequence ')'                                                       # ParenthesizedExpression
    ;

leftHandSideExpression
 // TODO optional chain??
//new
    : New memberExpression arguments                                # NewExpression
    | New memberExpression                                          # NewExpression
    | New '.' identifier                                            # MetaExpression // new.target
    | memberExpression                                              # MemberExpr
//call
    | leftHandSideExpression arguments                              # ArgumentsExpression
//optional 
    | leftHandSideExpression '?.' leftHandSideExpression            # OptionalChainExpression
    | leftHandSideExpression '?.'? '[' expressionSequence ']'       # MemberIndexExpression 
    | leftHandSideExpression '?'? '.' '#'? identifierName           # MemberDotExpression    
    ;
    
unaryExpression
    : leftHandSideExpression                                              # LHSExpr //TODO  PostfixExpr
    | leftHandSideExpression {this.notLineTerminator()}? '++'             # PostIncrementExpression
    | leftHandSideExpression {this.notLineTerminator()}? '--'             # PostDecreaseExpression
    | Delete unaryExpression                                              # DeleteExpression
    | Void unaryExpression                                                # VoidExpression
    | Typeof unaryExpression                                              # TypeofExpression
    | '++' unaryExpression                                                # PreIncrementExpression
    | '--' unaryExpression                                                # PreDecreaseExpression
    | '+' unaryExpression                                                 # UnaryPlusExpression
    | '-' unaryExpression                                                 # UnaryMinusExpression
    | '~' unaryExpression                                                 # BitNotExpression
    | '!' unaryExpression                                                 # NotExpression
    | Await unaryExpression                                               # AwaitExpression
    ;
    
binaryExpression
    : unaryExpression                                                     # UnaryExp
    | <assoc = right> binaryExpression '**' unaryExpression               # PowerExpression
    | binaryExpression ('*' | '/' | '%') unaryExpression                  # MultiplicativeExpression
    | binaryExpression ('+' | '-') unaryExpression                        # AdditiveExpression
    | binaryExpression '??' unaryExpression                               # CoalesceExpression
    | binaryExpression ('<<' | '>>' | '>>>') unaryExpression              # BitShiftExpression
    | binaryExpression ('<' | '>' | '<=' | '>=') unaryExpression          # RelationalExpression
    | binaryExpression Instanceof unaryExpression                         # InstanceofExpression
    | binaryExpression In unaryExpression                                 # InExpression
    | binaryExpression ('==' | '!=' | '===' | '!==') unaryExpression      # EqualityExpression
    | binaryExpression '&' unaryExpression                                # BitAndExpression
    | binaryExpression '^' unaryExpression                                # BitXOrExpression
    | binaryExpression '|' unaryExpression                                # BitOrExpression
    | binaryExpression '&&' unaryExpression                               # LogicalAndExpression
    | binaryExpression '||' unaryExpression                               # LogicalOrExpression
    ;

assignmentExpression
    : binaryExpression '?' assignmentExpression ':' assignmentExpression              # TernaryExpression
	| yieldStatement                                                                  # YieldExpression
    | Async? arrowFunctionParameters '=>' arrowFunctionBody                           # ArrowFunction
    | <assoc = right> leftHandSideExpression '=' assignmentExpression                 # AssignmentExpr
    | <assoc = right> leftHandSideExpression assignmentOperator assignmentExpression  # AssignmentOperatorExpression
    | binaryExpression                                                                # BinaryExpr
    | Import '(' assignmentExpression ')'                                             # ImportExpression
    ;

initializer
    : '=' assignmentExpression
    ;

assignable
    : identifier
    | keyword
    | arrayLiteral
    | objectLiteral
    ;

objectLiteral
    : '{' (propertyAssignment (',' propertyAssignment)* ','?)? '}'
    ;

arrowFunctionParameters
    : propertyName
    | '(' formalParameterList? ')'
    ;

arrowFunctionBody
    : assignmentExpression
    | functionBody
    ;

assignmentOperator
    : '*='
    | '/='
    | '%='
    | '+='
    | '-='
    | '<<='
    | '>>='
    | '>>>='
    | '&='
    | '^='
    | '|='
    | '**='
    | '??='
    ;

literal
    : NullLiteral
    | BooleanLiteral
    | StringLiteral
    | templateStringLiteral
    | RegularExpressionLiteral
    | numericLiteral
    | bigintLiteral
    ;

templateStringLiteral
    : BackTick templateStringAtom* BackTick
    ;

templateStringAtom
    : TemplateStringAtom
    | TemplateStringStartExpression assignmentExpression TemplateCloseBrace
    ;

numericLiteral
    : DecimalLiteral
    | HexIntegerLiteral
    | OctalIntegerLiteral
    | OctalIntegerLiteral2
    | BinaryIntegerLiteral
    ;

bigintLiteral
    : BigDecimalIntegerLiteral
    | BigHexIntegerLiteral
    | BigOctalIntegerLiteral
    | BigBinaryIntegerLiteral
    ;

getter
    : {this.n("get")}? identifier classElementName
    ;

setter
    : {this.n("set")}? identifier classElementName
    ;

identifierName
    : identifier
    | reservedWord
    ;

identifier
    : Identifier
    | NonStrictLet
    | Async
    | As
    | From
    | Yield
    | Of
    | Static
    | Implements
    | Interface
    | Package
    | Private
    | Public
    | Protected
    ;

reservedWord
    : keyword
    | NullLiteral
    | BooleanLiteral
    ;

keyword
    : Break
    | Do
    | Instanceof
    | Typeof
    | Case
    | Else
    | New
    | Var
    | Catch
    | Finally
    | Return
    | Void
    | Continue
    | For
    | Switch
    | While
    | Debugger
    | Function_
    | This
    | With
    | Default
    | If
    | Throw
    | Delete
    | In
    | Try
    | Class
    | Enum
    | Extends
    | Super
    | Const
    | Export
    | Import
    | Implements
    | let_
    | Private
    | Public
    | Interface
    | Package
    | Protected
    | Static
    | Yield
    | YieldStar    
    | Async
    | Await
    | From
    | As
    | Of
    ;

let_
    : NonStrictLet
    | StrictLet
    ;

eos
    : SemiColon
    | EOF
    | {this.lineTerminatorAhead()}?
    | {this.closeBrace()}?
    ;