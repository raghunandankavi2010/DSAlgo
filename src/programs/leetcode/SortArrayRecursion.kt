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

class SortArrayRecursion {

    fun sortArray(array: IntArray): IntArray {
        recurseSort(array,0)
        return array
    }

    fun recurseSort(array: IntArray, i: Int) {
        if(i == array.size) return
        var j = i
        while(j > 0 && array[j-1] > array[j]) {
            val temp = array[j-1]
            array[j-1] = array[j]
            array[j] = temp
            j--
        }

        recurseSort(array, i +1)
    }

}

fun main() {
    val array = intArrayOf(5,2,3,1)
    val sortArrayRecursion = SortArrayRecursion()
    val output = sortArrayRecursion.sortArray(array)
    print(output.toList())
}