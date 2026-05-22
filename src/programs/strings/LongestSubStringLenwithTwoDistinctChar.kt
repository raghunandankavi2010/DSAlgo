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