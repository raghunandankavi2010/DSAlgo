package programs.algoexpert

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


fun printList(head: LinkedList?) {
    if (head == null) {
        println("List is empty.")
        return
    }
    var current: LinkedList? = head
    val listStr = StringBuilder()
    while (current != null) {
        listStr.append("${current.value} -> ")
        current = current.next
    }
    listStr.append("null")
    println(listStr.toString())
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
    printList(head)

    val listWithoutDuplicates = removeDuplicatesFromLinkedList(head)

    println("\nList after removing duplicates:")
    printList(listWithoutDuplicates)

    println("\nExpected final output: 1 -> 3 -> 4 -> 5 -> 6 -> null")
}