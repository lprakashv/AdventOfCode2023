package com.lprakashv.adventofcode2023

val availableOptions = List("day1-1", "day1-2")

@main def main(): Unit =
  println(s"""
    Solutions:
        day1-1 => ${Day1.calibrateSum1}
        day1-2 => ${Day1.calibrateSum2}
        day2-1 => ${Day2.sumOfIDsOfPossibleGames(12, 13, 14)}
        day2-2 => ${Day2.sumOfPowersOfSets}
        day3-1 => ${Day3.getParNumbersSum}
    """)
