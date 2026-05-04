package programs.matrix

fun main() {
    val solution = Solution()

    // Example 1: 3x3 Matrix
    val matrix1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    println("Original 3x3 Matrix:")
    printMatrix(matrix1)

    solution.rotate(matrix1)

    println("\nRotated 90 Degrees Clockwise:")
    printMatrix(matrix1)

    println("\n" + "=".repeat(20) + "\n")

    // Example 2: 4x4 Matrix
    val matrix2 = arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7),
        intArrayOf(15, 14, 12, 16)
    )

    println("Original 4x4 Matrix:")
    printMatrix(matrix2)

    solution.rotate(matrix2)

    println("\nRotated 90 Degrees Clockwise:")
    printMatrix(matrix2)
}

/**
 * Helper function to print the matrix in a readable format
 */
fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        println(row.joinToString(prefix = "[", postfix = "]", separator = ", "))
    }
}

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        // if matrix size is 3 3/2 we rotate only 1st outer layer. inner is center stays same
        // if matrix is 4 4/2 is 2. we rotate 2 outer layers to inner layer
        // if size of 4 height and width decreases by 2 hence m/2
        for (layer in 0 until n / 2) {
            val last = n - 1 - layer
            for (i in layer until last) {
                val offset = i - layer
                val top = matrix[layer][i] // save top

                // left -> top
                matrix[layer][i] = matrix[last - offset][layer]

                // bottom -> left
                matrix[last - offset][layer] = matrix[last][last - offset]

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last]

                // top -> right
                matrix[i][last] = top // right <- saved top
            }
        }
    }
}