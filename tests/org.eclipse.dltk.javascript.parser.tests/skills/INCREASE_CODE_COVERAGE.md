---
name: rhino-parser-coverage
description: >
  Workflow for adding JUnit tests to increase line and branch coverage of
  org.eclipse.dltk.javascript.parser.rhino.Parser. Use this skill whenever
  the user asks to improve test coverage of the Rhino parser, add tests to
  TestRhinoParser, find uncovered parser paths, or reduce missed lines/branches
  in the DLTK JavaScript parser. Trigger even for partial requests like "what
  parser code is untested" or "write a test for optional chaining".
compatibility:
  tools:
    - eclipse-ide_runClassTests
    - eclipse-ide_readProjectResource
---

# Increasing Unit Test Coverage: Rhino JavaScript Parser

## Key Files

| Role | Path |
|---|---|
| Test class | `tests/org.eclipse.dltk.javascript.parser.tests/src/org/eclipse/dltk/javascript/parser/tests/TestRhinoParser.java` |
| Parser under test | `plugins/org.eclipse.dltk.javascript.parser/src/org/eclipse/dltk/javascript/parser/rhino/Parser.java` |
| Unsupported features spec | `plugins/org.eclipse.dltk.javascript.parser/specs/unsupported-features.md` |

---

## The Loop

Repeat this cycle until coverage plateaus or only blocked paths remain.

```
Run with coverage → Extract Parser.java gaps → Read uncovered lines
→ Check for duplicates → Write tests → Run again → Confirm gains
```

**Stop condition:** When `lines.nocovered` for `Parser.java` stops shrinking
between iterations, or all remaining lines are in blocked paths
(see [`specs/coverage-targets.md`](specs/coverage-targets.md)).

**Session target:** Aim to eliminate at least 20–30 uncovered lines per
iteration before re-running. Smaller batches are fine for tricky branches.

---

## Step 1 — Run Tests with Coverage

```
eclipse-ide_runClassTests(
  projectName  = "org.eclipse.dltk.javascript.parser.tests",
  className    = "org.eclipse.dltk.javascript.parser.tests.TestRhinoParser",
  withCoverage = true,
  classFilter  = "org.eclipse.dltk.javascript.parser.rhino.Parser",
  timeout      = 240
)
```

**Before writing any tests, confirm 0 failures and 0 errors.** If tests are
already failing, stop and fix the failures before proceeding — do not add new
tests on top of a broken baseline.

---

## Step 2 — Extract the Coverage Gap

The response is large (100k+ bytes) and will be truncated. The full output is
saved to a temp file shown in the response. Extract the `Parser.java` entry:

```powershell
# Find the line number of the Parser.java entry
Select-String -Path "<temp-file>" -Pattern '"Parser\.java"'

# Read around that line (adjust offset as needed)
Read <temp-file> offset=<line-number - 5> limit=40
```

If `Select-String` returns multiple hits, look for the one with package
`org.eclipse.dltk.javascript.parser.rhino`.

The entry looks like:
```json
{
  "sourcefile": "Parser.java",
  "package": "org.eclipse.dltk.javascript.parser.rhino",
  "lines": {
    "nocovered":        [233, 259, 273, ...],
    "partiallycovered": [232, 258, 264, ...]
  },
  "branch": {
    "nocovered":        [291, 293, ...],
    "partiallycovered": [232, 258, ...]
  }
}
```

Work from `lines.nocovered` first (completely untouched lines), then
`branch.nocovered` (lines reached but with untaken branches).

---

## Step 3 — Identify What to Test

For each cluster of uncovered line numbers:

1. Read those lines in `Parser.java`:
   ```
   eclipse-ide_readProjectResource(
     path           = "plugins/org.eclipse.dltk.javascript.parser/src/org/eclipse/dltk/javascript/parser/rhino/Parser.java",
     showLineNumbers = true,
     startLine      = <first uncovered line - 5>,
     endLine        = <last uncovered line + 5>
   )
   ```

2. Before writing a test, check whether a test already covers this path:
   ```
   eclipse-ide_readProjectResource(
     path = "tests/.../TestRhinoParser.java",
     showLineNumbers = true
   )
   ```
   Search for the source string or method name you'd use.

3. Check whether the path is permanently blocked — look it up in
   [`specs/coverage-targets.md`](specs/coverage-targets.md)
   under "Permanently Blocked Paths". If it's blocked, skip it and move
   to the next cluster.

4. Check whether the construct is unsupported (no `async`, `class`, etc.) —
   see `MERGING.md` or the `rhino-dltk-merge` skill's
   `plugins/org.eclipse.dltk.javascript.parser/specs/unsupported-features.md`.

**Prioritization:** When multiple clusters are available, pick the one with the
most uncovered lines first. The high-value targets list in
[`specs/coverage-targets.md`](specs/coverage-targets.md)
gives good starting points.

---

## Step 4 — Write the Tests

### Standard two-parser test (most cases)

```java
@Test
public void testMyFeature() {
    String source = "var x = 1;";
    Script script   = getScript(source);   // ANTLR4-based parser
    Script scriptv4 = getScriptv4(source); // Rhino parser
    assertNotNull(script);
    assertNotNull(scriptv4);
    assertTrue(equalsJSNode(script, scriptv4, new ArrayDeque<>()));
    // further assertions on structure, positions, etc.
}
```

### Rhino-only test (ES6+, destructuring, XML/E4X)

```java
@Test
public void testMyRhinoFeature() {
    Script scriptv4 = getScriptv4("let [a, b] = arr;");
    assertNotNull(scriptv4);
    // assertions on scriptv4 only — no equalsJSNode
}
```

### Error / recovery test

```java
@Test
public void testBadSyntax_reportsError() {
    org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser parser =
        new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
    IProblem[] problems = parser.parse("bad code here", null);
    assertTrue(problems.length > 0);
}
```

**Decision table — which pattern to use:**

| Situation | Pattern |
|---|---|
| Pre-ES6 syntax, both parsers support it | Two-parser + `equalsJSNode()` |
| ES6+ syntax or Rhino-only feature | Rhino-only (no `equalsJSNode()`) |
| Testing that bad source produces an error | Error reporting test |

For cast rules, position assertion style, and common imports, see
[`specs/ast-api-patterns.md`](specs/ast-api-patterns.md).

### Hard rules for new tests

- Do NOT introduce duplicate `@Test` method names.
- Do NOT use forbidden constructs in source strings (check `MERGING.md`).
- Do NOT hard-code source positions — use relational assertions
  (`>= 0`, `> sourceStart()`).
- `equalsJSNode()` return value must always be asserted with `assertTrue(...)`.

---

## Step 5 — Verify Gains

Re-run with `withCoverage=true` and re-extract the `Parser.java` entry.
Compare `lines.nocovered` count before and after. If the count did not shrink:

- Check that the test method was actually compiled and picked up (no silent
  compile errors).
- Check that the source string you wrote actually exercises the intended code
  path — add a temporary `System.out.println` or read the parser source again
  to trace the path.
- If the line is truly unreachable via source strings, add it to your local
  blocked-paths list and move on.

---

## Constraints Summary

- **0 failures, 0 errors** must be maintained at all times.
- Do not write tests that duplicate the behavior already covered by an existing test.
- No forbidden constructs in test source strings.
- Do not modify existing tests (unless they have a compile error from an API
  change — in that case, look up the correct API in the AST node source, don't
  guess).
- `equalsJSNode()` must always be asserted, never called bare.

---

## Reference Files

| File | When to read |
|---|---|
| [`specs/ast-api-patterns.md`](specs/ast-api-patterns.md) | When casting AST nodes, choosing which parser helper to use, or writing position assertions |
| [`specs/coverage-targets.md`](specs/coverage-targets.md) | When prioritizing which uncovered lines to pursue; when deciding whether a path is permanently blocked |
