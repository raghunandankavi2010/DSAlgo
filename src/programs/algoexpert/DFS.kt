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