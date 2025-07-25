package programs.algoexpert


private fun removeIslands(grid: Array<IntArray>) {
    if (grid.isEmpty() || grid[0].isEmpty()) {
        return
    }

    val rows = grid.size
    val cols = grid[0].size


    for (j in 0 until cols) {
        if (grid[0][j] == 1) {
            dfs(0, j, grid)
        }
        if (grid[rows - 1][j] == 1) {
            dfs(rows - 1, j, grid)
        }
    }

    for (i in 1 until rows - 1) {
        if (grid[i][0] == 1) {
            dfs(i, 0, grid)
        }
        if (grid[i][cols - 1] == 1) {
            dfs(i, cols - 1, grid)
        }
    }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0
            } else if (grid[i][j] == 2) {
                grid[i][j] = 1
            }
        }
    }
}


private fun dfs(row: Int, col: Int, grid: Array<IntArray>) {
    val rows = grid.size
    val cols = grid[0].size

    if (row !in 0..<rows || col < 0 || col >= cols || grid[row][col] != 1) {
        return
    }

    grid[row][col] = 2

    dfs(row + 1, col, grid)
    dfs(row - 1, col, grid)
    dfs(row, col + 1, grid)
    dfs(row, col - 1, grid)
}

fun printGrid(grid: Array<IntArray>) {
    grid.forEach { row ->
        println(row.joinToString(" "))
    }
    println("-".repeat(grid[0].size * 2 - 1))
}

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 1, 0),
        intArrayOf(1, 1, 0, 0, 1, 0),
        intArrayOf(1, 0, 0, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 1)
    )

    println("Original Grid:")
    printGrid(grid)

    removeIslands(grid)

    println("Grid After Removing Islands:")
    printGrid(grid)
}