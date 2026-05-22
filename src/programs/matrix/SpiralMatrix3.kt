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
 * https://leetcode.com/problems/spiral-matrix-iii/
 * Solution hint from https://www.youtube.com/watch?v=0qep3f9cqVs
 */
class SpiralMatrix3 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>)  {
            val R = 5
            val C = 6
            val r0 = 1
            val c0 = 4
            val matrix = spiralMatrix3(R,C,r0,c0)
            for (i in matrix.indices) {
                println(matrix[i].contentToString())
            }
        }

        private fun spiralMatrix3(R: Int, C: Int, r: Int, c: Int): Array<IntArray> {
            var r0: Int = r
            var c0 = c
            val directions = intArrayOf(0, 1, 0, -1, 0)
            val result = Array(R * C) { IntArray(2) }
            var i = 0
            result[i++] = intArrayOf(r0, c0)
            var len = 0
            var d = 0
            while (i < R * C) {
                if (d == 0 || d == 2) {
                    //plus one when moving east or west
                    len++
                }
                for (k in 0 until len) {
                    r0 += directions[d]
                    c0 += directions[d + 1]
                    if (r0 in 0 until R && c0 in 0 until C) {
                        result[i++] = intArrayOf(r0, c0)
                    }
                }
                d = (d + 1) % 4
            }
            return result
        }
    }
}