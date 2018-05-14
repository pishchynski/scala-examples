object CakePatternExample {

  trait Lambda {
    val lam = "Lambda"
  }

  trait Calculus {
    this: Lambda =>
    val calc = "Calculus"
    val lamCalc = lam + calc
  }

  def main(args: Array[String]): Unit = {
    val shota = new Calculus with Lambda
    println(shota.lamCalc)
//    val ccc = new Calculus {} //  Won't compile
    val lambda = new Lambda {}
    println(lambda.lam)
  }
}
