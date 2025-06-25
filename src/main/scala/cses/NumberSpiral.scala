package cses

import scala.io.StdIn.readLine

object NumberSpiral {
  def main(args: Array[String]): Unit = {
    val t = readLine().trim.toInt
    for (_ <- 1 to t) {
      val Array(y, x) = readLine().split(" ").map(_.toInt)
      val mx = x max y
      val initialValue = mx * mx
      if (x >= y && x % 2 != 0) {
        println(initialValue - y + 1)
      }
      if (x >= y && x % 2 == 0) {
        println(initialValue - (2 * x - 1) + y)
      }
      if (y > x && y % 2 == 0) {
        println(initialValue - x + 1)
      }
      if (y > x && y % 2 != 0) {
        println(initialValue - (2 * y - 1) + x)
      }
    }

  }
}