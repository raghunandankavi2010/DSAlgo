/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package programs.leetcode

fun main() {
    val obstacleGrid = arrayOf(
        intArrayOf(0, 0, 1),
        intArrayOf(0, 1, 0),
        intArrayOf(1, 0, 0)
    )
    val result = uniquePathsWithObstacles(obstacleGrid)
    println("Number of unique paths: $result")
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size

    // If the starting or ending cell has an obstacle, return 0
    if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
        return 0
    }

    // Initialize the DP table
    val dp = Array(m) { IntArray(n) }

    // Set the starting point
    dp[0][0] = 1

    // Fill the first column
    for (i in 1 until m) {
        dp[i][0] = if (obstacleGrid[i][0] == 0) dp[i - 1][0] else 0
    }

    // Fill the first row
    for (j in 1 until n) {
        dp[0][j] = if (obstacleGrid[0][j] == 0) dp[0][j - 1] else 0
    }

    // Fill the rest of the DP table
    for (i in 1 until m) {
        for (j in 1 until n) {
            if (obstacleGrid[i][j] == 0) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            } else {
                dp[i][j] = 0
            }
        }
    }

    return dp[m - 1][n - 1]
}
