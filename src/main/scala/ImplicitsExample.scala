import Implicits.{TrickyString, stringToTricky}
import Implicits.IntWithTimes

/**
  * Example of implicit parameter
  */
object Greeter {
  def greet(name: String)(implicit greeting: TrickyString): Unit = {
    println(s"$greeting, $name!")
  }
}

object Greeter2 {
  def greet(name: String)(implicit greeting: String, greeting2: TrickyString): Unit = {
    println(s"$greeting, $greeting2, $name!")
  }
}

object ImplicitsExample {

  /**
    * Example of implicit conversion
    */
  def doSomething(tricky: TrickyString): Unit = {
    println("Doing something")
    println(tricky.data)
  }

  def doSomething(tricky: String): Unit = {
    println("Doing something")
    println(tricky.data)  // Implicit conversion due to member absence
  }

  def doSomethingAgain(tricky: TrickyString): Unit = {
    println("Doing something again")
    println(tricky.data)
  }

  def main(args: Array[String]): Unit = {
    val text = "Hello, dummy world!"
    doSomething(text)
    println()
    doSomethingAgain(text)

    println()

    implicit val defaultHello: String = "Hello"
    implicit val defaultHello2: TrickyString = "Hello"

//    Greeter2 greet "User" "Hi"

    println()

    // Greeter.greet("User") // Error
//    Greeter.greet("Megauser")("Nice to see you")  // We still can provide implicit value explicitly

    println()

    5 times Greeter2.greet("User")
  }
}
