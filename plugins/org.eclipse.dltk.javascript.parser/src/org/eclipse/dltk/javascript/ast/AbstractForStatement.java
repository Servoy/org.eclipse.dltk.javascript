package org.eclipse.dltk.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractForStatement extends LoopStatement implements JSScope
{
	private List<JSDeclaration> declarations;
	
	public AbstractForStatement(JSNode parent) {
		super(parent);
	}

	@Override
	public void addDeclaration(JSDeclaration declaration) {
		if (declarations == null) {
			declarations = new ArrayList<JSDeclaration>();
		}
		declarations.add(declaration);
	}

	public List<JSDeclaration> getDeclarations() {
		return declarations != null ? declarations : Collections
				.<JSDeclaration> emptyList();
	}

}
