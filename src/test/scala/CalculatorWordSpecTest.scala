import org.scalatest.WordSpec

class CalculatorWordSpecTest extends WordSpec {
  "A Calculator" when {
    "square(2) invoked" should {
      "return 4" in {
        assert(Calculator.square(2) == 4)
      }
    }

    "divide by zero invoked" should {
      "produce ArithmeticException" in {
        assertThrows[ArithmeticException] {
          Calculator.divide(5, 0)
        }
      }
    }
  }
}
