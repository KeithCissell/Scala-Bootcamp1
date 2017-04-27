// src/main/scala/milestoneproject/search-engine.scala
package milestoneproject

object searchEngine {
  // Search Engine Classes
  class User(name: String, pass: String) {
    val userName = name;
    private var password = pass;
    var searchHistory = List[Search]();

    def validatePassword(entry: String): Boolean = {
      return entry == password
    }

    def addSearch(search: Search) {
      searchHistory ::= search
    }

    // Format a way to print user and info
    /******The nested for loops and if/elses make this code sloppy and hard to read
    *******what would be a better approach on either of these to make it looke nicer?*/
    override def toString: String = {
      var str = s"$userName\n\tSearch History:\n"
      if (searchHistory.length > 0) {
        for (s <- searchHistory) {
          str += s"\t\tSearched: ${s.searchValue}\n\t\tResults:\n"
          if (s.searchResults.length > 0) {
            for (r <- s.searchResults) {
              str += s"\t\t\t${r.resultTitle} - ${r.resultDescription}\n"
            }
          } else {
            str += "\t\t\tNo results were found...\n"
          }
        }
      } else {
        str += "\t\tUser has no search history\n"
      }
      return str
    }
  }

  class Search(value: String) {
    val searchValue = value;
    var searchResults = List[Result]();

    def addResults(results: List[Result]) {
      for (r <- results) {
        searchResults ::= r
      }
    }
  }

  class Result(title: String, description: String) {
    val resultTitle = title;
    val resultDescription = description;
  }


  def main(args: Array[String]) {
    // Create some users
    var Keith = new User("Keith", "StrongPassWord")
    var Connor = new User("Connor", "SecretPhrase")
    var Curly = new User("Curly", "Password123")
    var Moe = new User("Moe", "Wordpass321")
    var Larry = new User("Larry", "NyakNyakNyak")

    // Make some searches and fill them with results
    val weatherSearch = new Search("Weather")
    weatherSearch.addResults(
      List( new Result("Springfield's Weather", "Local weather report for your area."),
            new Result("National Weather Report", "Your up to date location for weather around the world.")
          )
    )

    val catVideoSearch = new Search("Cat Videos")
    catVideoSearch.addResults(
      List( new Result("Cat Fights Off Bear", "This little cat thinks it's king of the jungle!"),
            new Result("Nyan Cat Needs to Stop", "\"It was never funny. It's still not funny\" ~everyone"),
            new Result("Cat Videos United", "Just a website to host cat vidoes and nothing else. You're welcome.")
          )
    )

    val cardinalsSearch = new Search("Cardinals")
    cardinalsSearch.addResults(
      List( new Result("Cardinals Nation", "You're one stop for up to date Cardinal's score and news"),
            new Result("MLB Network", "Cardinals vs. Orioles: Live Score Updates")
          )
    )

    val pieSearch = new Search("pie")
    pieSearch.addResults(
      List( new Result("Apple Pie Recipe", "Famous homemade apple pie recipe"),
            new Result("Pie Eating Contest", "United Way is hosting a pie eating contest as a fund raiser"),
            new Result("Dave's Deli", "Freshly made pies, muffins, donuts....")
          )
    )

    val badSearch = new Search("asdfffffff")

    // Add searches to user history
    Keith.addSearch(cardinalsSearch)
    Keith.addSearch(weatherSearch)
    Connor.addSearch(weatherSearch)
    Connor.addSearch(catVideoSearch)
    Connor.addSearch(badSearch)
    Moe.addSearch(pieSearch)
    Larry.addSearch(pieSearch)
    Larry.addSearch(weatherSearch)

    // Create a list of all the users
    var searchEngineUsers = List(Keith, Connor, Curly, Moe, Larry)

    // Print out info on all the users
    for (user <- searchEngineUsers) println(user)
  }
}
