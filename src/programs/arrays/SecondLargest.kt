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

fun main() {

    val arr = intArrayOf(12, 35, 1, 10, 34, 1)
    val secondLargest = findSecondLargest(arr)
    println(secondLargest)
    println("By Sorting")
    println(findSecondLargestBySSorting(arr))
}

fun findSecondLargestBySSorting(arr: IntArray): Int {

    arr.sort()
    return arr[arr.size - 2]
}

fun findSecondLargest(arr: IntArray): Int {

    var first = arr[0]
    var second = arr[0]

    for (i in 1 until arr.size) {
        if (arr[i] > first) {
            second = first
            first = arr[i]
        } else if (arr[i] > second && arr[i] != first) {
            second = arr[i]
        }
    }
    return second
}
