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


fun main() {
    val input1 = intArrayOf(4,9,5)
    val input2= intArrayOf(9,4,9,8,4)
    intersection(input1,input2).forEach {
        print("$it ")
    }
    println("")
    val set = HashSet<Int>()

    if(input1.size > input2.size) {
        Arrays.sort(input1)
        input2.forEach{ element ->
            if(binarySearch(element,input1)){
                set.add(element)
            }

        }
    } else if(input1.size < input2.size) {
        Arrays.sort(input2)
        input2.forEach { element ->
            if(binarySearch(element,input1)) {
                set.add(element)
            }

        }
    } else {
        Arrays.sort(input1)
        input2.forEach{ element ->
            if(binarySearch(element,input1)){
                set.add(element)
            }

        }
    }

    val res = IntArray(set.size)
    var indx = 0
    for (i in set) {
        res[indx++] = i
    }
    res.forEach {
        println(it)
    }

}

fun binarySearch(key: Int, arr: IntArray): Boolean {
    var start = 0
    var end = arr.size - 1
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (arr[mid] == key) {
            return true
        } else if (arr[mid] > key) end = mid - 1 else {
            start = mid + 1
        }
    }
    return false
}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = HashSet<Int>()
    val set2 = HashSet<Int>()

    nums1.forEach {
        set1.add(it)
    }
    nums2.forEach {
        if(set1.contains(it)){
            set2.add(it)
        }
    }
    return set2.toIntArray()

}