// src/main/scala/scalabasics/string-to-int.scala
package scalabasics

// Usage `scala scalabasics.StringToInt`
object StringToInt {
  // Can main allow no args?
  def main(args: Array[String]) = {
    val strs: List[String] = List("We","are","","a","list",null,"of","strings")
    println(s"Strings: $strs")
    // Translate strings to ints
    val ints = for {
      s <- strs
      // pattern match the string
      val len = s match {
        case null => 0
        case ""   => -1
        case _    => s.length
      }
    } yield len
    println(s"Ints:\t $ints")
  }
}
