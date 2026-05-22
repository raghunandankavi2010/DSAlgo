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

package programs.arrays

import kotlin.math.max

/**
 * Knapsack problem recursive approach
 */
fun main() {
    val profit = intArrayOf(60, 100, 120)
    val weight = intArrayOf(10, 20, 30)
    val capacity = 50
    val n = profit.size
    println(knapSack(0, capacity, weight, profit, n))
}

private fun knapSack(index: Int, capacity: Int, weight: IntArray, profit: IntArray, n: Int): Int {
    if (index >= n) return 0

    // Exclude the current item
    var maxProfit = knapSack(index + 1, capacity, weight, profit, n)

    // Include the current item
    val newCapacity = capacity - weight[index]
    if (newCapacity >= 0) {
        val currentProfit = profit[index] + knapSack(index + 1, newCapacity, weight, profit, n)
        maxProfit = max(maxProfit, currentProfit)
    }

    return maxProfit
}
