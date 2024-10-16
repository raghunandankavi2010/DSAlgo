package programs.strings

import java.util.*

object ReverseString {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = "madem"
        val chars = s.toCharArray()
        var start = 0
        var end = s.length - 1
        while (start < end) {
            chars[start] = (chars[start].toInt() xor chars[end].toInt()).toChar()
            chars[end] = (chars[end].toInt() xor chars[start].toInt()).toChar()
            chars[start] = (chars[start].toInt() xor chars[end].toInt()).toChar()
            ++start
            --end
        }
        val result = Arrays.toString(chars)
        println(result)
        println()
        if (checkPalindrome(s)) {
            println(String.format("Given String %s is a Palindrome", s))
        } else {
            println(String.format("Given String %s is not a Palindrome", s))
        }
        if (isPalindrome(s)) {
            println(String.format("Given String %s is a Palindrome", s))
        } else {
            println(String.format("Given String %s is not a Palindrome", s))
        }
    }

    private fun isPalindrome(s: String): Boolean {   // if length is 0 or 1 then String is palindrome
        if (s.length == 0 || s.length == 1) return true
        return if (s[0] == s[s.length - 1]) isPalindrome(s.substring(1, s.length - 1)) else false
    }

    // This method check if a given String is palindrome or not using recursion
    private fun checkPalindrome(input: String?): Boolean {
        if (input == null) {
            return false
        }
        val reversed = reverse(input)
        println()
        println("Reversed String: $reversed")
        println()
        return input == reversed
    }

    private fun reverse(str: String?): String? {
        if (str == null) {
            return null
        }
        return if (str.length <= 1) {
            str
        } else reverse(str.substring(1)) + str[0]
    }
}