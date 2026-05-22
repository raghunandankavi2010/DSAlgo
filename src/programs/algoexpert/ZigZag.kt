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

    val givenMatrix = listOf(
        listOf(1, 3, 4, 10),
        listOf(2, 5, 9, 11),
        listOf(6, 8, 12, 15),
        listOf(7, 13, 14, 16)
    )
    val output = zigzagTraverse(givenMatrix)
    println("Zig Zag Traversal of a matrix")
    println(output)
}

private fun zigzagTraverse(array: List<List<Int>>): List<Int> {
    var goingDown = true
    val height = array.size - 1
    val width = array[0].size - 1
    val result = mutableListOf<Int>()

    var row = 0
    var col = 0

    while(!isOutOfBounds(row,col,height,width)) {
        result.add(array[row][col])
        if(goingDown) {
            if(col == 0 || row == height) {
                goingDown = false
                if(row == height) {
                    col++
                } else {
                    row++
                }
            } else {
                row++
                col--
            }
        } else {
            if( col == width || row == 0) {
                goingDown = true
                if(col == width) {
                    row++
                } else {
                    col++
                }
            } else {
                row--
                col++
            }
        }

    }

    return result
}


private fun isOutOfBounds(row: Int, col: Int, height: Int, width: Int) =
    row < 0 || row > height || col < 0 || col > width
