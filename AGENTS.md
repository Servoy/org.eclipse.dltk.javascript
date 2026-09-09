# AGENTS.md - DLTK JavaScript (Servoy Fork)

## Project Overview

Servoy fork of Eclipse DLTK JavaScript -- an Eclipse-based JavaScript tooling platform (parsing, type inference, code completion, debugging). Includes a forked Mozilla Rhino engine adapted for IDE use.

- Build: Maven/Tycho `4.0.12`
- Java: 21 (`maven.compiler.source/target=21`, Tycho `useJDK=BREE`)
- Version: `5.1.1-SNAPSHOT`
- Base: Eclipse DLTK (Dynamic Languages Toolkit)

## Building & Testing

- Tests are run through the Eclipse IDE MCP tool, NOT via `mvn test`. Use `eclipse-ide_runClassTests`:
  ```
  eclipse-ide_runClassTests(projectName="org.eclipse.dltk.javascript.parser.tests", className="org.eclipse.dltk.javascript.parser.tests.TestRhinoParser")
  ```
  Coverage: add `withCoverage=true`, `classFilter="...rhino.Parser"`, `timeout=240`.
- Maven build needs the target platform defined by `launch_target/org.eclipse.dltk.javascript.launch_target.target`. The root reactor consumes it via `target-platform-configuration`.
- Root reactor `pom.xml` only builds a subset: `core`, `core.manipulation`, `debug`, `debug.ui`, `jsjdtdebugger`, `formatter`, `launching`, `parser`, `ui`, the feature, and `repository.site`. It does NOT build `rhino`, `nodejs`, `jdt.integration*`, `core.dom.support`, `rhino.dbgp`, or the `tests/` tree. Those are separate modules built on their own.
- Environments: win32/macosx/linux, all x86_64.

## Layout

- `plugins/` -- production bundles.
- `tests/` -- separate reactor (`tests/pom.xml`) with `core.tests`, `formatter.tests`, `parser.tests`, `ui.tests`.
- `features/`, `repository.site`, `update.site` -- packaging/p2.
- `launch_target/` -- Tycho target definition.

### Key plugins
| Module | Purpose |
|--------|---------|
| `parser` | JS parser (Rhino-based + ANTLR4), emits DLTK AST directly (no post-parse conversion) |
| `rhino` | Forked Mozilla Rhino engine (compilation, IR, bytecode) |
| `core` | DLTK integration (type inference, model, indexing) |
| `ui` | Editor, content assist, outline |
| `debug`, `debug.ui`, `jsjdtdebugger` | Debugger integration |
| `formatter`, `launching`, `nodejs` | Formatter, launch configs, Node.js |

## Key Classes

Parser layer (`org.eclipse.dltk.javascript.parser`):
- `parser.rhino.Parser` -- main Rhino-based parser, emits DLTK AST (`Script`, `FunctionStatement`, ...)
- `parser.rhino.JavaScriptParser` -- high-level wrapper; `parse(source, reporter)` returns `IProblem[]`
- `ast.*` -- DLTK AST nodes (canonical package). Prefer `ast.*` over `ast.v4.*` for imports.

Rhino engine (`org.eclipse.dltk.javascript.rhino`):
- `org.mozilla.javascript.Parser` -- upstream Rhino parser (Rhino AST)
- `org.mozilla.javascript.IRFactory` -- Rhino AST -> IR
- `org.mozilla.javascript.Node` -- Rhino IR node

## Parser / Test Conventions (non-obvious)

- Position/offset "not set" sentinel is `-1`, never `0` (0 is a valid source position). Guards use `>= 0` / `> sourceStart()`. Follow this in new AST nodes and assertions.
- Test parser helpers in `TestRhinoParser`: `getScript(source)` (ANTLR4), `getScriptv4(source)` (Rhino), `equalsJSNode(...)` (always wrap in `assertTrue`), `makeParser(...)`.
- Never call `getScriptv4()` in error-recovery tests -- it calls `println(script)` -> `toSourceString()` on malformed nodes. Use `new JavaScriptParser().parse(source, null)` instead.
- Do NOT hard-code source positions in assertions; use relational checks.
- Function declarations are wrapped: `script.getStatements().get(0).getChilds().get(0)` -> `FunctionStatement` (not the `VoidExpression` path). Expressions ARE wrapped in `VoidExpression`.
- Unsupported constructs (must NOT be merged or used in test source): `async`/`await`, `class`, class fields, `import`/`export`, generators/`yield`, dynamic `import()`, `"use strict"`. `compilerEnv.isStrictMode()` always returns `false`. See `plugins/org.eclipse.dltk.javascript.parser/specs/unsupported-features.md`.

## Skills & Specs (read when relevant)

- `plugins/org.eclipse.dltk.javascript.parser/skills/MERGING.md` -- methodology for merging upstream Rhino upgrades into the DLTK parser.
- `tests/org.eclipse.dltk.javascript.parser.tests/skills/INCREASE_CODE_COVERAGE.md` -- coverage-improvement loop.
- `tests/org.eclipse.dltk.javascript.parser.tests/specs/ast-api-patterns.md` -- AST cast rules, known API mistakes.
- `tests/org.eclipse.dltk.javascript.parser.tests/specs/coverage-targets.md` -- blocked/high-value coverage targets.

## Spec / Design Documents

Feature specs live in `docs/` (repo root) and per-plugin `docs/`. Name: `<JIRA-KEY>-<slug>.spec.md`.

## Code Style & Conventions

- Java indentation: tabs.
- Line endings: CRLF (Windows).
- Commit messages: `<JIRA_KEY> <short description> [ai]` when AI-generated.
