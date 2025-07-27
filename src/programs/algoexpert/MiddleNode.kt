package programs.algoexpert

open class MyLinkedList(value: Int) {
    var value = value
    var next: MyLinkedList? = null

    fun add(newValue: Int): MyLinkedList {
        var currentNode = this
        while (currentNode.next != null) {
            currentNode = currentNode.next!!
        }
        currentNode.next = MyLinkedList(newValue)
        return this
    }
}

fun middleNode(linkedList: MyLinkedList): MyLinkedList? {
    // Write your code here.
    var slow: MyLinkedList? = linkedList
    var fast: MyLinkedList? = linkedList
    var count = 0
    while(fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        count++
    }
    return slow
}

fun main() {
    // Example 1: Odd number of nodes
    val headOdd = MyLinkedList(2)
    headOdd.add(7).add(3).add(5)

    print("List 1: ")
    var currentOdd: MyLinkedList? = headOdd
    while (currentOdd != null) {
        print("${currentOdd.value} -> ")
        currentOdd = currentOdd.next
    }
    println("null")

    val middle1 = middleNode(headOdd)
    println("Middle node value for List 1 is: ${middle1?.value}") // Expected: 3
    println("---")

    // Example 2: Even number of nodes
    val headEven = MyLinkedList(1)
    headEven.add(2).add(3).add(4).add(5)

    print("List 2: ")
    var currentEven: MyLinkedList? = headEven
    while (currentEven != null) {
        print("${currentEven.value} -> ")
        currentEven = currentEven.next
    }
    println("null")

    val middle2 = middleNode(headEven)
    println("Middle node value for List 2 is: ${middle2?.value}") // Expected: 4
}