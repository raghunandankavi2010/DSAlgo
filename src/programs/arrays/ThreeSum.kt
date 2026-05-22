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
    val arr = intArrayOf(0,0,0)
    println(threeSum(arr))
}


fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val listOfList = ArrayList<List<Int>>()
    for( i in nums.indices) {
        if(i > 0 && nums[i] == nums[i-1]) continue
        val target = 0 - nums[i]
        var left = i + 1
        var right = nums.size - 1
        while(left < right) {
            val sum = nums[left] + nums[right]
            if(sum == target) {
                val list = ArrayList<Int>()
                list.add(nums[left])
                list.add(nums[right])
                list.add(nums[i])
                listOfList.add(list)
                while(left < right && nums[left] == nums[left + 1] ) {
                    left++
                }
                while(right > left && nums[right] == nums[right - 1]) {
                    right--
                }
                right--
                left++
            } else if(sum > target) {
                right--
            } else {
                left--
            }
        }
    }

    return listOfList

}