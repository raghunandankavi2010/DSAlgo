package programs.algoexpert

import programs.utils.LinkedList
import programs.utils.printList

fun main() {
    val head = LinkedList(0)
    head.next = LinkedList(1)
    head.next!!.next = LinkedList(2)
    head.next!!.next!!.next = LinkedList(3)
    head.next!!.next!!.next!!.next = LinkedList(4)
    head.next!!.next!!.next!!.next!!.next = LinkedList(5)
    head.next!!.next!!.next!!.next!!.next!!.next = null
    val headNode = nodeSwap(head)
    headNode.printList()
}

fun nodeSwap(head: LinkedList): LinkedList {
    if (head.next == null) {
        return head
    }

    val dummy = LinkedList(-1)
    dummy.next = head

    var prevNode: LinkedList = dummy

    var current: LinkedList? = head

    while (current?.next != null) {
        val firstNode = current
        val secondNode = current.next!!

        prevNode.next = secondNode
        firstNode.next = secondNode.next
        secondNode.next = firstNode

        prevNode = firstNode
        current = firstNode.next
    }


    return dummy.next!!
}