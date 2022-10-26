/*******************************************************************************
 * Copyright (c) 2011 xored software, Inc.
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

import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.IProblemIdentifierFactory;

public class JavaScriptParserProblemFactory implements
		IProblemIdentifierFactory {

	public IProblemIdentifier valueOf(String localName)
			throws IllegalArgumentException {
		return JavaScriptParserProblems.valueOf(localName);
	}

	public IProblemIdentifier[] values() {
		return JavaScriptParserProblems.values();
	}

}
