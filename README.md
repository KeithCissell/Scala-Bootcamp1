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
  
### Chapter 3
* Operators
  * Almost all operators are methods
  * (Cautiously) Can be used in the forms `3.+(9)` or `3 + 9`
* Empty Arguments
  * Methods that take no arguments can be defined with or without parenthesis
    * If you don't use `()` to define the method, calling that method with `()` will throw an error
    * If you do use `()` the method can be called either with or without
* Shorthand
  * `List(1, 2, 3, 4).filter((i: Int) => isEven(i)).foreach((i: Int) => println(i))`
  * Can instead be written:
  * `List(1, 2, 3, 4) filter isEven foreach println`
* Precedence - ':' binds to the right and not the left. `list: List[Char]`
* DSL (Domain Specific Language)
  * internal DSLs: embedded in the host language
  * external DSLs: require custom parsers
* For loops
  * Generator Expressions
    * `for (item <- itemList)`
    * `for (i <- 1 to 10)`
  * Guards
    * place if statements within the for statement to filter results
      * `for (i <- 1 to 10 if i.isEven)`
  * Yield
    * assign filtered results to a val using yield
      *  `val filteredItems for { curly braces for multi-line } yield item`
    * val type inferred
* Open File: `import scala.io.Source` `Source.fromFile(fileName)`
* Handling NonFatal Errors: `import scala.util.control.NonFatal` `NonFatal(ex)`
  * matches to any non fatal exception
* For Comprehension
  * Easy to check Options `for (s <- source)` only executes on Some and ignores None
* Declaring subtype: `child <: parent`
* By-Name Parameters
  * `def function(str: => String)(body: => Unit)`
  * You can pass body's of functions using by-name params
  * `function(count < 5){ count += 1 }`
* Lazy val: `Lazy val resource: ...`
  * Evaluation is deferred until the resource is needed
* Enumeration:
  * `object WeekDay extends Enumeration { ... }`
  * Declare a type name: `type: WeekDay = Value`
  * Set ID\Value pairs: `val Mon = Value("Monday")`
  * `import WeekDay._` allows you to reference as Mon instead of WeekDay.Mon
* Traits:
  * `trait Logging { ... }`
  * Mixin:
    * Single instance: `val instance = new className() with Logging`
    * New class instance: `class LoggingService() extends Service() with Logging { ... }`
