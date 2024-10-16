package programs.leetcode

import kotlin.math.max

/**
 * https://www.youtube.com/watch?v=o17MBWparrI&t=554s
 */
fun main() {

    val s = "eleetminicoworoep"
    println(findTheLongestSubstring(s))

}

private fun findTheLongestSubstring(s: String): Int {

    // represent a e i o u in with bits
    // left shift multiply by 2
    val map = hashMapOf(
        'a' to  (1 shl 0), //1
        'e' to  (1 shl 1), //2
        'i' to  (1 shl 2), //4
        'o' to  (1 shl 3), //8
         'u' to  (1 shl 4), //16
    )

    var state = 0
    // we have int range as 32 bit
    // we can represent all english chars 26 within this
    val range = IntArray(32) { -1 } // initially set to  -1
    var longestSubStr = 0

    for (i in s.indices) {
        if(map.contains(s[i])) { // if char in map
            state = state xor map[s[i]]!! // change the state from 0 to -1 and -1 to 0

            // lets say at index i 0 is e
            // e is there is map
            // change state from -1 to 0
            // state is 2 ragne[state] was -1
            // update index
            if (range[state] == -1 && state != 0) {
                range[state] = i
            }
        }
        longestSubStr = max(longestSubStr,i-range[state])
    }

    return longestSubStr
}