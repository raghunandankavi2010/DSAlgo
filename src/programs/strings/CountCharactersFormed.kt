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

fun main() {

    val words = arrayOf("cat", "bt", "hat", "tree")
    val chars = "atach"
    val count = countCharacters(words, chars)
    println(count)
}

fun countCharacters(words: Array<String>, chars: String): Int {

    val map = HashMap<Char, Int>()

    // put all chars in a map
    chars.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    // Iterate through the words
    var result = 0
    words.forEach { word ->
        val countMap = HashMap<Char, Int>()
        var i = 0
        while (i <= word.length - 1) {
            val char = word[i]
            // check if char is found in map else cannot make word with char
            if (!map.containsKey(char))
                break
            else{
                // if char count is also more than what exists in map then also you can't make same words given
                if (countMap.getOrDefault(char,0)+1 > map[char]!!)
                    break
                // else just add it to map
                countMap[char] = countMap.getOrDefault(char, 0)+1
            }
            i++
        }
        // if you have scanned the entire word adding it to countMap
        // then the word can be formed
        if (i == word.length)
            result += word.length
    }
    return result
}