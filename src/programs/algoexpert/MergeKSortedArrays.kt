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

import java.util.PriorityQueue

private data class Node(val value: Int, val listIndex: Int, val elementIndex: Int)


fun mergeSortedArrays(arrays: List<List<Int>>): List<Int> {

    val result = mutableListOf<Int>()

    if (arrays.isEmpty()) {
        return result
    }

    val minHeap = PriorityQueue<Node>(compareBy { it.value })


    for ((listIndex, list) in arrays.withIndex()) {
        if (list.isNotEmpty()) {
            val firstElementValue = list[0]
            minHeap.add(Node(value = firstElementValue, listIndex = listIndex, elementIndex = 0))
        }
    }

    while (minHeap.isNotEmpty()) {

        val smallestNode = minHeap.poll()

        result.add(smallestNode.value)

        val sourceListIndex = smallestNode.listIndex
        val nextElementIndex = smallestNode.elementIndex + 1

        val sourceList = arrays[sourceListIndex]

        if (nextElementIndex < sourceList.size) {
            val nextValue = sourceList[nextElementIndex]
            val nextNode = Node(value = nextValue, listIndex = sourceListIndex, elementIndex = nextElementIndex)
            minHeap.add(nextNode)
        }
    }

    return result
}


fun main() {
    val list1 = listOf(1, 4, 5, 8)
    val list2 = listOf(2, 3, 6, 9)
    val list3 = listOf(0, 7, 10)
    val emptyList = listOf<Int>()

    val arrays = listOf(list1, list2, list3, emptyList)
    val mergedList = mergeSortedArrays(arrays)

    println("Input lists:")
    arrays.forEach { println(it) }

    println("\nMerged and Sorted List:")
    println(mergedList) // Expected output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
}