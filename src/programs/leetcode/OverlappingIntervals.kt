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
    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18)
    )
    val list = merge(intervals)
    list.forEach {
        println("${it[0]} ${it[1]}")
    }
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy { it[0] }
    val list = mutableListOf<IntArray>()
    list.add(intervals[0])
    for(i in 1 until intervals.size) {
        val last: IntArray = list[list.size - 1]
        val curr: IntArray = intervals[i]
        if (curr[0] <= last[1]) {
            last[1] = last[1].coerceAtLeast(curr[1])
        } else {
            list.add(curr)
        }
    }
    return list.toTypedArray()
}