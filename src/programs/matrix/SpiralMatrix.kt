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

package programs.matrix

/**
 * fill 2d array from 1 to n2 given n in spiral order
 * https://leetcode.com/problems/spiral-matrix-ii/submissions/
 */
fun main(){
    val n = 3
    fillSpiralMatrix(n)
}

fun fillSpiralMatrix(n: Int) {
    var top = 0
    var bottom = n-1
    var left = 0
    var right = n-1
    val arr = Array(n) { IntArray(n) }
    var value = 1

    while (value <= n * n) {
        // left to right
        for (i in left..right) arr[top][i] = value++
        top++

        // up to down
        for (i in top..bottom) arr[i][right] = value++
        right--

        // right to left
        for (i in right downTo left) arr[bottom][i] = value++
        bottom--

        // bottom to top
        for (i in bottom downTo top) arr[i][left] = value++
        left++
    }

    for (i in arr.indices) {
        println(arr[i].contentToString())
    }
}
