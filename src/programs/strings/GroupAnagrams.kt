/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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


    println("${map.values.toList()}")
}