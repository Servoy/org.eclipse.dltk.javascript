package org.eclipse.dltk.javascript.ui;

import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;

public interface IJsExtendsScope {

	static final String EXTENSION_ID = JavaScriptUI.PLUGIN_ID
			+ ".extendsScope";

	String getExtendsScope(String scopeName);
}
