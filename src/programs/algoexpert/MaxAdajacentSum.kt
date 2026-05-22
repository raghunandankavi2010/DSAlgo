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

package programs.algoexpert

import kotlin.math.max

fun main() {
    val input = arrayOf(75,105,-1).toList()
    val output = maxSubsetSumNoAdjacent(input)
    println(output)

}

private fun maxSubsetSumNoAdjacent(array: List<Int>): Int {
    // Write your code here.
    if(array.isEmpty()) return 0
    if(array.size == 1) return array[0]

    var maxSum: Int

    val dp = IntArray(array.size) {0}

    dp[0] = array[0]
    maxSum = dp[0]
    dp[1] = max(array[1], dp[0])

    maxSum = max(maxSum,dp[1])

    for(i in 2 until array.size) {
        dp[i] = max(dp[i-1], array[i]+dp[i-2])
        maxSum = max(maxSum,dp[i])
    }


    return maxSum
}