import org.scalatest.FlatSpec

class CalculatorFlatSpecTest extends FlatSpec {
  "Calculator.square(2)" should "return 4" in {
    assert(Calculator.square(2) == 4)
  }

  it should "produce ArithmeticException when smth is divided by zero" in {
    assertThrows[ArithmeticException] {
      Calculator.divide(5, 0)
    }
  }
}
