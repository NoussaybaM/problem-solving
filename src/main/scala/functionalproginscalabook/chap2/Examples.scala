package functionalproginscalabook

import scala.collection.immutable.Nil.foldLeft
import scala.io.StdIn.readLine

object Examples {

  def main(args: Array[String]): Unit = {

    def findFirst(ss: Array[String], key: String): Int = {

      def loop(position: Int): Int = {
        if (position >= ss.length) -1
        else if (ss(position) == key) position
        else loop(position + 1)
      }

      loop(0)
    }

    def genericFindFirst[A](ss: Array[A], p: A => Boolean): Int = {
      def loop(position: Int): Int = {
        if (position >= ss.length) -1
        else if (p(ss(position))) position
        else loop(position + 1)
      }

      loop(0)
    }

    def isSorted[A](ss: Array[A], isOrdred: (A, A) => Boolean): Boolean = {
      def loop(position: Int): Boolean = {
        if (position > ss.length - 2) true
        else if (!isOrdred(ss(position), ss(position + 1))) false
        else loop(position + 1)
      }

      loop(0)
    }

    //    val x = readLine().split(" ").map(_.toInt)
    //    println(isSorted[Int](x, (x, y) => x > y))

    def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
      A => B => f(A, B)
    }

    def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
      (A, B) => f(A)(B)
    }

    def compose[A, B, C](f: B => C, g: A => B): A => C = { //andThen
      A => f(g(A))
    }

    //Cons(x,xs) x::xs
    def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
      sup match {
        case Nil => false
        case _ if (startsWith(sup, sub)) => true
        case x :: xs => startsWith(xs, sub)
      }
    }

    def startsWith[A](l: List[A], prefix: List[A]): Boolean = {
      (l, prefix) match {
        case (_, Nil) => true
        case ((x :: xs), (y :: ys)) => if (x == y) startsWith(xs, ys) else false
        case (Nil, _) => false
      }
    }

  }
}