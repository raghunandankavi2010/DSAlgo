package programs.algoexpert

import java.util.LinkedList
import java.util.Queue

fun main() {
    val sortedArray = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val root = sortedArrayToBST(sortedArray)
    printTreeByLevel(root)

}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = BST(value)
            } else {
                this.left!!.insert(value)
            }
        } else {
            if (this.right == null) {
                this.right = BST(value)
            } else {
                this.right!!.insert(value)
            }
        }
    }

    override fun toString(): String {
        return "BST(`val`=$`value`, left=${left?.`value`}, right=${right?.`value`})"
    }
}

fun printTreeByLevel(root: BST?) {
    if (root == null) {
        println("Tree is empty.")
        return
    }

    val queue: Queue<BST> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size

        for (i in 0 until levelSize) {
            val currentNode = queue.poll()

            print("${currentNode.value} ")
            currentNode.left?.let { queue.add(it) }
            currentNode.right?.let { queue.add(it) }
        }
        println()
    }
}

fun sortedArrayToBST(nums: IntArray): BST? {
    return buildBST(nums, null, 0, nums.size - 1)
}

fun buildBST(nums: IntArray, node: BST?, start: Int, end: Int): BST? {
    if (start > end)  return null
        val mid = start + (end - start) / 2
        val valuetoAdd = nums[mid]
        val newBst = BST(valuetoAdd)

        newBst.left = buildBST(nums, newBst, start, mid - 1)
        newBst.right = buildBST(nums, newBst, mid + 1, end)

    return newBst
}