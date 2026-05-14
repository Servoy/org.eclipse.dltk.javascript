# AST API Patterns — Quick Reference

Read this file when writing new test methods or when a cast is failing.

---

## Which Parser Helper to Use

| Situation | Use |
|---|---|
| Feature supported by both parsers (most pre-ES6 syntax) | `getScript()` + `getScriptv4()` + `equalsJSNode()` |
| ES6+ feature, or Rhino-only feature (destructuring, XML/E4X) | `getScriptv4()` only — no `equalsJSNode()` |
| Error / recovery test | `new JavaScriptParser().parse(source, null)` directly |

**Rule:** `equalsJSNode()` must always be asserted: `assertTrue(equalsJSNode(...))`.
Never call it without asserting the return value.

**Rule:** Never use `getScriptv4()` in error-recovery tests — it calls `println(script)`
which invokes `toSourceString()` on potentially malformed AST nodes.

---

## Cast Rules by Node Type

### Function declarations
```java
// CORRECT — function declarations are wrapped; use getChilds().get(0)
FunctionStatement func =
    (FunctionStatement) script.getStatements().get(0).getChilds().get(0);

// WRONG — do not use VoidExpression path for function declarations
// (FunctionStatement) ((VoidExpression) script.getStatements().get(0)).getExpression()
```

### Arrow functions
```java
ASTNode stmt = script.getStatements().get(0);
assertTrue(stmt.getChilds().get(0) instanceof ArrowFunctionStatement);
ArrowFunctionStatement fn = (ArrowFunctionStatement) stmt.getChilds().get(0);
```

### Expressions (variable statements, calls, binary ops)
These ARE wrapped in `VoidExpression`:
```java
VariableStatement vs = (VariableStatement)
    ((VoidExpression) script.getStatements().get(0)).getExpression();
CallExpression call = (CallExpression)
    ((VoidExpression) script.getStatements().get(0)).getExpression();
BinaryOperation op = (BinaryOperation)
    ((VoidExpression) script.getStatements().get(0)).getExpression();
```

### Variable declarations (`let`, `const`, `var`)
```java
IVariableStatement vs = (IVariableStatement)
    ((VoidExpression) scriptv4.getStatements().get(0)).getExpression();
List<IVariableDeclaration> decls = vs.getVariables();
assertEquals("x", decls.get(0).getVariableName());
```

---

## Source Position Assertions

For position fields that may legitimately be at offset 0, use relational guards:
```java
assertTrue(node.sourceStart() >= 0);
assertTrue(node.sourceEnd() > node.sourceStart());
```
Do **not** hard-code expected positions (e.g. `assertEquals(10, node.sourceStart())`);
positions shift when test source strings change.

---

## Error Reporting Tests

```java
@Test
public void testSomething_reportsError() {
    org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser parser =
        new org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser();
    IProblem[] problems = parser.parse("bad source here", null);
    assertTrue(problems.length > 0);
}
```
Or use the `makeParser` / `makeParserStrict` helpers already present in `TestRhinoParser`.

---

## Common Imports

```java
import org.eclipse.dltk.javascript.ast.*;
import org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser;
import java.util.ArrayDeque;
import java.util.List;
```

Eclipse auto-organizes imports with Ctrl+Shift+O.

---

## Known API Mistakes (from historical failures)

| Wrong | Correct |
|---|---|
| `script.getStatements().get(0)` → cast to `FunctionStatement` | `.get(0).getChilds().get(0)` |
| `getFinally().getKeyword()` | `getFinally().getFinallyKeyword()` |
| `getCaseClauses()` → `List<CaseClause>` | Returns `List<SwitchComponent>`; cast individual elements |
| `getIdentifiers()` on `DestructuringVariableDeclaration` → binding names | Returns **pattern keys** |
