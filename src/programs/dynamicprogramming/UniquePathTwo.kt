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