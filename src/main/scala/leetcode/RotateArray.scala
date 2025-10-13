package leetcode

object RotateArray {
  def main(args: Array[String]): Unit = {
    println(rotate(Array(1,2),7))
  }

  def rotate(nums: Array[Int], k: Int): Unit = {
    val n= nums.length
    n match {
      case 1 => ()
      case _ => {
        val ki=k%n // it's a rotation we dont need the remaining
        println(ki)
        val subsettomove=nums.takeRight(ki)
        println(subsettomove.toList)
        val indextostop=nums.length - ki -1
        for (i <- indextostop to 0 by -1){
          nums(i+ki)=nums(i)
        }
        for( i <- 0 until ki){
          nums(i)=subsettomove(i)
        }
      }
    }
  }

  def rotate2(nums:Array[Int],k:Int):Unit={
    val n = nums.length
    val steps= k%n
    val splitindex=n-steps
    nums.drop(splitindex)++nums.take(n-splitindex)

  }
}