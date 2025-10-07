package leetcode

import scala._

object Wordpattern {

  def main(args: Array[String]): Unit = {
    println(wordPattern("aaaa","dog cat cat dog"))
  }

  def wordPattern(pattern: String, s: String): Boolean= {
    val words = s.split(" ")
    if (words.length != pattern.length)
      false
    else {
      def loop(i: Int, m1: Map[Char, String], m2: Map[String, Char]): Boolean = {
        if (i == pattern.length) true
        else {
          val current_pattern = pattern(i)
          val current_word = words(i)
          (m1.get(current_pattern), m2.get(current_word)) match {
            case (Some(word), Some(pattern)) => {
              if ((word == current_word) && (pattern == current_pattern)) loop(i + 1, m1, m2)
              else false
            }
            case (None, None) => {
              loop(i + 1, m1 + (current_pattern -> current_word), m2 + (current_word -> current_pattern))
            }
            case _ => false
          }
        }
      }

      loop(0, Map.empty, Map.empty)
    }
  }
}