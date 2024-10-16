package programs.matrix

/**
 * fill 2d array from 1 to n2 given n in spiral order
 * https://leetcode.com/problems/spiral-matrix-ii/submissions/
 */
fun main(){
    val n = 3
    fillSpiralMatrix(n)
}

fun fillSpiralMatrix(n: Int) {
    var top = 0
    var bottom = n-1
    var left = 0
    var right = n-1
    val arr = Array(n) { IntArray(n) }
    var value = 1

    while (value <= n * n) {
        // left to right
        for (i in left..right) arr[top][i] = value++
        top++

        // up to down
        for (i in top..bottom) arr[i][right] = value++
        right--

        // right to left
        for (i in right downTo left) arr[bottom][i] = value++
        bottom--

        // bottom to top
        for (i in bottom downTo top) arr[i][left] = value++
        left++
    }

    for (i in arr.indices) {
        println(arr[i].contentToString())
    }
}
