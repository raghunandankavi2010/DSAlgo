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
import programs.search.BinarySearch

/**
 * Search in sorted array binary search
 * o(logn)
 */
class BinarySearch {
    private fun binarySearch(arr: IntArray, key: Int, low: Int, high: Int): Int {
        if (low > high) return -1
        if (low == high && arr[low] == key) return low
        val mid = (low + high) / 2
        if (arr[mid] == key) return mid
        return when {
            arr[mid] < key -> binarySearch(arr, key, mid + 1, high)
            arr[mid] > key -> binarySearch(
                arr,
                key,
                low,
                mid - 1
            )
            else -> -1
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            val key = 2
            val binarySearch = BinarySearch()
            val low = 0
            val high = arr.size - 1
            val searchIndex = binarySearch.binarySearch(arr, key, low, high)
            if (searchIndex != -1) println("Number :" + arr[searchIndex] + " found at index " + searchIndex) else println(
                "Element not found"
            )
        }
    }
}