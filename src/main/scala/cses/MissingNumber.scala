package cses

import scala.io.StdIn.readLine

object MissingNumber {
  def main(args: Array[String]): Unit = {

    import scala.io.Source

    val lines = Source.stdin.getLines().toList

    val firstLine = lines(0)
    val secondLine = lines(1)

    println(firstLine)
    println(secondLine)

  }
}