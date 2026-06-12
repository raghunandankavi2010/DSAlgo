package programs.neetcode

import java.util.LinkedList
import java.util.Queue


fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 1, 0, 0)
    )


    val result = uniquePathsBFS(grid)
    println("Number of unique paths: $result") // Output: 2
}


// A data class to represent the independent state of an ongoing path exploration
data class PathState(
    val r: Int,
    val c: Int,
    val visited: Set<Pair<Int, Int>> // Every path carries its own memory history
)

fun uniquePathsBFS(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0
    val rows = grid.size
    val cols = grid[0].size
    if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) return 0

    var totalPaths = 0
    val queue: Queue<PathState> = LinkedList()

    // Start the first path at (0,0)
    queue.add(PathState(0, 0, setOf(Pair(0, 0))))

    val directions = arrayOf(
        Pair(1, 0),  // Down
        Pair(-1, 0), // Up
        Pair(0, 1),  // Right
        Pair(0, -1)  // Left
    )

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        // If this specific path branch reached the destination, count it!
        if (current.r == rows - 1 && current.c == cols - 1) {
            totalPaths++
            continue // This path is done, move to next path in queue
        }

        // Branch out in all 4 directions simultaneously
        for (dir in directions) {
            val nextR = current.r + dir.first
            val nextC = current.c + dir.second
            val nextCell = Pair(nextR, nextC)

            // Validate boundaries, rock obstacles, and ensure THIS path hasn't been here before
            if (nextR in 0 until rows &&
                nextC in 0 until cols &&
                grid[nextR][nextC] == 0 &&
                nextCell !in current.visited
            ) {
                // Snapshot the history and spawn a new path branch into the queue
                queue.add(PathState(nextR, nextC, current.visited + nextCell))
            }
        }
    }

    return totalPaths
}