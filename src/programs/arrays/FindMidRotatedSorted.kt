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

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
 */

/**
 * 4,5,6,7,0,1,2
 * l = 0 right points to 2
 * mid = 7; 7>2 so min lies between 0 and 2
 * if mid element < right most element then min lies either to left of mid or at mid
 * in case mid and right are same then we cannot decide which way to go
 * so just do right--
 *
 */
fun main() {
    val nums = intArrayOf(4,5,6,7,0,0,1,2)
    println(findMin(nums))
    val min = nums.minOrNull()
   val index =  min?.let{
        val index = nums.indexOf(min)
        index
    }

    println("Using standard functions available $min and the index is $index")
}

fun findMin(nums: IntArray): Int {
    var l = 0
    var r =  nums.size - 1

    while(l < r){
        val mid = l+(r-l)/2

        when {
            nums[mid]>nums[r] -> {
                l = mid+1
            }
            nums[mid]<nums[r] -> {
                r = mid
            }
            else -> {
                r--
            }
        }
    }
    println("Index where min element is $l")
    return nums[l]
}
