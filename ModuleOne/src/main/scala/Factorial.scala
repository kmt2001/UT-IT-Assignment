import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec
import scala.collection.mutable

class Factorial {

  val loggerObject = Logger(getClass)
  val memo = mutable.Map.empty[Int, Int]

  def factorial(number: Int): Either[String, Int] = {
    if (number < 0) {
      Left("Input must be a non-negative integer.")
    } else {
      val result = memo.getOrElseUpdate(number, computeFactorial(number))
      loggerObject.info(s"Factorial of $number is $result")
      Right(result)
    }
  }

  @tailrec
  private def computeFactorial(number: Int, acc: Int = 1): Int = {
    if (number <= 1) {
      acc
    } else {
      computeFactorial(number - 1, acc * number)
    }
  }
}
