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
 * Asked in L&T
 * Given an array of unsorted array
 * 2, 4, 5, 6, 1, 30, 13, 25, 10
 * create another array with elements
 * firstMin,firstMax,secondMin,secondMax
 * output
 * 1,30,2,25
 * Complexity O(n)
 */
fun main() {
    val intArray = arrayOf(2, 4, 5, 6, 1, 30, 13, 25, 10)
    var firstMin = intArray[0]
    var secondMin = 0
    var firstMax = intArray[0]
    var secondMax = 0

    for (i in 1 until intArray.size) {
        // find firstMin
        if (intArray[i] < firstMin) {
            secondMin = firstMin
            firstMin = intArray[i]
        }
        // if there are other elements that are less than secondMin
        else if (intArray[i] < secondMin) {
            secondMin = intArray[i]
        }
        // first firstMax and secondMax
        if (intArray[i] > firstMax) {
            secondMax = firstMax
            firstMax = intArray[i]
        } else if (intArray[i] > secondMax) {
            secondMax = intArray[i]
        }
    }

    val outputArray = arrayOf(firstMin, firstMax, secondMin, secondMax)
    outputArray.forEach {
        print(" $it")
    }
}