import org.scalatest.funsuite.AnyFunSuite

class FactorialTest extends AnyFunSuite {

  test("Factorial of 0 should be 1") {
    val fact = new Factorial
    assert(fact.factorial(0) == Right(1))
  }

  test("Factorial of 1 should be 1") {
    val fact = new Factorial
    assert(fact.factorial(1) == Right(1))
  }

  test("Factorial of a positive integer should be computed correctly") {
    val fact = new Factorial
    assert(fact.factorial(5) == Right(120))
    assert(fact.factorial(10) == Right(3628800))
  }

  test("Factorial of a negative integer should return an error message") {
    val fact = new Factorial
    assert(fact.factorial(-5) == Left("Input must be a non-negative integer."))
  }
}
