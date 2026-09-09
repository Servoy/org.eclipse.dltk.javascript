# Spec: SVY-21422 — JSFiles double JSDoc generation (missing-semicolon JSDoc leak)

## 1. Goal

Fix the DLTK Rhino parser (`org.eclipse.dltk.javascript.parser.rhino.Parser`) so that a `var` declaration whose statement is terminated by ASI (no explicit `;`) does not cause its JSDoc comment to also be attached to the *next* declaration. Each declaration must own exactly its own preceding JSDoc block.

This spec is design-only. No code changes are made here; it defines the problem, root cause, and the intended fix for a later implementation task.

## 2. Reproduction (from the ticket)

```javascript
/**
 * @properties={typeid:35,uuid:"70CFCBF9-573E-46AF-8216-F99B5CB7D65F",variableType:-4}
 */
var pdfBytes = solutionModel.getMedia('blank.pdf').bytes

/**
 * @type {String}
 *
 * @properties={typeid:35,uuid:"7D4D9708-081F-4BEB-9AF2-654D8618D030"}
 */
var _titleName
```

Observed: the parser attaches an **extra** JSDoc to the next method/variable. The reporter's workaround is to add a trailing `;` after `.bytes`, i.e. after the first declaration. With the `;` present, the bug disappears.

This is a Servoy `.js` solution file where every top-level `var` carries a `@properties` JSDoc block; a leaked/duplicated JSDoc corrupts the persisted model (double JSDoc generation on save).

## 3. Background — how JSDoc is attached in the Rhino parser

The DLTK Rhino parser emits DLTK AST directly. JSDoc attachment is driven by a **single shared field** `currentJsDocComment` (`Parser.java:184`):

- `recordComment(...)` (`Parser.java:420`) sets `currentJsDocComment = commentNode` whenever a JSDOC-type comment is scanned and `compilerEnv.isRecordingLocalJsDocComments()` is on. Comments are scanned lazily inside `peekToken()` (`Parser.java:488-500`) — i.e. while looking ahead past the current statement.
- `getAndResetJsDoc()` (`Parser.java:445`) returns the current comment and clears the field.
- `getAndResetJsDoc(int start)` (`Parser.java:451`) only returns the comment if the most recently scanned comment starts before `start` — a positional guard.

Consumers that assign the pending JSDoc to a node include:

| Site | Line | Consumes via |
|------|------|--------------|
| `variables()` — var/const/let statement doc | `Parser.java:2700` | `getAndResetJsDoc()` (unconditional) |
| `variables()` — per-name doc | `Parser.java:2738` | `getAndResetJsDoc()` |
| `assignExpr()` — assignment RHS | `Parser.java:3002` | `getAndResetJsDoc()` |
| `assignExpr()` — dead-code `expr;` for `@type` | `Parser.java:3031` | `getAndResetJsDoc()` |
| `createPropertyExpression()` | `Parser.java:3863` | guarded by `currentJsDocComment.sourceStart() < pn.start()` |
| `name()` primary | `Parser.java:4054` | guarded by `currentJsDocComment.sourceStart() < name.start()` |

Statement termination / ASI is handled by `autoInsertSemicolon()` (`Parser.java:1568`): on `SEMI` it consumes the `;`; on `EOF`/`RC`/EOL it inserts a virtual semicolon.

## 4. Root cause (hypothesis to confirm during implementation)

`currentJsDocComment` is a single latch shared across statement boundaries, and comments are scanned lazily during look-ahead. The sequence for the reproduction is:

1. Parsing `var pdfBytes = ...` enters `variables()`. `varjsdocNode = getAndResetJsDoc()` (`Parser.java:2700`) correctly grabs JSDoc #1 and clears the field.
2. The initializer `solutionModel.getMedia('blank.pdf').bytes` is parsed. There is **no trailing `;`**, so the parser must peek past the end of the initializer to decide statement termination (ASI). That look-ahead calls `peekToken()`, which scans forward across the blank line and reads **JSDoc #2**, setting `currentJsDocComment = jsdoc2` (`Parser.java:440`).
3. While the field now holds JSDoc #2, a JSDoc-attaching site for the *first* statement's expression still runs — a `createPropertyExpression` for `.bytes` (`Parser.java:3858`) or `name()`/`assignExpr()`. The positional guard `currentJsDocComment.sourceStart() < pn.start()` is intended to prevent attaching a later comment to an earlier node, **but** the node being decorated (the property expression / its object) starts *before* JSDoc #2, so the `<` check passes in the wrong direction is the suspect: confirm exactly which site (`3863`, `4054`, `3002`) fires and whether the guard comparison is inverted for this case.
4. Result: JSDoc #2 is consumed/attached to a node belonging to statement #1, or (equivalently) is duplicated so that both statement #1's expression and statement #2's `var` end up referencing it — producing the "double JSDoc".

When the reporter adds `;` after `.bytes`, `autoInsertSemicolon()` consumes the explicit `SEMI` (`Parser.java:1572-1577`) at a point *before* JSDoc #2 is scanned, so `currentJsDocComment` is still null/`jsdoc1`-cleared when statement #1 finishes, and JSDoc #2 is only ever seen by statement #2. That is why the `;` is a valid workaround and is the strongest evidence that the leak is caused by look-ahead scanning a later JSDoc into the shared latch before statement #1 fully resolves its documentation.

The implementation task must **confirm the exact leaking site** by tracing the reproduction (temporary logging in `recordComment`, `getAndResetJsDoc`, and the guarded sites at `3863`/`4054`). Do not fix blindly.

## 5. Proposed design

Preferred fix (surgical, minimal blast radius):

- Tighten the positional guards so a JSDoc can only decorate a node when the comment **immediately precedes that node and no intervening statement boundary exists**. Concretely, at the guarded sites (`Parser.java:3863`, `Parser.java:4054`) the comparison should ensure the pending comment starts *after* the previous statement's end (or after the enclosing statement's start), not merely before the current node. A comment scanned during ASI look-ahead for statement #1 belongs to statement #2 and must not be attachable to statement #1's sub-expressions.

Alternative / complementary approaches to evaluate:

- **Reset on statement completion.** After `autoInsertSemicolon()` finishes a statement (both explicit `;` and ASI paths in `Parser.java:1542-1565`), only keep `currentJsDocComment` if it was scanned *before* the statement's source end. If the pending comment starts at/after the just-closed statement's end, it belongs to the next statement and must be preserved for it — the leak is the opposite case, where an already-consumed-or-about-to-be-consumed comment bleeds backward into the finishing statement.
- **Do not let look-ahead over-scan.** Ensure the ASI look-ahead for a var-statement initializer does not eagerly latch a JSDoc that lives beyond the initializer. This is harder and riskier than tightening the guards.

Whichever approach is chosen, the invariant to establish is:

> A JSDoc comment is attachable to a node only if the comment lies between the previous statement's end and that node's start, with no statement terminator (explicit `;` or ASI) in between.

Follow the repo sentinel/position conventions: positions are compared with `>= 0` / `>` and `-1` means "not set"; never treat `0` as unset.

## 6. Files likely to change (implementation task)

| File | Expected change |
|------|-----------------|
| `plugins/org.eclipse.dltk.javascript.parser/src/org/eclipse/dltk/javascript/parser/rhino/Parser.java` | Tighten JSDoc-attachment guards (`~3863`, `~4054`) and/or reset `currentJsDocComment` correctly across statement boundaries in/after `autoInsertSemicolon` (`~1542-1595`). |

No AST node classes, visitors, DOM/EMF, or downstream `core` code are expected to change — this is contained in the parser's comment-latch logic.

## 7. Test cases (parser tests)

Add to `tests/org.eclipse.dltk.javascript.parser.tests/.../TestRhinoParser.java`. These are error-free, valid ES-source cases, so use `getScriptv4(source)` (Rhino parser) and assert on documentation attachment. Do **not** use `equalsJSNode()` — the ANTLR4 parser attaches documentation differently, and this bug is Rhino-specific. Do not hard-code source offsets.

1. `testDoubleJsdoc_missingSemicolon_doesNotLeakToNextVar` — the exact ticket source (two `var`s, first with no `;`, each preceded by its own JSDoc). Assert:
   - statement #1's variable/statement documentation text contains the first `@properties` uuid `70CFCBF9`.
   - statement #2's variable/statement documentation text contains the second uuid `7D4D9708` and `@type {String}`.
   - statement #1's documentation does **not** contain the second uuid (no leak), and statement #2's documentation does **not** contain the first uuid.
2. `testDoubleJsdoc_withSemicolon_stillCorrect` — same source but with the `;` after `.bytes`; assert the same per-statement ownership (guards against a regression that breaks the already-working path).
3. `testJsdoc_singleVarNoSemicolon_propertyAccessInitializer` — minimal `/** a */\nvar x = obj.prop\n/** b */\nvar y` to isolate the property-expression path (`createPropertyExpression`) as the suspected leak site.

Assert documentation by reading `getDocumentation().getText()` on the appropriate node. Resolve the node with the standard cast pattern: the `var` statement is reached via `script.getStatements()`, then `IVariableStatement` / its bindings (see `specs/ast-api-patterns.md`).

## 8. Acceptance criteria

- [ ] Root leak site confirmed by tracing before any code change.
- [ ] The ticket's source (no `;` after `.bytes`) parses with JSDoc #1 attached only to statement #1 and JSDoc #2 attached only to statement #2 — no duplication.
- [ ] The `;`-terminated variant still parses correctly (no regression).
- [ ] All existing parser tests (`TestRhinoParser` / `AllTests`) remain at 0 failures, 0 errors.
- [ ] No changes required outside `Parser.java` (parser plugin).

## 9. Out of scope

- Changing the ANTLR4 parser's documentation attachment (`JSTransformer.locateDocumentation`, `Parser.java` is the Rhino path targeted here).
- Reworking `currentJsDocComment` into a per-scope stack (larger refactor); only do this if the surgical guard fix proves insufficient.
- Any change to how JSDoc is persisted/serialized in the Servoy model layer.
