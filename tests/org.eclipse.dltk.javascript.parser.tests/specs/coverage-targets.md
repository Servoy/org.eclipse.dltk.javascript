# Coverage Targets — Blocked Paths and High-Value Methods

Read this file when deciding which uncovered lines to pursue next.

---

## Permanently Blocked Paths — Do Not Attempt

These lines will never be coverable via normal test source strings. Skip them
when you see them in `lines.nocovered`; time spent on them is wasted.

| Code / Method | Why it's blocked |
|---|---|
| `codeBug()` | Throws unconditionally; defensive guard for impossible states |
| `addWarning(String, String, int, int)` | Requires `compilerEnv.reportWarningAsError()=true`; the `warningAsError` field has no public setter and is only set in a non-IDE constructor |
| `addError(String, String, int, int, int, String, int)` | Same restriction as `addWarning` |
| `reportErrorsIfExists(int)` | Only fires when `!ideMode`; IDE mode is always on |
| `standaloneExpression(String)` | Not on the normal parse path |
| `lineBeginningFor(int)` | Internal utility; no observable AST effect |
| `simpleAssignment()`, `createDestructuringAssignment()`, `destructuringAssignmentHelper()` | Dead code — call `codeBug()` |
| `insideFunctionBody()`, `insideFunctionParams()` | Internal state accessors |
| `setIsGenerator()`, `setSourceURI(String)`, `getCalledByCompileFunction()` | Setters/flags with no observable AST effect |
| XML dot-access error paths (~lines 3691–3729) | Only reachable when `isXmlAvailable()=false` AND specific XML token sequences; not practically triggerable |
| `warnMissingSemi` / `warnTrailingComma` | Need non-standard `CompilerEnvirons` settings; `warningAsError` field not publicly settable |

---

## High-Value Testable Targets

Prioritize by estimated missed-instruction count. These are confirmed reachable
via normal source strings.

| Method / Area | How to reach it |
|---|---|
| `propertyAccess` | `super?.foo` (error path); `a.=b` (dot followed by non-name token) |
| `objectLiteral` | Computed keys `{[expr]: v}`; shorthand methods `{f(){}}` |
| `checkBadIncDec` | `++"foo"` and `--42` |
| `recordLabel` | Duplicate label: `L: L: x;` |
| `parseFunctionParams` | Duplicate param name: `function f(a, a) {}`; `eval` as param |
| `condition()` | Assignment as condition: `if (a = 7) {}` |
| `returnOrYield` | `return` outside function; `return` with line comment immediately after |
| `tryStatement` | `try {} finally {}` (no catch); `try {} catch(e) {} finally {}` |
| `primaryExpr` | Template literals `` `hello ${x}` ``; `new.target` |
| `assignExpr` | Compound assignment operators: `**=`, `&&=`, `||=`, `??=` |
| `spreadElement` | `[...a, ...b]`; `f(...a, ...b)` |
| `computedPropertyKey` | `let o = { [1+2]: 3 }` |
| `optionalChain` | `a?.b?.c`; `a?.[k]`; `a?.()` |

---

## Unsupported Constructs — Never Test These

See `plugins//org.eclipse.dltk.javascript.parser/specs/unsupported-features.md` (or the
`rhino-dltk-merge` skill's `references/unsupported-features.md`) for the full
list. Summary: no `async`/`await`, `class`, private fields (`#`), `import`/`export`,
`function*`/`yield`, dynamic `import()`, or `"use strict"` directive in test source strings.
