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

import java.util.*


fun main() {
    val arr = intArrayOf(1,2,3,0,0,0,-4,-2)
    val k = 5
    val target = 0
    println(combinationSum(arr, target, k))
}


fun combinationSum(nums: IntArray, target: Int, k: Int): List<List<Int>> {
    val list: MutableList<List<Int>> = ArrayList()
    Arrays.sort(nums)
    backtrack(list, ArrayList(), nums, target, 0, k)
    return list
}

private fun backtrack(
    list: MutableList<List<Int>>,
    tempList: MutableList<Int>,
    nums: IntArray,
    remain: Int,
    start: Int,
    k: Int
) {
    if (remain < 0)
        return
    else if (remain == 0 && tempList.size == k) {
        list.add(ArrayList(tempList))
        return
    } else {
        for (i in start until nums.size) {
            if (i > start && nums[i] == nums[i - 1]) continue  // skip duplicates
            tempList.add(nums[i])
            backtrack(list, tempList, nums, remain - nums[i], i + 1, k)
            tempList.removeAt(tempList.size - 1)
        }
    }
}
