# Case Classes And Pattern Matching

* Case classes allow pattern matching on objects without boilerplate code.
* These are defined using the `case` keyword.
* Features:
+ Compiler adds factory methods so no need of using `new`
+ All the arguments of the case class are defined as `val` and are therefore,
fields.
+ `toString`, `hashCode`, and `equals` are created for free, and these methods
are applied to the whole tree recursively.
+ `copy` method is added as well, which can create modified copies of a given
case class. So instead of providing all the values, we can provide only a
few using named parameters, and the rest are picked from the object being
copied.

