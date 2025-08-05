package programs.algoexpert

import programs.utils.LinkedList
import programs.utils.printList

fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {
    var currentNode: LinkedList? = linkedList

    while (currentNode?.next != null) {

        if (currentNode.value == currentNode.next!!.value) {
            currentNode.next = currentNode.next!!.next
        } else {
            currentNode = currentNode.next
        }
    }

    return linkedList
}





fun main() {

    val head = LinkedList(1)


    head.next = LinkedList(3)
    head.next!!.next = LinkedList(4)
    head.next!!.next!!.next = LinkedList(4)
    head.next!!.next!!.next!!.next = LinkedList(4)
    head.next!!.next!!.next!!.next!!.next = LinkedList(5)
    head.next!!.next!!.next!!.next!!.next!!.next = LinkedList(6)
    head.next!!.next!!.next!!.next!!.next!!.next!!.next = LinkedList(6)

    println("Original List:")
   head.printList()

    val listWithoutDuplicates = removeDuplicatesFromLinkedList(head)

    println("\nList after removing duplicates:")
    listWithoutDuplicates.printList()

    println("\nExpected final output: 1 -> 3 -> 4 -> 5 -> 6 -> null")
}