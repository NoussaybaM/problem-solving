package coursera.recfun

import scala.annotation.tailrec

object RecFun {

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def checkbalance(counter: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) counter == 0
      else {
        if (counter < 0) false
        else
          chars.head match {
            case '(' => checkbalance(counter + 1, chars.tail)
            case ')' => checkbalance(counter - 1, chars.tail)
            case _ => checkbalance(counter, chars.tail)
          }
      }
    }

    checkbalance(0, chars)
  }

  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1 // found a valid way
    else if (money < 0 || coins.isEmpty) 0 // invalid path
    else {
      // include head coin or exclude it
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
}

