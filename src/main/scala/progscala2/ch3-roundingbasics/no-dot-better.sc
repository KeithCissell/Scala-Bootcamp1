// src/main/scala/progscala2/ch3-roundingbasics/no-dot-better.sc

def isEven(n: Int) = (n % 2) == 0

List(1, 2, 3, 4) filter isEven foreach println

// Other possible ways to write this

List(1, 2, 3, 4).filter((i: Int) => isEven(i)).foreach((i: Int) => println(i))
List(1, 2, 3, 4).filter(i => isEven(i)).foreach(i => println(i))
List(1, 2, 3, 4).filter(isEven).foreach(println)
List(1, 2, 3, 4) filter isEven foreach println
