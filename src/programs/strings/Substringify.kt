package programs.strings

import kotlin.math.min

/**
 *  Created by Raghunandan Kavi 14 Spet 2022
 *  Given two lowercase alphabet strings s and t, return the minimum amount of operations on s required to make t a substring of s. In each operation, you can choose any position in s and change the character at that position to any other character.

Constraints

0 ≤ m ≤ n ≤ 100 where n is the length of s and m is the length of t
Example 1
Input
s = "foobar"
t = "oops"
Output
2
Explanation
We can take the substring "ooba" and change 'b' to 'p' and 'a' to 's'.
 */
fun main() {

    val s ="foobar"
    val t ="oops"
    println(solve(s,t))
}

private fun solve(s: String, t: String): Int {
    var min = t.length
    var i = 0
    while (i < s.length) {
        val start = i
        val end = i + t.length
        if (end <= s.length) {
            min = min(min, distance(s.substring(start, end), t))
        }
        i++
    }
    return min
}

private fun distance(s1: String, s2: String): Int {
    var count = 0
    for (j in s2.indices) {
        if (s1[j] != s2[j]) {
            count++
        }
    }
    return count
}