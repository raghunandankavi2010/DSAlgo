package programs.leetcode

fun main() {

    val arr = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 1),
    )
    val row = arr.size
    val col = arr[0].size
    numberOfProvinces(arr, row, col)
}

fun numberOfProvinces(arr: Array<IntArray>, row: Int, col: Int) {
    val visited = BooleanArray(row)
    var count = 0

    for (i in 0 until row) {
        if (!visited[i]) {
            count++
            dfsProvinces(arr, visited, i)

        }
    }

    println(count)
}


fun dfsProvinces(grid: Array<IntArray>, visited: BooleanArray, i: Int) {
    if (visited[i]) {
        return
    }
    visited[i] = true
    for (j in grid[0].indices) {
        if (grid[i][j] == 1) {
            dfsProvinces(grid, visited, j)
        }
    }
}