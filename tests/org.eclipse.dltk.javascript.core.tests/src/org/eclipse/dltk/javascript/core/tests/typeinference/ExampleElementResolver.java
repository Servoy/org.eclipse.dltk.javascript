/*******************************************************************************
 * Copyright (c) 2010 xored software, Inc.  
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html  
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.javascript.core.tests.typeinference;

import static org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelFactory.eINSTANCE;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.dltk.compiler.CharOperation;
import org.eclipse.dltk.compiler.env.ModuleSource;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IScriptFolder;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.internal.javascript.ti.TypeInferencer2;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.parser.JavaScriptParser;
import org.eclipse.dltk.javascript.typeinfo.IElementResolver;
import org.eclipse.dltk.javascript.typeinfo.ITypeInfoContext;
import org.eclipse.dltk.javascript.typeinfo.TypeUtil;
import org.eclipse.dltk.javascript.typeinfo.model.GenericMethod;
import org.eclipse.dltk.javascript.typeinfo.model.Member;
import org.eclipse.dltk.javascript.typeinfo.model.Parameter;
import org.eclipse.dltk.javascript.typeinfo.model.Property;
import org.eclipse.dltk.javascript.typeinfo.model.Type;
import org.eclipse.dltk.javascript.typeinfo.model.TypeInfoModelFactory;
import org.eclipse.dltk.javascript.typeinfo.model.TypeVariable;

@SuppressWarnings({ "nls", "restriction" })
public class ExampleElementResolver implements IElementResolver {

	public static final String MEMBER_VALUE = "AAAAAAAAAAAAAAAAAAAA";
	public static final String LAZY_MEMBER_VALUE = "LAZY_AAAAAAAAAAAAAAAAAAAA";

	public Member resolveElement(ITypeInfoContext context, String name) {
		if ("ExampleGlobal".equals(name)) {
			Property property = TypeInfoModelFactory.eINSTANCE.createProperty();
			property.setType(context
					.getTypeRef(ExampleTypeProvider.TYPE_SERVICE));
			property.setName(name);
			property.setDeprecated(true);
			return property;
		} else if ("GLOBALS".equals(name)) {
			Property property = TypeInfoModelFactory.eINSTANCE.createProperty();
			property.setName(name);
			final Script script = new JavaScriptParser().parse(new ModuleSource("/** @return {Array<String>}*/function test() { return new Array();}"), null);
			if (script != null) {
				TypeInferencer2 inferencer = new TypeInferencer2();
//				inferencer.setModelElement(globals);
				inferencer.doInferencing(script);
				property.setAttribute(MEMBER_VALUE,
						inferencer.getCollection());
			}
			return property;
		} else if ("GLOBALSLAZY".equals(name)) {
			// this is a lazy created value collection that also has a String
			// type (combined js file and a type)
			Property property = TypeInfoModelFactory.eINSTANCE.createProperty();
			property.setName(name);
			final ISourceModule module = context.getSource().getSourceModule();
			if (module != null) {
				final IScriptFolder folder = (IScriptFolder) module
						.getAncestor(IModelElement.SCRIPT_FOLDER);
				final ISourceModule globals = folder
						.getSourceModule("globals.js");
				// set the lazy value
				property.setAttribute(LAZY_MEMBER_VALUE, globals);
				// set the type besides the lazy value
				property.setType(context.getTypeRef("String"));
			}
			return property;
		} else if ("executeExampleGlobal".equals(name)) {
			final Type type = context.getType(ExampleTypeProvider.TYPE_SERVICE);
			for (Member member : type.getMembers()) {
				if ("execute".equals(member.getName())) {
					return member;
				}
			}
		} else if ("exampleForms".equals(name)) {
			Property property = TypeInfoModelFactory.eINSTANCE.createProperty();
			property.setType(context
					.getTypeRef(ExampleTypeProvider.TYPE_EXAMPLE_FORMS));
			property.setName(name);
			property.setDescription("Description for <b>exampleForms</b>");
			return property;
		} else if ("exampleFormsHide".equals(name)) {
			Property property = TypeInfoModelFactory.eINSTANCE.createProperty();
			property.setType(context
					.getTypeRef(ExampleTypeProvider.TYPE_EXAMPLE_FORMS));
			property.setName(name);
			property.setDescription("Description for <b>exampleForms</b>");
			property.setHideAllowed(true);
			return property;
		} else if ("myExampleForms".equals(name)) {
			Property property = TypeInfoModelFactory.eINSTANCE.createProperty();
			property.setType(context
					.getTypeRef(ExampleTypeProvider.TYPE_EXAMPLE_FORMS));
			property.setName(name);
			property.setDeprecated(true);
			return property;
		} else if ("myGenericArrayTest".equals(name)) {
			Property property = TypeInfoModelFactory.eINSTANCE.createProperty();
			property.setType(context
					.getTypeRef(ExampleTypeProvider.TYPE_GENERIC_ARRAY_METHOD));
			property.setName(name);
			return property;
		} else if ("exampleCopy".equals(name)) {
			final GenericMethod method = eINSTANCE.createGenericMethod();
			final TypeVariable variable = eINSTANCE.createTypeVariable();
			variable.setName("T");
			method.getTypeParameters().add(variable);
			method.setType(TypeUtil.reference(variable));
			final Parameter param = eINSTANCE.createParameter();
			param.setName("value");
			param.setType(TypeUtil.reference(variable));
			method.getParameters().add(param);
			return method;
		} else if ("arrayTest".equals(name)) {
			Property property = TypeInfoModelFactory.eINSTANCE.createProperty();
			property.setType(context.getTypeRef("ArrayTest"));
			property.setName(name);
			return property;
		}
		return null;
	}

	public Set<Member> resolveElements(ITypeInfoContext context, String name) {
		final Member member = resolveElement(context, name);
		return member != null ? Collections.singleton(member) : null;
	}

	private static final boolean ENABLE_LIST_GLOBALS = false;

	public Set<String> listGlobals(ITypeInfoContext context, String prefix) {
		if (ENABLE_LIST_GLOBALS) {
			Set<String> result = new HashSet<String>();
			String[] names = new String[] { "ExampleGlobal", "GLOBALS",
					"executeExampleGlobal", "exampleForms", "myExampleForms",
					"myGenericArrayTest" };
			for (String name : names) {
				if (CharOperation.prefixEquals(prefix, name)) {
					result.add(name);
				}
			}
			return result;
		} else {
			return null;
		}
	}

}
