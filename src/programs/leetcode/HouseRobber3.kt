package programs.leetcode

import programs.utils.TreeNode

// Main function to test the solution
fun main() {
    // Example 1: root = [3,2,3,null,3,null,1]
    // Expected Output: 7
    val root1 = TreeNode(3)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    root1.left?.right = TreeNode(3) // null is handled by not assigning
    root1.right?.right = TreeNode(1)

    val result1 = rob(root1)
    println("Example 1 Input: [3,2,3,null,3,null,1]")
    println("Example 1 Output: $result1") // Should print 7
    println("------------------------------------")

    // Example 2: root = [3,4,5,1,3,null,1]
    // This example is from the problem description (though not included above).
    // Let's create it for good measure.
    // Expected Output: 9 (4 + 5)
    val root2 = TreeNode(3)
    root2.left = TreeNode(4)
    root2.right = TreeNode(5)
    root2.left?.left = TreeNode(1)
    root2.left?.right = TreeNode(3)
    root2.right?.right = TreeNode(1)


    val result2 = rob(root2)
    println("Example 2 Input: [3,4,5,1,3,null,1]")
    println("Example 2 Output: $result2") // Should print 9
    println("------------------------------------")

    // Example 3: A simpler case - just a single node
    // root = [5]
    // Expected Output: 5
    val root3 = TreeNode(5)

    val result3 = rob(root3)
    println("Example 3 Input: [5]")
    println("Example 3 Output: $result3") // Should print 5
    println("------------------------------------")

    // Example 4: An empty tree
    // root = [] (or null)
    // Expected Output: 0
    val root4: TreeNode? = null
    val result4 = rob(root4)
    println("Example 4 Input: []")
    println("Example 4 Output: $result4") // Should print 0
    println("------------------------------------")
}

private val memo = mutableMapOf<TreeNode?, IntArray>()

fun rob(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val result = dfs(root)
    return result[0].coerceAtLeast(result[1])
}

private fun dfs(node: TreeNode?): IntArray {
    if (node == null) {
        return intArrayOf(0, 0)
    }

    if (memo.containsKey(node)) {
        return memo[node]!!
    }

    val leftResult = dfs(node.left)
    val rightResult = dfs(node.right)

    val robCurrent = node.`val` + leftResult[0] + rightResult[0]

    val notRobCurrent = leftResult[0].coerceAtLeast(leftResult[1]) + rightResult[0].coerceAtLeast(rightResult[1])

    val result = intArrayOf(notRobCurrent, robCurrent)
    memo[node] = result
    return result
}
