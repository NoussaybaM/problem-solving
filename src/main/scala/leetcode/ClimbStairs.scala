package leetcode

object ClimbStairs {
  def climbStairs(n: Int): Int = {
    //    if (n<=1) 1
    //    else climbStairs(n-1)+climbStairs(n-2) //fibonnaci
    (2 to n).foldLeft((1, 1)) { case ((a, b), _) =>
      (b, a + b)
    }._2
  }
}