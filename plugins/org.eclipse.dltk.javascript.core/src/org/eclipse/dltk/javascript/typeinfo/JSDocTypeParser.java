/*******************************************************************************
 * Copyright (c) 2011 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.typeinfo;

import static org.eclipse.dltk.javascript.parser.util.CharStreamUtil.match;
import static org.eclipse.dltk.javascript.parser.util.CharStreamUtil.skipSpaces;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.eclipse.dltk.internal.javascript.ti.JSDocProblem;
import org.eclipse.dltk.internal.javascript.validation.ValidationMessages;
import org.eclipse.dltk.javascript.core.JavaScriptProblems;
import org.eclipse.dltk.javascript.typeinfo.model.FunctionType;
import org.eclipse.dltk.javascript.typeinfo.model.GenericType;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.Parameter;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.dltk.javascript.typeinfo.model.RecordProperty;
import org.eclipse.dltk.javascript.typeinfo.model.RecordType;
import org.eclipse.dltk.javascript.typeinfo.model.SimpleType;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelFactory;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelLoader;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelPackage;
import org.eclipse.dltk.javascript.typeinfo.model.UnionType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.osgi.util.NLS;

public class JSDocTypeParser {

	public static final String FUNCTION = "function";
	public static final String CLASS = "Class";

	private final char[] extensionChars;

	public JSDocTypeParser() {
		this(null);
	}

	/**
	 * Creates this type parser specifying the characters which potentially
	 * could lead the syntax extensions. If such a character occurs in the type
	 * name, then {@link #parseExtension(CharStream, int)} is called and can
	 * continue the parsing.
	 * 
	 * @param extensionChars
	 */
	protected JSDocTypeParser(char[] extensionChars) {
		this.extensionChars = extensionChars;
	}

	private JSDocTypeParserExtension extension;

	public void setExtension(JSDocTypeParserExtension extension) {
		this.extension = extension;
	}

	public JSType parse(String input) throws ParseException {
		final ANTLRStringStream stream = new ANTLRStringStream(input);
		final JSType type = parse(stream, true);
		if (stream.LT(1) != CharStream.EOF) {
			throw new ParseException("Unexpected "
					+ stream.substring(stream.index(), stream.size() - 1),
					stream.index());
		}
		return type;
	}

	/**
	 * Parses the next type expression. {@link UnionType}s are handled at this
	 * level, parsing of parts is delegated to {@link #parseType(CharStream)}.
	 * 
	 * @param input
	 * @param autoUnion
	 *            if <code>true</code> then it is allowed to parse all parts of
	 *            the union type, but if <code>false</code> then unit type
	 *            declaration should be enclosed in parenthesis -
	 *            <code>'('</code> and <code>')'</code>.
	 */
	public JSType parse(CharStream input, boolean autoUnion)
			throws ParseException {
		skipSpaces(input);
		final List<JSType> types = new ArrayList<JSType>();
		final boolean inParenthese = input.LT(1) == '(';
		if (inParenthese) {
			input.consume();
			skipSpaces(input);
		}
		for (;;) {
			final JSType type = parseType(input);
			if (type != null) {
				types.add(type);
				skipSpaces(input);
				if ((inParenthese || autoUnion) && input.LT(1) == '|') {
					input.consume();
					skipSpaces(input);
					continue;
				}
			}
			break;
		}
		if (inParenthese) {
			match(input, ')');
		}
		if (types.size() == 1) {
			return types.get(0);
		} else if (types.size() > 1) {
			final UnionType unionType = TypeInfoModelFactory.eINSTANCE
					.createUnionType();
			unionType.getTargets().addAll(types);
			return unionType;
		} else {
			return null;
		}
	}

	protected JSType parseType(CharStream input) throws ParseException {
		if (input.LT(1) == '?') {
			// Nullable type
			input.consume();
		} else if (input.LT(1) == '!') {
			// Non-nullable type
			input.consume();
		}
		if (input.LT(1) == '{') {
			input.consume();
			final RecordType recordType = parseRecordType(input);
			match(input, '}');
			return recordType;
		} else if (input.LT(1) == '*') {
			input.consume();
			return TypeInfoModelFactory.eINSTANCE.createAnyType();
		} else {
			return parseTypeName(input);
		}
	}

	protected JSType parseTypeName(CharStream input) throws ParseException {
		final int start = input.index();
		int ch;
		int end;
		for (;;) {
			ch = input.LT(1);
			if (extensionChars != null) {
				for (int i = 0; i < extensionChars.length; ++i) {
					if (extensionChars[i] == ch) {
						final JSType result = parseExtension(input, start);
						if (result != null) {
							if (extension != null) {
								extension.reportType(result, start,
										input.index());
							}
							return result;
						}
						break;
					}
				}
			}
			if (Character.isWhitespace(ch)) {
				end = input.index();
				skipSpaces(input);
				ch = input.LT(1);
			} else if (ch == '<' || ch == '(' || ch == '['
					|| ch == CharStream.EOF || ch == '|' || ch == ','
					|| ch == '=' || ch == '}' || ch == '>' || ch == ')'
					|| ch == ']') {
				end = input.index();
			} else if (ch == '.' && input.LT(2) == '<') {
				end = input.index();
			} else {
				input.consume();
				continue;
			}
			break;
		}
		if (ch == '<') {
			final String baseType = input.substring(start, end - 1);
			input.consume();
			final List<JSType> typeParams = parseTypeParams(input);
			match(input, '>');
			JSType type = createGenericType(baseType, typeParams);
			if (extension != null) {
				extension.reportType(type, start, end);
			}
			return checkIfArray(input, type);
		} else if (ch == '.' && input.LT(2) == '<') {
			final String baseType = input.substring(start, end - 1);
			input.consume();
			input.consume();
			final List<JSType> typeParams = parseTypeParams(input);
			match(input, '>');
			JSType type = createGenericType(baseType, typeParams);
			if (extension != null) {
				extension.reportType(type, start, end);
			}
			return checkIfArray(input, type);
		} else if (ch == '('
				&& FUNCTION.equals(input.substring(start, end - 1))) {
			input.consume();
			final FunctionType functionType = TypeInfoModelFactory.eINSTANCE
					.createFunctionType();
			parseFunctionParams(input, functionType.getParameters());
			match(input, ')');
			skipSpaces(input);
			if (input.LT(1) == ':') {
				input.consume();
				skipSpaces(input);
				functionType.setReturnType(parse(input, false));
			}
			return checkIfArray(input, functionType);
		} else if (ch == '[') {
			final JSType itemType = createType(input, start, end);
			input.consume();
			match(input, ']');
			final JSType array = createArray(itemType);
			return checkIfArray(input, array);
		} else {
			return end > start ? createType(input, start, end) : null;
		}
	}

	/**
	 * Parses the syntax extension, returns the parsed type or <code>null</code>
	 * if parsing should continue in the normal way. This method is called if
	 * current character (<code>input.LT(1)</code>) is equal to one of the
	 * characters passed to the constructor.
	 * 
	 * @param input
	 *            the character stream, <code>input.LT(1)</code>
	 * @param start
	 * @return
	 * @throws ParseException
	 */
	protected JSType parseExtension(CharStream input, int start)
			throws ParseException {
		return null;
	}

	private JSType createType(CharStream input, final int start, final int end) {
		final JSType type = createType(translate(input
				.substring(start, end - 1)));
		if (extension != null) {
			extension.reportType(type, start, end);
		}
		return type;
	}

	/**
	 * @param input
	 * @param type
	 * @return
	 * @throws ParseException
	 */
	private JSType checkIfArray(CharStream input, JSType type)
			throws ParseException {
		int ch = input.LT(1);
		while (ch == '[') {
			input.consume();
			match(input, ']');
			type = createArray(type);
			ch = input.LT(1);
		}
		return type;
	}

	protected JSType createType(String typeName) {
		if (ITypeNames.UNDEFINED.equals(typeName)) {
			return TypeInfoModelFactory.eINSTANCE.createUndefinedType();
		} else if (CLASS.equals(typeName)) {
			return TypeInfoModelFactory.eINSTANCE.createClassType();
		} else {
			return TypeUtil.ref(typeName);
		}
	}

	protected JSType createArray(JSType itemType) {
		return TypeUtil.arrayOf(itemType);
	}

	protected JSType createGenericType(String baseType, List<JSType> typeParams)
			throws ParseException {
		if (ITypeNames.ARRAY.equals(baseType)) {
			if (typeParams.size() != 1) {
				throw new JSDocParseException(
						NLS.bind(
								ValidationMessages.IncorrectNumberOfTypeArguments,
								ITypeNames.ARRAY),
						JavaScriptProblems.PARAMETERIZED_TYPE_INCORRECT_ARGUMENTS);
			}
			return createArray(typeParams.get(0));
		} else if (ITypeNames.MAP.equals(baseType)) {
			if (typeParams.size() != 2) {
				throw new JSDocParseException(NLS.bind(
						ValidationMessages.IncorrectNumberOfTypeArguments,
						ITypeNames.MAP),
						JavaScriptProblems.PARAMETERIZED_TYPE_INCORRECT_ARGUMENTS);
			}
			return TypeUtil.mapOf(typeParams.get(0), typeParams.get(1));
		} else if (ITypeNames.SET.equals(baseType)) {
			if (typeParams.size() != 1) {
				throw new JSDocParseException(NLS.bind(
						ValidationMessages.IncorrectNumberOfTypeArguments,
						ITypeNames.SET),
						JavaScriptProblems.PARAMETERIZED_TYPE_INCORRECT_ARGUMENTS);
			}
			// where is the set type? just use map for now
			return TypeUtil.mapOf(null, typeParams.get(0));
		} else if (CLASS.equals(baseType)) {
			if (typeParams.size() != 1) {
				throw new JSDocParseException(
						NLS.bind(
								ValidationMessages.IncorrectNumberOfTypeArguments,
								CLASS),
						JavaScriptProblems.PARAMETERIZED_TYPE_INCORRECT_ARGUMENTS);
			}
			final JSType typeParam = typeParams.get(0);
			if (typeParam.eClass() != TypeInfoModelPackage.Literals.SIMPLE_TYPE) {
				throw new JSDocParseException(
						JSDocProblem.WRONG_TYPE_PARAMETERIZATION, CLASS,
						typeParam.eClass().getName());
			}
			return TypeUtil.classType(((SimpleType) typeParam).getTarget());
		} else if (ITypeNames.OBJECT.equals(baseType)) {
			if (typeParams.isEmpty() || typeParams.size() > 2) {
				throw new JSDocParseException(
						NLS.bind(
								ValidationMessages.IncorrectNumberOfTypeArguments,
								ITypeNames.OBJECT),
						JavaScriptProblems.PARAMETERIZED_TYPE_INCORRECT_ARGUMENTS);
			} else if (typeParams.size() == 2) {
				return TypeUtil.mapOf(typeParams.get(0), typeParams.get(1));
			} else {
				assert typeParams.size() == 1;
				return TypeUtil.mapOf(null, typeParams.get(0));
			}
		} else {
			return doCreateGenericType(baseType, typeParams);
		}
	}

	protected JSType doCreateGenericType(String baseType,
			List<JSType> typeParams) throws ParseException {
		if (!typeParams.isEmpty()) {
			Type type = TypeUtil.type(baseType);
			if (!(type instanceof GenericType)) {
				// this is a big of a hack because of using stuff beween <>
				// which are not directly types
				// but more information about the target type
				StringBuilder sb = new StringBuilder();
				sb.append(baseType);
				sb.append('<');
				int index = 0;
				for (JSType typeParam : typeParams) {
					if (++index > 1) {
						sb.append(',');
					}
					sb.append(typeParam.getName());
				}
				sb.append('>');
				return TypeUtil.ref(sb.toString());
			}
			return TypeUtil.parameterizedType(type,
					typeParams);
		}
		return TypeUtil.ref(baseType);
	}

	protected List<JSType> parseTypeParams(CharStream input)
			throws ParseException {
		final List<JSType> types = new ArrayList<JSType>();
		for (;;) {
			final JSType type = parse(input, true);
			if (type != null) {
				types.add(type);
				skipSpaces(input);
				if (input.LT(1) == ',') {
					input.consume();
					continue;
				}
			}
			break;
		}
		return types;
	}

	public void parseFunctionParams(CharStream input,
			EList<Parameter> parameters) throws ParseException {
		for (;;) {
			// TODO support parameter names (at least "this")
			skipSpaces(input);
			boolean varargs = false;
			boolean squareBracket = false;
			if (input.LT(1) == '.' && input.LT(2) == '.' && input.LT(3) == '.') {
				input.consume();
				input.consume();
				input.consume();
				varargs = true;
				if (input.LT(1) == '[') {
					input.consume();
					squareBracket = true;
				}
			}
			final JSType type = parse(input, true);
			if (type != null) {
				if (input.LT(1) == '.' && input.LT(2) == '.'
						&& input.LT(3) == '.') {
					input.consume();
					input.consume();
					input.consume();
					varargs = true;
					if (input.LT(1) == '[') {
						input.consume();
						squareBracket = true;
					}
				}
				final Parameter parameter = TypeInfoModelFactory.eINSTANCE
						.createParameter();
				parameter.setType(type);
				if (varargs) {
					parameter.setKind(ParameterKind.VARARGS);
					if (squareBracket) {
						match(input, ']');
					}
				} else if (input.LT(1) == '=') {
					parameter.setKind(ParameterKind.OPTIONAL);
					input.consume();
				}
				parameters.add(parameter);
				skipSpaces(input);
				if (input.LT(1) == ',') {
					input.consume();
					continue;
				}
			}
			break;
		}
	}

	protected RecordType parseRecordType(CharStream input)
			throws ParseException {
		final int start = input.index();
		final RecordType type = TypeInfoModelFactory.eINSTANCE
				.createRecordType();
		skipSpaces(input);
		for (;;) {
			int ch = input.LT(1);
			final boolean optional = ch == '[';
			if (optional) {
				input.consume();
				ch = input.LT(1);
			}
			boolean validPropertyName = true;
			final int nameStart = input.index();
			String name = null;
			if (ch == '"' || ch == '\'') {
				input.consume();
				ch = input.LT(1);
				while (ch != '"' && ch != '\'' && ch != -1) {
					input.consume();
					ch = input.LT(1);
				}
				if (ch == -1) {
					throw new ParseException("Ending quote expected",
							input.index());
				}
				validPropertyName = false;
				name = input.substring(nameStart + 1, input.index() - 1);
				input.consume();
			} else if (Character.isJavaIdentifierStart(ch)) {
				input.consume();
				while (Character.isJavaIdentifierPart(input.LT(1))) {
					input.consume();
				}
				name = input.substring(nameStart, input.index() - 1);
			}
			if (name != null) {
				final RecordProperty property = TypeInfoModelFactory.eINSTANCE
						.createRecordProperty();
				property.setName(name);
				skipSpaces(input);
				if (optional) {
					match(input, ']');
					skipSpaces(input);
					property.setOptional(true);
				}

				if (input.LT(1) == ':') {
					input.consume();
					final JSType memberType = parse(input, true);
					ch = input.LT(1);
					if (ch == '=') {
						input.consume();
						property.setOptional(true);
					}
					if (memberType != null) {
						property.setType(memberType);
					} else {
						property.setType(TypeInfoModelFactory.eINSTANCE
								.createAnyType());
					}
				} else {
					property.setType(TypeInfoModelFactory.eINSTANCE
							.createAnyType());
				}
				if (validPropertyName)
					type.getMembers().add(property);
				skipSpaces(input);
				if (input.LT(1) == ',') {
					input.consume();
					skipSpaces(input);
					continue;
				}
			}
			break;
		}
		type.setTypeName('{' + input.substring(start, input.index() - 1) + '}');
		return type;
	}

	protected String translate(String typeName) {
		return TypeInfoModelLoader.getInstance().translateTypeName(typeName);
	}

}
