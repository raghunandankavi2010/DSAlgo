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

import kotlin.math.abs

fun main() {
    // Let's create a sample BST:
    //         10
    //        /  \
    //       5    15
    //      / \   / \
    //     2   5 13  22
    //    /       \
    //   1         14
    val root = BST(10)
    root.left = BST(5)
    root.left?.left = BST(2)
    root.left?.left?.left = BST(1)
    root.left?.right = BST(5)
    root.right = BST(15)
    root.right?.left = BST(13)
    root.right?.left?.right = BST(14)
    root.right?.right = BST(22)

    val target = 12
    val closestValue = findClosestValueInBst(root, target)
    println("The target value is: $target")
    println("The closest value found in the BST is: $closestValue")

    val target2 = 1
    val closestValue2 = findClosestValueInBst(root, target2)
    println("\nThe target value is: $target2")
    println("The closest value found in the BST is: $closestValue2")

    val target3 = 23
    val closestValue3 = findClosestValueInBst(root, target3)
    println("\nThe target value is: $target3")
    println("The closest value found in the BST is: $closestValue3")
}

private fun findClosestValueInBst(tree: BST, target: Int): Int {
    var closest = tree.value
    var currentNode: BST? = tree

    while (currentNode != null) {

        if (abs(target - closest) > abs(target - currentNode.value)) {
            closest = currentNode.value
        }

        currentNode = when {
            target < currentNode.value -> {
                currentNode.left
            }

            target > currentNode.value -> {
                currentNode.right
            }

            else -> {

                return currentNode.value
            }
        }
    }
    return closest
}