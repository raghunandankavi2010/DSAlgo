package programs.algoexpert

import java.util.Stack

fun main() {

    val str = ")[]}"

    println(balancedBrackets(str))
}

fun balancedBrackets(str: String): Boolean {
    // Write your code here.
    val stack = Stack<Char>()
    str.forEachIndexed { index, char ->
        if (char == '{' || char == '(' || char == '[') {
            stack.push(char)
        }

        if (stack.isEmpty() && index == str.length - 1)
            return false
        if (stack.isNotEmpty()) {
            when (char) {
                ')' -> {
                    if ('(' == stack.peek())
                        stack.pop()
                    else
                        return false
                }

                '}' -> {
                    if ('{' == stack.peek())
                        stack.pop()
                    else
                        return false
                }

                ']' -> {
                    if ('[' == stack.peek())
                        stack.pop()
                    else
                        return false
                }
            }
        }

    }


    return stack.isEmpty()
}
