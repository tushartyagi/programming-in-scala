## Classes

Members are `public` by default.
Method params are `val` and hence cannot be changed inside the method body.
When there is no return statement, the last expression calculated is returned. So think of methods
as an expression that calculates a single value that is returned.
A method which is primarily used for side effect is called a procedure.
A method can be turned into a procedure by remove the return type and equal sign,
and wrap the body in braces. Removing the return type will always return `Unit`
which can be a gotcha. Removing the equal sign will always return `Unit`
def f() { "This string gets lost" }
def g(): Unit = "This string gets lost" 
def h() = { "This string is not lost" }

## Singleton Objects
