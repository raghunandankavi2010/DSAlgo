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

package programs.dynamicprogramming

fun main() {
    val arr = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 0),
    )
    println(uniquePathsWithObstacles(arr))
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {

    val row = obstacleGrid.size - 1
    val col = obstacleGrid[0].size - 1
    val dp = Array(obstacleGrid.size) { IntArray(obstacleGrid[0].size) }
    dp[0][0] = 1

    for (i in dp.indices) {
        if (obstacleGrid[0][i] == 1) {
            dp[i][0] = 0
        } else {
            dp[0][i] = 1
        }
    }

    for (i in 0 until dp[0].size) {
        if (obstacleGrid[i][0] == 1) {
            dp[i][0] = 0
        } else {
            dp[i][0] = 1
        }
    }

    for (i in 1 until dp.size) {
        for (j in 1 until dp[i].size) {

            if (obstacleGrid[i][j] == 1) {
                dp[i][j] = 0
            } else {
                dp[i][j] = dp[i][j-1] + dp[i-1][j]
            }

        }
    }
    return dp[dp.size - 1][dp[0].size - 1]
}