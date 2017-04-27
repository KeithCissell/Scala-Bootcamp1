// src/main/scala/milestoneproject/search-engine.scala
package milestoneproject

object searchEngine {
  // Search Engine Classes
  case class User(name: String, password: String, searchHistory: List[Search])

  case class Search(value: String, results: List[Result])

  case class Result(title: String, description: String)

  // Main
  def main(args: Array[String]) {
    // Make some searches and fill them with results
    val weatherSearch = Search("Weather", List(
      Result("Springfield's Weather", "Local weather report for your area."),
      Result("National Weather Report", "Your up to date location for weather around the world."))
    )

    val catVideoSearch = Search("Cat Videos", List(
      Result("Cat Fights Off Bear", "This little cat thinks it's king of the jungle!"),
      Result("Nyan Cat Needs to Stop", "\"It was never funny. It's still not funny\" ~everyone"),
      Result("Cat Videos United", "Just a website to host cat vidoes and nothing else. You're welcome."))
    )

    val cardinalsSearch = Search("Cardinals", List(
      Result("Cardinals Nation", "You're one stop for up to date Cardinal's score and news"),
      Result("MLB Network", "Cardinals vs. Orioles: Live Score Updates"))
    )

    val pieSearch = Search("pie", List(
      Result("Apple Pie Recipe", "Famous homemade apple pie recipe"),
      Result("Pie Eating Contest", "United Way is hosting a pie eating contest as a fund raiser"),
      Result("Dave's Deli", "Freshly made pies, muffins, donuts...."))
    )

    val badSearch = Search("asdfffffff", List())

    // Create some users
    val Keith = User("Keith", "StrongPassWord", List(cardinalsSearch, weatherSearch))
    val Connor = User("Connor", "SecretPhrase", List(weatherSearch, catVideoSearch, badSearch))
    val Curly = User("Curly", "Password123", List())
    val Moe = User("Moe", "Wordpass321", List(pieSearch))
    val Larry = User("Larry", "NyakNyakNyak", List(pieSearch, weatherSearch))

    // Create a list of all the users
    val searchEngineUsers = List(Keith, Connor, Curly, Moe, Larry)

    // Print out info on all the users
    for (user <- searchEngineUsers) println(user)
  }
}
