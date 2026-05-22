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

package programs.leetcode

import java.util.*
import kotlin.math.max

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.



Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 */
fun main() {

    val input = "(()"
    val len = findLongestValidParenthesisUsingStack(input)
    println(len)
    val output = findLongestValidParenthesis(input)
    println(output)

}

fun findLongestValidParenthesis(input: String): Int {

    var open = 0
    var close = 0
    var maxLen = 0
    for(i in input.indices) {
        val char = input[i]
        if(char == '(') {
            open++
        } else {
            close++
        }

        if(open == close ){
            val len = open + close
            maxLen = max(maxLen,len)
        } else if(close > open) {
            open = 0
            close = 0
        }
    }

    open = 0
    close = 0

    for(i in input.length -1 downTo 0) {
        val char = input[i]
        if(char == '(') {
            open ++
        } else {
            close ++
        }

        if(open == close ){
            val len = open + close
            maxLen = max(maxLen,len)
        } else if(open > close) {
            open = 0
            close = 0
        }
    }
    return maxLen

}

// )()())
//1 . stack initially has -1
//2. first char is ) so pop index -1. Now stack is empty push index 0
//3. char is ( push index to stack ie 1
//4. char is ) so pop from stack ie index 1. stack is not empty
//5. calculate the valid length current index is 2 and top of stack is 0. So 2 - 0 = 2 valid length
//6. Repeat the above taking max length
fun findLongestValidParenthesisUsingStack(input: String): Int {

    val stack = Stack<Int>()
    stack.push(-1)
    var maxLen = 0
    for(i in input.indices) {
        val char = input[i]
        if(char == '('){
            stack.push(i)
        } else{
            stack.pop()
            if(stack.isEmpty()){
               stack.push(i)
            } else {
                val topIndex = stack.peek()
                maxLen = max(maxLen,i-topIndex)
            }
        }
    }

    return maxLen

}
