package programs.algoexpert

import programs.utils.LinkedList
import programs.utils.printList


fun main() {
    val list = LinkedList(1)
    list.next = LinkedList(2)
    list.next!!.next = LinkedList(3)
    list.next!!.next!!.next = LinkedList(4)
    list.next!!.next!!.next!!.next = LinkedList(5)
    list.next!!.next!!.next!!.next!!.next = LinkedList(6)
    list.next!!.next!!.next!!.next!!.next!!.next = null
    val head = zipLinkedList(list)
    head.printList()
}


private fun zipLinkedList(linkedList: LinkedList): LinkedList {
    // Write your code here.

    var slowPtr: LinkedList? = linkedList
    var fastPtr: LinkedList? = linkedList
    var prevSlowPtr: LinkedList? = null

    while (fastPtr != null) {
        fastPtr = fastPtr.next?.next
        prevSlowPtr = slowPtr
        slowPtr = slowPtr?.next
    }

    if (fastPtr != null) {
        slowPtr = slowPtr?.next
    }

    prevSlowPtr?.next = null


    var first: LinkedList? = linkedList
    var second: LinkedList? = reverseList(slowPtr)

    while (first != null && second != null) {
        val tempFirstNext = first.next
        val tempSecondNext = second.next

        first.next = second
        second.next = tempFirstNext

        first = tempFirstNext
        second = tempSecondNext
    }

    return linkedList
}


private fun reverseList(head: LinkedList?): LinkedList? {
    var current: LinkedList? = head
    var prev: LinkedList? = null

    while (current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }

    return prev

}