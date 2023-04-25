
package com.knoldus.validator

class EmailValidator {
  private val emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"

  def emailIdIsValid(emailId: String): Boolean = {
    emailId.matches(emailRegex)
  }
}
