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

    //12 6 4
    val array = intArrayOf(12, 3, 4, 1, 6, 9,20)
    val k = 3
    val minHeap = PriorityQueue<Int>()
    var index = 0
    var count = 0
    while (count < k && index < array.size) {
        if (array[index] % 2 == 0) {
            minHeap.add(array[index])
            count++
        }
        index++
    }

    for (i in index until array.size) {
        if (minHeap.peek() > array[i]) continue else {
            if (array[i] % 2 == 0 && !minHeap.contains(array[i])) { // contains check is to avoid duplicates
                minHeap.poll()
                minHeap.add(array[i])
            }
        }
    }
    var max = 0

    val iterator: Iterator<Int> = minHeap.iterator()

    while (iterator.hasNext()) {
        max += iterator.next()
    }

    println(max)
}