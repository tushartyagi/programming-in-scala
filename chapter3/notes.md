A `val` cannot have its value changed and in cases it refers to an object, the objects value may change
but not the binding of `val` variable and the object.

Mathematical operators like `+`, `-`, etc. are methods in scala. An operation like 1 + 2 means (1).+(2)

Arrays use () instead of [] for indexing because this again expands to `apply` method. Any class that has
defined an `apply` method can use this notation.
Therefore, array(12) changes to array.apply(12) and the definition of apply in this class is implemented
such that it returns the value at that index.
Similarly, the assignment using parenthesis calls the `update` method:
array(12) = value converts to array.update(12, value)


Arrays are mutable in scala, and Lists are immutable (unlike `java.util.List` which is mutable) and hence
apply the idea of functional programming.
`val list = List(1, 2, 3)`
Because of this, the methods on List always return a new list.
`:::` the concatenation method, and `::` the cons (yup) method return new lists.

One new (and a bit weird) thing is that if a method's name ends with a `:` then the method belongs to the
right object, as in the case of concatenation and cons methods above.

## Tuples
Immutable data structure that can contain different data types. This is a bit different than
the tuples that we have in python since there's no concept of types in python.

The type of tuple depends on the number of element it contains, so the tuple (1, "1234") is
Tuple2[Int, String]
Accessing the elements is by `.` followed by `_` followed by index that starts from 1.
```
val tup = (1, "1234")
> tup._1
1
> tup._2
"1234"
```
We cannot use the `apply` method on tuples since it always returns same data type and tuple can
contain different data types.

