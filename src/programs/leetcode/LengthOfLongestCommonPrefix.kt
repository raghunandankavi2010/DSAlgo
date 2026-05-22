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
    val arr1 = intArrayOf(5655359)
    val arr2 = intArrayOf(56554)
    println(longestCommonPrefix(arr1,arr2))
}

private fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
    val prefixSet = HashSet<String>()

    //arr1 = [1,10,100], arr2 = [1000]
    for (num in arr1) {
        val str = num.toString()
        for (i in 1..str.length) {
            prefixSet.add(str.substring(0, i))
        }
    }
    var maxLength = 0
    for (num in arr2) {
        val str = num.toString()
        for (i in 1..str.length) {
            val prefix = str.substring(0, i)
            if (prefix in prefixSet && i > maxLength) {
                maxLength = i
            }
        }
    }


    return maxLength

}