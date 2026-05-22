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

package programs.utils

open class LinkedList(var value: Int) {
    var next: LinkedList? = null
}

fun LinkedList?.printList() {
    val head = this
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

fun createList(values: List<Int>): LinkedList {
    val head = LinkedList(values.first())
    var current = head
    for (i in 1 until values.size) {
        current.next = LinkedList(values[i])
        current = current.next!!
    }
    return head
}

