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
 * Write a function that takes in a "special" array and returns its product sum.
 * A "special" array is a non-empty array that contains either integers or other "special" arrays. The product sum of a "special" array is the sum of its elements, where "special" arrays inside it are summed themselves and then multiplied by their level of depth.
 * The depth of a "special" array is how far nested it is. For instance, the depth of [] is 1; the depth of the inner array in [[]] is 2; the depth of the innermost array in [[[]]] is 3.
 * Therefore, the product sum of [x, y] is x + y; the product sum of [x, [y, z]] is x + 2 * (y + z); the product sum of [x, [y, [z]]] is x + 2 * (y + 3z).
 * Sample Input
 * array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
 */

fun main() {
    val specialArray: List<Any> = listOf(
        5,
        2,
        listOf(7, -1),
        3,
        listOf(6, listOf(-13, 8), 4)
    )
    val output = productSum(specialArray)
    println(output)
}

private fun productSum(list: List<*>, depth: Int = 1): Int {
    var sum = 0
    for (element in list) {
        sum += if (element is List<*>) {
            // It's a nested list, so recurse
            // The type cast to List<Any> is safe due to the 'is' check
            productSum(element as List<Any>, depth + 1)
        } else {
            // It's an integer
            element as Int
        }
    }
    return sum * depth
}
