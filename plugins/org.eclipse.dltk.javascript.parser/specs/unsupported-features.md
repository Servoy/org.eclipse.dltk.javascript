# DLTK/Servoy Unsupported JavaScript Features — Specification

This file is the authoritative reference for JavaScript language features that **must not** be merged into the DLTK-modified Rhino parser. Consult this before evaluating any parser hunk or writing any test.

---

## Unsupported Constructs

The following constructs are **not supported** by DLTK/Servoy. For each:

- **Do NOT merge** the corresponding parser code from any upstream Rhino version.
- **Do NOT add tests** that use these constructs as JS source strings.
- **Disable or guard** any parser path that would emit AST nodes for them — do not leave them reachable.

| Construct | Examples |
|---|---|
| `async` / `await` | `async function f() {}`, `await x`, `async () => x` |
| `class` syntax | `class Foo {}`, `class Foo extends Bar {}`, class expressions |
| Class fields | `class Foo { x = 1; }` |
| Private class fields | `class Foo { #x = 1; }` |
| `import` / `export` statements | `import x from '...'`, `export default x`, `export { x }` |
| Generator functions | `function* gen() {}`, `yield x` |
| Dynamic `import()` | `import('./mod')` |
| Strict mode directives | `"use strict"` at top of file or function |

### Strict Mode Detail

`compilerEnv.isStrictMode()` always returns `false` in this environment. Do not set `compilerEnv.setStrictMode(true)` in tests. Do not write test cases whose correctness depends on strict-mode semantics.

---

## What IS Supported (Selective ES6+)

These ES6+ features *are* supported and parser code for them may be merged when guarded by a `Context.VERSION_ES6` check:

- Arrow functions (`=>`)
- Template literals
- `let` / `const`
- Destructuring (in variable declarations; *note*: the old Antlr parser does not support destructuring, so tests using `equalsJSNode()` must not involve it)
- Rest parameters (`...args`)
- Spread in array literals and call arguments (`...expr`)
- Spread in object literals (`...expr`)
- Computed property keys (`[expr]: value`)
- Optional chaining (`?.`)
- Nullish coalescing (`??`)
- Default parameters
- `for...of`
- Trailing commas in function parameters and calls

---

## How to Handle Hunks That Touch Unsupported Features

When diffing a new upstream Rhino version:

1. **Identify** hunks that add, modify, or enable any construct in the Unsupported table above.
2. **Skip** those hunks entirely — do not apply them.
3. **If a hunk is mixed** (it touches both supported and unsupported logic), apply only the supported portion and manually stub or remove the unsupported branches.
4. **If an existing parser path** for an unsupported construct is reachable after the merge, add a guard that either throws `codeBug()` or falls through to an error, rather than emitting a partial/incorrect AST node.

---

## Test Authoring Rules Specific to This Spec

- Never use any construct from the Unsupported table as JavaScript source in a test case.
- Any existing commented-out tests for unsupported constructs **must remain commented out**.
- Do not re-enable them as part of a merge, even if upstream Rhino now parses them correctly.