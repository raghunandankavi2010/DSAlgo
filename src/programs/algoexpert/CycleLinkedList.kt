package programs.algoexpert

import programs.utils.LinkedList

private fun findLoop(head: LinkedList): LinkedList? {

    var fastPtr: LinkedList? = head
    var slowPtr: LinkedList? = head

    while (fastPtr?.next != null) {
        slowPtr = slowPtr?.next
        fastPtr = fastPtr.next?.next

        if (slowPtr == fastPtr) {
            break
        }
    }

    if (fastPtr?.next == null) {
        return null
    }

    slowPtr = head
    while (slowPtr != fastPtr) {
        slowPtr = slowPtr?.next
        fastPtr = fastPtr?.next
    }

    return slowPtr
}

fun main() {

    // 1. Create a linear linked list: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    val head = LinkedList(0)
    var currentNode = head
    var loopStartNode: LinkedList? = null // This will hold the node where the loop starts

    for (i in 1..9) {
        val newNode = LinkedList(i)
        currentNode.next = newNode
        currentNode = newNode

        // We'll choose node '4' as the start of our loop. Let's save a reference to it.
        if (i == 4) {
            loopStartNode = currentNode
        }
    }
    // At this point, `currentNode` is the tail of the list (node 9).

    // 2. Create the cycle: Make the tail (node 9) point back to node 4.
    currentNode.next = loopStartNode

    println("Test list created. The loop starts at node with value: ${loopStartNode?.value}")
    println("-------------------------------------------------")

    // 3. Call your function to find the loop
    val foundNode = findLoop(head)

    // 4. Verify the result
    println("Your function found the loop starting at node with value: ${foundNode?.value}")

    // We use '===' to check for reference equality (if they are the exact same object)
    if (foundNode === loopStartNode) {
        println("\n✅ Success! Your function correctly identified the start of the loop.")
    } else {
        println("\n❌ Keep trying! The function did not return the correct node.")
    }
}