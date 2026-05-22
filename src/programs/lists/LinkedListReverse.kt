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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programs.lists

import programs.lists.LinkedListReverse.Node

class LinkedListReverse {
    private var head: Node? = null

    class Node(val value: Int) {
        var next: Node? = null
    }

    fun addToTheLast(node: Node?) {
        if (head == null) {
            head = node
        } else {
            var temp = head
            while (temp?.next != null) temp = temp.next

            temp?.next = node
        }
    }


    fun printList(head: Node?) {
        var temp = head
        while (temp != null) {
            System.out.format("%d ", temp.value)
            temp = temp.next
        }
        println()
    }


    fun reverseLinkedList(currentNode: Node?): Node? {
        var currentNode = currentNode
        var previousNode: Node? = null
        var nextNode: Node?
        while (currentNode != null) {
            nextNode = currentNode.next
            currentNode.next = previousNode
            previousNode = currentNode
            currentNode = nextNode
        }
        return previousNode
    }

    fun reverseLinkedListRecursion(currentNode: Node?): Node? {

        if(currentNode == null || currentNode.next == null) {
            return currentNode
        }

        val node = reverseLinkedListRecursion(currentNode.next)

        currentNode.next?.next = currentNode

        currentNode.next = null

        return node

    }


}

fun main() {
    val list = LinkedListReverse()
    // Creating a linked list
    val head = Node(1)
    list.addToTheLast(head)
    list.addToTheLast(Node(0))
    list.addToTheLast(Node(1))
    list.addToTheLast( Node(1))
    list.addToTheLast( Node(2))
    list.printList(head)
    println("After reversing Iterative")
    val newHead = list.reverseLinkedList(head)
    list.printList(newHead)
    val reverseHead = list.reverseLinkedListRecursion(head)
    println("After reversing recursive")
    list.printList(reverseHead)
}



