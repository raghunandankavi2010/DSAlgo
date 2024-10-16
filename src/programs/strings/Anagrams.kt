package programs.strings


import java.lang.StringBuilder
import java.util.stream.IntStream

/**
 * Anagram -
 * Given String1 and String2
 * If String2 can be formed by re-arranging chars of String1
 * its a anagram else not a anagram
 */

fun main() {
    val s1 = "abcf"
    val s2 = "cabfe"
    //anagram(s1, s2)
    //println()
    println(anagram3(s1,s2))
}

private fun anagram3(s1: String, s2: String): Boolean {
    val visited = Array(26) { 0 }

    s1.forEach {
        visited[it - 'a'] += 1
    }

    s2.forEach {
        visited[it - 'a'] -= 1
    }

    var isAnagram = true
    for (element in visited) {
        if (element != 0) {
            isAnagram = false
            break
        }
    }
    return isAnagram
}

private fun anagram(s1: String, s2: String) {
    val sb = StringBuilder(s2)
    val s = s1.toCharArray()
    // go through each element is one string
    // find the index of the element in another string
    // remove it
    // if string is empty that means its a anagram
    for (ch in s) {
        val index = sb.indexOf("" + ch)
        if (index != -1) {
            sb.deleteCharAt(index)
        }
    }
    if (sb.isEmpty()) {
        println("Anagram")
    } else {
        println("Not an Anagram")
    }
}

private fun anagram2(s1: String, s2: String) {
    val sb1 = StringBuilder(s1)
    val sb2 = StringBuilder(s2)
    for (i in 0 until sb1.length) {
        val index = sb2.indexOf("" + sb1[i])
        if (index != -1) {
            sb1.deleteCharAt(index)
            sb2.deleteCharAt(index)
        }
    }
    var count = 0
    for (i in 0 until sb1.length + sb2.length) {
        count++
    }
    println("Count $count")
}

private fun numberNeeded(first: String, second: String) {
    val lettercounts = IntArray(26)
    for (c in first.toCharArray()) {
        lettercounts[c - 'a']++
    }
    for (c in second.toCharArray()) {
        lettercounts[c - 'a']--
    }
    var result = 0
    for (i in lettercounts) {
        result += Math.abs(i)
    }
    println("Count $result")
}

private fun numberNeeded2(one: String, two: String) {
    val letters = IntArray(26)
    one.chars().forEach { c: Int -> letters[c - 'a'.toInt()]++ }
    two.chars().forEach { c: Int -> letters[c - 'a'.toInt()]-- }
    println("Count " + IntStream.of(*letters).map { a: Int -> Math.abs(a) }.sum())
}
