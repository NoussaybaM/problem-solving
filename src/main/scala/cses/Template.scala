package cses

import scala.io.StdIn._

object Template {
  def main(args: Array[String]): Unit = {
    // Sample input: 2 numbers
    val Array(a, b) = readLine().split(" ").map(_.toInt)

    // Your logic here
    println(a + b)
  }
}
