object Implicits {
  implicit def stringToTricky(s: String): TrickyString = {
    println("Implicit conversion from String to TrickyString called!")
    new TrickyString(s)
  }

  class TrickyString(s: String) {
    val data = s"Tricky $s"
    override def toString: String = data
  }

  /**
    * Example of implicit class
    */
    implicit class IntWithTimes(x: Int) {
      def times(f: => Unit): Unit = {
        for (_ <- 1 to x) {
          f
        }
      }
    }
}