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

private lateinit var  numbers: IntArray

fun main() {
    val arr = intArrayOf(2, 5, 8, 1, 2, 9, 10, 33, 11)
    val target = 33
    val n = arr.size - 1

    sort(arr)
    println("Sorted Array")
    arr.forEach {
        println(it)
    }
    println("--------------------------------------")
    val element  = binarySearch(arr, target, 0, n)
    if(element==-1){
        println("Element not found")
    }else{
        println("Element found $element")
    }
}

fun binarySearch(arr: IntArray, target: Int, i: Int, j: Int): Int {
    var low = i
    var high = j
    if (low > high) {
        return -1
    }
    if (low == high && arr[low] == target) {
        return arr[low]
    }
    val middle = (low + high) / 2
    when {
        arr[middle] == target -> {
            return arr[middle]
        }
        arr[middle] > target -> {
            high = middle - 1
        }
        else -> {
            low = middle + 1
        }
    }
    return binarySearch(arr, target, low, high)
}

fun sort(arr: IntArray) {

    if (arr.isEmpty()) {
        return
    }
    val i = 0
    val j = arr.size-1
    numbers = arr
    quicksort( i, j)


}

fun quicksort( low: Int, high: Int) {

    var i = low
    var j = high

    val key: Int = numbers[low + (high - low) / 2]


    while (i <= j) {
        while (numbers[i] < key) {
            i++
        }
        while (numbers[j] > key) {
            j--
        }
        if (i <= j) {
            val temp = numbers[i]
            numbers[i] = numbers[j]
            numbers[j] = temp
            i++
            j--

        }
        if (low < j)
            quicksort(low, j)
        if (i < high)
            quicksort(i, high)
    }


}
