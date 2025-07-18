package programs.algoexpert

import kotlin.math.max

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(1, 0),
    )
    println("Matrix:")
    printGrid(matrix)
    println("\nLargest possible island by flipping one '1': ${largestIsland(matrix)}")
}


fun largestIsland(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) {
        return 0
    }

    val rows = grid.size
    val cols = grid[0].size
    var islandId = 2
    val islandSizes = mutableMapOf<Int, Int>()

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == 1) {
                val size = markIslandAndGetSize(grid, r, c, islandId)
                islandSizes[islandId] = size
                islandId++
            }
        }
    }


    var maxSize = islandSizes.values.maxOrNull() ?: 0


    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == 0) {
                val neighborIslandIds = findNeighbours(r,c,grid)

                var potentialSize = 1
                for (id in neighborIslandIds) {
                    potentialSize += islandSizes.getOrDefault(id, 0)
                }
                maxSize = max(maxSize, potentialSize)
            }
        }
    }


    if (maxSize == 0 && rows * cols > 0) {
        return 1
    }

    return maxSize
}

private fun findNeighbours(r: Int, c: Int, grid: Array<IntArray>): MutableSet<Int> {
    val neighborIslandIds = mutableSetOf<Int>()

    if (r > 0 && grid[r - 1][c] >= 2) {
        neighborIslandIds.add(grid[r - 1][c])
    }

    if (r < grid.size - 1 && grid[r + 1][c] >= 2) {
        neighborIslandIds.add(grid[r + 1][c])
    }

    if (c > 0 && grid[r][c - 1] >= 2) {
        neighborIslandIds.add(grid[r][c - 1])
    }

    if (c < grid[r].size - 1 && grid[r][c + 1] >= 2) {
        neighborIslandIds.add(grid[r][c + 1])
    }

    return neighborIslandIds
}

private fun markIslandAndGetSize(grid: Array<IntArray>, r: Int, c: Int, islandId: Int): Int {
    if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size || grid[r][c] != 1) {
        return 0
    }

    grid[r][c] = islandId

    var size = 1
    size += markIslandAndGetSize(grid, r + 1, c, islandId)
    size += markIslandAndGetSize(grid, r - 1, c, islandId)
    size += markIslandAndGetSize(grid, r, c + 1, islandId)
    size += markIslandAndGetSize(grid, r, c - 1, islandId)

    return size
}

private fun printGrid(grid: Array<IntArray>) {
    for (row in grid) {
        println(row.joinToString(" "))
    }
}