import org.scalatest.FunSuite

class CalculatorFunSuiteTest extends FunSuite {
  test("Calculator.square(2) should return 4") {
    assert(Calculator.square(2) === 4)
  }

  test("Calculator.cube(3) should return 27") {
    assert(Calculator.cube(3) === 27)
  }

  test("Zero dividing should produce ArithmeticException") {
    assertThrows[ArithmeticException] {
      Calculator.divide(5, 0)
    }
  }
}
