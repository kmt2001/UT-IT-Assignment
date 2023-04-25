
package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UserValidatorSpec extends AnyFlatSpec with Matchers {
  val companyReadDto = new CompanyReadDto()
  val emailValidator = new EmailValidator()
  val userValidator = new UserValidator(companyReadDto, emailValidator)

  "UserValidator companyExists" should "return true if the company exists" in {
    val result = userValidator.companyExists("Knoldus")
    result shouldEqual true
  }

  it should "return false if the company does not exist" in {
    val result = userValidator.companyExists("Amazon")
    result shouldEqual false
  }

  "UserValidator#emailIsValid" should "return true if the email is valid" in {
    val result = userValidator.emailIsValid("krishna.tiwari@gknoldus.com")
    result shouldEqual true
  }

  it should "return false if the email is invalid" in {
    val result = userValidator.emailIsValid("invalid email")
    result shouldEqual false
  }
}



