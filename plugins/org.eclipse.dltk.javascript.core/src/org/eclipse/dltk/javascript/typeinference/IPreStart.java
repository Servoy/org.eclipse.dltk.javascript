package org.eclipse.dltk.javascript.typeinference;

import org.eclipse.core.resources.IFile;

public interface IPreStart {
	boolean aboutToStart(IFile file, IValueCollection collection);
}
