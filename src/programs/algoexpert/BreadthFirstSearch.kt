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