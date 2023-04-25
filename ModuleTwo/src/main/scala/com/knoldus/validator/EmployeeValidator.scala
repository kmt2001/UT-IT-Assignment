
package com.knoldus.validator

import com.knoldus.models.Employee

class EmployeeValidator(userValidator: UserValidator) {

  def employeeIsValid(employee: Employee): Boolean = {
    userValidator.companyExists(employee.companyName) && userValidator.emailIsValid(employee.emailId)
  }

}

