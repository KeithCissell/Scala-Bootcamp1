# Iteration1
Iteration1 of the scala learning modules.

## Book Work
Working along with O'Reilly's Programming Scala 2nd Edition.

### Chapter 1
- Created a Hello World Program
- Produced separate .class files
- Messed around with SBT and the REPL component
- Learned case classes
- Created extended Actor classes from Akka library
- Used pattern matching case statements to generate correct output

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
* Packages
  * Cannot be declared in classes or objects
  * __Note: scripts are interpreted as objects__
  * Importing specific dependency from a package:   `import package.dep`
  * Importing multiple dependencies from a packgae: `import package.{dep1, dep2}`
  * Importing all dependencies from a package:      `import package._`
  * Scoping: Imports can be used almost anywhere for use only in the scope where they are declared
  * Aliasing: You can rename variables when importing them by adding `=> myVarName` after import
    * renaming to `=> _` makes the variable invisible (used to exclude certain vars when importing entire packages)
* Parameterized Types
  * Covariant Typing: `List[+A]` B will be a subtype of A
  * Contravariant Typing: `List[-A]` B will the a supertype of A
