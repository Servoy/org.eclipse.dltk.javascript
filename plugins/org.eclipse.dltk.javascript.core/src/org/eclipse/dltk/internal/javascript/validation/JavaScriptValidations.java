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
package org.eclipse.dltk.internal.javascript.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.IValidationStatus;
import org.eclipse.dltk.compiler.problem.ValidationStatus;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceNode;
import org.eclipse.dltk.core.SourceParserUtil;
import org.eclipse.dltk.core.builder.IBuildContext;
import org.eclipse.dltk.javascript.ast.Script;
import org.eclipse.dltk.javascript.core.JavaScriptProblems;
import org.eclipse.dltk.javascript.parser.JSProblemReporter;
import org.eclipse.dltk.javascript.parser.JavaScriptParserUtil;
import org.eclipse.dltk.javascript.parser.Reporter;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinfo.IRConstructor;
import org.eclipse.dltk.javascript.typeinfo.IRMethod;
import org.eclipse.dltk.javascript.typeinfo.IRParameter;
import org.eclipse.dltk.javascript.typeinfo.IRType;
import org.eclipse.dltk.javascript.typeinfo.JSTypeSet;
import org.eclipse.dltk.javascript.typeinfo.RModelBuilder;
import org.eclipse.dltk.javascript.typeinfo.RTypes;
import org.eclipse.dltk.javascript.typeinfo.TypeCompatibility;
import org.eclipse.dltk.javascript.typeinfo.model.ParameterKind;
import org.eclipse.osgi.util.NLS;

public class JavaScriptValidations {

	static final String ATTR_INCONSISTENT_RETURNS = JavaScriptValidations.class
			.getName() + ".INCONSISTENT_RETURNS";

	public static Script parse(IBuildContext context) {
		final IModuleDeclaration savedAST = (IModuleDeclaration) context
				.get(IBuildContext.ATTR_MODULE_DECLARATION);
		if (savedAST instanceof Script) {
			return (Script) savedAST;
		}
		final ISourceModule module = context.getSourceModule();
		if (module != null) {
			// TODO pass additional predicate here...
			final IModuleDeclaration declaration = SourceParserUtil.parse(
					module, context.getProblemReporter());
			if (declaration instanceof Script) {
				context.set(IBuildContext.ATTR_MODULE_DECLARATION, declaration);
				return (Script) declaration;
			}
		}
		Script script = JavaScriptParserUtil.parse(context,
				context.getProblemReporter());
		context.set(IBuildContext.ATTR_MODULE_DECLARATION, script);
		return script;
	}

	public static IRType typeOf(IValueReference reference) {
		if (reference != null) {
			if (reference.getDeclaredType() != null) {
				return reference.getDeclaredType();
			}
			JSTypeSet declaredTypes = reference.getDeclaredTypes();
			if (declaredTypes.size() == 1) {
				return declaredTypes.toRType();
			}
			return reference.getTypes().toRType();
		}
		return null;
	}

	public static Set<IRType> getTypes(IValueReference reference) {
		if (reference != null) {
			final Set<IRType> set = new HashSet<IRType>(4);
			final IRType declaredType = reference.getDeclaredType();
			if (declaredType != null) {
				set.add(declaredType);
			}
			for (IRType type : reference.getDeclaredTypes()) {
				set.add(type);
			}
			for (IRType type : reference.getTypes()) {
				set.add(type);
			}
			if (!set.isEmpty()) {
				return set;
			}
		}
		return Collections.emptySet();
	}

	protected static Reporter createReporter(IBuildContext context) {
		return new Reporter(context.getLineTracker(),
				context.getProblemReporter());
	}

	/**
	 * @param methods
	 * @param arguments
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <METHOD extends IRMethod> METHOD selectMethod(
			List<METHOD> methods, IValueReference[] arguments, boolean fallback) {
		if (methods.size() == 1) {
			return methods.get(0);
		}
		List<METHOD> matches = null;
		for (METHOD method : methods) {
			if (checkParameterCount(method, arguments.length)) {
				if (matches == null) {
					matches = new ArrayList<METHOD>(4);
				}
				matches.add(method);
			}
		}
		if (matches != null) {
			METHOD firstMatch = matches.get(0);
			if (matches.size() == 1) {
				return firstMatch;
			}
			OUTER: for (METHOD method : matches) {
				final List<IRParameter> parameters = method.getParameters();
				for (int i = 0; i < Math.min(parameters.size(),
						arguments.length); i++) {
					final IRType parameterType = parameters.get(i).getType();
					if (parameterType == null)
						continue;
					final IRType argumentType = typeOf(arguments[i]);
					if (argumentType == null)
						continue;
					if (parameterType.isAssignableFrom(argumentType) == TypeCompatibility.FALSE)
						continue OUTER;
				}
				return method;
			}
			// if it still didn't match then the argument is maybe of union type
			// and matches 1 of the methods at runtime (but not a specific one
			// at design time). just make 1 method of the matched methods.
			if (!(firstMatch instanceof IRConstructor)) {
				Collection<IRType>[] paramType = new Collection[firstMatch
						.getParameterCount()];
				for (METHOD method : matches) {
					List<IRParameter> parameters = method.getParameters();
					for (int i = 0; i < Math.min(arguments.length,
							parameters.size()); i++) {
						if (paramType[i] == null)
							paramType[i] = new ArrayList<IRType>();
						paramType[i].add(parameters.get(i).getType());
					}
				}
				List<IRParameter> parameters = firstMatch.getParameters();
				IRParameter[] params = new IRParameter[paramType.length];
				for (int i = 0; i < parameters.size(); i++) {
					IRParameter param = parameters.get(i);
					params[i] = RModelBuilder.createParameter(param.getName(),
							RTypes.union(paramType[i]), param.getKind());
				}
				return (METHOD) RModelBuilder.method(firstMatch.getName(),
						firstMatch.getType(), Arrays.asList(params),
						firstMatch.getVisibility(), firstMatch.getSource());
			}
		}
		return fallback ? methods.get(0) : null;
	}

	/**
	 * Checks the parameter count, returns <code>true</code> if correct.
	 * 
	 * @param method
	 * @param argCount
	 * 
	 * @return
	 */
	static boolean checkParameterCount(IRMethod method, int argCount) {
		final List<IRParameter> params = method.getParameters();
		if (params.size() == argCount) {
			return true;
		} else if (params.size() < argCount) {
			return !params.isEmpty()
					&& params.get(params.size() - 1).getKind() == ParameterKind.VARARGS;
		} else if (params.size() > argCount) {
			final ParameterKind last = params.get(argCount).getKind();
			return last == ParameterKind.OPTIONAL
					|| last == ParameterKind.VARARGS;
		} else {
			return false;
		}
	}

	public static void reportValidationStatus(JSProblemReporter reporter,
			final IValidationStatus result, ISourceNode node,
			final JavaScriptProblems defaultProblemId,
			final String defaultMessage, final String name) {
		if (result instanceof ValidationStatus) {
			final ValidationStatus status = (ValidationStatus) result;
			final int start;
			final int end;
			if (status.hasRange()) {
				start = status.start();
				end = status.end();
			} else {
				start = node.start();
				end = node.end();
			}
			reporter.reportProblem(status.identifier(), status.message(),
					start, end);
		} else if (result instanceof IProblemIdentifier) {
			reporter.reportProblem((IProblemIdentifier) result,
					NLS.bind(defaultMessage, name), node.start(), node.end());
		} else if (result == ValidationStatus.OK) {
			return;
		} else {
			reporter.reportProblem(defaultProblemId,
					NLS.bind(defaultMessage, name) + ": " + result,
					node.start(), node.end());
		}
	}
}
