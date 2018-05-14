package shapeless_example

import shapeless.{::, HNil, Poly1}

object ShapelessExample {
  case class SomeUser(name: String)

  object plusOne extends Poly1 {
    implicit def caseInt =
      at[Int]{ _ + 1 }

    implicit def caseString =
      at[String]{ _ + 1 }

    implicit def caseUser =
      at[SomeUser]{ case SomeUser(name) =>
        SomeUser(name + 1)
      }
  }

  def main(args: Array[String]): Unit = {
    var demo = 42 :: "Hello" :: SomeUser("Test") :: HNil

    val s = demo.select[String]
    println(s)

    val i = demo.select[Int]
    println(i)

    val i1 :: s1 :: u :: HNil = demo
    println(i1 + " :: " + s1 + " :: " + u)

    demo = demo.map(plusOne)
    println(demo)
  }
}
