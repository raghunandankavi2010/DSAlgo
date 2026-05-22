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

/**
 * Given an array of integers between 1 to n find the first duplicate number
 */

fun main() {
    val arr = mutableListOf(2, 1, 5, 3, 3, 2, 4)
    print(firstDuplicateValue(arr))

}

private fun firstDuplicateValue(array: MutableList<Int>): Int {
    var duplicateNum = -1
    for (i in 0 until array.size) {
        val index = kotlin.math.abs(array[i]) - 1
        if (index >= array.size) continue  // Skip if index is out of bounds

        if (array[index] < 0) {
            duplicateNum = index + 1
            break
        } else {
            array[index] = -array[index]
        }
    }
    return duplicateNum
}
