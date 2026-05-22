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

package programs.search

import kotlin.jvm.JvmStatic
import programs.search.MissingElementSearch

object MissingElementSearch {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1, 3, 4, 5)
        val x = findMissingElement(arr)
        println(x)
    }

    private fun findMissingElement(arr: IntArray): Int {
        var low = 0
        var high = arr.size - 1
        while (low <= high) {
            val middle = (low + high) / 2
            // index+1 should correspond to the number at index
            // this is the most important condition which i missed
            if (arr[middle] != middle + 1 && arr[middle - 1] == middle) {
                return middle + 1
            }
            // arr[middle] != middl+1
            // this mean there is a missing element towards left of array
            if (arr[middle] != middle + 1) {
                high = middle - 1
            } else { // missing element towards right of array
                low = middle + 1
            }
        }
        return -1
    }
}