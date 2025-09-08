package programs.algoexpert

import programs.utils.BinaryTree
import java.util.* // For Queue, LinkedList, HashMap, HashSet

private fun findNodesDistanceK(tree: BinaryTree, target: Int, k: Int): List<Int> {
    // Step 1: Populate the parent map
    val parentMap = HashMap<BinaryTree, BinaryTree>()
    populateParentMap(parentMap, tree, null)

    // Step 2: Find the target node
    val targetNode = findNode(tree, target)
        ?: return listOf() // If target node not found, return empty list

    // Step 3: Perform BFS from the target node
    val result = mutableListOf<Int>()
    val queue: Queue<BinaryTree> = LinkedList()
    val seen = HashSet<BinaryTree>()

    // Handle k=0 case immediately
    if (k == 0) {
        result.add(targetNode.value)
        return result
    }

    queue.add(targetNode)
    seen.add(targetNode)

    var currentDistance = 0

    while (queue.isNotEmpty()) {
        val levelSize = queue.size

        // Process all nodes at the current level
        for (i in 0 until levelSize) {
            val currentNode = queue.remove()

            // Add left child if not seen
            if (currentNode.left != null && !seen.contains(currentNode.left)) {
                queue.add(currentNode.left)
                seen.add(currentNode.left!!) // Use !! after null check if it's guaranteed not null
            }

            // Add right child if not seen
            if (currentNode.right != null && !seen.contains(currentNode.right)) {
                queue.add(currentNode.right)
                seen.add(currentNode.right!!)
            }

            // Add parent if not seen
            val parent = parentMap[currentNode]
            if (parent != null && !seen.contains(parent)) {
                queue.add(parent)
                seen.add(parent)
            }
        }

        currentDistance++ // Increment distance AFTER processing all nodes at the previous level

        // If we've reached the k-th distance, collect its contents
        if (currentDistance == k) {
            for (node in queue) {
                result.add(node.value)
            }
            return result // Found all nodes at distance k, so we can stop
        }
    }

    return result // Should typically be found within the loop, but for safety
}

// Helper function to populate the parent map
private fun populateParentMap(parentMap: HashMap<BinaryTree, BinaryTree>, node: BinaryTree?, parent: BinaryTree?) {
    if (node == null) {
        return
    }
    if (parent != null) { // Root has no parent, so only map for non-root nodes
        parentMap[node] = parent
    }
    populateParentMap(parentMap, node.left, node)
    populateParentMap(parentMap, node.right, node)
}

// Helper function to find the target node in the tree
private fun findNode(node: BinaryTree?, target: Int): BinaryTree? {
    if (node == null) {
        return null
    }
    if (node.value == target) {
        return node
    }
    val leftResult = findNode(node.left, target)
    if (leftResult != null) {
        return leftResult
    }
    return findNode(node.right, target)
}


// --- Example Usage (Main function for testing) ---
fun main() {
    // Example Tree:
    //        5
    //       / \
    //      3   7
    //     / \ / \
    //    2  4 6  8

    val root = BinaryTree(5)
    root.left = BinaryTree(3)
    root.right = BinaryTree(7)
    root.left!!.left = BinaryTree(2)
    root.left!!.right = BinaryTree(4)
    root.right!!.left = BinaryTree(6)
    root.right!!.right = BinaryTree(8)

    // Test cases
    println("Nodes at distance 2 from target 3:")
    println(findNodesDistanceK(root, 3, 2)) // Expected: [5, 6, 8]

    println("Nodes at distance 1 from target 5:")
    println(findNodesDistanceK(root, 5, 1)) // Expected: [3, 7]

    println("Nodes at distance 0 from target 4:")
    println(findNodesDistanceK(root, 4, 0)) // Expected: [4]

    println("Nodes at distance 3 from target 2:")
    println(findNodesDistanceK(root, 2, 3)) // Expected: [7, 8]

    println("Nodes at distance 1 from non-existent target 9:")
    println(findNodesDistanceK(root, 9, 1)) // Expected: []
}