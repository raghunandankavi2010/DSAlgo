package programs.strings

import java.lang.StringBuilder

fun main() {
    val input = "021"
    val output = buildParenthesis(input)
    println(output)

}

fun buildParenthesis(input: String): String {
    val chars = input.toCharArray()
    var curr = 0
    val sb = StringBuilder()
    for (char in chars) {
        val num = char - '0'
        while (curr < num) {
           sb.append("(")
            curr++
        }
        while(curr > num) {
            sb.append(")")
            curr--
        }
        sb.append(char)
    }
    // add remaining closing braces at the end
    while(curr>0){
        sb.append(")")
        curr--
    }
    return sb.toString()
}
