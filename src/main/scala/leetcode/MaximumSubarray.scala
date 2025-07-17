package leetcode

import scala.collection.View.Empty

object MaximumSubarray {
  /*
  Given an integer array nums, find the subarray with the largest sum, and return its sum.


   */

  //[-2,1,-3,4,-1,2,1,-5,4]

  //  def maxSubArray(nums: Array[Int]): Int = {
  //    val globalMax = nums.min
  //
  //    def loop(subarr: List[Int], newMax: Int): Int = {
  //      subarr match {
  //        case Nil => newMax
  //        case xs => {
  //          val localmax = extractLocalMax(xs)
  //          val globmax = newMax max localmax
  //          loop(xs.tail, globmax)
  //        }
  //      }
  //    }
  //
  //    def extractLocalMax(input: List[Int]): Int = {
  //      //we have a list we want to have the list containing the sum of each sub array
  //      val extractingSumProcess = input.foldLeft(List[Int](), 0)(
  //        (Summation, arrayvalue) => {
  //          val (listOfSums, lastSummation) = Summation
  //          val newSummation = lastSummation + arrayvalue
  //          (listOfSums.appended(newSummation), newSummation)
  //        }
  //      )
  //      //among this list of sums, get the max one
  //      extractingSumProcess._1.max
  //
  //    }
  //
  //    nums.toList match {
  //      case Nil => 0
  //      case values => loop(values, globalMax)
  //    }
  //  }

  def maxSubArray(nums: Array[Int]): Int = {
    nums.toList match {
      case Nil => 0
      case x :: Nil => x
      case x :: xs => {
        xs.foldLeft((x, x))(
          (maxes, arrayvalue) => {
            val (currentmax, globalmax) = maxes
            val newcurrentmax = (currentmax + arrayvalue) max arrayvalue
            val newglobalmax = globalmax max newcurrentmax
            (newcurrentmax, newglobalmax)
          }
        )._2
      }
    }
  }


}