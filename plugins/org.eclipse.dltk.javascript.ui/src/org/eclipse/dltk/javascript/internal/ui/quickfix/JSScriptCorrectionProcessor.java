package org.eclipse.dltk.javascript.internal.ui.quickfix;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.dltk.compiler.problem.ProblemCategoryManager;
import org.eclipse.dltk.javascript.core.JavaScriptNature;
import org.eclipse.dltk.javascript.core.JavaScriptProblems;
import org.eclipse.dltk.javascript.parser.jsdoc.JSDocTag;
import org.eclipse.dltk.ui.editor.IScriptAnnotation;
import org.eclipse.dltk.ui.text.IScriptCorrectionContext;
import org.eclipse.dltk.ui.text.IScriptCorrectionProcessor;

public class JSScriptCorrectionProcessor implements IScriptCorrectionProcessor {

	public JSScriptCorrectionProcessor() {
	}

	public boolean canFix(IScriptAnnotation annotation) {
		if (annotation.getId() == JavaScriptProblems.UNDECLARED_VARIABLE) {
			return true;
		} else {
			return ProblemCategoryManager.getInstance().getID(
					JavaScriptNature.NATURE_ID, JSDocTag.SUPPRESS_WARNINGS,
					annotation.getId()) != null;
		}
	}

	public boolean canFix(IMarker marker) {
		return false;
	}

	public void computeQuickAssistProposals(IScriptAnnotation annotation,
			IScriptCorrectionContext context) {
		if (annotation.getId() == JavaScriptProblems.UNDECLARED_VARIABLE) {
			context.addResolution(new CreateLocalVariableQuickFix(
					(IFile) annotation.getSourceModule().getResource(), context
							.getInvocationContext().getOffset()), annotation);
			CreateTopLevelVariable resolution = new CreateTopLevelVariable(
					(IFile) annotation.getSourceModule().getResource(), context
							.getInvocationContext().getOffset());
			if (resolution.isValid()) {
				context.addResolution(resolution, annotation);
			}

		} else {
			String[] id = ProblemCategoryManager.getInstance().getID(
					JavaScriptNature.NATURE_ID, JSDocTag.SUPPRESS_WARNINGS,
					annotation.getId());
			for (int i = 0; i < id.length; i++) {
				IFile file = (IFile) annotation.getSourceModule().getResource();
				int offset = context.getInvocationContext().getOffset();

				GenerateSuppressWarningsResolution resolution = new GenerateSuppressWarningsResolution(
						file, offset, id[i]);
				if (resolution.isValid()) {
					context.addResolution(resolution, annotation);
				}

				GenerateSuppressWarningsLineResolution lineResolution = new GenerateSuppressWarningsLineResolution(
						file, offset, id[i]);
				if (lineResolution.isValid()) {
					context.addResolution(lineResolution, annotation);
				}
			}
		}
	}

	public void computeQuickAssistProposals(IMarker marker,
			IScriptCorrectionContext context) {
	}

}
