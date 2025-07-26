package programs.algoexpert

fun main() {
    val mat = arrayOf<IntArray?>(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16)
    )

    val listOfLists: List<List<Int>> = mat.mapNotNull { it?.toList() }

    val output = spiralTraverse(listOfLists)
    print(output)
}

private fun spiralTraverse(array: List<List<Int>>): List<Int> {
    // Write your code here.
    val result = mutableListOf<Int>()
    var top = 0
    var bottom = array.size -1
    var left = 0
    var right = array[0].size -1

    while(top <= bottom && left <= right) {

        // print first row
        for (i in left..right) {
            result.add(array[top][i])
        }
        top++

        for (i in top..bottom) {
            result.add(array[i][right])
        }
        right--

        if (top <= bottom) {
            for (i in right downTo left) {
                result.add(array[bottom][i])
            }
            bottom--
        }

        if (left <= right) {
            for (i in bottom downTo top) {
                result.add(array[i][left])
            }
            left++
        }

    }
    return result
}