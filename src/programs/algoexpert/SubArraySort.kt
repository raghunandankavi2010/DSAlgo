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

import kotlin.math.max
import kotlin.math.min


fun main() {
    val array = listOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19)
    print(subarraySort(array))
}

private fun subarraySort(array: List<Int>): List<Int> {
    var minOutOfOrder = Integer.MAX_VALUE
    var maxOutOfOrder = Integer.MIN_VALUE
    for (i in 0 until array.size) {
        val num = array[i]
        if (isOutOfOrder(i, num, array)) {
            minOutOfOrder = min(minOutOfOrder, num)
            maxOutOfOrder = max(maxOutOfOrder, num)
        }
    }
    if (minOutOfOrder == Integer.MAX_VALUE) {
        return listOf(-1, -1)
    } else {
        var leftIndex = 0
        while (minOutOfOrder >= array[leftIndex]) {
            leftIndex++
        }
        var rightIndex = array.size - 1
        while (maxOutOfOrder <= array[rightIndex]) {
            rightIndex--
        }
        return listOf(leftIndex, rightIndex)
    }
}


private fun isOutOfOrder(i: Int, num: Int, array: List<Int>): Boolean {
    return when (i) {
        0 -> {
            num > array[0 + 1]
        }

        array.size - 1 -> {
            num < array[i - 1]

        }

        else -> {
            ((num > array[i + 1]) || (num < array[i - 1]))
        }
    }
}