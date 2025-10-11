package leetcode

object RemoveDuplicatesFromSortedArray {
  def main(args: Array[String]): Unit = {
  println(removeduplidates2(Array(1,1,2)))
  }

  def removeDuplicates(nums: Array[Int]): Int = {
    val numset = nums.distinct.zipWithIndex.toMap
    numset.foreach(num => {
      nums(num._2) = num._1
    })
    numset.keys.toList.length
  }

  def removeduplidates2(nums: Array[Int]): Int = {
    def loop(fast:Int,slow:Int,numsi:Array[Int],occurence:Int):Int={
      if (fast==numsi.length-1) slow+1
      else{
        if(numsi(fast)!=numsi(slow)){
          numsi(slow+1)=numsi(fast)
          loop(fast+1,slow+1,numsi,1)
        }else if (numsi(fast)==numsi(slow) && occurence<2) {
          numsi(slow+1)=numsi(fast)
          loop(fast+1,slow+1,numsi,occurence+1)
        }else{
          loop(fast+1,slow,numsi,occurence+1)
        }
      }
    }
    loop(1,0,nums,1)
  }
}