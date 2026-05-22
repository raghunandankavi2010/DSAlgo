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
    nextPermutation(intArrayOf(1,3,2))
}

//[1,1,5]
fun nextPermutation(nums: IntArray) {

    val originalArray = nums
    var index = -1
    for (i in (nums.size - 1) downTo 0) {
        if (i > 0 && nums[i] > nums[i - 1]) {
            index = i
            break
        }
    }
    if (index > 0) {
        index --
        var toSwap = -1
        for (i in index until nums.size) {
            if (nums[i] > nums[index]) {
                toSwap = i
            }
        }
        swapArray(nums, 0 + index, toSwap)
        var start = index + 1
        var end = nums.size - 1
        while (start < end) {
            val temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start++
            end--
        }
    } else {
        nums.sort()
    }
    nums.forEach {
        println(it)
    }
}

fun swapArray(arr: IntArray, i: Int, j: Int) {
    val t = arr[i]
    arr[i] = arr[j]
    arr[j] = t
}