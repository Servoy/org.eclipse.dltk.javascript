# Spec: SVY-21221 — Add type support in Array.sort()

## 1. Goal

Provide full type inference for the comparator callback parameters in `Array.sort()` and `Array.toSorted()`, so that when a developer writes `myTypedArray.sort((a, b) => ...)`, the parameters `a` and `b` are correctly typed as the array's element type. This brings `sort` in line with `map`, `filter`, `forEach`, `find`, and other array methods that already have proper type support.

## 2. Background

### 2.1 Current type inference for array callbacks

The DLTK type inferencer resolves callback parameter types for array methods through two mechanisms:

1. **`parseFunctionTypes()`** in `TypeInferencerVisitor` (line 714–740): When visiting a call expression, this method inspects the called method's parameter definitions. If a parameter's type is an `IRFunctionType`, the function type is stored in a map keyed by the callback AST node. Later, when the callback (arrow function or function expression) is visited, its parameters receive types from the stored `IRFunctionType`.

2. **Parameterized type resolution**: `RParameterizedTypeDeclaration` implements `ITypeSystem.getTypeVariable()` which resolves `TypeVariableReference` instances (like `@ROOT/Array/E`) to concrete types based on the array's actual element type.

### 2.2 How `filter` works (reference)

In `native-references.xml`, `filter`'s callback is declared as a proper `FunctionType`:

```xml
<parameters name="callback">
  <type xsi:type="ref:FunctionType">
    <parameters name="elementValue">
      <type xsi:type="ref:TypeVariableReference" variable="@ROOT/Array/E"/>
    </parameters>
    ...
  </type>
</parameters>
```

This allows `parseFunctionTypes()` to detect the `IRFunctionType` and propagate the element type to the callback's parameters.

### 2.3 How `sort` currently fails

In `native-references.xml`, `sort`'s comparator is declared as:

```xml
<parameters name="sortByFunction" directType="Function" kind="OPTIONAL"/>
```

`directType="Function"` produces a plain type reference, NOT an `IRFunctionType`. Therefore `parseFunctionTypes()` does not detect it, and the callback parameters `a` and `b` remain untyped.

The same issue exists for `toSorted`'s comparator parameter (line 502):

```xml
<parameters name="comparator" directType="Function"/>
```

## 3. Design

### 3.1 Change `sort` callback definition

Replace the plain `directType="Function"` parameter with a proper `FunctionType` element that declares two parameters typed with `TypeVariableReference` to `@ROOT/Array/E`. The comparator returns a `Number` (negative, zero, or positive).

### 3.2 Change `toSorted` callback definition

Merge the two `toSorted` overloads (no-arg + comparator) into a single method with `kind="OPTIONAL"` on the comparator parameter. This matches the `sort` pattern and fixes both type inference and template completion (the two-overload approach caused the DLTK engine to match the no-arg overload first, losing type info).

### 3.3 Return type (no change needed)

The return type of `sort` already correctly uses:
```xml
<type xsi:type="ref:ArrayType">
  <itemType xsi:type="ref:TypeVariableReference" variable="@ROOT/Array/E"/>
</type>
```

This is resolved by `RParameterizedTypeDeclaration.getTypeVariable()` when the array is parameterized. No additional changes are needed for the return type.

### 3.4 No changes to TypeInferencerVisitor

The existing `parseFunctionTypes()` mechanism will handle the new `FunctionType` definition automatically — no special-case code is needed for `sort` in `checkSpecialJavascriptFunctionCalls()`.

### 3.5 Git history: TypeVariableReference in return types

Commit `ea7b087` ("remove for now the generic type array (just return plain) for map and flatmap") removed `<itemType xsi:type="ref:TypeVariableReference" variable="@ROOT/Array/E"/>` from the return types of `map` and `flatmap`. The follow-up `3a6e036` ("reduce is the same as map … for now return Object") did the same for `reduce`. This was a temporary workaround related to SVY-20811's warning checks when "Any" types of the argument are not seen as always good.

**Important distinction:** only the *return-type* generics were reverted. The *callback parameter* typing (using `TypeVariableReference` inside a `FunctionType`) remains in place for `find`, `filter`, `forEach`, and others (lines 415–425). Our change follows the same pattern — adding `TypeVariableReference` to callback parameters, not modifying return types — so the same issue should not apply.

**Risk:** If the SVY-20811 warning logic is later extended to also flag callback parameter types resolved via `TypeVariableReference`, the same "Any type" warnings could surface for sort/toSorted callbacks. Monitor after implementation.

## 4. Implementation plan

1. **Modify `org.eclipse.dltk.javascript.core/resources/native-references.xml`** — Replace the `sort` method's parameter definition (line 410):

   From:
   ```xml
   <parameters name="sortByFunction" directType="Function" kind="OPTIONAL"/>
   ```

   To:
   ```xml
   <parameters name="sortByFunction" kind="OPTIONAL">
     <type xsi:type="ref:FunctionType" directType="Number">
       <parameters name="a" description="The first element for comparison.">
         <type xsi:type="ref:TypeVariableReference" variable="@ROOT/Array/E"/>
       </parameters>
       <parameters name="b" description="The second element for comparison.">
         <type xsi:type="ref:TypeVariableReference" variable="@ROOT/Array/E"/>
       </parameters>
     </type>
   </parameters>
   ```

2. **Merge `toSorted` two overloads into one** — Remove the no-arg overload and the separate comparator overload. Replace with a single method with `kind="OPTIONAL"` on the comparator parameter (matching the `sort` pattern). This fixes both type inference and template completion.

   From:
   ```xml
   <members xsi:type="ref:Method" name="toSorted" description="...">
       <type xsi:type="ref:ArrayType">...</type>
   </members>
   <members xsi:type="ref:Method" name="toSorted" description="...">
       <parameters name="comparator" directType="Function"/>
       <type xsi:type="ref:ArrayType">...</type>
   </members>
   ```

   To:
   ```xml
   <members xsi:type="ref:Method" name="toSorted" description="Returns a new array with the elements sorted in ascending order.">
       <parameters name="comparator" kind="OPTIONAL">
         <type xsi:type="ref:FunctionType" directType="Number">
           <parameters name="a" description="The first element for comparison.">
             <type xsi:type="ref:TypeVariableReference" variable="@ROOT/Array/E"/>
           </parameters>
           <parameters name="b" description="The second element for comparison.">
             <type xsi:type="ref:TypeVariableReference" variable="@ROOT/Array/E"/>
           </parameters>
         </type>
       </parameters>
       <type xsi:type="ref:ArrayType">
           <itemType xsi:type="ref:TypeVariableReference" variable="@ROOT/Array/E"/>
       </type>
   </members>
   ```

3. **Verify** — Confirm that:
   - Code completion inside `sort((a, b) => ...)` shows the correct element type for `a` and `b`
   - The return type of `sort()` is still correctly resolved as a typed array
   - No regressions in existing `filter`/`map`/`forEach` type resolution

## 5. Acceptance criteria

- [ ] `Array<SomeType>.sort((a, b) => ...)` — parameters `a` and `b` are inferred as `SomeType`
- [ ] `Array<SomeType>.toSorted((a, b) => ...)` — parameters `a` and `b` are inferred as `SomeType`
- [ ] Code completion on `a.` and `b.` inside the sort comparator shows members of the element type
- [ ] The return type of `.sort()` is correctly inferred as `Array<SomeType>`
- [ ] No regressions in type inference for `map`, `filter`, `forEach`, `find`, `reduce`, and other array methods

## 6. Out of scope

- Adding type support for other untyped callback parameters (e.g., `setTimeout`, `setInterval`)
- Changing the runtime behavior of sort in the Rhino engine
- Adding overload variants of sort (e.g., typed sort with key extractor)

## 7. Open questions

| Question | Owner | Status |
|----------|-------|--------|
| Should the FunctionType for sort's comparator declare a return type of `Number` via `directType` attribute, or leave it untyped? Other comparator patterns may return any value. | Dev | open |
| Should `toSorted` without a comparator also have its no-arg form validated for type propagation? | Dev | open |
