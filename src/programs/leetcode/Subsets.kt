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
 *
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,23]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
fun main() {
    val arr = intArrayOf(1,2,2)
    println(subsets(arr))
    println(subsetsWithDup(arr))
}

/**
 * At each step we have 2 choices include current or exclude current
 * if n is the number of elements for each n we have 2 such choices
 * So at each step its 2 power n. n time 2 power n is because copying
 * n elements to result
 */

fun subsets(nums: IntArray): List<List<Int>> {

    val currentSubset = mutableListOf<Int>()
    val result = mutableListOf<List<Int>>()

    fun backtrack(index: Int) {
        result.add(ArrayList(currentSubset))
        for (i in index until nums.size) {


            currentSubset.add(nums[i])
            backtrack(i + 1)
            currentSubset.removeAt(currentSubset.size - 1)
        }
    }
    backtrack(0)
    return result
}

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val currentSubset = mutableListOf<Int>()
    val result = mutableListOf<List<Int>>()

    fun backtrack(index: Int) {
        result.add(ArrayList(currentSubset))
        for (i in index until nums.size) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue // Skip this element to avoid duplicate subsets
            }

            currentSubset.add(nums[i])
            backtrack(i + 1)
            currentSubset.removeAt(currentSubset.size - 1)
        }
    }
    backtrack(0)
    return result
}