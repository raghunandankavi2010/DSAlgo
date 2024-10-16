package programs.strings

import java.lang.StringBuilder
import java.util.*

/**
 *  Given String s1 = "ab#c"
 *  where # represents a backspace ie delete character b results in ac
 *  Similarly for String s1 = "ad#c" results is ac
 *  comparing s1 == s2 is true else false
 */

fun main() {

    val s1 = "ab#c"
    val s2 = "ad#c"
    val isTrue = check(s1, s2)
    println(isTrue)

}

fun check(s1: String, s2: String): Boolean {

    val string1 = processString(s1)
    val string2 = processString(s2)
    println("$string1 $string2")
    return string1 == string2
}

fun processString(s: String): String {
    val stack = Stack<Char>()
    val result = StringBuilder()
    val sCharArray = s.toCharArray()
    var temp = ' '
    for (i in sCharArray.indices) {
        if (sCharArray[i] != '#') {
            temp = ' '
            stack.push(sCharArray[i])
        } else if (stack.isNotEmpty() && temp != '#') {
            temp = '#'
            stack.pop()
        }
    }

    while (stack.isNotEmpty()) {
        result.insert(0,stack.pop())
    }

    return result.toString()

}
