package programs.strings

/** Leet code
 * 438. Find All Anagrams in a String

   Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
 */
fun main() {
    val big = "babba"
    val small = "ab"
    findAnagrams(big, small)
}

// Accepted solution using sliding window technique
fun findAnagrams(big: String, small: String) {

    val map = HashMap<Char, Int>()
    var res = 0

    val wSize = small.length
    small.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    val map2 = HashMap<Char, Int>()


    for (i in big.indices) {
        if (i < wSize) {
            if(!map2.containsKey(big[i])) {
                map2[big[i]] = 1
            } else {
                val pCount = map2.getOrDefault(big[i],1) + 1
                map2[big[i]] = pCount
            }
        } else {

            if (map == map2) {
                res++
                println("Anagrams found are '${big.substring(i-wSize,i)}' at index ${i-wSize}")
            }
            val charAtBeginWindow = big[i - wSize ]
            val countCharAtBeginWindow = map2.getOrDefault(charAtBeginWindow, 0)
            if (countCharAtBeginWindow > 1) {
                map2[charAtBeginWindow] = (countCharAtBeginWindow -1)
            } else {
                map2.remove(charAtBeginWindow)
            }
            if(!map2.containsKey(big[i])) {
                map2[big[i]] = 1
            } else {
                val pCount = map2.getOrDefault(big[i],1) + 1
                map2[big[i]] = pCount
            }

        }
    }
    // the last wSize
    if (map == map2) {
        res++
        println("Anagrams found are '${big.substring(big.length-wSize,big.length)}' at index ${big.length-wSize}")
    }

    println(res)
}
