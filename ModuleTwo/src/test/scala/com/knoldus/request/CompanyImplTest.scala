
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.knoldus.models.{Company, Employee}
import com.knoldus.db.CompanyReadDto
import com.knoldus.request.CompanyImpl
import com.knoldus.validator.{CompanyValidator, EmailValidator, EmployeeValidator}

class CompanyImplTest extends AnyFlatSpec with Matchers {
  val companyReadDto = new CompanyReadDto()
  val emailValidator = new EmailValidator()
  val companyValidator = new CompanyValidator(companyReadDto, emailValidator)
  val companyImpl = new CompanyImpl(companyValidator)

  "CompanyImpl#createCompany" should "return Some(name) if the company is does not exist" in {
    val company = Company("Amazon", "amazon@gmail.com", "Noida")
    val result = companyImpl.createCompany(company)
    result shouldEqual Some("Amazon")
  }
  it should "return None if the company already exists" in {
    val company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val result = companyImpl.createCompany(company)
    result shouldEqual None
  }

  it should "return None if the company email is invalid" in {
    val company = Company("Knoldus", "invalid email", "ghaziabad")
    val result = companyImpl.createCompany(company)
    result shouldEqual None
  }
}