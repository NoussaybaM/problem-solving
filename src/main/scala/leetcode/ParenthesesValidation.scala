package leetcode

import scala.io.StdIn.readLine

object ParenthesesValidation {

  def main(args: Array[String]): Unit = {
    val input = readLine().trim
    println(isValid(input))
  }

  def isValid(s: String): Boolean = {

    s.toList.foldLeft((0, 0, 0, true))(
      (checkValidation, elem) => {
        val (numParentheses, numAlcolades, numBrackets, isvalid) = checkValidation
        isvalid match {
          case true => {
            elem match {
              case '(' => (numParentheses + 1, numAlcolades, numBrackets, isvalid)
              case '[' => (numParentheses, numAlcolades + 1, numBrackets, isvalid)
              case '{' => (numParentheses, numAlcolades, numBrackets + 1, isvalid)
              case ')' if numParentheses - 1 < 0 => (numParentheses - 1, numAlcolades, numBrackets, false)
              case ']' if numAlcolades - 1 < 0 => (numParentheses, numAlcolades - 1, numBrackets, false)
              case '}' if numBrackets - 1 < 0 => (numParentheses, numAlcolades, numBrackets - 1, false)
              case ')' => (numParentheses - 1, numAlcolades, numBrackets, isvalid)
              case ']' => (numParentheses, numAlcolades - 1, numBrackets, isvalid)
              case '}' => (numParentheses, numAlcolades, numBrackets - 1, isvalid)
            }
          }
          case false => (numParentheses, numAlcolades, numBrackets, false)
        }
      }
    )._4
  }
}