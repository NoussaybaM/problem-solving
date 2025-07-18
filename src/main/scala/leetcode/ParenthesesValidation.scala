package leetcode

import scala.io.StdIn.readLine

object ParenthesesValidation {

  def main(args: Array[String]): Unit = {
    val input = readLine().trim
    println(isValid(input))
  }

//  def isValid(s: String): Boolean = {
//    val matching = Map(')' -> '(', ']' -> '[', '}' -> '{')
//    if (s.toList.length > 1) {
//      val res = s.toList.foldLeft(List.empty[Char], true)(
//        (stack, elem) => {
//          if (matching.values.toList.contains(elem)) {
//            (elem :: stack._1, stack._2)
//          } else {
//            stack._1 match {
//              case x :: xs if (matching(elem) == x) => (xs, stack._2)
//              case x :: xs => (xs, false)
//              case Nil => (Nil, stack._2)
//            }
//          }
//        }
//      )
//      res._2 && res._1.isEmpty
//    }
//    else false
//  }
  //corrected solution:
  def isValid(s: String): Boolean = {
    val matching = Map(')' -> '(', ']' -> '[', '}' -> '{')

    val (finalStack, isValid) = s.toList.foldLeft((List.empty[Char], true)) {
      case ((stack, true), char) if matching.values.toSet.contains(char) =>
        // Opening bracket → push to stack
        (char :: stack, true)

      case ((x :: xs, true), char) if matching.contains(char) && matching(char) == x =>
        // Valid closing bracket → pop
        (xs, true)

      case ((_, true), char) if matching.contains(char) =>
        // Mismatched or unbalanced closing bracket
        (Nil, false)

      case ((stack, valid), _) =>
        // Already invalid → keep propagating
        (stack, valid)
    }

    isValid && finalStack.isEmpty
  }

}