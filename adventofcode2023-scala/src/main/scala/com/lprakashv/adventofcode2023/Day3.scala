package com.lprakashv.adventofcode2023

import scala.io.Source

object Day3 {
  private case class Num(v: Int, row: Int, start: Int, end: Int)

  private lazy val matrix: Array[Array[Char]] =
    Source
      .fromResource("day3_input.txt")
      .getLines
      .toArray
      .map(_.toArray)

  private lazy val nums = getNums

  private lazy val partNums = nums
    .filter(isPartNum)

  private def getNums: Array[Num] =
    matrix.zipWithIndex
      .flatMap: (line, row) =>
        line.zipWithIndex
          .filter: (c, _) =>
            c.isDigit
          .foldLeft(List.empty[Num]) { case (acc, (c, i)) =>
            acc match
              case Num(v, r, s, e) :: tail if e == i - 1 =>
                Num(v * 10 + (c - '0'), r, s, i) :: tail
              case _ => Num(c - '0', row, i, i) :: acc
          }
          .reverse

  private def isPartNum(num: Num): Boolean =
    val cols =
      math.max(0, num.start - 1) to math.min(matrix(0).size - 1, num.end + 1)

    val top =
      if num.row > 0
      then
        cols.exists: i =>
          isSymbol(matrix(num.row - 1)(i))
      else false

    val bottom =
      if num.row < matrix.size - 1
      then
        cols.exists: i =>
          isSymbol(matrix(num.row + 1)(i))
      else false

    val sides = (num.start > 0 && isSymbol(matrix(num.row)(num.start - 1)))
      || (num.end < matrix(0).size - 1
        && isSymbol(matrix(num.row)(num.end + 1)))

    top || bottom || sides

  private def isSymbol(c: Char): Boolean = !c.isDigit && c != '.'

  def getParNumbersSum: Int =
    partNums
      .map(_.v)
      .sum

}
