package programs.algoexpert

import programs.utils.LinkedList
import programs.utils.printList

private fun removeKthNodeFromEnd(head: LinkedList, k: Int) {


    var current: LinkedList? = head
    var prev: LinkedList? = null
    var count = 1

    while(current?.next != null) {
        current = current.next
        count++
        prev = if(count > k && prev == null) {
            head
        } else {
            prev?.next
        }
    }
    if(count == k) {
        val nextNode = head.next
        head.value = nextNode!!.value
        head.next = nextNode.next
    } else {
        val next = prev?.next?.next
        prev?.next = next
    }
}
//  0 1 2 3 4 5 6 7 8 9

fun main() {
    val head = LinkedList(0)
    var current = head
    for (i in 1..9) {
        val newNode = LinkedList(i)
        current.next = newNode
        current = newNode
    }

    val k = 4

    println("Original list:")
    head.printList()
    println("---")


    println("Removing the ${k}th node from the end...")
    removeKthNodeFromEnd(head, k)
    println("---")

    println("List after removal:")
    head.printList()
}