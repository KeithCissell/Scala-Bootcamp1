// src/main/scala/progscala2/ch3-roundingbasics/scoped-for.sc

val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund",
  "Scottish Terrier", "Great Dane", "Portuguese Water Dog")

val filteredBreeds = for {
  breed <- dogBreeds
  upcasedBreed = breed.toUpperCase()
} println(upcasedBreed)
