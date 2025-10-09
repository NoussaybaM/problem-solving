package leetcode

object IsAnagram {
  def main(args: Array[String]): Unit = {
    println(isAnagram("rat","car"))
  }

  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length) false
    else {
      val m1 = s.groupBy(identity).view.mapValues(_.length).toMap
      println(m1)
      val m2 = t.groupBy(identity).view.mapValues(_.length).toMap
      m1 == m2
    }
  }

}