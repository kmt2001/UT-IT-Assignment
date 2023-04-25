
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.knoldus.models.Company
import com.knoldus.db.CompanyReadDto

class CompanyReadDtoTest extends AnyFlatSpec with Matchers {
  val companyReadDto = new CompanyReadDto()

  "CompanyReadDto,getCompanyByName" should "return the company object if it exists in the HashMap" in {
    val result = companyReadDto.getCompanyByName("Knoldus")
    result shouldEqual Some(Company("Knoldus", "knoldus@gmail.com", "Noida"))
  }

  it should "return None if the company does not exist in the HashMap" in {
    val result = companyReadDto.getCompanyByName("Non-existent company")
    result shouldEqual None
  }
}
