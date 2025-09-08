package programs.algoexpert

import programs.utils.BinaryTree


fun main() {

    val root = BinaryTree(1)
    root.left = BinaryTree(2)
    root.right = BinaryTree(3)
    root.left?.left = BinaryTree(4)
    root.left?.right = BinaryTree(5)
    root.right?.left = BinaryTree(6)
    root.right?.right = BinaryTree(7)

    val result = branchSums(root)

    println("The branch sums are: $result")
}

private fun branchSums(root: BinaryTree): List<Int> {
    val sums = mutableListOf<Int>()
    calculateBranchSums(root, 0, sums)
    return sums
}

private fun calculateBranchSums(node: BinaryTree?, runningSum: Int, sums: MutableList<Int>) {

    if (node == null) {
        return
    }

    val newRunningSum = runningSum + node.value

    if (node.left == null && node.right == null) {
        sums.add(newRunningSum)
        return
    }

    calculateBranchSums(node.left, newRunningSum, sums)
    calculateBranchSums(node.right, newRunningSum, sums)
}

