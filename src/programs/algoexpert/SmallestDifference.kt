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

import kotlin.math.abs

fun main() {
    val arr1 = mutableListOf(-1, 5, 10, 10, 28, 3)
    val arr2 = mutableListOf(26, 134, 135, 15, 17)
    val output = smallestDifference(arr1, arr2)
    print("$output")
}

private fun smallestDifference(
    arrayOne: MutableList<Int>,
    arrayTwo: MutableList<Int>
): List<Int> {
    val list1 = arrayOne.sorted()
    val list2 = arrayTwo.sorted()
    val n = list1.size - 1
    val m = list2.size - 1

    var p1 = 0
    var p2 = 0
    var resultPair = emptyList<Int>()

    var smallestDiff = Integer.MAX_VALUE
    while (p1 <= n && p2 <= m) {
        val first = list1[p1]
        val second = list2[p2]
        val diff = abs(first - second)

        if (diff < smallestDiff) {
            smallestDiff = diff
            resultPair = listOf(first, second)
        }

        if (diff == 0) {
            return resultPair
        }

        if (first < second) {
            p1++
        } else {
            p2++
        }
    }

    return resultPair
}
