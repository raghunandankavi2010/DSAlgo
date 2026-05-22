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

private fun findMinElem(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    // Optimization: If the array is not rotated, return the first element
    if (nums[left] <= nums[right]) {
        return nums[left]
    }

    while (left < right) {
        val mid = left + (right - left) / 2

        if (nums[mid] > nums[right]) {
            // The minimum must be in the right part
            left = mid + 1
        } else {
            // The minimum is mid or in the left part
            right = mid
        }
    }

    // When left == right, we've found the smallest element
    return nums[left]
}

fun main() {
    // Test Case 1: Rotated array
    val nums1 = intArrayOf(3,4,5,1,2)
    println("Array: ${nums1.joinToString(", ")}")
    println("Minimum: ${findMinElem(nums1)}") // Output: 0

    println("---")

    // Test Case 2: Array rotated n times (fully sorted)
    val nums2 = intArrayOf(11, 13, 15, 17)
    println("Array: ${nums2.joinToString(", ")}")
    println("Minimum: ${findMinElem(nums2)}") // Output: 11

    println("---")

    // Test Case 3: Small array
    val nums3 = intArrayOf(2, 1)
    println("Array: ${nums3.joinToString(", ")}")
    println("Minimum: ${findMin(nums3)}") // Output: 1
}