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

import java.util.HashMap

/**
 *  Find pairs whose sum is K given an array of integers
 *  Do it in one pass
 *  One way is to sort array and then increment low and high based on sum greater os lesser than k
 */
fun main() {
    val intArray = intArrayOf(10,25,0,5,7,20,3)
    val k = 3

    val complementMap: HashMap<Int, Int> = HashMap()

    for (i in intArray.indices) {
        val curr: Int = intArray[i]
        if (complementMap.containsKey(k - curr)) {
          println("Pair is $curr ${complementMap[k - curr]}")
            break
        }
        complementMap[curr] = curr
    }

}