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
package org.eclipse.dltk.javascript.parser.old;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class JavaScriptParserPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.dltk.javascript.parser";

	// The shared instance.
	private static JavaScriptParserPlugin plugin;

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static JavaScriptParserPlugin getDefault() {
		return plugin;
	}

	/**
	 * @since 5.0
	 */
	public static void error(String message) {
		error(message, null);
	}

	/**
	 * @since 5.0
	 */
	public static void error(Throwable e) {
		error(e.getLocalizedMessage(), e);
	}

	/**
	 * @since 5.0
	 */
	public static void error(String message, Throwable t) {
		final Plugin p = plugin;
		if (p != null) {
			p.getLog()
					.log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK,
							message, t));
		} else {
			System.err.println(message);
			if (t != null) {
				t.printStackTrace();
			}
		}
	}

}
