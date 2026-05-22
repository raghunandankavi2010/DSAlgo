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
    val input = mutableListOf(8,5,2,9,5,6,3)
    print(quickSort(input))
}

private fun quickSort(array: MutableList<Int>): List<Int> {
    // Write your code here.
    sort(array,0,array.size -1)
    return array
}

private fun sort(array: MutableList<Int>, i: Int, j: Int) {
    var start = i
    var end = j
    val key = start + (end-start)/2
    while(start <= end) {

        while (array[start] < array[key]) {
            start++
        }
        while (array[end] > array[key]) {
            end--
        }

        if(start <= end){
            val temp = array[start]
            array[start] = array[end]
            array[end] = temp
            start++
            end--
        }


        if (start < j)
            sort(array,start, j)
        if (i < end)
            sort(array,i, end)
    }
}
