package leetcode


class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object ReverseLinkedList {
  def reverseList(head: ListNode): ListNode = {
    def reverse(curr: ListNode, previousNode: ListNode): ListNode = {
      if (curr == null) previousNode
      else {
        val temp = curr.next
        curr.next = previousNode
        reverse(temp, curr)
      }
    }

    reverse(head, null)
  }
}