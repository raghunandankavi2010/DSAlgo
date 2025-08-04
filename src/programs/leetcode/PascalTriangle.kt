package programs.leetcode

fun main() {
    val n = 5
    val pascalTriangle = generate(n)
    println(pascalTriangle)
    val pascalTriangle2 = getRow(3)
    println(pascalTriangle2)

}

private fun generate(numRows: Int): List<List<Int>> {
    val triangle = mutableListOf<List<Int>>()

    if (numRows == 0) {
        return triangle
    }

    triangle.add(listOf(1))

    for (i in 1 until numRows) {
        val prevRow = triangle[i - 1]
        val currRow = mutableListOf<Int>()
        currRow.add(1)
        for (j in 1 until i) {
            currRow.add(prevRow[j - 1] + prevRow[j])
        }

        currRow.add(1)

        triangle.add(currRow)
    }
    return triangle
}

private fun getRow(rowIndex: Int): List<Int> {
    val triangle = mutableListOf<List<Int>>()

    if (rowIndex == 0) {
        return listOf(1)
    }

    triangle.add(listOf(1))

    for (i in 1 .. rowIndex ) {
        val prevRow = triangle[i - 1]
        val currRow = mutableListOf<Int>()
        currRow.add(1)
        for (j in 1 until i) {
            currRow.add(prevRow[j - 1] + prevRow[j])
        }

        currRow.add(1)

        triangle.add(currRow)
    }
    return triangle[triangle.size-1]
}