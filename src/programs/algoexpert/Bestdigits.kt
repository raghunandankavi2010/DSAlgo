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
