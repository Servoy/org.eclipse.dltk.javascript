// $ANTLR 3.0.1 JS.g 2013-01-10 21:56:49

package org.eclipse.dltk.javascript.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * @since 6.0
 */
@SuppressWarnings({"unused"})
public class JSLexer extends Lexer {
    public static final int PACKAGE=58;
    public static final int FUNCTION=18;
    public static final int SHR=93;
    public static final int VT=157;
    public static final int RegularExpressionChar=195;
    public static final int LOCALNAME=130;
    public static final int XMLFragmentEnd=121;
    public static final int SHL=92;
    public static final int MOD=89;
    public static final int CONST=43;
    public static final int LineTerminatorChar=168;
    public static final int DQUOTE=154;
    public static final int DO=13;
    public static final int NOT=98;
    public static final int EOF=-1;
    public static final int CEXPR=132;
    public static final int DIVASS=116;
    public static final int BYINDEX=128;
    public static final int INC=90;
    public static final int RPAREN=72;
    public static final int FINAL=49;
    public static final int FORSTEP=135;
    public static final int IMPORT=53;
    public static final int EOL=170;
    public static final int OctalDigit=181;
    public static final int RETURN=23;
    public static final int THIS=25;
    public static final int GET=33;
    public static final int WhiteSpace=163;
    public static final int EXPORT=47;
    public static final int EQ=82;
    public static final int GOTO=51;
    public static final int XORASS=114;
    public static final int SHU=94;
    public static final int RBRACK=74;
    public static final int RBRACE=70;
    public static final int STATIC=63;
    public static final int INV=99;
    public static final int ELSE=14;
    public static final int NATIVE=57;
    public static final int INT=54;
    public static final int DEFAULT_XML_NAMESPACE=139;
    public static final int FF=158;
    public static final int OctalEscapeSequence=189;
    public static final int RegularExpressionFirstChar=194;
    public static final int TYPEOF=28;
    public static final int GT=79;
    public static final int CALL=131;
    public static final int CharacterEscapeSequence=187;
    public static final int LAND=100;
    public static final int PINC=147;
    public static final int UnicodeFormatCategory=162;
    public static final int PROTECTED=60;
    public static final int LBRACK=73;
    public static final int LBRACE=69;
    public static final int RegularExpressionLiteral=180;
    public static final int SUB=87;
    public static final int FLOAT=50;
    public static final int DecimalIntegerLiteral=183;
    public static final int HexDigit=174;
    public static final int LPAREN=71;
    public static final int AT=117;
    public static final int IMPLEMENTS=52;
    public static final int YIELD=35;
    public static final int SHRASS=110;
    public static final int PS=167;
    public static final int MultiLineComment=171;
    public static final int ADD=86;
    public static final int ZeroToThree=188;
    public static final int ITEM=140;
    public static final int UnicodeEscapeSequence=191;
    public static final int SHUASS=111;
    public static final int SET=34;
    public static final int SHORT=62;
    public static final int INSTANCEOF=21;
    public static final int SQUOTE=155;
    public static final int Tokens=196;
    public static final int SAME=84;
    public static final int StringLiteral=173;
    public static final int COLON=103;
    public static final int XMLFragment=120;
    public static final int PAREXPR=145;
    public static final int ENUM=46;
    public static final int CALL_ARGUMENTS=123;
    public static final int HexIntegerLiteral=186;
    public static final int NBSP=160;
    public static final int SP=159;
    public static final int BLOCK=126;
    public static final int LineTerminator=169;
    public static final int INTERFACE=55;
    public static final int DIV=115;
    public static final int FUNCTION_DECLARATION=152;
    public static final int LONG=56;
    public static final int CR=165;
    public static final int PUBLIC=61;
    public static final int LOR=101;
    public static final int LT=78;
    public static final int WHILE=31;
    public static final int BackslashSequence=193;
    public static final int LS=166;
    public static final int CASE=8;
    public static final int NEW=22;
    public static final int CHAR=41;
    public static final int DecimalDigit=176;
    public static final int BYFIELD=127;
    public static final int BREAK=7;
    public static final int Identifier=179;
    public static final int WXML=36;
    public static final int POS=148;
    public static final int DOUBLE=45;
    public static final int ExponentPart=182;
    public static final int VAR=29;
    public static final int VOID=30;
    public static final int SUPER=64;
    public static final int EACH=17;
    public static final int LABELLED=141;
    public static final int ADDASS=105;
    public static final int ARRAY=125;
    public static final int ARGUMENTS=124;
    public static final int PRIVATE=59;
    public static final int SWITCH=24;
    public static final int NULL=4;
    public static final int THROWS=66;
    public static final int DELETE=12;
    public static final int MUL=88;
    public static final int IdentifierStartASCII=175;
    public static final int TRY=27;
    public static final int NAMESPACE=37;
    public static final int SHLASS=109;
    public static final int COLONCOLON=119;
    public static final int USP=161;
    public static final int ANDASS=112;
    public static final int EMPTY_STATEMENT=151;
    public static final int IdentifierNameASCIIStart=178;
    public static final int QUE=102;
    public static final int OR=96;
    public static final int SETTER=138;
    public static final int DEBUGGER=44;
    public static final int FOREACH=136;
    public static final int PDEC=146;
    public static final int CATCH=9;
    public static final int FALSE=6;
    public static final int EscapeSequence=192;
    public static final int THROW=26;
    public static final int MULASS=107;
    public static final int XmlAttribute=149;
    public static final int DEC=91;
    public static final int OctalIntegerLiteral=185;
    public static final int CLASS=42;
    public static final int HexEscapeSequence=190;
    public static final int ORASS=113;
    public static final int NAMEDVALUE=142;
    public static final int SingleLineComment=172;
    public static final int GTE=81;
    public static final int XMLFragmentError=122;
    public static final int FOR=16;
    public static final int DOTDOT=118;
    public static final int ABSTRACT=38;
    public static final int AND=95;
    public static final int LTE=80;
    public static final int IF=19;
    public static final int SUBASS=106;
    public static final int SYNCHRONIZED=65;
    public static final int BOOLEAN=39;
    public static final int EXPR=133;
    public static final int IN=20;
    public static final int CONTINUE=10;
    public static final int OBJECT=144;
    public static final int COMMA=77;
    public static final int TRANSIENT=67;
    public static final int FORITER=134;
    public static final int MODASS=108;
    public static final int DOT=75;
    public static final int IdentifierPart=177;
    public static final int WITH=32;
    public static final int BYTE=40;
    public static final int XOR=97;
    public static final int VOLATILE=68;
    public static final int GETTER=137;
    public static final int NSAME=85;
    public static final int DEFAULT=11;
    public static final int ALLCHILDREN=129;
    public static final int TAB=156;
    public static final int DecimalLiteral=184;
    public static final int TRUE=5;
    public static final int NEQ=83;
    public static final int FINALLY=15;
    public static final int NEG=143;
    public static final int ASSIGN=104;
    public static final int XML_LITERAL=150;
    public static final int SEMIC=76;
    public static final int EXTENDS=48;
    public static final int BSLASH=153;
    public static final int LF=164;

    private Token lastCodeToken;
    protected Token lastToken;

    final static boolean isIdentifierKeyword(int token)
    {
    	return token == WXML
    		|| token == GET
      		|| token == SET
      		|| token == EACH
      		|| token == NAMESPACE; 
    }

    protected final boolean areRegularExpressionsEnabled()
    {
    	if (lastCodeToken == null)
    	{
    		return true;
    	}
    	if (isIdentifierKeyword(lastCodeToken.getType())) {
    		return false; 
    	}
    	switch (lastCodeToken.getType())
    	{
    	// identifier
    		case Identifier:
    	// XmlAttribute = Identifier or isIdentifierKeyword()
    	// literals
    		case NULL:
    		case TRUE:
    		case FALSE:
    		case THIS:
    		case OctalIntegerLiteral:
    		case DecimalLiteral:
    		case HexIntegerLiteral:
    		case StringLiteral:
    	// member access ending 
    		case RBRACK:
    	// function call or nested expression ending
    		case RPAREN:
    	//++,--
    	    case INC:
    	    case DEC:
    			return false;
    	// otherwise OK
    		default:
    			return true;
    	}
    }

    protected boolean isXmlStartEnabled() {
    	return false;
    }

    protected void readFirstXml() throws RecognitionException {
    	throw new EarlyExitException(0, input);
    }

    private final void consumeIdentifierUnicodeStart() throws RecognitionException, NoViableAltException
    {
    	int ch = input.LA(1);
    	if (isIdentifierStartUnicode(ch))
    	{
    		matchAny();
    		do
    		{
    			ch = input.LA(1);
    			if (ch == '$' || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || ch == '\\' || ch == '_' || (ch >= 'a' && ch <= 'z') || isIdentifierPartUnicode(ch))
    			{
    				mIdentifierPart();
    			}
    			else
    			{
    				return;
    			}
    		}
    		while (true);
    	}
    	else
    	{
    		throw new NoIdentifierException();
    	}
    }
    	
    private final boolean isIdentifierPartUnicode(int ch)
    {
    	return Character.isJavaIdentifierPart((char)ch);
    }
    	
    private final boolean isIdentifierStartUnicode(int ch)
    {
    	return Character.isJavaIdentifierStart((char)ch);
    }

    public Token nextToken()
    {
    	Token result = super.nextToken();
    	lastToken = result;
    	if (result.getChannel() == Token.DEFAULT_CHANNEL) {
    		lastCodeToken = result;
    	}
    	return result;		
    }


    public JSLexer() {;} 
    public JSLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "JS.g"; }

    // $ANTLR start NULL
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            // JS.g:115:6: ( 'null' )
            // JS.g:115:8: 'null'
            {
            match("null"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NULL

    // $ANTLR start TRUE
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            // JS.g:116:6: ( 'true' )
            // JS.g:116:8: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TRUE

    // $ANTLR start FALSE
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            // JS.g:117:7: ( 'false' )
            // JS.g:117:9: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FALSE

    // $ANTLR start BREAK
    public final void mBREAK() throws RecognitionException {
        try {
            int _type = BREAK;
            // JS.g:118:7: ( 'break' )
            // JS.g:118:9: 'break'
            {
            match("break"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BREAK

    // $ANTLR start CASE
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            // JS.g:119:6: ( 'case' )
            // JS.g:119:8: 'case'
            {
            match("case"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CASE

    // $ANTLR start CATCH
    public final void mCATCH() throws RecognitionException {
        try {
            int _type = CATCH;
            // JS.g:120:7: ( 'catch' )
            // JS.g:120:9: 'catch'
            {
            match("catch"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CATCH

    // $ANTLR start CONTINUE
    public final void mCONTINUE() throws RecognitionException {
        try {
            int _type = CONTINUE;
            // JS.g:121:10: ( 'continue' )
            // JS.g:121:12: 'continue'
            {
            match("continue"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CONTINUE

    // $ANTLR start DEFAULT
    public final void mDEFAULT() throws RecognitionException {
        try {
            int _type = DEFAULT;
            // JS.g:122:9: ( 'default' )
            // JS.g:122:11: 'default'
            {
            match("default"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DEFAULT

    // $ANTLR start DELETE
    public final void mDELETE() throws RecognitionException {
        try {
            int _type = DELETE;
            // JS.g:123:8: ( 'delete' )
            // JS.g:123:10: 'delete'
            {
            match("delete"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DELETE

    // $ANTLR start DO
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            // JS.g:124:4: ( 'do' )
            // JS.g:124:6: 'do'
            {
            match("do"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DO

    // $ANTLR start ELSE
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            // JS.g:125:6: ( 'else' )
            // JS.g:125:8: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ELSE

    // $ANTLR start FINALLY
    public final void mFINALLY() throws RecognitionException {
        try {
            int _type = FINALLY;
            // JS.g:126:9: ( 'finally' )
            // JS.g:126:11: 'finally'
            {
            match("finally"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FINALLY

    // $ANTLR start FOR
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            // JS.g:127:5: ( 'for' )
            // JS.g:127:7: 'for'
            {
            match("for"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FOR

    // $ANTLR start EACH
    public final void mEACH() throws RecognitionException {
        try {
            int _type = EACH;
            // JS.g:128:6: ( 'each' )
            // JS.g:128:8: 'each'
            {
            match("each"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EACH

    // $ANTLR start FUNCTION
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            // JS.g:129:10: ( 'function' )
            // JS.g:129:12: 'function'
            {
            match("function"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FUNCTION

    // $ANTLR start IF
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            // JS.g:130:4: ( 'if' )
            // JS.g:130:6: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IF

    // $ANTLR start IN
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            // JS.g:131:4: ( 'in' )
            // JS.g:131:6: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IN

    // $ANTLR start INSTANCEOF
    public final void mINSTANCEOF() throws RecognitionException {
        try {
            int _type = INSTANCEOF;
            // JS.g:132:12: ( 'instanceof' )
            // JS.g:132:14: 'instanceof'
            {
            match("instanceof"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INSTANCEOF

    // $ANTLR start NEW
    public final void mNEW() throws RecognitionException {
        try {
            int _type = NEW;
            // JS.g:133:5: ( 'new' )
            // JS.g:133:7: 'new'
            {
            match("new"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEW

    // $ANTLR start RETURN
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            // JS.g:134:8: ( 'return' )
            // JS.g:134:10: 'return'
            {
            match("return"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RETURN

    // $ANTLR start SWITCH
    public final void mSWITCH() throws RecognitionException {
        try {
            int _type = SWITCH;
            // JS.g:135:8: ( 'switch' )
            // JS.g:135:10: 'switch'
            {
            match("switch"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SWITCH

    // $ANTLR start THIS
    public final void mTHIS() throws RecognitionException {
        try {
            int _type = THIS;
            // JS.g:136:6: ( 'this' )
            // JS.g:136:8: 'this'
            {
            match("this"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end THIS

    // $ANTLR start THROW
    public final void mTHROW() throws RecognitionException {
        try {
            int _type = THROW;
            // JS.g:137:7: ( 'throw' )
            // JS.g:137:9: 'throw'
            {
            match("throw"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end THROW

    // $ANTLR start TRY
    public final void mTRY() throws RecognitionException {
        try {
            int _type = TRY;
            // JS.g:138:5: ( 'try' )
            // JS.g:138:7: 'try'
            {
            match("try"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TRY

    // $ANTLR start TYPEOF
    public final void mTYPEOF() throws RecognitionException {
        try {
            int _type = TYPEOF;
            // JS.g:139:8: ( 'typeof' )
            // JS.g:139:10: 'typeof'
            {
            match("typeof"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TYPEOF

    // $ANTLR start VAR
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            // JS.g:140:5: ( 'var' )
            // JS.g:140:7: 'var'
            {
            match("var"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end VAR

    // $ANTLR start VOID
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            // JS.g:141:6: ( 'void' )
            // JS.g:141:8: 'void'
            {
            match("void"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end VOID

    // $ANTLR start WHILE
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            // JS.g:142:7: ( 'while' )
            // JS.g:142:9: 'while'
            {
            match("while"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WHILE

    // $ANTLR start WITH
    public final void mWITH() throws RecognitionException {
        try {
            int _type = WITH;
            // JS.g:143:6: ( 'with' )
            // JS.g:143:8: 'with'
            {
            match("with"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WITH

    // $ANTLR start GET
    public final void mGET() throws RecognitionException {
        try {
            int _type = GET;
            // JS.g:144:5: ( 'get' )
            // JS.g:144:7: 'get'
            {
            match("get"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GET

    // $ANTLR start SET
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            // JS.g:145:5: ( 'set' )
            // JS.g:145:7: 'set'
            {
            match("set"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SET

    // $ANTLR start YIELD
    public final void mYIELD() throws RecognitionException {
        try {
            int _type = YIELD;
            // JS.g:146:7: ( 'yield' )
            // JS.g:146:9: 'yield'
            {
            match("yield"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end YIELD

    // $ANTLR start WXML
    public final void mWXML() throws RecognitionException {
        try {
            int _type = WXML;
            // JS.g:147:6: ( 'xml' )
            // JS.g:147:8: 'xml'
            {
            match("xml"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WXML

    // $ANTLR start NAMESPACE
    public final void mNAMESPACE() throws RecognitionException {
        try {
            int _type = NAMESPACE;
            // JS.g:148:11: ( 'namespace' )
            // JS.g:148:13: 'namespace'
            {
            match("namespace"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NAMESPACE

    // $ANTLR start ABSTRACT
    public final void mABSTRACT() throws RecognitionException {
        try {
            int _type = ABSTRACT;
            // JS.g:149:10: ( 'abstract' )
            // JS.g:149:12: 'abstract'
            {
            match("abstract"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ABSTRACT

    // $ANTLR start BOOLEAN
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            // JS.g:150:9: ( 'boolean' )
            // JS.g:150:11: 'boolean'
            {
            match("boolean"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BOOLEAN

    // $ANTLR start BYTE
    public final void mBYTE() throws RecognitionException {
        try {
            int _type = BYTE;
            // JS.g:151:6: ( 'byte' )
            // JS.g:151:8: 'byte'
            {
            match("byte"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BYTE

    // $ANTLR start CHAR
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            // JS.g:152:6: ( 'char' )
            // JS.g:152:8: 'char'
            {
            match("char"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CHAR

    // $ANTLR start CLASS
    public final void mCLASS() throws RecognitionException {
        try {
            int _type = CLASS;
            // JS.g:153:7: ( 'class' )
            // JS.g:153:9: 'class'
            {
            match("class"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CLASS

    // $ANTLR start CONST
    public final void mCONST() throws RecognitionException {
        try {
            int _type = CONST;
            // JS.g:154:7: ( 'const' )
            // JS.g:154:9: 'const'
            {
            match("const"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CONST

    // $ANTLR start DEBUGGER
    public final void mDEBUGGER() throws RecognitionException {
        try {
            int _type = DEBUGGER;
            // JS.g:155:10: ( 'debugger' )
            // JS.g:155:12: 'debugger'
            {
            match("debugger"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DEBUGGER

    // $ANTLR start DOUBLE
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            // JS.g:156:8: ( 'double' )
            // JS.g:156:10: 'double'
            {
            match("double"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE

    // $ANTLR start ENUM
    public final void mENUM() throws RecognitionException {
        try {
            int _type = ENUM;
            // JS.g:157:6: ( 'enum' )
            // JS.g:157:8: 'enum'
            {
            match("enum"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ENUM

    // $ANTLR start EXPORT
    public final void mEXPORT() throws RecognitionException {
        try {
            int _type = EXPORT;
            // JS.g:158:8: ( 'export' )
            // JS.g:158:10: 'export'
            {
            match("export"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EXPORT

    // $ANTLR start EXTENDS
    public final void mEXTENDS() throws RecognitionException {
        try {
            int _type = EXTENDS;
            // JS.g:159:9: ( 'extends' )
            // JS.g:159:11: 'extends'
            {
            match("extends"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EXTENDS

    // $ANTLR start FINAL
    public final void mFINAL() throws RecognitionException {
        try {
            int _type = FINAL;
            // JS.g:160:7: ( 'final' )
            // JS.g:160:9: 'final'
            {
            match("final"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FINAL

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            // JS.g:161:7: ( 'float' )
            // JS.g:161:9: 'float'
            {
            match("float"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    // $ANTLR start GOTO
    public final void mGOTO() throws RecognitionException {
        try {
            int _type = GOTO;
            // JS.g:162:6: ( 'goto' )
            // JS.g:162:8: 'goto'
            {
            match("goto"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GOTO

    // $ANTLR start IMPLEMENTS
    public final void mIMPLEMENTS() throws RecognitionException {
        try {
            int _type = IMPLEMENTS;
            // JS.g:163:12: ( 'implements' )
            // JS.g:163:14: 'implements'
            {
            match("implements"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IMPLEMENTS

    // $ANTLR start IMPORT
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            // JS.g:164:8: ( 'import' )
            // JS.g:164:10: 'import'
            {
            match("import"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IMPORT

    // $ANTLR start INT
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            // JS.g:165:5: ( 'int' )
            // JS.g:165:7: 'int'
            {
            match("int"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INT

    // $ANTLR start INTERFACE
    public final void mINTERFACE() throws RecognitionException {
        try {
            int _type = INTERFACE;
            // JS.g:166:11: ( 'interface' )
            // JS.g:166:13: 'interface'
            {
            match("interface"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INTERFACE

    // $ANTLR start LONG
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            // JS.g:167:6: ( 'long' )
            // JS.g:167:8: 'long'
            {
            match("long"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LONG

    // $ANTLR start NATIVE
    public final void mNATIVE() throws RecognitionException {
        try {
            int _type = NATIVE;
            // JS.g:168:8: ( 'native' )
            // JS.g:168:10: 'native'
            {
            match("native"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NATIVE

    // $ANTLR start PACKAGE
    public final void mPACKAGE() throws RecognitionException {
        try {
            int _type = PACKAGE;
            // JS.g:169:9: ( 'package' )
            // JS.g:169:11: 'package'
            {
            match("package"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PACKAGE

    // $ANTLR start PRIVATE
    public final void mPRIVATE() throws RecognitionException {
        try {
            int _type = PRIVATE;
            // JS.g:170:9: ( 'private' )
            // JS.g:170:11: 'private'
            {
            match("private"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PRIVATE

    // $ANTLR start PROTECTED
    public final void mPROTECTED() throws RecognitionException {
        try {
            int _type = PROTECTED;
            // JS.g:171:11: ( 'protected' )
            // JS.g:171:13: 'protected'
            {
            match("protected"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PROTECTED

    // $ANTLR start PUBLIC
    public final void mPUBLIC() throws RecognitionException {
        try {
            int _type = PUBLIC;
            // JS.g:172:8: ( 'public' )
            // JS.g:172:10: 'public'
            {
            match("public"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PUBLIC

    // $ANTLR start SHORT
    public final void mSHORT() throws RecognitionException {
        try {
            int _type = SHORT;
            // JS.g:173:7: ( 'short' )
            // JS.g:173:9: 'short'
            {
            match("short"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SHORT

    // $ANTLR start STATIC
    public final void mSTATIC() throws RecognitionException {
        try {
            int _type = STATIC;
            // JS.g:174:8: ( 'static' )
            // JS.g:174:10: 'static'
            {
            match("static"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STATIC

    // $ANTLR start SUPER
    public final void mSUPER() throws RecognitionException {
        try {
            int _type = SUPER;
            // JS.g:175:7: ( 'super' )
            // JS.g:175:9: 'super'
            {
            match("super"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SUPER

    // $ANTLR start SYNCHRONIZED
    public final void mSYNCHRONIZED() throws RecognitionException {
        try {
            int _type = SYNCHRONIZED;
            // JS.g:176:14: ( 'synchronized' )
            // JS.g:176:16: 'synchronized'
            {
            match("synchronized"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SYNCHRONIZED

    // $ANTLR start THROWS
    public final void mTHROWS() throws RecognitionException {
        try {
            int _type = THROWS;
            // JS.g:177:8: ( 'throws' )
            // JS.g:177:10: 'throws'
            {
            match("throws"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end THROWS

    // $ANTLR start TRANSIENT
    public final void mTRANSIENT() throws RecognitionException {
        try {
            int _type = TRANSIENT;
            // JS.g:178:11: ( 'transient' )
            // JS.g:178:13: 'transient'
            {
            match("transient"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TRANSIENT

    // $ANTLR start VOLATILE
    public final void mVOLATILE() throws RecognitionException {
        try {
            int _type = VOLATILE;
            // JS.g:179:10: ( 'volatile' )
            // JS.g:179:12: 'volatile'
            {
            match("volatile"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end VOLATILE

    // $ANTLR start LBRACE
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            // JS.g:180:8: ( '{' )
            // JS.g:180:10: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LBRACE

    // $ANTLR start RBRACE
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            // JS.g:181:8: ( '}' )
            // JS.g:181:10: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RBRACE

    // $ANTLR start LPAREN
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            // JS.g:182:8: ( '(' )
            // JS.g:182:10: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LPAREN

    // $ANTLR start RPAREN
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            // JS.g:183:8: ( ')' )
            // JS.g:183:10: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RPAREN

    // $ANTLR start LBRACK
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            // JS.g:184:8: ( '[' )
            // JS.g:184:10: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LBRACK

    // $ANTLR start RBRACK
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            // JS.g:185:8: ( ']' )
            // JS.g:185:10: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RBRACK

    // $ANTLR start DOT
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            // JS.g:186:5: ( '.' )
            // JS.g:186:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOT

    // $ANTLR start SEMIC
    public final void mSEMIC() throws RecognitionException {
        try {
            int _type = SEMIC;
            // JS.g:187:7: ( ';' )
            // JS.g:187:9: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMIC

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // JS.g:188:7: ( ',' )
            // JS.g:188:9: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start LT
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            // JS.g:189:4: ( '<' )
            // JS.g:189:6: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LT

    // $ANTLR start GT
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            // JS.g:190:4: ( '>' )
            // JS.g:190:6: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GT

    // $ANTLR start LTE
    public final void mLTE() throws RecognitionException {
        try {
            int _type = LTE;
            // JS.g:191:5: ( '<=' )
            // JS.g:191:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LTE

    // $ANTLR start GTE
    public final void mGTE() throws RecognitionException {
        try {
            int _type = GTE;
            // JS.g:192:5: ( '>=' )
            // JS.g:192:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GTE

    // $ANTLR start EQ
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            // JS.g:193:4: ( '==' )
            // JS.g:193:6: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQ

    // $ANTLR start NEQ
    public final void mNEQ() throws RecognitionException {
        try {
            int _type = NEQ;
            // JS.g:194:5: ( '!=' )
            // JS.g:194:7: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEQ

    // $ANTLR start SAME
    public final void mSAME() throws RecognitionException {
        try {
            int _type = SAME;
            // JS.g:195:6: ( '===' )
            // JS.g:195:8: '==='
            {
            match("==="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SAME

    // $ANTLR start NSAME
    public final void mNSAME() throws RecognitionException {
        try {
            int _type = NSAME;
            // JS.g:196:7: ( '!==' )
            // JS.g:196:9: '!=='
            {
            match("!=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NSAME

    // $ANTLR start ADD
    public final void mADD() throws RecognitionException {
        try {
            int _type = ADD;
            // JS.g:197:5: ( '+' )
            // JS.g:197:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ADD

    // $ANTLR start SUB
    public final void mSUB() throws RecognitionException {
        try {
            int _type = SUB;
            // JS.g:198:5: ( '-' )
            // JS.g:198:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SUB

    // $ANTLR start MUL
    public final void mMUL() throws RecognitionException {
        try {
            int _type = MUL;
            // JS.g:199:5: ( '*' )
            // JS.g:199:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MUL

    // $ANTLR start MOD
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            // JS.g:200:5: ( '%' )
            // JS.g:200:7: '%'
            {
            match('%'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MOD

    // $ANTLR start INC
    public final void mINC() throws RecognitionException {
        try {
            int _type = INC;
            // JS.g:201:5: ( '++' )
            // JS.g:201:7: '++'
            {
            match("++"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INC

    // $ANTLR start DEC
    public final void mDEC() throws RecognitionException {
        try {
            int _type = DEC;
            // JS.g:202:5: ( '--' )
            // JS.g:202:7: '--'
            {
            match("--"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DEC

    // $ANTLR start SHL
    public final void mSHL() throws RecognitionException {
        try {
            int _type = SHL;
            // JS.g:203:5: ( '<<' )
            // JS.g:203:7: '<<'
            {
            match("<<"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SHL

    // $ANTLR start SHR
    public final void mSHR() throws RecognitionException {
        try {
            int _type = SHR;
            // JS.g:204:5: ( '>>' )
            // JS.g:204:7: '>>'
            {
            match(">>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SHR

    // $ANTLR start SHU
    public final void mSHU() throws RecognitionException {
        try {
            int _type = SHU;
            // JS.g:205:5: ( '>>>' )
            // JS.g:205:7: '>>>'
            {
            match(">>>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SHU

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // JS.g:206:5: ( '&' )
            // JS.g:206:7: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AND

    // $ANTLR start OR
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            // JS.g:207:4: ( '|' )
            // JS.g:207:6: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OR

    // $ANTLR start XOR
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            // JS.g:208:5: ( '^' )
            // JS.g:208:7: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end XOR

    // $ANTLR start NOT
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            // JS.g:209:5: ( '!' )
            // JS.g:209:7: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOT

    // $ANTLR start INV
    public final void mINV() throws RecognitionException {
        try {
            int _type = INV;
            // JS.g:210:5: ( '~' )
            // JS.g:210:7: '~'
            {
            match('~'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INV

    // $ANTLR start LAND
    public final void mLAND() throws RecognitionException {
        try {
            int _type = LAND;
            // JS.g:211:6: ( '&&' )
            // JS.g:211:8: '&&'
            {
            match("&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LAND

    // $ANTLR start LOR
    public final void mLOR() throws RecognitionException {
        try {
            int _type = LOR;
            // JS.g:212:5: ( '||' )
            // JS.g:212:7: '||'
            {
            match("||"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LOR

    // $ANTLR start QUE
    public final void mQUE() throws RecognitionException {
        try {
            int _type = QUE;
            // JS.g:213:5: ( '?' )
            // JS.g:213:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUE

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            // JS.g:214:7: ( ':' )
            // JS.g:214:9: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start ASSIGN
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            // JS.g:215:8: ( '=' )
            // JS.g:215:10: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ASSIGN

    // $ANTLR start ADDASS
    public final void mADDASS() throws RecognitionException {
        try {
            int _type = ADDASS;
            // JS.g:216:8: ( '+=' )
            // JS.g:216:10: '+='
            {
            match("+="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ADDASS

    // $ANTLR start SUBASS
    public final void mSUBASS() throws RecognitionException {
        try {
            int _type = SUBASS;
            // JS.g:217:8: ( '-=' )
            // JS.g:217:10: '-='
            {
            match("-="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SUBASS

    // $ANTLR start MULASS
    public final void mMULASS() throws RecognitionException {
        try {
            int _type = MULASS;
            // JS.g:218:8: ( '*=' )
            // JS.g:218:10: '*='
            {
            match("*="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MULASS

    // $ANTLR start MODASS
    public final void mMODASS() throws RecognitionException {
        try {
            int _type = MODASS;
            // JS.g:219:8: ( '%=' )
            // JS.g:219:10: '%='
            {
            match("%="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MODASS

    // $ANTLR start SHLASS
    public final void mSHLASS() throws RecognitionException {
        try {
            int _type = SHLASS;
            // JS.g:220:8: ( '<<=' )
            // JS.g:220:10: '<<='
            {
            match("<<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SHLASS

    // $ANTLR start SHRASS
    public final void mSHRASS() throws RecognitionException {
        try {
            int _type = SHRASS;
            // JS.g:221:8: ( '>>=' )
            // JS.g:221:10: '>>='
            {
            match(">>="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SHRASS

    // $ANTLR start SHUASS
    public final void mSHUASS() throws RecognitionException {
        try {
            int _type = SHUASS;
            // JS.g:222:8: ( '>>>=' )
            // JS.g:222:10: '>>>='
            {
            match(">>>="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SHUASS

    // $ANTLR start ANDASS
    public final void mANDASS() throws RecognitionException {
        try {
            int _type = ANDASS;
            // JS.g:223:8: ( '&=' )
            // JS.g:223:10: '&='
            {
            match("&="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ANDASS

    // $ANTLR start ORASS
    public final void mORASS() throws RecognitionException {
        try {
            int _type = ORASS;
            // JS.g:224:7: ( '|=' )
            // JS.g:224:9: '|='
            {
            match("|="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ORASS

    // $ANTLR start XORASS
    public final void mXORASS() throws RecognitionException {
        try {
            int _type = XORASS;
            // JS.g:225:8: ( '^=' )
            // JS.g:225:10: '^='
            {
            match("^="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end XORASS

    // $ANTLR start DIV
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            // JS.g:226:5: ( '/' )
            // JS.g:226:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIV

    // $ANTLR start DIVASS
    public final void mDIVASS() throws RecognitionException {
        try {
            int _type = DIVASS;
            // JS.g:227:8: ( '/=' )
            // JS.g:227:10: '/='
            {
            match("/="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIVASS

    // $ANTLR start AT
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            // JS.g:228:4: ( '@' )
            // JS.g:228:6: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AT

    // $ANTLR start DOTDOT
    public final void mDOTDOT() throws RecognitionException {
        try {
            int _type = DOTDOT;
            // JS.g:229:8: ( '..' )
            // JS.g:229:10: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOTDOT

    // $ANTLR start COLONCOLON
    public final void mCOLONCOLON() throws RecognitionException {
        try {
            int _type = COLONCOLON;
            // JS.g:230:12: ( '::' )
            // JS.g:230:14: '::'
            {
            match("::"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLONCOLON

    // $ANTLR start BSLASH
    public final void mBSLASH() throws RecognitionException {
        try {
            // JS.g:492:2: ( '\\\\' )
            // JS.g:492:4: '\\\\'
            {
            match('\\'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end BSLASH

    // $ANTLR start DQUOTE
    public final void mDQUOTE() throws RecognitionException {
        try {
            // JS.g:496:2: ( '\"' )
            // JS.g:496:4: '\"'
            {
            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end DQUOTE

    // $ANTLR start SQUOTE
    public final void mSQUOTE() throws RecognitionException {
        try {
            // JS.g:500:2: ( '\\'' )
            // JS.g:500:4: '\\''
            {
            match('\''); 

            }

        }
        finally {
        }
    }
    // $ANTLR end SQUOTE

    // $ANTLR start TAB
    public final void mTAB() throws RecognitionException {
        try {
            // JS.g:506:2: ( '\\u0009' )
            // JS.g:506:4: '\\u0009'
            {
            match('\t'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end TAB

    // $ANTLR start VT
    public final void mVT() throws RecognitionException {
        try {
            // JS.g:510:2: ( '\\u000b' )
            // JS.g:510:4: '\\u000b'
            {
            match('\u000B'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end VT

    // $ANTLR start FF
    public final void mFF() throws RecognitionException {
        try {
            // JS.g:514:2: ( '\\u000c' )
            // JS.g:514:4: '\\u000c'
            {
            match('\f'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end FF

    // $ANTLR start SP
    public final void mSP() throws RecognitionException {
        try {
            // JS.g:518:2: ( '\\u0020' )
            // JS.g:518:4: '\\u0020'
            {
            match(' '); 

            }

        }
        finally {
        }
    }
    // $ANTLR end SP

    // $ANTLR start NBSP
    public final void mNBSP() throws RecognitionException {
        try {
            // JS.g:522:2: ( '\\u00a0' )
            // JS.g:522:4: '\\u00a0'
            {
            match('\u00A0'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end NBSP

    // $ANTLR start USP
    public final void mUSP() throws RecognitionException {
        try {
            // JS.g:526:2: ( '\\u1680' | '\\u180E' | '\\u2000' | '\\u2001' | '\\u2002' | '\\u2003' | '\\u2004' | '\\u2005' | '\\u2006' | '\\u2007' | '\\u2008' | '\\u2009' | '\\u200A' | '\\u202F' | '\\u205F' | '\\u3000' )
            // JS.g:
            {
            if ( input.LA(1)=='\u1680'||input.LA(1)=='\u180E'||(input.LA(1)>='\u2000' && input.LA(1)<='\u200A')||input.LA(1)=='\u202F'||input.LA(1)=='\u205F'||input.LA(1)=='\u3000' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end USP

    // $ANTLR start UnicodeFormatCategory
    public final void mUnicodeFormatCategory() throws RecognitionException {
        try {
            // JS.g:545:2: ( '\\uFEFF' )
            // JS.g:545:4: '\\uFEFF'
            {
            match('\uFEFF'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end UnicodeFormatCategory

    // $ANTLR start WhiteSpace
    public final void mWhiteSpace() throws RecognitionException {
        try {
            int _type = WhiteSpace;
            // JS.g:549:2: ( ( TAB | VT | FF | SP | NBSP | USP | UnicodeFormatCategory )+ )
            // JS.g:549:4: ( TAB | VT | FF | SP | NBSP | USP | UnicodeFormatCategory )+
            {
            // JS.g:549:4: ( TAB | VT | FF | SP | NBSP | USP | UnicodeFormatCategory )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||(LA1_0>='\u000B' && LA1_0<='\f')||LA1_0==' '||LA1_0=='\u00A0'||LA1_0=='\u1680'||LA1_0=='\u180E'||(LA1_0>='\u2000' && LA1_0<='\u200A')||LA1_0=='\u202F'||LA1_0=='\u205F'||LA1_0=='\u3000'||LA1_0=='\uFEFF') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // JS.g:
            	    {
            	    if ( input.LA(1)=='\t'||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||input.LA(1)==' '||input.LA(1)=='\u00A0'||input.LA(1)=='\u1680'||input.LA(1)=='\u180E'||(input.LA(1)>='\u2000' && input.LA(1)<='\u200A')||input.LA(1)=='\u202F'||input.LA(1)=='\u205F'||input.LA(1)=='\u3000'||input.LA(1)=='\uFEFF' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

             channel = HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WhiteSpace

    // $ANTLR start LF
    public final void mLF() throws RecognitionException {
        try {
            // JS.g:557:2: ( '\\n' )
            // JS.g:557:4: '\\n'
            {
            match('\n'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end LF

    // $ANTLR start CR
    public final void mCR() throws RecognitionException {
        try {
            // JS.g:561:2: ( '\\r' )
            // JS.g:561:4: '\\r'
            {
            match('\r'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end CR

    // $ANTLR start LS
    public final void mLS() throws RecognitionException {
        try {
            // JS.g:565:2: ( '\\u2028' )
            // JS.g:565:4: '\\u2028'
            {
            match('\u2028'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end LS

    // $ANTLR start PS
    public final void mPS() throws RecognitionException {
        try {
            // JS.g:569:2: ( '\\u2029' )
            // JS.g:569:4: '\\u2029'
            {
            match('\u2029'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end PS

    // $ANTLR start LineTerminatorChar
    public final void mLineTerminatorChar() throws RecognitionException {
        try {
            // JS.g:573:2: ( CR | LF | LS | PS )
            // JS.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r'||(input.LA(1)>='\u2028' && input.LA(1)<='\u2029') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end LineTerminatorChar

    // $ANTLR start LineTerminator
    public final void mLineTerminator() throws RecognitionException {
        try {
            // JS.g:577:2: ( ( CR ( LF )? ) | LF | LS | PS )
            int alt3=4;
            switch ( input.LA(1) ) {
            case '\r':
                {
                alt3=1;
                }
                break;
            case '\n':
                {
                alt3=2;
                }
                break;
            case '\u2028':
                {
                alt3=3;
                }
                break;
            case '\u2029':
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("576:10: fragment LineTerminator : ( ( CR ( LF )? ) | LF | LS | PS );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // JS.g:577:4: ( CR ( LF )? )
                    {
                    // JS.g:577:4: ( CR ( LF )? )
                    // JS.g:577:5: CR ( LF )?
                    {
                    mCR(); 
                    // JS.g:577:8: ( LF )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\n') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // JS.g:577:8: LF
                            {
                            mLF(); 

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // JS.g:577:15: LF
                    {
                    mLF(); 

                    }
                    break;
                case 3 :
                    // JS.g:577:20: LS
                    {
                    mLS(); 

                    }
                    break;
                case 4 :
                    // JS.g:577:25: PS
                    {
                    mPS(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end LineTerminator

    // $ANTLR start EOL
    public final void mEOL() throws RecognitionException {
        try {
            int _type = EOL;
            // JS.g:581:2: ( ( ( CR ( LF )? ) | LF | LS | PS ) )
            // JS.g:581:4: ( ( CR ( LF )? ) | LF | LS | PS )
            {
            // JS.g:581:4: ( ( CR ( LF )? ) | LF | LS | PS )
            int alt5=4;
            switch ( input.LA(1) ) {
            case '\r':
                {
                alt5=1;
                }
                break;
            case '\n':
                {
                alt5=2;
                }
                break;
            case '\u2028':
                {
                alt5=3;
                }
                break;
            case '\u2029':
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("581:4: ( ( CR ( LF )? ) | LF | LS | PS )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // JS.g:581:6: ( CR ( LF )? )
                    {
                    // JS.g:581:6: ( CR ( LF )? )
                    // JS.g:581:8: CR ( LF )?
                    {
                    mCR(); 
                    // JS.g:581:11: ( LF )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\n') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // JS.g:581:11: LF
                            {
                            mLF(); 

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // JS.g:581:19: LF
                    {
                    mLF(); 

                    }
                    break;
                case 3 :
                    // JS.g:581:24: LS
                    {
                    mLS(); 

                    }
                    break;
                case 4 :
                    // JS.g:581:29: PS
                    {
                    mPS(); 

                    }
                    break;

            }

             channel = HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EOL

    // $ANTLR start MultiLineComment
    public final void mMultiLineComment() throws RecognitionException {
        try {
            int _type = MultiLineComment;
            // JS.g:588:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // JS.g:588:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // JS.g:588:9: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFE')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // JS.g:588:41: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("*/"); 

             channel = HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MultiLineComment

    // $ANTLR start SingleLineComment
    public final void mSingleLineComment() throws RecognitionException {
        try {
            int _type = SingleLineComment;
            // JS.g:592:2: ( '//' (~ ( LineTerminatorChar ) )* )
            // JS.g:592:4: '//' (~ ( LineTerminatorChar ) )*
            {
            match("//"); 

            // JS.g:592:9: (~ ( LineTerminatorChar ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\u2027')||(LA7_0>='\u202A' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // JS.g:592:11: ~ ( LineTerminatorChar )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             channel = HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SingleLineComment

    // $ANTLR start IdentifierStartASCII
    public final void mIdentifierStartASCII() throws RecognitionException {
        try {
            // JS.g:700:2: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | BSLASH 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt8=1;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                {
                alt8=2;
                }
                break;
            case '$':
                {
                alt8=3;
                }
                break;
            case '_':
                {
                alt8=4;
                }
                break;
            case '\\':
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("699:10: fragment IdentifierStartASCII : ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | BSLASH 'u' HexDigit HexDigit HexDigit HexDigit );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // JS.g:700:4: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }
                    break;
                case 2 :
                    // JS.g:700:15: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }
                    break;
                case 3 :
                    // JS.g:701:4: '$'
                    {
                    match('$'); 

                    }
                    break;
                case 4 :
                    // JS.g:702:4: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 5 :
                    // JS.g:703:4: BSLASH 'u' HexDigit HexDigit HexDigit HexDigit
                    {
                    mBSLASH(); 
                    match('u'); 
                    mHexDigit(); 
                    mHexDigit(); 
                    mHexDigit(); 
                    mHexDigit(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end IdentifierStartASCII

    // $ANTLR start IdentifierPart
    public final void mIdentifierPart() throws RecognitionException {
        try {
            // JS.g:711:2: ( DecimalDigit | IdentifierStartASCII | {...}?)
            int alt9=3;
            switch ( input.LA(1) ) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt9=1;
                }
                break;
            case '$':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt9=2;
                }
                break;
            default:
                alt9=3;}

            switch (alt9) {
                case 1 :
                    // JS.g:711:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 2 :
                    // JS.g:712:4: IdentifierStartASCII
                    {
                    mIdentifierStartASCII(); 

                    }
                    break;
                case 3 :
                    // JS.g:713:4: {...}?
                    {
                    if ( !( isIdentifierPartUnicode(input.LA(1)) ) ) {
                        throw new FailedPredicateException(input, "IdentifierPart", " isIdentifierPartUnicode(input.LA(1)) ");
                    }
                     matchAny(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end IdentifierPart

    // $ANTLR start IdentifierNameASCIIStart
    public final void mIdentifierNameASCIIStart() throws RecognitionException {
        try {
            // JS.g:717:2: ( IdentifierStartASCII ( IdentifierPart )* )
            // JS.g:717:4: IdentifierStartASCII ( IdentifierPart )*
            {
            mIdentifierStartASCII(); 
            // JS.g:717:25: ( IdentifierPart )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='$'||(LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='\\'||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }
                else if ( ( isIdentifierPartUnicode(input.LA(1)) ) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // JS.g:717:25: IdentifierPart
            	    {
            	    mIdentifierPart(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end IdentifierNameASCIIStart

    // $ANTLR start Identifier
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            // JS.g:730:3: ( IdentifierNameASCIIStart | )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='$'||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='\\'||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                alt11=1;
            }
            else {
                alt11=2;}
            switch (alt11) {
                case 1 :
                    // JS.g:730:5: IdentifierNameASCIIStart
                    {
                    mIdentifierNameASCIIStart(); 

                    }
                    break;
                case 2 :
                    // JS.g:731:5: 
                    {
                     consumeIdentifierUnicodeStart(); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Identifier

    // $ANTLR start XMLFragment
    public final void mXMLFragment() throws RecognitionException {
        try {
            int _type = XMLFragment;

            	int marker = input.mark();

            // JS.g:839:5: ({...}? => LT ( NOT | QUE | GT | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' | '{' ) )
            // JS.g:839:7: {...}? => LT ( NOT | QUE | GT | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' | '{' )
            {
            if ( !( isXmlStartEnabled() ) ) {
                throw new FailedPredicateException(input, "XMLFragment", " isXmlStartEnabled() ");
            }
            mLT(); 
            if ( input.LA(1)=='!'||input.LA(1)==':'||(input.LA(1)>='>' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='{') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            			input.rewind(marker);
            			readFirstXml();
                     

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end XMLFragment

    // $ANTLR start DecimalDigit
    public final void mDecimalDigit() throws RecognitionException {
        try {
            // JS.g:868:2: ( '0' .. '9' )
            // JS.g:868:4: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end DecimalDigit

    // $ANTLR start HexDigit
    public final void mHexDigit() throws RecognitionException {
        try {
            // JS.g:872:2: ( DecimalDigit | 'a' .. 'f' | 'A' .. 'F' )
            // JS.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end HexDigit

    // $ANTLR start OctalDigit
    public final void mOctalDigit() throws RecognitionException {
        try {
            // JS.g:876:2: ( '0' .. '7' )
            // JS.g:876:4: '0' .. '7'
            {
            matchRange('0','7'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end OctalDigit

    // $ANTLR start ExponentPart
    public final void mExponentPart() throws RecognitionException {
        try {
            // JS.g:880:2: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DecimalDigit )+ )
            // JS.g:880:4: ( 'e' | 'E' ) ( '+' | '-' )? ( DecimalDigit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // JS.g:880:18: ( '+' | '-' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='+'||LA12_0=='-') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // JS.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // JS.g:880:33: ( DecimalDigit )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // JS.g:880:33: DecimalDigit
            	    {
            	    mDecimalDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end ExponentPart

    // $ANTLR start DecimalIntegerLiteral
    public final void mDecimalIntegerLiteral() throws RecognitionException {
        try {
            // JS.g:884:2: ( '0' | '1' .. '9' ( DecimalDigit )* )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='0') ) {
                alt15=1;
            }
            else if ( ((LA15_0>='1' && LA15_0<='9')) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("883:10: fragment DecimalIntegerLiteral : ( '0' | '1' .. '9' ( DecimalDigit )* );", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // JS.g:884:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // JS.g:885:4: '1' .. '9' ( DecimalDigit )*
                    {
                    matchRange('1','9'); 
                    // JS.g:885:13: ( DecimalDigit )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // JS.g:885:13: DecimalDigit
                    	    {
                    	    mDecimalDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end DecimalIntegerLiteral

    // $ANTLR start DecimalLiteral
    public final void mDecimalLiteral() throws RecognitionException {
        try {
            int _type = DecimalLiteral;
            // JS.g:889:2: ( DecimalIntegerLiteral '.' ( DecimalDigit )* ( ExponentPart )? | '.' ( DecimalDigit )+ ( ExponentPart )? | DecimalIntegerLiteral ( ExponentPart )? )
            int alt21=3;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // JS.g:889:4: DecimalIntegerLiteral '.' ( DecimalDigit )* ( ExponentPart )?
                    {
                    mDecimalIntegerLiteral(); 
                    match('.'); 
                    // JS.g:889:30: ( DecimalDigit )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // JS.g:889:30: DecimalDigit
                    	    {
                    	    mDecimalDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    // JS.g:889:44: ( ExponentPart )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='E'||LA17_0=='e') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // JS.g:889:44: ExponentPart
                            {
                            mExponentPart(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // JS.g:890:4: '.' ( DecimalDigit )+ ( ExponentPart )?
                    {
                    match('.'); 
                    // JS.g:890:8: ( DecimalDigit )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // JS.g:890:8: DecimalDigit
                    	    {
                    	    mDecimalDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    // JS.g:890:22: ( ExponentPart )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0=='E'||LA19_0=='e') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // JS.g:890:22: ExponentPart
                            {
                            mExponentPart(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // JS.g:891:4: DecimalIntegerLiteral ( ExponentPart )?
                    {
                    mDecimalIntegerLiteral(); 
                    // JS.g:891:26: ( ExponentPart )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='E'||LA20_0=='e') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // JS.g:891:26: ExponentPart
                            {
                            mExponentPart(); 

                            }
                            break;

                    }


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DecimalLiteral

    // $ANTLR start OctalIntegerLiteral
    public final void mOctalIntegerLiteral() throws RecognitionException {
        try {
            int _type = OctalIntegerLiteral;
            // JS.g:895:2: ( '0' ( OctalDigit )+ )
            // JS.g:895:4: '0' ( OctalDigit )+
            {
            match('0'); 
            // JS.g:895:8: ( OctalDigit )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='0' && LA22_0<='7')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // JS.g:895:8: OctalDigit
            	    {
            	    mOctalDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OctalIntegerLiteral

    // $ANTLR start HexIntegerLiteral
    public final void mHexIntegerLiteral() throws RecognitionException {
        try {
            int _type = HexIntegerLiteral;
            // JS.g:899:2: ( ( '0x' | '0X' ) ( HexDigit )+ )
            // JS.g:899:4: ( '0x' | '0X' ) ( HexDigit )+
            {
            // JS.g:899:4: ( '0x' | '0X' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='0') ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1=='x') ) {
                    alt23=1;
                }
                else if ( (LA23_1=='X') ) {
                    alt23=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("899:4: ( '0x' | '0X' )", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("899:4: ( '0x' | '0X' )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // JS.g:899:6: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // JS.g:899:13: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // JS.g:899:20: ( HexDigit )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='0' && LA24_0<='9')||(LA24_0>='A' && LA24_0<='F')||(LA24_0>='a' && LA24_0<='f')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // JS.g:899:20: HexDigit
            	    {
            	    mHexDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end HexIntegerLiteral

    // $ANTLR start CharacterEscapeSequence
    public final void mCharacterEscapeSequence() throws RecognitionException {
        try {
            // JS.g:918:2: (~ ( DecimalDigit | 'x' | 'u' | LineTerminatorChar ) )
            // JS.g:918:4: ~ ( DecimalDigit | 'x' | 'u' | LineTerminatorChar )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='/')||(input.LA(1)>=':' && input.LA(1)<='t')||(input.LA(1)>='v' && input.LA(1)<='w')||(input.LA(1)>='y' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFE') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end CharacterEscapeSequence

    // $ANTLR start ZeroToThree
    public final void mZeroToThree() throws RecognitionException {
        try {
            // JS.g:922:2: ( '0' .. '3' )
            // JS.g:922:4: '0' .. '3'
            {
            matchRange('0','3'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end ZeroToThree

    // $ANTLR start OctalEscapeSequence
    public final void mOctalEscapeSequence() throws RecognitionException {
        try {
            // JS.g:926:2: ( OctalDigit | ZeroToThree OctalDigit | '4' .. '7' OctalDigit | ZeroToThree OctalDigit OctalDigit )
            int alt25=4;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>='0' && LA25_0<='3')) ) {
                int LA25_1 = input.LA(2);

                if ( ((LA25_1>='0' && LA25_1<='7')) ) {
                    int LA25_4 = input.LA(3);

                    if ( ((LA25_4>='0' && LA25_4<='7')) ) {
                        alt25=4;
                    }
                    else {
                        alt25=2;}
                }
                else {
                    alt25=1;}
            }
            else if ( ((LA25_0>='4' && LA25_0<='7')) ) {
                int LA25_2 = input.LA(2);

                if ( ((LA25_2>='0' && LA25_2<='7')) ) {
                    alt25=3;
                }
                else {
                    alt25=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("925:10: fragment OctalEscapeSequence : ( OctalDigit | ZeroToThree OctalDigit | '4' .. '7' OctalDigit | ZeroToThree OctalDigit OctalDigit );", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // JS.g:926:4: OctalDigit
                    {
                    mOctalDigit(); 

                    }
                    break;
                case 2 :
                    // JS.g:927:4: ZeroToThree OctalDigit
                    {
                    mZeroToThree(); 
                    mOctalDigit(); 

                    }
                    break;
                case 3 :
                    // JS.g:928:4: '4' .. '7' OctalDigit
                    {
                    matchRange('4','7'); 
                    mOctalDigit(); 

                    }
                    break;
                case 4 :
                    // JS.g:929:4: ZeroToThree OctalDigit OctalDigit
                    {
                    mZeroToThree(); 
                    mOctalDigit(); 
                    mOctalDigit(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end OctalEscapeSequence

    // $ANTLR start HexEscapeSequence
    public final void mHexEscapeSequence() throws RecognitionException {
        try {
            // JS.g:933:2: ( 'x' HexDigit HexDigit )
            // JS.g:933:4: 'x' HexDigit HexDigit
            {
            match('x'); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end HexEscapeSequence

    // $ANTLR start UnicodeEscapeSequence
    public final void mUnicodeEscapeSequence() throws RecognitionException {
        try {
            // JS.g:937:2: ( 'u' HexDigit HexDigit HexDigit HexDigit )
            // JS.g:937:4: 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end UnicodeEscapeSequence

    // $ANTLR start EscapeSequence
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // JS.g:941:2: ( BSLASH ( CharacterEscapeSequence | OctalEscapeSequence | HexEscapeSequence | UnicodeEscapeSequence | LineTerminator ) )
            // JS.g:942:2: BSLASH ( CharacterEscapeSequence | OctalEscapeSequence | HexEscapeSequence | UnicodeEscapeSequence | LineTerminator )
            {
            mBSLASH(); 
            // JS.g:943:2: ( CharacterEscapeSequence | OctalEscapeSequence | HexEscapeSequence | UnicodeEscapeSequence | LineTerminator )
            int alt26=5;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>='\u0000' && LA26_0<='\t')||(LA26_0>='\u000B' && LA26_0<='\f')||(LA26_0>='\u000E' && LA26_0<='/')||(LA26_0>=':' && LA26_0<='t')||(LA26_0>='v' && LA26_0<='w')||(LA26_0>='y' && LA26_0<='\u2027')||(LA26_0>='\u202A' && LA26_0<='\uFFFE')) ) {
                alt26=1;
            }
            else if ( ((LA26_0>='0' && LA26_0<='7')) ) {
                alt26=2;
            }
            else if ( (LA26_0=='x') ) {
                alt26=3;
            }
            else if ( (LA26_0=='u') ) {
                alt26=4;
            }
            else if ( (LA26_0=='\n'||LA26_0=='\r'||(LA26_0>='\u2028' && LA26_0<='\u2029')) ) {
                alt26=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("943:2: ( CharacterEscapeSequence | OctalEscapeSequence | HexEscapeSequence | UnicodeEscapeSequence | LineTerminator )", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // JS.g:944:3: CharacterEscapeSequence
                    {
                    mCharacterEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // JS.g:945:5: OctalEscapeSequence
                    {
                    mOctalEscapeSequence(); 

                    }
                    break;
                case 3 :
                    // JS.g:946:5: HexEscapeSequence
                    {
                    mHexEscapeSequence(); 

                    }
                    break;
                case 4 :
                    // JS.g:947:5: UnicodeEscapeSequence
                    {
                    mUnicodeEscapeSequence(); 

                    }
                    break;
                case 5 :
                    // JS.g:948:5: LineTerminator
                    {
                    mLineTerminator(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end EscapeSequence

    // $ANTLR start StringLiteral
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            // JS.g:953:2: ( SQUOTE (~ ( SQUOTE | BSLASH | LineTerminatorChar ) | EscapeSequence )* SQUOTE | DQUOTE (~ ( DQUOTE | BSLASH | LineTerminatorChar ) | EscapeSequence )* DQUOTE )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0=='\'') ) {
                alt29=1;
            }
            else if ( (LA29_0=='\"') ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("952:1: StringLiteral : ( SQUOTE (~ ( SQUOTE | BSLASH | LineTerminatorChar ) | EscapeSequence )* SQUOTE | DQUOTE (~ ( DQUOTE | BSLASH | LineTerminatorChar ) | EscapeSequence )* DQUOTE );", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // JS.g:953:4: SQUOTE (~ ( SQUOTE | BSLASH | LineTerminatorChar ) | EscapeSequence )* SQUOTE
                    {
                    mSQUOTE(); 
                    // JS.g:953:11: (~ ( SQUOTE | BSLASH | LineTerminatorChar ) | EscapeSequence )*
                    loop27:
                    do {
                        int alt27=3;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>='\u0000' && LA27_0<='\t')||(LA27_0>='\u000B' && LA27_0<='\f')||(LA27_0>='\u000E' && LA27_0<='&')||(LA27_0>='(' && LA27_0<='[')||(LA27_0>=']' && LA27_0<='\u2027')||(LA27_0>='\u202A' && LA27_0<='\uFFFE')) ) {
                            alt27=1;
                        }
                        else if ( (LA27_0=='\\') ) {
                            alt27=2;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // JS.g:953:13: ~ ( SQUOTE | BSLASH | LineTerminatorChar )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // JS.g:953:57: EscapeSequence
                    	    {
                    	    mEscapeSequence(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    mSQUOTE(); 

                    }
                    break;
                case 2 :
                    // JS.g:954:4: DQUOTE (~ ( DQUOTE | BSLASH | LineTerminatorChar ) | EscapeSequence )* DQUOTE
                    {
                    mDQUOTE(); 
                    // JS.g:954:11: (~ ( DQUOTE | BSLASH | LineTerminatorChar ) | EscapeSequence )*
                    loop28:
                    do {
                        int alt28=3;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>='\u0000' && LA28_0<='\t')||(LA28_0>='\u000B' && LA28_0<='\f')||(LA28_0>='\u000E' && LA28_0<='!')||(LA28_0>='#' && LA28_0<='[')||(LA28_0>=']' && LA28_0<='\u2027')||(LA28_0>='\u202A' && LA28_0<='\uFFFE')) ) {
                            alt28=1;
                        }
                        else if ( (LA28_0=='\\') ) {
                            alt28=2;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // JS.g:954:13: ~ ( DQUOTE | BSLASH | LineTerminatorChar )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // JS.g:954:57: EscapeSequence
                    	    {
                    	    mEscapeSequence(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    mDQUOTE(); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end StringLiteral

    // $ANTLR start BackslashSequence
    public final void mBackslashSequence() throws RecognitionException {
        try {
            // JS.g:963:2: ( BSLASH ~ ( LineTerminatorChar ) )
            // JS.g:963:4: BSLASH ~ ( LineTerminatorChar )
            {
            mBSLASH(); 
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFE') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end BackslashSequence

    // $ANTLR start RegularExpressionFirstChar
    public final void mRegularExpressionFirstChar() throws RecognitionException {
        try {
            // JS.g:967:2: (~ ( LineTerminatorChar | MUL | BSLASH | DIV ) | BackslashSequence )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>='\u0000' && LA30_0<='\t')||(LA30_0>='\u000B' && LA30_0<='\f')||(LA30_0>='\u000E' && LA30_0<=')')||(LA30_0>='+' && LA30_0<='.')||(LA30_0>='0' && LA30_0<='[')||(LA30_0>=']' && LA30_0<='\u2027')||(LA30_0>='\u202A' && LA30_0<='\uFFFE')) ) {
                alt30=1;
            }
            else if ( (LA30_0=='\\') ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("966:10: fragment RegularExpressionFirstChar : (~ ( LineTerminatorChar | MUL | BSLASH | DIV ) | BackslashSequence );", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // JS.g:967:4: ~ ( LineTerminatorChar | MUL | BSLASH | DIV )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;
                case 2 :
                    // JS.g:968:4: BackslashSequence
                    {
                    mBackslashSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end RegularExpressionFirstChar

    // $ANTLR start RegularExpressionChar
    public final void mRegularExpressionChar() throws RecognitionException {
        try {
            // JS.g:972:2: (~ ( LineTerminatorChar | BSLASH | DIV ) | BackslashSequence )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>='\u0000' && LA31_0<='\t')||(LA31_0>='\u000B' && LA31_0<='\f')||(LA31_0>='\u000E' && LA31_0<='.')||(LA31_0>='0' && LA31_0<='[')||(LA31_0>=']' && LA31_0<='\u2027')||(LA31_0>='\u202A' && LA31_0<='\uFFFE')) ) {
                alt31=1;
            }
            else if ( (LA31_0=='\\') ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("971:10: fragment RegularExpressionChar : (~ ( LineTerminatorChar | BSLASH | DIV ) | BackslashSequence );", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // JS.g:972:4: ~ ( LineTerminatorChar | BSLASH | DIV )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;
                case 2 :
                    // JS.g:973:4: BackslashSequence
                    {
                    mBackslashSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end RegularExpressionChar

    // $ANTLR start RegularExpressionLiteral
    public final void mRegularExpressionLiteral() throws RecognitionException {
        try {
            int _type = RegularExpressionLiteral;
            // JS.g:977:2: ({...}? => DIV RegularExpressionFirstChar ( RegularExpressionChar )* DIV ( IdentifierPart )* )
            // JS.g:977:4: {...}? => DIV RegularExpressionFirstChar ( RegularExpressionChar )* DIV ( IdentifierPart )*
            {
            if ( !( areRegularExpressionsEnabled() ) ) {
                throw new FailedPredicateException(input, "RegularExpressionLiteral", " areRegularExpressionsEnabled() ");
            }
            mDIV(); 
            mRegularExpressionFirstChar(); 
            // JS.g:977:73: ( RegularExpressionChar )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>='\u0000' && LA32_0<='\t')||(LA32_0>='\u000B' && LA32_0<='\f')||(LA32_0>='\u000E' && LA32_0<='.')||(LA32_0>='0' && LA32_0<='\u2027')||(LA32_0>='\u202A' && LA32_0<='\uFFFE')) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // JS.g:977:73: RegularExpressionChar
            	    {
            	    mRegularExpressionChar(); 

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            mDIV(); 
            // JS.g:977:100: ( IdentifierPart )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0=='$'||(LA33_0>='0' && LA33_0<='9')||(LA33_0>='A' && LA33_0<='Z')||LA33_0=='\\'||LA33_0=='_'||(LA33_0>='a' && LA33_0<='z')) ) {
                    alt33=1;
                }
                else if ( ( isIdentifierPartUnicode(input.LA(1)) ) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // JS.g:977:100: IdentifierPart
            	    {
            	    mIdentifierPart(); 

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RegularExpressionLiteral

    public void mTokens() throws RecognitionException {
        // JS.g:1:8: ( NULL | TRUE | FALSE | BREAK | CASE | CATCH | CONTINUE | DEFAULT | DELETE | DO | ELSE | FINALLY | FOR | EACH | FUNCTION | IF | IN | INSTANCEOF | NEW | RETURN | SWITCH | THIS | THROW | TRY | TYPEOF | VAR | VOID | WHILE | WITH | GET | SET | YIELD | WXML | NAMESPACE | ABSTRACT | BOOLEAN | BYTE | CHAR | CLASS | CONST | DEBUGGER | DOUBLE | ENUM | EXPORT | EXTENDS | FINAL | FLOAT | GOTO | IMPLEMENTS | IMPORT | INT | INTERFACE | LONG | NATIVE | PACKAGE | PRIVATE | PROTECTED | PUBLIC | SHORT | STATIC | SUPER | SYNCHRONIZED | THROWS | TRANSIENT | VOLATILE | LBRACE | RBRACE | LPAREN | RPAREN | LBRACK | RBRACK | DOT | SEMIC | COMMA | LT | GT | LTE | GTE | EQ | NEQ | SAME | NSAME | ADD | SUB | MUL | MOD | INC | DEC | SHL | SHR | SHU | AND | OR | XOR | NOT | INV | LAND | LOR | QUE | COLON | ASSIGN | ADDASS | SUBASS | MULASS | MODASS | SHLASS | SHRASS | SHUASS | ANDASS | ORASS | XORASS | DIV | DIVASS | AT | DOTDOT | COLONCOLON | WhiteSpace | EOL | MultiLineComment | SingleLineComment | Identifier | XMLFragment | DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral | StringLiteral | RegularExpressionLiteral )
        int alt34=127;
        switch ( input.LA(1) ) {
        case 'n':
            {
            switch ( input.LA(2) ) {
            case 'a':
                {
                switch ( input.LA(3) ) {
                case 'm':
                    {
                    int LA34_137 = input.LA(4);

                    if ( (LA34_137=='e') ) {
                        int LA34_207 = input.LA(5);

                        if ( (LA34_207=='s') ) {
                            int LA34_269 = input.LA(6);

                            if ( (LA34_269=='p') ) {
                                int LA34_321 = input.LA(7);

                                if ( (LA34_321=='a') ) {
                                    int LA34_362 = input.LA(8);

                                    if ( (LA34_362=='c') ) {
                                        int LA34_391 = input.LA(9);

                                        if ( (LA34_391=='e') ) {
                                            int LA34_409 = input.LA(10);

                                            if ( (LA34_409=='$'||(LA34_409>='0' && LA34_409<='9')||(LA34_409>='A' && LA34_409<='Z')||LA34_409=='\\'||LA34_409=='_'||(LA34_409>='a' && LA34_409<='z')) ) {
                                                alt34=121;
                                            }
                                            else {
                                                alt34=34;}
                                        }
                                        else {
                                            alt34=121;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 't':
                    {
                    int LA34_138 = input.LA(4);

                    if ( (LA34_138=='i') ) {
                        int LA34_208 = input.LA(5);

                        if ( (LA34_208=='v') ) {
                            int LA34_270 = input.LA(6);

                            if ( (LA34_270=='e') ) {
                                int LA34_322 = input.LA(7);

                                if ( (LA34_322=='$'||(LA34_322>='0' && LA34_322<='9')||(LA34_322>='A' && LA34_322<='Z')||LA34_322=='\\'||LA34_322=='_'||(LA34_322>='a' && LA34_322<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=54;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                default:
                    alt34=121;}

                }
                break;
            case 'u':
                {
                int LA34_51 = input.LA(3);

                if ( (LA34_51=='l') ) {
                    int LA34_139 = input.LA(4);

                    if ( (LA34_139=='l') ) {
                        int LA34_209 = input.LA(5);

                        if ( (LA34_209=='$'||(LA34_209>='0' && LA34_209<='9')||(LA34_209>='A' && LA34_209<='Z')||LA34_209=='\\'||LA34_209=='_'||(LA34_209>='a' && LA34_209<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=1;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'e':
                {
                int LA34_52 = input.LA(3);

                if ( (LA34_52=='w') ) {
                    int LA34_140 = input.LA(4);

                    if ( (LA34_140=='$'||(LA34_140>='0' && LA34_140<='9')||(LA34_140>='A' && LA34_140<='Z')||LA34_140=='\\'||LA34_140=='_'||(LA34_140>='a' && LA34_140<='z')) ) {
                        alt34=121;
                    }
                    else {
                        alt34=19;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 't':
            {
            switch ( input.LA(2) ) {
            case 'h':
                {
                switch ( input.LA(3) ) {
                case 'r':
                    {
                    int LA34_141 = input.LA(4);

                    if ( (LA34_141=='o') ) {
                        int LA34_211 = input.LA(5);

                        if ( (LA34_211=='w') ) {
                            switch ( input.LA(6) ) {
                            case 's':
                                {
                                int LA34_323 = input.LA(7);

                                if ( (LA34_323=='$'||(LA34_323>='0' && LA34_323<='9')||(LA34_323>='A' && LA34_323<='Z')||LA34_323=='\\'||LA34_323=='_'||(LA34_323>='a' && LA34_323<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=63;}
                                }
                                break;
                            case '$':
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                            case 'G':
                            case 'H':
                            case 'I':
                            case 'J':
                            case 'K':
                            case 'L':
                            case 'M':
                            case 'N':
                            case 'O':
                            case 'P':
                            case 'Q':
                            case 'R':
                            case 'S':
                            case 'T':
                            case 'U':
                            case 'V':
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                            case '\\':
                            case '_':
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                            case 'g':
                            case 'h':
                            case 'i':
                            case 'j':
                            case 'k':
                            case 'l':
                            case 'm':
                            case 'n':
                            case 'o':
                            case 'p':
                            case 'q':
                            case 'r':
                            case 't':
                            case 'u':
                            case 'v':
                            case 'w':
                            case 'x':
                            case 'y':
                            case 'z':
                                {
                                alt34=121;
                                }
                                break;
                            default:
                                alt34=23;}

                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 'i':
                    {
                    int LA34_142 = input.LA(4);

                    if ( (LA34_142=='s') ) {
                        int LA34_212 = input.LA(5);

                        if ( (LA34_212=='$'||(LA34_212>='0' && LA34_212<='9')||(LA34_212>='A' && LA34_212<='Z')||LA34_212=='\\'||LA34_212=='_'||(LA34_212>='a' && LA34_212<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=22;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                default:
                    alt34=121;}

                }
                break;
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'u':
                    {
                    int LA34_143 = input.LA(4);

                    if ( (LA34_143=='e') ) {
                        int LA34_213 = input.LA(5);

                        if ( (LA34_213=='$'||(LA34_213>='0' && LA34_213<='9')||(LA34_213>='A' && LA34_213<='Z')||LA34_213=='\\'||LA34_213=='_'||(LA34_213>='a' && LA34_213<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=2;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 'y':
                    {
                    int LA34_144 = input.LA(4);

                    if ( (LA34_144=='$'||(LA34_144>='0' && LA34_144<='9')||(LA34_144>='A' && LA34_144<='Z')||LA34_144=='\\'||LA34_144=='_'||(LA34_144>='a' && LA34_144<='z')) ) {
                        alt34=121;
                    }
                    else {
                        alt34=24;}
                    }
                    break;
                case 'a':
                    {
                    int LA34_145 = input.LA(4);

                    if ( (LA34_145=='n') ) {
                        int LA34_215 = input.LA(5);

                        if ( (LA34_215=='s') ) {
                            int LA34_275 = input.LA(6);

                            if ( (LA34_275=='i') ) {
                                int LA34_325 = input.LA(7);

                                if ( (LA34_325=='e') ) {
                                    int LA34_365 = input.LA(8);

                                    if ( (LA34_365=='n') ) {
                                        int LA34_392 = input.LA(9);

                                        if ( (LA34_392=='t') ) {
                                            int LA34_410 = input.LA(10);

                                            if ( (LA34_410=='$'||(LA34_410>='0' && LA34_410<='9')||(LA34_410>='A' && LA34_410<='Z')||LA34_410=='\\'||LA34_410=='_'||(LA34_410>='a' && LA34_410<='z')) ) {
                                                alt34=121;
                                            }
                                            else {
                                                alt34=64;}
                                        }
                                        else {
                                            alt34=121;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                default:
                    alt34=121;}

                }
                break;
            case 'y':
                {
                int LA34_55 = input.LA(3);

                if ( (LA34_55=='p') ) {
                    int LA34_146 = input.LA(4);

                    if ( (LA34_146=='e') ) {
                        int LA34_216 = input.LA(5);

                        if ( (LA34_216=='o') ) {
                            int LA34_276 = input.LA(6);

                            if ( (LA34_276=='f') ) {
                                int LA34_326 = input.LA(7);

                                if ( (LA34_326=='$'||(LA34_326>='0' && LA34_326<='9')||(LA34_326>='A' && LA34_326<='Z')||LA34_326=='\\'||LA34_326=='_'||(LA34_326>='a' && LA34_326<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=25;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'f':
            {
            switch ( input.LA(2) ) {
            case 'l':
                {
                int LA34_56 = input.LA(3);

                if ( (LA34_56=='o') ) {
                    int LA34_147 = input.LA(4);

                    if ( (LA34_147=='a') ) {
                        int LA34_217 = input.LA(5);

                        if ( (LA34_217=='t') ) {
                            int LA34_277 = input.LA(6);

                            if ( (LA34_277=='$'||(LA34_277>='0' && LA34_277<='9')||(LA34_277>='A' && LA34_277<='Z')||LA34_277=='\\'||LA34_277=='_'||(LA34_277>='a' && LA34_277<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=47;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'i':
                {
                int LA34_57 = input.LA(3);

                if ( (LA34_57=='n') ) {
                    int LA34_148 = input.LA(4);

                    if ( (LA34_148=='a') ) {
                        int LA34_218 = input.LA(5);

                        if ( (LA34_218=='l') ) {
                            switch ( input.LA(6) ) {
                            case 'l':
                                {
                                int LA34_328 = input.LA(7);

                                if ( (LA34_328=='y') ) {
                                    int LA34_367 = input.LA(8);

                                    if ( (LA34_367=='$'||(LA34_367>='0' && LA34_367<='9')||(LA34_367>='A' && LA34_367<='Z')||LA34_367=='\\'||LA34_367=='_'||(LA34_367>='a' && LA34_367<='z')) ) {
                                        alt34=121;
                                    }
                                    else {
                                        alt34=12;}
                                }
                                else {
                                    alt34=121;}
                                }
                                break;
                            case '$':
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                            case 'G':
                            case 'H':
                            case 'I':
                            case 'J':
                            case 'K':
                            case 'L':
                            case 'M':
                            case 'N':
                            case 'O':
                            case 'P':
                            case 'Q':
                            case 'R':
                            case 'S':
                            case 'T':
                            case 'U':
                            case 'V':
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                            case '\\':
                            case '_':
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                            case 'g':
                            case 'h':
                            case 'i':
                            case 'j':
                            case 'k':
                            case 'm':
                            case 'n':
                            case 'o':
                            case 'p':
                            case 'q':
                            case 'r':
                            case 's':
                            case 't':
                            case 'u':
                            case 'v':
                            case 'w':
                            case 'x':
                            case 'y':
                            case 'z':
                                {
                                alt34=121;
                                }
                                break;
                            default:
                                alt34=46;}

                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'a':
                {
                int LA34_58 = input.LA(3);

                if ( (LA34_58=='l') ) {
                    int LA34_149 = input.LA(4);

                    if ( (LA34_149=='s') ) {
                        int LA34_219 = input.LA(5);

                        if ( (LA34_219=='e') ) {
                            int LA34_279 = input.LA(6);

                            if ( (LA34_279=='$'||(LA34_279>='0' && LA34_279<='9')||(LA34_279>='A' && LA34_279<='Z')||LA34_279=='\\'||LA34_279=='_'||(LA34_279>='a' && LA34_279<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=3;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'u':
                {
                int LA34_59 = input.LA(3);

                if ( (LA34_59=='n') ) {
                    int LA34_150 = input.LA(4);

                    if ( (LA34_150=='c') ) {
                        int LA34_220 = input.LA(5);

                        if ( (LA34_220=='t') ) {
                            int LA34_280 = input.LA(6);

                            if ( (LA34_280=='i') ) {
                                int LA34_331 = input.LA(7);

                                if ( (LA34_331=='o') ) {
                                    int LA34_368 = input.LA(8);

                                    if ( (LA34_368=='n') ) {
                                        int LA34_394 = input.LA(9);

                                        if ( (LA34_394=='$'||(LA34_394>='0' && LA34_394<='9')||(LA34_394>='A' && LA34_394<='Z')||LA34_394=='\\'||LA34_394=='_'||(LA34_394>='a' && LA34_394<='z')) ) {
                                            alt34=121;
                                        }
                                        else {
                                            alt34=15;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'o':
                {
                int LA34_60 = input.LA(3);

                if ( (LA34_60=='r') ) {
                    int LA34_151 = input.LA(4);

                    if ( (LA34_151=='$'||(LA34_151>='0' && LA34_151<='9')||(LA34_151>='A' && LA34_151<='Z')||LA34_151=='\\'||LA34_151=='_'||(LA34_151>='a' && LA34_151<='z')) ) {
                        alt34=121;
                    }
                    else {
                        alt34=13;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'b':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA34_61 = input.LA(3);

                if ( (LA34_61=='o') ) {
                    int LA34_152 = input.LA(4);

                    if ( (LA34_152=='l') ) {
                        int LA34_222 = input.LA(5);

                        if ( (LA34_222=='e') ) {
                            int LA34_281 = input.LA(6);

                            if ( (LA34_281=='a') ) {
                                int LA34_332 = input.LA(7);

                                if ( (LA34_332=='n') ) {
                                    int LA34_369 = input.LA(8);

                                    if ( (LA34_369=='$'||(LA34_369>='0' && LA34_369<='9')||(LA34_369>='A' && LA34_369<='Z')||LA34_369=='\\'||LA34_369=='_'||(LA34_369>='a' && LA34_369<='z')) ) {
                                        alt34=121;
                                    }
                                    else {
                                        alt34=36;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'y':
                {
                int LA34_62 = input.LA(3);

                if ( (LA34_62=='t') ) {
                    int LA34_153 = input.LA(4);

                    if ( (LA34_153=='e') ) {
                        int LA34_223 = input.LA(5);

                        if ( (LA34_223=='$'||(LA34_223>='0' && LA34_223<='9')||(LA34_223>='A' && LA34_223<='Z')||LA34_223=='\\'||LA34_223=='_'||(LA34_223>='a' && LA34_223<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=37;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'r':
                {
                int LA34_63 = input.LA(3);

                if ( (LA34_63=='e') ) {
                    int LA34_154 = input.LA(4);

                    if ( (LA34_154=='a') ) {
                        int LA34_224 = input.LA(5);

                        if ( (LA34_224=='k') ) {
                            int LA34_283 = input.LA(6);

                            if ( (LA34_283=='$'||(LA34_283>='0' && LA34_283<='9')||(LA34_283>='A' && LA34_283<='Z')||LA34_283=='\\'||LA34_283=='_'||(LA34_283>='a' && LA34_283<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=4;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'c':
            {
            switch ( input.LA(2) ) {
            case 'h':
                {
                int LA34_64 = input.LA(3);

                if ( (LA34_64=='a') ) {
                    int LA34_155 = input.LA(4);

                    if ( (LA34_155=='r') ) {
                        int LA34_225 = input.LA(5);

                        if ( (LA34_225=='$'||(LA34_225>='0' && LA34_225<='9')||(LA34_225>='A' && LA34_225<='Z')||LA34_225=='\\'||LA34_225=='_'||(LA34_225>='a' && LA34_225<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=38;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'l':
                {
                int LA34_65 = input.LA(3);

                if ( (LA34_65=='a') ) {
                    int LA34_156 = input.LA(4);

                    if ( (LA34_156=='s') ) {
                        int LA34_226 = input.LA(5);

                        if ( (LA34_226=='s') ) {
                            int LA34_285 = input.LA(6);

                            if ( (LA34_285=='$'||(LA34_285>='0' && LA34_285<='9')||(LA34_285>='A' && LA34_285<='Z')||LA34_285=='\\'||LA34_285=='_'||(LA34_285>='a' && LA34_285<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=39;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'o':
                {
                int LA34_66 = input.LA(3);

                if ( (LA34_66=='n') ) {
                    switch ( input.LA(4) ) {
                    case 's':
                        {
                        int LA34_227 = input.LA(5);

                        if ( (LA34_227=='t') ) {
                            int LA34_286 = input.LA(6);

                            if ( (LA34_286=='$'||(LA34_286>='0' && LA34_286<='9')||(LA34_286>='A' && LA34_286<='Z')||LA34_286=='\\'||LA34_286=='_'||(LA34_286>='a' && LA34_286<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=40;}
                        }
                        else {
                            alt34=121;}
                        }
                        break;
                    case 't':
                        {
                        int LA34_228 = input.LA(5);

                        if ( (LA34_228=='i') ) {
                            int LA34_287 = input.LA(6);

                            if ( (LA34_287=='n') ) {
                                int LA34_336 = input.LA(7);

                                if ( (LA34_336=='u') ) {
                                    int LA34_370 = input.LA(8);

                                    if ( (LA34_370=='e') ) {
                                        int LA34_396 = input.LA(9);

                                        if ( (LA34_396=='$'||(LA34_396>='0' && LA34_396<='9')||(LA34_396>='A' && LA34_396<='Z')||LA34_396=='\\'||LA34_396=='_'||(LA34_396>='a' && LA34_396<='z')) ) {
                                            alt34=121;
                                        }
                                        else {
                                            alt34=7;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                        }
                        break;
                    default:
                        alt34=121;}

                }
                else {
                    alt34=121;}
                }
                break;
            case 'a':
                {
                switch ( input.LA(3) ) {
                case 's':
                    {
                    int LA34_158 = input.LA(4);

                    if ( (LA34_158=='e') ) {
                        int LA34_229 = input.LA(5);

                        if ( (LA34_229=='$'||(LA34_229>='0' && LA34_229<='9')||(LA34_229>='A' && LA34_229<='Z')||LA34_229=='\\'||LA34_229=='_'||(LA34_229>='a' && LA34_229<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=5;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 't':
                    {
                    int LA34_159 = input.LA(4);

                    if ( (LA34_159=='c') ) {
                        int LA34_230 = input.LA(5);

                        if ( (LA34_230=='h') ) {
                            int LA34_289 = input.LA(6);

                            if ( (LA34_289=='$'||(LA34_289>='0' && LA34_289<='9')||(LA34_289>='A' && LA34_289<='Z')||LA34_289=='\\'||LA34_289=='_'||(LA34_289>='a' && LA34_289<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=6;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                default:
                    alt34=121;}

                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'd':
            {
            switch ( input.LA(2) ) {
            case 'e':
                {
                switch ( input.LA(3) ) {
                case 'b':
                    {
                    int LA34_160 = input.LA(4);

                    if ( (LA34_160=='u') ) {
                        int LA34_231 = input.LA(5);

                        if ( (LA34_231=='g') ) {
                            int LA34_290 = input.LA(6);

                            if ( (LA34_290=='g') ) {
                                int LA34_338 = input.LA(7);

                                if ( (LA34_338=='e') ) {
                                    int LA34_371 = input.LA(8);

                                    if ( (LA34_371=='r') ) {
                                        int LA34_397 = input.LA(9);

                                        if ( (LA34_397=='$'||(LA34_397>='0' && LA34_397<='9')||(LA34_397>='A' && LA34_397<='Z')||LA34_397=='\\'||LA34_397=='_'||(LA34_397>='a' && LA34_397<='z')) ) {
                                            alt34=121;
                                        }
                                        else {
                                            alt34=41;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 'l':
                    {
                    int LA34_161 = input.LA(4);

                    if ( (LA34_161=='e') ) {
                        int LA34_232 = input.LA(5);

                        if ( (LA34_232=='t') ) {
                            int LA34_291 = input.LA(6);

                            if ( (LA34_291=='e') ) {
                                int LA34_339 = input.LA(7);

                                if ( (LA34_339=='$'||(LA34_339>='0' && LA34_339<='9')||(LA34_339>='A' && LA34_339<='Z')||LA34_339=='\\'||LA34_339=='_'||(LA34_339>='a' && LA34_339<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=9;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 'f':
                    {
                    int LA34_162 = input.LA(4);

                    if ( (LA34_162=='a') ) {
                        int LA34_233 = input.LA(5);

                        if ( (LA34_233=='u') ) {
                            int LA34_292 = input.LA(6);

                            if ( (LA34_292=='l') ) {
                                int LA34_340 = input.LA(7);

                                if ( (LA34_340=='t') ) {
                                    int LA34_373 = input.LA(8);

                                    if ( (LA34_373=='$'||(LA34_373>='0' && LA34_373<='9')||(LA34_373>='A' && LA34_373<='Z')||LA34_373=='\\'||LA34_373=='_'||(LA34_373>='a' && LA34_373<='z')) ) {
                                        alt34=121;
                                    }
                                    else {
                                        alt34=8;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                default:
                    alt34=121;}

                }
                break;
            case 'o':
                {
                switch ( input.LA(3) ) {
                case 'u':
                    {
                    int LA34_163 = input.LA(4);

                    if ( (LA34_163=='b') ) {
                        int LA34_234 = input.LA(5);

                        if ( (LA34_234=='l') ) {
                            int LA34_293 = input.LA(6);

                            if ( (LA34_293=='e') ) {
                                int LA34_341 = input.LA(7);

                                if ( (LA34_341=='$'||(LA34_341>='0' && LA34_341<='9')||(LA34_341>='A' && LA34_341<='Z')||LA34_341=='\\'||LA34_341=='_'||(LA34_341>='a' && LA34_341<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=42;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case '$':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '\\':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt34=121;
                    }
                    break;
                default:
                    alt34=10;}

                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'e':
            {
            switch ( input.LA(2) ) {
            case 'x':
                {
                switch ( input.LA(3) ) {
                case 't':
                    {
                    int LA34_165 = input.LA(4);

                    if ( (LA34_165=='e') ) {
                        int LA34_235 = input.LA(5);

                        if ( (LA34_235=='n') ) {
                            int LA34_294 = input.LA(6);

                            if ( (LA34_294=='d') ) {
                                int LA34_342 = input.LA(7);

                                if ( (LA34_342=='s') ) {
                                    int LA34_375 = input.LA(8);

                                    if ( (LA34_375=='$'||(LA34_375>='0' && LA34_375<='9')||(LA34_375>='A' && LA34_375<='Z')||LA34_375=='\\'||LA34_375=='_'||(LA34_375>='a' && LA34_375<='z')) ) {
                                        alt34=121;
                                    }
                                    else {
                                        alt34=45;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 'p':
                    {
                    int LA34_166 = input.LA(4);

                    if ( (LA34_166=='o') ) {
                        int LA34_236 = input.LA(5);

                        if ( (LA34_236=='r') ) {
                            int LA34_295 = input.LA(6);

                            if ( (LA34_295=='t') ) {
                                int LA34_343 = input.LA(7);

                                if ( (LA34_343=='$'||(LA34_343>='0' && LA34_343<='9')||(LA34_343>='A' && LA34_343<='Z')||LA34_343=='\\'||LA34_343=='_'||(LA34_343>='a' && LA34_343<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=44;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                default:
                    alt34=121;}

                }
                break;
            case 'n':
                {
                int LA34_71 = input.LA(3);

                if ( (LA34_71=='u') ) {
                    int LA34_167 = input.LA(4);

                    if ( (LA34_167=='m') ) {
                        int LA34_237 = input.LA(5);

                        if ( (LA34_237=='$'||(LA34_237>='0' && LA34_237<='9')||(LA34_237>='A' && LA34_237<='Z')||LA34_237=='\\'||LA34_237=='_'||(LA34_237>='a' && LA34_237<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=43;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'a':
                {
                int LA34_72 = input.LA(3);

                if ( (LA34_72=='c') ) {
                    int LA34_168 = input.LA(4);

                    if ( (LA34_168=='h') ) {
                        int LA34_238 = input.LA(5);

                        if ( (LA34_238=='$'||(LA34_238>='0' && LA34_238<='9')||(LA34_238>='A' && LA34_238<='Z')||LA34_238=='\\'||LA34_238=='_'||(LA34_238>='a' && LA34_238<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=14;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'l':
                {
                int LA34_73 = input.LA(3);

                if ( (LA34_73=='s') ) {
                    int LA34_169 = input.LA(4);

                    if ( (LA34_169=='e') ) {
                        int LA34_239 = input.LA(5);

                        if ( (LA34_239=='$'||(LA34_239>='0' && LA34_239<='9')||(LA34_239>='A' && LA34_239<='Z')||LA34_239=='\\'||LA34_239=='_'||(LA34_239>='a' && LA34_239<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=11;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'i':
            {
            switch ( input.LA(2) ) {
            case 'm':
                {
                int LA34_74 = input.LA(3);

                if ( (LA34_74=='p') ) {
                    switch ( input.LA(4) ) {
                    case 'o':
                        {
                        int LA34_240 = input.LA(5);

                        if ( (LA34_240=='r') ) {
                            int LA34_299 = input.LA(6);

                            if ( (LA34_299=='t') ) {
                                int LA34_344 = input.LA(7);

                                if ( (LA34_344=='$'||(LA34_344>='0' && LA34_344<='9')||(LA34_344>='A' && LA34_344<='Z')||LA34_344=='\\'||LA34_344=='_'||(LA34_344>='a' && LA34_344<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=50;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                        }
                        break;
                    case 'l':
                        {
                        int LA34_241 = input.LA(5);

                        if ( (LA34_241=='e') ) {
                            int LA34_300 = input.LA(6);

                            if ( (LA34_300=='m') ) {
                                int LA34_345 = input.LA(7);

                                if ( (LA34_345=='e') ) {
                                    int LA34_378 = input.LA(8);

                                    if ( (LA34_378=='n') ) {
                                        int LA34_400 = input.LA(9);

                                        if ( (LA34_400=='t') ) {
                                            int LA34_414 = input.LA(10);

                                            if ( (LA34_414=='s') ) {
                                                int LA34_423 = input.LA(11);

                                                if ( (LA34_423=='$'||(LA34_423>='0' && LA34_423<='9')||(LA34_423>='A' && LA34_423<='Z')||LA34_423=='\\'||LA34_423=='_'||(LA34_423>='a' && LA34_423<='z')) ) {
                                                    alt34=121;
                                                }
                                                else {
                                                    alt34=49;}
                                            }
                                            else {
                                                alt34=121;}
                                        }
                                        else {
                                            alt34=121;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                        }
                        break;
                    default:
                        alt34=121;}

                }
                else {
                    alt34=121;}
                }
                break;
            case 'n':
                {
                switch ( input.LA(3) ) {
                case 's':
                    {
                    int LA34_171 = input.LA(4);

                    if ( (LA34_171=='t') ) {
                        int LA34_242 = input.LA(5);

                        if ( (LA34_242=='a') ) {
                            int LA34_301 = input.LA(6);

                            if ( (LA34_301=='n') ) {
                                int LA34_346 = input.LA(7);

                                if ( (LA34_346=='c') ) {
                                    int LA34_379 = input.LA(8);

                                    if ( (LA34_379=='e') ) {
                                        int LA34_401 = input.LA(9);

                                        if ( (LA34_401=='o') ) {
                                            int LA34_415 = input.LA(10);

                                            if ( (LA34_415=='f') ) {
                                                int LA34_424 = input.LA(11);

                                                if ( (LA34_424=='$'||(LA34_424>='0' && LA34_424<='9')||(LA34_424>='A' && LA34_424<='Z')||LA34_424=='\\'||LA34_424=='_'||(LA34_424>='a' && LA34_424<='z')) ) {
                                                    alt34=121;
                                                }
                                                else {
                                                    alt34=18;}
                                            }
                                            else {
                                                alt34=121;}
                                        }
                                        else {
                                            alt34=121;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 't':
                    {
                    switch ( input.LA(4) ) {
                    case 'e':
                        {
                        int LA34_243 = input.LA(5);

                        if ( (LA34_243=='r') ) {
                            int LA34_302 = input.LA(6);

                            if ( (LA34_302=='f') ) {
                                int LA34_347 = input.LA(7);

                                if ( (LA34_347=='a') ) {
                                    int LA34_380 = input.LA(8);

                                    if ( (LA34_380=='c') ) {
                                        int LA34_402 = input.LA(9);

                                        if ( (LA34_402=='e') ) {
                                            int LA34_416 = input.LA(10);

                                            if ( (LA34_416=='$'||(LA34_416>='0' && LA34_416<='9')||(LA34_416>='A' && LA34_416<='Z')||LA34_416=='\\'||LA34_416=='_'||(LA34_416>='a' && LA34_416<='z')) ) {
                                                alt34=121;
                                            }
                                            else {
                                                alt34=52;}
                                        }
                                        else {
                                            alt34=121;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                        }
                        break;
                    case '$':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                    case 'G':
                    case 'H':
                    case 'I':
                    case 'J':
                    case 'K':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'O':
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                    case 'T':
                    case 'U':
                    case 'V':
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                    case '\\':
                    case '_':
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                        {
                        alt34=121;
                        }
                        break;
                    default:
                        alt34=51;}

                    }
                    break;
                case '$':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '\\':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt34=121;
                    }
                    break;
                default:
                    alt34=17;}

                }
                break;
            case 'f':
                {
                int LA34_76 = input.LA(3);

                if ( (LA34_76=='$'||(LA34_76>='0' && LA34_76<='9')||(LA34_76>='A' && LA34_76<='Z')||LA34_76=='\\'||LA34_76=='_'||(LA34_76>='a' && LA34_76<='z')) ) {
                    alt34=121;
                }
                else {
                    alt34=16;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'r':
            {
            int LA34_9 = input.LA(2);

            if ( (LA34_9=='e') ) {
                int LA34_77 = input.LA(3);

                if ( (LA34_77=='t') ) {
                    int LA34_175 = input.LA(4);

                    if ( (LA34_175=='u') ) {
                        int LA34_245 = input.LA(5);

                        if ( (LA34_245=='r') ) {
                            int LA34_303 = input.LA(6);

                            if ( (LA34_303=='n') ) {
                                int LA34_348 = input.LA(7);

                                if ( (LA34_348=='$'||(LA34_348>='0' && LA34_348<='9')||(LA34_348>='A' && LA34_348<='Z')||LA34_348=='\\'||LA34_348=='_'||(LA34_348>='a' && LA34_348<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=20;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
            }
            else {
                alt34=121;}
            }
            break;
        case 's':
            {
            switch ( input.LA(2) ) {
            case 'h':
                {
                int LA34_78 = input.LA(3);

                if ( (LA34_78=='o') ) {
                    int LA34_176 = input.LA(4);

                    if ( (LA34_176=='r') ) {
                        int LA34_246 = input.LA(5);

                        if ( (LA34_246=='t') ) {
                            int LA34_304 = input.LA(6);

                            if ( (LA34_304=='$'||(LA34_304>='0' && LA34_304<='9')||(LA34_304>='A' && LA34_304<='Z')||LA34_304=='\\'||LA34_304=='_'||(LA34_304>='a' && LA34_304<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=59;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 't':
                {
                int LA34_79 = input.LA(3);

                if ( (LA34_79=='a') ) {
                    int LA34_177 = input.LA(4);

                    if ( (LA34_177=='t') ) {
                        int LA34_247 = input.LA(5);

                        if ( (LA34_247=='i') ) {
                            int LA34_305 = input.LA(6);

                            if ( (LA34_305=='c') ) {
                                int LA34_350 = input.LA(7);

                                if ( (LA34_350=='$'||(LA34_350>='0' && LA34_350<='9')||(LA34_350>='A' && LA34_350<='Z')||LA34_350=='\\'||LA34_350=='_'||(LA34_350>='a' && LA34_350<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=60;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'u':
                {
                int LA34_80 = input.LA(3);

                if ( (LA34_80=='p') ) {
                    int LA34_178 = input.LA(4);

                    if ( (LA34_178=='e') ) {
                        int LA34_248 = input.LA(5);

                        if ( (LA34_248=='r') ) {
                            int LA34_306 = input.LA(6);

                            if ( (LA34_306=='$'||(LA34_306>='0' && LA34_306<='9')||(LA34_306>='A' && LA34_306<='Z')||LA34_306=='\\'||LA34_306=='_'||(LA34_306>='a' && LA34_306<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=61;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'y':
                {
                int LA34_81 = input.LA(3);

                if ( (LA34_81=='n') ) {
                    int LA34_179 = input.LA(4);

                    if ( (LA34_179=='c') ) {
                        int LA34_249 = input.LA(5);

                        if ( (LA34_249=='h') ) {
                            int LA34_307 = input.LA(6);

                            if ( (LA34_307=='r') ) {
                                int LA34_352 = input.LA(7);

                                if ( (LA34_352=='o') ) {
                                    int LA34_383 = input.LA(8);

                                    if ( (LA34_383=='n') ) {
                                        int LA34_403 = input.LA(9);

                                        if ( (LA34_403=='i') ) {
                                            int LA34_417 = input.LA(10);

                                            if ( (LA34_417=='z') ) {
                                                int LA34_426 = input.LA(11);

                                                if ( (LA34_426=='e') ) {
                                                    int LA34_430 = input.LA(12);

                                                    if ( (LA34_430=='d') ) {
                                                        int LA34_431 = input.LA(13);

                                                        if ( (LA34_431=='$'||(LA34_431>='0' && LA34_431<='9')||(LA34_431>='A' && LA34_431<='Z')||LA34_431=='\\'||LA34_431=='_'||(LA34_431>='a' && LA34_431<='z')) ) {
                                                            alt34=121;
                                                        }
                                                        else {
                                                            alt34=62;}
                                                    }
                                                    else {
                                                        alt34=121;}
                                                }
                                                else {
                                                    alt34=121;}
                                            }
                                            else {
                                                alt34=121;}
                                        }
                                        else {
                                            alt34=121;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'e':
                {
                int LA34_82 = input.LA(3);

                if ( (LA34_82=='t') ) {
                    int LA34_180 = input.LA(4);

                    if ( (LA34_180=='$'||(LA34_180>='0' && LA34_180<='9')||(LA34_180>='A' && LA34_180<='Z')||LA34_180=='\\'||LA34_180=='_'||(LA34_180>='a' && LA34_180<='z')) ) {
                        alt34=121;
                    }
                    else {
                        alt34=31;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'w':
                {
                int LA34_83 = input.LA(3);

                if ( (LA34_83=='i') ) {
                    int LA34_181 = input.LA(4);

                    if ( (LA34_181=='t') ) {
                        int LA34_251 = input.LA(5);

                        if ( (LA34_251=='c') ) {
                            int LA34_308 = input.LA(6);

                            if ( (LA34_308=='h') ) {
                                int LA34_353 = input.LA(7);

                                if ( (LA34_353=='$'||(LA34_353>='0' && LA34_353<='9')||(LA34_353>='A' && LA34_353<='Z')||LA34_353=='\\'||LA34_353=='_'||(LA34_353>='a' && LA34_353<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=21;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'v':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                switch ( input.LA(3) ) {
                case 'l':
                    {
                    int LA34_182 = input.LA(4);

                    if ( (LA34_182=='a') ) {
                        int LA34_252 = input.LA(5);

                        if ( (LA34_252=='t') ) {
                            int LA34_309 = input.LA(6);

                            if ( (LA34_309=='i') ) {
                                int LA34_354 = input.LA(7);

                                if ( (LA34_354=='l') ) {
                                    int LA34_385 = input.LA(8);

                                    if ( (LA34_385=='e') ) {
                                        int LA34_404 = input.LA(9);

                                        if ( (LA34_404=='$'||(LA34_404>='0' && LA34_404<='9')||(LA34_404>='A' && LA34_404<='Z')||LA34_404=='\\'||LA34_404=='_'||(LA34_404>='a' && LA34_404<='z')) ) {
                                            alt34=121;
                                        }
                                        else {
                                            alt34=65;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 'i':
                    {
                    int LA34_183 = input.LA(4);

                    if ( (LA34_183=='d') ) {
                        int LA34_253 = input.LA(5);

                        if ( (LA34_253=='$'||(LA34_253>='0' && LA34_253<='9')||(LA34_253>='A' && LA34_253<='Z')||LA34_253=='\\'||LA34_253=='_'||(LA34_253>='a' && LA34_253<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=27;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                default:
                    alt34=121;}

                }
                break;
            case 'a':
                {
                int LA34_85 = input.LA(3);

                if ( (LA34_85=='r') ) {
                    int LA34_184 = input.LA(4);

                    if ( (LA34_184=='$'||(LA34_184>='0' && LA34_184<='9')||(LA34_184>='A' && LA34_184<='Z')||LA34_184=='\\'||LA34_184=='_'||(LA34_184>='a' && LA34_184<='z')) ) {
                        alt34=121;
                    }
                    else {
                        alt34=26;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'w':
            {
            switch ( input.LA(2) ) {
            case 'h':
                {
                int LA34_86 = input.LA(3);

                if ( (LA34_86=='i') ) {
                    int LA34_185 = input.LA(4);

                    if ( (LA34_185=='l') ) {
                        int LA34_255 = input.LA(5);

                        if ( (LA34_255=='e') ) {
                            int LA34_311 = input.LA(6);

                            if ( (LA34_311=='$'||(LA34_311>='0' && LA34_311<='9')||(LA34_311>='A' && LA34_311<='Z')||LA34_311=='\\'||LA34_311=='_'||(LA34_311>='a' && LA34_311<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=28;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'i':
                {
                int LA34_87 = input.LA(3);

                if ( (LA34_87=='t') ) {
                    int LA34_186 = input.LA(4);

                    if ( (LA34_186=='h') ) {
                        int LA34_256 = input.LA(5);

                        if ( (LA34_256=='$'||(LA34_256>='0' && LA34_256<='9')||(LA34_256>='A' && LA34_256<='Z')||LA34_256=='\\'||LA34_256=='_'||(LA34_256>='a' && LA34_256<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=29;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'g':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA34_88 = input.LA(3);

                if ( (LA34_88=='t') ) {
                    int LA34_187 = input.LA(4);

                    if ( (LA34_187=='o') ) {
                        int LA34_257 = input.LA(5);

                        if ( (LA34_257=='$'||(LA34_257>='0' && LA34_257<='9')||(LA34_257>='A' && LA34_257<='Z')||LA34_257=='\\'||LA34_257=='_'||(LA34_257>='a' && LA34_257<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=48;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'e':
                {
                int LA34_89 = input.LA(3);

                if ( (LA34_89=='t') ) {
                    int LA34_188 = input.LA(4);

                    if ( (LA34_188=='$'||(LA34_188>='0' && LA34_188<='9')||(LA34_188>='A' && LA34_188<='Z')||LA34_188=='\\'||LA34_188=='_'||(LA34_188>='a' && LA34_188<='z')) ) {
                        alt34=121;
                    }
                    else {
                        alt34=30;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case 'y':
            {
            int LA34_14 = input.LA(2);

            if ( (LA34_14=='i') ) {
                int LA34_90 = input.LA(3);

                if ( (LA34_90=='e') ) {
                    int LA34_189 = input.LA(4);

                    if ( (LA34_189=='l') ) {
                        int LA34_259 = input.LA(5);

                        if ( (LA34_259=='d') ) {
                            int LA34_314 = input.LA(6);

                            if ( (LA34_314=='$'||(LA34_314>='0' && LA34_314<='9')||(LA34_314>='A' && LA34_314<='Z')||LA34_314=='\\'||LA34_314=='_'||(LA34_314>='a' && LA34_314<='z')) ) {
                                alt34=121;
                            }
                            else {
                                alt34=32;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
            }
            else {
                alt34=121;}
            }
            break;
        case 'x':
            {
            int LA34_15 = input.LA(2);

            if ( (LA34_15=='m') ) {
                int LA34_91 = input.LA(3);

                if ( (LA34_91=='l') ) {
                    int LA34_190 = input.LA(4);

                    if ( (LA34_190=='$'||(LA34_190>='0' && LA34_190<='9')||(LA34_190>='A' && LA34_190<='Z')||LA34_190=='\\'||LA34_190=='_'||(LA34_190>='a' && LA34_190<='z')) ) {
                        alt34=121;
                    }
                    else {
                        alt34=33;}
                }
                else {
                    alt34=121;}
            }
            else {
                alt34=121;}
            }
            break;
        case 'a':
            {
            int LA34_16 = input.LA(2);

            if ( (LA34_16=='b') ) {
                int LA34_92 = input.LA(3);

                if ( (LA34_92=='s') ) {
                    int LA34_191 = input.LA(4);

                    if ( (LA34_191=='t') ) {
                        int LA34_261 = input.LA(5);

                        if ( (LA34_261=='r') ) {
                            int LA34_315 = input.LA(6);

                            if ( (LA34_315=='a') ) {
                                int LA34_357 = input.LA(7);

                                if ( (LA34_357=='c') ) {
                                    int LA34_386 = input.LA(8);

                                    if ( (LA34_386=='t') ) {
                                        int LA34_405 = input.LA(9);

                                        if ( (LA34_405=='$'||(LA34_405>='0' && LA34_405<='9')||(LA34_405>='A' && LA34_405<='Z')||LA34_405=='\\'||LA34_405=='_'||(LA34_405>='a' && LA34_405<='z')) ) {
                                            alt34=121;
                                        }
                                        else {
                                            alt34=35;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
            }
            else {
                alt34=121;}
            }
            break;
        case 'l':
            {
            int LA34_17 = input.LA(2);

            if ( (LA34_17=='o') ) {
                int LA34_93 = input.LA(3);

                if ( (LA34_93=='n') ) {
                    int LA34_192 = input.LA(4);

                    if ( (LA34_192=='g') ) {
                        int LA34_262 = input.LA(5);

                        if ( (LA34_262=='$'||(LA34_262>='0' && LA34_262<='9')||(LA34_262>='A' && LA34_262<='Z')||LA34_262=='\\'||LA34_262=='_'||(LA34_262>='a' && LA34_262<='z')) ) {
                            alt34=121;
                        }
                        else {
                            alt34=53;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
            }
            else {
                alt34=121;}
            }
            break;
        case 'p':
            {
            switch ( input.LA(2) ) {
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'o':
                    {
                    int LA34_193 = input.LA(4);

                    if ( (LA34_193=='t') ) {
                        int LA34_263 = input.LA(5);

                        if ( (LA34_263=='e') ) {
                            int LA34_317 = input.LA(6);

                            if ( (LA34_317=='c') ) {
                                int LA34_358 = input.LA(7);

                                if ( (LA34_358=='t') ) {
                                    int LA34_387 = input.LA(8);

                                    if ( (LA34_387=='e') ) {
                                        int LA34_406 = input.LA(9);

                                        if ( (LA34_406=='d') ) {
                                            int LA34_420 = input.LA(10);

                                            if ( (LA34_420=='$'||(LA34_420>='0' && LA34_420<='9')||(LA34_420>='A' && LA34_420<='Z')||LA34_420=='\\'||LA34_420=='_'||(LA34_420>='a' && LA34_420<='z')) ) {
                                                alt34=121;
                                            }
                                            else {
                                                alt34=57;}
                                        }
                                        else {
                                            alt34=121;}
                                    }
                                    else {
                                        alt34=121;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                case 'i':
                    {
                    int LA34_194 = input.LA(4);

                    if ( (LA34_194=='v') ) {
                        int LA34_264 = input.LA(5);

                        if ( (LA34_264=='a') ) {
                            int LA34_318 = input.LA(6);

                            if ( (LA34_318=='t') ) {
                                int LA34_359 = input.LA(7);

                                if ( (LA34_359=='e') ) {
                                    int LA34_388 = input.LA(8);

                                    if ( (LA34_388=='$'||(LA34_388>='0' && LA34_388<='9')||(LA34_388>='A' && LA34_388<='Z')||LA34_388=='\\'||LA34_388=='_'||(LA34_388>='a' && LA34_388<='z')) ) {
                                        alt34=121;
                                    }
                                    else {
                                        alt34=56;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                    }
                    break;
                default:
                    alt34=121;}

                }
                break;
            case 'a':
                {
                int LA34_95 = input.LA(3);

                if ( (LA34_95=='c') ) {
                    int LA34_195 = input.LA(4);

                    if ( (LA34_195=='k') ) {
                        int LA34_265 = input.LA(5);

                        if ( (LA34_265=='a') ) {
                            int LA34_319 = input.LA(6);

                            if ( (LA34_319=='g') ) {
                                int LA34_360 = input.LA(7);

                                if ( (LA34_360=='e') ) {
                                    int LA34_389 = input.LA(8);

                                    if ( (LA34_389=='$'||(LA34_389>='0' && LA34_389<='9')||(LA34_389>='A' && LA34_389<='Z')||LA34_389=='\\'||LA34_389=='_'||(LA34_389>='a' && LA34_389<='z')) ) {
                                        alt34=121;
                                    }
                                    else {
                                        alt34=55;}
                                }
                                else {
                                    alt34=121;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            case 'u':
                {
                int LA34_96 = input.LA(3);

                if ( (LA34_96=='b') ) {
                    int LA34_196 = input.LA(4);

                    if ( (LA34_196=='l') ) {
                        int LA34_266 = input.LA(5);

                        if ( (LA34_266=='i') ) {
                            int LA34_320 = input.LA(6);

                            if ( (LA34_320=='c') ) {
                                int LA34_361 = input.LA(7);

                                if ( (LA34_361=='$'||(LA34_361>='0' && LA34_361<='9')||(LA34_361>='A' && LA34_361<='Z')||LA34_361=='\\'||LA34_361=='_'||(LA34_361>='a' && LA34_361<='z')) ) {
                                    alt34=121;
                                }
                                else {
                                    alt34=58;}
                            }
                            else {
                                alt34=121;}
                        }
                        else {
                            alt34=121;}
                    }
                    else {
                        alt34=121;}
                }
                else {
                    alt34=121;}
                }
                break;
            default:
                alt34=121;}

            }
            break;
        case '{':
            {
            alt34=66;
            }
            break;
        case '}':
            {
            alt34=67;
            }
            break;
        case '(':
            {
            alt34=68;
            }
            break;
        case ')':
            {
            alt34=69;
            }
            break;
        case '[':
            {
            alt34=70;
            }
            break;
        case ']':
            {
            alt34=71;
            }
            break;
        case '.':
            {
            switch ( input.LA(2) ) {
            case '.':
                {
                alt34=115;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt34=123;
                }
                break;
            default:
                alt34=72;}

            }
            break;
        case ';':
            {
            alt34=73;
            }
            break;
        case ',':
            {
            alt34=74;
            }
            break;
        case '<':
            {
            int LA34_28 = input.LA(2);

            if ( (LA34_28=='=') ) {
                alt34=77;
            }
            else if ( (LA34_28=='<') ) {
                int LA34_100 = input.LA(3);

                if ( (LA34_100=='=') ) {
                    alt34=106;
                }
                else {
                    alt34=89;}
            }
            else if ( (LA34_28=='!'||LA34_28==':'||(LA34_28>='>' && LA34_28<='?')||(LA34_28>='A' && LA34_28<='Z')||LA34_28=='_'||(LA34_28>='a' && LA34_28<='{')) && ( isXmlStartEnabled() )) {
                alt34=122;
            }
            else {
                alt34=75;}
            }
            break;
        case '>':
            {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt34=78;
                }
                break;
            case '>':
                {
                switch ( input.LA(3) ) {
                case '>':
                    {
                    int LA34_199 = input.LA(4);

                    if ( (LA34_199=='=') ) {
                        alt34=108;
                    }
                    else {
                        alt34=91;}
                    }
                    break;
                case '=':
                    {
                    alt34=107;
                    }
                    break;
                default:
                    alt34=90;}

                }
                break;
            default:
                alt34=76;}

            }
            break;
        case '=':
            {
            int LA34_30 = input.LA(2);

            if ( (LA34_30=='=') ) {
                int LA34_106 = input.LA(3);

                if ( (LA34_106=='=') ) {
                    alt34=81;
                }
                else {
                    alt34=79;}
            }
            else {
                alt34=101;}
            }
            break;
        case '!':
            {
            int LA34_31 = input.LA(2);

            if ( (LA34_31=='=') ) {
                int LA34_108 = input.LA(3);

                if ( (LA34_108=='=') ) {
                    alt34=82;
                }
                else {
                    alt34=80;}
            }
            else {
                alt34=95;}
            }
            break;
        case '+':
            {
            switch ( input.LA(2) ) {
            case '+':
                {
                alt34=87;
                }
                break;
            case '=':
                {
                alt34=102;
                }
                break;
            default:
                alt34=83;}

            }
            break;
        case '-':
            {
            switch ( input.LA(2) ) {
            case '-':
                {
                alt34=88;
                }
                break;
            case '=':
                {
                alt34=103;
                }
                break;
            default:
                alt34=84;}

            }
            break;
        case '*':
            {
            int LA34_34 = input.LA(2);

            if ( (LA34_34=='=') ) {
                alt34=104;
            }
            else {
                alt34=85;}
            }
            break;
        case '%':
            {
            int LA34_35 = input.LA(2);

            if ( (LA34_35=='=') ) {
                alt34=105;
            }
            else {
                alt34=86;}
            }
            break;
        case '&':
            {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt34=109;
                }
                break;
            case '&':
                {
                alt34=97;
                }
                break;
            default:
                alt34=92;}

            }
            break;
        case '|':
            {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt34=110;
                }
                break;
            case '|':
                {
                alt34=98;
                }
                break;
            default:
                alt34=93;}

            }
            break;
        case '^':
            {
            int LA34_38 = input.LA(2);

            if ( (LA34_38=='=') ) {
                alt34=111;
            }
            else {
                alt34=94;}
            }
            break;
        case '~':
            {
            alt34=96;
            }
            break;
        case '?':
            {
            alt34=99;
            }
            break;
        case ':':
            {
            int LA34_41 = input.LA(2);

            if ( (LA34_41==':') ) {
                alt34=116;
            }
            else {
                alt34=100;}
            }
            break;
        case '/':
            {
            int LA34_42 = input.LA(2);

            if ( (LA34_42=='=') ) {
                int LA34_130 = input.LA(3);

                if ( ((LA34_130>='\u0000' && LA34_130<='\t')||(LA34_130>='\u000B' && LA34_130<='\f')||(LA34_130>='\u000E' && LA34_130<='\u2027')||(LA34_130>='\u202A' && LA34_130<='\uFFFE')) && ( areRegularExpressionsEnabled() )) {
                    alt34=127;
                }
                else {
                    alt34=113;}
            }
            else if ( (LA34_42=='*') ) {
                alt34=119;
            }
            else if ( (LA34_42=='/') ) {
                alt34=120;
            }
            else if ( ((LA34_42>='\u0000' && LA34_42<='\t')||(LA34_42>='\u000B' && LA34_42<='\f')||(LA34_42>='\u000E' && LA34_42<=')')||(LA34_42>='+' && LA34_42<='.')||(LA34_42>='0' && LA34_42<='<')||(LA34_42>='>' && LA34_42<='\u2027')||(LA34_42>='\u202A' && LA34_42<='\uFFFE')) && ( areRegularExpressionsEnabled() )) {
                alt34=127;
            }
            else {
                alt34=112;}
            }
            break;
        case '@':
            {
            alt34=114;
            }
            break;
        case '\t':
        case '\u000B':
        case '\f':
        case ' ':
        case '\u00A0':
        case '\u1680':
        case '\u180E':
        case '\u2000':
        case '\u2001':
        case '\u2002':
        case '\u2003':
        case '\u2004':
        case '\u2005':
        case '\u2006':
        case '\u2007':
        case '\u2008':
        case '\u2009':
        case '\u200A':
        case '\u202F':
        case '\u205F':
        case '\u3000':
        case '\uFEFF':
            {
            alt34=117;
            }
            break;
        case '\n':
        case '\r':
        case '\u2028':
        case '\u2029':
            {
            alt34=118;
            }
            break;
        case '0':
            {
            switch ( input.LA(2) ) {
            case 'X':
            case 'x':
                {
                alt34=125;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
                {
                alt34=124;
                }
                break;
            default:
                alt34=123;}

            }
            break;
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt34=123;
            }
            break;
        case '\"':
        case '\'':
            {
            alt34=126;
            }
            break;
        default:
            alt34=121;}

        switch (alt34) {
            case 1 :
                // JS.g:1:10: NULL
                {
                mNULL(); 

                }
                break;
            case 2 :
                // JS.g:1:15: TRUE
                {
                mTRUE(); 

                }
                break;
            case 3 :
                // JS.g:1:20: FALSE
                {
                mFALSE(); 

                }
                break;
            case 4 :
                // JS.g:1:26: BREAK
                {
                mBREAK(); 

                }
                break;
            case 5 :
                // JS.g:1:32: CASE
                {
                mCASE(); 

                }
                break;
            case 6 :
                // JS.g:1:37: CATCH
                {
                mCATCH(); 

                }
                break;
            case 7 :
                // JS.g:1:43: CONTINUE
                {
                mCONTINUE(); 

                }
                break;
            case 8 :
                // JS.g:1:52: DEFAULT
                {
                mDEFAULT(); 

                }
                break;
            case 9 :
                // JS.g:1:60: DELETE
                {
                mDELETE(); 

                }
                break;
            case 10 :
                // JS.g:1:67: DO
                {
                mDO(); 

                }
                break;
            case 11 :
                // JS.g:1:70: ELSE
                {
                mELSE(); 

                }
                break;
            case 12 :
                // JS.g:1:75: FINALLY
                {
                mFINALLY(); 

                }
                break;
            case 13 :
                // JS.g:1:83: FOR
                {
                mFOR(); 

                }
                break;
            case 14 :
                // JS.g:1:87: EACH
                {
                mEACH(); 

                }
                break;
            case 15 :
                // JS.g:1:92: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 16 :
                // JS.g:1:101: IF
                {
                mIF(); 

                }
                break;
            case 17 :
                // JS.g:1:104: IN
                {
                mIN(); 

                }
                break;
            case 18 :
                // JS.g:1:107: INSTANCEOF
                {
                mINSTANCEOF(); 

                }
                break;
            case 19 :
                // JS.g:1:118: NEW
                {
                mNEW(); 

                }
                break;
            case 20 :
                // JS.g:1:122: RETURN
                {
                mRETURN(); 

                }
                break;
            case 21 :
                // JS.g:1:129: SWITCH
                {
                mSWITCH(); 

                }
                break;
            case 22 :
                // JS.g:1:136: THIS
                {
                mTHIS(); 

                }
                break;
            case 23 :
                // JS.g:1:141: THROW
                {
                mTHROW(); 

                }
                break;
            case 24 :
                // JS.g:1:147: TRY
                {
                mTRY(); 

                }
                break;
            case 25 :
                // JS.g:1:151: TYPEOF
                {
                mTYPEOF(); 

                }
                break;
            case 26 :
                // JS.g:1:158: VAR
                {
                mVAR(); 

                }
                break;
            case 27 :
                // JS.g:1:162: VOID
                {
                mVOID(); 

                }
                break;
            case 28 :
                // JS.g:1:167: WHILE
                {
                mWHILE(); 

                }
                break;
            case 29 :
                // JS.g:1:173: WITH
                {
                mWITH(); 

                }
                break;
            case 30 :
                // JS.g:1:178: GET
                {
                mGET(); 

                }
                break;
            case 31 :
                // JS.g:1:182: SET
                {
                mSET(); 

                }
                break;
            case 32 :
                // JS.g:1:186: YIELD
                {
                mYIELD(); 

                }
                break;
            case 33 :
                // JS.g:1:192: WXML
                {
                mWXML(); 

                }
                break;
            case 34 :
                // JS.g:1:197: NAMESPACE
                {
                mNAMESPACE(); 

                }
                break;
            case 35 :
                // JS.g:1:207: ABSTRACT
                {
                mABSTRACT(); 

                }
                break;
            case 36 :
                // JS.g:1:216: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 37 :
                // JS.g:1:224: BYTE
                {
                mBYTE(); 

                }
                break;
            case 38 :
                // JS.g:1:229: CHAR
                {
                mCHAR(); 

                }
                break;
            case 39 :
                // JS.g:1:234: CLASS
                {
                mCLASS(); 

                }
                break;
            case 40 :
                // JS.g:1:240: CONST
                {
                mCONST(); 

                }
                break;
            case 41 :
                // JS.g:1:246: DEBUGGER
                {
                mDEBUGGER(); 

                }
                break;
            case 42 :
                // JS.g:1:255: DOUBLE
                {
                mDOUBLE(); 

                }
                break;
            case 43 :
                // JS.g:1:262: ENUM
                {
                mENUM(); 

                }
                break;
            case 44 :
                // JS.g:1:267: EXPORT
                {
                mEXPORT(); 

                }
                break;
            case 45 :
                // JS.g:1:274: EXTENDS
                {
                mEXTENDS(); 

                }
                break;
            case 46 :
                // JS.g:1:282: FINAL
                {
                mFINAL(); 

                }
                break;
            case 47 :
                // JS.g:1:288: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 48 :
                // JS.g:1:294: GOTO
                {
                mGOTO(); 

                }
                break;
            case 49 :
                // JS.g:1:299: IMPLEMENTS
                {
                mIMPLEMENTS(); 

                }
                break;
            case 50 :
                // JS.g:1:310: IMPORT
                {
                mIMPORT(); 

                }
                break;
            case 51 :
                // JS.g:1:317: INT
                {
                mINT(); 

                }
                break;
            case 52 :
                // JS.g:1:321: INTERFACE
                {
                mINTERFACE(); 

                }
                break;
            case 53 :
                // JS.g:1:331: LONG
                {
                mLONG(); 

                }
                break;
            case 54 :
                // JS.g:1:336: NATIVE
                {
                mNATIVE(); 

                }
                break;
            case 55 :
                // JS.g:1:343: PACKAGE
                {
                mPACKAGE(); 

                }
                break;
            case 56 :
                // JS.g:1:351: PRIVATE
                {
                mPRIVATE(); 

                }
                break;
            case 57 :
                // JS.g:1:359: PROTECTED
                {
                mPROTECTED(); 

                }
                break;
            case 58 :
                // JS.g:1:369: PUBLIC
                {
                mPUBLIC(); 

                }
                break;
            case 59 :
                // JS.g:1:376: SHORT
                {
                mSHORT(); 

                }
                break;
            case 60 :
                // JS.g:1:382: STATIC
                {
                mSTATIC(); 

                }
                break;
            case 61 :
                // JS.g:1:389: SUPER
                {
                mSUPER(); 

                }
                break;
            case 62 :
                // JS.g:1:395: SYNCHRONIZED
                {
                mSYNCHRONIZED(); 

                }
                break;
            case 63 :
                // JS.g:1:408: THROWS
                {
                mTHROWS(); 

                }
                break;
            case 64 :
                // JS.g:1:415: TRANSIENT
                {
                mTRANSIENT(); 

                }
                break;
            case 65 :
                // JS.g:1:425: VOLATILE
                {
                mVOLATILE(); 

                }
                break;
            case 66 :
                // JS.g:1:434: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 67 :
                // JS.g:1:441: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 68 :
                // JS.g:1:448: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 69 :
                // JS.g:1:455: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 70 :
                // JS.g:1:462: LBRACK
                {
                mLBRACK(); 

                }
                break;
            case 71 :
                // JS.g:1:469: RBRACK
                {
                mRBRACK(); 

                }
                break;
            case 72 :
                // JS.g:1:476: DOT
                {
                mDOT(); 

                }
                break;
            case 73 :
                // JS.g:1:480: SEMIC
                {
                mSEMIC(); 

                }
                break;
            case 74 :
                // JS.g:1:486: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 75 :
                // JS.g:1:492: LT
                {
                mLT(); 

                }
                break;
            case 76 :
                // JS.g:1:495: GT
                {
                mGT(); 

                }
                break;
            case 77 :
                // JS.g:1:498: LTE
                {
                mLTE(); 

                }
                break;
            case 78 :
                // JS.g:1:502: GTE
                {
                mGTE(); 

                }
                break;
            case 79 :
                // JS.g:1:506: EQ
                {
                mEQ(); 

                }
                break;
            case 80 :
                // JS.g:1:509: NEQ
                {
                mNEQ(); 

                }
                break;
            case 81 :
                // JS.g:1:513: SAME
                {
                mSAME(); 

                }
                break;
            case 82 :
                // JS.g:1:518: NSAME
                {
                mNSAME(); 

                }
                break;
            case 83 :
                // JS.g:1:524: ADD
                {
                mADD(); 

                }
                break;
            case 84 :
                // JS.g:1:528: SUB
                {
                mSUB(); 

                }
                break;
            case 85 :
                // JS.g:1:532: MUL
                {
                mMUL(); 

                }
                break;
            case 86 :
                // JS.g:1:536: MOD
                {
                mMOD(); 

                }
                break;
            case 87 :
                // JS.g:1:540: INC
                {
                mINC(); 

                }
                break;
            case 88 :
                // JS.g:1:544: DEC
                {
                mDEC(); 

                }
                break;
            case 89 :
                // JS.g:1:548: SHL
                {
                mSHL(); 

                }
                break;
            case 90 :
                // JS.g:1:552: SHR
                {
                mSHR(); 

                }
                break;
            case 91 :
                // JS.g:1:556: SHU
                {
                mSHU(); 

                }
                break;
            case 92 :
                // JS.g:1:560: AND
                {
                mAND(); 

                }
                break;
            case 93 :
                // JS.g:1:564: OR
                {
                mOR(); 

                }
                break;
            case 94 :
                // JS.g:1:567: XOR
                {
                mXOR(); 

                }
                break;
            case 95 :
                // JS.g:1:571: NOT
                {
                mNOT(); 

                }
                break;
            case 96 :
                // JS.g:1:575: INV
                {
                mINV(); 

                }
                break;
            case 97 :
                // JS.g:1:579: LAND
                {
                mLAND(); 

                }
                break;
            case 98 :
                // JS.g:1:584: LOR
                {
                mLOR(); 

                }
                break;
            case 99 :
                // JS.g:1:588: QUE
                {
                mQUE(); 

                }
                break;
            case 100 :
                // JS.g:1:592: COLON
                {
                mCOLON(); 

                }
                break;
            case 101 :
                // JS.g:1:598: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 102 :
                // JS.g:1:605: ADDASS
                {
                mADDASS(); 

                }
                break;
            case 103 :
                // JS.g:1:612: SUBASS
                {
                mSUBASS(); 

                }
                break;
            case 104 :
                // JS.g:1:619: MULASS
                {
                mMULASS(); 

                }
                break;
            case 105 :
                // JS.g:1:626: MODASS
                {
                mMODASS(); 

                }
                break;
            case 106 :
                // JS.g:1:633: SHLASS
                {
                mSHLASS(); 

                }
                break;
            case 107 :
                // JS.g:1:640: SHRASS
                {
                mSHRASS(); 

                }
                break;
            case 108 :
                // JS.g:1:647: SHUASS
                {
                mSHUASS(); 

                }
                break;
            case 109 :
                // JS.g:1:654: ANDASS
                {
                mANDASS(); 

                }
                break;
            case 110 :
                // JS.g:1:661: ORASS
                {
                mORASS(); 

                }
                break;
            case 111 :
                // JS.g:1:667: XORASS
                {
                mXORASS(); 

                }
                break;
            case 112 :
                // JS.g:1:674: DIV
                {
                mDIV(); 

                }
                break;
            case 113 :
                // JS.g:1:678: DIVASS
                {
                mDIVASS(); 

                }
                break;
            case 114 :
                // JS.g:1:685: AT
                {
                mAT(); 

                }
                break;
            case 115 :
                // JS.g:1:688: DOTDOT
                {
                mDOTDOT(); 

                }
                break;
            case 116 :
                // JS.g:1:695: COLONCOLON
                {
                mCOLONCOLON(); 

                }
                break;
            case 117 :
                // JS.g:1:706: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;
            case 118 :
                // JS.g:1:717: EOL
                {
                mEOL(); 

                }
                break;
            case 119 :
                // JS.g:1:721: MultiLineComment
                {
                mMultiLineComment(); 

                }
                break;
            case 120 :
                // JS.g:1:738: SingleLineComment
                {
                mSingleLineComment(); 

                }
                break;
            case 121 :
                // JS.g:1:756: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 122 :
                // JS.g:1:767: XMLFragment
                {
                mXMLFragment(); 

                }
                break;
            case 123 :
                // JS.g:1:779: DecimalLiteral
                {
                mDecimalLiteral(); 

                }
                break;
            case 124 :
                // JS.g:1:794: OctalIntegerLiteral
                {
                mOctalIntegerLiteral(); 

                }
                break;
            case 125 :
                // JS.g:1:814: HexIntegerLiteral
                {
                mHexIntegerLiteral(); 

                }
                break;
            case 126 :
                // JS.g:1:832: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 127 :
                // JS.g:1:846: RegularExpressionLiteral
                {
                mRegularExpressionLiteral(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\1\uffff\2\4\3\uffff\1\4";
    static final String DFA21_eofS =
        "\7\uffff";
    static final String DFA21_minS =
        "\3\56\3\uffff\1\56";
    static final String DFA21_maxS =
        "\1\71\1\56\1\71\3\uffff\1\71";
    static final String DFA21_acceptS =
        "\3\uffff\1\2\1\3\1\1\1\uffff";
    static final String DFA21_specialS =
        "\7\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\1\uffff\1\1\11\2",
            "\1\5",
            "\1\5\1\uffff\12\6",
            "",
            "",
            "",
            "\1\5\1\uffff\12\6"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "888:1: DecimalLiteral : ( DecimalIntegerLiteral '.' ( DecimalDigit )* ( ExponentPart )? | '.' ( DecimalDigit )+ ( ExponentPart )? | DecimalIntegerLiteral ( ExponentPart )? );";
        }
    }
 

}