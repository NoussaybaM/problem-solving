package leetcode

object BulbSwitcher {
  def main(args: Array[String]): Unit = {
    println(bulbSwitch(4))
  }

  def bulbSwitch(n: Int): Int = {
    val bulbs = Array.fill(n)(false) // all off
    for (round <- 1 to n) {
      for (switcher <- round to n by round) {
        bulbs(switcher - 1) = !bulbs(switcher - 1) //toggle
      }
    }
    bulbs.count(_ == true)
  }
}