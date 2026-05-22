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

package programs.strings

import java.util.*

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 *   An input string is valid if:
 *   Open brackets must be closed by the same type of brackets.
 *   Open brackets must be closed in the correct order.
 *   Note that an empty string is also considered valid.
 *   Example 1:
 *
 * Input: "()"
 *    Output: true
 *   Example 2:

 * Input: "()[]{}"
 * Output: true
 * Example 3:

 * Input: "(]"
 * Output: false
 * Example 4:

 * Input: "([)]"
 * Output: false
 * Example 5:

 * Input: "{[]}"
 * Output: true

 */

fun main() {
    val inputString = "(]"
    val output = checkValid(inputString)
    println(output)
}

fun checkValid(inputString: String): Boolean {
    val stack = Stack<Char>()
    for (element in inputString) {
        // push the elements to stack if its open brackets
        if (element == '(' || element == '[' || element == '{') {
            stack.push(element)
            continue
        }
        if (stack.isEmpty())
            return false
        // in case it is closing bracket check the top of stack is opening
        // bracket of same type. if so pop from the stack else return false
        when (element) {
            ')' -> {
                if('(' == stack.peek())
                stack.pop()
                else
                return false
            }
            '}' -> {
                if('{' == stack.peek())
                stack.pop()
                else
                return false
            }
            ']' -> {
                if('[' == stack.peek())
                stack.pop()
                else
                return false
            }
        }

    }
    return stack.isEmpty()
}



