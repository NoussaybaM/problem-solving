package leetcode

object IsomorphicString {
  def main(args: Array[String]): Unit = {
    println(isIsomorphic("egg", "add"))
  }

  def isIsomorphic(s: String, t: String): Boolean = {
    if (s.length != t.length) false
    else {
      @annotation.tailrec
      def loop(i: Int, TtoS: Map[Char, Char], sToT: Map[Char, Char]): Boolean = {
        if (i == s.length) true
        else {
          val cs = s(i)
          val ct = t(i)
          (TtoS.get(ct), sToT.get(cs)) match {
            case (Some(mappedT), Some(mappedS)) =>
              if (mappedT == mappedS) loop(i + 1, TtoS, sToT)
              else false
            case (None, None) => loop(i + 1, sToT + (cs -> ct), TtoS + (ct -> cs))
            case _ => false
          }
        }
      }
      loop(0,Map.empty,Map.empty)
    }
  }


}