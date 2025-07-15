package leetcode

import scala.:+
import scala.io.StdIn.readLine

object TwoSums {


  /**
   *
   * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   *
   * You may assume that each input would have exactly one solution, and you may not use the same element twice.
   *
   * You can return the answer in any order.
   */
  def main(args: Array[String]): Unit = {
    val input = readLine().split(" ").map(_.toInt)
    val targeted = readLine().trim.toInt
    println(twoSum(input, targeted).toList)

  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    nums
      .zipWithIndex
      .foldLeft((Map.empty[Int, Int], Option.empty[Array[Int]])) {
        (accum, elem) =>
          val (mapofseen, arrayresult) = accum
          val (arrayvalue, arrayindex) = elem
          val complement = target - arrayvalue
          mapofseen.get(complement) match {
            case Some(foundindex) => (mapofseen + (arrayvalue -> arrayindex), Some(Array(foundindex, arrayindex)))
            case _ => (mapofseen + (arrayvalue -> arrayindex), arrayresult)
          }

      }._2.getOrElse(Array())
  }

}