package leetcode

object besttimetobuy {
  def canJump(nums: Array[Int]): Boolean = {
    val x= nums.zipWithIndex.map(elem=>{
      val maxdistance= elem._2+elem._1
      maxdistance>=nums.length-1
    } )
    println(x.toList)
    if(nums.length==1 && nums(0)==true) true
    else
    {x.take(nums.length -1).find(_==true).getOrElse(false) }
  }
}