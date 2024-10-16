package programs.leetcode

fun main() {
    val arr = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1),
        intArrayOf(1, 0, 0, 1, 1),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 0, 1, 0, 1)
    )
    val row = arr.size
    val col = arr[0].size
    numberOfIslands(arr, row, col)
}

fun numberOfIslands(arr: Array<IntArray>, row: Int, col: Int) {

    val visited = Array(row) { BooleanArray(col) }
    var count = 0

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (arr[i][j] == 1 && !visited[i][j]) {
                dfs(arr, i, j, visited)
                count++
            }
        }
    }

    println(count)

}


fun dfs(arr: Array<IntArray>, i: Int, j: Int, visited: Array<BooleanArray>) {

    if (i >= 0 && j >= 0 && i < arr.size && j < arr[0].size && arr[i][j] == 1 && !visited[i][j]) {
        visited[i][j] = true
        dfs(arr, i - 1, j, visited)
        dfs(arr, i + 1, j, visited)
        dfs(arr, i, j - 1, visited)
        dfs(arr, i, j + 1, visited)
        dfs(arr, i+1, j + 1, visited)
        dfs(arr, i-1, j - 1, visited)
        dfs(arr, i+1, j - 1, visited)
        dfs(arr, i-1, j + 1, visited)
    }

}



