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
    val input = intArrayOf(1, 1, 2)
    val output = permuteUnique(input)
    println(output)

}

private fun permuteUnique(nums: IntArray): List<List<Int>> {
    val result = ArrayList<MutableList<Int>>()
    nums.sort()
    val used = BooleanArray(nums.size)
    permHelper(mutableListOf(), nums, result, used)
    return result
}

private fun permHelper(
    tempList: MutableList<Int>,
    nums: IntArray,
    result: ArrayList<MutableList<Int>>,
    used: BooleanArray
) {
    if(tempList.size == nums.size) {
        result.add(ArrayList(tempList))
        return
    }

    for(i in 0.. nums.size-1) {
        if(used[i]) {
            continue
        }
        if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
            continue
        }
        tempList.add(nums[i])
        used[i] = true
        permHelper(tempList, nums, result, used)
        used[i] = false
        tempList.removeAt(tempList.size-1)
    }
}
