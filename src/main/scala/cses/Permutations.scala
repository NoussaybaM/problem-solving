package cses

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Permutations {
  def main(args: Array[String]): Unit = {
    val n = readLine().trim.toInt
    val arrayEvenNumbers = List.empty
    val arrayOddNumbers = List.empty

    @tailrec
    def findPermutation(arrayEvenNumbers: List[Int], arrayOddNumbers: List[Int], position: Int): Unit = {
      if (position == n + 1) {
        if (arrayEvenNumbers.last + 1 != arrayOddNumbers.head) {
          val resultArray = arrayEvenNumbers reverse_::: arrayOddNumbers.reverse
          resultArray.foreach(elem => print(elem + " "))
        }
        else println("NO SOLUTION")
      }

      else {
        val isEven = position % 2 == 0
        if (isEven) findPermutation(arrayEvenNumbers :+ position, arrayOddNumbers, position + 1)
        else findPermutation(arrayEvenNumbers, arrayOddNumbers :+ position, position + 1)

      }
    }

    findPermutation(arrayEvenNumbers, arrayOddNumbers, 1)

  }
}