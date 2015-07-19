# Control Structures

* `if` is an expression in Scala and hence returns a value.
* `while` and `do while` are loops and do not return any value.
* Unlike C, the assignment operator doesn't return the value of the RHS,
but instead returns `Unit` or `()`
* Challenge the while loops in your code, use some other construct.
* Usage of `for` loop:
1. Iterate through collections:
```
for(file <- fileArray) ...
for(i <- 1 to 10) ...
for(i <- 1 until 11) ...
```
2. Filter through values:
```
for(file <- fileArray
if file.isFile
if file.getName.endsWith(".scala")) ...
```
3. Nested Iteration
We can use both curly braces and parens in the body of the `for` loop.
Nesting is done by introducing additional <- in the body of the loop.
The nesting variables introduced are accessible in the loop body.
Additional variables can be introduced by assignment operator.
```
for {
file <- fileArray
if file.isFile
if file.getName.endsWith(".scala")
line <- fileLines(file)
trimmed = line.trim
} ...
```
4. Creating Collections
This is done using the `yield` keyword -- and this has to come before the
entire body of the loop and, if there are curly braces outside of these.
```
for { 
// some condition 
}
yield {
// do something with the values here
}
```
* Match expressions are what scala offers in case of switch and it, by
default, returns the value of the matched statement.

* Scala allows to add variables of the same name as in the outer scope, and
hides the outer variable by shadowing.


