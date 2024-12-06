package org.eclipse.dltk.javascript.parser;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.osgi.service.prefs.BackingStoreException;

public class JavascriptParserPreferences {
	
	protected final IEclipsePreferences eclipsePreferences;
	private static final String ES6_Preference = "ES6_Parser";

	public JavascriptParserPreferences()
	{
		eclipsePreferences = JavaScriptParserPlugin.getEclipsePreferences();
	}

	public boolean useES6Parser() {
		return eclipsePreferences.getBoolean(ES6_Preference, true);
	}
	
	public void useES6Parser(boolean use) {
		eclipsePreferences.putBoolean(ES6_Preference, use);
	}

	public void save()
	{
		try
		{
			eclipsePreferences.flush();
		}
		catch (BackingStoreException e)
		{
		}
	}
}
