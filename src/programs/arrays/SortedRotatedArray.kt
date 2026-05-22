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

package programs.arrays

/**
 * Given input array 3,4,5,0,1,2
 * The array is rotated and sorted
 * Rotated by 3 position at index 3 with min value 0
 *
 */
fun main() {
    val input = intArrayOf(3,4,5,0,1,2)
    val isSortedRotated = checkSortedRotated(input)
    println(isSortedRotated)
}

fun checkSortedRotated(input: IntArray): Boolean {

    // find min element
    val min = input.minOrNull()
    // find index of min element
    val index = min?.let { input.indexOf(it) }

    // check if elements from 0 to min element are in increasing order
    var flag1 = true
    for(i in 1 until index!!){
        if(input[i]<input[i-1]){
            flag1 = false
            break
        }
    }

    // check if elements from min element + 1 to array length is in increasing order
    var flag2 = true
    for(i in index+1 until input.size){
        if(input[i]<input[i-1]){
            flag2 = false
            break
        }
    }

    // if array is rotated the first element is greater then last element
    return flag1 && flag2 && input[input.size-1] < input[0]
}
