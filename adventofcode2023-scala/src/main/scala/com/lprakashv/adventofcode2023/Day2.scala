package com.lprakashv.adventofcode2023

import scala.annotation.targetName
import scala.io.Source

object Day2 {
  private case class CubesSet(red: Int, green: Int, blue: Int):
    @targetName("add_CubeSets")
    def +(other: CubesSet): CubesSet =
      CubesSet(
        red = this.red + other.red,
        green = this.green + other.green,
        blue = this.blue + other.blue
      )

    def maxSet(other: CubesSet): CubesSet =
      CubesSet(
        red = Math.max(this.red, other.red),
        green = Math.max(this.green, other.green),
        blue = Math.max(this.blue, other.blue)
      )

  private case class Game(ID: Int, cubeSets: List[CubesSet])

  // Sample line:
  // Game 1: 1 red, 5 blue, 10 green; 5 green, 6 blue, 12 red; 4 red, 10 blue, 4 green
  private def parseGameLine(line: String): Game =
    val idAndGames = line.split(":").map(_.trim)
    Game(
      ID = idAndGames(0).split(" ")(1).toInt,
      cubeSets = idAndGames(1)
        .split(";")
        .filterNot:
          _.isBlank
        .map: cubes =>
          cubes.trim
            .split(",")
            .filterNot:
              _.isBlank
            .map(_.split(" ").filterNot(_.isBlank))
            .map: cubesAndColor =>
              cubesAndColor(1) -> cubesAndColor(0).toInt
        .map:
          _.toMap
        .map: colorToCubesMap =>
          CubesSet(
            red = colorToCubesMap.getOrElse("red", 0),
            green = colorToCubesMap.getOrElse("green", 0),
            blue = colorToCubesMap.getOrElse("blue", 0)
          )
        .toList
    )

  private def readGameInput: List[Game] =
    Source
      .fromResource("day2_input.txt")
      //    Source.fromFile("./src/main/resources/day2_input.txt")
      .getLines
      .map(parseGameLine)
      .toList

  def sumOfIDsOfPossibleGames(red: Int, green: Int, blue: Int): Int =
    val maxCubeSetsForGame: List[(Int, CubesSet)] = readGameInput
      .map: game =>
        (game.ID, game.cubeSets.reduce((a, b) => a.maxSet(b)))

    maxCubeSetsForGame
      .filterNot: (_, totalCubes) =>
        totalCubes.red > red || totalCubes.green > green || totalCubes.blue > blue
      .map:
        _._1
      .sum

  def sumOfPowersOfSets: Int =
    val maxCubeSetsForGame: List[(Int, CubesSet)] = readGameInput
      .map: game =>
        (game.ID, game.cubeSets.reduce((a, b) => a.maxSet(b)))

    maxCubeSetsForGame
      .map: (_, maxSet) =>
        maxSet.red * maxSet.green * maxSet.blue
      .sum
}
