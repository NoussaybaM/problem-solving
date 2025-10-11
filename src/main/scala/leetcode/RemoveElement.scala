package leetcode

object RemoveElement {
  def main(args: Array[String]): Unit = {

  }

  def removeElement(nums: Array[Int], `val`: Int): Int = {
    nums.indices.foreach(index=> {
      if (nums(index)==`val`){
        nums(index)= -1
      }
    }
    )
    nums.sortInPlaceWith(_>_).count(_>=0)
    }
}