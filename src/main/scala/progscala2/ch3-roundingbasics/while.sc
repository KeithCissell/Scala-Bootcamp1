// src/main/scala/progscala2/ch3-roundingbasics/while.sc
// WARNING: This script runs for a LOOOOONG time!
import java.util.Calendar

def isFridayThirteen(cal: Calendar): Boolean = {
  val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
  val dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)

  // Scala returns the result of the last expression in a method
  (dayOfWeek == Calendar.Friday) && (dayOfMonth == 13)
}

while (!isFridayThirteen(Calendar.getInstance())) {
  println("Today isn't Friday the 13th. Lame.")
  // sleep for a day
  Thread.sleep(86400000)
}
