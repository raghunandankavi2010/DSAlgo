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

fun main() {
    val array = listOf(1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6)
    val result = largestRange(array)
    print(result)
}

private fun largestRange(array: List<Int>): List<Int> {
    if (array.isEmpty()) {
        return emptyList()
    }
    val sortedArray = array.sorted()
    var longestRange = listOf(sortedArray[0], sortedArray[0])

    var currentStart = sortedArray[0]

    for (i in 1 until sortedArray.size) {
        val currentNum = sortedArray[i]
        val prevNum = sortedArray[i - 1]

        if (currentNum != prevNum + 1) {
            val currentRangeLength = prevNum - currentStart + 1
            val maxRangeLength = longestRange[1] - longestRange[0] + 1

            if (currentRangeLength > maxRangeLength) {
                longestRange = listOf(currentStart, prevNum)
            }
            currentStart = currentNum
        }
    }

    val lastElement = sortedArray.last()
    val lastRangeLength = lastElement - currentStart + 1
    val maxRangeLength = longestRange[1] - longestRange[0] + 1

    if (lastRangeLength > maxRangeLength) {
        longestRange = listOf(currentStart, lastElement)
    }

    return longestRange
}

private fun largestRangeOptimized(array: List<Int>): Pair<Int, Int> {
    if (array.isEmpty()) {
        return Pair(-1,-1)
    }

    var longestRange = emptyList<Int>()
    var maxLength = 0

    val numMap = mutableMapOf<Int, Boolean>()
    for (num in array) {
        numMap[num] = false
    }

    for (num in array) {
        if (numMap[num] == true) {
            continue
        }

        numMap[num] = true
        var currentLength = 1

        var left = num - 1
        while (numMap.containsKey(left)) {
            numMap[left] = true // Mark as visited
            currentLength++
            left--
        }

        var right = num + 1
        while (numMap.containsKey(right)) {
            numMap[right] = true // Mark as visited
            currentLength++
            right++
        }

        if (currentLength > maxLength) {
            maxLength = currentLength
            longestRange = listOf(left + 1, right - 1)
        }
    }

    return Pair(longestRange[0],longestRange[1])

}