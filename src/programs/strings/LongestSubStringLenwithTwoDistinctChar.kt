package programs.strings

import kotlin.math.max

/**
 * Given a string s, find the length of the longest substring t that contains at most 2 distinct characters.
Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

 */

fun main() {
    val input = "eceba"
    val map = HashMap<Char, Int>()

    var start = 0
    var end = 0
    var maxLen = 0

    while (end < input.length) {
        map[input[end]] = end
        if (map.size > 2) {
            val minIndex = map.values.minOrNull()
            if (minIndex != null) {
                start = minIndex + 1
                map.remove(input[minIndex])
            }
        }
        maxLen = max(maxLen, end - start + 1)
        end++
    }

    println(maxLen)

}