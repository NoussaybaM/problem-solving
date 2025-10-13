package leetcode

object MaxProfit {
  def main(args: Array[String]): Unit = {
    println(findmaxprofit(Array(7,6,4,3,1)))
  }

  def findmaxprofit(prices: Array[Int]): Int = {
    prices.foldLeft(0, prices(0)) {
      (accum, curr) => {
        val (maxprofit, minseen) = accum
        val newmax = curr - minseen
        val localmax = math.max(maxprofit: Int, newmax: Int)
        val localmin= math.min(minseen,curr)
        (localmax,localmin)
      }
    }._1
  }

  def findmaxprofit2(prices: Array[Int]):Int={
    prices.toList match {
      case Nil => 0
      case x::xs=> {
        xs.foldLeft(x,0){
        }
      }
    }
  }
}