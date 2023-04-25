import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PasswordCheckerTest extends AnyFunSuite with Matchers {
val passwordChecker = new PasswordChecker

test("isStrong should return true for a strong password") {
passwordChecker.isStrong("Password@123", "John") should be (true)
}

test("isStrong should return false for a weak password") {
passwordChecker.isStrong("password123", "John") should be (false)
}

test("isStrong should return false if the password contains the name") {
passwordChecker.isStrong("john123", "John") should be (false)
}

test("isValidEmail should return true for a valid email") {
passwordChecker.isValidEmail("test@example.com") should be (true)
}

test("isValidEmail should return false for an invalid email") {
passwordChecker.isValidEmail("test@.com") should be (false)
}
}