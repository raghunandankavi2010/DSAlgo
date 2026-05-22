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