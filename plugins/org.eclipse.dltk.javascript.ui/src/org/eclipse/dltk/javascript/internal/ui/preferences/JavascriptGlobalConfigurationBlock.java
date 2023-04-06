/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.javascript.internal.ui.preferences;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.dltk.core.SourceParserUtil;
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
	private boolean changed = false;

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

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		
		useES6ParserButton = new Button(composite, SWT.CHECK);
		useES6ParserButton
				.setSelection(preferences.useES6Parser());
		useES6ParserButton.setText(
				"Enable the EcmaScript parser");
		useES6ParserButton.setToolTipText(
				"Allows support of ES6 features like arrow functions and template strings.\nIf you change this preference, a clean build is triggered.");
		useES6ParserButton.addListener(SWT.Selection, event -> {
			preferences.useES6Parser(
					useES6ParserButton.getSelection());
			changed = !changed;
		});
		return composite;		
	}

	@Override
	public void performOk() {
		if (!changed)
			return;
		preferences.save();
		changed = false;
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		Job cleanJob = new Job("Clean workspace build") {
			public IStatus run(IProgressMonitor monitor) {
				try {
					SourceParserUtil.clearCache();
					workspace.build(IncrementalProjectBuilder.CLEAN_BUILD,
							monitor);
					return Status.OK_STATUS;
				} catch (CoreException ex) {
					return ex.getStatus();
				}
			}
		};
		cleanJob.setRule(workspace.getRoot());
		cleanJob.schedule();
		super.performOk();
	}
}
