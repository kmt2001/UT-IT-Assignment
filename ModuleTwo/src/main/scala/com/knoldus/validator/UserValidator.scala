
package com.knoldus.validator

import com.knoldus.db.CompanyReadDto

class UserValidator(companyReadDto: CompanyReadDto, emailValidator: EmailValidator) {

  def companyExists(companyName: String): Boolean = companyReadDto.getCompanyByName(companyName).nonEmpty

  def emailIsValid(emailId: String): Boolean = emailValidator.emailIdIsValid(emailId)

}
