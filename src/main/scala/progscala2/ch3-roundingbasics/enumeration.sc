// src/main/scala/progscala2/ch3-roundingbasics/enumeration.sc

object Breed extends Enumeration {
  type Breed = Value
  val doberman  = Value("Doberman Pinscher")
  val yorkie    = Value("Yorkshire Terrier")
  val scottie   = Value("Scottish Terrier")
  val dane      = Value("Portuguese Water Dog")
}
import Breed._

// Print a list of breeds and their IDs
println("ID\tBreed")
for (breed <- Breed.values) println(s"${breed.id}\t$breed")

// Print a list of Terrier breeds
println("\nJust Terriers:")
Breed.values filter (_.toString.endsWith("Terrier")) foreach println

def isTerrier(b: Breed) = b.toString.endsWith("Terrier")

println("\nTerriers Again??")
Breed.values filter isTerrier foreach println
