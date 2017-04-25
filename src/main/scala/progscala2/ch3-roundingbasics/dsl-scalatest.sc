// src/main/scala/progscala2/ch3-roundingbasics/dsl-scalatest.sc
// Example fragment of a ScalaTest. Doesn't run standalone.

import org.scalatest.{ FunSpec, ShouldMatchers }

class NerdFinderSpec extends FunSpec with ShouldMatchers {

  describe ("nerd finder") {
    it ("identify nerds from a list") {
      val actors = List ("Rick Moranis", "James Dean", "Woody Allen")
      val finder = new NerdFinder(actors)
      finder.findNerds shouldEqual List("Rick Moranis", "Woody Allen")
    }
  }
}
