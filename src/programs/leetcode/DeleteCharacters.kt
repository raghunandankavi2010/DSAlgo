package programs.leetcode

/**
 * 1957. Delete Characters to Make Fancy String
 * Easy
 * Topics
 * Companies
 * Hint
 * A fancy string is a string where no three consecutive characters are equal.
 *
 * Given a string s, delete the minimum possible number of characters from s to make it fancy.
 *
 * Return the final string after the deletion. It can be shown that the answer will always be unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leeetcode"
 * Output: "leetcode"
 * Explanation:
 * Remove an 'e' from the first group of 'e's to create "leetcode".
 * No three consecutive characters are equal, so return "leetcode".
 * Example 2:
 *
 * Input: s = "aaabaaaa"
 * Output: "aabaa"
 * Explanation:
 * Remove an 'a' from the first group of 'a's to create "aabaaaa".
 * Remove two 'a's from the second group of 'a's to create "aabaa".
 * No three consecutive characters are equal, so return "aabaa".
 * Example 3:
 *
 * Input: s = "aab"
 * Output: "aab"
 * Explanation: No three consecutive characters are equal, so return "aab".
 *
 */
fun main() {
    val output = makeFancyString("aaabaaaa")
    println(output)
}

private fun makeFancyString(s: String): String {
    if(s.isEmpty()) return ""
    val sb = StringBuilder()
    var currChar = s[0]
    var count = 1
    sb.append(currChar)
    for(i in 1..<s.length) {
       if(s[i] == currChar) {
           count++
       } else {
           count = 1
           currChar = s[i]
       }
        if(count <= 2) {
            sb.append(s[i])
        }
    }

    return sb.toString()
}