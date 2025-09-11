package programs.leetcode

import kotlin.math.max

fun main() {
    val input = intArrayOf(1,2,3)
    println("Max Profit for robbing non adjacent houses ${rob(input)}")
}

private fun rob(nums: IntArray): Int {

    val n = nums.size
    if (n == 0) return 0
    if (n == 1) return nums[0]
    if (n == 2) return maxOf(nums[0], nums[1])

    // Helper function using full DP array
    fun robLinearDP(start: Int, end: Int): Int {
        val dp = IntArray(end - start + 1)
        dp[0] = nums[start]
        dp[1] = maxOf(nums[start], nums[start + 1])
        for (i in 2 until dp.size) {
            dp[i] = maxOf(dp[i - 1], dp[i - 2] + nums[start + i])
        }
        return dp.last()
    }

    val case1 = robLinearDP(0, n - 2)
    val case2 = robLinearDP(1, n - 1)

    return maxOf(case1, case2)
}