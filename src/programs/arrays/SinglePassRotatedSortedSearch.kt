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
    // Test Case 1: Standard rotated array, target exists in the right half
    val nums1 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target1 = 0
    println("Test Case 1:")
    println("Input: nums = ${nums1.contentToString()}, target = $target1")
    println("Result Index: ${search(nums1, target1)}") // Expected output: 4
    println("---")

    // Test Case 2: Target does not exist in the array
    val nums2 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target2 = 3
    println("Test Case 2:")
    println("Input: nums = ${nums2.contentToString()}, target = $target2")
    println("Result Index: ${search(nums2, target2)}") // Expected output: -1
    println("---")

    // Test Case 3: Single element array where target is missing
    val nums3 = intArrayOf(1)
    val target3 = 0
    println("Test Case 3:")
    println("Input: nums = ${nums3.contentToString()}, target = $target3")
    println("Result Index: ${search(nums3, target3)}") // Expected output: -1
}

/**
 * Searches for a target value in a rotated sorted array in O(log n) time.
 */
private fun search(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        if (target == nums[mid]) return mid

        // Check if the left half is normally sorted
        if (nums[low] <= nums[mid]) {
            // Check if the target falls within the sorted left half
            if (target >= nums[low] && target < nums[mid]) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        // Otherwise, the right half must be normally sorted
        else {
            // Check if the target falls within the sorted right half
            if (target > nums[mid] && target <= nums[high]) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
    }
    return -1
}