import com.typesafe.scalalogging.Logger

// Define a trait for logging
trait Logging {
  val logger: Logger = Logger(getClass)
}

// Define a separate class for duplicate checking
class DuplicateChecker extends Logging {
  def hasDuplicates(list: List[Int]): Boolean = {
    val distinctList = list.distinct
    val hasDuplicates = distinctList.size != list.size

    if (hasDuplicates) {
      logger.info("List has duplicates")
    } else {
      logger.warn("List does not have duplicates")
    }
    hasDuplicates
  }
}
