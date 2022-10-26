// $ANTLR 3.0.1 JS.g 2014-04-21 18:13:32

package org.eclipse.dltk.javascript.parser.old;

import org.eclipse.dltk.javascript.parser.JavaScriptParser.JSBaseParser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

@SuppressWarnings({"cast","unused","rawtypes","unchecked","null"})
public class JSParser extends JSBaseParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NULL", "TRUE", "FALSE", "BREAK", "CASE", "CATCH", "CONTINUE", "DEFAULT", "DELETE", "DO", "ELSE", "FINALLY", "FOR", "EACH", "FUNCTION", "IF", "IN", "INSTANCEOF", "NEW", "RETURN", "SWITCH", "THIS", "THROW", "TRY", "TYPEOF", "VAR", "VOID", "WHILE", "WITH", "GET", "SET", "YIELD", "WXML", "NAMESPACE", "ABSTRACT", "BOOLEAN", "BYTE", "CHAR", "CLASS", "CONST", "DEBUGGER", "DOUBLE", "ENUM", "EXPORT", "EXTENDS", "FINAL", "FLOAT", "GOTO", "IMPLEMENTS", "IMPORT", "INT", "INTERFACE", "LONG", "NATIVE", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "SHORT", "STATIC", "SUPER", "SYNCHRONIZED", "THROWS", "TRANSIENT", "VOLATILE", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "DOT", "SEMIC", "COMMA", "LT", "GT", "LTE", "GTE", "EQ", "NEQ", "SAME", "NSAME", "ADD", "SUB", "MUL", "MOD", "INC", "DEC", "SHL", "SHR", "SHU", "AND", "OR", "XOR", "NOT", "INV", "LAND", "LOR", "QUE", "COLON", "ASSIGN", "ADDASS", "SUBASS", "MULASS", "MODASS", "SHLASS", "SHRASS", "SHUASS", "ANDASS", "ORASS", "XORASS", "DIV", "DIVASS", "AT", "DOTDOT", "COLONCOLON", "XMLFragment", "XMLFragmentEnd", "XMLFragmentError", "CALL_ARGUMENTS", "ARGUMENTS", "ARRAY", "BLOCK", "BYFIELD", "BYINDEX", "ALLCHILDREN", "LOCALNAME", "CALL", "CEXPR", "EXPR", "FORITER", "FORSTEP", "FOREACH", "GETTER", "SETTER", "DEFAULT_XML_NAMESPACE", "ITEM", "LABELLED", "NAMEDVALUE", "NEG", "OBJECT", "PAREXPR", "PDEC", "PINC", "POS", "XmlAttribute", "XML_LITERAL", "EMPTY_STATEMENT", "FUNCTION_DECLARATION", "BSLASH", "DQUOTE", "SQUOTE", "TAB", "VT", "FF", "SP", "NBSP", "USP", "UnicodeFormatCategory", "WhiteSpace", "LF", "CR", "LS", "PS", "LineTerminatorChar", "LineTerminator", "EOL", "MultiLineComment", "SingleLineComment", "StringLiteral", "HexDigit", "IdentifierStartASCII", "DecimalDigit", "IdentifierPart", "IdentifierNameASCIIStart", "Identifier", "RegularExpressionLiteral", "OctalDigit", "ExponentPart", "DecimalIntegerLiteral", "DecimalLiteral", "OctalIntegerLiteral", "HexIntegerLiteral", "CharacterEscapeSequence", "ZeroToThree", "OctalEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "EscapeSequence", "BackslashSequence", "RegularExpressionFirstChar", "RegularExpressionChar"
    };
    public static final int PACKAGE=58;
    public static final int FUNCTION=18;
    public static final int SHR=93;
    public static final int VT=157;
    public static final int RegularExpressionChar=195;
    public static final int LOCALNAME=130;
    public static final int XMLFragmentEnd=121;
    public static final int MOD=89;
    public static final int SHL=92;
    public static final int CONST=43;
    public static final int DO=13;
    public static final int DQUOTE=154;
    public static final int LineTerminatorChar=168;
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
    public static final int PROTECTED=60;
    public static final int UnicodeFormatCategory=162;
    public static final int LBRACK=73;
    public static final int LBRACE=69;
    public static final int SUB=87;
    public static final int RegularExpressionLiteral=180;
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
    public static final int SHORT=62;
    public static final int SET=34;
    public static final int INSTANCEOF=21;
    public static final int SQUOTE=155;
    public static final int SAME=84;
    public static final int COLON=103;
    public static final int StringLiteral=173;
    public static final int XMLFragment=120;
    public static final int PAREXPR=145;
    public static final int ENUM=46;
    public static final int CALL_ARGUMENTS=123;
    public static final int NBSP=160;
    public static final int HexIntegerLiteral=186;
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

        public JSParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "JS.g"; }



    private final boolean isLeftHandSideAssign(RuleReturnScope lhs, Object[] cached)
    {
    	if (cached[0] != null)
    	{
    		return ((Boolean)cached[0]).booleanValue();
    	}
    	
    	boolean result;
    	if (isLeftHandSideExpression(lhs))
    	{
    		switch (input.LA(1))
    		{
    			case ASSIGN:
    			case MULASS:
    			case DIVASS:
    			case MODASS:
    			case ADDASS:
    			case SUBASS:
    			case SHLASS:
    			case SHRASS:
    			case SHUASS:
    			case ANDASS:
    			case XORASS:
    			case ORASS:
    				result = true;
    				break;
    			default:
    				result = false;
    				break;
    		}
    	}
    	else
    	{
    		result = false;
    	}
    	
    	cached[0] = Boolean.valueOf(result);
    	return result;
    }

    private final static boolean isLeftHandSideExpression(RuleReturnScope lhs)
    {
    	if (lhs.getTree() == null) // e.g. during backtracking
    	{
    		return true;
    	}
    	else
    	{
      		if (JSLexer.isIdentifierKeyword(((Tree)lhs.getTree()).getType())) {
    			return true;
    		}
    		switch (((Tree)lhs.getTree()).getType())
    		{
    		// primaryExpression
    			case THIS:
    			case Identifier:
    			case XmlAttribute:
    			case NULL:
    			case TRUE:
    			case FALSE:
    			case DecimalLiteral:
    			case OctalIntegerLiteral:
    			case HexIntegerLiteral:
    			case StringLiteral:
    			case RegularExpressionLiteral:
    			case XMLFragment:
    			case XMLFragmentEnd:
    			case ARRAY:
    			case OBJECT:
    			case PAREXPR:
    		// functionExpression
    			case FUNCTION:
    		// newExpression
    			case NEW:
    		// leftHandSideExpression
    			case CALL:
    			case BYFIELD:
    			case BYINDEX:
    				return true;
    			
    			default:
    				return false;
    		}
    	}
    }
    	
    private final boolean isLeftHandSideIn(RuleReturnScope lhs, Object[] cached)
    {
    	if (cached[0] != null)
    	{
    		return ((Boolean)cached[0]).booleanValue();
    	}
    	
    	boolean result = isLeftHandSideExpression(lhs) && (input.LA(1) == IN);
    	cached[0] = new Boolean(result);
    	return result;
    }

    private final void promoteEOL(ParserRuleReturnScope rule)
    {
    	// Get current token and its type (the possibly offending token).
    	Token lt = input.LT(1);
    	int la = lt.getType();
    	
    	// We only need to promote an EOL when the current token is offending (not a SEMIC, EOF, RBRACE, EOL or MultiLineComment).
    	// EOL and MultiLineComment are not offending as they're already promoted in a previous call to this method.
    	// Promoting an EOL means switching it from off channel to on channel.
    	// A MultiLineComment gets promoted when it contains an EOL.
    	if (!(la == SEMIC || la == EOF || la == RBRACE || la == EOL || la == MultiLineComment))
    	{
    		// Start on the possition before the current token and scan backwards off channel tokens until the previous on channel token.
    		for (int ix = lt.getTokenIndex() - 1; ix > 0; ix--)
    		{
    			lt = input.get(ix);
    			if (lt.getChannel() == Token.DEFAULT_CHANNEL)
    			{
    				// On channel token found: stop scanning.
    				break;
    			}
    			else if (lt.getType() == EOL || (lt.getType() == MultiLineComment && lt.getText().matches("/.*\r\n|\r|\n")))
    			{
    				// We found our EOL: promote the token to on channel, position the input on it and reset the rule start.
    				lt.setChannel(Token.DEFAULT_CHANNEL);
    				input.seek(lt.getTokenIndex());
    				if (rule != null)
    				{
    					rule.start = lt;
    				}
    				break;
    			}
    		}
    	}
    }	


    public static class token_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start token
    // JS.g:599:1: token : ( reservedWord | identifier | XMLFragment | XMLFragmentEnd | punctuator | NULL | booleanLiteral | numericLiteral | StringLiteral | xmlAttribute );
    public final token_return token() throws RecognitionException {
        token_return retval = new token_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token XMLFragment3=null;
        Token XMLFragmentEnd4=null;
        Token NULL6=null;
        Token StringLiteral9=null;
        reservedWord_return reservedWord1 = null;

        identifier_return identifier2 = null;

        punctuator_return punctuator5 = null;

        booleanLiteral_return booleanLiteral7 = null;

        numericLiteral_return numericLiteral8 = null;

        xmlAttribute_return xmlAttribute10 = null;


        Object XMLFragment3_tree=null;
        Object XMLFragmentEnd4_tree=null;
        Object NULL6_tree=null;
        Object StringLiteral9_tree=null;

        try {
            // JS.g:600:2: ( reservedWord | identifier | XMLFragment | XMLFragmentEnd | punctuator | NULL | booleanLiteral | numericLiteral | StringLiteral | xmlAttribute )
            int alt1=10;
            switch ( input.LA(1) ) {
            case WXML:
                {
                alt1=1;
                }
                break;
            case GET:
                {
                alt1=1;
                }
                break;
            case SET:
                {
                alt1=1;
                }
                break;
            case EACH:
                {
                alt1=1;
                }
                break;
            case BREAK:
            case CASE:
            case CATCH:
            case CONTINUE:
            case DEFAULT:
            case DELETE:
            case DO:
            case ELSE:
            case FINALLY:
            case FOR:
            case FUNCTION:
            case IF:
            case IN:
            case INSTANCEOF:
            case NEW:
            case RETURN:
            case SWITCH:
            case THIS:
            case THROW:
            case TRY:
            case TYPEOF:
            case VAR:
            case VOID:
            case WHILE:
            case WITH:
            case YIELD:
            case NAMESPACE:
                {
                alt1=1;
                }
                break;
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case DEBUGGER:
            case DOUBLE:
            case ENUM:
            case EXPORT:
            case EXTENDS:
            case FINAL:
            case FLOAT:
            case GOTO:
            case IMPLEMENTS:
            case IMPORT:
            case INT:
            case INTERFACE:
            case LONG:
            case NATIVE:
            case PACKAGE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case SHORT:
            case STATIC:
            case SUPER:
            case SYNCHRONIZED:
            case THROWS:
            case TRANSIENT:
            case VOLATILE:
            case Identifier:
                {
                alt1=2;
                }
                break;
            case XMLFragment:
                {
                alt1=3;
                }
                break;
            case XMLFragmentEnd:
                {
                alt1=4;
                }
                break;
            case LBRACE:
            case RBRACE:
            case LPAREN:
            case RPAREN:
            case LBRACK:
            case RBRACK:
            case DOT:
            case SEMIC:
            case COMMA:
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
            case COLON:
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
            case DOTDOT:
            case COLONCOLON:
                {
                alt1=5;
                }
                break;
            case NULL:
                {
                alt1=6;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt1=7;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt1=8;
                }
                break;
            case StringLiteral:
                {
                alt1=9;
                }
                break;
            case AT:
                {
                alt1=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("599:1: token : ( reservedWord | identifier | XMLFragment | XMLFragmentEnd | punctuator | NULL | booleanLiteral | numericLiteral | StringLiteral | xmlAttribute );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // JS.g:600:4: reservedWord
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_reservedWord_in_token1981);
                    reservedWord1=reservedWord();
                    _fsp--;

                    adaptor.addChild(root_0, reservedWord1.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:601:4: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_token1986);
                    identifier2=identifier();
                    _fsp--;

                    adaptor.addChild(root_0, identifier2.getTree());

                    }
                    break;
                case 3 :
                    // JS.g:602:4: XMLFragment
                    {
                    root_0 = (Object)adaptor.nil();

                    XMLFragment3=(Token)input.LT(1);
                    match(input,XMLFragment,FOLLOW_XMLFragment_in_token1991); 
                    XMLFragment3_tree = (Object)adaptor.create(XMLFragment3);
                    adaptor.addChild(root_0, XMLFragment3_tree);


                    }
                    break;
                case 4 :
                    // JS.g:603:4: XMLFragmentEnd
                    {
                    root_0 = (Object)adaptor.nil();

                    XMLFragmentEnd4=(Token)input.LT(1);
                    match(input,XMLFragmentEnd,FOLLOW_XMLFragmentEnd_in_token1996); 
                    XMLFragmentEnd4_tree = (Object)adaptor.create(XMLFragmentEnd4);
                    adaptor.addChild(root_0, XMLFragmentEnd4_tree);


                    }
                    break;
                case 5 :
                    // JS.g:604:4: punctuator
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_punctuator_in_token2001);
                    punctuator5=punctuator();
                    _fsp--;

                    adaptor.addChild(root_0, punctuator5.getTree());

                    }
                    break;
                case 6 :
                    // JS.g:605:4: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL6=(Token)input.LT(1);
                    match(input,NULL,FOLLOW_NULL_in_token2006); 
                    NULL6_tree = (Object)adaptor.create(NULL6);
                    adaptor.addChild(root_0, NULL6_tree);


                    }
                    break;
                case 7 :
                    // JS.g:606:4: booleanLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_booleanLiteral_in_token2011);
                    booleanLiteral7=booleanLiteral();
                    _fsp--;

                    adaptor.addChild(root_0, booleanLiteral7.getTree());

                    }
                    break;
                case 8 :
                    // JS.g:607:4: numericLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numericLiteral_in_token2016);
                    numericLiteral8=numericLiteral();
                    _fsp--;

                    adaptor.addChild(root_0, numericLiteral8.getTree());

                    }
                    break;
                case 9 :
                    // JS.g:608:4: StringLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    StringLiteral9=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_token2021); 
                    StringLiteral9_tree = (Object)adaptor.create(StringLiteral9);
                    adaptor.addChild(root_0, StringLiteral9_tree);


                    }
                    break;
                case 10 :
                    // JS.g:609:4: xmlAttribute
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_xmlAttribute_in_token2026);
                    xmlAttribute10=xmlAttribute();
                    _fsp--;

                    adaptor.addChild(root_0, xmlAttribute10.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end token

    public static class reservedWord_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start reservedWord
    // JS.g:614:1: reservedWord : keyword ;
    public final reservedWord_return reservedWord() throws RecognitionException {
        reservedWord_return retval = new reservedWord_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        keyword_return keyword11 = null;



        try {
            // JS.g:615:2: ( keyword )
            // JS.g:615:4: keyword
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_keyword_in_reservedWord2039);
            keyword11=keyword();
            _fsp--;

            adaptor.addChild(root_0, keyword11.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end reservedWord

    public static class keyword_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start keyword
    // JS.g:622:1: keyword : ( BREAK | CASE | CATCH | CONTINUE | DEFAULT | DELETE | DO | ELSE | FINALLY | FOR | EACH | FUNCTION | GET | SET | IF | IN | INSTANCEOF | NEW | RETURN | SWITCH | THIS | THROW | TRY | TYPEOF | VAR | VOID | WHILE | WITH | NAMESPACE | WXML | YIELD );
    public final keyword_return keyword() throws RecognitionException {
        keyword_return retval = new keyword_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set12=null;

        Object set12_tree=null;

        try {
            // JS.g:623:2: ( BREAK | CASE | CATCH | CONTINUE | DEFAULT | DELETE | DO | ELSE | FINALLY | FOR | EACH | FUNCTION | GET | SET | IF | IN | INSTANCEOF | NEW | RETURN | SWITCH | THIS | THROW | TRY | TYPEOF | VAR | VOID | WHILE | WITH | NAMESPACE | WXML | YIELD )
            // JS.g:
            {
            root_0 = (Object)adaptor.nil();

            set12=(Token)input.LT(1);
            if ( (input.LA(1)>=BREAK && input.LA(1)<=NAMESPACE) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set12));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_keyword0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end keyword

    public static class futureReservedWord_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start futureReservedWord
    // JS.g:660:1: futureReservedWord : ( ABSTRACT | BOOLEAN | BYTE | CHAR | CLASS | DEBUGGER | DOUBLE | ENUM | EXPORT | EXTENDS | FINAL | FLOAT | GOTO | IMPLEMENTS | IMPORT | INT | INTERFACE | LONG | NATIVE | PACKAGE | PRIVATE | PROTECTED | PUBLIC | SHORT | STATIC | SUPER | SYNCHRONIZED | THROWS | TRANSIENT | VOLATILE );
    public final futureReservedWord_return futureReservedWord() throws RecognitionException {
        futureReservedWord_return retval = new futureReservedWord_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set13=null;

        Object set13_tree=null;

        try {
            // JS.g:661:2: ( ABSTRACT | BOOLEAN | BYTE | CHAR | CLASS | DEBUGGER | DOUBLE | ENUM | EXPORT | EXTENDS | FINAL | FLOAT | GOTO | IMPLEMENTS | IMPORT | INT | INTERFACE | LONG | NATIVE | PACKAGE | PRIVATE | PROTECTED | PUBLIC | SHORT | STATIC | SUPER | SYNCHRONIZED | THROWS | TRANSIENT | VOLATILE )
            // JS.g:
            {
            root_0 = (Object)adaptor.nil();

            set13=(Token)input.LT(1);
            if ( (input.LA(1)>=ABSTRACT && input.LA(1)<=CLASS)||(input.LA(1)>=DEBUGGER && input.LA(1)<=VOLATILE) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set13));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_futureReservedWord0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end futureReservedWord

    public static class identifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start identifier
    // JS.g:733:1: identifier : ( WXML | GET | SET | EACH | NAMESPACE | word= futureReservedWord -> Identifier[word.start] | Identifier );
    public final identifier_return identifier() throws RecognitionException {
        identifier_return retval = new identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WXML14=null;
        Token GET15=null;
        Token SET16=null;
        Token EACH17=null;
        Token NAMESPACE18=null;
        Token Identifier19=null;
        futureReservedWord_return word = null;


        Object WXML14_tree=null;
        Object GET15_tree=null;
        Object SET16_tree=null;
        Object EACH17_tree=null;
        Object NAMESPACE18_tree=null;
        Object Identifier19_tree=null;
        RewriteRuleSubtreeStream stream_futureReservedWord=new RewriteRuleSubtreeStream(adaptor,"rule futureReservedWord");
        try {
            // JS.g:734:3: ( WXML | GET | SET | EACH | NAMESPACE | word= futureReservedWord -> Identifier[word.start] | Identifier )
            int alt2=7;
            switch ( input.LA(1) ) {
            case WXML:
                {
                alt2=1;
                }
                break;
            case GET:
                {
                alt2=2;
                }
                break;
            case SET:
                {
                alt2=3;
                }
                break;
            case EACH:
                {
                alt2=4;
                }
                break;
            case NAMESPACE:
                {
                alt2=5;
                }
                break;
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case DEBUGGER:
            case DOUBLE:
            case ENUM:
            case EXPORT:
            case EXTENDS:
            case FINAL:
            case FLOAT:
            case GOTO:
            case IMPLEMENTS:
            case IMPORT:
            case INT:
            case INTERFACE:
            case LONG:
            case NATIVE:
            case PACKAGE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case SHORT:
            case STATIC:
            case SUPER:
            case SYNCHRONIZED:
            case THROWS:
            case TRANSIENT:
            case VOLATILE:
                {
                alt2=6;
                }
                break;
            case Identifier:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("733:1: identifier : ( WXML | GET | SET | EACH | NAMESPACE | word= futureReservedWord -> Identifier[word.start] | Identifier );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // JS.g:734:5: WXML
                    {
                    root_0 = (Object)adaptor.nil();

                    WXML14=(Token)input.LT(1);
                    match(input,WXML,FOLLOW_WXML_in_identifier2493); 
                    WXML14_tree = (Object)adaptor.create(WXML14);
                    adaptor.addChild(root_0, WXML14_tree);


                    }
                    break;
                case 2 :
                    // JS.g:735:5: GET
                    {
                    root_0 = (Object)adaptor.nil();

                    GET15=(Token)input.LT(1);
                    match(input,GET,FOLLOW_GET_in_identifier2499); 
                    GET15_tree = (Object)adaptor.create(GET15);
                    adaptor.addChild(root_0, GET15_tree);


                    }
                    break;
                case 3 :
                    // JS.g:736:5: SET
                    {
                    root_0 = (Object)adaptor.nil();

                    SET16=(Token)input.LT(1);
                    match(input,SET,FOLLOW_SET_in_identifier2505); 
                    SET16_tree = (Object)adaptor.create(SET16);
                    adaptor.addChild(root_0, SET16_tree);


                    }
                    break;
                case 4 :
                    // JS.g:737:5: EACH
                    {
                    root_0 = (Object)adaptor.nil();

                    EACH17=(Token)input.LT(1);
                    match(input,EACH,FOLLOW_EACH_in_identifier2511); 
                    EACH17_tree = (Object)adaptor.create(EACH17);
                    adaptor.addChild(root_0, EACH17_tree);


                    }
                    break;
                case 5 :
                    // JS.g:738:5: NAMESPACE
                    {
                    root_0 = (Object)adaptor.nil();

                    NAMESPACE18=(Token)input.LT(1);
                    match(input,NAMESPACE,FOLLOW_NAMESPACE_in_identifier2517); 
                    NAMESPACE18_tree = (Object)adaptor.create(NAMESPACE18);
                    adaptor.addChild(root_0, NAMESPACE18_tree);


                    }
                    break;
                case 6 :
                    // JS.g:739:5: word= futureReservedWord
                    {
                    pushFollow(FOLLOW_futureReservedWord_in_identifier2525);
                    word=futureReservedWord();
                    _fsp--;

                    stream_futureReservedWord.add(word.getTree());
                     reportReservedKeyword(word.start); 

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 739:68: -> Identifier[word.start]
                    {
                        adaptor.addChild(root_0, adaptor.create(Identifier, word.start));

                    }



                    }
                    break;
                case 7 :
                    // JS.g:740:5: Identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    Identifier19=(Token)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_identifier2538); 
                    Identifier19_tree = (Object)adaptor.create(Identifier19);
                    adaptor.addChild(root_0, Identifier19_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end identifier

    public static class xmlAttribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start xmlAttribute
    // JS.g:743:1: xmlAttribute : ( AT identifier -> ^( XmlAttribute AT identifier ) | AT MUL -> ^( XmlAttribute AT MUL ) | AT LBRACK expression RBRACK -> ^( XmlAttribute LBRACK expression ) );
    public final xmlAttribute_return xmlAttribute() throws RecognitionException {
        xmlAttribute_return retval = new xmlAttribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AT20=null;
        Token AT22=null;
        Token MUL23=null;
        Token AT24=null;
        Token LBRACK25=null;
        Token RBRACK27=null;
        identifier_return identifier21 = null;

        expression_return expression26 = null;


        Object AT20_tree=null;
        Object AT22_tree=null;
        Object MUL23_tree=null;
        Object AT24_tree=null;
        Object LBRACK25_tree=null;
        Object RBRACK27_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_MUL=new RewriteRuleTokenStream(adaptor,"token MUL");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // JS.g:744:3: ( AT identifier -> ^( XmlAttribute AT identifier ) | AT MUL -> ^( XmlAttribute AT MUL ) | AT LBRACK expression RBRACK -> ^( XmlAttribute LBRACK expression ) )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==AT) ) {
                switch ( input.LA(2) ) {
                case MUL:
                    {
                    alt3=2;
                    }
                    break;
                case LBRACK:
                    {
                    alt3=3;
                    }
                    break;
                case EACH:
                case GET:
                case SET:
                case WXML:
                case NAMESPACE:
                case ABSTRACT:
                case BOOLEAN:
                case BYTE:
                case CHAR:
                case CLASS:
                case DEBUGGER:
                case DOUBLE:
                case ENUM:
                case EXPORT:
                case EXTENDS:
                case FINAL:
                case FLOAT:
                case GOTO:
                case IMPLEMENTS:
                case IMPORT:
                case INT:
                case INTERFACE:
                case LONG:
                case NATIVE:
                case PACKAGE:
                case PRIVATE:
                case PROTECTED:
                case PUBLIC:
                case SHORT:
                case STATIC:
                case SUPER:
                case SYNCHRONIZED:
                case THROWS:
                case TRANSIENT:
                case VOLATILE:
                case Identifier:
                    {
                    alt3=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("743:1: xmlAttribute : ( AT identifier -> ^( XmlAttribute AT identifier ) | AT MUL -> ^( XmlAttribute AT MUL ) | AT LBRACK expression RBRACK -> ^( XmlAttribute LBRACK expression ) );", 3, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("743:1: xmlAttribute : ( AT identifier -> ^( XmlAttribute AT identifier ) | AT MUL -> ^( XmlAttribute AT MUL ) | AT LBRACK expression RBRACK -> ^( XmlAttribute LBRACK expression ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // JS.g:744:5: AT identifier
                    {
                    AT20=(Token)input.LT(1);
                    match(input,AT,FOLLOW_AT_in_xmlAttribute2549); 
                    stream_AT.add(AT20);

                    pushFollow(FOLLOW_identifier_in_xmlAttribute2551);
                    identifier21=identifier();
                    _fsp--;

                    stream_identifier.add(identifier21.getTree());

                    // AST REWRITE
                    // elements: identifier, AT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 744:19: -> ^( XmlAttribute AT identifier )
                    {
                        // JS.g:744:22: ^( XmlAttribute AT identifier )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(XmlAttribute, "XmlAttribute"), root_1);

                        adaptor.addChild(root_1, stream_AT.next());
                        adaptor.addChild(root_1, stream_identifier.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 2 :
                    // JS.g:745:5: AT MUL
                    {
                    AT22=(Token)input.LT(1);
                    match(input,AT,FOLLOW_AT_in_xmlAttribute2567); 
                    stream_AT.add(AT22);

                    MUL23=(Token)input.LT(1);
                    match(input,MUL,FOLLOW_MUL_in_xmlAttribute2569); 
                    stream_MUL.add(MUL23);


                    // AST REWRITE
                    // elements: AT, MUL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 745:12: -> ^( XmlAttribute AT MUL )
                    {
                        // JS.g:745:15: ^( XmlAttribute AT MUL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(XmlAttribute, "XmlAttribute"), root_1);

                        adaptor.addChild(root_1, stream_AT.next());
                        adaptor.addChild(root_1, stream_MUL.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 3 :
                    // JS.g:746:5: AT LBRACK expression RBRACK
                    {
                    AT24=(Token)input.LT(1);
                    match(input,AT,FOLLOW_AT_in_xmlAttribute2585); 
                    stream_AT.add(AT24);

                    LBRACK25=(Token)input.LT(1);
                    match(input,LBRACK,FOLLOW_LBRACK_in_xmlAttribute2587); 
                    stream_LBRACK.add(LBRACK25);

                    pushFollow(FOLLOW_expression_in_xmlAttribute2589);
                    expression26=expression();
                    _fsp--;

                    stream_expression.add(expression26.getTree());
                    RBRACK27=(Token)input.LT(1);
                    match(input,RBRACK,FOLLOW_RBRACK_in_xmlAttribute2591); 
                    stream_RBRACK.add(RBRACK27);


                    // AST REWRITE
                    // elements: expression, LBRACK
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 746:33: -> ^( XmlAttribute LBRACK expression )
                    {
                        // JS.g:746:36: ^( XmlAttribute LBRACK expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(XmlAttribute, "XmlAttribute"), root_1);

                        adaptor.addChild(root_1, stream_LBRACK.next());
                        adaptor.addChild(root_1, stream_expression.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end xmlAttribute

    public static class propertySelector_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start propertySelector
    // JS.g:749:1: propertySelector : ( identifier | MUL );
    public final propertySelector_return propertySelector() throws RecognitionException {
        propertySelector_return retval = new propertySelector_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token MUL29=null;
        identifier_return identifier28 = null;


        Object MUL29_tree=null;

        try {
            // JS.g:750:2: ( identifier | MUL )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==EACH||(LA4_0>=GET && LA4_0<=SET)||(LA4_0>=WXML && LA4_0<=CLASS)||(LA4_0>=DEBUGGER && LA4_0<=VOLATILE)||LA4_0==Identifier) ) {
                alt4=1;
            }
            else if ( (LA4_0==MUL) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("749:1: propertySelector : ( identifier | MUL );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // JS.g:750:4: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_propertySelector2613);
                    identifier28=identifier();
                    _fsp--;

                    adaptor.addChild(root_0, identifier28.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:751:4: MUL
                    {
                    root_0 = (Object)adaptor.nil();

                    MUL29=(Token)input.LT(1);
                    match(input,MUL,FOLLOW_MUL_in_propertySelector2618); 
                    MUL29_tree = (Object)adaptor.create(MUL29);
                    adaptor.addChild(root_0, MUL29_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end propertySelector

    public static class punctuator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start punctuator
    // JS.g:758:1: punctuator : ( LBRACE | RBRACE | LPAREN | RPAREN | LBRACK | RBRACK | DOT | SEMIC | COMMA | LT | GT | LTE | GTE | EQ | NEQ | SAME | NSAME | ADD | SUB | MUL | MOD | INC | DEC | SHL | SHR | SHU | AND | OR | XOR | NOT | INV | LAND | LOR | QUE | COLON | ASSIGN | ADDASS | SUBASS | MULASS | MODASS | SHLASS | SHRASS | SHUASS | ANDASS | ORASS | XORASS | DIV | DIVASS | DOTDOT | COLONCOLON );
    public final punctuator_return punctuator() throws RecognitionException {
        punctuator_return retval = new punctuator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set30=null;

        Object set30_tree=null;

        try {
            // JS.g:759:2: ( LBRACE | RBRACE | LPAREN | RPAREN | LBRACK | RBRACK | DOT | SEMIC | COMMA | LT | GT | LTE | GTE | EQ | NEQ | SAME | NSAME | ADD | SUB | MUL | MOD | INC | DEC | SHL | SHR | SHU | AND | OR | XOR | NOT | INV | LAND | LOR | QUE | COLON | ASSIGN | ADDASS | SUBASS | MULASS | MODASS | SHLASS | SHRASS | SHUASS | ANDASS | ORASS | XORASS | DIV | DIVASS | DOTDOT | COLONCOLON )
            // JS.g:
            {
            root_0 = (Object)adaptor.nil();

            set30=(Token)input.LT(1);
            if ( (input.LA(1)>=LBRACE && input.LA(1)<=DIVASS)||(input.LA(1)>=DOTDOT && input.LA(1)<=COLONCOLON) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set30));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_punctuator0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end punctuator

    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literal
    // JS.g:815:1: literal : ( NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral | {...}? => xmlLiteral );
    public final literal_return literal() throws RecognitionException {
        literal_return retval = new literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NULL31=null;
        Token StringLiteral34=null;
        Token RegularExpressionLiteral35=null;
        booleanLiteral_return booleanLiteral32 = null;

        numericLiteral_return numericLiteral33 = null;

        xmlLiteral_return xmlLiteral36 = null;


        Object NULL31_tree=null;
        Object StringLiteral34_tree=null;
        Object RegularExpressionLiteral35_tree=null;

        try {
            // JS.g:816:2: ( NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral | {...}? => xmlLiteral )
            int alt5=6;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NULL) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=TRUE && LA5_0<=FALSE)) ) {
                alt5=2;
            }
            else if ( ((LA5_0>=DecimalLiteral && LA5_0<=HexIntegerLiteral)) ) {
                alt5=3;
            }
            else if ( (LA5_0==StringLiteral) ) {
                alt5=4;
            }
            else if ( (LA5_0==RegularExpressionLiteral) ) {
                alt5=5;
            }
            else if ( ((LA5_0>=XMLFragment && LA5_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt5=6;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("815:1: literal : ( NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral | {...}? => xmlLiteral );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // JS.g:816:4: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL31=(Token)input.LT(1);
                    match(input,NULL,FOLLOW_NULL_in_literal2893); 
                    NULL31_tree = (Object)adaptor.create(NULL31);
                    adaptor.addChild(root_0, NULL31_tree);


                    }
                    break;
                case 2 :
                    // JS.g:817:4: booleanLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_booleanLiteral_in_literal2898);
                    booleanLiteral32=booleanLiteral();
                    _fsp--;

                    adaptor.addChild(root_0, booleanLiteral32.getTree());

                    }
                    break;
                case 3 :
                    // JS.g:818:4: numericLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numericLiteral_in_literal2903);
                    numericLiteral33=numericLiteral();
                    _fsp--;

                    adaptor.addChild(root_0, numericLiteral33.getTree());

                    }
                    break;
                case 4 :
                    // JS.g:819:4: StringLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    StringLiteral34=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_literal2908); 
                    StringLiteral34_tree = (Object)adaptor.create(StringLiteral34);
                    adaptor.addChild(root_0, StringLiteral34_tree);


                    }
                    break;
                case 5 :
                    // JS.g:820:4: RegularExpressionLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    RegularExpressionLiteral35=(Token)input.LT(1);
                    match(input,RegularExpressionLiteral,FOLLOW_RegularExpressionLiteral_in_literal2913); 
                    RegularExpressionLiteral35_tree = (Object)adaptor.create(RegularExpressionLiteral35);
                    adaptor.addChild(root_0, RegularExpressionLiteral35_tree);


                    }
                    break;
                case 6 :
                    // JS.g:821:4: {...}? => xmlLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !( isXmlEnabled() ) ) {
                        throw new FailedPredicateException(input, "literal", " isXmlEnabled() ");
                    }
                    pushFollow(FOLLOW_xmlLiteral_in_literal2921);
                    xmlLiteral36=xmlLiteral();
                    _fsp--;

                    adaptor.addChild(root_0, xmlLiteral36.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end literal

    public static class xmlLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start xmlLiteral
    // JS.g:824:1: xmlLiteral : ( XMLFragment LBRACE expression RBRACE )* XMLFragmentEnd -> ^( XML_LITERAL ( XMLFragment )* ( expression )* XMLFragmentEnd ) ;
    public final xmlLiteral_return xmlLiteral() throws RecognitionException {
        xmlLiteral_return retval = new xmlLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token XMLFragment37=null;
        Token LBRACE38=null;
        Token RBRACE40=null;
        Token XMLFragmentEnd41=null;
        expression_return expression39 = null;


        Object XMLFragment37_tree=null;
        Object LBRACE38_tree=null;
        Object RBRACE40_tree=null;
        Object XMLFragmentEnd41_tree=null;
        RewriteRuleTokenStream stream_XMLFragment=new RewriteRuleTokenStream(adaptor,"token XMLFragment");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_XMLFragmentEnd=new RewriteRuleTokenStream(adaptor,"token XMLFragmentEnd");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // JS.g:825:2: ( ( XMLFragment LBRACE expression RBRACE )* XMLFragmentEnd -> ^( XML_LITERAL ( XMLFragment )* ( expression )* XMLFragmentEnd ) )
            // JS.g:825:4: ( XMLFragment LBRACE expression RBRACE )* XMLFragmentEnd
            {
            // JS.g:825:4: ( XMLFragment LBRACE expression RBRACE )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==XMLFragment) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // JS.g:826:6: XMLFragment LBRACE expression RBRACE
            	    {
            	    XMLFragment37=(Token)input.LT(1);
            	    match(input,XMLFragment,FOLLOW_XMLFragment_in_xmlLiteral2939); 
            	    stream_XMLFragment.add(XMLFragment37);

            	     ((JSTokenStream)input).setMode(JSTokenSource.MODE_EXPRESSION); 
            	    LBRACE38=(Token)input.LT(1);
            	    match(input,LBRACE,FOLLOW_LBRACE_in_xmlLiteral2956); 
            	    stream_LBRACE.add(LBRACE38);

            	    pushFollow(FOLLOW_expression_in_xmlLiteral2958);
            	    expression39=expression();
            	    _fsp--;

            	    stream_expression.add(expression39.getTree());
            	    RBRACE40=(Token)input.LT(1);
            	    match(input,RBRACE,FOLLOW_RBRACE_in_xmlLiteral2960); 
            	    stream_RBRACE.add(RBRACE40);

            	     ((JSTokenStream)input).setMode(JSTokenSource.MODE_XML); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            XMLFragmentEnd41=(Token)input.LT(1);
            match(input,XMLFragmentEnd,FOLLOW_XMLFragmentEnd_in_xmlLiteral2976); 
            stream_XMLFragmentEnd.add(XMLFragmentEnd41);


            // AST REWRITE
            // elements: XMLFragment, XMLFragmentEnd, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 831:4: -> ^( XML_LITERAL ( XMLFragment )* ( expression )* XMLFragmentEnd )
            {
                // JS.g:831:7: ^( XML_LITERAL ( XMLFragment )* ( expression )* XMLFragmentEnd )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(XML_LITERAL, "XML_LITERAL"), root_1);

                // JS.g:831:21: ( XMLFragment )*
                while ( stream_XMLFragment.hasNext() ) {
                    adaptor.addChild(root_1, stream_XMLFragment.next());

                }
                stream_XMLFragment.reset();
                // JS.g:831:34: ( expression )*
                while ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.next());

                }
                stream_expression.reset();
                adaptor.addChild(root_1, stream_XMLFragmentEnd.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
             ((JSTokenStream)input).setMode(JSTokenSource.MODE_JS); 
        }
        return retval;
    }
    // $ANTLR end xmlLiteral

    public static class booleanLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start booleanLiteral
    // JS.g:855:1: booleanLiteral : ( TRUE | FALSE );
    public final booleanLiteral_return booleanLiteral() throws RecognitionException {
        booleanLiteral_return retval = new booleanLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set42=null;

        Object set42_tree=null;

        try {
            // JS.g:856:2: ( TRUE | FALSE )
            // JS.g:
            {
            root_0 = (Object)adaptor.nil();

            set42=(Token)input.LT(1);
            if ( (input.LA(1)>=TRUE && input.LA(1)<=FALSE) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set42));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_booleanLiteral0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end booleanLiteral

    public static class numericLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start numericLiteral
    // JS.g:902:1: numericLiteral : ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral );
    public final numericLiteral_return numericLiteral() throws RecognitionException {
        numericLiteral_return retval = new numericLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set43=null;

        Object set43_tree=null;

        try {
            // JS.g:903:2: ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral )
            // JS.g:
            {
            root_0 = (Object)adaptor.nil();

            set43=(Token)input.LT(1);
            if ( (input.LA(1)>=DecimalLiteral && input.LA(1)<=HexIntegerLiteral) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set43));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_numericLiteral0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end numericLiteral

    public static class primaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primaryExpression
    // JS.g:992:1: primaryExpression : ( THIS | identifier | xmlAttribute | literal | arrayLiteral | objectLiteral | parenExpression );
    public final primaryExpression_return primaryExpression() throws RecognitionException {
        primaryExpression_return retval = new primaryExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token THIS44=null;
        identifier_return identifier45 = null;

        xmlAttribute_return xmlAttribute46 = null;

        literal_return literal47 = null;

        arrayLiteral_return arrayLiteral48 = null;

        objectLiteral_return objectLiteral49 = null;

        parenExpression_return parenExpression50 = null;


        Object THIS44_tree=null;

        try {
            // JS.g:993:2: ( THIS | identifier | xmlAttribute | literal | arrayLiteral | objectLiteral | parenExpression )
            int alt7=7;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==THIS) ) {
                alt7=1;
            }
            else if ( (LA7_0==EACH||(LA7_0>=GET && LA7_0<=SET)||(LA7_0>=WXML && LA7_0<=CLASS)||(LA7_0>=DEBUGGER && LA7_0<=VOLATILE)||LA7_0==Identifier) ) {
                alt7=2;
            }
            else if ( (LA7_0==AT) ) {
                alt7=3;
            }
            else if ( ((LA7_0>=NULL && LA7_0<=FALSE)||LA7_0==StringLiteral||LA7_0==RegularExpressionLiteral||(LA7_0>=DecimalLiteral && LA7_0<=HexIntegerLiteral)) ) {
                alt7=4;
            }
            else if ( ((LA7_0>=XMLFragment && LA7_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt7=4;
            }
            else if ( (LA7_0==LBRACK) ) {
                alt7=5;
            }
            else if ( (LA7_0==LBRACE) ) {
                alt7=6;
            }
            else if ( (LA7_0==LPAREN) ) {
                alt7=7;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("992:1: primaryExpression : ( THIS | identifier | xmlAttribute | literal | arrayLiteral | objectLiteral | parenExpression );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // JS.g:993:4: THIS
                    {
                    root_0 = (Object)adaptor.nil();

                    THIS44=(Token)input.LT(1);
                    match(input,THIS,FOLLOW_THIS_in_primaryExpression3766); 
                    THIS44_tree = (Object)adaptor.create(THIS44);
                    adaptor.addChild(root_0, THIS44_tree);


                    }
                    break;
                case 2 :
                    // JS.g:994:4: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_primaryExpression3771);
                    identifier45=identifier();
                    _fsp--;

                    adaptor.addChild(root_0, identifier45.getTree());

                    }
                    break;
                case 3 :
                    // JS.g:995:4: xmlAttribute
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_xmlAttribute_in_primaryExpression3776);
                    xmlAttribute46=xmlAttribute();
                    _fsp--;

                    adaptor.addChild(root_0, xmlAttribute46.getTree());

                    }
                    break;
                case 4 :
                    // JS.g:996:4: literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primaryExpression3781);
                    literal47=literal();
                    _fsp--;

                    adaptor.addChild(root_0, literal47.getTree());

                    }
                    break;
                case 5 :
                    // JS.g:997:4: arrayLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_arrayLiteral_in_primaryExpression3786);
                    arrayLiteral48=arrayLiteral();
                    _fsp--;

                    adaptor.addChild(root_0, arrayLiteral48.getTree());

                    }
                    break;
                case 6 :
                    // JS.g:998:4: objectLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_objectLiteral_in_primaryExpression3791);
                    objectLiteral49=objectLiteral();
                    _fsp--;

                    adaptor.addChild(root_0, objectLiteral49.getTree());

                    }
                    break;
                case 7 :
                    // JS.g:999:4: parenExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_parenExpression_in_primaryExpression3796);
                    parenExpression50=parenExpression();
                    _fsp--;

                    adaptor.addChild(root_0, parenExpression50.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end primaryExpression

    public static class parenExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start parenExpression
    // JS.g:1002:1: parenExpression : lpar= LPAREN expression RPAREN -> ^( PAREXPR[$lpar, \"PAREXPR\"] expression RPAREN ) ;
    public final parenExpression_return parenExpression() throws RecognitionException {
        parenExpression_return retval = new parenExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lpar=null;
        Token RPAREN52=null;
        expression_return expression51 = null;


        Object lpar_tree=null;
        Object RPAREN52_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // JS.g:1003:3: (lpar= LPAREN expression RPAREN -> ^( PAREXPR[$lpar, \"PAREXPR\"] expression RPAREN ) )
            // JS.g:1003:5: lpar= LPAREN expression RPAREN
            {
            lpar=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_parenExpression3812); 
            stream_LPAREN.add(lpar);

            pushFollow(FOLLOW_expression_in_parenExpression3814);
            expression51=expression();
            _fsp--;

            stream_expression.add(expression51.getTree());
            RPAREN52=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_parenExpression3816); 
            stream_RPAREN.add(RPAREN52);


            // AST REWRITE
            // elements: RPAREN, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1003:37: -> ^( PAREXPR[$lpar, \"PAREXPR\"] expression RPAREN )
            {
                // JS.g:1003:40: ^( PAREXPR[$lpar, \"PAREXPR\"] expression RPAREN )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(PAREXPR, lpar,  "PAREXPR"), root_1);

                adaptor.addChild(root_1, stream_expression.next());
                adaptor.addChild(root_1, stream_RPAREN.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end parenExpression

    public static class arrayLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start arrayLiteral
    // JS.g:1006:1: arrayLiteral : lb= LBRACK ( arrayItem ( COMMA ( arrayItem )? )* )? rb= RBRACK -> ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* $rb) ;
    public final arrayLiteral_return arrayLiteral() throws RecognitionException {
        arrayLiteral_return retval = new arrayLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb=null;
        Token rb=null;
        Token COMMA54=null;
        arrayItem_return arrayItem53 = null;

        arrayItem_return arrayItem55 = null;


        Object lb_tree=null;
        Object rb_tree=null;
        Object COMMA54_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_arrayItem=new RewriteRuleSubtreeStream(adaptor,"rule arrayItem");
        try {
            // JS.g:1007:2: (lb= LBRACK ( arrayItem ( COMMA ( arrayItem )? )* )? rb= RBRACK -> ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* $rb) )
            // JS.g:1007:4: lb= LBRACK ( arrayItem ( COMMA ( arrayItem )? )* )? rb= RBRACK
            {
            lb=(Token)input.LT(1);
            match(input,LBRACK,FOLLOW_LBRACK_in_arrayLiteral3843); 
            stream_LBRACK.add(lb);

            // JS.g:1007:14: ( arrayItem ( COMMA ( arrayItem )? )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=NULL && LA10_0<=FALSE)||LA10_0==EACH||LA10_0==THIS||(LA10_0>=GET && LA10_0<=SET)||(LA10_0>=WXML && LA10_0<=CLASS)||(LA10_0>=DEBUGGER && LA10_0<=VOLATILE)||LA10_0==AT||LA10_0==StringLiteral||(LA10_0>=Identifier && LA10_0<=RegularExpressionLiteral)||(LA10_0>=DecimalLiteral && LA10_0<=HexIntegerLiteral)) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=XMLFragment && LA10_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt10=1;
            }
            else if ( (LA10_0==DELETE||LA10_0==FUNCTION||LA10_0==NEW||LA10_0==TYPEOF||LA10_0==VOID||LA10_0==YIELD||LA10_0==LBRACE||LA10_0==LPAREN||LA10_0==LBRACK||LA10_0==COMMA||(LA10_0>=ADD && LA10_0<=SUB)||(LA10_0>=INC && LA10_0<=DEC)||(LA10_0>=NOT && LA10_0<=INV)) ) {
                alt10=1;
            }
            else if ( (LA10_0==RBRACK) ) {
                int LA10_4 = input.LA(2);

                if ( ( input.LA(1) == COMMA ) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // JS.g:1007:16: arrayItem ( COMMA ( arrayItem )? )*
                    {
                    pushFollow(FOLLOW_arrayItem_in_arrayLiteral3847);
                    arrayItem53=arrayItem();
                    _fsp--;

                    stream_arrayItem.add(arrayItem53.getTree());
                    // JS.g:1007:26: ( COMMA ( arrayItem )? )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==COMMA) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // JS.g:1007:28: COMMA ( arrayItem )?
                    	    {
                    	    COMMA54=(Token)input.LT(1);
                    	    match(input,COMMA,FOLLOW_COMMA_in_arrayLiteral3851); 
                    	    stream_COMMA.add(COMMA54);

                    	    // JS.g:1007:34: ( arrayItem )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( ((LA8_0>=NULL && LA8_0<=FALSE)||LA8_0==EACH||LA8_0==THIS||(LA8_0>=GET && LA8_0<=SET)||(LA8_0>=WXML && LA8_0<=CLASS)||(LA8_0>=DEBUGGER && LA8_0<=VOLATILE)||LA8_0==AT||LA8_0==StringLiteral||(LA8_0>=Identifier && LA8_0<=RegularExpressionLiteral)||(LA8_0>=DecimalLiteral && LA8_0<=HexIntegerLiteral)) ) {
                    	        alt8=1;
                    	    }
                    	    else if ( ((LA8_0>=XMLFragment && LA8_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                    	        alt8=1;
                    	    }
                    	    else if ( (LA8_0==DELETE||LA8_0==FUNCTION||LA8_0==NEW||LA8_0==TYPEOF||LA8_0==VOID||LA8_0==YIELD||LA8_0==LBRACE||LA8_0==LPAREN||LA8_0==LBRACK||(LA8_0>=ADD && LA8_0<=SUB)||(LA8_0>=INC && LA8_0<=DEC)||(LA8_0>=NOT && LA8_0<=INV)) ) {
                    	        alt8=1;
                    	    }
                    	    else if ( (LA8_0==RBRACK) ) {
                    	        int LA8_4 = input.LA(2);

                    	        if ( ( input.LA(1) == COMMA ) ) {
                    	            alt8=1;
                    	        }
                    	    }
                    	    else if ( (LA8_0==COMMA) ) {
                    	        int LA8_5 = input.LA(2);

                    	        if ( ( input.LA(1) == COMMA ) ) {
                    	            alt8=1;
                    	        }
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // JS.g:1007:34: arrayItem
                    	            {
                    	            pushFollow(FOLLOW_arrayItem_in_arrayLiteral3853);
                    	            arrayItem55=arrayItem();
                    	            _fsp--;

                    	            stream_arrayItem.add(arrayItem55.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            rb=(Token)input.LT(1);
            match(input,RBRACK,FOLLOW_RBRACK_in_arrayLiteral3864); 
            stream_RBRACK.add(rb);


            // AST REWRITE
            // elements: arrayItem, rb
            // token labels: rb
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_rb=new RewriteRuleTokenStream(adaptor,"token rb",rb);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1008:2: -> ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* $rb)
            {
                // JS.g:1008:5: ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* $rb)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ARRAY, lb,  "ARRAY"), root_1);

                // JS.g:1008:28: ( arrayItem )*
                while ( stream_arrayItem.hasNext() ) {
                    adaptor.addChild(root_1, stream_arrayItem.next());

                }
                stream_arrayItem.reset();
                adaptor.addChild(root_1, stream_rb.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end arrayLiteral

    public static class arrayItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start arrayItem
    // JS.g:1011:1: arrayItem : (expr= assignmentExpression | {...}?) -> ^( ITEM ( $expr)? ) ;
    public final arrayItem_return arrayItem() throws RecognitionException {
        arrayItem_return retval = new arrayItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        assignmentExpression_return expr = null;


        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            // JS.g:1012:2: ( (expr= assignmentExpression | {...}?) -> ^( ITEM ( $expr)? ) )
            // JS.g:1012:4: (expr= assignmentExpression | {...}?)
            {
            // JS.g:1012:4: (expr= assignmentExpression | {...}?)
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=NULL && LA11_0<=FALSE)||LA11_0==EACH||LA11_0==THIS||(LA11_0>=GET && LA11_0<=SET)||(LA11_0>=WXML && LA11_0<=CLASS)||(LA11_0>=DEBUGGER && LA11_0<=VOLATILE)||LA11_0==AT||LA11_0==StringLiteral||(LA11_0>=Identifier && LA11_0<=RegularExpressionLiteral)||(LA11_0>=DecimalLiteral && LA11_0<=HexIntegerLiteral)) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=XMLFragment && LA11_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt11=1;
            }
            else if ( (LA11_0==DELETE||LA11_0==FUNCTION||LA11_0==NEW||LA11_0==TYPEOF||LA11_0==VOID||LA11_0==YIELD||LA11_0==LBRACE||LA11_0==LPAREN||LA11_0==LBRACK||(LA11_0>=ADD && LA11_0<=SUB)||(LA11_0>=INC && LA11_0<=DEC)||(LA11_0>=NOT && LA11_0<=INV)) ) {
                alt11=1;
            }
            else if ( (LA11_0==RBRACK||LA11_0==COMMA) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1012:4: (expr= assignmentExpression | {...}?)", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // JS.g:1012:6: expr= assignmentExpression
                    {
                    pushFollow(FOLLOW_assignmentExpression_in_arrayItem3894);
                    expr=assignmentExpression();
                    _fsp--;

                    stream_assignmentExpression.add(expr.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1012:34: {...}?
                    {
                    if ( !( input.LA(1) == COMMA ) ) {
                        throw new FailedPredicateException(input, "arrayItem", " input.LA(1) == COMMA ");
                    }

                    }
                    break;

            }


            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval, expr
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"token expr",expr!=null?expr.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1013:2: -> ^( ITEM ( $expr)? )
            {
                // JS.g:1013:5: ^( ITEM ( $expr)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ITEM, "ITEM"), root_1);

                // JS.g:1013:13: ( $expr)?
                if ( stream_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_expr.next());

                }
                stream_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end arrayItem

    public static class objectLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start objectLiteral
    // JS.g:1016:1: objectLiteral : lb= LBRACE ( objectPropertyInitializer ( COMMA objectPropertyInitializer )* ( COMMA )? )? RBRACE -> ^( OBJECT[$lb, \"OBJECT\"] ( objectPropertyInitializer )* ( COMMA )* ) ;
    public final objectLiteral_return objectLiteral() throws RecognitionException {
        objectLiteral_return retval = new objectLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb=null;
        Token COMMA57=null;
        Token COMMA59=null;
        Token RBRACE60=null;
        objectPropertyInitializer_return objectPropertyInitializer56 = null;

        objectPropertyInitializer_return objectPropertyInitializer58 = null;


        Object lb_tree=null;
        Object COMMA57_tree=null;
        Object COMMA59_tree=null;
        Object RBRACE60_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_objectPropertyInitializer=new RewriteRuleSubtreeStream(adaptor,"rule objectPropertyInitializer");
        try {
            // JS.g:1017:2: (lb= LBRACE ( objectPropertyInitializer ( COMMA objectPropertyInitializer )* ( COMMA )? )? RBRACE -> ^( OBJECT[$lb, \"OBJECT\"] ( objectPropertyInitializer )* ( COMMA )* ) )
            // JS.g:1017:4: lb= LBRACE ( objectPropertyInitializer ( COMMA objectPropertyInitializer )* ( COMMA )? )? RBRACE
            {
            lb=(Token)input.LT(1);
            match(input,LBRACE,FOLLOW_LBRACE_in_objectLiteral3926); 
            stream_LBRACE.add(lb);

            // JS.g:1017:14: ( objectPropertyInitializer ( COMMA objectPropertyInitializer )* ( COMMA )? )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=BREAK && LA14_0<=CLASS)||(LA14_0>=DEBUGGER && LA14_0<=VOLATILE)||LA14_0==StringLiteral||LA14_0==Identifier||(LA14_0>=DecimalLiteral && LA14_0<=HexIntegerLiteral)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // JS.g:1017:16: objectPropertyInitializer ( COMMA objectPropertyInitializer )* ( COMMA )?
                    {
                    pushFollow(FOLLOW_objectPropertyInitializer_in_objectLiteral3930);
                    objectPropertyInitializer56=objectPropertyInitializer();
                    _fsp--;

                    stream_objectPropertyInitializer.add(objectPropertyInitializer56.getTree());
                    // JS.g:1017:42: ( COMMA objectPropertyInitializer )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==COMMA) ) {
                            int LA12_1 = input.LA(2);

                            if ( ((LA12_1>=BREAK && LA12_1<=CLASS)||(LA12_1>=DEBUGGER && LA12_1<=VOLATILE)||LA12_1==StringLiteral||LA12_1==Identifier||(LA12_1>=DecimalLiteral && LA12_1<=HexIntegerLiteral)) ) {
                                alt12=1;
                            }


                        }


                        switch (alt12) {
                    	case 1 :
                    	    // JS.g:1017:44: COMMA objectPropertyInitializer
                    	    {
                    	    COMMA57=(Token)input.LT(1);
                    	    match(input,COMMA,FOLLOW_COMMA_in_objectLiteral3934); 
                    	    stream_COMMA.add(COMMA57);

                    	    pushFollow(FOLLOW_objectPropertyInitializer_in_objectLiteral3936);
                    	    objectPropertyInitializer58=objectPropertyInitializer();
                    	    _fsp--;

                    	    stream_objectPropertyInitializer.add(objectPropertyInitializer58.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // JS.g:1017:79: ( COMMA )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==COMMA) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // JS.g:1017:79: COMMA
                            {
                            COMMA59=(Token)input.LT(1);
                            match(input,COMMA,FOLLOW_COMMA_in_objectLiteral3941); 
                            stream_COMMA.add(COMMA59);


                            }
                            break;

                    }


                    }
                    break;

            }

            RBRACE60=(Token)input.LT(1);
            match(input,RBRACE,FOLLOW_RBRACE_in_objectLiteral3946); 
            stream_RBRACE.add(RBRACE60);


            // AST REWRITE
            // elements: COMMA, objectPropertyInitializer
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1018:2: -> ^( OBJECT[$lb, \"OBJECT\"] ( objectPropertyInitializer )* ( COMMA )* )
            {
                // JS.g:1018:5: ^( OBJECT[$lb, \"OBJECT\"] ( objectPropertyInitializer )* ( COMMA )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(OBJECT, lb,  "OBJECT"), root_1);

                // JS.g:1018:30: ( objectPropertyInitializer )*
                while ( stream_objectPropertyInitializer.hasNext() ) {
                    adaptor.addChild(root_1, stream_objectPropertyInitializer.next());

                }
                stream_objectPropertyInitializer.reset();
                // JS.g:1018:57: ( COMMA )*
                while ( stream_COMMA.hasNext() ) {
                    adaptor.addChild(root_1, stream_COMMA.next());

                }
                stream_COMMA.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end objectLiteral

    public static class objectPropertyInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start objectPropertyInitializer
    // JS.g:1021:1: objectPropertyInitializer : ( nameValuePair | getMethodDeclaration | setMethodDeclaration );
    public final objectPropertyInitializer_return objectPropertyInitializer() throws RecognitionException {
        objectPropertyInitializer_return retval = new objectPropertyInitializer_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        nameValuePair_return nameValuePair61 = null;

        getMethodDeclaration_return getMethodDeclaration62 = null;

        setMethodDeclaration_return setMethodDeclaration63 = null;



        try {
            // JS.g:1022:3: ( nameValuePair | getMethodDeclaration | setMethodDeclaration )
            int alt15=3;
            switch ( input.LA(1) ) {
            case BREAK:
            case CASE:
            case CATCH:
            case CONTINUE:
            case DEFAULT:
            case DELETE:
            case DO:
            case ELSE:
            case FINALLY:
            case FOR:
            case EACH:
            case FUNCTION:
            case IF:
            case IN:
            case INSTANCEOF:
            case NEW:
            case RETURN:
            case SWITCH:
            case THIS:
            case THROW:
            case TRY:
            case TYPEOF:
            case VAR:
            case VOID:
            case WHILE:
            case WITH:
            case YIELD:
            case WXML:
            case NAMESPACE:
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case DEBUGGER:
            case DOUBLE:
            case ENUM:
            case EXPORT:
            case EXTENDS:
            case FINAL:
            case FLOAT:
            case GOTO:
            case IMPLEMENTS:
            case IMPORT:
            case INT:
            case INTERFACE:
            case LONG:
            case NATIVE:
            case PACKAGE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case SHORT:
            case STATIC:
            case SUPER:
            case SYNCHRONIZED:
            case THROWS:
            case TRANSIENT:
            case VOLATILE:
            case StringLiteral:
            case Identifier:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt15=1;
                }
                break;
            case GET:
                {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==COLON) ) {
                    alt15=1;
                }
                else if ( (LA15_2==EACH||(LA15_2>=GET && LA15_2<=SET)||(LA15_2>=WXML && LA15_2<=CLASS)||(LA15_2>=DEBUGGER && LA15_2<=VOLATILE)||LA15_2==Identifier) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1021:1: objectPropertyInitializer : ( nameValuePair | getMethodDeclaration | setMethodDeclaration );", 15, 2, input);

                    throw nvae;
                }
                }
                break;
            case SET:
                {
                int LA15_3 = input.LA(2);

                if ( (LA15_3==COLON) ) {
                    alt15=1;
                }
                else if ( (LA15_3==EACH||(LA15_3>=GET && LA15_3<=SET)||(LA15_3>=WXML && LA15_3<=CLASS)||(LA15_3>=DEBUGGER && LA15_3<=VOLATILE)||LA15_3==Identifier) ) {
                    alt15=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1021:1: objectPropertyInitializer : ( nameValuePair | getMethodDeclaration | setMethodDeclaration );", 15, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1021:1: objectPropertyInitializer : ( nameValuePair | getMethodDeclaration | setMethodDeclaration );", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // JS.g:1022:5: nameValuePair
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nameValuePair_in_objectPropertyInitializer3973);
                    nameValuePair61=nameValuePair();
                    _fsp--;

                    adaptor.addChild(root_0, nameValuePair61.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1023:5: getMethodDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_getMethodDeclaration_in_objectPropertyInitializer3979);
                    getMethodDeclaration62=getMethodDeclaration();
                    _fsp--;

                    adaptor.addChild(root_0, getMethodDeclaration62.getTree());

                    }
                    break;
                case 3 :
                    // JS.g:1024:5: setMethodDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_setMethodDeclaration_in_objectPropertyInitializer3985);
                    setMethodDeclaration63=setMethodDeclaration();
                    _fsp--;

                    adaptor.addChild(root_0, setMethodDeclaration63.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end objectPropertyInitializer

    public static class nameValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nameValuePair
    // JS.g:1027:1: nameValuePair : propertyName COLON assignmentExpression ( nameValuePairFix )? -> ^( NAMEDVALUE propertyName assignmentExpression ( nameValuePairFix )? ) ;
    public final nameValuePair_return nameValuePair() throws RecognitionException {
        nameValuePair_return retval = new nameValuePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON65=null;
        propertyName_return propertyName64 = null;

        assignmentExpression_return assignmentExpression66 = null;

        nameValuePairFix_return nameValuePairFix67 = null;


        Object COLON65_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_propertyName=new RewriteRuleSubtreeStream(adaptor,"rule propertyName");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        RewriteRuleSubtreeStream stream_nameValuePairFix=new RewriteRuleSubtreeStream(adaptor,"rule nameValuePairFix");
        try {
            // JS.g:1028:2: ( propertyName COLON assignmentExpression ( nameValuePairFix )? -> ^( NAMEDVALUE propertyName assignmentExpression ( nameValuePairFix )? ) )
            // JS.g:1028:4: propertyName COLON assignmentExpression ( nameValuePairFix )?
            {
            pushFollow(FOLLOW_propertyName_in_nameValuePair3997);
            propertyName64=propertyName();
            _fsp--;

            stream_propertyName.add(propertyName64.getTree());
            COLON65=(Token)input.LT(1);
            match(input,COLON,FOLLOW_COLON_in_nameValuePair3999); 
            stream_COLON.add(COLON65);

            pushFollow(FOLLOW_assignmentExpression_in_nameValuePair4001);
            assignmentExpression66=assignmentExpression();
            _fsp--;

            stream_assignmentExpression.add(assignmentExpression66.getTree());
            // JS.g:1028:44: ( nameValuePairFix )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==EACH||(LA16_0>=GET && LA16_0<=SET)||(LA16_0>=WXML && LA16_0<=CLASS)||(LA16_0>=DEBUGGER && LA16_0<=VOLATILE)||LA16_0==COLON||LA16_0==Identifier) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // JS.g:1028:44: nameValuePairFix
                    {
                    pushFollow(FOLLOW_nameValuePairFix_in_nameValuePair4003);
                    nameValuePairFix67=nameValuePairFix();
                    _fsp--;

                    stream_nameValuePairFix.add(nameValuePairFix67.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: nameValuePairFix, assignmentExpression, propertyName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1029:2: -> ^( NAMEDVALUE propertyName assignmentExpression ( nameValuePairFix )? )
            {
                // JS.g:1029:5: ^( NAMEDVALUE propertyName assignmentExpression ( nameValuePairFix )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(NAMEDVALUE, "NAMEDVALUE"), root_1);

                adaptor.addChild(root_1, stream_propertyName.next());
                adaptor.addChild(root_1, stream_assignmentExpression.next());
                // JS.g:1029:53: ( nameValuePairFix )?
                if ( stream_nameValuePairFix.hasNext() ) {
                    adaptor.addChild(root_1, stream_nameValuePairFix.next());

                }
                stream_nameValuePairFix.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end nameValuePair

    public static class nameValuePairFix_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nameValuePairFix
    // JS.g:1032:1: nameValuePairFix : (colon= COLON assignmentExpression -> ^( $colon assignmentExpression ) | id= identifier COLON assignmentExpression -> ^( NAMEDVALUE $id assignmentExpression ) );
    public final nameValuePairFix_return nameValuePairFix() throws RecognitionException {
        nameValuePairFix_return retval = new nameValuePairFix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token colon=null;
        Token COLON69=null;
        identifier_return id = null;

        assignmentExpression_return assignmentExpression68 = null;

        assignmentExpression_return assignmentExpression70 = null;


        Object colon_tree=null;
        Object COLON69_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // JS.g:1033:2: (colon= COLON assignmentExpression -> ^( $colon assignmentExpression ) | id= identifier COLON assignmentExpression -> ^( NAMEDVALUE $id assignmentExpression ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==COLON) ) {
                alt17=1;
            }
            else if ( (LA17_0==EACH||(LA17_0>=GET && LA17_0<=SET)||(LA17_0>=WXML && LA17_0<=CLASS)||(LA17_0>=DEBUGGER && LA17_0<=VOLATILE)||LA17_0==Identifier) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1032:1: nameValuePairFix : (colon= COLON assignmentExpression -> ^( $colon assignmentExpression ) | id= identifier COLON assignmentExpression -> ^( NAMEDVALUE $id assignmentExpression ) );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // JS.g:1033:4: colon= COLON assignmentExpression
                    {
                    colon=(Token)input.LT(1);
                    match(input,COLON,FOLLOW_COLON_in_nameValuePairFix4033); 
                    stream_COLON.add(colon);

                    pushFollow(FOLLOW_assignmentExpression_in_nameValuePairFix4035);
                    assignmentExpression68=assignmentExpression();
                    _fsp--;

                    stream_assignmentExpression.add(assignmentExpression68.getTree());
                     reportError("Comma or expression expected", colon); 

                    // AST REWRITE
                    // elements: colon, assignmentExpression
                    // token labels: colon
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_colon=new RewriteRuleTokenStream(adaptor,"token colon",colon);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1034:2: -> ^( $colon assignmentExpression )
                    {
                        // JS.g:1034:5: ^( $colon assignmentExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_colon.next(), root_1);

                        adaptor.addChild(root_1, stream_assignmentExpression.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 2 :
                    // JS.g:1035:4: id= identifier COLON assignmentExpression
                    {
                    pushFollow(FOLLOW_identifier_in_nameValuePairFix4056);
                    id=identifier();
                    _fsp--;

                    stream_identifier.add(id.getTree());
                    COLON69=(Token)input.LT(1);
                    match(input,COLON,FOLLOW_COLON_in_nameValuePairFix4058); 
                    stream_COLON.add(COLON69);

                    pushFollow(FOLLOW_assignmentExpression_in_nameValuePairFix4060);
                    assignmentExpression70=assignmentExpression();
                    _fsp--;

                    stream_assignmentExpression.add(assignmentExpression70.getTree());
                     reportError("Comma expected", ((Token)id.start)); 

                    // AST REWRITE
                    // elements: assignmentExpression, id
                    // token labels: 
                    // rule labels: id, retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"token id",id!=null?id.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1036:2: -> ^( NAMEDVALUE $id assignmentExpression )
                    {
                        // JS.g:1036:5: ^( NAMEDVALUE $id assignmentExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(NAMEDVALUE, "NAMEDVALUE"), root_1);

                        adaptor.addChild(root_1, stream_id.next());
                        adaptor.addChild(root_1, stream_assignmentExpression.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end nameValuePairFix

    public static class propertyName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start propertyName
    // JS.g:1039:1: propertyName : ( identifier | word= reservedWord -> Identifier[word.start] | StringLiteral | numericLiteral );
    public final propertyName_return propertyName() throws RecognitionException {
        propertyName_return retval = new propertyName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token StringLiteral72=null;
        reservedWord_return word = null;

        identifier_return identifier71 = null;

        numericLiteral_return numericLiteral73 = null;


        Object StringLiteral72_tree=null;
        RewriteRuleSubtreeStream stream_reservedWord=new RewriteRuleSubtreeStream(adaptor,"rule reservedWord");
        try {
            // JS.g:1040:2: ( identifier | word= reservedWord -> Identifier[word.start] | StringLiteral | numericLiteral )
            int alt18=4;
            switch ( input.LA(1) ) {
            case WXML:
                {
                alt18=1;
                }
                break;
            case GET:
                {
                alt18=1;
                }
                break;
            case SET:
                {
                alt18=1;
                }
                break;
            case EACH:
                {
                alt18=1;
                }
                break;
            case NAMESPACE:
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case DEBUGGER:
            case DOUBLE:
            case ENUM:
            case EXPORT:
            case EXTENDS:
            case FINAL:
            case FLOAT:
            case GOTO:
            case IMPLEMENTS:
            case IMPORT:
            case INT:
            case INTERFACE:
            case LONG:
            case NATIVE:
            case PACKAGE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case SHORT:
            case STATIC:
            case SUPER:
            case SYNCHRONIZED:
            case THROWS:
            case TRANSIENT:
            case VOLATILE:
            case Identifier:
                {
                alt18=1;
                }
                break;
            case BREAK:
            case CASE:
            case CATCH:
            case CONTINUE:
            case DEFAULT:
            case DELETE:
            case DO:
            case ELSE:
            case FINALLY:
            case FOR:
            case FUNCTION:
            case IF:
            case IN:
            case INSTANCEOF:
            case NEW:
            case RETURN:
            case SWITCH:
            case THIS:
            case THROW:
            case TRY:
            case TYPEOF:
            case VAR:
            case VOID:
            case WHILE:
            case WITH:
            case YIELD:
                {
                alt18=2;
                }
                break;
            case StringLiteral:
                {
                alt18=3;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1039:1: propertyName : ( identifier | word= reservedWord -> Identifier[word.start] | StringLiteral | numericLiteral );", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // JS.g:1040:4: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_propertyName4087);
                    identifier71=identifier();
                    _fsp--;

                    adaptor.addChild(root_0, identifier71.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1041:4: word= reservedWord
                    {
                    pushFollow(FOLLOW_reservedWord_in_propertyName4094);
                    word=reservedWord();
                    _fsp--;

                    stream_reservedWord.add(word.getTree());

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1041:22: -> Identifier[word.start]
                    {
                        adaptor.addChild(root_0, adaptor.create(Identifier, word.start));

                    }



                    }
                    break;
                case 3 :
                    // JS.g:1042:4: StringLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    StringLiteral72=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_propertyName4104); 
                    StringLiteral72_tree = (Object)adaptor.create(StringLiteral72);
                    adaptor.addChild(root_0, StringLiteral72_tree);


                    }
                    break;
                case 4 :
                    // JS.g:1043:4: numericLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numericLiteral_in_propertyName4109);
                    numericLiteral73=numericLiteral();
                    _fsp--;

                    adaptor.addChild(root_0, numericLiteral73.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end propertyName

    public static class memberExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start memberExpression
    // JS.g:1055:1: memberExpression : ( primaryExpression | functionExpression | newExpression );
    public final memberExpression_return memberExpression() throws RecognitionException {
        memberExpression_return retval = new memberExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        primaryExpression_return primaryExpression74 = null;

        functionExpression_return functionExpression75 = null;

        newExpression_return newExpression76 = null;



        try {
            // JS.g:1056:2: ( primaryExpression | functionExpression | newExpression )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=NULL && LA19_0<=FALSE)||LA19_0==EACH||LA19_0==THIS||(LA19_0>=GET && LA19_0<=SET)||(LA19_0>=WXML && LA19_0<=CLASS)||(LA19_0>=DEBUGGER && LA19_0<=VOLATILE)||LA19_0==AT||LA19_0==StringLiteral||(LA19_0>=Identifier && LA19_0<=RegularExpressionLiteral)||(LA19_0>=DecimalLiteral && LA19_0<=HexIntegerLiteral)) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=XMLFragment && LA19_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt19=1;
            }
            else if ( (LA19_0==LBRACE||LA19_0==LPAREN||LA19_0==LBRACK) ) {
                alt19=1;
            }
            else if ( (LA19_0==FUNCTION) ) {
                alt19=2;
            }
            else if ( (LA19_0==NEW) ) {
                alt19=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1055:1: memberExpression : ( primaryExpression | functionExpression | newExpression );", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // JS.g:1056:4: primaryExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primaryExpression_in_memberExpression4127);
                    primaryExpression74=primaryExpression();
                    _fsp--;

                    adaptor.addChild(root_0, primaryExpression74.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1057:4: functionExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionExpression_in_memberExpression4132);
                    functionExpression75=functionExpression();
                    _fsp--;

                    adaptor.addChild(root_0, functionExpression75.getTree());

                    }
                    break;
                case 3 :
                    // JS.g:1058:4: newExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_memberExpression4137);
                    newExpression76=newExpression();
                    _fsp--;

                    adaptor.addChild(root_0, newExpression76.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end memberExpression

    public static class newExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start newExpression
    // JS.g:1061:1: newExpression : NEW newExpressionTail ;
    public final newExpression_return newExpression() throws RecognitionException {
        newExpression_return retval = new newExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NEW77=null;
        newExpressionTail_return newExpressionTail78 = null;


        Object NEW77_tree=null;

        try {
            // JS.g:1062:2: ( NEW newExpressionTail )
            // JS.g:1062:4: NEW newExpressionTail
            {
            root_0 = (Object)adaptor.nil();

            NEW77=(Token)input.LT(1);
            match(input,NEW,FOLLOW_NEW_in_newExpression4148); 
            NEW77_tree = (Object)adaptor.create(NEW77);
            root_0 = (Object)adaptor.becomeRoot(NEW77_tree, root_0);

            pushFollow(FOLLOW_newExpressionTail_in_newExpression4151);
            newExpressionTail78=newExpressionTail();
            _fsp--;

            adaptor.addChild(root_0, newExpressionTail78.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end newExpression

    public static class arguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start arguments
    // JS.g:1066:1: arguments : LPAREN ( assignmentExpression ( COMMA assignmentExpression )* )? RPAREN -> ^( CALL_ARGUMENTS ( assignmentExpression )* ) ;
    public final arguments_return arguments() throws RecognitionException {
        arguments_return retval = new arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN79=null;
        Token COMMA81=null;
        Token RPAREN83=null;
        assignmentExpression_return assignmentExpression80 = null;

        assignmentExpression_return assignmentExpression82 = null;


        Object LPAREN79_tree=null;
        Object COMMA81_tree=null;
        Object RPAREN83_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            // JS.g:1067:2: ( LPAREN ( assignmentExpression ( COMMA assignmentExpression )* )? RPAREN -> ^( CALL_ARGUMENTS ( assignmentExpression )* ) )
            // JS.g:1067:4: LPAREN ( assignmentExpression ( COMMA assignmentExpression )* )? RPAREN
            {
            LPAREN79=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_arguments4164); 
            stream_LPAREN.add(LPAREN79);

            // JS.g:1067:11: ( assignmentExpression ( COMMA assignmentExpression )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=NULL && LA21_0<=FALSE)||LA21_0==EACH||LA21_0==THIS||(LA21_0>=GET && LA21_0<=SET)||(LA21_0>=WXML && LA21_0<=CLASS)||(LA21_0>=DEBUGGER && LA21_0<=VOLATILE)||LA21_0==AT||LA21_0==StringLiteral||(LA21_0>=Identifier && LA21_0<=RegularExpressionLiteral)||(LA21_0>=DecimalLiteral && LA21_0<=HexIntegerLiteral)) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=XMLFragment && LA21_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt21=1;
            }
            else if ( (LA21_0==DELETE||LA21_0==FUNCTION||LA21_0==NEW||LA21_0==TYPEOF||LA21_0==VOID||LA21_0==YIELD||LA21_0==LBRACE||LA21_0==LPAREN||LA21_0==LBRACK||(LA21_0>=ADD && LA21_0<=SUB)||(LA21_0>=INC && LA21_0<=DEC)||(LA21_0>=NOT && LA21_0<=INV)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // JS.g:1067:13: assignmentExpression ( COMMA assignmentExpression )*
                    {
                    pushFollow(FOLLOW_assignmentExpression_in_arguments4168);
                    assignmentExpression80=assignmentExpression();
                    _fsp--;

                    stream_assignmentExpression.add(assignmentExpression80.getTree());
                    // JS.g:1067:34: ( COMMA assignmentExpression )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==COMMA) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // JS.g:1067:36: COMMA assignmentExpression
                    	    {
                    	    COMMA81=(Token)input.LT(1);
                    	    match(input,COMMA,FOLLOW_COMMA_in_arguments4172); 
                    	    stream_COMMA.add(COMMA81);

                    	    pushFollow(FOLLOW_assignmentExpression_in_arguments4174);
                    	    assignmentExpression82=assignmentExpression();
                    	    _fsp--;

                    	    stream_assignmentExpression.add(assignmentExpression82.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            RPAREN83=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_arguments4182); 
            stream_RPAREN.add(RPAREN83);


            // AST REWRITE
            // elements: assignmentExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1068:2: -> ^( CALL_ARGUMENTS ( assignmentExpression )* )
            {
                // JS.g:1068:5: ^( CALL_ARGUMENTS ( assignmentExpression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(CALL_ARGUMENTS, "CALL_ARGUMENTS"), root_1);

                // JS.g:1068:23: ( assignmentExpression )*
                while ( stream_assignmentExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_assignmentExpression.next());

                }
                stream_assignmentExpression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end arguments

    public static class leftHandSideExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start leftHandSideExpression
    // JS.g:1071:1: leftHandSideExpression : ( memberExpression -> memberExpression ) ( arguments -> ^( CALL $leftHandSideExpression arguments ) | lb1= LBRACK expression RBRACK -> ^( BYINDEX[$lb1] $leftHandSideExpression expression ) | DOT r= rightHandSideExpression -> ^( BYFIELD $leftHandSideExpression DOT ( $r)? ) | {...}? => DOTDOT r2= rightHandSideExpression2 -> ^( ALLCHILDREN $leftHandSideExpression $r2) | {...}? => COLONCOLON LBRACK expression RBRACK -> ^( LOCALNAME $leftHandSideExpression expression ) | {...}? => COLONCOLON ps= propertySelector -> ^( LOCALNAME $leftHandSideExpression ( $ps)? ) )* ;
    public final leftHandSideExpression_return leftHandSideExpression() throws RecognitionException {
        leftHandSideExpression_return retval = new leftHandSideExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb1=null;
        Token RBRACK87=null;
        Token DOT88=null;
        Token DOTDOT89=null;
        Token COLONCOLON90=null;
        Token LBRACK91=null;
        Token RBRACK93=null;
        Token COLONCOLON94=null;
        rightHandSideExpression_return r = null;

        rightHandSideExpression2_return r2 = null;

        propertySelector_return ps = null;

        memberExpression_return memberExpression84 = null;

        arguments_return arguments85 = null;

        expression_return expression86 = null;

        expression_return expression92 = null;


        Object lb1_tree=null;
        Object RBRACK87_tree=null;
        Object DOT88_tree=null;
        Object DOTDOT89_tree=null;
        Object COLONCOLON90_tree=null;
        Object LBRACK91_tree=null;
        Object RBRACK93_tree=null;
        Object COLONCOLON94_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_COLONCOLON=new RewriteRuleTokenStream(adaptor,"token COLONCOLON");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_DOTDOT=new RewriteRuleTokenStream(adaptor,"token DOTDOT");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_memberExpression=new RewriteRuleSubtreeStream(adaptor,"rule memberExpression");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_rightHandSideExpression2=new RewriteRuleSubtreeStream(adaptor,"rule rightHandSideExpression2");
        RewriteRuleSubtreeStream stream_rightHandSideExpression=new RewriteRuleSubtreeStream(adaptor,"rule rightHandSideExpression");
        RewriteRuleSubtreeStream stream_propertySelector=new RewriteRuleSubtreeStream(adaptor,"rule propertySelector");
         pushState(JSParserRule.LEFT_HAND_SIDE_EXPRESSION); 
        try {
            // JS.g:1073:3: ( ( memberExpression -> memberExpression ) ( arguments -> ^( CALL $leftHandSideExpression arguments ) | lb1= LBRACK expression RBRACK -> ^( BYINDEX[$lb1] $leftHandSideExpression expression ) | DOT r= rightHandSideExpression -> ^( BYFIELD $leftHandSideExpression DOT ( $r)? ) | {...}? => DOTDOT r2= rightHandSideExpression2 -> ^( ALLCHILDREN $leftHandSideExpression $r2) | {...}? => COLONCOLON LBRACK expression RBRACK -> ^( LOCALNAME $leftHandSideExpression expression ) | {...}? => COLONCOLON ps= propertySelector -> ^( LOCALNAME $leftHandSideExpression ( $ps)? ) )* )
            // JS.g:1074:3: ( memberExpression -> memberExpression ) ( arguments -> ^( CALL $leftHandSideExpression arguments ) | lb1= LBRACK expression RBRACK -> ^( BYINDEX[$lb1] $leftHandSideExpression expression ) | DOT r= rightHandSideExpression -> ^( BYFIELD $leftHandSideExpression DOT ( $r)? ) | {...}? => DOTDOT r2= rightHandSideExpression2 -> ^( ALLCHILDREN $leftHandSideExpression $r2) | {...}? => COLONCOLON LBRACK expression RBRACK -> ^( LOCALNAME $leftHandSideExpression expression ) | {...}? => COLONCOLON ps= propertySelector -> ^( LOCALNAME $leftHandSideExpression ( $ps)? ) )*
            {
            // JS.g:1074:3: ( memberExpression -> memberExpression )
            // JS.g:1075:5: memberExpression
            {
            pushFollow(FOLLOW_memberExpression_in_leftHandSideExpression4220);
            memberExpression84=memberExpression();
            _fsp--;

            stream_memberExpression.add(memberExpression84.getTree());

            // AST REWRITE
            // elements: memberExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1075:25: -> memberExpression
            {
                adaptor.addChild(root_0, stream_memberExpression.next());

            }



            }

            // JS.g:1077:3: ( arguments -> ^( CALL $leftHandSideExpression arguments ) | lb1= LBRACK expression RBRACK -> ^( BYINDEX[$lb1] $leftHandSideExpression expression ) | DOT r= rightHandSideExpression -> ^( BYFIELD $leftHandSideExpression DOT ( $r)? ) | {...}? => DOTDOT r2= rightHandSideExpression2 -> ^( ALLCHILDREN $leftHandSideExpression $r2) | {...}? => COLONCOLON LBRACK expression RBRACK -> ^( LOCALNAME $leftHandSideExpression expression ) | {...}? => COLONCOLON ps= propertySelector -> ^( LOCALNAME $leftHandSideExpression ( $ps)? ) )*
            loop22:
            do {
                int alt22=7;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==LPAREN) ) {
                    alt22=1;
                }
                else if ( (LA22_0==LBRACK) ) {
                    alt22=2;
                }
                else if ( (LA22_0==DOT) ) {
                    alt22=3;
                }
                else if ( (LA22_0==DOTDOT) && ( isXmlEnabled() )) {
                    alt22=4;
                }
                else if ( (LA22_0==COLONCOLON) && ( isXmlEnabled() )) {
                    int LA22_6 = input.LA(2);

                    if ( (LA22_6==LBRACK) && ( isXmlEnabled() )) {
                        alt22=5;
                    }
                    else if ( (LA22_6==EACH||(LA22_6>=GET && LA22_6<=SET)||(LA22_6>=WXML && LA22_6<=CLASS)||(LA22_6>=DEBUGGER && LA22_6<=VOLATILE)||LA22_6==MUL||LA22_6==Identifier) && ( isXmlEnabled() )) {
                        alt22=6;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // JS.g:1078:5: arguments
            	    {
            	    pushFollow(FOLLOW_arguments_in_leftHandSideExpression4241);
            	    arguments85=arguments();
            	    _fsp--;

            	    stream_arguments.add(arguments85.getTree());

            	    // AST REWRITE
            	    // elements: arguments, leftHandSideExpression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1078:19: -> ^( CALL $leftHandSideExpression arguments )
            	    {
            	        // JS.g:1078:22: ^( CALL $leftHandSideExpression arguments )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(CALL, "CALL"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_arguments.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;
            	case 2 :
            	    // JS.g:1079:7: lb1= LBRACK expression RBRACK
            	    {
            	    lb1=(Token)input.LT(1);
            	    match(input,LBRACK,FOLLOW_LBRACK_in_leftHandSideExpression4268); 
            	    stream_LBRACK.add(lb1);

            	    pushFollow(FOLLOW_expression_in_leftHandSideExpression4270);
            	    expression86=expression();
            	    _fsp--;

            	    stream_expression.add(expression86.getTree());
            	    RBRACK87=(Token)input.LT(1);
            	    match(input,RBRACK,FOLLOW_RBRACK_in_leftHandSideExpression4272); 
            	    stream_RBRACK.add(RBRACK87);


            	    // AST REWRITE
            	    // elements: leftHandSideExpression, expression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1079:37: -> ^( BYINDEX[$lb1] $leftHandSideExpression expression )
            	    {
            	        // JS.g:1079:40: ^( BYINDEX[$lb1] $leftHandSideExpression expression )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(BYINDEX, lb1), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_expression.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;
            	case 3 :
            	    // JS.g:1080:7: DOT r= rightHandSideExpression
            	    {
            	    DOT88=(Token)input.LT(1);
            	    match(input,DOT,FOLLOW_DOT_in_leftHandSideExpression4295); 
            	    stream_DOT.add(DOT88);

            	    pushFollow(FOLLOW_rightHandSideExpression_in_leftHandSideExpression4299);
            	    r=rightHandSideExpression();
            	    _fsp--;

            	    stream_rightHandSideExpression.add(r.getTree());

            	    // AST REWRITE
            	    // elements: r, DOT, leftHandSideExpression
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"token r",r!=null?r.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1080:37: -> ^( BYFIELD $leftHandSideExpression DOT ( $r)? )
            	    {
            	        // JS.g:1080:40: ^( BYFIELD $leftHandSideExpression DOT ( $r)? )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(BYFIELD, "BYFIELD"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_DOT.next());
            	        // JS.g:1080:79: ( $r)?
            	        if ( stream_r.hasNext() ) {
            	            adaptor.addChild(root_1, stream_r.next());

            	        }
            	        stream_r.reset();

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;
            	case 4 :
            	    // JS.g:1081:7: {...}? => DOTDOT r2= rightHandSideExpression2
            	    {
            	    if ( !( isXmlEnabled() ) ) {
            	        throw new FailedPredicateException(input, "leftHandSideExpression", " isXmlEnabled() ");
            	    }
            	    DOTDOT89=(Token)input.LT(1);
            	    match(input,DOTDOT,FOLLOW_DOTDOT_in_leftHandSideExpression4327); 
            	    stream_DOTDOT.add(DOTDOT89);

            	    pushFollow(FOLLOW_rightHandSideExpression2_in_leftHandSideExpression4331);
            	    r2=rightHandSideExpression2();
            	    _fsp--;

            	    stream_rightHandSideExpression2.add(r2.getTree());

            	    // AST REWRITE
            	    // elements: leftHandSideExpression, r2
            	    // token labels: 
            	    // rule labels: retval, r2
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r2=new RewriteRuleSubtreeStream(adaptor,"token r2",r2!=null?r2.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1081:64: -> ^( ALLCHILDREN $leftHandSideExpression $r2)
            	    {
            	        // JS.g:1081:67: ^( ALLCHILDREN $leftHandSideExpression $r2)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(ALLCHILDREN, "ALLCHILDREN"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_r2.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;
            	case 5 :
            	    // JS.g:1082:7: {...}? => COLONCOLON LBRACK expression RBRACK
            	    {
            	    if ( !( isXmlEnabled() ) ) {
            	        throw new FailedPredicateException(input, "leftHandSideExpression", " isXmlEnabled() ");
            	    }
            	    COLONCOLON90=(Token)input.LT(1);
            	    match(input,COLONCOLON,FOLLOW_COLONCOLON_in_leftHandSideExpression4354); 
            	    stream_COLONCOLON.add(COLONCOLON90);

            	    LBRACK91=(Token)input.LT(1);
            	    match(input,LBRACK,FOLLOW_LBRACK_in_leftHandSideExpression4356); 
            	    stream_LBRACK.add(LBRACK91);

            	    pushFollow(FOLLOW_expression_in_leftHandSideExpression4358);
            	    expression92=expression();
            	    _fsp--;

            	    stream_expression.add(expression92.getTree());
            	    RBRACK93=(Token)input.LT(1);
            	    match(input,RBRACK,FOLLOW_RBRACK_in_leftHandSideExpression4360); 
            	    stream_RBRACK.add(RBRACK93);


            	    // AST REWRITE
            	    // elements: expression, leftHandSideExpression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1082:65: -> ^( LOCALNAME $leftHandSideExpression expression )
            	    {
            	        // JS.g:1082:68: ^( LOCALNAME $leftHandSideExpression expression )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(LOCALNAME, "LOCALNAME"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_expression.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;
            	case 6 :
            	    // JS.g:1083:7: {...}? => COLONCOLON ps= propertySelector
            	    {
            	    if ( !( isXmlEnabled() ) ) {
            	        throw new FailedPredicateException(input, "leftHandSideExpression", " isXmlEnabled() ");
            	    }
            	    COLONCOLON94=(Token)input.LT(1);
            	    match(input,COLONCOLON,FOLLOW_COLONCOLON_in_leftHandSideExpression4382); 
            	    stream_COLONCOLON.add(COLONCOLON94);

            	    pushFollow(FOLLOW_propertySelector_in_leftHandSideExpression4386);
            	    ps=propertySelector();
            	    _fsp--;

            	    stream_propertySelector.add(ps.getTree());

            	    // AST REWRITE
            	    // elements: leftHandSideExpression, ps
            	    // token labels: 
            	    // rule labels: retval, ps
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_ps=new RewriteRuleSubtreeStream(adaptor,"token ps",ps!=null?ps.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1083:60: -> ^( LOCALNAME $leftHandSideExpression ( $ps)? )
            	    {
            	        // JS.g:1083:63: ^( LOCALNAME $leftHandSideExpression ( $ps)? )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(LOCALNAME, "LOCALNAME"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        // JS.g:1083:99: ( $ps)?
            	        if ( stream_ps.hasNext() ) {
            	            adaptor.addChild(root_1, stream_ps.next());

            	        }
            	        stream_ps.reset();

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException e) {
             reportRuleError(e); 
        }
        catch (RuntimeException e) {
             reportFailure(e); 
        }
        finally {
             popState(); 
        }
        return retval;
    }
    // $ANTLR end leftHandSideExpression

    public static class newExpressionTail_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start newExpressionTail
    // JS.g:1090:1: newExpressionTail : ( memberExpression -> memberExpression ) (lb1= LBRACK expression RBRACK -> ^( BYINDEX[$lb1] $newExpressionTail expression ) | DOT r= rightHandSideExpression -> ^( BYFIELD $newExpressionTail DOT ( $r)? ) | {...}? => DOTDOT r2= rightHandSideExpression2 -> ^( ALLCHILDREN $newExpressionTail $r2) | {...}? => COLONCOLON LBRACK expression RBRACK -> ^( LOCALNAME $newExpressionTail expression ) | {...}? => COLONCOLON ps= propertySelector -> ^( LOCALNAME $newExpressionTail ( $ps)? ) )* ( arguments -> ^( CALL $newExpressionTail arguments ) )? ;
    public final newExpressionTail_return newExpressionTail() throws RecognitionException {
        newExpressionTail_return retval = new newExpressionTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb1=null;
        Token RBRACK97=null;
        Token DOT98=null;
        Token DOTDOT99=null;
        Token COLONCOLON100=null;
        Token LBRACK101=null;
        Token RBRACK103=null;
        Token COLONCOLON104=null;
        rightHandSideExpression_return r = null;

        rightHandSideExpression2_return r2 = null;

        propertySelector_return ps = null;

        memberExpression_return memberExpression95 = null;

        expression_return expression96 = null;

        expression_return expression102 = null;

        arguments_return arguments105 = null;


        Object lb1_tree=null;
        Object RBRACK97_tree=null;
        Object DOT98_tree=null;
        Object DOTDOT99_tree=null;
        Object COLONCOLON100_tree=null;
        Object LBRACK101_tree=null;
        Object RBRACK103_tree=null;
        Object COLONCOLON104_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_COLONCOLON=new RewriteRuleTokenStream(adaptor,"token COLONCOLON");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_DOTDOT=new RewriteRuleTokenStream(adaptor,"token DOTDOT");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_memberExpression=new RewriteRuleSubtreeStream(adaptor,"rule memberExpression");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_rightHandSideExpression2=new RewriteRuleSubtreeStream(adaptor,"rule rightHandSideExpression2");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_rightHandSideExpression=new RewriteRuleSubtreeStream(adaptor,"rule rightHandSideExpression");
        RewriteRuleSubtreeStream stream_propertySelector=new RewriteRuleSubtreeStream(adaptor,"rule propertySelector");
        try {
            // JS.g:1091:3: ( ( memberExpression -> memberExpression ) (lb1= LBRACK expression RBRACK -> ^( BYINDEX[$lb1] $newExpressionTail expression ) | DOT r= rightHandSideExpression -> ^( BYFIELD $newExpressionTail DOT ( $r)? ) | {...}? => DOTDOT r2= rightHandSideExpression2 -> ^( ALLCHILDREN $newExpressionTail $r2) | {...}? => COLONCOLON LBRACK expression RBRACK -> ^( LOCALNAME $newExpressionTail expression ) | {...}? => COLONCOLON ps= propertySelector -> ^( LOCALNAME $newExpressionTail ( $ps)? ) )* ( arguments -> ^( CALL $newExpressionTail arguments ) )? )
            // JS.g:1092:3: ( memberExpression -> memberExpression ) (lb1= LBRACK expression RBRACK -> ^( BYINDEX[$lb1] $newExpressionTail expression ) | DOT r= rightHandSideExpression -> ^( BYFIELD $newExpressionTail DOT ( $r)? ) | {...}? => DOTDOT r2= rightHandSideExpression2 -> ^( ALLCHILDREN $newExpressionTail $r2) | {...}? => COLONCOLON LBRACK expression RBRACK -> ^( LOCALNAME $newExpressionTail expression ) | {...}? => COLONCOLON ps= propertySelector -> ^( LOCALNAME $newExpressionTail ( $ps)? ) )* ( arguments -> ^( CALL $newExpressionTail arguments ) )?
            {
            // JS.g:1092:3: ( memberExpression -> memberExpression )
            // JS.g:1093:5: memberExpression
            {
            pushFollow(FOLLOW_memberExpression_in_newExpressionTail4447);
            memberExpression95=memberExpression();
            _fsp--;

            stream_memberExpression.add(memberExpression95.getTree());

            // AST REWRITE
            // elements: memberExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1093:25: -> memberExpression
            {
                adaptor.addChild(root_0, stream_memberExpression.next());

            }



            }

            // JS.g:1095:3: (lb1= LBRACK expression RBRACK -> ^( BYINDEX[$lb1] $newExpressionTail expression ) | DOT r= rightHandSideExpression -> ^( BYFIELD $newExpressionTail DOT ( $r)? ) | {...}? => DOTDOT r2= rightHandSideExpression2 -> ^( ALLCHILDREN $newExpressionTail $r2) | {...}? => COLONCOLON LBRACK expression RBRACK -> ^( LOCALNAME $newExpressionTail expression ) | {...}? => COLONCOLON ps= propertySelector -> ^( LOCALNAME $newExpressionTail ( $ps)? ) )*
            loop23:
            do {
                int alt23=6;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==LBRACK) ) {
                    alt23=1;
                }
                else if ( (LA23_0==DOT) ) {
                    alt23=2;
                }
                else if ( (LA23_0==DOTDOT) && ( isXmlEnabled() )) {
                    int LA23_4 = input.LA(2);

                    if ( ( isXmlEnabled() ) ) {
                        alt23=3;
                    }


                }
                else if ( (LA23_0==COLONCOLON) && ( isXmlEnabled() )) {
                    int LA23_5 = input.LA(2);

                    if ( ( isXmlEnabled() ) ) {
                        alt23=4;
                    }
                    else if ( ( isXmlEnabled() ) ) {
                        alt23=5;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // JS.g:1096:5: lb1= LBRACK expression RBRACK
            	    {
            	    lb1=(Token)input.LT(1);
            	    match(input,LBRACK,FOLLOW_LBRACK_in_newExpressionTail4470); 
            	    stream_LBRACK.add(lb1);

            	    pushFollow(FOLLOW_expression_in_newExpressionTail4472);
            	    expression96=expression();
            	    _fsp--;

            	    stream_expression.add(expression96.getTree());
            	    RBRACK97=(Token)input.LT(1);
            	    match(input,RBRACK,FOLLOW_RBRACK_in_newExpressionTail4474); 
            	    stream_RBRACK.add(RBRACK97);


            	    // AST REWRITE
            	    // elements: newExpressionTail, expression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1096:35: -> ^( BYINDEX[$lb1] $newExpressionTail expression )
            	    {
            	        // JS.g:1096:38: ^( BYINDEX[$lb1] $newExpressionTail expression )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(BYINDEX, lb1), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_expression.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;
            	case 2 :
            	    // JS.g:1097:7: DOT r= rightHandSideExpression
            	    {
            	    DOT98=(Token)input.LT(1);
            	    match(input,DOT,FOLLOW_DOT_in_newExpressionTail4497); 
            	    stream_DOT.add(DOT98);

            	    pushFollow(FOLLOW_rightHandSideExpression_in_newExpressionTail4501);
            	    r=rightHandSideExpression();
            	    _fsp--;

            	    stream_rightHandSideExpression.add(r.getTree());

            	    // AST REWRITE
            	    // elements: DOT, newExpressionTail, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"token r",r!=null?r.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1097:37: -> ^( BYFIELD $newExpressionTail DOT ( $r)? )
            	    {
            	        // JS.g:1097:40: ^( BYFIELD $newExpressionTail DOT ( $r)? )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(BYFIELD, "BYFIELD"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_DOT.next());
            	        // JS.g:1097:74: ( $r)?
            	        if ( stream_r.hasNext() ) {
            	            adaptor.addChild(root_1, stream_r.next());

            	        }
            	        stream_r.reset();

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;
            	case 3 :
            	    // JS.g:1098:7: {...}? => DOTDOT r2= rightHandSideExpression2
            	    {
            	    if ( !( isXmlEnabled() ) ) {
            	        throw new FailedPredicateException(input, "newExpressionTail", " isXmlEnabled() ");
            	    }
            	    DOTDOT99=(Token)input.LT(1);
            	    match(input,DOTDOT,FOLLOW_DOTDOT_in_newExpressionTail4529); 
            	    stream_DOTDOT.add(DOTDOT99);

            	    pushFollow(FOLLOW_rightHandSideExpression2_in_newExpressionTail4533);
            	    r2=rightHandSideExpression2();
            	    _fsp--;

            	    stream_rightHandSideExpression2.add(r2.getTree());

            	    // AST REWRITE
            	    // elements: newExpressionTail, r2
            	    // token labels: 
            	    // rule labels: retval, r2
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r2=new RewriteRuleSubtreeStream(adaptor,"token r2",r2!=null?r2.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1098:64: -> ^( ALLCHILDREN $newExpressionTail $r2)
            	    {
            	        // JS.g:1098:67: ^( ALLCHILDREN $newExpressionTail $r2)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(ALLCHILDREN, "ALLCHILDREN"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_r2.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;
            	case 4 :
            	    // JS.g:1099:7: {...}? => COLONCOLON LBRACK expression RBRACK
            	    {
            	    if ( !( isXmlEnabled() ) ) {
            	        throw new FailedPredicateException(input, "newExpressionTail", " isXmlEnabled() ");
            	    }
            	    COLONCOLON100=(Token)input.LT(1);
            	    match(input,COLONCOLON,FOLLOW_COLONCOLON_in_newExpressionTail4556); 
            	    stream_COLONCOLON.add(COLONCOLON100);

            	    LBRACK101=(Token)input.LT(1);
            	    match(input,LBRACK,FOLLOW_LBRACK_in_newExpressionTail4558); 
            	    stream_LBRACK.add(LBRACK101);

            	    pushFollow(FOLLOW_expression_in_newExpressionTail4560);
            	    expression102=expression();
            	    _fsp--;

            	    stream_expression.add(expression102.getTree());
            	    RBRACK103=(Token)input.LT(1);
            	    match(input,RBRACK,FOLLOW_RBRACK_in_newExpressionTail4562); 
            	    stream_RBRACK.add(RBRACK103);


            	    // AST REWRITE
            	    // elements: expression, newExpressionTail
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1099:65: -> ^( LOCALNAME $newExpressionTail expression )
            	    {
            	        // JS.g:1099:68: ^( LOCALNAME $newExpressionTail expression )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(LOCALNAME, "LOCALNAME"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_expression.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;
            	case 5 :
            	    // JS.g:1100:7: {...}? => COLONCOLON ps= propertySelector
            	    {
            	    if ( !( isXmlEnabled() ) ) {
            	        throw new FailedPredicateException(input, "newExpressionTail", " isXmlEnabled() ");
            	    }
            	    COLONCOLON104=(Token)input.LT(1);
            	    match(input,COLONCOLON,FOLLOW_COLONCOLON_in_newExpressionTail4584); 
            	    stream_COLONCOLON.add(COLONCOLON104);

            	    pushFollow(FOLLOW_propertySelector_in_newExpressionTail4588);
            	    ps=propertySelector();
            	    _fsp--;

            	    stream_propertySelector.add(ps.getTree());

            	    // AST REWRITE
            	    // elements: newExpressionTail, ps
            	    // token labels: 
            	    // rule labels: retval, ps
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_ps=new RewriteRuleSubtreeStream(adaptor,"token ps",ps!=null?ps.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 1100:60: -> ^( LOCALNAME $newExpressionTail ( $ps)? )
            	    {
            	        // JS.g:1100:63: ^( LOCALNAME $newExpressionTail ( $ps)? )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(LOCALNAME, "LOCALNAME"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        // JS.g:1100:94: ( $ps)?
            	        if ( stream_ps.hasNext() ) {
            	            adaptor.addChild(root_1, stream_ps.next());

            	        }
            	        stream_ps.reset();

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }



            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // JS.g:1102:3: ( arguments -> ^( CALL $newExpressionTail arguments ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==LPAREN) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // JS.g:1103:5: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_newExpressionTail4616);
                    arguments105=arguments();
                    _fsp--;

                    stream_arguments.add(arguments105.getTree());

                    // AST REWRITE
                    // elements: arguments, newExpressionTail
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1103:19: -> ^( CALL $newExpressionTail arguments )
                    {
                        // JS.g:1103:22: ^( CALL $newExpressionTail arguments )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(CALL, "CALL"), root_1);

                        adaptor.addChild(root_1, stream_retval.next());
                        adaptor.addChild(root_1, stream_arguments.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end newExpressionTail

    public static class rightHandSideExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start rightHandSideExpression
    // JS.g:1107:1: rightHandSideExpression : ( identifier | word= reservedWord -> Identifier[word.start] | {...}? => parenExpression | {...}? => xmlAttribute | {...}? => MUL );
    public final rightHandSideExpression_return rightHandSideExpression() throws RecognitionException {
        rightHandSideExpression_return retval = new rightHandSideExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token MUL109=null;
        reservedWord_return word = null;

        identifier_return identifier106 = null;

        parenExpression_return parenExpression107 = null;

        xmlAttribute_return xmlAttribute108 = null;


        Object MUL109_tree=null;
        RewriteRuleSubtreeStream stream_reservedWord=new RewriteRuleSubtreeStream(adaptor,"rule reservedWord");
        try {
            // JS.g:1108:3: ( identifier | word= reservedWord -> Identifier[word.start] | {...}? => parenExpression | {...}? => xmlAttribute | {...}? => MUL )
            int alt25=5;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==WXML) ) {
                alt25=1;
            }
            else if ( (LA25_0==GET) ) {
                alt25=1;
            }
            else if ( (LA25_0==SET) ) {
                alt25=1;
            }
            else if ( (LA25_0==EACH) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=NAMESPACE && LA25_0<=CLASS)||(LA25_0>=DEBUGGER && LA25_0<=VOLATILE)||LA25_0==Identifier) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=BREAK && LA25_0<=FOR)||(LA25_0>=FUNCTION && LA25_0<=WITH)||LA25_0==YIELD) ) {
                alt25=2;
            }
            else if ( (LA25_0==LPAREN) && ( isXmlEnabled() )) {
                alt25=3;
            }
            else if ( (LA25_0==AT) && ( isXmlEnabled() )) {
                alt25=4;
            }
            else if ( (LA25_0==MUL) && ( isXmlEnabled() )) {
                alt25=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1107:1: rightHandSideExpression : ( identifier | word= reservedWord -> Identifier[word.start] | {...}? => parenExpression | {...}? => xmlAttribute | {...}? => MUL );", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // JS.g:1108:5: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_rightHandSideExpression4651);
                    identifier106=identifier();
                    _fsp--;

                    adaptor.addChild(root_0, identifier106.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1109:5: word= reservedWord
                    {
                    pushFollow(FOLLOW_reservedWord_in_rightHandSideExpression4659);
                    word=reservedWord();
                    _fsp--;

                    stream_reservedWord.add(word.getTree());

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1109:23: -> Identifier[word.start]
                    {
                        adaptor.addChild(root_0, adaptor.create(Identifier, word.start));

                    }



                    }
                    break;
                case 3 :
                    // JS.g:1110:5: {...}? => parenExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !( isXmlEnabled() ) ) {
                        throw new FailedPredicateException(input, "rightHandSideExpression", " isXmlEnabled() ");
                    }
                    pushFollow(FOLLOW_parenExpression_in_rightHandSideExpression4673);
                    parenExpression107=parenExpression();
                    _fsp--;

                    adaptor.addChild(root_0, parenExpression107.getTree());

                    }
                    break;
                case 4 :
                    // JS.g:1111:5: {...}? => xmlAttribute
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !( isXmlEnabled() ) ) {
                        throw new FailedPredicateException(input, "rightHandSideExpression", " isXmlEnabled() ");
                    }
                    pushFollow(FOLLOW_xmlAttribute_in_rightHandSideExpression4683);
                    xmlAttribute108=xmlAttribute();
                    _fsp--;

                    adaptor.addChild(root_0, xmlAttribute108.getTree());

                    }
                    break;
                case 5 :
                    // JS.g:1112:5: {...}? => MUL
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !( isXmlEnabled() ) ) {
                        throw new FailedPredicateException(input, "rightHandSideExpression", " isXmlEnabled() ");
                    }
                    MUL109=(Token)input.LT(1);
                    match(input,MUL,FOLLOW_MUL_in_rightHandSideExpression4692); 
                    MUL109_tree = (Object)adaptor.create(MUL109);
                    adaptor.addChild(root_0, MUL109_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end rightHandSideExpression

    public static class rightHandSideExpression2_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start rightHandSideExpression2
    // JS.g:1115:1: rightHandSideExpression2 : ( identifier | xmlAttribute | MUL );
    public final rightHandSideExpression2_return rightHandSideExpression2() throws RecognitionException {
        rightHandSideExpression2_return retval = new rightHandSideExpression2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token MUL112=null;
        identifier_return identifier110 = null;

        xmlAttribute_return xmlAttribute111 = null;


        Object MUL112_tree=null;

        try {
            // JS.g:1116:3: ( identifier | xmlAttribute | MUL )
            int alt26=3;
            switch ( input.LA(1) ) {
            case EACH:
            case GET:
            case SET:
            case WXML:
            case NAMESPACE:
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case DEBUGGER:
            case DOUBLE:
            case ENUM:
            case EXPORT:
            case EXTENDS:
            case FINAL:
            case FLOAT:
            case GOTO:
            case IMPLEMENTS:
            case IMPORT:
            case INT:
            case INTERFACE:
            case LONG:
            case NATIVE:
            case PACKAGE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case SHORT:
            case STATIC:
            case SUPER:
            case SYNCHRONIZED:
            case THROWS:
            case TRANSIENT:
            case VOLATILE:
            case Identifier:
                {
                alt26=1;
                }
                break;
            case AT:
                {
                alt26=2;
                }
                break;
            case MUL:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1115:1: rightHandSideExpression2 : ( identifier | xmlAttribute | MUL );", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // JS.g:1116:5: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_rightHandSideExpression24704);
                    identifier110=identifier();
                    _fsp--;

                    adaptor.addChild(root_0, identifier110.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1117:5: xmlAttribute
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_xmlAttribute_in_rightHandSideExpression24710);
                    xmlAttribute111=xmlAttribute();
                    _fsp--;

                    adaptor.addChild(root_0, xmlAttribute111.getTree());

                    }
                    break;
                case 3 :
                    // JS.g:1118:5: MUL
                    {
                    root_0 = (Object)adaptor.nil();

                    MUL112=(Token)input.LT(1);
                    match(input,MUL,FOLLOW_MUL_in_rightHandSideExpression24716); 
                    MUL112_tree = (Object)adaptor.create(MUL112);
                    adaptor.addChild(root_0, MUL112_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end rightHandSideExpression2

    public static class postfixExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start postfixExpression
    // JS.g:1131:1: postfixExpression : leftHandSideExpression ( postfixOperator )? ;
    public final postfixExpression_return postfixExpression() throws RecognitionException {
        postfixExpression_return retval = new postfixExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        leftHandSideExpression_return leftHandSideExpression113 = null;

        postfixOperator_return postfixOperator114 = null;



        try {
            // JS.g:1132:2: ( leftHandSideExpression ( postfixOperator )? )
            // JS.g:1132:4: leftHandSideExpression ( postfixOperator )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_leftHandSideExpression_in_postfixExpression4732);
            leftHandSideExpression113=leftHandSideExpression();
            _fsp--;

            adaptor.addChild(root_0, leftHandSideExpression113.getTree());
             if (input.LA(1) == INC || input.LA(1) == DEC) promoteEOL(null); 
            // JS.g:1132:95: ( postfixOperator )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=INC && LA27_0<=DEC)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // JS.g:1132:97: postfixOperator
                    {
                    pushFollow(FOLLOW_postfixOperator_in_postfixExpression4738);
                    postfixOperator114=postfixOperator();
                    _fsp--;

                    root_0 = (Object)adaptor.becomeRoot(postfixOperator114.getTree(), root_0);

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end postfixExpression

    public static class postfixOperator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start postfixOperator
    // JS.g:1135:1: postfixOperator : (op= INC | op= DEC );
    public final postfixOperator_return postfixOperator() throws RecognitionException {
        postfixOperator_return retval = new postfixOperator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;

        Object op_tree=null;

        try {
            // JS.g:1136:2: (op= INC | op= DEC )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==INC) ) {
                alt28=1;
            }
            else if ( (LA28_0==DEC) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1135:1: postfixOperator : (op= INC | op= DEC );", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // JS.g:1136:4: op= INC
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,INC,FOLLOW_INC_in_postfixOperator4756); 
                    op_tree = (Object)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(PINC); 

                    }
                    break;
                case 2 :
                    // JS.g:1137:4: op= DEC
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,DEC,FOLLOW_DEC_in_postfixOperator4765); 
                    op_tree = (Object)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(PDEC); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end postfixOperator

    public static class unaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpression
    // JS.g:1144:1: unaryExpression : ( postfixExpression | unaryOperator unaryExpression );
    public final unaryExpression_return unaryExpression() throws RecognitionException {
        unaryExpression_return retval = new unaryExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        postfixExpression_return postfixExpression115 = null;

        unaryOperator_return unaryOperator116 = null;

        unaryExpression_return unaryExpression117 = null;



        try {
            // JS.g:1145:2: ( postfixExpression | unaryOperator unaryExpression )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=NULL && LA29_0<=FALSE)||LA29_0==EACH||LA29_0==THIS||(LA29_0>=GET && LA29_0<=SET)||(LA29_0>=WXML && LA29_0<=CLASS)||(LA29_0>=DEBUGGER && LA29_0<=VOLATILE)||LA29_0==AT||LA29_0==StringLiteral||(LA29_0>=Identifier && LA29_0<=RegularExpressionLiteral)||(LA29_0>=DecimalLiteral && LA29_0<=HexIntegerLiteral)) ) {
                alt29=1;
            }
            else if ( ((LA29_0>=XMLFragment && LA29_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt29=1;
            }
            else if ( (LA29_0==FUNCTION||LA29_0==NEW||LA29_0==LBRACE||LA29_0==LPAREN||LA29_0==LBRACK) ) {
                alt29=1;
            }
            else if ( (LA29_0==DELETE||LA29_0==TYPEOF||LA29_0==VOID||LA29_0==YIELD||(LA29_0>=ADD && LA29_0<=SUB)||(LA29_0>=INC && LA29_0<=DEC)||(LA29_0>=NOT && LA29_0<=INV)) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1144:1: unaryExpression : ( postfixExpression | unaryOperator unaryExpression );", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // JS.g:1145:4: postfixExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_postfixExpression_in_unaryExpression4782);
                    postfixExpression115=postfixExpression();
                    _fsp--;

                    adaptor.addChild(root_0, postfixExpression115.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1146:4: unaryOperator unaryExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unaryOperator_in_unaryExpression4787);
                    unaryOperator116=unaryOperator();
                    _fsp--;

                    root_0 = (Object)adaptor.becomeRoot(unaryOperator116.getTree(), root_0);
                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression4790);
                    unaryExpression117=unaryExpression();
                    _fsp--;

                    adaptor.addChild(root_0, unaryExpression117.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end unaryExpression

    public static class unaryOperator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryOperator
    // JS.g:1149:1: unaryOperator : ( DELETE | VOID | TYPEOF | INC | DEC | op= ADD | op= SUB | INV | NOT | YIELD );
    public final unaryOperator_return unaryOperator() throws RecognitionException {
        unaryOperator_return retval = new unaryOperator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token DELETE118=null;
        Token VOID119=null;
        Token TYPEOF120=null;
        Token INC121=null;
        Token DEC122=null;
        Token INV123=null;
        Token NOT124=null;
        Token YIELD125=null;

        Object op_tree=null;
        Object DELETE118_tree=null;
        Object VOID119_tree=null;
        Object TYPEOF120_tree=null;
        Object INC121_tree=null;
        Object DEC122_tree=null;
        Object INV123_tree=null;
        Object NOT124_tree=null;
        Object YIELD125_tree=null;

        try {
            // JS.g:1150:2: ( DELETE | VOID | TYPEOF | INC | DEC | op= ADD | op= SUB | INV | NOT | YIELD )
            int alt30=10;
            switch ( input.LA(1) ) {
            case DELETE:
                {
                alt30=1;
                }
                break;
            case VOID:
                {
                alt30=2;
                }
                break;
            case TYPEOF:
                {
                alt30=3;
                }
                break;
            case INC:
                {
                alt30=4;
                }
                break;
            case DEC:
                {
                alt30=5;
                }
                break;
            case ADD:
                {
                alt30=6;
                }
                break;
            case SUB:
                {
                alt30=7;
                }
                break;
            case INV:
                {
                alt30=8;
                }
                break;
            case NOT:
                {
                alt30=9;
                }
                break;
            case YIELD:
                {
                alt30=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1149:1: unaryOperator : ( DELETE | VOID | TYPEOF | INC | DEC | op= ADD | op= SUB | INV | NOT | YIELD );", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // JS.g:1150:4: DELETE
                    {
                    root_0 = (Object)adaptor.nil();

                    DELETE118=(Token)input.LT(1);
                    match(input,DELETE,FOLLOW_DELETE_in_unaryOperator4802); 
                    DELETE118_tree = (Object)adaptor.create(DELETE118);
                    adaptor.addChild(root_0, DELETE118_tree);


                    }
                    break;
                case 2 :
                    // JS.g:1151:4: VOID
                    {
                    root_0 = (Object)adaptor.nil();

                    VOID119=(Token)input.LT(1);
                    match(input,VOID,FOLLOW_VOID_in_unaryOperator4807); 
                    VOID119_tree = (Object)adaptor.create(VOID119);
                    adaptor.addChild(root_0, VOID119_tree);


                    }
                    break;
                case 3 :
                    // JS.g:1152:4: TYPEOF
                    {
                    root_0 = (Object)adaptor.nil();

                    TYPEOF120=(Token)input.LT(1);
                    match(input,TYPEOF,FOLLOW_TYPEOF_in_unaryOperator4812); 
                    TYPEOF120_tree = (Object)adaptor.create(TYPEOF120);
                    adaptor.addChild(root_0, TYPEOF120_tree);


                    }
                    break;
                case 4 :
                    // JS.g:1153:4: INC
                    {
                    root_0 = (Object)adaptor.nil();

                    INC121=(Token)input.LT(1);
                    match(input,INC,FOLLOW_INC_in_unaryOperator4817); 
                    INC121_tree = (Object)adaptor.create(INC121);
                    adaptor.addChild(root_0, INC121_tree);


                    }
                    break;
                case 5 :
                    // JS.g:1154:4: DEC
                    {
                    root_0 = (Object)adaptor.nil();

                    DEC122=(Token)input.LT(1);
                    match(input,DEC,FOLLOW_DEC_in_unaryOperator4822); 
                    DEC122_tree = (Object)adaptor.create(DEC122);
                    adaptor.addChild(root_0, DEC122_tree);


                    }
                    break;
                case 6 :
                    // JS.g:1155:4: op= ADD
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,ADD,FOLLOW_ADD_in_unaryOperator4829); 
                    op_tree = (Object)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(POS); 

                    }
                    break;
                case 7 :
                    // JS.g:1156:4: op= SUB
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,SUB,FOLLOW_SUB_in_unaryOperator4838); 
                    op_tree = (Object)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(NEG); 

                    }
                    break;
                case 8 :
                    // JS.g:1157:4: INV
                    {
                    root_0 = (Object)adaptor.nil();

                    INV123=(Token)input.LT(1);
                    match(input,INV,FOLLOW_INV_in_unaryOperator4845); 
                    INV123_tree = (Object)adaptor.create(INV123);
                    adaptor.addChild(root_0, INV123_tree);


                    }
                    break;
                case 9 :
                    // JS.g:1158:4: NOT
                    {
                    root_0 = (Object)adaptor.nil();

                    NOT124=(Token)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_unaryOperator4850); 
                    NOT124_tree = (Object)adaptor.create(NOT124);
                    adaptor.addChild(root_0, NOT124_tree);


                    }
                    break;
                case 10 :
                    // JS.g:1159:4: YIELD
                    {
                    root_0 = (Object)adaptor.nil();

                    YIELD125=(Token)input.LT(1);
                    match(input,YIELD,FOLLOW_YIELD_in_unaryOperator4855); 
                    YIELD125_tree = (Object)adaptor.create(YIELD125);
                    adaptor.addChild(root_0, YIELD125_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end unaryOperator

    public static class namespaceStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start namespaceStatement
    // JS.g:1164:1: namespaceStatement : {...}? => DEFAULT WXML NAMESPACE ASSIGN expression semic -> ^( DEFAULT_XML_NAMESPACE DEFAULT WXML ASSIGN expression ) ;
    public final namespaceStatement_return namespaceStatement() throws RecognitionException {
        namespaceStatement_return retval = new namespaceStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DEFAULT126=null;
        Token WXML127=null;
        Token NAMESPACE128=null;
        Token ASSIGN129=null;
        expression_return expression130 = null;

        semic_return semic131 = null;


        Object DEFAULT126_tree=null;
        Object WXML127_tree=null;
        Object NAMESPACE128_tree=null;
        Object ASSIGN129_tree=null;
        RewriteRuleTokenStream stream_WXML=new RewriteRuleTokenStream(adaptor,"token WXML");
        RewriteRuleTokenStream stream_NAMESPACE=new RewriteRuleTokenStream(adaptor,"token NAMESPACE");
        RewriteRuleTokenStream stream_DEFAULT=new RewriteRuleTokenStream(adaptor,"token DEFAULT");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_semic=new RewriteRuleSubtreeStream(adaptor,"rule semic");
        try {
            // JS.g:1165:3: ({...}? => DEFAULT WXML NAMESPACE ASSIGN expression semic -> ^( DEFAULT_XML_NAMESPACE DEFAULT WXML ASSIGN expression ) )
            // JS.g:1165:5: {...}? => DEFAULT WXML NAMESPACE ASSIGN expression semic
            {
            if ( !( isXmlEnabled() ) ) {
                throw new FailedPredicateException(input, "namespaceStatement", " isXmlEnabled() ");
            }
            DEFAULT126=(Token)input.LT(1);
            match(input,DEFAULT,FOLLOW_DEFAULT_in_namespaceStatement4872); 
            stream_DEFAULT.add(DEFAULT126);

            WXML127=(Token)input.LT(1);
            match(input,WXML,FOLLOW_WXML_in_namespaceStatement4874); 
            stream_WXML.add(WXML127);

            NAMESPACE128=(Token)input.LT(1);
            match(input,NAMESPACE,FOLLOW_NAMESPACE_in_namespaceStatement4876); 
            stream_NAMESPACE.add(NAMESPACE128);

            ASSIGN129=(Token)input.LT(1);
            match(input,ASSIGN,FOLLOW_ASSIGN_in_namespaceStatement4878); 
            stream_ASSIGN.add(ASSIGN129);

            pushFollow(FOLLOW_expression_in_namespaceStatement4880);
            expression130=expression();
            _fsp--;

            stream_expression.add(expression130.getTree());
            pushFollow(FOLLOW_semic_in_namespaceStatement4882);
            semic131=semic();
            _fsp--;

            stream_semic.add(semic131.getTree());

            // AST REWRITE
            // elements: WXML, DEFAULT, expression, ASSIGN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1166:5: -> ^( DEFAULT_XML_NAMESPACE DEFAULT WXML ASSIGN expression )
            {
                // JS.g:1166:8: ^( DEFAULT_XML_NAMESPACE DEFAULT WXML ASSIGN expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(DEFAULT_XML_NAMESPACE, "DEFAULT_XML_NAMESPACE"), root_1);

                adaptor.addChild(root_1, stream_DEFAULT.next());
                adaptor.addChild(root_1, stream_WXML.next());
                adaptor.addChild(root_1, stream_ASSIGN.next());
                adaptor.addChild(root_1, stream_expression.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end namespaceStatement

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpression
    // JS.g:1171:1: multiplicativeExpression : unaryExpression ( ( MUL | DIV | MOD ) unaryExpression )* ;
    public final multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        multiplicativeExpression_return retval = new multiplicativeExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set133=null;
        unaryExpression_return unaryExpression132 = null;

        unaryExpression_return unaryExpression134 = null;


        Object set133_tree=null;

        try {
            // JS.g:1172:2: ( unaryExpression ( ( MUL | DIV | MOD ) unaryExpression )* )
            // JS.g:1172:4: unaryExpression ( ( MUL | DIV | MOD ) unaryExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression4914);
            unaryExpression132=unaryExpression();
            _fsp--;

            adaptor.addChild(root_0, unaryExpression132.getTree());
            // JS.g:1172:20: ( ( MUL | DIV | MOD ) unaryExpression )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=MUL && LA31_0<=MOD)||LA31_0==DIV) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // JS.g:1172:22: ( MUL | DIV | MOD ) unaryExpression
            	    {
            	    set133=(Token)input.LT(1);
            	    if ( (input.LA(1)>=MUL && input.LA(1)<=MOD)||input.LA(1)==DIV ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set133), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_multiplicativeExpression4918);    throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression4933);
            	    unaryExpression134=unaryExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, unaryExpression134.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end multiplicativeExpression

    public static class additiveExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpression
    // JS.g:1179:1: additiveExpression : multiplicativeExpression ( ( ADD | SUB ) multiplicativeExpression )* ;
    public final additiveExpression_return additiveExpression() throws RecognitionException {
        additiveExpression_return retval = new additiveExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set136=null;
        multiplicativeExpression_return multiplicativeExpression135 = null;

        multiplicativeExpression_return multiplicativeExpression137 = null;


        Object set136_tree=null;

        try {
            // JS.g:1180:2: ( multiplicativeExpression ( ( ADD | SUB ) multiplicativeExpression )* )
            // JS.g:1180:4: multiplicativeExpression ( ( ADD | SUB ) multiplicativeExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression4951);
            multiplicativeExpression135=multiplicativeExpression();
            _fsp--;

            adaptor.addChild(root_0, multiplicativeExpression135.getTree());
            // JS.g:1180:29: ( ( ADD | SUB ) multiplicativeExpression )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=ADD && LA32_0<=SUB)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // JS.g:1180:31: ( ADD | SUB ) multiplicativeExpression
            	    {
            	    set136=(Token)input.LT(1);
            	    if ( (input.LA(1)>=ADD && input.LA(1)<=SUB) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set136), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_additiveExpression4955);    throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression4966);
            	    multiplicativeExpression137=multiplicativeExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, multiplicativeExpression137.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end additiveExpression

    public static class shiftExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start shiftExpression
    // JS.g:1187:1: shiftExpression : additiveExpression ( ( SHL | SHR | SHU ) additiveExpression )* ;
    public final shiftExpression_return shiftExpression() throws RecognitionException {
        shiftExpression_return retval = new shiftExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set139=null;
        additiveExpression_return additiveExpression138 = null;

        additiveExpression_return additiveExpression140 = null;


        Object set139_tree=null;

        try {
            // JS.g:1188:2: ( additiveExpression ( ( SHL | SHR | SHU ) additiveExpression )* )
            // JS.g:1188:4: additiveExpression ( ( SHL | SHR | SHU ) additiveExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_shiftExpression4985);
            additiveExpression138=additiveExpression();
            _fsp--;

            adaptor.addChild(root_0, additiveExpression138.getTree());
            // JS.g:1188:23: ( ( SHL | SHR | SHU ) additiveExpression )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=SHL && LA33_0<=SHU)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // JS.g:1188:25: ( SHL | SHR | SHU ) additiveExpression
            	    {
            	    set139=(Token)input.LT(1);
            	    if ( (input.LA(1)>=SHL && input.LA(1)<=SHU) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set139), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_shiftExpression4989);    throw mse;
            	    }

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression5004);
            	    additiveExpression140=additiveExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, additiveExpression140.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end shiftExpression

    public static class relationalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relationalExpression
    // JS.g:1195:1: relationalExpression : shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )* ;
    public final relationalExpression_return relationalExpression() throws RecognitionException {
        relationalExpression_return retval = new relationalExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set142=null;
        shiftExpression_return shiftExpression141 = null;

        shiftExpression_return shiftExpression143 = null;


        Object set142_tree=null;

        try {
            // JS.g:1196:2: ( shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )* )
            // JS.g:1196:4: shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_shiftExpression_in_relationalExpression5023);
            shiftExpression141=shiftExpression();
            _fsp--;

            adaptor.addChild(root_0, shiftExpression141.getTree());
            // JS.g:1196:20: ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=IN && LA34_0<=INSTANCEOF)||(LA34_0>=LT && LA34_0<=GTE)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // JS.g:1196:22: ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression
            	    {
            	    set142=(Token)input.LT(1);
            	    if ( (input.LA(1)>=IN && input.LA(1)<=INSTANCEOF)||(input.LA(1)>=LT && input.LA(1)<=GTE) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set142), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_relationalExpression5027);    throw mse;
            	    }

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression5054);
            	    shiftExpression143=shiftExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, shiftExpression143.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end relationalExpression

    public static class relationalExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relationalExpressionNoIn
    // JS.g:1199:1: relationalExpressionNoIn : shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )* ;
    public final relationalExpressionNoIn_return relationalExpressionNoIn() throws RecognitionException {
        relationalExpressionNoIn_return retval = new relationalExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set145=null;
        shiftExpression_return shiftExpression144 = null;

        shiftExpression_return shiftExpression146 = null;


        Object set145_tree=null;

        try {
            // JS.g:1200:2: ( shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )* )
            // JS.g:1200:4: shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_shiftExpression_in_relationalExpressionNoIn5068);
            shiftExpression144=shiftExpression();
            _fsp--;

            adaptor.addChild(root_0, shiftExpression144.getTree());
            // JS.g:1200:20: ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==INSTANCEOF||(LA35_0>=LT && LA35_0<=GTE)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // JS.g:1200:22: ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression
            	    {
            	    set145=(Token)input.LT(1);
            	    if ( input.LA(1)==INSTANCEOF||(input.LA(1)>=LT && input.LA(1)<=GTE) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set145), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_relationalExpressionNoIn5072);    throw mse;
            	    }

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpressionNoIn5095);
            	    shiftExpression146=shiftExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, shiftExpression146.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end relationalExpressionNoIn

    public static class equalityExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start equalityExpression
    // JS.g:1207:1: equalityExpression : relationalExpression ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )* ;
    public final equalityExpression_return equalityExpression() throws RecognitionException {
        equalityExpression_return retval = new equalityExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set148=null;
        relationalExpression_return relationalExpression147 = null;

        relationalExpression_return relationalExpression149 = null;


        Object set148_tree=null;

        try {
            // JS.g:1208:2: ( relationalExpression ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )* )
            // JS.g:1208:4: relationalExpression ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_equalityExpression5114);
            relationalExpression147=relationalExpression();
            _fsp--;

            adaptor.addChild(root_0, relationalExpression147.getTree());
            // JS.g:1208:25: ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=EQ && LA36_0<=NSAME)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // JS.g:1208:27: ( EQ | NEQ | SAME | NSAME ) relationalExpression
            	    {
            	    set148=(Token)input.LT(1);
            	    if ( (input.LA(1)>=EQ && input.LA(1)<=NSAME) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set148), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_equalityExpression5118);    throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression5137);
            	    relationalExpression149=relationalExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, relationalExpression149.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end equalityExpression

    public static class equalityExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start equalityExpressionNoIn
    // JS.g:1211:1: equalityExpressionNoIn : relationalExpressionNoIn ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )* ;
    public final equalityExpressionNoIn_return equalityExpressionNoIn() throws RecognitionException {
        equalityExpressionNoIn_return retval = new equalityExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set151=null;
        relationalExpressionNoIn_return relationalExpressionNoIn150 = null;

        relationalExpressionNoIn_return relationalExpressionNoIn152 = null;


        Object set151_tree=null;

        try {
            // JS.g:1212:2: ( relationalExpressionNoIn ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )* )
            // JS.g:1212:4: relationalExpressionNoIn ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn5151);
            relationalExpressionNoIn150=relationalExpressionNoIn();
            _fsp--;

            adaptor.addChild(root_0, relationalExpressionNoIn150.getTree());
            // JS.g:1212:29: ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=EQ && LA37_0<=NSAME)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // JS.g:1212:31: ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn
            	    {
            	    set151=(Token)input.LT(1);
            	    if ( (input.LA(1)>=EQ && input.LA(1)<=NSAME) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot(adaptor.create(set151), root_0);
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_equalityExpressionNoIn5155);    throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn5174);
            	    relationalExpressionNoIn152=relationalExpressionNoIn();
            	    _fsp--;

            	    adaptor.addChild(root_0, relationalExpressionNoIn152.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end equalityExpressionNoIn

    public static class bitwiseANDExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseANDExpression
    // JS.g:1219:1: bitwiseANDExpression : equalityExpression ( AND equalityExpression )* ;
    public final bitwiseANDExpression_return bitwiseANDExpression() throws RecognitionException {
        bitwiseANDExpression_return retval = new bitwiseANDExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND154=null;
        equalityExpression_return equalityExpression153 = null;

        equalityExpression_return equalityExpression155 = null;


        Object AND154_tree=null;

        try {
            // JS.g:1220:2: ( equalityExpression ( AND equalityExpression )* )
            // JS.g:1220:4: equalityExpression ( AND equalityExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalityExpression_in_bitwiseANDExpression5194);
            equalityExpression153=equalityExpression();
            _fsp--;

            adaptor.addChild(root_0, equalityExpression153.getTree());
            // JS.g:1220:23: ( AND equalityExpression )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==AND) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // JS.g:1220:25: AND equalityExpression
            	    {
            	    AND154=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_bitwiseANDExpression5198); 
            	    AND154_tree = (Object)adaptor.create(AND154);
            	    root_0 = (Object)adaptor.becomeRoot(AND154_tree, root_0);

            	    pushFollow(FOLLOW_equalityExpression_in_bitwiseANDExpression5201);
            	    equalityExpression155=equalityExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, equalityExpression155.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end bitwiseANDExpression

    public static class bitwiseANDExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseANDExpressionNoIn
    // JS.g:1223:1: bitwiseANDExpressionNoIn : equalityExpressionNoIn ( AND equalityExpressionNoIn )* ;
    public final bitwiseANDExpressionNoIn_return bitwiseANDExpressionNoIn() throws RecognitionException {
        bitwiseANDExpressionNoIn_return retval = new bitwiseANDExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND157=null;
        equalityExpressionNoIn_return equalityExpressionNoIn156 = null;

        equalityExpressionNoIn_return equalityExpressionNoIn158 = null;


        Object AND157_tree=null;

        try {
            // JS.g:1224:2: ( equalityExpressionNoIn ( AND equalityExpressionNoIn )* )
            // JS.g:1224:4: equalityExpressionNoIn ( AND equalityExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn5215);
            equalityExpressionNoIn156=equalityExpressionNoIn();
            _fsp--;

            adaptor.addChild(root_0, equalityExpressionNoIn156.getTree());
            // JS.g:1224:27: ( AND equalityExpressionNoIn )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==AND) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // JS.g:1224:29: AND equalityExpressionNoIn
            	    {
            	    AND157=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_bitwiseANDExpressionNoIn5219); 
            	    AND157_tree = (Object)adaptor.create(AND157);
            	    root_0 = (Object)adaptor.becomeRoot(AND157_tree, root_0);

            	    pushFollow(FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn5222);
            	    equalityExpressionNoIn158=equalityExpressionNoIn();
            	    _fsp--;

            	    adaptor.addChild(root_0, equalityExpressionNoIn158.getTree());

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end bitwiseANDExpressionNoIn

    public static class bitwiseXORExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseXORExpression
    // JS.g:1227:1: bitwiseXORExpression : bitwiseANDExpression ( XOR bitwiseANDExpression )* ;
    public final bitwiseXORExpression_return bitwiseXORExpression() throws RecognitionException {
        bitwiseXORExpression_return retval = new bitwiseXORExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token XOR160=null;
        bitwiseANDExpression_return bitwiseANDExpression159 = null;

        bitwiseANDExpression_return bitwiseANDExpression161 = null;


        Object XOR160_tree=null;

        try {
            // JS.g:1228:2: ( bitwiseANDExpression ( XOR bitwiseANDExpression )* )
            // JS.g:1228:4: bitwiseANDExpression ( XOR bitwiseANDExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression5238);
            bitwiseANDExpression159=bitwiseANDExpression();
            _fsp--;

            adaptor.addChild(root_0, bitwiseANDExpression159.getTree());
            // JS.g:1228:25: ( XOR bitwiseANDExpression )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==XOR) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // JS.g:1228:27: XOR bitwiseANDExpression
            	    {
            	    XOR160=(Token)input.LT(1);
            	    match(input,XOR,FOLLOW_XOR_in_bitwiseXORExpression5242); 
            	    XOR160_tree = (Object)adaptor.create(XOR160);
            	    root_0 = (Object)adaptor.becomeRoot(XOR160_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression5245);
            	    bitwiseANDExpression161=bitwiseANDExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, bitwiseANDExpression161.getTree());

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end bitwiseXORExpression

    public static class bitwiseXORExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseXORExpressionNoIn
    // JS.g:1231:1: bitwiseXORExpressionNoIn : bitwiseANDExpressionNoIn ( XOR bitwiseANDExpressionNoIn )* ;
    public final bitwiseXORExpressionNoIn_return bitwiseXORExpressionNoIn() throws RecognitionException {
        bitwiseXORExpressionNoIn_return retval = new bitwiseXORExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token XOR163=null;
        bitwiseANDExpressionNoIn_return bitwiseANDExpressionNoIn162 = null;

        bitwiseANDExpressionNoIn_return bitwiseANDExpressionNoIn164 = null;


        Object XOR163_tree=null;

        try {
            // JS.g:1232:2: ( bitwiseANDExpressionNoIn ( XOR bitwiseANDExpressionNoIn )* )
            // JS.g:1232:4: bitwiseANDExpressionNoIn ( XOR bitwiseANDExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn5261);
            bitwiseANDExpressionNoIn162=bitwiseANDExpressionNoIn();
            _fsp--;

            adaptor.addChild(root_0, bitwiseANDExpressionNoIn162.getTree());
            // JS.g:1232:29: ( XOR bitwiseANDExpressionNoIn )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==XOR) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // JS.g:1232:31: XOR bitwiseANDExpressionNoIn
            	    {
            	    XOR163=(Token)input.LT(1);
            	    match(input,XOR,FOLLOW_XOR_in_bitwiseXORExpressionNoIn5265); 
            	    XOR163_tree = (Object)adaptor.create(XOR163);
            	    root_0 = (Object)adaptor.becomeRoot(XOR163_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn5268);
            	    bitwiseANDExpressionNoIn164=bitwiseANDExpressionNoIn();
            	    _fsp--;

            	    adaptor.addChild(root_0, bitwiseANDExpressionNoIn164.getTree());

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end bitwiseXORExpressionNoIn

    public static class bitwiseORExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseORExpression
    // JS.g:1235:1: bitwiseORExpression : bitwiseXORExpression ( OR bitwiseXORExpression )* ;
    public final bitwiseORExpression_return bitwiseORExpression() throws RecognitionException {
        bitwiseORExpression_return retval = new bitwiseORExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR166=null;
        bitwiseXORExpression_return bitwiseXORExpression165 = null;

        bitwiseXORExpression_return bitwiseXORExpression167 = null;


        Object OR166_tree=null;

        try {
            // JS.g:1236:2: ( bitwiseXORExpression ( OR bitwiseXORExpression )* )
            // JS.g:1236:4: bitwiseXORExpression ( OR bitwiseXORExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseXORExpression_in_bitwiseORExpression5283);
            bitwiseXORExpression165=bitwiseXORExpression();
            _fsp--;

            adaptor.addChild(root_0, bitwiseXORExpression165.getTree());
            // JS.g:1236:25: ( OR bitwiseXORExpression )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==OR) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // JS.g:1236:27: OR bitwiseXORExpression
            	    {
            	    OR166=(Token)input.LT(1);
            	    match(input,OR,FOLLOW_OR_in_bitwiseORExpression5287); 
            	    OR166_tree = (Object)adaptor.create(OR166);
            	    root_0 = (Object)adaptor.becomeRoot(OR166_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseXORExpression_in_bitwiseORExpression5290);
            	    bitwiseXORExpression167=bitwiseXORExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, bitwiseXORExpression167.getTree());

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end bitwiseORExpression

    public static class bitwiseORExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitwiseORExpressionNoIn
    // JS.g:1239:1: bitwiseORExpressionNoIn : bitwiseXORExpressionNoIn ( OR bitwiseXORExpressionNoIn )* ;
    public final bitwiseORExpressionNoIn_return bitwiseORExpressionNoIn() throws RecognitionException {
        bitwiseORExpressionNoIn_return retval = new bitwiseORExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR169=null;
        bitwiseXORExpressionNoIn_return bitwiseXORExpressionNoIn168 = null;

        bitwiseXORExpressionNoIn_return bitwiseXORExpressionNoIn170 = null;


        Object OR169_tree=null;

        try {
            // JS.g:1240:2: ( bitwiseXORExpressionNoIn ( OR bitwiseXORExpressionNoIn )* )
            // JS.g:1240:4: bitwiseXORExpressionNoIn ( OR bitwiseXORExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn5305);
            bitwiseXORExpressionNoIn168=bitwiseXORExpressionNoIn();
            _fsp--;

            adaptor.addChild(root_0, bitwiseXORExpressionNoIn168.getTree());
            // JS.g:1240:29: ( OR bitwiseXORExpressionNoIn )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==OR) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // JS.g:1240:31: OR bitwiseXORExpressionNoIn
            	    {
            	    OR169=(Token)input.LT(1);
            	    match(input,OR,FOLLOW_OR_in_bitwiseORExpressionNoIn5309); 
            	    OR169_tree = (Object)adaptor.create(OR169);
            	    root_0 = (Object)adaptor.becomeRoot(OR169_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn5312);
            	    bitwiseXORExpressionNoIn170=bitwiseXORExpressionNoIn();
            	    _fsp--;

            	    adaptor.addChild(root_0, bitwiseXORExpressionNoIn170.getTree());

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end bitwiseORExpressionNoIn

    public static class logicalANDExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start logicalANDExpression
    // JS.g:1247:1: logicalANDExpression : bitwiseORExpression ( LAND bitwiseORExpression )* ;
    public final logicalANDExpression_return logicalANDExpression() throws RecognitionException {
        logicalANDExpression_return retval = new logicalANDExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LAND172=null;
        bitwiseORExpression_return bitwiseORExpression171 = null;

        bitwiseORExpression_return bitwiseORExpression173 = null;


        Object LAND172_tree=null;

        try {
            // JS.g:1248:2: ( bitwiseORExpression ( LAND bitwiseORExpression )* )
            // JS.g:1248:4: bitwiseORExpression ( LAND bitwiseORExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseORExpression_in_logicalANDExpression5331);
            bitwiseORExpression171=bitwiseORExpression();
            _fsp--;

            adaptor.addChild(root_0, bitwiseORExpression171.getTree());
            // JS.g:1248:24: ( LAND bitwiseORExpression )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==LAND) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // JS.g:1248:26: LAND bitwiseORExpression
            	    {
            	    LAND172=(Token)input.LT(1);
            	    match(input,LAND,FOLLOW_LAND_in_logicalANDExpression5335); 
            	    LAND172_tree = (Object)adaptor.create(LAND172);
            	    root_0 = (Object)adaptor.becomeRoot(LAND172_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseORExpression_in_logicalANDExpression5338);
            	    bitwiseORExpression173=bitwiseORExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, bitwiseORExpression173.getTree());

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end logicalANDExpression

    public static class logicalANDExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start logicalANDExpressionNoIn
    // JS.g:1251:1: logicalANDExpressionNoIn : bitwiseORExpressionNoIn ( LAND bitwiseORExpressionNoIn )* ;
    public final logicalANDExpressionNoIn_return logicalANDExpressionNoIn() throws RecognitionException {
        logicalANDExpressionNoIn_return retval = new logicalANDExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LAND175=null;
        bitwiseORExpressionNoIn_return bitwiseORExpressionNoIn174 = null;

        bitwiseORExpressionNoIn_return bitwiseORExpressionNoIn176 = null;


        Object LAND175_tree=null;

        try {
            // JS.g:1252:2: ( bitwiseORExpressionNoIn ( LAND bitwiseORExpressionNoIn )* )
            // JS.g:1252:4: bitwiseORExpressionNoIn ( LAND bitwiseORExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn5352);
            bitwiseORExpressionNoIn174=bitwiseORExpressionNoIn();
            _fsp--;

            adaptor.addChild(root_0, bitwiseORExpressionNoIn174.getTree());
            // JS.g:1252:28: ( LAND bitwiseORExpressionNoIn )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==LAND) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // JS.g:1252:30: LAND bitwiseORExpressionNoIn
            	    {
            	    LAND175=(Token)input.LT(1);
            	    match(input,LAND,FOLLOW_LAND_in_logicalANDExpressionNoIn5356); 
            	    LAND175_tree = (Object)adaptor.create(LAND175);
            	    root_0 = (Object)adaptor.becomeRoot(LAND175_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn5359);
            	    bitwiseORExpressionNoIn176=bitwiseORExpressionNoIn();
            	    _fsp--;

            	    adaptor.addChild(root_0, bitwiseORExpressionNoIn176.getTree());

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end logicalANDExpressionNoIn

    public static class logicalORExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start logicalORExpression
    // JS.g:1255:1: logicalORExpression : logicalANDExpression ( LOR logicalANDExpression )* ;
    public final logicalORExpression_return logicalORExpression() throws RecognitionException {
        logicalORExpression_return retval = new logicalORExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOR178=null;
        logicalANDExpression_return logicalANDExpression177 = null;

        logicalANDExpression_return logicalANDExpression179 = null;


        Object LOR178_tree=null;

        try {
            // JS.g:1256:2: ( logicalANDExpression ( LOR logicalANDExpression )* )
            // JS.g:1256:4: logicalANDExpression ( LOR logicalANDExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalANDExpression_in_logicalORExpression5374);
            logicalANDExpression177=logicalANDExpression();
            _fsp--;

            adaptor.addChild(root_0, logicalANDExpression177.getTree());
            // JS.g:1256:25: ( LOR logicalANDExpression )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==LOR) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // JS.g:1256:27: LOR logicalANDExpression
            	    {
            	    LOR178=(Token)input.LT(1);
            	    match(input,LOR,FOLLOW_LOR_in_logicalORExpression5378); 
            	    LOR178_tree = (Object)adaptor.create(LOR178);
            	    root_0 = (Object)adaptor.becomeRoot(LOR178_tree, root_0);

            	    pushFollow(FOLLOW_logicalANDExpression_in_logicalORExpression5381);
            	    logicalANDExpression179=logicalANDExpression();
            	    _fsp--;

            	    adaptor.addChild(root_0, logicalANDExpression179.getTree());

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end logicalORExpression

    public static class logicalORExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start logicalORExpressionNoIn
    // JS.g:1259:1: logicalORExpressionNoIn : logicalANDExpressionNoIn ( LOR logicalANDExpressionNoIn )* ;
    public final logicalORExpressionNoIn_return logicalORExpressionNoIn() throws RecognitionException {
        logicalORExpressionNoIn_return retval = new logicalORExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOR181=null;
        logicalANDExpressionNoIn_return logicalANDExpressionNoIn180 = null;

        logicalANDExpressionNoIn_return logicalANDExpressionNoIn182 = null;


        Object LOR181_tree=null;

        try {
            // JS.g:1260:2: ( logicalANDExpressionNoIn ( LOR logicalANDExpressionNoIn )* )
            // JS.g:1260:4: logicalANDExpressionNoIn ( LOR logicalANDExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn5396);
            logicalANDExpressionNoIn180=logicalANDExpressionNoIn();
            _fsp--;

            adaptor.addChild(root_0, logicalANDExpressionNoIn180.getTree());
            // JS.g:1260:29: ( LOR logicalANDExpressionNoIn )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==LOR) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // JS.g:1260:31: LOR logicalANDExpressionNoIn
            	    {
            	    LOR181=(Token)input.LT(1);
            	    match(input,LOR,FOLLOW_LOR_in_logicalORExpressionNoIn5400); 
            	    LOR181_tree = (Object)adaptor.create(LOR181);
            	    root_0 = (Object)adaptor.becomeRoot(LOR181_tree, root_0);

            	    pushFollow(FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn5403);
            	    logicalANDExpressionNoIn182=logicalANDExpressionNoIn();
            	    _fsp--;

            	    adaptor.addChild(root_0, logicalANDExpressionNoIn182.getTree());

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end logicalORExpressionNoIn

    public static class conditionalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start conditionalExpression
    // JS.g:1267:1: conditionalExpression : logicalORExpression ( QUE assignmentExpression COLON assignmentExpression )? ;
    public final conditionalExpression_return conditionalExpression() throws RecognitionException {
        conditionalExpression_return retval = new conditionalExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QUE184=null;
        Token COLON186=null;
        logicalORExpression_return logicalORExpression183 = null;

        assignmentExpression_return assignmentExpression185 = null;

        assignmentExpression_return assignmentExpression187 = null;


        Object QUE184_tree=null;
        Object COLON186_tree=null;

        try {
            // JS.g:1268:2: ( logicalORExpression ( QUE assignmentExpression COLON assignmentExpression )? )
            // JS.g:1268:4: logicalORExpression ( QUE assignmentExpression COLON assignmentExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalORExpression_in_conditionalExpression5422);
            logicalORExpression183=logicalORExpression();
            _fsp--;

            adaptor.addChild(root_0, logicalORExpression183.getTree());
            // JS.g:1268:24: ( QUE assignmentExpression COLON assignmentExpression )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==QUE) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // JS.g:1268:26: QUE assignmentExpression COLON assignmentExpression
                    {
                    QUE184=(Token)input.LT(1);
                    match(input,QUE,FOLLOW_QUE_in_conditionalExpression5426); 
                    QUE184_tree = (Object)adaptor.create(QUE184);
                    root_0 = (Object)adaptor.becomeRoot(QUE184_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpression_in_conditionalExpression5429);
                    assignmentExpression185=assignmentExpression();
                    _fsp--;

                    adaptor.addChild(root_0, assignmentExpression185.getTree());
                    COLON186=(Token)input.LT(1);
                    match(input,COLON,FOLLOW_COLON_in_conditionalExpression5431); 
                    pushFollow(FOLLOW_assignmentExpression_in_conditionalExpression5434);
                    assignmentExpression187=assignmentExpression();
                    _fsp--;

                    adaptor.addChild(root_0, assignmentExpression187.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end conditionalExpression

    public static class conditionalExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start conditionalExpressionNoIn
    // JS.g:1271:1: conditionalExpressionNoIn : logicalORExpressionNoIn ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )? ;
    public final conditionalExpressionNoIn_return conditionalExpressionNoIn() throws RecognitionException {
        conditionalExpressionNoIn_return retval = new conditionalExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QUE189=null;
        Token COLON191=null;
        logicalORExpressionNoIn_return logicalORExpressionNoIn188 = null;

        assignmentExpressionNoIn_return assignmentExpressionNoIn190 = null;

        assignmentExpressionNoIn_return assignmentExpressionNoIn192 = null;


        Object QUE189_tree=null;
        Object COLON191_tree=null;

        try {
            // JS.g:1272:2: ( logicalORExpressionNoIn ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )? )
            // JS.g:1272:4: logicalORExpressionNoIn ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalORExpressionNoIn_in_conditionalExpressionNoIn5448);
            logicalORExpressionNoIn188=logicalORExpressionNoIn();
            _fsp--;

            adaptor.addChild(root_0, logicalORExpressionNoIn188.getTree());
            // JS.g:1272:28: ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==QUE) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // JS.g:1272:30: QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn
                    {
                    QUE189=(Token)input.LT(1);
                    match(input,QUE,FOLLOW_QUE_in_conditionalExpressionNoIn5452); 
                    QUE189_tree = (Object)adaptor.create(QUE189);
                    root_0 = (Object)adaptor.becomeRoot(QUE189_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn5455);
                    assignmentExpressionNoIn190=assignmentExpressionNoIn();
                    _fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn190.getTree());
                    COLON191=(Token)input.LT(1);
                    match(input,COLON,FOLLOW_COLON_in_conditionalExpressionNoIn5457); 
                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn5460);
                    assignmentExpressionNoIn192=assignmentExpressionNoIn();
                    _fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn192.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end conditionalExpressionNoIn

    public static class assignmentExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start assignmentExpression
    // JS.g:1301:1: assignmentExpression : lhs= conditionalExpression ({...}? assignmentOperator assignmentExpression )? ;
    public final assignmentExpression_return assignmentExpression() throws RecognitionException {
        assignmentExpression_return retval = new assignmentExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        conditionalExpression_return lhs = null;

        assignmentOperator_return assignmentOperator193 = null;

        assignmentExpression_return assignmentExpression194 = null;




        	Object[] isLhs = new Object[1];

        try {
            // JS.g:1306:2: (lhs= conditionalExpression ({...}? assignmentOperator assignmentExpression )? )
            // JS.g:1306:4: lhs= conditionalExpression ({...}? assignmentOperator assignmentExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_conditionalExpression_in_assignmentExpression5488);
            lhs=conditionalExpression();
            _fsp--;

            adaptor.addChild(root_0, lhs.getTree());
            // JS.g:1307:2: ({...}? assignmentOperator assignmentExpression )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=ASSIGN && LA50_0<=XORASS)||LA50_0==DIVASS) ) {
                int LA50_1 = input.LA(2);

                if ( ( isLeftHandSideAssign(lhs, isLhs) ) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // JS.g:1307:4: {...}? assignmentOperator assignmentExpression
                    {
                    if ( !( isLeftHandSideAssign(lhs, isLhs) ) ) {
                        throw new FailedPredicateException(input, "assignmentExpression", " isLeftHandSideAssign(lhs, isLhs) ");
                    }
                    pushFollow(FOLLOW_assignmentOperator_in_assignmentExpression5495);
                    assignmentOperator193=assignmentOperator();
                    _fsp--;

                    root_0 = (Object)adaptor.becomeRoot(assignmentOperator193.getTree(), root_0);
                    pushFollow(FOLLOW_assignmentExpression_in_assignmentExpression5498);
                    assignmentExpression194=assignmentExpression();
                    _fsp--;

                    adaptor.addChild(root_0, assignmentExpression194.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end assignmentExpression

    public static class assignmentOperator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start assignmentOperator
    // JS.g:1310:1: assignmentOperator : ( ASSIGN | MULASS | DIVASS | MODASS | ADDASS | SUBASS | SHLASS | SHRASS | SHUASS | ANDASS | XORASS | ORASS );
    public final assignmentOperator_return assignmentOperator() throws RecognitionException {
        assignmentOperator_return retval = new assignmentOperator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set195=null;

        Object set195_tree=null;

        try {
            // JS.g:1311:3: ( ASSIGN | MULASS | DIVASS | MODASS | ADDASS | SUBASS | SHLASS | SHRASS | SHUASS | ANDASS | XORASS | ORASS )
            // JS.g:
            {
            root_0 = (Object)adaptor.nil();

            set195=(Token)input.LT(1);
            if ( (input.LA(1)>=ASSIGN && input.LA(1)<=XORASS)||input.LA(1)==DIVASS ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set195));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_assignmentOperator0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end assignmentOperator

    public static class assignmentExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start assignmentExpressionNoIn
    // JS.g:1314:1: assignmentExpressionNoIn : lhs= conditionalExpressionNoIn ({...}? assignmentOperator assignmentExpressionNoIn )? ;
    public final assignmentExpressionNoIn_return assignmentExpressionNoIn() throws RecognitionException {
        assignmentExpressionNoIn_return retval = new assignmentExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        conditionalExpressionNoIn_return lhs = null;

        assignmentOperator_return assignmentOperator196 = null;

        assignmentExpressionNoIn_return assignmentExpressionNoIn197 = null;




        	Object[] isLhs = new Object[1];

        try {
            // JS.g:1319:2: (lhs= conditionalExpressionNoIn ({...}? assignmentOperator assignmentExpressionNoIn )? )
            // JS.g:1319:4: lhs= conditionalExpressionNoIn ({...}? assignmentOperator assignmentExpressionNoIn )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_conditionalExpressionNoIn_in_assignmentExpressionNoIn5576);
            lhs=conditionalExpressionNoIn();
            _fsp--;

            adaptor.addChild(root_0, lhs.getTree());
            // JS.g:1320:2: ({...}? assignmentOperator assignmentExpressionNoIn )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=ASSIGN && LA51_0<=XORASS)||LA51_0==DIVASS) ) {
                int LA51_1 = input.LA(2);

                if ( ( isLeftHandSideAssign(lhs, isLhs) ) ) {
                    alt51=1;
                }
            }
            switch (alt51) {
                case 1 :
                    // JS.g:1320:4: {...}? assignmentOperator assignmentExpressionNoIn
                    {
                    if ( !( isLeftHandSideAssign(lhs, isLhs) ) ) {
                        throw new FailedPredicateException(input, "assignmentExpressionNoIn", " isLeftHandSideAssign(lhs, isLhs) ");
                    }
                    pushFollow(FOLLOW_assignmentOperator_in_assignmentExpressionNoIn5583);
                    assignmentOperator196=assignmentOperator();
                    _fsp--;

                    root_0 = (Object)adaptor.becomeRoot(assignmentOperator196.getTree(), root_0);
                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_assignmentExpressionNoIn5586);
                    assignmentExpressionNoIn197=assignmentExpressionNoIn();
                    _fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn197.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end assignmentExpressionNoIn

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expression
    // JS.g:1327:1: expression : exprs+= assignmentExpression ( COMMA exprs+= assignmentExpression )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs;
    public final expression_return expression() throws RecognitionException {
        expression_return retval = new expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA198=null;
        List list_exprs=null;
        RuleReturnScope exprs = null;
        Object COMMA198_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            // JS.g:1328:2: (exprs+= assignmentExpression ( COMMA exprs+= assignmentExpression )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs)
            // JS.g:1328:4: exprs+= assignmentExpression ( COMMA exprs+= assignmentExpression )*
            {
            pushFollow(FOLLOW_assignmentExpression_in_expression5608);
            exprs=assignmentExpression();
            _fsp--;

            stream_assignmentExpression.add(exprs.getTree());
            if (list_exprs==null) list_exprs=new ArrayList();
            list_exprs.add(exprs);

            // JS.g:1328:32: ( COMMA exprs+= assignmentExpression )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==COMMA) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // JS.g:1328:34: COMMA exprs+= assignmentExpression
            	    {
            	    COMMA198=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_expression5612); 
            	    stream_COMMA.add(COMMA198);

            	    pushFollow(FOLLOW_assignmentExpression_in_expression5616);
            	    exprs=assignmentExpression();
            	    _fsp--;

            	    stream_assignmentExpression.add(exprs.getTree());
            	    if (list_exprs==null) list_exprs=new ArrayList();
            	    list_exprs.add(exprs);


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            // AST REWRITE
            // elements: exprs, exprs
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: exprs
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"token exprs",list_exprs);
            root_0 = (Object)adaptor.nil();
            // 1329:2: -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ )
            if ( list_exprs.size() > 1 ) {
                // JS.g:1329:28: ^( CEXPR ( $exprs)+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(CEXPR, "CEXPR"), root_1);

                if ( !(stream_exprs.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_exprs.hasNext() ) {
                    adaptor.addChild(root_1, ((ParserRuleReturnScope)stream_exprs.next()).getTree());

                }
                stream_exprs.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 1330:2: -> $exprs
            {
                adaptor.addChild(root_0, ((ParserRuleReturnScope)stream_exprs.next()).getTree());

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expression

    public static class expressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionNoIn
    // JS.g:1333:1: expressionNoIn : exprs+= assignmentExpressionNoIn ( COMMA exprs+= assignmentExpressionNoIn )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs;
    public final expressionNoIn_return expressionNoIn() throws RecognitionException {
        expressionNoIn_return retval = new expressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA199=null;
        List list_exprs=null;
        RuleReturnScope exprs = null;
        Object COMMA199_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignmentExpressionNoIn=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpressionNoIn");
        try {
            // JS.g:1334:2: (exprs+= assignmentExpressionNoIn ( COMMA exprs+= assignmentExpressionNoIn )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs)
            // JS.g:1334:4: exprs+= assignmentExpressionNoIn ( COMMA exprs+= assignmentExpressionNoIn )*
            {
            pushFollow(FOLLOW_assignmentExpressionNoIn_in_expressionNoIn5653);
            exprs=assignmentExpressionNoIn();
            _fsp--;

            stream_assignmentExpressionNoIn.add(exprs.getTree());
            if (list_exprs==null) list_exprs=new ArrayList();
            list_exprs.add(exprs);

            // JS.g:1334:36: ( COMMA exprs+= assignmentExpressionNoIn )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==COMMA) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // JS.g:1334:38: COMMA exprs+= assignmentExpressionNoIn
            	    {
            	    COMMA199=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_expressionNoIn5657); 
            	    stream_COMMA.add(COMMA199);

            	    pushFollow(FOLLOW_assignmentExpressionNoIn_in_expressionNoIn5661);
            	    exprs=assignmentExpressionNoIn();
            	    _fsp--;

            	    stream_assignmentExpressionNoIn.add(exprs.getTree());
            	    if (list_exprs==null) list_exprs=new ArrayList();
            	    list_exprs.add(exprs);


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            // AST REWRITE
            // elements: exprs, exprs
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: exprs
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"token exprs",list_exprs);
            root_0 = (Object)adaptor.nil();
            // 1335:2: -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ )
            if ( list_exprs.size() > 1 ) {
                // JS.g:1335:28: ^( CEXPR ( $exprs)+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(CEXPR, "CEXPR"), root_1);

                if ( !(stream_exprs.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_exprs.hasNext() ) {
                    adaptor.addChild(root_1, ((ParserRuleReturnScope)stream_exprs.next()).getTree());

                }
                stream_exprs.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 1336:2: -> $exprs
            {
                adaptor.addChild(root_0, ((ParserRuleReturnScope)stream_exprs.next()).getTree());

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expressionNoIn

    public static class semic_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start semic
    // JS.g:1361:1: semic : ( SEMIC | EOF | RBRACE | EOL | MultiLineComment );
    public final semic_return semic() throws RecognitionException {
        semic_return retval = new semic_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMIC200=null;
        Token EOF201=null;
        Token RBRACE202=null;
        Token EOL203=null;
        Token MultiLineComment204=null;

        Object SEMIC200_tree=null;
        Object EOF201_tree=null;
        Object RBRACE202_tree=null;
        Object EOL203_tree=null;
        Object MultiLineComment204_tree=null;


        	// Mark current position so we can unconsume a RBRACE.
        	int marker = input.mark();
        	// Promote EOL if appropriate	
        	promoteEOL(retval);

        try {
            // JS.g:1369:2: ( SEMIC | EOF | RBRACE | EOL | MultiLineComment )
            int alt54=5;
            switch ( input.LA(1) ) {
            case SEMIC:
                {
                alt54=1;
                }
                break;
            case EOF:
                {
                alt54=2;
                }
                break;
            case RBRACE:
                {
                alt54=3;
                }
                break;
            case EOL:
                {
                alt54=4;
                }
                break;
            case MultiLineComment:
                {
                alt54=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1361:1: semic : ( SEMIC | EOF | RBRACE | EOL | MultiLineComment );", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // JS.g:1369:4: SEMIC
                    {
                    root_0 = (Object)adaptor.nil();

                    SEMIC200=(Token)input.LT(1);
                    match(input,SEMIC,FOLLOW_SEMIC_in_semic5712); 
                    SEMIC200_tree = (Object)adaptor.create(SEMIC200);
                    adaptor.addChild(root_0, SEMIC200_tree);


                    }
                    break;
                case 2 :
                    // JS.g:1370:4: EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    EOF201=(Token)input.LT(1);
                    match(input,EOF,FOLLOW_EOF_in_semic5717); 
                    EOF201_tree = (Object)adaptor.create(EOF201);
                    adaptor.addChild(root_0, EOF201_tree);


                    }
                    break;
                case 3 :
                    // JS.g:1371:4: RBRACE
                    {
                    root_0 = (Object)adaptor.nil();

                    RBRACE202=(Token)input.LT(1);
                    match(input,RBRACE,FOLLOW_RBRACE_in_semic5722); 
                    RBRACE202_tree = (Object)adaptor.create(RBRACE202);
                    adaptor.addChild(root_0, RBRACE202_tree);

                     input.rewind(marker); 

                    }
                    break;
                case 4 :
                    // JS.g:1372:4: EOL
                    {
                    root_0 = (Object)adaptor.nil();

                    EOL203=(Token)input.LT(1);
                    match(input,EOL,FOLLOW_EOL_in_semic5729); 
                    EOL203_tree = (Object)adaptor.create(EOL203);
                    adaptor.addChild(root_0, EOL203_tree);


                    }
                    break;
                case 5 :
                    // JS.g:1372:10: MultiLineComment
                    {
                    root_0 = (Object)adaptor.nil();

                    MultiLineComment204=(Token)input.LT(1);
                    match(input,MultiLineComment,FOLLOW_MultiLineComment_in_semic5733); 
                    MultiLineComment204_tree = (Object)adaptor.create(MultiLineComment204);
                    adaptor.addChild(root_0, MultiLineComment204_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end semic

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statement
    // JS.g:1380:1: statement options {k=1; } : ({...}? block | statementTail );
    public final statement_return statement() throws RecognitionException {
        statement_return retval = new statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        block_return block205 = null;

        statementTail_return statementTail206 = null;



        try {
            // JS.g:1385:2: ({...}? block | statementTail )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==LBRACE) ) {
                int LA55_1 = input.LA(2);

                if ( ( input.LA(1) == LBRACE ) ) {
                    alt55=1;
                }
                else if ( (true) ) {
                    alt55=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1380:1: statement options {k=1; } : ({...}? block | statementTail );", 55, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA55_0>=NULL && LA55_0<=FALSE)||LA55_0==EACH||LA55_0==THIS||LA55_0==VAR||(LA55_0>=GET && LA55_0<=SET)||(LA55_0>=WXML && LA55_0<=CLASS)||(LA55_0>=DEBUGGER && LA55_0<=VOLATILE)||LA55_0==SEMIC||LA55_0==AT||LA55_0==StringLiteral||(LA55_0>=Identifier && LA55_0<=RegularExpressionLiteral)||(LA55_0>=DecimalLiteral && LA55_0<=HexIntegerLiteral)) ) {
                alt55=2;
            }
            else if ( ((LA55_0>=XMLFragment && LA55_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt55=2;
            }
            else if ( (LA55_0==BREAK||LA55_0==CONTINUE||(LA55_0>=DELETE && LA55_0<=DO)||LA55_0==FOR||(LA55_0>=FUNCTION && LA55_0<=IF)||(LA55_0>=NEW && LA55_0<=SWITCH)||(LA55_0>=THROW && LA55_0<=TYPEOF)||(LA55_0>=VOID && LA55_0<=WITH)||LA55_0==YIELD||LA55_0==CONST||LA55_0==LPAREN||LA55_0==LBRACK||(LA55_0>=ADD && LA55_0<=SUB)||(LA55_0>=INC && LA55_0<=DEC)||(LA55_0>=NOT && LA55_0<=INV)) ) {
                alt55=2;
            }
            else if ( (LA55_0==DEFAULT) && ( isXmlEnabled() )) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1380:1: statement options {k=1; } : ({...}? block | statementTail );", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // JS.g:1385:4: {...}? block
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !( input.LA(1) == LBRACE ) ) {
                        throw new FailedPredicateException(input, "statement", " input.LA(1) == LBRACE ");
                    }
                    pushFollow(FOLLOW_block_in_statement5762);
                    block205=block();
                    _fsp--;

                    adaptor.addChild(root_0, block205.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1386:4: statementTail
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementTail_in_statement5767);
                    statementTail206=statementTail();
                    _fsp--;

                    adaptor.addChild(root_0, statementTail206.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end statement

    public static class statementTail_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statementTail
    // JS.g:1389:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement );
    public final statementTail_return statementTail() throws RecognitionException {
        statementTail_return retval = new statementTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        variableStatement_return variableStatement207 = null;

        emptyStatement_return emptyStatement208 = null;

        expressionStatement_return expressionStatement209 = null;

        ifStatement_return ifStatement210 = null;

        iterationStatement_return iterationStatement211 = null;

        continueStatement_return continueStatement212 = null;

        breakStatement_return breakStatement213 = null;

        returnStatement_return returnStatement214 = null;

        withStatement_return withStatement215 = null;

        labelledStatement_return labelledStatement216 = null;

        switchStatement_return switchStatement217 = null;

        throwStatement_return throwStatement218 = null;

        tryStatement_return tryStatement219 = null;

        constStatement_return constStatement220 = null;

        namespaceStatement_return namespaceStatement221 = null;



        try {
            // JS.g:1390:2: ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement )
            int alt56=15;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==VAR) ) {
                alt56=1;
            }
            else if ( (LA56_0==SEMIC) ) {
                alt56=2;
            }
            else if ( ((LA56_0>=NULL && LA56_0<=FALSE)||LA56_0==THIS||LA56_0==AT||LA56_0==StringLiteral||LA56_0==RegularExpressionLiteral||(LA56_0>=DecimalLiteral && LA56_0<=HexIntegerLiteral)) ) {
                alt56=3;
            }
            else if ( (LA56_0==WXML) ) {
                int LA56_4 = input.LA(2);

                if ( (LA56_4==EOF||(LA56_4>=IN && LA56_4<=INSTANCEOF)||(LA56_4>=RBRACE && LA56_4<=LPAREN)||LA56_4==LBRACK||(LA56_4>=DOT && LA56_4<=XOR)||(LA56_4>=LAND && LA56_4<=QUE)||(LA56_4>=ASSIGN && LA56_4<=DIVASS)||(LA56_4>=DOTDOT && LA56_4<=COLONCOLON)||(LA56_4>=EOL && LA56_4<=MultiLineComment)) ) {
                    alt56=3;
                }
                else if ( (LA56_4==COLON) ) {
                    alt56=10;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1389:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement );", 56, 4, input);

                    throw nvae;
                }
            }
            else if ( (LA56_0==GET) ) {
                int LA56_5 = input.LA(2);

                if ( (LA56_5==EOF||(LA56_5>=IN && LA56_5<=INSTANCEOF)||(LA56_5>=RBRACE && LA56_5<=LPAREN)||LA56_5==LBRACK||(LA56_5>=DOT && LA56_5<=XOR)||(LA56_5>=LAND && LA56_5<=QUE)||(LA56_5>=ASSIGN && LA56_5<=DIVASS)||(LA56_5>=DOTDOT && LA56_5<=COLONCOLON)||(LA56_5>=EOL && LA56_5<=MultiLineComment)) ) {
                    alt56=3;
                }
                else if ( (LA56_5==COLON) ) {
                    alt56=10;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1389:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement );", 56, 5, input);

                    throw nvae;
                }
            }
            else if ( (LA56_0==SET) ) {
                int LA56_6 = input.LA(2);

                if ( (LA56_6==COLON) ) {
                    alt56=10;
                }
                else if ( (LA56_6==EOF||(LA56_6>=IN && LA56_6<=INSTANCEOF)||(LA56_6>=RBRACE && LA56_6<=LPAREN)||LA56_6==LBRACK||(LA56_6>=DOT && LA56_6<=XOR)||(LA56_6>=LAND && LA56_6<=QUE)||(LA56_6>=ASSIGN && LA56_6<=DIVASS)||(LA56_6>=DOTDOT && LA56_6<=COLONCOLON)||(LA56_6>=EOL && LA56_6<=MultiLineComment)) ) {
                    alt56=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1389:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement );", 56, 6, input);

                    throw nvae;
                }
            }
            else if ( (LA56_0==EACH) ) {
                int LA56_7 = input.LA(2);

                if ( (LA56_7==COLON) ) {
                    alt56=10;
                }
                else if ( (LA56_7==EOF||(LA56_7>=IN && LA56_7<=INSTANCEOF)||(LA56_7>=RBRACE && LA56_7<=LPAREN)||LA56_7==LBRACK||(LA56_7>=DOT && LA56_7<=XOR)||(LA56_7>=LAND && LA56_7<=QUE)||(LA56_7>=ASSIGN && LA56_7<=DIVASS)||(LA56_7>=DOTDOT && LA56_7<=COLONCOLON)||(LA56_7>=EOL && LA56_7<=MultiLineComment)) ) {
                    alt56=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1389:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement );", 56, 7, input);

                    throw nvae;
                }
            }
            else if ( (LA56_0==NAMESPACE) ) {
                int LA56_8 = input.LA(2);

                if ( (LA56_8==COLON) ) {
                    alt56=10;
                }
                else if ( (LA56_8==EOF||(LA56_8>=IN && LA56_8<=INSTANCEOF)||(LA56_8>=RBRACE && LA56_8<=LPAREN)||LA56_8==LBRACK||(LA56_8>=DOT && LA56_8<=XOR)||(LA56_8>=LAND && LA56_8<=QUE)||(LA56_8>=ASSIGN && LA56_8<=DIVASS)||(LA56_8>=DOTDOT && LA56_8<=COLONCOLON)||(LA56_8>=EOL && LA56_8<=MultiLineComment)) ) {
                    alt56=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1389:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement );", 56, 8, input);

                    throw nvae;
                }
            }
            else if ( ((LA56_0>=ABSTRACT && LA56_0<=CLASS)||(LA56_0>=DEBUGGER && LA56_0<=VOLATILE)) ) {
                int LA56_9 = input.LA(2);

                if ( (LA56_9==COLON) ) {
                    alt56=10;
                }
                else if ( (LA56_9==EOF||(LA56_9>=IN && LA56_9<=INSTANCEOF)||(LA56_9>=RBRACE && LA56_9<=LPAREN)||LA56_9==LBRACK||(LA56_9>=DOT && LA56_9<=XOR)||(LA56_9>=LAND && LA56_9<=QUE)||(LA56_9>=ASSIGN && LA56_9<=DIVASS)||(LA56_9>=DOTDOT && LA56_9<=COLONCOLON)||(LA56_9>=EOL && LA56_9<=MultiLineComment)) ) {
                    alt56=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1389:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement );", 56, 9, input);

                    throw nvae;
                }
            }
            else if ( (LA56_0==Identifier) ) {
                int LA56_10 = input.LA(2);

                if ( (LA56_10==EOF||(LA56_10>=IN && LA56_10<=INSTANCEOF)||(LA56_10>=RBRACE && LA56_10<=LPAREN)||LA56_10==LBRACK||(LA56_10>=DOT && LA56_10<=XOR)||(LA56_10>=LAND && LA56_10<=QUE)||(LA56_10>=ASSIGN && LA56_10<=DIVASS)||(LA56_10>=DOTDOT && LA56_10<=COLONCOLON)||(LA56_10>=EOL && LA56_10<=MultiLineComment)) ) {
                    alt56=3;
                }
                else if ( (LA56_10==COLON) ) {
                    alt56=10;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1389:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement );", 56, 10, input);

                    throw nvae;
                }
            }
            else if ( ((LA56_0>=XMLFragment && LA56_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt56=3;
            }
            else if ( (LA56_0==DELETE||LA56_0==FUNCTION||LA56_0==NEW||LA56_0==TYPEOF||LA56_0==VOID||LA56_0==YIELD||LA56_0==LBRACE||LA56_0==LPAREN||LA56_0==LBRACK||(LA56_0>=ADD && LA56_0<=SUB)||(LA56_0>=INC && LA56_0<=DEC)||(LA56_0>=NOT && LA56_0<=INV)) ) {
                alt56=3;
            }
            else if ( (LA56_0==IF) ) {
                alt56=4;
            }
            else if ( (LA56_0==DO||LA56_0==FOR||LA56_0==WHILE) ) {
                alt56=5;
            }
            else if ( (LA56_0==CONTINUE) ) {
                alt56=6;
            }
            else if ( (LA56_0==BREAK) ) {
                alt56=7;
            }
            else if ( (LA56_0==RETURN) ) {
                alt56=8;
            }
            else if ( (LA56_0==WITH) ) {
                alt56=9;
            }
            else if ( (LA56_0==SWITCH) ) {
                alt56=11;
            }
            else if ( (LA56_0==THROW) ) {
                alt56=12;
            }
            else if ( (LA56_0==TRY) ) {
                alt56=13;
            }
            else if ( (LA56_0==CONST) ) {
                alt56=14;
            }
            else if ( (LA56_0==DEFAULT) && ( isXmlEnabled() )) {
                alt56=15;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1389:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement | constStatement | namespaceStatement );", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // JS.g:1390:4: variableStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_variableStatement_in_statementTail5779);
                    variableStatement207=variableStatement();
                    _fsp--;

                    adaptor.addChild(root_0, variableStatement207.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1391:4: emptyStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_emptyStatement_in_statementTail5784);
                    emptyStatement208=emptyStatement();
                    _fsp--;

                    adaptor.addChild(root_0, emptyStatement208.getTree());

                    }
                    break;
                case 3 :
                    // JS.g:1392:4: expressionStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementTail5789);
                    expressionStatement209=expressionStatement();
                    _fsp--;

                    adaptor.addChild(root_0, expressionStatement209.getTree());

                    }
                    break;
                case 4 :
                    // JS.g:1393:4: ifStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementTail5794);
                    ifStatement210=ifStatement();
                    _fsp--;

                    adaptor.addChild(root_0, ifStatement210.getTree());

                    }
                    break;
                case 5 :
                    // JS.g:1394:4: iterationStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_iterationStatement_in_statementTail5799);
                    iterationStatement211=iterationStatement();
                    _fsp--;

                    adaptor.addChild(root_0, iterationStatement211.getTree());

                    }
                    break;
                case 6 :
                    // JS.g:1395:4: continueStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementTail5804);
                    continueStatement212=continueStatement();
                    _fsp--;

                    adaptor.addChild(root_0, continueStatement212.getTree());

                    }
                    break;
                case 7 :
                    // JS.g:1396:4: breakStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementTail5809);
                    breakStatement213=breakStatement();
                    _fsp--;

                    adaptor.addChild(root_0, breakStatement213.getTree());

                    }
                    break;
                case 8 :
                    // JS.g:1397:4: returnStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementTail5814);
                    returnStatement214=returnStatement();
                    _fsp--;

                    adaptor.addChild(root_0, returnStatement214.getTree());

                    }
                    break;
                case 9 :
                    // JS.g:1398:4: withStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_withStatement_in_statementTail5819);
                    withStatement215=withStatement();
                    _fsp--;

                    adaptor.addChild(root_0, withStatement215.getTree());

                    }
                    break;
                case 10 :
                    // JS.g:1399:4: labelledStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_labelledStatement_in_statementTail5824);
                    labelledStatement216=labelledStatement();
                    _fsp--;

                    adaptor.addChild(root_0, labelledStatement216.getTree());

                    }
                    break;
                case 11 :
                    // JS.g:1400:4: switchStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementTail5829);
                    switchStatement217=switchStatement();
                    _fsp--;

                    adaptor.addChild(root_0, switchStatement217.getTree());

                    }
                    break;
                case 12 :
                    // JS.g:1401:4: throwStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementTail5834);
                    throwStatement218=throwStatement();
                    _fsp--;

                    adaptor.addChild(root_0, throwStatement218.getTree());

                    }
                    break;
                case 13 :
                    // JS.g:1402:4: tryStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tryStatement_in_statementTail5839);
                    tryStatement219=tryStatement();
                    _fsp--;

                    adaptor.addChild(root_0, tryStatement219.getTree());

                    }
                    break;
                case 14 :
                    // JS.g:1403:4: constStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constStatement_in_statementTail5844);
                    constStatement220=constStatement();
                    _fsp--;

                    adaptor.addChild(root_0, constStatement220.getTree());

                    }
                    break;
                case 15 :
                    // JS.g:1404:4: namespaceStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_namespaceStatement_in_statementTail5849);
                    namespaceStatement221=namespaceStatement();
                    _fsp--;

                    adaptor.addChild(root_0, namespaceStatement221.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end statementTail

    public static class block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start block
    // JS.g:1409:1: block : lb= LBRACE ( sourceElement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* ) ;
    public final block_return block() throws RecognitionException {
        block_return retval = new block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb=null;
        Token RBRACE223=null;
        sourceElement_return sourceElement222 = null;


        Object lb_tree=null;
        Object RBRACE223_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_sourceElement=new RewriteRuleSubtreeStream(adaptor,"rule sourceElement");
        try {
            // JS.g:1410:2: (lb= LBRACE ( sourceElement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* ) )
            // JS.g:1410:4: lb= LBRACE ( sourceElement )* RBRACE
            {
            lb=(Token)input.LT(1);
            match(input,LBRACE,FOLLOW_LBRACE_in_block5864); 
            stream_LBRACE.add(lb);

            // JS.g:1410:14: ( sourceElement )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=NULL && LA57_0<=FALSE)||(LA57_0>=EACH && LA57_0<=FUNCTION)||LA57_0==THIS||LA57_0==VAR||(LA57_0>=GET && LA57_0<=SET)||(LA57_0>=WXML && LA57_0<=CLASS)||(LA57_0>=DEBUGGER && LA57_0<=LBRACE)||LA57_0==SEMIC||LA57_0==AT||LA57_0==StringLiteral||(LA57_0>=Identifier && LA57_0<=RegularExpressionLiteral)||(LA57_0>=DecimalLiteral && LA57_0<=HexIntegerLiteral)) ) {
                    alt57=1;
                }
                else if ( ((LA57_0>=XMLFragment && LA57_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                    alt57=1;
                }
                else if ( (LA57_0==BREAK||LA57_0==CONTINUE||(LA57_0>=DELETE && LA57_0<=DO)||LA57_0==FOR||LA57_0==IF||(LA57_0>=NEW && LA57_0<=SWITCH)||(LA57_0>=THROW && LA57_0<=TYPEOF)||(LA57_0>=VOID && LA57_0<=WITH)||LA57_0==YIELD||LA57_0==CONST||LA57_0==LPAREN||LA57_0==LBRACK||(LA57_0>=ADD && LA57_0<=SUB)||(LA57_0>=INC && LA57_0<=DEC)||(LA57_0>=NOT && LA57_0<=INV)) ) {
                    alt57=1;
                }
                else if ( (LA57_0==DEFAULT) && ( isXmlEnabled() )) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // JS.g:1410:14: sourceElement
            	    {
            	    pushFollow(FOLLOW_sourceElement_in_block5866);
            	    sourceElement222=sourceElement();
            	    _fsp--;

            	    stream_sourceElement.add(sourceElement222.getTree());

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            RBRACE223=(Token)input.LT(1);
            match(input,RBRACE,FOLLOW_RBRACE_in_block5869); 
            stream_RBRACE.add(RBRACE223);


            // AST REWRITE
            // elements: sourceElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1411:2: -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* )
            {
                // JS.g:1411:5: ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(BLOCK, lb,  "BLOCK"), root_1);

                // JS.g:1411:28: ( sourceElement )*
                while ( stream_sourceElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_sourceElement.next());

                }
                stream_sourceElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end block

    public static class variableStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start variableStatement
    // JS.g:1418:1: variableStatement : VAR variableDeclaration ( COMMA variableDeclaration )* semic -> ^( VAR ( variableDeclaration )+ ) ;
    public final variableStatement_return variableStatement() throws RecognitionException {
        variableStatement_return retval = new variableStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAR224=null;
        Token COMMA226=null;
        variableDeclaration_return variableDeclaration225 = null;

        variableDeclaration_return variableDeclaration227 = null;

        semic_return semic228 = null;


        Object VAR224_tree=null;
        Object COMMA226_tree=null;
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_variableDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclaration");
        RewriteRuleSubtreeStream stream_semic=new RewriteRuleSubtreeStream(adaptor,"rule semic");
        try {
            // JS.g:1419:2: ( VAR variableDeclaration ( COMMA variableDeclaration )* semic -> ^( VAR ( variableDeclaration )+ ) )
            // JS.g:1419:4: VAR variableDeclaration ( COMMA variableDeclaration )* semic
            {
            VAR224=(Token)input.LT(1);
            match(input,VAR,FOLLOW_VAR_in_variableStatement5898); 
            stream_VAR.add(VAR224);

            pushFollow(FOLLOW_variableDeclaration_in_variableStatement5900);
            variableDeclaration225=variableDeclaration();
            _fsp--;

            stream_variableDeclaration.add(variableDeclaration225.getTree());
            // JS.g:1419:28: ( COMMA variableDeclaration )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==COMMA) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // JS.g:1419:30: COMMA variableDeclaration
            	    {
            	    COMMA226=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_variableStatement5904); 
            	    stream_COMMA.add(COMMA226);

            	    pushFollow(FOLLOW_variableDeclaration_in_variableStatement5906);
            	    variableDeclaration227=variableDeclaration();
            	    _fsp--;

            	    stream_variableDeclaration.add(variableDeclaration227.getTree());

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            pushFollow(FOLLOW_semic_in_variableStatement5911);
            semic228=semic();
            _fsp--;

            stream_semic.add(semic228.getTree());

            // AST REWRITE
            // elements: VAR, variableDeclaration
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1420:2: -> ^( VAR ( variableDeclaration )+ )
            {
                // JS.g:1420:5: ^( VAR ( variableDeclaration )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_VAR.next(), root_1);

                if ( !(stream_variableDeclaration.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_variableDeclaration.hasNext() ) {
                    adaptor.addChild(root_1, stream_variableDeclaration.next());

                }
                stream_variableDeclaration.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end variableStatement

    public static class variableDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start variableDeclaration
    // JS.g:1423:1: variableDeclaration : identifier ( ASSIGN assignmentExpression )? ;
    public final variableDeclaration_return variableDeclaration() throws RecognitionException {
        variableDeclaration_return retval = new variableDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASSIGN230=null;
        identifier_return identifier229 = null;

        assignmentExpression_return assignmentExpression231 = null;


        Object ASSIGN230_tree=null;

        try {
            // JS.g:1424:2: ( identifier ( ASSIGN assignmentExpression )? )
            // JS.g:1424:4: identifier ( ASSIGN assignmentExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_variableDeclaration5934);
            identifier229=identifier();
            _fsp--;

            root_0 = (Object)adaptor.becomeRoot(identifier229.getTree(), root_0);
            // JS.g:1424:16: ( ASSIGN assignmentExpression )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==ASSIGN) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // JS.g:1424:18: ASSIGN assignmentExpression
                    {
                    ASSIGN230=(Token)input.LT(1);
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclaration5939); 
                    ASSIGN230_tree = (Object)adaptor.create(ASSIGN230);
                    adaptor.addChild(root_0, ASSIGN230_tree);

                    pushFollow(FOLLOW_assignmentExpression_in_variableDeclaration5941);
                    assignmentExpression231=assignmentExpression();
                    _fsp--;

                    adaptor.addChild(root_0, assignmentExpression231.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end variableDeclaration

    public static class variableDeclarationNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start variableDeclarationNoIn
    // JS.g:1427:1: variableDeclarationNoIn : identifier ( ASSIGN assignmentExpressionNoIn )? ;
    public final variableDeclarationNoIn_return variableDeclarationNoIn() throws RecognitionException {
        variableDeclarationNoIn_return retval = new variableDeclarationNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASSIGN233=null;
        identifier_return identifier232 = null;

        assignmentExpressionNoIn_return assignmentExpressionNoIn234 = null;


        Object ASSIGN233_tree=null;

        try {
            // JS.g:1428:2: ( identifier ( ASSIGN assignmentExpressionNoIn )? )
            // JS.g:1428:4: identifier ( ASSIGN assignmentExpressionNoIn )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_variableDeclarationNoIn5956);
            identifier232=identifier();
            _fsp--;

            root_0 = (Object)adaptor.becomeRoot(identifier232.getTree(), root_0);
            // JS.g:1428:16: ( ASSIGN assignmentExpressionNoIn )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==ASSIGN) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // JS.g:1428:18: ASSIGN assignmentExpressionNoIn
                    {
                    ASSIGN233=(Token)input.LT(1);
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclarationNoIn5961); 
                    ASSIGN233_tree = (Object)adaptor.create(ASSIGN233);
                    adaptor.addChild(root_0, ASSIGN233_tree);

                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_variableDeclarationNoIn5963);
                    assignmentExpressionNoIn234=assignmentExpressionNoIn();
                    _fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn234.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end variableDeclarationNoIn

    public static class constStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start constStatement
    // JS.g:1431:1: constStatement : CONST variableDeclaration ( COMMA variableDeclaration )* semic -> ^( CONST ( variableDeclaration )+ ) ;
    public final constStatement_return constStatement() throws RecognitionException {
        constStatement_return retval = new constStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CONST235=null;
        Token COMMA237=null;
        variableDeclaration_return variableDeclaration236 = null;

        variableDeclaration_return variableDeclaration238 = null;

        semic_return semic239 = null;


        Object CONST235_tree=null;
        Object COMMA237_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_CONST=new RewriteRuleTokenStream(adaptor,"token CONST");
        RewriteRuleSubtreeStream stream_variableDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclaration");
        RewriteRuleSubtreeStream stream_semic=new RewriteRuleSubtreeStream(adaptor,"rule semic");
        try {
            // JS.g:1432:3: ( CONST variableDeclaration ( COMMA variableDeclaration )* semic -> ^( CONST ( variableDeclaration )+ ) )
            // JS.g:1432:5: CONST variableDeclaration ( COMMA variableDeclaration )* semic
            {
            CONST235=(Token)input.LT(1);
            match(input,CONST,FOLLOW_CONST_in_constStatement5978); 
            stream_CONST.add(CONST235);

            pushFollow(FOLLOW_variableDeclaration_in_constStatement5980);
            variableDeclaration236=variableDeclaration();
            _fsp--;

            stream_variableDeclaration.add(variableDeclaration236.getTree());
            // JS.g:1432:31: ( COMMA variableDeclaration )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==COMMA) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // JS.g:1432:33: COMMA variableDeclaration
            	    {
            	    COMMA237=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_constStatement5984); 
            	    stream_COMMA.add(COMMA237);

            	    pushFollow(FOLLOW_variableDeclaration_in_constStatement5986);
            	    variableDeclaration238=variableDeclaration();
            	    _fsp--;

            	    stream_variableDeclaration.add(variableDeclaration238.getTree());

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            pushFollow(FOLLOW_semic_in_constStatement5991);
            semic239=semic();
            _fsp--;

            stream_semic.add(semic239.getTree());

            // AST REWRITE
            // elements: variableDeclaration, CONST
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1433:3: -> ^( CONST ( variableDeclaration )+ )
            {
                // JS.g:1433:6: ^( CONST ( variableDeclaration )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_CONST.next(), root_1);

                if ( !(stream_variableDeclaration.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_variableDeclaration.hasNext() ) {
                    adaptor.addChild(root_1, stream_variableDeclaration.next());

                }
                stream_variableDeclaration.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end constStatement

    public static class emptyStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start emptyStatement
    // JS.g:1440:1: emptyStatement : SEMIC -> EMPTY_STATEMENT[$SEMIC] ;
    public final emptyStatement_return emptyStatement() throws RecognitionException {
        emptyStatement_return retval = new emptyStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMIC240=null;

        Object SEMIC240_tree=null;
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");

        try {
            // JS.g:1441:2: ( SEMIC -> EMPTY_STATEMENT[$SEMIC] )
            // JS.g:1441:4: SEMIC
            {
            SEMIC240=(Token)input.LT(1);
            match(input,SEMIC,FOLLOW_SEMIC_in_emptyStatement6021); 
            stream_SEMIC.add(SEMIC240);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1441:10: -> EMPTY_STATEMENT[$SEMIC]
            {
                adaptor.addChild(root_0, adaptor.create(EMPTY_STATEMENT, SEMIC240));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end emptyStatement

    public static class expressionStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressionStatement
    // JS.g:1454:1: expressionStatement : expression semic ;
    public final expressionStatement_return expressionStatement() throws RecognitionException {
        expressionStatement_return retval = new expressionStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        expression_return expression241 = null;

        semic_return semic242 = null;



        try {
            // JS.g:1455:2: ( expression semic )
            // JS.g:1455:4: expression semic
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_expressionStatement6044);
            expression241=expression();
            _fsp--;

            adaptor.addChild(root_0, expression241.getTree());
            pushFollow(FOLLOW_semic_in_expressionStatement6046);
            semic242=semic();
            _fsp--;


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expressionStatement

    public static class ifStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ifStatement
    // JS.g:1462:1: ifStatement : IF LPAREN expression RPAREN statement ({...}? ELSE statement )? -> ^( IF expression ( statement )+ ) ;
    public final ifStatement_return ifStatement() throws RecognitionException {
        ifStatement_return retval = new ifStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IF243=null;
        Token LPAREN244=null;
        Token RPAREN246=null;
        Token ELSE248=null;
        expression_return expression245 = null;

        statement_return statement247 = null;

        statement_return statement249 = null;


        Object IF243_tree=null;
        Object LPAREN244_tree=null;
        Object RPAREN246_tree=null;
        Object ELSE248_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // JS.g:1464:2: ( IF LPAREN expression RPAREN statement ({...}? ELSE statement )? -> ^( IF expression ( statement )+ ) )
            // JS.g:1464:4: IF LPAREN expression RPAREN statement ({...}? ELSE statement )?
            {
            IF243=(Token)input.LT(1);
            match(input,IF,FOLLOW_IF_in_ifStatement6064); 
            stream_IF.add(IF243);

            LPAREN244=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_ifStatement6066); 
            stream_LPAREN.add(LPAREN244);

            pushFollow(FOLLOW_expression_in_ifStatement6068);
            expression245=expression();
            _fsp--;

            stream_expression.add(expression245.getTree());
            RPAREN246=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_ifStatement6070); 
            stream_RPAREN.add(RPAREN246);

            pushFollow(FOLLOW_statement_in_ifStatement6072);
            statement247=statement();
            _fsp--;

            stream_statement.add(statement247.getTree());
            // JS.g:1464:42: ({...}? ELSE statement )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==ELSE) ) {
                int LA62_1 = input.LA(2);

                if ( ( input.LA(1) == ELSE ) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // JS.g:1464:44: {...}? ELSE statement
                    {
                    if ( !( input.LA(1) == ELSE ) ) {
                        throw new FailedPredicateException(input, "ifStatement", " input.LA(1) == ELSE ");
                    }
                    ELSE248=(Token)input.LT(1);
                    match(input,ELSE,FOLLOW_ELSE_in_ifStatement6078); 
                    stream_ELSE.add(ELSE248);

                    pushFollow(FOLLOW_statement_in_ifStatement6080);
                    statement249=statement();
                    _fsp--;

                    stream_statement.add(statement249.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: expression, IF, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1465:2: -> ^( IF expression ( statement )+ )
            {
                // JS.g:1465:5: ^( IF expression ( statement )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_IF.next(), root_1);

                adaptor.addChild(root_1, stream_expression.next());
                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.next());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end ifStatement

    public static class iterationStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start iterationStatement
    // JS.g:1472:1: iterationStatement : ( doStatement | whileStatement | forEachStatement | forStatement );
    public final iterationStatement_return iterationStatement() throws RecognitionException {
        iterationStatement_return retval = new iterationStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        doStatement_return doStatement250 = null;

        whileStatement_return whileStatement251 = null;

        forEachStatement_return forEachStatement252 = null;

        forStatement_return forStatement253 = null;



        try {
            // JS.g:1473:2: ( doStatement | whileStatement | forEachStatement | forStatement )
            int alt63=4;
            switch ( input.LA(1) ) {
            case DO:
                {
                alt63=1;
                }
                break;
            case WHILE:
                {
                alt63=2;
                }
                break;
            case FOR:
                {
                int LA63_3 = input.LA(2);

                if ( (LA63_3==LPAREN) ) {
                    alt63=4;
                }
                else if ( (LA63_3==EACH) ) {
                    alt63=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1472:1: iterationStatement : ( doStatement | whileStatement | forEachStatement | forStatement );", 63, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1472:1: iterationStatement : ( doStatement | whileStatement | forEachStatement | forStatement );", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // JS.g:1473:4: doStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_doStatement_in_iterationStatement6113);
                    doStatement250=doStatement();
                    _fsp--;

                    adaptor.addChild(root_0, doStatement250.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1474:4: whileStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_iterationStatement6118);
                    whileStatement251=whileStatement();
                    _fsp--;

                    adaptor.addChild(root_0, whileStatement251.getTree());

                    }
                    break;
                case 3 :
                    // JS.g:1475:4: forEachStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forEachStatement_in_iterationStatement6123);
                    forEachStatement252=forEachStatement();
                    _fsp--;

                    adaptor.addChild(root_0, forEachStatement252.getTree());

                    }
                    break;
                case 4 :
                    // JS.g:1476:4: forStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_iterationStatement6128);
                    forStatement253=forStatement();
                    _fsp--;

                    adaptor.addChild(root_0, forStatement253.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end iterationStatement

    public static class doStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start doStatement
    // JS.g:1479:1: doStatement : DO statement WHILE LPAREN expression RPAREN semic -> ^( DO statement expression ) ;
    public final doStatement_return doStatement() throws RecognitionException {
        doStatement_return retval = new doStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DO254=null;
        Token WHILE256=null;
        Token LPAREN257=null;
        Token RPAREN259=null;
        statement_return statement255 = null;

        expression_return expression258 = null;

        semic_return semic260 = null;


        Object DO254_tree=null;
        Object WHILE256_tree=null;
        Object LPAREN257_tree=null;
        Object RPAREN259_tree=null;
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_semic=new RewriteRuleSubtreeStream(adaptor,"rule semic");
        try {
            // JS.g:1480:2: ( DO statement WHILE LPAREN expression RPAREN semic -> ^( DO statement expression ) )
            // JS.g:1480:4: DO statement WHILE LPAREN expression RPAREN semic
            {
            DO254=(Token)input.LT(1);
            match(input,DO,FOLLOW_DO_in_doStatement6140); 
            stream_DO.add(DO254);

            pushFollow(FOLLOW_statement_in_doStatement6142);
            statement255=statement();
            _fsp--;

            stream_statement.add(statement255.getTree());
            WHILE256=(Token)input.LT(1);
            match(input,WHILE,FOLLOW_WHILE_in_doStatement6144); 
            stream_WHILE.add(WHILE256);

            LPAREN257=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_doStatement6146); 
            stream_LPAREN.add(LPAREN257);

            pushFollow(FOLLOW_expression_in_doStatement6148);
            expression258=expression();
            _fsp--;

            stream_expression.add(expression258.getTree());
            RPAREN259=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_doStatement6150); 
            stream_RPAREN.add(RPAREN259);

            pushFollow(FOLLOW_semic_in_doStatement6152);
            semic260=semic();
            _fsp--;

            stream_semic.add(semic260.getTree());

            // AST REWRITE
            // elements: DO, statement, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1481:2: -> ^( DO statement expression )
            {
                // JS.g:1481:5: ^( DO statement expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_DO.next(), root_1);

                adaptor.addChild(root_1, stream_statement.next());
                adaptor.addChild(root_1, stream_expression.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end doStatement

    public static class whileStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start whileStatement
    // JS.g:1484:1: whileStatement : WHILE LPAREN expression RPAREN statement ;
    public final whileStatement_return whileStatement() throws RecognitionException {
        whileStatement_return retval = new whileStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHILE261=null;
        Token LPAREN262=null;
        Token RPAREN264=null;
        expression_return expression263 = null;

        statement_return statement265 = null;


        Object WHILE261_tree=null;
        Object LPAREN262_tree=null;
        Object RPAREN264_tree=null;

        try {
            // JS.g:1485:2: ( WHILE LPAREN expression RPAREN statement )
            // JS.g:1485:4: WHILE LPAREN expression RPAREN statement
            {
            root_0 = (Object)adaptor.nil();

            WHILE261=(Token)input.LT(1);
            match(input,WHILE,FOLLOW_WHILE_in_whileStatement6177); 
            WHILE261_tree = (Object)adaptor.create(WHILE261);
            root_0 = (Object)adaptor.becomeRoot(WHILE261_tree, root_0);

            LPAREN262=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_whileStatement6180); 
            pushFollow(FOLLOW_expression_in_whileStatement6183);
            expression263=expression();
            _fsp--;

            adaptor.addChild(root_0, expression263.getTree());
            RPAREN264=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_whileStatement6185); 
            pushFollow(FOLLOW_statement_in_whileStatement6188);
            statement265=statement();
            _fsp--;

            adaptor.addChild(root_0, statement265.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end whileStatement

    public static class forEachStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forEachStatement
    // JS.g:1530:1: forEachStatement : forKeyword= FOR EACH LPAREN forEachControl RPAREN statement -> ^( FOREACH[$forKeyword] forEachControl statement ) ;
    public final forEachStatement_return forEachStatement() throws RecognitionException {
        forEachStatement_return retval = new forEachStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token forKeyword=null;
        Token EACH266=null;
        Token LPAREN267=null;
        Token RPAREN269=null;
        forEachControl_return forEachControl268 = null;

        statement_return statement270 = null;


        Object forKeyword_tree=null;
        Object EACH266_tree=null;
        Object LPAREN267_tree=null;
        Object RPAREN269_tree=null;
        RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_EACH=new RewriteRuleTokenStream(adaptor,"token EACH");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_forEachControl=new RewriteRuleSubtreeStream(adaptor,"rule forEachControl");
        try {
            // JS.g:1531:3: (forKeyword= FOR EACH LPAREN forEachControl RPAREN statement -> ^( FOREACH[$forKeyword] forEachControl statement ) )
            // JS.g:1531:5: forKeyword= FOR EACH LPAREN forEachControl RPAREN statement
            {
            forKeyword=(Token)input.LT(1);
            match(input,FOR,FOLLOW_FOR_in_forEachStatement6205); 
            stream_FOR.add(forKeyword);

            EACH266=(Token)input.LT(1);
            match(input,EACH,FOLLOW_EACH_in_forEachStatement6207); 
            stream_EACH.add(EACH266);

            LPAREN267=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_forEachStatement6209); 
            stream_LPAREN.add(LPAREN267);

            pushFollow(FOLLOW_forEachControl_in_forEachStatement6211);
            forEachControl268=forEachControl();
            _fsp--;

            stream_forEachControl.add(forEachControl268.getTree());
            RPAREN269=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_forEachStatement6213); 
            stream_RPAREN.add(RPAREN269);

            pushFollow(FOLLOW_statement_in_forEachStatement6215);
            statement270=statement();
            _fsp--;

            stream_statement.add(statement270.getTree());

            // AST REWRITE
            // elements: forEachControl, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1532:4: -> ^( FOREACH[$forKeyword] forEachControl statement )
            {
                // JS.g:1532:7: ^( FOREACH[$forKeyword] forEachControl statement )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FOREACH, forKeyword), root_1);

                adaptor.addChild(root_1, stream_forEachControl.next());
                adaptor.addChild(root_1, stream_statement.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end forEachStatement

    public static class forEachControl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forEachControl
    // JS.g:1535:1: forEachControl : ( forControlVar | forControlExpression );
    public final forEachControl_return forEachControl() throws RecognitionException {
        forEachControl_return retval = new forEachControl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        forControlVar_return forControlVar271 = null;

        forControlExpression_return forControlExpression272 = null;



        try {
            // JS.g:1536:3: ( forControlVar | forControlExpression )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==VAR) ) {
                alt64=1;
            }
            else if ( ((LA64_0>=NULL && LA64_0<=FALSE)||LA64_0==EACH||LA64_0==THIS||(LA64_0>=GET && LA64_0<=SET)||(LA64_0>=WXML && LA64_0<=CLASS)||(LA64_0>=DEBUGGER && LA64_0<=VOLATILE)||LA64_0==AT||LA64_0==StringLiteral||(LA64_0>=Identifier && LA64_0<=RegularExpressionLiteral)||(LA64_0>=DecimalLiteral && LA64_0<=HexIntegerLiteral)) ) {
                alt64=2;
            }
            else if ( ((LA64_0>=XMLFragment && LA64_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt64=2;
            }
            else if ( (LA64_0==DELETE||LA64_0==FUNCTION||LA64_0==NEW||LA64_0==TYPEOF||LA64_0==VOID||LA64_0==YIELD||LA64_0==LBRACE||LA64_0==LPAREN||LA64_0==LBRACK||(LA64_0>=ADD && LA64_0<=SUB)||(LA64_0>=INC && LA64_0<=DEC)||(LA64_0>=NOT && LA64_0<=INV)) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1535:1: forEachControl : ( forControlVar | forControlExpression );", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // JS.g:1536:5: forControlVar
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forControlVar_in_forEachControl6243);
                    forControlVar271=forControlVar();
                    _fsp--;

                    adaptor.addChild(root_0, forControlVar271.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1537:5: forControlExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forControlExpression_in_forEachControl6249);
                    forControlExpression272=forControlExpression();
                    _fsp--;

                    adaptor.addChild(root_0, forControlExpression272.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end forEachControl

    public static class forStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forStatement
    // JS.g:1540:1: forStatement : FOR LPAREN forControl RPAREN statement ;
    public final forStatement_return forStatement() throws RecognitionException {
        forStatement_return retval = new forStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FOR273=null;
        Token LPAREN274=null;
        Token RPAREN276=null;
        forControl_return forControl275 = null;

        statement_return statement277 = null;


        Object FOR273_tree=null;
        Object LPAREN274_tree=null;
        Object RPAREN276_tree=null;

        try {
            // JS.g:1541:2: ( FOR LPAREN forControl RPAREN statement )
            // JS.g:1541:4: FOR LPAREN forControl RPAREN statement
            {
            root_0 = (Object)adaptor.nil();

            FOR273=(Token)input.LT(1);
            match(input,FOR,FOLLOW_FOR_in_forStatement6261); 
            FOR273_tree = (Object)adaptor.create(FOR273);
            root_0 = (Object)adaptor.becomeRoot(FOR273_tree, root_0);

            LPAREN274=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_forStatement6264); 
            pushFollow(FOLLOW_forControl_in_forStatement6267);
            forControl275=forControl();
            _fsp--;

            adaptor.addChild(root_0, forControl275.getTree());
            RPAREN276=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_forStatement6269); 
            pushFollow(FOLLOW_statement_in_forStatement6272);
            statement277=statement();
            _fsp--;

            adaptor.addChild(root_0, statement277.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end forStatement

    public static class forControl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forControl
    // JS.g:1544:1: forControl : ( forControlVar | forControlExpression | forControlSemic );
    public final forControl_return forControl() throws RecognitionException {
        forControl_return retval = new forControl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        forControlVar_return forControlVar278 = null;

        forControlExpression_return forControlExpression279 = null;

        forControlSemic_return forControlSemic280 = null;



        try {
            // JS.g:1545:2: ( forControlVar | forControlExpression | forControlSemic )
            int alt65=3;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==VAR) ) {
                alt65=1;
            }
            else if ( ((LA65_0>=NULL && LA65_0<=FALSE)||LA65_0==EACH||LA65_0==THIS||(LA65_0>=GET && LA65_0<=SET)||(LA65_0>=WXML && LA65_0<=CLASS)||(LA65_0>=DEBUGGER && LA65_0<=VOLATILE)||LA65_0==AT||LA65_0==StringLiteral||(LA65_0>=Identifier && LA65_0<=RegularExpressionLiteral)||(LA65_0>=DecimalLiteral && LA65_0<=HexIntegerLiteral)) ) {
                alt65=2;
            }
            else if ( ((LA65_0>=XMLFragment && LA65_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt65=2;
            }
            else if ( (LA65_0==DELETE||LA65_0==FUNCTION||LA65_0==NEW||LA65_0==TYPEOF||LA65_0==VOID||LA65_0==YIELD||LA65_0==LBRACE||LA65_0==LPAREN||LA65_0==LBRACK||(LA65_0>=ADD && LA65_0<=SUB)||(LA65_0>=INC && LA65_0<=DEC)||(LA65_0>=NOT && LA65_0<=INV)) ) {
                alt65=2;
            }
            else if ( (LA65_0==SEMIC) ) {
                alt65=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1544:1: forControl : ( forControlVar | forControlExpression | forControlSemic );", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // JS.g:1545:4: forControlVar
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forControlVar_in_forControl6283);
                    forControlVar278=forControlVar();
                    _fsp--;

                    adaptor.addChild(root_0, forControlVar278.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1546:4: forControlExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forControlExpression_in_forControl6288);
                    forControlExpression279=forControlExpression();
                    _fsp--;

                    adaptor.addChild(root_0, forControlExpression279.getTree());

                    }
                    break;
                case 3 :
                    // JS.g:1547:4: forControlSemic
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forControlSemic_in_forControl6293);
                    forControlSemic280=forControlSemic();
                    _fsp--;

                    adaptor.addChild(root_0, forControlSemic280.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end forControl

    public static class forControlVar_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forControlVar
    // JS.g:1550:1: forControlVar : VAR variableDeclarationNoIn ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) ) ) ) ;
    public final forControlVar_return forControlVar() throws RecognitionException {
        forControlVar_return retval = new forControlVar_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token semi1=null;
        Token semi2=null;
        Token VAR281=null;
        Token IN283=null;
        Token COMMA285=null;
        expression_return ex1 = null;

        expression_return ex2 = null;

        variableDeclarationNoIn_return variableDeclarationNoIn282 = null;

        expression_return expression284 = null;

        variableDeclarationNoIn_return variableDeclarationNoIn286 = null;


        Object semi1_tree=null;
        Object semi2_tree=null;
        Object VAR281_tree=null;
        Object IN283_tree=null;
        Object COMMA285_tree=null;
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_variableDeclarationNoIn=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclarationNoIn");
        try {
            // JS.g:1551:2: ( VAR variableDeclarationNoIn ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) ) ) ) )
            // JS.g:1551:4: VAR variableDeclarationNoIn ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) ) ) )
            {
            VAR281=(Token)input.LT(1);
            match(input,VAR,FOLLOW_VAR_in_forControlVar6304); 
            stream_VAR.add(VAR281);

            pushFollow(FOLLOW_variableDeclarationNoIn_in_forControlVar6306);
            variableDeclarationNoIn282=variableDeclarationNoIn();
            _fsp--;

            stream_variableDeclarationNoIn.add(variableDeclarationNoIn282.getTree());
            // JS.g:1552:2: ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==IN) ) {
                alt69=1;
            }
            else if ( ((LA69_0>=SEMIC && LA69_0<=COMMA)) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1552:2: ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) ) ) )", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // JS.g:1553:3: ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) )
                    {
                    // JS.g:1553:3: ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) )
                    // JS.g:1554:4: IN expression
                    {
                    IN283=(Token)input.LT(1);
                    match(input,IN,FOLLOW_IN_in_forControlVar6318); 
                    stream_IN.add(IN283);

                    pushFollow(FOLLOW_expression_in_forControlVar6320);
                    expression284=expression();
                    _fsp--;

                    stream_expression.add(expression284.getTree());

                    // AST REWRITE
                    // elements: variableDeclarationNoIn, expression, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1555:4: -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) )
                    {
                        // JS.g:1555:7: ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(FORITER, "FORITER"), root_1);

                        // JS.g:1555:18: ^( VAR variableDeclarationNoIn )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(stream_VAR.next(), root_2);

                        adaptor.addChild(root_2, stream_variableDeclarationNoIn.next());

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1555:51: ^( EXPR expression )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_expression.next());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }


                    }
                    break;
                case 2 :
                    // JS.g:1558:3: ( ( COMMA variableDeclarationNoIn )* semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) ) )
                    {
                    // JS.g:1558:3: ( ( COMMA variableDeclarationNoIn )* semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) ) )
                    // JS.g:1559:4: ( COMMA variableDeclarationNoIn )* semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )?
                    {
                    // JS.g:1559:4: ( COMMA variableDeclarationNoIn )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==COMMA) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // JS.g:1559:6: COMMA variableDeclarationNoIn
                    	    {
                    	    COMMA285=(Token)input.LT(1);
                    	    match(input,COMMA,FOLLOW_COMMA_in_forControlVar6366); 
                    	    stream_COMMA.add(COMMA285);

                    	    pushFollow(FOLLOW_variableDeclarationNoIn_in_forControlVar6368);
                    	    variableDeclarationNoIn286=variableDeclarationNoIn();
                    	    _fsp--;

                    	    stream_variableDeclarationNoIn.add(variableDeclarationNoIn286.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);

                    semi1=(Token)input.LT(1);
                    match(input,SEMIC,FOLLOW_SEMIC_in_forControlVar6375); 
                    stream_SEMIC.add(semi1);

                    // JS.g:1559:54: (ex1= expression )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( ((LA67_0>=NULL && LA67_0<=FALSE)||LA67_0==EACH||LA67_0==THIS||(LA67_0>=GET && LA67_0<=SET)||(LA67_0>=WXML && LA67_0<=CLASS)||(LA67_0>=DEBUGGER && LA67_0<=VOLATILE)||LA67_0==AT||LA67_0==StringLiteral||(LA67_0>=Identifier && LA67_0<=RegularExpressionLiteral)||(LA67_0>=DecimalLiteral && LA67_0<=HexIntegerLiteral)) ) {
                        alt67=1;
                    }
                    else if ( ((LA67_0>=XMLFragment && LA67_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                        alt67=1;
                    }
                    else if ( (LA67_0==DELETE||LA67_0==FUNCTION||LA67_0==NEW||LA67_0==TYPEOF||LA67_0==VOID||LA67_0==YIELD||LA67_0==LBRACE||LA67_0==LPAREN||LA67_0==LBRACK||(LA67_0>=ADD && LA67_0<=SUB)||(LA67_0>=INC && LA67_0<=DEC)||(LA67_0>=NOT && LA67_0<=INV)) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // JS.g:1559:54: ex1= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlVar6379);
                            ex1=expression();
                            _fsp--;

                            stream_expression.add(ex1.getTree());

                            }
                            break;

                    }

                    semi2=(Token)input.LT(1);
                    match(input,SEMIC,FOLLOW_SEMIC_in_forControlVar6384); 
                    stream_SEMIC.add(semi2);

                    // JS.g:1559:82: (ex2= expression )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( ((LA68_0>=NULL && LA68_0<=FALSE)||LA68_0==EACH||LA68_0==THIS||(LA68_0>=GET && LA68_0<=SET)||(LA68_0>=WXML && LA68_0<=CLASS)||(LA68_0>=DEBUGGER && LA68_0<=VOLATILE)||LA68_0==AT||LA68_0==StringLiteral||(LA68_0>=Identifier && LA68_0<=RegularExpressionLiteral)||(LA68_0>=DecimalLiteral && LA68_0<=HexIntegerLiteral)) ) {
                        alt68=1;
                    }
                    else if ( ((LA68_0>=XMLFragment && LA68_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                        alt68=1;
                    }
                    else if ( (LA68_0==DELETE||LA68_0==FUNCTION||LA68_0==NEW||LA68_0==TYPEOF||LA68_0==VOID||LA68_0==YIELD||LA68_0==LBRACE||LA68_0==LPAREN||LA68_0==LBRACK||(LA68_0>=ADD && LA68_0<=SUB)||(LA68_0>=INC && LA68_0<=DEC)||(LA68_0>=NOT && LA68_0<=INV)) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // JS.g:1559:82: ex2= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlVar6388);
                            ex2=expression();
                            _fsp--;

                            stream_expression.add(ex2.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: semi2, semi1, VAR, variableDeclarationNoIn, ex2, ex1
                    // token labels: semi2, semi1
                    // rule labels: retval, ex2, ex1
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_semi2=new RewriteRuleTokenStream(adaptor,"token semi2",semi2);
                    RewriteRuleTokenStream stream_semi1=new RewriteRuleTokenStream(adaptor,"token semi1",semi1);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
                    RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1560:4: -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) )
                    {
                        // JS.g:1560:7: ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(FORSTEP, "FORSTEP"), root_1);

                        // JS.g:1560:18: ^( VAR ( variableDeclarationNoIn )+ )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(stream_VAR.next(), root_2);

                        if ( !(stream_variableDeclarationNoIn.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_variableDeclarationNoIn.hasNext() ) {
                            adaptor.addChild(root_2, stream_variableDeclarationNoIn.next());

                        }
                        stream_variableDeclarationNoIn.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1560:52: ^( $semi1)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(stream_semi1.next(), root_2);

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1560:64: ^( EXPR ( $ex1)? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                        // JS.g:1560:72: ( $ex1)?
                        if ( stream_ex1.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex1.next());

                        }
                        stream_ex1.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1560:80: ^( $semi2)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(stream_semi2.next(), root_2);

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1560:92: ^( EXPR ( $ex2)? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                        // JS.g:1560:100: ( $ex2)?
                        if ( stream_ex2.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex2.next());

                        }
                        stream_ex2.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end forControlVar

    public static class forControlExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forControlExpression
    // JS.g:1565:1: forControlExpression : ex1= expressionNoIn ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | (semi1= SEMIC (ex2= expression )? semi2= SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( $semi1) ^( EXPR ( $ex2)? ) ^( $semi2) ^( EXPR ( $ex3)? ) ) ) ) ;
    public final forControlExpression_return forControlExpression() throws RecognitionException {
        forControlExpression_return retval = new forControlExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token semi1=null;
        Token semi2=null;
        Token IN287=null;
        expressionNoIn_return ex1 = null;

        expression_return ex2 = null;

        expression_return ex3 = null;


        Object semi1_tree=null;
        Object semi2_tree=null;
        Object IN287_tree=null;
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_expressionNoIn=new RewriteRuleSubtreeStream(adaptor,"rule expressionNoIn");

        	Object[] isLhs = new Object[1];

        try {
            // JS.g:1570:2: (ex1= expressionNoIn ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | (semi1= SEMIC (ex2= expression )? semi2= SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( $semi1) ^( EXPR ( $ex2)? ) ^( $semi2) ^( EXPR ( $ex3)? ) ) ) ) )
            // JS.g:1570:4: ex1= expressionNoIn ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | (semi1= SEMIC (ex2= expression )? semi2= SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( $semi1) ^( EXPR ( $ex2)? ) ^( $semi2) ^( EXPR ( $ex3)? ) ) ) )
            {
            pushFollow(FOLLOW_expressionNoIn_in_forControlExpression6468);
            ex1=expressionNoIn();
            _fsp--;

            stream_expressionNoIn.add(ex1.getTree());
            // JS.g:1571:2: ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | (semi1= SEMIC (ex2= expression )? semi2= SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( $semi1) ^( EXPR ( $ex2)? ) ^( $semi2) ^( EXPR ( $ex3)? ) ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==IN) ) {
                alt72=1;
            }
            else if ( (LA72_0==SEMIC) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1571:2: ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | (semi1= SEMIC (ex2= expression )? semi2= SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( $semi1) ^( EXPR ( $ex2)? ) ^( $semi2) ^( EXPR ( $ex3)? ) ) ) )", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // JS.g:1572:3: {...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) )
                    {
                    if ( !( isLeftHandSideIn(ex1, isLhs) ) ) {
                        throw new FailedPredicateException(input, "forControlExpression", " isLeftHandSideIn(ex1, isLhs) ");
                    }
                    // JS.g:1572:37: ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) )
                    // JS.g:1573:4: IN ex2= expression
                    {
                    IN287=(Token)input.LT(1);
                    match(input,IN,FOLLOW_IN_in_forControlExpression6483); 
                    stream_IN.add(IN287);

                    pushFollow(FOLLOW_expression_in_forControlExpression6487);
                    ex2=expression();
                    _fsp--;

                    stream_expression.add(ex2.getTree());

                    // AST REWRITE
                    // elements: ex2, ex1
                    // token labels: 
                    // rule labels: retval, ex2, ex1
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
                    RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1574:4: -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) )
                    {
                        // JS.g:1574:7: ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(FORITER, "FORITER"), root_1);

                        // JS.g:1574:18: ^( EXPR $ex1)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_ex1.next());

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1574:33: ^( EXPR $ex2)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_ex2.next());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }


                    }
                    break;
                case 2 :
                    // JS.g:1577:3: (semi1= SEMIC (ex2= expression )? semi2= SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( $semi1) ^( EXPR ( $ex2)? ) ^( $semi2) ^( EXPR ( $ex3)? ) ) )
                    {
                    // JS.g:1577:3: (semi1= SEMIC (ex2= expression )? semi2= SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( $semi1) ^( EXPR ( $ex2)? ) ^( $semi2) ^( EXPR ( $ex3)? ) ) )
                    // JS.g:1578:4: semi1= SEMIC (ex2= expression )? semi2= SEMIC (ex3= expression )?
                    {
                    semi1=(Token)input.LT(1);
                    match(input,SEMIC,FOLLOW_SEMIC_in_forControlExpression6535); 
                    stream_SEMIC.add(semi1);

                    // JS.g:1578:19: (ex2= expression )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( ((LA70_0>=NULL && LA70_0<=FALSE)||LA70_0==EACH||LA70_0==THIS||(LA70_0>=GET && LA70_0<=SET)||(LA70_0>=WXML && LA70_0<=CLASS)||(LA70_0>=DEBUGGER && LA70_0<=VOLATILE)||LA70_0==AT||LA70_0==StringLiteral||(LA70_0>=Identifier && LA70_0<=RegularExpressionLiteral)||(LA70_0>=DecimalLiteral && LA70_0<=HexIntegerLiteral)) ) {
                        alt70=1;
                    }
                    else if ( ((LA70_0>=XMLFragment && LA70_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                        alt70=1;
                    }
                    else if ( (LA70_0==DELETE||LA70_0==FUNCTION||LA70_0==NEW||LA70_0==TYPEOF||LA70_0==VOID||LA70_0==YIELD||LA70_0==LBRACE||LA70_0==LPAREN||LA70_0==LBRACK||(LA70_0>=ADD && LA70_0<=SUB)||(LA70_0>=INC && LA70_0<=DEC)||(LA70_0>=NOT && LA70_0<=INV)) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // JS.g:1578:19: ex2= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlExpression6539);
                            ex2=expression();
                            _fsp--;

                            stream_expression.add(ex2.getTree());

                            }
                            break;

                    }

                    semi2=(Token)input.LT(1);
                    match(input,SEMIC,FOLLOW_SEMIC_in_forControlExpression6544); 
                    stream_SEMIC.add(semi2);

                    // JS.g:1578:47: (ex3= expression )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( ((LA71_0>=NULL && LA71_0<=FALSE)||LA71_0==EACH||LA71_0==THIS||(LA71_0>=GET && LA71_0<=SET)||(LA71_0>=WXML && LA71_0<=CLASS)||(LA71_0>=DEBUGGER && LA71_0<=VOLATILE)||LA71_0==AT||LA71_0==StringLiteral||(LA71_0>=Identifier && LA71_0<=RegularExpressionLiteral)||(LA71_0>=DecimalLiteral && LA71_0<=HexIntegerLiteral)) ) {
                        alt71=1;
                    }
                    else if ( ((LA71_0>=XMLFragment && LA71_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                        alt71=1;
                    }
                    else if ( (LA71_0==DELETE||LA71_0==FUNCTION||LA71_0==NEW||LA71_0==TYPEOF||LA71_0==VOID||LA71_0==YIELD||LA71_0==LBRACE||LA71_0==LPAREN||LA71_0==LBRACK||(LA71_0>=ADD && LA71_0<=SUB)||(LA71_0>=INC && LA71_0<=DEC)||(LA71_0>=NOT && LA71_0<=INV)) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // JS.g:1578:47: ex3= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlExpression6548);
                            ex3=expression();
                            _fsp--;

                            stream_expression.add(ex3.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: semi2, semi1, ex1, ex2, ex3
                    // token labels: semi2, semi1
                    // rule labels: retval, ex3, ex2, ex1
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_semi2=new RewriteRuleTokenStream(adaptor,"token semi2",semi2);
                    RewriteRuleTokenStream stream_semi1=new RewriteRuleTokenStream(adaptor,"token semi1",semi1);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ex3=new RewriteRuleSubtreeStream(adaptor,"token ex3",ex3!=null?ex3.tree:null);
                    RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
                    RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1579:4: -> ^( FORSTEP ^( EXPR $ex1) ^( $semi1) ^( EXPR ( $ex2)? ) ^( $semi2) ^( EXPR ( $ex3)? ) )
                    {
                        // JS.g:1579:7: ^( FORSTEP ^( EXPR $ex1) ^( $semi1) ^( EXPR ( $ex2)? ) ^( $semi2) ^( EXPR ( $ex3)? ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(FORSTEP, "FORSTEP"), root_1);

                        // JS.g:1579:18: ^( EXPR $ex1)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_ex1.next());

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1579:33: ^( $semi1)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(stream_semi1.next(), root_2);

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1579:45: ^( EXPR ( $ex2)? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                        // JS.g:1579:53: ( $ex2)?
                        if ( stream_ex2.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex2.next());

                        }
                        stream_ex2.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1579:61: ^( $semi2)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(stream_semi2.next(), root_2);

                        adaptor.addChild(root_1, root_2);
                        }
                        // JS.g:1579:73: ^( EXPR ( $ex3)? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                        // JS.g:1579:81: ( $ex3)?
                        if ( stream_ex3.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex3.next());

                        }
                        stream_ex3.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end forControlExpression

    public static class forControlSemic_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start forControlSemic
    // JS.g:1584:1: forControlSemic : semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )? -> ^( FORSTEP ^( EXPR ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) ) ;
    public final forControlSemic_return forControlSemic() throws RecognitionException {
        forControlSemic_return retval = new forControlSemic_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token semi1=null;
        Token semi2=null;
        expression_return ex1 = null;

        expression_return ex2 = null;


        Object semi1_tree=null;
        Object semi2_tree=null;
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // JS.g:1585:2: (semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )? -> ^( FORSTEP ^( EXPR ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) ) )
            // JS.g:1585:4: semi1= SEMIC (ex1= expression )? semi2= SEMIC (ex2= expression )?
            {
            semi1=(Token)input.LT(1);
            match(input,SEMIC,FOLLOW_SEMIC_in_forControlSemic6623); 
            stream_SEMIC.add(semi1);

            // JS.g:1585:19: (ex1= expression )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=NULL && LA73_0<=FALSE)||LA73_0==EACH||LA73_0==THIS||(LA73_0>=GET && LA73_0<=SET)||(LA73_0>=WXML && LA73_0<=CLASS)||(LA73_0>=DEBUGGER && LA73_0<=VOLATILE)||LA73_0==AT||LA73_0==StringLiteral||(LA73_0>=Identifier && LA73_0<=RegularExpressionLiteral)||(LA73_0>=DecimalLiteral && LA73_0<=HexIntegerLiteral)) ) {
                alt73=1;
            }
            else if ( ((LA73_0>=XMLFragment && LA73_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt73=1;
            }
            else if ( (LA73_0==DELETE||LA73_0==FUNCTION||LA73_0==NEW||LA73_0==TYPEOF||LA73_0==VOID||LA73_0==YIELD||LA73_0==LBRACE||LA73_0==LPAREN||LA73_0==LBRACK||(LA73_0>=ADD && LA73_0<=SUB)||(LA73_0>=INC && LA73_0<=DEC)||(LA73_0>=NOT && LA73_0<=INV)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // JS.g:1585:19: ex1= expression
                    {
                    pushFollow(FOLLOW_expression_in_forControlSemic6627);
                    ex1=expression();
                    _fsp--;

                    stream_expression.add(ex1.getTree());

                    }
                    break;

            }

            semi2=(Token)input.LT(1);
            match(input,SEMIC,FOLLOW_SEMIC_in_forControlSemic6632); 
            stream_SEMIC.add(semi2);

            // JS.g:1585:47: (ex2= expression )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=NULL && LA74_0<=FALSE)||LA74_0==EACH||LA74_0==THIS||(LA74_0>=GET && LA74_0<=SET)||(LA74_0>=WXML && LA74_0<=CLASS)||(LA74_0>=DEBUGGER && LA74_0<=VOLATILE)||LA74_0==AT||LA74_0==StringLiteral||(LA74_0>=Identifier && LA74_0<=RegularExpressionLiteral)||(LA74_0>=DecimalLiteral && LA74_0<=HexIntegerLiteral)) ) {
                alt74=1;
            }
            else if ( ((LA74_0>=XMLFragment && LA74_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt74=1;
            }
            else if ( (LA74_0==DELETE||LA74_0==FUNCTION||LA74_0==NEW||LA74_0==TYPEOF||LA74_0==VOID||LA74_0==YIELD||LA74_0==LBRACE||LA74_0==LPAREN||LA74_0==LBRACK||(LA74_0>=ADD && LA74_0<=SUB)||(LA74_0>=INC && LA74_0<=DEC)||(LA74_0>=NOT && LA74_0<=INV)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // JS.g:1585:47: ex2= expression
                    {
                    pushFollow(FOLLOW_expression_in_forControlSemic6636);
                    ex2=expression();
                    _fsp--;

                    stream_expression.add(ex2.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: ex1, semi1, ex2, semi2
            // token labels: semi2, semi1
            // rule labels: retval, ex2, ex1
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_semi2=new RewriteRuleTokenStream(adaptor,"token semi2",semi2);
            RewriteRuleTokenStream stream_semi1=new RewriteRuleTokenStream(adaptor,"token semi1",semi1);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
            RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1586:2: -> ^( FORSTEP ^( EXPR ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) )
            {
                // JS.g:1586:5: ^( FORSTEP ^( EXPR ) ^( $semi1) ^( EXPR ( $ex1)? ) ^( $semi2) ^( EXPR ( $ex2)? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FORSTEP, "FORSTEP"), root_1);

                // JS.g:1586:16: ^( EXPR )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // JS.g:1586:26: ^( $semi1)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(stream_semi1.next(), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // JS.g:1586:38: ^( EXPR ( $ex1)? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                // JS.g:1586:46: ( $ex1)?
                if ( stream_ex1.hasNext() ) {
                    adaptor.addChild(root_2, stream_ex1.next());

                }
                stream_ex1.reset();

                adaptor.addChild(root_1, root_2);
                }
                // JS.g:1586:54: ^( $semi2)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(stream_semi2.next(), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // JS.g:1586:66: ^( EXPR ( $ex2)? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(EXPR, "EXPR"), root_2);

                // JS.g:1586:74: ( $ex2)?
                if ( stream_ex2.hasNext() ) {
                    adaptor.addChild(root_2, stream_ex2.next());

                }
                stream_ex2.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end forControlSemic

    public static class continueStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start continueStatement
    // JS.g:1598:1: continueStatement : CONTINUE ( Identifier )? semic ;
    public final continueStatement_return continueStatement() throws RecognitionException {
        continueStatement_return retval = new continueStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CONTINUE288=null;
        Token Identifier289=null;
        semic_return semic290 = null;


        Object CONTINUE288_tree=null;
        Object Identifier289_tree=null;

        try {
            // JS.g:1599:2: ( CONTINUE ( Identifier )? semic )
            // JS.g:1599:4: CONTINUE ( Identifier )? semic
            {
            root_0 = (Object)adaptor.nil();

            CONTINUE288=(Token)input.LT(1);
            match(input,CONTINUE,FOLLOW_CONTINUE_in_continueStatement6704); 
            CONTINUE288_tree = (Object)adaptor.create(CONTINUE288);
            root_0 = (Object)adaptor.becomeRoot(CONTINUE288_tree, root_0);

             if (input.LA(1) == Identifier) promoteEOL(null); 
            // JS.g:1599:67: ( Identifier )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==Identifier) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // JS.g:1599:67: Identifier
                    {
                    Identifier289=(Token)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_continueStatement6709); 
                    Identifier289_tree = (Object)adaptor.create(Identifier289);
                    adaptor.addChild(root_0, Identifier289_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_semic_in_continueStatement6712);
            semic290=semic();
            _fsp--;


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end continueStatement

    public static class breakStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start breakStatement
    // JS.g:1611:1: breakStatement : BREAK ( Identifier )? semic ;
    public final breakStatement_return breakStatement() throws RecognitionException {
        breakStatement_return retval = new breakStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BREAK291=null;
        Token Identifier292=null;
        semic_return semic293 = null;


        Object BREAK291_tree=null;
        Object Identifier292_tree=null;

        try {
            // JS.g:1612:2: ( BREAK ( Identifier )? semic )
            // JS.g:1612:4: BREAK ( Identifier )? semic
            {
            root_0 = (Object)adaptor.nil();

            BREAK291=(Token)input.LT(1);
            match(input,BREAK,FOLLOW_BREAK_in_breakStatement6731); 
            BREAK291_tree = (Object)adaptor.create(BREAK291);
            root_0 = (Object)adaptor.becomeRoot(BREAK291_tree, root_0);

             if (input.LA(1) == Identifier) promoteEOL(null); 
            // JS.g:1612:64: ( Identifier )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==Identifier) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // JS.g:1612:64: Identifier
                    {
                    Identifier292=(Token)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_breakStatement6736); 
                    Identifier292_tree = (Object)adaptor.create(Identifier292);
                    adaptor.addChild(root_0, Identifier292_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_semic_in_breakStatement6739);
            semic293=semic();
            _fsp--;


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end breakStatement

    public static class returnStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start returnStatement
    // JS.g:1632:1: returnStatement : RETURN ( expression )? semic ;
    public final returnStatement_return returnStatement() throws RecognitionException {
        returnStatement_return retval = new returnStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RETURN294=null;
        expression_return expression295 = null;

        semic_return semic296 = null;


        Object RETURN294_tree=null;

        try {
            // JS.g:1633:2: ( RETURN ( expression )? semic )
            // JS.g:1633:4: RETURN ( expression )? semic
            {
            root_0 = (Object)adaptor.nil();

            RETURN294=(Token)input.LT(1);
            match(input,RETURN,FOLLOW_RETURN_in_returnStatement6758); 
            RETURN294_tree = (Object)adaptor.create(RETURN294);
            root_0 = (Object)adaptor.becomeRoot(RETURN294_tree, root_0);

             promoteEOL(null); 
            // JS.g:1633:34: ( expression )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=NULL && LA77_0<=FALSE)||LA77_0==EACH||LA77_0==THIS||(LA77_0>=GET && LA77_0<=SET)||(LA77_0>=WXML && LA77_0<=CLASS)||(LA77_0>=DEBUGGER && LA77_0<=VOLATILE)||LA77_0==AT||LA77_0==StringLiteral||(LA77_0>=Identifier && LA77_0<=RegularExpressionLiteral)||(LA77_0>=DecimalLiteral && LA77_0<=HexIntegerLiteral)) ) {
                alt77=1;
            }
            else if ( ((LA77_0>=XMLFragment && LA77_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt77=1;
            }
            else if ( (LA77_0==DELETE||LA77_0==FUNCTION||LA77_0==NEW||LA77_0==TYPEOF||LA77_0==VOID||LA77_0==YIELD||LA77_0==LBRACE||LA77_0==LPAREN||LA77_0==LBRACK||(LA77_0>=ADD && LA77_0<=SUB)||(LA77_0>=INC && LA77_0<=DEC)||(LA77_0>=NOT && LA77_0<=INV)) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // JS.g:1633:34: expression
                    {
                    pushFollow(FOLLOW_expression_in_returnStatement6763);
                    expression295=expression();
                    _fsp--;

                    adaptor.addChild(root_0, expression295.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_semic_in_returnStatement6766);
            semic296=semic();
            _fsp--;


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end returnStatement

    public static class withStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start withStatement
    // JS.g:1640:1: withStatement : WITH LPAREN expression RPAREN statement ;
    public final withStatement_return withStatement() throws RecognitionException {
        withStatement_return retval = new withStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WITH297=null;
        Token LPAREN298=null;
        Token RPAREN300=null;
        expression_return expression299 = null;

        statement_return statement301 = null;


        Object WITH297_tree=null;
        Object LPAREN298_tree=null;
        Object RPAREN300_tree=null;

        try {
            // JS.g:1641:2: ( WITH LPAREN expression RPAREN statement )
            // JS.g:1641:4: WITH LPAREN expression RPAREN statement
            {
            root_0 = (Object)adaptor.nil();

            WITH297=(Token)input.LT(1);
            match(input,WITH,FOLLOW_WITH_in_withStatement6783); 
            WITH297_tree = (Object)adaptor.create(WITH297);
            root_0 = (Object)adaptor.becomeRoot(WITH297_tree, root_0);

            LPAREN298=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_withStatement6786); 
            pushFollow(FOLLOW_expression_in_withStatement6789);
            expression299=expression();
            _fsp--;

            adaptor.addChild(root_0, expression299.getTree());
            RPAREN300=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_withStatement6791); 
            pushFollow(FOLLOW_statement_in_withStatement6794);
            statement301=statement();
            _fsp--;

            adaptor.addChild(root_0, statement301.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end withStatement

    public static class switchStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start switchStatement
    // JS.g:1648:1: switchStatement : SWITCH LPAREN expression RPAREN LBRACE ( defaultClause | caseClause )* RBRACE -> ^( SWITCH expression ( defaultClause )* ( caseClause )* ) ;
    public final switchStatement_return switchStatement() throws RecognitionException {
        switchStatement_return retval = new switchStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SWITCH302=null;
        Token LPAREN303=null;
        Token RPAREN305=null;
        Token LBRACE306=null;
        Token RBRACE309=null;
        expression_return expression304 = null;

        defaultClause_return defaultClause307 = null;

        caseClause_return caseClause308 = null;


        Object SWITCH302_tree=null;
        Object LPAREN303_tree=null;
        Object RPAREN305_tree=null;
        Object LBRACE306_tree=null;
        Object RBRACE309_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_SWITCH=new RewriteRuleTokenStream(adaptor,"token SWITCH");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_caseClause=new RewriteRuleSubtreeStream(adaptor,"rule caseClause");
        RewriteRuleSubtreeStream stream_defaultClause=new RewriteRuleSubtreeStream(adaptor,"rule defaultClause");
        try {
            // JS.g:1649:2: ( SWITCH LPAREN expression RPAREN LBRACE ( defaultClause | caseClause )* RBRACE -> ^( SWITCH expression ( defaultClause )* ( caseClause )* ) )
            // JS.g:1649:4: SWITCH LPAREN expression RPAREN LBRACE ( defaultClause | caseClause )* RBRACE
            {
            SWITCH302=(Token)input.LT(1);
            match(input,SWITCH,FOLLOW_SWITCH_in_switchStatement6810); 
            stream_SWITCH.add(SWITCH302);

            LPAREN303=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_switchStatement6812); 
            stream_LPAREN.add(LPAREN303);

            pushFollow(FOLLOW_expression_in_switchStatement6814);
            expression304=expression();
            _fsp--;

            stream_expression.add(expression304.getTree());
            RPAREN305=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_switchStatement6816); 
            stream_RPAREN.add(RPAREN305);

            LBRACE306=(Token)input.LT(1);
            match(input,LBRACE,FOLLOW_LBRACE_in_switchStatement6818); 
            stream_LBRACE.add(LBRACE306);

            // JS.g:1649:43: ( defaultClause | caseClause )*
            loop78:
            do {
                int alt78=3;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==DEFAULT) ) {
                    alt78=1;
                }
                else if ( (LA78_0==CASE) ) {
                    alt78=2;
                }


                switch (alt78) {
            	case 1 :
            	    // JS.g:1649:45: defaultClause
            	    {
            	    pushFollow(FOLLOW_defaultClause_in_switchStatement6822);
            	    defaultClause307=defaultClause();
            	    _fsp--;

            	    stream_defaultClause.add(defaultClause307.getTree());

            	    }
            	    break;
            	case 2 :
            	    // JS.g:1649:61: caseClause
            	    {
            	    pushFollow(FOLLOW_caseClause_in_switchStatement6826);
            	    caseClause308=caseClause();
            	    _fsp--;

            	    stream_caseClause.add(caseClause308.getTree());

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            RBRACE309=(Token)input.LT(1);
            match(input,RBRACE,FOLLOW_RBRACE_in_switchStatement6831); 
            stream_RBRACE.add(RBRACE309);


            // AST REWRITE
            // elements: SWITCH, defaultClause, expression, caseClause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1650:2: -> ^( SWITCH expression ( defaultClause )* ( caseClause )* )
            {
                // JS.g:1650:5: ^( SWITCH expression ( defaultClause )* ( caseClause )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SWITCH.next(), root_1);

                adaptor.addChild(root_1, stream_expression.next());
                // JS.g:1650:26: ( defaultClause )*
                while ( stream_defaultClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_defaultClause.next());

                }
                stream_defaultClause.reset();
                // JS.g:1650:41: ( caseClause )*
                while ( stream_caseClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_caseClause.next());

                }
                stream_caseClause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end switchStatement

    public static class caseClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start caseClause
    // JS.g:1653:1: caseClause : CASE expression COLON ( statement )* ;
    public final caseClause_return caseClause() throws RecognitionException {
        caseClause_return retval = new caseClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CASE310=null;
        Token COLON312=null;
        expression_return expression311 = null;

        statement_return statement313 = null;


        Object CASE310_tree=null;
        Object COLON312_tree=null;

        try {
            // JS.g:1654:2: ( CASE expression COLON ( statement )* )
            // JS.g:1654:4: CASE expression COLON ( statement )*
            {
            root_0 = (Object)adaptor.nil();

            CASE310=(Token)input.LT(1);
            match(input,CASE,FOLLOW_CASE_in_caseClause6859); 
            CASE310_tree = (Object)adaptor.create(CASE310);
            root_0 = (Object)adaptor.becomeRoot(CASE310_tree, root_0);

            pushFollow(FOLLOW_expression_in_caseClause6862);
            expression311=expression();
            _fsp--;

            adaptor.addChild(root_0, expression311.getTree());
            COLON312=(Token)input.LT(1);
            match(input,COLON,FOLLOW_COLON_in_caseClause6864); 
            // JS.g:1654:28: ( statement )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==DEFAULT) ) {
                    int LA79_2 = input.LA(2);

                    if ( (LA79_2==WXML) && ( isXmlEnabled() )) {
                        alt79=1;
                    }


                }
                else if ( ((LA79_0>=NULL && LA79_0<=FALSE)||LA79_0==EACH||LA79_0==THIS||LA79_0==VAR||(LA79_0>=GET && LA79_0<=SET)||(LA79_0>=WXML && LA79_0<=CLASS)||(LA79_0>=DEBUGGER && LA79_0<=LBRACE)||LA79_0==SEMIC||LA79_0==AT||LA79_0==StringLiteral||(LA79_0>=Identifier && LA79_0<=RegularExpressionLiteral)||(LA79_0>=DecimalLiteral && LA79_0<=HexIntegerLiteral)) ) {
                    alt79=1;
                }
                else if ( ((LA79_0>=XMLFragment && LA79_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                    alt79=1;
                }
                else if ( (LA79_0==BREAK||LA79_0==CONTINUE||(LA79_0>=DELETE && LA79_0<=DO)||LA79_0==FOR||(LA79_0>=FUNCTION && LA79_0<=IF)||(LA79_0>=NEW && LA79_0<=SWITCH)||(LA79_0>=THROW && LA79_0<=TYPEOF)||(LA79_0>=VOID && LA79_0<=WITH)||LA79_0==YIELD||LA79_0==CONST||LA79_0==LPAREN||LA79_0==LBRACK||(LA79_0>=ADD && LA79_0<=SUB)||(LA79_0>=INC && LA79_0<=DEC)||(LA79_0>=NOT && LA79_0<=INV)) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // JS.g:1654:28: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_caseClause6867);
            	    statement313=statement();
            	    _fsp--;

            	    adaptor.addChild(root_0, statement313.getTree());

            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end caseClause

    public static class defaultClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start defaultClause
    // JS.g:1657:1: defaultClause : DEFAULT COLON ( statement )* ;
    public final defaultClause_return defaultClause() throws RecognitionException {
        defaultClause_return retval = new defaultClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DEFAULT314=null;
        Token COLON315=null;
        statement_return statement316 = null;


        Object DEFAULT314_tree=null;
        Object COLON315_tree=null;

        try {
            // JS.g:1658:2: ( DEFAULT COLON ( statement )* )
            // JS.g:1658:4: DEFAULT COLON ( statement )*
            {
            root_0 = (Object)adaptor.nil();

            DEFAULT314=(Token)input.LT(1);
            match(input,DEFAULT,FOLLOW_DEFAULT_in_defaultClause6880); 
            DEFAULT314_tree = (Object)adaptor.create(DEFAULT314);
            root_0 = (Object)adaptor.becomeRoot(DEFAULT314_tree, root_0);

            COLON315=(Token)input.LT(1);
            match(input,COLON,FOLLOW_COLON_in_defaultClause6883); 
            // JS.g:1658:20: ( statement )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==DEFAULT) ) {
                    int LA80_2 = input.LA(2);

                    if ( (LA80_2==WXML) && ( isXmlEnabled() )) {
                        alt80=1;
                    }


                }
                else if ( ((LA80_0>=NULL && LA80_0<=FALSE)||LA80_0==EACH||LA80_0==THIS||LA80_0==VAR||(LA80_0>=GET && LA80_0<=SET)||(LA80_0>=WXML && LA80_0<=CLASS)||(LA80_0>=DEBUGGER && LA80_0<=LBRACE)||LA80_0==SEMIC||LA80_0==AT||LA80_0==StringLiteral||(LA80_0>=Identifier && LA80_0<=RegularExpressionLiteral)||(LA80_0>=DecimalLiteral && LA80_0<=HexIntegerLiteral)) ) {
                    alt80=1;
                }
                else if ( ((LA80_0>=XMLFragment && LA80_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                    alt80=1;
                }
                else if ( (LA80_0==BREAK||LA80_0==CONTINUE||(LA80_0>=DELETE && LA80_0<=DO)||LA80_0==FOR||(LA80_0>=FUNCTION && LA80_0<=IF)||(LA80_0>=NEW && LA80_0<=SWITCH)||(LA80_0>=THROW && LA80_0<=TYPEOF)||(LA80_0>=VOID && LA80_0<=WITH)||LA80_0==YIELD||LA80_0==CONST||LA80_0==LPAREN||LA80_0==LBRACK||(LA80_0>=ADD && LA80_0<=SUB)||(LA80_0>=INC && LA80_0<=DEC)||(LA80_0>=NOT && LA80_0<=INV)) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // JS.g:1658:20: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_defaultClause6886);
            	    statement316=statement();
            	    _fsp--;

            	    adaptor.addChild(root_0, statement316.getTree());

            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end defaultClause

    public static class labelledStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start labelledStatement
    // JS.g:1665:1: labelledStatement : identifier COLON sourceElement -> ^( LABELLED identifier sourceElement ) ;
    public final labelledStatement_return labelledStatement() throws RecognitionException {
        labelledStatement_return retval = new labelledStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON318=null;
        identifier_return identifier317 = null;

        sourceElement_return sourceElement319 = null;


        Object COLON318_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_sourceElement=new RewriteRuleSubtreeStream(adaptor,"rule sourceElement");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // JS.g:1666:2: ( identifier COLON sourceElement -> ^( LABELLED identifier sourceElement ) )
            // JS.g:1666:4: identifier COLON sourceElement
            {
            pushFollow(FOLLOW_identifier_in_labelledStatement6903);
            identifier317=identifier();
            _fsp--;

            stream_identifier.add(identifier317.getTree());
            COLON318=(Token)input.LT(1);
            match(input,COLON,FOLLOW_COLON_in_labelledStatement6905); 
            stream_COLON.add(COLON318);

            pushFollow(FOLLOW_sourceElement_in_labelledStatement6907);
            sourceElement319=sourceElement();
            _fsp--;

            stream_sourceElement.add(sourceElement319.getTree());

            // AST REWRITE
            // elements: identifier, sourceElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1667:2: -> ^( LABELLED identifier sourceElement )
            {
                // JS.g:1667:5: ^( LABELLED identifier sourceElement )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(LABELLED, "LABELLED"), root_1);

                adaptor.addChild(root_1, stream_identifier.next());
                adaptor.addChild(root_1, stream_sourceElement.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end labelledStatement

    public static class throwStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start throwStatement
    // JS.g:1689:1: throwStatement : THROW expression semic ;
    public final throwStatement_return throwStatement() throws RecognitionException {
        throwStatement_return retval = new throwStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token THROW320=null;
        expression_return expression321 = null;

        semic_return semic322 = null;


        Object THROW320_tree=null;

        try {
            // JS.g:1690:2: ( THROW expression semic )
            // JS.g:1690:4: THROW expression semic
            {
            root_0 = (Object)adaptor.nil();

            THROW320=(Token)input.LT(1);
            match(input,THROW,FOLLOW_THROW_in_throwStatement6938); 
            THROW320_tree = (Object)adaptor.create(THROW320);
            root_0 = (Object)adaptor.becomeRoot(THROW320_tree, root_0);

             promoteEOL(null); 
            pushFollow(FOLLOW_expression_in_throwStatement6943);
            expression321=expression();
            _fsp--;

            adaptor.addChild(root_0, expression321.getTree());
            pushFollow(FOLLOW_semic_in_throwStatement6945);
            semic322=semic();
            _fsp--;


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end throwStatement

    public static class tryStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start tryStatement
    // JS.g:1697:1: tryStatement : TRY block ( ( catchClause )+ ( finallyClause )? | finallyClause ) ;
    public final tryStatement_return tryStatement() throws RecognitionException {
        tryStatement_return retval = new tryStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TRY323=null;
        block_return block324 = null;

        catchClause_return catchClause325 = null;

        finallyClause_return finallyClause326 = null;

        finallyClause_return finallyClause327 = null;


        Object TRY323_tree=null;

        try {
            // JS.g:1698:2: ( TRY block ( ( catchClause )+ ( finallyClause )? | finallyClause ) )
            // JS.g:1698:4: TRY block ( ( catchClause )+ ( finallyClause )? | finallyClause )
            {
            root_0 = (Object)adaptor.nil();

            TRY323=(Token)input.LT(1);
            match(input,TRY,FOLLOW_TRY_in_tryStatement6962); 
            TRY323_tree = (Object)adaptor.create(TRY323);
            root_0 = (Object)adaptor.becomeRoot(TRY323_tree, root_0);

            pushFollow(FOLLOW_block_in_tryStatement6965);
            block324=block();
            _fsp--;

            adaptor.addChild(root_0, block324.getTree());
            // JS.g:1698:15: ( ( catchClause )+ ( finallyClause )? | finallyClause )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==CATCH) ) {
                alt83=1;
            }
            else if ( (LA83_0==FINALLY) ) {
                alt83=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1698:15: ( ( catchClause )+ ( finallyClause )? | finallyClause )", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // JS.g:1698:17: ( catchClause )+ ( finallyClause )?
                    {
                    // JS.g:1698:17: ( catchClause )+
                    int cnt81=0;
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==CATCH) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // JS.g:1698:17: catchClause
                    	    {
                    	    pushFollow(FOLLOW_catchClause_in_tryStatement6969);
                    	    catchClause325=catchClause();
                    	    _fsp--;

                    	    adaptor.addChild(root_0, catchClause325.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt81 >= 1 ) break loop81;
                                EarlyExitException eee =
                                    new EarlyExitException(81, input);
                                throw eee;
                        }
                        cnt81++;
                    } while (true);

                    // JS.g:1698:30: ( finallyClause )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==FINALLY) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // JS.g:1698:30: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_tryStatement6972);
                            finallyClause326=finallyClause();
                            _fsp--;

                            adaptor.addChild(root_0, finallyClause326.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // JS.g:1698:47: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_tryStatement6977);
                    finallyClause327=finallyClause();
                    _fsp--;

                    adaptor.addChild(root_0, finallyClause327.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end tryStatement

    public static class catchClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start catchClause
    // JS.g:1701:1: catchClause : CATCH LPAREN identifier ( catchFilter )? RPAREN block ;
    public final catchClause_return catchClause() throws RecognitionException {
        catchClause_return retval = new catchClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CATCH328=null;
        Token LPAREN329=null;
        Token RPAREN332=null;
        identifier_return identifier330 = null;

        catchFilter_return catchFilter331 = null;

        block_return block333 = null;


        Object CATCH328_tree=null;
        Object LPAREN329_tree=null;
        Object RPAREN332_tree=null;

        try {
            // JS.g:1702:2: ( CATCH LPAREN identifier ( catchFilter )? RPAREN block )
            // JS.g:1702:4: CATCH LPAREN identifier ( catchFilter )? RPAREN block
            {
            root_0 = (Object)adaptor.nil();

            CATCH328=(Token)input.LT(1);
            match(input,CATCH,FOLLOW_CATCH_in_catchClause6991); 
            CATCH328_tree = (Object)adaptor.create(CATCH328);
            root_0 = (Object)adaptor.becomeRoot(CATCH328_tree, root_0);

            LPAREN329=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_catchClause6994); 
            pushFollow(FOLLOW_identifier_in_catchClause6997);
            identifier330=identifier();
            _fsp--;

            adaptor.addChild(root_0, identifier330.getTree());
            // JS.g:1702:30: ( catchFilter )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==IF) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // JS.g:1702:30: catchFilter
                    {
                    pushFollow(FOLLOW_catchFilter_in_catchClause6999);
                    catchFilter331=catchFilter();
                    _fsp--;

                    adaptor.addChild(root_0, catchFilter331.getTree());

                    }
                    break;

            }

            RPAREN332=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_catchClause7002); 
            pushFollow(FOLLOW_block_in_catchClause7005);
            block333=block();
            _fsp--;

            adaptor.addChild(root_0, block333.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end catchClause

    public static class catchFilter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start catchFilter
    // JS.g:1705:1: catchFilter : IF expression ;
    public final catchFilter_return catchFilter() throws RecognitionException {
        catchFilter_return retval = new catchFilter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IF334=null;
        expression_return expression335 = null;


        Object IF334_tree=null;

        try {
            // JS.g:1706:2: ( IF expression )
            // JS.g:1706:4: IF expression
            {
            root_0 = (Object)adaptor.nil();

            IF334=(Token)input.LT(1);
            match(input,IF,FOLLOW_IF_in_catchFilter7016); 
            IF334_tree = (Object)adaptor.create(IF334);
            adaptor.addChild(root_0, IF334_tree);

            pushFollow(FOLLOW_expression_in_catchFilter7018);
            expression335=expression();
            _fsp--;

            adaptor.addChild(root_0, expression335.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end catchFilter

    public static class finallyClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start finallyClause
    // JS.g:1709:1: finallyClause : FINALLY block ;
    public final finallyClause_return finallyClause() throws RecognitionException {
        finallyClause_return retval = new finallyClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FINALLY336=null;
        block_return block337 = null;


        Object FINALLY336_tree=null;

        try {
            // JS.g:1710:2: ( FINALLY block )
            // JS.g:1710:4: FINALLY block
            {
            root_0 = (Object)adaptor.nil();

            FINALLY336=(Token)input.LT(1);
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause7030); 
            FINALLY336_tree = (Object)adaptor.create(FINALLY336);
            root_0 = (Object)adaptor.becomeRoot(FINALLY336_tree, root_0);

            pushFollow(FOLLOW_block_in_finallyClause7033);
            block337=block();
            _fsp--;

            adaptor.addChild(root_0, block337.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end finallyClause

    public static class functionDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start functionDeclaration
    // JS.g:1723:1: functionDeclaration : function= FUNCTION name= identifier formalParameterList functionBody -> ^( FUNCTION_DECLARATION[$function] $name formalParameterList functionBody ) ;
    public final functionDeclaration_return functionDeclaration() throws RecognitionException {
        functionDeclaration_return retval = new functionDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token function=null;
        identifier_return name = null;

        formalParameterList_return formalParameterList338 = null;

        functionBody_return functionBody339 = null;


        Object function_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleSubtreeStream stream_functionBody=new RewriteRuleSubtreeStream(adaptor,"rule functionBody");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // JS.g:1724:2: (function= FUNCTION name= identifier formalParameterList functionBody -> ^( FUNCTION_DECLARATION[$function] $name formalParameterList functionBody ) )
            // JS.g:1724:4: function= FUNCTION name= identifier formalParameterList functionBody
            {
            function=(Token)input.LT(1);
            match(input,FUNCTION,FOLLOW_FUNCTION_in_functionDeclaration7056); 
            stream_FUNCTION.add(function);

            pushFollow(FOLLOW_identifier_in_functionDeclaration7060);
            name=identifier();
            _fsp--;

            stream_identifier.add(name.getTree());
            pushFollow(FOLLOW_formalParameterList_in_functionDeclaration7062);
            formalParameterList338=formalParameterList();
            _fsp--;

            stream_formalParameterList.add(formalParameterList338.getTree());
            pushFollow(FOLLOW_functionBody_in_functionDeclaration7064);
            functionBody339=functionBody();
            _fsp--;

            stream_functionBody.add(functionBody339.getTree());

            // AST REWRITE
            // elements: functionBody, name, formalParameterList
            // token labels: 
            // rule labels: retval, name
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"token name",name!=null?name.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1725:2: -> ^( FUNCTION_DECLARATION[$function] $name formalParameterList functionBody )
            {
                // JS.g:1725:5: ^( FUNCTION_DECLARATION[$function] $name formalParameterList functionBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION_DECLARATION, function), root_1);

                adaptor.addChild(root_1, stream_name.next());
                adaptor.addChild(root_1, stream_formalParameterList.next());
                adaptor.addChild(root_1, stream_functionBody.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end functionDeclaration

    public static class functionExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start functionExpression
    // JS.g:1728:1: functionExpression : FUNCTION (name= identifier )? formalParameterList functionBody -> ^( FUNCTION ( $name)? formalParameterList functionBody ) ;
    public final functionExpression_return functionExpression() throws RecognitionException {
        functionExpression_return retval = new functionExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FUNCTION340=null;
        identifier_return name = null;

        formalParameterList_return formalParameterList341 = null;

        functionBody_return functionBody342 = null;


        Object FUNCTION340_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleSubtreeStream stream_functionBody=new RewriteRuleSubtreeStream(adaptor,"rule functionBody");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // JS.g:1729:2: ( FUNCTION (name= identifier )? formalParameterList functionBody -> ^( FUNCTION ( $name)? formalParameterList functionBody ) )
            // JS.g:1729:4: FUNCTION (name= identifier )? formalParameterList functionBody
            {
            FUNCTION340=(Token)input.LT(1);
            match(input,FUNCTION,FOLLOW_FUNCTION_in_functionExpression7092); 
            stream_FUNCTION.add(FUNCTION340);

            // JS.g:1729:17: (name= identifier )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==EACH||(LA85_0>=GET && LA85_0<=SET)||(LA85_0>=WXML && LA85_0<=CLASS)||(LA85_0>=DEBUGGER && LA85_0<=VOLATILE)||LA85_0==Identifier) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // JS.g:1729:17: name= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_functionExpression7096);
                    name=identifier();
                    _fsp--;

                    stream_identifier.add(name.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_formalParameterList_in_functionExpression7099);
            formalParameterList341=formalParameterList();
            _fsp--;

            stream_formalParameterList.add(formalParameterList341.getTree());
            pushFollow(FOLLOW_functionBody_in_functionExpression7101);
            functionBody342=functionBody();
            _fsp--;

            stream_functionBody.add(functionBody342.getTree());

            // AST REWRITE
            // elements: FUNCTION, functionBody, formalParameterList, name
            // token labels: 
            // rule labels: retval, name
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"token name",name!=null?name.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1730:2: -> ^( FUNCTION ( $name)? formalParameterList functionBody )
            {
                // JS.g:1730:5: ^( FUNCTION ( $name)? formalParameterList functionBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_FUNCTION.next(), root_1);

                // JS.g:1730:17: ( $name)?
                if ( stream_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_name.next());

                }
                stream_name.reset();
                adaptor.addChild(root_1, stream_formalParameterList.next());
                adaptor.addChild(root_1, stream_functionBody.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end functionExpression

    public static class formalParameter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start formalParameter
    // JS.g:1733:1: formalParameter : identifier ;
    public final formalParameter_return formalParameter() throws RecognitionException {
        formalParameter_return retval = new formalParameter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        identifier_return identifier343 = null;



        try {
            // JS.g:1734:2: ( identifier )
            // JS.g:1734:4: identifier
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_formalParameter7129);
            identifier343=identifier();
            _fsp--;

            root_0 = (Object)adaptor.becomeRoot(identifier343.getTree(), root_0);

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end formalParameter

    public static class formalParameterList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start formalParameterList
    // JS.g:1737:1: formalParameterList : LPAREN ( formalParameter ( COMMA formalParameter )* )? RPAREN -> ^( ARGUMENTS ( formalParameter )* ) ;
    public final formalParameterList_return formalParameterList() throws RecognitionException {
        formalParameterList_return retval = new formalParameterList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN344=null;
        Token COMMA346=null;
        Token RPAREN348=null;
        formalParameter_return formalParameter345 = null;

        formalParameter_return formalParameter347 = null;


        Object LPAREN344_tree=null;
        Object COMMA346_tree=null;
        Object RPAREN348_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_formalParameter=new RewriteRuleSubtreeStream(adaptor,"rule formalParameter");
        try {
            // JS.g:1738:2: ( LPAREN ( formalParameter ( COMMA formalParameter )* )? RPAREN -> ^( ARGUMENTS ( formalParameter )* ) )
            // JS.g:1738:4: LPAREN ( formalParameter ( COMMA formalParameter )* )? RPAREN
            {
            LPAREN344=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_formalParameterList7141); 
            stream_LPAREN.add(LPAREN344);

            // JS.g:1738:11: ( formalParameter ( COMMA formalParameter )* )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==EACH||(LA87_0>=GET && LA87_0<=SET)||(LA87_0>=WXML && LA87_0<=CLASS)||(LA87_0>=DEBUGGER && LA87_0<=VOLATILE)||LA87_0==Identifier) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // JS.g:1738:13: formalParameter ( COMMA formalParameter )*
                    {
                    pushFollow(FOLLOW_formalParameter_in_formalParameterList7145);
                    formalParameter345=formalParameter();
                    _fsp--;

                    stream_formalParameter.add(formalParameter345.getTree());
                    // JS.g:1738:29: ( COMMA formalParameter )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==COMMA) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // JS.g:1738:31: COMMA formalParameter
                    	    {
                    	    COMMA346=(Token)input.LT(1);
                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameterList7149); 
                    	    stream_COMMA.add(COMMA346);

                    	    pushFollow(FOLLOW_formalParameter_in_formalParameterList7151);
                    	    formalParameter347=formalParameter();
                    	    _fsp--;

                    	    stream_formalParameter.add(formalParameter347.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop86;
                        }
                    } while (true);


                    }
                    break;

            }

            RPAREN348=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_formalParameterList7159); 
            stream_RPAREN.add(RPAREN348);


            // AST REWRITE
            // elements: formalParameter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1739:2: -> ^( ARGUMENTS ( formalParameter )* )
            {
                // JS.g:1739:5: ^( ARGUMENTS ( formalParameter )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ARGUMENTS, "ARGUMENTS"), root_1);

                // JS.g:1739:18: ( formalParameter )*
                while ( stream_formalParameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_formalParameter.next());

                }
                stream_formalParameter.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end formalParameterList

    public static class functionBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start functionBody
    // JS.g:1742:1: functionBody : lb= LBRACE ( sourceElement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* ) ;
    public final functionBody_return functionBody() throws RecognitionException {
        functionBody_return retval = new functionBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb=null;
        Token RBRACE350=null;
        sourceElement_return sourceElement349 = null;


        Object lb_tree=null;
        Object RBRACE350_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_sourceElement=new RewriteRuleSubtreeStream(adaptor,"rule sourceElement");
         pushState(JSParserRule.FUNCTION_BODY); 
        try {
            // JS.g:1744:2: (lb= LBRACE ( sourceElement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* ) )
            // JS.g:1744:4: lb= LBRACE ( sourceElement )* RBRACE
            {
            lb=(Token)input.LT(1);
            match(input,LBRACE,FOLLOW_LBRACE_in_functionBody7189); 
            stream_LBRACE.add(lb);

            // JS.g:1744:14: ( sourceElement )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( ((LA88_0>=NULL && LA88_0<=FALSE)||(LA88_0>=EACH && LA88_0<=FUNCTION)||LA88_0==THIS||LA88_0==VAR||(LA88_0>=GET && LA88_0<=SET)||(LA88_0>=WXML && LA88_0<=CLASS)||(LA88_0>=DEBUGGER && LA88_0<=LBRACE)||LA88_0==SEMIC||LA88_0==AT||LA88_0==StringLiteral||(LA88_0>=Identifier && LA88_0<=RegularExpressionLiteral)||(LA88_0>=DecimalLiteral && LA88_0<=HexIntegerLiteral)) ) {
                    alt88=1;
                }
                else if ( ((LA88_0>=XMLFragment && LA88_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                    alt88=1;
                }
                else if ( (LA88_0==BREAK||LA88_0==CONTINUE||(LA88_0>=DELETE && LA88_0<=DO)||LA88_0==FOR||LA88_0==IF||(LA88_0>=NEW && LA88_0<=SWITCH)||(LA88_0>=THROW && LA88_0<=TYPEOF)||(LA88_0>=VOID && LA88_0<=WITH)||LA88_0==YIELD||LA88_0==CONST||LA88_0==LPAREN||LA88_0==LBRACK||(LA88_0>=ADD && LA88_0<=SUB)||(LA88_0>=INC && LA88_0<=DEC)||(LA88_0>=NOT && LA88_0<=INV)) ) {
                    alt88=1;
                }
                else if ( (LA88_0==DEFAULT) && ( isXmlEnabled() )) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // JS.g:1744:14: sourceElement
            	    {
            	    pushFollow(FOLLOW_sourceElement_in_functionBody7191);
            	    sourceElement349=sourceElement();
            	    _fsp--;

            	    stream_sourceElement.add(sourceElement349.getTree());

            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);

            RBRACE350=(Token)input.LT(1);
            match(input,RBRACE,FOLLOW_RBRACE_in_functionBody7194); 
            stream_RBRACE.add(RBRACE350);


            // AST REWRITE
            // elements: sourceElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1745:2: -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* )
            {
                // JS.g:1745:5: ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(BLOCK, lb,  "BLOCK"), root_1);

                // JS.g:1745:28: ( sourceElement )*
                while ( stream_sourceElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_sourceElement.next());

                }
                stream_sourceElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
             popState(); 
        }
        return retval;
    }
    // $ANTLR end functionBody

    public static class getMethodDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start getMethodDeclaration
    // JS.g:1754:1: getMethodDeclaration : get= GET name= identifier LPAREN RPAREN functionBody -> ^( GETTER[$get] identifier functionBody ) ;
    public final getMethodDeclaration_return getMethodDeclaration() throws RecognitionException {
        getMethodDeclaration_return retval = new getMethodDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token get=null;
        Token LPAREN351=null;
        Token RPAREN352=null;
        identifier_return name = null;

        functionBody_return functionBody353 = null;


        Object get_tree=null;
        Object LPAREN351_tree=null;
        Object RPAREN352_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_functionBody=new RewriteRuleSubtreeStream(adaptor,"rule functionBody");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // JS.g:1755:3: (get= GET name= identifier LPAREN RPAREN functionBody -> ^( GETTER[$get] identifier functionBody ) )
            // JS.g:1755:5: get= GET name= identifier LPAREN RPAREN functionBody
            {
            get=(Token)input.LT(1);
            match(input,GET,FOLLOW_GET_in_getMethodDeclaration7231); 
            stream_GET.add(get);

            pushFollow(FOLLOW_identifier_in_getMethodDeclaration7235);
            name=identifier();
            _fsp--;

            stream_identifier.add(name.getTree());
            LPAREN351=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_getMethodDeclaration7237); 
            stream_LPAREN.add(LPAREN351);

            RPAREN352=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_getMethodDeclaration7239); 
            stream_RPAREN.add(RPAREN352);

            pushFollow(FOLLOW_functionBody_in_getMethodDeclaration7241);
            functionBody353=functionBody();
            _fsp--;

            stream_functionBody.add(functionBody353.getTree());

            // AST REWRITE
            // elements: identifier, functionBody
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1756:4: -> ^( GETTER[$get] identifier functionBody )
            {
                // JS.g:1756:7: ^( GETTER[$get] identifier functionBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(GETTER, get), root_1);

                adaptor.addChild(root_1, stream_identifier.next());
                adaptor.addChild(root_1, stream_functionBody.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end getMethodDeclaration

    public static class setMethodDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start setMethodDeclaration
    // JS.g:1759:1: setMethodDeclaration : set= SET name= identifier LPAREN param= identifier RPAREN functionBody -> ^( SETTER[$set] $name $param functionBody ) ;
    public final setMethodDeclaration_return setMethodDeclaration() throws RecognitionException {
        setMethodDeclaration_return retval = new setMethodDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set=null;
        Token LPAREN354=null;
        Token RPAREN355=null;
        identifier_return name = null;

        identifier_return param = null;

        functionBody_return functionBody356 = null;


        Object set_tree=null;
        Object LPAREN354_tree=null;
        Object RPAREN355_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_functionBody=new RewriteRuleSubtreeStream(adaptor,"rule functionBody");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // JS.g:1760:3: (set= SET name= identifier LPAREN param= identifier RPAREN functionBody -> ^( SETTER[$set] $name $param functionBody ) )
            // JS.g:1760:5: set= SET name= identifier LPAREN param= identifier RPAREN functionBody
            {
            set=(Token)input.LT(1);
            match(input,SET,FOLLOW_SET_in_setMethodDeclaration7272); 
            stream_SET.add(set);

            pushFollow(FOLLOW_identifier_in_setMethodDeclaration7276);
            name=identifier();
            _fsp--;

            stream_identifier.add(name.getTree());
            LPAREN354=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_setMethodDeclaration7278); 
            stream_LPAREN.add(LPAREN354);

            pushFollow(FOLLOW_identifier_in_setMethodDeclaration7282);
            param=identifier();
            _fsp--;

            stream_identifier.add(param.getTree());
            RPAREN355=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_setMethodDeclaration7284); 
            stream_RPAREN.add(RPAREN355);

            pushFollow(FOLLOW_functionBody_in_setMethodDeclaration7286);
            functionBody356=functionBody();
            _fsp--;

            stream_functionBody.add(functionBody356.getTree());

            // AST REWRITE
            // elements: param, functionBody, name
            // token labels: 
            // rule labels: retval, param, name
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"token param",param!=null?param.tree:null);
            RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"token name",name!=null?name.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1761:5: -> ^( SETTER[$set] $name $param functionBody )
            {
                // JS.g:1761:8: ^( SETTER[$set] $name $param functionBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(SETTER, set), root_1);

                adaptor.addChild(root_1, stream_name.next());
                adaptor.addChild(root_1, stream_param.next());
                adaptor.addChild(root_1, stream_functionBody.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end setMethodDeclaration

    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start program
    // JS.g:1768:1: program : sourceElementSync ( sourceElement sourceElementSync )* EOF ;
    public final program_return program() throws RecognitionException {
        program_return retval = new program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF360=null;
        sourceElementSync_return sourceElementSync357 = null;

        sourceElement_return sourceElement358 = null;

        sourceElementSync_return sourceElementSync359 = null;


        Object EOF360_tree=null;

         pushState(JSParserRule.PROGRAM); 
        try {
            // JS.g:1770:2: ( sourceElementSync ( sourceElement sourceElementSync )* EOF )
            // JS.g:1770:4: sourceElementSync ( sourceElement sourceElementSync )* EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sourceElementSync_in_program7327);
            sourceElementSync357=sourceElementSync();
            _fsp--;

            adaptor.addChild(root_0, sourceElementSync357.getTree());
            // JS.g:1770:22: ( sourceElement sourceElementSync )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( ((LA89_0>=NULL && LA89_0<=FALSE)||(LA89_0>=EACH && LA89_0<=FUNCTION)||LA89_0==THIS||LA89_0==VAR||(LA89_0>=GET && LA89_0<=SET)||(LA89_0>=WXML && LA89_0<=CLASS)||(LA89_0>=DEBUGGER && LA89_0<=LBRACE)||LA89_0==SEMIC||LA89_0==AT||LA89_0==StringLiteral||(LA89_0>=Identifier && LA89_0<=RegularExpressionLiteral)||(LA89_0>=DecimalLiteral && LA89_0<=HexIntegerLiteral)) ) {
                    alt89=1;
                }
                else if ( ((LA89_0>=XMLFragment && LA89_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                    alt89=1;
                }
                else if ( (LA89_0==BREAK||LA89_0==CONTINUE||(LA89_0>=DELETE && LA89_0<=DO)||LA89_0==FOR||LA89_0==IF||(LA89_0>=NEW && LA89_0<=SWITCH)||(LA89_0>=THROW && LA89_0<=TYPEOF)||(LA89_0>=VOID && LA89_0<=WITH)||LA89_0==YIELD||LA89_0==CONST||LA89_0==LPAREN||LA89_0==LBRACK||(LA89_0>=ADD && LA89_0<=SUB)||(LA89_0>=INC && LA89_0<=DEC)||(LA89_0>=NOT && LA89_0<=INV)) ) {
                    alt89=1;
                }
                else if ( (LA89_0==DEFAULT) && ( isXmlEnabled() )) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // JS.g:1770:23: sourceElement sourceElementSync
            	    {
            	    pushFollow(FOLLOW_sourceElement_in_program7330);
            	    sourceElement358=sourceElement();
            	    _fsp--;

            	    adaptor.addChild(root_0, sourceElement358.getTree());
            	    pushFollow(FOLLOW_sourceElementSync_in_program7332);
            	    sourceElementSync359=sourceElementSync();
            	    _fsp--;

            	    adaptor.addChild(root_0, sourceElementSync359.getTree());

            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);

            EOF360=(Token)input.LT(1);
            match(input,EOF,FOLLOW_EOF_in_program7336); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end program

    public static class sourceElementSync_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start sourceElementSync
    // JS.g:1773:1: sourceElementSync : ;
    public final sourceElementSync_return sourceElementSync() throws RecognitionException {
        sourceElementSync_return retval = new sourceElementSync_return();
        retval.start = input.LT(1);

        Object root_0 = null;


        	syncToSet();

        try {
            // JS.g:1777:2: ()
            // JS.g:1778:3: 
            {
            root_0 = (Object)adaptor.nil();

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end sourceElementSync

    public static class sourceElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start sourceElement
    // JS.g:1785:1: sourceElement options {k=1; } : ({...}? functionDeclaration | statement );
    public final sourceElement_return sourceElement() throws RecognitionException {
        sourceElement_return retval = new sourceElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        functionDeclaration_return functionDeclaration361 = null;

        statement_return statement362 = null;



        try {
            // JS.g:1790:2: ({...}? functionDeclaration | statement )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==FUNCTION) ) {
                int LA90_1 = input.LA(2);

                if ( ( input.LA(1) == FUNCTION ) ) {
                    alt90=1;
                }
                else if ( (true) ) {
                    alt90=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1785:1: sourceElement options {k=1; } : ({...}? functionDeclaration | statement );", 90, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA90_0>=NULL && LA90_0<=FALSE)||LA90_0==EACH||LA90_0==THIS||LA90_0==VAR||(LA90_0>=GET && LA90_0<=SET)||(LA90_0>=WXML && LA90_0<=CLASS)||(LA90_0>=DEBUGGER && LA90_0<=LBRACE)||LA90_0==SEMIC||LA90_0==AT||LA90_0==StringLiteral||(LA90_0>=Identifier && LA90_0<=RegularExpressionLiteral)||(LA90_0>=DecimalLiteral && LA90_0<=HexIntegerLiteral)) ) {
                alt90=2;
            }
            else if ( ((LA90_0>=XMLFragment && LA90_0<=XMLFragmentEnd)) && ( isXmlEnabled() )) {
                alt90=2;
            }
            else if ( (LA90_0==BREAK||LA90_0==CONTINUE||(LA90_0>=DELETE && LA90_0<=DO)||LA90_0==FOR||LA90_0==IF||(LA90_0>=NEW && LA90_0<=SWITCH)||(LA90_0>=THROW && LA90_0<=TYPEOF)||(LA90_0>=VOID && LA90_0<=WITH)||LA90_0==YIELD||LA90_0==CONST||LA90_0==LPAREN||LA90_0==LBRACK||(LA90_0>=ADD && LA90_0<=SUB)||(LA90_0>=INC && LA90_0<=DEC)||(LA90_0>=NOT && LA90_0<=INV)) ) {
                alt90=2;
            }
            else if ( (LA90_0==DEFAULT) && ( isXmlEnabled() )) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1785:1: sourceElement options {k=1; } : ({...}? functionDeclaration | statement );", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // JS.g:1790:4: {...}? functionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !( input.LA(1) == FUNCTION ) ) {
                        throw new FailedPredicateException(input, "sourceElement", " input.LA(1) == FUNCTION ");
                    }
                    pushFollow(FOLLOW_functionDeclaration_in_sourceElement7381);
                    functionDeclaration361=functionDeclaration();
                    _fsp--;

                    adaptor.addChild(root_0, functionDeclaration361.getTree());

                    }
                    break;
                case 2 :
                    // JS.g:1791:4: statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_sourceElement7386);
                    statement362=statement();
                    _fsp--;

                    adaptor.addChild(root_0, statement362.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end sourceElement

    public static class standaloneExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start standaloneExpression
    // JS.g:1796:1: standaloneExpression : expression EOF ;
    public final standaloneExpression_return standaloneExpression() throws RecognitionException {
        standaloneExpression_return retval = new standaloneExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF364=null;
        expression_return expression363 = null;


        Object EOF364_tree=null;

         pushState(JSParserRule.EXPRESSION); 
        try {
            // JS.g:1798:2: ( expression EOF )
            // JS.g:1798:4: expression EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_standaloneExpression7404);
            expression363=expression();
            _fsp--;

            adaptor.addChild(root_0, expression363.getTree());
            EOF364=(Token)input.LT(1);
            match(input,EOF,FOLLOW_EOF_in_standaloneExpression7406); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException re) {
        	reportRuleError(re);
        }
        catch (RuntimeException e) {
        	reportFailure(e);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end standaloneExpression


 

    public static final BitSet FOLLOW_reservedWord_in_token1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_token1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_XMLFragment_in_token1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_XMLFragmentEnd_in_token1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_punctuator_in_token2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_token2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_token2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_token2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_token2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xmlAttribute_in_token2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyword_in_reservedWord2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_keyword0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_futureReservedWord0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WXML_in_identifier2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_identifier2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_identifier2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EACH_in_identifier2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAMESPACE_in_identifier2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_futureReservedWord_in_identifier2525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_identifier2538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_xmlAttribute2549 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_identifier_in_xmlAttribute2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_xmlAttribute2567 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_MUL_in_xmlAttribute2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_xmlAttribute2585 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_LBRACK_in_xmlAttribute2587 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_xmlAttribute2589 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK_in_xmlAttribute2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_propertySelector2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MUL_in_propertySelector2618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_punctuator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_literal2898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal2903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RegularExpressionLiteral_in_literal2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xmlLiteral_in_literal2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_XMLFragment_in_xmlLiteral2939 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_LBRACE_in_xmlLiteral2956 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_xmlLiteral2958 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RBRACE_in_xmlLiteral2960 = new BitSet(new long[]{0x0000000000000000L,0x0300000000000000L});
    public static final BitSet FOLLOW_XMLFragmentEnd_in_xmlLiteral2976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_booleanLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_numericLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_primaryExpression3766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_primaryExpression3771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xmlAttribute_in_primaryExpression3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primaryExpression3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayLiteral_in_primaryExpression3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectLiteral_in_primaryExpression3791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parenExpression_in_primaryExpression3796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parenExpression3812 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_parenExpression3814 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_parenExpression3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayLiteral3843 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC026BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_arrayItem_in_arrayLiteral3847 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002400L});
    public static final BitSet FOLLOW_COMMA_in_arrayLiteral3851 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC026BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_arrayItem_in_arrayLiteral3853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002400L});
    public static final BitSet FOLLOW_RBRACK_in_arrayLiteral3864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_arrayItem3894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_objectLiteral3926 = new BitSet(new long[]{0xFFFFF7FFFFFFFF80L,0x000000000000005FL,0x0708200000000000L});
    public static final BitSet FOLLOW_objectPropertyInitializer_in_objectLiteral3930 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002040L});
    public static final BitSet FOLLOW_COMMA_in_objectLiteral3934 = new BitSet(new long[]{0xFFFFF7FFFFFFFF80L,0x000000000000001FL,0x0708200000000000L});
    public static final BitSet FOLLOW_objectPropertyInitializer_in_objectLiteral3936 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002040L});
    public static final BitSet FOLLOW_COMMA_in_objectLiteral3941 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RBRACE_in_objectLiteral3946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameValuePair_in_objectPropertyInitializer3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getMethodDeclaration_in_objectPropertyInitializer3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setMethodDeclaration_in_objectPropertyInitializer3985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyName_in_nameValuePair3997 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_COLON_in_nameValuePair3999 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_nameValuePair4001 = new BitSet(new long[]{0xFFFFF7F600020002L,0x000000800000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_nameValuePairFix_in_nameValuePair4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_nameValuePairFix4033 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_nameValuePairFix4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_nameValuePairFix4056 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_COLON_in_nameValuePairFix4058 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_nameValuePairFix4060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_propertyName4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reservedWord_in_propertyName4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_propertyName4104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_propertyName4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_memberExpression4127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionExpression_in_memberExpression4132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_memberExpression4137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_newExpression4148 = new BitSet(new long[]{0xFFFFF7F602460070L,0x03200000000002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_newExpressionTail_in_newExpression4151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments4164 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC003BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_arguments4168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002100L});
    public static final BitSet FOLLOW_COMMA_in_arguments4172 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_arguments4174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002100L});
    public static final BitSet FOLLOW_RPAREN_in_arguments4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberExpression_in_leftHandSideExpression4220 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_arguments_in_leftHandSideExpression4241 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_LBRACK_in_leftHandSideExpression4268 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_leftHandSideExpression4270 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK_in_leftHandSideExpression4272 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_DOT_in_leftHandSideExpression4295 = new BitSet(new long[]{0xFFFFF7FFFFFFFF80L,0x002000000100009FL,0x0008000000000000L});
    public static final BitSet FOLLOW_rightHandSideExpression_in_leftHandSideExpression4299 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_DOTDOT_in_leftHandSideExpression4327 = new BitSet(new long[]{0xFFFFF7F600020000L,0x002000000100001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_rightHandSideExpression2_in_leftHandSideExpression4331 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_COLONCOLON_in_leftHandSideExpression4354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_LBRACK_in_leftHandSideExpression4356 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_leftHandSideExpression4358 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK_in_leftHandSideExpression4360 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_COLONCOLON_in_leftHandSideExpression4382 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000100001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_propertySelector_in_leftHandSideExpression4386 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_memberExpression_in_newExpressionTail4447 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_LBRACK_in_newExpressionTail4470 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_newExpressionTail4472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK_in_newExpressionTail4474 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_DOT_in_newExpressionTail4497 = new BitSet(new long[]{0xFFFFF7FFFFFFFF80L,0x002000000100009FL,0x0008000000000000L});
    public static final BitSet FOLLOW_rightHandSideExpression_in_newExpressionTail4501 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_DOTDOT_in_newExpressionTail4529 = new BitSet(new long[]{0xFFFFF7F600020000L,0x002000000100001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_rightHandSideExpression2_in_newExpressionTail4533 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_COLONCOLON_in_newExpressionTail4556 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_LBRACK_in_newExpressionTail4558 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_newExpressionTail4560 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK_in_newExpressionTail4562 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_COLONCOLON_in_newExpressionTail4584 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000100001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_propertySelector_in_newExpressionTail4588 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000A80L});
    public static final BitSet FOLLOW_arguments_in_newExpressionTail4616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_rightHandSideExpression4651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reservedWord_in_rightHandSideExpression4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parenExpression_in_rightHandSideExpression4673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xmlAttribute_in_rightHandSideExpression4683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MUL_in_rightHandSideExpression4692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_rightHandSideExpression24704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xmlAttribute_in_rightHandSideExpression24710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MUL_in_rightHandSideExpression24716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_postfixExpression4732 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_postfixOperator_in_postfixExpression4738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_postfixOperator4756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_postfixOperator4765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression4782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOperator_in_unaryExpression4787 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression4790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_unaryOperator4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_unaryOperator4807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPEOF_in_unaryOperator4812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_unaryOperator4817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_unaryOperator4822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_unaryOperator4829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_in_unaryOperator4838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INV_in_unaryOperator4845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryOperator4850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YIELD_in_unaryOperator4855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_namespaceStatement4872 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_WXML_in_namespaceStatement4874 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NAMESPACE_in_namespaceStatement4876 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_namespaceStatement4878 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_namespaceStatement4880 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_semic_in_namespaceStatement4882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression4914 = new BitSet(new long[]{0x0000000000000002L,0x0008000003000000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression4918 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression4933 = new BitSet(new long[]{0x0000000000000002L,0x0008000003000000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression4951 = new BitSet(new long[]{0x0000000000000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_set_in_additiveExpression4955 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression4966 = new BitSet(new long[]{0x0000000000000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression4985 = new BitSet(new long[]{0x0000000000000002L,0x0000000070000000L});
    public static final BitSet FOLLOW_set_in_shiftExpression4989 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression5004 = new BitSet(new long[]{0x0000000000000002L,0x0000000070000000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression5023 = new BitSet(new long[]{0x0000000000300002L,0x000000000003C000L});
    public static final BitSet FOLLOW_set_in_relationalExpression5027 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression5054 = new BitSet(new long[]{0x0000000000300002L,0x000000000003C000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpressionNoIn5068 = new BitSet(new long[]{0x0000000000200002L,0x000000000003C000L});
    public static final BitSet FOLLOW_set_in_relationalExpressionNoIn5072 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpressionNoIn5095 = new BitSet(new long[]{0x0000000000200002L,0x000000000003C000L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression5114 = new BitSet(new long[]{0x0000000000000002L,0x00000000003C0000L});
    public static final BitSet FOLLOW_set_in_equalityExpression5118 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression5137 = new BitSet(new long[]{0x0000000000000002L,0x00000000003C0000L});
    public static final BitSet FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn5151 = new BitSet(new long[]{0x0000000000000002L,0x00000000003C0000L});
    public static final BitSet FOLLOW_set_in_equalityExpressionNoIn5155 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn5174 = new BitSet(new long[]{0x0000000000000002L,0x00000000003C0000L});
    public static final BitSet FOLLOW_equalityExpression_in_bitwiseANDExpression5194 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_AND_in_bitwiseANDExpression5198 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_equalityExpression_in_bitwiseANDExpression5201 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn5215 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_AND_in_bitwiseANDExpressionNoIn5219 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn5222 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression5238 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_XOR_in_bitwiseXORExpression5242 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression5245 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn5261 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_XOR_in_bitwiseXORExpressionNoIn5265 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn5268 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_bitwiseXORExpression_in_bitwiseORExpression5283 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_OR_in_bitwiseORExpression5287 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_bitwiseXORExpression_in_bitwiseORExpression5290 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn5305 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_OR_in_bitwiseORExpressionNoIn5309 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn5312 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_bitwiseORExpression_in_logicalANDExpression5331 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_LAND_in_logicalANDExpression5335 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_bitwiseORExpression_in_logicalANDExpression5338 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn5352 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_LAND_in_logicalANDExpressionNoIn5356 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn5359 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_logicalANDExpression_in_logicalORExpression5374 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_LOR_in_logicalORExpression5378 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_logicalANDExpression_in_logicalORExpression5381 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn5396 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_LOR_in_logicalORExpressionNoIn5400 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn5403 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_logicalORExpression_in_conditionalExpression5422 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_QUE_in_conditionalExpression5426 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_conditionalExpression5429 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression5431 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_conditionalExpression5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalORExpressionNoIn_in_conditionalExpressionNoIn5448 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_QUE_in_conditionalExpressionNoIn5452 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn5455 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpressionNoIn5457 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn5460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_assignmentExpression5488 = new BitSet(new long[]{0x0000000000000002L,0x0017FF0000000000L});
    public static final BitSet FOLLOW_assignmentOperator_in_assignmentExpression5495 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_assignmentExpression5498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignmentOperator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpressionNoIn_in_assignmentExpressionNoIn5576 = new BitSet(new long[]{0x0000000000000002L,0x0017FF0000000000L});
    public static final BitSet FOLLOW_assignmentOperator_in_assignmentExpressionNoIn5583 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_assignmentExpressionNoIn5586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_expression5608 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_COMMA_in_expression5612 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_expression5616 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_expressionNoIn5653 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_COMMA_in_expressionNoIn5657 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_expressionNoIn5661 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_SEMIC_in_semic5712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOF_in_semic5717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RBRACE_in_semic5722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOL_in_semic5729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MultiLineComment_in_semic5733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement5762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementTail_in_statement5767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableStatement_in_statementTail5779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyStatement_in_statementTail5784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementTail5789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementTail5794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterationStatement_in_statementTail5799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementTail5804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementTail5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementTail5814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_withStatement_in_statementTail5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelledStatement_in_statementTail5824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementTail5829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementTail5834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tryStatement_in_statementTail5839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constStatement_in_statementTail5844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_namespaceStatement_in_statementTail5849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_block5864 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012FFL,0x0718200000000000L});
    public static final BitSet FOLLOW_sourceElement_in_block5866 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012FFL,0x0718200000000000L});
    public static final BitSet FOLLOW_RBRACE_in_block5869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_variableStatement5898 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableStatement5900 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_COMMA_in_variableStatement5904 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableStatement5906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_semic_in_variableStatement5911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableDeclaration5934 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclaration5939 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpression_in_variableDeclaration5941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableDeclarationNoIn5956 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclarationNoIn5961 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_variableDeclarationNoIn5963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_constStatement5978 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_constStatement5980 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_COMMA_in_constStatement5984 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_constStatement5986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_semic_in_constStatement5991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMIC_in_emptyStatement6021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionStatement6044 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_semic_in_expressionStatement6046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement6064 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_ifStatement6066 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_ifStatement6068 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_ifStatement6070 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_statement_in_ifStatement6072 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement6078 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_statement_in_ifStatement6080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doStatement_in_iterationStatement6113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_iterationStatement6118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forEachStatement_in_iterationStatement6123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_iterationStatement6128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_doStatement6140 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_statement_in_doStatement6142 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_WHILE_in_doStatement6144 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_doStatement6146 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_doStatement6148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_doStatement6150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_semic_in_doStatement6152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileStatement6177 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_whileStatement6180 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_whileStatement6183 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_whileStatement6185 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_statement_in_whileStatement6188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forEachStatement6205 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EACH_in_forEachStatement6207 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_forEachStatement6209 = new BitSet(new long[]{0xFFFFF7FE72461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_forEachControl_in_forEachStatement6211 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_forEachStatement6213 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_statement_in_forEachStatement6215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlVar_in_forEachControl6243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlExpression_in_forEachControl6249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStatement6261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_forStatement6264 = new BitSet(new long[]{0xFFFFF7FE72461070L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_forControl_in_forStatement6267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_forStatement6269 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_statement_in_forStatement6272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlVar_in_forControl6283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlExpression_in_forControl6288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlSemic_in_forControl6293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_forControlVar6304 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_variableDeclarationNoIn_in_forControlVar6306 = new BitSet(new long[]{0x0000000000100000L,0x0000000000003000L});
    public static final BitSet FOLLOW_IN_in_forControlVar6318 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_forControlVar6320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_forControlVar6366 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_variableDeclarationNoIn_in_forControlVar6368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_SEMIC_in_forControlVar6375 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_forControlVar6379 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_SEMIC_in_forControlVar6384 = new BitSet(new long[]{0xFFFFF7FE52461072L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_forControlVar6388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionNoIn_in_forControlExpression6468 = new BitSet(new long[]{0x0000000000100000L,0x0000000000001000L});
    public static final BitSet FOLLOW_IN_in_forControlExpression6483 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_forControlExpression6487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMIC_in_forControlExpression6535 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_forControlExpression6539 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_SEMIC_in_forControlExpression6544 = new BitSet(new long[]{0xFFFFF7FE52461072L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_forControlExpression6548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMIC_in_forControlSemic6623 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_forControlSemic6627 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_SEMIC_in_forControlSemic6632 = new BitSet(new long[]{0xFFFFF7FE52461072L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_forControlSemic6636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_continueStatement6704 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L,0x00080C0000000000L});
    public static final BitSet FOLLOW_Identifier_in_continueStatement6709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_semic_in_continueStatement6712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_breakStatement6731 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L,0x00080C0000000000L});
    public static final BitSet FOLLOW_Identifier_in_breakStatement6736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_semic_in_breakStatement6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_returnStatement6758 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC012FFL,0x07182C0000000000L});
    public static final BitSet FOLLOW_expression_in_returnStatement6763 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_semic_in_returnStatement6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_withStatement6783 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_withStatement6786 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_withStatement6789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_withStatement6791 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_statement_in_withStatement6794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_switchStatement6810 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_switchStatement6812 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_switchStatement6814 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_switchStatement6816 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_LBRACE_in_switchStatement6818 = new BitSet(new long[]{0x0000000000000900L,0x0000000000000040L});
    public static final BitSet FOLLOW_defaultClause_in_switchStatement6822 = new BitSet(new long[]{0x0000000000000900L,0x0000000000000040L});
    public static final BitSet FOLLOW_caseClause_in_switchStatement6826 = new BitSet(new long[]{0x0000000000000900L,0x0000000000000040L});
    public static final BitSet FOLLOW_RBRACE_in_switchStatement6831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_caseClause6859 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_caseClause6862 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_COLON_in_caseClause6864 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF2L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_statement_in_caseClause6867 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF2L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_DEFAULT_in_defaultClause6880 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_COLON_in_defaultClause6883 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF2L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_statement_in_defaultClause6886 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF2L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_identifier_in_labelledStatement6903 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_COLON_in_labelledStatement6905 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_sourceElement_in_labelledStatement6907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROW_in_throwStatement6938 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_throwStatement6943 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L,0x00000C0000000000L});
    public static final BitSet FOLLOW_semic_in_throwStatement6945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRY_in_tryStatement6962 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_tryStatement6965 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_catchClause_in_tryStatement6969 = new BitSet(new long[]{0x0000000000008202L});
    public static final BitSet FOLLOW_finallyClause_in_tryStatement6972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_tryStatement6977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_catchClause6991 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_catchClause6994 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_identifier_in_catchClause6997 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000100L});
    public static final BitSet FOLLOW_catchFilter_in_catchClause6999 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_catchClause7002 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_catchClause7005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_catchFilter7016 = new BitSet(new long[]{0xFFFFF7FE52461070L,0x0320000C0CC002BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_expression_in_catchFilter7018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause7030 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_finallyClause7033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_functionDeclaration7056 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_identifier_in_functionDeclaration7060 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_formalParameterList_in_functionDeclaration7062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_functionBody_in_functionDeclaration7064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_functionExpression7092 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000009FL,0x0008000000000000L});
    public static final BitSet FOLLOW_identifier_in_functionExpression7096 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_formalParameterList_in_functionExpression7099 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_functionBody_in_functionExpression7101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_formalParameter7129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameterList7141 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000011FL,0x0008000000000000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList7145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002100L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterList7149 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameterList7151 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002100L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameterList7159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_functionBody7189 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012FFL,0x0718200000000000L});
    public static final BitSet FOLLOW_sourceElement_in_functionBody7191 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012FFL,0x0718200000000000L});
    public static final BitSet FOLLOW_RBRACE_in_functionBody7194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getMethodDeclaration7231 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_identifier_in_getMethodDeclaration7235 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_getMethodDeclaration7237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_getMethodDeclaration7239 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_functionBody_in_getMethodDeclaration7241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_setMethodDeclaration7272 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_identifier_in_setMethodDeclaration7276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_setMethodDeclaration7278 = new BitSet(new long[]{0xFFFFF7F600020000L,0x000000000000001FL,0x0008000000000000L});
    public static final BitSet FOLLOW_identifier_in_setMethodDeclaration7282 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_setMethodDeclaration7284 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_functionBody_in_setMethodDeclaration7286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceElementSync_in_program7327 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_sourceElement_in_program7330 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_sourceElementSync_in_program7332 = new BitSet(new long[]{0xFFFFFFFFFFCF3CF0L,0x0320000C0CC012BFL,0x0718200000000000L});
    public static final BitSet FOLLOW_EOF_in_program7336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_sourceElement7381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_sourceElement7386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_standaloneExpression7404 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_standaloneExpression7406 = new BitSet(new long[]{0x0000000000000002L});

}