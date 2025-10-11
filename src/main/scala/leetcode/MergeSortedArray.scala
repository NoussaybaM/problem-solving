package leetcode

object MergeSortedArray {
  def main(args: Array[String]): Unit = {
    println(merge(Array(1,2,3,0,0,0),3,Array(2,5,6),3))
  }

  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    def loop(ni: Int, mi: Int, zi: Int): Unit = {
      if (ni<0) ()
      else{
        if(mi>=0 && nums1(mi)>nums2(ni)){
          nums1(zi)=nums1(mi)
          loop(ni,mi-1,zi-1)
        }else{
          nums1(zi)=nums2(ni)
          loop(ni-1,mi,zi-1)
        }
      }

    }

    loop(n-1, m-1, n + m-1)

  }
}