package org.eclipse.dltk.javascript.internal.ui.quickfix;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.dltk.compiler.problem.DefaultProblemIdentifier;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.ProblemCategoryManager;
import org.eclipse.dltk.javascript.core.JavaScriptNature;
import org.eclipse.dltk.javascript.core.JavaScriptProblems;
import org.eclipse.dltk.javascript.parser.jsdoc.JSDocTag;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

public class JSProblemMarkerResolutionGenerator implements
		IMarkerResolutionGenerator {
	private static IMarkerResolution[] NONE = new IMarkerResolution[0];

	public IMarkerResolution[] getResolutions(IMarker marker) {
		IProblemIdentifier problemId = DefaultProblemIdentifier
				.getProblemId(marker);
		if (problemId == JavaScriptProblems.UNDECLARED_VARIABLE) {
			CreateTopLevelVariable createTopLevelVariable = new CreateTopLevelVariable(
					(IFile) marker.getResource(), marker.getAttribute(
							IMarker.CHAR_START, -1));
			if (createTopLevelVariable.isValid()) {
				return new IMarkerResolution[] {
						new CreateLocalVariableQuickFix(
								(IFile) marker.getResource(),
								marker.getAttribute(IMarker.CHAR_START, -1)),
						createTopLevelVariable };
			} else {
				return new IMarkerResolution[] { new CreateLocalVariableQuickFix(
						(IFile) marker.getResource(), marker.getAttribute(
								IMarker.CHAR_START, -1)) };
			}
		} else {
			String[] ids = ProblemCategoryManager.getInstance().getID(
					JavaScriptNature.NATURE_ID, JSDocTag.SUPPRESS_WARNINGS,
					problemId);
			if (ids.length > 0) {
				ArrayList<IMarkerResolution> resolutions = new ArrayList<IMarkerResolution>();
				for (int i = 0; i < ids.length; i++) {
					IFile file = (IFile) marker.getResource();
					int charStart = marker.getAttribute(IMarker.CHAR_START, -1);

					GenerateSuppressWarningsResolution resolution = new GenerateSuppressWarningsResolution(
							file, charStart, ids[i]);
					if (resolution.isValid()) {
						resolutions.add(resolution);
					}

					GenerateSuppressWarningsLineResolution lineResolution = new GenerateSuppressWarningsLineResolution(
							file, charStart, ids[i]);
					if (lineResolution.isValid()) {
						resolutions.add(lineResolution);
					}
				}
				return resolutions.toArray(new IMarkerResolution[resolutions
						.size()]);
			}
		}
		return NONE;
	}
}
