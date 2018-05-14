object VarargsExample {

  def printAll(strings: String*): Unit = {
    for (string <- strings) {
      print(string + " ")
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    printAll("Hello,", "fucking", "world")

    val wordsArray: Array[String] = Array("Hello,", "array", "world")
    printAll(wordsArray: _*)
  }

}
