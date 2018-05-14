/**
  * Trait extension example
  */
trait BeautifulSoup {
  def extractText(input: String): String = {
    input
    .replaceAll("""</?\w[^>]*>""","")
    .replaceAll("<.*>","")
  }
}

class Page(val s: String) extends BeautifulSoup {
  def getText: String = extractText(s)
}

trait SafeStringUtils {
  def trimToNone(s: String): Option[String] = Option(s)
    .map(_.trim)
    .filterNot(_.isEmpty)
}

// If you are extending a class and one or more traits, you will need to extend the class
// before you can add the traits using the with keyword.
// A parent class, if specified, must always come before any parent traits.
class BetterPage(val str: String) extends Page(str) with BeautifulSoup with SafeStringUtils {
  override def getText: String = {
    trimToNone(s).map(extractText).getOrElse("n/a")
  }
}

/**
  * Linearization order example.
  * Pay attention to the fact that the linearization is computed from right to left
  */
class Animal {
  override def toString: String = "Animal"
}

trait Furry extends Animal {
  def hi() : Unit = {
    println("Hi, Furry")
  }
  override def toString: String = "Furry->" + super.toString
}

trait HasLegs extends Animal {
  override def toString: String = "HasLegs->" + super.toString
}

trait FourLegged extends HasLegs {
  def hi() : Unit = {
    println("Hi, FourLegged")
  }
  override def toString: String = "FourLegged->" + super.toString
}

class Cat extends FourLegged with Furry{
  override def hi(): Unit = super.hi()
  override def toString: String = "Cat->" + super.toString
}

/**
  * Self type example
  */
// A self type is a trait annotation that asserts that the
// trait must be mixed in with a specific type, or its subtype, when it is added to a class.
// A trait with a self type cannot be added to a class that does not extend the specified type.
class TestSuite(suiteName: String) {
  def start() {}
}

trait RandomSeeded {
  self: TestSuite =>        // Assure that trait will be mixed into class that extends TestSuite
  def randomStart(): Unit = {
    util.Random.setSeed(System.currentTimeMillis)
    self.start()
  }
}

class IdSpec extends TestSuite("ID Tests ") with RandomSeeded {
  def testId(): Unit = {
    println(util.Random.nextInt != 1)
  }
  override def start() {
    testId()
  }

  println("Starting...")
  randomStart()
}

/**
  * Instantiation with traits example
  */
class SciPerson(val name: String) {
  def suffix = ""
  override def toString: String = s"$name$suffix"
}

trait PhD {
  self: SciPerson =>
  override def suffix = ", PhD"
}

trait MD {
  self: SciPerson =>
  override def suffix = ", MD"
}

trait Reverser {
  override def toString: String = super.toString.reverse
}

object TraitsExample {
  def main(args: Array[String]): Unit = {
    val pageText = new Page("<html><body><h1>Ciao!</h1></body></html>").getText
    println(pageText)

    val betterPageText = new BetterPage("<html><body><h1>Bene Ciao!</h1></body></html>").getText
    println(betterPageText)
    val emptyPageText = new BetterPage("     ").getText
    println(emptyPageText)
    println(new BetterPage(null).getText)
    println()

    val cat = new Cat
    println(cat + "\n")
    cat.hi()

    val idTest = new IdSpec()

    val asta = new SciPerson("Astashynski") with PhD
    println(asta)

    val house = new SciPerson("House") with MD
    println(house)

    val atsa = new SciPerson("Astashynski") with PhD with Reverser
    println(atsa)

    // val testSuite = new TestSuite("test") with PhD   // won't compile
  }
}
