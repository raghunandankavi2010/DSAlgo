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

package programs.algoexpert

import programs.utils.LinkedList
import programs.utils.printList
import programs.utils.createList

fun main() {
    val head = createList(listOf(1, 2, 3, 4, 5, 6))

    println("Original list:")
    head.printList()
    println("--------------------")

    // Positive case
    println("Shifting by k = 2:")
    var shiftedList = shiftLinkedList(createList(listOf(1, 2, 3, 4, 5, 6)), 2)
    shiftedList.printList() // Expected: 5 -> 6 -> 1 -> 2 -> 3 -> 4

    // Negative case
    println("\nShifting by k = -2:")
    shiftedList = shiftLinkedList(createList(listOf(1, 2, 3, 4, 5, 6)), -2)
    shiftedList.printList() // Expected: 3 -> 4 -> 5 -> 6 -> 1 -> 2

}

private fun shiftLinkedList(head: LinkedList?, k: Int): LinkedList? {

    if (head?.next == null || k == 0) {
        return head
    }

    var listLength = 1
    var tail = head
    while (tail?.next != null) {
        tail = tail.next
        listLength++
    }

    val offset = k % listLength
    if (offset == 0) {
        return head
    }

    val newTailPosition = if (offset > 0) listLength - offset else -offset

    tail?.next = head


    var newTail = head
    for (i in 1 until newTailPosition) {
        newTail = newTail?.next
    }

    val newHead = newTail?.next
    newTail?.next = null

    return newHead
}

// Helper function to create a list from values
