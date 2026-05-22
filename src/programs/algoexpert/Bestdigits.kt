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

import java.util.ArrayDeque

fun main() {
    val num = "10"
    val k = 1
    println("Best digit is ${bestDigits(num, k)}")
}

private fun bestDigits(number: String, numDigits: Int): String {
    // Write your code here.
    val stack = ArrayDeque<Int>()
    var count = numDigits

    stack.add(number[0].digitToInt())

    for (i in 1 until number.length) {
        val num = number[i].digitToInt()

        while (stack.isNotEmpty() && count > 0 && num > stack.last()) {
            stack.removeLast()
            count--
        }
        stack.add(num)
    }

    while (count > 0 && stack.isNotEmpty()) {
        stack.removeLast()
        count--
    }

    return stack.joinToString("")
}
