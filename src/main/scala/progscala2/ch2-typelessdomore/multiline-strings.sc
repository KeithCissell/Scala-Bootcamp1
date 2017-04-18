// src/main/scala/progscala2/ch2-typelessdomore/multiline-strings.sc

def goodbye(name: String) =
  s"""xxxGoodbye, ${name}yyy
  xxxCome again!yyy""".stripPrefix("xxx").stripSuffix("yyy")

println( goodbye("Keith") )
