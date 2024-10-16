package programs.strings

/**
 * Given a string, find the first non-repeating character in it.
 * For example, if the input string is “GeeksforGeeks”,
 * then output should be ‘f’
 * and if input string is “GeeksQuiz”,then output should be ‘G’.
 */
fun main() {
    val str = "GeeksforGeeks"
    val cache = IntArray(26)
    for (element in str) {
        val value = Character.toLowerCase(element)
        cache[value.toInt() - 'a'.toInt()]++
    }
    for (i in str.indices) {
        val value = Character.toLowerCase(str[i])
        if (cache[value.toInt() - 'a'.toInt()] == 1) {
            println(str[i])
            break
        }
    }
}
