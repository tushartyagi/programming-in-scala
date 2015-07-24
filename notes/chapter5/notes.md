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


