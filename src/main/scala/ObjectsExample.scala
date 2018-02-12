/**
  * Object demonstration
  */
object Hello {
  println("Object Hello instantiated")  // will print this once
  def greet = "Hello, World!"
}

/**
  * Companion object example
  */
class Multiplier(val x: Int) {
  def apply(y: Int): Int = x * y
  def getMyName = s"My name is ${Multiplier.myName}" // We can get access to private members of companion object but not vice versa!
}

object Multiplier {
  private val myName = "Multiplier"

  def apply(x: Int) = new Multiplier(x) // Factory!
}

/**
  * Case class example. I put it here because of companion object generated automatically
  */
case class Person(name: String, isRich: Boolean)

object ObjectsExample {
  def main(args: Array[String]): Unit = {
    println(Hello.greet)
    println(Hello.greet)

    val tripler = Multiplier(3) // Create 3x multiplier
    println(tripler(5))

    println(Multiplier(3)(7))   // LOL
    println(tripler.getMyName)

    val richPerson = Person("Big Boss", isRich = true) // Here companion object's apply method is called.
    println(richPerson) // Pay attention to the fact that toString method implementation was also generated on class fields base

    val arrestedRichPerson = richPerson.copy(isRich = false)  // We can copy objects changing copy's fields
    println(arrestedRichPerson)

    println(arrestedRichPerson == richPerson) // obviously, returns false

    val anotherRichPerson = Person("Big Boss", isRich = true)
    println(anotherRichPerson == richPerson)  // returns true because equals method (and hashCode method too) was also generated based on class fields
  }
}
