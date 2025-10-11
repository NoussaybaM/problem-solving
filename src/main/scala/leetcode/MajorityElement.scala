package leetcode

object MajorityElement {
  def main(args: Array[String]): Unit = {
    println(findmajority2(Array(1,1,2)))
  }
//  def findmajority(nums: Array[Int]): Unit = {
//    var count = 0
//    var candidate = 0
//    for (num <- nums) {
//      if (count == 0) {
//        candidate = num
//      }
//      if (num == candidate)
//        count += 1
//      else
//        count -= 1
//    }
//
//  }


  def findmajority2(nums: Array[Int]): Int = {
    nums.groupBy(identity).find(_._2.length >= nums.length/2).get._1
  }
}