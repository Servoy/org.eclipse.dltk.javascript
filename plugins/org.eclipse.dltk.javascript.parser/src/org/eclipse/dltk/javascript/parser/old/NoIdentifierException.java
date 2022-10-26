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
package org.eclipse.dltk.javascript.parser.old;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;

@SuppressWarnings("serial")
public class NoIdentifierException extends NoViableAltException {

	/**
	 * @since 6.0
	 */
	public NoIdentifierException(Parser recognizer) {
		super(recognizer);
	}
}
