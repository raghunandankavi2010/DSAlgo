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

fun main() {
    val arr = intArrayOf(-1, 2, 1, -4)
    val target = 1
    println(threeSumClosest(arr,target))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    var ans = nums[0] + nums[1] + nums[nums.size-1]
    nums.sort()
    var diff = Integer.MAX_VALUE
    for( i in nums.indices) {
        val firstNumber = nums[i]
        var left = i + 1
        var right = nums.size - 1
        while(left <  right) {
            val sum = nums[left] + nums[right] + firstNumber
            if(sum > target) {
                right--
            } else {
                left++
            }
            if(Math.abs(sum - target )< Math.abs(ans - target)) {
                ans = sum
            }
        }

    }
    return ans
}