/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.javascript.internal.ui.text.completion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.javascript.internal.ui.text.Symbols;
import org.eclipse.dltk.javascript.typeinfo.IRFunctionType;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRParameter;
import org.eclipse.dltk.javascript.ui.scriptdoc.JavaHeuristicScanner;
import org.eclipse.dltk.ui.text.completion.ContentAssistInvocationContext;
import org.eclipse.dltk.ui.text.completion.IScriptCompletionProposalExtension2;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalComputer;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.dltk.ui.text.completion.ScriptMethodCompletionProposal;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;

public class JavaScriptTypeCompletionProposalComputer extends
		ScriptCompletionProposalComputer {

	@Override
	protected TemplateCompletionProcessor createTemplateProposalComputer(
			ScriptContentAssistInvocationContext context) {
		return null;
	}

	@Override
	protected int guessContextInformationPosition(
			ContentAssistInvocationContext context) {
		final int contextPosition = context.getInvocationOffset();
		IDocument document = context.getDocument();
		JavaHeuristicScanner scanner = new JavaHeuristicScanner(document);
		int bound = Math.max(-1, contextPosition - 200);
		// try the innermost scope of parentheses that looks like a method call
		int pos = contextPosition - 1;
		do {
			int paren = scanner.findOpeningPeer(pos, bound, '(', ')');
			if (paren == JavaHeuristicScanner.NOT_FOUND)
				break;
			int token = scanner.previousToken(paren - 1, bound);
			// next token must be a method name (identifier)
			if (token == Symbols.TokenIDENT)
				return paren;
			pos = paren - 1;
		} while (true);
		return contextPosition;
	}

	@Override
	public List<IContextInformation> computeContextInformation(
			ContentAssistInvocationContext context, IProgressMonitor monitor) {
		if (DLTKCore.DEBUG) {
			System.out.println("Offset: " + context.getInvocationOffset());
			System.out.println(getClass().getSimpleName()
					+ ".computeContextInformation()");
		}
		if (context instanceof ScriptContentAssistInvocationContext) {
			final int completionOffset = guessContextInformationPosition(context);
			final List<ICompletionProposal> proposals = computeScriptCompletionProposals(
					completionOffset,
					(ScriptContentAssistInvocationContext) context, monitor);
			if (DLTKCore.DEBUG) {
				System.out.println("!!! Proposals: " + proposals.size());
			}
			final List<IContextInformation> list = new ArrayList<IContextInformation>();
			for (ICompletionProposal proposal : proposals) {
				final IContextInformation contextInformation = proposal
						.getContextInformation();
				if (contextInformation == null) {
					continue;
				}
				if (proposal instanceof IScriptCompletionProposalExtension2) {
					final IScriptCompletionProposalExtension2 e2 = (IScriptCompletionProposalExtension2) proposal;
					if (e2.getReplacementLength() != e2.getName().length()) {
						continue;
					}
				}
				if (DLTKCore.DEBUG) {
					System.out.println("Proposal: " + proposal + ", info: "
							+ contextInformation.getInformationDisplayString());
				}
				list.add(contextInformation);
			}
			return list;
		}
		return Collections.emptyList();
	}

	@Override
	protected ScriptCompletionProposalCollector createCollector(
			ScriptContentAssistInvocationContext context) {
		return new JavaScriptCompletionProposalCollector(
				context.getSourceModule());
	}

	@Override
	public List<ICompletionProposal> computeCompletionProposals(
			ContentAssistInvocationContext context, IProgressMonitor monitor) {
		List<ICompletionProposal> proposals = super.computeCompletionProposals(
				context, monitor);
		int parenPos = findMethodCallOpenParen(context);
		if (parenPos == -1) {
			return proposals;
		}

		String method = getMethodName(context.getDocument(), parenPos);
		if (method == null) {
			return proposals;
		}

		// re-trigger method reference completion when inside ()
		method = method.trim();
		if (context instanceof ScriptContentAssistInvocationContext cx) {
			final int completionOffset = guessContextInformationPosition(cx);
			List<ICompletionProposal> reTriggeredProposals = super.computeScriptCompletionProposals(
					completionOffset,
					cx, monitor);

			// filter only those proposals that have a function parameter
			List<ICompletionProposal> filtered = reTriggeredProposals.stream()
					.filter(p -> p instanceof ScriptMethodCompletionProposal sp
							&& sp.getExtraInfo() instanceof IRMethod methodInfo
							&& hasFunctionParameter(methodInfo))
					.toList();

			// if no function parameter proposals, return the normal proposals
			return filtered.isEmpty() ? proposals : filtered;
		}
		return proposals;
	}

	private int findMethodCallOpenParen(
			ContentAssistInvocationContext context) {
		final int offset = context.getInvocationOffset();
		IDocument document = context.getDocument();
		JavaHeuristicScanner scanner = new JavaHeuristicScanner(document);
		try {
			// look for the nearest '(' before cursor
			int paren = scanner.findOpeningPeer(offset - 1, -1, '(', ')');
			if (paren == JavaHeuristicScanner.NOT_FOUND)
				return -1;

			// must be preceded by an identifier (method call)
			int token = scanner.previousToken(paren - 1, -1);
			if (token != Symbols.TokenIDENT)
				return -1;

			for (int i = paren + 1; i < offset; i++) {
				if (!Character.isWhitespace(document.getChar(i)))
					return -1;
			}
			int pos = offset;
			int length = document.getLength();
			while (pos < length
					&& Character.isWhitespace(document.getChar(pos)))
				pos++; // skip whitespace

			if (pos >= length || document.getChar(pos) != ')')
				return -1;

			return paren;

		} catch (Exception e) {
			return -1;
		}
	}

	private String getMethodName(IDocument doc, int parenPos) {
		try {
			JavaHeuristicScanner scanner = new JavaHeuristicScanner(doc);
			int token = scanner.previousToken(parenPos - 1, -1);
			if (token == Symbols.TokenIDENT) {
				int start = scanner.getPosition() + 1;
				int end = parenPos - 1;
				return doc.get(start, end - start + 1);
			}
		} catch (Exception e) {
			// shouldn't happen
			JavaScriptUI.log(e);
		}
		return null;
	}

	private boolean hasFunctionParameter(IRMethod methodInfo) {
		for (IRParameter p : methodInfo.getParameters()) {
			if (p.getType() instanceof IRFunctionType) {
				return true;
			}
		}
		return false;
	}
}