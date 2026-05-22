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