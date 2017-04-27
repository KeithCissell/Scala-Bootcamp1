// src/main/scala/scalabasics/2dvector.scala
package scalabasics

object VectorMath {
  case class Vec2D(x: Int, y: Int) {
    // override the toString for printing the vector
    override def toString: String = {
      s"($x, $y)"
    }

    // override + operator for vector addition
    def + (v2: Vec2D): Vec2D = {
      val newX = x + v2.x
      val newY = y + v2.y
      Vec2D(newX, newY)
    }

    // override - operator for vector subtraction
    def - (v2: Vec2D): Vec2D = {
      val newX = x - v2.x
      val newY = y - v2.y
      Vec2D(newX, newY)
    }

    //override * operator for scalar multiplication
    def * (s: Int): Vec2D = {
      val newX = x * s
      val newY = y * s
      Vec2D(newX, newY)
    }
  }

  def main(args: Array[String]) = {
    // Test Vec2D operators
    val v1 = Vec2D(2, 3)
    val v2 = Vec2D(-1, 1)
    println(s"v1 = $v1")
    println(s"v2 = $v2")

    //addition
    val v3 = v1 + v2
    println(s"\nv1 + v2 = $v3")

    //subtraction
    val v4 = v1 - v2
    println(s"\nv1 - v2 = $v4")

    //multiplication
    val v5 = v1 * 10
    println(s"\nv1 * 10 = $v5")
  }
}
