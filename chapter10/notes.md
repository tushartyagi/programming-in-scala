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

