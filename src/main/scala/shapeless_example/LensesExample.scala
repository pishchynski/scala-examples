package shapeless_example

import shapeless.lens

object LensesExample {

  case class House(buildYear: Int, storeysNum: Int, informalName: String)

  def main(args: Array[String]): Unit = {
    val buildYearLens = lens[House] >> Symbol("buildYear")
    val house = House(1961, 5, "сталинка")
    val newHouse = buildYearLens.set(house)(1965)
    print(newHouse)
  }
}
