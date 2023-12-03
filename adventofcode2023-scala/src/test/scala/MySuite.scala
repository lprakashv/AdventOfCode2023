import com.lprakashv.adventofcode2023.{Day1, Day2}
import com.lprakashv.adventofcode2023.Day1.{calibrateSum1, calibrateSum2}

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {

  test("day1-1") {
    assertEquals(calibrateSum1, 53921)
  }

  test("day1-2") {
    assertEquals(calibrateSum2, 54676)
  }

  test("day2-1") {
    assertEquals(Day2.sumOfIDsOfPossibleGames(12, 13, 14), 2720)
  }

  test("day2-2") {
    assertEquals(Day2.sumOfPowersOfSets, 71535)
  }
}
