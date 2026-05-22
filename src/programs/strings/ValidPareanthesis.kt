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

import java.lang.StringBuilder
import java.util.*

/**
 * Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

 */

fun main() {
    val input = "lee(t(c)o)de)"
    println(validParenthesis(input))
}

fun validParenthesis(input: String): String {
    val ch = input.toCharArray()
    val stack = Stack<Int>()

    ch.forEachIndexed { index, element ->
        if (element == '(') {
            stack.push(index)
        } else if (element == ')') {
            if (stack.isEmpty()) {
                ch[index] = '*' // process the string by adding * if its not a valid parenthesis
            } else {
                stack.pop() // if it valid just pop the index from stack
            }
        }
    }

    // left over index in stack is invalid so add * in those indexes
    while (!stack.isEmpty()) {
        ch[stack.pop()] = '*'
    }

    // build the string ignoring invalid character *
    val sb = StringBuilder()
    ch.forEach {
        if (it != '*') {
            sb.append(it)
        }
    }
    return sb.toString()
}
