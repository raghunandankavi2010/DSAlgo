package programs.algoexpert

fun printMatrix(matrix: List<List<Int>>) {
    println("Current state of the matrix:")
    if (matrix.isEmpty()) {
        println("[] (Matrix is empty)")
        return
    }

    matrix.forEachIndexed { index, row ->
        println("  Row $index: $row")
    }
}

fun main() {

    val matrix: MutableList<MutableList<Int>> = mutableListOf()

    val row1 = mutableListOf(1, 2 )
    //val row2 = mutableListOf(4, 5)
   // val row3 = mutableListOf(7, 8, 9)

    matrix.add(row1)
   // matrix.add(row2)
   // matrix.add(row3)
    println("Before Transpose")
    printMatrix(matrix)

    val output = transposeMatrix(matrix)
    printMatrix(output)

}

private fun transposeMatrix(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    // Write your code here.
    val result: MutableList<MutableList<Int>> = mutableListOf()

    val width = matrix[0].size
    val height = matrix.size


        for (i in 0 until width) { // row
            val rowElements = mutableListOf<Int>()
            for (j in 0 until height) { // col
                rowElements.add(matrix[j][i])
            }
            result.add(rowElements)
        }

    return result
}
