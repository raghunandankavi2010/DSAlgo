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

fun printMatrix(matrix: List<List<Int>>) {
    println("Current state of the matrix:")
    if (matrix.isEmpty()) {
        println("[] (Matrix is empty)")
        return
    }

    matrix.forEachIndexed { index, row ->
        println("  Row $index: $row")
    }
}

fun main() {

    val matrix: MutableList<MutableList<Int>> = mutableListOf()

    val row1 = mutableListOf(1, 2 )
    //val row2 = mutableListOf(4, 5)
   // val row3 = mutableListOf(7, 8, 9)

    matrix.add(row1)
   // matrix.add(row2)
   // matrix.add(row3)
    println("Before Transpose")
    printMatrix(matrix)

    val output = transposeMatrix(matrix)
    printMatrix(output)

}

private fun transposeMatrix(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    // Write your code here.
    val result: MutableList<MutableList<Int>> = mutableListOf()

    val width = matrix[0].size
    val height = matrix.size


        for (i in 0 until width) { // row
            val rowElements = mutableListOf<Int>()
            for (j in 0 until height) { // col
                rowElements.add(matrix[j][i])
            }
            result.add(rowElements)
        }

    return result
}
