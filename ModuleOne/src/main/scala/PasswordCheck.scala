import com.typesafe.scalalogging.Logger

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

case class PasswordCheckResult(password: String, name: String, isStrong: Boolean)

class PasswordChecker {
  val loggerObject = Logger(getClass)

  def isStrong(password: String, name: String): Boolean = {
    val containsUpperCase = password.matches(".*[A-Z].*")
    val containsLowerCase = password.matches(".*[a-z].*")
    val containsAlphanumeric = password.matches(".*\\d.*")
    val containsAllowedMetacharacters = password.matches(".*[%@#&$].*")
    val containsName = password.toLowerCase.contains(name.toLowerCase)

    containsUpperCase && containsLowerCase && containsAlphanumeric && containsAllowedMetacharacters && !containsName
  }

  def checkPassword(password: String, name: String): PasswordCheckResult = {
    val isPasswordStrong = isStrong(password, name)

    if (isPasswordStrong) {
      loggerObject.info("password is strong")
    } else {
      loggerObject.warn("password is weak")
    }

    PasswordCheckResult(password, name, isPasswordStrong)
  }

  def isValidEmail(email: String): Boolean = {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".r
    emailRegex.findFirstMatchIn(email).isDefined
  }
}

object PasswordChecker extends App {
  private val passwordChecker = new PasswordChecker
  private val name = readLine("Enter your full name: ")
  val email = readLine("Enter your email ID: ")

  if (passwordChecker.isValidEmail(email)) {
    val userPassword = Try(readLine("Enter your password:"))

    userPassword match {
      case Success(userPassword) =>
        passwordChecker.checkPassword(userPassword, name)
      case Failure(exception) =>
        passwordChecker.loggerObject.error(s"Error while reading the password: ${exception.getMessage}")
    }
  } else {
    passwordChecker.loggerObject.error("Invalid email ID")
  }
}
