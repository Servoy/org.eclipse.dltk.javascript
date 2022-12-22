package org.eclipse.dltk.javascript.parser;

// $ANTLR 3.0.1 /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g 2009-04-09 16:22:10

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeParser;

/**
 * @since 6.0
 */
public class JSWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NULL", "TRUE", "FALSE", "BREAK", "CASE", "CATCH", "CONTINUE", "DEFAULT", "DELETE", "DO", "ELSE", "FINALLY", "FOR", "EACH", "FUNCTION", "IF", "IN", "INSTANCEOF", "NEW", "RETURN", "SWITCH", "THIS", "THROW", "TRY", "TYPEOF", "VAR", "VOID", "WHILE", "WITH", "GET", "SET", "ABSTRACT", "BOOLEAN", "BYTE", "CHAR", "CLASS", "CONST", "DEBUGGER", "DOUBLE", "ENUM", "EXPORT", "EXTENDS", "FINAL", "FLOAT", "GOTO", "IMPLEMENTS", "IMPORT", "INT", "INTERFACE", "LONG", "NATIVE", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "SHORT", "STATIC", "SUPER", "SYNCHRONIZED", "THROWS", "TRANSIENT", "VOLATILE", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "DOT", "SEMIC", "COMMA", "LT", "GT", "LTE", "GTE", "EQ", "NEQ", "SAME", "NSAME", "ADD", "SUB", "MUL", "MOD", "INC", "DEC", "SHL", "SHR", "SHU", "AND", "OR", "XOR", "NOT", "INV", "LAND", "LOR", "QUE", "COLON", "ASSIGN", "ADDASS", "SUBASS", "MULASS", "MODASS", "SHLASS", "SHRASS", "SHUASS", "ANDASS", "ORASS", "XORASS", "DIV", "DIVASS", "ARGS", "ARRAY", "BLOCK", "BYFIELD", "BYINDEX", "CALL", "CEXPR", "EXPR", "FORITER", "FORSTEP", "ITEM", "LABELLED", "NAMEDVALUE", "NEG", "OBJECT", "PAREXPR", "PDEC", "PINC", "POS", "BSLASH", "DQUOTE", "SQUOTE", "TAB", "VT", "FF", "SP", "NBSP", "USP", "WhiteSpace", "LF", "CR", "LS", "PS", "LineTerminator", "EOL", "MultiLineComment", "SingleLineComment", "Identifier", "StringLiteral", "HexDigit", "IdentifierStartASCII", "DecimalDigit", "IdentifierPart", "IdentifierNameASCIIStart", "RegularExpressionLiteral", "OctalDigit", "ExponentPart", "DecimalIntegerLiteral", "DecimalLiteral", "OctalIntegerLiteral", "HexIntegerLiteral", "CharacterEscapeSequence", "ZeroToThree", "OctalEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "EscapeSequence", "BackslashSequence", "RegularExpressionFirstChar", "RegularExpressionChar"
    };
    public static final int PACKAGE=55;
    public static final int FUNCTION=18;
    public static final int LOR=98;
    public static final int VT=137;
    public static final int SHR=90;
    public static final int RegularExpressionChar=173;
    public static final int LT=75;
    public static final int WHILE=31;
    public static final int MOD=86;
    public static final int SHL=89;
    public static final int CONST=40;
    public static final int BackslashSequence=171;
    public static final int LS=145;
    public static final int CASE=8;
    public static final int CHAR=38;
    public static final int NEW=22;
    public static final int DO=13;
    public static final int DQUOTE=134;
    public static final int NOT=95;
    public static final int DecimalDigit=155;
    public static final int BYFIELD=117;
    public static final int EOF=-1;
    public static final int BREAK=7;
    public static final int CEXPR=120;
    public static final int DIVASS=113;
    public static final int Identifier=151;
    public static final int BYINDEX=118;
    public static final int INC=87;
    public static final int RPAREN=69;
    public static final int FINAL=46;
    public static final int FORSTEP=123;
    public static final int IMPORT=50;
    public static final int EOL=148;
    public static final int POS=132;
    public static final int OctalDigit=159;
    public static final int RETURN=23;
    public static final int THIS=25;
    public static final int DOUBLE=42;
    public static final int ARGS=114;
    public static final int ExponentPart=160;
    public static final int GET=33;
    public static final int WhiteSpace=142;
    public static final int VAR=29;
    public static final int VOID=30;
    public static final int EXPORT=44;
    public static final int LABELLED=125;
    public static final int EACH=17;
    public static final int SUPER=61;
    public static final int GOTO=48;
    public static final int EQ=79;
    public static final int XORASS=111;
    public static final int ADDASS=102;
    public static final int ARRAY=115;
    public static final int SHU=91;
    public static final int RBRACK=71;
    public static final int RBRACE=67;
    public static final int PRIVATE=56;
    public static final int STATIC=60;
    public static final int INV=96;
    public static final int SWITCH=24;
    public static final int NULL=4;
    public static final int ELSE=14;
    public static final int NATIVE=54;
    public static final int THROWS=63;
    public static final int INT=51;
    public static final int DELETE=12;
    public static final int MUL=85;
    public static final int IdentifierStartASCII=154;
    public static final int TRY=27;
    public static final int FF=138;
    public static final int SHLASS=106;
    public static final int OctalEscapeSequence=167;
    public static final int USP=141;
    public static final int RegularExpressionFirstChar=172;
    public static final int ANDASS=109;
    public static final int TYPEOF=28;
    public static final int IdentifierNameASCIIStart=157;
    public static final int QUE=99;
    public static final int OR=93;
    public static final int DEBUGGER=41;
    public static final int GT=76;
    public static final int PDEC=130;
    public static final int CALL=119;
    public static final int CharacterEscapeSequence=165;
    public static final int CATCH=9;
    public static final int FALSE=6;
    public static final int EscapeSequence=170;
    public static final int LAND=97;
    public static final int THROW=26;
    public static final int MULASS=104;
    public static final int PINC=131;
    public static final int DEC=88;
    public static final int PROTECTED=57;
    public static final int OctalIntegerLiteral=163;
    public static final int CLASS=39;
    public static final int LBRACK=70;
    public static final int ORASS=110;
    public static final int HexEscapeSequence=168;
    public static final int NAMEDVALUE=126;
    public static final int SingleLineComment=150;
    public static final int GTE=78;
    public static final int LBRACE=66;
    public static final int FOR=16;
    public static final int SUB=84;
    public static final int RegularExpressionLiteral=158;
    public static final int FLOAT=47;
    public static final int ABSTRACT=35;
    public static final int AND=92;
    public static final int DecimalIntegerLiteral=161;
    public static final int LTE=77;
    public static final int HexDigit=153;
    public static final int LPAREN=68;
    public static final int IF=19;
    public static final int SUBASS=103;
    public static final int SYNCHRONIZED=62;
    public static final int BOOLEAN=36;
    public static final int EXPR=121;
    public static final int IN=20;
    public static final int IMPLEMENTS=49;
    public static final int CONTINUE=10;
    public static final int OBJECT=128;
    public static final int COMMA=74;
    public static final int TRANSIENT=64;
    public static final int FORITER=122;
    public static final int MODASS=105;
    public static final int SHRASS=107;
    public static final int PS=146;
    public static final int DOT=72;
    public static final int MultiLineComment=149;
    public static final int IdentifierPart=156;
    public static final int WITH=32;
    public static final int ADD=83;
    public static final int BYTE=37;
    public static final int XOR=94;
    public static final int ZeroToThree=166;
    public static final int VOLATILE=65;
    public static final int ITEM=124;
    public static final int UnicodeEscapeSequence=169;
    public static final int NSAME=82;
    public static final int DEFAULT=11;
    public static final int SHUASS=108;
    public static final int TAB=136;
    public static final int SHORT=59;
    public static final int SET=34;
    public static final int INSTANCEOF=21;
    public static final int SQUOTE=135;
    public static final int DecimalLiteral=162;
    public static final int TRUE=5;
    public static final int SAME=81;
    public static final int COLON=100;
    public static final int StringLiteral=152;
    public static final int NEQ=80;
    public static final int PAREXPR=129;
    public static final int ENUM=43;
    public static final int FINALLY=15;
    public static final int NBSP=140;
    public static final int HexIntegerLiteral=164;
    public static final int SP=139;
    public static final int BLOCK=116;
    public static final int NEG=127;
    public static final int LineTerminator=147;
    public static final int ASSIGN=101;
    public static final int INTERFACE=52;
    public static final int DIV=112;
    public static final int SEMIC=73;
    public static final int LONG=53;
    public static final int CR=144;
    public static final int PUBLIC=58;
    public static final int EXTENDS=45;
    public static final int BSLASH=133;
    public static final int LF=143;

        public JSWalker(TreeNodeStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g"; }



    // $ANTLR start program
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:21:1: program : ( statement )* ;
    public final void program() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:22:2: ( ( statement )* )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:22:4: ( statement )*
            {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:22:4: ( statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=NULL && LA1_0<=BREAK)||LA1_0==CONTINUE||(LA1_0>=DELETE && LA1_0<=DO)||LA1_0==FOR||(LA1_0>=FUNCTION && LA1_0<=WITH)||(LA1_0>=LT && LA1_0<=QUE)||(LA1_0>=ASSIGN && LA1_0<=DIVASS)||(LA1_0>=ARRAY && LA1_0<=CEXPR)||LA1_0==LABELLED||(LA1_0>=NEG && LA1_0<=OBJECT)||(LA1_0>=PDEC && LA1_0<=POS)||(LA1_0>=Identifier && LA1_0<=StringLiteral)||LA1_0==RegularExpressionLiteral||(LA1_0>=DecimalLiteral && LA1_0<=HexIntegerLiteral)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:22:4: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program57);
            	    statement();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end program


    // $ANTLR start statement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:25:1: statement : ( block | variableDeclaration | expression | ifStatement | doStatement | whileStatement | forStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement );
    public final void statement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:26:2: ( block | variableDeclaration | expression | ifStatement | doStatement | whileStatement | forStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement )
            int alt2=15;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt2=1;
                }
                break;
            case VAR:
                {
                alt2=2;
                }
                break;
            case NULL:
            case TRUE:
            case FALSE:
            case DELETE:
            case FUNCTION:
            case IN:
            case INSTANCEOF:
            case NEW:
            case THIS:
            case TYPEOF:
            case VOID:
            case LT:
            case GT:
            case LTE:
            case GTE:
            case EQ:
            case NEQ:
            case SAME:
            case NSAME:
            case ADD:
            case SUB:
            case MUL:
            case MOD:
            case INC:
            case DEC:
            case SHL:
            case SHR:
            case SHU:
            case AND:
            case OR:
            case XOR:
            case NOT:
            case INV:
            case LAND:
            case LOR:
            case QUE:
            case ASSIGN:
            case ADDASS:
            case SUBASS:
            case MULASS:
            case MODASS:
            case SHLASS:
            case SHRASS:
            case SHUASS:
            case ANDASS:
            case ORASS:
            case XORASS:
            case DIV:
            case DIVASS:
            case ARRAY:
            case BYFIELD:
            case BYINDEX:
            case CALL:
            case CEXPR:
            case NEG:
            case OBJECT:
            case PDEC:
            case PINC:
            case POS:
            case Identifier:
            case StringLiteral:
            case RegularExpressionLiteral:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt2=3;
                }
                break;
            case IF:
                {
                alt2=4;
                }
                break;
            case DO:
                {
                alt2=5;
                }
                break;
            case WHILE:
                {
                alt2=6;
                }
                break;
            case FOR:
                {
                alt2=7;
                }
                break;
            case CONTINUE:
                {
                alt2=8;
                }
                break;
            case BREAK:
                {
                alt2=9;
                }
                break;
            case RETURN:
                {
                alt2=10;
                }
                break;
            case WITH:
                {
                alt2=11;
                }
                break;
            case LABELLED:
                {
                alt2=12;
                }
                break;
            case SWITCH:
                {
                alt2=13;
                }
                break;
            case THROW:
                {
                alt2=14;
                }
                break;
            case TRY:
                {
                alt2=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("25:1: statement : ( block | variableDeclaration | expression | ifStatement | doStatement | whileStatement | forStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:26:4: block
                    {
                    pushFollow(FOLLOW_block_in_statement69);
                    block();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:27:4: variableDeclaration
                    {
                    pushFollow(FOLLOW_variableDeclaration_in_statement74);
                    variableDeclaration();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:28:4: expression
                    {
                    pushFollow(FOLLOW_expression_in_statement79);
                    expression();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:29:4: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement84);
                    ifStatement();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:30:4: doStatement
                    {
                    pushFollow(FOLLOW_doStatement_in_statement89);
                    doStatement();
                    _fsp--;


                    }
                    break;
                case 6 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:31:4: whileStatement
                    {
                    pushFollow(FOLLOW_whileStatement_in_statement94);
                    whileStatement();
                    _fsp--;


                    }
                    break;
                case 7 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:32:4: forStatement
                    {
                    pushFollow(FOLLOW_forStatement_in_statement99);
                    forStatement();
                    _fsp--;


                    }
                    break;
                case 8 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:33:4: continueStatement
                    {
                    pushFollow(FOLLOW_continueStatement_in_statement104);
                    continueStatement();
                    _fsp--;


                    }
                    break;
                case 9 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:34:4: breakStatement
                    {
                    pushFollow(FOLLOW_breakStatement_in_statement109);
                    breakStatement();
                    _fsp--;


                    }
                    break;
                case 10 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:35:4: returnStatement
                    {
                    pushFollow(FOLLOW_returnStatement_in_statement114);
                    returnStatement();
                    _fsp--;


                    }
                    break;
                case 11 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:36:4: withStatement
                    {
                    pushFollow(FOLLOW_withStatement_in_statement119);
                    withStatement();
                    _fsp--;


                    }
                    break;
                case 12 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:37:4: labelledStatement
                    {
                    pushFollow(FOLLOW_labelledStatement_in_statement124);
                    labelledStatement();
                    _fsp--;


                    }
                    break;
                case 13 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:38:4: switchStatement
                    {
                    pushFollow(FOLLOW_switchStatement_in_statement129);
                    switchStatement();
                    _fsp--;


                    }
                    break;
                case 14 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:39:4: throwStatement
                    {
                    pushFollow(FOLLOW_throwStatement_in_statement134);
                    throwStatement();
                    _fsp--;


                    }
                    break;
                case 15 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:40:4: tryStatement
                    {
                    pushFollow(FOLLOW_tryStatement_in_statement139);
                    tryStatement();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end statement


    // $ANTLR start block
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:43:1: block : ^( BLOCK ( statement )* ) ;
    public final void block() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:44:2: ( ^( BLOCK ( statement )* ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:44:4: ^( BLOCK ( statement )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block152); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:44:13: ( statement )*
                loop3:
                do {
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=NULL && LA3_0<=BREAK)||LA3_0==CONTINUE||(LA3_0>=DELETE && LA3_0<=DO)||LA3_0==FOR||(LA3_0>=FUNCTION && LA3_0<=WITH)||(LA3_0>=LT && LA3_0<=QUE)||(LA3_0>=ASSIGN && LA3_0<=DIVASS)||(LA3_0>=ARRAY && LA3_0<=CEXPR)||LA3_0==LABELLED||(LA3_0>=NEG && LA3_0<=OBJECT)||(LA3_0>=PDEC && LA3_0<=POS)||(LA3_0>=Identifier && LA3_0<=StringLiteral)||LA3_0==RegularExpressionLiteral||(LA3_0>=DecimalLiteral && LA3_0<=HexIntegerLiteral)) ) {
                        alt3=1;
                    }


                    switch (alt3) {
                	case 1 :
                	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:44:13: statement
                	    {
                	    pushFollow(FOLLOW_statement_in_block154);
                	    statement();
                	    _fsp--;


                	    }
                	    break;

                	default :
                	    break loop3;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end block


    // $ANTLR start variableDeclaration
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:47:1: variableDeclaration : ^( VAR ( Identifier | ^( ASSIGN Identifier expr ) )+ ) ;
    public final void variableDeclaration() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:48:2: ( ^( VAR ( Identifier | ^( ASSIGN Identifier expr ) )+ ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:48:4: ^( VAR ( Identifier | ^( ASSIGN Identifier expr ) )+ )
            {
            match(input,VAR,FOLLOW_VAR_in_variableDeclaration170); 

            match(input, Token.DOWN, null); 
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:48:11: ( Identifier | ^( ASSIGN Identifier expr ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Identifier) ) {
                    alt4=1;
                }
                else if ( (LA4_0==ASSIGN) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:48:13: Identifier
            	    {
            	    match(input,Identifier,FOLLOW_Identifier_in_variableDeclaration174); 

            	    }
            	    break;
            	case 2 :
            	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:48:26: ^( ASSIGN Identifier expr )
            	    {
            	    match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclaration180); 

            	    match(input, Token.DOWN, null); 
            	    match(input,Identifier,FOLLOW_Identifier_in_variableDeclaration182); 
            	    pushFollow(FOLLOW_expr_in_variableDeclaration184);
            	    expr();
            	    _fsp--;


            	    match(input, Token.UP, null); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end variableDeclaration


    // $ANTLR start ifStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:51:1: ifStatement : ^( IF expression ( statement )+ ) ;
    public final void ifStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:52:2: ( ^( IF expression ( statement )+ ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:52:4: ^( IF expression ( statement )+ )
            {
            match(input,IF,FOLLOW_IF_in_ifStatement204); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_ifStatement206);
            expression();
            _fsp--;

            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:52:21: ( statement )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=NULL && LA5_0<=BREAK)||LA5_0==CONTINUE||(LA5_0>=DELETE && LA5_0<=DO)||LA5_0==FOR||(LA5_0>=FUNCTION && LA5_0<=WITH)||(LA5_0>=LT && LA5_0<=QUE)||(LA5_0>=ASSIGN && LA5_0<=DIVASS)||(LA5_0>=ARRAY && LA5_0<=CEXPR)||LA5_0==LABELLED||(LA5_0>=NEG && LA5_0<=OBJECT)||(LA5_0>=PDEC && LA5_0<=POS)||(LA5_0>=Identifier && LA5_0<=StringLiteral)||LA5_0==RegularExpressionLiteral||(LA5_0>=DecimalLiteral && LA5_0<=HexIntegerLiteral)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:52:21: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_ifStatement208);
            	    statement();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end ifStatement


    // $ANTLR start doStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:55:1: doStatement : ^( DO statement expression ) ;
    public final void doStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:56:2: ( ^( DO statement expression ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:56:4: ^( DO statement expression )
            {
            match(input,DO,FOLLOW_DO_in_doStatement224); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_statement_in_doStatement226);
            statement();
            _fsp--;

            pushFollow(FOLLOW_expression_in_doStatement228);
            expression();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end doStatement


    // $ANTLR start whileStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:59:1: whileStatement : ^( WHILE expression statement ) ;
    public final void whileStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:60:2: ( ^( WHILE expression statement ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:60:4: ^( WHILE expression statement )
            {
            match(input,WHILE,FOLLOW_WHILE_in_whileStatement243); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_whileStatement245);
            expression();
            _fsp--;

            pushFollow(FOLLOW_statement_in_whileStatement247);
            statement();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end whileStatement


    // $ANTLR start forStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:63:1: forStatement : ^( FOR ( ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause ) | ^( FORITER ( exprClause | variableDeclaration ) exprClause ) ) statement ) ;
    public final void forStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:64:2: ( ^( FOR ( ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause ) | ^( FORITER ( exprClause | variableDeclaration ) exprClause ) ) statement ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:64:4: ^( FOR ( ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause ) | ^( FORITER ( exprClause | variableDeclaration ) exprClause ) ) statement )
            {
            match(input,FOR,FOLLOW_FOR_in_forStatement263); 

            match(input, Token.DOWN, null); 
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:66:2: ( ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause ) | ^( FORITER ( exprClause | variableDeclaration ) exprClause ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==FORSTEP) ) {
                alt8=1;
            }
            else if ( (LA8_0==FORITER) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("66:2: ( ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause ) | ^( FORITER ( exprClause | variableDeclaration ) exprClause ) )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:67:3: ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause )
                    {
                    match(input,FORSTEP,FOLLOW_FORSTEP_in_forStatement273); 

                    match(input, Token.DOWN, null); 
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:67:14: ( exprOptClause | variableDeclaration )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==EXPR) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==VAR) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("67:14: ( exprOptClause | variableDeclaration )", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:67:16: exprOptClause
                            {
                            pushFollow(FOLLOW_exprOptClause_in_forStatement277);
                            exprOptClause();
                            _fsp--;


                            }
                            break;
                        case 2 :
                            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:67:32: variableDeclaration
                            {
                            pushFollow(FOLLOW_variableDeclaration_in_forStatement281);
                            variableDeclaration();
                            _fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_exprOptClause_in_forStatement285);
                    exprOptClause();
                    _fsp--;

                    pushFollow(FOLLOW_exprOptClause_in_forStatement287);
                    exprOptClause();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:68:5: ^( FORITER ( exprClause | variableDeclaration ) exprClause )
                    {
                    match(input,FORITER,FOLLOW_FORITER_in_forStatement297); 

                    match(input, Token.DOWN, null); 
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:68:16: ( exprClause | variableDeclaration )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==EXPR) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==VAR) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("68:16: ( exprClause | variableDeclaration )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:68:18: exprClause
                            {
                            pushFollow(FOLLOW_exprClause_in_forStatement301);
                            exprClause();
                            _fsp--;


                            }
                            break;
                        case 2 :
                            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:68:31: variableDeclaration
                            {
                            pushFollow(FOLLOW_variableDeclaration_in_forStatement305);
                            variableDeclaration();
                            _fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_exprClause_in_forStatement309);
                    exprClause();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

            }

            pushFollow(FOLLOW_statement_in_forStatement317);
            statement();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end forStatement


    // $ANTLR start exprOptClause
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:73:1: exprOptClause : ^( EXPR ( expression )? ) ;
    public final void exprOptClause() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:74:2: ( ^( EXPR ( expression )? ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:74:4: ^( EXPR ( expression )? )
            {
            match(input,EXPR,FOLLOW_EXPR_in_exprOptClause331); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:74:12: ( expression )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=NULL && LA9_0<=FALSE)||LA9_0==DELETE||LA9_0==FUNCTION||(LA9_0>=IN && LA9_0<=NEW)||LA9_0==THIS||LA9_0==TYPEOF||LA9_0==VOID||(LA9_0>=LT && LA9_0<=QUE)||(LA9_0>=ASSIGN && LA9_0<=DIVASS)||LA9_0==ARRAY||(LA9_0>=BYFIELD && LA9_0<=CEXPR)||(LA9_0>=NEG && LA9_0<=OBJECT)||(LA9_0>=PDEC && LA9_0<=POS)||(LA9_0>=Identifier && LA9_0<=StringLiteral)||LA9_0==RegularExpressionLiteral||(LA9_0>=DecimalLiteral && LA9_0<=HexIntegerLiteral)) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:74:12: expression
                        {
                        pushFollow(FOLLOW_expression_in_exprOptClause333);
                        expression();
                        _fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end exprOptClause


    // $ANTLR start exprClause
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:77:1: exprClause : ^( EXPR expression ) ;
    public final void exprClause() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:78:2: ( ^( EXPR expression ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:78:4: ^( EXPR expression )
            {
            match(input,EXPR,FOLLOW_EXPR_in_exprClause349); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_exprClause351);
            expression();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end exprClause


    // $ANTLR start continueStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:81:1: continueStatement : ^( CONTINUE ( Identifier )? ) ;
    public final void continueStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:82:2: ( ^( CONTINUE ( Identifier )? ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:82:4: ^( CONTINUE ( Identifier )? )
            {
            match(input,CONTINUE,FOLLOW_CONTINUE_in_continueStatement366); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:82:16: ( Identifier )?
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Identifier) ) {
                    alt10=1;
                }
                switch (alt10) {
                    case 1 :
                        // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:82:16: Identifier
                        {
                        match(input,Identifier,FOLLOW_Identifier_in_continueStatement368); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end continueStatement


    // $ANTLR start breakStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:85:1: breakStatement : ^( BREAK ( Identifier )? ) ;
    public final void breakStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:86:2: ( ^( BREAK ( Identifier )? ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:86:4: ^( BREAK ( Identifier )? )
            {
            match(input,BREAK,FOLLOW_BREAK_in_breakStatement384); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:86:13: ( Identifier )?
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Identifier) ) {
                    alt11=1;
                }
                switch (alt11) {
                    case 1 :
                        // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:86:13: Identifier
                        {
                        match(input,Identifier,FOLLOW_Identifier_in_breakStatement386); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end breakStatement


    // $ANTLR start returnStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:89:1: returnStatement : ^( RETURN ( expression )? ) ;
    public final void returnStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:90:2: ( ^( RETURN ( expression )? ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:90:4: ^( RETURN ( expression )? )
            {
            match(input,RETURN,FOLLOW_RETURN_in_returnStatement402); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:90:14: ( expression )?
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=NULL && LA12_0<=FALSE)||LA12_0==DELETE||LA12_0==FUNCTION||(LA12_0>=IN && LA12_0<=NEW)||LA12_0==THIS||LA12_0==TYPEOF||LA12_0==VOID||(LA12_0>=LT && LA12_0<=QUE)||(LA12_0>=ASSIGN && LA12_0<=DIVASS)||LA12_0==ARRAY||(LA12_0>=BYFIELD && LA12_0<=CEXPR)||(LA12_0>=NEG && LA12_0<=OBJECT)||(LA12_0>=PDEC && LA12_0<=POS)||(LA12_0>=Identifier && LA12_0<=StringLiteral)||LA12_0==RegularExpressionLiteral||(LA12_0>=DecimalLiteral && LA12_0<=HexIntegerLiteral)) ) {
                    alt12=1;
                }
                switch (alt12) {
                    case 1 :
                        // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:90:14: expression
                        {
                        pushFollow(FOLLOW_expression_in_returnStatement404);
                        expression();
                        _fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end returnStatement


    // $ANTLR start withStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:93:1: withStatement : ^( WITH expression statement ) ;
    public final void withStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:94:2: ( ^( WITH expression statement ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:94:4: ^( WITH expression statement )
            {
            match(input,WITH,FOLLOW_WITH_in_withStatement420); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_withStatement422);
            expression();
            _fsp--;

            pushFollow(FOLLOW_statement_in_withStatement424);
            statement();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end withStatement


    // $ANTLR start labelledStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:97:1: labelledStatement : ^( LABELLED Identifier statement ) ;
    public final void labelledStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:98:2: ( ^( LABELLED Identifier statement ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:98:4: ^( LABELLED Identifier statement )
            {
            match(input,LABELLED,FOLLOW_LABELLED_in_labelledStatement439); 

            match(input, Token.DOWN, null); 
            match(input,Identifier,FOLLOW_Identifier_in_labelledStatement441); 
            pushFollow(FOLLOW_statement_in_labelledStatement443);
            statement();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end labelledStatement


    // $ANTLR start switchStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:101:1: switchStatement : ^( SWITCH expression ( defaultClause )? ( caseClause )* ) ;
    public final void switchStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:102:2: ( ^( SWITCH expression ( defaultClause )? ( caseClause )* ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:102:4: ^( SWITCH expression ( defaultClause )? ( caseClause )* )
            {
            match(input,SWITCH,FOLLOW_SWITCH_in_switchStatement458); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_switchStatement460);
            expression();
            _fsp--;

            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:102:25: ( defaultClause )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==DEFAULT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:102:25: defaultClause
                    {
                    pushFollow(FOLLOW_defaultClause_in_switchStatement462);
                    defaultClause();
                    _fsp--;


                    }
                    break;

            }

            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:102:40: ( caseClause )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==CASE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:102:40: caseClause
            	    {
            	    pushFollow(FOLLOW_caseClause_in_switchStatement465);
            	    caseClause();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end switchStatement


    // $ANTLR start defaultClause
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:105:1: defaultClause : ^( DEFAULT ( statement )* ) ;
    public final void defaultClause() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:106:2: ( ^( DEFAULT ( statement )* ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:106:4: ^( DEFAULT ( statement )* )
            {
            match(input,DEFAULT,FOLLOW_DEFAULT_in_defaultClause481); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:106:15: ( statement )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0>=NULL && LA15_0<=BREAK)||LA15_0==CONTINUE||(LA15_0>=DELETE && LA15_0<=DO)||LA15_0==FOR||(LA15_0>=FUNCTION && LA15_0<=WITH)||(LA15_0>=LT && LA15_0<=QUE)||(LA15_0>=ASSIGN && LA15_0<=DIVASS)||(LA15_0>=ARRAY && LA15_0<=CEXPR)||LA15_0==LABELLED||(LA15_0>=NEG && LA15_0<=OBJECT)||(LA15_0>=PDEC && LA15_0<=POS)||(LA15_0>=Identifier && LA15_0<=StringLiteral)||LA15_0==RegularExpressionLiteral||(LA15_0>=DecimalLiteral && LA15_0<=HexIntegerLiteral)) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:106:15: statement
                	    {
                	    pushFollow(FOLLOW_statement_in_defaultClause483);
                	    statement();
                	    _fsp--;


                	    }
                	    break;

                	default :
                	    break loop15;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end defaultClause


    // $ANTLR start caseClause
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:109:1: caseClause : ^( CASE expression ( statement )* ) ;
    public final void caseClause() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:110:2: ( ^( CASE expression ( statement )* ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:110:4: ^( CASE expression ( statement )* )
            {
            match(input,CASE,FOLLOW_CASE_in_caseClause499); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_caseClause501);
            expression();
            _fsp--;

            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:110:23: ( statement )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=NULL && LA16_0<=BREAK)||LA16_0==CONTINUE||(LA16_0>=DELETE && LA16_0<=DO)||LA16_0==FOR||(LA16_0>=FUNCTION && LA16_0<=WITH)||(LA16_0>=LT && LA16_0<=QUE)||(LA16_0>=ASSIGN && LA16_0<=DIVASS)||(LA16_0>=ARRAY && LA16_0<=CEXPR)||LA16_0==LABELLED||(LA16_0>=NEG && LA16_0<=OBJECT)||(LA16_0>=PDEC && LA16_0<=POS)||(LA16_0>=Identifier && LA16_0<=StringLiteral)||LA16_0==RegularExpressionLiteral||(LA16_0>=DecimalLiteral && LA16_0<=HexIntegerLiteral)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:110:23: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_caseClause503);
            	    statement();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end caseClause


    // $ANTLR start throwStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:113:1: throwStatement : ^( THROW expression ) ;
    public final void throwStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:114:2: ( ^( THROW expression ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:114:4: ^( THROW expression )
            {
            match(input,THROW,FOLLOW_THROW_in_throwStatement519); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_throwStatement521);
            expression();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end throwStatement


    // $ANTLR start tryStatement
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:117:1: tryStatement : ^( TRY block ( catchClause )? ( finallyClause )? ) ;
    public final void tryStatement() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:118:2: ( ^( TRY block ( catchClause )? ( finallyClause )? ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:118:4: ^( TRY block ( catchClause )? ( finallyClause )? )
            {
            match(input,TRY,FOLLOW_TRY_in_tryStatement536); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_tryStatement538);
            block();
            _fsp--;

            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:118:17: ( catchClause )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==CATCH) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:118:17: catchClause
                    {
                    pushFollow(FOLLOW_catchClause_in_tryStatement540);
                    catchClause();
                    _fsp--;


                    }
                    break;

            }

            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:118:30: ( finallyClause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FINALLY) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:118:30: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_tryStatement543);
                    finallyClause();
                    _fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end tryStatement


    // $ANTLR start catchClause
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:121:1: catchClause : ^( CATCH Identifier block ) ;
    public final void catchClause() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:122:2: ( ^( CATCH Identifier block ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:122:4: ^( CATCH Identifier block )
            {
            match(input,CATCH,FOLLOW_CATCH_in_catchClause560); 

            match(input, Token.DOWN, null); 
            match(input,Identifier,FOLLOW_Identifier_in_catchClause562); 
            pushFollow(FOLLOW_block_in_catchClause564);
            block();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end catchClause


    // $ANTLR start finallyClause
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:125:1: finallyClause : ^( FINALLY block ) ;
    public final void finallyClause() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:126:2: ( ^( FINALLY block ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:126:4: ^( FINALLY block )
            {
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause580); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_finallyClause582);
            block();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end finallyClause


    // $ANTLR start expression
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:129:1: expression : ( expr | ^( CEXPR ( expr )+ ) );
    public final void expression() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:130:2: ( expr | ^( CEXPR ( expr )+ ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=NULL && LA20_0<=FALSE)||LA20_0==DELETE||LA20_0==FUNCTION||(LA20_0>=IN && LA20_0<=NEW)||LA20_0==THIS||LA20_0==TYPEOF||LA20_0==VOID||(LA20_0>=LT && LA20_0<=QUE)||(LA20_0>=ASSIGN && LA20_0<=DIVASS)||LA20_0==ARRAY||(LA20_0>=BYFIELD && LA20_0<=CALL)||(LA20_0>=NEG && LA20_0<=OBJECT)||(LA20_0>=PDEC && LA20_0<=POS)||(LA20_0>=Identifier && LA20_0<=StringLiteral)||LA20_0==RegularExpressionLiteral||(LA20_0>=DecimalLiteral && LA20_0<=HexIntegerLiteral)) ) {
                alt20=1;
            }
            else if ( (LA20_0==CEXPR) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("129:1: expression : ( expr | ^( CEXPR ( expr )+ ) );", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:130:4: expr
                    {
                    pushFollow(FOLLOW_expr_in_expression595);
                    expr();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:131:4: ^( CEXPR ( expr )+ )
                    {
                    match(input,CEXPR,FOLLOW_CEXPR_in_expression603); 

                    match(input, Token.DOWN, null); 
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:131:13: ( expr )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=NULL && LA19_0<=FALSE)||LA19_0==DELETE||LA19_0==FUNCTION||(LA19_0>=IN && LA19_0<=NEW)||LA19_0==THIS||LA19_0==TYPEOF||LA19_0==VOID||(LA19_0>=LT && LA19_0<=QUE)||(LA19_0>=ASSIGN && LA19_0<=DIVASS)||LA19_0==ARRAY||(LA19_0>=BYFIELD && LA19_0<=CALL)||(LA19_0>=NEG && LA19_0<=OBJECT)||(LA19_0>=PDEC && LA19_0<=POS)||(LA19_0>=Identifier && LA19_0<=StringLiteral)||LA19_0==RegularExpressionLiteral||(LA19_0>=DecimalLiteral && LA19_0<=HexIntegerLiteral)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:131:13: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_expression605);
                    	    expr();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end expression


    // $ANTLR start expr
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:134:1: expr : ( leftHandSideExpression | ^( ASSIGN expr expr ) | ^( MULASS expr expr ) | ^( DIVASS expr expr ) | ^( MODASS expr expr ) | ^( ADDASS expr expr ) | ^( SUBASS expr expr ) | ^( SHLASS expr expr ) | ^( SHRASS expr expr ) | ^( SHUASS expr expr ) | ^( ANDASS expr expr ) | ^( XORASS expr expr ) | ^( ORASS expr expr ) | ^( QUE expr expr expr ) | ^( LOR expr expr ) | ^( LAND expr expr ) | ^( AND expr expr ) | ^( OR expr expr ) | ^( XOR expr expr ) | ^( EQ expr expr ) | ^( NEQ expr expr ) | ^( SAME expr expr ) | ^( NSAME expr expr ) | ^( LT expr expr ) | ^( GT expr expr ) | ^( LTE expr expr ) | ^( GTE expr expr ) | ^( INSTANCEOF expr expr ) | ^( IN expr expr ) | ^( SHL expr expr ) | ^( SHR expr expr ) | ^( SHU expr expr ) | ^( ADD expr expr ) | ^( SUB expr expr ) | ^( MUL expr expr ) | ^( DIV expr expr ) | ^( MOD expr expr ) | ^( DELETE expr ) | ^( VOID expr ) | ^( TYPEOF expr ) | ^( INC expr ) | ^( DEC expr ) | ^( POS expr ) | ^( NEG expr ) | ^( INV expr ) | ^( NOT expr ) | ^( PINC expr ) | ^( PDEC expr ) );
    public final void expr() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:135:2: ( leftHandSideExpression | ^( ASSIGN expr expr ) | ^( MULASS expr expr ) | ^( DIVASS expr expr ) | ^( MODASS expr expr ) | ^( ADDASS expr expr ) | ^( SUBASS expr expr ) | ^( SHLASS expr expr ) | ^( SHRASS expr expr ) | ^( SHUASS expr expr ) | ^( ANDASS expr expr ) | ^( XORASS expr expr ) | ^( ORASS expr expr ) | ^( QUE expr expr expr ) | ^( LOR expr expr ) | ^( LAND expr expr ) | ^( AND expr expr ) | ^( OR expr expr ) | ^( XOR expr expr ) | ^( EQ expr expr ) | ^( NEQ expr expr ) | ^( SAME expr expr ) | ^( NSAME expr expr ) | ^( LT expr expr ) | ^( GT expr expr ) | ^( LTE expr expr ) | ^( GTE expr expr ) | ^( INSTANCEOF expr expr ) | ^( IN expr expr ) | ^( SHL expr expr ) | ^( SHR expr expr ) | ^( SHU expr expr ) | ^( ADD expr expr ) | ^( SUB expr expr ) | ^( MUL expr expr ) | ^( DIV expr expr ) | ^( MOD expr expr ) | ^( DELETE expr ) | ^( VOID expr ) | ^( TYPEOF expr ) | ^( INC expr ) | ^( DEC expr ) | ^( POS expr ) | ^( NEG expr ) | ^( INV expr ) | ^( NOT expr ) | ^( PINC expr ) | ^( PDEC expr ) )
            int alt21=48;
            switch ( input.LA(1) ) {
            case NULL:
            case TRUE:
            case FALSE:
            case FUNCTION:
            case NEW:
            case THIS:
            case ARRAY:
            case BYFIELD:
            case BYINDEX:
            case CALL:
            case OBJECT:
            case Identifier:
            case StringLiteral:
            case RegularExpressionLiteral:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt21=1;
                }
                break;
            case ASSIGN:
                {
                alt21=2;
                }
                break;
            case MULASS:
                {
                alt21=3;
                }
                break;
            case DIVASS:
                {
                alt21=4;
                }
                break;
            case MODASS:
                {
                alt21=5;
                }
                break;
            case ADDASS:
                {
                alt21=6;
                }
                break;
            case SUBASS:
                {
                alt21=7;
                }
                break;
            case SHLASS:
                {
                alt21=8;
                }
                break;
            case SHRASS:
                {
                alt21=9;
                }
                break;
            case SHUASS:
                {
                alt21=10;
                }
                break;
            case ANDASS:
                {
                alt21=11;
                }
                break;
            case XORASS:
                {
                alt21=12;
                }
                break;
            case ORASS:
                {
                alt21=13;
                }
                break;
            case QUE:
                {
                alt21=14;
                }
                break;
            case LOR:
                {
                alt21=15;
                }
                break;
            case LAND:
                {
                alt21=16;
                }
                break;
            case AND:
                {
                alt21=17;
                }
                break;
            case OR:
                {
                alt21=18;
                }
                break;
            case XOR:
                {
                alt21=19;
                }
                break;
            case EQ:
                {
                alt21=20;
                }
                break;
            case NEQ:
                {
                alt21=21;
                }
                break;
            case SAME:
                {
                alt21=22;
                }
                break;
            case NSAME:
                {
                alt21=23;
                }
                break;
            case LT:
                {
                alt21=24;
                }
                break;
            case GT:
                {
                alt21=25;
                }
                break;
            case LTE:
                {
                alt21=26;
                }
                break;
            case GTE:
                {
                alt21=27;
                }
                break;
            case INSTANCEOF:
                {
                alt21=28;
                }
                break;
            case IN:
                {
                alt21=29;
                }
                break;
            case SHL:
                {
                alt21=30;
                }
                break;
            case SHR:
                {
                alt21=31;
                }
                break;
            case SHU:
                {
                alt21=32;
                }
                break;
            case ADD:
                {
                alt21=33;
                }
                break;
            case SUB:
                {
                alt21=34;
                }
                break;
            case MUL:
                {
                alt21=35;
                }
                break;
            case DIV:
                {
                alt21=36;
                }
                break;
            case MOD:
                {
                alt21=37;
                }
                break;
            case DELETE:
                {
                alt21=38;
                }
                break;
            case VOID:
                {
                alt21=39;
                }
                break;
            case TYPEOF:
                {
                alt21=40;
                }
                break;
            case INC:
                {
                alt21=41;
                }
                break;
            case DEC:
                {
                alt21=42;
                }
                break;
            case POS:
                {
                alt21=43;
                }
                break;
            case NEG:
                {
                alt21=44;
                }
                break;
            case INV:
                {
                alt21=45;
                }
                break;
            case NOT:
                {
                alt21=46;
                }
                break;
            case PINC:
                {
                alt21=47;
                }
                break;
            case PDEC:
                {
                alt21=48;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("134:1: expr : ( leftHandSideExpression | ^( ASSIGN expr expr ) | ^( MULASS expr expr ) | ^( DIVASS expr expr ) | ^( MODASS expr expr ) | ^( ADDASS expr expr ) | ^( SUBASS expr expr ) | ^( SHLASS expr expr ) | ^( SHRASS expr expr ) | ^( SHUASS expr expr ) | ^( ANDASS expr expr ) | ^( XORASS expr expr ) | ^( ORASS expr expr ) | ^( QUE expr expr expr ) | ^( LOR expr expr ) | ^( LAND expr expr ) | ^( AND expr expr ) | ^( OR expr expr ) | ^( XOR expr expr ) | ^( EQ expr expr ) | ^( NEQ expr expr ) | ^( SAME expr expr ) | ^( NSAME expr expr ) | ^( LT expr expr ) | ^( GT expr expr ) | ^( LTE expr expr ) | ^( GTE expr expr ) | ^( INSTANCEOF expr expr ) | ^( IN expr expr ) | ^( SHL expr expr ) | ^( SHR expr expr ) | ^( SHU expr expr ) | ^( ADD expr expr ) | ^( SUB expr expr ) | ^( MUL expr expr ) | ^( DIV expr expr ) | ^( MOD expr expr ) | ^( DELETE expr ) | ^( VOID expr ) | ^( TYPEOF expr ) | ^( INC expr ) | ^( DEC expr ) | ^( POS expr ) | ^( NEG expr ) | ^( INV expr ) | ^( NOT expr ) | ^( PINC expr ) | ^( PDEC expr ) );", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:135:4: leftHandSideExpression
                    {
                    pushFollow(FOLLOW_leftHandSideExpression_in_expr619);
                    leftHandSideExpression();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:138:4: ^( ASSIGN expr expr )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_expr630); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr632);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr634);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:139:4: ^( MULASS expr expr )
                    {
                    match(input,MULASS,FOLLOW_MULASS_in_expr643); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr645);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr647);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:140:4: ^( DIVASS expr expr )
                    {
                    match(input,DIVASS,FOLLOW_DIVASS_in_expr656); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr658);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr660);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:141:4: ^( MODASS expr expr )
                    {
                    match(input,MODASS,FOLLOW_MODASS_in_expr669); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr671);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr673);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:142:4: ^( ADDASS expr expr )
                    {
                    match(input,ADDASS,FOLLOW_ADDASS_in_expr682); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr684);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr686);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:143:4: ^( SUBASS expr expr )
                    {
                    match(input,SUBASS,FOLLOW_SUBASS_in_expr695); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr697);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr699);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:144:4: ^( SHLASS expr expr )
                    {
                    match(input,SHLASS,FOLLOW_SHLASS_in_expr708); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr710);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr712);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:145:4: ^( SHRASS expr expr )
                    {
                    match(input,SHRASS,FOLLOW_SHRASS_in_expr721); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr723);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr725);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:146:4: ^( SHUASS expr expr )
                    {
                    match(input,SHUASS,FOLLOW_SHUASS_in_expr734); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr736);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr738);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:147:4: ^( ANDASS expr expr )
                    {
                    match(input,ANDASS,FOLLOW_ANDASS_in_expr747); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr749);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr751);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:148:4: ^( XORASS expr expr )
                    {
                    match(input,XORASS,FOLLOW_XORASS_in_expr760); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr762);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr764);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 13 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:149:4: ^( ORASS expr expr )
                    {
                    match(input,ORASS,FOLLOW_ORASS_in_expr773); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr775);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr777);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:152:4: ^( QUE expr expr expr )
                    {
                    match(input,QUE,FOLLOW_QUE_in_expr790); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr792);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr794);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr796);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:155:4: ^( LOR expr expr )
                    {
                    match(input,LOR,FOLLOW_LOR_in_expr809); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr811);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr813);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 16 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:156:4: ^( LAND expr expr )
                    {
                    match(input,LAND,FOLLOW_LAND_in_expr822); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr824);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr826);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:159:4: ^( AND expr expr )
                    {
                    match(input,AND,FOLLOW_AND_in_expr839); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr841);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr843);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 18 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:160:4: ^( OR expr expr )
                    {
                    match(input,OR,FOLLOW_OR_in_expr852); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr854);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr856);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 19 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:161:4: ^( XOR expr expr )
                    {
                    match(input,XOR,FOLLOW_XOR_in_expr865); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr867);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr869);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 20 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:164:4: ^( EQ expr expr )
                    {
                    match(input,EQ,FOLLOW_EQ_in_expr882); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr884);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr886);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 21 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:165:4: ^( NEQ expr expr )
                    {
                    match(input,NEQ,FOLLOW_NEQ_in_expr895); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr897);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr899);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 22 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:166:4: ^( SAME expr expr )
                    {
                    match(input,SAME,FOLLOW_SAME_in_expr908); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr910);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr912);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 23 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:167:4: ^( NSAME expr expr )
                    {
                    match(input,NSAME,FOLLOW_NSAME_in_expr921); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr923);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr925);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 24 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:170:4: ^( LT expr expr )
                    {
                    match(input,LT,FOLLOW_LT_in_expr938); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr940);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr942);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 25 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:171:4: ^( GT expr expr )
                    {
                    match(input,GT,FOLLOW_GT_in_expr951); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr953);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr955);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 26 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:172:4: ^( LTE expr expr )
                    {
                    match(input,LTE,FOLLOW_LTE_in_expr964); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr966);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr968);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 27 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:173:4: ^( GTE expr expr )
                    {
                    match(input,GTE,FOLLOW_GTE_in_expr977); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr979);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr981);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 28 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:174:4: ^( INSTANCEOF expr expr )
                    {
                    match(input,INSTANCEOF,FOLLOW_INSTANCEOF_in_expr990); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr992);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr994);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 29 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:175:4: ^( IN expr expr )
                    {
                    match(input,IN,FOLLOW_IN_in_expr1003); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1005);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr1007);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 30 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:178:4: ^( SHL expr expr )
                    {
                    match(input,SHL,FOLLOW_SHL_in_expr1020); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1022);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr1024);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 31 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:179:4: ^( SHR expr expr )
                    {
                    match(input,SHR,FOLLOW_SHR_in_expr1033); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1035);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr1037);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 32 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:180:4: ^( SHU expr expr )
                    {
                    match(input,SHU,FOLLOW_SHU_in_expr1046); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1048);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr1050);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 33 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:183:4: ^( ADD expr expr )
                    {
                    match(input,ADD,FOLLOW_ADD_in_expr1063); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1065);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr1067);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 34 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:184:4: ^( SUB expr expr )
                    {
                    match(input,SUB,FOLLOW_SUB_in_expr1076); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1078);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr1080);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 35 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:187:4: ^( MUL expr expr )
                    {
                    match(input,MUL,FOLLOW_MUL_in_expr1093); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1095);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr1097);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 36 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:188:4: ^( DIV expr expr )
                    {
                    match(input,DIV,FOLLOW_DIV_in_expr1106); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1108);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr1110);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 37 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:189:4: ^( MOD expr expr )
                    {
                    match(input,MOD,FOLLOW_MOD_in_expr1119); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1121);
                    expr();
                    _fsp--;

                    pushFollow(FOLLOW_expr_in_expr1123);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 38 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:192:4: ^( DELETE expr )
                    {
                    match(input,DELETE,FOLLOW_DELETE_in_expr1136); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1138);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 39 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:193:4: ^( VOID expr )
                    {
                    match(input,VOID,FOLLOW_VOID_in_expr1147); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1149);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 40 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:194:4: ^( TYPEOF expr )
                    {
                    match(input,TYPEOF,FOLLOW_TYPEOF_in_expr1158); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1160);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 41 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:195:4: ^( INC expr )
                    {
                    match(input,INC,FOLLOW_INC_in_expr1169); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1171);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 42 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:196:4: ^( DEC expr )
                    {
                    match(input,DEC,FOLLOW_DEC_in_expr1180); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1182);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 43 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:197:4: ^( POS expr )
                    {
                    match(input,POS,FOLLOW_POS_in_expr1191); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1193);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 44 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:198:4: ^( NEG expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr1202); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1204);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 45 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:199:4: ^( INV expr )
                    {
                    match(input,INV,FOLLOW_INV_in_expr1213); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1215);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 46 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:200:4: ^( NOT expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1224); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1226);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 47 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:203:4: ^( PINC expr )
                    {
                    match(input,PINC,FOLLOW_PINC_in_expr1239); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1241);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 48 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:204:4: ^( PDEC expr )
                    {
                    match(input,PDEC,FOLLOW_PDEC_in_expr1250); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1252);
                    expr();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end expr


    // $ANTLR start leftHandSideExpression
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:207:1: leftHandSideExpression : ( primaryExpression | newExpression | functionDeclaration | callExpression | memberExpression );
    public final void leftHandSideExpression() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:208:2: ( primaryExpression | newExpression | functionDeclaration | callExpression | memberExpression )
            int alt22=5;
            switch ( input.LA(1) ) {
            case NULL:
            case TRUE:
            case FALSE:
            case THIS:
            case ARRAY:
            case OBJECT:
            case Identifier:
            case StringLiteral:
            case RegularExpressionLiteral:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt22=1;
                }
                break;
            case NEW:
                {
                alt22=2;
                }
                break;
            case FUNCTION:
                {
                alt22=3;
                }
                break;
            case CALL:
                {
                alt22=4;
                }
                break;
            case BYFIELD:
            case BYINDEX:
                {
                alt22=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("207:1: leftHandSideExpression : ( primaryExpression | newExpression | functionDeclaration | callExpression | memberExpression );", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:208:4: primaryExpression
                    {
                    pushFollow(FOLLOW_primaryExpression_in_leftHandSideExpression1265);
                    primaryExpression();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:209:4: newExpression
                    {
                    pushFollow(FOLLOW_newExpression_in_leftHandSideExpression1270);
                    newExpression();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:210:4: functionDeclaration
                    {
                    pushFollow(FOLLOW_functionDeclaration_in_leftHandSideExpression1275);
                    functionDeclaration();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:211:4: callExpression
                    {
                    pushFollow(FOLLOW_callExpression_in_leftHandSideExpression1280);
                    callExpression();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:212:4: memberExpression
                    {
                    pushFollow(FOLLOW_memberExpression_in_leftHandSideExpression1285);
                    memberExpression();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end leftHandSideExpression


    // $ANTLR start newExpression
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:215:1: newExpression : ^( NEW primaryExpression ) ;
    public final void newExpression() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:216:2: ( ^( NEW primaryExpression ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:216:4: ^( NEW primaryExpression )
            {
            match(input,NEW,FOLLOW_NEW_in_newExpression1298); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_primaryExpression_in_newExpression1300);
            primaryExpression();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end newExpression


    // $ANTLR start functionDeclaration
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:219:1: functionDeclaration : ^( FUNCTION ( Identifier )? ^( ARGS ( Identifier )* ) block ) ;
    public final void functionDeclaration() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:220:2: ( ^( FUNCTION ( Identifier )? ^( ARGS ( Identifier )* ) block ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:220:4: ^( FUNCTION ( Identifier )? ^( ARGS ( Identifier )* ) block )
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_functionDeclaration1315); 

            match(input, Token.DOWN, null); 
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:220:16: ( Identifier )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Identifier) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:220:16: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_functionDeclaration1317); 

                    }
                    break;

            }

            match(input,ARGS,FOLLOW_ARGS_in_functionDeclaration1322); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:220:36: ( Identifier )*
                loop24:
                do {
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==Identifier) ) {
                        alt24=1;
                    }


                    switch (alt24) {
                	case 1 :
                	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:220:36: Identifier
                	    {
                	    match(input,Identifier,FOLLOW_Identifier_in_functionDeclaration1324); 

                	    }
                	    break;

                	default :
                	    break loop24;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
            pushFollow(FOLLOW_block_in_functionDeclaration1329);
            block();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end functionDeclaration


    // $ANTLR start callExpression
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:223:1: callExpression : ^( CALL leftHandSideExpression ^( ARGS ( expr )* ) ) ;
    public final void callExpression() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:224:2: ( ^( CALL leftHandSideExpression ^( ARGS ( expr )* ) ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:224:4: ^( CALL leftHandSideExpression ^( ARGS ( expr )* ) )
            {
            match(input,CALL,FOLLOW_CALL_in_callExpression1344); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_leftHandSideExpression_in_callExpression1346);
            leftHandSideExpression();
            _fsp--;

            match(input,ARGS,FOLLOW_ARGS_in_callExpression1350); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:224:43: ( expr )*
                loop25:
                do {
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>=NULL && LA25_0<=FALSE)||LA25_0==DELETE||LA25_0==FUNCTION||(LA25_0>=IN && LA25_0<=NEW)||LA25_0==THIS||LA25_0==TYPEOF||LA25_0==VOID||(LA25_0>=LT && LA25_0<=QUE)||(LA25_0>=ASSIGN && LA25_0<=DIVASS)||LA25_0==ARRAY||(LA25_0>=BYFIELD && LA25_0<=CALL)||(LA25_0>=NEG && LA25_0<=OBJECT)||(LA25_0>=PDEC && LA25_0<=POS)||(LA25_0>=Identifier && LA25_0<=StringLiteral)||LA25_0==RegularExpressionLiteral||(LA25_0>=DecimalLiteral && LA25_0<=HexIntegerLiteral)) ) {
                        alt25=1;
                    }


                    switch (alt25) {
                	case 1 :
                	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:224:43: expr
                	    {
                	    pushFollow(FOLLOW_expr_in_callExpression1352);
                	    expr();
                	    _fsp--;


                	    }
                	    break;

                	default :
                	    break loop25;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end callExpression


    // $ANTLR start memberExpression
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:227:1: memberExpression : ( ^( BYINDEX leftHandSideExpression expression ) | ^( BYFIELD leftHandSideExpression Identifier ) );
    public final void memberExpression() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:228:2: ( ^( BYINDEX leftHandSideExpression expression ) | ^( BYFIELD leftHandSideExpression Identifier ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==BYINDEX) ) {
                alt26=1;
            }
            else if ( (LA26_0==BYFIELD) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("227:1: memberExpression : ( ^( BYINDEX leftHandSideExpression expression ) | ^( BYFIELD leftHandSideExpression Identifier ) );", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:228:4: ^( BYINDEX leftHandSideExpression expression )
                    {
                    match(input,BYINDEX,FOLLOW_BYINDEX_in_memberExpression1371); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_leftHandSideExpression_in_memberExpression1373);
                    leftHandSideExpression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_memberExpression1375);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:229:4: ^( BYFIELD leftHandSideExpression Identifier )
                    {
                    match(input,BYFIELD,FOLLOW_BYFIELD_in_memberExpression1384); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_leftHandSideExpression_in_memberExpression1386);
                    leftHandSideExpression();
                    _fsp--;

                    match(input,Identifier,FOLLOW_Identifier_in_memberExpression1388); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end memberExpression


    // $ANTLR start primaryExpression
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:232:1: primaryExpression : ( Identifier | literal );
    public final void primaryExpression() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:233:2: ( Identifier | literal )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Identifier) ) {
                alt27=1;
            }
            else if ( ((LA27_0>=NULL && LA27_0<=FALSE)||LA27_0==THIS||LA27_0==ARRAY||LA27_0==OBJECT||LA27_0==StringLiteral||LA27_0==RegularExpressionLiteral||(LA27_0>=DecimalLiteral && LA27_0<=HexIntegerLiteral)) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("232:1: primaryExpression : ( Identifier | literal );", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:233:4: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_primaryExpression1401); 

                    }
                    break;
                case 2 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:234:4: literal
                    {
                    pushFollow(FOLLOW_literal_in_primaryExpression1406);
                    literal();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end primaryExpression


    // $ANTLR start literal
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:237:1: literal : ( THIS | NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral | arrayLiteral | objectLiteral );
    public final void literal() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:238:2: ( THIS | NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral | arrayLiteral | objectLiteral )
            int alt28=8;
            switch ( input.LA(1) ) {
            case THIS:
                {
                alt28=1;
                }
                break;
            case NULL:
                {
                alt28=2;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt28=3;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt28=4;
                }
                break;
            case StringLiteral:
                {
                alt28=5;
                }
                break;
            case RegularExpressionLiteral:
                {
                alt28=6;
                }
                break;
            case ARRAY:
                {
                alt28=7;
                }
                break;
            case OBJECT:
                {
                alt28=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("237:1: literal : ( THIS | NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral | arrayLiteral | objectLiteral );", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:238:4: THIS
                    {
                    match(input,THIS,FOLLOW_THIS_in_literal1417); 

                    }
                    break;
                case 2 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:239:4: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_literal1422); 

                    }
                    break;
                case 3 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:240:4: booleanLiteral
                    {
                    pushFollow(FOLLOW_booleanLiteral_in_literal1427);
                    booleanLiteral();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:241:4: numericLiteral
                    {
                    pushFollow(FOLLOW_numericLiteral_in_literal1432);
                    numericLiteral();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:242:4: StringLiteral
                    {
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_literal1437); 

                    }
                    break;
                case 6 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:243:4: RegularExpressionLiteral
                    {
                    match(input,RegularExpressionLiteral,FOLLOW_RegularExpressionLiteral_in_literal1442); 

                    }
                    break;
                case 7 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:244:4: arrayLiteral
                    {
                    pushFollow(FOLLOW_arrayLiteral_in_literal1447);
                    arrayLiteral();
                    _fsp--;


                    }
                    break;
                case 8 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:245:4: objectLiteral
                    {
                    pushFollow(FOLLOW_objectLiteral_in_literal1452);
                    objectLiteral();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end literal


    // $ANTLR start booleanLiteral
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:248:1: booleanLiteral : ( TRUE | FALSE );
    public final void booleanLiteral() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:249:2: ( TRUE | FALSE )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:
            {
            if ( (input.LA(1)>=TRUE && input.LA(1)<=FALSE) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_booleanLiteral0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end booleanLiteral


    // $ANTLR start numericLiteral
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:253:1: numericLiteral : ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral );
    public final void numericLiteral() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:254:2: ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:
            {
            if ( (input.LA(1)>=DecimalLiteral && input.LA(1)<=HexIntegerLiteral) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_numericLiteral0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end numericLiteral


    // $ANTLR start arrayLiteral
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:259:1: arrayLiteral : ^( ARRAY ( ^( ITEM ( expr )? ) )* ) ;
    public final void arrayLiteral() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:260:2: ( ^( ARRAY ( ^( ITEM ( expr )? ) )* ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:260:4: ^( ARRAY ( ^( ITEM ( expr )? ) )* )
            {
            match(input,ARRAY,FOLLOW_ARRAY_in_arrayLiteral1502); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:260:13: ( ^( ITEM ( expr )? ) )*
                loop30:
                do {
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==ITEM) ) {
                        alt30=1;
                    }


                    switch (alt30) {
                	case 1 :
                	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:260:15: ^( ITEM ( expr )? )
                	    {
                	    match(input,ITEM,FOLLOW_ITEM_in_arrayLiteral1508); 

                	    if ( input.LA(1)==Token.DOWN ) {
                	        match(input, Token.DOWN, null); 
                	        // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:260:23: ( expr )?
                	        int alt29=2;
                	        int LA29_0 = input.LA(1);

                	        if ( ((LA29_0>=NULL && LA29_0<=FALSE)||LA29_0==DELETE||LA29_0==FUNCTION||(LA29_0>=IN && LA29_0<=NEW)||LA29_0==THIS||LA29_0==TYPEOF||LA29_0==VOID||(LA29_0>=LT && LA29_0<=QUE)||(LA29_0>=ASSIGN && LA29_0<=DIVASS)||LA29_0==ARRAY||(LA29_0>=BYFIELD && LA29_0<=CALL)||(LA29_0>=NEG && LA29_0<=OBJECT)||(LA29_0>=PDEC && LA29_0<=POS)||(LA29_0>=Identifier && LA29_0<=StringLiteral)||LA29_0==RegularExpressionLiteral||(LA29_0>=DecimalLiteral && LA29_0<=HexIntegerLiteral)) ) {
                	            alt29=1;
                	        }
                	        switch (alt29) {
                	            case 1 :
                	                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:260:23: expr
                	                {
                	                pushFollow(FOLLOW_expr_in_arrayLiteral1510);
                	                expr();
                	                _fsp--;


                	                }
                	                break;

                	        }


                	        match(input, Token.UP, null); 
                	    }

                	    }
                	    break;

                	default :
                	    break loop30;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end arrayLiteral


    // $ANTLR start objectLiteral
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:263:1: objectLiteral : ^( OBJECT ( ^( NAMEDVALUE propertyName expr ) )* ) ;
    public final void objectLiteral() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:264:2: ( ^( OBJECT ( ^( NAMEDVALUE propertyName expr ) )* ) )
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:264:4: ^( OBJECT ( ^( NAMEDVALUE propertyName expr ) )* )
            {
            match(input,OBJECT,FOLLOW_OBJECT_in_objectLiteral1531); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:264:14: ( ^( NAMEDVALUE propertyName expr ) )*
                loop31:
                do {
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==NAMEDVALUE) ) {
                        alt31=1;
                    }


                    switch (alt31) {
                	case 1 :
                	    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:264:16: ^( NAMEDVALUE propertyName expr )
                	    {
                	    match(input,NAMEDVALUE,FOLLOW_NAMEDVALUE_in_objectLiteral1537); 

                	    match(input, Token.DOWN, null); 
                	    pushFollow(FOLLOW_propertyName_in_objectLiteral1539);
                	    propertyName();
                	    _fsp--;

                	    pushFollow(FOLLOW_expr_in_objectLiteral1541);
                	    expr();
                	    _fsp--;


                	    match(input, Token.UP, null); 

                	    }
                	    break;

                	default :
                	    break loop31;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end objectLiteral


    // $ANTLR start propertyName
    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:267:1: propertyName : ( Identifier | StringLiteral | numericLiteral );
    public final void propertyName() throws RecognitionException {
        try {
            // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:268:2: ( Identifier | StringLiteral | numericLiteral )
            int alt32=3;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt32=1;
                }
                break;
            case StringLiteral:
                {
                alt32=2;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("267:1: propertyName : ( Identifier | StringLiteral | numericLiteral );", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:268:4: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_propertyName1559); 

                    }
                    break;
                case 2 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:269:4: StringLiteral
                    {
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_propertyName1564); 

                    }
                    break;
                case 3 :
                    // /home/bell/workspace.js/org.eclipse.dltk.javascript.formatter/src/org/eclipse/dltk/javascript/parser/JSWalker.g:270:4: numericLiteral
                    {
                    pushFollow(FOLLOW_numericLiteral_in_propertyName1569);
                    numericLiteral();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end propertyName


 

    public static final BitSet FOLLOW_statement_in_program57 = new BitSet(new long[]{0x00000001FFFD34F2L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_block_in_statement69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_statement74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doStatement_in_statement89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statement99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statement104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statement109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statement114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_withStatement_in_statement119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelledStatement_in_statement124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statement129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statement134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tryStatement_in_statement139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block154 = new BitSet(new long[]{0x00000001FFFD34F8L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_VAR_in_variableDeclaration170 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclaration174 = new BitSet(new long[]{0x0000000000000008L,0x0000002000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclaration180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclaration182 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_variableDeclaration184 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_ifStatement204 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ifStatement206 = new BitSet(new long[]{0x00000001FFFD34F0L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_statement_in_ifStatement208 = new BitSet(new long[]{0x00000001FFFD34F8L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_DO_in_doStatement224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_doStatement226 = new BitSet(new long[]{0x0000000052741070L,0x81EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expression_in_doStatement228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_whileStatement243 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_whileStatement245 = new BitSet(new long[]{0x00000001FFFD34F0L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_statement_in_whileStatement247 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_forStatement263 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FORSTEP_in_forStatement273 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_exprOptClause_in_forStatement277 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_forStatement281 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_exprOptClause_in_forStatement285 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_exprOptClause_in_forStatement287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORITER_in_forStatement297 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_exprClause_in_forStatement301 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_forStatement305 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_exprClause_in_forStatement309 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_statement_in_forStatement317 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_in_exprOptClause331 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_exprOptClause333 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_in_exprClause349 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_exprClause351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONTINUE_in_continueStatement366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_continueStatement368 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BREAK_in_breakStatement384 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_breakStatement386 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURN_in_returnStatement402 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_returnStatement404 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WITH_in_withStatement420 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_withStatement422 = new BitSet(new long[]{0x00000001FFFD34F0L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_statement_in_withStatement424 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LABELLED_in_labelledStatement439 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_labelledStatement441 = new BitSet(new long[]{0x00000001FFFD34F0L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_statement_in_labelledStatement443 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SWITCH_in_switchStatement458 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_switchStatement460 = new BitSet(new long[]{0x0000000000000908L});
    public static final BitSet FOLLOW_defaultClause_in_switchStatement462 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_caseClause_in_switchStatement465 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_DEFAULT_in_defaultClause481 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_defaultClause483 = new BitSet(new long[]{0x00000001FFFD34F8L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_CASE_in_caseClause499 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_caseClause501 = new BitSet(new long[]{0x00000001FFFD34F8L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_statement_in_caseClause503 = new BitSet(new long[]{0x00000001FFFD34F8L,0xA1FBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_THROW_in_throwStatement519 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_throwStatement521 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TRY_in_tryStatement536 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_tryStatement538 = new BitSet(new long[]{0x0000000000008208L});
    public static final BitSet FOLLOW_catchClause_in_tryStatement540 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_finallyClause_in_tryStatement543 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CATCH_in_catchClause560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_catchClause562 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_block_in_catchClause564 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause580 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_finallyClause582 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_expression595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CEXPR_in_expression603 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expression605 = new BitSet(new long[]{0x0000000052741078L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_leftHandSideExpression_in_expr619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_expr630 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr632 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr634 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MULASS_in_expr643 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr645 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr647 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVASS_in_expr656 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr658 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr660 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODASS_in_expr669 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr671 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr673 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ADDASS_in_expr682 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr684 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUBASS_in_expr695 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr697 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr699 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHLASS_in_expr708 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr710 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr712 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHRASS_in_expr721 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr723 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr725 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHUASS_in_expr734 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr736 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr738 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ANDASS_in_expr747 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr749 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr751 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_XORASS_in_expr760 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr762 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr764 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORASS_in_expr773 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr775 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr777 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUE_in_expr790 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr792 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr794 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr796 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOR_in_expr809 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr811 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr813 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LAND_in_expr822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr824 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr826 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr839 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr841 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr843 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr852 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr854 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr856 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_XOR_in_expr865 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr867 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr869 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr882 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr884 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr886 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr895 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr897 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr899 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAME_in_expr908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr910 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr912 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NSAME_in_expr921 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr923 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr925 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr938 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr940 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr942 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr951 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr953 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr955 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LTE_in_expr964 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr966 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GTE_in_expr977 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr979 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr981 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INSTANCEOF_in_expr990 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr992 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr994 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_expr1003 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1005 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr1007 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHL_in_expr1020 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1022 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr1024 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHR_in_expr1033 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1035 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr1037 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHU_in_expr1046 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1048 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr1050 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ADD_in_expr1063 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1065 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr1067 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUB_in_expr1076 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1078 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr1080 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MUL_in_expr1093 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1095 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr1097 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1106 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1108 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr1110 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1119 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1121 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_expr1123 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DELETE_in_expr1136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1138 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VOID_in_expr1147 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1149 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPEOF_in_expr1158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1160 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INC_in_expr1169 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1171 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEC_in_expr1180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1182 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POS_in_expr1191 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1193 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr1202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1204 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INV_in_expr1213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1215 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1226 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PINC_in_expr1239 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1241 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PDEC_in_expr1250 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1252 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_primaryExpression_in_leftHandSideExpression1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_leftHandSideExpression1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_leftHandSideExpression1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callExpression_in_leftHandSideExpression1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberExpression_in_leftHandSideExpression1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_newExpression1298 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_primaryExpression_in_newExpression1300 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_functionDeclaration1315 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_functionDeclaration1317 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_ARGS_in_functionDeclaration1322 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_functionDeclaration1324 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_functionDeclaration1329 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CALL_in_callExpression1344 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_callExpression1346 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_ARGS_in_callExpression1350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_callExpression1352 = new BitSet(new long[]{0x0000000052741078L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_BYINDEX_in_memberExpression1371 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_memberExpression1373 = new BitSet(new long[]{0x0000000052741070L,0x81EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expression_in_memberExpression1375 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BYFIELD_in_memberExpression1384 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_memberExpression1386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_Identifier_in_memberExpression1388 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Identifier_in_primaryExpression1401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primaryExpression1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_literal1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_literal1427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RegularExpressionLiteral_in_literal1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayLiteral_in_literal1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectLiteral_in_literal1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_booleanLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_numericLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_arrayLiteral1502 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ITEM_in_arrayLiteral1508 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayLiteral1510 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OBJECT_in_objectLiteral1531 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NAMEDVALUE_in_objectLiteral1537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyName_in_objectLiteral1539 = new BitSet(new long[]{0x0000000052741070L,0x80EBFFEFFFFFF800L,0x0000001C4180001DL});
    public static final BitSet FOLLOW_expr_in_objectLiteral1541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Identifier_in_propertyName1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_propertyName1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_propertyName1569 = new BitSet(new long[]{0x0000000000000002L});

}