// src/main/scala/progscala2/ch2-typelessdomore/tailrecursion.sc
import scala.annotation.tailrec // used to check for recursion optimization
// compiler error if recursion is not tial recursive

def factorial(i: Int): Long = {
  def fact(i: Int, accumulator: Int): Long = {
    if (i <= 1) accumulator
    else fact(i - 1, i * accumulator)
  }

  fact(i, 1)
}

(0 to 5) foreach ( i => println(factorial(i)) )
