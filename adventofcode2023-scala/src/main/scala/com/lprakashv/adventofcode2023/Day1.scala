package com.lprakashv.adventofcode2023

import scala.io.Source

object Day1 {
  def calibrateSum1: Int =
    Source
      .fromResource("day1_input.txt")
      .getLines
      .map:
        _.filter:
          _.isDigit
      .flatMap: chars =>
        chars.headOption
          .map:
            _ :: chars.last :: Nil
      .map:
        _.mkString.toInt
      .sum

  private def wordReplacements(s: String): String =
    s.replace("zero", "z0o")
      .replace("one", "o1e")
      .replace("two", "t2o")
      .replace("three", "t3e")
      .replace("four", "f4r")
      .replace("five", "f5e")
      .replace("six", "s6x")
      .replace("seven", "s7n")
      .replace("eight", "e8t")
      .replace("nine", "n9e")

  def calibrateSum2: Int =
    Source
      .fromResource("day1_input.txt")
      .getLines
      .map(wordReplacements)
      .map:
        _.filter:
          _.isDigit
      .flatMap: chars =>
        chars.headOption
          .map:
            _ :: chars.last :: Nil
      .map(_.mkString.toInt)
      .sum

}
