/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.javascript.internal.ui.preferences;

import org.eclipse.dltk.javascript.parser.JavascriptParserPreferences;
import org.eclipse.dltk.ui.preferences.AbstractConfigurationBlock;
import org.eclipse.dltk.ui.preferences.OverlayPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class JavascriptGlobalConfigurationBlock extends AbstractConfigurationBlock  {
	private Button useES6ParserButton;
	private JavascriptParserPreferences preferences;

	public JavascriptGlobalConfigurationBlock(OverlayPreferenceStore store, PreferencePage mainPreferencePage) {
		super(store, mainPreferencePage);
		preferences = new JavascriptParserPreferences();
	}
	
	protected void initializeFields() {
		useES6ParserButton
				.setSelection(preferences.useES6Parser());
	}

	public Control createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite composite= new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		
		useES6ParserButton = new Button(composite, SWT.CHECK);
		useES6ParserButton
				.setSelection(preferences.useES6Parser());
		useES6ParserButton.setText(
				"Enable the EcmaScript parser");
		useES6ParserButton.setToolTipText(
				"Allows support of ES6 features like arrow functions and template strings");
		useES6ParserButton.addListener(SWT.Selection, event -> {
			preferences.useES6Parser(
					useES6ParserButton.getSelection());
		});
		return composite;		
	}

	@Override
	public void performOk() {
		preferences.save();
		super.performOk();
	}
}
