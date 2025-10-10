package leetcode

object longestconsecutivesequence {
  def main(args: Array[String]): Unit = {}

  def longestconsecutive(nums: Array[Int]): Int = {
    val numset = nums.toSet
    numset.foldLeft(0) {
      (accum, current) => {
        //looking for the start of the sequence: this is the trick
        //how do you know it s a start of sequence, it's by not finding its -1
        //we should be keeping a max of longest sequence to compare with it
        if (!numset.contains(current - 1)) {
          //it s the start of sequence
          //now we should look for the consecutives
          val length = LazyList.iterate(current)(_ + 1).takeWhile(numset.contains).length
          accum max length
        }
        else
          accum
      }
    }
  }
}