package leetcode

object MergeSortedList {


  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    (list1, list2) match {
      case (_, null) => list1
      case (null, _) => list2
      case (_, _) if (list1.x < list2.x) => {
        new ListNode(list1.x, mergeTwoLists(list1.next, list2))
      }
      case _ => new ListNode(list2.x, mergeTwoLists(list1, list2.next))
    }
  }
}