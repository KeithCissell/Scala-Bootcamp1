// src/main/scala/progscala2/ch3-roundingbasics/assigned-if.sc

val configFile = new java.io.File("somefile.txt")

val configFilePath = if (configFile.exists()) {
  configFile.getAbsolutePath()
} else {
  configFile.createNewFile()
  configFile.getAbsolutePath()
}
