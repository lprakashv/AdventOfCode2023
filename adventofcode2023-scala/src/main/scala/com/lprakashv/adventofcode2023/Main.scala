package com.lprakashv.adventofcode2023

val availableOptions = List("day1-1", "day1-2")

@main def main(args: String*): Unit =
  args.toList match
    case "day1-1" :: _ => println(Day1.calibrateSum1)
    case "day1-2" :: _ => println(Day1.calibrateSum2)
    case "day2-1" :: _ => println(Day2.sumOfIDsOfPossibleGames(12, 13, 14))
    case _ => println(s"available options: ${availableOptions.mkString(", ")}")
