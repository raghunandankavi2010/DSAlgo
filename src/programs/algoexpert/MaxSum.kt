package programs.algoexpert

fun main() {

    val root = BinaryTree(1)
    root.left = BinaryTree(2)
    root.right = BinaryTree(3)
    root.left?.left = BinaryTree(4)
    root.left?.right = BinaryTree(5)
    root.right?.left = BinaryTree(6)
    root.right?.right = BinaryTree(7)

    val result = branchSums(root)

    println("The max sum is: $result")
}

private fun branchSums(root: BinaryTree): Int {
    return maxSum(root)
}

private fun maxSum(root: BinaryTree?): Int {
    if(root == null) return 0

    if(root.left == null && root.right == null) {
       return root.value
    }

    val leftSum = if (root.left != null) maxSum(root.left) else Int.MIN_VALUE
    val rightSum = if (root.right != null) maxSum(root.right) else Int.MIN_VALUE

    return root.value + maxOf(leftSum, rightSum)
}


