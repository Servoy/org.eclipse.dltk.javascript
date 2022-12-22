/*******************************************************************************
 * Copyright (c) 2010 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.internal.javascript.ti;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.eclipse.dltk.annotations.NonNull;
import org.eclipse.dltk.annotations.Nullable;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.compiler.problem.IProblemCategory;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.ProblemCategoryManager;
import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.CallExpression;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.IVariableStatement;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.PropertyExpression;
import org.eclipse.dltk.javascript.ast.PropertyInitializer;
import org.eclipse.dltk.javascript.ast.Statement;
import org.eclipse.dltk.javascript.ast.VariableDeclaration;
import org.eclipse.dltk.javascript.ast.VariableStatement;
import org.eclipse.dltk.javascript.core.JavaScriptLanguageUtil;
import org.eclipse.dltk.javascript.core.JavaScriptNature;
import org.eclipse.dltk.javascript.parser.JSParser;
import org.eclipse.dltk.javascript.parser.JSProblemIdentifier;
import org.eclipse.dltk.javascript.parser.JSProblemReporter;
import org.eclipse.dltk.javascript.parser.ProblemReporter;
import org.eclipse.dltk.javascript.parser.jsdoc.JSDocTag;
import org.eclipse.dltk.javascript.parser.jsdoc.JSDocTags;
import org.eclipse.dltk.javascript.parser.jsdoc.SimpleJSDocParser;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder;
import org.eclipse.dltk.javascript.typeinfo.ITypeChecker;
import org.eclipse.dltk.javascript.typeinfo.ITypeInfoContext;
import org.eclipse.dltk.javascript.typeinfo.JSDocParseException;
import org.eclipse.dltk.javascript.typeinfo.JSDocTypeParser;
import org.eclipse.dltk.javascript.typeinfo.model.JSType;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.dltk.javascript.typeinfo.model.RecordProperty;
import org.eclipse.dltk.javascript.typeinfo.model.RecordType;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelFactory;
import org.eclipse.dltk.javascript.typeinfo.model.Visibility;
import org.eclipse.emf.common.util.EList;
import org.eclipse.osgi.util.NLS;

/**
 * Implements support for javadocs tags .
 * 
 * @see http://jsdoc.sourceforge.net/
 * @see http://code.google.com/p/jsdoc-toolkit/wiki/TagType
 * @see http://code.google.com/p/jsdoc-toolkit/wiki/TagParam
 */
public class JSDocSupport implements IModelBuilder {

	public static final String PARAM_DOTS = "...";
	public static final String PARAM_OPTIONAL = "=";

	public String getFeatureId() {
		return JSDocSupport.class.getName();
	}

	public int priorityFor(ITypeInfoContext context) {
		return PRIORITY_DEFAULT;
	}

	public static JSDocTags parse(Comment comment) {
		return new SimpleJSDocParser().parse(comment.getText(),
				comment.sourceStart());
	}

	public enum JSDocFunctionContext {
		DECLARATION {
			@Override
			String[] getReturnTags() {
				return JSDocTag.RETURN_TAGS;
			}
		},
		EXPRESSION {
			@Override
			String[] getReturnTags() {
				return RETURN_ONLY_TAGS;
			}
		};

		static final String[] RETURN_ONLY_TAGS = { JSDocTag.RETURNS,
				JSDocTag.RETURN };

		abstract String[] getReturnTags();
	}

	public void processMethod(FunctionStatement statement, IMethod method,
			JSProblemReporter reporter, ITypeChecker typeChecker) {
		Comment comment = getComment(statement);
		if (comment == null) {
			return;
		}
		final JSDocTags tags = parse(comment);
		processMethod(method,
				statement.isDeclaration() ? JSDocFunctionContext.DECLARATION
						: JSDocFunctionContext.EXPRESSION, tags, reporter,
				typeChecker);
	}

	public final void processMethod(IMethod method, final JSDocTags tags,
			JSProblemReporter reporter, ITypeChecker typeChecker) {
		processMethod(method, JSDocFunctionContext.EXPRESSION, tags, reporter,
				typeChecker);
	}

	public void processMethod(IMethod method, JSDocFunctionContext context,
			final JSDocTags tags, JSProblemReporter reporter,
			ITypeChecker typeChecker) {
		if (method.getType() == null) {
			parseType(method, tags, context.getReturnTags(), reporter,
					typeChecker);
		}
		parseParams(method, tags, reporter, typeChecker);
		parseThis(method, tags, reporter, typeChecker);
		parseDeprecation(method, tags, reporter);
		parseAccessModifiers(method, tags, reporter);
		parseConstructor(method, tags, reporter);
		parseExtends(method, tags, reporter, typeChecker);
		parseThrows(method, tags, reporter, typeChecker);
		parseSuppressWarnings(method, tags, reporter);
	}

	private void parseExtends(IMethod method, JSDocTags tags,
			JSProblemReporter reporter, ITypeChecker typeChecker) {
		final JSDocTag extendsTag = tags.get(JSDocTag.EXTENDS);
		if (extendsTag != null) {
			final JSType type = parseType(extendsTag, false, reporter);
			if (type != null) {
				if (typeChecker != null)
					typeChecker.checkType(type, extendsTag);
				method.setExtendsType(type);
			}
			validateSingleTag(tags, JSDocTag.EXTENDS, reporter);
		}
	}

	protected void parseSuppressWarnings(IElement element, JSDocTags tags,
			JSProblemReporter reporter) {
		final List<JSDocTag> suppressWarnings = tags
				.list(JSDocTag.SUPPRESS_WARNINGS);
		if (!suppressWarnings.isEmpty()) {
			for (JSDocTag tag : suppressWarnings) {
				processSuppressWarnings(tag, new CountingReporter(reporter),
						element);
			}
		}
	}

	private void parseThrows(IMethod method, JSDocTags tags,
			JSProblemReporter reporter, ITypeChecker typeChecker) {
		if (typeChecker != null) {
			List<JSDocTag> throwsTags = tags.list(JSDocTag.THROWS);
			for (JSDocTag throwsTag : throwsTags) {
				String value = throwsTag.value();
				String[] split = value.split(" ");
				if (split.length > 0) {
					if (isBraced(split[0])) {
						JSType type = translateTypeName(cutBraces(split[0]),
								throwsTag, reporter);
						typeChecker.checkType(type, throwsTag);
					}
				}
			}
		}

	}

	public static Comment getCallComment(CallExpression call) {
		ASTNode node = call;
		while (node != null) {
			if (node instanceof JSNode) {
				final Comment doc = ((JSNode) node).getDocumentation();
				if (doc != null) {
					return doc;
				}
			}
			if (node instanceof Statement) {
				break;
			}
			if (!(node instanceof JSNode)) {
				break;
			}
			node = ((JSNode) node).getParent();
		}
		return null;
	}

	@Deprecated
	public static Comment getFunctionComment(FunctionStatement statement) {
		return getComment(statement);
	}

	public static Comment getComment(JSNode statement) {
		Comment documentation = statement.getDocumentation();
		if (documentation != null) {
			return documentation;
		}
		final ASTNode parent = statement.getParent();
		if (parent instanceof BinaryOperation) {
			final BinaryOperation binary = (BinaryOperation) parent;
			if (binary.getOperation() == JSParser.Assign
					&& binary.getRightExpression() == statement) {
				documentation = binary.getLeftExpression().getDocumentation();
				if (documentation != null) {
					return documentation;
				}
			}
		} else if (parent instanceof PropertyInitializer) {
			final PropertyInitializer property = (PropertyInitializer) parent;
			if (property.getValue() == statement) {
				documentation = property.getName().getDocumentation();
				if (documentation != null) {
					return documentation;
				}
			}
		} else if (parent instanceof VariableDeclaration) {
			final VariableDeclaration variable = (VariableDeclaration) parent;
			if ((variable.getInitializer() == statement || variable
					.getIdentifier() == statement)
					&& variable.getParent() instanceof VariableStatement) {
				return ((VariableStatement) variable.getParent())
						.getDocumentation();
			}
		} else if (parent instanceof PropertyExpression) {
			return getComment((PropertyExpression) parent);
		}
		return null;
	}

	private void parseConstructor(IMethod method, JSDocTags tags,
			JSProblemReporter reporter) {
		if (tags.get(JSDocTag.CONSTRUCTOR) != null) {
			method.setConstructor(true);
			validateSingleTag(tags, JSDocTag.CONSTRUCTOR, reporter);
		}
	}

	public static class NamedValue<T> {
		public final String name;
		public final T value;

		private NamedValue(String name, T value) {
			this.name = name;
			this.value = value;
		}

		public static <T> NamedValue<T> of(String name, T value) {
			return new NamedValue<T>(name, value);
		}
	}

	protected static final List<NamedValue<Visibility>> STANDARD_ACCESS_MODIFIERS;

	static {
		final List<NamedValue<Visibility>> modifiers = new ArrayList<NamedValue<Visibility>>(
				3);
		modifiers.add(NamedValue.of(JSDocTag.PUBLIC, Visibility.PUBLIC));
		modifiers.add(NamedValue.of(JSDocTag.PROTECTED, Visibility.PROTECTED));
		modifiers.add(NamedValue.of(JSDocTag.PRIVATE, Visibility.PRIVATE));
		STANDARD_ACCESS_MODIFIERS = modifiers;
	}

	protected List<NamedValue<Visibility>> getSupportedAccessModifiers() {
		return STANDARD_ACCESS_MODIFIERS;
	}

	public void parseAccessModifiers(IMember member, JSDocTags tags,
			JSProblemReporter reporter) {
		final List<NamedValue<Visibility>> accessModifiers = getSupportedAccessModifiers();
		for (int i = 0; i < accessModifiers.size(); ++i) {
			final NamedValue<Visibility> pair = accessModifiers.get(i);
			final JSDocTag tag = tags.get(pair.name);
			if (tag != null) {
				member.setVisibility(pair.value);
				int extraTags = tags.count(pair.name) - 1;
				for (int j = i + 1; extraTags == 0
						&& j < accessModifiers.size(); ++j) {
					extraTags += tags.count(accessModifiers.get(j).name);
				}
				if (extraTags > 0) {
					final List<JSDocTag> all = new ArrayList<JSDocTag>();
					all.addAll(tags.list(pair.name));
					all.remove(tag);
					for (int j = i + 1; j < accessModifiers.size(); ++j) {
						all.addAll(tags.list(accessModifiers.get(j).name));
					}
					for (JSDocTag t : all) {
						reportProblem(reporter, JSDocProblem.IGNORED_TAG, t,
								t.name(), tag.name());
					}
				}
				break;
			}
		}
	}

	private void validateSingleTag(JSDocTags tags, String tagName,
			JSProblemReporter reporter) {
		if (reporter != null && tags.count(tagName) > 1) {
			final List<JSDocTag> t = tags.list(tagName);
			for (JSDocTag tag : t.subList(1, t.size())) {
				reportProblem(reporter, JSDocProblem.DUPLICATE_TAG, tag,
						tag.name());
			}
		}
	}

	public void processVariable(VariableDeclaration declaration,
			IVariable variable, JSProblemReporter reporter,
			ITypeChecker typeChecker) {
		Comment comment = declaration.getDocumentation();
		if (comment == null) {
			final IVariableStatement statement = declaration.getStatement();
			final List<VariableDeclaration> vars = statement.getVariables();
			if (!vars.isEmpty() && vars.get(0) == declaration) {
				comment = statement.getDocumentation();
				if (comment == null) {
					return;
				}
			} else {
				return;
			}
		}
		final JSDocTags tags = parse(comment);
		if (variable.getType() == null) {
			parseType(variable, tags, TYPE_TAGS, reporter, typeChecker);
		}
		parseTypeDef(variable, tags, reporter, typeChecker);
		parseDeprecation(variable, tags, reporter);
		parseAccessModifiers(variable, tags, reporter);
		parseSuppressWarnings(variable, tags, reporter);
	}

	private void parseTypeDef(IVariable variable, JSDocTags tags,
			JSProblemReporter reporter, ITypeChecker typeChecker) {
		final JSDocTag typeDefTag = tags.get(JSDocTag.TYPEDEF);
		if (typeDefTag != null) {
			final JSType type = parseType(typeDefTag, false, reporter);
			if (type != null) {
				if (!(type instanceof RecordType)) {
					reportProblem(reporter, JSDocProblem.UNSUPPORTED_TYPEDEF,
							typeDefTag, type.getName());
				} else {
					if (typeChecker != null)
						typeChecker.checkType(type, typeDefTag);
					variable.setTypeDef(type);
				}
			}
			validateSingleTag(tags, JSDocTag.TYPEDEF, reporter);
			if (reporter != null && tags.count(JSDocTag.TYPE) > 0) {
				reportProblem(reporter, JSDocProblem.TYPE_WITH_TYPEDEF,
						typeDefTag, typeDefTag.name());
			}
		}
	}

	private void parseThis(IMethod method, JSDocTags tags,
			JSProblemReporter reporter, ITypeChecker typeChecker) {
		final JSDocTag thisTag = tags.get(JSDocTag.THIS);
		if (thisTag != null) {
			final JSType type = parseType(thisTag, false, reporter);
			if (type != null) {
				if (typeChecker != null)
					typeChecker.checkType(type, thisTag);
				method.setThisType(type);
			}
			validateSingleTag(tags, JSDocTag.THIS, reporter);
		}
	}

	public void parseDeprecation(IMember member, JSDocTags tags,
			JSProblemReporter reporter) {
		if (tags.get(JSDocTag.DEPRECATED) != null) {
			member.setDeprecated(true);
			validateSingleTag(tags, JSDocTag.DEPRECATED, reporter);
		}
	}

	protected static class ParamInfo {
		public String type;
		public boolean varargs;
		public boolean optional;

		void clear() {
			type = null;
			varargs = false;
			optional = false;
		}
	}

	protected void parseParams(IMethod method, JSDocTags tags,
			JSProblemReporter reporter, ITypeChecker typeChecker) {
		final List<JSDocTag> paramTags = tags.list(JSDocTag.PARAM);
		if (paramTags.isEmpty()) {
			return;
		}
		int problemCount = 0;
		final Map<String, RecordType> objectPropertiesTypes = new HashMap<String, RecordType>();
		final Set<String> processedParams = new HashSet<String>();
		final ParamInfo pp = new ParamInfo();
		for (JSDocTag tag : paramTags) {
			pp.clear();
			final TagTokenizer st = new TagTokenizer(tag);
			if (st.hasMoreTokens()) {
				final String token = st.peek();
				if (isBraced(token)) {
					String type = cutBraces(token);
					if (type.startsWith(PARAM_DOTS)) {
						pp.varargs = true;
						type = type.substring(PARAM_DOTS.length());
					} else if (type.endsWith(PARAM_DOTS)) {
						pp.varargs = true;
						type = type.substring(0,
								type.length() - PARAM_DOTS.length());
					} else if (type.endsWith(PARAM_OPTIONAL)) {
						type = type.substring(0,
								type.length() - PARAM_OPTIONAL.length());
						pp.optional = true;
					}
					pp.type = type;
					st.nextToken();
				}
			}
			if (st.hasMoreTokens()) {
				String paramName = st.nextToken();
				if (paramName.startsWith("[") && paramName.endsWith("]")) {
					pp.optional = true;
					paramName = paramName.substring(1, paramName.length() - 1);
					int defaultValueSeperatorIndex = paramName.indexOf('=');
					if (defaultValueSeperatorIndex != -1) {
						paramName = paramName.substring(0,
								defaultValueSeperatorIndex);
					}
				}
				if (!pp.varargs && paramName.endsWith(PARAM_DOTS)) {
					// just in case, so next condition doesn't use ".." as
					// property name.
					pp.varargs = true;
					paramName = paramName.substring(0, paramName.length()
							- PARAM_DOTS.length());
				}
				String propertyName = null;
				int propertiesObjectIndex = paramName.lastIndexOf('.');
				if (propertiesObjectIndex != -1) {
					// http://code.google.com/p/jsdoc-toolkit/wiki/TagParam
					// = Parameters With Properties =
					propertyName = paramName
							.substring(propertiesObjectIndex + 1);
					if (JavaScriptLanguageUtil.isValidIdentifier(propertyName)) {
						String objectName = paramName.substring(0,
								propertiesObjectIndex);
						RecordType propertiesType = objectPropertiesTypes
								.get(objectName);
						if (propertiesType == null) {
							propertiesType = TypeInfoModelFactory.eINSTANCE
									.createRecordType();
							propertiesType.setTypeName('{' + objectName + '}');
							objectPropertiesTypes.put(objectName,
									propertiesType);
							final IParameter param = method
									.getParameter(objectName);
							if (param != null) {
								param.setType(propertiesType);
								if (pp.optional)
									param.setKind(ParameterKind.OPTIONAL);
							} else {
								int index = objectName.lastIndexOf('.');
								if (index == -1) {
									++problemCount;
									reportProblem(reporter,
											JSDocProblem.UNKNOWN_PARAM, tag,
											objectName);
								} else {
									RecordType parentRecordType = objectPropertiesTypes
											.get(objectName.substring(0, index));
									if (parentRecordType != null) {
										String memberName = objectName
												.substring(index + 1);
										EList<Member> members = parentRecordType
												.getMembers();
										for (Member member : members) {
											if (member.getName().equals(
													memberName)) {
												member.setType(propertiesType);
												break;
											}
										}
									}
								}
							}
						}
						final RecordProperty property = TypeInfoModelFactory.eINSTANCE
								.createRecordProperty();
						property.setName(propertyName);
						if (pp.type != null) {
							JSType type = translateTypeName(pp.type, tag,
									reporter);
							if (typeChecker != null)
								typeChecker.checkType(type, tag);
							property.setType(type);
						}
						property.setOptional(pp.optional);
						propertiesType.getMembers().add(property);
						continue;
					}
				}
				if (method.getParameter(paramName) != null
						&& !processedParams.add(paramName)) {
					++problemCount;
					reportProblem(reporter, JSDocProblem.DUPLICATE_PARAM, tag,
							paramName);
					continue;
				}
				IParameter parameter = method.getParameter(paramName);
				if (parameter != null) {
					if (!pp.optional && st.hasMoreTokens()
							&& st.nextToken().equals("optional")) {
						pp.optional = true;
					}
					updateParameter(tag, parameter, pp, reporter, typeChecker);
				} else if (pp.varargs) {
					/*
					 * create virtual parameter for varargs as most of the time
					 * passed values are accessed via "arguments" object and
					 * parameter declaration in code is not required.
					 */
					parameter = method.createParameter();
					parameter.setName(paramName);
					updateParameter(tag, parameter, pp, reporter, typeChecker);
					method.getParameters().add(parameter);
					processedParams.add(paramName);
				} else {
					++problemCount;
					reportProblem(reporter, JSDocProblem.UNKNOWN_PARAM, tag,
							paramName);
				}
			} else {
				++problemCount;
				reportProblem(reporter, JSDocProblem.MISSING_PARAMETER_NAME,
						tag);
			}
		}
		if (problemCount == 0 && reporter != null) {
			for (IParameter parameter : method.getParameters()) {
				if (!processedParams.contains(parameter.getName())
						&& !objectPropertiesTypes.containsKey(parameter
								.getName())) {
					final ReferenceLocation location = parameter.getLocation();
					reporter.reportProblem(
							JSDocProblem.PARAMETER_MISSING_ANNOTATION,
							JSDocProblem.PARAMETER_MISSING_ANNOTATION
									.formatMessage(parameter.getName()),
							location.getNameStart(), location.getNameEnd());
				}
			}
		}
	}

	protected void updateParameter(JSDocTag tag, final IParameter parameter,
			final ParamInfo pp, JSProblemReporter reporter,
			ITypeChecker typeChecker) {
		if (pp.type != null && parameter.getType() == null) {
			JSType type = translateTypeName(pp.type, tag, reporter);
			if (typeChecker != null)
				typeChecker.checkType(type, tag);
			parameter.setType(type);
		}
		if (pp.varargs) {
			parameter.setKind(ParameterKind.VARARGS);
		} else if (pp.optional) {
			parameter.setKind(ParameterKind.OPTIONAL);
		}
	}

	public static final String[] TYPE_TAGS = { JSDocTag.TYPE };

	public static class TagTokenizer {
		private final String content;
		private final int end;
		private int position;
		private int tokenStart;

		public TagTokenizer(JSDocTag tag) {
			this(tag.value());
		}

		public TagTokenizer(String content) {
			this.content = content;
			this.end = content.length();
			this.position = skipDelimiters(0);
		}

		/**
		 * The token loaded by {@link #peek()} if not <code>null</code>.
		 */
		private String current;

		/**
		 * Checks if there are more tokens available from this tokenizer.
		 */
		public boolean hasMoreTokens() {
			return current != null || position < end;
		}

		/**
		 * Returns the first character of the next token without removing it
		 * from this tokenizer or <code>\0</code> if there are no more tokens.
		 */
		public char peekChar() {
			if (current == null) {
				if (position < end) {
					return content.charAt(position);
				} else {
					return '\0';
				}
			} else if (current.length() != 0) {
				return current.charAt(0);
			} else {
				return '\0';
			}
		}

		/**
		 * Returns the next token without removing it from this tokenizer or
		 * <code>null</code> if there are no more tokens.
		 */
		public String peek() {
			if (current == null) {
				if (position < end) {
					current = fetchNextToken();
				} else {
					return null;
				}
			}
			return current;
		}

		/**
		 * Returns the next token from this tokenizer.
		 * 
		 * @throws NoSuchElementException
		 *             if no more tokens available.
		 */
		public String nextToken() {
			if (current != null) {
				final String token = current;
				current = null;
				return token;
			}
			return fetchNextToken();
		}

		/**
		 * Returns the starting position of the last fetched token.
		 */
		public int getTokenStart() {
			return tokenStart;
		}

		private int skipDelimiters(int pos) {
			while (pos < end && Character.isWhitespace(content.charAt(pos))) {
				++pos;
			}
			return pos;
		}

		private String fetchNextToken() {
			if (position == end) {
				throw new NoSuchElementException();
			}
			tokenStart = position;
			int braceCount = 0;
			while (position < end) {
				if (Character.isWhitespace(content.charAt(position))
						&& braceCount == 0) {
					break;
				} else if (content.charAt(position) == '{') {
					++braceCount;
				} else if (content.charAt(position) == '}') {
					--braceCount;
				}
				++position;
			}
			final String token = content.substring(tokenStart, position);
			position = skipDelimiters(position);
			return token;
		}
	}

	/**
	 * @see St
	 * @param context
	 * @param member
	 * @param comment
	 */
	public void parseType(IElement member, JSDocTags tags, String[] tagNames,
			JSProblemReporter reporter, ITypeChecker typeChecker) {
		final JSDocTag tag = tags.get(tagNames);
		if (tag != null) {
			if (reporter != null) {
				final int count = tags.count(tagNames);
				if (count > 1) {
					for (JSDocTag t : tags.list(tagNames).subList(1, count)) {
						if (t.name().equals(tag.name())) {
							reportProblem(reporter, JSDocProblem.DUPLICATE_TAG,
									t, t.name());
						} else {
							reportProblem(
									reporter,
									JSDocProblem.DUPLICATE_TAG,
									JSDocProblem.DUPLICATE_TAG.formatMessage(t
											.name())
											+ " (was "
											+ tag.name()
											+ ")", t);
						}
					}
				}
			}
			final JSType type = parseType(tag, requireBraces(tag.name()),
					reporter);
			if (type != null) {
				if (typeChecker != null)
					typeChecker.checkType(type, tag);
				member.setType(type);
			}
		}
	}

	public JSType parseType(JSDocTag tag, boolean requireBraces,
			JSProblemReporter reporter) {
		final TagTokenizer st = new TagTokenizer(tag);
		if (st.hasMoreTokens()) {
			final String typeName = st.nextToken();
			if (!requireBraces || isBraced(typeName)) {
				return translateTypeName(cutBraces(typeName), tag, reporter);
			}
		} else if (!requireBraces) {
			reportProblem(reporter, JSDocProblem.WRONG_TYPE_SYNTAX,
					"Missing type name", tag);
		}
		return null;
	}

	protected boolean requireBraces(String tagName) {
		return JSDocTag.RETURN.equals(tagName)
				|| JSDocTag.RETURNS.equals(tagName);
	}

	private void reportProblem(JSProblemReporter reporter,
			JSProblemIdentifier problemIdentifier, JSDocTag tag, Object... args) {
		if (reporter != null) {
			reporter.reportProblem(problemIdentifier,
					problemIdentifier.formatMessage(args), tag.start(),
					tag.end());
		}
	}

	private void reportProblem(JSProblemReporter reporter,
			JSProblemIdentifier problemIdentifier, String message, JSDocTag tag) {
		if (reporter != null) {
			reporter.reportProblem(problemIdentifier, message, tag.start(),
					tag.end());
		}
	}

	protected JSType translateTypeName(String typeName, JSDocTag tag,
			JSProblemReporter reporter) {
		JSDocTypeParser parser = createTypeParser();
		try {
			return parser.parse(typeName);
		} catch (JSDocParseException e) {
			if (reporter != null) {
				reporter.reportProblem(e.problemId, e.getMessage(),
						tag.start(), tag.end());
			}
			return null;
		} catch (ParseException e) {
			if (reporter != null) {
				String message = e.getMessage();
				if (e.getErrorOffset() >= 0) {
					message += " after "
							+ typeName.substring(0, e.getErrorOffset());
				}
				reporter.reportProblem(JSDocProblem.WRONG_TYPE_SYNTAX, message,
						tag.start(), tag.end());
			}
			return null;
		}
	}

	public JSDocTypeParser createTypeParser() {
		return new JSDocTypeParser();
	}

	public static String cutBraces(String typeName) {
		if (isBraced(typeName)) {
			typeName = typeName.substring(1, typeName.length() - 1);
		}
		return typeName;
	}

	public static boolean isBraced(String typeName) {
		final int length = typeName.length();
		return length > 2 && typeName.charAt(0) == '{'
				&& typeName.charAt(length - 1) == '}';
	}

	private static class CountingReporter implements ProblemReporter {
		@Nullable
		final JSProblemReporter reporter;
		int problemCount;

		public CountingReporter(@Nullable JSProblemReporter reporter) {
			this.reporter = reporter;
		}

		public void reportProblem(IProblemIdentifier identifier,
				String message, int start, int end) {
			++problemCount;
			if (reporter != null) {
				reporter.reportProblem(identifier, message, start, end);
			}
		}
	}

	private void processSuppressWarnings(JSDocTag tag,
			@NonNull CountingReporter reporter, IElement element) {
		final CharStream input = CharStreams.fromString(tag.value());
		final boolean hasParenthesis = input.LT(1) == '(';
		if (hasParenthesis) {
			input.consume();
		}
		for (;;) {
			int ch = input.LT(1);
			while (Character.isWhitespace(ch)) {
				input.consume();
				ch = input.LT(1);
			}
			if (ch == '"' || ch == '\'') {
				final char quote = (char) ch;
				input.consume();
				final int start = input.index();
				for (;;) {
					ch = input.LT(1);
					if (ch == quote) {
						suppressWarning(tag, reporter, element, input, start);
						input.consume();
						break;
					} else if (ch == CharStream.EOF) {
						reporter.reportProblem(
								JSDocProblem.WRONG_SUPPRESS_WARNING, "Closing "
										+ quote + " expected", tag.start(),
								tag.end());
						break;
					}
					input.consume();
				}
			} else {
				final int start = input.index();
				for (;;) {
					ch = input.LT(1);
					if (ch == ',' || ch == ')' || ch == CharStream.EOF
							|| Character.isWhitespace(ch)) {
						suppressWarning(tag, reporter, element, input, start);
						break;
					}
					input.consume();
				}
			}
			ch = input.LT(1);
			while (ch != CharStream.EOF && Character.isWhitespace(ch)) {
				input.consume();
				ch = input.LT(1);
			}
			if (ch != ',') {
				break;
			}
			input.consume();
		}
		if (hasParenthesis) {
			if (input.LT(1) == ')') {
				input.consume();
			} else {
				reporter.reportProblem(JSDocProblem.WRONG_SUPPRESS_WARNING,
						"Closing ) expected", tag.start(), tag.end());
			}
		}
		if (reporter.problemCount != 0 && input.LT(1) != CharStream.EOF) {
			reporter.reportProblem(JSDocProblem.WRONG_SUPPRESS_WARNING,
					"Unexpected content", tag.start(), tag.end());
		}
	}

	private void suppressWarning(JSDocTag tag,
			@NonNull CountingReporter reporter, IElement element,
			final CharStream input, final int start) {
		final String categoryId = input.substring(start, input.index() - 1);
		if (categoryId.length() != 0) {
			final IProblemCategory category = getCategory(categoryId);
			if (category != null) {
				element.addSuppressedWarning(category);
			} else {
				reporter.reportProblem(JSDocProblem.WRONG_SUPPRESS_WARNING, NLS
						.bind("Unsupported {0}({1})",
								JSDocTag.SUPPRESS_WARNINGS, categoryId), tag
						.start(), tag.end());
			}
		} else {
			reporter.reportProblem(JSDocProblem.WRONG_SUPPRESS_WARNING,
					"warning identifier expected", tag.start(), tag.end());
		}
	}

	protected IProblemCategory getCategory(final String categoryId) {
		return ProblemCategoryManager.getInstance().getCategory(
				JavaScriptNature.NATURE_ID, JSDocTag.SUPPRESS_WARNINGS,
				categoryId);
	}

	/**
	 * Value type for the results of the high-level JSDoc tag parsing.
	 * 
	 * @see JSDocSupport#parseParameter(JSDocTag)
	 * @see JSDocSupport#parseOptionalType(JSDocTag)
	 * @see JSDocSupport#parseType(JSDocTag)
	 */
	public static class TypedElementNode {
		/**
		 * Type expression, potentially with surrounding braces or
		 * <code>null</code>
		 */
		@Nullable
		private final String type;
		/**
		 * Offset of the type token or <code>-1</code> if no type
		 */
		private final int typeOffset;

		/**
		 * Answers if type expression is surrounded with braces.
		 */
		boolean isBraced() {
			return true;
		}

		TypedElementNode(String type, int typeOffset) {
			this.type = type;
			this.typeOffset = typeOffset;
		}

		/**
		 * Returns type expression without surrounding braces or
		 * <code>null</code>
		 */
		@Nullable
		public String getTypeExpression() {
			if (type != null) {
				return isBraced() ? type.substring(1, type.length() - 1) : type;
			} else {
				return null;
			}
		}

		/**
		 * Returns the starting offset of the actual type expression (i.e.
		 * without surrounding braces) or <code>-1</code> if no type expression.
		 */
		public int getTypeExpressionStart() {
			return typeOffset >= 0 ? typeOffset + (isBraced() ? 1 : 0) : -1;
		}

		/**
		 * Checks if specified position is contained in the type declaration.
		 */
		public boolean isInType(int position) {
			return type != null
					&& (isBraced() ? typeOffset < position
							&& position < typeOffset + type.length()
							: typeOffset <= position
									&& position <= typeOffset + type.length());
		}
	}

	public static class ParameterNode extends TypedElementNode {
		@NonNull
		public final String name;
		public final int offset;

		ParameterNode(String type, int typeOffset, String name, int offset) {
			super(type, typeOffset);
			this.name = name;
			this.offset = offset;
		}

		public boolean isInParameter(int position) {
			return offset <= position && offset + name.length() >= position;
		}
	}

	public static class TypeNode extends TypedElementNode {
		private final boolean braced;

		@Override
		boolean isBraced() {
			return braced;
		}

		TypeNode(String type, int typeOffset, boolean braced) {
			super(type, typeOffset);
			this.braced = braced;
		}
	}

	/**
	 * High level parsing of JSDoc &#64;param tag
	 */
	public static ParameterNode parseParameter(JSDocTag tag) {
		final TagTokenizer tokenizer = new TagTokenizer(tag);
		if (!tokenizer.hasMoreTokens()) {
			return null;
		}
		int typeOffset = -1;
		String type = null;
		String token = tokenizer.nextToken();
		if (JSDocSupport.isBraced(token)) { // skip type name
			if (!tokenizer.hasMoreTokens()) {
				return null;
			}
			typeOffset = tokenizer.getTokenStart();
			type = token;
			token = tokenizer.nextToken();
		}
		int tokenStart = tokenizer.getTokenStart();
		// optional parameter
		if (token.startsWith("[") && token.endsWith("]")) {
			token = token.substring(1, token.length() - 1);
			++tokenStart;
			// default value separator
			int separator = token.indexOf('=');
			if (separator != -1) {
				token = token.substring(0, separator);
			}
		}
		int propertyIndex = token.indexOf('.');
		if (propertyIndex != -1) {
			token = token.substring(0, propertyIndex);
		}
		return new ParameterNode(type, typeOffset, token, tokenStart);
	}

	/**
	 * Parses optional type expression (like the one in &#64;return/&#64;returns
	 * tags) from the specified tag value.
	 */
	public static TypedElementNode parseOptionalType(JSDocTag tag) {
		final TagTokenizer tokenizer = new TagTokenizer(tag);
		if (tokenizer.peekChar() == '{' && tokenizer.hasMoreTokens()) {
			final String type = tokenizer.nextToken();
			return new TypedElementNode(type, tokenizer.getTokenStart());
		} else {
			return null;
		}
	}

	/**
	 * Parses the type expression of &#64;type tag.
	 */
	public static TypeNode parseType(JSDocTag tag) {
		final TagTokenizer tokenizer = new TagTokenizer(tag);
		if (tokenizer.hasMoreTokens()) {
			final String type = tokenizer.nextToken();
			return new TypeNode(type, tokenizer.getTokenStart(), isBraced(type));
		} else {
			return null;
		}
	}

}
