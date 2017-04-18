# Iteration1
Iteration1 of the scala learning modules.

## Book Work
Working along with O'Reilly's Programming Scala 2nd Edition.

### Chapter 2
* `val` (immutable) vs `var` (mutable)
* Range:
  * 1 until 10 (exclusive)
  * 1 to 10 (inclusive)
  * 'a' to 'g' by 3
* PartialFunction[Any,String]
  * can only use case clauses
  * MatchError: returns ERROR! if no case match found
  * isDefinedAt(input): built in method returns true or false if case for input exists
* Future
  * Set default ExecutionContext to ForkJoinPool:
    * `import scala.concurrent.ExecutionContext.Implicits.global`
    * creates threads
  * Callbacks: onSuccess { ... } and onFailure { //throwable }
* 'implicit': used to declare a default to use if a value isn't declared
  * Example: the case above where Future's ExecutionContext is defined implicitly
* optimization: Tail Recursion
  * recursive function can be optimized into a loop by having recursive call at the end of the function
  * `import scala.annotation.tailrec` will throw compile error for non-tail-recursions
* Return Type Inference
  * good practice: declare method return types explicitly and use the most general return type you can
  * Method Inference
    * Procedure: `def function(input: type) { doStuff() }` => Unit (doesn't expect any return value)
    * Function: `def function(input: type) = { doStuff() }` => Type (expects a returned value)
    * __Don't use procedure syntax as it is deprecated__
* List of Reserved Words: pg. 51
  * `object` - a singleton declaration (class with one instance)
  * `sealed` - applied to parent type. requires all derived types to be declared in same files
  * some java methods use reserved words, fix by placing ticks around them
    * `java.util.Scanner.'match'.`
* `TupleN` (immutable) - creates a tuple of N values N = 1 - 22
* Options: Some and None
  * Maps - returns an Option: Some(Value) or None
    * `Mapt.get("Input")` => Some(Value) or None
    * to return actual value use `.get` or `.getOrElse("Return value for None")`
    * `.get` will throw a messy error if called on None
* sealed: prevents users from declaring subtypes of a class outside of the file that the class is declared
  * `sealed abstract class Option[+A] ... { ... }`
* final: prevents any subtypes of a class from being created
  * `final class dontExtendMe[T] ... { ... }`
