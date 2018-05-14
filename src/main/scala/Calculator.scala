object Calculator extends App {
  def square(x: Int): Int = {
    x * x
  }

  def cube(x: Int): Int = {
    x * x * x
  }

  def sin(x: Double, isDegrees: Boolean = true): Double = {
    if (isDegrees) {
      math.sin(math.toRadians(x))
    } else {
      math.sin(x)
    }
  }

  def divide(num: Int, denom: Int): Int = {
    num / denom
  }
}
