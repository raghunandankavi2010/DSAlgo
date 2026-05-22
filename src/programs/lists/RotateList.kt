/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package programs.lists

fun main() {
    // 1. Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }

    val k = 2
    println("Original List:")
    printList(head)

    // 2. Rotate the list
    val rotatedHead = rotateRight(head, k)

    println("Rotated List by $k:")
    printList(rotatedHead)
}

private fun rotateRight(head: ListNode?, k: Int): ListNode? {
    // 1. Edge cases: empty list or single node
    if (head?.next == null || k == 0) return head

    // 2. Compute length and find the actual tail
    var lastNode = head
    var length = 1
    while (lastNode?.next != null) {
        lastNode = lastNode.next
        length++
    }

    // 3. Adjust k in case k > length
    val actualK = k % length
    if (actualK == 0) return head

    // 4. Two-pointer strategy:
    // Move 'fast' to the kth node from the beginning
    var fast = head
    repeat(actualK) {
        fast = fast?.next
    }

    // Move both until 'fast' reaches the end
    var slow = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next
    }

    // 5. Rearrange pointers
    val newHead = slow?.next
    slow?.next = null    // Break the link
    fast?.next = head    // Connect old tail to old head

    return newHead
}

// Helper function to display the list
private fun printList(head: ListNode?) {
    var current = head
    val nodes = mutableListOf<String>()
    while (current != null) {
        nodes.add("${current.`val`}")
        current = current.next
    }
    println(nodes.joinToString(" -> "))
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}