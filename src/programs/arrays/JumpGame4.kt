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
import kotlin.math.min

class Solution {
    fun maxValue(nums: IntArray): IntArray {
        val n = nums.size
        if (n == 0) return intArrayOf()

        // prefixMax[i] stores the maximum value from index 0 to i
        val prefixMax = IntArray(n)
        var currentMax = Int.MIN_VALUE
        for (i in 0 until n) {
            currentMax = max(currentMax, nums[i])
            prefixMax[i] = currentMax
        }

        // suffixMin[i] stores the minimum value from index i to n-1
        val suffixMin = IntArray(n)
        var currentMin = Int.MAX_VALUE
        for (i in n - 1 downTo 0) {
            currentMin = min(currentMin, nums[i])
            suffixMin[i] = currentMin
        }

        val ans = IntArray(n)
        var i = 0
        while (i < n) {
            var j = i

            // If the max value seen so far is greater than the minimum value remaining,
            // these indices are part of the same connected jump component.
            while (j < n - 1 && prefixMax[j] > suffixMin[j + 1]) {
                j++
            }

            // Find the peak value in this specific component
            var componentMax = Int.MIN_VALUE
            for (k in i..j) {
                componentMax = max(componentMax, nums[k])
            }

            // All indices in this component can eventually reach the peak value
            for (k in i..j) {
                ans[k] = componentMax
            }

            i = j + 1
        }

        return ans
    }
}

/**
 * Driver Function
 */
fun main() {
    val sol = Solution()

    // Test Case 1
    val nums1 = intArrayOf(2, 1, 3)
    println("Input: [2, 1, 3] -> Output: ${sol.maxValue(nums1).joinToString(", ")}")

    // Test Case 2
    val nums2 = intArrayOf(2, 3, 1)
    println("Input: [2, 3, 1] -> Output: ${sol.maxValue(nums2).joinToString(", ")}")

    // Test Case 3: Larger range component
    val nums3 = intArrayOf(4, 1, 2, 0, 5)
    // Here, 4 can jump to 1, 2, or 0. From 0, we can jump back to 4.
    // Since 5 is the absolute max and reachable from 0, the whole array merges.
    println("Input: [4, 1, 2, 0, 5] -> Output: ${sol.maxValue(nums3).joinToString(", ")}")
}