
import org.scalatest.funsuite.AnyFunSuite

class DuplicateCheckerTest extends AnyFunSuite {

  val checker = new DuplicateChecker()

  test("List with duplicates") {
    val duplicateList = List(1, 2, 3, 4, 3)
    assert(checker.hasDuplicates(duplicateList))
  }

  test("List without duplicates") {
    val distinctList = List(1, 2, 3, 4, 5)
    assert(!checker.hasDuplicates(distinctList))
  }

  test("Empty list") {
    val emptyList = List.empty[Int]
    assert(!checker.hasDuplicates(emptyList))
  }

  test("List with single item") {
    val singleItemList = List(1)
    assert(!checker.hasDuplicates(singleItemList))
  }

  test("List with only duplicates") {
    val duplicateItemList = List(1, 1, 1, 1)
    assert(checker.hasDuplicates(duplicateItemList))
  }

  test("List with negative numbers") {
    val negativeList = List(-1, -2, -3, -4, -3)
    val checker = new DuplicateChecker()
    assert(checker.hasDuplicates(negativeList))
  }

  test("List with both positive and negative numbers") {
    val mixedList = List(-1, 2, -3, 4, -3)
    assert(checker.hasDuplicates(mixedList))
  }
}
