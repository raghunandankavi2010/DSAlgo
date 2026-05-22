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
    val arr = listOf(5, 1, 4, 2)
    // left  ->  1    5    5    20
    // right ->  8    8    2    1

    val result = arrayOfProducts(arr)
    println(result)
}

private fun arrayOfProducts(array: List<Int>): List<Int> {
    // Write your code here.
    val outputArr = MutableList(array.size) { 1 }

    outputArr[0] = 1
    for (i in 1 until array.size) {
        outputArr[i] = outputArr[i - 1] * array[i-1]
    }

    var right = 1
    for (i in array.size - 1 downTo 0) {
        outputArr[i] = outputArr[i] * right
        right *= array[i]
    }

    return outputArr
}
