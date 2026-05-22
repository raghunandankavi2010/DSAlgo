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

fun printLinkedList(head: LinkedList?) {
    if (head == null) {
        println("null")
        return
    }
    var current: LinkedList? = head
    val nodes = mutableListOf<Int>()
    while (current != null) {
        nodes.add(current.value)
        current = current.next
    }
    println(nodes.joinToString(" -> "))
}


fun main() {

    val listOne = LinkedList(2)
    listOne.next = LinkedList(4)
    listOne.next!!.next = LinkedList(7)
    listOne.next!!.next!!.next = LinkedList(1)


    val listTwo = LinkedList(9)
    listTwo.next = LinkedList(4)
    listTwo.next!!.next = LinkedList(5)

    println("--- Input Lists ---")
    print("List One (represents 2471): ")
    printLinkedList(listOne)

    print("List Two (represents 945):  ")
    printLinkedList(listTwo)
    println()

    val sumResult = sumOfLinkedLists(listOne, listTwo)

    println("--- Output ---")
    print("Result of Sum: ")
    printLinkedList(sumResult)
}

fun sumOfLinkedLists(l1: LinkedList, l2: LinkedList): LinkedList {
    val dummyHead = LinkedList(0)
    var currentNode = dummyHead

    var p1: LinkedList? = l1
    var p2: LinkedList? = l2
    var carry = 0

    while (p1 != null || p2 != null || carry != 0) {
        val val1 = p1?.value ?: 0
        val val2 = p2?.value ?: 0

        val sum = val1 + val2 + carry

        val newNodeValue = sum % 10
        carry = sum / 10

        val newNode = LinkedList(newNodeValue)
        currentNode.next = newNode

        currentNode = newNode

        p1 = p1?.next
        p2 = p2?.next
    }

    return dummyHead.next!!
}