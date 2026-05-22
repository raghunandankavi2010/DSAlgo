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

package programs.search

fun main() {
    val nums = intArrayOf(1, 2, 4, 8, 9)
    val k = 3
    print(aggressiveCows(nums,k))

}

fun aggressiveCows(nums: IntArray, cows: Int): Int {
    nums.sort()
    var low = 0
    var high = nums[nums.size-1] - nums[0]
    var res = 0

    while(low <= high) {
        val mid = low+(high-low)/2
         if(checkIfPossible(nums,cows,mid)) {
             res = mid
             low = mid + 1
         } else {
             high = mid - 1
         }
    }
    return res

}

fun checkIfPossible(nums: IntArray, cows: Int, dist: Int): Boolean {

    var prevStall = nums[0]
    var count = 1
     for( i in 1..<nums.size) {
         if(nums[i] - prevStall >= dist) {
             prevStall = nums[i]
             count++

         }
     }
    return (count >= cows)

}
