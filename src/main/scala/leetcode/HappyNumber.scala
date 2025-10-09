package leetcode

object HappyNumber {
  def main(args: Array[String]): Unit = {
    println(isHappy(16))
  }

  def isHappy(n: Int): Boolean = {
    def sumSquares(n: Int): Int = {
      n.toString.map(ch => {
        val d = ch.asDigit
        d * d
      }).sum
    }

    def loopishappy(n: Int, seen: Set[Int]): Boolean = {
      if (n == 1) true
      else if (seen.contains(n)) {
        false
      }
      else {
        val calculonenumber = sumSquares(n)
        val newSet = seen + n
        loopishappy(calculonenumber, newSet)
      }
    }

    loopishappy(n, Set.empty[Int])
  }


}