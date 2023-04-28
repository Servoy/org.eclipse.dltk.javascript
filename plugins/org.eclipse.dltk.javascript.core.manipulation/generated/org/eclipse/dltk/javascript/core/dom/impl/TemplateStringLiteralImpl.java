package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Node;
import org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral;

public class TemplateStringLiteralImpl extends ExpressionImpl implements TemplateStringLiteral {
	
	protected static final String TEXT_EDEFAULT = null;
	
	protected String text = TEXT_EDEFAULT;

	@Override
	public void setText(String text) {
		this.text = text;		
	}

	@Override
	public String getText() {
		return text;
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomPackage.STRING_LITERAL__TEXT:
				return getText();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DomPackage.STRING_LITERAL__TEXT:
				setText((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DomPackage.STRING_LITERAL__TEXT:
				setText(TEXT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DomPackage.STRING_LITERAL__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

	@Override
	public void addExpression(Node templateStringExpression) {
		// TODO Auto-generated method stub
		
	}
}
