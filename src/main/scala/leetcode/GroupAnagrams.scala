package leetcode

object GroupAnagrams {
  def main(args: Array[String]): Unit = {
    println(groupAnagrams(Array("eat","tea","tan","ate","nat","bat")))
  }

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.toList.groupBy(_.sorted).view.values.toList
  }
}