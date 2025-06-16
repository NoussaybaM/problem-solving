package cses

import scala.io.StdIn.readLine

object MissingNumber {
  def main(args: Array[String]): Unit = {

    val n = readLine().trim.toInt
    val inputList = readLine().split(" ").toList
    val elemsExist = new Array[Boolean](n)

    inputList.foreach(elem => {
      val elemConverted = elem.toInt - 1
      elemsExist.update(elemConverted, true)
    })

    println(elemsExist.indexWhere(!_) + 1)

  }
}
