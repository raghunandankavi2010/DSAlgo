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
    val arr = intArrayOf(0, 1, 21, 33, 45, 61, 71, 72, 73)
    val target = -1
    val output = binarySearch(arr,0, arr.size-1, target)
    println("Target $target found at index $output")

}

private fun binarySearch(arr: IntArray, start: Int, end: Int, target: Int): Int {
    if(arr.isEmpty()) return -1
    if(start > end) return -1

    val mid = start + (end - start) / 2

    return if(arr[mid] == target) {
        mid
    } else if(target > arr[mid]) {
        binarySearch(arr,mid+1,end, target)
    } else {
        binarySearch(arr,start,mid-1, target)
    }
}