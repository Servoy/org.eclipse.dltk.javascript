# Spec: SVY-21250 — Array-destructuring parameter support in DLTK Rhino fork

## 1. Goal

Implement array/object-destructuring formal parameter support in the DLTK Rhino parser fork so that arrow functions and regular functions with destructuring parameters (e.g., `([key, value]) => value !== null`) parse correctly, produce proper AST nodes, and integrate with type inference (no NPE, no "undeclared variable" warnings for destructured bindings).

## 2. Background

### 2.1 DLTK Parser architecture

The DLTK JavaScript parser (`org.eclipse.dltk.javascript.parser`) is a **separate fork** from the upstream Rhino parser (`org.eclipse.dltk.javascript.rhino`). It produces a DLTK-specific AST used for IDE tooling (code completion, outline, validation, search), **not** for JavaScript execution.

Key distinction:
- **Upstream Rhino** (`org.mozilla.javascript.Parser`): Produces Rhino AST → IR → bytecode. Handles `DESTRUCTURING_PARAMS` via temp names, `defineSymbol`, and `createDestructuringAssignment`.
- **DLTK Parser** (`org.eclipse.dltk.javascript.parser.rhino.Parser`): Produces DLTK AST (`FunctionStatement`, `Argument`, `Identifier`). Does NOT participate in IR/bytecode compilation.

### 2.2 Missing implementation

The DLTK parser had destructuring parameter handling commented out with `//TODO` markers. When encountering `[a, b]` or `{a, b}` in a parameter position, the parser would either skip it or produce broken AST nodes, leading to:
1. `NullPointerException` in downstream visitors (type inferencer, formatter, search)
2. "Reference to undeclared variable" warnings for destructured bindings

### 2.3 Downstream consumers

Code that iterates `FunctionStatement.getArguments()` and calls `argument.getIdentifier().getName()` would crash on destructuring arguments (which have no identifier, only a pattern):
- `JSMethod.addArguments` — builds parameter list for type inference
- `TypeInferencerVisitor.createMethod` — resolves parameter types
- `SelectionVisitor` — code navigation (F3)
- `JavaScriptMatchLocatorVisitor` — search/references
- `FormatterNodeBuilder` — code formatting
- `ASTVerifier` — test infrastructure

## 3. Design

### 3.1 Parser changes (`org.eclipse.dltk.javascript.parser`)

#### 3.1.1 `Argument` class — new `destructuringPattern` field

Added to `org.eclipse.dltk.javascript.ast.Argument`:
- `Expression destructuringPattern` field with getter/setter
- `getArgumentName()` returns `null` when identifier is absent (destructuring arg)

#### 3.1.2 `Parser.parseFunctionParams` — regular functions

When `tt == Token.LB || tt == Token.LC`:
1. Parse pattern via `destructuringPrimaryExpr()`
2. `markDestructuring(expr)`
3. Create `Argument` with `setDestructuringPattern(expr)`
4. If followed by `=`, parse default value via `assignExpr()` and store on argument

This approach differs from upstream Rhino which uses `destructuringAssignExpr()` to parse the entire `[a,b] = [1,2]` as one Assignment node. Our approach parses the pattern first, then handles `=` separately — functionally equivalent but simpler and consistent with how the DLTK parser handles default params for named arguments.

#### 3.1.3 `Parser.arrowFunctionParams` — arrow functions

Arrow function params arrive as already-parsed expressions (the parenthesized expression is parsed before `=>` is seen). Added handling for:
- `params instanceof IDestructuringPattern` → wrap in Argument with `setDestructuringPattern`
- `params instanceof BinaryOperation` with `"="` and LHS instanceof `IDestructuringPattern` → destructuring with default value

#### 3.1.4 No IR/compilation changes needed

The DLTK parser does NOT set `DESTRUCTURING_PARAMS` or call `defineSymbol`/`getNextTempName` because:
- It produces IDE AST, not compilation IR
- The Rhino compilation pipeline uses its own `org.mozilla.javascript.Parser` which already handles this correctly

### 3.2 Downstream null-safety fixes (`org.eclipse.dltk.javascript.core`)

#### 3.2.1 `JSMethod.addArguments` — extract identifiers from pattern

When `argument.getIdentifier() == null && argument.getDestructuringPattern() != null`:
- Cast pattern to `IDestructuringPattern`
- Call `pattern.getIdentifiers()` to get the bound names
- Register each as a named `IParameter`

This follows the same approach as `DestructuringVariableDeclaration` handling in `JSDocSupport.processVariable` and `TypeInferencerVisitor.visitVariableStatementBase`.

#### 3.2.2 Null guards in visitors

Added `if (argument.getIdentifier() == null) continue;` in:
- `TypeInferencerVisitor.createMethod(FunctionStatement)` 
- `TypeInferencerVisitor.createMethod(Method)`
- `TypeInferencerVisitor.createMethod(ArrowFunctionStatement)`
- `SelectionVisitor.visitFunctionBody` / `visitArrowFunctionBody`
- `JavaScriptMatchLocatorVisitor`

These are safe to skip because the parameters are already registered via `JSMethod.addArguments`.

#### 3.2.3 Formatter and ASTVerifier — visit pattern node

In `FormatterNodeBuilder` and `ASTVerifier`, replaced:
```java
visit(argument.getIdentifier());
```
with:
```java
if (argument.getIdentifier() != null) {
    visit(argument.getIdentifier());
} else if (argument.getDestructuringPattern() != null) {
    visit(argument.getDestructuringPattern());
}
```

### 3.3 API filter

Suppressed pre-existing PDE API compatibility marker for `Parser.setIsGenerator()` removal (unrelated to this change).

## 4. Files changed

### `org.eclipse.dltk.javascript.parser` (in `org.eclipse.dltk.javascript` repo)
| File | Change |
|------|--------|
| `Argument.java` | Added `destructuringPattern` field, getter, setter |
| `Parser.java` | Destructuring param handling in `parseFunctionParams` and `arrowFunctionParams` |
| `.settings/.api_filters` | Suppress `setIsGenerator()` API warning |

### `org.eclipse.dltk.javascript.parser.tests`
| File | Change |
|------|--------|
| `TestRhinoParser.java` | 5 test methods for destructuring params |
| `ASTVerifier.java` | Null-safe pattern visiting |

### `org.eclipse.dltk.javascript.core` (in `org.eclipse.dltk.javascript` repo)
| File | Change |
|------|--------|
| `JSMethod.java` | Extract identifiers from destructuring pattern |
| `TypeInferencerVisitor.java` | Null guards (3 locations) |
| `SelectionVisitor.java` | Null guards (2 locations) |
| `JavaScriptMatchLocatorVisitor.java` | Null guard |

### `org.eclipse.dltk.javascript.formatter`
| File | Change |
|------|--------|
| `FormatterNodeBuilder.java` | Visit pattern instead of identifier (2 locations) |

## 5. Test cases

All in `TestRhinoParser`:
- `testDestructuringParam_arrayInArrowFunction` — `([a, b]) => a + b`
- `testDestructuringParam_arrayInRegularFunction` — `function f([a, b]) { return a + b; }`
- `testDestructuringParam_objectInRegularFunction` — `function f({a, b}) { return a + b; }`
- `testDestructuringParam_mixedWithRegularParams` — `function f(x, [a, b], y) {...}`
- `testDestructuringParam_realWorldFilterPattern` — `Object.entries(obj).filter(([key, value]) => value !== null)`

Full test suite: 469 tests, all passing.

## 6. Acceptance criteria

- [x] Arrow function with array-destructuring parameter parses without error: `([key, value]) => value !== null`
- [x] Regular function with array-destructuring parameter parses without error: `function f([a, b]) { return a + b; }`
- [x] Object destructuring parameter works: `({a, b}) => a + b`
- [x] Destructuring with default values works: `function f([a, b] = [1, 2]) {...}`
- [x] Mixed parameters work: `function f(x, [a, b], y) {...}`
- [x] No NPE in type inferencer, formatter, search, or code assist
- [x] Destructured bindings are registered as parameters (no "undeclared variable" warning)
- [x] All 469 existing parser tests pass
- [x] Zero compilation errors across all affected projects

## 7. Out of scope

- Non-parameter array destructuring (e.g., `var [a, b] = arr;`) — already works via `DestructuringVariableDeclaration`
- Full type inference through destructuring patterns (e.g., inferring `key` is `string` from `Object.entries`)
- Upgrading to a newer upstream Rhino version
