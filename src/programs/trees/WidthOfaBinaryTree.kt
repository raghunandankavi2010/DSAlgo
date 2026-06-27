package programs.trees

class BinaryTree {

    data class TreeNode(
        val value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )

    // Width of ANY binary tree (not assuming full)
    fun widthOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0

        val queue: ArrayDeque<Pair<TreeNode, Int>> = ArrayDeque()
        queue.add(root to 1)

        var maxWidth = 0

        while (queue.isNotEmpty()) {
            val size = queue.size
            val firstIndex = queue.first().second
            var lastIndex = firstIndex

            repeat(size) {
                val (node, index) = queue.removeFirst()
                lastIndex = index

                node.left?.let { queue.add(it to index * 2) }
                node.right?.let { queue.add(it to index * 2 + 1) }
            }

            maxWidth = maxOf(maxWidth, (lastIndex - firstIndex + 1))
        }

        return maxWidth
    }


    // Driver to test
    fun run() {
        val root = TreeNode(1)
        root.left = TreeNode(3)
        root.right = TreeNode(2)
        root.left!!.left = TreeNode(5)
        root.left!!.right = TreeNode(3)
        root.right!!.right = TreeNode(9)

        val width = widthOfBinaryTree(root)
        println("Width of the binary tree: $width")
    }
}

fun main() {
    BinaryTree().run()
}