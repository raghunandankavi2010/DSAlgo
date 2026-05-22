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

package programs.stacks

import java.util.Stack

/**
 *
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 *
 *
 *
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 */
fun main() {
    val num = "10"
    val k = 2
    println(removeKdigits(num, k))
}

fun removeKdigits(num: String, k: Int): String {
    var count = k
    if (num.isEmpty()) {
        return ""
    } else if(num.length == 1 && k == 1) {
        return "0"
    }
    val stack = Stack<Char>()

    num.forEach {

        while (count > 0 && stack.isNotEmpty() && stack.peek() > it) {
            stack.pop()
            count--
        }
        stack.add(it)
    }

    while(count > 0 && stack.isNotEmpty()) {
        stack.pop()
        count--
    }

    if(stack.isEmpty()) {
        return "0"
    } else if(stack.size == 1){
        return stack.joinToString("")
    }

    val joinedString =  stack.joinToString("").trimStart('0')
    if(joinedString.isEmpty()) {
        return "0"
    } else {
        return joinedString
    }
}