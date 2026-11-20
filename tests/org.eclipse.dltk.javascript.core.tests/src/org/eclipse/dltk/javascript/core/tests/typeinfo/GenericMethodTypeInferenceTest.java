/*******************************************************************************
 * Copyright (c) 2012 NumberFour AG
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NumberFour AG - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.core.tests.typeinfo;

import java.util.Arrays;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.dltk.internal.javascript.ti.TypeSystemImpl;
import org.eclipse.dltk.javascript.core.Types;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.GenericMethodTypeInferencer;
import org.eclipse.dltk.javascript.typeinfo.GenericMethodTypeInferencer.Capture;
import org.eclipse.dltk.javascript.typeinfo.ITypeSystem;
import org.eclipse.dltk.javascript.typeinfo.RTypes;
import org.eclipse.dltk.javascript.typeinfo.TypeUtil;
import org.eclipse.dltk.javascript.typeinfo.model.GenericMethod;
import org.eclipse.dltk.javascript.typeinfo.model.Parameter;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelFactory;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariable;

@SuppressWarnings("restriction")
public class GenericMethodTypeInferenceTest extends TestCase {

	private static final TypeInfoModelFactory TIMF = TypeInfoModelFactory.eINSTANCE;

	private ITypeSystem typeSystem;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.typeSystem = new TypeSystemImpl();
	}

	public void testMap() {
		final GenericMethod method = TIMF.createGenericMethod();
		method.setName("test");
		final TypeVariable key = TIMF.createTypeVariable();
		key.setName("K");
		method.getTypeParameters().add(key);
		final TypeVariable value = TIMF.createTypeVariable();
		value.setName("V");
		method.getTypeParameters().add(value);
		final Parameter p = TIMF.createParameter();
		p.setName("param");
		p.setType(TypeUtil.mapOf(TypeUtil.reference(key),
				TypeUtil.reference(value)));
		method.getParameters().add(p);

		final GenericMethodTypeInferencer methodTypeInferencer = new GenericMethodTypeInferencer(
				typeSystem, method);
		final Capture capture = methodTypeInferencer.capture(p.getType(),
				Collections.singletonList(RTypes.mapOf(RTypes.STRING,
						RTypes.NUMBER, typeSystem.parameterize(Types.MAP, Arrays
								.<IRType> asList(RTypes.STRING, RTypes.NUMBER)))));
		assertTrue(capture.isOK());
		assertEquals(2, capture.getVariables().size());
		assertTrue(capture.getVariables().contains(key));
		assertEquals(RTypes.STRING, capture.getTypeOf(key).toRType());

		assertTrue(capture.getVariables().contains(value));
		assertEquals(RTypes.NUMBER, capture.getTypeOf(value).toRType());
	}

}
