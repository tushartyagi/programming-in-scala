

* Allows the nesting of the functions, and hence closures.
* The usual notation for anonymous functions
``` (x: Int) = x > 0 ```
* **target typing** is present, which allows the param type to
be inferred from the applied expression.
``` intList.foreach((x) => x > 0) ``` will infer that the param has
to be an int.
* Even the parans around the param can be removed:
``` intList.foreach(x => x > 0) ```
* Placeholder syntax allows to have an underscore in place of the
params. 
``` intList.foreach(_ > 0) ```
There are two caveats while using this syntax:
1. There can be more than one _ in the call, and each one is different:
``` intPair.foreach((x, y) => x + y > 0) ```
``` intPair.foreach(_ + _ > 0)```
2. The order of the _s matter.
* Partially Applied Functions
Using the syntax of partially applied functions, we create a reference
to an existing function.
```
def sum(a: Int, b: Int) = a + b
val add1 = sum(1, _: Int)
add1 12 // 13
val add2 = sum(2, _: Int)
add2 12 // 14
val add  = sum _
add 12 13 // 25
```
When using this syntax, the compiler uses the `apply` method on add*
functions and fill in the required params.

