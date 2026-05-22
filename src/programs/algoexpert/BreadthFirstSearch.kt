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

import java.util.LinkedList
import java.util.Queue

class TreeNode(name: String) {
    val name: String = name
    val children = mutableListOf<TreeNode>()

    fun breadthFirstSearch(): List<String> {

        val result = mutableListOf<String>()

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(this)

        while(queue.isNotEmpty()) {
            val node = queue.poll()

            result.add(node.name)

            for(childNodes in node.children) {
                queue.add(childNodes)
            }
        }

        return result
    }

    fun addChild(name: String): TreeNode {
        val childNode = TreeNode(name)
        children.add(childNode)
        return this
    }
}

fun main() {

    val graph = TreeNode("A")
    graph.addChild("B").addChild("C").addChild("D")
    graph.children[0].addChild("E").addChild("F")
    graph.children[2].addChild("G").addChild("H")
    graph.children[0].children[1].addChild("I").addChild("J")

    // 2. Call your function to perform the BFS
    val bfsResult = graph.breadthFirstSearch()

    // 3. Print the result and compare with the expected output
    println("BFS Result:      $bfsResult")
    println("Expected Result: [A, B, C, D, E, F, G, H, I, J]")

    // Verify the result
    if (bfsResult == listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")) {
        println("\n✅ Success! The implementation is correct.")
    } else {
        println("\n❌ Keep trying! The result does not match the expected output.")
    }
}