package org.eclipse.dltk.javascript.typeinfo;

/**
 * Marker interface for types that have a other types associated with them.
 * {@link IRType} implemenentations can also implement this interface to provide
 * the default type that they also map to So that would be
 * ScriptRuntime.getDefaultValue(type) in Rhino. If an object would return there
 * a String, so the type will be converted to String at runtime, then this type
 * tells the code validator that. But in code completion it is not directly a
 * String (so not a super type or a trait). Because we don't want to show the
 * String type in the completion, that it maps on a string is a pure runtime
 * thing.
 */
public interface MapOnType extends IRType {
	TypeCompatibility canMap(IRType type);
}
