package leetcode

object containsNearbyDuplicate {
  def main(args: Array[String]): Unit = {
    println(containsNearbyDuplicate(Array(1, 2, 3, 1, 2, 3), 2))
  }

  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    nums.zipWithIndex.foldLeft((Map.empty[Int, List[Int]], false)) {
      (accum, currenteleminarray) => {
        val (seen, res) = accum
        seen.get(currenteleminarray._1) match {
          case Some(equalelemindex) if equalelemindex.exists(x => math.abs(x - currenteleminarray._2) <= k) => (seen, true)
          case Some(indexes) => (seen + ((currenteleminarray._1, currenteleminarray._2 :: indexes)), res)

          case _ => (seen + (currenteleminarray._1 -> List(currenteleminarray._2)), res)
        }
      }
    }._2
  }
}