package programs.neetcode

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 1, 0, 0)
    )


    val result = uniquePaths(grid)
    println("Number of unique paths: $result") // Output: 2
}

 fun uniquePaths(grid: Array<IntArray>): Int  {
    // Base edge cases: empty grid or blocked start/end
    if (grid.isEmpty() || grid[0].isEmpty()) return 0
    val rows = grid.size
    val cols = grid[0].size
    if(grid[0][0] == 1 || grid[rows - 1] [cols - 1] == 1) return 0
    fun dfs(r: Int, c: Int): Int {
        // 1. Check boundary conditions and obstacle/visited status
        if (r !in 0 until rows || c !in 0 until cols || grid[r][c] != 0) {
            return 0
        }

        // 2. Target reached! Return 1 valid path.
        if (r == rows - 1 && c == cols - 1) {
            return 1
        }

        // 3. Mark the current cell as visited
        grid[r][c] = 2

        // 4. Explore all 4 directions recursively
        val paths = dfs(r + 1, c) + // Down
                dfs(r - 1, c) + // Up
                dfs(r, c + 1) + // Right
                dfs(r, c - 1)   // Left

        // 5. Backtrack: Reset the cell back to land for other potential paths
        grid[r][c] = 0

        return paths
    }
    return dfs(0, 0)

}
