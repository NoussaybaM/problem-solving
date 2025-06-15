package cses
import scala.annotation.tailrec
import scala.io.StdIn._

object WeirdAlgorithm {
  def main(args: Array[String]): Unit = {
      val n = readLine().trim.toInt
      @tailrec
      def calculate(n: Int, res: List[Int]): List[Int]={
        if (n==1) res
        else if (n % 2 == 0) calculate(n/2, res++ List(n/2))
        else  calculate(n*3+1, res++ List(n*3+1))
      }
    calculate(n,List(n)).foreach(x=>print(x + " "))
  }
}