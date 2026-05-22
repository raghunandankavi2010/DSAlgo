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
    val array = intArrayOf(1, 0, 0, -1, -1, 0, 1, 1).toMutableList()
    val order = intArrayOf(0, 1, -1).toList()

    print(threeNumberSort(array,order))
}

private fun threeNumberSort(array: MutableList<Int>, order: List<Int>): List<Int> {
    // Write your code here.

    var start = 0
    var mid = 0
    var end =   array.size - 1
    val firstNum = order[0]
    val midNum =  order[1]

    while (mid <= end) {
        val value = array[mid]

        when (value) {
            firstNum -> {
               val temp = array[start]
                array[start] = array[mid]
                array[mid] = temp
                start++
                mid++
            }
            midNum -> {
                mid++
            }
            else -> {
                val temp = array[mid]
                array[mid] = array[end]
                array[end] = temp
                end--
            }
        }
    }
    return array
}
