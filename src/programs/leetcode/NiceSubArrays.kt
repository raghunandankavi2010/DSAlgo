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

/**
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There are no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *
 */

fun main() {
    val arr = intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2)
    // Loop through the array and modify elements
//    for (i in arr.indices) {
//        arr[i] = arr[i] % 2
//    }
    val k = 2

    val result1 = numSubArray(arr, k)
    val result2 = numSubArray(arr, k - 1)
    println(result1 - result2)
}

private fun numSubArray(arr: IntArray, k: Int): Int {
    if (k < 0) return 0
    var l = 0
    var r = 0
    var sum = 0
    var count = 0

    while (r < arr.size) {
        sum += arr[r] % 2

        while (sum > k) {
            sum -= arr[l] % 2
            l += 1
        }

        count += (r - l + 1)
        r++
    }
    return count
}