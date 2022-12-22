/*******************************************************************************
 * Copyright (c) 2011 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.parser.v4;

import org.eclipse.dltk.compiler.problem.IProblemCategory;

/**
 * Represents the current state of suppress warnings directives in the
 * {@link JSProblemReporter}.
 * 
 * It doesn't expose any methods and implementation is completely internal.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 4.0
 */
public interface ISuppressWarningsState {

	/**
	 * Creates snapshot of the current state.
	 */
	IProblemCategory asCategory();

}
