
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.validator.EmailValidator

class EmailValidatorTest extends AnyFlatSpec {

  val emailValidator = new EmailValidator()

  "EmailValidator" should "return true for a valid email" in {
    assert(emailValidator.emailIdIsValid("krishna.tiwari@knoldus.com") === true)
    assert(emailValidator.emailIdIsValid("megha@gmail.com") === true)
    assert(emailValidator.emailIdIsValid("singhakanksha@gmail.com") === true)
  }

  it should "return false for an invalid email" in {
    assert(emailValidator.emailIdIsValid("aman.shukla@") === false)
    assert(emailValidator.emailIdIsValid("mukesha.singh@gmail.com") === false)
    assert(emailValidator.emailIdIsValid("mks@gmail") === false)
    assert(emailValidator.emailIdIsValid("pawan.tiwari@gmail.com") === false)
  }
}

