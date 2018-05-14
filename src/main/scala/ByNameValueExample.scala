object ByNameValueExample {
  def main(args: Array[String]): Unit = {
    var count = 0
    continue(count < 5) {
      println(s"at $count")
      count += 1
    }
  }

  @annotation.tailrec
  def continue(conditional: => Boolean)(body: => Unit) {
    if (conditional) {
      body
      continue(conditional)(body)
    }
  }
}
