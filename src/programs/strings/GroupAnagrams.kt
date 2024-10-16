package programs.strings

import java.util.*
import kotlin.collections.HashMap

/**
 * Leet code 49
 * Group anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Example 1:
 *  Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

fun main() {

    val array = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

    val map = HashMap<String, List<String>>()

    array.forEach { it ->

        val arr = it.toCharArray()
        val value = arr.sorted().joinToString("")

        if (!map.containsKey(value)) {
            val list = ArrayList<String>()
            list.add(it)
            map[value] = list
        } else {
            val list = map.getOrDefault(value, ArrayList<String>()) as ArrayList<String>
            list.add(it)
            map[value] = list

        }
    }

    println("$map")
}