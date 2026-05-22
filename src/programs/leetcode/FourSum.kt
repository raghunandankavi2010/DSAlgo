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
    val nums = intArrayOf(1, 0, -1, 0, -2, 2)
    val target = 0
    println(fourSum(nums, target))
}

/**
 * o(n3)
 */
fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in 0 until nums.size - 3) {
        if (i > 0 && nums[i] == nums[i - 1]) continue

        for (j in i + 1 until nums.size - 2) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue

            var left = j + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i].toLong() + nums[j].toLong() + nums[left].toLong() + nums[right].toLong()
                when {
                    sum == target.toLong() -> {
                        result.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        left++
                        right--

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left - 1]) left++
                        while (left < right && nums[right] == nums[right + 1]) right--
                    }
                    sum < target -> left++
                    else -> right--
                }
            }
        }
    }

    return result
}