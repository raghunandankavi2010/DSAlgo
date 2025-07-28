package programs.algoexpert

open class BSTNode(val value: Int) {
    var left: BSTNode? = null
    var right: BSTNode? = null

    fun insert(newValue: Int): BSTNode {
        var currentNode: BSTNode? = this
        while (currentNode != null) {
            if (newValue < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = BSTNode(newValue)
                    break
                } else {
                    currentNode = currentNode.left
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = BSTNode(newValue)
                    break
                } else {
                    currentNode = currentNode.right
                }
            }
        }
        return this
    }
}

fun inOrderTraverse(tree: BSTNode?, array: MutableList<Int>): List<Int> {
    if (tree == null) {
        return array
    }
    inOrderTraverse(tree.left, array)
    array.add(tree.value)
    inOrderTraverse(tree.right, array)
    return array
}

fun preOrderTraverse(tree: BSTNode?, array: MutableList<Int>): List<Int> {
    if (tree == null) {
        return array
    }
    array.add(tree.value)
    preOrderTraverse(tree.left, array)
    preOrderTraverse(tree.right, array)
    return array
}

fun postOrderTraverse(tree: BSTNode?, array: MutableList<Int>): List<Int> {
    if (tree == null) {
        return array
    }
    postOrderTraverse(tree.left, array)
    postOrderTraverse(tree.right, array)
    array.add(tree.value)
    return array
}

fun main() {
    val root = BSTNode(10)
    root.insert(5)
        .insert(15)
        .insert(2)
        .insert(5)
        .insert(22)
        .insert(1)

    println("--- In-Order Traversal (Left, Root, Right) ---")
    val inOrderResult = inOrderTraverse(root, mutableListOf())
    println("Result:   $inOrderResult")
    println("Expected: [1, 2, 5, 5, 10, 15, 22]")
    println()

    println("--- Pre-Order Traversal (Root, Left, Right) ---")
    val preOrderResult = preOrderTraverse(root, mutableListOf())
    println("Result:   $preOrderResult")
    println("Expected: [10, 5, 2, 1, 5, 15, 22]")
    println()

    println("--- Post-Order Traversal (Left, Right, Root) ---")
    val postOrderResult = postOrderTraverse(root, mutableListOf())
    println("Result:   $postOrderResult")
    println("Expected: [1, 2, 5, 5, 22, 15, 10]")
    println()
}