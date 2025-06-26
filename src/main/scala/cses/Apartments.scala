package cses

import scala.io.StdIn.readLine

object Apartments {
  def main(args: Array[String]): Unit = {
    val Array(n, m, k) = readLine().split(" ").map(_.toInt)
    val An = readLine().split(" ").map(_.toInt).toList.sorted.toArray //people desired size
    val Bm = readLine().split(" ").map(_.toInt).toList.sorted.toArray //app sizes

    def countAppartmrnt(i: Int, j: Int, cnt: Int): Unit = {
      if (i == n || j == m) println(cnt)
      else {
        if (An(i) >= Bm(j) - k && An(i) <= Bm(j) + k) {
          countAppartmrnt(i + 1, j + 1, cnt + 1)
        }
        else if (An(i) > Bm(j) + k) countAppartmrnt(i, j + 1, cnt)
        else if (An(i) < Bm(j) - k) countAppartmrnt(i + 1, j, cnt)
      }
    }

    countAppartmrnt(0, 0, 0)
  }
}
//4 3 5
//60 45 80 60
//30 60 75