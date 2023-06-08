package org.eclipse.dltk.javascript.formatter.internal.nodes;

import org.eclipse.dltk.formatter.IFormatterDocument;

public class FormatterForOfStatementNode extends FormatterBlockWithBeginNode {

	public FormatterForOfStatementNode(IFormatterDocument document) {
		super(document);
	}

	@Override
	protected boolean isIndenting() {
		return false;
	}
}
