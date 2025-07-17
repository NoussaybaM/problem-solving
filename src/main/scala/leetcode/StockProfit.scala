package leetcode

object StockProfit {

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
  def maxProfit(prices: Array[Int]): Int = {
    prices.toList match {
      case Nil => 0
      case x :: Nil => 0
      case x :: xs => {
        xs.foldLeft((x, 0))(
          (results, elem) => {
            val (globminprice, maximumprofit) = results
            val profit = maximumprofit max elem - globminprice
            val minprice = globminprice min elem
            (minprice, profit)
          }
        )._2
      }
    }

  }
}