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

package programs.hackerearth

/**
 * Find the start index and end index in such a way,
 * that sorting the sub array will result in entire array sorted
 */
fun main() {
    val arr = intArrayOf(10, 12, 40, 35, 5, 50, 60)
    printUnsorted(arr)
}

fun printUnsorted(arr: IntArray) {
    var start = 0
    var end = 0

    for(i in arr.indices){
        if(arr[i]> arr[i+1]){
            start = i
            break
        }
    }

    if (start == arr.size-1) {
        return
    }

    for(i in arr.size-1 downTo 0) {
        if(arr[i] < arr[i-1]) {
            end = i
            break
        }
    }

    var min = arr[start]
    var max = arr[start]

    for(i in  (start + 1).. end) {
        if(arr[i] > max)
            max = arr[i]
        if(arr[i] < min)
            min = arr[i]
    }

    println("$min and $max")

    for( i in 0.. start){
        if(arr[i] > min) {
            start = i
            break
        }
    }

    for( i in arr.size-1 downTo (end+1)){
        if(arr[i] < max) {
            end = i
            break
        }
    }

    println("$start and $end")
}
