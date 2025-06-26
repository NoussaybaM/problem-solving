package cses

import scala.io.StdIn.readLine

object DistinctNumbers {
  def main(args: Array[String]): Unit = {
    val n = readLine().trim.toInt
    val input = readLine().split(" ").toSet.toList.length
    println(input)

  }
}