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
    val n = 5
    val dp = Array(n) { 0 }
    val recursive = climbStairsRecursive(n, dp)
    println(recursive)
    val output = climbStairsIterative(n)
    println(output)
}


private fun climbStairsIterative(n: Int): Int {
    val dp = Array(n+1) { 0 }

    dp[1] = 1
    dp[2] = 2

    for(i in 3.. n) {
        dp[i] =  dp[i-1] + dp [i-2]
    }

    return dp[n]
}

private fun climbStairsRecursive(n: Int, dp: Array<Int>, steps: Int = 0): Int {
    if (steps == n) return 1

    if(steps > n) return 0

    val currentStep = steps + 1

    if (dp[steps] > 0) {
        return dp[steps]
    }
    val ways =  climbStairsRecursive(n, dp,currentStep) + climbStairsRecursive(n, dp ,currentStep + 1)

    dp[steps] = ways
    return ways
}