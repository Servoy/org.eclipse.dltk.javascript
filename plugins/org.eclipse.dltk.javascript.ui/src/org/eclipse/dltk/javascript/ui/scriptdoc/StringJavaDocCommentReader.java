package org.eclipse.dltk.javascript.ui.scriptdoc;

public class StringJavaDocCommentReader extends JavaDocCommentReader {

	private String fBuffer;

	public StringJavaDocCommentReader(String buf) {
		super(0, buf.length());
		fBuffer = buf;
	}

	@Override
	protected char getChar(int index) {
		return fBuffer.charAt(index);
	}

	/**
	 * @see java.io.Reader#close()
	 */
	public void close() {
		fBuffer = null;
	}

}