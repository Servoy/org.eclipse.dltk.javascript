package org.eclipse.dltk.javascript.ui;

import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;

public interface IJsExtendsForm {

	static final String EXTENSION_ID = JavaScriptUI.PLUGIN_ID
			+ ".jsExtendsForm";

	String getExtendsForm(String formName);
}
