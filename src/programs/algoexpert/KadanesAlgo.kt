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

package programs.algoexpert

fun kadanesAlgorithm(array: List<Int>): Int {
    var currentMax = array[0]
    var globalMax = array[0]

    for (i in 1 until array.size) {
        currentMax = Math.max(array[i], currentMax + array[i])
        if (currentMax > globalMax) {
            globalMax = currentMax
        }
    }
    return globalMax
}

fun main() {
    val arr = arrayOf(3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4)
    val list = arr.toList()
    println(kadanesAlgorithm(list)) // Output should be the maximum sum of contiguous subarray
}
