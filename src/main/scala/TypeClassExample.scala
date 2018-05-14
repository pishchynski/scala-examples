object TypeClassExample {

  trait Show[A] {
    def show(action: A => String): String
  }

  object Show {

//    def show[A](a: A)(implicit sh: Show[A]) = sh.show(a)

    def show[A: Show](action: A => String) = Show[A].show(action)

    def apply[A](implicit sh: Show[A]): Show[A] = sh

    implicit val intCanShow: Show[Int] = new Show[Int] {
      def show(action: Int => String): String = action(10)
    }

    implicit val stringCanShow: Show[String] =
      new Show[String]{
        def show(action: String => String): String = action("LOL")
      }
  }

  def main(args: Array[String]): Unit = {
    println(Show.show((x: Int) => x.toString))
  }

}
