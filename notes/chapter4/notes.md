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

