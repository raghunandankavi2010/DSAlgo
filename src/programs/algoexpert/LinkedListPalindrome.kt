package programs.algoexpert

import programs.utils.LinkedList
import programs.utils.createList

fun main() {
    val head: LinkedList? = createList(listOf(0, 2 ,1))
    val isPalin = linkedListPalindrome(head)

    println("List 0 -> 1 -> 2 ->2 -> 1 -> 0")
    println("Is above palin? $isPalin")

}

private fun linkedListPalindrome(head: LinkedList?): Boolean {
    // Write your code here.

    var fastPtr: LinkedList? = head
    var slowPtr: LinkedList? = head
    var prevSlowPtr: LinkedList? = null

    while(fastPtr != null) {
        fastPtr = fastPtr.next?.next
        prevSlowPtr = slowPtr
        slowPtr = slowPtr?.next
    }

    if(fastPtr != null)  {
        slowPtr = slowPtr?.next
    }

    prevSlowPtr?.next = null


    val secondHalf = reverseHalfOfLinkedList(slowPtr)
    val firstHalf = head

    return compareLists(firstHalf,secondHalf)

}


private fun compareLists(firstHalf: LinkedList?, secondHalf: LinkedList?): Boolean {

    var first: LinkedList? = firstHalf
    var second: LinkedList? = secondHalf
    var isPalin = true
    while(first != null && second != null) {
        if(first.value != second.value) {
            isPalin = false
            break
        }
        first = first.next
        second = second.next
    }
    return isPalin
}


private fun reverseHalfOfLinkedList(head: LinkedList?): LinkedList? {
    var current: LinkedList? = head
    var prev: LinkedList? = null

    while(current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }

    return prev

}