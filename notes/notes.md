Chapter 3
==========

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

Chapter 4
=====

## Classes

* Members are `public` by default.
* Method params are `val` and hence cannot be changed inside the method body.
* When there is no return statement, the last expression calculated is returned. So think of methods
as an expression that calculates a single value that is returned.
* A method which is primarily used for side effect is called a procedure.
* A method can be turned into a procedure by remove the return type and equal sign,
and wrapping the body in braces. Removing the return type will always return `Unit`
which can be a gotcha. Removing the equal sign will always return `Unit`

```
// This value isn't returned when method is called
def f() { "This string gets lost" }
// same thing happens here because the return type is
// explicit (Unit)
def g(): Unit = "This string gets lost"
// this value is returned when method is called
def h() = { "This string is not lost" }
```

## Singleton Objects
Singletons provide the same functionality as static classes.
By definition, a singleton is an object which is unique throughout the
application and every call results in the same object being returned.

These have the same body as a class but uses the `object` keyword.

A singleton object and class sharing the same name are called each others
*companion*. Companions can access each others private members. A singleton
without the companion is called *standalone* object.

Creating a singleton doesn't add a new type to the application. The type
has to come from the companion class.

Singleton objects cannot take parameters, because it is not initialised
using `new` keyword but when it is used for the first time.

Chapter 5
===========

# Operators

* Language supports all the three arrangements, pre, post, and infix operators.
* Only +, -, !, and ~ can be used as prefix operators.
* Conventionally, the parenthesis are left out if the method does not have side
effect, e.g. s.toLowerCase where s is String

* == method first checks the left operand for null and then calls the `equals()`
* `equals` checks for the content based equality. `eq` and `ne` check for
reference based equality.

## Operator Precedence and Associativity
Since the operators are methods in scala, the language has defined name based
rules:
1. Precedence depends on the first character of the method name, e.g. a
method whose name starts with * will have higher precedence than whose name
starts with + or -. 
2. If the name of the operator ends with a =, and it is not one of the
comparision operators, then the precedence will be equal to the = operator.
3. Associativity depends on the last character of the method name. Any method
that ends with `:` is right associative, and the reverse is true for others.
Hence 3 * 4 is a method on 3, but 2 :: 4 is a method on 4.
4. No matter what the associativity of an operator is, the left operand is
always evaluated first, e.g. a ::: b is evaluated as
```
{ var x = a; b.:::(a) }
```

Chapter 6
============

# Functional Objects

* Objects which don't mutate
* Class definition can take parameters in Scala and the code which is
outside the method definition and field becomes the part of the
primary constructor.
* While the primary constructor is free, we can define "auxillary
constructor". The first step of any auxillary constructor is to call
another constructor of the class; this can be either primary or another
auxillary.
* Only the primary constructor can call the superclass constructor.

Chapter 7
============

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

Chapter 8
============

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

Chapter 10
============

# Composition and Inheritance

* *Combinators* allow to combine the elements of some different domains into
new elements.
* A method that doesn't have a body is taken to be abstract and this
qualifier isn't required.
* By following the *uniform access principle* (which says that the client
implementation should not depend on the field being a field or a method),
Scala provides both parameterless methods and empty-parens methods.
+ Parameterless methods are used when:
1. There are no parameters in the method call
2. Method only accesses the fields of the containing object, which means:
3. There are no side-effects of the method
UAP is followed here since if the attribute changes from a method to a field,
or vice versa, then there will be no change in the client code.
For instance, the following code will be unaffected in case the implementation
changes:

```
var x = someClass.value

class someClass {
// None of the approaches will break the client code
def value = ...
// val value = ...
}

```

+ Empty params method are to be used when there may be side effects of
calling that method.

```
someClass.changeSomething()
```

"aoeuao".length
println()

* Subtyping is allowed, so that the subtypes can be assigned to the supertype.
```val a: Animal = new Giraffe()```

* Due to UAP and methods and fields sharing the same namespace, the subclasses
can have fields that can override the *parameterless* methods in the parent
class.

Chapter 12
=========

Traits have the body like that of classes but are a clever way of providing multiple inheritance.

* Thin Interface: An interface providing small number of methods. The load on implementors is less since they have to implement minimal methods.
* Rich Interface: An interface providing large number of methods. The load on implementors is more since they have to implement many methods.

Traits provide the middle ground. All the methods of the rich interface can be implemented in the trait itself, and others can be left as abstract. So the users can have a lot more functionality with minimal coding.


Chapter 15
=========

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