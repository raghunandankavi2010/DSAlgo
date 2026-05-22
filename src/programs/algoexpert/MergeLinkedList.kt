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


private fun mergeLinkedLists(headOne: LinkedList, headTwo: LinkedList): LinkedList {

    var first: LinkedList? = headOne
    var two: LinkedList? = headTwo
    val dummyHead = LinkedList(-1)

    var tail: LinkedList? = dummyHead

    while(first != null && two != null) {
        if(first.value < two.value) {
            tail?.next = first
            first = first.next
        } else {
           tail?.next = two
            two = two.next
        }

        tail = tail?.next
    }
    tail?.next = first ?: two
    println("Merged List: ${listToString(tail?.next)}")
    return dummyHead.next!!
}

fun main() {

    val listOne = LinkedList(2)
    listOne.next = LinkedList(6)
    listOne.next?.next = LinkedList(7)
    listOne.next?.next?.next = LinkedList(8)

    val listTwo = LinkedList(1)
    listTwo.next = LinkedList(3)
    listTwo.next?.next = LinkedList(4)
    listTwo.next?.next?.next = LinkedList(5)
    listTwo.next?.next?.next?.next = LinkedList(9)
    listTwo.next?.next?.next?.next?.next = LinkedList(10)

    println("List One: ${listToString(listOne)}")
    println("List Two: ${listToString(listTwo)}")

    val mergedList = mergeLinkedLists(listOne, listTwo)

    println("---------------------------------")
    println("Merged List: ${listToString(mergedList)}")
}


private fun listToString(head: LinkedList?): String {
    if (head == null) return "null"
    val parts = mutableListOf<String>()
    var currentNode = head
    while (currentNode != null) {
        parts.add(currentNode.value.toString())
        currentNode = currentNode.next
    }
    return parts.joinToString(" -> ")
}