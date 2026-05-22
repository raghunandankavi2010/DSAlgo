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
    val array = intArrayOf(1,2,3,4)
    print(check(array))
}

fun check(nums: IntArray): Boolean {
    if (nums.size <= 2) return true

    var previous = nums[0]
    val start = nums[0]
    var pivotIndex = -1

    for (i in 1 until nums.size) {
        if (previous > nums[i]) {
            if (pivotIndex == -1) pivotIndex = i else return false
            if (nums[i] > start) return false
        } else {
            if (pivotIndex != -1 && nums[i] > start) return false
        }
        print(pivotIndex)
        println()
        previous = nums[i]
    }

    return true
}