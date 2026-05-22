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


/**
 *
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0
 */

fun main() {

    val mat = arrayOf(intArrayOf(0, 0, 0, 1), intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 1, 1), intArrayOf(0, 0, 1, 1))
    println("${calculate(mat).first} and index ${calculate(mat).second}")
}

fun calculate(mat: Array<IntArray>): Pair<Int, Int> {
    var max = 0
    var arrayRow = -1
    for (i in mat.indices) {
        val index = binarySearch(mat[i], 0, mat[i].size - 1)
        if (index != -1) {
            val count: Int = mat[i].size - index
            if (count > max) {
                max = count
                arrayRow = index
            }
        }
    }
    return Pair(max, arrayRow)
}

fun binarySearch(array: IntArray, low: Int, high: Int): Int {
    return if (array[low] == 1) {
        low
    } else if (low < high) {
        val mid = low + (high - low) / 2
        if (array[mid] == 1 && array[mid - 1] == 0) return mid
        if (array[mid] == 0 && array[mid + 1] == 1) return mid + 1
        if (array[mid] == 0 && array[mid + 1] != 1) {
            binarySearch(array, mid + 1, high)
        } else {
            binarySearch(array, low, mid - 1)
        }
    } else {
        -1
    }
}

