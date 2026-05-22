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

import java.util.*

class LinkedLinkedList(val name: String) {
    val children = mutableListOf<LinkedLinkedList>()

    fun depthFirstSearch(): List<String> {
        val resultList = mutableListOf<String>()

        val stack = ArrayDeque<LinkedLinkedList>()

        stack.addFirst(this)

        while (stack.isNotEmpty()) {
            val currentNode = stack.removeFirst()

            resultList.add(currentNode.name)
            for (i in currentNode.children.lastIndex downTo 0) {
                stack.addFirst(currentNode.children[i])
            }
        }

        return resultList
    }


    fun addChild(name: String): LinkedLinkedList {
        val childNode = LinkedLinkedList(name)
        children.add(childNode)
        return this
    }
}


fun main() {
    // Let's build a sample tree structure:
    //
    //         A
    //       / | \
    //      B  C  D
    //     /     / \
    //    E     F   G
    //
    val graph = LinkedLinkedList("A")
    graph.addChild("B").addChild("C").addChild("D")
    graph.children[0].addChild("E")
    graph.children[2].addChild("F").addChild("G")

    val dfsResult = graph.depthFirstSearch()

    println("Depth-First Search Result (using a Stack):")
    println(dfsResult)
}