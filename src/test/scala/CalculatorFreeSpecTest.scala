import org.scalatest.FreeSpec

class CalculatorFreeSpecTest extends FreeSpec {
  "A Calculator" - {
    "when square(2) invoked" - {
      "should return 4" in {
        assert(Calculator.square(2) == 4)
      }
    }

    "when divide invoked" - {
      "with divisor 0" - {
        "should produce ArithmeticException" in {
          assertThrows[ArithmeticException] {
            Calculator.divide(5, 0)
          }
        }
      }
    }
  }
}
