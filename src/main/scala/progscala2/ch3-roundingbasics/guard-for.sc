// src/main/scala/progscala2/ch3-roundingbasics/guardfor.sc

val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund",
  "Scottish Terrier", "Great Dane", "Portuguese Water Dog")

for (breed <- dogBreeds)
  println(breed)

// Guards
println("Guard1:")
for (breed <- dogBreeds
  if breed.contains("Terrier")
) println(breed)

println("Guard2:")
for (breed <- dogBreeds
  if breed.contains("Terrier")
  if !breed.startsWith("Yorkshire")
) println(breed)

println("Guard3:")
for (breed <- dogBreeds
  if breed.contains("Terrier") && !breed.startsWith("Yorkshire")
) println(breed)
