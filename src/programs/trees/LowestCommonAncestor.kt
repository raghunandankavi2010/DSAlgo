package programs.trees

class BinaryTreeLCA {

    // Node structure private to this class
    private data class TreeNode(
        val value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )

    // LCA function (standard recursive solution)
    private fun lowestCommonAncestor(
        root: TreeNode?,
        p: TreeNode?,
        q: TreeNode?
    ): TreeNode? {
        if (root == null || root == p || root == q)
            return root

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        return when {
            left != null && right != null -> root
            left != null -> left
            else -> right
        }
    }

    // Driver main function inside the class
    fun run() {
        // Build a sample tree
        val root = TreeNode(3)
        root.left = TreeNode(5)
        root.right = TreeNode(1)
        root.left!!.left = TreeNode(6)
        root.left!!.right = TreeNode(2)
        root.right!!.left = TreeNode(0)
        root.right!!.right = TreeNode(8)
        root.left!!.right!!.left = TreeNode(7)
        root.left!!.right!!.right = TreeNode(4)

        val p = root.left              // Node 5
        val q = root.left!!.right!!.right // Node 4

        val lca = lowestCommonAncestor(root, p, q)

        println("LCA of ${p?.value} and ${q?.value} is: ${lca?.value}")
    }
}

// Top-level main that just triggers the class driver
fun main() {
    BinaryTreeLCA().run()
}
