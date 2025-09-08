package programs.algoexpert

import programs.utils.BinaryTree


private var maxSum = Integer.MIN_VALUE


fun maxPathSum(tree: BinaryTree): Int {
    // Start the recursive calculation. The initial return value is not used.
    findMaxGain(tree)
    // The result is the maxSum found during the traversal.
    return maxSum
}

private fun findMaxGain(node: BinaryTree?): Int {
    // Base Case: A null node contributes nothing to a path.
    if (node == null) {
        return 0
    }

    // 1. Recursively find the max gain from left and right children.
    //    Use maxOf(0, ...) to ignore any negative path sums, as we would rather not include them.
    val leftGain = maxOf(0, findMaxGain(node.left))
    val rightGain = maxOf(0, findMaxGain(node.right))

    // 2. Calculate the max path sum with the current `node` as the highest point (the "bend").
    //    This is a potential candidate for the overall maximum sum.
    val newPathSum = node.value + leftGain + rightGain
    maxSum = maxOf(maxSum, newPathSum)

    // 3. For the recursion upwards, return the maximum gain from a "straight" path.
    //    A path going up to the parent can't include both children, so we pick the better one.
    return node.value + maxOf(leftGain, rightGain)
}

fun main() {
    // Let's build the tree from the example:
    //       -10
    //       /   \
    //      9     20
    //           /  \
    //          15   7
    val root = BinaryTree(-10)
    root.left = BinaryTree(9)
    root.right = BinaryTree(20)
    root.right?.left = BinaryTree(15)
    root.right?.right = BinaryTree(7)

    val result = maxPathSum(root)
    println("Maximum Path Sum: $result") // Expected: 42
}