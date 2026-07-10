# AGENTS.md - DLTK JavaScript (Servoy Fork)

## Project Overview

This is the **Servoy fork of Eclipse DLTK JavaScript** — an Eclipse-based JavaScript tooling platform providing parsing, type inference, code completion, and debugging support. It includes a forked Rhino engine adapted for IDE use.

- **Build system:** Maven/Tycho
- **Java version:** 21
- **Base:** Eclipse DLTK (Dynamic Languages Toolkit)

## Project Structure

### Plugins
| Module | Purpose |
|--------|---------|
| `org.eclipse.dltk.javascript.parser` | JavaScript parser (Rhino-based + ANTLR4), produces DLTK AST |
| `org.eclipse.dltk.javascript.rhino` | Forked Mozilla Rhino engine (compilation, IR, bytecode) |
| `org.eclipse.dltk.javascript.core` | Core DLTK integration (type inference, model, indexing) |
| `org.eclipse.dltk.javascript.ui` | Editor, content assist, outline |
| `org.eclipse.dltk.javascript.debug` | Debugger integration |
| `org.eclipse.dltk.javascript.formatter` | Code formatter |
| `org.eclipse.dltk.javascript.launching` | Launch configurations |
| `org.eclipse.dltk.javascript.nodejs` | Node.js support |

### Tests
| Module | Purpose |
|--------|---------|
| `org.eclipse.dltk.javascript.parser.tests` | Parser unit tests (`TestRhinoParser`, `TestANTLR4Parser`) |
| `org.eclipse.dltk.javascript.core.tests` | Core/type inference tests |
| `org.eclipse.dltk.javascript.formatter.tests` | Formatter tests |
| `org.eclipse.dltk.javascript.ui.tests` | UI tests |

## Key Classes

### Parser Layer (`org.eclipse.dltk.javascript.parser`)
- `org.eclipse.dltk.javascript.parser.rhino.Parser` — Main Rhino-based parser, produces DLTK AST (`Script`, `FunctionStatement`, etc.)
- `org.eclipse.dltk.javascript.parser.rhino.JavaScriptParser` — High-level parser wrapper
- `org.eclipse.dltk.javascript.ast.*` — DLTK AST node classes
- `org.eclipse.dltk.javascript.ast.v4.*` — Additional AST nodes (arrow functions, etc.)

### Rhino Engine (`org.eclipse.dltk.javascript.rhino`)
- `org.mozilla.javascript.Parser` — Upstream Rhino parser (produces Rhino AST)
- `org.mozilla.javascript.IRFactory` — Transforms Rhino AST to IR for compilation
- `org.mozilla.javascript.Node` — Rhino IR node

## Testing

Run parser tests:
```
eclipse-ide_runClassTests(projectName="org.eclipse.dltk.javascript.parser.tests", className="org.eclipse.dltk.javascript.parser.tests.TestRhinoParser")
```

Test patterns in `TestRhinoParser`:
- `getScript(source)` — parse via DLTK-level JavaScriptParser
- `getScriptv4(source)` — parse via Rhino-level JavaScriptParser
- `makeParser(source, warnTrailingComma, collector)` — low-level Rhino Parser with error collection

## Spec / Design Documents

Feature specs live in `docs/` at the repository root:
- Name files: `docs/<JIRA-KEY>-<slug>.spec.md`

## Code Style & Conventions

- Follow existing code style (tabs for indentation in Java)
- Line endings: CRLF (Windows)
- Commit messages: `<JIRA_KEY> <short description> [ai]` when AI-generated
