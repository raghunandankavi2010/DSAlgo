/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package programs.algoexpert

// This is an input class. Do not edit.
open class BinarySearchTree(value: Int) {
    var value = value
    var left: BinarySearchTree? = null
    var right: BinarySearchTree? = null

    // Helper function to build the tree for testing.
    fun insert(newValue: Int): BinarySearchTree {
        var currentNode: BinarySearchTree? = this
        while (currentNode != null) {
            if (newValue < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = BinarySearchTree(newValue)
                    break
                } else {
                    currentNode = currentNode.left
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = BinarySearchTree(newValue)
                    break
                } else {
                    currentNode = currentNode.right
                }
            }
        }
        return this
    }
}

class TreeInformation(var numberOfNodesVisited: Int, var latestVisitedValue: Int)

fun findKthLargestValueInBst(tree: BinarySearchTree, k: Int): Int {
    val treeInfo = TreeInformation(numberOfNodesVisited = 0, latestVisitedValue = -1)

    reverseInOrderTraversal(tree, k, treeInfo)

    return treeInfo.latestVisitedValue
}

fun reverseInOrderTraversal(node: BinarySearchTree?, k: Int, info: TreeInformation) {
    if (node == null || info.numberOfNodesVisited >= k) {
        return
    }

    reverseInOrderTraversal(node.right, k, info)

    if (info.numberOfNodesVisited < k) {
        info.numberOfNodesVisited++
        info.latestVisitedValue = node.value
        reverseInOrderTraversal(node.left, k, info)
    }
}

fun main() {
    // Let's build a sample BST:
    //         15
    //        /  \
    //       5    20
    //      / \   / \
    //     2   5 17  22
    //    / \
    //   1   3
    val root = BinarySearchTree(15)
    root.insert(5)
        .insert(20)
        .insert(2)
        .insert(5)
        .insert(17)
        .insert(22)
        .insert(1)
        .insert(3)

    val k = 3
    val result = findKthLargestValueInBst(root, k)

    println("Finding the $k-rd largest value...")
    println("Result: $result")
    println("Expected: 17")


}