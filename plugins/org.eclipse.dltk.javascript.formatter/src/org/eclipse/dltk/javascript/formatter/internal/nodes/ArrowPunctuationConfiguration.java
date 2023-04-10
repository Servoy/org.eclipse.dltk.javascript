package org.eclipse.dltk.javascript.formatter.internal.nodes;

public class ArrowPunctuationConfiguration
		extends AbstractPunctuationConfiguration {

	@Override
	public boolean insertSpaceAfter() {
		return true;
	}

	@Override
	public boolean insertSpaceBefore() {
		return true;
	}

}
