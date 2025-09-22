package programs.leetcode

import programs.utils.TreeNode
import java.util.Stack


/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 */


private fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (root == null) return result

    // Stack holds Triple of (current node, path so far, sum so far)
    val stack = Stack<Triple<TreeNode, MutableList<Int>, Int>>()
    stack.push(Triple(root, mutableListOf(root.`val`), root.`val`))

    while (stack.isNotEmpty()) {
        val (node, path, sum) = stack.pop()

        // Check if it's a leaf and the sum matches
        if (node.left == null && node.right == null && sum == targetSum) {
            result.add(path)
        }

        // Push right child
        node.right?.let {
            val newPath = path.toMutableList()
            newPath.add(it.`val`)
            stack.push(Triple(it, newPath, sum + it.`val`))
        }

        // Push left child
        node.left?.let {
            val newPath = path.toMutableList()
            newPath.add(it.`val`)
            stack.push(Triple(it, newPath, sum + it.`val`))
        }
    }

    return result
}


fun main() {
    // Expected Output: 7
    val root1 = TreeNode(5)
    root1.left = TreeNode(4)
    root1.right = TreeNode(8)

    root1.right?.right = TreeNode(4)
    root1.right?.left = TreeNode(13)
    root1.right?.right?.right = TreeNode(1)
    root1.right?.right?.left = TreeNode(5)


    root1.left?.left = TreeNode(11)
    root1.left?.left?.left = TreeNode(7)
    root1.left?.left?.right = TreeNode(2)
    println(pathSum(root1, 22))

}