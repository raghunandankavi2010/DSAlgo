package programs.strings

import kotlin.jvm.JvmStatic
import programs.strings.ReverseWordsInString
import java.lang.StringBuilder
import java.util.*

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/submissions/
 */
class ReverseWordsInString {
//    private fun reverseWords(s: String) {
//        val arr = s.toCharArray()
//        var i = 0
//        var j = arr.size - 1
//        while (i < j) {
//            // if it is not space then swap char at i and j
//            // increment i and decrement j
//            if (arr[i] != ' ' && arr[j] != ' ') {
//                arr[i] = arr[i] xor arr[j]
//                arr[j] = arr[j] xor arr[i]
//                arr[i] = arr[i] xor arr[j]
//                i++
//                j--
//            } else if (arr[i] == ' ') { // space just increment i
//                i++
//            } else if (arr[j] == ' ') { // space just decrement j
//                j--
//            }
//        }
//        println(String(arr))
//    }

    private fun reverseWordsInString(input: String): String {
        val s = input.toCharArray()
        var start = 0
        for (end in s.indices) {
            if (s[end] == ' ') {
                reverse(s, start, end)
                start = end + 1
            }
        }
        reverse(s, start, s.size - 1)
        reverse(s, 0, s.size - 1)
        return Arrays.toString(s)
    }

    private fun reverse(str: CharArray, start: Int, end: Int) {
        // Temporary variable
        // to store character
        var start = start
        var end = end
        var temp: Char
        while (start <= end) {
            // Swapping the first
            // and last character
            temp = str[start]
            str[start] = str[end]
            str[end] = temp
            start++
            end--
        }
    }

    private fun reverse(s: String) {
        var s = s
        s = s.replace("\\s+".toRegex(), " ").trim { it <= ' ' }
        val strgs = s.split("\\s".toRegex()).toTypedArray()
        val n = strgs.size - 1
        val sb = StringBuilder()
        var i = n
        while (i >= 0) {
            if (i == 0) {
                sb.append(strgs[i])
            } else {
                sb.append(strgs[i]).append(" ")
            }
            i--
        }
        println("Reversed String : $sb")
    }

    private fun reverseIndividualWords(input: String) {
        val stack = Stack<Char>()

        input.forEach {
            if(it != ' '){
                stack.push(it)
            } else{
                while(!stack.isEmpty()){
                    print(stack.pop())
                }
                print(" ")
            }
        }
        while(!stack.isEmpty()){
            print(stack.pop())
        }

    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val reverseWordsInString = ReverseWordsInString()
            val s = " Hello World! "
            //reverseWordsInString.reverse(s)
            // philips test.
            val s2 = "I am working at Manyata"
            //reverseWordsInString.reverseWords(s2)
            reverseWordsInString.reverseIndividualWords(s2)

        }
    }

}

infix fun String.xor(that: String) = mapIndexed { index, c ->
    that[index].toInt().xor(c.toInt())
}.joinToString(separator = "") {
    it.toChar().toString()
}