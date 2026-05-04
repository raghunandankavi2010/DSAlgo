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

/**
 *
 * . The Variable: val offset = i - firstIn the code,
 * i is the current column index in the top row,
 * and first is the starting index of that row.
 * If you are at the very first element of a row,
 * i and first are the same, so offset is 0.
 * As you move to the next element,
 * offset becomes 1, then 2, and so on.2.
 * Why we need it for "Backward" movementIn a 2D grid,
 * moving "forward" (Right or Down) is easy—you just add to the index.
 * But moving "backward" (Left or Up) requires you to subtract from the last index.
 * This is where offset is required.
 * Consider a $4 \times 4$ matrix
 * where the current layer is the outermost ring (first = 0, last = 3):
 * Move DirectionCoordinate
 * LogicExplanationTop
 * Row (Right)[first][first + offset]
 * Row stays at 0, Column increases ($0, 1, 2$).
 * Right Col (Down)[first + offset][last]Column stays at 3, Row increases ($0, 1, 2$).
 * Bottom Row (Left)[last][last - offset]Row stays at 3, Column decreases ($3, 2, 1$).
 * Left Col (Up)[last - offset][first]Column stays at 0, Row decreases ($3, 2, 1$).3.
 * Step-by-Step Example
 * Imagine a $3 \times 3$ matrix ($n=3$, first=0, last=2).
 * We are rotating the outer layer:When i = 0 (Offset = 0):
 * We are at the corners.last - offset is 2 - 0 = 2.
 * You swap the elements at index 0 and index 2.When i = 1 (Offset = 1):
 * We are at the middle elements of the edges.last - offset is 2 - 1 = 1.
 * You swap the elements at index 1 and index 1 (the middle of each side).
 */
class Solution {
    fun rotate(matrix: Array<IntArray>) {
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