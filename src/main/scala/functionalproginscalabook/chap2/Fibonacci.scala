package functionalproginscalabook.chap2

import scala.annotation.tailrec

object Fibonacci {

  def fib(n: Int): Int = {
    @tailrec
    def loop(i: Int, prev: Int, curr: Int): Int = {
      if (i >= n) prev
      else loop(i + 1, curr, curr + prev)
    }

    loop(0, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    println(fib(4))
  }
}