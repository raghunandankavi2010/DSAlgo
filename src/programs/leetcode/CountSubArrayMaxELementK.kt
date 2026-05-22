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

private fun countSubarrays(nums: IntArray, k: Int): Long {

    if (nums.isEmpty()) {
        return 0L
    }
    val maxElement = nums.maxOrNull() ?: return 0L

    var count = 0
    var left = 0
    var ans: Long = 0

    for (right in nums.indices) {
        if (nums[right] == maxElement) {
            count++
        }

        while (count >= k) {
            ans += (nums.size - right)
            if (nums[left] == maxElement) {
                count--
            }
            left++
        }
    }

    return ans
}

fun main() {
    val input = intArrayOf(1,3,2,3,3)
    val k = 2
    println(countSubarrays(input,k))
}