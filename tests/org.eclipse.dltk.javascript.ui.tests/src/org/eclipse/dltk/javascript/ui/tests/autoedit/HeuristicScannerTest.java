/*******************************************************************************
 * Copyright (c) 2012 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.ui.tests.autoedit;

import org.eclipse.dltk.core.tests.util.StringList;
import org.eclipse.dltk.javascript.internal.ui.text.Symbols;
import org.eclipse.dltk.javascript.ui.scriptdoc.JavaHeuristicScanner;
import org.eclipse.jface.text.BadLocationException;
import org.junit.Test;

public class HeuristicScannerTest extends JSAutoEditStrategyTestCase {

	@Test
	public void testNewLineAfterIdentifier() throws BadLocationException {
		final Document document = createDocument(new StringList("a", ""));
		final JavaHeuristicScanner scanner = new JavaHeuristicScanner(document);
		assertEquals(Symbols.TokenIDENT, scanner.previousToken(
				document.getEndOfLineOffset(1), JavaHeuristicScanner.UNBOUND));
	}

	@Test
	public void testNewLineAfterReturn() throws BadLocationException {
		final Document document = createDocument(new StringList("return", ""));
		final JavaHeuristicScanner scanner = new JavaHeuristicScanner(document);
		assertEquals(Symbols.TokenSEMICOLON, scanner.previousToken(
				document.getEndOfLineOffset(1), JavaHeuristicScanner.UNBOUND));
	}

}
