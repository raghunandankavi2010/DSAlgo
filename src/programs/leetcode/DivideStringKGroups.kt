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

package programs.leetcode

class Solution {

    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < s.length) {
            val end = (i + k).coerceAtMost(s.length)
            val chunk = s.substring(i, end).padEnd(k, fill)
            result.add(chunk)
            i += k
        }
        return result.toTypedArray()
    }
}

fun main() {
    val s = "abcdefghi"
    val k = 3
    val fill = 'x'

    val solution = Solution()
    solution.divideString(s, k, fill).forEach {
        print(it)
    }
}