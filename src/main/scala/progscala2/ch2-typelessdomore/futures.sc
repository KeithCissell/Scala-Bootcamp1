// src/main/scala/progscala2/ch2-typelessdomore/futures.sc
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
// ^^^ provides code that implicitly defines ExecutionContext of Future to be ForkJoinPool

def sleep(millis: Long) = {
  Thread.sleep(millis)
}

// Busy work
def doWork(index: Int) = {
  sleep((math.random * 1000).toLong)
  index
}

// creates 5 threads and handles success and failure callbacks
(1 to 5) foreach { index =>
  val future = Future {
    doWork(index)
  }
  future onSuccess {
    case answer: Int => println(s"Success! returned $answer")
  }
  future onFailure {
    case th: Throwable => println(s"FAILURE! returned: $th")
  }
}

sleep(1000) // Wait long enough for th "work" to finish.
println("Finito!")
