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

import kotlin.math.abs


/**
 * Two pointer technique problems
 * Given array  -6,-2,-1,1,4,6
 * Output = 1,1,4,16,36,36
 * Given array1  -6,-2,-1,1,4,6
 * Given array2 - 4,16,36
 * Output = -6 -2 -1 1 4 16 36 46
 */

fun main() {
    println("Merge two sorted Array")
    val nums1 = arrayOf(1,2,3,0,0,0)
    val m = 3
    val nums2 = arrayOf(2,5,6)
    val n = 3
    mergeArray(nums1,m,nums2,n)
    println("\nSquare and sort a sorted array")
    squareSort()
}

fun mergeArray(nums1: Array<Int>, m: Int, nums2: Array<Int>, n: Int) {
    val inputArray1 = nums1
    val inputArray2 = nums2

    var p1 = m - 1
    var p2 = n - 1
    val outputArray = IntArray(m + n) { 0 }

    var index = m + n- 1


    while (p1 >= 0 && p2 >= 0) {
        if (inputArray1[p1] >= inputArray2[p2]) {
            outputArray[index] = inputArray1[p1]
           --p1
        } else if(inputArray1[p1] < inputArray2[p2]){
            outputArray[index] = inputArray2[p2]
            --p2
        }
        --index
    }

    while (n >= 0 && p1 >= 0) {
        outputArray[index] = inputArray1[p1]
        p1--
        index--
    }

    while (n >= 0 && p2 >= 0) {
        outputArray[index] = inputArray2[p2]
        p2--
        index--
    }

    outputArray.forEach { num ->
        print("$num ")
    }
}

fun squareSort() {
    val inputArray = arrayOf(-6, -2, -1, 1, 4, 6)
    val outputArray = IntArray(inputArray.size) { 0 }

    var right = inputArray.size - 1
    var left = 0
    var n = inputArray.size - 1

    while (n >= 0) {
        if (abs(inputArray[left]) > inputArray[right]) {
            outputArray[n] = inputArray[left] * inputArray[left]
            left++
        } else {
            outputArray[n] = inputArray[right] * inputArray[right]
            right--
        }
        n--
    }

    outputArray.forEach { num ->
        print("$num ")
    }
}