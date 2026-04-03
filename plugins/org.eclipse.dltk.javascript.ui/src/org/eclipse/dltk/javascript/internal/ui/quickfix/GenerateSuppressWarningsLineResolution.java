package org.eclipse.dltk.javascript.internal.ui.quickfix;

import org.eclipse.core.resources.IFile;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.javascript.ast.BinaryOperation;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.javascript.parser.JavaScriptParserUtil;
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
		if (getBinaryOperation(getScriptFile(), getProblemStartIdx()) != null) {
			return "Add SuppressWarnings(" + type + ") inline before the binary operation"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return "Add SuppressWarnings(" + type + ") on the line before the warning"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public Image getImage() {
		return DLTKPluginImages.getImage(JavaScriptUI.getDefault(),
				"icons/obj16/supresswarnings.gif"); //$NON-NLS-1$
	}

	@Override
	public String getDescription() {
		if (getBinaryOperation(getScriptFile(), getProblemStartIdx()) != null) {
			return "Inserts '/** " + getAnnotation() + " */' inline before the binary operation"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return "Inserts '/** " + getAnnotation() //$NON-NLS-1$
				+ " */' on the line before the warning"; //$NON-NLS-1$
	}

	@Override
	protected MultiTextEdit getTextEdit(final IFile scriptFile, final int position) {
		MultiTextEdit textEdit = new MultiTextEdit();
		try {
			ISourceModule sourceModule = DLTKCore.createSourceModuleFrom(scriptFile);
			String source = sourceModule.getSource();
			if (source == null)
				return textEdit;

			// Check whether the warning sits inside a binary operation.
			// If so, insert the annotation inline just before that operation.
			BinaryOperation binaryOp = getBinaryOperation(scriptFile, position);
			if (binaryOp != null) {
				String insertion = "/** " + getAnnotation() + " */"; //$NON-NLS-1$ //$NON-NLS-2$
				textEdit.addChild(new InsertEdit(binaryOp.sourceStart(), insertion));
				return textEdit;
			}

			// Fallback: insert "<indent>/** @SuppressWarnings(type) */\n"
			// on the line immediately before the line containing 'position'.
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

			String insertion = indent + "/** " + getAnnotation() + " */\n"; //$NON-NLS-1$ //$NON-NLS-2$
			textEdit.addChild(new InsertEdit(lineStart, insertion));
		} catch (ModelException e) {
			e.printStackTrace();
		}
		return textEdit;
	}

	/**
	 * Finds the innermost {@link BinaryOperation} AST node that contains
	 * {@code position}.  Returns {@code null} when the position is not inside
	 * any binary operation.
	 */
	private BinaryOperation getBinaryOperation(final IFile scriptFile, final int position) {
		Script script = JavaScriptParserUtil.parse(DLTKCore.createSourceModuleFrom(scriptFile));
		if (script == null)
			return null;
		final BinaryOperation[] result = new BinaryOperation[1];
		ASTVisitor finder = new ASTVisitor() {
			@Override
			public boolean visitGeneral(ASTNode node) throws Exception {
				if (node.sourceStart() > position)
					return false;
				if (node.sourceEnd() >= position && node instanceof BinaryOperation) {
					BinaryOperation bo = (BinaryOperation) node;
					// only use non-assignment binary ops (comparisons, logical, etc.)
					if (!bo.isAssignment()) {
						// keep the innermost (last one found via depth-first)
						result[0] = bo;
					}
				}
				return true;
			}
		};
		try {
			script.traverse(finder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result[0];
	}

	private String getAnnotation() {
		return "@SuppressWarnings(" + type + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/** Always valid – a line comment can be inserted anywhere. */
	public boolean isValid() {
		return getScriptFile() != null && getProblemStartIdx() >= 0;
	}
}
