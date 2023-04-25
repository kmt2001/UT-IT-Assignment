
package com.knoldus.validator

import com.knoldus.models.{Company}

import com.knoldus.db.CompanyReadDto

class CompanyValidator(companyReadDto: CompanyReadDto, emailValidator: EmailValidator) {

  def companyExists(companyName: String): Boolean = companyReadDto.getCompanyByName(companyName).nonEmpty

  def companyIsValid(company: Company): Boolean = {
    !companyExists(company.name) && emailValidator.emailIdIsValid(company.emailId)
  }

}


