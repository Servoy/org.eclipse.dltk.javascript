package org.eclipse.dltk.javascript.internal.ui.quickfix;

import org.eclipse.core.resources.IFile;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.ui.DLTKPluginImages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MultiTextEdit;

/**
 * Quick fix that inserts a <code>// @SuppressWarnings(type)</code> comment on
 * the line immediately before the line that contains the warning.
 */
public class GenerateSuppressWarningsLineResolution extends TextFileEditResolution {

	private final String type;

	public GenerateSuppressWarningsLineResolution(IFile scriptFile,
			int problemStartIdx, String type) {
		super(scriptFile, problemStartIdx);
		this.type = type;
	}

	@Override
	public String getLabel() {
		return "Add SuppressWarnings(" + type + ") on the line before the warning"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public Image getImage() {
		return DLTKPluginImages.getImage(JavaScriptUI.getDefault(),
				"icons/obj16/supresswarnings.gif"); //$NON-NLS-1$
	}

	@Override
	public String getDescription() {
		return "Inserts '// " + getAnnotation() //$NON-NLS-1$
				+ "' on the line before the warning"; //$NON-NLS-1$
	}

	@Override
	protected MultiTextEdit getTextEdit(final IFile scriptFile, final int position) {
		MultiTextEdit textEdit = new MultiTextEdit();
		try {
			ISourceModule sourceModule = DLTKCore.createSourceModuleFrom(scriptFile);
			String source = sourceModule.getSource();
			if (source == null)
				return textEdit;

			// find the start-of-line that contains 'position'
			int lineStart = position;
			while (lineStart > 0 && source.charAt(lineStart - 1) != '\n') {
				lineStart--;
			}

			// preserve the indentation of that line
			int indentEnd = lineStart;
			while (indentEnd < source.length()
					&& (source.charAt(indentEnd) == ' ' || source.charAt(indentEnd) == '\t')) {
				indentEnd++;
			}
			String indent = source.substring(lineStart, indentEnd);

			// insert "<indent>/** @SuppressWarnings(type) */\n" just before lineStart
			String insertion = indent + "/** " + getAnnotation() + " */\n"; //$NON-NLS-1$ //$NON-NLS-2$
			textEdit.addChild(new InsertEdit(lineStart, insertion));
		} catch (ModelException e) {
			e.printStackTrace();
		}
		return textEdit;
	}

	private String getAnnotation() {
		return "@SuppressWarnings(" + type + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/** Always valid – a line comment can be inserted anywhere. */
	public boolean isValid() {
		return getScriptFile() != null && getProblemStartIdx() >= 0;
	}
}
