import org.scalatest.FunSpec

class CalculatorFunSpecTest extends  FunSpec {
  describe("A Calculator") {
    describe("when square invoked") {
      describe("with given 2") {
        it("should return 4") {
          assert(Calculator.square(2) == 4)
        }
      }
    }
    describe("when divide invoked") {
      describe("with divisor 0") {
        it("should produce ArithmeticException") {
          assertThrows[ArithmeticException] {
            Calculator.divide(5, 0)
          }
        }
      }
    }
  }
}
