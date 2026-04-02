package org.eclipse.dltk.javascript.internal.ui.quickfix;

import org.eclipse.core.resources.IFile;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.javascript.ast.Comment;
import org.eclipse.dltk.javascript.ast.FunctionStatement;
import org.eclipse.dltk.javascript.ast.JSNode;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.internal.ui.JavaScriptUI;
import org.eclipse.dltk.javascript.parser.JavaScriptParserUtil;
import org.eclipse.dltk.ui.DLTKPluginImages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MultiTextEdit;

public class GenerateSuppressWarningsResolution extends TextFileEditResolution {

	private final String type;

	public GenerateSuppressWarningsResolution(IFile scriptFile,
			int problemStartIdx, String type) {
		super(scriptFile, problemStartIdx);
		this.type = type;
	}

	public String getLabel() {
		FunctionStatement fs = getFunctionStatement(getScriptFile(),
				getProblemStartIdx());
		if (fs != null) {
			return "Add SuppressWarnings("
					+ type
					+ ") to the function '"
					+ getFunctionStatement(getScriptFile(),
							getProblemStartIdx()).getFunctionName() + "'";
		}
		return "Add SuppressWarnings(" + type + ")";
	}

	@Override
	public Image getImage() {
		return DLTKPluginImages.getImage(JavaScriptUI.getDefault(),
				"icons/obj16/supresswarnings.gif");
	}

	protected MultiTextEdit getTextEdit(final IFile scriptFile,
			final int position) {
		MultiTextEdit textEdit = new MultiTextEdit();

		FunctionStatement fs = getFunctionStatement(scriptFile, position);
		if (fs != null) {
			// TODO identation should be get..
			int insertOffset = -1;
			Comment documentation = fs.getDocumentation();
			if (documentation != null && documentation.isDocumentation()) {
				insertOffset = documentation.sourceEnd() - 2;
				InsertEdit suppressTextEdit = new InsertEdit(insertOffset,
						"* " + getAnnotation() + "\n "); //$NON-NLS-1$ //$NON-NLS-2$
				textEdit.addChild(suppressTextEdit);
			} else {
				textEdit.addChild(new InsertEdit(fs.sourceStart(), "/**\n * "
						+ getAnnotation() + "\n*/\n"));
			}
		}
		return textEdit;
	}

	/**
	 * @param scriptFile
	 * @param position
	 */
	private FunctionStatement getFunctionStatement(final IFile scriptFile,
			final int position) {
		Script script = JavaScriptParserUtil.parse(DLTKCore
				.createSourceModuleFrom(scriptFile));
		final ASTNode[] closestValue = new ASTNode[1];
		ASTVisitor finder = new ASTVisitor() {
			@Override
			public boolean visitGeneral(ASTNode node) throws Exception {
				if (node.sourceStart() > position)
					return false;

				if (node.sourceEnd() >= position) {
					closestValue[0] = node;
				}
				return true;
			};
		};
		try {
			script.traverse(finder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ASTNode node = closestValue[0];
		while (node instanceof JSNode) {
			if (node instanceof FunctionStatement) {
				return (FunctionStatement) node;
			}
			node = ((JSNode) node).getParent();
		}
		return null;
	}

	public String getDescription() {
		FunctionStatement f = getFunctionStatement(getScriptFile(),
				getProblemStartIdx());
		ISourceModule sourceModule = DLTKCore
				.createSourceModuleFrom(getScriptFile());
		try {
			String functionString = sourceModule.getBuffer().getText(
					f.sourceStart(), f.sourceEnd() - f.sourceStart());
			int lineEnd = functionString.indexOf('\n');
			StringBuilder sb = new StringBuilder(lineEnd + 100);
			sb.append("<html><body> *<b>");
			sb.append(getAnnotation());
			sb.append("</b><br/> */<br/>");
			sb.append(functionString.substring(0, lineEnd));
			sb.append("</body></html>");
			return sb.toString();
		} catch (ModelException e) {
		}
		return getLabel();
	}

	private String getAnnotation() {
		return "@SuppressWarnings(" + type + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public boolean isValid() {
		return getFunctionStatement(getScriptFile(), getProblemStartIdx()) != null;
	}
}
