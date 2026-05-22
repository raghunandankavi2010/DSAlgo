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


fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    // Write your code here.

    var end = array.size - 1
    var start = 0
    while (start <= end) {
        if (array[start] == toMove) {
            if(array[end] == toMove) {
                end--
            } else {
                val temp = array[start]
                array[start] = array[end]
                array[end] = temp
                start++
                end--
            }
        } else {
            start++
        }
    }
    return array
}


fun main() {

    val input = mutableListOf(2,1)
    print(moveElementToEnd(input, 2))
}

