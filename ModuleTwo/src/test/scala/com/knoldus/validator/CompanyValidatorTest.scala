
import com.knoldus.models.Company
import com.knoldus.db.CompanyReadDto
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorTest extends AnyFlatSpec {

  val companyReadDto = new CompanyReadDto()
  val emailValidator = new EmailValidator()
  val companyValidator = new CompanyValidator(companyReadDto, emailValidator)

  "CompanyValidator" should "return true if a company with a given name already exists" in {
    val existingCompany = Company("Knoldus", "knoldus@gmail.com", "Noida")
    assert(companyValidator.companyExists(existingCompany.name) === true)
  }

  it should "return false if a company with a given name does not exist" in {
    val nonExistingCompany = Company("XYZ", "xyz@gmail.com", "Noida")
    assert(companyValidator.companyExists(nonExistingCompany.name) === false)
  }

  it should "return false if a company with a given email address already exists" in {
    val existingCompany = Company("Knoldus", "knoldus@gmail.com", "Noida")
    assert(companyValidator.companyIsValid(existingCompany) === false)
  }

  it should "return true if a company with a given name and email address does not exist" in {
    val newCompany = Company("XYZ", "xyz@gmail.com", "Noida")
    assert(companyValidator.companyIsValid(newCompany) === true)
  }

}
