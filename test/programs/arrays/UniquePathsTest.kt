package programs.arrays

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import programs.neetcode.uniquePaths

class UniquePathsTest {

    @Test
    fun `given standard grid with obstacles when uniquePaths called then returns correct count`() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(0, 0, 0, 1),
            intArrayOf(0, 1, 0, 0)
        )

        val actualPaths = uniquePaths(grid)

        assertThat(actualPaths, `is`(2))
    }

    @Test
    fun `given blocked starting cell when uniquePaths called then returns zero`() {
        val grid = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 0)
        )

        val actualPaths = uniquePaths(grid)

        assertThat(actualPaths, `is`(0))
    }

    @Test
    fun `given blocked destination cell when uniquePaths called then returns zero`() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1)
        )

        val actualPaths = uniquePaths(grid)

        assertThat(actualPaths, `is`(0))
    }

    @Test
    fun `given completely open grid when uniquePaths called then returns all possible paths`() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )

        val actualPaths = uniquePaths(grid)

        // In a 3x3 open grid allowing 4-directional movement without self-intersection,
        // there are exactly 12 unique paths to the bottom-right corner.
        assertThat(actualPaths, `is`(12))
    }

    @Test
    fun `given completely blocked grid when uniquePaths called then returns zero`() {
        val grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )

        val actualPaths = uniquePaths(grid)

        assertThat(actualPaths, `is`(0))
    }

    @Test
    fun `given empty grid when uniquePaths called then returns zero`() {
        val emptyGrid = arrayOf<IntArray>()

        val actualPaths = uniquePaths(emptyGrid)

        assertThat(actualPaths, `is`(0))
    }
}