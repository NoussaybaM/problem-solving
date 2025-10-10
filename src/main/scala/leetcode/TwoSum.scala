package leetcode

object TwoSum {
  def main(args: Array[String]): Unit = {
    println(findtarget(Array(3, 3), 6))
  }

  def findtarget(nums: Array[Int], target: Int): Array[Int] = {
    nums.zipWithIndex.foldLeft((Map.empty[Int, Int], Array.emptyIntArray)) {
      (accum, elem) =>
        val (mapofseen, res) = accum
        val (arrayvalue, arrayindex) = elem
        val complement = target - arrayvalue
        mapofseen.get(complement) match {
          case Some((foundindex)) => (mapofseen + (arrayvalue -> arrayindex), Array(arrayindex, foundindex))
          case _ => (mapofseen + (arrayvalue -> arrayindex), res)
        }
    }._2
  }
}