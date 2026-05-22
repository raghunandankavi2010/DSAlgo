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


private fun getCommon(nums1: IntArray, nums2: IntArray): Int {

    var i = 0
    var j = 0

    while(i < nums1.size && j < nums2.size) {

        if(nums1[i] < nums2[j]) {
            i++
        } else if(nums2[j] < nums1[i]) {
            j++
        } else {
           return  nums1[i]
        }
    }
    return -1
}

fun main() {
    val nums1 = intArrayOf(1,2)
    val nums2 = intArrayOf(2,4)

    val commonMinNumber = getCommon(nums1, nums2)
    println(commonMinNumber)
}
