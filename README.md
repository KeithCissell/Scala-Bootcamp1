# Iteration1
Iteration1 of the scala learning modules.

## Book Work
Working along with O'Reilly's Programming Scala 2nd Edition.

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
