package cses

import scala.annotation.tailrec
import scala.io.StdIn._

object Repetitions {
  def main(args: Array[String]): Unit = {
    val input = readLine().trim.toArray

    @tailrec
    def findMax(mx: Int, position: Int, car: Char, count: Int): Int = {
      if (position == input.length) mx
      else {
        if (input(position) == car) {
          findMax(count max mx, position + 1, car, count + 1)
        }
        else {
          findMax(mx, position + 1, input(position), 1)
        }
      }
    }

    println(findMax(1, 0, input(0), 1))

  }
}