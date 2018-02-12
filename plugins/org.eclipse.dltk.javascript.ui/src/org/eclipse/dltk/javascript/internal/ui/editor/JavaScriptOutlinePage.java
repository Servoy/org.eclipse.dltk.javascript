/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.javascript.internal.ui.editor;

import java.util.ArrayList;

import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.internal.javascript.parser.JSModifiers;
import org.eclipse.dltk.internal.ui.editor.ScriptEditor;
import org.eclipse.dltk.internal.ui.editor.ScriptOutlinePage;
import org.eclipse.dltk.ui.DLTKPluginImages;
import org.eclipse.dltk.ui.actions.MemberFilterActionGroup;
import org.eclipse.dltk.ui.viewsupport.MemberFilterAction;
import org.eclipse.dltk.ui.viewsupport.ModelElementFilter;
import org.eclipse.dltk.ui.viewsupport.ModelElementFlagsFilter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.handlers.CollapseAllHandler;

public class JavaScriptOutlinePage extends ScriptOutlinePage {

	class CollapseAllAction extends Action {

		private final ScriptOutlineViewer tree;

		/**
		 * Create the CollapseAll action.
		 *
		 * @param aViewer
		 *            The viewer to be collapsed.
		 */
		public CollapseAllAction(ScriptOutlineViewer view) {
			super(ActionMessages.CollapsAllAction_label);
			setToolTipText(ActionMessages.CollapsAllAction_tooltip);
			setActionDefinitionId(CollapseAllHandler.COMMAND_ID);
			tree = view;
		}

		@Override
		public void run() {
			if (tree != null) {
				tree.collapseAll();
			}
		}
	}

	public JavaScriptOutlinePage(ScriptEditor editor, IPreferenceStore store) {
		super(editor, store);		
	}
	
	protected void registerSpecialToolbarActions(IActionBars actionBars) {
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		CollapseAllAction collapseAllAction = new CollapseAllAction(
				fOutlineViewer);
		DLTKPluginImages.setLocalImageDescriptors(collapseAllAction,
				"collapseall.gif");

		toolBarManager.insertBefore(toolBarManager.getItems()[0].getId(),
				collapseAllAction);

		MemberFilterActionGroup fMemberFilterActionGroup= new MemberFilterActionGroup(fOutlineViewer, fStore); //$NON-NLS-1$

		String title, helpContext;
		ArrayList<MemberFilterAction> actions = new ArrayList<MemberFilterAction>(
				4);

		// fill-in actions

		// variables
		
		title = ActionMessages.MemberFilterActionGroup_hide_variables_label;
		// TODO help support
		helpContext = "";// IDLTKHelpContextIds.FILTER_FIELDS_ACTION;
		MemberFilterAction hideVariables = new MemberFilterAction(fMemberFilterActionGroup, title,
				new ModelElementFilter(IModelElement.FIELD), helpContext, true); // also
																					// filter
																					// IModelElement.LOCAL_VARIABLE?
		hideVariables
				.setDescription(ActionMessages.MemberFilterActionGroup_hide_variables_description);
		hideVariables
				.setToolTipText(ActionMessages.MemberFilterActionGroup_hide_variables_tooltip);
		DLTKPluginImages.setLocalImageDescriptors(hideVariables,
				"filter_fields.gif"); //$NON-NLS-1$
		actions.add(hideVariables);

		// procedures		

		title = ActionMessages.MemberFilterActionGroup_hide_functions_label;
		// TODO help support
		helpContext = "";// IDLTKHelpContextIds.FILTER_STATIC_ACTION;
		MemberFilterAction hideProcedures = new MemberFilterAction(fMemberFilterActionGroup, title,
				new ModelElementFilter(IModelElement.METHOD), helpContext, true);
		hideProcedures
				.setDescription(ActionMessages.MemberFilterActionGroup_hide_functions_description);
		hideProcedures
				.setToolTipText(ActionMessages.MemberFilterActionGroup_hide_functions_tooltip);
		// TODO: add correct icon
		DLTKPluginImages.setLocalImageDescriptors(hideProcedures,
				"filter_methods.gif"); //$NON-NLS-1$
		actions.add(hideProcedures);

		// namespaces

		title = ActionMessages.MemberFilterActionGroup_hide_classes_label;
		// TODO help support
		helpContext = "";// IDLTKHelpContextIds.FILTER_PUBLIC_ACTION;
		MemberFilterAction hideNamespaces = new MemberFilterAction(fMemberFilterActionGroup, title,
				new ModelElementFilter(IModelElement.TYPE), helpContext, true); // When
																				// does
																				// IModelElement.TYPE
																				// happen
																				// in
																				// JS?
		hideNamespaces
				.setDescription(ActionMessages.MemberFilterActionGroup_hide_classes_description);
		hideNamespaces
				.setToolTipText(ActionMessages.MemberFilterActionGroup_hide_classes_tooltip);
		DLTKPluginImages.setLocalImageDescriptors(hideNamespaces,
				"filter_classes.gif"); //$NON-NLS-1$
		actions.add(hideNamespaces);

		// Visibility
		title = ActionMessages.MemberFilterActionGroup_hide_non_public_label;
		// TODO help support
		helpContext = "";// IDLTKHelpContextIds.FILTER_FIELDS_ACTION;
		MemberFilterAction hideNonPublic = new MemberFilterAction(
				fMemberFilterActionGroup, title,
				new ModelElementFlagsFilter(
						JSModifiers.PROTECTED | JSModifiers.PRIVATE), // Should
																		// be
																		// inverted
				helpContext, true);
		hideNonPublic.setDescription(
				ActionMessages.MemberFilterActionGroup_hide_non_public_description);
		hideNonPublic.setToolTipText(
				ActionMessages.MemberFilterActionGroup_hide_non_public_tooltip);
		DLTKPluginImages.setLocalImageDescriptors(hideNonPublic,
				"public_co.gif"); //$NON-NLS-1$
		actions.add(hideNonPublic);

		// order corresponds to order in toolbar
		MemberFilterAction[] fFilterActions = actions
				.toArray(new MemberFilterAction[actions.size()]);
		
		fMemberFilterActionGroup.setActions(fFilterActions);
		
		fMemberFilterActionGroup.contributeToToolBar(toolBarManager);
		
	}
}
