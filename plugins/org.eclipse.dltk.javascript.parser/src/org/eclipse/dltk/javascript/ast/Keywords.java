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

package org.eclipse.dltk.javascript.ast;

import java.util.HashMap;

import org.eclipse.dltk.javascript.parser.JSParser;

public class Keywords {

	public static final String FUNCTION = "function";

	public static final String NULL = "null";

	public static final String RETURN = "return";

	public static final String IF = "if";

	public static final String ELSE = "else";

	public static final String SWITCH = "switch";

	public static final String CASE = "case";

	public static final String BREAK = "break";

	public static final String CONTINUE = "continue";

	public static final String DEFAULT = "default";

	public static final String FOR = "for";

	public static final String EACH = "each";

	public static final String WHILE = "while";

	public static final String DO = "do";

	public static final String VAR = "var";

	public static final String CONST = "const";

	public static final String IN = "in";

	public static final String NEW = "new";

	public static final String TRUE = "true";

	public static final String FALSE = "false";

	public static final String TRY = "try";

	public static final String CATCH = "catch";

	public static final String FINALLY = "finally";

	public static final String INSTANCEOF = "instanceof";

	public static final String TYPEOF = "typeof";

	public static final String THIS = "this";

	public static final String THROW = "throw";

	public static final String EXPORT = "export";

	public static final String IMPORT = "import";

	public static final String WITH = "with";

	public static final String DELETE = "delete";

	public static final String GET = "get";

	public static final String SET = "set";

	public static final String VOID = "void";

	public static final String XML = "xml";

	public static final String NAMESPACE = "namespace";

	public static final String YIELD = "yield";

	//
	//
	//
	//

	public static final char SPACE_CHAR = ' ';

	// public static final String NEW_LINE = "\r\n";

	//
	//
	//

	public static final char LP = '(';

	public static final char RP = ')';

	public static final char LC = '{';

	public static final char RC = '}';

	public static final char LB = '[';

	public static final char RB = ']';

	//
	//
	//

	public static final char DOT = '.';

	public static final char COMMA = ',';

	public static final char SEMI = ';';

	public static final char COLON = ':';

	//
	//
	//

	public static final char STRING_QUOTE = '"';

	//
	//
	//

	public static final char ASSIGN = '=';

	public static final String ADDASS = "+=";
	public static final String SUBASS = "-=";
	public static final String MULASS = "*=";
	public static final String DIVASS = "/=";
	public static final String MODASS = "%="; // it does not present in
	// JavaScript
	// 1.5 Reference

	public static final String XORASS = "^=";
	public static final String ANDASS = "&=";
	public static final String ORASS = "|=";
	public static final String SHLASS = "<<=";
	public static final String SHRASS = ">>=";
	public static final String SHUASS = ">>>=";

	//
	//
	//

	public static final String INC = "++";
	public static final String DEC = "--";

	public static final char ADD = '+';
	public static final char SUB = '-';
	public static final char MUL = '*';
	public static final char DIV = '/';
	public static final char MOD = '%';
	public static final String LAND = "&&";
	public static final String LOR = "||";
	public static final char NOT = '!';

	public static final char OR = '|';
	public static final char XOR = '^';
	public static final char AND = '&';
	public static final char INV = '~';

	public static final String SHL = "<<";
	public static final String SHR = ">>";
	public static final String SHU = ">>>";

	public static final String EQ = "==";
	public static final String NEQ = "!=";
	public static final String SAME = "===";
	public static final String NSAME = "!==";

	public static final String LTE = "<=";
	public static final char LT = '<';
	public static final String GTE = ">=";
	public static final char GT = '>';

	public static final char HOOK = '?';

	private final static HashMap<Integer, String> map = new HashMap<Integer, String>();

	static {
		map.put(Integer.valueOf(JSParser.Function_), Keywords.FUNCTION);
		map.put(Integer.valueOf(JSParser.NullLiteral), Keywords.NULL);
		map.put(Integer.valueOf(JSParser.Return), Keywords.RETURN);
		map.put(Integer.valueOf(JSParser.If), Keywords.IF);
		map.put(Integer.valueOf(JSParser.Else), Keywords.IF);
		map.put(Integer.valueOf(JSParser.Switch), Keywords.SWITCH);
		map.put(Integer.valueOf(JSParser.Case), Keywords.CASE);
		map.put(Integer.valueOf(JSParser.Break), Keywords.BREAK);
		map.put(Integer.valueOf(JSParser.Continue), Keywords.CONTINUE);
		map.put(Integer.valueOf(JSParser.Default), Keywords.DEFAULT);
		map.put(Integer.valueOf(JSParser.For), Keywords.FOR);
// NOT THERE!		map.put(Integer.valueOf(JavaScriptParser.EACH), Keywords.EACH);
		map.put(Integer.valueOf(JSParser.While), Keywords.WHILE);
		map.put(Integer.valueOf(JSParser.Do), Keywords.DO);
		map.put(Integer.valueOf(JSParser.Var), Keywords.VAR);
		//TODO Let strict vs not strict? map.put(Integer.valueOf(JavaScriptParser.StrictLet), Keywords.LET);
		map.put(Integer.valueOf(JSParser.Const), Keywords.CONST);
		map.put(Integer.valueOf(JSParser.In), Keywords.IN);
		map.put(Integer.valueOf(JSParser.New), Keywords.NEW);
//		map.put(Integer.valueOf(JavaScriptParser.TRUE), Keywords.TRUE);
//		map.put(Integer.valueOf(JavaScriptParser.FALSE), Keywords.FALSE);
		map.put(Integer.valueOf(JSParser.Try), Keywords.TRY);
		map.put(Integer.valueOf(JSParser.Catch), Keywords.CATCH);
		map.put(Integer.valueOf(JSParser.Finally), Keywords.FINALLY);
		map.put(Integer.valueOf(JSParser.Instanceof), Keywords.INSTANCEOF);
		map.put(Integer.valueOf(JSParser.Typeof), Keywords.TYPEOF);
		map.put(Integer.valueOf(JSParser.This), Keywords.THIS);
		map.put(Integer.valueOf(JSParser.Throw), Keywords.THROW);
		map.put(Integer.valueOf(JSParser.Export), Keywords.EXPORT);
		map.put(Integer.valueOf(JSParser.Import), Keywords.IMPORT);
		map.put(Integer.valueOf(JSParser.With), Keywords.WITH);
		map.put(Integer.valueOf(JSParser.Delete), Keywords.DELETE);
//		map.put(Integer.valueOf(JavaScriptParser.GET), Keywords.GET);
//		map.put(Integer.valueOf(JavaScriptParser.SET), Keywords.SET);
		map.put(Integer.valueOf(JSParser.Void), Keywords.VOID);
//		map.put(Integer.valueOf(JavaScriptParser.WXML), Keywords.XML);
//		map.put(Integer.valueOf(JavaScriptParser.NAMESPACE), Keywords.NAMESPACE);
		map.put(Integer.valueOf(JSParser.Yield), Keywords.YIELD);

		map.put(Integer.valueOf(JSParser.Assign), String
				.valueOf(Keywords.ASSIGN));

		map.put(Integer.valueOf(JSParser.PlusAssign), Keywords.ADDASS);
		map.put(Integer.valueOf(JSParser.MinusAssign), Keywords.SUBASS);
		map.put(Integer.valueOf(JSParser.MultiplyAssign), Keywords.MULASS);
		map.put(Integer.valueOf(JSParser.DivideAssign), Keywords.DIVASS);
		map.put(Integer.valueOf(JSParser.ModulusAssign), Keywords.MODASS);
		map.put(Integer.valueOf(JSParser.BitXorAssign), Keywords.XORASS);
		map.put(Integer.valueOf(JSParser.BitAndAssign), Keywords.ANDASS);
		map.put(Integer.valueOf(JSParser.BitOrAssign), Keywords.ORASS);
		map.put(Integer.valueOf(JSParser.LeftShiftArithmeticAssign), Keywords.SHLASS);
		map.put(Integer.valueOf(JSParser.RightShiftArithmeticAssign), Keywords.SHRASS);
		map.put(Integer.valueOf(JSParser.RightShiftLogicalAssign), Keywords.SHUASS);

		//
		//
		//

		map.put(Integer.valueOf(JSParser.PlusPlus), Keywords.INC);
		map.put(Integer.valueOf(JSParser.MinusMinus), Keywords.DEC);
//TODO check same as the 2 above		map.put(Integer.valueOf(JavaScriptParser.INC), Keywords.INC);
//		map.put(Integer.valueOf(JavaScriptParser.DEC), Keywords.DEC);
		map.put(Integer.valueOf(JSParser.Minus), String.valueOf(Keywords.SUB));
		map.put(Integer.valueOf(JSParser.Plus), String.valueOf(Keywords.ADD));

		map.put(Integer.valueOf(JSParser.Plus), String.valueOf(Keywords.ADD));//TODO check 
		map.put(Integer.valueOf(JSParser.Minus), String.valueOf(Keywords.SUB));
		map.put(Integer.valueOf(JSParser.Divide), String.valueOf(Keywords.DIV));
		map.put(Integer.valueOf(JSParser.Multiply), String.valueOf(Keywords.MUL));
		map.put(Integer.valueOf(JSParser.Modulus), String.valueOf(Keywords.MOD));

		map.put(Integer.valueOf(JSParser.And), Keywords.LAND);
		map.put(Integer.valueOf(JSParser.Or), Keywords.LOR);
		map.put(Integer.valueOf(JSParser.Not), String.valueOf(Keywords.NOT));

		map.put(Integer.valueOf(JSParser.BitOr), String.valueOf(Keywords.OR));
		map.put(Integer.valueOf(JSParser.BitXOr), String.valueOf(Keywords.XOR));
		map.put(Integer.valueOf(JSParser.BitAnd), String.valueOf(Keywords.AND));
		map.put(Integer.valueOf(JSParser.BitNot), String.valueOf(Keywords.INV));

		map.put(Integer.valueOf(JSParser.LeftShiftArithmetic), Keywords.SHL);
		map.put(Integer.valueOf(JSParser.RightShiftArithmetic), Keywords.SHR);
		map.put(Integer.valueOf(JSParser.RightShiftLogical), Keywords.SHU);

		map.put(Integer.valueOf(JSParser.Equals_), Keywords.EQ);
		map.put(Integer.valueOf(JSParser.NotEquals), Keywords.NEQ);
		map.put(Integer.valueOf(JSParser.LessThanEquals), Keywords.LTE);
		map.put(Integer.valueOf(JSParser.LessThan), String.valueOf(Keywords.LT));
		map.put(Integer.valueOf(JSParser.GreaterThanEquals), Keywords.GTE);
		map.put(Integer.valueOf(JSParser.GreaterThanEquals), String.valueOf(Keywords.GT));
		map.put(Integer.valueOf(JSParser.IdentityEquals), Keywords.SAME);
		map.put(Integer.valueOf(JSParser.IdentityNotEquals), Keywords.NSAME);

		map.put(Integer.valueOf(JSParser.Instanceof), Keywords.INSTANCEOF);
		map.put(Integer.valueOf(JSParser.Typeof), Keywords.TYPEOF);
		map.put(Integer.valueOf(JSParser.In), Keywords.IN);
	}

	public static String fromToken(int token) {
		Integer tokenValue = Integer.valueOf(token);
		if (map.containsKey(tokenValue)) {
			return map.get(tokenValue);
		}
		throw new IllegalArgumentException(Integer.toString(token));
	}

	private static String charToHexString(char ch) {
		return Integer.toHexString(ch).toUpperCase();
	}

	public static String encodeString(String s, char quoteChar) {

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			switch (ch) {
			case '\t':
				buffer.append("\\t");
				break;

			case '\b':
				buffer.append("\\b");
				break;

			case '\f':
				buffer.append("\\f");
				break;

			case '\r':
				buffer.append("\\r");
				break;

			case '\n':
				buffer.append("\\n");
				break;

			case '\\':
				buffer.append("\\\\");
				break;

			default:
				if (ch == quoteChar) {
					buffer.append("\\");
					buffer.append(quoteChar);
				} else if (ch > 0xfff) {
					buffer.append("\\u" + charToHexString(ch));
				} else if (ch > 0xff) {
					buffer.append("\\u0" + charToHexString(ch));
				} else if (ch > 0x7f) {
					buffer.append("\\u00" + charToHexString(ch));
				} else
					buffer.append(ch);
			}
		}
		return buffer.toString();
	}

	public static boolean isKeyword(String value) {
		return value != null && value.length() != 0 && map.containsValue(value);
	}
}
