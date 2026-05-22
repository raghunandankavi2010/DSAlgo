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

import java.util.HashMap
import kotlin.math.max

/**
 *
 * @param input string
 * @return output longest length substring without repeating chars
 * https://www.baeldung.com/java-longest-substring-without-repeated-characters
 */

fun main() {

    ///println(getUniqueCharacterSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("tmmzuxt"))
}

private fun getUniqueCharacterSubstring(input: String): String {
    val visited: MutableMap<Char, Int> = HashMap()
    var output = ""
    var start = 0
    var end = 0
    var finalLength = 0
    while (end < input.length) {
        val currChar = input[end]
        if (visited.containsKey(currChar)) {
            start = max(visited.getOrDefault(currChar, 0) + 1, start)
        }
        if (output.length < end - start + 1) {
            output = input.substring(start, end + 1)
            output = output.trim { it <= ' ' } // remove spaces
        }
        if (finalLength < (end - start + 1)) {
            finalLength = end - start + 1
        }
        visited[currChar] = end
        end++
    }
    println(finalLength)

    return output
}

fun lengthOfLongestSubstring(s: String): Int {
    val map = mutableMapOf<Char, Int>()
    var start = 0
    var end = 0
    var finalLength = 0
    while (end < s.length) {
        if (map.containsKey(s[end])) {
            start = max(map.getOrDefault(s[end], 0) + 1, start)
        }
        if (finalLength < (end - start + 1)) {
            finalLength = end - start + 1
        }
        map[s[end]] = end

        end++

    }
    return finalLength
}