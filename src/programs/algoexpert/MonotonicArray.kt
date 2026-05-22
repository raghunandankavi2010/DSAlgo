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

private fun isMonotonic(nums: List<Int>): Boolean {
    var increasing = true
    var decreasing = true

    for (i in 1 until nums.size) {
        if (nums[i] > nums[i - 1]) decreasing = false
        if (nums[i] < nums[i - 1]) increasing = false
    }

    return increasing || decreasing
}

fun main() {
    val testCases = listOf(
        listOf(1, 2, 2, 3),     // true
        listOf(6, 5, 4, 4),     // true
        listOf(1, 3, 2),        // false
        listOf(1),              // true
        emptyList(),      // true
        listOf(3, 3, 3),        // true
        listOf(1, 2, 3, 2),     // false
    )

    for (test in testCases) {
        println("Input: $test → Monotonic: ${isMonotonic(test)}")
    }
}