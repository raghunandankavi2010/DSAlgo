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

    val arr = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 1),
    )
    val row = arr.size
    val col = arr[0].size
    numberOfProvinces(arr, row, col)
}

fun numberOfProvinces(arr: Array<IntArray>, row: Int, col: Int) {
    val visited = BooleanArray(row)
    var count = 0

    for (i in 0 until row) {
        if (!visited[i]) {
            count++
            dfsProvinces(arr, visited, i)

        }
    }

    println(count)
}


fun dfsProvinces(grid: Array<IntArray>, visited: BooleanArray, i: Int) {
    if (visited[i]) {
        return
    }
    visited[i] = true
    for (j in grid[0].indices) {
        if (grid[i][j] == 1) {
            dfsProvinces(grid, visited, j)
        }
    }
}