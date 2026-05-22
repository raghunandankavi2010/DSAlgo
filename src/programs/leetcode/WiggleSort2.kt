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
    val array = intArrayOf(1,5,1,1,6,4)
    print("Wiggle sorted array = ${wiggleSort(array).contentToString()}")
}


private fun wiggleSort(nums: IntArray): IntArray {

    val sortedArray = nums.sortedArray()
    val n = nums.size

    var left = (n-1)/2
    var right = nums.size - 1

    for(i in 0..<n){
        if(i%2 ==0 ) {
            nums[i] = sortedArray[left]
            left--
        } else {
            nums[i] = sortedArray[right]
            right--
        }
    }

    return nums

}