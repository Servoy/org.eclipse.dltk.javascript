---
name: rhino-dltk-merge
description: >
  Step-by-step methodology for merging upstream Rhino parser upgrades into the
  DLTK-modified parser that directly emits DLTK AST nodes. Use this skill
  whenever the user wants to: port a new Rhino version into the DLTK/Servoy
  JavaScript parser, add ES6+ syntax support to the DLTK parser, create new
  DLTK AST node classes and visitor updates, or improve test coverage of the
  merged parser. Trigger even for partial tasks like "add spread support" or
  "update the visitor for computed property keys".
---

# Merging Rhino Parser Upgrades into DLTK JavaScript

This skill guides a merge of any upstream Rhino parser version into the
DLTK-modified parser. The DLTK parser **directly emits DLTK AST nodes** — there
is no post-parse conversion step. Keep that mental model throughout.

---

## Hard Constraints (Read First)

- **Do NOT break existing tests.** `AllTests` must stay at 0 failures throughout
  the merge. Run it after every logical group of changes.
- **Do NOT convert Rhino AST to DLTK nodes** — the parser emits DLTK nodes
  directly.
- **Do NOT add `BinaryOperation` handling to `arrowFunctionParams`** in
  `Parser.java`.
- **Do NOT edit `.class` files** — only `.java` source files.
- **Canonical AST node package is `org.eclipse.dltk.javascript.ast`**, not
  `ast.v4`. All imports must use `ast.*`.
- Before merging any hunk that adds new syntax, check
  [`specs/unsupported-features.md`](specs/unsupported-features.md).
  If the construct is on the unsupported list, skip the hunk (or surgically
  remove only the unsupported branch if the hunk is mixed).

---

## Merge Methodology

Work through the diff in four sequential phases. Run `AllTests` between phases
(and frequently within phases). Never carry forward a failing test.

### Phase 1 — Categorize the Diff

Before touching any code, diff the two Rhino versions and sort every hunk into
one of these buckets:

| Bucket | Description | Action |
|---|---|---|
| A | Pure parser logic (tokenizer fixes, precedence, error recovery) | Apply directly to `Parser.java` |
| B | New syntax → existing DLTK AST nodes (e.g. `?.`, `??`, trailing commas) | Apply to `Parser.java` only |
| C | New syntax → new AST nodes needed (e.g. `...`, `[expr]:`) | Parser + new node class + visitor updates |
| D | Dead code / Rhino-internal infrastructure | Skip or stub |
| U | Unsupported feature (see reference spec) | Skip entirely |

Produce a short written categorization before writing any code — it becomes
your merge checklist and helps avoid applying U-bucket hunks by accident.

### Phase 2 — Parser-Only Changes (Buckets A & B)

Apply all Bucket A and B hunks. After each logical group, run `AllTests`.

**Key invariants to verify in this phase:**

- Sentinel values for optional chain positions must be initialized to `-1` (not
  `0`). The guards `>= 0` / `> 0` throughout the codebase depend on this.
  Affected fields: `optionalChain`/`optionalChainPos` on `PropertyExpression`,
  `CallExpression`, `GetArrayItemExpression`.
- `UnaryOperation.toSourceString()`: assert `operationPos >= 0`, not `> 0`
  (prefix operators at position 0 are valid).
- All new ES6 syntax paths in `Parser.java` must be guarded by a
  `Context.VERSION_ES6` version check.

### Phase 3 — New AST Nodes (Bucket C)

For each new construct, create a node class in `org.eclipse.dltk.javascript.ast`.

**Canonical pattern:**

```java
public class SpreadElement extends Expression implements ISourceable {
    private int dotdotdot = -1;   // sentinel: -1 = not set, >= 0 = active
    private Expression expression;

    public SpreadElement(JSNode parent) { super(parent); }

    public int getDotDotDot()          { return dotdotdot; }
    public void setDotDotDot(int pos)  { this.dotdotdot = pos; }
    public Expression getExpression()  { return expression; }
    public void setExpression(Expression e) { this.expression = e; }

    @Override public String toSourceString(String indent) { ... }
    @Override public void traverse(ASTVisitor visitor) throws Exception { ... }
}
```

**Nodes added for Rhino 1.7→1.9 as reference examples:**

| Node | Extends | Notes |
|---|---|---|
| `SpreadElement` | `Expression` | `...expr` in array literals / call args |
| `SpreadProperty` | `ObjectInitializerPart` | `...expr` in object literals; `getName()` returns `null` |
| `ComputedPropertyKey` | `ObjectInitializerPart` | `[expr]: value`; tracks `lb`, `rb`, `colon` positions; `getName()` returns `null` |

Use the same sentinel/guard pattern (`-1` / `>= 0`) for all position fields in
new nodes. Never use `0` as "not set" — position 0 is a valid source location.

### Phase 4 — Visitor Updates

Every new AST node must be wired into **all** visitor classes. Use
`findReferences` / grep on the new class name to discover every site.

**Mandatory visitor classes and what to add:**

| Class | Change |
|---|---|
| `ASTVisitor.java` | New handler indices + `visitXxx` / `endvisitXxx` default methods (return `null`) |
| `AbstractNavigationVisitor.java` | Override `visitObjectInitializer` for new `ObjectInitializerPart` subtypes; add `visitXxx` overrides |
| `TypeInferencerVisitor.java` | Imports from `ast.*`; `visitXxx` overrides |
| `StructureReporter3.java` | Same pattern |
| `JavaScriptMatchLocatorVisitor.java` | Same pattern |
| `FormatterNodeBuilder.java` | Emit source tokens (e.g. `...` with `skipSpaces`) |
| `ASTVerifier.java` (test) | Handle new types without `Assert.fail` |
| `CodeValidation.java` | Usually no change — silently skips unknown parts |
| `JavaScriptCodeFoldingBlockProvider.java` | Usually no change |

**`ObjectInitializerPart` subtypes rule:** In `visitObjectInitializer`, use
`continue` after handling `SpreadProperty`/`ComputedPropertyKey` to bypass
`cur`-based post-processing that assumes a `PropertyInitializer`.

### Phase 5 — DOM / EMF Model Updates (when needed)

Only required if new AST nodes must be visible in tooling (formatter, content
assist, refactoring). Steps:

1. Update `dom.ecore` — add new `EClass` entries.
2. Update DOM interfaces (`ISpreadElement`, etc.) in `core.dom`.
3. Update DOM impls in `core.dom.impl`.
4. Update `DomPackage.java`, `DomPackageImpl.java`, `DomFactory.java`,
   `DomFactoryImpl.java` — register new type constants.
5. Update `ASTConverter.java` — add `visitXxx` methods that create DOM nodes
   from AST nodes.

**Type constant numbering:** append after the last existing constant. Do not
renumber existing constants.

---

## Test Strategy

### Existing Tests — Stability Rules

- Never modify an existing test unless it has a **compile error** caused by an
  incorrect API assumption introduced during the merge.
- When fixing a compile error, look up the actual method name in the AST node
  source — do not guess.

**Common API mistakes to watch for:**

| Wrong | Correct |
|---|---|
| `script.getStatements().get(0)` → `FunctionStatement` | `.get(0).getChilds().get(0)` → `FunctionStatement` (function decl is wrapped) |
| `getFinally().getKeyword()` | `getFinally().getFinallyKeyword()` |
| `getCaseClauses()` cast to `List<CaseClause>` | Returns `List<SwitchComponent>`; cast individual elements |
| `getIdentifiers()` on `DestructuringVariableDeclaration` → binding names | Returns **pattern keys** |

### New Tests — Rules

**ES6-only tests** (use language features not in Rhino 1.6):
- Use `getScriptv4()` only — never `equalsJSNode()`.

**Non-ES6 tests** (features available pre-ES6):
- Use both `getScript()` and `getScriptv4()`.
- Check punctuation positions explicitly.
- Call `equalsJSNode()` as the *last* assertion.
- Always assert the return value: `assertTrue(equalsJSNode(...))`.

**Error-recovery tests:**
- Do NOT use `getScriptv4()` — it calls `println(script)` which triggers
  `toSourceString()` on potentially malformed nodes.
- Use `new JavaScriptParser().parse(source, reporter)` directly.

**Position assertions:**
- Do NOT assert exact positions (e.g. `assertEquals(10, cpk.getLB())`).
- Use relational assertions: `assertTrue(cpk.getLB() >= 0)`,
  `assertTrue(cpk.getRB() > cpk.getLB())`.

**Forbidden constructs in test JS source strings:**  
See [`references/unsupported-features.md`](specs/unsupported-features.md)
for the full list. Never use them as the JavaScript source being parsed, even
in tests that intentionally check for parse errors.

### Coverage Improvement

**Methods that are untestable — skip:**

| Method | Reason |
|---|---|
| `codeBug()` | Throws unconditionally |
| `addWarning(...)`, `addStrictWarning(...)`, `addError(String)` | Internal plumbing |
| `reportErrorsIfExists(int)` | Only fires when `!ideMode` |
| `standaloneExpression(String)` | Not on the normal parse path |
| `lineBeginningFor(int)` | Internal utility |
| `simpleAssignment()`, `createDestructuringAssignment()`, `destructuringAssignmentHelper()` | Dead code (call `codeBug()`) |
| `insideFunctionBody()`, `insideFunctionParams()` | Internal state |
| `setIsGenerator()`, `setSourceURI(String)`, `getCalledByCompileFunction()` | Setters/flags with no observable AST effect |

**High-value testable targets (prioritize by missed-instruction count):**

| Target | How to test |
|---|---|
| `propertyAccess` | `super?.foo` (error path), `a.=b` (dot followed by non-name) |
| `checkBadIncDec` | `++"foo"` and `--42` |
| `recordLabel` | Duplicate label |
| `parseFunctionParams` | Duplicate param name |
| `condition()` | Assignment as condition: `if (a = 7)` |
| `returnOrYield` | `return` outside function; `return` followed by line comment |

---

## Regression Handling

If `AllTests` goes red after a change:

1. Note the failing test name(s) and the change that introduced the regression.
2. Revert that change in isolation (do not batch-revert).
3. Re-read the diff hunk: check whether it belongs in a different bucket, or
   whether it needs a DLTK-specific adaptation rather than a straight apply.
4. Fix and re-run before continuing.

The baseline before any merge work should be **0 failures**. If you see
failures before you've made any changes, stop and resolve them before beginning
the merge — they are not pre-existing known failures.

---

## Key API Quick Reference

| What you want | Correct API |
|---|---|
| Function declaration body | `script.getStatements().get(0).getChilds().get(0)` → `FunctionStatement` |
| Finally keyword position | `ts.getFinally().getFinallyKeyword()` |
| Switch clauses | `sw.getCaseClauses()` → `List<SwitchComponent>`; cast each element |
| Destructuring identifiers | `dvd.getIdentifiers()` returns **keys**, not local binding names |
| Rest parameter | `arg.getEllipsisPosition() >= 0` |
| Default parameter value | `arg.getDefaultParamValue()` |
| Label text | `label.getText()` not `label.getName()` |
| Spread `...` position | `se.getDotDotDot()` |
| Optional chain sentinel | `-1` means not set; `>= 0` means active |

---

## Reference Files

| File | When to read |
|---|---|
| [`references/unsupported-features.md`](specs/unsupported-features.md) | Before evaluating any hunk; before writing any test; any time you're unsure whether a feature is in scope |
