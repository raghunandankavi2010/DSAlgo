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

data class Quadrets(val first: Int, val second: Int, val third: Int, val fourth: Int)

fun main() {
    val inputArray = intArrayOf(1, 0, -1, 0, -2, 2)

    val target = 2

    Arrays.sort(inputArray)

    val set = HashSet<Quadrets>()

    for (i in inputArray.indices) {
        for (j in i + 1 until inputArray.size) {
            var start = j + 1
            var end = inputArray.size - 1
            while (start < end) {
                val sum = inputArray[i] + inputArray[j] + inputArray[start] + inputArray[end]
                if (sum == target) {
                    val quadrets = Quadrets(inputArray[i], inputArray[j], inputArray[start], inputArray[end])
                    if (!set.contains(quadrets)) {
                        set.add(quadrets)
                    }
                    start++
                    end--

                } else if (sum > target) {
                    end--
                } else {
                    start++
                }
            }
        }
    }

    set.forEach { quadret ->
        println("${quadret.first} ${quadret.second} ${quadret.third} ${quadret.fourth} ")
        
    }
}