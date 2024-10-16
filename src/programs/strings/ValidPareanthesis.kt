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
