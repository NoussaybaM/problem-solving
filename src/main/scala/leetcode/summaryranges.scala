package leetcode

object summaryranges {
  def main(args: Array[String]): Unit = {
    println(summaryRanges(Array(0, 1, 2, 4, 5, 7)))
  }

  //  Input: nums = [0,1,2,4,5,7]
  //  Output: ["0->2","4->5","7"]
  def summaryRanges(nums: Array[Int]): List[String] = {
    if (nums.length == 0) {
      List.empty[String]
    }
    else {
      val first = nums.apply(0)
      val (start, end, res) = nums.tail.foldLeft(first, first, List.empty[String]) {
        (accum, curr) => {
          val (bornemin, lastparcours, res) = accum
          if (curr != lastparcours + 1) {
            val interval = if (bornemin == lastparcours) {
              bornemin.toString
            } else {
              bornemin.toString + "->" + lastparcours.toString
            }

            (curr, curr, interval :: res)
          } else {
            (bornemin, curr, res)
          }
        }
      }
      val interval = if (start == end) {
        start.toString
      } else {
        start.toString + "->" + end.toString
      }
      val resres=interval :: res
      resres.reverse
    }
  }
}