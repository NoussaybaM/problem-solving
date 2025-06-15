package cses
import scala.annotation.tailrec
import scala.io.StdIn._

object WeirdAlgorithm {
  def main(args: Array[String]): Unit = {
      val m = readLine().trim.toInt
      @tailrec
      def calculate(n: Int): Unit={
        print(n + " ")
        if (n==1) ()
        else if (n % 2 == 0){
          calculate(n/2)}
        else {
          calculate(n*3+1)
        }
      }
    calculate(m)
  }
}