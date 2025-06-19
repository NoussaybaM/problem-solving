package cses

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object IncreasingArray {
  def main(args: Array[String]): Unit = {
    val n = readLine().trim.toInt
    val inputArrays = readLine().split(" ")

    @tailrec
    def MinMoves(inputArray: Array[String], position: Int, moves: Int): Int = {
      if (position == n - 1) moves
      else {
        val diff = inputArray(position).toInt - inputArray(position + 1).toInt
        val addition = 0 max diff
        val newVal = addition + inputArray(position + 1).toInt
        inputArray.update(position + 1, newVal.toString)
        MinMoves(inputArray, position + 1, moves + addition)
      }
    }

    println(MinMoves(inputArrays, 0, 0))
  }
}