package org.eclipse.dltk.javascript.internal.ui.text;

import java.io.StringReader;
import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.javascript.ast.Expression;
import org.eclipse.dltk.javascript.ast.ForEachInStatement;
import org.eclipse.dltk.javascript.ast.GetMethod;
import org.eclipse.dltk.javascript.ast.Identifier;
import org.eclipse.dltk.javascript.ast.Keyword;
import org.eclipse.dltk.javascript.ast.Method;
import org.eclipse.dltk.javascript.ast.PropertyInitializer;
import org.eclipse.dltk.javascript.ast.RegExpLiteral;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.ast.SetMethod;
import org.eclipse.dltk.javascript.ast.StringLiteral;
import org.eclipse.dltk.javascript.ast.XmlFragment;
import org.eclipse.dltk.javascript.ast.XmlLiteral;
import org.eclipse.dltk.javascript.ast.XmlTextFragment;
import org.eclipse.dltk.javascript.ast.v4.PropertyShorthand;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.javascript.parser.JavaScriptParserUtil;
import org.eclipse.dltk.ui.editor.highlighting.AbortSemanticHighlightingException;
import org.eclipse.dltk.ui.editor.highlighting.ISemanticHighlighter;
import org.eclipse.dltk.ui.editor.highlighting.ISemanticHighlightingRequestor;

public class JavaScriptXmlHighlighter extends AbstractJavaScriptHighlighter
		implements ISemanticHighlighter {

	private static final String HL_XML_TAG = JavascriptColorConstants.JS_XML_TAG_NAME;
	private static final String HL_XML_ATTRIBUTE = JavascriptColorConstants.JS_XML_ATTR_NAME;
	private static final String HL_XML_COMMENT = JavascriptColorConstants.JS_XML_COMMENT_NAME;
	private static final String HL_KEYWORD = JavascriptColorConstants.JS_KEYWORD;
	private static final String HL_REGEXP = JavascriptColorConstants.JS_REGEXP;
	private static final String HL_PROPERTY = JavascriptColorConstants.JS_PROPERTY;

	public String[] getHighlightingKeys() {
		return new String[] { HL_XML_TAG, HL_XML_ATTRIBUTE, HL_XML_COMMENT,
				HL_KEYWORD, HL_REGEXP, HL_PROPERTY };
	}

	public void process(IModuleSource code,
			ISemanticHighlightingRequestor requestor) {
		final Script declaration = JavaScriptParserUtil.parse(code, null);
		if (declaration == null) {
			throw new AbortSemanticHighlightingException();
		}
		try {
			declaration.traverse(new HighlightingVisitor(requestor));
		} catch (Exception e) {
			JavaScriptUI.log(e);
		}

	}

	static class HighlightingVisitor extends ASTVisitor {
		final ISemanticHighlightingRequestor requestor;
		final boolean bPropertyNames = isSemanticHighlightingEnabled(HL_PROPERTY);

		public HighlightingVisitor(ISemanticHighlightingRequestor requestor) {
			this.requestor = requestor;
		}

		@Override
		public boolean visitGeneral(ASTNode node) throws Exception {
			if (node instanceof XmlLiteral) {
				handleXML((XmlLiteral) node);
			} else if (node instanceof Method) {
				handleMethod((Method) node);
			} else if (node instanceof RegExpLiteral) {
				handleRegExp((RegExpLiteral) node);
			} else if (node instanceof PropertyInitializer) {
				if (bPropertyNames) {
					handlePropertyInitializer((PropertyInitializer) node);
				}
			} else if (node instanceof PropertyShorthand) {
				if (bPropertyNames) {
					handlePropertyShorthand((PropertyShorthand) node);
				}
			} else if (node instanceof ForEachInStatement) {
				handleForEachIn((ForEachInStatement) node);
			}
			return true;
		}

		private void handleXML(XmlLiteral literal) {
			for (XmlFragment fragment : literal.getFragments()) {
				if (fragment instanceof XmlTextFragment) {
					final XMLTokenizer tokenizer = new XMLTokenizer(
							new StringReader(
									((XmlTextFragment) fragment).getXml()));
					final int offset = fragment.sourceStart();
					@SuppressWarnings("unchecked")
					final List<Token> tokens = tokenizer.getRegions();
					for (Token token : tokens) {
						if (token.context == XMLTokenizer.XML_TAG_NAME) {
							addRange(requestor, offset, token, HL_XML_TAG);
						} else if (token.context == XMLTokenizer.XML_TAG_ATTRIBUTE_NAME) {
							addRange(requestor, offset, token, HL_XML_ATTRIBUTE);
						} else if (token.context == XMLTokenizer.XML_COMMENT_OPEN
								|| token.context == XMLTokenizer.XML_COMMENT_TEXT
								|| token.context == XMLTokenizer.XML_COMMENT_CLOSE) {
							addRange(requestor, offset, token, HL_XML_COMMENT);
						} else if (token.context == XMLTokenizer.XML_TAG_ATTRIBUTE_VALUE) {
							//
						}
					}
				}
			}
		}

		private void handleMethod(Method method) {
			Keyword keyword;
			if (method instanceof GetMethod) {
				keyword = ((GetMethod) method).getGetKeyword();
			} else if (method instanceof SetMethod) {
				keyword = ((SetMethod) method).getSetKeyword();
			} else {
				return;
			}
			requestor.addPosition(keyword.sourceStart(), keyword.sourceEnd(),
					HL_KEYWORD);
		}

		private void handleForEachIn(ForEachInStatement forEach) {
			final Keyword keyword = forEach.getEachKeyword();
			requestor.addPosition(keyword.sourceStart(), keyword.sourceEnd(),
					HL_KEYWORD);
		}

		private void handleRegExp(RegExpLiteral regExp) {
			requestor.addPosition(regExp.sourceStart(), regExp.sourceEnd(),
					HL_REGEXP);
		}

		private void handlePropertyInitializer(PropertyInitializer property) {
			final Expression name = property.getName();
			if (name instanceof Identifier || name instanceof StringLiteral) {
				requestor.addPosition(name.sourceStart(), name.sourceEnd(),
						HL_PROPERTY);
			}
		}

		private void handlePropertyShorthand(PropertyShorthand property) {
			final Expression name = property.getExpression();
			if (name instanceof Identifier || name instanceof StringLiteral) {
				requestor.addPosition(name.sourceStart(), name.sourceEnd(),
						HL_PROPERTY);
			}
		}

		private static void addRange(ISemanticHighlightingRequestor requestor,
				int start, Token token, String highlightingKey) {
			requestor.addPosition(start + token.start, start + token.start
					+ token.textLength, highlightingKey);
		}
	}

}
