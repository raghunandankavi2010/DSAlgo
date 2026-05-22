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

import java.util.*

/**
 * Sort array of zeros and 1
 */

fun main() {
    val array = arrayOf(1, 0, 1, 1, 0, 1, 0, 0)
    bubbleSort(array)
    sortArray(array)



}

fun sortArray(array: Array<Int>) {
    var left = 0
    var right = array.size -1
    while(left < right) {
        if(array[left] == 1) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            right --
        } else {
            left ++
        }
    }
    println(array.contentToString())
}

fun bubbleSort(array: Array<Int>) {
    val n = array.size - 1
    for(i in 0.. n) {
        for( j in 0.. n-(i+1)) {
            if(array[j] >= array[j+1]) {
                val temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
            }
        }
    }
    println(array.contentToString())
}