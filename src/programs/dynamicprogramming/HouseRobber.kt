package programs.dynamicprogramming

import kotlin.math.max

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected
 * and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
fun main() {
    val nums = intArrayOf(1,3,1,4,1,5)
    val output = rob2(nums)
    println(output)
}

fun rob(nums: IntArray): Int {

    var maxP = 0
    val dp = IntArray(nums.size)
     nums.forEachIndexed { index, element ->
        if(index >= 2) {
            dp[index] = max(dp[index-1],dp[index-2] + element)
        } else {
            if(index - 1 >= 0) {
                dp[index] = max(dp[index - 1], element)
            } else {
                dp[index] = element
            }
        }
      maxP = max(maxP,dp[index])
     }
    return maxP
}

fun rob2(nums: IntArray): Int {
    var maxP = 0
    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    return when (nums.size) {
        2 -> {
            dp[1] = max(nums[0],nums[1])
            maxP = max(maxP,dp[1])
            maxP
        }
        1 -> {
            dp[0] = nums[0]
            maxP = nums[0]
            maxP
        }
        else -> {
            dp[1] = max(nums[0],nums[1])
            maxP = max(maxP,dp[1])
            for(i in 2 until nums.size) {
                dp[i] = max(dp[i-1],dp[i-2] + nums[i])
                maxP = max(maxP,dp[i])
            }
            maxP
        }
    }

}