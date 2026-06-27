package programs.leetcode



fun printSolution(solution: Array<IntArray>?) {
    if (solution == null) {
        println("No solution exists.")
        return
    }
    for (i in solution.indices) {
        for (j in solution[0].indices) {
            print("${solution[i][j]} ")
        }
        println()
    }
    println("--------------------")
}

fun main() {
    // Example Maze 1
    val maze1 = arrayOf(
        intArrayOf(1, 1, 0 ),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 1, 1 )
    )
    println("Maze 1:")
    printSolution(maze1)
    println("Solution for Maze 1 (4-directions):")
    val solution1 = solveMaze(maze1)
    printSolution(solution1)
}

fun solveMaze(maze: Array<IntArray>): Array<IntArray>? {
    val n = maze.size
    if (n == 0 || maze[0].isEmpty()) return null

    // Initialize solution matrix with all 0s
    val solution = Array(n) { IntArray(n) { 0 } }

    // Keep track of visited cells to prevent infinite loops (going back and forth)
    val visited = Array(n) { BooleanArray(n) { false } }

    // Start DFS from (0,0)
    if (solveMazeDFS(maze, 0, 0, solution, visited)) {
        return solution
    }
    return null // No path found
}

private fun solveMazeDFS(
    maze: Array<IntArray>,
    x: Int,
    y: Int,
    solution: Array<IntArray>,
    visited: Array<BooleanArray>
): Boolean {

    val n = maze.size
    val m = maze[0].size

    if (x == n - 1 && y == m - 1) {
        solution[x][y] = 1
        return true
    }

    if(isSafe(maze,x,y,visited)) {
        solution[x][y] = 1
        visited[x][y] = true

        if (solveMazeDFS(maze, x, y + 1, solution, visited)) {
            visited[x][y+1] = false
            return true
        }
        if (solveMazeDFS(maze, x, y - 1, solution, visited)) {
            visited[x][y-1] = false
            return true
        }

        if (solveMazeDFS(maze, x + 1, y, solution, visited)) {
            return true
        }
        if (solveMazeDFS(maze, x - 1, y, solution, visited)) {
            return true
        }
        // if we do not find the solution
        solution[x][y] = 0
        visited[x][y] = false
        return false

    }

    return false
}

private fun isSafe(maze: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>): Boolean {
    val n = maze.size
    val m = maze[0].size
    return (x >= 0 && x< n && y >= 0 && y < m && maze[x][y] == 1 && !visited[x][y])
}
